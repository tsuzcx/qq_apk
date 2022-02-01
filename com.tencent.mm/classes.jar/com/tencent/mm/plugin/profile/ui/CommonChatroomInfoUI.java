package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;

public class CommonChatroomInfoUI
  extends MMBaseSelectContactUI
{
  private b MVn;
  private c MVo;
  private au contact;
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(305514);
    paramAdapterView = (g)getContentLV().getAdapter().getItem(paramInt);
    if (paramAdapterView != null)
    {
      if (((au.bwO(paramAdapterView.contact.field_username)) || (au.bwP(paramAdapterView.contact.field_username))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(305514);
        return;
      }
      com.tencent.mm.br.c.g(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", paramAdapterView.contact.field_username).putExtra("finish_direct", true));
    }
    AppMethodBeat.o(305514);
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(26944);
    super.aNi();
    String str = getIntent().getStringExtra("Select_Talker_Name");
    bh.bCz();
    this.contact = com.tencent.mm.model.c.bzA().JE(str);
    AppMethodBeat.o(26944);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(26947);
    if (this.MVn == null) {
      this.MVn = new b(this, this.scene, this.contact);
    }
    b localb = this.MVn;
    AppMethodBeat.o(26947);
    return localb;
  }
  
  public final p bVB()
  {
    AppMethodBeat.i(26948);
    if (this.MVo == null) {
      this.MVo = new c(this, this.scene, this.contact);
    }
    c localc = this.MVo;
    AppMethodBeat.o(26948);
    return localc;
  }
  
  public final boolean bVx()
  {
    return true;
  }
  
  public final boolean bVy()
  {
    return false;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(26946);
    if (this.contact.sex == 1)
    {
      str = getString(R.l.gBh);
      AppMethodBeat.o(26946);
      return str;
    }
    if (this.contact.sex == 2)
    {
      str = getString(R.l.gBg);
      AppMethodBeat.o(26946);
      return str;
    }
    String str = getString(R.l.gBj);
    AppMethodBeat.o(26946);
    return str;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26945);
    super.initView();
    b localb = this.MVn;
    l locall = new l();
    locall.query = localb.contact.field_username;
    locall.HtC = localb;
    locall.handler = localb.handler;
    locall.qRb = 6;
    locall.HtB = new b.a((byte)0);
    ((n)h.az(n.class)).search(2, locall);
    AppMethodBeat.o(26945);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.CommonChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */
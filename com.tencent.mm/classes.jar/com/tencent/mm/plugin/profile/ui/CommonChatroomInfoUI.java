package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;

public class CommonChatroomInfoUI
  extends MMBaseSelectContactUI
{
  private a Bdr;
  private b Bds;
  private as contact;
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(231829);
    f localf = (f)getContentLV().getAdapter().getItem(paramInt);
    if (localf != null)
    {
      if (((as.bjp(localf.contact.field_username)) || (as.bjq(localf.contact.field_username))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(231829);
        return;
      }
      com.tencent.mm.br.c.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", localf.contact.field_username).putExtra("finish_direct", true));
    }
    AppMethodBeat.o(231829);
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(26944);
    super.amZ();
    String str = getIntent().getStringExtra("Select_Talker_Name");
    bg.aVF();
    this.contact = com.tencent.mm.model.c.aSN().Kn(str);
    AppMethodBeat.o(26944);
  }
  
  public final boolean bmA()
  {
    return false;
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(26946);
    if (this.contact.fuA == 1)
    {
      str = getString(2131757862);
      AppMethodBeat.o(26946);
      return str;
    }
    if (this.contact.fuA == 2)
    {
      str = getString(2131757861);
      AppMethodBeat.o(26946);
      return str;
    }
    String str = getString(2131757866);
    AppMethodBeat.o(26946);
    return str;
  }
  
  public final q bmC()
  {
    AppMethodBeat.i(26947);
    if (this.Bdr == null) {
      this.Bdr = new a(this, this.scene, this.contact);
    }
    a locala = this.Bdr;
    AppMethodBeat.o(26947);
    return locala;
  }
  
  public final o bmD()
  {
    AppMethodBeat.i(26948);
    if (this.Bds == null) {
      this.Bds = new b(this, this.scene, this.contact);
    }
    b localb = this.Bds;
    AppMethodBeat.o(26948);
    return localb;
  }
  
  public final boolean bmz()
  {
    return true;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26945);
    super.initView();
    a locala = this.Bdr;
    j localj = new j();
    localj.query = locala.contact.field_username;
    localj.wWZ = locala;
    localj.handler = locala.handler;
    localj.kXb = 6;
    localj.wWY = new a.a((byte)0);
    ((n)g.ah(n.class)).search(2, localj);
    AppMethodBeat.o(26945);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.CommonChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */
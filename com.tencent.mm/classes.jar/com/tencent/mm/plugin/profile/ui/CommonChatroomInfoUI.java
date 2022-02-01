package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;

public class CommonChatroomInfoUI
  extends MMBaseSelectContactUI
{
  private a GXq;
  private b GXr;
  private as contact;
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(278372);
    g localg = (g)getContentLV().getAdapter().getItem(paramInt);
    if (localg != null)
    {
      if (((as.bvK(localg.contact.field_username)) || (as.bvL(localg.contact.field_username))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(278372);
        return;
      }
      com.tencent.mm.by.c.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", localg.contact.field_username).putExtra("finish_direct", true));
    }
    AppMethodBeat.o(278372);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(26944);
    super.ata();
    String str = getIntent().getStringExtra("Select_Talker_Name");
    bh.beI();
    this.contact = com.tencent.mm.model.c.bbL().RG(str);
    AppMethodBeat.o(26944);
  }
  
  public final boolean bwH()
  {
    return true;
  }
  
  public final boolean bwI()
  {
    return false;
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(26946);
    if (this.contact.sex == 1)
    {
      str = getString(R.l.eyp);
      AppMethodBeat.o(26946);
      return str;
    }
    if (this.contact.sex == 2)
    {
      str = getString(R.l.eyo);
      AppMethodBeat.o(26946);
      return str;
    }
    String str = getString(R.l.eyr);
    AppMethodBeat.o(26946);
    return str;
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(26947);
    if (this.GXq == null) {
      this.GXq = new a(this, this.scene, this.contact);
    }
    a locala = this.GXq;
    AppMethodBeat.o(26947);
    return locala;
  }
  
  public final p bwL()
  {
    AppMethodBeat.i(26948);
    if (this.GXr == null) {
      this.GXr = new b(this, this.scene, this.contact);
    }
    b localb = this.GXr;
    AppMethodBeat.o(26948);
    return localb;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26945);
    super.initView();
    a locala = this.GXq;
    j localj = new j();
    localj.query = locala.contact.field_username;
    localj.BIU = locala;
    localj.handler = locala.handler;
    localj.nRn = 6;
    localj.BIT = new a.a((byte)0);
    ((n)h.ag(n.class)).search(2, localj);
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
package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.p;

public class CommonChatroomInfoUI
  extends MMBaseSelectContactUI
{
  private ad contact;
  private a pyk;
  private b pyl;
  
  public final void Kc()
  {
    AppMethodBeat.i(23324);
    super.Kc();
    String str = getIntent().getStringExtra("Select_Talker_Name");
    aw.aaz();
    this.contact = c.YA().arw(str);
    AppMethodBeat.o(23324);
  }
  
  public final boolean apa()
  {
    return true;
  }
  
  public final boolean apb()
  {
    return false;
  }
  
  public final String apc()
  {
    AppMethodBeat.i(23326);
    if (this.contact.dqC == 1)
    {
      str = getString(2131298575);
      AppMethodBeat.o(23326);
      return str;
    }
    if (this.contact.dqC == 2)
    {
      str = getString(2131298574);
      AppMethodBeat.o(23326);
      return str;
    }
    String str = getString(2131298579);
    AppMethodBeat.o(23326);
    return str;
  }
  
  public final p apd()
  {
    AppMethodBeat.i(23327);
    if (this.pyk == null) {
      this.pyk = new a(this, this.scene, this.contact);
    }
    a locala = this.pyk;
    AppMethodBeat.o(23327);
    return locala;
  }
  
  public final com.tencent.mm.ui.contact.n ape()
  {
    AppMethodBeat.i(23328);
    if (this.pyl == null) {
      this.pyl = new b(this, this.scene, this.contact);
    }
    b localb = this.pyl;
    AppMethodBeat.o(23328);
    return localb;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23325);
    super.initView();
    a locala = this.pyk;
    i locali = new i();
    locali.query = locala.contact.field_username;
    locali.mSU = locala;
    locali.handler = locala.handler;
    locali.hdl = 6;
    locali.mST = new a.a((byte)0);
    ((com.tencent.mm.plugin.fts.a.n)g.G(com.tencent.mm.plugin.fts.a.n.class)).search(2, locali);
    AppMethodBeat.o(23325);
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(23329);
    f localf = (f)getContentLV().getAdapter().getItem(paramInt);
    if (localf != null) {
      d.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", localf.contact.field_username).putExtra("finish_direct", true));
    }
    AppMethodBeat.o(23329);
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
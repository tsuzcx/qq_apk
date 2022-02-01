package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;

public class CommonChatroomInfoUI
  extends MMBaseSelectContactUI
{
  private am contact;
  private a wPU;
  private b wPV;
  
  public final void Zd()
  {
    AppMethodBeat.i(26944);
    super.Zd();
    String str = getIntent().getStringExtra("Select_Talker_Name");
    ba.aBQ();
    this.contact = c.azp().Bf(str);
    AppMethodBeat.o(26944);
  }
  
  public final boolean aRu()
  {
    return true;
  }
  
  public final boolean aRv()
  {
    return false;
  }
  
  public final String aRw()
  {
    AppMethodBeat.i(26946);
    if (this.contact.ePk == 1)
    {
      str = getString(2131757634);
      AppMethodBeat.o(26946);
      return str;
    }
    if (this.contact.ePk == 2)
    {
      str = getString(2131757633);
      AppMethodBeat.o(26946);
      return str;
    }
    String str = getString(2131757638);
    AppMethodBeat.o(26946);
    return str;
  }
  
  public final q aRx()
  {
    AppMethodBeat.i(26947);
    if (this.wPU == null) {
      this.wPU = new a(this, this.scene, this.contact);
    }
    a locala = this.wPU;
    AppMethodBeat.o(26947);
    return locala;
  }
  
  public final o aRy()
  {
    AppMethodBeat.i(26948);
    if (this.wPV == null) {
      this.wPV = new b(this, this.scene, this.contact);
    }
    b localb = this.wPV;
    AppMethodBeat.o(26948);
    return localb;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26945);
    super.initView();
    a locala = this.wPU;
    j localj = new j();
    localj.query = locala.contact.field_username;
    localj.tvj = locala;
    localj.handler = locala.handler;
    localj.jQN = 6;
    localj.tvi = new a.a((byte)0);
    ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(26945);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(26949);
    f localf = (f)getContentLV().getAdapter().getItem(paramInt);
    if (localf != null) {
      d.f(this, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", localf.contact.field_username).putExtra("finish_direct", true));
    }
    AppMethodBeat.o(26949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.CommonChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */
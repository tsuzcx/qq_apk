package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;

public class CommonChatroomInfoUI
  extends MMBaseSelectContactUI
{
  private an contact;
  private a xfL;
  private b xfM;
  
  public final void Zm()
  {
    AppMethodBeat.i(26944);
    super.Zm();
    String str = getIntent().getStringExtra("Select_Talker_Name");
    bc.aCg();
    this.contact = c.azF().BH(str);
    AppMethodBeat.o(26944);
  }
  
  public final boolean aRT()
  {
    return true;
  }
  
  public final boolean aRU()
  {
    return false;
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(26946);
    if (this.contact.eQV == 1)
    {
      str = getString(2131757634);
      AppMethodBeat.o(26946);
      return str;
    }
    if (this.contact.eQV == 2)
    {
      str = getString(2131757633);
      AppMethodBeat.o(26946);
      return str;
    }
    String str = getString(2131757638);
    AppMethodBeat.o(26946);
    return str;
  }
  
  public final q aRW()
  {
    AppMethodBeat.i(26947);
    if (this.xfL == null) {
      this.xfL = new a(this, this.scene, this.contact);
    }
    a locala = this.xfL;
    AppMethodBeat.o(26947);
    return locala;
  }
  
  public final o aRX()
  {
    AppMethodBeat.i(26948);
    if (this.xfM == null) {
      this.xfM = new b(this, this.scene, this.contact);
    }
    b localb = this.xfM;
    AppMethodBeat.o(26948);
    return localb;
  }
  
  public void initView()
  {
    AppMethodBeat.i(26945);
    super.initView();
    a locala = this.xfL;
    j localj = new j();
    localj.query = locala.contact.field_username;
    localj.tGa = locala;
    localj.handler = locala.handler;
    localj.jUf = 6;
    localj.tFZ = new a.a((byte)0);
    ((n)g.ad(n.class)).search(2, localj);
    AppMethodBeat.o(26945);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
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
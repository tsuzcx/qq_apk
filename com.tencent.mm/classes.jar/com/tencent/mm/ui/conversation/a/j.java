package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;

public final class j
  extends b
{
  private c FJE;
  View HgU;
  int evt;
  
  public j(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38794);
    this.HgU = View.inflate(paramContext, 2131494488, null);
    if (this.HgU == null)
    {
      AppMethodBeat.o(38794);
      return;
    }
    this.evt = bt.getInt(g.Zd().getValue("InviteFriendsControlFlags"), 0);
    this.HgU.setVisibility(8);
    this.HgU.setPadding(0, -com.tencent.mm.cd.a.fromDPToPix(paramContext, 2131165515), 0, 0);
    if ((this.evt & 0x1) > 0)
    {
      this.HgU.setVisibility(0);
      this.HgU.setPadding(0, 0, 0, 0);
    }
    this.HgU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38791);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Invite_friends", 1);
        d.b(paramContext, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", paramAnonymousView);
        h.vKh.f(14034, new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(38791);
      }
    });
    this.FJE = new c() {};
    AppMethodBeat.o(38794);
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(38795);
    com.tencent.mm.sdk.b.a.ESL.c(this.FJE);
    if ((this.HgU != null) && (this.HgU.getVisibility() == 0))
    {
      AppMethodBeat.o(38795);
      return true;
    }
    AppMethodBeat.o(38795);
    return false;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final View getView()
  {
    return this.HgU;
  }
  
  public final void release()
  {
    AppMethodBeat.i(38796);
    com.tencent.mm.sdk.b.a.ESL.d(this.FJE);
    AppMethodBeat.o(38796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.j
 * JD-Core Version:    0.7.0.1
 */
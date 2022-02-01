package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.n.e;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bu;

public final class j
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private c JqM;
  View KUP;
  int eQZ;
  
  public j(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38794);
    this.KUP = View.inflate(paramContext, 2131494488, null);
    if (this.KUP == null)
    {
      AppMethodBeat.o(38794);
      return;
    }
    this.eQZ = bu.getInt(com.tencent.mm.n.g.acL().getValue("InviteFriendsControlFlags"), 0);
    this.KUP.setVisibility(8);
    this.KUP.setPadding(0, -com.tencent.mm.cb.a.fromDPToPix(paramContext, 2131165515), 0, 0);
    if ((this.eQZ & 0x1) > 0)
    {
      this.KUP.setVisibility(0);
      this.KUP.setPadding(0, 0, 0, 0);
    }
    this.KUP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/InviteFriendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Invite_friends", 1);
        d.b(paramContext, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", paramAnonymousView);
        com.tencent.mm.plugin.report.service.g.yxI.f(14034, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/InviteFriendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(38791);
      }
    });
    this.JqM = new c() {};
    AppMethodBeat.o(38794);
  }
  
  public final boolean bAV()
  {
    AppMethodBeat.i(38795);
    com.tencent.mm.sdk.b.a.IvT.c(this.JqM);
    if ((this.KUP != null) && (this.KUP.getVisibility() == 0))
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
    return this.KUP;
  }
  
  public final void release()
  {
    AppMethodBeat.i(38796);
    com.tencent.mm.sdk.b.a.IvT.d(this.JqM);
    AppMethodBeat.o(38796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.j
 * JD-Core Version:    0.7.0.1
 */
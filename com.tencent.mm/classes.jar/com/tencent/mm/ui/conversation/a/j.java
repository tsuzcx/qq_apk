package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.df;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private IListener OAS;
  View Qif;
  int showFlag;
  
  public j(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38794);
    this.Qif = View.inflate(paramContext, 2131495080, null);
    if (this.Qif == null)
    {
      AppMethodBeat.o(38794);
      return;
    }
    this.showFlag = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("InviteFriendsControlFlags"), 0);
    this.Qif.setVisibility(8);
    this.Qif.setPadding(0, -com.tencent.mm.cb.a.fromDPToPix(paramContext, 2131165533), 0, 0);
    if ((this.showFlag & 0x1) > 0)
    {
      this.Qif.setVisibility(0);
      this.Qif.setPadding(0, 0, 0, 0);
    }
    this.Qif.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/banner/InviteFriendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Invite_friends", 1);
        c.b(paramContext, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", paramAnonymousView);
        com.tencent.mm.plugin.report.service.h.CyF.a(14034, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/InviteFriendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(38791);
      }
    });
    this.OAS = new IListener() {};
    AppMethodBeat.o(38794);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(38795);
    EventCenter.instance.addListener(this.OAS);
    if ((this.Qif != null) && (this.Qif.getVisibility() == 0))
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
    return this.Qif;
  }
  
  public final void release()
  {
    AppMethodBeat.i(38796);
    EventCenter.instance.removeListener(this.OAS);
    AppMethodBeat.o(38796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.j
 * JD-Core Version:    0.7.0.1
 */
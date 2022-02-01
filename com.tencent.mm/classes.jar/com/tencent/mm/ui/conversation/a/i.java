package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.i;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private IListener VUg;
  View XFl;
  int showFlag;
  
  public i(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38794);
    this.XFl = View.inflate(paramContext, R.i.ehE, null);
    if (this.XFl == null)
    {
      AppMethodBeat.o(38794);
      return;
    }
    this.showFlag = Util.getInt(com.tencent.mm.n.h.axc().getValue("InviteFriendsControlFlags"), 0);
    this.XFl.setVisibility(8);
    this.XFl.setPadding(0, -com.tencent.mm.ci.a.fromDPToPix(paramContext, R.f.NormalListHeight), 0, 0);
    if ((this.showFlag & 0x1) > 0)
    {
      this.XFl.setVisibility(0);
      this.XFl.setPadding(0, 0, 0, 0);
    }
    this.XFl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/InviteFriendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Invite_friends", 1);
        c.b(paramContext, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", paramAnonymousView);
        com.tencent.mm.plugin.report.service.h.IzE.a(14034, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/InviteFriendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(38791);
      }
    });
    this.VUg = new IListener() {};
    AppMethodBeat.o(38794);
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(38795);
    EventCenter.instance.addListener(this.VUg);
    if ((this.XFl != null) && (this.XFl.getVisibility() == 0))
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
    return this.XFl;
  }
  
  public final void release()
  {
    AppMethodBeat.i(38796);
    EventCenter.instance.removeListener(this.VUg);
    AppMethodBeat.o(38796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.i
 * JD-Core Version:    0.7.0.1
 */
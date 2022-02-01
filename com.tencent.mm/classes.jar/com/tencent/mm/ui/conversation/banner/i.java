package com.tencent.mm.ui.conversation.banner;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.i;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
  extends com.tencent.mm.pluginsdk.ui.a.b
{
  private IListener adyr;
  View aftj;
  int showFlag;
  
  public i(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38794);
    this.aftj = View.inflate(paramContext, R.i.gkz, null);
    if (this.aftj == null)
    {
      AppMethodBeat.o(38794);
      return;
    }
    this.showFlag = Util.getInt(com.tencent.mm.k.i.aRC().getValue("InviteFriendsControlFlags"), 0);
    this.aftj.setVisibility(8);
    this.aftj.setPadding(0, -com.tencent.mm.cd.a.fromDPToPix(paramContext, R.f.NormalListHeight), 0, 0);
    if ((this.showFlag & 0x1) > 0)
    {
      this.aftj.setVisibility(0);
      this.aftj.setPadding(0, 0, 0, 0);
    }
    this.aftj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/banner/InviteFriendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Invite_friends", 1);
        c.b(paramContext, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", paramAnonymousView);
        h.OAn.b(14034, new Object[] { Integer.valueOf(1) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/banner/InviteFriendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(38791);
      }
    });
    this.adyr = new InviteFriendBanner.2(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(38794);
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(38795);
    this.adyr.alive();
    if ((this.aftj != null) && (this.aftj.getVisibility() == 0))
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
    return this.aftj;
  }
  
  public final void release()
  {
    AppMethodBeat.i(38796);
    this.adyr.dead();
    AppMethodBeat.o(38796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.banner.i
 * JD-Core Version:    0.7.0.1
 */
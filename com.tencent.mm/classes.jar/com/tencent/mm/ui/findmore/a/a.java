package com.tencent.mm.ui.findmore.a;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.FindMoreFriendsUI;
import com.tencent.mm.ui.FinderIconViewTipPreference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/findmore/entry/FinderLiveEntryPreferenceMgr;", "", "context", "Landroid/content/Context;", "findMoreFriendsUI", "Lcom/tencent/mm/ui/FindMoreFriendsUI;", "(Landroid/content/Context;Lcom/tencent/mm/ui/FindMoreFriendsUI;)V", "curObservePreference", "Lcom/tencent/mm/ui/FinderIconViewTipPreference;", "enableFinderLiveEntryAboveLook", "", "finderLiveRedDotObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "lastIsEnableFinderLiveEntryAboveLook", "dismissFinderLiveEntrance", "", "getFinderLiveEntranceKey", "", "handleFinderLiveRedDot", "result", "isEnableFinderLiveEntry", "observeFinderLiveRedDot", "preference", "showFinderLiveEntrance", "startPreloadTargetPage", "isEnableShowFinderLiveEntranceRedDot", "updateFinderLiveEntry", "Companion", "app_release"})
public final class a
{
  public static final a.a XHr;
  public s<h.a> XHo;
  public FinderIconViewTipPreference XHp;
  public final FindMoreFriendsUI XHq;
  public boolean aadj;
  public boolean aadk;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(242608);
    XHr = new a.a((byte)0);
    AppMethodBeat.o(242608);
  }
  
  public a(Context paramContext, FindMoreFriendsUI paramFindMoreFriendsUI)
  {
    AppMethodBeat.i(242607);
    this.context = paramContext;
    this.XHq = paramFindMoreFriendsUI;
    this.aadk = this.aadj;
    AppMethodBeat.o(242607);
  }
  
  private final void iWE()
  {
    AppMethodBeat.i(293005);
    this.XHq.hGo().dz("find_friends_by_finder_live_above_look", true);
    this.XHq.hGo().dz("find_friends_by_finder_live", true);
    AppMethodBeat.o(293005);
  }
  
  public final void GV(boolean paramBoolean)
  {
    AppMethodBeat.i(242605);
    if ((paramBoolean) && (this.XHq.hGn()))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_context_id", com.tencent.mm.ui.report.a.hXJ());
      com.tencent.mm.plugin.finder.nearby.preload.a.zIv.an(localIntent);
    }
    AppMethodBeat.o(242605);
  }
  
  public final boolean eeH()
  {
    AppMethodBeat.i(242603);
    Object localObject = com.tencent.mm.kernel.h.ae(b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    if (((b)localObject).ZM())
    {
      iWE();
      Log.i("FinderLiveEntryPreferenceMgr", "updateFinderLiveEntry return for isTeenMode.");
      AppMethodBeat.o(242603);
      return false;
    }
    if (!this.XHq.Hh(9007199254740992L)) {}
    for (int i = 1; i == 0; i = 0)
    {
      iWE();
      Log.w("FinderLiveEntryPreferenceMgr", "updateFinderLiveEntry return for enableFinderLiveEntry");
      AppMethodBeat.o(242603);
      return false;
    }
    localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (!com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      iWE();
      Log.w("FinderLiveEntryPreferenceMgr", "updateFinderLiveEntry return for isEnableFindLive");
      AppMethodBeat.o(242603);
      return false;
    }
    AppMethodBeat.o(242603);
    return true;
  }
  
  public final void iWD()
  {
    AppMethodBeat.i(293004);
    if (this.aadj)
    {
      this.XHq.hGo().dz("find_friends_by_finder_live_above_look", false);
      this.XHq.hGo().dz("find_friends_by_finder_live", true);
      AppMethodBeat.o(293004);
      return;
    }
    this.XHq.hGo().dz("find_friends_by_finder_live_above_look", true);
    this.XHq.hGo().dz("find_friends_by_finder_live", false);
    AppMethodBeat.o(293004);
  }
  
  public final String iWF()
  {
    if (this.aadj) {
      return "find_friends_by_finder_live_above_look";
    }
    return "find_friends_by_finder_live";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  public static final class c<T>
    implements s<h.a>
  {
    public c(a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.findmore.a.a
 * JD-Core Version:    0.7.0.1
 */
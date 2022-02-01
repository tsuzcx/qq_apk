package com.tencent.mm.ui.findmore.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.extension.reddot.j;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.FindMoreFriendsUI;
import com.tencent.mm.ui.FinderIconViewTipPreference;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.tools.w;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/findmore/entry/NearbyEntryPreferenceMgr;", "", "context", "Landroid/content/Context;", "findMoreFriendsUI", "Lcom/tencent/mm/ui/FindMoreFriendsUI;", "(Landroid/content/Context;Lcom/tencent/mm/ui/FindMoreFriendsUI;)V", "curObservePreference", "Lcom/tencent/mm/ui/FinderIconViewTipPreference;", "lastIsEnableFindLiveState", "", "nearbyEntranceRedDotObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "handleNearbyEntranceLiveRedDot", "", "preference", "result", "info", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "handleNearbyEntranceLocalRedDot", "enableShowNearByEntranceRedDot", "handleNearbyEntranceRedDot", "observeNearbyEntrance", "observeNearbyFriendsRedDot", "enableNearbyFriends", "observeNearbyLiveFriendsRedDot", "startPreloadTargetPage", "isEnableShowFinderLiveEntranceRedDot", "updateNearbyEntry", "updateNearbyEntryV3", "updateNearbyFriendsEntry", "updateNearbyLiveFriendsEntry", "Companion", "app_release"})
public final class b
{
  public static final b.a XHw;
  private FinderIconViewTipPreference XHp;
  private final FindMoreFriendsUI XHq;
  private s<h.a> XHu;
  private boolean XHv;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(279997);
    XHw = new b.a((byte)0);
    AppMethodBeat.o(279997);
  }
  
  public b(Context paramContext, FindMoreFriendsUI paramFindMoreFriendsUI)
  {
    AppMethodBeat.i(279995);
    this.context = paramContext;
    this.XHq = paramFindMoreFriendsUI;
    paramContext = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    this.XHv = com.tencent.mm.plugin.finder.nearby.abtest.a.dLo();
    AppMethodBeat.o(279995);
  }
  
  private final void GV(boolean paramBoolean)
  {
    AppMethodBeat.i(279994);
    if ((paramBoolean) && (this.XHq.hGn()))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_context_id", com.tencent.mm.ui.report.a.hXI());
      com.tencent.mm.plugin.finder.nearby.preload.a.zIv.ao(localIntent);
    }
    AppMethodBeat.o(279994);
  }
  
  private final void a(FinderIconViewTipPreference paramFinderIconViewTipPreference)
  {
    AppMethodBeat.i(279993);
    this.XHp = paramFinderIconViewTipPreference;
    Object localObject;
    if (this.XHu != null)
    {
      localObject = new StringBuilder("observeNearbyEntrance lastIsEnableFindLiveState:").append(this.XHv).append(" isEnableFindLive:");
      com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      Log.w("NearbyEntryPreferenceMgr", com.tencent.mm.plugin.finder.nearby.abtest.a.dLo() + "  preference: " + paramFinderIconViewTipPreference + ' ' + paramFinderIconViewTipPreference.hashCode() + " return for observing.");
      boolean bool = this.XHv;
      paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      if (bool != com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
      {
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
        if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo()) {
          break label159;
        }
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.xuX;
        com.tencent.mm.plugin.finder.extension.reddot.nearby.a.aBC("removeFinderLiveEntranceShowInfo");
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.extension.reddot.h.drk();
        localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        paramFinderIconViewTipPreference.L(com.tencent.mm.plugin.finder.extension.reddot.h.drk().getValue());
      }
      for (;;)
      {
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
        this.XHv = com.tencent.mm.plugin.finder.nearby.abtest.a.dLo();
        AppMethodBeat.o(279993);
        return;
        label159:
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.xuX;
        com.tencent.mm.plugin.finder.extension.reddot.nearby.a.aBB("removeNearbyEntryLiveShowInfo");
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.extension.reddot.h.drj();
        localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        paramFinderIconViewTipPreference.L(com.tencent.mm.plugin.finder.extension.reddot.h.drj().getValue());
      }
    }
    Log.i("NearbyEntryPreferenceMgr", "observeNearbyEntrance preference:" + paramFinderIconViewTipPreference + ' ' + paramFinderIconViewTipPreference.hashCode());
    this.XHu = ((s)new c(this));
    paramFinderIconViewTipPreference = this.XHu;
    if (paramFinderIconViewTipPreference != null)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.drk().a((androidx.lifecycle.l)this.XHq, paramFinderIconViewTipPreference);
    }
    paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
    paramFinderIconViewTipPreference = (h.a)com.tencent.mm.plugin.finder.extension.reddot.h.drk().getValue();
    if (paramFinderIconViewTipPreference != null)
    {
      localObject = this.XHu;
      if (localObject != null) {
        ((s)localObject).onChanged(paramFinderIconViewTipPreference);
      }
    }
    paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    this.XHv = com.tencent.mm.plugin.finder.nearby.abtest.a.dLo();
    AppMethodBeat.o(279993);
  }
  
  private final void a(FinderIconViewTipPreference paramFinderIconViewTipPreference, boolean paramBoolean)
  {
    AppMethodBeat.i(279991);
    Object localObject = d.bqd();
    p.j(localObject, "SubCoreVerify.getLBSVerifyMsgStg()");
    int i = ((by)localObject).cHo();
    if (!paramBoolean) {
      i = 0;
    }
    if (i <= 0)
    {
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      if (((com.tencent.mm.kernel.f)localObject).aHp().getBoolean(ar.a.VBR, true))
      {
        localObject = com.tencent.mm.kernel.h.ag(ak.class);
        p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
        localObject = ((ak)localObject).getRedDotManager();
        p.j(localObject, "MMKernel.plugin(IPluginF…class.java).redDotManager");
        if (((z)localObject).dqJ())
        {
          Log.i("NearbyEntryPreferenceMgr", "updateNearbyLiveFriendsEntry: add nearby new red dot");
          localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
          p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
          ((PluginFinder)localObject).getRedDotManager().xsL.drC();
          localObject = com.tencent.mm.kernel.h.aHG();
          p.j(localObject, "MMKernel.storage()");
          ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.VBR, Boolean.FALSE);
        }
      }
    }
    b(paramFinderIconViewTipPreference, paramBoolean);
    AppMethodBeat.o(279991);
  }
  
  private final void b(FinderIconViewTipPreference paramFinderIconViewTipPreference, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(279992);
    Object localObject = d.bqd();
    p.j(localObject, "SubCoreVerify.getLBSVerifyMsgStg()");
    int i = ((by)localObject).cHo();
    if (!paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      if ((!com.tencent.mm.app.plugin.c.abO()) && (paramBoolean))
      {
        Log.i("NearbyEntryPreferenceMgr", "observeNearbyFriendsRedDot: add footprint red dot");
        localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)localObject).getRedDotManager().xsL.drB();
        localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
        localObject = ((PluginFinder)localObject).getRedDotManager().aBe("NearbyPeopleTab");
        if (localObject != null) {
          j = ((bkn)localObject).count;
        }
        if (i <= 0) {
          break label253;
        }
        Log.i("NearbyEntryPreferenceMgr", "observeNearbyFriendsRedDot: add unread red dot,insideRedDotUnRedCount = " + j + ", unRead = " + i);
        if (i > j)
        {
          localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
          p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
          ((PluginFinder)localObject).getRedDotManager().xsL.Ms(i);
        }
      }
      for (;;)
      {
        a(paramFinderIconViewTipPreference);
        AppMethodBeat.o(279992);
        return;
        Log.i("NearbyEntryPreferenceMgr", "observeNearbyFriendsRedDot: clear footprint red dot");
        localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)localObject).getRedDotManager().Mp(1014);
        break;
        label253:
        Log.i("NearbyEntryPreferenceMgr", "observeNearbyFriendsRedDot: clear unread red dot");
        localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
        p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder)localObject).getRedDotManager().Mp(1013);
      }
    }
  }
  
  private final boolean hWW()
  {
    AppMethodBeat.i(279988);
    int i;
    if (!this.XHq.Hh(70368744177664L))
    {
      i = 1;
      if ((this.XHq.hGp() & 0x200) != 0) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      if (i != 0) {
        break label92;
      }
      this.XHq.hGo().dz("find_friends_by_near_v3", true);
      Log.w("NearbyEntryPreferenceMgr", "updateNearbyEntryV3 return for openNearbyLiveFriends:%s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(279988);
      return false;
      i = 0;
      break;
    }
    label92:
    if (this.XHq.hGn()) {
      com.tencent.mm.ui.report.a.hXE();
    }
    this.XHq.hGo().dz("find_friends_by_near_v3", false);
    Object localObject = this.XHq.hGo().byG("find_friends_by_near_v3");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.FinderIconViewTipPreference");
      AppMethodBeat.o(279988);
      throw ((Throwable)localObject);
    }
    localObject = (FinderIconViewTipPreference)localObject;
    if (localObject == null)
    {
      Log.w("NearbyEntryPreferenceMgr", "updateNearbyEntryV3 find_friends_by_near return for null.");
      AppMethodBeat.o(279988);
      return false;
    }
    b((FinderIconViewTipPreference)localObject, bool);
    Log.i("NearbyEntryPreferenceMgr", "updateNearbyEntryV3");
    AppMethodBeat.o(279988);
    return true;
  }
  
  private final boolean hWX()
  {
    AppMethodBeat.i(279989);
    int i;
    if (!this.XHq.Hh(70368744177664L))
    {
      i = 1;
      if ((this.XHq.hGp() & 0x200) != 0) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      if (i != 0) {
        break label92;
      }
      this.XHq.hGo().dz("find_live_friends_by_near", true);
      Log.w("NearbyEntryPreferenceMgr", "updateNearbyLiveFriendsEntry return for openNearbyLiveFriends:%s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(279989);
      return false;
      i = 0;
      break;
    }
    label92:
    if (this.XHq.hGn()) {
      com.tencent.mm.ui.report.a.hXC();
    }
    this.XHq.hGo().dz("find_live_friends_by_near", false);
    Object localObject = this.XHq.hGo().byG("find_live_friends_by_near");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.FinderIconViewTipPreference");
      AppMethodBeat.o(279989);
      throw ((Throwable)localObject);
    }
    localObject = (FinderIconViewTipPreference)localObject;
    if (localObject == null)
    {
      Log.w("NearbyEntryPreferenceMgr", "updateNearbyLiveFriendsEntry find_friends_by_near return for null.");
      AppMethodBeat.o(279989);
      return false;
    }
    Log.i("NearbyEntryPreferenceMgr", "updateNearbyLiveFriendsEntry");
    a((FinderIconViewTipPreference)localObject, bool);
    localObject = com.tencent.mm.kernel.h.ag(ak.class);
    p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
    localObject = ((ak)localObject).getRedDotManager();
    p.j(localObject, "MMKernel.plugin(IPluginF…class.java).redDotManager");
    GV(((z)localObject).dqJ());
    AppMethodBeat.o(279989);
    return true;
  }
  
  private final boolean hWY()
  {
    AppMethodBeat.i(279990);
    Object localObject1 = this.XHu;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
      com.tencent.mm.plugin.finder.extension.reddot.h.dqO().b((s)localObject1);
    }
    if ((this.XHq.hGp() & 0x200) == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.by.c.blP("nearby");
      Log.i("NearbyEntryPreferenceMgr", "updateNearbyFriendsEntry enableNearbyFriends:" + bool1 + ", nearbyPluginInstalled:" + bool2);
      if ((bool1) && (bool2)) {
        break;
      }
      this.XHq.hGo().dz("find_friends_by_near", true);
      if (!this.XHq.hFY()) {
        com.tencent.mm.plugin.report.service.h.IzE.p(953L, 5L, 1L);
      }
      AppMethodBeat.o(279990);
      return false;
    }
    this.XHq.hGo().dz("find_friends_by_near", false);
    localObject1 = this.XHq.hGo().byG("find_friends_by_near");
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.IconPreference");
      AppMethodBeat.o(279990);
      throw ((Throwable)localObject1);
    }
    localObject1 = (IconPreference)localObject1;
    if (localObject1 == null)
    {
      Log.w("NearbyEntryPreferenceMgr", "updateNearbyEntry find_friends_by_near return for null.");
      AppMethodBeat.o(279990);
      return false;
    }
    int i;
    if (com.tencent.mm.app.plugin.c.abO())
    {
      ((IconPreference)localObject1).auF(8);
      localObject2 = d.bqd();
      p.j(localObject2, "SubCoreVerify.getLBSVerifyMsgStg()");
      i = ((by)localObject2).cHo();
      if ((!com.tencent.mm.bw.a.hft()) || (com.tencent.mm.bw.a.hfs())) {
        break label367;
      }
      if (i <= 0) {
        break label357;
      }
      ((IconPreference)localObject1).aak(0);
      com.tencent.mm.ui.report.a.Wl(i);
    }
    for (;;)
    {
      AppMethodBeat.o(279990);
      return true;
      ((IconPreference)localObject1).auF(0);
      ((IconPreference)localObject1).J(au.o(this.context, R.k.icons_filled_footstep, this.context.getResources().getColor(R.e.arrow_color)));
      ((IconPreference)localObject1).mu(aw.aZ(this.context, R.f.Edge_2_5_A), aw.aZ(this.context, R.f.Edge_2_5_A));
      break;
      label357:
      ((IconPreference)localObject1).aak(8);
      continue;
      label367:
      if (i > 0)
      {
        ((IconPreference)localObject1).abe(0);
        ((IconPreference)localObject1).fC(String.valueOf(i), w.bj(this.context, i));
        com.tencent.mm.ui.report.a.Wl(i);
      }
      else
      {
        ((IconPreference)localObject1).abe(8);
        ((IconPreference)localObject1).fC("", -1);
      }
    }
  }
  
  public final boolean hWV()
  {
    AppMethodBeat.i(279987);
    Object localObject = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(localObject, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)localObject).ZM())
    {
      this.XHq.hGo().dz("find_friends_by_near", true);
      this.XHq.hGo().dz("find_live_friends_by_near", true);
      this.XHq.hGo().dz("find_friends_by_near_v3", true);
      if (!this.XHq.hFY()) {
        com.tencent.mm.plugin.report.service.h.IzE.p(953L, 5L, 1L);
      }
      Log.i("NearbyEntryPreferenceMgr", "updateNearbyEntry return for isTeenMode.");
      AppMethodBeat.o(279987);
      return false;
    }
    localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      this.XHq.hGo().dz("find_friends_by_near", true);
      this.XHq.hGo().dz("find_live_friends_by_near", true);
      bool = hWW();
      AppMethodBeat.o(279987);
      return bool;
    }
    this.XHq.hGo().dz("find_friends_by_near_v3", true);
    if (com.tencent.mm.bw.a.hfs())
    {
      this.XHq.hGo().dz("find_friends_by_near", true);
      bool = hWX();
      AppMethodBeat.o(279987);
      return bool;
    }
    this.XHq.hGo().dz("find_live_friends_by_near", true);
    boolean bool = hWY();
    AppMethodBeat.o(279987);
    return bool;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class c<T>
    implements s<h.a>
  {
    c(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.findmore.a.b
 * JD-Core Version:    0.7.0.1
 */
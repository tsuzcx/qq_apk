package com.tencent.mm.ui.findmore.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.m;
import com.tencent.mm.plugin.finder.extension.reddot.m.a;
import com.tencent.mm.plugin.finder.extension.reddot.n;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.FindMoreFriendsUI;
import com.tencent.mm.ui.FinderIconViewTipPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.tools.v;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/findmore/entry/NearbyEntryPreferenceMgr;", "", "context", "Landroid/content/Context;", "findMoreFriendsUI", "Lcom/tencent/mm/ui/FindMoreFriendsUI;", "(Landroid/content/Context;Lcom/tencent/mm/ui/FindMoreFriendsUI;)V", "curObservePreference", "Lcom/tencent/mm/ui/FinderIconViewTipPreference;", "lastIsEnableFindLiveState", "", "nearbyEntranceRedDotObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "handleNearbyEntranceLiveRedDot", "", "preference", "result", "info", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "handleNearbyEntranceLocalRedDot", "enableShowNearByEntranceRedDot", "handleNearbyEntranceRedDot", "observeNearbyEntrance", "observeNearbyFriendsRedDot", "enableNearbyFriends", "observeNearbyLiveFriendsRedDot", "startPreloadTargetPage", "isEnableShowFinderLiveEntranceRedDot", "updateNearbyEntry", "updateNearbyEntryV3", "updateNearbyFriendsEntry", "updateNearbyLiveFriendsEntry", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a afvc;
  private final FindMoreFriendsUI afuX;
  private FinderIconViewTipPreference afva;
  private y<l.a> afvd;
  private boolean afve;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(250750);
    afvc = new b.a((byte)0);
    AppMethodBeat.o(250750);
  }
  
  public b(Context paramContext, FindMoreFriendsUI paramFindMoreFriendsUI)
  {
    AppMethodBeat.i(250718);
    this.context = paramContext;
    this.afuX = paramFindMoreFriendsUI;
    paramContext = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    this.afve = com.tencent.mm.plugin.finder.nearby.abtest.a.eEi();
    AppMethodBeat.o(250718);
  }
  
  private final void MN(boolean paramBoolean)
  {
    AppMethodBeat.i(250744);
    if ((paramBoolean) && (this.afuX.hNd))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_context_id", com.tencent.mm.ui.report.a.jCp());
      com.tencent.mm.plugin.finder.nearby.preload.a.EPD.aC(localIntent);
    }
    AppMethodBeat.o(250744);
  }
  
  private static final void MP(boolean paramBoolean)
  {
    AppMethodBeat.i(250749);
    if (!paramBoolean) {
      Log.i("NearbyEntryPreferenceMgr", "handleNearbyEntranceRedDot notify but enableShowNearByEntranceRedDot = false ,remove NearByEntrance ShowInfo");
    }
    AppMethodBeat.o(250749);
  }
  
  private final void a(FinderIconViewTipPreference paramFinderIconViewTipPreference, boolean paramBoolean)
  {
    AppMethodBeat.i(250736);
    int i = com.tencent.mm.modelverify.d.bNJ().dkF();
    if (!paramBoolean) {
      i = 0;
    }
    if ((i <= 0) && (com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.aden, true)) && (((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().dZt()))
    {
      Log.i("NearbyEntryPreferenceMgr", "updateNearbyLiveFriendsEntry: add nearby new red dot");
      ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQu.ear();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.aden, Boolean.FALSE);
    }
    b(paramFinderIconViewTipPreference, paramBoolean);
    AppMethodBeat.o(250736);
  }
  
  private static final void a(b paramb, l.a parama)
  {
    boolean bool1 = true;
    AppMethodBeat.i(250748);
    s.u(paramb, "this$0");
    if (paramb.afva == null)
    {
      Log.i("NearbyEntryPreferenceMgr", "handleNearbyEntranceRedDot return for null");
      AppMethodBeat.o(250748);
      return;
    }
    FinderIconViewTipPreference localFinderIconViewTipPreference = paramb.afva;
    s.checkNotNull(localFinderIconViewTipPreference);
    if (parama == null)
    {
      Log.i("NearbyEntryPreferenceMgr", "handleNearbyEntranceRedDot preference:" + localFinderIconViewTipPreference + ' ' + localFinderIconViewTipPreference.hashCode() + " return for null");
      AppMethodBeat.o(250748);
      return;
    }
    Object localObject1 = new StringBuilder("handleNearbyEntranceRedDot nearbyEntrance:");
    Object localObject2 = l.ARA;
    Log.i("Finder.RedDotNotifier", l.dZY().getValue() + " result:" + parama);
    if (!parama.hBY)
    {
      localFinderIconViewTipPreference.yn(false);
      FindMoreFriendsUI.ef("find_live_friends_by_near", false);
      Log.w("NearbyEntryPreferenceMgr", "handleNearbyEntranceRedDot return for isShow");
      AppMethodBeat.o(250748);
      return;
    }
    int i;
    if (parama.ASh != null)
    {
      localObject1 = parama.ASh;
      s.checkNotNull(localObject1);
      if (((p)localObject1).field_ctrType != 1013)
      {
        localObject1 = parama.ASh;
        s.checkNotNull(localObject1);
        if (((p)localObject1).field_ctrType != 1014)
        {
          localObject1 = parama.ASh;
          s.checkNotNull(localObject1);
          if (((p)localObject1).field_ctrType != 1011) {
            break label286;
          }
        }
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject1 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
        if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
        {
          Log.w("NearbyEntryPreferenceMgr", s.X("handleNearbyEntranceRedDot return for nearby v3 result:", parama));
          AppMethodBeat.o(250748);
          return;
          label286:
          i = 0;
          continue;
        }
      }
      localObject1 = parama.ASg;
      if (localObject1 == null)
      {
        Log.w("NearbyEntryPreferenceMgr", "handleNearbyEntranceRedDot info is null");
        AppMethodBeat.o(250748);
        return;
      }
      boolean bool2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().dZt();
      Log.i("NearbyEntryPreferenceMgr", "handleNearbyEntranceRedDot preference:" + localFinderIconViewTipPreference + ' ' + localFinderIconViewTipPreference.hashCode() + " [onChanged] isEnableShowNearByEntranceRedDot:" + bool2 + " result" + parama);
      if (i != 0) {
        if ((((bxq)localObject1).show_type != 101) && (!bool2)) {
          Log.i("NearbyEntryPreferenceMgr", "handleNearbyEntranceLocalRedDot return for enableShowNearByEntranceRedDot:" + bool2 + '.');
        }
      }
      for (;;)
      {
        com.tencent.threadpool.h.ahAA.bo(new b..ExternalSyntheticLambda1(bool2));
        AppMethodBeat.o(250748);
        return;
        if ((paramb.afuX.PtI & 0x200) == 0) {}
        for (bool1 = true;; bool1 = false)
        {
          Log.i("NearbyEntryPreferenceMgr", s.X("handleNearbyEntranceLocalRedDot enableNearbyFriends:", Boolean.valueOf(bool1)));
          FindMoreFriendsUI.ef("find_live_friends_by_near", true);
          if (((bxq)localObject1).show_type != 6) {
            break label564;
          }
          if ((com.tencent.mm.modelverify.d.bNJ().dkF() > 0) && (bool1)) {
            break;
          }
          localFinderIconViewTipPreference.yn(false);
          localFinderIconViewTipPreference.afx(0);
          localFinderIconViewTipPreference.gv(paramb.context.getString(R.l.app_new), R.g.new_tips_bg);
          break;
        }
        label564:
        localFinderIconViewTipPreference.yn(false);
        localFinderIconViewTipPreference.aBh(0);
        localFinderIconViewTipPreference.aBi(0);
        localFinderIconViewTipPreference.T(bb.m(paramb.context, R.k.icons_filled_footstep, paramb.context.getResources().getColor(R.e.arrow_color)));
        localFinderIconViewTipPreference.oo(bd.bs(paramb.context, R.f.Edge_2_5_A), bd.bs(paramb.context, R.f.Edge_2_5_A));
        if (((bxq)localObject1).show_type != 101)
        {
          i = ((bxq)localObject1).count;
          localFinderIconViewTipPreference.afx(0);
          localFinderIconViewTipPreference.gv(s.X("", Integer.valueOf(i)), v.bC(paramb.context, i));
          paramb = m.ASi;
          paramb = parama.ASh;
          s.checkNotNull(paramb);
          paramb = paramb.field_tipsId;
          s.s(paramb, "result.ctrInfo!!.field_tipsId");
          m.a.avF(paramb);
          continue;
          localObject2 = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
          if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
          {
            Log.w("NearbyEntryPreferenceMgr", "handleNearbyEntranceLiveRedDot return for isEnableFindLive");
          }
          else
          {
            if (com.tencent.mm.bp.a.iGm()) {
              break;
            }
            Log.w("NearbyEntryPreferenceMgr", "handleNearbyEntranceLiveRedDot return for isEnableNearByLiveFriends");
          }
        }
      }
      localFinderIconViewTipPreference.aBh(8);
      localFinderIconViewTipPreference.afx(8);
      localFinderIconViewTipPreference.gv("", -1);
      boolean bool3 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().dZt();
      Log.i("NearbyEntryPreferenceMgr", "handleNearbyEntranceLiveRedDot isEnableShowNearByEntranceRedDot:" + bool3 + " result:" + parama + " info:" + localObject1);
      localObject2 = paramb.afuX;
      parama = parama.ASh;
      if (parama != null)
      {
        parama = parama.ASz;
        if ((parama == null) || (parama.aabQ != 1)) {}
      }
      for (;;)
      {
        ((FindMoreFriendsUI)localObject2).a((bxq)localObject1, localFinderIconViewTipPreference, false, bool3, bool1);
        paramb.MN(bool3);
        break;
        bool1 = false;
      }
      i = 0;
    }
  }
  
  private final void b(FinderIconViewTipPreference paramFinderIconViewTipPreference)
  {
    AppMethodBeat.i(250741);
    this.afva = paramFinderIconViewTipPreference;
    Object localObject;
    if (this.afvd != null)
    {
      localObject = new StringBuilder("observeNearbyEntrance lastIsEnableFindLiveState:").append(this.afve).append(" isEnableFindLive:");
      com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      Log.w("NearbyEntryPreferenceMgr", com.tencent.mm.plugin.finder.nearby.abtest.a.eEi() + "  preference: " + paramFinderIconViewTipPreference + ' ' + paramFinderIconViewTipPreference.hashCode() + " return for observing.");
      boolean bool = this.afve;
      paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      if (bool != com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
      {
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
        if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
          break label166;
        }
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
        com.tencent.mm.plugin.finder.extension.reddot.nearby.a.avN("removeFinderLiveEntranceShowInfo");
        paramFinderIconViewTipPreference = l.ARA;
        paramFinderIconViewTipPreference = l.dZY();
        localObject = l.ARA;
        paramFinderIconViewTipPreference.t(l.dZY().getValue());
      }
      for (;;)
      {
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
        this.afve = com.tencent.mm.plugin.finder.nearby.abtest.a.eEi();
        AppMethodBeat.o(250741);
        return;
        label166:
        paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
        com.tencent.mm.plugin.finder.extension.reddot.nearby.a.avM("removeNearbyEntryLiveShowInfo");
        paramFinderIconViewTipPreference = l.ARA;
        paramFinderIconViewTipPreference = l.dZX();
        localObject = l.ARA;
        paramFinderIconViewTipPreference.t(l.dZX().getValue());
      }
    }
    Log.i("NearbyEntryPreferenceMgr", "observeNearbyEntrance preference:" + paramFinderIconViewTipPreference + ' ' + paramFinderIconViewTipPreference.hashCode());
    this.afvd = new b..ExternalSyntheticLambda0(this);
    paramFinderIconViewTipPreference = this.afvd;
    if (paramFinderIconViewTipPreference != null)
    {
      localObject = l.ARA;
      l.dZY().a((q)this.afuX, paramFinderIconViewTipPreference);
    }
    paramFinderIconViewTipPreference = l.ARA;
    paramFinderIconViewTipPreference = (l.a)l.dZY().getValue();
    if (paramFinderIconViewTipPreference != null)
    {
      localObject = this.afvd;
      if (localObject != null) {
        ((y)localObject).onChanged(paramFinderIconViewTipPreference);
      }
    }
    paramFinderIconViewTipPreference = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    this.afve = com.tencent.mm.plugin.finder.nearby.abtest.a.eEi();
    AppMethodBeat.o(250741);
  }
  
  private final void b(FinderIconViewTipPreference paramFinderIconViewTipPreference, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(250740);
    int i = com.tencent.mm.modelverify.d.bNJ().dkF();
    if (!paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      if ((!com.tencent.mm.app.plugin.c.aDN()) && (paramBoolean))
      {
        Log.i("NearbyEntryPreferenceMgr", "observeNearbyFriendsRedDot: add footprint red dot");
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQu.eaq();
        bxq localbxq = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp("NearbyPeopleTab");
        if (localbxq != null) {
          j = localbxq.count;
        }
        if (i <= 0) {
          break label189;
        }
        Log.i("NearbyEntryPreferenceMgr", "observeNearbyFriendsRedDot: add unread red dot,insideRedDotUnRedCount = " + j + ", unRead = " + i);
        if (i > j) {
          ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().AQu.Nz(i);
        }
      }
      for (;;)
      {
        b(paramFinderIconViewTipPreference);
        AppMethodBeat.o(250740);
        return;
        Log.i("NearbyEntryPreferenceMgr", "observeNearbyFriendsRedDot: clear footprint red dot");
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Nv(1014);
        break;
        label189:
        Log.i("NearbyEntryPreferenceMgr", "observeNearbyFriendsRedDot: clear unread red dot");
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Nv(1013);
      }
    }
  }
  
  private final boolean jBt()
  {
    AppMethodBeat.i(250722);
    int i;
    if (!this.afuX.ju(70368744177664L))
    {
      i = 1;
      if ((this.afuX.PtI & 0x200) != 0) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      if (i != 0) {
        break label92;
      }
      this.afuX.FUv.eh("find_friends_by_near_v3", true);
      Log.w("NearbyEntryPreferenceMgr", "updateNearbyEntryV3 return for openNearbyLiveFriends:%s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(250722);
      return false;
      i = 0;
      break;
    }
    label92:
    if (this.afuX.hNd) {
      com.tencent.mm.ui.report.a.jCl();
    }
    this.afuX.FUv.eh("find_friends_by_near_v3", false);
    Object localObject = this.afuX.FUv.bAi("find_friends_by_near_v3");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.FinderIconViewTipPreference");
      AppMethodBeat.o(250722);
      throw ((Throwable)localObject);
    }
    b((FinderIconViewTipPreference)localObject, bool);
    Log.i("NearbyEntryPreferenceMgr", "updateNearbyEntryV3");
    AppMethodBeat.o(250722);
    return true;
  }
  
  private final boolean jBu()
  {
    AppMethodBeat.i(250727);
    int i;
    if (!this.afuX.ju(70368744177664L))
    {
      i = 1;
      if ((this.afuX.PtI & 0x200) != 0) {
        break label87;
      }
    }
    label87:
    for (boolean bool = true;; bool = false)
    {
      if (i != 0) {
        break label92;
      }
      this.afuX.FUv.eh("find_live_friends_by_near", true);
      Log.w("NearbyEntryPreferenceMgr", "updateNearbyLiveFriendsEntry return for openNearbyLiveFriends:%s", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(250727);
      return false;
      i = 0;
      break;
    }
    label92:
    if (this.afuX.hNd) {
      com.tencent.mm.ui.report.a.jCj();
    }
    this.afuX.FUv.eh("find_live_friends_by_near", false);
    Object localObject = this.afuX.FUv.bAi("find_live_friends_by_near");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.FinderIconViewTipPreference");
      AppMethodBeat.o(250727);
      throw ((Throwable)localObject);
    }
    localObject = (FinderIconViewTipPreference)localObject;
    Log.i("NearbyEntryPreferenceMgr", "updateNearbyLiveFriendsEntry");
    a((FinderIconViewTipPreference)localObject, bool);
    MN(((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().dZt());
    AppMethodBeat.o(250727);
    return true;
  }
  
  private final boolean jBv()
  {
    AppMethodBeat.i(250732);
    Object localObject = this.afvd;
    if (localObject != null)
    {
      l locall = l.ARA;
      l.dZC().b((y)localObject);
    }
    if ((this.afuX.PtI & 0x200) == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.br.c.blq("nearby");
      Log.i("NearbyEntryPreferenceMgr", "updateNearbyFriendsEntry enableNearbyFriends:" + bool1 + ", nearbyPluginInstalled:" + bool2);
      if ((bool1) && (bool2)) {
        break;
      }
      this.afuX.FUv.eh("find_friends_by_near", true);
      if (!this.afuX.jij()) {
        com.tencent.mm.plugin.report.service.h.OAn.p(953L, 5L, 1L);
      }
      AppMethodBeat.o(250732);
      return false;
    }
    this.afuX.FUv.eh("find_friends_by_near", false);
    localObject = this.afuX.FUv.bAi("find_friends_by_near");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.IconPreference");
      AppMethodBeat.o(250732);
      throw ((Throwable)localObject);
    }
    localObject = (IconPreference)localObject;
    int i;
    if (com.tencent.mm.app.plugin.c.aDN())
    {
      ((IconPreference)localObject).aBh(8);
      i = com.tencent.mm.modelverify.d.bNJ().dkF();
      if ((!com.tencent.mm.bp.a.iGn()) || (com.tencent.mm.bp.a.iGm())) {
        break label334;
      }
      if (i <= 0) {
        break label324;
      }
      ((IconPreference)localObject).aeD(0);
      com.tencent.mm.ui.report.a.Ax(i);
    }
    for (;;)
    {
      AppMethodBeat.o(250732);
      return true;
      ((IconPreference)localObject).aBh(0);
      ((IconPreference)localObject).T(bb.m(this.context, R.k.icons_filled_footstep, this.context.getResources().getColor(R.e.arrow_color)));
      ((IconPreference)localObject).oo(bd.bs(this.context, R.f.Edge_2_5_A), bd.bs(this.context, R.f.Edge_2_5_A));
      break;
      label324:
      ((IconPreference)localObject).aeD(8);
      continue;
      label334:
      if (i > 0)
      {
        ((IconPreference)localObject).afx(0);
        ((IconPreference)localObject).gv(s.X("", Integer.valueOf(i)), v.bC(this.context, i));
        com.tencent.mm.ui.report.a.Ax(i);
      }
      else
      {
        ((IconPreference)localObject).afx(8);
        ((IconPreference)localObject).gv("", -1);
      }
    }
  }
  
  public final boolean jBs()
  {
    AppMethodBeat.i(250756);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      this.afuX.FUv.eh("find_friends_by_near", true);
      this.afuX.FUv.eh("find_live_friends_by_near", true);
      this.afuX.FUv.eh("find_friends_by_near_v3", true);
      if (!this.afuX.jij()) {
        com.tencent.mm.plugin.report.service.h.OAn.p(953L, 5L, 1L);
      }
      Log.i("NearbyEntryPreferenceMgr", "updateNearbyEntry return for isTeenMode.");
      AppMethodBeat.o(250756);
      return false;
    }
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      this.afuX.FUv.eh("find_friends_by_near", true);
      this.afuX.FUv.eh("find_live_friends_by_near", true);
      bool = jBt();
      AppMethodBeat.o(250756);
      return bool;
    }
    this.afuX.FUv.eh("find_friends_by_near_v3", true);
    if (com.tencent.mm.bp.a.iGm())
    {
      this.afuX.FUv.eh("find_friends_by_near", true);
      bool = jBu();
      AppMethodBeat.o(250756);
      return bool;
    }
    this.afuX.FUv.eh("find_live_friends_by_near", true);
    boolean bool = jBv();
    AppMethodBeat.o(250756);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.findmore.a.b
 * JD-Core Version:    0.7.0.1
 */
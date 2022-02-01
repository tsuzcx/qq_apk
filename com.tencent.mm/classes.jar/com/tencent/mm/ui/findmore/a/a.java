package com.tencent.mm.ui.findmore.a;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.finder.extension.reddot.l;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.FindMoreFriendsUI;
import com.tencent.mm.ui.FinderIconViewTipPreference;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/findmore/entry/FinderLiveEntryPreferenceMgr;", "", "context", "Landroid/content/Context;", "findMoreFriendsUI", "Lcom/tencent/mm/ui/FindMoreFriendsUI;", "(Landroid/content/Context;Lcom/tencent/mm/ui/FindMoreFriendsUI;)V", "curObservePreference", "Lcom/tencent/mm/ui/FinderIconViewTipPreference;", "enableFinderLiveEntryAboveLook", "", "finderLiveRedDotObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "lastIsEnableFinderLiveEntryAboveLook", "dismissFinderLiveEntrance", "", "getFinderLiveEntranceKey", "", "handleFinderLiveRedDot", "result", "isEnableFinderLiveEntry", "observeFinderLiveRedDot", "preference", "showFinderLiveEntrance", "startPreloadTargetPage", "isEnableShowFinderLiveEntranceRedDot", "updateFinderLiveEntry", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a afuW;
  public final FindMoreFriendsUI afuX;
  public boolean afuY;
  private y<l.a> afuZ;
  private FinderIconViewTipPreference afva;
  private boolean afvb;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(250729);
    afuW = new a.a((byte)0);
    AppMethodBeat.o(250729);
  }
  
  public a(Context paramContext, FindMoreFriendsUI paramFindMoreFriendsUI)
  {
    AppMethodBeat.i(250712);
    this.context = paramContext;
    this.afuX = paramFindMoreFriendsUI;
    this.afvb = this.afuY;
    AppMethodBeat.o(250712);
  }
  
  private static final void MO(boolean paramBoolean)
  {
    AppMethodBeat.i(250726);
    if (!paramBoolean) {
      Log.i("FinderLiveEntryPreferenceMgr", "handleFinderLiveRedDot notify but enableShowNearByEntranceRedDot = false ,remove NearByEntrance ShowInfo");
    }
    AppMethodBeat.o(250726);
  }
  
  private static final void a(a parama, l.a parama1)
  {
    boolean bool1 = true;
    AppMethodBeat.i(250724);
    s.u(parama, "this$0");
    if (parama.afva == null)
    {
      Log.i("FinderLiveEntryPreferenceMgr", "handleFinderLiveRedDot return for null");
      AppMethodBeat.o(250724);
      return;
    }
    FinderIconViewTipPreference localFinderIconViewTipPreference = parama.afva;
    s.checkNotNull(localFinderIconViewTipPreference);
    if (!parama.afuX.FUv.bAj(parama.jBr()))
    {
      Log.i("FinderLiveEntryPreferenceMgr", s.X("handleFinderLiveRedDot return for not show ", parama.jBr()));
      AppMethodBeat.o(250724);
      return;
    }
    if (parama1 == null)
    {
      Log.i("FinderLiveEntryPreferenceMgr", "handleFinderLiveRedDot preference:" + localFinderIconViewTipPreference + ' ' + localFinderIconViewTipPreference.hashCode() + " return for null");
      AppMethodBeat.o(250724);
      return;
    }
    if (!parama1.hBY)
    {
      localFinderIconViewTipPreference.yn(false);
      parama.jBp();
      FindMoreFriendsUI.ef("find_friends_by_finder_live", false);
      Log.i("FinderLiveEntryPreferenceMgr", "handleFinderLiveRedDot return for isShow");
      AppMethodBeat.o(250724);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      Log.i("FinderLiveEntryPreferenceMgr", "handleFinderLiveRedDot return for isEnableFindLive");
      AppMethodBeat.o(250724);
      return;
    }
    localObject = parama1.ASg;
    if (localObject == null)
    {
      Log.e("FinderLiveEntryPreferenceMgr", "handleFinderLiveRedDot info is null");
      AppMethodBeat.o(250724);
      return;
    }
    boolean bool2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().dZv();
    Log.i("FinderLiveEntryPreferenceMgr", "handleFinderLiveRedDot preference:" + localFinderIconViewTipPreference + ' ' + localFinderIconViewTipPreference.hashCode() + " [onChanged] isEnableShowNearByEntranceRedDot:" + bool2 + " result" + parama1);
    if (((bxq)localObject).show_type == 6)
    {
      localFinderIconViewTipPreference.yn(false);
      localFinderIconViewTipPreference.afx(0);
      localFinderIconViewTipPreference.gv(parama.context.getString(R.l.app_new), R.g.new_tips_bg);
      parama.jBq();
      com.tencent.threadpool.h.ahAA.bo(new a..ExternalSyntheticLambda1(bool2));
      AppMethodBeat.o(250724);
      return;
    }
    localFinderIconViewTipPreference.aBh(8);
    localFinderIconViewTipPreference.afx(8);
    localFinderIconViewTipPreference.gv("", -1);
    FindMoreFriendsUI localFindMoreFriendsUI = parama.afuX;
    parama1 = parama1.ASh;
    if (parama1 != null)
    {
      parama1 = parama1.ASz;
      if ((parama1 == null) || (parama1.aabQ != 1)) {}
    }
    for (;;)
    {
      localFindMoreFriendsUI.a((bxq)localObject, localFinderIconViewTipPreference, false, bool2, bool1);
      ((com.tencent.d.a.b.a.b.a)com.tencent.mm.kernel.h.ax(com.tencent.d.a.b.a.b.a.class)).eGP();
      parama.MN(bool2);
      break;
      bool1 = false;
    }
  }
  
  private final void jBq()
  {
    AppMethodBeat.i(250716);
    this.afuX.FUv.eh("find_friends_by_finder_live_above_look", true);
    this.afuX.FUv.eh("find_friends_by_finder_live", true);
    AppMethodBeat.o(250716);
  }
  
  public final void MN(boolean paramBoolean)
  {
    AppMethodBeat.i(250745);
    if ((paramBoolean) && (this.afuX.hNd))
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_context_id", com.tencent.mm.ui.report.a.jCq());
      com.tencent.mm.plugin.finder.nearby.preload.a.EPD.aB((Intent)localObject);
      if (((b)com.tencent.mm.kernel.h.az(b.class)).isNewLiveEntranceEnable())
      {
        localObject = com.tencent.mm.kernel.h.ax(com.tencent.d.a.b.a.b.a.class);
        s.s(localObject, "service(INearbyRefreshService::class.java)");
        ((com.tencent.d.a.b.a.b.a)localObject).sV(false);
      }
    }
    AppMethodBeat.o(250745);
  }
  
  public final void a(FinderIconViewTipPreference paramFinderIconViewTipPreference)
  {
    AppMethodBeat.i(250743);
    this.afva = paramFinderIconViewTipPreference;
    Object localObject;
    if (this.afuZ != null)
    {
      Log.w("FinderLiveEntryPreferenceMgr", "observeFinderLiveRedDot preference:" + paramFinderIconViewTipPreference + ' ' + paramFinderIconViewTipPreference.hashCode() + " return for observing.");
      if (this.afvb != this.afuY)
      {
        Log.w("FinderLiveEntryPreferenceMgr", "observeFinderLiveRedDot preference:" + paramFinderIconViewTipPreference + ' ' + paramFinderIconViewTipPreference.hashCode() + " refresh red not, enableFinderLiveEntryAboveLook:" + this.afuY + " lastIsEnableFinderLiveEntryAboveLook:" + this.afvb);
        paramFinderIconViewTipPreference = l.ARA;
        paramFinderIconViewTipPreference = l.dZX();
        localObject = l.ARA;
        paramFinderIconViewTipPreference.t(l.dZX().getValue());
        this.afvb = this.afuY;
      }
      AppMethodBeat.o(250743);
      return;
    }
    Log.i("FinderLiveEntryPreferenceMgr", "observeFinderLiveRedDot preference:" + paramFinderIconViewTipPreference + ' ' + paramFinderIconViewTipPreference.hashCode());
    this.afuZ = new a..ExternalSyntheticLambda0(this);
    paramFinderIconViewTipPreference = this.afuZ;
    if (paramFinderIconViewTipPreference != null)
    {
      localObject = l.ARA;
      l.dZX().a((q)this.afuX, paramFinderIconViewTipPreference);
    }
    paramFinderIconViewTipPreference = l.ARA;
    paramFinderIconViewTipPreference = (l.a)l.dZX().getValue();
    if (paramFinderIconViewTipPreference != null)
    {
      localObject = this.afuZ;
      if (localObject != null) {
        ((y)localObject).onChanged(paramFinderIconViewTipPreference);
      }
    }
    this.afvb = this.afuY;
    AppMethodBeat.o(250743);
  }
  
  public final boolean fgE()
  {
    AppMethodBeat.i(250737);
    if (((d)com.tencent.mm.kernel.h.ax(d.class)).aBu())
    {
      jBq();
      Log.i("FinderLiveEntryPreferenceMgr", "updateFinderLiveEntry return for isTeenMode.");
      AppMethodBeat.o(250737);
      return false;
    }
    if (!this.afuX.ju(9007199254740992L)) {}
    for (int i = 1; i == 0; i = 0)
    {
      jBq();
      Log.w("FinderLiveEntryPreferenceMgr", "updateFinderLiveEntry return for enableFinderLiveEntry");
      AppMethodBeat.o(250737);
      return false;
    }
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      jBq();
      Log.w("FinderLiveEntryPreferenceMgr", "updateFinderLiveEntry return for isEnableFindLive");
      AppMethodBeat.o(250737);
      return false;
    }
    AppMethodBeat.o(250737);
    return true;
  }
  
  public final void jBp()
  {
    AppMethodBeat.i(250739);
    if (this.afuY)
    {
      this.afuX.FUv.eh("find_friends_by_finder_live_above_look", false);
      this.afuX.FUv.eh("find_friends_by_finder_live", true);
      AppMethodBeat.o(250739);
      return;
    }
    this.afuX.FUv.eh("find_friends_by_finder_live_above_look", true);
    this.afuX.FUv.eh("find_friends_by_finder_live", false);
    AppMethodBeat.o(250739);
  }
  
  public final String jBr()
  {
    if (this.afuY) {
      return "find_friends_by_finder_live_above_look";
    }
    return "find_friends_by_finder_live";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.findmore.a.a
 * JD-Core Version:    0.7.0.1
 */
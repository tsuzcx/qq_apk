package com.tencent.mm.plugin.taskbar.ui;

import android.util.Pair;
import android.view.View;
import com.tencent.d.a.a.a.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.a;
import com.tencent.mm.plugin.appbrand.widget.recent.j;
import com.tencent.mm.plugin.appbrand.widget.recent.m;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.a.a;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.h.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter;", "", "()V", "closePageType", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "getCollectionStorage", "()Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "currentTabIndex", "exceedOtherData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "firstFeedShowInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$TaskBarFeedAppearInfo;", "Lkotlin/collections/ArrayList;", "homeTabChangedListener", "com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1;", "isTeenMode", "", "()Z", "setTeenMode", "(Z)V", "lastLiveCheckTimeSec", "", "lastStartTime", "liveCheckIntervalSec", "miniProgramOption", "getMiniProgramOption", "()I", "setMiniProgramOption", "(I)V", "myWeAppOnStorageChangeListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "sectionDataMyWeApp", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "getSectionDataMyWeApp", "()Ljava/util/ArrayList;", "setSectionDataMyWeApp", "(Ljava/util/ArrayList;)V", "sectionDataWeApp", "getSectionDataWeApp", "setSectionDataWeApp", "sectionViewModelMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "Lkotlin/collections/HashMap;", "taskBarOnStorageChangeListener", "taskBarReporter", "Lcom/tencent/mm/plugin/taskbar/report/TaskBarReporter;", "taskBarUpdateEventListener", "com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$taskBarUpdateEventListener$1", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$taskBarUpdateEventListener$1;", "teenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "getUsageStorage", "()Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "view", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$IView;", "viewDuration", "weAppOnStorageChangeListener", "canLaunchAppBrand", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "appInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaAppInfo;", "checkLaunchAppBrand", "", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$LaunchAppBrandPreCheckCallback;", "checkLiveState", "getAppIdList", "", "appBrandItems", "", "getLiveTaskInfo", "getViewModelBySectionType", "sectionType", "isOnMainTab", "itemListDescription", "localUsageInfoList", "localUsageListDescription", "onCreate", "onDestroy", "onDidAppear", "onDidClose", "reason", "isDesktop", "isMyDesktop", "onOpenHeader", "onPause", "onResume", "onStartToPull", "onViewDestroy", "reloadData", "notify", "reloadOtherData", "viewModel", "reloadWeAppData", "isMy", "removeExceedData", "removeTimeoutData", "removeWeAppData", "pos", "reportDesktopAppear", "isMyWeApp", "count", "reportOnFirstFeedShow", "reportOnItemAddDeleted", "appItem", "actionType", "actionChannel", "multiTaskInfo", "reportOnItemAppear", "appView", "Landroid/view/View;", "isMyWeAppView", "isLoadMore", "exp_type", "page_type", "page", "iconAppId", "reportOnItemAppearDirectly", "reportOnItemClicked", "isMyWeapp", "itemType", "appID", "reportOnItemManualAddDeleteMyWeApp", "insert", "reportOnItemReorderWeApp", "startPos", "endPos", "isTaskBar", "reportTaskBarAppear", "isBackFromDesktop", "reportTaskBarClose", "closeType", "resetPendingShowInfo", "updateTeenModeStatus", "Companion", "IView", "LaunchAppBrandPreCheckCallback", "TaskBarFeedAppearInfo", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final a STj;
  private int LHx;
  public b STk;
  ArrayList<AppBrandDesktopView.a> STl;
  ArrayList<AppBrandDesktopView.a> STm;
  private final HashMap<Integer, com.tencent.mm.plugin.taskbar.ui.section.d> STn;
  private final LinkedList<MultiTaskInfo> STo;
  private long STp;
  private int STq;
  a STr;
  public long STs;
  ArrayList<d> STt;
  int STu;
  public final MStorage.IOnStorageChange STv;
  public final MStorage.IOnStorageChange STw;
  public final TaskBarViewPresenter.taskBarUpdateEventListener.1 STx;
  public final MStorage.IOnStorageChange STy;
  public final TaskBarViewPresenter.homeTabChangedListener.1 STz;
  boolean epi;
  public final com.tencent.mm.plugin.teenmode.a.g qCv;
  public long teM;
  private com.tencent.mm.plugin.appbrand.widget.recent.i uPN;
  private com.tencent.mm.plugin.appbrand.widget.recent.b uPO;
  private int umi;
  
  static
  {
    AppMethodBeat.i(264265);
    STj = new a((byte)0);
    AppMethodBeat.o(264265);
  }
  
  public d()
  {
    AppMethodBeat.i(264087);
    this.STl = new ArrayList();
    this.STm = new ArrayList();
    this.STo = new LinkedList();
    this.STq = 60;
    this.STr = new a();
    this.STt = new ArrayList();
    this.STv = new d..ExternalSyntheticLambda2(this);
    this.STw = new d..ExternalSyntheticLambda3(this);
    this.STx = new TaskBarViewPresenter.taskBarUpdateEventListener.1(this, f.hfK);
    this.STy = new d..ExternalSyntheticLambda1(this);
    this.STz = new TaskBarViewPresenter.homeTabChangedListener.1(this, f.hfK);
    this.qCv = new d..ExternalSyntheticLambda0(this);
    this.STn = ak.g(new r[] { v.Y(Integer.valueOf(4), new com.tencent.mm.plugin.taskbar.ui.section.d(4, new int[] { 2, 21, 22, 6, 4, 3 })) });
    this.STz.alive();
    this.STx.alive();
    Object localObject = hDN();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recent.i)localObject).add(this.STv);
    }
    localObject = hDO();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recent.b)localObject).add(this.STw);
    }
    localObject = ((PluginTaskBar)com.tencent.mm.kernel.h.az(PluginTaskBar.class)).getTaskBarStorage();
    if (localObject != null) {
      ((com.tencent.mm.plugin.taskbar.h)localObject).add(this.STy);
    }
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(this.qCv);
    AppMethodBeat.o(264087);
  }
  
  private static final int a(MultiTaskInfo paramMultiTaskInfo1, MultiTaskInfo paramMultiTaskInfo2)
  {
    long l = paramMultiTaskInfo2.field_updateTime - paramMultiTaskInfo1.field_updateTime;
    if (l == 0L) {
      return 0;
    }
    if (l > 0L) {
      return 1;
    }
    return -1;
  }
  
  private void a(MultiTaskInfo paramMultiTaskInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264164);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAddDeleted type:%d,pos:%d", new Object[] { Integer.valueOf(paramMultiTaskInfo.field_type), Integer.valueOf(0) });
    if (paramInt1 == 2) {}
    for (long l = cn.bDw() - paramMultiTaskInfo.field_updateTime;; l = 0L)
    {
      this.STr.a(paramInt1, paramInt2, a.UG(paramMultiTaskInfo.field_type), paramMultiTaskInfo.field_id, (int)l / 1000, 1, 0, 0);
      AppMethodBeat.o(264164);
      return;
    }
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(264096);
    paramc.cqs();
    AppMethodBeat.o(264096);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(264170);
    s.u(paramd, "this$0");
    Log.i("MicroMsg.TaskBarViewPresenter", "received weAppOnStorageChangeListener");
    paramd.bh(true, false);
    AppMethodBeat.o(264170);
  }
  
  private static final void a(d paramd, String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(264177);
    s.u(paramd, "this$0");
    com.tencent.threadpool.h.ahAA.bn(new d..ExternalSyntheticLambda4(paramd));
    AppMethodBeat.o(264177);
  }
  
  private static final void a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(264235);
    s.u(paramd, "this$0");
    Log.i("MicroMsg.TaskBarViewPresenter", "do reload data");
    paramd.bh(false, false);
    paramd.bh(false, true);
    com.tencent.mm.plugin.taskbar.ui.section.d locald = (com.tencent.mm.plugin.taskbar.ui.section.d)paramd.STn.get(Integer.valueOf(4));
    if (locald != null) {
      paramd.a(locald);
    }
    if (paramBoolean)
    {
      paramd = paramd.STk;
      if (paramd != null) {
        paramd.hDw();
      }
    }
    AppMethodBeat.o(264235);
  }
  
  private static final void a(LinkedList paramLinkedList, d paramd)
  {
    AppMethodBeat.i(264221);
    s.u(paramLinkedList, "$timeoutData");
    s.u(paramd, "this$0");
    Log.i("MicroMsg.TaskBarViewPresenter", "async remove timeout taskbar item");
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)paramLinkedList.next();
      paramd.a(localMultiTaskInfo, 2, 5);
      ((PluginTaskBar)com.tencent.mm.kernel.h.az(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(localMultiTaskInfo);
      ((com.tencent.mm.plugin.taskbar.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.taskbar.c.class)).removeTaskInfo(localMultiTaskInfo.field_id, false, 5);
    }
    AppMethodBeat.o(264221);
  }
  
  private static final void b(d paramd)
  {
    AppMethodBeat.i(264186);
    s.u(paramd, "this$0");
    Log.i("MicroMsg.TaskBarViewPresenter", "received myWeAppOnStorageChangeListener");
    paramd.bh(true, true);
    AppMethodBeat.o(264186);
  }
  
  private static final void b(d paramd, String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(264193);
    s.u(paramd, "this$0");
    com.tencent.threadpool.h.ahAA.bn(new d..ExternalSyntheticLambda6(paramd));
    AppMethodBeat.o(264193);
  }
  
  private void bh(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 2;
    int m = 0;
    AppMethodBeat.i(264122);
    int n;
    label71:
    boolean bool;
    if (paramBoolean2)
    {
      localObject1 = this.STm;
      n = ((ArrayList)localObject1).size();
      if (n <= 0) {
        break label191;
      }
      localObject2 = (CharSequence)((AppBrandDesktopView.a)((ArrayList)localObject1).get(0)).uAl.nickname;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label186;
      }
      i = 1;
      if (i == 0) {
        break label191;
      }
      bool = true;
      label78:
      Log.i("MicroMsg.TaskBarViewPresenter", "update WeApp Data " + n + ' ' + paramBoolean1 + ' ' + paramBoolean2 + ' ' + bool);
      lp((List)localObject1);
      if (!paramBoolean2) {
        break label219;
      }
      localObject1 = hDO();
      if (localObject1 != null) {
        break label197;
      }
    }
    label186:
    label191:
    label197:
    for (Object localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.appbrand.widget.recent.b)localObject1).a(com.tencent.mm.plugin.appbrand.widget.recent.h.uPW.count, com.tencent.mm.plugin.appbrand.widget.recent.h.uPW.qQm))
    {
      if (localObject1 != null) {
        break label259;
      }
      Log.w("MicroMsg.TaskBarViewPresenter", "usageStorage is null");
      AppMethodBeat.o(264122);
      return;
      localObject1 = this.STl;
      break;
      i = 0;
      break label71;
      bool = false;
      break label78;
    }
    label219:
    localObject1 = hDN();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.appbrand.widget.recent.i)localObject1).zu(com.tencent.mm.plugin.appbrand.widget.recent.h.uPX.count))
    {
      localObject1 = an.hD(localObject1);
      break;
    }
    label259:
    Object localObject2 = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    if (localIterator.hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
      if (paramBoolean2) {}
      for (i = 2;; i = 1)
      {
        ((ArrayList)localObject2).add(new AppBrandDesktopView.a(localLocalUsageInfo, i));
        break;
      }
    }
    lq((List)localObject1);
    lp((List)localObject2);
    if (paramBoolean2)
    {
      this.STm = ((ArrayList)localObject2);
      Log.i("MicroMsg.TaskBarViewPresenter", s.X("update WeApp Data Done ", Integer.valueOf(((ArrayList)localObject2).size())));
      if (((Collection)localObject2).isEmpty()) {
        break label554;
      }
      i = 1;
      label387:
      if (i != 0) {
        if (n != 0)
        {
          if (bool)
          {
            localObject1 = ((AppBrandDesktopView.a)((ArrayList)localObject2).get(0)).uAl.nickname;
            int j = m;
            if (localObject1 != null)
            {
              if (((CharSequence)localObject1).length() <= 0) {
                break label559;
              }
              i = 1;
              label442:
              j = m;
              if (i == 1) {
                j = 1;
              }
            }
            if (j == 0) {}
          }
        }
        else
        {
          localObject1 = this.STk;
          if (localObject1 != null) {
            ((b)localObject1).hDz();
          }
        }
      }
      if (paramBoolean1)
      {
        localObject1 = this.STk;
        if (localObject1 != null) {
          ((b)localObject1).hDw();
        }
      }
      if ((((ArrayList)localObject2).isEmpty()) && (n > 0))
      {
        localObject1 = this.STk;
        if (localObject1 != null) {
          if (!paramBoolean2) {
            break label564;
          }
        }
      }
    }
    label554:
    label559:
    label564:
    for (int i = k;; i = 1)
    {
      ((b)localObject1).anY(i);
      AppMethodBeat.o(264122);
      return;
      this.STl = ((ArrayList)localObject2);
      break;
      i = 0;
      break label387;
      i = 0;
      break label442;
    }
  }
  
  private static final void c(d paramd)
  {
    AppMethodBeat.i(264209);
    s.u(paramd, "this$0");
    paramd = paramd.STk;
    if (paramd != null) {
      paramd.hDB();
    }
    AppMethodBeat.o(264209);
  }
  
  private static final void c(d paramd, String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(264205);
    s.u(paramd, "this$0");
    Log.i("MicroMsg.TaskBarViewPresenter", "received taskBarOnStorageChangeListener");
    paramd.hDU();
    if (paramMStorageEventData.eventId == 5)
    {
      if (paramMStorageEventData.obj != null)
      {
        paramString = paramMStorageEventData.obj;
        if (paramString == null)
        {
          paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.taskbar.TaskBarStorage.TaskBarDeleteNotify");
          AppMethodBeat.o(264205);
          throw paramd;
        }
        paramMStorageEventData = (h.b)paramString;
        if ((paramMStorageEventData.Jrn == 2) || (paramMStorageEventData.Jrn == 3))
        {
          paramString = paramMStorageEventData.LIj;
          if (paramString != null) {}
          for (;;)
          {
            paramd.a(paramString, 2, paramMStorageEventData.Jrn);
            AppMethodBeat.o(264205);
            return;
            s.bIx("multiTaskInfo");
            paramString = null;
          }
        }
      }
    }
    else if (paramMStorageEventData.eventId == 2)
    {
      paramString = paramMStorageEventData.obj;
      if (paramString == null)
      {
        paramd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.model.MultiTaskInfo");
        AppMethodBeat.o(264205);
        throw paramd;
      }
      paramd.a((MultiTaskInfo)paramString, 1, 1);
    }
    AppMethodBeat.o(264205);
  }
  
  private static final void d(d paramd)
  {
    AppMethodBeat.i(264227);
    s.u(paramd, "this$0");
    paramd.hDQ();
    AppMethodBeat.o(264227);
  }
  
  private final void hDQ()
  {
    try
    {
      AppMethodBeat.i(264132);
      Log.i("MicroMsg.TaskBarViewPresenter", "removeExceedData %d", new Object[] { Integer.valueOf(this.STo.size()) });
      Iterator localIterator = ((Iterable)this.STo).iterator();
      while (localIterator.hasNext())
      {
        MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)localIterator.next();
        ((PluginTaskBar)com.tencent.mm.kernel.h.az(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(localMultiTaskInfo);
        ((com.tencent.mm.plugin.taskbar.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.taskbar.c.class)).removeTaskInfo(localMultiTaskInfo.field_id, false, 4);
        a(localMultiTaskInfo, 2, 4);
      }
      this.STo.clear();
    }
    finally {}
    AppMethodBeat.o(264132);
  }
  
  private final boolean hDR()
  {
    int i;
    try
    {
      AppMethodBeat.i(264147);
      Object localObject1 = aob(4);
      if (localObject1 == null) {
        break label300;
      }
      localObject1 = ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).SUc;
      if (localObject1 == null) {
        break label300;
      }
      i = ((List)localObject1).size();
      long l1 = System.currentTimeMillis();
      long l2 = a.hDV();
      Iterator localIterator = ((List)localObject1).iterator();
      LinkedList localLinkedList = new LinkedList();
      while (localIterator.hasNext())
      {
        MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)localIterator.next();
        Log.i("MicroMsg.TaskBarViewPresenter", "item[" + localMultiTaskInfo.gkh().title + ", " + localMultiTaskInfo.field_id + "] time:" + localMultiTaskInfo.field_updateTime + " now:" + l1 + " limit:" + l2);
        if (l1 - localMultiTaskInfo.field_updateTime > l2)
        {
          localLinkedList.add(localMultiTaskInfo);
          localIterator.remove();
        }
      }
      com.tencent.threadpool.h.ahAA.bn(new d..ExternalSyntheticLambda8(localLinkedList, this));
    }
    finally {}
    Log.i("MicroMsg.TaskBarViewPresenter", "remove Timeout Data done " + i + ' ' + localObject2.size());
    boolean bool;
    if (i != localObject2.size())
    {
      bool = true;
      AppMethodBeat.o(264147);
    }
    for (;;)
    {
      return bool;
      AppMethodBeat.o(264147);
      bool = false;
      continue;
      label300:
      AppMethodBeat.o(264147);
      bool = false;
    }
  }
  
  private final MultiTaskInfo hDT()
  {
    AppMethodBeat.i(264155);
    Object localObject = aob(4);
    if (localObject == null)
    {
      AppMethodBeat.o(264155);
      return null;
    }
    localObject = ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject).SUc;
    if (localObject == null)
    {
      AppMethodBeat.o(264155);
      return null;
    }
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((MultiTaskInfo)localObject).field_type == 21)
      {
        i = 1;
        label81:
        if (i == 0) {
          break label101;
        }
      }
    }
    for (;;)
    {
      localObject = (MultiTaskInfo)localObject;
      AppMethodBeat.o(264155);
      return localObject;
      i = 0;
      break label81;
      label101:
      break;
      localObject = null;
    }
  }
  
  private static void lp(List<? extends AppBrandDesktopView.a> paramList)
  {
    AppMethodBeat.i(264104);
    s.u(paramList, "localUsageInfoList");
    if (!BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(264104);
      return;
    }
    Iterator localIterator = paramList.iterator();
    paramList = "";
    if (localIterator.hasNext())
    {
      AppBrandDesktopView.a locala = (AppBrandDesktopView.a)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder().append(paramList);
      paramList = locala.uAl;
      if (paramList == null) {}
      for (paramList = null;; paramList = paramList.nickname)
      {
        paramList = paramList + ' ';
        break;
      }
    }
    Log.i("MicroMsg.TaskBarViewPresenter", s.X("update WeApp Data ", paramList));
    AppMethodBeat.o(264104);
  }
  
  private static void lq(List<? extends LocalUsageInfo> paramList)
  {
    AppMethodBeat.i(264111);
    s.u(paramList, "localUsageInfoList");
    if (!BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(264111);
      return;
    }
    Iterator localIterator = paramList.iterator();
    paramList = "";
    if (localIterator.hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder().append(paramList);
      if (localLocalUsageInfo == null) {}
      for (paramList = null;; paramList = localLocalUsageInfo.nickname)
      {
        paramList = paramList + ' ';
        break;
      }
    }
    Log.i("MicroMsg.TaskBarViewPresenter", s.X("update WeApp Data locaList ", paramList));
    AppMethodBeat.o(264111);
  }
  
  public final void D(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(264448);
    if (paramView == null)
    {
      paramView = null;
      if ((paramView == null) || (paramView.getVisibility() != 0)) {
        break label61;
      }
      i = 1;
      label25:
      if (i != 0) {
        if (!paramBoolean) {
          break label66;
        }
      }
    }
    label61:
    label66:
    for (int i = 11;; i = 2)
    {
      R(1, i, null);
      AppMethodBeat.o(264448);
      return;
      paramView = paramView.findViewById(com.tencent.mm.plugin.taskbar.d.d.more);
      break;
      i = 0;
      break label25;
    }
  }
  
  public final void Fq(boolean paramBoolean)
  {
    AppMethodBeat.i(264401);
    int i8 = 0;
    int k = 0;
    int i9 = 0;
    int m = 0;
    int i10 = 0;
    int j = 0;
    int i11 = 0;
    int n = 0;
    int i12 = 0;
    int i = 0;
    int i13 = 0;
    int i1 = 0;
    Object localObject = (com.tencent.mm.plugin.taskbar.ui.section.d)this.STn.get(Integer.valueOf(4));
    int i2 = i13;
    int i3 = i12;
    int i4 = i11;
    int i5 = i9;
    int i6 = i8;
    int i7 = i10;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject).SUc;
      i2 = i13;
      i3 = i12;
      i4 = i11;
      i5 = i9;
      i6 = i8;
      i7 = i10;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        i2 = i1;
        i3 = i;
        i4 = n;
        i5 = m;
        i6 = k;
        i7 = j;
        if (((Iterator)localObject).hasNext())
        {
          switch (((MultiTaskInfo)((Iterator)localObject).next()).field_type)
          {
          }
          for (;;)
          {
            break;
            m += 1;
            break;
            k += 1;
            break;
            j += 1;
            break;
            n += 1;
            break;
            i1 += 1;
            break;
            i += 1;
          }
        }
      }
    }
    if (e.aTo())
    {
      i = 1;
      localObject = this.STr;
      if (!paramBoolean) {
        break label377;
      }
      j = 4;
      label309:
      if (this.STl.size() < 8) {
        break label382;
      }
      k = 8;
      label325:
      if (this.STm.size() < 8) {
        break label394;
      }
    }
    label394:
    for (m = 8;; m = this.STm.size())
    {
      ((a)localObject).a(j, i, k, i2, i5, i6, i3, i4, m, i7, 1);
      AppMethodBeat.o(264401);
      return;
      i = 0;
      break;
      label377:
      j = 1;
      break label309;
      label382:
      k = this.STl.size();
      break label325;
    }
  }
  
  public final void R(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(264436);
    this.STr.b(paramInt1, paramInt2, null, 1, paramString);
    AppMethodBeat.o(264436);
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    AppMethodBeat.i(264411);
    this.STu = paramInt;
    int i;
    if (!paramBoolean1) {
      i = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemClicked type:%d", new Object[] { Integer.valueOf(paramInt) });
      this.STr.a(paramInt, 0, "", i, paramString);
      AppMethodBeat.o(264411);
      return;
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
  
  public final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(264422);
    s.u(paramLocalUsageInfo, "appItem");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemReorderWeApp appId:%s,start:%d end:%d", new Object[] { paramLocalUsageInfo.appId, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramLocalUsageInfo = com.tencent.mm.plugin.multitask.g.gj(paramLocalUsageInfo.appId, paramLocalUsageInfo.euz);
    if (paramBoolean) {}
    for (;;)
    {
      this.STr.a(3, 0, 3, paramLocalUsageInfo, 0, i, paramInt1, paramInt2);
      AppMethodBeat.o(264422);
      return;
      i = 3;
    }
  }
  
  public final void a(LocalUsageInfo paramLocalUsageInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(264431);
    s.u(paramLocalUsageInfo, "appItem");
    paramLocalUsageInfo = com.tencent.mm.plugin.multitask.g.gj(paramLocalUsageInfo.appId, paramLocalUsageInfo.euz);
    if (paramBoolean) {}
    for (int i = 3;; i = 1)
    {
      d locald = new d();
      locald.STA = 1;
      locald.pageType = i;
      locald.vWA = paramLocalUsageInfo;
      this.STt.add(locald);
      AppMethodBeat.o(264431);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.taskbar.ui.section.d paramd)
  {
    for (;;)
    {
      int m;
      int i;
      int i1;
      int k;
      try
      {
        AppMethodBeat.i(264362);
        s.u(paramd, "viewModel");
        m = paramd.SUc.size();
        localObject1 = new ArrayList();
        Object localObject2 = com.tencent.mm.plugin.taskbar.ui.section.d.SUa;
        localObject2 = com.tencent.mm.plugin.taskbar.ui.section.d.a.hEh();
        this.STo.clear();
        int[] arrayOfInt = paramd.SUb;
        int n = arrayOfInt.length;
        i = 0;
        if (i < n)
        {
          j = arrayOfInt[i];
          Object localObject3 = com.tencent.mm.plugin.taskbar.ui.section.d.SUa;
          if ((com.tencent.mm.plugin.taskbar.ui.section.d.a.aog(j)) || (((ArrayList)localObject2).contains(Integer.valueOf(j))))
          {
            Log.i("MicroMsg.TaskBarViewPresenter", s.X("type blocked ", Integer.valueOf(j)));
            break label335;
          }
          localObject3 = ((com.tencent.mm.plugin.taskbar.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.taskbar.c.class)).getTaskInfoByType(j);
          i1 = ((List)localObject3).size();
          if (i1 <= 0) {
            break label335;
          }
          j = 0;
          k = j + 1;
          if (j <= 0) {
            ((ArrayList)localObject1).add(((List)localObject3).get(j));
          } else {
            this.STo.add(((List)localObject3).get(j));
          }
        }
      }
      finally {}
      p.a((List)localObject1, d..ExternalSyntheticLambda9.INSTANCE);
      Object localObject1 = (List)localObject1;
      s.u(localObject1, "<set-?>");
      paramd.SUc = ((List)localObject1);
      if ((m > 0) && (paramd.SUc.isEmpty()))
      {
        localObject1 = this.STk;
        if (localObject1 != null) {
          ((b)localObject1).anY(paramd.STX);
        }
      }
      Log.i("MicroMsg.TaskBarViewPresenter", "reloadOtherData " + paramd.STX + ' ' + m + ' ' + paramd.SUc.size());
      AppMethodBeat.o(264362);
      return;
      label335:
      do
      {
        i += 1;
        break;
      } while (k >= i1);
      int j = k;
    }
  }
  
  public final com.tencent.mm.plugin.taskbar.ui.section.d aob(int paramInt)
  {
    AppMethodBeat.i(264342);
    com.tencent.mm.plugin.taskbar.ui.section.d locald = (com.tencent.mm.plugin.taskbar.ui.section.d)this.STn.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(264342);
    return locald;
  }
  
  public final void bV(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(264354);
    Object localObject;
    if (paramBoolean)
    {
      localObject = hDO();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.appbrand.widget.recent.b)localObject).bS(((AppBrandDesktopView.a)this.STm.get(paramInt)).uAl.username, ((AppBrandDesktopView.a)this.STm.get(paramInt)).uAl.euz);
        AppMethodBeat.o(264354);
      }
    }
    else
    {
      localObject = hDN();
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.widget.recent.i)localObject).bT(((AppBrandDesktopView.a)this.STl.get(paramInt)).uAl.username, ((AppBrandDesktopView.a)this.STl.get(paramInt)).uAl.euz);
      }
    }
    AppMethodBeat.o(264354);
  }
  
  public final void cPw()
  {
    AppMethodBeat.i(264349);
    this.epi = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
    this.umi = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEr();
    Log.i("MicroMsg.TaskBarView", "alvinluo updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(this.epi), Integer.valueOf(this.umi) });
    AppMethodBeat.o(264349);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.recent.i hDN()
  {
    AppMethodBeat.i(264327);
    if (this.uPN == null) {
      this.uPN = com.tencent.mm.plugin.appbrand.widget.recent.c.uPM.cSJ();
    }
    com.tencent.mm.plugin.appbrand.widget.recent.i locali = this.uPN;
    AppMethodBeat.o(264327);
    return locali;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.recent.b hDO()
  {
    AppMethodBeat.i(264332);
    if (this.uPO == null) {
      this.uPO = com.tencent.mm.plugin.appbrand.widget.recent.c.uPM.cSK();
    }
    com.tencent.mm.plugin.appbrand.widget.recent.b localb = this.uPO;
    AppMethodBeat.o(264332);
    return localb;
  }
  
  public final boolean hDP()
  {
    return this.LHx == 0;
  }
  
  public final void hDS()
  {
    AppMethodBeat.i(264383);
    Log.i("MicroMsg.TaskBarViewPresenter", "onStartToPull");
    long l2 = System.currentTimeMillis();
    com.tencent.threadpool.h.ahAA.bn(new d..ExternalSyntheticLambda5(this));
    Object localObject1;
    if (hDR())
    {
      localObject1 = this.STk;
      if (localObject1 != null) {
        ((b)localObject1).hDA();
      }
    }
    localHashMap1 = new HashMap();
    localHashMap2 = new HashMap();
    localObject4 = hDT();
    if (localObject4 != null) {
      localObject1 = new bkg();
    }
    try
    {
      ((bkg)localObject1).parseFrom(((MultiTaskInfo)localObject4).field_data);
      if (((bkg)localObject1).ABJ == null) {
        break label194;
      }
      localObject5 = ((bkg)localObject1).ABJ;
      s.checkNotNull(localObject5);
      localHashMap1.put(Long.valueOf(((FinderObject)localObject5).id), localObject4);
      localObject4 = ((bkg)localObject1).ABJ;
      if (localObject4 != null) {
        break label306;
      }
      i = 2;
    }
    finally
    {
      for (;;)
      {
        Object localObject5;
        int i;
        long l1;
        Log.e("MicroMsg.TaskBarViewPresenter", "FinderLiveMultiTaskData parse failed");
        continue;
        localObject4 = ((FinderObject)localObject4).liveInfo;
        if (localObject4 == null)
        {
          i = 2;
        }
        else
        {
          i = ((bip)localObject4).liveStatus;
          continue;
          this.STp = l1;
          Log.i("MicroMsg.TaskBarViewPresenter", "start check live status");
          Object localObject3 = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
          s.s(localObject3, "plugin(IPluginFinderLive::class.java)");
          localObject5 = (com.tencent.d.a.a.a.b)localObject3;
          localObject3 = localHashMap2.values();
          s.s(localObject3, "objId2LiveDataNotEnded.values");
          localObject3 = (Iterable)localObject3;
          Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
          Iterator localIterator = ((Iterable)localObject3).iterator();
          if (localIterator.hasNext())
          {
            localObject3 = (bkg)localIterator.next();
            localObject4 = ((bkg)localObject3).ABJ;
            if (localObject4 == null)
            {
              l1 = 0L;
              localObject3 = ((bkg)localObject3).ABJ;
              if (localObject3 != null) {
                break label505;
              }
              localObject3 = "";
            }
            for (;;)
            {
              localCollection.add(new Pair(Long.valueOf(l1), localObject3));
              break;
              l1 = ((FinderObject)localObject4).id;
              break label455;
              localObject4 = ((FinderObject)localObject3).objectNonceId;
              localObject3 = localObject4;
              if (localObject4 == null) {
                localObject3 = "";
              }
            }
          }
          ((com.tencent.d.a.a.a.b)localObject5).batchGetLiveStatus(p.J((Collection)localCollection), (b.c)new e(this, localHashMap2, localHashMap1), null);
        }
      }
    }
    if (i != 2)
    {
      localObject4 = ((bkg)localObject1).ABJ;
      s.checkNotNull(localObject4);
      localHashMap2.put(Long.valueOf(((FinderObject)localObject4).id), localObject1);
    }
    label194:
    if (!localHashMap2.isEmpty())
    {
      l1 = System.currentTimeMillis() / 1000L;
      if (l1 - this.STp <= this.STq) {
        Log.i("MicroMsg.TaskBarViewPresenter", "not check because of interval: " + this.STq + " last:" + this.STp);
      }
    }
    else
    {
      Log.i("MicroMsg.TaskBarViewPresenter", s.X("onStartToPull done ", Long.valueOf(System.currentTimeMillis() - l2)));
      AppMethodBeat.o(264383);
      return;
    }
  }
  
  public final void hDU()
  {
    AppMethodBeat.i(264391);
    com.tencent.threadpool.h.ahAA.bn(new d..ExternalSyntheticLambda7(this, true));
    AppMethodBeat.o(264391);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "TAG", "", "getTimeoutInMs", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static long hDV()
    {
      AppMethodBeat.i(264156);
      long l = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zub, 3600L);
      AppMethodBeat.o(264156);
      return l * 1000L;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$IView;", "", "animateRemoveSection", "", "sectionType", "", "forceReloadData", "isHeaderOpen", "", "onDataUpdated", "onLiveStatusUpdated", "onTeenModeStatusChanged", "reloadDataIfNeed", "reloadOtherData", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void anY(int paramInt);
    
    public abstract boolean glK();
    
    public abstract void hDA();
    
    public abstract void hDB();
    
    public abstract void hDv();
    
    public abstract void hDw();
    
    public abstract void hDx();
    
    public abstract void hDz();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$LaunchAppBrandPreCheckCallback;", "", "onResult", "", "checkOk", "", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void cqs();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$TaskBarFeedAppearInfo;", "", "()V", "contentId", "", "getContentId", "()Ljava/lang/String;", "setContentId", "(Ljava/lang/String;)V", "expType", "", "getExpType", "()I", "setExpType", "(I)V", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "pageType", "getPageType", "setPageType", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    MultiTaskInfo LIj;
    int STA;
    int pageType;
    String vWA;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$checkLiveState$3", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderBatchLiveStatusCallback;", "onBatchLiveStatusCallback", "", "map", "", "", "", "intervalSec", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements b.c
  {
    e(d paramd, HashMap<Long, bkg> paramHashMap, HashMap<Long, MultiTaskInfo> paramHashMap1) {}
    
    public final void e(Map<Long, Integer> paramMap, int paramInt)
    {
      AppMethodBeat.i(264171);
      s.u(paramMap, "map");
      if (paramInt > 0)
      {
        Log.i("MicroMsg.TaskBarViewPresenter", s.X("new interval:", Integer.valueOf(paramInt)));
        d.a(this.STB, paramInt);
      }
      HashMap localHashMap1 = localHashMap2;
      HashMap localHashMap2 = localHashMap1;
      Iterator localIterator = paramMap.entrySet().iterator();
      paramInt = 0;
      if (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        if (((Number)((Map.Entry)localObject1).getValue()).intValue() != 2) {
          break label273;
        }
        paramMap = (bkg)localHashMap1.get(((Map.Entry)localObject1).getKey());
        if (paramMap != null)
        {
          localObject2 = paramMap.ABJ;
          if (localObject2 != null)
          {
            localObject2 = ((FinderObject)localObject2).liveInfo;
            if (localObject2 != null) {
              ((bip)localObject2).liveStatus = 2;
            }
          }
        }
        Object localObject2 = (MultiTaskInfo)localHashMap2.get(((Map.Entry)localObject1).getKey());
        if (localObject2 == null) {
          break label273;
        }
        Log.i("MicroMsg.TaskBarViewPresenter", s.X("live end: ", ((MultiTaskInfo)localObject2).gkh().nickname));
        if (paramMap == null)
        {
          paramMap = null;
          label194:
          localObject1 = paramMap;
          if (paramMap == null) {
            localObject1 = ((MultiTaskInfo)localObject2).field_data;
          }
          ((MultiTaskInfo)localObject2).field_data = ((byte[])localObject1);
          ((com.tencent.mm.plugin.taskbar.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.taskbar.c.class)).removeTaskInfo(((MultiTaskInfo)localObject2).field_id, true, 2);
          paramInt = 1;
        }
      }
      label273:
      for (;;)
      {
        break;
        paramMap = paramMap.toByteArray();
        break label194;
        if (paramInt != 0)
        {
          paramMap = d.e(this.STB);
          if (paramMap != null) {
            paramMap.hDv();
          }
        }
        AppMethodBeat.o(264171);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.d
 * JD-Core Version:    0.7.0.1
 */
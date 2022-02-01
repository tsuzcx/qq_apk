package com.tencent.mm.plugin.taskbar.ui;

import android.util.Pair;
import com.tencent.c.a.a.a.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.lk;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.a;
import com.tencent.mm.plugin.appbrand.widget.recent.m;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.h.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.Long;Ljava.lang.Integer;>;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter;", "", "()V", "closePageType", "", "collectionStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "getCollectionStorage", "()Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandCollectionStorageWithCache;", "currentTabIndex", "exceedOtherData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "firstFeedShowInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$TaskBarFeedAppearInfo;", "homeTabChangedListener", "com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1;", "isTeenMode", "", "()Z", "setTeenMode", "(Z)V", "lastLiveCheckTimeSec", "", "lastStartTime", "liveCheckIntervalSec", "miniProgramOption", "getMiniProgramOption", "()I", "setMiniProgramOption", "(I)V", "myWeAppOnStorageChangeListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "sectionDataMyWeApp", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "getSectionDataMyWeApp", "()Ljava/util/ArrayList;", "setSectionDataMyWeApp", "(Ljava/util/ArrayList;)V", "sectionDataWeApp", "getSectionDataWeApp", "setSectionDataWeApp", "sectionViewModelMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "Lkotlin/collections/HashMap;", "taskBarOnStorageChangeListener", "taskBarReporter", "Lcom/tencent/mm/plugin/taskbar/report/TaskBarReporter;", "taskBarUpdateEventListener", "com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$taskBarUpdateEventListener$1", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$taskBarUpdateEventListener$1;", "teenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "getUsageStorage", "()Lcom/tencent/mm/plugin/appbrand/widget/recent/AppBrandUsageStorageWithCache;", "view", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$IView;", "viewDuration", "weAppOnStorageChangeListener", "canLaunchAppBrand", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "appInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaAppInfo;", "checkLaunchAppBrand", "", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$LaunchAppBrandPreCheckCallback;", "checkLiveState", "clearPendingShowInfo", "getAppIdList", "", "appBrandItems", "", "getLiveTaskInfo", "getViewModelBySectionType", "sectionType", "isOnMainTab", "onCreate", "onDestroy", "onDidAppear", "onDidClose", "reason", "isDesktop", "isMyDesktop", "onOpenHeader", "onPause", "onResume", "onStartToPull", "onViewDestroy", "reloadData", "notify", "reloadOtherData", "viewModel", "reloadWeAppData", "isMy", "removeExceedData", "removeTimeoutData", "removeWeAppData", "pos", "reportDesktopAppear", "isMyWeApp", "count", "reportOnFirstFeedShow", "reportOnItemAddDeleted", "appItem", "actionType", "actionChannel", "multiTaskInfo", "reportOnItemAppear", "isLoadMore", "reportOnItemClicked", "isMyWeapp", "itemType", "reportOnItemManualAddDeleteMyWeApp", "insert", "page", "reportOnItemReorderWeApp", "startPos", "endPos", "reportTaskBarAppear", "isBackFromDesktop", "reportTaskBarClose", "closeType", "updateTeenModeStatus", "Companion", "IView", "LaunchAppBrandPreCheckCallback", "TaskBarFeedAppearInfo", "plugin-taskbar_release"})
public final class d
{
  public static final d.a Mqf;
  private int FMs;
  public b MpP;
  ArrayList<AppBrandDesktopView.a> MpQ;
  ArrayList<AppBrandDesktopView.a> MpR;
  private final HashMap<Integer, com.tencent.mm.plugin.taskbar.ui.section.d> MpS;
  private final LinkedList<MultiTaskInfo> MpT;
  private long MpU;
  private int MpV;
  com.tencent.mm.plugin.taskbar.a.a MpW;
  public long MpX;
  ArrayList<d> MpY;
  int MpZ;
  public final MStorage.IOnStorageChange Mqa;
  public final MStorage.IOnStorageChange Mqb;
  public final n Mqc;
  public final MStorage.IOnStorageChange Mqd;
  public final g Mqe;
  boolean lsi;
  public final com.tencent.mm.plugin.teenmode.a.c nCC;
  public long pZO;
  private com.tencent.mm.plugin.appbrand.widget.recent.b rEA;
  private com.tencent.mm.plugin.appbrand.widget.recent.i rEz;
  int rec;
  
  static
  {
    AppMethodBeat.i(215527);
    Mqf = new d.a((byte)0);
    AppMethodBeat.o(215527);
  }
  
  public d()
  {
    AppMethodBeat.i(215526);
    this.MpQ = new ArrayList();
    this.MpR = new ArrayList();
    this.MpT = new LinkedList();
    this.MpV = 60;
    this.MpW = new com.tencent.mm.plugin.taskbar.a.a();
    this.MpY = new ArrayList();
    this.Mqa = ((MStorage.IOnStorageChange)new p(this));
    this.Mqb = ((MStorage.IOnStorageChange)new h(this));
    this.Mqc = new n(this);
    this.Mqd = ((MStorage.IOnStorageChange)new m(this));
    this.Mqe = new g(this);
    this.nCC = ((com.tencent.mm.plugin.teenmode.a.c)new o(this));
    this.MpS = ae.g(new o[] { s.M(Integer.valueOf(4), new com.tencent.mm.plugin.taskbar.ui.section.d(4, new int[] { 2, 21, 22, 6, 4, 3 })) });
    this.Mqe.alive();
    this.Mqc.alive();
    Object localObject = gjM();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recent.i)localObject).add(this.Mqa);
    }
    localObject = gjN();
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.widget.recent.b)localObject).add(this.Mqb);
    }
    localObject = ((PluginTaskBar)com.tencent.mm.kernel.h.ag(PluginTaskBar.class)).getTaskBarStorage();
    if (localObject != null) {
      ((com.tencent.mm.plugin.taskbar.h)localObject).add(this.Mqd);
    }
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).a(this.nCC);
    AppMethodBeat.o(215526);
  }
  
  private final void gjP()
  {
    try
    {
      AppMethodBeat.i(215511);
      Log.i("MicroMsg.TaskBarViewPresenter", "removeExceedData %d", new Object[] { Integer.valueOf(this.MpT.size()) });
      Iterator localIterator = ((Iterable)this.MpT).iterator();
      while (localIterator.hasNext())
      {
        MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)localIterator.next();
        ((PluginTaskBar)com.tencent.mm.kernel.h.ag(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(localMultiTaskInfo);
        ((com.tencent.mm.plugin.taskbar.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.taskbar.c.class)).removeTaskInfo(localMultiTaskInfo.field_id, false, 4);
        a(localMultiTaskInfo, 2, 4);
      }
      this.MpT.clear();
    }
    finally {}
    AppMethodBeat.o(215511);
  }
  
  private final boolean gjQ()
  {
    int i;
    try
    {
      AppMethodBeat.i(215513);
      Object localObject1 = aiZ(4);
      if (localObject1 == null) {
        break label303;
      }
      localObject1 = ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject1).MqU;
      if (localObject1 == null) {
        break label303;
      }
      i = ((List)localObject1).size();
      long l1 = System.currentTimeMillis();
      long l2 = d.a.gjV();
      Iterator localIterator = ((List)localObject1).iterator();
      LinkedList localLinkedList = new LinkedList();
      while (localIterator.hasNext())
      {
        MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)localIterator.next();
        Log.i("MicroMsg.TaskBarViewPresenter", "item[" + localMultiTaskInfo.fbc().title + ", " + localMultiTaskInfo.field_id + "] time:" + localMultiTaskInfo.field_updateTime + " now:" + l1 + " limit:" + l2);
        if (l1 - localMultiTaskInfo.field_updateTime > l2)
        {
          localLinkedList.add(localMultiTaskInfo);
          localIterator.remove();
        }
      }
      com.tencent.e.h.ZvG.bf((Runnable)new l(localLinkedList, this));
    }
    finally {}
    Log.i("MicroMsg.TaskBarViewPresenter", "remove Timeout Data done " + i + ' ' + localObject2.size());
    boolean bool;
    if (i != localObject2.size())
    {
      bool = true;
      AppMethodBeat.o(215513);
    }
    for (;;)
    {
      return bool;
      AppMethodBeat.o(215513);
      bool = false;
      continue;
      label303:
      AppMethodBeat.o(215513);
      bool = false;
    }
  }
  
  private final MultiTaskInfo gjS()
  {
    AppMethodBeat.i(215517);
    Object localObject = aiZ(4);
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject).MqU;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        int i;
        if (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if (((MultiTaskInfo)localObject).field_type == 21)
          {
            i = 1;
            label65:
            if (i == 0) {
              break label85;
            }
          }
        }
        for (;;)
        {
          localObject = (MultiTaskInfo)localObject;
          AppMethodBeat.o(215517);
          return localObject;
          i = 0;
          break label65;
          label85:
          break;
          localObject = null;
        }
      }
    }
    AppMethodBeat.o(215517);
    return null;
  }
  
  private final void gjT()
  {
    AppMethodBeat.i(215519);
    final HashMap localHashMap1 = new HashMap();
    final HashMap localHashMap2 = new HashMap();
    Object localObject2 = gjS();
    bbf localbbf;
    if (localObject2 != null) {
      localbbf = new bbf();
    }
    try
    {
      localbbf.parseFrom(((MultiTaskInfo)localObject2).field_data);
      if (localbbf.xcx == null) {
        break label160;
      }
      localObject3 = localbbf.xcx;
      if (localObject3 == null) {
        p.iCn();
      }
      localHashMap1.put(Long.valueOf(((FinderObject)localObject3).id), localObject2);
      localObject2 = localbbf.xcx;
      if (localObject2 == null) {
        break label189;
      }
      localObject2 = ((FinderObject)localObject2).liveInfo;
      if (localObject2 == null) {
        break label189;
      }
      i = ((bac)localObject2).liveStatus;
    }
    catch (Throwable localThrowable)
    {
      Object localObject3;
      for (;;)
      {
        Log.e("MicroMsg.TaskBarViewPresenter", "FinderLiveMultiTaskData parse failed");
        continue;
        int i = 2;
      }
      long l = System.currentTimeMillis() / 1000L;
      if (l - this.MpU > this.MpV) {
        break label263;
      }
      Log.i("MicroMsg.TaskBarViewPresenter", "not check because of interval: " + this.MpV + " last:" + this.MpU);
      AppMethodBeat.o(215519);
      return;
      this.MpU = l;
      Log.i("MicroMsg.TaskBarViewPresenter", "start check live status");
      com.tencent.c.a.a.a.b localb = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
      Object localObject1 = localHashMap2.values();
      p.j(localObject1, "objId2LiveDataNotEnded.values");
      localObject1 = (Iterable)localObject1;
      Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (!localIterator.hasNext()) {
        break label446;
      }
      localObject2 = (bbf)localIterator.next();
      localObject1 = ((bbf)localObject2).xcx;
      if (localObject1 == null) {
        break label437;
      }
      for (localObject1 = Long.valueOf(((FinderObject)localObject1).id);; localObject1 = Long.valueOf(0L))
      {
        localObject2 = ((bbf)localObject2).xcx;
        if (localObject2 != null)
        {
          localObject3 = ((FinderObject)localObject2).objectNonceId;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        localCollection.add(new Pair(localObject1, localObject2));
        break;
      }
      localb.batchGetLiveStatus(kotlin.a.j.t((Collection)localCollection), (b.c)new f(this, localHashMap2, localHashMap1));
      AppMethodBeat.o(215519);
    }
    if (i != 2)
    {
      localObject2 = localbbf.xcx;
      if (localObject2 == null) {
        p.iCn();
      }
      localHashMap2.put(Long.valueOf(((FinderObject)localObject2).id), localbbf);
    }
    label160:
    if (localHashMap2.isEmpty())
    {
      AppMethodBeat.o(215519);
      return;
    }
    label189:
    label446:
    return;
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(215525);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAddDeleted type:%d,pos:%d", new Object[] { Integer.valueOf(paramMultiTaskInfo.field_type), Integer.valueOf(0) });
    if (paramInt1 == 2) {}
    for (long l = cm.bfE() - paramMultiTaskInfo.field_updateTime;; l = 0L)
    {
      this.MpW.a(paramInt1, paramInt2, com.tencent.mm.plugin.taskbar.a.a.RC(paramMultiTaskInfo.field_type), paramMultiTaskInfo.field_id, (int)l / 1000, 1, 0, 0);
      AppMethodBeat.o(215525);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.taskbar.ui.section.d paramd)
  {
    for (;;)
    {
      int k;
      int i;
      int j;
      try
      {
        AppMethodBeat.i(215509);
        p.k(paramd, "viewModel");
        k = paramd.MqU.size();
        localObject1 = new ArrayList();
        Object localObject2 = com.tencent.mm.plugin.taskbar.ui.section.d.MqY;
        localObject2 = com.tencent.mm.plugin.taskbar.ui.section.d.a.gki();
        this.MpT.clear();
        int[] arrayOfInt = paramd.MqW;
        int m = arrayOfInt.length;
        i = 0;
        if (i < m)
        {
          j = arrayOfInt[i];
          Object localObject3 = com.tencent.mm.plugin.taskbar.ui.section.d.MqY;
          if ((com.tencent.mm.plugin.taskbar.ui.section.d.a.aje(j)) || (((ArrayList)localObject2).contains(Integer.valueOf(j))))
          {
            Log.i("MicroMsg.TaskBarViewPresenter", "type blocked ".concat(String.valueOf(j)));
            break label334;
          }
          localObject3 = ((com.tencent.mm.plugin.taskbar.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.taskbar.c.class)).getTaskInfoByType(j);
          int n = ((List)localObject3).size();
          j = 0;
          if (j >= n) {
            break label334;
          }
          if (j <= 0) {
            ((ArrayList)localObject1).add(((List)localObject3).get(j));
          } else {
            this.MpT.add(((List)localObject3).get(j));
          }
        }
      }
      finally {}
      kotlin.a.j.a((List)localObject1, (Comparator)k.Mqo);
      Object localObject1 = (List)localObject1;
      p.k(localObject1, "<set-?>");
      paramd.MqU = ((List)localObject1);
      if ((k > 0) && (paramd.MqU.isEmpty()))
      {
        localObject1 = this.MpP;
        if (localObject1 != null) {
          ((b)localObject1).aiW(paramd.MqM);
        }
      }
      Log.i("MicroMsg.TaskBarViewPresenter", "reloadOtherData " + paramd.MqM + ' ' + k + ' ' + paramd.MqU.size());
      AppMethodBeat.o(215509);
      return;
      label334:
      i += 1;
      continue;
      j += 1;
    }
  }
  
  final boolean a(LocalUsageInfo paramLocalUsageInfo, WxaAttributes.a parama)
  {
    if ((parama.serviceType != 0) && (parama.serviceType != 4)) {}
    do
    {
      return true;
      if (this.rec == 0) {
        return paramLocalUsageInfo.nQn;
      }
    } while (this.rec != 2);
    return false;
  }
  
  public final void aK(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 2;
    int m = 0;
    AppMethodBeat.i(215507);
    int n;
    label83:
    boolean bool;
    if (paramBoolean2)
    {
      localObject = this.MpR;
      n = ((ArrayList)localObject).size();
      if (n <= 0) {
        break label211;
      }
      localObject = ((ArrayList)localObject).get(0);
      p.j(localObject, "oldSectionData[0]");
      localObject = (CharSequence)((AppBrandDesktopView.a)localObject).cnz().nickname;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label206;
      }
      i = 1;
      if (i == 0) {
        break label211;
      }
      bool = true;
      label90:
      Log.i("MicroMsg.TaskBarViewPresenter", "update WeApp Data " + n + ' ' + paramBoolean1 + ' ' + paramBoolean2 + ' ' + bool);
      if (!paramBoolean2) {
        break label223;
      }
      localObject = gjN();
      if (localObject == null) {
        break label217;
      }
    }
    label206:
    label211:
    label217:
    for (Object localObject = ((com.tencent.mm.plugin.appbrand.widget.recent.b)localObject).a(com.tencent.mm.plugin.appbrand.widget.recent.h.rEJ.count, com.tencent.mm.plugin.appbrand.widget.recent.h.rEJ.nQx);; localObject = null)
    {
      if (localObject != null) {
        break label263;
      }
      Log.w("MicroMsg.TaskBarViewPresenter", "usageStorage is null");
      AppMethodBeat.o(215507);
      return;
      localObject = this.MpQ;
      break;
      i = 0;
      break label83;
      bool = false;
      break label90;
    }
    label223:
    localObject = gjM();
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.appbrand.widget.recent.i)localObject).zh(com.tencent.mm.plugin.appbrand.widget.recent.h.rEK.count);; localObject = null)
    {
      localObject = ag.ff(localObject);
      break;
    }
    label263:
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject).next();
      if (i < 10)
      {
        if (paramBoolean2) {}
        for (int j = 2;; j = 1)
        {
          localArrayList.add(new AppBrandDesktopView.a(localLocalUsageInfo, j));
          i += 1;
          break;
        }
      }
    }
    if (paramBoolean2)
    {
      this.MpR = localArrayList;
      Log.i("MicroMsg.TaskBarViewPresenter", "update WeApp Data Done " + localArrayList.size());
      if (((Collection)localArrayList).isEmpty()) {
        break label566;
      }
      i = 1;
      label400:
      if (i != 0) {
        if (n != 0)
        {
          if (bool)
          {
            localObject = localArrayList.get(0);
            p.j(localObject, "tempList[0]");
            localObject = ((AppBrandDesktopView.a)localObject).cnz().nickname;
            if (localObject != null)
            {
              i = m;
              if (((CharSequence)localObject).length() > 0) {
                i = 1;
              }
              if (i != 1) {}
            }
          }
        }
        else
        {
          localObject = this.MpP;
          if (localObject != null) {
            ((b)localObject).gjy();
          }
        }
      }
      if (paramBoolean1)
      {
        localObject = this.MpP;
        if (localObject != null) {
          ((b)localObject).gjv();
        }
      }
      if ((!localArrayList.isEmpty()) || (n <= 0)) {
        break label576;
      }
      localObject = this.MpP;
      if (localObject == null) {
        break label576;
      }
      if (!paramBoolean2) {
        break label571;
      }
    }
    label566:
    label571:
    for (i = k;; i = 1)
    {
      ((b)localObject).aiW(i);
      AppMethodBeat.o(215507);
      return;
      this.MpQ = localArrayList;
      break;
      i = 0;
      break label400;
    }
    label576:
    AppMethodBeat.o(215507);
  }
  
  public final com.tencent.mm.plugin.taskbar.ui.section.d aiZ(int paramInt)
  {
    AppMethodBeat.i(215497);
    com.tencent.mm.plugin.taskbar.ui.section.d locald = (com.tencent.mm.plugin.taskbar.ui.section.d)this.MpS.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(215497);
    return locald;
  }
  
  public final void bn(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(215504);
    Object localObject2;
    Object localObject3;
    if (paramBoolean)
    {
      localObject1 = gjN();
      if (localObject1 != null)
      {
        localObject2 = this.MpR.get(paramInt);
        p.j(localObject2, "sectionDataMyWeApp[pos]");
        localObject2 = ((AppBrandDesktopView.a)localObject2).cnz().username;
        localObject3 = this.MpR.get(paramInt);
        p.j(localObject3, "sectionDataMyWeApp[pos]");
        ((com.tencent.mm.plugin.appbrand.widget.recent.b)localObject1).bA((String)localObject2, ((AppBrandDesktopView.a)localObject3).cnz().cBU);
        AppMethodBeat.o(215504);
        return;
      }
      AppMethodBeat.o(215504);
      return;
    }
    Object localObject1 = gjM();
    if (localObject1 != null)
    {
      localObject2 = this.MpQ.get(paramInt);
      p.j(localObject2, "sectionDataWeApp[pos]");
      localObject2 = ((AppBrandDesktopView.a)localObject2).cnz().username;
      localObject3 = this.MpQ.get(paramInt);
      p.j(localObject3, "sectionDataWeApp[pos]");
      ((com.tencent.mm.plugin.appbrand.widget.recent.i)localObject1).bB((String)localObject2, ((AppBrandDesktopView.a)localObject3).cnz().cBU);
      AppMethodBeat.o(215504);
      return;
    }
    AppMethodBeat.o(215504);
  }
  
  public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215523);
    this.MpZ = paramInt;
    int i;
    if (!paramBoolean1) {
      i = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemClicked type:%d", new Object[] { Integer.valueOf(paramInt) });
      this.MpW.g(paramInt, 0, "", i);
      AppMethodBeat.o(215523);
      return;
      if (paramBoolean2) {
        i = 3;
      } else {
        i = 2;
      }
    }
  }
  
  public final void cnt()
  {
    AppMethodBeat.i(215501);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    this.lsi = ((com.tencent.mm.plugin.teenmode.a.b)locala).ZM();
    locala = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    this.rec = ((com.tencent.mm.plugin.teenmode.a.b)locala).gks();
    Log.i("MicroMsg.TaskBarView", "alvinluo updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(this.lsi), Integer.valueOf(this.rec) });
    AppMethodBeat.o(215501);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.recent.i gjM()
  {
    AppMethodBeat.i(215490);
    if (this.rEz == null) {
      this.rEz = com.tencent.mm.plugin.appbrand.widget.recent.c.rEB.cqe();
    }
    com.tencent.mm.plugin.appbrand.widget.recent.i locali = this.rEz;
    AppMethodBeat.o(215490);
    return locali;
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.recent.b gjN()
  {
    AppMethodBeat.i(215493);
    if (this.rEA == null) {
      this.rEA = com.tencent.mm.plugin.appbrand.widget.recent.c.rEB.cqf();
    }
    com.tencent.mm.plugin.appbrand.widget.recent.b localb = this.rEA;
    AppMethodBeat.o(215493);
    return localb;
  }
  
  public final boolean gjO()
  {
    return this.FMs == 0;
  }
  
  public final void gjR()
  {
    AppMethodBeat.i(215515);
    Log.i("MicroMsg.TaskBarViewPresenter", "onStartToPull");
    long l = System.currentTimeMillis();
    com.tencent.e.h.ZvG.bf((Runnable)new i(this));
    if (gjQ())
    {
      b localb = this.MpP;
      if (localb != null) {
        localb.gjA();
      }
    }
    gjT();
    Log.i("MicroMsg.TaskBarViewPresenter", "onStartToPull done " + (System.currentTimeMillis() - l));
    AppMethodBeat.o(215515);
  }
  
  public final void gjU()
  {
    AppMethodBeat.i(215521);
    com.tencent.e.h.ZvG.bf((Runnable)new j(this));
    AppMethodBeat.o(215521);
  }
  
  public final void zZ(boolean paramBoolean)
  {
    AppMethodBeat.i(215522);
    int k = 0;
    int i3 = 0;
    int j = 0;
    int i2 = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    int i1 = 0;
    Object localObject = (com.tencent.mm.plugin.taskbar.ui.section.d)this.MpS.get(Integer.valueOf(4));
    label236:
    label249:
    int i4;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.taskbar.ui.section.d)localObject).MqU;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        k = i3;
        j = i2;
        if (((Iterator)localObject).hasNext())
        {
          switch (((MultiTaskInfo)((Iterator)localObject).next()).field_type)
          {
          }
          for (;;)
          {
            break;
            j += 1;
            break;
            k += 1;
            break;
            m += 1;
            break;
            n += 1;
            break;
            i1 += 1;
            break;
            i += 1;
          }
        }
        i2 = i1;
        i1 = m;
        m = i;
        i = i2;
        if (!e.aAt()) {
          break label326;
        }
        i2 = 1;
        localObject = this.MpW;
        if (!paramBoolean) {
          break label332;
        }
        i3 = 4;
        if (this.MpQ.size() < 8) {
          break label338;
        }
        i4 = 8;
        label265:
        if (this.MpR.size() < 8) {
          break label350;
        }
      }
    }
    label326:
    label332:
    label338:
    label350:
    for (int i5 = 8;; i5 = this.MpR.size())
    {
      ((com.tencent.mm.plugin.taskbar.a.a)localObject).a(i3, i2, i4, i, j, k, m, n, i5, i1, 1);
      AppMethodBeat.o(215522);
      return;
      i = 0;
      m = 0;
      n = 0;
      i1 = 0;
      break;
      i2 = 0;
      break label236;
      i3 = 1;
      break label249;
      i4 = this.MpQ.size();
      break label265;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$IView;", "", "animateRemoveSection", "", "sectionType", "", "forceReloadData", "isHeaderOpen", "", "onDataUpdated", "onLiveStatusUpdated", "onTeenModeStatusChanged", "reloadDataIfNeed", "reloadOtherData", "plugin-taskbar_release"})
  public static abstract interface b
  {
    public abstract void aiW(int paramInt);
    
    public abstract boolean fcH();
    
    public abstract void gjA();
    
    public abstract void gjB();
    
    public abstract void gju();
    
    public abstract void gjv();
    
    public abstract void gjw();
    
    public abstract void gjy();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$LaunchAppBrandPreCheckCallback;", "", "onResult", "", "checkOk", "", "plugin-taskbar_release"})
  public static abstract interface c
  {
    public abstract void ep(boolean paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$TaskBarFeedAppearInfo;", "", "()V", "contentId", "", "getContentId", "()Ljava/lang/String;", "setContentId", "(Ljava/lang/String;)V", "expType", "", "getExpType", "()I", "setExpType", "(I)V", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "pageType", "getPageType", "setPageType", "plugin-taskbar_release"})
  public static final class d
  {
    MultiTaskInfo FNi;
    int Mqg;
    int pageType;
    String sQY;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "wxaAttributes", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
  static final class e
    implements q.a
  {
    e(d paramd, d.c paramc, LocalUsageInfo paramLocalUsageInfo) {}
    
    public final void b(WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(214728);
      if ((paramWxaAttributes != null) && (this.Mqi != null))
      {
        d.c localc = this.Mqi;
        d locald = this.Mqh;
        LocalUsageInfo localLocalUsageInfo = this.Mqj;
        paramWxaAttributes = paramWxaAttributes.bLF();
        p.j(paramWxaAttributes, "wxaAttributes.appInfo");
        localc.ep(d.a(locald, localLocalUsageInfo, paramWxaAttributes));
      }
      AppMethodBeat.o(214728);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$checkLiveState$3", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderBatchLiveStatusCallback;", "onBatchLiveStatusCallback", "", "map", "", "", "", "intervalSec", "plugin-taskbar_release"})
  public static final class f
    implements b.c
  {
    f(HashMap paramHashMap1, HashMap paramHashMap2) {}
    
    public final void f(Map<Long, Integer> paramMap, int paramInt)
    {
      AppMethodBeat.i(215585);
      p.k(paramMap, "map");
      if (paramInt > 0)
      {
        Log.i("MicroMsg.TaskBarViewPresenter", "new interval:".concat(String.valueOf(paramInt)));
        d.a(this.Mqh, paramInt);
      }
      Iterator localIterator = paramMap.entrySet().iterator();
      paramInt = 0;
      while (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        if (((Number)((Map.Entry)localObject1).getValue()).intValue() == 2)
        {
          paramMap = (bbf)localHashMap2.get(((Map.Entry)localObject1).getKey());
          if (paramMap != null)
          {
            localObject2 = paramMap.xcx;
            if (localObject2 != null)
            {
              localObject2 = ((FinderObject)localObject2).liveInfo;
              if (localObject2 != null) {
                ((bac)localObject2).liveStatus = 2;
              }
            }
          }
          Object localObject2 = (MultiTaskInfo)localHashMap1.get(((Map.Entry)localObject1).getKey());
          if (localObject2 != null)
          {
            localObject1 = new StringBuilder("live end: ");
            p.j(localObject2, "taskInfo");
            Log.i("MicroMsg.TaskBarViewPresenter", ((MultiTaskInfo)localObject2).fbc().nickname);
            if (paramMap != null)
            {
              localObject1 = paramMap.toByteArray();
              paramMap = (Map<Long, Integer>)localObject1;
              if (localObject1 != null) {}
            }
            else
            {
              paramMap = ((MultiTaskInfo)localObject2).field_data;
            }
            ((MultiTaskInfo)localObject2).field_data = paramMap;
            ((com.tencent.mm.plugin.taskbar.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.taskbar.c.class)).removeTaskInfo(((MultiTaskInfo)localObject2).field_id, true, 2);
            paramInt = 1;
          }
        }
      }
      if (paramInt != 0)
      {
        paramMap = d.b(this.Mqh);
        if (paramMap != null)
        {
          paramMap.gju();
          AppMethodBeat.o(215585);
          return;
        }
      }
      AppMethodBeat.o(215585);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-taskbar_release"})
  public static final class g
    extends IListener<lk>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class h
    implements MStorage.IOnStorageChange
  {
    h(d paramd) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(214388);
      com.tencent.e.h.ZvG.bf((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215432);
          Log.i("MicroMsg.TaskBarViewPresenter", "received myWeAppOnStorageChangeListener");
          this.Mqm.Mqh.aK(true, true);
          AppMethodBeat.o(215432);
        }
      });
      AppMethodBeat.o(214388);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(215673);
      d.a(this.Mqh);
      AppMethodBeat.o(215673);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(214427);
      Log.i("MicroMsg.TaskBarViewPresenter", "do reload data");
      this.Mqh.aK(false, false);
      this.Mqh.aK(false, true);
      Object localObject = (com.tencent.mm.plugin.taskbar.ui.section.d)d.c(this.Mqh).get(Integer.valueOf(4));
      if (localObject != null)
      {
        d locald = this.Mqh;
        p.j(localObject, "it");
        locald.a((com.tencent.mm.plugin.taskbar.ui.section.d)localObject);
      }
      if (this.Mqn)
      {
        localObject = d.b(this.Mqh);
        if (localObject != null)
        {
          ((d.b)localObject).gjv();
          AppMethodBeat.o(214427);
          return;
        }
      }
      AppMethodBeat.o(214427);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "kotlin.jvm.PlatformType", "o2", "compare"})
  static final class k<T>
    implements Comparator<MultiTaskInfo>
  {
    public static final k Mqo;
    
    static
    {
      AppMethodBeat.i(215738);
      Mqo = new k();
      AppMethodBeat.o(215738);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$removeTimeoutData$1$1"})
  static final class l
    implements Runnable
  {
    l(LinkedList paramLinkedList, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(214705);
      Log.i("MicroMsg.TaskBarViewPresenter", "async remove timeout taskbar item");
      Iterator localIterator = ((Iterable)this.Mqp).iterator();
      while (localIterator.hasNext())
      {
        MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)localIterator.next();
        jdField_this.a(localMultiTaskInfo, 2, 5);
        ((PluginTaskBar)com.tencent.mm.kernel.h.ag(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(localMultiTaskInfo);
        ((com.tencent.mm.plugin.taskbar.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.taskbar.c.class)).removeTaskInfo(localMultiTaskInfo.field_id, false, 5);
      }
      AppMethodBeat.o(214705);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class m
    implements MStorage.IOnStorageChange
  {
    m(d paramd) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(214250);
      Log.i("MicroMsg.TaskBarViewPresenter", "received taskBarOnStorageChangeListener");
      this.Mqh.gjU();
      if (paramMStorageEventData.eventId == 5)
      {
        if (paramMStorageEventData.obj != null)
        {
          paramString = paramMStorageEventData.obj;
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.taskbar.TaskBarStorage.TaskBarDeleteNotify");
            AppMethodBeat.o(214250);
            throw paramString;
          }
          paramString = (h.b)paramString;
          if ((paramString.Dyj == 2) || (paramString.Dyj == 3))
          {
            paramMStorageEventData = this.Mqh;
            MultiTaskInfo localMultiTaskInfo = paramString.FNi;
            if (localMultiTaskInfo == null) {
              p.bGy("multiTaskInfo");
            }
            paramMStorageEventData.a(localMultiTaskInfo, 2, paramString.Dyj);
            AppMethodBeat.o(214250);
          }
        }
      }
      else if (paramMStorageEventData.eventId == 2)
      {
        paramString = this.Mqh;
        paramMStorageEventData = paramMStorageEventData.obj;
        if (paramMStorageEventData == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.model.MultiTaskInfo");
          AppMethodBeat.o(214250);
          throw paramString;
        }
        paramString.a((MultiTaskInfo)paramMStorageEventData, 1, 1);
      }
      AppMethodBeat.o(214250);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$taskBarUpdateEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/TaskBarDataUpdateEvent;", "callback", "", "event", "plugin-taskbar_release"})
  public static final class n
    extends IListener<Object>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDataChanged"})
  static final class o
    implements com.tencent.mm.plugin.teenmode.a.c
  {
    o(d paramd) {}
    
    public final void onDataChanged()
    {
      AppMethodBeat.i(215531);
      d.b localb = d.b(this.Mqh);
      if (localb != null)
      {
        localb.gjB();
        AppMethodBeat.o(215531);
        return;
      }
      AppMethodBeat.o(215531);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class p
    implements MStorage.IOnStorageChange
  {
    p(d paramd) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(214627);
      com.tencent.e.h.ZvG.bf((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215720);
          Log.i("MicroMsg.TaskBarViewPresenter", "received weAppOnStorageChangeListener");
          this.Mqq.Mqh.aK(true, false);
          AppMethodBeat.o(215720);
        }
      });
      AppMethodBeat.o(214627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.d
 * JD-Core Version:    0.7.0.1
 */
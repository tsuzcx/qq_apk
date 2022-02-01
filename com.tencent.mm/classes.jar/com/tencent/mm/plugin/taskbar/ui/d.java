package com.tencent.mm.plugin.taskbar.ui;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.h.b;
import com.tencent.mm.plugin.taskbar.ui.section.weapp.b.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter;", "", "view", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$IView;", "(Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$IView;)V", "currentTabIndex", "", "firstFeedShowInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$TaskBarFeedAppearInfo;", "homeTabChangedListener", "com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1;", "isTeenMode", "", "()Z", "setTeenMode", "(Z)V", "lastLiveCheckTimeSec", "", "lastStartTime", "liveCheckIntervalSec", "miniProgramOption", "getMiniProgramOption", "()I", "setMiniProgramOption", "(I)V", "sectionDataWeApp", "Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionWeAppView$AppBrandItem;", "getSectionDataWeApp", "()Ljava/util/ArrayList;", "setSectionDataWeApp", "(Ljava/util/ArrayList;)V", "sectionViewModelMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "Lkotlin/collections/HashMap;", "sessionId", "", "taskBarOnStorageChangeListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "taskBarReporter", "Lcom/tencent/mm/plugin/taskbar/report/TaskBarReporter;", "teenModeDataChangedListener", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "usageStorage", "Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "getUsageStorage", "()Lcom/tencent/mm/plugin/appbrand/appusage/IAppBrandLocalUsageStorage;", "viewDuration", "weAppOnStorageChangeListener", "canLaunchAppBrand", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "appInfo", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$WxaAppInfo;", "checkAndRemoveExceedSectionData", "", "checkLaunchAppBrand", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$LaunchAppBrandPreCheckCallback;", "checkLiveState", "clearPendingShowInfo", "getAppIdList", "appBrandItems", "", "getViewModelBySectionType", "sectionType", "isOnMainTab", "onDestroy", "onDidAppear", "onDidClose", "reason", "onOpenHeader", "onPause", "onResume", "removeExceedSectionData", "data", "", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "removeWeAppData", "pos", "reportOnClickDesktopView", "reportOnFirstFeedShow", "reportOnItemAddDeleted", "appItem", "actionType", "actionChannel", "multiTaskInfo", "reportOnItemAppear", "reportOnItemClicked", "reportTaskBarAppear", "reportTaskBarClose", "closeType", "updateData", "notify", "updateSectionData", "viewModel", "updateTeenModeStatus", "updateWeAppData", "Companion", "IView", "LaunchAppBrandPreCheckCallback", "TaskBarFeedAppearInfo", "plugin-taskbar_release"})
public final class d
{
  public static final d.a FUM;
  private int AfK;
  private ah FUA;
  ArrayList<b.a> FUB;
  final HashMap<Integer, com.tencent.mm.plugin.taskbar.ui.section.g> FUC;
  long FUD;
  int FUE;
  com.tencent.mm.plugin.taskbar.a.a FUF;
  long FUG;
  ArrayList<d> FUH;
  final MStorage.IOnStorageChange FUI;
  private final MStorage.IOnStorageChange FUJ;
  final g FUK;
  b FUL;
  boolean iCn;
  final com.tencent.mm.plugin.teenmode.a.c kIM;
  long mZq;
  int ocu;
  private String sessionId;
  
  static
  {
    AppMethodBeat.i(238464);
    FUM = new d.a((byte)0);
    AppMethodBeat.o(238464);
  }
  
  public d(b paramb)
  {
    AppMethodBeat.i(238463);
    this.FUL = paramb;
    this.FUB = new ArrayList();
    this.FUE = 60;
    this.sessionId = "";
    this.FUF = new com.tencent.mm.plugin.taskbar.a.a();
    this.FUH = new ArrayList();
    this.FUI = ((MStorage.IOnStorageChange)new l(this));
    this.FUJ = ((MStorage.IOnStorageChange)new h(this));
    this.FUK = new g(this);
    this.kIM = ((com.tencent.mm.plugin.teenmode.a.c)new i(this));
    this.FUC = ae.g(new o[] { s.U(Integer.valueOf(3), new com.tencent.mm.plugin.taskbar.ui.section.g(3, new int[] { 2 })), s.U(Integer.valueOf(2), new com.tencent.mm.plugin.taskbar.ui.section.g(2, new int[] { 21 })), s.U(Integer.valueOf(4), new com.tencent.mm.plugin.taskbar.ui.section.g(4, new int[] { 22 })), s.U(Integer.valueOf(7), new com.tencent.mm.plugin.taskbar.ui.section.g(7, new int[] { 6 })), s.U(Integer.valueOf(5), new com.tencent.mm.plugin.taskbar.ui.section.g(5, new int[] { 4, 3 })) });
    this.FUK.alive();
    paramb = fuW();
    if (paramb != null) {
      paramb.add(this.FUI);
    }
    paramb = ((PluginTaskBar)com.tencent.mm.kernel.g.ah(PluginTaskBar.class)).getTaskBarStorage();
    if (paramb != null) {
      paramb.add(this.FUJ);
    }
    ((b)com.tencent.mm.kernel.g.af(b.class)).a(this.kIM);
    AppMethodBeat.o(238463);
  }
  
  public final void a(MultiTaskInfo paramMultiTaskInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238462);
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewPresenter", "reportOnItemAddDeleted type:%d,pos:%d", new Object[] { Integer.valueOf(paramMultiTaskInfo.field_type), Integer.valueOf(0) });
    long l1 = cl.aWA();
    long l2 = paramMultiTaskInfo.field_updateTime;
    this.FUF.a(paramInt1, paramInt2, com.tencent.mm.plugin.taskbar.a.a.Mm(paramMultiTaskInfo.field_type), paramMultiTaskInfo.field_id, (int)(l1 - l2) / 1000);
    AppMethodBeat.o(238462);
  }
  
  final boolean a(LocalUsageInfo paramLocalUsageInfo, WxaAttributes.a parama)
  {
    if ((parama.serviceType != 0) && (parama.serviceType != 4)) {}
    do
    {
      return true;
      if (this.ocu == 0) {
        return paramLocalUsageInfo.kWa;
      }
    } while (this.ocu != 2);
    return false;
  }
  
  public final com.tencent.mm.plugin.taskbar.ui.section.g abG(int paramInt)
  {
    AppMethodBeat.i(238458);
    com.tencent.mm.plugin.taskbar.ui.section.g localg = (com.tencent.mm.plugin.taskbar.ui.section.g)this.FUC.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(238458);
    return localg;
  }
  
  public final void cau()
  {
    AppMethodBeat.i(238459);
    com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.g.af(b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    this.iCn = ((b)locala).Vt();
    locala = com.tencent.mm.kernel.g.af(b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    this.ocu = ((b)locala).fvp();
    Log.i("MicroMsg.TaskBarView", "alvinluo updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(this.iCn), Integer.valueOf(this.ocu) });
    AppMethodBeat.o(238459);
  }
  
  final ah fuW()
  {
    AppMethodBeat.i(238457);
    if (this.FUA == null) {
      this.FUA = ((ah)com.tencent.mm.plugin.appbrand.widget.recent.c.oBT.ccP());
    }
    ah localah = this.FUA;
    AppMethodBeat.o(238457);
    return localah;
  }
  
  public final boolean fuX()
  {
    return this.AfK == 0;
  }
  
  public final void qE(final boolean paramBoolean)
  {
    AppMethodBeat.i(238461);
    com.tencent.f.h.RTc.aY((Runnable)new j(this, paramBoolean));
    AppMethodBeat.o(238461);
  }
  
  public final void wp(boolean paramBoolean)
  {
    AppMethodBeat.i(238460);
    int j = this.FUB.size();
    int i = 0;
    Log.i("MicroMsg.TaskBarViewPresenter", "update WeApp Data " + j + ' ' + paramBoolean);
    Object localObject1 = fuW();
    if (localObject1 != null) {}
    for (localObject1 = ((ah)localObject1).vW(9);; localObject1 = null)
    {
      localObject2 = af.eY(localObject1);
      if (localObject2 != null) {
        break;
      }
      Log.w("MicroMsg.TaskBarViewPresenter", "usageStorage is null");
      AppMethodBeat.o(238460);
      return;
    }
    localObject1 = new ArrayList();
    Object localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)((Iterator)localObject2).next();
      if (i >= 9) {
        break;
      }
      ((ArrayList)localObject1).add(new b.a(localLocalUsageInfo));
      i += 1;
    }
    this.FUB = ((ArrayList)localObject1);
    Log.i("MicroMsg.TaskBarViewPresenter", "update WeApp Data Done " + this.FUB.size());
    if (paramBoolean)
    {
      localObject1 = this.FUL;
      if (localObject1 != null) {
        ((b)localObject1).fuP();
      }
    }
    if ((this.FUB.isEmpty()) && (j > 0))
    {
      localObject1 = this.FUL;
      if (localObject1 != null)
      {
        ((b)localObject1).abB(1);
        AppMethodBeat.o(238460);
        return;
      }
    }
    AppMethodBeat.o(238460);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$IView;", "", "isHeaderOpen", "", "onDataUpdated", "", "onLiveStatusUpdated", "onSectionDeleted", "sectionType", "", "onTeenModeStatusChanged", "reloadDataIfNeed", "plugin-taskbar_release"})
  public static abstract interface b
  {
    public abstract void abB(int paramInt);
    
    public abstract boolean esy();
    
    public abstract void fuO();
    
    public abstract void fuP();
    
    public abstract void fuQ();
    
    public abstract void fuR();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$LaunchAppBrandPreCheckCallback;", "", "onResult", "", "checkOk", "", "plugin-taskbar_release"})
  public static abstract interface c
  {
    public abstract void dQ(boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$TaskBarFeedAppearInfo;", "", "()V", "contentId", "", "getContentId", "()Ljava/lang/String;", "setContentId", "(Ljava/lang/String;)V", "expType", "", "getExpType", "()I", "setExpType", "(I)V", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskInfo", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "setMultiTaskInfo", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "pageType", "getPageType", "setPageType", "plugin-taskbar_release"})
  public static final class d
  {
    MultiTaskInfo Agu;
    int FUN;
    String pFK;
    int pageType;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "wxaAttributes", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
  static final class e
    implements q.a
  {
    e(d paramd, d.c paramc, LocalUsageInfo paramLocalUsageInfo) {}
    
    public final void b(WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(238448);
      if ((paramWxaAttributes != null) && (this.FUP != null))
      {
        d.c localc = this.FUP;
        d locald = this.FUO;
        LocalUsageInfo localLocalUsageInfo = this.FUQ;
        paramWxaAttributes = paramWxaAttributes.bAn();
        p.g(paramWxaAttributes, "wxaAttributes.appInfo");
        localc.dQ(d.a(locald, localLocalUsageInfo, paramWxaAttributes));
      }
      AppMethodBeat.o(238448);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/taskbar/ui/TaskBarViewPresenter$homeTabChangedListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/HomeUITabChangeEvent;", "callback", "", "event", "plugin-taskbar_release"})
  public static final class g
    extends IListener<kt>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class h
    implements MStorage.IOnStorageChange
  {
    h(d paramd) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(238451);
      Log.i("MicroMsg.TaskBarViewPresenter", "received taskBarOnStorageChangeListener");
      this.FUO.qE(true);
      if (paramMStorageEventData.eventId == 5)
      {
        if (paramMStorageEventData.obj != null)
        {
          paramString = paramMStorageEventData.obj;
          if (paramString == null)
          {
            paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.taskbar.TaskBarStorage.TaskBarDeleteNotify");
            AppMethodBeat.o(238451);
            throw paramString;
          }
          paramString = (h.b)paramString;
          if ((paramString.FSf == 2) || (paramString.FSf == 3))
          {
            paramMStorageEventData = this.FUO;
            MultiTaskInfo localMultiTaskInfo = paramString.Agu;
            if (localMultiTaskInfo == null) {
              p.btv("multiTaskInfo");
            }
            paramMStorageEventData.a(localMultiTaskInfo, 2, paramString.FSf);
            AppMethodBeat.o(238451);
          }
        }
      }
      else if (paramMStorageEventData.eventId == 2)
      {
        paramString = this.FUO;
        paramMStorageEventData = paramMStorageEventData.obj;
        if (paramMStorageEventData == null)
        {
          paramString = new t("null cannot be cast to non-null type com.tencent.mm.plugin.multitask.model.MultiTaskInfo");
          AppMethodBeat.o(238451);
          throw paramString;
        }
        paramString.a((MultiTaskInfo)paramMStorageEventData, 1, 1);
      }
      AppMethodBeat.o(238451);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDataChanged"})
  static final class i
    implements com.tencent.mm.plugin.teenmode.a.c
  {
    i(d paramd) {}
    
    public final void onDataChanged()
    {
      AppMethodBeat.i(238452);
      d.b localb = d.a(this.FUO);
      if (localb != null)
      {
        localb.fuR();
        AppMethodBeat.o(238452);
        return;
      }
      AppMethodBeat.o(238452);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class j
    implements Runnable
  {
    j(d paramd, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(238453);
      Log.i("MicroMsg.TaskBarViewPresenter", "do update data");
      this.FUO.wp(false);
      Object localObject = d.b(this.FUO).values();
      p.g(localObject, "sectionViewModelMap.values");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.taskbar.ui.section.g localg = (com.tencent.mm.plugin.taskbar.ui.section.g)((Iterator)localObject).next();
        d locald = this.FUO;
        p.g(localg, "it");
        d.a(locald, localg);
      }
      if (paramBoolean)
      {
        localObject = d.a(this.FUO);
        if (localObject != null)
        {
          ((d.b)localObject).fuP();
          AppMethodBeat.o(238453);
          return;
        }
      }
      AppMethodBeat.o(238453);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
  static final class l
    implements MStorage.IOnStorageChange
  {
    l(d paramd) {}
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(238456);
      com.tencent.f.h.RTc.aY((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(238455);
          this.FUV.FUO.wp(true);
          AppMethodBeat.o(238455);
        }
      });
      AppMethodBeat.o(238456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.d
 * JD-Core Version:    0.7.0.1
 */
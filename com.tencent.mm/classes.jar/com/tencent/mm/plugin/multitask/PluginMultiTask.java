package com.tencent.mm.plugin.multitask;

import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/PluginMultiTask;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/multitask/IPluginMultiTask;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "()V", "TAG", "", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "multiTaskStorage", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorage;", "getMultiTaskStorage", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorage;", "setMultiTaskStorage", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskStorage;)V", "viewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "addTaskInfo", "", "id", "type", "", "showData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "data", "", "reportdata", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "addTaskInfoByBitmap", "bitmap", "Landroid/graphics/Bitmap;", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getInnerMultiTaskItemPosition", "curPos", "way", "getInnerTaskInfoById", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskFloatBallPosition", "Landroid/graphics/Point;", "getMultiTaskInfoList", "callback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getMultiTaskItemPosition", "getTaskInfoById", "getTaskInfoByType", "", "getViewModelStore", "hasTaskInfo", "", "multiTaskInfo", "hasTaskInfoById", "installed", "isDataEmpty", "isMultiTaskMode", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "registerMultiTaskUIC", "clazz", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "removeTaskInfoAndCoverImg", "reportAddTaskInfo", "reportInnerMultiTaskInfo", "reportType", "multiTaskReportData", "reportMultiTaskInfo", "reportInfo", "sendMultiTaskEvent", "eventType", "setListener", "listener", "Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "updateTaskInfo", "updateTaskInfoByBitmap", "updateTaskInfoByTitle", "Companion", "OnMultiTaskUICListener", "plugin-multitask_release"})
public final class PluginMultiTask
  extends com.tencent.mm.kernel.b.f
  implements ViewModelStoreOwner, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, d
{
  private static final HashMap<Integer, Class<? extends MultiTaskUIComponent>> zZs;
  private static b zZt;
  public static final PluginMultiTask.a zZu;
  private final ViewModelStore FE;
  private final String TAG;
  private final o.a appForegroundListener;
  private com.tencent.mm.plugin.multitask.model.a zZr;
  
  static
  {
    AppMethodBeat.i(200343);
    zZu = new PluginMultiTask.a((byte)0);
    zZs = new HashMap();
    AppMethodBeat.o(200343);
  }
  
  public PluginMultiTask()
  {
    AppMethodBeat.i(200342);
    this.TAG = "MicroMsg.MultiTask.PluginMultiTask";
    this.FE = new ViewModelStore();
    this.appForegroundListener = ((o.a)new d(this));
    AppMethodBeat.o(200342);
  }
  
  public final void addTaskInfo(String paramString, int paramInt, cru paramcru, byte[] paramArrayOfByte, crt paramcrt)
  {
    AppMethodBeat.i(200334);
    p.h(paramString, "id");
    p.h(paramcru, "showData");
    Log.i(this.TAG, "addTaskInfo id:" + paramString + " type:" + paramInt);
    MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
    localMultiTaskInfo.field_id = paramString;
    localMultiTaskInfo.field_type = paramInt;
    localMultiTaskInfo.field_createTime = cl.aWA();
    localMultiTaskInfo.field_updateTime = cl.aWA();
    localMultiTaskInfo.field_showData = paramcru;
    localMultiTaskInfo.field_data = paramArrayOfByte;
    paramString = this.zZr;
    if (paramString != null)
    {
      p.h(localMultiTaskInfo, "item");
      if (!paramString.delete((IAutoDBItem)localMultiTaskInfo, false, new String[0])) {
        break label187;
      }
      if (paramString.insertNotify((IAutoDBItem)localMultiTaskInfo, false)) {
        paramString.doNotify("single", 8, localMultiTaskInfo);
      }
    }
    for (;;)
    {
      reportAddTaskInfo(localMultiTaskInfo, paramcrt);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).d(localMultiTaskInfo);
      AppMethodBeat.o(200334);
      return;
      label187:
      paramString.h(localMultiTaskInfo);
    }
  }
  
  public final void addTaskInfoByBitmap(String paramString, int paramInt, cru paramcru, Bitmap paramBitmap, byte[] paramArrayOfByte, crt paramcrt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(200323);
    p.h(paramString, "id");
    p.h(paramcru, "showData");
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("addTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    Object localObject1;
    if (paramBitmap != null)
    {
      localObject1 = Integer.valueOf(paramBitmap.getByteCount());
      Log.i((String)localObject3, localObject1);
      if (!MMApplicationContext.isMainProcess()) {
        break label213;
      }
      paramcru.MwT = false;
      if (paramBitmap == null) {
        break label195;
      }
      localObject1 = h.zZn;
      localObject1 = h.aGJ(paramString);
      if (s.YS((String)localObject1)) {
        s.deleteFile((String)localObject1);
      }
      localObject2 = g.zZj;
      localObject2 = h.zZn;
      localObject2 = g.e((String)localObject1, h.eqz());
      q.bcV().OR((String)localObject2);
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject1, false);
    }
    for (;;)
    {
      addTaskInfo(paramString, paramInt, paramcru, paramArrayOfByte, paramcrt);
      AppMethodBeat.o(200323);
      return;
      localObject1 = null;
      break;
      label195:
      paramcru.MwT = true;
      Log.i(this.TAG, "addTaskInfoByBitmap showData defaultBg mainProcess");
    }
    label213:
    localObject3 = new Bundle();
    paramcru.MwT = false;
    if (paramBitmap != null)
    {
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = ((Context)localObject1).getExternalCacheDir();
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        localObject1 = p.I((String)localObject1, paramString);
        if (s.YS((String)localObject1)) {
          s.deleteFile((String)localObject1);
        }
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject1, false);
        ((Bundle)localObject3).putString("path", (String)localObject1);
      }
    }
    for (;;)
    {
      ((Bundle)localObject3).putString("id", paramString);
      ((Bundle)localObject3).putInt("type", paramInt);
      ((Bundle)localObject3).putByteArray("showData", paramcru.toByteArray());
      ((Bundle)localObject3).putByteArray("data", paramArrayOfByte);
      paramString = (String)localObject2;
      if (paramcrt != null) {
        paramString = paramcrt.toByteArray();
      }
      ((Bundle)localObject3).putByteArray("reportdata", paramString);
      com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject3, a.class, (com.tencent.mm.ipcinvoker.d)new c(this));
      AppMethodBeat.o(200323);
      return;
      localObject1 = null;
      break;
      paramcru.MwT = true;
      Log.i(this.TAG, "addTaskInfoByBitmap showData defaultBg");
    }
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(200317);
    Log.i(this.TAG, "onAccountRelease");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("MultiTaskInfo".hashCode()), e.zZw);
    AppMethodBeat.o(200317);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void dependency() {}
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final String getInnerMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200328);
    p.h(paramString, "id");
    b localb = zZt;
    if (localb != null)
    {
      paramString = localb.getMultiTaskItemPosition(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(200328);
      return paramString;
    }
    AppMethodBeat.o(200328);
    return null;
  }
  
  public final MultiTaskInfo getInnerTaskInfoById(String paramString)
  {
    AppMethodBeat.i(200338);
    p.h(paramString, "id");
    com.tencent.mm.plugin.multitask.model.a locala = this.zZr;
    if (locala != null)
    {
      paramString = locala.aGM(paramString);
      AppMethodBeat.o(200338);
      return paramString;
    }
    AppMethodBeat.o(200338);
    return null;
  }
  
  public final Point getMultiTaskFloatBallPosition()
  {
    AppMethodBeat.i(200341);
    Point localPoint = new Point(0, f.oYW);
    AppMethodBeat.o(200341);
    return localPoint;
  }
  
  public final void getMultiTaskInfoList(com.tencent.mm.plugin.multitask.c.a parama)
  {
    AppMethodBeat.i(200320);
    Log.i(this.TAG, "getMultiTaskInfoList");
    if (MMApplicationContext.isMainProcess())
    {
      if (parama != null)
      {
        Object localObject = this.zZr;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.plugin.multitask.model.a)localObject).eri();; localObject = (List)new ArrayList())
        {
          parama.bC((List)localObject);
          AppMethodBeat.o(200320);
          return;
        }
      }
      AppMethodBeat.o(200320);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, b.class, (com.tencent.mm.ipcinvoker.d)new PluginMultiTask.f(parama));
    AppMethodBeat.o(200320);
  }
  
  public final String getMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200329);
    p.h(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      paramString = getInnerMultiTaskItemPosition(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(200329);
      return paramString;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("curPos", paramInt1);
    localBundle.putInt("way", paramInt2);
    paramString = (IPCString)com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localBundle, m.class);
    if (paramString != null)
    {
      paramString = paramString.value;
      AppMethodBeat.o(200329);
      return paramString;
    }
    AppMethodBeat.o(200329);
    return null;
  }
  
  public final com.tencent.mm.plugin.multitask.model.a getMultiTaskStorage()
  {
    return this.zZr;
  }
  
  public final MultiTaskInfo getTaskInfoById(String paramString)
  {
    AppMethodBeat.i(200337);
    p.h(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      paramString = getInnerTaskInfoById(paramString);
      AppMethodBeat.o(200337);
      return paramString;
    }
    AppMethodBeat.o(200337);
    return null;
  }
  
  public final List<MultiTaskInfo> getTaskInfoByType(int paramInt)
  {
    AppMethodBeat.i(200336);
    Object localObject = this.zZr;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitask.model.a)localObject).db.rawQuery("SELECT * FROM MultiTaskInfo WHERE type = ? ORDER BY createTime DESC;", new String[] { String.valueOf(paramInt) });
      ArrayList localArrayList = new ArrayList();
      while (((Cursor)localObject).moveToNext())
      {
        MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
        localMultiTaskInfo.convertFrom((Cursor)localObject);
        localArrayList.add(localMultiTaskInfo);
      }
      ((Cursor)localObject).close();
      localObject = (List)localArrayList;
      AppMethodBeat.o(200336);
      return localObject;
    }
    localObject = (List)new ArrayList();
    AppMethodBeat.o(200336);
    return localObject;
  }
  
  public final ViewModelStore getViewModelStore()
  {
    return this.FE;
  }
  
  public final boolean hasTaskInfo(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(200340);
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    boolean bool;
    if (MMApplicationContext.isMainProcess())
    {
      paramMultiTaskInfo = paramMultiTaskInfo.field_id;
      p.g(paramMultiTaskInfo, "multiTaskInfo.field_id");
      bool = hasTaskInfoById(paramMultiTaskInfo);
      AppMethodBeat.o(200340);
      return bool;
    }
    paramMultiTaskInfo = (IPCBoolean)com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)new IPCString(paramMultiTaskInfo.field_id), c.class);
    if (paramMultiTaskInfo != null)
    {
      bool = paramMultiTaskInfo.value;
      AppMethodBeat.o(200340);
      return bool;
    }
    AppMethodBeat.o(200340);
    return false;
  }
  
  public final boolean hasTaskInfoById(String paramString)
  {
    AppMethodBeat.i(200339);
    p.h(paramString, "id");
    Object localObject = zZt;
    if (localObject != null)
    {
      boolean bool = ((b)localObject).aGK(paramString);
      AppMethodBeat.o(200339);
      return bool;
    }
    localObject = this.zZr;
    if (localObject != null) {}
    for (paramString = ((com.tencent.mm.plugin.multitask.model.a)localObject).aGM(paramString); paramString != null; paramString = null)
    {
      AppMethodBeat.o(200339);
      return true;
    }
    AppMethodBeat.o(200339);
    return false;
  }
  
  public final void installed() {}
  
  public final boolean isDataEmpty()
  {
    AppMethodBeat.i(200327);
    Object localObject = zZt;
    boolean bool;
    if (localObject != null)
    {
      bool = ((b)localObject).isDataEmpty();
      AppMethodBeat.o(200327);
      return bool;
    }
    localObject = this.zZr;
    if (localObject != null)
    {
      bool = ((com.tencent.mm.plugin.multitask.model.a)localObject).eri().isEmpty();
      AppMethodBeat.o(200327);
      return bool;
    }
    AppMethodBeat.o(200327);
    return false;
  }
  
  public final boolean isMultiTaskMode()
  {
    AppMethodBeat.i(200326);
    boolean bool = ao.isMultiTaskMode();
    AppMethodBeat.o(200326);
    return bool;
  }
  
  public final String name()
  {
    return "PluginMultiTask";
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(200319);
    if (this.zZr == null)
    {
      paramc = com.tencent.mm.kernel.g.aAh();
      p.g(paramc, "MMKernel.storage()");
      paramc = paramc.getDataDB();
      p.g(paramc, "MMKernel.storage().dataDB");
      this.zZr = new com.tencent.mm.plugin.multitask.model.a((ISQLiteDatabase)paramc);
    }
    this.appForegroundListener.alive();
    AppMethodBeat.o(200319);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(200318);
    Log.i(this.TAG, "onAccountRelease");
    this.zZr = null;
    this.appForegroundListener.dead();
    zZt = null;
    AppMethodBeat.o(200318);
  }
  
  public final void registerMultiTaskUIC(int paramInt, Class<? extends MultiTaskUIComponent> paramClass)
  {
    AppMethodBeat.i(200321);
    Log.i(this.TAG, "registerMultiTaskUIC type:" + paramInt + " clazzUic:" + paramClass);
    if (MMApplicationContext.isMainProcess()) {
      ((Map)zZs).put(Integer.valueOf(paramInt), paramClass);
    }
    AppMethodBeat.o(200321);
  }
  
  public final void removeTaskInfoAndCoverImg(String paramString)
  {
    AppMethodBeat.i(200332);
    if (paramString != null)
    {
      Object localObject = h.zZn;
      localObject = h.aGJ(paramString);
      if (s.YS((String)localObject)) {
        s.deleteFile((String)localObject);
      }
      localObject = this.zZr;
      if (localObject != null)
      {
        p.h(paramString, "id");
        MultiTaskInfo localMultiTaskInfo = ((com.tencent.mm.plugin.multitask.model.a)localObject).aGM(paramString);
        if ((localMultiTaskInfo != null) && (((com.tencent.mm.plugin.multitask.model.a)localObject).delete((IAutoDBItem)localMultiTaskInfo, false, new String[0]))) {
          ((com.tencent.mm.plugin.multitask.model.a)localObject).doNotify("single", 5, localMultiTaskInfo);
        }
      }
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).aBz(paramString);
      AppMethodBeat.o(200332);
      return;
    }
    AppMethodBeat.o(200332);
  }
  
  public final void reportAddTaskInfo(MultiTaskInfo paramMultiTaskInfo, crt paramcrt)
  {
    AppMethodBeat.i(200333);
    if (paramcrt != null)
    {
      crp localcrp = paramcrt.MwO;
      if (localcrp != null)
      {
        com.tencent.mm.plugin.multitask.d.a locala = com.tencent.mm.plugin.multitask.d.a.AbZ;
        com.tencent.mm.plugin.multitask.d.a.a(paramMultiTaskInfo, localcrp.MwA, localcrp.jii, paramcrt.sGQ, localcrp.MwB);
        AppMethodBeat.o(200333);
        return;
      }
    }
    AppMethodBeat.o(200333);
  }
  
  public final void reportInnerMultiTaskInfo(int paramInt, crt paramcrt)
  {
    AppMethodBeat.i(200330);
    if (paramcrt != null)
    {
      com.tencent.mm.plugin.multitask.d.a locala;
      if (paramInt == 2)
      {
        locala = com.tencent.mm.plugin.multitask.d.a.AbZ;
        com.tencent.mm.plugin.multitask.d.a.a(paramcrt);
        locala = com.tencent.mm.plugin.multitask.d.a.AbZ;
        com.tencent.mm.plugin.multitask.d.a.a(paramcrt.dUm, paramcrt.Uub);
        AppMethodBeat.o(200330);
        return;
      }
      if (paramInt == 3)
      {
        locala = com.tencent.mm.plugin.multitask.d.a.AbZ;
        com.tencent.mm.plugin.multitask.d.a.b(paramcrt);
      }
    }
    AppMethodBeat.o(200330);
  }
  
  public final void reportMultiTaskInfo(int paramInt, crt paramcrt)
  {
    Object localObject3 = null;
    AppMethodBeat.i(200325);
    String str = this.TAG;
    if (paramcrt != null)
    {
      localObject1 = paramcrt.MwM;
      if (paramcrt == null) {
        break label89;
      }
    }
    label89:
    for (Object localObject2 = Integer.valueOf(paramcrt.dUm);; localObject2 = null)
    {
      Log.d(str, "reportMultiTaskInfo, itemid: %s, itemtype: %d, reporttype: %d", new Object[] { localObject1, localObject2, Integer.valueOf(paramInt) });
      if (!MMApplicationContext.isMainProcess()) {
        break label95;
      }
      reportInnerMultiTaskInfo(paramInt, paramcrt);
      AppMethodBeat.o(200325);
      return;
      localObject1 = null;
      break;
    }
    label95:
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("reporttype", paramInt);
    Object localObject1 = localObject3;
    if (paramcrt != null) {
      localObject1 = paramcrt.toByteArray();
    }
    ((Bundle)localObject2).putByteArray("reportdata", (byte[])localObject1);
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject2, j.class, (com.tencent.mm.ipcinvoker.d)new g(this));
    AppMethodBeat.o(200325);
  }
  
  public final void sendMultiTaskEvent(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(200322);
    p.h(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      localObject = new mt();
      ((mt)localObject).dSq.dSr = paramInt1;
      ((mt)localObject).dSq.type = paramInt2;
      ((mt)localObject).dSq.id = paramString;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(200322);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("id", paramString);
    ((Bundle)localObject).putInt("type", paramInt2);
    ((Bundle)localObject).putInt("event_type", paramInt1);
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject, e.class, (com.tencent.mm.ipcinvoker.d)new h(this));
    AppMethodBeat.o(200322);
  }
  
  public final void setListener(b paramb)
  {
    zZt = paramb;
  }
  
  public final void setMultiTaskStorage(com.tencent.mm.plugin.multitask.model.a parama)
  {
    this.zZr = parama;
  }
  
  public final void updateTaskInfo(String paramString, int paramInt, cru paramcru, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(200335);
    p.h(paramString, "id");
    p.h(paramcru, "showData");
    com.tencent.mm.plugin.multitask.model.a locala = this.zZr;
    if (locala != null)
    {
      paramString = locala.aGM(paramString);
      if (paramString != null)
      {
        paramString.field_updateTime = cl.aWA();
        paramString.field_type = paramInt;
        paramString.field_showData = paramcru;
        if (paramArrayOfByte != null) {
          paramString.field_data = paramArrayOfByte;
        }
        paramcru = this.zZr;
        if (paramcru != null) {
          paramcru.a(paramString, new String[0]);
        }
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(paramString);
        AppMethodBeat.o(200335);
        return;
      }
    }
    AppMethodBeat.o(200335);
  }
  
  public final void updateTaskInfoByBitmap(final String paramString, final int paramInt, final cru paramcru, final Bitmap paramBitmap, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(200324);
    p.h(paramString, "id");
    p.h(paramcru, "showData");
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("updateTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    Object localObject1;
    if (paramBitmap != null)
    {
      localObject1 = Integer.valueOf(paramBitmap.getByteCount());
      Log.i((String)localObject2, localObject1);
      if (!MMApplicationContext.isMainProcess()) {
        break label208;
      }
      paramcru.MwT = false;
      if (paramBitmap == null) {
        break label190;
      }
      localObject1 = h.zZn;
      localObject1 = h.aGJ(paramString);
      if (s.YS((String)localObject1)) {
        s.deleteFile((String)localObject1);
      }
      localObject2 = g.zZj;
      localObject2 = h.zZn;
      localObject2 = g.e((String)localObject1, h.eqz());
      q.bcV().OR((String)localObject2);
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject1, false);
    }
    for (;;)
    {
      updateTaskInfo(paramString, paramInt, paramcru, paramArrayOfByte);
      AppMethodBeat.o(200324);
      return;
      localObject1 = null;
      break;
      label190:
      paramcru.MwT = true;
      Log.i(this.TAG, "updateTaskInfoByBitmap showData defaultBg mainProcess");
    }
    label208:
    localObject2 = new Bundle();
    paramcru.MwT = false;
    if (paramBitmap != null)
    {
      localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = ((Context)localObject1).getExternalCacheDir();
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        localObject1 = p.I((String)localObject1, paramString);
        if (s.YS((String)localObject1)) {
          s.deleteFile((String)localObject1);
        }
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject1, false);
        ((Bundle)localObject2).putString("path", (String)localObject1);
      }
    }
    for (;;)
    {
      ((Bundle)localObject2).putString("id", paramString);
      ((Bundle)localObject2).putInt("type", paramInt);
      ((Bundle)localObject2).putByteArray("showData", paramcru.toByteArray());
      ((Bundle)localObject2).putByteArray("data", paramArrayOfByte);
      com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject2, l.class, (com.tencent.mm.ipcinvoker.d)new i(this, paramcru, paramBitmap, paramString, paramInt, paramArrayOfByte));
      AppMethodBeat.o(200324);
      return;
      localObject1 = null;
      break;
      paramcru.MwT = true;
      Log.i(this.TAG, "updateTaskInfoByBitmap showData defaultBg");
    }
  }
  
  public final void updateTaskInfoByTitle(final String paramString, final int paramInt, final cru paramcru, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(200331);
    p.h(paramString, "id");
    p.h(paramcru, "showData");
    if (MMApplicationContext.isMainProcess())
    {
      updateTaskInfo(paramString, paramInt, paramcru, paramArrayOfByte);
      AppMethodBeat.o(200331);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("type", paramInt);
    localBundle.putByteArray("showData", paramcru.toByteArray());
    localBundle.putByteArray("data", paramArrayOfByte);
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localBundle, k.class, (com.tencent.mm.ipcinvoker.d)new j(this, paramString, paramInt, paramcru, paramArrayOfByte));
    AppMethodBeat.o(200331);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "", "getMultiTaskItemPosition", "", "id", "curPos", "", "way", "hasCurrentMultiInfo", "", "isDataEmpty", "markWechatForeground", "", "foreground", "plugin-multitask_release"})
  public static abstract interface b
  {
    public abstract boolean aGK(String paramString);
    
    public abstract String getMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2);
    
    public abstract boolean isDataEmpty();
    
    public abstract void jK(boolean paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback"})
  static final class c<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    c(PluginMultiTask paramPluginMultiTask) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitask/PluginMultiTask$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-multitask_release"})
  public static final class d
    extends o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(200309);
      p.h(paramString, "activity");
      Log.i(PluginMultiTask.access$getTAG$p(this.zZv), "onAppBackground, activity:%s", new Object[] { paramString });
      paramString = PluginMultiTask.zZu;
      paramString = PluginMultiTask.access$getMListener$cp();
      if (paramString != null)
      {
        paramString.jK(AppForegroundDelegate.djR.Wc());
        AppMethodBeat.o(200309);
        return;
      }
      AppMethodBeat.o(200309);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(200308);
      p.h(paramString, "activity");
      Log.i(PluginMultiTask.access$getTAG$p(this.zZv), "onAppForeground, activity:%s", new Object[] { paramString });
      if ((AppForegroundDelegate.djR.Wc()) && (com.tencent.mm.kernel.g.aAc()))
      {
        boolean bool = Util.isTopApplication(MMApplicationContext.getContext());
        Log.i(PluginMultiTask.access$getTAG$p(this.zZv), "onAppForeground isTopApplication: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = PluginMultiTask.zZu;
          paramString = PluginMultiTask.access$getMListener$cp();
          if (paramString != null)
          {
            paramString.jK(true);
            AppMethodBeat.o(200308);
            return;
          }
        }
      }
      AppMethodBeat.o(200308);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class e
    implements h.b
  {
    public static final e zZw;
    
    static
    {
      AppMethodBeat.i(200311);
      zZw = new e();
      AppMethodBeat.o(200311);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(200310);
      Object localObject = com.tencent.mm.plugin.multitask.model.a.AbX;
      localObject = com.tencent.mm.plugin.multitask.model.a.dax();
      AppMethodBeat.o(200310);
      return localObject;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback"})
  static final class g<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    g(PluginMultiTask paramPluginMultiTask) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback"})
  static final class h<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    h(PluginMultiTask paramPluginMultiTask) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback", "com/tencent/mm/plugin/multitask/PluginMultiTask$updateTaskInfoByBitmap$1$3"})
  static final class i<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    i(PluginMultiTask paramPluginMultiTask, cru paramcru, Bitmap paramBitmap, String paramString, int paramInt, byte[] paramArrayOfByte) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback", "com/tencent/mm/plugin/multitask/PluginMultiTask$updateTaskInfoByTitle$1$1"})
  static final class j<T>
    implements com.tencent.mm.ipcinvoker.d<ResultType>
  {
    j(PluginMultiTask paramPluginMultiTask, String paramString, int paramInt, cru paramcru, byte[] paramArrayOfByte) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.PluginMultiTask
 * JD-Core Version:    0.7.0.1
 */
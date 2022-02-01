package com.tencent.mm.plugin.multitask;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.lifecycle.aa;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.nk;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.p.d.a;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.observer.StorageEventId;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/PluginMultiTask;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/multitask/IPluginMultiTask;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Landroidx/lifecycle/ViewModelStoreOwner;", "()V", "KEY_MULTITASK", "", "MMKV_MULTI_TASK_NAME", "TAG", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "hasRestoredDataFromStorageToMMKV", "", "multiTaskInfoList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "multiTaskStorage", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskLiveStorage;", "getMultiTaskStorage", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskLiveStorage;", "setMultiTaskStorage", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskLiveStorage;)V", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "addTaskInfo", "", "id", "type", "", "showData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "data", "", "reportdata", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "addTaskInfoByBitmap", "bitmap", "Landroid/graphics/Bitmap;", "checkListNotEmpty", "collection", "", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getInnerMultiTaskItemPosition", "curPos", "way", "getInnerTaskInfoById", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskFloatBallPosition", "Landroid/graphics/Point;", "getMultiTaskInfoList", "callback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getMultiTaskItemPosition", "getTaskInfoById", "getTaskInfoByType", "", "getViewModelStore", "hasTaskInfo", "multiTaskInfo", "hasTaskInfoById", "hasTaskInfoByMMKV", "installed", "isDataEmpty", "isMultiTaskMode", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "registerMultiTaskUIC", "clazz", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "removeTaskInfoAndCoverImg", "reportAddTaskInfo", "reportInnerMultiTaskInfo", "reportType", "multiTaskReportData", "reportMultiTaskInfo", "reportInfo", "restoreDataFromStorageToMMKV", "saveMultiTaskToMMKV", "sendMultiTaskEvent", "eventType", "setListener", "listener", "Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "updateTaskInfo", "updateTaskInfoByBitmap", "updateTaskInfoByTitle", "Companion", "OnMultiTaskUICListener", "plugin-multitask_release"})
public final class PluginMultiTask
  extends com.tencent.mm.kernel.b.f
  implements androidx.lifecycle.ab, com.tencent.mm.kernel.api.bucket.c, d
{
  private static final HashMap<Integer, Class<? extends com.tencent.mm.plugin.multitask.ui.c>> FFk;
  private static b FFl;
  public static final PluginMultiTask.a FFm;
  private com.tencent.mm.plugin.multitask.model.b FFf;
  private volatile boolean FFg;
  private final CopyOnWriteArrayList<String> FFh;
  private final String FFi;
  private final String FFj;
  private final String TAG;
  private final aa VK;
  private final o.a appForegroundListener;
  
  static
  {
    AppMethodBeat.i(248464);
    FFm = new PluginMultiTask.a((byte)0);
    FFk = new HashMap();
    AppMethodBeat.o(248464);
  }
  
  public PluginMultiTask()
  {
    AppMethodBeat.i(248463);
    this.TAG = "MicroMsg.MultiTask.PluginMultiTask";
    this.FFh = new CopyOnWriteArrayList();
    this.FFi = "multitask";
    this.FFj = "multi_task_storage";
    this.VK = new aa();
    this.appForegroundListener = ((o.a)new d(this));
    AppMethodBeat.o(248463);
  }
  
  public final void addTaskInfo(String paramString, int paramInt, dar paramdar, byte[] paramArrayOfByte, daq paramdaq)
  {
    AppMethodBeat.i(248453);
    p.k(paramString, "id");
    p.k(paramdar, "showData");
    MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
    localMultiTaskInfo.field_id = paramString;
    localMultiTaskInfo.field_type = paramInt;
    localMultiTaskInfo.field_createTime = cm.bfE();
    localMultiTaskInfo.field_updateTime = cm.bfE();
    localMultiTaskInfo.field_showData = paramdar;
    localMultiTaskInfo.field_data = paramArrayOfByte;
    paramdar = this.FFf;
    int i;
    boolean bool;
    if (paramdar != null)
    {
      p.k(localMultiTaskInfo, "item");
      if (com.tencent.mm.plugin.p.h.b(paramdar, (IAutoDBItem)localMultiTaskInfo, false, false, 4) > 0)
      {
        i = 1;
        if (i == 0) {
          break label343;
        }
        bool = com.tencent.mm.plugin.p.h.a(paramdar, (IAutoDBItem)localMultiTaskInfo, false, false, 4);
        if (!bool) {
          break label366;
        }
        paramArrayOfByte = com.tencent.mm.plugin.multitask.model.c.FHM;
        paramArrayOfByte = new StorageObserverEvent((StorageEventId)com.tencent.mm.plugin.multitask.model.c.fbe(), null, 2, null);
        paramArrayOfByte.setEvent("single");
        paramArrayOfByte.setObj(localMultiTaskInfo);
        paramdar.getOwner().notify(paramArrayOfByte);
      }
    }
    label172:
    label343:
    label366:
    for (;;)
    {
      for (paramdar = Boolean.valueOf(bool);; paramdar = null)
      {
        reportAddTaskInfo(localMultiTaskInfo, paramdaq);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).d(localMultiTaskInfo);
        if ((p.h(paramdar, Boolean.TRUE)) && (!this.FFh.contains(paramString)))
        {
          this.FFh.add(paramString);
          saveMultiTaskToMMKV();
        }
        if (p.h(paramdar, Boolean.TRUE))
        {
          paramArrayOfByte = com.tencent.mm.plugin.multitask.e.b.FHS;
          if (!com.tencent.mm.plugin.multitask.e.b.fbk())
          {
            Log.i(this.TAG, "[enterTips] first Add!");
            paramArrayOfByte = com.tencent.mm.plugin.multitask.e.b.FHS;
            com.tencent.mm.plugin.multitask.e.b.vn(true);
            paramArrayOfByte = com.tencent.mm.plugin.multitask.e.b.FHS;
            com.tencent.mm.plugin.multitask.e.b.OC(System.currentTimeMillis());
          }
        }
        Log.i(this.TAG, "addTaskInfo id:" + paramString + " type:" + paramInt + " success:" + paramdar);
        AppMethodBeat.o(248453);
        return;
        i = 0;
        break;
        bool = com.tencent.mm.plugin.p.h.a(paramdar, (IAutoDBItem)localMultiTaskInfo, false, false, 6);
        break label172;
      }
    }
  }
  
  public final void addTaskInfoByBitmap(String paramString, int paramInt, dar paramdar, Bitmap paramBitmap, byte[] paramArrayOfByte, daq paramdaq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(248429);
    p.k(paramString, "id");
    p.k(paramdar, "showData");
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("addTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    if (paramBitmap != null)
    {
      localObject1 = Integer.valueOf(paramBitmap.getByteCount());
      Log.i((String)localObject3, localObject1);
      if (!MMApplicationContext.isMainProcess()) {
        break label214;
      }
      paramdar.TIi = false;
      if (paramBitmap == null) {
        break label196;
      }
      localObject1 = h.FFb;
      localObject1 = h.aQX(paramString);
      if (u.agG((String)localObject1)) {
        u.deleteFile((String)localObject1);
      }
      localObject2 = g.FEX;
      localObject2 = h.FFb;
      localObject2 = g.e((String)localObject1, h.fap());
      com.tencent.mm.ay.q.bml().Wp((String)localObject2);
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
    }
    for (;;)
    {
      addTaskInfo(paramString, paramInt, paramdar, paramArrayOfByte, paramdaq);
      AppMethodBeat.o(248429);
      return;
      localObject1 = null;
      break;
      label196:
      paramdar.TIi = true;
      Log.i(this.TAG, "addTaskInfoByBitmap showData defaultBg mainProcess");
    }
    label214:
    Object localObject1 = new Bundle();
    paramdar.TIi = false;
    if (paramBitmap != null)
    {
      localObject3 = new StringBuilder();
      localObject4 = com.tencent.mm.vfs.ab.bCa("multitask");
      p.j(localObject4, "VFSStrategy.getTempDir(C…ITASK_STORAGE_DIR, false)");
      localObject3 = ((com.tencent.mm.vfs.q)localObject4).bOF() + "/" + paramString;
      if (u.agG((String)localObject3)) {
        u.deleteFile((String)localObject3);
      }
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject3, false);
      ((Bundle)localObject1).putString("path", (String)localObject3);
    }
    for (;;)
    {
      ((Bundle)localObject1).putString("id", paramString);
      ((Bundle)localObject1).putInt("type", paramInt);
      ((Bundle)localObject1).putByteArray("showData", paramdar.toByteArray());
      ((Bundle)localObject1).putByteArray("data", paramArrayOfByte);
      paramString = (String)localObject2;
      if (paramdaq != null) {
        paramString = paramdaq.toByteArray();
      }
      ((Bundle)localObject1).putByteArray("reportdata", paramString);
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, a.class, (com.tencent.mm.ipcinvoker.f)new c(this));
      AppMethodBeat.o(248429);
      return;
      paramdar.TIi = true;
      Log.i(this.TAG, "addTaskInfoByBitmap showData defaultBg");
    }
  }
  
  public final boolean checkListNotEmpty(Collection<?> paramCollection)
  {
    AppMethodBeat.i(248415);
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      AppMethodBeat.o(248415);
      return true;
    }
    AppMethodBeat.o(248415);
    return false;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void dependency() {}
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final String getInnerMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248443);
    p.k(paramString, "id");
    b localb = FFl;
    if (localb != null)
    {
      paramString = localb.getMultiTaskItemPosition(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(248443);
      return paramString;
    }
    AppMethodBeat.o(248443);
    return null;
  }
  
  public final MultiTaskInfo getInnerTaskInfoById(String paramString)
  {
    AppMethodBeat.i(248457);
    p.k(paramString, "id");
    com.tencent.mm.plugin.multitask.model.b localb = this.FFf;
    if (localb != null)
    {
      paramString = localb.aRb(paramString);
      AppMethodBeat.o(248457);
      return paramString;
    }
    AppMethodBeat.o(248457);
    return null;
  }
  
  public final Point getMultiTaskFloatBallPosition()
  {
    AppMethodBeat.i(248461);
    Point localPoint = new Point(0, f.saX);
    AppMethodBeat.o(248461);
    return localPoint;
  }
  
  public final void getMultiTaskInfoList(com.tencent.mm.plugin.multitask.c.a parama)
  {
    AppMethodBeat.i(248418);
    Log.i(this.TAG, "getMultiTaskInfoList");
    if (MMApplicationContext.isMainProcess())
    {
      if (parama != null)
      {
        Object localObject = this.FFf;
        if (localObject != null) {}
        for (localObject = ((com.tencent.mm.plugin.multitask.model.b)localObject).fbd();; localObject = (List)new ArrayList())
        {
          parama.bA((List)localObject);
          AppMethodBeat.o(248418);
          return;
        }
      }
      AppMethodBeat.o(248418);
      return;
    }
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, b.class, (com.tencent.mm.ipcinvoker.f)new PluginMultiTask.e(parama));
    AppMethodBeat.o(248418);
  }
  
  public final String getMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248444);
    p.k(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      paramString = getInnerMultiTaskItemPosition(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(248444);
      return paramString;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("curPos", paramInt1);
    localBundle.putInt("way", paramInt2);
    paramString = (IPCString)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, n.class);
    if (paramString != null)
    {
      paramString = paramString.value;
      AppMethodBeat.o(248444);
      return paramString;
    }
    AppMethodBeat.o(248444);
    return null;
  }
  
  public final com.tencent.mm.plugin.multitask.model.b getMultiTaskStorage()
  {
    return this.FFf;
  }
  
  public final MultiTaskInfo getTaskInfoById(String paramString)
  {
    AppMethodBeat.i(248456);
    p.k(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      paramString = getInnerTaskInfoById(paramString);
      AppMethodBeat.o(248456);
      return paramString;
    }
    AppMethodBeat.o(248456);
    return null;
  }
  
  public final List<MultiTaskInfo> getTaskInfoByType(int paramInt)
  {
    AppMethodBeat.i(248455);
    Object localObject = this.FFf;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitask.model.b)localObject).Yc(paramInt);
      AppMethodBeat.o(248455);
      return localObject;
    }
    localObject = (List)new ArrayList();
    AppMethodBeat.o(248455);
    return localObject;
  }
  
  public final aa getViewModelStore()
  {
    return this.VK;
  }
  
  public final boolean hasTaskInfo(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(248459);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    boolean bool = hasTaskInfoByMMKV(paramMultiTaskInfo);
    AppMethodBeat.o(248459);
    return bool;
  }
  
  public final boolean hasTaskInfoById(String paramString)
  {
    AppMethodBeat.i(248458);
    p.k(paramString, "id");
    Object localObject = FFl;
    if (localObject != null)
    {
      boolean bool = ((b)localObject).aQY(paramString);
      AppMethodBeat.o(248458);
      return bool;
    }
    localObject = this.FFf;
    if (localObject != null) {}
    for (paramString = ((com.tencent.mm.plugin.multitask.model.b)localObject).aRb(paramString); paramString != null; paramString = null)
    {
      AppMethodBeat.o(248458);
      return true;
    }
    AppMethodBeat.o(248458);
    return false;
  }
  
  public final boolean hasTaskInfoByMMKV(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(248413);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject1 = MultiProcessMMKV.getMMKV(this.FFj).decodeString(this.FFi);
    boolean bool1;
    if ((Util.isNullOrNil((String)localObject1)) && (!this.FFg))
    {
      if (MMApplicationContext.isMainProcess())
      {
        paramMultiTaskInfo = paramMultiTaskInfo.field_id;
        p.j(paramMultiTaskInfo, "multiTaskInfo.field_id");
        bool1 = hasTaskInfoById(paramMultiTaskInfo);
        AppMethodBeat.o(248413);
        return bool1;
      }
      paramMultiTaskInfo = (IPCBoolean)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramMultiTaskInfo.field_id), c.class);
      if (paramMultiTaskInfo != null)
      {
        bool1 = paramMultiTaskInfo.value;
        AppMethodBeat.o(248413);
        return bool1;
      }
      AppMethodBeat.o(248413);
      return false;
    }
    Log.d(this.TAG, "load, savedMuliTaskInfos:%s", new Object[] { localObject1 });
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if (((JSONArray)localObject1).length() <= 0) {
          break label314;
        }
        int j = ((JSONArray)localObject1).length();
        i = 0;
        bool1 = false;
        bool2 = bool1;
        if (i >= j) {
          break;
        }
      }
      catch (JSONException paramMultiTaskInfo)
      {
        int i;
        Object localObject2;
        bool1 = false;
      }
      try
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject2 == null) {
          break label311;
        }
        localObject2 = MultiTaskInfo.bk((JSONObject)localObject2);
        if (localObject2 == null) {
          break label311;
        }
        bool2 = TextUtils.equals((CharSequence)((MultiTaskInfo)localObject2).field_id, (CharSequence)paramMultiTaskInfo.field_id);
        if (!bool2) {
          break label311;
        }
        bool1 = true;
      }
      catch (JSONException paramMultiTaskInfo)
      {
        break label254;
        continue;
      }
      i += 1;
      continue;
      label254:
      Log.printErrStackTrace(this.TAG, (Throwable)paramMultiTaskInfo, "load fail, exception:%s", new Object[] { paramMultiTaskInfo });
    }
    label311:
    label314:
    for (boolean bool2 = bool1;; bool2 = false)
    {
      Log.i(this.TAG, "load, hasTaskInfoByMMKV: ".concat(String.valueOf(bool2)));
      AppMethodBeat.o(248413);
      return bool2;
    }
  }
  
  public final void installed() {}
  
  public final boolean isDataEmpty()
  {
    AppMethodBeat.i(248441);
    Object localObject = FFl;
    boolean bool;
    if (localObject != null)
    {
      bool = ((b)localObject).isDataEmpty();
      AppMethodBeat.o(248441);
      return bool;
    }
    localObject = this.FFf;
    if (localObject != null)
    {
      bool = ((com.tencent.mm.plugin.multitask.model.b)localObject).fbd().isEmpty();
      AppMethodBeat.o(248441);
      return bool;
    }
    AppMethodBeat.o(248441);
    return false;
  }
  
  public final boolean isMultiTaskMode()
  {
    AppMethodBeat.i(248439);
    boolean bool = ar.isMultiTaskMode();
    AppMethodBeat.o(248439);
    return bool;
  }
  
  public final String name()
  {
    return "PluginMultiTask";
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(248403);
    paramc = com.tencent.mm.plugin.p.d.EiT;
    paramc = (com.tencent.mm.plugin.multitask.model.a)d.a.bj(com.tencent.mm.plugin.multitask.model.a.class);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.f)localObject).getDataDB();
    p.j(localObject, "MMKernel.storage().dataDB");
    paramc.d((com.tencent.mm.storagebase.h)localObject);
    paramc = com.tencent.mm.plugin.p.d.EiT;
    this.FFf = ((com.tencent.mm.plugin.multitask.model.b)((com.tencent.mm.plugin.multitask.model.a)d.a.bj(com.tencent.mm.plugin.multitask.model.a.class)).bi(com.tencent.mm.plugin.multitask.model.b.class));
    this.appForegroundListener.alive();
    this.FFg = false;
    restoreDataFromStorageToMMKV();
    AppMethodBeat.o(248403);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(248401);
    Log.i(this.TAG, "onAccountRelease");
    this.FFf = null;
    this.appForegroundListener.dead();
    FFl = null;
    this.FFg = false;
    AppMethodBeat.o(248401);
  }
  
  public final void registerMultiTaskUIC(int paramInt, Class<? extends com.tencent.mm.plugin.multitask.ui.c> paramClass)
  {
    AppMethodBeat.i(248421);
    Log.i(this.TAG, "registerMultiTaskUIC type:" + paramInt + " clazzUic:" + paramClass);
    if (MMApplicationContext.isMainProcess()) {
      ((Map)FFk).put(Integer.valueOf(paramInt), paramClass);
    }
    AppMethodBeat.o(248421);
  }
  
  public final void removeTaskInfoAndCoverImg(String paramString)
  {
    AppMethodBeat.i(248449);
    if (paramString != null)
    {
      Object localObject = h.FFb;
      localObject = h.aQX(paramString);
      if (u.agG((String)localObject)) {
        u.deleteFile((String)localObject);
      }
      localObject = this.FFf;
      boolean bool;
      if (localObject != null)
      {
        p.k(paramString, "id");
        MultiTaskInfo localMultiTaskInfo = ((com.tencent.mm.plugin.multitask.model.b)localObject).aRb(paramString);
        if (localMultiTaskInfo != null) {
          if (com.tencent.mm.plugin.p.h.b((com.tencent.mm.plugin.p.h)localObject, (IAutoDBItem)localMultiTaskInfo, false, false, 6) > 0) {
            bool = true;
          }
        }
      }
      for (localObject = Boolean.valueOf(bool);; localObject = null)
      {
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).aLn(paramString);
        if ((p.h(localObject, Boolean.TRUE)) && (this.FFh.contains(paramString)))
        {
          this.FFh.remove(paramString);
          saveMultiTaskToMMKV();
        }
        Log.i(this.TAG, "removeTaskInfo id:" + paramString + " success:" + localObject);
        AppMethodBeat.o(248449);
        return;
        bool = false;
        break;
        bool = false;
        break;
      }
    }
    AppMethodBeat.o(248449);
  }
  
  public final void reportAddTaskInfo(MultiTaskInfo paramMultiTaskInfo, daq paramdaq)
  {
    AppMethodBeat.i(248451);
    if (paramdaq != null)
    {
      dak localdak = paramdaq.THY;
      if (localdak != null)
      {
        com.tencent.mm.plugin.multitask.d.a locala = com.tencent.mm.plugin.multitask.d.a.FHO;
        com.tencent.mm.plugin.multitask.d.a.a(paramMultiTaskInfo, localdak.THD, localdak.status, paramdaq.wmL, localdak.THE);
        AppMethodBeat.o(248451);
        return;
      }
    }
    AppMethodBeat.o(248451);
  }
  
  public final void reportInnerMultiTaskInfo(int paramInt, daq paramdaq)
  {
    AppMethodBeat.i(248446);
    if (paramdaq != null)
    {
      com.tencent.mm.plugin.multitask.d.a locala;
      if (paramInt == 2)
      {
        locala = com.tencent.mm.plugin.multitask.d.a.FHO;
        com.tencent.mm.plugin.multitask.d.a.a(paramdaq);
        locala = com.tencent.mm.plugin.multitask.d.a.FHO;
        com.tencent.mm.plugin.multitask.d.a.a(paramdaq.fNO, paramdaq.TIa);
        AppMethodBeat.o(248446);
        return;
      }
      if (paramInt == 3)
      {
        locala = com.tencent.mm.plugin.multitask.d.a.FHO;
        com.tencent.mm.plugin.multitask.d.a.b(paramdaq);
      }
    }
    AppMethodBeat.o(248446);
  }
  
  public final void reportMultiTaskInfo(int paramInt, daq paramdaq)
  {
    Object localObject3 = null;
    AppMethodBeat.i(248437);
    String str = this.TAG;
    if (paramdaq != null)
    {
      localObject1 = paramdaq.THW;
      if (paramdaq == null) {
        break label89;
      }
    }
    label89:
    for (Object localObject2 = Integer.valueOf(paramdaq.fNO);; localObject2 = null)
    {
      Log.d(str, "reportMultiTaskInfo, itemid: %s, itemtype: %d, reporttype: %d", new Object[] { localObject1, localObject2, Integer.valueOf(paramInt) });
      if (!MMApplicationContext.isMainProcess()) {
        break label95;
      }
      reportInnerMultiTaskInfo(paramInt, paramdaq);
      AppMethodBeat.o(248437);
      return;
      localObject1 = null;
      break;
    }
    label95:
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("reporttype", paramInt);
    Object localObject1 = localObject3;
    if (paramdaq != null) {
      localObject1 = paramdaq.toByteArray();
    }
    ((Bundle)localObject2).putByteArray("reportdata", (byte[])localObject1);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject2, k.class, (com.tencent.mm.ipcinvoker.f)new f(this));
    AppMethodBeat.o(248437);
  }
  
  public final void restoreDataFromStorageToMMKV()
  {
    AppMethodBeat.i(248406);
    Log.i(this.TAG, "restore data from storage");
    if (!com.tencent.mm.kernel.h.aHB())
    {
      Log.i(this.TAG, "account not ready!");
      AppMethodBeat.o(248406);
      return;
    }
    if (this.FFg)
    {
      Log.i(this.TAG, "restoreData already done!");
      AppMethodBeat.o(248406);
      return;
    }
    Object localObject = this.FFf;
    JSONArray localJSONArray;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitask.model.b)localObject).fbd();
      if (localObject == null) {
        break label247;
      }
      localJSONArray = new JSONArray();
    }
    label247:
    label254:
    for (;;)
    {
      try
      {
        localObject = ((List)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)((Iterator)localObject).next();
          JSONObject localJSONObject = MultiTaskInfo.aRa(localMultiTaskInfo.field_id);
          if (localJSONObject == null) {
            break label254;
          }
          localJSONArray.put(i, localJSONObject);
          if (!this.FFh.contains(localMultiTaskInfo.field_id)) {
            this.FFh.add(localMultiTaskInfo.field_id);
          }
          i += 1;
          continue;
          localObject = null;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localJSONException, "restoreDataFromStorageToMMKV fail, exception:%s", new Object[] { localJSONException });
        String str = localJSONArray.toString();
        p.j(str, "multiTaskInfoJsonArray.toString()");
        MultiProcessMMKV.getMMKV(this.FFj).encode(this.FFi, str);
        this.FFg = true;
        Log.i(this.TAG, "restore data done!");
      }
      AppMethodBeat.o(248406);
      return;
    }
  }
  
  public final void saveMultiTaskToMMKV()
  {
    AppMethodBeat.i(248409);
    Object localObject = new JSONArray();
    try
    {
      if (checkListNotEmpty((Collection)this.FFh))
      {
        Iterator localIterator = this.FFh.iterator();
        int i = 0;
        if (localIterator.hasNext())
        {
          JSONObject localJSONObject = MultiTaskInfo.aRa((String)localIterator.next());
          if (localJSONObject == null) {
            break label147;
          }
          int j = i + 1;
          ((JSONArray)localObject).put(i, localJSONObject);
          i = j;
        }
      }
      for (;;)
      {
        break;
      }
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localJSONException, "saveMultiTaskToMMKV fail, exception:%s", new Object[] { localJSONException });
      localObject = ((JSONArray)localObject).toString();
      p.j(localObject, "multiTaskInfosJsonArray.toString()");
      MultiProcessMMKV.getMMKV(this.FFj).encode(this.FFi, (String)localObject);
      AppMethodBeat.o(248409);
      return;
    }
  }
  
  public final void sendMultiTaskEvent(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(248425);
    p.k(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      localObject = new nk();
      ((nk)localObject).fLN.fLO = paramInt1;
      ((nk)localObject).fLN.type = paramInt2;
      ((nk)localObject).fLN.id = paramString;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(248425);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("id", paramString);
    ((Bundle)localObject).putInt("type", paramInt2);
    ((Bundle)localObject).putInt("event_type", paramInt1);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject, e.class, (com.tencent.mm.ipcinvoker.f)new g(this));
    AppMethodBeat.o(248425);
  }
  
  public final void setListener(b paramb)
  {
    FFl = paramb;
  }
  
  public final void setMultiTaskStorage(com.tencent.mm.plugin.multitask.model.b paramb)
  {
    this.FFf = paramb;
  }
  
  public final void updateTaskInfo(String paramString, int paramInt, dar paramdar, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(248454);
    p.k(paramString, "id");
    p.k(paramdar, "showData");
    com.tencent.mm.plugin.multitask.model.b localb = this.FFf;
    if (localb != null)
    {
      paramString = localb.aRb(paramString);
      if (paramString != null)
      {
        paramString.field_updateTime = cm.bfE();
        paramString.field_type = paramInt;
        paramString.field_showData = paramdar;
        if (paramArrayOfByte != null) {
          paramString.field_data = paramArrayOfByte;
        }
        paramdar = this.FFf;
        if (paramdar != null) {
          com.tencent.mm.plugin.p.h.a(paramdar, (IAutoDBItem)paramString);
        }
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(paramString);
        AppMethodBeat.o(248454);
        return;
      }
    }
    AppMethodBeat.o(248454);
  }
  
  public final void updateTaskInfoByBitmap(final String paramString, final int paramInt, final dar paramdar, final Bitmap paramBitmap, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(248432);
    p.k(paramString, "id");
    p.k(paramdar, "showData");
    Object localObject2 = this.TAG;
    Object localObject3 = new StringBuilder("updateTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    if (paramBitmap != null)
    {
      localObject1 = Integer.valueOf(paramBitmap.getByteCount());
      Log.i((String)localObject2, localObject1);
      if (!MMApplicationContext.isMainProcess()) {
        break label209;
      }
      paramdar.TIi = false;
      if (paramBitmap == null) {
        break label191;
      }
      localObject1 = h.FFb;
      localObject1 = h.aQX(paramString);
      if (u.agG((String)localObject1)) {
        u.deleteFile((String)localObject1);
      }
      localObject2 = g.FEX;
      localObject2 = h.FFb;
      localObject2 = g.e((String)localObject1, h.fap());
      com.tencent.mm.ay.q.bml().Wp((String)localObject2);
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
    }
    for (;;)
    {
      updateTaskInfo(paramString, paramInt, paramdar, paramArrayOfByte);
      AppMethodBeat.o(248432);
      return;
      localObject1 = null;
      break;
      label191:
      paramdar.TIi = true;
      Log.i(this.TAG, "updateTaskInfoByBitmap showData defaultBg mainProcess");
    }
    label209:
    Object localObject1 = new Bundle();
    paramdar.TIi = false;
    if (paramBitmap != null)
    {
      localObject2 = new StringBuilder();
      localObject3 = com.tencent.mm.vfs.ab.bCa("multitask");
      p.j(localObject3, "VFSStrategy.getTempDir(C…ITASK_STORAGE_DIR, false)");
      localObject2 = ((com.tencent.mm.vfs.q)localObject3).bOF() + "/" + paramString;
      if (u.agG((String)localObject2)) {
        u.deleteFile((String)localObject2);
      }
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject2, false);
      ((Bundle)localObject1).putString("path", (String)localObject2);
    }
    for (;;)
    {
      ((Bundle)localObject1).putString("id", paramString);
      ((Bundle)localObject1).putInt("type", paramInt);
      ((Bundle)localObject1).putByteArray("showData", paramdar.toByteArray());
      ((Bundle)localObject1).putByteArray("data", paramArrayOfByte);
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, m.class, (com.tencent.mm.ipcinvoker.f)new h(this, paramdar, paramBitmap, paramString, paramInt, paramArrayOfByte));
      AppMethodBeat.o(248432);
      return;
      paramdar.TIi = true;
      Log.i(this.TAG, "updateTaskInfoByBitmap showData defaultBg");
    }
  }
  
  public final void updateTaskInfoByTitle(final String paramString, final int paramInt, final dar paramdar, final byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(248447);
    p.k(paramString, "id");
    p.k(paramdar, "showData");
    if (MMApplicationContext.isMainProcess())
    {
      updateTaskInfo(paramString, paramInt, paramdar, paramArrayOfByte);
      AppMethodBeat.o(248447);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("type", paramInt);
    localBundle.putByteArray("showData", paramdar.toByteArray());
    localBundle.putByteArray("data", paramArrayOfByte);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, l.class, (com.tencent.mm.ipcinvoker.f)new i(this, paramString, paramInt, paramdar, paramArrayOfByte));
    AppMethodBeat.o(248447);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "", "getMultiTaskItemPosition", "", "id", "curPos", "", "way", "hasCurrentMultiInfo", "", "isDataEmpty", "markWechatForeground", "", "foreground", "plugin-multitask_release"})
  public static abstract interface b
  {
    public abstract boolean aQY(String paramString);
    
    public abstract String getMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2);
    
    public abstract boolean isDataEmpty();
    
    public abstract void kU(boolean paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback"})
  static final class c<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    c(PluginMultiTask paramPluginMultiTask) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitask/PluginMultiTask$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-multitask_release"})
  public static final class d
    extends o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(248710);
      p.k(paramString, "activity");
      Log.i(PluginMultiTask.access$getTAG$p(this.FFn), "onAppBackground, activity:%s", new Object[] { paramString });
      paramString = PluginMultiTask.FFm;
      paramString = PluginMultiTask.access$getMListener$cp();
      if (paramString != null)
      {
        paramString.kU(AppForegroundDelegate.fby.aax());
        AppMethodBeat.o(248710);
        return;
      }
      AppMethodBeat.o(248710);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(248709);
      p.k(paramString, "activity");
      Log.i(PluginMultiTask.access$getTAG$p(this.FFn), "onAppForeground, activity:%s", new Object[] { paramString });
      if ((AppForegroundDelegate.fby.aax()) && (com.tencent.mm.kernel.h.aHB()))
      {
        boolean bool = Util.isTopApplication(MMApplicationContext.getContext());
        Log.i(PluginMultiTask.access$getTAG$p(this.FFn), "onAppForeground isTopApplication: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = PluginMultiTask.FFm;
          paramString = PluginMultiTask.access$getMListener$cp();
          if (paramString != null) {
            paramString.kU(true);
          }
          this.FFn.restoreDataFromStorageToMMKV();
        }
      }
      AppMethodBeat.o(248709);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback"})
  static final class f<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    f(PluginMultiTask paramPluginMultiTask) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback"})
  static final class g<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    g(PluginMultiTask paramPluginMultiTask) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback", "com/tencent/mm/plugin/multitask/PluginMultiTask$updateTaskInfoByBitmap$1$3"})
  static final class h<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    h(PluginMultiTask paramPluginMultiTask, dar paramdar, Bitmap paramBitmap, String paramString, int paramInt, byte[] paramArrayOfByte) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bundle", "Landroid/os/Bundle;", "onCallback", "com/tencent/mm/plugin/multitask/PluginMultiTask$updateTaskInfoByTitle$1$1"})
  static final class i<T>
    implements com.tencent.mm.ipcinvoker.f<ResultType>
  {
    i(PluginMultiTask paramPluginMultiTask, String paramString, int paramInt, dar paramdar, byte[] paramArrayOfByte) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.PluginMultiTask
 * JD-Core Version:    0.7.0.1
 */
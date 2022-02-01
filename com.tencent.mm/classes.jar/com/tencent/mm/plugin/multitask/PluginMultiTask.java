package com.tencent.mm.plugin.multitask;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.or;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.ac.a.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.observer.StorageEventId;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/PluginMultiTask;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/multitask/IPluginMultiTask;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Landroidx/lifecycle/ViewModelStoreOwner;", "()V", "KEY_MULTITASK", "", "MMKV_MULTI_TASK_NAME", "TAG", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "hasRestoredDataFromStorageToMMKV", "", "multiTaskInfoList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "multiTaskStorage", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskLiveStorage;", "getMultiTaskStorage", "()Lcom/tencent/mm/plugin/multitask/model/MultiTaskLiveStorage;", "setMultiTaskStorage", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskLiveStorage;)V", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "addTaskInfo", "", "id", "type", "", "showData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "data", "", "reportdata", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "addTaskInfoByBitmap", "bitmap", "Landroid/graphics/Bitmap;", "checkListNotEmpty", "collection", "", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getInnerMultiTaskItemPosition", "curPos", "way", "getInnerTaskInfoById", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getMultiTaskFloatBallPosition", "Landroid/graphics/Point;", "getMultiTaskInfoList", "callback", "Lcom/tencent/mm/plugin/multitask/listener/OnGetMultiTaskInfoListCallback;", "getMultiTaskItemPosition", "getTaskInfoById", "getTaskInfoByType", "", "getViewModelStore", "hasTaskInfo", "multiTaskInfo", "hasTaskInfoById", "hasTaskInfoByMMKV", "installed", "isDataEmpty", "isMultiTaskMode", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "registerMultiTaskUIC", "clazz", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", "removeTaskInfoAndCoverImg", "reportAddTaskInfo", "reportInnerMultiTaskInfo", "reportType", "multiTaskReportData", "reportMultiTaskInfo", "reportInfo", "restoreDataFromStorageToMMKV", "saveMultiTaskToMMKV", "sendMultiTaskEvent", "eventType", "setListener", "listener", "Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "updateTaskInfo", "updateTaskInfoByBitmap", "updateTaskInfoByTitle", "Companion", "OnMultiTaskUICListener", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginMultiTask
  extends com.tencent.mm.kernel.b.f
  implements ak, com.tencent.mm.kernel.api.bucket.c, d
{
  public static final PluginMultiTask.a LBi;
  private static final HashMap<Integer, Class<? extends com.tencent.mm.plugin.multitask.ui.c>> LBo;
  private static b LBp;
  private com.tencent.mm.plugin.multitask.model.b LBj;
  private volatile boolean LBk;
  private final CopyOnWriteArrayList<String> LBl;
  private final String LBm;
  private final String LBn;
  private final String TAG;
  private final q.a appForegroundListener;
  private final aj er;
  
  static
  {
    AppMethodBeat.i(303785);
    LBi = new PluginMultiTask.a((byte)0);
    LBo = new HashMap();
    AppMethodBeat.o(303785);
  }
  
  public PluginMultiTask()
  {
    AppMethodBeat.i(303725);
    this.TAG = "MicroMsg.MultiTask.PluginMultiTask";
    this.LBl = new CopyOnWriteArrayList();
    this.LBm = "multitask";
    this.LBn = "multi_task_storage";
    this.er = new aj();
    this.appForegroundListener = ((q.a)new c(this));
    AppMethodBeat.o(303725);
  }
  
  private static final void addTaskInfoByBitmap$lambda-8(PluginMultiTask paramPluginMultiTask, Bundle paramBundle)
  {
    AppMethodBeat.i(303747);
    s.u(paramPluginMultiTask, "this$0");
    paramPluginMultiTask = paramPluginMultiTask.TAG;
    if (paramBundle == null) {}
    for (boolean bool = false;; bool = paramBundle.getBoolean("result"))
    {
      Log.i(paramPluginMultiTask, s.X("addTaskInfoByBitmap invoker callback result:", Boolean.valueOf(bool)));
      AppMethodBeat.o(303747);
      return;
    }
  }
  
  private static final void getMultiTaskInfoList$lambda-2(com.tencent.mm.plugin.multitask.c.a parama, MultiTaskListParcel paramMultiTaskListParcel)
  {
    AppMethodBeat.i(303731);
    if ((paramMultiTaskListParcel != null) && (paramMultiTaskListParcel.LBc != null))
    {
      List localList = paramMultiTaskListParcel.LBc;
      if ((localList != null) && (!localList.isEmpty())) {}
      for (int i = 1; i != 0; i = 0)
      {
        if (parama == null) {
          break label87;
        }
        parama.dl(paramMultiTaskListParcel.LBc);
        AppMethodBeat.o(303731);
        return;
      }
    }
    if (parama != null) {
      parama.dl((List)new ArrayList());
    }
    label87:
    AppMethodBeat.o(303731);
  }
  
  private static final void reportMultiTaskInfo$lambda-13(PluginMultiTask paramPluginMultiTask, Bundle paramBundle)
  {
    AppMethodBeat.i(303759);
    s.u(paramPluginMultiTask, "this$0");
    paramPluginMultiTask = paramPluginMultiTask.TAG;
    if (paramBundle == null) {}
    for (boolean bool = false;; bool = paramBundle.getBoolean("result"))
    {
      Log.i(paramPluginMultiTask, s.X("reportMultiTaskInfo invoker callback result:", Boolean.valueOf(bool)));
      AppMethodBeat.o(303759);
      return;
    }
  }
  
  private static final void sendMultiTaskEvent$lambda-3(PluginMultiTask paramPluginMultiTask, Bundle paramBundle)
  {
    AppMethodBeat.i(303739);
    s.u(paramPluginMultiTask, "this$0");
    paramPluginMultiTask = paramPluginMultiTask.TAG;
    if (paramBundle == null) {}
    for (boolean bool = false;; bool = paramBundle.getBoolean("result"))
    {
      Log.i(paramPluginMultiTask, s.X("hideMultiTaskUIC invoker callback result:", Boolean.valueOf(bool)));
      AppMethodBeat.o(303739);
      return;
    }
  }
  
  private static final void updateTaskInfoByBitmap$lambda-12$lambda-11(PluginMultiTask paramPluginMultiTask, Bundle paramBundle)
  {
    AppMethodBeat.i(303753);
    s.u(paramPluginMultiTask, "this$0");
    paramPluginMultiTask = paramPluginMultiTask.TAG;
    if (paramBundle == null) {}
    for (boolean bool = false;; bool = paramBundle.getBoolean("result"))
    {
      Log.i(paramPluginMultiTask, s.X("updateTaskInfoByBitmap invoker callback result:", Boolean.valueOf(bool)));
      AppMethodBeat.o(303753);
      return;
    }
  }
  
  private static final void updateTaskInfoByTitle$lambda-16$lambda-15(PluginMultiTask paramPluginMultiTask, Bundle paramBundle)
  {
    AppMethodBeat.i(303762);
    s.u(paramPluginMultiTask, "this$0");
    paramPluginMultiTask = paramPluginMultiTask.TAG;
    if (paramBundle == null) {}
    for (boolean bool = false;; bool = paramBundle.getBoolean("result"))
    {
      Log.i(paramPluginMultiTask, s.X("updateTaskInfoByTitle invoker callback result:", Boolean.valueOf(bool)));
      AppMethodBeat.o(303762);
      return;
    }
  }
  
  public final void addTaskInfo(String paramString, int paramInt, drz paramdrz, byte[] paramArrayOfByte, dry paramdry)
  {
    AppMethodBeat.i(304024);
    s.u(paramString, "id");
    s.u(paramdrz, "showData");
    MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
    localMultiTaskInfo.field_id = paramString;
    localMultiTaskInfo.field_type = paramInt;
    localMultiTaskInfo.field_createTime = cn.bDw();
    localMultiTaskInfo.field_updateTime = cn.bDw();
    localMultiTaskInfo.field_showData = paramdrz;
    localMultiTaskInfo.field_data = paramArrayOfByte;
    paramdrz = this.LBj;
    if (paramdrz == null)
    {
      paramdrz = null;
      reportAddTaskInfo(localMultiTaskInfo, paramdry);
      if ((s.p(paramdrz, Boolean.TRUE)) && (!this.LBl.contains(paramString)))
      {
        this.LBl.add(paramString);
        saveMultiTaskToMMKV();
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).d(localMultiTaskInfo);
      }
      if (s.p(paramdrz, Boolean.TRUE))
      {
        paramArrayOfByte = com.tencent.mm.plugin.multitask.e.b.LDn;
        if (!com.tencent.mm.plugin.multitask.e.b.gkp())
        {
          Log.i(this.TAG, "[enterTips] first Add!");
          paramArrayOfByte = com.tencent.mm.plugin.multitask.e.b.LDn;
          com.tencent.mm.plugin.multitask.e.b.zF(true);
          paramArrayOfByte = com.tencent.mm.plugin.multitask.e.b.LDn;
          com.tencent.mm.plugin.multitask.e.b.sz(System.currentTimeMillis());
        }
      }
      Log.i(this.TAG, "addTaskInfo id:" + paramString + " type:" + paramInt + " success:" + paramdrz + ' ' + localMultiTaskInfo.toJSON());
      AppMethodBeat.o(304024);
      return;
    }
    s.u(localMultiTaskInfo, "item");
    int i;
    label283:
    boolean bool;
    if (com.tencent.mm.plugin.ac.g.b((com.tencent.mm.plugin.ac.g)paramdrz, (IAutoDBItem)localMultiTaskInfo, false, false, 4) > 0)
    {
      i = 1;
      if (i == 0) {
        break label375;
      }
      bool = com.tencent.mm.plugin.ac.g.a((com.tencent.mm.plugin.ac.g)paramdrz, (IAutoDBItem)localMultiTaskInfo, false, false, 4);
      if (!bool) {
        break label396;
      }
      paramArrayOfByte = com.tencent.mm.plugin.multitask.model.c.LDh;
      paramArrayOfByte = new StorageObserverEvent((StorageEventId)com.tencent.mm.plugin.multitask.model.c.gkj(), null, 2, null);
      paramArrayOfByte.setEvent("single");
      paramArrayOfByte.setObj((IAutoDBItem)localMultiTaskInfo);
      paramdrz.getOwner().notify(paramArrayOfByte);
    }
    label396:
    for (;;)
    {
      paramdrz = Boolean.valueOf(bool);
      break;
      i = 0;
      break label283;
      label375:
      bool = com.tencent.mm.plugin.ac.g.a((com.tencent.mm.plugin.ac.g)paramdrz, (IAutoDBItem)localMultiTaskInfo, false, false, 6);
    }
  }
  
  public final void addTaskInfoByBitmap(String paramString, int paramInt, drz paramdrz, Bitmap paramBitmap, byte[] paramArrayOfByte, dry paramdry)
  {
    Object localObject2 = null;
    String str1 = null;
    AppMethodBeat.i(303942);
    s.u(paramString, "id");
    s.u(paramdrz, "showData");
    String str2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("addTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    if (paramBitmap == null)
    {
      localObject1 = null;
      Log.i(str2, localObject1);
      if (!MMApplicationContext.isMainProcess()) {
        break label232;
      }
      paramdrz.aaXR = false;
      if (paramBitmap != null) {
        break label158;
      }
    }
    for (paramBitmap = str1;; paramBitmap = Boolean.valueOf(BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, false)))
    {
      if (paramBitmap == null)
      {
        paramdrz.aaXR = true;
        Log.i(this.TAG, "addTaskInfoByBitmap showData defaultBg mainProcess");
      }
      addTaskInfo(paramString, paramInt, paramdrz, paramArrayOfByte, paramdry);
      AppMethodBeat.o(303942);
      return;
      localObject1 = Integer.valueOf(paramBitmap.getByteCount());
      break;
      label158:
      localObject1 = h.LBd;
      localObject1 = h.aNP(paramString);
      if (y.ZC((String)localObject1)) {
        y.deleteFile((String)localObject1);
      }
      localObject2 = g.LBa;
      localObject2 = h.LBd;
      localObject2 = g.e((String)localObject1, h.gju());
      r.bKe().Op((String)localObject2);
    }
    label232:
    Object localObject1 = new Bundle();
    paramdrz.aaXR = false;
    if (paramBitmap == null)
    {
      paramBitmap = null;
      if (paramBitmap == null)
      {
        paramdrz.aaXR = true;
        Log.i(this.TAG, "addTaskInfoByBitmap showData defaultBg");
      }
      ((Bundle)localObject1).putString("id", paramString);
      ((Bundle)localObject1).putInt("type", paramInt);
      ((Bundle)localObject1).putByteArray("showData", paramdrz.toByteArray());
      ((Bundle)localObject1).putByteArray("data", paramArrayOfByte);
      if (paramdry != null) {
        break label443;
      }
    }
    label443:
    for (paramString = (String)localObject2;; paramString = paramdry.toByteArray())
    {
      ((Bundle)localObject1).putByteArray("reportdata", paramString);
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, a.class, new PluginMultiTask..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(303942);
      return;
      str1 = com.tencent.mm.vfs.ah.v(af.eC("multitask", false).jKT()) + '/' + paramString;
      if (y.ZC(str1)) {
        y.deleteFile(str1);
      }
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, str1, false);
      ((Bundle)localObject1).putString("path", str1);
      paramBitmap = kotlin.ah.aiuX;
      break;
    }
  }
  
  public final boolean checkListNotEmpty(Collection<?> paramCollection)
  {
    AppMethodBeat.i(303907);
    if ((paramCollection != null) && (!paramCollection.isEmpty()))
    {
      AppMethodBeat.o(303907);
      return true;
    }
    AppMethodBeat.o(303907);
    return false;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void dependency() {}
  
  public final void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public final String getInnerMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(303979);
    s.u(paramString, "id");
    b localb = LBp;
    if (localb == null)
    {
      AppMethodBeat.o(303979);
      return null;
    }
    paramString = localb.getMultiTaskItemPosition(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(303979);
    return paramString;
  }
  
  public final MultiTaskInfo getInnerTaskInfoById(String paramString)
  {
    AppMethodBeat.i(304047);
    s.u(paramString, "id");
    com.tencent.mm.plugin.multitask.model.b localb = this.LBj;
    if (localb == null)
    {
      AppMethodBeat.o(304047);
      return null;
    }
    paramString = localb.aNT(paramString);
    AppMethodBeat.o(304047);
    return paramString;
  }
  
  public final Point getMultiTaskFloatBallPosition()
  {
    AppMethodBeat.i(304067);
    Point localPoint = new Point(0, f.vmp);
    AppMethodBeat.o(304067);
    return localPoint;
  }
  
  public final void getMultiTaskInfoList(com.tencent.mm.plugin.multitask.c.a parama)
  {
    AppMethodBeat.i(303912);
    Log.i(this.TAG, "getMultiTaskInfoList");
    if (MMApplicationContext.isMainProcess())
    {
      if (parama != null)
      {
        Object localObject1 = this.LBj;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.multitask.model.b)localObject1).gki())
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = (List)new ArrayList();
          }
          parama.dl((List)localObject2);
          AppMethodBeat.o(303912);
          return;
        }
      }
    }
    else {
      XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, b.class, new PluginMultiTask..ExternalSyntheticLambda5(parama));
    }
    AppMethodBeat.o(303912);
  }
  
  public final String getMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(303985);
    s.u(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      paramString = getInnerMultiTaskItemPosition(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(303985);
      return paramString;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("curPos", paramInt1);
    localBundle.putInt("way", paramInt2);
    paramString = (IPCString)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, n.class);
    if (paramString == null)
    {
      AppMethodBeat.o(303985);
      return null;
    }
    paramString = paramString.value;
    AppMethodBeat.o(303985);
    return paramString;
  }
  
  public final com.tencent.mm.plugin.multitask.model.b getMultiTaskStorage()
  {
    return this.LBj;
  }
  
  public final MultiTaskInfo getTaskInfoById(String paramString)
  {
    AppMethodBeat.i(304043);
    s.u(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      paramString = getInnerTaskInfoById(paramString);
      AppMethodBeat.o(304043);
      return paramString;
    }
    AppMethodBeat.o(304043);
    return null;
  }
  
  public final List<MultiTaskInfo> getTaskInfoByType(int paramInt)
  {
    AppMethodBeat.i(304038);
    Object localObject = this.LBj;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((com.tencent.mm.plugin.multitask.model.b)localObject).acp(paramInt))
    {
      localObject = (List)new ArrayList();
      AppMethodBeat.o(304038);
      return localObject;
    }
    AppMethodBeat.o(304038);
    return localObject;
  }
  
  public final aj getViewModelStore()
  {
    return this.er;
  }
  
  public final boolean hasTaskInfo(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(304056);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    boolean bool = hasTaskInfoByMMKV(paramMultiTaskInfo);
    AppMethodBeat.o(304056);
    return bool;
  }
  
  public final boolean hasTaskInfoById(String paramString)
  {
    AppMethodBeat.i(304051);
    s.u(paramString, "id");
    Object localObject = LBp;
    if (localObject == null)
    {
      localObject = this.LBj;
      if (localObject == null) {}
      for (paramString = null; paramString != null; paramString = ((com.tencent.mm.plugin.multitask.model.b)localObject).aNT(paramString))
      {
        AppMethodBeat.o(304051);
        return true;
      }
      AppMethodBeat.o(304051);
      return false;
    }
    boolean bool = ((b)localObject).aNQ(paramString);
    AppMethodBeat.o(304051);
    return bool;
  }
  
  public final boolean hasTaskInfoByMMKV(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(303903);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    localObject1 = MultiProcessMMKV.getMMKV(this.LBn).decodeString(this.LBm);
    if ((Util.isNullOrNil((String)localObject1)) && (!this.LBk))
    {
      if (MMApplicationContext.isMainProcess())
      {
        paramMultiTaskInfo = paramMultiTaskInfo.field_id;
        s.s(paramMultiTaskInfo, "multiTaskInfo.field_id");
        bool1 = hasTaskInfoById(paramMultiTaskInfo);
        AppMethodBeat.o(303903);
        return bool1;
      }
      paramMultiTaskInfo = (IPCBoolean)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)new IPCString(paramMultiTaskInfo.field_id), c.class);
      if (paramMultiTaskInfo == null)
      {
        AppMethodBeat.o(303903);
        return false;
      }
      bool1 = paramMultiTaskInfo.value;
      AppMethodBeat.o(303903);
      return bool1;
    }
    Log.d(this.TAG, "load, savedMuliTaskInfos:%s", new Object[] { localObject1 });
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      if (((JSONArray)localObject1).length() <= 0) {
        break label318;
      }
      k = ((JSONArray)localObject1).length();
      if (k <= 0) {
        break label318;
      }
      i = 0;
      bool1 = false;
    }
    catch (JSONException paramMultiTaskInfo)
    {
      for (;;)
      {
        try
        {
          int k;
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject2 == null) {
            break label315;
          }
          localObject2 = MultiTaskInfo.bA((JSONObject)localObject2);
          if (localObject2 == null) {
            break label315;
          }
          boolean bool2 = TextUtils.equals((CharSequence)((MultiTaskInfo)localObject2).field_id, (CharSequence)paramMultiTaskInfo.field_id);
          if (!bool2) {
            break label315;
          }
          bool1 = true;
          if (j < k) {
            continue;
          }
          Log.i(this.TAG, s.X("load, hasTaskInfoByMMKV: ", Boolean.valueOf(bool1)));
          AppMethodBeat.o(303903);
          return bool1;
        }
        catch (JSONException paramMultiTaskInfo)
        {
          int j;
          continue;
          int i = j;
        }
        paramMultiTaskInfo = paramMultiTaskInfo;
        bool1 = false;
        Log.printErrStackTrace(this.TAG, (Throwable)paramMultiTaskInfo, "load fail, exception:%s", new Object[] { paramMultiTaskInfo });
        continue;
        continue;
        continue;
        bool1 = false;
      }
    }
    j = i + 1;
  }
  
  public final void installed() {}
  
  public final boolean isDataEmpty()
  {
    AppMethodBeat.i(303976);
    Object localObject = LBp;
    if (localObject == null)
    {
      localObject = this.LBj;
      if (localObject == null)
      {
        AppMethodBeat.o(303976);
        return false;
      }
      localObject = ((com.tencent.mm.plugin.multitask.model.b)localObject).gki();
      if (localObject == null)
      {
        AppMethodBeat.o(303976);
        return false;
      }
      bool = ((List)localObject).isEmpty();
      AppMethodBeat.o(303976);
      return bool;
    }
    boolean bool = ((b)localObject).isDataEmpty();
    AppMethodBeat.o(303976);
    return bool;
  }
  
  public final boolean isMultiTaskMode()
  {
    AppMethodBeat.i(303969);
    boolean bool = aw.isMultiTaskMode();
    AppMethodBeat.o(303969);
    return bool;
  }
  
  public final String name()
  {
    return "PluginMultiTask";
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(303885);
    paramc = com.tencent.mm.plugin.ac.a.MnH;
    paramc = (com.tencent.mm.plugin.multitask.model.a)a.a.bW(com.tencent.mm.plugin.multitask.model.a.class);
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.h.baE().mCN;
    s.s(localh, "storage().dataDB");
    paramc.g(localh);
    paramc = com.tencent.mm.plugin.ac.a.MnH;
    this.LBj = ((com.tencent.mm.plugin.multitask.model.b)((com.tencent.mm.plugin.multitask.model.a)a.a.bW(com.tencent.mm.plugin.multitask.model.a.class)).bV(com.tencent.mm.plugin.multitask.model.b.class));
    this.appForegroundListener.alive();
    this.LBk = false;
    restoreDataFromStorageToMMKV();
    AppMethodBeat.o(303885);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(303875);
    Log.i(this.TAG, "onAccountRelease");
    this.LBj = null;
    this.appForegroundListener.dead();
    LBp = null;
    this.LBk = false;
    AppMethodBeat.o(303875);
  }
  
  public final void registerMultiTaskUIC(int paramInt, Class<? extends com.tencent.mm.plugin.multitask.ui.c> paramClass)
  {
    AppMethodBeat.i(303917);
    Log.i(this.TAG, "registerMultiTaskUIC type:" + paramInt + " clazzUic:" + paramClass);
    if (MMApplicationContext.isMainProcess()) {
      ((Map)LBo).put(Integer.valueOf(paramInt), paramClass);
    }
    AppMethodBeat.o(303917);
  }
  
  public final void removeTaskInfoAndCoverImg(String paramString)
  {
    AppMethodBeat.i(304007);
    Object localObject;
    if (paramString != null)
    {
      localObject = h.LBd;
      localObject = h.aNP(paramString);
      if (y.ZC((String)localObject)) {
        y.deleteFile((String)localObject);
      }
      localObject = getMultiTaskStorage();
      if (localObject == null)
      {
        localObject = null;
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).aIe(paramString);
        if ((s.p(localObject, Boolean.TRUE)) && (this.LBl.contains(paramString)))
        {
          this.LBl.remove(paramString);
          saveMultiTaskToMMKV();
        }
        Log.i(this.TAG, "removeTaskInfo id:" + paramString + " success:" + localObject);
      }
    }
    else
    {
      AppMethodBeat.o(304007);
      return;
    }
    s.u(paramString, "id");
    MultiTaskInfo localMultiTaskInfo = ((com.tencent.mm.plugin.multitask.model.b)localObject).aNT(paramString);
    boolean bool;
    if (localMultiTaskInfo != null) {
      if (com.tencent.mm.plugin.ac.g.b((com.tencent.mm.plugin.ac.g)localObject, (IAutoDBItem)localMultiTaskInfo, false, false, 6) > 0) {
        bool = true;
      }
    }
    for (;;)
    {
      localObject = Boolean.valueOf(bool);
      break;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final void reportAddTaskInfo(MultiTaskInfo paramMultiTaskInfo, dry paramdry)
  {
    AppMethodBeat.i(304014);
    drs localdrs;
    long l1;
    long l2;
    if (paramdry != null)
    {
      localdrs = paramdry.aaXH;
      if (localdrs != null)
      {
        com.tencent.mm.plugin.multitask.d.a locala = com.tencent.mm.plugin.multitask.d.a.LDj;
        l1 = localdrs.aaXm;
        l2 = localdrs.status;
        if (paramdry != null) {
          break label65;
        }
      }
    }
    label65:
    for (paramdry = null;; paramdry = paramdry.zIO)
    {
      com.tencent.mm.plugin.multitask.d.a.a(paramMultiTaskInfo, l1, l2, paramdry, localdrs.aaXn);
      AppMethodBeat.o(304014);
      return;
    }
  }
  
  public final void reportInnerMultiTaskInfo(int paramInt, dry paramdry)
  {
    AppMethodBeat.i(303994);
    if (paramdry != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(303994);
      return;
      com.tencent.mm.plugin.multitask.d.a locala = com.tencent.mm.plugin.multitask.d.a.LDj;
      com.tencent.mm.plugin.multitask.d.a.a(paramdry);
      locala = com.tencent.mm.plugin.multitask.d.a.LDj;
      com.tencent.mm.plugin.multitask.d.a.a(paramdry.itemType, paramdry.aaXJ);
      AppMethodBeat.o(303994);
      return;
      locala = com.tencent.mm.plugin.multitask.d.a.LDj;
      com.tencent.mm.plugin.multitask.d.a.b(paramdry);
    }
  }
  
  public final void reportMultiTaskInfo(int paramInt, dry paramdry)
  {
    Object localObject2 = null;
    AppMethodBeat.i(303964);
    String str = this.TAG;
    if (paramdry == null)
    {
      localObject1 = null;
      if (paramdry != null) {
        break label83;
      }
    }
    label83:
    for (Integer localInteger = null;; localInteger = Integer.valueOf(paramdry.itemType))
    {
      Log.d(str, "reportMultiTaskInfo, itemid: %s, itemtype: %d, reporttype: %d", new Object[] { localObject1, localInteger, Integer.valueOf(paramInt) });
      if (!MMApplicationContext.isMainProcess()) {
        break label95;
      }
      reportInnerMultiTaskInfo(paramInt, paramdry);
      AppMethodBeat.o(303964);
      return;
      localObject1 = paramdry.aaXF;
      break;
    }
    label95:
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("reporttype", paramInt);
    if (paramdry == null) {}
    for (paramdry = localObject2;; paramdry = paramdry.toByteArray())
    {
      ((Bundle)localObject1).putByteArray("reportdata", paramdry);
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, k.class, new PluginMultiTask..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(303964);
      return;
    }
  }
  
  public final void restoreDataFromStorageToMMKV()
  {
    AppMethodBeat.i(303892);
    Log.i(this.TAG, "restore data from storage");
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.i(this.TAG, "account not ready!");
      AppMethodBeat.o(303892);
      return;
    }
    if (this.LBk)
    {
      Log.i(this.TAG, "restoreData already done!");
      AppMethodBeat.o(303892);
      return;
    }
    Object localObject1 = this.LBj;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label289;
      }
      localObject2 = new JSONArray();
    }
    for (;;)
    {
      int j;
      try
      {
        Iterator localIterator = ((List)localObject1).iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)localIterator.next();
          JSONObject localJSONObject = MultiTaskInfo.aNS(localMultiTaskInfo.field_id);
          if (localJSONObject == null) {
            continue;
          }
          j = i + 1;
          ((JSONArray)localObject2).put(i, localJSONObject);
          if (this.LBl.contains(localMultiTaskInfo.field_id)) {
            break label296;
          }
          this.LBl.add(localMultiTaskInfo.field_id);
          i = j;
          continue;
          localObject1 = ((com.tencent.mm.plugin.multitask.model.b)localObject1).gki();
        }
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)localJSONException, "restoreDataFromStorageToMMKV fail, exception:%s", new Object[] { localJSONException });
        localObject2 = ((JSONArray)localObject2).toString();
        s.s(localObject2, "multiTaskInfoJsonArray.toString()");
        MultiProcessMMKV.getMMKV(this.LBn).encode(this.LBm, (String)localObject2);
        this.LBk = true;
        Log.i(this.TAG, "restore data done!");
        localObject2 = (com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class);
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.handoff.a.a)localObject2).ix((List)localObject1);
          localObject1 = kotlin.ah.aiuX;
        }
      }
      label289:
      AppMethodBeat.o(303892);
      return;
      label296:
      int i = j;
    }
  }
  
  public final void saveMultiTaskToMMKV()
  {
    AppMethodBeat.i(303898);
    Object localObject = new JSONArray();
    try
    {
      if (checkListNotEmpty((Collection)this.LBl))
      {
        Iterator localIterator = this.LBl.iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          JSONObject localJSONObject = MultiTaskInfo.aNS((String)localIterator.next());
          if (localJSONObject != null)
          {
            ((JSONArray)localObject).put(i, localJSONObject);
            i += 1;
          }
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)localJSONException, "saveMultiTaskToMMKV fail, exception:%s", new Object[] { localJSONException });
      localObject = ((JSONArray)localObject).toString();
      s.s(localObject, "multiTaskInfosJsonArray.toString()");
      MultiProcessMMKV.getMMKV(this.LBn).encode(this.LBm, (String)localObject);
      AppMethodBeat.o(303898);
    }
  }
  
  public final void sendMultiTaskEvent(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(303927);
    s.u(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      localObject = new or();
      ((or)localObject).hRw.hRx = paramInt1;
      ((or)localObject).hRw.type = paramInt2;
      ((or)localObject).hRw.id = paramString;
      ((or)localObject).publish();
      AppMethodBeat.o(303927);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("id", paramString);
    ((Bundle)localObject).putInt("type", paramInt2);
    ((Bundle)localObject).putInt("event_type", paramInt1);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject, e.class, new PluginMultiTask..ExternalSyntheticLambda4(this));
    AppMethodBeat.o(303927);
  }
  
  public final void setListener(b paramb)
  {
    LBp = paramb;
  }
  
  public final void setMultiTaskStorage(com.tencent.mm.plugin.multitask.model.b paramb)
  {
    this.LBj = paramb;
  }
  
  public final void updateTaskInfo(String paramString, int paramInt, drz paramdrz, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(304031);
    s.u(paramString, "id");
    s.u(paramdrz, "showData");
    com.tencent.mm.plugin.multitask.model.b localb = this.LBj;
    if (localb != null)
    {
      paramString = localb.aNT(paramString);
      if (paramString != null)
      {
        paramString.field_updateTime = cn.bDw();
        paramString.field_type = paramInt;
        paramString.field_showData = paramdrz;
        if (paramArrayOfByte != null) {
          paramString.field_data = paramArrayOfByte;
        }
        paramdrz = getMultiTaskStorage();
        if (paramdrz != null) {
          com.tencent.mm.plugin.ac.g.a((com.tencent.mm.plugin.ac.g)paramdrz, (IAutoDBItem)paramString);
        }
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(paramString);
      }
    }
    AppMethodBeat.o(304031);
  }
  
  public final void updateTaskInfoByBitmap(String paramString, int paramInt, drz paramdrz, Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    AppMethodBeat.i(303956);
    s.u(paramString, "id");
    s.u(paramdrz, "showData");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("updateTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    if (paramBitmap == null)
    {
      localObject1 = null;
      Log.i(str, localObject1);
      if (!MMApplicationContext.isMainProcess()) {
        break label214;
      }
      paramdrz.aaXR = false;
      if (paramBitmap == null) {
        break label196;
      }
      localObject1 = h.LBd;
      localObject1 = h.aNP(paramString);
      if (y.ZC((String)localObject1)) {
        y.deleteFile((String)localObject1);
      }
      localObject2 = g.LBa;
      localObject2 = h.LBd;
      localObject2 = g.e((String)localObject1, h.gju());
      r.bKe().Op((String)localObject2);
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject1, false);
    }
    for (;;)
    {
      updateTaskInfo(paramString, paramInt, paramdrz, paramArrayOfByte);
      AppMethodBeat.o(303956);
      return;
      localObject1 = Integer.valueOf(paramBitmap.getByteCount());
      break;
      label196:
      paramdrz.aaXR = true;
      Log.i(this.TAG, "updateTaskInfoByBitmap showData defaultBg mainProcess");
    }
    label214:
    Object localObject1 = new Bundle();
    paramdrz.aaXR = false;
    if (paramBitmap == null) {}
    for (paramBitmap = (Bitmap)localObject2;; paramBitmap = kotlin.ah.aiuX)
    {
      if (paramBitmap == null)
      {
        paramdrz.aaXR = true;
        Log.i(this.TAG, "updateTaskInfoByBitmap showData defaultBg");
      }
      ((Bundle)localObject1).putString("id", paramString);
      ((Bundle)localObject1).putInt("type", paramInt);
      ((Bundle)localObject1).putByteArray("showData", paramdrz.toByteArray());
      ((Bundle)localObject1).putByteArray("data", paramArrayOfByte);
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, m.class, new PluginMultiTask..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(303956);
      return;
      localObject2 = com.tencent.mm.vfs.ah.v(af.eC("multitask", false).jKT()) + '/' + paramString;
      if (y.ZC((String)localObject2)) {
        y.deleteFile((String)localObject2);
      }
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, (String)localObject2, false);
      ((Bundle)localObject1).putString("path", (String)localObject2);
    }
  }
  
  public final void updateTaskInfoByTitle(String paramString, int paramInt, drz paramdrz, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(304001);
    s.u(paramString, "id");
    s.u(paramdrz, "showData");
    if (MMApplicationContext.isMainProcess())
    {
      updateTaskInfo(paramString, paramInt, paramdrz, paramArrayOfByte);
      AppMethodBeat.o(304001);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("type", paramInt);
    localBundle.putByteArray("showData", paramdrz.toByteArray());
    localBundle.putByteArray("data", paramArrayOfByte);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, l.class, new PluginMultiTask..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(304001);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/PluginMultiTask$OnMultiTaskUICListener;", "", "getMultiTaskItemPosition", "", "id", "curPos", "", "way", "hasCurrentMultiInfo", "", "isDataEmpty", "markWechatForeground", "", "foreground", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract boolean aNQ(String paramString);
    
    public abstract String getMultiTaskItemPosition(String paramString, int paramInt1, int paramInt2);
    
    public abstract boolean isDataEmpty();
    
    public abstract void mh(boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitask/PluginMultiTask$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends q.a
  {
    c(PluginMultiTask paramPluginMultiTask) {}
    
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(303710);
      s.u(paramString, "activity");
      Log.i(PluginMultiTask.access$getTAG$p(this.LBq), "onAppBackground, activity:%s", new Object[] { paramString });
      paramString = PluginMultiTask.LBi;
      paramString = PluginMultiTask.access$getMListener$cp();
      if (paramString != null) {
        paramString.mh(AppForegroundDelegate.heY.eLx);
      }
      AppMethodBeat.o(303710);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(303708);
      s.u(paramString, "activity");
      Log.i(PluginMultiTask.access$getTAG$p(this.LBq), "onAppForeground, activity:%s", new Object[] { paramString });
      if ((AppForegroundDelegate.heY.eLx) && (com.tencent.mm.kernel.h.baz()))
      {
        boolean bool = Util.isTopApplication(MMApplicationContext.getContext());
        Log.i(PluginMultiTask.access$getTAG$p(this.LBq), "onAppForeground isTopApplication: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool)
        {
          paramString = PluginMultiTask.LBi;
          paramString = PluginMultiTask.access$getMListener$cp();
          if (paramString != null) {
            paramString.mh(true);
          }
          this.LBq.restoreDataFromStorageToMMKV();
        }
      }
      AppMethodBeat.o(303708);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.PluginMultiTask
 * JD-Core Version:    0.7.0.1
 */
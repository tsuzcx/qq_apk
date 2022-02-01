package com.tencent.mm.plugin.taskbar;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.lifecycle.aa;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.plugin.taskbar.ui.section.d;
import com.tencent.mm.plugin.taskbar.ui.section.d.a;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/PluginTaskBar;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/taskbar/IPluginTaskBar;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Landroidx/lifecycle/ViewModelStoreOwner;", "()V", "TAG", "", "taskBarStorage", "Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "getTaskBarStorage", "()Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "setTaskBarStorage", "(Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;)V", "taskBarViewService", "Lcom/tencent/mm/plugin/taskbar/TaskBarViewService;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "addOrUpdateTaskInfo", "", "id", "type", "", "showData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "data", "", "addOrUpdateTaskInfoByBitmap", "bitmap", "Landroid/graphics/Bitmap;", "addToMultiTask", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getInnerTaskInfoById", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getTaskInfoById", "getTaskInfoByType", "", "getViewModelStore", "installed", "name", "notifyClickTaskBarItem", "multiTaskInfo", "notifyClickTaskBarItem$plugin_taskbar_release", "notifyExposeTaskBarItem", "notifyExposeTaskBarItem$plugin_taskbar_release", "notifyRemoveTaskBarItem", "notifyRemoveTaskBarItem$plugin_taskbar_release", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "removeTaskInfo", "isNotify", "", "scene", "saveBitmapToImageProtected", "path", "callback", "Lkotlin/Function0;", "updateTaskInfo", "updateBitmapOnly", "updateTaskInfoByBitmap", "Companion", "plugin-taskbar_release"})
public final class PluginTaskBar
  extends com.tencent.mm.kernel.b.f
  implements androidx.lifecycle.ab, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, c
{
  public static final PluginTaskBar.a MlX;
  private h MlV;
  private final i MlW;
  private final String TAG;
  private final aa VK;
  
  static
  {
    AppMethodBeat.i(214885);
    MlX = new PluginTaskBar.a((byte)0);
    AppMethodBeat.o(214885);
  }
  
  public PluginTaskBar()
  {
    AppMethodBeat.i(214884);
    this.TAG = "MicroMsg.TaskBar.PluginTaskBar";
    this.MlW = new i();
    this.VK = new aa();
    AppMethodBeat.o(214884);
  }
  
  private final void saveBitmapToImageProtected(Bitmap paramBitmap, String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(214853);
    com.tencent.e.h.ZvG.bf((Runnable)new PluginTaskBar.g(this, paramBitmap, paramString, parama));
    AppMethodBeat.o(214853);
  }
  
  public final void addOrUpdateTaskInfo(String paramString, int paramInt, dar paramdar, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214863);
    p.k(paramString, "id");
    Object localObject = getInnerTaskInfoById(paramString);
    h localh;
    if (localObject != null)
    {
      Log.i(this.TAG, "updateTaskInfo id:" + paramString + " type:" + paramInt);
      ((MultiTaskInfo)localObject).field_updateTime = System.currentTimeMillis();
      ((MultiTaskInfo)localObject).field_showData = paramdar;
      if (paramArrayOfByte != null) {
        ((MultiTaskInfo)localObject).field_data = paramArrayOfByte;
      }
      localh = this.MlV;
      if (localh == null) {
        break label217;
      }
    }
    label217:
    for (localObject = Boolean.valueOf(localh.a((MultiTaskInfo)localObject, new String[0]));; localObject = null)
    {
      if (localObject == null)
      {
        Log.i(this.TAG, "addTaskInfo id:" + paramString + " type:" + paramInt);
        localObject = new MultiTaskInfo();
        ((MultiTaskInfo)localObject).field_id = paramString;
        ((MultiTaskInfo)localObject).field_type = paramInt;
        ((MultiTaskInfo)localObject).field_createTime = System.currentTimeMillis();
        ((MultiTaskInfo)localObject).field_updateTime = System.currentTimeMillis();
        ((MultiTaskInfo)localObject).field_showData = paramdar;
        ((MultiTaskInfo)localObject).field_data = paramArrayOfByte;
        paramString = this.MlV;
        if (paramString != null) {
          paramString.m((MultiTaskInfo)localObject);
        }
      }
      AppMethodBeat.o(214863);
      return;
    }
  }
  
  public final void addOrUpdateTaskInfoByBitmap(String paramString, int paramInt, dar paramdar, Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    AppMethodBeat.i(214859);
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("addTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    if (paramBitmap != null) {}
    for (Object localObject1 = Integer.valueOf(paramBitmap.getByteCount());; localObject1 = null)
    {
      Log.i((String)localObject3, localObject1);
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(214859);
      return;
    }
    if (MMApplicationContext.isMainProcess())
    {
      if (!com.tencent.mm.kernel.h.aHB())
      {
        AppMethodBeat.o(214859);
        return;
      }
      if (paramBitmap != null)
      {
        localObject1 = f.Mnf;
        localObject1 = f.aQX(paramString);
        if (u.agG((String)localObject1)) {
          u.deleteFile((String)localObject1);
        }
        saveBitmapToImageProtected(paramBitmap, (String)localObject1, (kotlin.g.a.a)PluginTaskBar.d.Mmb);
        localObject2 = d.MqY;
        if (d.a.ajc(paramInt))
        {
          localObject2 = f.Mnf;
          localObject2 = e.Mnd;
          p.j(localObject2, "SNAPSHOT_LOADER_OPTION");
          localObject1 = f.f((String)localObject1, (com.tencent.mm.ay.a.a.c)localObject2);
          com.tencent.mm.ay.q.bml().Wp((String)localObject1);
          com.tencent.mm.ay.q.bml().h((String)localObject1, paramBitmap);
        }
      }
      addOrUpdateTaskInfo(paramString, paramInt, paramdar, paramArrayOfByte);
      AppMethodBeat.o(214859);
      return;
    }
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("addType", 1);
    ((Bundle)localObject3).putString("id", paramString);
    ((Bundle)localObject3).putInt("type", paramInt);
    localObject1 = localObject2;
    if (paramdar != null) {
      localObject1 = paramdar.toByteArray();
    }
    ((Bundle)localObject3).putByteArray("showData", (byte[])localObject1);
    ((Bundle)localObject3).putByteArray("data", paramArrayOfByte);
    if (paramBitmap != null)
    {
      paramdar = new StringBuilder();
      paramArrayOfByte = com.tencent.mm.vfs.ab.bCa("taskbar");
      p.j(paramArrayOfByte, "VFSStrategy.getTempDir(C…SKBAR_STORAGE_DIR, false)");
      paramdar = paramArrayOfByte.bOF() + "/" + paramString;
      if (u.agG(paramdar)) {
        u.deleteFile(paramdar);
      }
      saveBitmapToImageProtected(paramBitmap, paramdar, (kotlin.g.a.a)new PluginTaskBar.b(paramdar, this, paramString, (Bundle)localObject3));
      AppMethodBeat.o(214859);
      return;
    }
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject3, a.class, (com.tencent.mm.ipcinvoker.f)new PluginTaskBar.c(this, (Bundle)localObject3));
    AppMethodBeat.o(214859);
  }
  
  public final void addToMultiTask(String paramString)
  {
    AppMethodBeat.i(214845);
    p.k(paramString, "id");
    MultiTaskInfo localMultiTaskInfo = getInnerTaskInfoById(paramString);
    if (localMultiTaskInfo != null)
    {
      Object localObject = f.Mnf;
      localObject = f.aQX(paramString);
      com.tencent.mm.plugin.multitask.h localh = com.tencent.mm.plugin.multitask.h.FFb;
      u.on((String)localObject, com.tencent.mm.plugin.multitask.h.aQX(paramString));
      localObject = ((PluginMultiTask)com.tencent.mm.kernel.h.ag(PluginMultiTask.class)).getMultiTaskStorage();
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.multitask.model.b)localObject).aRb(paramString) == null)
        {
          com.tencent.mm.plugin.p.h.a((com.tencent.mm.plugin.p.h)localObject, (IAutoDBItem)localMultiTaskInfo, false, false, 6);
          paramString = com.tencent.mm.plugin.multitask.d.a.FHO;
          com.tencent.mm.plugin.multitask.d.a.a(localMultiTaskInfo, 3L, 2L, "", "");
          AppMethodBeat.o(214845);
          return;
        }
        com.tencent.mm.plugin.p.h.a((com.tencent.mm.plugin.p.h)localObject, (IAutoDBItem)localMultiTaskInfo);
        paramString = com.tencent.mm.plugin.multitask.d.a.FHO;
        com.tencent.mm.plugin.multitask.d.a.a(localMultiTaskInfo, 3L, 1L, "", "");
        AppMethodBeat.o(214845);
        return;
      }
      AppMethodBeat.o(214845);
      return;
    }
    AppMethodBeat.o(214845);
  }
  
  public final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(214839);
    Log.i(this.TAG, "onAccountRelease");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("TaskBarInfo".hashCode()), e.Mmc);
    AppMethodBeat.o(214839);
    return localHashMap;
  }
  
  public final void configure(g paramg) {}
  
  public final void dependency()
  {
    AppMethodBeat.i(214837);
    super.dependency();
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(214837);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(214831);
    if (paramg != null)
    {
      if (paramg.aIE() == true)
      {
        com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.taskbar.api.b.class, (com.tencent.mm.kernel.c.a)this.MlW);
        paramg = com.tencent.mm.plugin.taskbar.ui.a.b.Mqv;
        paramg = MMApplicationContext.getContext();
        p.j(paramg, "MMApplicationContext.getContext()");
        com.tencent.mm.plugin.taskbar.ui.a.b.init(paramg);
      }
      AppMethodBeat.o(214831);
      return;
    }
    AppMethodBeat.o(214831);
  }
  
  public final MultiTaskInfo getInnerTaskInfoById(String paramString)
  {
    AppMethodBeat.i(214879);
    p.k(paramString, "id");
    h localh = this.MlV;
    if (localh != null)
    {
      paramString = localh.aRb(paramString);
      AppMethodBeat.o(214879);
      return paramString;
    }
    AppMethodBeat.o(214879);
    return null;
  }
  
  public final h getTaskBarStorage()
  {
    return this.MlV;
  }
  
  public final MultiTaskInfo getTaskInfoById(String paramString)
  {
    AppMethodBeat.i(214877);
    p.k(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      paramString = getInnerTaskInfoById(paramString);
      AppMethodBeat.o(214877);
      return paramString;
    }
    AppMethodBeat.o(214877);
    return null;
  }
  
  public final List<MultiTaskInfo> getTaskInfoByType(int paramInt)
  {
    AppMethodBeat.i(214875);
    Object localObject = this.MlV;
    if (localObject != null)
    {
      localObject = ((h)localObject).db.rawQuery("SELECT * FROM TaskBarInfo WHERE type = ? ORDER BY updateTime DESC;", new String[] { String.valueOf(paramInt) });
      ArrayList localArrayList = new ArrayList();
      while (((Cursor)localObject).moveToNext())
      {
        MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
        localMultiTaskInfo.convertFrom((Cursor)localObject);
        localArrayList.add(localMultiTaskInfo);
      }
      ((Cursor)localObject).close();
      localObject = (List)localArrayList;
      AppMethodBeat.o(214875);
      return localObject;
    }
    localObject = (List)new ArrayList();
    AppMethodBeat.o(214875);
    return localObject;
  }
  
  public final aa getViewModelStore()
  {
    return this.VK;
  }
  
  public final void installed() {}
  
  public final String name()
  {
    return "PluginTaskBar";
  }
  
  public final void notifyClickTaskBarItem$plugin_taskbar_release(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(214833);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject = this.MlW;
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewService", "notifyClick " + paramMultiTaskInfo.fbc().title + ' ' + paramMultiTaskInfo.field_id + ' ' + paramMultiTaskInfo.field_type);
    localObject = (HashSet)((i)localObject).lWz.get(paramMultiTaskInfo.field_type);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).b(paramMultiTaskInfo);
      }
      AppMethodBeat.o(214833);
      return;
    }
    AppMethodBeat.o(214833);
  }
  
  public final void notifyExposeTaskBarItem$plugin_taskbar_release(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(214834);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject = this.MlW;
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    localObject = (HashSet)((i)localObject).lWz.get(paramMultiTaskInfo.field_type);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).a(paramMultiTaskInfo);
      }
      AppMethodBeat.o(214834);
      return;
    }
    AppMethodBeat.o(214834);
  }
  
  public final void notifyRemoveTaskBarItem$plugin_taskbar_release(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(214835);
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject = this.MlW;
    p.k(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewService", "notifyRemoveTaskBarItem " + paramMultiTaskInfo.fbc().title + ' ' + paramMultiTaskInfo.field_id + ' ' + paramMultiTaskInfo.field_type);
    localObject = (HashSet)((i)localObject).lWz.get(paramMultiTaskInfo.field_type);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).c(paramMultiTaskInfo);
      }
      AppMethodBeat.o(214835);
      return;
    }
    AppMethodBeat.o(214835);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(214841);
    Log.i(this.TAG, "onAccountInitialized");
    if (this.MlV == null)
    {
      paramc = com.tencent.mm.kernel.h.aHG();
      p.j(paramc, "MMKernel.storage()");
      paramc = paramc.getDataDB();
      p.j(paramc, "MMKernel.storage().dataDB");
      this.MlV = new h((ISQLiteDatabase)paramc);
    }
    AppMethodBeat.o(214841);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(214842);
    Log.i(this.TAG, "onAccountRelease");
    this.MlV = null;
    AppMethodBeat.o(214842);
  }
  
  public final void removeTaskInfo(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(214849);
    Log.i(this.TAG, "removeTaskInfo " + paramString + ' ' + paramBoolean + ' ' + paramInt);
    if (MMApplicationContext.isMainProcess())
    {
      if (!com.tencent.mm.kernel.h.aHB())
      {
        AppMethodBeat.o(214849);
        return;
      }
      if (paramString != null)
      {
        localObject = f.Mnf;
        localObject = f.aQX(paramString);
        if (u.agG((String)localObject)) {
          u.deleteFile((String)localObject);
        }
        localObject = this.MlV;
        if (localObject != null)
        {
          p.k(paramString, "id");
          paramString = ((h)localObject).aRb(paramString);
          if (paramString != null)
          {
            Log.i("MicroMsg.TaskBarStorage", "delete:" + paramString.field_type + ' ' + paramString.field_id + ' ' + paramString.fbc().title + ' ' + paramInt);
            ((h)localObject).delete((IAutoDBItem)paramString, false, new String[0]);
            if (paramBoolean)
            {
              h.b localb = new h.b();
              p.k(paramString, "<set-?>");
              localb.FNi = paramString;
              localb.Dyj = paramInt;
              ((h)localObject).doNotify("single", 5, localb);
            }
            AppMethodBeat.o(214849);
            return;
          }
          AppMethodBeat.o(214849);
          return;
        }
        AppMethodBeat.o(214849);
        return;
      }
      AppMethodBeat.o(214849);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("id", paramString);
    ((Bundle)localObject).putInt("scene", paramInt);
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject, b.class, (com.tencent.mm.ipcinvoker.f)new PluginTaskBar.f(this));
    AppMethodBeat.o(214849);
  }
  
  public final void setTaskBarStorage(h paramh)
  {
    this.MlV = paramh;
  }
  
  public final void updateTaskInfo(String paramString, int paramInt, dar paramdar, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(214872);
    p.k(paramString, "id");
    MultiTaskInfo localMultiTaskInfo = getInnerTaskInfoById(paramString);
    if (localMultiTaskInfo != null)
    {
      Log.i(this.TAG, "updateTaskInfo id:" + paramString + " type:" + paramInt + " updateBitmapOnly:" + paramBoolean);
      localMultiTaskInfo.field_updateTime = System.currentTimeMillis();
      if (!paramBoolean)
      {
        localMultiTaskInfo.field_showData = paramdar;
        if (paramArrayOfByte != null) {
          localMultiTaskInfo.field_data = paramArrayOfByte;
        }
      }
      paramString = this.MlV;
      if (paramString != null)
      {
        paramString.a(localMultiTaskInfo, new String[0]);
        AppMethodBeat.o(214872);
        return;
      }
      AppMethodBeat.o(214872);
      return;
    }
    AppMethodBeat.o(214872);
  }
  
  public final void updateTaskInfoByBitmap(String paramString, int paramInt, dar paramdar, Bitmap paramBitmap, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(214868);
    Object localObject3 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("updateTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    if (paramBitmap != null) {}
    for (Object localObject1 = Integer.valueOf(paramBitmap.getByteCount());; localObject1 = null)
    {
      Log.i((String)localObject3, localObject1 + " updateBitmapOnly:" + paramBoolean);
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(214868);
      return;
    }
    if (MMApplicationContext.isMainProcess())
    {
      if (!com.tencent.mm.kernel.h.aHB())
      {
        AppMethodBeat.o(214868);
        return;
      }
      if (paramBitmap != null)
      {
        localObject1 = f.Mnf;
        localObject1 = f.aQX(paramString);
        if (u.agG((String)localObject1)) {
          u.deleteFile((String)localObject1);
        }
        saveBitmapToImageProtected(paramBitmap, (String)localObject1, (kotlin.g.a.a)PluginTaskBar.j.Mme);
        localObject2 = d.MqY;
        if (d.a.ajc(paramInt))
        {
          localObject2 = f.Mnf;
          localObject2 = e.Mnd;
          p.j(localObject2, "SNAPSHOT_LOADER_OPTION");
          localObject1 = f.f((String)localObject1, (com.tencent.mm.ay.a.a.c)localObject2);
          com.tencent.mm.ay.q.bml().h((String)localObject1, paramBitmap);
        }
      }
      updateTaskInfo(paramString, paramInt, paramdar, paramArrayOfByte, paramBoolean);
      AppMethodBeat.o(214868);
      return;
    }
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("addType", 2);
    ((Bundle)localObject3).putString("id", paramString);
    ((Bundle)localObject3).putInt("type", paramInt);
    localObject1 = localObject2;
    if (paramdar != null) {
      localObject1 = paramdar.toByteArray();
    }
    ((Bundle)localObject3).putByteArray("showData", (byte[])localObject1);
    ((Bundle)localObject3).putByteArray("data", paramArrayOfByte);
    ((Bundle)localObject3).putBoolean("updateBitmapOnly", paramBoolean);
    if (paramBitmap != null)
    {
      paramdar = new StringBuilder();
      paramArrayOfByte = com.tencent.mm.vfs.ab.bCa("taskbar");
      p.j(paramArrayOfByte, "VFSStrategy.getTempDir(C…SKBAR_STORAGE_DIR, false)");
      paramdar = paramArrayOfByte.bOF() + "/" + paramString;
      if (u.agG(paramdar)) {
        u.deleteFile(paramdar);
      }
      saveBitmapToImageProtected(paramBitmap, paramdar, (kotlin.g.a.a)new PluginTaskBar.h(paramdar, this, paramString, (Bundle)localObject3));
      AppMethodBeat.o(214868);
      return;
    }
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject3, a.class, (com.tencent.mm.ipcinvoker.f)new PluginTaskBar.i(this, (Bundle)localObject3));
    AppMethodBeat.o(214868);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class e
    implements com.tencent.mm.storagebase.h.b
  {
    public static final e Mmc;
    
    static
    {
      AppMethodBeat.i(215068);
      Mmc = new e();
      AppMethodBeat.o(215068);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(215066);
      Object localObject = h.Mnj;
      localObject = h.dqy();
      AppMethodBeat.o(215066);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.PluginTaskBar
 * JD-Core Version:    0.7.0.1
 */
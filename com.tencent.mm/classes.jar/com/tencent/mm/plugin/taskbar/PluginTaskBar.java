package com.tencent.mm.plugin.taskbar;

import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.c.a;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/PluginTaskBar;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/taskbar/IPluginTaskBar;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Landroid/arch/lifecycle/ViewModelStoreOwner;", "()V", "TAG", "", "taskBarStorage", "Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "getTaskBarStorage", "()Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "setTaskBarStorage", "(Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;)V", "taskBarViewService", "Lcom/tencent/mm/plugin/taskbar/TaskBarViewService;", "viewModelStore", "Landroid/arch/lifecycle/ViewModelStore;", "addOrUpdateTaskInfo", "", "id", "type", "", "showData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "data", "", "addOrUpdateTaskInfoByBitmap", "bitmap", "Landroid/graphics/Bitmap;", "addToMultiTask", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getInnerTaskInfoById", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getTaskInfoById", "getTaskInfoByType", "", "getViewModelStore", "hasTaskInfo", "", "installed", "name", "notifyClickTaskBarItem", "multiTaskInfo", "notifyClickTaskBarItem$plugin_taskbar_release", "notifyExposeTaskBarItem", "notifyExposeTaskBarItem$plugin_taskbar_release", "notifyRemoveTaskBarItem", "notifyRemoveTaskBarItem$plugin_taskbar_release", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "removeTaskInfo", "isNotify", "scene", "saveBitmapToImageProtected", "path", "callback", "Lkotlin/Function0;", "updateTaskInfo", "updateBitmapOnly", "updateTaskInfoByBitmap", "Companion", "plugin-taskbar_release"})
public final class PluginTaskBar
  extends com.tencent.mm.kernel.b.f
  implements ViewModelStoreOwner, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, d
{
  public static final PluginTaskBar.a FRW;
  private final ViewModelStore FE;
  private h FRU;
  private final i FRV;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(238420);
    FRW = new PluginTaskBar.a((byte)0);
    AppMethodBeat.o(238420);
  }
  
  public PluginTaskBar()
  {
    AppMethodBeat.i(238419);
    this.TAG = "MicroMsg.TaskBar.PluginTaskBar";
    this.FRV = new i();
    this.FE = new ViewModelStore();
    AppMethodBeat.o(238419);
  }
  
  private final void saveBitmapToImageProtected(Bitmap paramBitmap, String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(258571);
    com.tencent.f.h.RTc.aY((Runnable)new PluginTaskBar.g(this, paramBitmap, paramString, parama));
    AppMethodBeat.o(258571);
  }
  
  public final void addOrUpdateTaskInfo(String paramString, int paramInt, cru paramcru, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(238412);
    p.h(paramString, "id");
    Object localObject = getInnerTaskInfoById(paramString);
    h localh;
    if (localObject != null)
    {
      Log.i(this.TAG, "updateTaskInfo id:" + paramString + " type:" + paramInt);
      ((MultiTaskInfo)localObject).field_updateTime = cl.aWA();
      ((MultiTaskInfo)localObject).field_showData = paramcru;
      if (paramArrayOfByte != null) {
        ((MultiTaskInfo)localObject).field_data = paramArrayOfByte;
      }
      localh = this.FRU;
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
        ((MultiTaskInfo)localObject).field_createTime = cl.aWA();
        ((MultiTaskInfo)localObject).field_updateTime = cl.aWA();
        ((MultiTaskInfo)localObject).field_showData = paramcru;
        ((MultiTaskInfo)localObject).field_data = paramArrayOfByte;
        paramString = this.FRU;
        if (paramString != null) {
          paramString.h((MultiTaskInfo)localObject);
        }
      }
      AppMethodBeat.o(238412);
      return;
    }
  }
  
  public final void addOrUpdateTaskInfoByBitmap(String paramString, int paramInt, cru paramcru, Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    AppMethodBeat.i(238411);
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("addTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    if (paramBitmap != null) {}
    for (Object localObject1 = Integer.valueOf(paramBitmap.getByteCount());; localObject1 = null)
    {
      Log.i((String)localObject3, localObject1);
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(238411);
      return;
    }
    if (MMApplicationContext.isMainProcess())
    {
      if (paramBitmap != null)
      {
        localObject1 = f.FSa;
        localObject1 = f.aGJ(paramString);
        if (s.YS((String)localObject1)) {
          s.deleteFile((String)localObject1);
        }
        saveBitmapToImageProtected(paramBitmap, (String)localObject1, (kotlin.g.a.a)PluginTaskBar.f.UrE);
      }
      addOrUpdateTaskInfo(paramString, paramInt, paramcru, paramArrayOfByte);
      AppMethodBeat.o(238411);
      return;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("addType", 1);
    ((Bundle)localObject1).putString("id", paramString);
    ((Bundle)localObject1).putInt("type", paramInt);
    if (paramcru != null) {}
    for (paramcru = paramcru.toByteArray();; paramcru = null)
    {
      ((Bundle)localObject1).putByteArray("showData", paramcru);
      ((Bundle)localObject1).putByteArray("data", paramArrayOfByte);
      if (paramBitmap == null) {
        break;
      }
      paramArrayOfByte = new z.f();
      localObject3 = new StringBuilder();
      paramcru = MMApplicationContext.getContext();
      p.g(paramcru, "MMApplicationContext.getContext()");
      localObject4 = paramcru.getExternalCacheDir();
      paramcru = localObject2;
      if (localObject4 != null) {
        paramcru = ((File)localObject4).getAbsolutePath();
      }
      paramArrayOfByte.SYG = (paramcru + "taskbar" + paramString);
      if (s.YS((String)paramArrayOfByte.SYG)) {
        s.deleteFile((String)paramArrayOfByte.SYG);
      }
      saveBitmapToImageProtected(paramBitmap, (String)paramArrayOfByte.SYG, (kotlin.g.a.a)new PluginTaskBar.b(paramArrayOfByte, this, paramString, (Bundle)localObject1));
      AppMethodBeat.o(238411);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject1, a.class, (com.tencent.mm.ipcinvoker.d)new PluginTaskBar.e(this, (Bundle)localObject1));
    AppMethodBeat.o(238411);
  }
  
  public final void addToMultiTask(String paramString)
  {
    AppMethodBeat.i(238408);
    p.h(paramString, "id");
    MultiTaskInfo localMultiTaskInfo = getInnerTaskInfoById(paramString);
    if (localMultiTaskInfo != null)
    {
      Object localObject = f.FSa;
      localObject = f.aGJ(paramString);
      com.tencent.mm.plugin.multitask.h localh = com.tencent.mm.plugin.multitask.h.zZn;
      s.nw((String)localObject, com.tencent.mm.plugin.multitask.h.aGJ(paramString));
      localObject = ((PluginMultiTask)com.tencent.mm.kernel.g.ah(PluginMultiTask.class)).getMultiTaskStorage();
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.multitask.model.a)localObject).aGM(paramString) == null)
        {
          ((com.tencent.mm.plugin.multitask.model.a)localObject).h(localMultiTaskInfo);
          paramString = com.tencent.mm.plugin.multitask.d.a.AbZ;
          com.tencent.mm.plugin.multitask.d.a.a(localMultiTaskInfo, 3L, 2L, "", "");
          AppMethodBeat.o(238408);
          return;
        }
        ((com.tencent.mm.plugin.multitask.model.a)localObject).a(localMultiTaskInfo, new String[0]);
        paramString = com.tencent.mm.plugin.multitask.d.a.AbZ;
        com.tencent.mm.plugin.multitask.d.a.a(localMultiTaskInfo, 3L, 1L, "", "");
        AppMethodBeat.o(238408);
        return;
      }
      AppMethodBeat.o(238408);
      return;
    }
    AppMethodBeat.o(238408);
  }
  
  public final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(238405);
    Log.i(this.TAG, "onAccountRelease");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("TaskBarInfo".hashCode()), c.FRY);
    AppMethodBeat.o(238405);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void dependency()
  {
    AppMethodBeat.i(238404);
    super.dependency();
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(238404);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(238400);
    if (paramg != null)
    {
      if (paramg.aBb() == true)
      {
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.taskbar.api.c.class, (com.tencent.mm.kernel.c.a)this.FRV);
        paramg = com.tencent.mm.plugin.taskbar.ui.a.b.FVa;
        paramg = MMApplicationContext.getContext();
        p.g(paramg, "MMApplicationContext.getContext()");
        com.tencent.mm.plugin.taskbar.ui.a.b.init(paramg);
      }
      AppMethodBeat.o(238400);
      return;
    }
    AppMethodBeat.o(238400);
  }
  
  public final MultiTaskInfo getInnerTaskInfoById(String paramString)
  {
    AppMethodBeat.i(238418);
    p.h(paramString, "id");
    h localh = this.FRU;
    if (localh != null)
    {
      paramString = localh.aGM(paramString);
      AppMethodBeat.o(238418);
      return paramString;
    }
    AppMethodBeat.o(238418);
    return null;
  }
  
  public final h getTaskBarStorage()
  {
    return this.FRU;
  }
  
  public final MultiTaskInfo getTaskInfoById(String paramString)
  {
    AppMethodBeat.i(238416);
    p.h(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      paramString = getInnerTaskInfoById(paramString);
      AppMethodBeat.o(238416);
      return paramString;
    }
    AppMethodBeat.o(238416);
    return null;
  }
  
  public final List<MultiTaskInfo> getTaskInfoByType(int paramInt)
  {
    AppMethodBeat.i(238415);
    Object localObject = this.FRU;
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
      AppMethodBeat.o(238415);
      return localObject;
    }
    localObject = (List)new ArrayList();
    AppMethodBeat.o(238415);
    return localObject;
  }
  
  public final ViewModelStore getViewModelStore()
  {
    return this.FE;
  }
  
  public final boolean hasTaskInfo(String paramString)
  {
    AppMethodBeat.i(238417);
    p.h(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      if (getInnerTaskInfoById(paramString) != null)
      {
        AppMethodBeat.o(238417);
        return true;
      }
      AppMethodBeat.o(238417);
      return false;
    }
    paramString = (IPCBoolean)com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)new IPCString(paramString), c.class);
    if (paramString != null)
    {
      boolean bool = paramString.value;
      AppMethodBeat.o(238417);
      return bool;
    }
    AppMethodBeat.o(238417);
    return false;
  }
  
  public final void installed() {}
  
  public final String name()
  {
    return "PluginTaskBar";
  }
  
  public final void notifyClickTaskBarItem$plugin_taskbar_release(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(238401);
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject = this.FRV;
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewService", "notifyClick " + paramMultiTaskInfo.erh().title + ' ' + paramMultiTaskInfo.field_id + ' ' + paramMultiTaskInfo.field_type);
    localObject = (HashSet)((i)localObject).jfY.get(paramMultiTaskInfo.field_type);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c.a)((Iterator)localObject).next()).b(paramMultiTaskInfo);
      }
      AppMethodBeat.o(238401);
      return;
    }
    AppMethodBeat.o(238401);
  }
  
  public final void notifyExposeTaskBarItem$plugin_taskbar_release(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(238402);
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject = this.FRV;
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    localObject = (HashSet)((i)localObject).jfY.get(paramMultiTaskInfo.field_type);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c.a)((Iterator)localObject).next()).a(paramMultiTaskInfo);
      }
      AppMethodBeat.o(238402);
      return;
    }
    AppMethodBeat.o(238402);
  }
  
  public final void notifyRemoveTaskBarItem$plugin_taskbar_release(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(238403);
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject = this.FRV;
    p.h(paramMultiTaskInfo, "multiTaskInfo");
    localObject = (HashSet)((i)localObject).jfY.get(paramMultiTaskInfo.field_type);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((c.a)((Iterator)localObject).next()).c(paramMultiTaskInfo);
      }
      AppMethodBeat.o(238403);
      return;
    }
    AppMethodBeat.o(238403);
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(238406);
    Log.i(this.TAG, "onAccountInitialized");
    if (this.FRU == null)
    {
      paramc = com.tencent.mm.kernel.g.aAh();
      p.g(paramc, "MMKernel.storage()");
      paramc = paramc.getDataDB();
      p.g(paramc, "MMKernel.storage().dataDB");
      this.FRU = new h((ISQLiteDatabase)paramc);
    }
    AppMethodBeat.o(238406);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(238407);
    Log.i(this.TAG, "onAccountRelease");
    this.FRU = null;
    AppMethodBeat.o(238407);
  }
  
  public final void removeTaskInfo(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(238409);
    if (MMApplicationContext.isMainProcess())
    {
      if (paramString != null)
      {
        localObject = f.FSa;
        localObject = f.aGJ(paramString);
        if (s.YS((String)localObject)) {
          s.deleteFile((String)localObject);
        }
        localObject = this.FRU;
        if (localObject != null)
        {
          p.h(paramString, "id");
          paramString = ((h)localObject).aGM(paramString);
          if (paramString != null)
          {
            Log.i("MicroMsg.TaskBarStorage", "delete:" + paramString.field_type + ' ' + paramString.field_id + ' ' + paramString.erh().title + ' ' + paramInt);
            ((h)localObject).delete((IAutoDBItem)paramString, false, new String[0]);
            if (paramBoolean)
            {
              h.b localb = new h.b();
              p.h(paramString, "<set-?>");
              localb.Agu = paramString;
              localb.FSf = paramInt;
              ((h)localObject).doNotify("single", 5, localb);
            }
            AppMethodBeat.o(238409);
            return;
          }
          AppMethodBeat.o(238409);
          return;
        }
        AppMethodBeat.o(238409);
        return;
      }
      AppMethodBeat.o(238409);
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("id", paramString);
    ((Bundle)localObject).putInt("scene", paramInt);
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject, b.class, (com.tencent.mm.ipcinvoker.d)new PluginTaskBar.d(this));
    AppMethodBeat.o(238409);
  }
  
  public final void setTaskBarStorage(h paramh)
  {
    this.FRU = paramh;
  }
  
  public final void updateTaskInfo(String paramString, int paramInt, cru paramcru, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(238414);
    p.h(paramString, "id");
    MultiTaskInfo localMultiTaskInfo = getInnerTaskInfoById(paramString);
    if (localMultiTaskInfo != null)
    {
      Log.i(this.TAG, "updateTaskInfo id:" + paramString + " type:" + paramInt + " updateBitmapOnly:" + paramBoolean);
      localMultiTaskInfo.field_updateTime = cl.aWA();
      if (!paramBoolean)
      {
        localMultiTaskInfo.field_showData = paramcru;
        if (paramArrayOfByte != null) {
          localMultiTaskInfo.field_data = paramArrayOfByte;
        }
      }
      paramString = this.FRU;
      if (paramString != null)
      {
        paramString.a(localMultiTaskInfo, new String[0]);
        AppMethodBeat.o(238414);
        return;
      }
      AppMethodBeat.o(238414);
      return;
    }
    AppMethodBeat.o(238414);
  }
  
  public final void updateTaskInfoByBitmap(String paramString, int paramInt, cru paramcru, Bitmap paramBitmap, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(238413);
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("updateTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    if (paramBitmap != null) {}
    for (Object localObject1 = Integer.valueOf(paramBitmap.getByteCount());; localObject1 = null)
    {
      Log.i((String)localObject3, localObject1 + " updateBitmapOnly:" + paramBoolean);
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(238413);
      return;
    }
    if (MMApplicationContext.isMainProcess())
    {
      if (paramBitmap != null)
      {
        localObject1 = f.FSa;
        localObject1 = f.aGJ(paramString);
        if (s.YS((String)localObject1)) {
          s.deleteFile((String)localObject1);
        }
        saveBitmapToImageProtected(paramBitmap, (String)localObject1, (kotlin.g.a.a)PluginTaskBar.j.UrG);
      }
      updateTaskInfo(paramString, paramInt, paramcru, paramArrayOfByte, paramBoolean);
      AppMethodBeat.o(238413);
      return;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("addType", 2);
    ((Bundle)localObject1).putString("id", paramString);
    ((Bundle)localObject1).putInt("type", paramInt);
    if (paramcru != null) {}
    for (paramcru = paramcru.toByteArray();; paramcru = null)
    {
      ((Bundle)localObject1).putByteArray("showData", paramcru);
      ((Bundle)localObject1).putByteArray("data", paramArrayOfByte);
      ((Bundle)localObject1).putBoolean("updateBitmapOnly", paramBoolean);
      if (paramBitmap == null) {
        break;
      }
      paramArrayOfByte = new z.f();
      localObject3 = new StringBuilder();
      paramcru = MMApplicationContext.getContext();
      p.g(paramcru, "MMApplicationContext.getContext()");
      localObject4 = paramcru.getExternalCacheDir();
      paramcru = localObject2;
      if (localObject4 != null) {
        paramcru = ((File)localObject4).getAbsolutePath();
      }
      paramArrayOfByte.SYG = (paramcru + "taskbar" + paramString);
      if (s.YS((String)paramArrayOfByte.SYG)) {
        s.deleteFile((String)paramArrayOfByte.SYG);
      }
      saveBitmapToImageProtected(paramBitmap, (String)paramArrayOfByte.SYG, (kotlin.g.a.a)new PluginTaskBar.h(paramArrayOfByte, this, paramString, (Bundle)localObject1));
      AppMethodBeat.o(238413);
      return;
    }
    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject1, a.class, (com.tencent.mm.ipcinvoker.d)new PluginTaskBar.i(this, (Bundle)localObject1));
    AppMethodBeat.o(238413);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "getSQLs", "()[Ljava/lang/String;"})
  static final class c
    implements com.tencent.mm.storagebase.h.b
  {
    public static final c FRY;
    
    static
    {
      AppMethodBeat.i(238397);
      FRY = new c();
      AppMethodBeat.o(238397);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(238396);
      Object localObject = h.FSe;
      localObject = h.dax();
      AppMethodBeat.o(238396);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.PluginTaskBar
 * JD-Core Version:    0.7.0.1
 */
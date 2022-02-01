package com.tencent.mm.plugin.taskbar;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.multitask.PluginMultiTask;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.plugin.taskbar.ui.section.d;
import com.tencent.mm.plugin.taskbar.ui.section.d.a;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/PluginTaskBar;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/taskbar/IPluginTaskBar;", "Lcom/tencent/mm/kernel/api/bucket/ICollectDBFactoryBucket;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Landroidx/lifecycle/ViewModelStoreOwner;", "()V", "TAG", "", "taskBarStorage", "Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "getTaskBarStorage", "()Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;", "setTaskBarStorage", "(Lcom/tencent/mm/plugin/taskbar/TaskBarStorage;)V", "taskBarViewService", "Lcom/tencent/mm/plugin/taskbar/TaskBarViewService;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "addOrUpdateTaskInfo", "", "id", "type", "", "showData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "data", "", "addOrUpdateTaskInfoByBitmap", "bitmap", "Landroid/graphics/Bitmap;", "addToMultiTask", "collectDatabaseFactory", "Ljava/util/HashMap;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "dependency", "execute", "getInnerTaskInfoById", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getTaskInfoById", "getTaskInfoByType", "", "getViewModelStore", "installed", "name", "notifyClickTaskBarItem", "multiTaskInfo", "notifyClickTaskBarItem$plugin_taskbar_release", "notifyExposeTaskBarItem", "notifyExposeTaskBarItem$plugin_taskbar_release", "notifyRemoveTaskBarItem", "notifyRemoveTaskBarItem$plugin_taskbar_release", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "removeTaskInfo", "isNotify", "", "scene", "saveBitmapToImageProtected", "path", "callback", "Lkotlin/Function0;", "updateTaskInfo", "updateBitmapOnly", "updateTaskInfoByBitmap", "Companion", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginTaskBar
  extends com.tencent.mm.kernel.b.f
  implements ak, com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.c, c
{
  public static final PluginTaskBar.a SPo;
  private h SPp;
  private final i SPq;
  private final String TAG;
  private final aj er;
  
  static
  {
    AppMethodBeat.i(264061);
    SPo = new PluginTaskBar.a((byte)0);
    AppMethodBeat.o(264061);
  }
  
  public PluginTaskBar()
  {
    AppMethodBeat.i(264019);
    this.TAG = "MicroMsg.TaskBar.PluginTaskBar";
    this.SPq = new i();
    this.er = new aj();
    AppMethodBeat.o(264019);
  }
  
  private static final void addOrUpdateTaskInfoByBitmap$lambda-9$lambda-8(PluginTaskBar paramPluginTaskBar, Bundle paramBundle)
  {
    AppMethodBeat.i(264046);
    s.u(paramPluginTaskBar, "this$0");
    paramPluginTaskBar = paramPluginTaskBar.TAG;
    if (paramBundle == null) {}
    for (boolean bool = false;; bool = paramBundle.getBoolean("result"))
    {
      Log.i(paramPluginTaskBar, s.X("invoker callback result:", Boolean.valueOf(bool)));
      AppMethodBeat.o(264046);
      return;
    }
  }
  
  private static final String[] collectDatabaseFactory$lambda-0()
  {
    AppMethodBeat.i(264029);
    Object localObject = h.SQC;
    localObject = h.dZh();
    AppMethodBeat.o(264029);
    return localObject;
  }
  
  private static final void removeTaskInfo$lambda-4(PluginTaskBar paramPluginTaskBar, Bundle paramBundle)
  {
    AppMethodBeat.i(264034);
    s.u(paramPluginTaskBar, "this$0");
    paramPluginTaskBar = paramPluginTaskBar.TAG;
    if (paramBundle == null) {}
    for (boolean bool = false;; bool = paramBundle.getBoolean("result"))
    {
      Log.i(paramPluginTaskBar, s.X("removeTaskInfo invoker callback result:", Boolean.valueOf(bool)));
      AppMethodBeat.o(264034);
      return;
    }
  }
  
  private final void saveBitmapToImageProtected(Bitmap paramBitmap, String paramString, kotlin.g.a.a<kotlin.ah> parama)
  {
    AppMethodBeat.i(264025);
    com.tencent.threadpool.h.ahAA.bn(new PluginTaskBar..ExternalSyntheticLambda4(paramBitmap, paramString, this, parama));
    AppMethodBeat.o(264025);
  }
  
  private static final void saveBitmapToImageProtected$lambda-5(Bitmap paramBitmap, String paramString, PluginTaskBar paramPluginTaskBar, kotlin.g.a.a parama)
  {
    AppMethodBeat.i(264040);
    s.u(paramBitmap, "$bitmap");
    s.u(paramString, "$path");
    s.u(paramPluginTaskBar, "this$0");
    s.u(parama, "$callback");
    try
    {
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, false);
      parama.invoke();
      AppMethodBeat.o(264040);
      return;
    }
    finally
    {
      try
      {
        Log.e(paramPluginTaskBar.TAG, s.X("save bitmap failed! ", paramString), new Object[] { paramBitmap });
        return;
      }
      finally
      {
        parama.invoke();
        AppMethodBeat.o(264040);
      }
    }
  }
  
  private static final void updateTaskInfoByBitmap$lambda-15$lambda-14(PluginTaskBar paramPluginTaskBar, Bundle paramBundle)
  {
    AppMethodBeat.i(264049);
    s.u(paramPluginTaskBar, "this$0");
    paramPluginTaskBar = paramPluginTaskBar.TAG;
    if (paramBundle == null) {}
    for (boolean bool = false;; bool = paramBundle.getBoolean("result"))
    {
      Log.i(paramPluginTaskBar, s.X("invoker callback result:", Boolean.valueOf(bool)));
      AppMethodBeat.o(264049);
      return;
    }
  }
  
  public final void addOrUpdateTaskInfo(String paramString, int paramInt, drz paramdrz, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    AppMethodBeat.i(264228);
    s.u(paramString, "id");
    MultiTaskInfo localMultiTaskInfo = getInnerTaskInfoById(paramString);
    if (localMultiTaskInfo == null) {}
    for (;;)
    {
      if (localObject == null)
      {
        Log.i(this.TAG, "addTaskInfo id:" + paramString + " type:" + paramInt);
        localObject = new MultiTaskInfo();
        ((MultiTaskInfo)localObject).field_id = paramString;
        ((MultiTaskInfo)localObject).field_type = paramInt;
        ((MultiTaskInfo)localObject).field_createTime = System.currentTimeMillis();
        ((MultiTaskInfo)localObject).field_updateTime = System.currentTimeMillis();
        ((MultiTaskInfo)localObject).field_showData = paramdrz;
        ((MultiTaskInfo)localObject).field_data = paramArrayOfByte;
        paramString = getTaskBarStorage();
        if (paramString != null) {
          paramString.m((MultiTaskInfo)localObject);
        }
      }
      AppMethodBeat.o(264228);
      return;
      Log.i(this.TAG, "updateTaskInfo id:" + paramString + " type:" + paramInt);
      localMultiTaskInfo.field_updateTime = System.currentTimeMillis();
      localMultiTaskInfo.field_showData = paramdrz;
      if (paramArrayOfByte != null) {
        localMultiTaskInfo.field_data = paramArrayOfByte;
      }
      h localh = getTaskBarStorage();
      if (localh != null) {
        localObject = Boolean.valueOf(localh.a(localMultiTaskInfo, new String[0]));
      }
    }
  }
  
  public final void addOrUpdateTaskInfoByBitmap(final String paramString, int paramInt, drz paramdrz, Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    AppMethodBeat.i(264219);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("addTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    if (paramBitmap == null) {}
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(paramBitmap.getByteCount()))
    {
      Log.i(str, localObject1);
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(264219);
      return;
    }
    if (MMApplicationContext.isMainProcess())
    {
      if (!com.tencent.mm.kernel.h.baz())
      {
        AppMethodBeat.o(264219);
        return;
      }
      if (paramBitmap != null)
      {
        localObject1 = f.SQy;
        localObject1 = f.aNP(paramString);
        if (y.ZC((String)localObject1)) {
          y.deleteFile((String)localObject1);
        }
        saveBitmapToImageProtected(paramBitmap, (String)localObject1, (kotlin.g.a.a)PluginTaskBar.b.SPr);
        localObject2 = d.SUa;
        if (d.a.aoe(paramInt))
        {
          localObject2 = f.SQy;
          localObject2 = e.SQw;
          s.s(localObject2, "SNAPSHOT_LOADER_OPTION");
          localObject1 = f.f((String)localObject1, (com.tencent.mm.modelimage.loader.a.c)localObject2);
          r.bKe().Op((String)localObject1);
          r.bKe().h((String)localObject1, paramBitmap);
        }
      }
      addOrUpdateTaskInfo(paramString, paramInt, paramdrz, paramArrayOfByte);
      AppMethodBeat.o(264219);
      return;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("addType", 1);
    ((Bundle)localObject1).putString("id", paramString);
    ((Bundle)localObject1).putInt("type", paramInt);
    if (paramdrz == null)
    {
      paramdrz = null;
      ((Bundle)localObject1).putByteArray("showData", paramdrz);
      ((Bundle)localObject1).putByteArray("data", paramArrayOfByte);
      if (paramBitmap != null) {
        break label341;
      }
    }
    for (paramString = (String)localObject2;; paramString = kotlin.ah.aiuX)
    {
      if (paramString == null) {
        j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, a.class, new PluginTaskBar..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(264219);
      return;
      paramdrz = paramdrz.toByteArray();
      break;
      label341:
      paramString = com.tencent.mm.vfs.ah.v(af.eC("taskbar", false).jKT()) + '/' + paramString;
      if (y.ZC(paramString)) {
        y.deleteFile(paramString);
      }
      saveBitmapToImageProtected(paramBitmap, paramString, (kotlin.g.a.a)new c((Bundle)localObject1, paramString, this));
    }
  }
  
  public final void addToMultiTask(String paramString)
  {
    AppMethodBeat.i(264199);
    s.u(paramString, "id");
    MultiTaskInfo localMultiTaskInfo = getInnerTaskInfoById(paramString);
    if (localMultiTaskInfo != null)
    {
      Object localObject = f.SQy;
      localObject = f.aNP(paramString);
      com.tencent.mm.plugin.multitask.h localh = com.tencent.mm.plugin.multitask.h.LBd;
      y.O((String)localObject, com.tencent.mm.plugin.multitask.h.aNP(paramString), false);
      localObject = ((PluginMultiTask)com.tencent.mm.kernel.h.az(PluginMultiTask.class)).getMultiTaskStorage();
      if (localObject != null)
      {
        if (((com.tencent.mm.plugin.multitask.model.b)localObject).aNT(paramString) == null)
        {
          com.tencent.mm.plugin.ac.g.a((com.tencent.mm.plugin.ac.g)localObject, (IAutoDBItem)localMultiTaskInfo, false, false, 6);
          paramString = com.tencent.mm.plugin.multitask.d.a.LDj;
          com.tencent.mm.plugin.multitask.d.a.a(localMultiTaskInfo, 3L, 2L, "", "");
          AppMethodBeat.o(264199);
          return;
        }
        com.tencent.mm.plugin.ac.g.a((com.tencent.mm.plugin.ac.g)localObject, (IAutoDBItem)localMultiTaskInfo);
        paramString = com.tencent.mm.plugin.multitask.d.a.LDj;
        com.tencent.mm.plugin.multitask.d.a.a(localMultiTaskInfo, 3L, 1L, "", "");
      }
    }
    AppMethodBeat.o(264199);
  }
  
  public final HashMap<Integer, com.tencent.mm.storagebase.h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(264166);
    Log.i(this.TAG, "onAccountRelease");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf("TaskBarInfo".hashCode()), PluginTaskBar..ExternalSyntheticLambda3.INSTANCE);
    AppMethodBeat.o(264166);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg) {}
  
  public final void dependency()
  {
    AppMethodBeat.i(264158);
    super.dependency();
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.comm.a.b.class);
    }
    AppMethodBeat.o(264158);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    int i = 1;
    AppMethodBeat.i(264118);
    if ((paramg != null) && (paramg.bbA() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.taskbar.api.b.class, (com.tencent.mm.kernel.c.a)this.SPq);
        paramg = com.tencent.mm.plugin.taskbar.ui.a.b.STI;
        paramg = MMApplicationContext.getContext();
        s.s(paramg, "getContext()");
        com.tencent.mm.plugin.taskbar.ui.a.b.init(paramg);
      }
      AppMethodBeat.o(264118);
      return;
      i = 0;
    }
  }
  
  public final MultiTaskInfo getInnerTaskInfoById(String paramString)
  {
    AppMethodBeat.i(264277);
    s.u(paramString, "id");
    h localh = this.SPp;
    if (localh == null)
    {
      AppMethodBeat.o(264277);
      return null;
    }
    paramString = localh.aNT(paramString);
    AppMethodBeat.o(264277);
    return paramString;
  }
  
  public final h getTaskBarStorage()
  {
    return this.SPp;
  }
  
  public final MultiTaskInfo getTaskInfoById(String paramString)
  {
    AppMethodBeat.i(264269);
    s.u(paramString, "id");
    if (MMApplicationContext.isMainProcess())
    {
      paramString = getInnerTaskInfoById(paramString);
      AppMethodBeat.o(264269);
      return paramString;
    }
    AppMethodBeat.o(264269);
    return null;
  }
  
  public final List<MultiTaskInfo> getTaskInfoByType(int paramInt)
  {
    AppMethodBeat.i(264264);
    Object localObject = this.SPp;
    if (localObject == null) {}
    ArrayList localArrayList;
    for (localObject = null; localObject == null; localObject = (List)localArrayList)
    {
      localObject = (List)new ArrayList();
      AppMethodBeat.o(264264);
      return localObject;
      localObject = ((h)localObject).db.rawQuery("SELECT * FROM TaskBarInfo WHERE type = ? ORDER BY updateTime DESC;", new String[] { String.valueOf(paramInt) });
      localArrayList = new ArrayList();
      while (((Cursor)localObject).moveToNext())
      {
        MultiTaskInfo localMultiTaskInfo = new MultiTaskInfo();
        localMultiTaskInfo.convertFrom((Cursor)localObject);
        localArrayList.add(localMultiTaskInfo);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(264264);
    return localObject;
  }
  
  public final aj getViewModelStore()
  {
    return this.er;
  }
  
  public final void installed() {}
  
  public final String name()
  {
    return "PluginTaskBar";
  }
  
  public final void notifyClickTaskBarItem$plugin_taskbar_release(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264133);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject = this.SPq;
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewService", "notifyClick " + paramMultiTaskInfo.gkh().title + ' ' + paramMultiTaskInfo.field_id + ' ' + paramMultiTaskInfo.field_type);
    localObject = (HashSet)((i)localObject).oPB.get(paramMultiTaskInfo.field_type);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).b(paramMultiTaskInfo);
      }
    }
    AppMethodBeat.o(264133);
  }
  
  public final void notifyExposeTaskBarItem$plugin_taskbar_release(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264141);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject = this.SPq;
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    localObject = (HashSet)((i)localObject).oPB.get(paramMultiTaskInfo.field_type);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).a(paramMultiTaskInfo);
      }
    }
    AppMethodBeat.o(264141);
  }
  
  public final void notifyRemoveTaskBarItem$plugin_taskbar_release(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(264150);
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    Object localObject = this.SPq;
    s.u(paramMultiTaskInfo, "multiTaskInfo");
    Log.i("MicroMsg.TaskBarViewService", "notifyRemoveTaskBarItem " + paramMultiTaskInfo.gkh().title + ' ' + paramMultiTaskInfo.field_id + ' ' + paramMultiTaskInfo.field_type);
    localObject = (HashSet)((i)localObject).oPB.get(paramMultiTaskInfo.field_type);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((b.a)((Iterator)localObject).next()).c(paramMultiTaskInfo);
      }
    }
    AppMethodBeat.o(264150);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(264173);
    Log.i(this.TAG, "onAccountInitialized");
    if (this.SPp == null)
    {
      paramc = com.tencent.mm.kernel.h.baE().mCN;
      s.s(paramc, "storage().dataDB");
      this.SPp = new h((ISQLiteDatabase)paramc);
    }
    AppMethodBeat.o(264173);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(264185);
    Log.i(this.TAG, "onAccountRelease");
    this.SPp = null;
    AppMethodBeat.o(264185);
  }
  
  public final void removeTaskInfo(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(264207);
    Log.i(this.TAG, "removeTaskInfo " + paramString + ' ' + paramBoolean + ' ' + paramInt);
    Object localObject;
    if (MMApplicationContext.isMainProcess())
    {
      if (!com.tencent.mm.kernel.h.baz())
      {
        AppMethodBeat.o(264207);
        return;
      }
      if (paramString != null)
      {
        localObject = f.SQy;
        localObject = f.aNP(paramString);
        if (y.ZC((String)localObject)) {
          y.deleteFile((String)localObject);
        }
        localObject = getTaskBarStorage();
        if (localObject != null)
        {
          s.u(paramString, "id");
          paramString = ((h)localObject).aNT(paramString);
          if (paramString != null)
          {
            Log.i("MicroMsg.TaskBarStorage", "delete:" + paramString.field_type + ' ' + paramString.field_id + ' ' + paramString.gkh().title + ' ' + paramInt);
            ((h)localObject).delete((IAutoDBItem)paramString, false, new String[0]);
            if (paramBoolean)
            {
              h.b localb = new h.b();
              s.u(paramString, "<set-?>");
              localb.LIj = paramString;
              localb.Jrn = paramInt;
              ((h)localObject).doNotify("single", 5, localb);
            }
          }
        }
        AppMethodBeat.o(264207);
      }
    }
    else
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("id", paramString);
      ((Bundle)localObject).putInt("scene", paramInt);
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject, b.class, new PluginTaskBar..ExternalSyntheticLambda1(this));
    }
    AppMethodBeat.o(264207);
  }
  
  public final void setTaskBarStorage(h paramh)
  {
    this.SPp = paramh;
  }
  
  public final void updateTaskInfo(String paramString, int paramInt, drz paramdrz, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(264252);
    s.u(paramString, "id");
    MultiTaskInfo localMultiTaskInfo = getInnerTaskInfoById(paramString);
    if (localMultiTaskInfo != null)
    {
      Log.i(this.TAG, "updateTaskInfo id:" + paramString + " type:" + paramInt + " updateBitmapOnly:" + paramBoolean);
      localMultiTaskInfo.field_updateTime = System.currentTimeMillis();
      if (!paramBoolean)
      {
        localMultiTaskInfo.field_showData = paramdrz;
        if (paramArrayOfByte != null) {
          localMultiTaskInfo.field_data = paramArrayOfByte;
        }
      }
      paramString = getTaskBarStorage();
      if (paramString != null) {
        paramString.a(localMultiTaskInfo, new String[0]);
      }
    }
    AppMethodBeat.o(264252);
  }
  
  public final void updateTaskInfoByBitmap(final String paramString, int paramInt, drz paramdrz, Bitmap paramBitmap, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(264243);
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("updateTaskInfoByBitmap id:").append(paramString).append(" type:").append(paramInt).append(" bitmap:");
    if (paramBitmap == null) {}
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(paramBitmap.getByteCount()))
    {
      Log.i(str, localObject1 + " updateBitmapOnly:" + paramBoolean);
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(264243);
      return;
    }
    if (MMApplicationContext.isMainProcess())
    {
      if (!com.tencent.mm.kernel.h.baz())
      {
        AppMethodBeat.o(264243);
        return;
      }
      if (paramBitmap != null)
      {
        localObject1 = f.SQy;
        localObject1 = f.aNP(paramString);
        if (y.ZC((String)localObject1)) {
          y.deleteFile((String)localObject1);
        }
        saveBitmapToImageProtected(paramBitmap, (String)localObject1, (kotlin.g.a.a)PluginTaskBar.d.SPu);
        localObject2 = d.SUa;
        if (d.a.aoe(paramInt))
        {
          localObject2 = f.SQy;
          localObject2 = e.SQw;
          s.s(localObject2, "SNAPSHOT_LOADER_OPTION");
          localObject1 = f.f((String)localObject1, (com.tencent.mm.modelimage.loader.a.c)localObject2);
          r.bKe().h((String)localObject1, paramBitmap);
        }
      }
      updateTaskInfo(paramString, paramInt, paramdrz, paramArrayOfByte, paramBoolean);
      AppMethodBeat.o(264243);
      return;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("addType", 2);
    ((Bundle)localObject1).putString("id", paramString);
    ((Bundle)localObject1).putInt("type", paramInt);
    if (paramdrz == null)
    {
      paramdrz = null;
      ((Bundle)localObject1).putByteArray("showData", paramdrz);
      ((Bundle)localObject1).putByteArray("data", paramArrayOfByte);
      ((Bundle)localObject1).putBoolean("updateBitmapOnly", paramBoolean);
      if (paramBitmap != null) {
        break label356;
      }
    }
    for (paramString = (String)localObject2;; paramString = kotlin.ah.aiuX)
    {
      if (paramString == null) {
        j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, a.class, new PluginTaskBar..ExternalSyntheticLambda2(this));
      }
      AppMethodBeat.o(264243);
      return;
      paramdrz = paramdrz.toByteArray();
      break;
      label356:
      paramString = com.tencent.mm.vfs.ah.v(af.eC("taskbar", false).jKT()) + '/' + paramString;
      if (y.ZC(paramString)) {
        y.deleteFile(paramString);
      }
      saveBitmapToImageProtected(paramBitmap, paramString, (kotlin.g.a.a)new e((Bundle)localObject1, paramString, this));
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    c(Bundle paramBundle, String paramString, PluginTaskBar paramPluginTaskBar)
    {
      super();
    }
    
    private static final void a(PluginTaskBar paramPluginTaskBar, Bundle paramBundle)
    {
      AppMethodBeat.i(263988);
      s.u(paramPluginTaskBar, "this$0");
      paramPluginTaskBar = PluginTaskBar.access$getTAG$p(paramPluginTaskBar);
      if (paramBundle == null) {}
      for (boolean bool = false;; bool = paramBundle.getBoolean("result"))
      {
        Log.i(paramPluginTaskBar, s.X("invoker callback result:", Boolean.valueOf(bool)));
        AppMethodBeat.o(263988);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    e(Bundle paramBundle, String paramString, PluginTaskBar paramPluginTaskBar)
    {
      super();
    }
    
    private static final void a(PluginTaskBar paramPluginTaskBar, Bundle paramBundle)
    {
      AppMethodBeat.i(264002);
      s.u(paramPluginTaskBar, "this$0");
      paramPluginTaskBar = PluginTaskBar.access$getTAG$p(paramPluginTaskBar);
      if (paramBundle == null) {}
      for (boolean bool = false;; bool = paramBundle.getBoolean("result"))
      {
        Log.i(paramPluginTaskBar, s.X("invoker callback result:", Boolean.valueOf(bool)));
        AppMethodBeat.o(264002);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.PluginTaskBar
 * JD-Core Version:    0.7.0.1
 */
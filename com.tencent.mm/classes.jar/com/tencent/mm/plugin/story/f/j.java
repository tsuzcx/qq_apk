package com.tencent.mm.plugin.story.f;

import android.graphics.Point;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.PluginStory.b;
import com.tencent.mm.plugin.story.PluginStory.c;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.f.a.i;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.protocal.protobuf.ede;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "appForegroundListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "removeDirtyDB", "resetDb", "updateConfigs", "AppForegroundListener", "Companion", "ConfigChangedListener", "plugin-story_release"})
public final class j
  implements bd
{
  private static String DKR;
  private static final int DLb = 103;
  private static final int Fmt = 150;
  private static final IListener<fp> Fmu;
  private static boolean Fmv = false;
  private static boolean Fmw = false;
  private static long Fmx = 0L;
  public static final b Fmy;
  private static final String TAG = "MicroMsg.StoryCore";
  private static final Point imX;
  private boolean DKP;
  private HashMap<Integer, h.b> Fmd;
  private k Fme;
  private com.tencent.mm.plugin.story.i.g Fmf;
  private com.tencent.mm.plugin.story.i.m Fmg;
  private com.tencent.mm.plugin.story.i.b Fmh;
  private o Fmi;
  private com.tencent.mm.plugin.story.i.i Fmj;
  private com.tencent.mm.plugin.story.f.g.c Fmk;
  private e Fml;
  private com.tencent.mm.plugin.story.f.c.e Fmm;
  private o.a Fmn;
  private PluginStory.c Fmo;
  private PluginStory.b Fmp;
  private d Fmq;
  private a Fmr;
  private MMHandler Fms;
  private final MMHandler handler;
  private com.tencent.mm.storagebase.h hqK;
  private final byte[] lock;
  private boolean tnN;
  
  static
  {
    AppMethodBeat.i(118713);
    Fmy = new b((byte)0);
    TAG = "MicroMsg.StoryCore";
    DKR = "";
    imX = new Point();
    DLb = 103;
    Fmt = 150;
    Fmu = (IListener)new c();
    Fmx = -1L;
    AppMethodBeat.o(118713);
  }
  
  public j()
  {
    AppMethodBeat.i(118712);
    this.lock = new byte[0];
    this.Fmd = new HashMap();
    this.Fmo = new PluginStory.c();
    this.Fmp = new PluginStory.b();
    this.Fmq = new d();
    this.Fmr = new a();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Fms = new MMHandler("SnsCore_task_handler");
    ((Map)this.Fmd).put(Integer.valueOf("MMStoryInfo".hashCode()), 1.Fmz);
    ((Map)this.Fmd).put(Integer.valueOf("StoryExtItem".hashCode()), 2.FmA);
    ((Map)this.Fmd).put(Integer.valueOf("StoryCommentSync".hashCode()), 3.FmB);
    ((Map)this.Fmd).put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), 4.FmC);
    ((Map)this.Fmd).put(Integer.valueOf("StoryEditorInfo".hashCode()), 5.FmD);
    ((Map)this.Fmd).put(Integer.valueOf("StoryRoomInfo".hashCode()), 6.FmE);
    ((Map)this.Fmd).put(Integer.valueOf("MMStoryHistoryItem".hashCode()), 7.FmF);
    AppMethodBeat.o(118712);
  }
  
  private static void fax()
  {
    AppMethodBeat.i(222907);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = new File(((com.tencent.mm.kernel.e)localObject).azM()).list();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        Log.i(TAG, "removeDirtyDB file:%s", new Object[] { str });
        if ((str != null) && (n.e((CharSequence)str, (CharSequence)"StoryMicroMsg")))
        {
          Log.i(TAG, "removeDirtyDB will delete:%s", new Object[] { str });
          s.deleteFile(str);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(222907);
  }
  
  public static boolean isValid()
  {
    AppMethodBeat.i(118711);
    boolean bool = com.tencent.mm.kernel.g.aAf().azp();
    AppMethodBeat.o(118711);
    return bool;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(118709);
    if (this.DKP)
    {
      AppMethodBeat.o(118709);
      return;
    }
    this.DKP = true;
    this.tnN = true;
    Object localObject1 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class);
    kotlin.g.b.p.g(localObject1, "plugin(IPluginStory::class.java)");
    s.boN(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryPath());
    localObject1 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class);
    kotlin.g.b.p.g(localObject1, "plugin(IPluginStory::class.java)");
    s.boN(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryTmpPath());
    EventCenter.instance.addListener((IListener)this.Fmo);
    EventCenter.instance.addListener((IListener)this.Fmp);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new h(), new String[] { "//story" });
    localObject1 = b.foi();
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).ibn.a((f)((com.tencent.mm.plugin.story.f.g.c)localObject1).FqB);
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).vSA.a((f)((com.tencent.mm.plugin.story.f.g.c)localObject1).FqC);
    Object localObject2 = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localObject2, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject2).azz().a(351, (com.tencent.mm.ak.i)localObject1);
    localObject1 = b.fod();
    ((com.tencent.mm.plugin.story.i.g)localObject1).add((MStorage.IOnStorageChange)localObject1);
    localObject1 = com.tencent.mm.plugin.story.f.b.b.Fom;
    if ((s.YS(com.tencent.mm.plugin.story.f.b.b.Fod)) && (!s.YS(com.tencent.mm.plugin.story.f.b.b.DNm))) {
      s.nx(com.tencent.mm.plugin.story.f.b.b.Fod, com.tencent.mm.plugin.story.f.b.b.DNm);
    }
    localObject2 = s.aW(com.tencent.mm.plugin.story.f.b.b.DNm, 0, -1);
    if (localObject2 != null)
    {
      if (localObject2.length != 0) {
        break label482;
      }
      i = 1;
      if (i != 0) {
        break label487;
      }
    }
    label482:
    label487:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.plugin.story.f.b.b.Fof.parseFrom((byte[])localObject2);
      }
      localObject2 = com.tencent.mm.kernel.g.aAg();
      kotlin.g.b.p.g(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).azz().a(354, (com.tencent.mm.ak.i)localObject1);
      localObject2 = com.tencent.mm.kernel.g.aAg();
      kotlin.g.b.p.g(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).azz().a(764, (com.tencent.mm.ak.i)localObject1);
      com.tencent.mm.plugin.story.f.b.b.fbQ();
      b.fon();
      com.tencent.mm.plugin.story.f.f.a.FpB.init();
      Fmu.alive();
      localObject1 = l.FmK;
      l.reset();
      localObject1 = l.FmK;
      s.boN(l.jdMethod_for() + "coming/");
      s.boN(l.jdMethod_for() + "pic/");
      s.boN(l.jdMethod_for() + "video/");
      com.tencent.mm.plugin.story.api.p.FkJ = (p.b)com.tencent.mm.plugin.story.f.d.e.FoL;
      EventCenter.instance.addListener((IListener)this.Fmq);
      this.Fmr.alive();
      AppMethodBeat.o(118709);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(118710);
    this.Fmr.dead();
    EventCenter.instance.removeListener((IListener)this.Fmo);
    EventCenter.instance.removeListener((IListener)this.Fmp);
    EventCenter.instance.removeListener((IListener)this.Fmq);
    com.tencent.mm.pluginsdk.cmd.b.V(new String[] { "//story" });
    Object localObject = b.foi();
    ((com.tencent.mm.plugin.story.f.g.c)localObject).ibn.b((f)((com.tencent.mm.plugin.story.f.g.c)localObject).FqB);
    ((com.tencent.mm.plugin.story.f.g.c)localObject).vSA.b((f)((com.tencent.mm.plugin.story.f.g.c)localObject).FqC);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "MMKernel.network()");
    localb.azz().b(351, (com.tencent.mm.ak.i)localObject);
    localObject = b.fod();
    ((com.tencent.mm.plugin.story.i.g)localObject).remove((MStorage.IOnStorageChange)localObject);
    localObject = com.tencent.mm.plugin.story.f.b.b.Fom;
    com.tencent.mm.plugin.story.f.b.b.foR();
    localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "network()");
    localb.azz().b(354, (com.tencent.mm.ak.i)localObject);
    localb = com.tencent.mm.kernel.g.aAg();
    kotlin.g.b.p.g(localb, "network()");
    localb.azz().b(764, (com.tencent.mm.ak.i)localObject);
    localObject = com.tencent.mm.plugin.story.f.f.a.FpB;
    Log.i(com.tencent.mm.plugin.story.f.f.a.TAG, "destroy: ");
    b.fod().remove((MStorage.IOnStorageChange)localObject);
    b.foc().remove((MStorage.IOnStorageChange)localObject);
    com.tencent.mm.plugin.story.f.f.a.ndV.clear();
    com.tencent.mm.plugin.story.f.f.a.Fpz.dead();
    localObject = com.tencent.mm.plugin.story.f.b.b.Fom;
    com.tencent.mm.plugin.story.f.b.b.g(com.tencent.mm.plugin.story.f.f.a.FpA);
    Fmu.dead();
    AppMethodBeat.o(118710);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-story_release"})
  public final class a
    extends com.tencent.mm.app.o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(118683);
      paramString = new xc();
      paramString.edy.state = 0;
      EventCenter.instance.publish((IEvent)paramString);
      AppMethodBeat.o(118683);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(118682);
      paramString = new xc();
      paramString.edy.state = 1;
      EventCenter.instance.publish((IEvent)paramString);
      AppMethodBeat.o(118682);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"})
  public static final class b
  {
    public static com.tencent.mm.loader.c.e a(com.tencent.mm.plugin.story.f.c.a parama)
    {
      AppMethodBeat.i(118697);
      kotlin.g.b.p.h(parama, "scene");
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.o(fob()) == null) {
        j.a(fob(), new com.tencent.mm.plugin.story.f.c.e());
      }
      com.tencent.mm.plugin.story.f.c.e locale = j.o(fob());
      if (locale == null) {
        kotlin.g.b.p.hyc();
      }
      kotlin.g.b.p.h(parama, "scene");
      switch (com.tencent.mm.plugin.story.f.c.f.$EnumSwitchMapping$0[parama.ordinal()])
      {
      default: 
        parama = new kotlin.m();
        AppMethodBeat.o(118697);
        throw parama;
      case 1: 
      case 2: 
        parama = locale.FoH;
        AppMethodBeat.o(118697);
        return parama;
      }
      parama = locale.FoG;
      AppMethodBeat.o(118697);
      return parama;
    }
    
    public static MMHandler eJP()
    {
      AppMethodBeat.i(118693);
      Object localObject = com.tencent.mm.kernel.g.aAk();
      kotlin.g.b.p.g(localObject, "MMKernel.getPizzaWorkerThread()");
      localObject = ((MMHandlerThread)localObject).getWorkerHandler();
      kotlin.g.b.p.g(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
      AppMethodBeat.o(118693);
      return localObject;
    }
    
    public static String fau()
    {
      AppMethodBeat.i(118700);
      Object localObject = com.tencent.mm.kernel.g.aAh();
      kotlin.g.b.p.g(localObject, "MMKernel.storage()");
      String str = (String)((com.tencent.mm.kernel.e)localObject).azQ().get(2);
      if (str == null) {
        Log.i(j.access$getTAG$cp(), "error getSelfName " + Util.getStack());
      }
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(118700);
      return localObject;
    }
    
    private static j fob()
    {
      AppMethodBeat.i(118685);
      j localj = (j)y.at(j.class);
      if ((localj instanceof j))
      {
        j.a(localj);
        if (!j.b(localj)) {}
      }
      synchronized (j.d(localj))
      {
        Object localObject2 = j.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("getCore need reset DB now ");
        Thread localThread = Thread.currentThread();
        kotlin.g.b.p.g(localThread, "Thread.currentThread()");
        localStringBuilder = localStringBuilder.append(localThread.getName()).append(" ");
        localThread = Thread.currentThread();
        kotlin.g.b.p.g(localThread, "Thread.currentThread()");
        Log.i((String)localObject2, localThread.getId() + " " + localj.hashCode());
        if (j.b(localj))
        {
          j.e(localj);
          j.c(localj);
          Log.i(j.access$getTAG$cp(), "resetdb done");
        }
        localObject2 = x.SXb;
        kotlin.g.b.p.g(localj, "theCore");
        AppMethodBeat.o(118685);
        return localj;
      }
    }
    
    public static k foc()
    {
      AppMethodBeat.i(118687);
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.g(fob()) == null) {
        j.a(fob(), new k((ISQLiteDatabase)getDataDB()));
      }
      k localk = j.g(fob());
      if (localk == null) {
        kotlin.g.b.p.hyc();
      }
      AppMethodBeat.o(118687);
      return localk;
    }
    
    public static com.tencent.mm.plugin.story.i.g fod()
    {
      AppMethodBeat.i(118688);
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.h(fob()) == null) {
        j.a(fob(), new com.tencent.mm.plugin.story.i.g((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.g localg = j.h(fob());
      if (localg == null) {
        kotlin.g.b.p.hyc();
      }
      AppMethodBeat.o(118688);
      return localg;
    }
    
    public static com.tencent.mm.plugin.story.i.m foe()
    {
      AppMethodBeat.i(118689);
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.i(fob()) == null) {
        j.a(fob(), new com.tencent.mm.plugin.story.i.m((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.m localm = j.i(fob());
      if (localm == null) {
        kotlin.g.b.p.hyc();
      }
      AppMethodBeat.o(118689);
      return localm;
    }
    
    public static com.tencent.mm.plugin.story.i.b fof()
    {
      AppMethodBeat.i(118690);
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.j(fob()) == null) {
        j.a(fob(), new com.tencent.mm.plugin.story.i.b((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.b localb = j.j(fob());
      if (localb == null) {
        kotlin.g.b.p.hyc();
      }
      AppMethodBeat.o(118690);
      return localb;
    }
    
    public static o fog()
    {
      AppMethodBeat.i(118691);
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.k(fob()) == null) {
        j.a(fob(), new o((ISQLiteDatabase)getDataDB()));
      }
      o localo = j.k(fob());
      if (localo == null) {
        kotlin.g.b.p.hyc();
      }
      AppMethodBeat.o(118691);
      return localo;
    }
    
    public static com.tencent.mm.plugin.story.i.i foh()
    {
      AppMethodBeat.i(118692);
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.l(fob()) == null) {
        j.a(fob(), new com.tencent.mm.plugin.story.i.i((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.i locali = j.l(fob());
      if (locali == null) {
        kotlin.g.b.p.hyc();
      }
      AppMethodBeat.o(118692);
      return locali;
    }
    
    public static com.tencent.mm.plugin.story.f.g.c foi()
    {
      AppMethodBeat.i(118694);
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.m(fob()) == null) {
        j.a(fob(), new com.tencent.mm.plugin.story.f.g.c());
      }
      com.tencent.mm.plugin.story.f.g.c localc = j.m(fob());
      if (localc == null) {
        kotlin.g.b.p.hyc();
      }
      AppMethodBeat.o(118694);
      return localc;
    }
    
    public static e foj()
    {
      AppMethodBeat.i(118695);
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.n(fob()) == null)
      {
        localObject1 = fob();
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(localObject2, "MMKernel.storage()");
        localStringBuilder = localStringBuilder.append(((com.tencent.mm.kernel.e)localObject2).azM());
        localObject2 = e.FlV;
        j.a((j)localObject1, new e(e.fnM()));
      }
      Object localObject1 = j.n(fob());
      if (localObject1 == null) {
        kotlin.g.b.p.hyc();
      }
      AppMethodBeat.o(118695);
      return localObject1;
    }
    
    public static com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> fok()
    {
      AppMethodBeat.i(118696);
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.o(fob()) == null) {
        j.a(fob(), new com.tencent.mm.plugin.story.f.c.e());
      }
      Object localObject = j.o(fob());
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      localObject = ((com.tencent.mm.plugin.story.f.c.e)localObject).FoE;
      AppMethodBeat.o(118696);
      return localObject;
    }
    
    public static o.a fol()
    {
      AppMethodBeat.i(118698);
      com.tencent.mm.kernel.g.aAf().azk();
      if (j.p(fob()) == null) {
        j.a(fob(), new o.a());
      }
      o.a locala = j.p(fob());
      if (locala == null) {
        kotlin.g.b.p.hyc();
      }
      AppMethodBeat.o(118698);
      return locala;
    }
    
    public static g.a fom()
    {
      AppMethodBeat.i(118703);
      g.a locala = (g.a)com.tencent.mm.plugin.story.c.a.g.Fls.aLT();
      AppMethodBeat.o(118703);
      return locala;
    }
    
    static void fon()
    {
      AppMethodBeat.i(118704);
      j.fnY();
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPl, 1);
      Log.d(j.access$getTAG$cp(), "loadStoryCheck %s local_debug %s", new Object[] { Integer.valueOf(i), Boolean.FALSE });
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aXu().Fu("100481");
      kotlin.g.b.p.g(localc, "abTestItem");
      if ((localc.isValid()) && (kotlin.g.b.p.j("1", (String)localc.gzz().get("open")))) {
        i = 1;
      }
      for (;;)
      {
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          j.vN(bool);
          AppMethodBeat.o(118704);
          return;
        }
      }
    }
    
    public static boolean foo()
    {
      AppMethodBeat.i(118705);
      if (com.tencent.mm.plugin.textstatus.a.p.fvC())
      {
        AppMethodBeat.o(118705);
        return false;
      }
      if (!j.fnX()) {
        fon();
      }
      boolean bool = j.fnZ();
      AppMethodBeat.o(118705);
      return bool;
    }
    
    public static long fop()
    {
      AppMethodBeat.i(118706);
      if (j.foa() == -1L)
      {
        com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(locale, "MMKernel.storage()");
        j.Kj(locale.azQ().a(ar.a.OiN, 0L));
      }
      long l = j.foa();
      AppMethodBeat.o(118706);
      return l;
    }
    
    public static String getAccStoryCachePath()
    {
      AppMethodBeat.i(118702);
      Object localObject = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class);
      kotlin.g.b.p.g(localObject, "plugin<IPluginStory>(IPluginStory::class.java)");
      localObject = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryCachePath();
      kotlin.g.b.p.g(localObject, "plugin<IPluginStory>(IPl…s.java).accStoryCachePath");
      AppMethodBeat.o(118702);
      return localObject;
    }
    
    public static String getAccStoryPath()
    {
      AppMethodBeat.i(118701);
      Object localObject = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class);
      kotlin.g.b.p.g(localObject, "plugin<IPluginStory>(IPluginStory::class.java)");
      localObject = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath();
      kotlin.g.b.p.g(localObject, "plugin<IPluginStory>(IPl…:class.java).accStoryPath");
      AppMethodBeat.o(118701);
      return localObject;
    }
    
    private static com.tencent.mm.storagebase.h getDataDB()
    {
      AppMethodBeat.i(118686);
      com.tencent.mm.storagebase.h localh = j.f(fob());
      if (localh == null) {
        kotlin.g.b.p.hyc();
      }
      AppMethodBeat.o(118686);
      return localh;
    }
    
    public static boolean isInValid()
    {
      AppMethodBeat.i(118699);
      fob();
      if (!j.isValid())
      {
        AppMethodBeat.o(118699);
        return true;
      }
      AppMethodBeat.o(118699);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/StoryCore$Companion$exptChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends IListener<fp>
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/DynamicConfigUpdatedEvent;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "callback", "", "event", "plugin-story_release"})
  public final class d
    extends IListener<df>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.j
 * JD-Core Version:    0.7.0.1
 */
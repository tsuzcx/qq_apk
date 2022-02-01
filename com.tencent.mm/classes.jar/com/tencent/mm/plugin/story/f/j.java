package com.tencent.mm.plugin.story.f;

import android.graphics.Point;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.yj;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.PluginStory.b;
import com.tencent.mm.plugin.story.PluginStory.c;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.f.a.i;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.protocal.protobuf.enf;
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
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "appForegroundListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "removeDirtyDB", "resetDb", "updateConfigs", "AppForegroundListener", "Companion", "ConfigChangedListener", "plugin-story_release"})
public final class j
  implements be
{
  private static String JXS;
  private static final int JYc = 103;
  public static final b LGA;
  private static final int LGv = 150;
  private static final IListener<fw> LGw;
  private static boolean LGx = false;
  private static boolean LGy = false;
  private static long LGz = 0L;
  private static final String TAG = "MicroMsg.StoryCore";
  private static final Point lbY;
  private boolean JXQ;
  private HashMap<Integer, h.b> LGf;
  private k LGg;
  private com.tencent.mm.plugin.story.i.g LGh;
  private com.tencent.mm.plugin.story.i.m LGi;
  private com.tencent.mm.plugin.story.i.b LGj;
  private o LGk;
  private com.tencent.mm.plugin.story.i.i LGl;
  private com.tencent.mm.plugin.story.f.g.c LGm;
  private e LGn;
  private com.tencent.mm.plugin.story.f.c.e LGo;
  private o.a LGp;
  private PluginStory.c LGq;
  private PluginStory.b LGr;
  private d LGs;
  private a LGt;
  private MMHandler LGu;
  private final MMHandler handler;
  private com.tencent.mm.storagebase.h kcF;
  private final byte[] lock;
  private boolean wUJ;
  
  static
  {
    AppMethodBeat.i(118713);
    LGA = new b((byte)0);
    TAG = "MicroMsg.StoryCore";
    JXS = "";
    lbY = new Point();
    JYc = 103;
    LGv = 150;
    LGw = (IListener)new c();
    LGz = -1L;
    AppMethodBeat.o(118713);
  }
  
  public j()
  {
    AppMethodBeat.i(118712);
    this.lock = new byte[0];
    this.LGf = new HashMap();
    this.LGq = new PluginStory.c();
    this.LGr = new PluginStory.b();
    this.LGs = new d();
    this.LGt = new a();
    this.handler = new MMHandler(Looper.getMainLooper());
    this.LGu = new MMHandler("SnsCore_task_handler");
    ((Map)this.LGf).put(Integer.valueOf("MMStoryInfo".hashCode()), 1.LGB);
    ((Map)this.LGf).put(Integer.valueOf("StoryExtItem".hashCode()), 2.LGC);
    ((Map)this.LGf).put(Integer.valueOf("StoryCommentSync".hashCode()), 3.LGD);
    ((Map)this.LGf).put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), 4.LGE);
    ((Map)this.LGf).put(Integer.valueOf("StoryEditorInfo".hashCode()), 5.LGF);
    ((Map)this.LGf).put(Integer.valueOf("StoryRoomInfo".hashCode()), 6.LGG);
    ((Map)this.LGf).put(Integer.valueOf("MMStoryHistoryItem".hashCode()), 7.LGH);
    AppMethodBeat.o(118712);
  }
  
  private static void fOr()
  {
    AppMethodBeat.i(216822);
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = new File(((com.tencent.mm.kernel.f)localObject).aHl()).list();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        Log.i(TAG, "removeDirtyDB file:%s", new Object[] { str });
        if ((str != null) && (n.g((CharSequence)str, (CharSequence)"StoryMicroMsg")))
        {
          Log.i(TAG, "removeDirtyDB will delete:%s", new Object[] { str });
          u.deleteFile(str);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(216822);
  }
  
  public static boolean isValid()
  {
    AppMethodBeat.i(118711);
    boolean bool = com.tencent.mm.kernel.h.aHE().aGM();
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
    if (this.JXQ)
    {
      AppMethodBeat.o(118709);
      return;
    }
    this.JXQ = true;
    this.wUJ = true;
    Object localObject1 = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class);
    p.j(localObject1, "plugin(IPluginStory::class.java)");
    u.bBD(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryPath());
    localObject1 = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class);
    p.j(localObject1, "plugin(IPluginStory::class.java)");
    u.bBD(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryTmpPath());
    EventCenter.instance.addListener((IListener)this.LGq);
    EventCenter.instance.addListener((IListener)this.LGr);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new h(), new String[] { "//story" });
    localObject1 = b.gcC();
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).kPU.a((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject1).LKE);
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).AAa.a((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject1).LKF);
    Object localObject2 = com.tencent.mm.kernel.h.aHF();
    p.j(localObject2, "MMKernel.network()");
    ((com.tencent.mm.kernel.c)localObject2).aGY().a(351, (com.tencent.mm.an.i)localObject1);
    localObject1 = b.gcx();
    ((com.tencent.mm.plugin.story.i.g)localObject1).add((MStorage.IOnStorageChange)localObject1);
    localObject1 = com.tencent.mm.plugin.story.f.b.b.LIo;
    if ((u.agG(com.tencent.mm.plugin.story.f.b.b.LIe)) && (!u.agG(com.tencent.mm.plugin.story.f.b.b.Kao))) {
      u.oo(com.tencent.mm.plugin.story.f.b.b.LIe, com.tencent.mm.plugin.story.f.b.b.Kao);
    }
    localObject2 = u.aY(com.tencent.mm.plugin.story.f.b.b.Kao, 0, -1);
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
        com.tencent.mm.plugin.story.f.b.b.LIh.parseFrom((byte[])localObject2);
      }
      localObject2 = com.tencent.mm.kernel.h.aHF();
      p.j(localObject2, "network()");
      ((com.tencent.mm.kernel.c)localObject2).aGY().a(354, (com.tencent.mm.an.i)localObject1);
      localObject2 = com.tencent.mm.kernel.h.aHF();
      p.j(localObject2, "network()");
      ((com.tencent.mm.kernel.c)localObject2).aGY().a(764, (com.tencent.mm.an.i)localObject1);
      com.tencent.mm.plugin.story.f.b.b.fPI();
      b.gcH();
      com.tencent.mm.plugin.story.f.f.a.LJD.init();
      LGw.alive();
      localObject1 = l.LGM;
      l.reset();
      localObject1 = l.LGM;
      u.bBD(l.gcL() + "coming/");
      u.bBD(l.gcL() + "pic/");
      u.bBD(l.gcL() + "video/");
      com.tencent.mm.plugin.story.api.p.LEL = (p.b)com.tencent.mm.plugin.story.f.d.e.LIN;
      EventCenter.instance.addListener((IListener)this.LGs);
      this.LGt.alive();
      AppMethodBeat.o(118709);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(118710);
    this.LGt.dead();
    EventCenter.instance.removeListener((IListener)this.LGq);
    EventCenter.instance.removeListener((IListener)this.LGr);
    EventCenter.instance.removeListener((IListener)this.LGs);
    com.tencent.mm.pluginsdk.cmd.b.W(new String[] { "//story" });
    Object localObject = b.gcC();
    ((com.tencent.mm.plugin.story.f.g.c)localObject).kPU.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject).LKE);
    ((com.tencent.mm.plugin.story.f.g.c)localObject).AAa.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject).LKF);
    com.tencent.mm.kernel.c localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(351, (com.tencent.mm.an.i)localObject);
    localObject = b.gcx();
    ((com.tencent.mm.plugin.story.i.g)localObject).remove((MStorage.IOnStorageChange)localObject);
    localObject = com.tencent.mm.plugin.story.f.b.b.LIo;
    com.tencent.mm.plugin.story.f.b.b.gdl();
    localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "network()");
    localc.aGY().b(354, (com.tencent.mm.an.i)localObject);
    localc = com.tencent.mm.kernel.h.aHF();
    p.j(localc, "network()");
    localc.aGY().b(764, (com.tencent.mm.an.i)localObject);
    localObject = com.tencent.mm.plugin.story.f.f.a.LJD;
    Log.i(com.tencent.mm.plugin.story.f.f.a.TAG, "destroy: ");
    b.gcx().remove((MStorage.IOnStorageChange)localObject);
    b.gcw().remove((MStorage.IOnStorageChange)localObject);
    com.tencent.mm.plugin.story.f.f.a.qem.clear();
    com.tencent.mm.plugin.story.f.f.a.LJB.dead();
    localObject = com.tencent.mm.plugin.story.f.b.b.LIo;
    com.tencent.mm.plugin.story.f.b.b.g(com.tencent.mm.plugin.story.f.f.a.LJC);
    LGw.dead();
    AppMethodBeat.o(118710);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-story_release"})
  public final class a
    extends com.tencent.mm.app.o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(118683);
      paramString = new yj();
      paramString.fXH.state = 0;
      EventCenter.instance.publish((IEvent)paramString);
      AppMethodBeat.o(118683);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(118682);
      paramString = new yj();
      paramString.fXH.state = 1;
      EventCenter.instance.publish((IEvent)paramString);
      AppMethodBeat.o(118682);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"})
  public static final class b
  {
    public static com.tencent.mm.loader.c.e a(com.tencent.mm.plugin.story.f.c.a parama)
    {
      AppMethodBeat.i(118697);
      p.k(parama, "scene");
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.o(gcv()) == null) {
        j.a(gcv(), new com.tencent.mm.plugin.story.f.c.e());
      }
      com.tencent.mm.plugin.story.f.c.e locale = j.o(gcv());
      if (locale == null) {
        p.iCn();
      }
      p.k(parama, "scene");
      switch (com.tencent.mm.plugin.story.f.c.f.$EnumSwitchMapping$0[parama.ordinal()])
      {
      default: 
        parama = new kotlin.m();
        AppMethodBeat.o(118697);
        throw parama;
      case 1: 
      case 2: 
        parama = locale.LIJ;
        AppMethodBeat.o(118697);
        return parama;
      }
      parama = locale.LII;
      AppMethodBeat.o(118697);
      return parama;
    }
    
    public static String fOo()
    {
      AppMethodBeat.i(118700);
      Object localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      String str = (String)((com.tencent.mm.kernel.f)localObject).aHp().get(2);
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
    
    public static MMHandler fwa()
    {
      AppMethodBeat.i(118693);
      Object localObject = com.tencent.mm.kernel.h.aHJ();
      p.j(localObject, "MMKernel.getPizzaWorkerThread()");
      localObject = ((MMHandlerThread)localObject).getWorkerHandler();
      p.j(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
      AppMethodBeat.o(118693);
      return localObject;
    }
    
    public static o gcA()
    {
      AppMethodBeat.i(118691);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.k(gcv()) == null) {
        j.a(gcv(), new o((ISQLiteDatabase)getDataDB()));
      }
      o localo = j.k(gcv());
      if (localo == null) {
        p.iCn();
      }
      AppMethodBeat.o(118691);
      return localo;
    }
    
    public static com.tencent.mm.plugin.story.i.i gcB()
    {
      AppMethodBeat.i(118692);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.l(gcv()) == null) {
        j.a(gcv(), new com.tencent.mm.plugin.story.i.i((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.i locali = j.l(gcv());
      if (locali == null) {
        p.iCn();
      }
      AppMethodBeat.o(118692);
      return locali;
    }
    
    public static com.tencent.mm.plugin.story.f.g.c gcC()
    {
      AppMethodBeat.i(118694);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.m(gcv()) == null) {
        j.a(gcv(), new com.tencent.mm.plugin.story.f.g.c());
      }
      com.tencent.mm.plugin.story.f.g.c localc = j.m(gcv());
      if (localc == null) {
        p.iCn();
      }
      AppMethodBeat.o(118694);
      return localc;
    }
    
    public static e gcD()
    {
      AppMethodBeat.i(118695);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.n(gcv()) == null)
      {
        localObject1 = gcv();
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2 = com.tencent.mm.kernel.h.aHG();
        p.j(localObject2, "MMKernel.storage()");
        localStringBuilder = localStringBuilder.append(((com.tencent.mm.kernel.f)localObject2).aHl());
        localObject2 = e.LFX;
        j.a((j)localObject1, new e(e.gcg()));
      }
      Object localObject1 = j.n(gcv());
      if (localObject1 == null) {
        p.iCn();
      }
      AppMethodBeat.o(118695);
      return localObject1;
    }
    
    public static com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> gcE()
    {
      AppMethodBeat.i(118696);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.o(gcv()) == null) {
        j.a(gcv(), new com.tencent.mm.plugin.story.f.c.e());
      }
      Object localObject = j.o(gcv());
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((com.tencent.mm.plugin.story.f.c.e)localObject).LIG;
      AppMethodBeat.o(118696);
      return localObject;
    }
    
    public static o.a gcF()
    {
      AppMethodBeat.i(118698);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.p(gcv()) == null) {
        j.a(gcv(), new o.a());
      }
      o.a locala = j.p(gcv());
      if (locala == null) {
        p.iCn();
      }
      AppMethodBeat.o(118698);
      return locala;
    }
    
    public static g.a gcG()
    {
      AppMethodBeat.i(118703);
      g.a locala = (g.a)com.tencent.mm.plugin.story.c.a.g.LFu.aUb();
      AppMethodBeat.o(118703);
      return locala;
    }
    
    static void gcH()
    {
      AppMethodBeat.i(118704);
      j.gcs();
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvw, 1);
      Log.d(j.access$getTAG$cp(), "loadStoryCheck %s local_debug %s", new Object[] { Integer.valueOf(i), Boolean.FALSE });
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.bgB().Mu("100481");
      p.j(localc, "abTestItem");
      if ((localc.isValid()) && (p.h("1", (String)localc.hvz().get("open")))) {
        i = 1;
      }
      for (;;)
      {
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          j.zr(bool);
          AppMethodBeat.o(118704);
          return;
        }
      }
    }
    
    public static boolean gcI()
    {
      AppMethodBeat.i(118705);
      if (com.tencent.mm.plugin.textstatus.a.t.gkZ())
      {
        AppMethodBeat.o(118705);
        return false;
      }
      if (!j.gcr()) {
        gcH();
      }
      boolean bool = j.gct();
      AppMethodBeat.o(118705);
      return bool;
    }
    
    public static long gcJ()
    {
      AppMethodBeat.i(118706);
      if (j.gcu() == -1L)
      {
        com.tencent.mm.kernel.f localf = com.tencent.mm.kernel.h.aHG();
        p.j(localf, "MMKernel.storage()");
        j.RD(localf.aHp().a(ar.a.Vxd, 0L));
      }
      long l = j.gcu();
      AppMethodBeat.o(118706);
      return l;
    }
    
    private static j gcv()
    {
      AppMethodBeat.i(118685);
      j localj = (j)y.as(j.class);
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
        p.j(localThread, "Thread.currentThread()");
        localStringBuilder = localStringBuilder.append(localThread.getName()).append(" ");
        localThread = Thread.currentThread();
        p.j(localThread, "Thread.currentThread()");
        Log.i((String)localObject2, localThread.getId() + " " + localj.hashCode());
        if (j.b(localj))
        {
          j.e(localj);
          j.c(localj);
          Log.i(j.access$getTAG$cp(), "resetdb done");
        }
        localObject2 = x.aazN;
        p.j(localj, "theCore");
        AppMethodBeat.o(118685);
        return localj;
      }
    }
    
    public static k gcw()
    {
      AppMethodBeat.i(118687);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.g(gcv()) == null) {
        j.a(gcv(), new k((ISQLiteDatabase)getDataDB()));
      }
      k localk = j.g(gcv());
      if (localk == null) {
        p.iCn();
      }
      AppMethodBeat.o(118687);
      return localk;
    }
    
    public static com.tencent.mm.plugin.story.i.g gcx()
    {
      AppMethodBeat.i(118688);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.h(gcv()) == null) {
        j.a(gcv(), new com.tencent.mm.plugin.story.i.g((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.g localg = j.h(gcv());
      if (localg == null) {
        p.iCn();
      }
      AppMethodBeat.o(118688);
      return localg;
    }
    
    public static com.tencent.mm.plugin.story.i.m gcy()
    {
      AppMethodBeat.i(118689);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.i(gcv()) == null) {
        j.a(gcv(), new com.tencent.mm.plugin.story.i.m((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.m localm = j.i(gcv());
      if (localm == null) {
        p.iCn();
      }
      AppMethodBeat.o(118689);
      return localm;
    }
    
    public static com.tencent.mm.plugin.story.i.b gcz()
    {
      AppMethodBeat.i(118690);
      com.tencent.mm.kernel.h.aHE().aGH();
      if (j.j(gcv()) == null) {
        j.a(gcv(), new com.tencent.mm.plugin.story.i.b((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.b localb = j.j(gcv());
      if (localb == null) {
        p.iCn();
      }
      AppMethodBeat.o(118690);
      return localb;
    }
    
    public static String getAccStoryCachePath()
    {
      AppMethodBeat.i(118702);
      Object localObject = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class);
      p.j(localObject, "plugin<IPluginStory>(IPluginStory::class.java)");
      localObject = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryCachePath();
      p.j(localObject, "plugin<IPluginStory>(IPl…s.java).accStoryCachePath");
      AppMethodBeat.o(118702);
      return localObject;
    }
    
    public static String getAccStoryPath()
    {
      AppMethodBeat.i(118701);
      Object localObject = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class);
      p.j(localObject, "plugin<IPluginStory>(IPluginStory::class.java)");
      localObject = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath();
      p.j(localObject, "plugin<IPluginStory>(IPl…:class.java).accStoryPath");
      AppMethodBeat.o(118701);
      return localObject;
    }
    
    private static com.tencent.mm.storagebase.h getDataDB()
    {
      AppMethodBeat.i(118686);
      com.tencent.mm.storagebase.h localh = j.f(gcv());
      if (localh == null) {
        p.iCn();
      }
      AppMethodBeat.o(118686);
      return localh;
    }
    
    public static boolean isInValid()
    {
      AppMethodBeat.i(118699);
      gcv();
      if (!j.isValid())
      {
        AppMethodBeat.o(118699);
        return true;
      }
      AppMethodBeat.o(118699);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/model/StoryCore$Companion$exptChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends IListener<fw>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/DynamicConfigUpdatedEvent;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "callback", "", "event", "plugin-story_release"})
  public final class d
    extends IListener<dk>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.j
 * JD-Core Version:    0.7.0.1
 */
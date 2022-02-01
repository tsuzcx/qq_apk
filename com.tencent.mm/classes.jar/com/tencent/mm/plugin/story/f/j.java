package com.tencent.mm.plugin.story.f;

import android.graphics.Point;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.PluginStory.b;
import com.tencent.mm.plugin.story.PluginStory.c;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.f.a.i;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storagebase.h.b;
import d.g.b.p;
import d.n.n;
import d.z;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "appForegroundListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "removeDirtyDB", "resetDb", "updateConfigs", "AppForegroundListener", "Companion", "ConfigChangedListener", "plugin-story_release"})
public final class j
  implements ax
{
  private static final int AJW = 150;
  private static final com.tencent.mm.sdk.b.c<fl> AJX;
  private static boolean AJY = false;
  private static boolean AJZ = false;
  private static long AKa = 0L;
  public static final b AKb;
  private static final String TAG = "MicroMsg.StoryCore";
  private static final Point hqz;
  private static String zjK;
  private static final int zjU = 103;
  private HashMap<Integer, h.b> AJG;
  private k AJH;
  private com.tencent.mm.plugin.story.i.g AJI;
  private com.tencent.mm.plugin.story.i.m AJJ;
  private com.tencent.mm.plugin.story.i.b AJK;
  private o AJL;
  private com.tencent.mm.plugin.story.i.i AJM;
  private com.tencent.mm.plugin.story.f.g.c AJN;
  private e AJO;
  private com.tencent.mm.plugin.story.f.c.e AJP;
  private o.a AJQ;
  private PluginStory.c AJR;
  private PluginStory.b AJS;
  private d AJT;
  private a AJU;
  private ap AJV;
  private com.tencent.mm.storagebase.h gBq;
  private final ap handler;
  private final byte[] lock;
  private boolean rFO;
  private boolean zjI;
  
  static
  {
    AppMethodBeat.i(118713);
    AKb = new b((byte)0);
    TAG = "MicroMsg.StoryCore";
    zjK = "";
    hqz = new Point();
    zjU = 103;
    AJW = 150;
    AJX = (com.tencent.mm.sdk.b.c)new c();
    AKa = -1L;
    AppMethodBeat.o(118713);
  }
  
  public j()
  {
    AppMethodBeat.i(118712);
    this.lock = new byte[0];
    this.AJG = new HashMap();
    this.AJR = new PluginStory.c();
    this.AJS = new PluginStory.b();
    this.AJT = new d();
    this.AJU = new a();
    this.handler = new ap(Looper.getMainLooper());
    this.AJV = new ap("SnsCore_task_handler");
    ((Map)this.AJG).put(Integer.valueOf("MMStoryInfo".hashCode()), j.1.AKc);
    ((Map)this.AJG).put(Integer.valueOf("StoryExtItem".hashCode()), j.2.AKd);
    ((Map)this.AJG).put(Integer.valueOf("StoryCommentSync".hashCode()), j.3.AKe);
    ((Map)this.AJG).put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), j.4.AKf);
    ((Map)this.AJG).put(Integer.valueOf("StoryEditorInfo".hashCode()), j.5.AKg);
    ((Map)this.AJG).put(Integer.valueOf("StoryRoomInfo".hashCode()), j.6.AKh);
    ((Map)this.AJG).put(Integer.valueOf("MMStoryHistoryItem".hashCode()), j.7.AKi);
    AppMethodBeat.o(118712);
  }
  
  private static void dTM()
  {
    AppMethodBeat.i(189775);
    Object localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = new File(((com.tencent.mm.kernel.e)localObject).ajh()).list();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        ad.i(TAG, "removeDirtyDB file:%s", new Object[] { str });
        if ((str != null) && (n.e((CharSequence)str, (CharSequence)"StoryMicroMsg")))
        {
          ad.i(TAG, "removeDirtyDB will delete:%s", new Object[] { str });
          com.tencent.mm.vfs.i.deleteFile(str);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(189775);
  }
  
  public static boolean isValid()
  {
    AppMethodBeat.i(118711);
    boolean bool = com.tencent.mm.kernel.g.ajA().aiK();
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
    if (this.zjI)
    {
      AppMethodBeat.o(118709);
      return;
    }
    this.zjI = true;
    this.rFO = true;
    Object localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    p.g(localObject1, "plugin(IPluginStory::class.java)");
    com.tencent.mm.vfs.i.aYg(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryPath());
    localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    p.g(localObject1, "plugin(IPluginStory::class.java)");
    com.tencent.mm.vfs.i.aYg(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryTmpPath());
    com.tencent.mm.sdk.b.a.IbL.c((com.tencent.mm.sdk.b.c)this.AJR);
    com.tencent.mm.sdk.b.a.IbL.c((com.tencent.mm.sdk.b.c)this.AJS);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new h(), new String[] { "//story" });
    localObject1 = b.ehZ();
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).hfB.a((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject1).AOj);
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).sJd.a((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject1).AOk);
    Object localObject2 = com.tencent.mm.kernel.g.ajB();
    p.g(localObject2, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject2).aiU().a(351, (com.tencent.mm.al.f)localObject1);
    localObject1 = b.ehU();
    ((com.tencent.mm.plugin.story.i.g)localObject1).add((k.a)localObject1);
    localObject1 = com.tencent.mm.plugin.story.f.b.b.ALT;
    if ((com.tencent.mm.vfs.i.fv(com.tencent.mm.plugin.story.f.b.b.ALJ)) && (!com.tencent.mm.vfs.i.fv(com.tencent.mm.plugin.story.f.b.b.zlT))) {
      com.tencent.mm.vfs.i.mA(com.tencent.mm.plugin.story.f.b.b.ALJ, com.tencent.mm.plugin.story.f.b.b.zlT);
    }
    localObject2 = com.tencent.mm.vfs.i.aY(com.tencent.mm.plugin.story.f.b.b.zlT, 0, -1);
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
        com.tencent.mm.plugin.story.f.b.b.ALM.parseFrom((byte[])localObject2);
      }
      localObject2 = com.tencent.mm.kernel.g.ajB();
      p.g(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).aiU().a(354, (com.tencent.mm.al.f)localObject1);
      localObject2 = com.tencent.mm.kernel.g.ajB();
      p.g(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).aiU().a(764, (com.tencent.mm.al.f)localObject1);
      com.tencent.mm.plugin.story.f.b.b.dVc();
      b.eie();
      com.tencent.mm.plugin.story.f.f.a.ANj.init();
      AJX.alive();
      localObject1 = l.AKo;
      l.reset();
      localObject1 = l.AKo;
      com.tencent.mm.vfs.i.aYg(l.eii() + "coming/");
      com.tencent.mm.vfs.i.aYg(l.eii() + "pic/");
      com.tencent.mm.vfs.i.aYg(l.eii() + "video/");
      com.tencent.mm.plugin.story.api.p.AIi = (p.b)com.tencent.mm.plugin.story.f.d.e.AMs;
      com.tencent.mm.sdk.b.a.IbL.c((com.tencent.mm.sdk.b.c)this.AJT);
      this.AJU.alive();
      AppMethodBeat.o(118709);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(118710);
    this.AJU.dead();
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)this.AJR);
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)this.AJS);
    com.tencent.mm.sdk.b.a.IbL.d((com.tencent.mm.sdk.b.c)this.AJT);
    com.tencent.mm.pluginsdk.cmd.b.S(new String[] { "//story" });
    Object localObject = b.ehZ();
    ((com.tencent.mm.plugin.story.f.g.c)localObject).hfB.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject).AOj);
    ((com.tencent.mm.plugin.story.f.g.c)localObject).sJd.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject).AOk);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(351, (com.tencent.mm.al.f)localObject);
    localObject = b.ehU();
    ((com.tencent.mm.plugin.story.i.g)localObject).remove((k.a)localObject);
    localObject = com.tencent.mm.plugin.story.f.b.b.ALT;
    com.tencent.mm.plugin.story.f.b.b.eiH();
    localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "network()");
    localb.aiU().b(354, (com.tencent.mm.al.f)localObject);
    localb = com.tencent.mm.kernel.g.ajB();
    p.g(localb, "network()");
    localb.aiU().b(764, (com.tencent.mm.al.f)localObject);
    localObject = com.tencent.mm.plugin.story.f.f.a.ANj;
    ad.i(com.tencent.mm.plugin.story.f.f.a.TAG, "destroy: ");
    b.ehU().remove((k.a)localObject);
    b.ehT().remove((k.a)localObject);
    com.tencent.mm.plugin.story.f.f.a.lRS.clear();
    com.tencent.mm.plugin.story.f.f.a.ANh.dead();
    localObject = com.tencent.mm.plugin.story.f.b.b.ALT;
    com.tencent.mm.plugin.story.f.b.b.e(com.tencent.mm.plugin.story.f.f.a.ANi);
    AJX.dead();
    AppMethodBeat.o(118710);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-story_release"})
  public final class a
    extends n.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(118683);
      paramString = new vy();
      paramString.dKu.state = 0;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)paramString);
      AppMethodBeat.o(118683);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(118682);
      paramString = new vy();
      paramString.dKu.state = 1;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)paramString);
      AppMethodBeat.o(118682);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"})
  public static final class b
  {
    public static com.tencent.mm.loader.c.e a(com.tencent.mm.plugin.story.f.c.a parama)
    {
      AppMethodBeat.i(118697);
      p.h(parama, "scene");
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.o(ehS()) == null) {
        j.a(ehS(), new com.tencent.mm.plugin.story.f.c.e());
      }
      com.tencent.mm.plugin.story.f.c.e locale = j.o(ehS());
      if (locale == null) {
        p.gfZ();
      }
      p.h(parama, "scene");
      switch (com.tencent.mm.plugin.story.f.c.f.cpQ[parama.ordinal()])
      {
      default: 
        parama = new d.m();
        AppMethodBeat.o(118697);
        throw parama;
      case 1: 
      case 2: 
        parama = locale.AMo;
        AppMethodBeat.o(118697);
        return parama;
      }
      parama = locale.AMn;
      AppMethodBeat.o(118697);
      return parama;
    }
    
    public static ap dFL()
    {
      AppMethodBeat.i(118693);
      Object localObject = com.tencent.mm.kernel.g.ajF();
      p.g(localObject, "MMKernel.getPizzaWorkerThread()");
      localObject = ((aq)localObject).cWY();
      p.g(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
      AppMethodBeat.o(118693);
      return localObject;
    }
    
    public static String dTJ()
    {
      AppMethodBeat.i(118700);
      Object localObject = com.tencent.mm.kernel.g.ajC();
      p.g(localObject, "MMKernel.storage()");
      String str = (String)((com.tencent.mm.kernel.e)localObject).ajl().get(2);
      if (str == null) {
        ad.i(j.access$getTAG$cp(), "error getSelfName " + bt.flS());
      }
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(118700);
      return localObject;
    }
    
    public static boolean dTN()
    {
      AppMethodBeat.i(118699);
      ehS();
      if (!j.isValid())
      {
        AppMethodBeat.o(118699);
        return true;
      }
      AppMethodBeat.o(118699);
      return false;
    }
    
    private static j ehS()
    {
      AppMethodBeat.i(118685);
      j localj = (j)t.ap(j.class);
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
        p.g(localThread, "Thread.currentThread()");
        localStringBuilder = localStringBuilder.append(localThread.getName()).append(" ");
        localThread = Thread.currentThread();
        p.g(localThread, "Thread.currentThread()");
        ad.i((String)localObject2, localThread.getId() + " " + localj.hashCode());
        if (j.b(localj))
        {
          j.e(localj);
          j.c(localj);
          ad.i(j.access$getTAG$cp(), "resetdb done");
        }
        localObject2 = z.MKo;
        p.g(localj, "theCore");
        AppMethodBeat.o(118685);
        return localj;
      }
    }
    
    public static k ehT()
    {
      AppMethodBeat.i(118687);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.g(ehS()) == null) {
        j.a(ehS(), new k((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      k localk = j.g(ehS());
      if (localk == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118687);
      return localk;
    }
    
    public static com.tencent.mm.plugin.story.i.g ehU()
    {
      AppMethodBeat.i(118688);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.h(ehS()) == null) {
        j.a(ehS(), new com.tencent.mm.plugin.story.i.g((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.g localg = j.h(ehS());
      if (localg == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118688);
      return localg;
    }
    
    public static com.tencent.mm.plugin.story.i.m ehV()
    {
      AppMethodBeat.i(118689);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.i(ehS()) == null) {
        j.a(ehS(), new com.tencent.mm.plugin.story.i.m((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.m localm = j.i(ehS());
      if (localm == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118689);
      return localm;
    }
    
    public static com.tencent.mm.plugin.story.i.b ehW()
    {
      AppMethodBeat.i(118690);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.j(ehS()) == null) {
        j.a(ehS(), new com.tencent.mm.plugin.story.i.b((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.b localb = j.j(ehS());
      if (localb == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118690);
      return localb;
    }
    
    public static o ehX()
    {
      AppMethodBeat.i(118691);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.k(ehS()) == null) {
        j.a(ehS(), new o((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      o localo = j.k(ehS());
      if (localo == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118691);
      return localo;
    }
    
    public static com.tencent.mm.plugin.story.i.i ehY()
    {
      AppMethodBeat.i(118692);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.l(ehS()) == null) {
        j.a(ehS(), new com.tencent.mm.plugin.story.i.i((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.i locali = j.l(ehS());
      if (locali == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118692);
      return locali;
    }
    
    public static com.tencent.mm.plugin.story.f.g.c ehZ()
    {
      AppMethodBeat.i(118694);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.m(ehS()) == null) {
        j.a(ehS(), new com.tencent.mm.plugin.story.f.g.c());
      }
      com.tencent.mm.plugin.story.f.g.c localc = j.m(ehS());
      if (localc == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118694);
      return localc;
    }
    
    public static e eia()
    {
      AppMethodBeat.i(118695);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.n(ehS()) == null)
      {
        localObject1 = ehS();
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2 = com.tencent.mm.kernel.g.ajC();
        p.g(localObject2, "MMKernel.storage()");
        localStringBuilder = localStringBuilder.append(((com.tencent.mm.kernel.e)localObject2).ajh());
        localObject2 = e.AJy;
        j.a((j)localObject1, new e(e.ehD()));
      }
      Object localObject1 = j.n(ehS());
      if (localObject1 == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118695);
      return localObject1;
    }
    
    public static com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> eib()
    {
      AppMethodBeat.i(118696);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.o(ehS()) == null) {
        j.a(ehS(), new com.tencent.mm.plugin.story.f.c.e());
      }
      Object localObject = j.o(ehS());
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((com.tencent.mm.plugin.story.f.c.e)localObject).AMl;
      AppMethodBeat.o(118696);
      return localObject;
    }
    
    public static o.a eic()
    {
      AppMethodBeat.i(118698);
      com.tencent.mm.kernel.g.ajA().aiF();
      if (j.p(ehS()) == null) {
        j.a(ehS(), new o.a());
      }
      o.a locala = j.p(ehS());
      if (locala == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118698);
      return locala;
    }
    
    public static g.a eid()
    {
      AppMethodBeat.i(118703);
      g.a locala = (g.a)com.tencent.mm.plugin.story.c.a.g.AIR.ate();
      AppMethodBeat.o(118703);
      return locala;
    }
    
    static void eie()
    {
      AppMethodBeat.i(118704);
      j.ehP();
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqG, 1);
      ad.d(j.access$getTAG$cp(), "loadStoryCheck %s local_debug %s", new Object[] { Integer.valueOf(i), Boolean.FALSE });
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100481");
      p.g(localc, "abTestItem");
      if ((localc.isValid()) && (p.i("1", (String)localc.foF().get("open")))) {
        i = 1;
      }
      for (;;)
      {
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          j.sl(bool);
          AppMethodBeat.o(118704);
          return;
        }
      }
    }
    
    public static boolean eif()
    {
      AppMethodBeat.i(118705);
      if (!j.ehO()) {
        eie();
      }
      boolean bool = j.ehQ();
      AppMethodBeat.o(118705);
      return bool;
    }
    
    public static long eig()
    {
      AppMethodBeat.i(118706);
      if (j.ehR() == -1L)
      {
        com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajC();
        p.g(locale, "MMKernel.storage()");
        j.AG(locale.ajl().a(al.a.IFH, 0L));
      }
      long l = j.ehR();
      AppMethodBeat.o(118706);
      return l;
    }
    
    public static String getAccStoryCachePath()
    {
      AppMethodBeat.i(118702);
      Object localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
      p.g(localObject, "plugin<IPluginStory>(IPluginStory::class.java)");
      localObject = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryCachePath();
      p.g(localObject, "plugin<IPluginStory>(IPl…s.java).accStoryCachePath");
      AppMethodBeat.o(118702);
      return localObject;
    }
    
    public static String getAccStoryPath()
    {
      AppMethodBeat.i(118701);
      Object localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
      p.g(localObject, "plugin<IPluginStory>(IPluginStory::class.java)");
      localObject = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath();
      p.g(localObject, "plugin<IPluginStory>(IPl…:class.java).accStoryPath");
      AppMethodBeat.o(118701);
      return localObject;
    }
    
    private static com.tencent.mm.storagebase.h getDataDB()
    {
      AppMethodBeat.i(118686);
      com.tencent.mm.storagebase.h localh = j.f(ehS());
      if (localh == null) {
        p.gfZ();
      }
      AppMethodBeat.o(118686);
      return localh;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/model/StoryCore$Companion$exptChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<fl>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/DynamicConfigUpdatedEvent;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "callback", "", "event", "plugin-story_release"})
  public final class d
    extends com.tencent.mm.sdk.b.c<db>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.j
 * JD-Core Version:    0.7.0.1
 */
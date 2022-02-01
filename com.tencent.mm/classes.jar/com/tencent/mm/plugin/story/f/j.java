package com.tencent.mm.plugin.story.f;

import android.graphics.Point;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.wc;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.story.PluginStory.b;
import com.tencent.mm.plugin.story.PluginStory.c;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.f.a.i;
import com.tencent.mm.plugin.story.i.i;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.djr;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storagebase.h.b;
import d.g.b.p;
import d.n.n;
import d.z;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "appForegroundListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "removeDirtyDB", "resetDb", "updateConfigs", "AppForegroundListener", "Companion", "ConfigChangedListener", "plugin-story_release"})
public final class j
  implements az
{
  private static final com.tencent.mm.sdk.b.c<fm> BbA;
  private static boolean BbB = false;
  private static boolean BbC = false;
  private static long BbD = 0L;
  public static final b BbE;
  private static final int Bbz = 150;
  private static final String TAG = "MicroMsg.StoryCore";
  private static final Point htn;
  private static String zAZ;
  private static final int zBj = 103;
  private HashMap<Integer, h.b> Bbj;
  private k Bbk;
  private com.tencent.mm.plugin.story.i.g Bbl;
  private com.tencent.mm.plugin.story.i.m Bbm;
  private com.tencent.mm.plugin.story.i.b Bbn;
  private com.tencent.mm.plugin.story.i.o Bbo;
  private i Bbp;
  private com.tencent.mm.plugin.story.f.g.c Bbq;
  private e Bbr;
  private com.tencent.mm.plugin.story.f.c.e Bbs;
  private o.a Bbt;
  private PluginStory.c Bbu;
  private PluginStory.b Bbv;
  private d Bbw;
  private a Bbx;
  private aq Bby;
  private com.tencent.mm.storagebase.h gDX;
  private final aq handler;
  private final byte[] lock;
  private boolean rNZ;
  private boolean zAX;
  
  static
  {
    AppMethodBeat.i(118713);
    BbE = new b((byte)0);
    TAG = "MicroMsg.StoryCore";
    zAZ = "";
    htn = new Point();
    zBj = 103;
    Bbz = 150;
    BbA = (com.tencent.mm.sdk.b.c)new c();
    BbD = -1L;
    AppMethodBeat.o(118713);
  }
  
  public j()
  {
    AppMethodBeat.i(118712);
    this.lock = new byte[0];
    this.Bbj = new HashMap();
    this.Bbu = new PluginStory.c();
    this.Bbv = new PluginStory.b();
    this.Bbw = new d();
    this.Bbx = new a();
    this.handler = new aq(Looper.getMainLooper());
    this.Bby = new aq("SnsCore_task_handler");
    ((Map)this.Bbj).put(Integer.valueOf("MMStoryInfo".hashCode()), j.1.BbF);
    ((Map)this.Bbj).put(Integer.valueOf("StoryExtItem".hashCode()), 2.BbG);
    ((Map)this.Bbj).put(Integer.valueOf("StoryCommentSync".hashCode()), j.3.BbH);
    ((Map)this.Bbj).put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), j.4.BbI);
    ((Map)this.Bbj).put(Integer.valueOf("StoryEditorInfo".hashCode()), j.5.BbJ);
    ((Map)this.Bbj).put(Integer.valueOf("StoryRoomInfo".hashCode()), j.6.BbK);
    ((Map)this.Bbj).put(Integer.valueOf("MMStoryHistoryItem".hashCode()), 7.BbL);
    AppMethodBeat.o(118712);
  }
  
  private static void dXm()
  {
    AppMethodBeat.i(221745);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = new File(((com.tencent.mm.kernel.e)localObject).ajw()).list();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        ae.i(TAG, "removeDirtyDB file:%s", new Object[] { str });
        if ((str != null) && (n.f((CharSequence)str, (CharSequence)"StoryMicroMsg")))
        {
          ae.i(TAG, "removeDirtyDB will delete:%s", new Object[] { str });
          com.tencent.mm.vfs.o.deleteFile(str);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(221745);
  }
  
  public static boolean isValid()
  {
    AppMethodBeat.i(118711);
    boolean bool = com.tencent.mm.kernel.g.ajP().aiZ();
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
    if (this.zAX)
    {
      AppMethodBeat.o(118709);
      return;
    }
    this.zAX = true;
    this.rNZ = true;
    Object localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    p.g(localObject1, "plugin(IPluginStory::class.java)");
    com.tencent.mm.vfs.o.aZI(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryPath());
    localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    p.g(localObject1, "plugin(IPluginStory::class.java)");
    com.tencent.mm.vfs.o.aZI(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryTmpPath());
    com.tencent.mm.sdk.b.a.IvT.c((com.tencent.mm.sdk.b.c)this.Bbu);
    com.tencent.mm.sdk.b.a.IvT.c((com.tencent.mm.sdk.b.c)this.Bbv);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new h(), new String[] { "//story" });
    localObject1 = b.elH();
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).hip.a((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject1).BfK);
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).sUq.a((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject1).BfL);
    Object localObject2 = com.tencent.mm.kernel.g.ajQ();
    p.g(localObject2, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject2).ajj().a(351, (com.tencent.mm.ak.f)localObject1);
    localObject1 = b.elC();
    ((com.tencent.mm.plugin.story.i.g)localObject1).add((k.a)localObject1);
    localObject1 = com.tencent.mm.plugin.story.f.b.b.Bdv;
    if ((com.tencent.mm.vfs.o.fB(com.tencent.mm.plugin.story.f.b.b.Bdm)) && (!com.tencent.mm.vfs.o.fB(com.tencent.mm.plugin.story.f.b.b.zDi))) {
      com.tencent.mm.vfs.o.mG(com.tencent.mm.plugin.story.f.b.b.Bdm, com.tencent.mm.plugin.story.f.b.b.zDi);
    }
    localObject2 = com.tencent.mm.vfs.o.bb(com.tencent.mm.plugin.story.f.b.b.zDi, 0, -1);
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
        com.tencent.mm.plugin.story.f.b.b.Bdo.parseFrom((byte[])localObject2);
      }
      localObject2 = com.tencent.mm.kernel.g.ajQ();
      p.g(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).ajj().a(354, (com.tencent.mm.ak.f)localObject1);
      localObject2 = com.tencent.mm.kernel.g.ajQ();
      p.g(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).ajj().a(764, (com.tencent.mm.ak.f)localObject1);
      com.tencent.mm.plugin.story.f.b.b.dYC();
      b.elM();
      com.tencent.mm.plugin.story.f.f.a.BeK.init();
      BbA.alive();
      localObject1 = l.BbR;
      l.reset();
      localObject1 = l.BbR;
      com.tencent.mm.vfs.o.aZI(l.elQ() + "coming/");
      com.tencent.mm.vfs.o.aZI(l.elQ() + "pic/");
      com.tencent.mm.vfs.o.aZI(l.elQ() + "video/");
      com.tencent.mm.plugin.story.api.p.AZL = (p.b)com.tencent.mm.plugin.story.f.d.e.BdU;
      com.tencent.mm.sdk.b.a.IvT.c((com.tencent.mm.sdk.b.c)this.Bbw);
      this.Bbx.alive();
      AppMethodBeat.o(118709);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(118710);
    this.Bbx.dead();
    com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)this.Bbu);
    com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)this.Bbv);
    com.tencent.mm.sdk.b.a.IvT.d((com.tencent.mm.sdk.b.c)this.Bbw);
    com.tencent.mm.pluginsdk.cmd.b.S(new String[] { "//story" });
    Object localObject = b.elH();
    ((com.tencent.mm.plugin.story.f.g.c)localObject).hip.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject).BfK);
    ((com.tencent.mm.plugin.story.f.g.c)localObject).sUq.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.f.g.c)localObject).BfL);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(351, (com.tencent.mm.ak.f)localObject);
    localObject = b.elC();
    ((com.tencent.mm.plugin.story.i.g)localObject).remove((k.a)localObject);
    localObject = com.tencent.mm.plugin.story.f.b.b.Bdv;
    com.tencent.mm.plugin.story.f.b.b.emp();
    localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "network()");
    localb.ajj().b(354, (com.tencent.mm.ak.f)localObject);
    localb = com.tencent.mm.kernel.g.ajQ();
    p.g(localb, "network()");
    localb.ajj().b(764, (com.tencent.mm.ak.f)localObject);
    localObject = com.tencent.mm.plugin.story.f.f.a.BeK;
    ae.i(com.tencent.mm.plugin.story.f.f.a.TAG, "destroy: ");
    b.elC().remove((k.a)localObject);
    b.elB().remove((k.a)localObject);
    com.tencent.mm.plugin.story.f.f.a.lWt.clear();
    com.tencent.mm.plugin.story.f.f.a.BeI.dead();
    localObject = com.tencent.mm.plugin.story.f.b.b.Bdv;
    com.tencent.mm.plugin.story.f.b.b.e(com.tencent.mm.plugin.story.f.f.a.BeJ);
    BbA.dead();
    AppMethodBeat.o(118710);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-story_release"})
  public final class a
    extends com.tencent.mm.app.o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(118683);
      paramString = new wc();
      paramString.dLJ.state = 0;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)paramString);
      AppMethodBeat.o(118683);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(118682);
      paramString = new wc();
      paramString.dLJ.state = 1;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)paramString);
      AppMethodBeat.o(118682);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"})
  public static final class b
  {
    public static com.tencent.mm.loader.c.e a(com.tencent.mm.plugin.story.f.c.a parama)
    {
      AppMethodBeat.i(118697);
      p.h(parama, "scene");
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.o(elA()) == null) {
        j.a(elA(), new com.tencent.mm.plugin.story.f.c.e());
      }
      com.tencent.mm.plugin.story.f.c.e locale = j.o(elA());
      if (locale == null) {
        p.gkB();
      }
      p.h(parama, "scene");
      switch (com.tencent.mm.plugin.story.f.c.f.cqt[parama.ordinal()])
      {
      default: 
        parama = new d.m();
        AppMethodBeat.o(118697);
        throw parama;
      case 1: 
      case 2: 
        parama = locale.BdQ;
        AppMethodBeat.o(118697);
        return parama;
      }
      parama = locale.BdP;
      AppMethodBeat.o(118697);
      return parama;
    }
    
    public static aq dJc()
    {
      AppMethodBeat.i(118693);
      Object localObject = com.tencent.mm.kernel.g.ajU();
      p.g(localObject, "MMKernel.getPizzaWorkerThread()");
      localObject = ((ar)localObject).cZF();
      p.g(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
      AppMethodBeat.o(118693);
      return localObject;
    }
    
    public static String dXj()
    {
      AppMethodBeat.i(118700);
      Object localObject = com.tencent.mm.kernel.g.ajR();
      p.g(localObject, "MMKernel.storage()");
      String str = (String)((com.tencent.mm.kernel.e)localObject).ajA().get(2);
      if (str == null) {
        ae.i(j.access$getTAG$cp(), "error getSelfName " + bu.fpN());
      }
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(118700);
      return localObject;
    }
    
    public static boolean dXn()
    {
      AppMethodBeat.i(118699);
      elA();
      if (!j.isValid())
      {
        AppMethodBeat.o(118699);
        return true;
      }
      AppMethodBeat.o(118699);
      return false;
    }
    
    private static j elA()
    {
      AppMethodBeat.i(118685);
      j localj = (j)u.ap(j.class);
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
        ae.i((String)localObject2, localThread.getId() + " " + localj.hashCode());
        if (j.b(localj))
        {
          j.e(localj);
          j.c(localj);
          ae.i(j.access$getTAG$cp(), "resetdb done");
        }
        localObject2 = z.Nhr;
        p.g(localj, "theCore");
        AppMethodBeat.o(118685);
        return localj;
      }
    }
    
    public static k elB()
    {
      AppMethodBeat.i(118687);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.g(elA()) == null) {
        j.a(elA(), new k((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      k localk = j.g(elA());
      if (localk == null) {
        p.gkB();
      }
      AppMethodBeat.o(118687);
      return localk;
    }
    
    public static com.tencent.mm.plugin.story.i.g elC()
    {
      AppMethodBeat.i(118688);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.h(elA()) == null) {
        j.a(elA(), new com.tencent.mm.plugin.story.i.g((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.g localg = j.h(elA());
      if (localg == null) {
        p.gkB();
      }
      AppMethodBeat.o(118688);
      return localg;
    }
    
    public static com.tencent.mm.plugin.story.i.m elD()
    {
      AppMethodBeat.i(118689);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.i(elA()) == null) {
        j.a(elA(), new com.tencent.mm.plugin.story.i.m((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.m localm = j.i(elA());
      if (localm == null) {
        p.gkB();
      }
      AppMethodBeat.o(118689);
      return localm;
    }
    
    public static com.tencent.mm.plugin.story.i.b elE()
    {
      AppMethodBeat.i(118690);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.j(elA()) == null) {
        j.a(elA(), new com.tencent.mm.plugin.story.i.b((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.b localb = j.j(elA());
      if (localb == null) {
        p.gkB();
      }
      AppMethodBeat.o(118690);
      return localb;
    }
    
    public static com.tencent.mm.plugin.story.i.o elF()
    {
      AppMethodBeat.i(118691);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.k(elA()) == null) {
        j.a(elA(), new com.tencent.mm.plugin.story.i.o((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      com.tencent.mm.plugin.story.i.o localo = j.k(elA());
      if (localo == null) {
        p.gkB();
      }
      AppMethodBeat.o(118691);
      return localo;
    }
    
    public static i elG()
    {
      AppMethodBeat.i(118692);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.l(elA()) == null) {
        j.a(elA(), new i((com.tencent.mm.sdk.e.e)getDataDB()));
      }
      i locali = j.l(elA());
      if (locali == null) {
        p.gkB();
      }
      AppMethodBeat.o(118692);
      return locali;
    }
    
    public static com.tencent.mm.plugin.story.f.g.c elH()
    {
      AppMethodBeat.i(118694);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.m(elA()) == null) {
        j.a(elA(), new com.tencent.mm.plugin.story.f.g.c());
      }
      com.tencent.mm.plugin.story.f.g.c localc = j.m(elA());
      if (localc == null) {
        p.gkB();
      }
      AppMethodBeat.o(118694);
      return localc;
    }
    
    public static e elI()
    {
      AppMethodBeat.i(118695);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.n(elA()) == null)
      {
        localObject1 = elA();
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2 = com.tencent.mm.kernel.g.ajR();
        p.g(localObject2, "MMKernel.storage()");
        localStringBuilder = localStringBuilder.append(((com.tencent.mm.kernel.e)localObject2).ajw());
        localObject2 = e.Bbb;
        j.a((j)localObject1, new e(e.ell()));
      }
      Object localObject1 = j.n(elA());
      if (localObject1 == null) {
        p.gkB();
      }
      AppMethodBeat.o(118695);
      return localObject1;
    }
    
    public static com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> elJ()
    {
      AppMethodBeat.i(118696);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.o(elA()) == null) {
        j.a(elA(), new com.tencent.mm.plugin.story.f.c.e());
      }
      Object localObject = j.o(elA());
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((com.tencent.mm.plugin.story.f.c.e)localObject).BdN;
      AppMethodBeat.o(118696);
      return localObject;
    }
    
    public static o.a elK()
    {
      AppMethodBeat.i(118698);
      com.tencent.mm.kernel.g.ajP().aiU();
      if (j.p(elA()) == null) {
        j.a(elA(), new o.a());
      }
      o.a locala = j.p(elA());
      if (locala == null) {
        p.gkB();
      }
      AppMethodBeat.o(118698);
      return locala;
    }
    
    public static g.a elL()
    {
      AppMethodBeat.i(118703);
      g.a locala = (g.a)com.tencent.mm.plugin.story.c.a.g.Bau.att();
      AppMethodBeat.o(118703);
      return locala;
    }
    
    static void elM()
    {
      AppMethodBeat.i(118704);
      j.elx();
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxt, 1);
      ae.d(j.access$getTAG$cp(), "loadStoryCheck %s local_debug %s", new Object[] { Integer.valueOf(i), Boolean.FALSE });
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi("100481");
      p.g(localc, "abTestItem");
      if ((localc.isValid()) && (p.i("1", (String)localc.fsy().get("open")))) {
        i = 1;
      }
      for (;;)
      {
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          j.ss(bool);
          AppMethodBeat.o(118704);
          return;
        }
      }
    }
    
    public static boolean elN()
    {
      AppMethodBeat.i(118705);
      if (!j.elw()) {
        elM();
      }
      boolean bool = j.ely();
      AppMethodBeat.o(118705);
      return bool;
    }
    
    public static long elO()
    {
      AppMethodBeat.i(118706);
      if (j.elz() == -1L)
      {
        com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.ajR();
        p.g(locale, "MMKernel.storage()");
        j.Be(locale.ajA().a(am.a.Jah, 0L));
      }
      long l = j.elz();
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
      com.tencent.mm.storagebase.h localh = j.f(elA());
      if (localh == null) {
        p.gkB();
      }
      AppMethodBeat.o(118686);
      return localh;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/model/StoryCore$Companion$exptChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<fm>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/DynamicConfigUpdatedEvent;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "callback", "", "event", "plugin-story_release"})
  public final class d
    extends com.tencent.mm.sdk.b.c<dc>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.story.f;

import android.graphics.Point;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.story.PluginStory.b;
import com.tencent.mm.plugin.story.PluginStory.c;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.f.f.a.i;
import com.tencent.mm.plugin.story.i.o;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storagebase.h.b;
import d.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "appForegroundListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "resetDb", "updateConfigs", "AppForegroundListener", "Companion", "ConfigChangedListener", "plugin-story_release"})
public final class j
  implements aw
{
  private static final String TAG = "MicroMsg.StoryCore";
  private static final Point gYt;
  private static String xTP;
  private static final int xTZ = 103;
  private static final int zsc = 150;
  private static final com.tencent.mm.sdk.b.c<fi> zsd;
  private static boolean zse;
  private static boolean zsf;
  private static long zsg;
  public static final b zsh;
  private com.tencent.mm.storagebase.h ghG;
  private final ao handler;
  private final byte[] lock;
  private boolean qVx;
  private boolean xTN;
  private HashMap<Integer, h.b> zrM;
  private com.tencent.mm.plugin.story.i.k zrN;
  private com.tencent.mm.plugin.story.i.g zrO;
  private com.tencent.mm.plugin.story.i.m zrP;
  private com.tencent.mm.plugin.story.i.b zrQ;
  private o zrR;
  private com.tencent.mm.plugin.story.i.i zrS;
  private com.tencent.mm.plugin.story.f.g.c zrT;
  private e zrU;
  private com.tencent.mm.plugin.story.f.c.e zrV;
  private o.a zrW;
  private PluginStory.c zrX;
  private PluginStory.b zrY;
  private d zrZ;
  private a zsa;
  private ao zsb;
  
  static
  {
    AppMethodBeat.i(118713);
    zsh = new b((byte)0);
    TAG = "MicroMsg.StoryCore";
    xTP = "";
    gYt = new Point();
    xTZ = 103;
    zsc = 150;
    zsd = (com.tencent.mm.sdk.b.c)new c();
    zsg = -1L;
    AppMethodBeat.o(118713);
  }
  
  public j()
  {
    AppMethodBeat.i(118712);
    this.lock = new byte[0];
    this.zrM = new HashMap();
    this.zrX = new PluginStory.c();
    this.zrY = new PluginStory.b();
    this.zrZ = new d();
    this.zsa = new a();
    this.handler = new ao(Looper.getMainLooper());
    this.zsb = new ao("SnsCore_task_handler");
    ((Map)this.zrM).put(Integer.valueOf("MMStoryInfo".hashCode()), j.1.zsi);
    ((Map)this.zrM).put(Integer.valueOf("StoryExtItem".hashCode()), 2.zsj);
    ((Map)this.zrM).put(Integer.valueOf("StoryCommentSync".hashCode()), j.3.zsk);
    ((Map)this.zrM).put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), 4.zsl);
    ((Map)this.zrM).put(Integer.valueOf("StoryEditorInfo".hashCode()), j.5.zsm);
    ((Map)this.zrM).put(Integer.valueOf("StoryRoomInfo".hashCode()), j.6.zsn);
    ((Map)this.zrM).put(Integer.valueOf("MMStoryHistoryItem".hashCode()), 7.zso);
    AppMethodBeat.o(118712);
  }
  
  public static boolean isValid()
  {
    AppMethodBeat.i(118711);
    boolean bool = com.tencent.mm.kernel.g.agP().afY();
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
    if (this.xTN)
    {
      AppMethodBeat.o(118709);
      return;
    }
    this.xTN = true;
    this.qVx = true;
    Object localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    d.g.b.k.g(localObject1, "plugin(IPluginStory::class.java)");
    com.tencent.mm.vfs.i.aSh(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryPath());
    localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    d.g.b.k.g(localObject1, "plugin(IPluginStory::class.java)");
    com.tencent.mm.vfs.i.aSh(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryTmpPath());
    com.tencent.mm.sdk.b.a.GpY.c((com.tencent.mm.sdk.b.c)this.zrX);
    com.tencent.mm.sdk.b.a.GpY.c((com.tencent.mm.sdk.b.c)this.zrY);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new h(), new String[] { "//story" });
    localObject1 = b.dVK();
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).rMY.a((f)((com.tencent.mm.plugin.story.f.g.c)localObject1).zwn);
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).rMZ.a((f)((com.tencent.mm.plugin.story.f.g.c)localObject1).zwo);
    Object localObject2 = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localObject2, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject2).agi().a(351, (com.tencent.mm.ak.g)localObject1);
    localObject1 = b.dVF();
    ((com.tencent.mm.plugin.story.i.g)localObject1).add((k.a)localObject1);
    localObject1 = com.tencent.mm.plugin.story.f.b.b.ztY;
    if ((com.tencent.mm.vfs.i.eA(com.tencent.mm.plugin.story.f.b.b.ztP)) && (!com.tencent.mm.vfs.i.eA(com.tencent.mm.plugin.story.f.b.b.xVV))) {
      com.tencent.mm.vfs.i.ma(com.tencent.mm.plugin.story.f.b.b.ztP, com.tencent.mm.plugin.story.f.b.b.xVV);
    }
    localObject2 = com.tencent.mm.vfs.i.aU(com.tencent.mm.plugin.story.f.b.b.xVV, 0, -1);
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
        com.tencent.mm.plugin.story.f.b.b.ztR.parseFrom((byte[])localObject2);
      }
      localObject2 = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).agi().a(354, (com.tencent.mm.ak.g)localObject1);
      localObject2 = com.tencent.mm.kernel.g.agQ();
      d.g.b.k.g(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).agi().a(764, (com.tencent.mm.ak.g)localObject1);
      com.tencent.mm.plugin.story.f.b.b.dIP();
      b.dVP();
      com.tencent.mm.plugin.story.f.f.a.zvn.init();
      zsd.alive();
      localObject1 = l.zsu;
      l.reset();
      localObject1 = l.zsu;
      com.tencent.mm.vfs.i.aSh(l.dVT() + "coming/");
      com.tencent.mm.vfs.i.aSh(l.dVT() + "pic/");
      com.tencent.mm.vfs.i.aSh(l.dVT() + "video/");
      com.tencent.mm.plugin.story.api.p.zqo = (p.b)com.tencent.mm.plugin.story.f.d.e.zux;
      com.tencent.mm.sdk.b.a.GpY.c((com.tencent.mm.sdk.b.c)this.zrZ);
      this.zsa.alive();
      AppMethodBeat.o(118709);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(118710);
    this.zsa.dead();
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.zrX);
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.zrY);
    com.tencent.mm.sdk.b.a.GpY.d((com.tencent.mm.sdk.b.c)this.zrZ);
    com.tencent.mm.pluginsdk.cmd.b.Q(new String[] { "//story" });
    Object localObject = b.dVK();
    ((com.tencent.mm.plugin.story.f.g.c)localObject).rMY.b((f)((com.tencent.mm.plugin.story.f.g.c)localObject).zwn);
    ((com.tencent.mm.plugin.story.f.g.c)localObject).rMZ.b((f)((com.tencent.mm.plugin.story.f.g.c)localObject).zwo);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(351, (com.tencent.mm.ak.g)localObject);
    localObject = b.dVF();
    ((com.tencent.mm.plugin.story.i.g)localObject).remove((k.a)localObject);
    localObject = com.tencent.mm.plugin.story.f.b.b.ztY;
    com.tencent.mm.plugin.story.f.b.b.dWs();
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "network()");
    localb.agi().b(354, (com.tencent.mm.ak.g)localObject);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "network()");
    localb.agi().b(764, (com.tencent.mm.ak.g)localObject);
    localObject = com.tencent.mm.plugin.story.f.f.a.zvn;
    ac.i(com.tencent.mm.plugin.story.f.f.a.TAG, "destroy: ");
    b.dVF().remove((k.a)localObject);
    b.dVE().remove((k.a)localObject);
    com.tencent.mm.plugin.story.f.f.a.lsJ.clear();
    com.tencent.mm.plugin.story.f.f.a.zvl.dead();
    localObject = com.tencent.mm.plugin.story.f.b.b.ztY;
    com.tencent.mm.plugin.story.f.b.b.e(com.tencent.mm.plugin.story.f.f.a.zvm);
    zsd.dead();
    AppMethodBeat.o(118710);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-story_release"})
  public final class a
    extends n.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(118683);
      paramString = new vf();
      paramString.dyh.state = 0;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)paramString);
      AppMethodBeat.o(118683);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(118682);
      paramString = new vf();
      paramString.dyh.state = 1;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)paramString);
      AppMethodBeat.o(118682);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"})
  public static final class b
  {
    public static com.tencent.mm.loader.c.e a(com.tencent.mm.plugin.story.f.c.a parama)
    {
      AppMethodBeat.i(118697);
      d.g.b.k.h(parama, "scene");
      com.tencent.mm.kernel.g.agP().afT();
      if (j.o(dVD()) == null) {
        j.a(dVD(), new com.tencent.mm.plugin.story.f.c.e());
      }
      com.tencent.mm.plugin.story.f.c.e locale = j.o(dVD());
      if (locale == null) {
        d.g.b.k.fOy();
      }
      d.g.b.k.h(parama, "scene");
      switch (com.tencent.mm.plugin.story.f.c.f.cfA[parama.ordinal()])
      {
      default: 
        parama = new d.m();
        AppMethodBeat.o(118697);
        throw parama;
      case 1: 
      case 2: 
        parama = locale.zut;
        AppMethodBeat.o(118697);
        return parama;
      }
      parama = locale.zus;
      AppMethodBeat.o(118697);
      return parama;
    }
    
    private static com.tencent.mm.storagebase.h agw()
    {
      AppMethodBeat.i(118686);
      com.tencent.mm.storagebase.h localh = j.f(dVD());
      if (localh == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118686);
      return localh;
    }
    
    public static boolean dHA()
    {
      AppMethodBeat.i(118699);
      dVD();
      if (!j.isValid())
      {
        AppMethodBeat.o(118699);
        return true;
      }
      AppMethodBeat.o(118699);
      return false;
    }
    
    public static String dHx()
    {
      AppMethodBeat.i(118700);
      Object localObject = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      String str = (String)((com.tencent.mm.kernel.e)localObject).agA().get(2);
      if (str == null) {
        ac.i(j.access$getTAG$cp(), "error getSelfName " + bs.eWi());
      }
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(118700);
      return localObject;
    }
    
    private static j dVD()
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
        d.g.b.k.g(localThread, "Thread.currentThread()");
        localStringBuilder = localStringBuilder.append(localThread.getName()).append(" ");
        localThread = Thread.currentThread();
        d.g.b.k.g(localThread, "Thread.currentThread()");
        ac.i((String)localObject2, localThread.getId() + " " + localj.hashCode());
        if (j.b(localj))
        {
          j.e(localj);
          j.c(localj);
          ac.i(j.access$getTAG$cp(), "resetdb done");
        }
        localObject2 = y.KTp;
        d.g.b.k.g(localj, "theCore");
        AppMethodBeat.o(118685);
        return localj;
      }
    }
    
    public static com.tencent.mm.plugin.story.i.k dVE()
    {
      AppMethodBeat.i(118687);
      com.tencent.mm.kernel.g.agP().afT();
      if (j.g(dVD()) == null) {
        j.a(dVD(), new com.tencent.mm.plugin.story.i.k((com.tencent.mm.sdk.e.e)agw()));
      }
      com.tencent.mm.plugin.story.i.k localk = j.g(dVD());
      if (localk == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118687);
      return localk;
    }
    
    public static com.tencent.mm.plugin.story.i.g dVF()
    {
      AppMethodBeat.i(118688);
      com.tencent.mm.kernel.g.agP().afT();
      if (j.h(dVD()) == null) {
        j.a(dVD(), new com.tencent.mm.plugin.story.i.g((com.tencent.mm.sdk.e.e)agw()));
      }
      com.tencent.mm.plugin.story.i.g localg = j.h(dVD());
      if (localg == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118688);
      return localg;
    }
    
    public static com.tencent.mm.plugin.story.i.m dVG()
    {
      AppMethodBeat.i(118689);
      com.tencent.mm.kernel.g.agP().afT();
      if (j.i(dVD()) == null) {
        j.a(dVD(), new com.tencent.mm.plugin.story.i.m((com.tencent.mm.sdk.e.e)agw()));
      }
      com.tencent.mm.plugin.story.i.m localm = j.i(dVD());
      if (localm == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118689);
      return localm;
    }
    
    public static com.tencent.mm.plugin.story.i.b dVH()
    {
      AppMethodBeat.i(118690);
      com.tencent.mm.kernel.g.agP().afT();
      if (j.j(dVD()) == null) {
        j.a(dVD(), new com.tencent.mm.plugin.story.i.b((com.tencent.mm.sdk.e.e)agw()));
      }
      com.tencent.mm.plugin.story.i.b localb = j.j(dVD());
      if (localb == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118690);
      return localb;
    }
    
    public static o dVI()
    {
      AppMethodBeat.i(118691);
      com.tencent.mm.kernel.g.agP().afT();
      if (j.k(dVD()) == null) {
        j.a(dVD(), new o((com.tencent.mm.sdk.e.e)agw()));
      }
      o localo = j.k(dVD());
      if (localo == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118691);
      return localo;
    }
    
    public static com.tencent.mm.plugin.story.i.i dVJ()
    {
      AppMethodBeat.i(118692);
      com.tencent.mm.kernel.g.agP().afT();
      if (j.l(dVD()) == null) {
        j.a(dVD(), new com.tencent.mm.plugin.story.i.i((com.tencent.mm.sdk.e.e)agw()));
      }
      com.tencent.mm.plugin.story.i.i locali = j.l(dVD());
      if (locali == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118692);
      return locali;
    }
    
    public static com.tencent.mm.plugin.story.f.g.c dVK()
    {
      AppMethodBeat.i(118694);
      com.tencent.mm.kernel.g.agP().afT();
      if (j.m(dVD()) == null) {
        j.a(dVD(), new com.tencent.mm.plugin.story.f.g.c());
      }
      com.tencent.mm.plugin.story.f.g.c localc = j.m(dVD());
      if (localc == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118694);
      return localc;
    }
    
    public static e dVL()
    {
      AppMethodBeat.i(118695);
      com.tencent.mm.kernel.g.agP().afT();
      if (j.n(dVD()) == null)
      {
        localObject1 = dVD();
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2 = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(localObject2, "MMKernel.storage()");
        localStringBuilder = localStringBuilder.append(((com.tencent.mm.kernel.e)localObject2).agv());
        localObject2 = e.zrE;
        j.a((j)localObject1, new e(e.dVo()));
      }
      Object localObject1 = j.n(dVD());
      if (localObject1 == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118695);
      return localObject1;
    }
    
    public static com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> dVM()
    {
      AppMethodBeat.i(118696);
      com.tencent.mm.kernel.g.agP().afT();
      if (j.o(dVD()) == null) {
        j.a(dVD(), new com.tencent.mm.plugin.story.f.c.e());
      }
      Object localObject = j.o(dVD());
      if (localObject == null) {
        d.g.b.k.fOy();
      }
      localObject = ((com.tencent.mm.plugin.story.f.c.e)localObject).zuq;
      AppMethodBeat.o(118696);
      return localObject;
    }
    
    public static o.a dVN()
    {
      AppMethodBeat.i(118698);
      com.tencent.mm.kernel.g.agP().afT();
      if (j.p(dVD()) == null) {
        j.a(dVD(), new o.a());
      }
      o.a locala = j.p(dVD());
      if (locala == null) {
        d.g.b.k.fOy();
      }
      AppMethodBeat.o(118698);
      return locala;
    }
    
    public static g.a dVO()
    {
      AppMethodBeat.i(118703);
      g.a locala = (g.a)com.tencent.mm.plugin.story.c.a.g.zqX.aqp();
      AppMethodBeat.o(118703);
      return locala;
    }
    
    static void dVP()
    {
      AppMethodBeat.i(118704);
      j.dVA();
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMJ, 1);
      ac.d(j.access$getTAG$cp(), "loadStoryCheck %s local_debug %s", new Object[] { Integer.valueOf(i), Boolean.FALSE });
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aAp().tJ("100481");
      d.g.b.k.g(localc, "abTestItem");
      if ((localc.isValid()) && (d.g.b.k.g("1", (String)localc.eYV().get("open")))) {
        i = 1;
      }
      for (;;)
      {
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          j.rF(bool);
          AppMethodBeat.o(118704);
          return;
        }
      }
    }
    
    public static boolean dVQ()
    {
      AppMethodBeat.i(118705);
      if (!j.dVz()) {
        dVP();
      }
      boolean bool = j.dVB();
      AppMethodBeat.o(118705);
      return bool;
    }
    
    public static long dVR()
    {
      AppMethodBeat.i(118706);
      if (j.dVC() == -1L)
      {
        com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(locale, "MMKernel.storage()");
        j.yi(locale.agA().a(ah.a.GTc, 0L));
      }
      long l = j.dVC();
      AppMethodBeat.o(118706);
      return l;
    }
    
    public static ao dvq()
    {
      AppMethodBeat.i(118693);
      Object localObject = com.tencent.mm.kernel.g.agU();
      d.g.b.k.g(localObject, "MMKernel.getPizzaWorkerThread()");
      localObject = ((ap)localObject).cOC();
      d.g.b.k.g(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
      AppMethodBeat.o(118693);
      return localObject;
    }
    
    public static String getAccStoryCachePath()
    {
      AppMethodBeat.i(118702);
      Object localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
      d.g.b.k.g(localObject, "plugin<IPluginStory>(IPluginStory::class.java)");
      localObject = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryCachePath();
      d.g.b.k.g(localObject, "plugin<IPluginStory>(IPl…s.java).accStoryCachePath");
      AppMethodBeat.o(118702);
      return localObject;
    }
    
    public static String getAccStoryPath()
    {
      AppMethodBeat.i(118701);
      Object localObject = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
      d.g.b.k.g(localObject, "plugin<IPluginStory>(IPluginStory::class.java)");
      localObject = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath();
      d.g.b.k.g(localObject, "plugin<IPluginStory>(IPl…:class.java).accStoryPath");
      AppMethodBeat.o(118701);
      return localObject;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/model/StoryCore$Companion$exptChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<fi>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/DynamicConfigUpdatedEvent;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "callback", "", "event", "plugin-story_release"})
  public final class d
    extends com.tencent.mm.sdk.b.c<cy>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.j
 * JD-Core Version:    0.7.0.1
 */
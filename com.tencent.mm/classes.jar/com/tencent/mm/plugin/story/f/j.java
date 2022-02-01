package com.tencent.mm.plugin.story.f;

import android.graphics.Point;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.uv;
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
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storagebase.h.b;
import d.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "appForegroundListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "resetDb", "updateConfigs", "AppForegroundListener", "Companion", "ConfigChangedListener", "plugin-story_release"})
public final class j
  implements aw
{
  private static final String TAG = "MicroMsg.StoryCore";
  private static final Point gxV;
  private static final int wHE = 103;
  private static String wHu;
  private static final int yfc = 150;
  private static final com.tencent.mm.sdk.b.c<fh> yfd;
  private static boolean yfe;
  private static boolean yff;
  private static long yfg;
  public static final b yfh;
  private com.tencent.mm.storagebase.h gda;
  private final ap handler;
  private final byte[] lock;
  private boolean qmV;
  private boolean wHs;
  private HashMap<Integer, h.b> yeM;
  private com.tencent.mm.plugin.story.i.k yeN;
  private com.tencent.mm.plugin.story.i.g yeO;
  private com.tencent.mm.plugin.story.i.m yeP;
  private com.tencent.mm.plugin.story.i.b yeQ;
  private o yeR;
  private com.tencent.mm.plugin.story.i.i yeS;
  private com.tencent.mm.plugin.story.f.g.c yeT;
  private e yeU;
  private com.tencent.mm.plugin.story.f.c.e yeV;
  private o.a yeW;
  private PluginStory.c yeX;
  private PluginStory.b yeY;
  private d yeZ;
  private a yfa;
  private ap yfb;
  
  static
  {
    AppMethodBeat.i(118713);
    yfh = new b((byte)0);
    TAG = "MicroMsg.StoryCore";
    wHu = "";
    gxV = new Point();
    wHE = 103;
    yfc = 150;
    yfd = (com.tencent.mm.sdk.b.c)new c();
    yfg = -1L;
    AppMethodBeat.o(118713);
  }
  
  public j()
  {
    AppMethodBeat.i(118712);
    this.lock = new byte[0];
    this.yeM = new HashMap();
    this.yeX = new PluginStory.c();
    this.yeY = new PluginStory.b();
    this.yeZ = new d();
    this.yfa = new a();
    this.handler = new ap(Looper.getMainLooper());
    this.yfb = new ap("SnsCore_task_handler");
    ((Map)this.yeM).put(Integer.valueOf("MMStoryInfo".hashCode()), 1.yfi);
    ((Map)this.yeM).put(Integer.valueOf("StoryExtItem".hashCode()), 2.yfj);
    ((Map)this.yeM).put(Integer.valueOf("StoryCommentSync".hashCode()), 3.yfk);
    ((Map)this.yeM).put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), 4.yfl);
    ((Map)this.yeM).put(Integer.valueOf("StoryEditorInfo".hashCode()), j.5.yfm);
    ((Map)this.yeM).put(Integer.valueOf("StoryRoomInfo".hashCode()), j.6.yfn);
    ((Map)this.yeM).put(Integer.valueOf("MMStoryHistoryItem".hashCode()), 7.yfo);
    AppMethodBeat.o(118712);
  }
  
  public static boolean isValid()
  {
    AppMethodBeat.i(118711);
    boolean bool = com.tencent.mm.kernel.g.afz().aeI();
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
    if (this.wHs)
    {
      AppMethodBeat.o(118709);
      return;
    }
    this.wHs = true;
    this.qmV = true;
    Object localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    d.g.b.k.g(localObject1, "plugin(IPluginStory::class.java)");
    com.tencent.mm.vfs.i.aMF(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryPath());
    localObject1 = com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    d.g.b.k.g(localObject1, "plugin(IPluginStory::class.java)");
    com.tencent.mm.vfs.i.aMF(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryTmpPath());
    com.tencent.mm.sdk.b.a.ESL.c((com.tencent.mm.sdk.b.c)this.yeX);
    com.tencent.mm.sdk.b.a.ESL.c((com.tencent.mm.sdk.b.c)this.yeY);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new h(), new String[] { "//story" });
    localObject1 = b.dHj();
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).qQX.a((f)((com.tencent.mm.plugin.story.f.g.c)localObject1).yjo);
    ((com.tencent.mm.plugin.story.f.g.c)localObject1).qQY.a((f)((com.tencent.mm.plugin.story.f.g.c)localObject1).yjp);
    Object localObject2 = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localObject2, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject2).aeS().a(351, (com.tencent.mm.al.g)localObject1);
    localObject1 = b.dHe();
    ((com.tencent.mm.plugin.story.i.g)localObject1).add((k.a)localObject1);
    localObject1 = com.tencent.mm.plugin.story.f.b.b.ygY;
    if ((com.tencent.mm.vfs.i.eK(com.tencent.mm.plugin.story.f.b.b.ygP)) && (!com.tencent.mm.vfs.i.eK(com.tencent.mm.plugin.story.f.b.b.wJq))) {
      com.tencent.mm.vfs.i.lD(com.tencent.mm.plugin.story.f.b.b.ygP, com.tencent.mm.plugin.story.f.b.b.wJq);
    }
    localObject2 = com.tencent.mm.vfs.i.aR(com.tencent.mm.plugin.story.f.b.b.wJq, 0, -1);
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
        com.tencent.mm.plugin.story.f.b.b.ygR.parseFrom((byte[])localObject2);
      }
      localObject2 = com.tencent.mm.kernel.g.afA();
      d.g.b.k.g(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).aeS().a(354, (com.tencent.mm.al.g)localObject1);
      localObject2 = com.tencent.mm.kernel.g.afA();
      d.g.b.k.g(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).aeS().a(764, (com.tencent.mm.al.g)localObject1);
      com.tencent.mm.plugin.story.f.b.b.dup();
      b.dHo();
      com.tencent.mm.plugin.story.f.f.a.yio.init();
      yfd.alive();
      localObject1 = l.yfu;
      l.reset();
      localObject1 = l.yfu;
      com.tencent.mm.vfs.i.aMF(l.dHs() + "coming/");
      com.tencent.mm.vfs.i.aMF(l.dHs() + "pic/");
      com.tencent.mm.vfs.i.aMF(l.dHs() + "video/");
      com.tencent.mm.plugin.story.api.p.ydo = (p.b)com.tencent.mm.plugin.story.f.d.e.yhx;
      com.tencent.mm.sdk.b.a.ESL.c((com.tencent.mm.sdk.b.c)this.yeZ);
      this.yfa.alive();
      AppMethodBeat.o(118709);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(118710);
    this.yfa.dead();
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.yeX);
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.yeY);
    com.tencent.mm.sdk.b.a.ESL.d((com.tencent.mm.sdk.b.c)this.yeZ);
    com.tencent.mm.pluginsdk.cmd.b.Q(new String[] { "//story" });
    Object localObject = b.dHj();
    ((com.tencent.mm.plugin.story.f.g.c)localObject).qQX.b((f)((com.tencent.mm.plugin.story.f.g.c)localObject).yjo);
    ((com.tencent.mm.plugin.story.f.g.c)localObject).qQY.b((f)((com.tencent.mm.plugin.story.f.g.c)localObject).yjp);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(351, (com.tencent.mm.al.g)localObject);
    localObject = b.dHe();
    ((com.tencent.mm.plugin.story.i.g)localObject).remove((k.a)localObject);
    localObject = com.tencent.mm.plugin.story.f.b.b.ygY;
    com.tencent.mm.plugin.story.f.b.b.dHR();
    localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "network()");
    localb.aeS().b(354, (com.tencent.mm.al.g)localObject);
    localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "network()");
    localb.aeS().b(764, (com.tencent.mm.al.g)localObject);
    localObject = com.tencent.mm.plugin.story.f.f.a.yio;
    ad.i(com.tencent.mm.plugin.story.f.f.a.TAG, "destroy: ");
    b.dHe().remove((k.a)localObject);
    b.dHd().remove((k.a)localObject);
    com.tencent.mm.plugin.story.f.f.a.kRj.clear();
    com.tencent.mm.plugin.story.f.f.a.yim.dead();
    localObject = com.tencent.mm.plugin.story.f.b.b.ygY;
    com.tencent.mm.plugin.story.f.b.b.d(com.tencent.mm.plugin.story.f.f.a.yin);
    yfd.dead();
    AppMethodBeat.o(118710);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-story_release"})
  public final class a
    extends n.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(118683);
      paramString = new uv();
      paramString.dAv.state = 0;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)paramString);
      AppMethodBeat.o(118683);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(118682);
      paramString = new uv();
      paramString.dAv.state = 1;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)paramString);
      AppMethodBeat.o(118682);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"})
  public static final class b
  {
    public static com.tencent.mm.loader.c.e a(com.tencent.mm.plugin.story.f.c.a parama)
    {
      AppMethodBeat.i(118697);
      d.g.b.k.h(parama, "scene");
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.o(dHc()) == null) {
        j.a(dHc(), new com.tencent.mm.plugin.story.f.c.e());
      }
      com.tencent.mm.plugin.story.f.c.e locale = j.o(dHc());
      if (locale == null) {
        d.g.b.k.fvU();
      }
      d.g.b.k.h(parama, "scene");
      switch (com.tencent.mm.plugin.story.f.c.f.ciE[parama.ordinal()])
      {
      default: 
        parama = new d.m();
        AppMethodBeat.o(118697);
        throw parama;
      case 1: 
      case 2: 
        parama = locale.yht;
        AppMethodBeat.o(118697);
        return parama;
      }
      parama = locale.yhs;
      AppMethodBeat.o(118697);
      return parama;
    }
    
    private static com.tencent.mm.storagebase.h afg()
    {
      AppMethodBeat.i(118686);
      com.tencent.mm.storagebase.h localh = j.f(dHc());
      if (localh == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118686);
      return localh;
    }
    
    private static j dHc()
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
        ad.i((String)localObject2, localThread.getId() + " " + localj.hashCode());
        if (j.b(localj))
        {
          j.e(localj);
          j.c(localj);
          ad.i(j.access$getTAG$cp(), "resetdb done");
        }
        localObject2 = y.JfV;
        d.g.b.k.g(localj, "theCore");
        AppMethodBeat.o(118685);
        return localj;
      }
    }
    
    public static com.tencent.mm.plugin.story.i.k dHd()
    {
      AppMethodBeat.i(118687);
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.g(dHc()) == null) {
        j.a(dHc(), new com.tencent.mm.plugin.story.i.k((com.tencent.mm.sdk.e.e)afg()));
      }
      com.tencent.mm.plugin.story.i.k localk = j.g(dHc());
      if (localk == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118687);
      return localk;
    }
    
    public static com.tencent.mm.plugin.story.i.g dHe()
    {
      AppMethodBeat.i(118688);
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.h(dHc()) == null) {
        j.a(dHc(), new com.tencent.mm.plugin.story.i.g((com.tencent.mm.sdk.e.e)afg()));
      }
      com.tencent.mm.plugin.story.i.g localg = j.h(dHc());
      if (localg == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118688);
      return localg;
    }
    
    public static com.tencent.mm.plugin.story.i.m dHf()
    {
      AppMethodBeat.i(118689);
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.i(dHc()) == null) {
        j.a(dHc(), new com.tencent.mm.plugin.story.i.m((com.tencent.mm.sdk.e.e)afg()));
      }
      com.tencent.mm.plugin.story.i.m localm = j.i(dHc());
      if (localm == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118689);
      return localm;
    }
    
    public static com.tencent.mm.plugin.story.i.b dHg()
    {
      AppMethodBeat.i(118690);
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.j(dHc()) == null) {
        j.a(dHc(), new com.tencent.mm.plugin.story.i.b((com.tencent.mm.sdk.e.e)afg()));
      }
      com.tencent.mm.plugin.story.i.b localb = j.j(dHc());
      if (localb == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118690);
      return localb;
    }
    
    public static o dHh()
    {
      AppMethodBeat.i(118691);
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.k(dHc()) == null) {
        j.a(dHc(), new o((com.tencent.mm.sdk.e.e)afg()));
      }
      o localo = j.k(dHc());
      if (localo == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118691);
      return localo;
    }
    
    public static com.tencent.mm.plugin.story.i.i dHi()
    {
      AppMethodBeat.i(118692);
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.l(dHc()) == null) {
        j.a(dHc(), new com.tencent.mm.plugin.story.i.i((com.tencent.mm.sdk.e.e)afg()));
      }
      com.tencent.mm.plugin.story.i.i locali = j.l(dHc());
      if (locali == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118692);
      return locali;
    }
    
    public static com.tencent.mm.plugin.story.f.g.c dHj()
    {
      AppMethodBeat.i(118694);
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.m(dHc()) == null) {
        j.a(dHc(), new com.tencent.mm.plugin.story.f.g.c());
      }
      com.tencent.mm.plugin.story.f.g.c localc = j.m(dHc());
      if (localc == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118694);
      return localc;
    }
    
    public static e dHk()
    {
      AppMethodBeat.i(118695);
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.n(dHc()) == null)
      {
        localObject1 = dHc();
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject2 = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(localObject2, "MMKernel.storage()");
        localStringBuilder = localStringBuilder.append(((com.tencent.mm.kernel.e)localObject2).aff());
        localObject2 = e.yeE;
        j.a((j)localObject1, new e(e.dGN()));
      }
      Object localObject1 = j.n(dHc());
      if (localObject1 == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118695);
      return localObject1;
    }
    
    public static com.tencent.mm.loader.d<com.tencent.mm.plugin.story.f.c.d> dHl()
    {
      AppMethodBeat.i(118696);
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.o(dHc()) == null) {
        j.a(dHc(), new com.tencent.mm.plugin.story.f.c.e());
      }
      Object localObject = j.o(dHc());
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = ((com.tencent.mm.plugin.story.f.c.e)localObject).yhq;
      AppMethodBeat.o(118696);
      return localObject;
    }
    
    public static o.a dHm()
    {
      AppMethodBeat.i(118698);
      com.tencent.mm.kernel.g.afz().aeD();
      if (j.p(dHc()) == null) {
        j.a(dHc(), new o.a());
      }
      o.a locala = j.p(dHc());
      if (locala == null) {
        d.g.b.k.fvU();
      }
      AppMethodBeat.o(118698);
      return locala;
    }
    
    public static g.a dHn()
    {
      AppMethodBeat.i(118703);
      g.a locala = (g.a)com.tencent.mm.plugin.story.c.a.g.ydX.ajp();
      AppMethodBeat.o(118703);
      return locala;
    }
    
    static void dHo()
    {
      AppMethodBeat.i(118704);
      j.dGZ();
      int i = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjs, 1);
      ad.d(j.access$getTAG$cp(), "loadStoryCheck %s local_debug %s", new Object[] { Integer.valueOf(i), Boolean.FALSE });
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aty().qu("100481");
      d.g.b.k.g(localc, "abTestItem");
      if ((localc.isValid()) && (d.g.b.k.g("1", (String)localc.eJy().get("open")))) {
        i = 1;
      }
      for (;;)
      {
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          j.qH(bool);
          AppMethodBeat.o(118704);
          return;
        }
      }
    }
    
    public static boolean dHp()
    {
      AppMethodBeat.i(118705);
      if (!j.dGY()) {
        dHo();
      }
      boolean bool = j.dHa();
      AppMethodBeat.o(118705);
      return bool;
    }
    
    public static long dHq()
    {
      AppMethodBeat.i(118706);
      if (j.dHb() == -1L)
      {
        com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(locale, "MMKernel.storage()");
        j.tF(locale.afk().a(ae.a.Fvi, 0L));
      }
      long l = j.dHb();
      AppMethodBeat.o(118706);
      return l;
    }
    
    public static ap dhI()
    {
      AppMethodBeat.i(118693);
      Object localObject = com.tencent.mm.kernel.g.afE();
      d.g.b.k.g(localObject, "MMKernel.getPizzaWorkerThread()");
      localObject = ((aq)localObject).cBt();
      d.g.b.k.g(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
      AppMethodBeat.o(118693);
      return localObject;
    }
    
    public static String dta()
    {
      AppMethodBeat.i(118700);
      Object localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      String str = (String)((com.tencent.mm.kernel.e)localObject).afk().get(2);
      if (str == null) {
        ad.i(j.access$getTAG$cp(), "error getSelfName " + bt.eGN());
      }
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(118700);
      return localObject;
    }
    
    public static boolean dtd()
    {
      AppMethodBeat.i(118699);
      dHc();
      if (!j.isValid())
      {
        AppMethodBeat.o(118699);
        return true;
      }
      AppMethodBeat.o(118699);
      return false;
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/model/StoryCore$Companion$exptChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "callback", "", "event", "plugin-story_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<fh>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/DynamicConfigUpdatedEvent;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "callback", "", "event", "plugin-story_release"})
  public final class d
    extends com.tencent.mm.sdk.b.c<cx>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.j
 * JD-Core Version:    0.7.0.1
 */
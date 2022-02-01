package com.tencent.mm.plugin.story.model;

import android.graphics.Point;
import android.os.Looper;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.story.PluginStory.StoryCleanListener;
import com.tencent.mm.plugin.story.PluginStory.StorySynclistener;
import com.tencent.mm.plugin.story.api.p.b;
import com.tencent.mm.plugin.story.c.a.g.a;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.m;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.sync.ContactSyncFetcher.snsPermissionNotifyListener.1;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.protocal.protobuf.fid;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "appForegroundListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "removeDirtyDB", "resetDb", "updateConfigs", "AppForegroundListener", "Companion", "ConfigChangedListener", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryCore
  implements be
{
  private static String Qvd;
  private static final int Qvn;
  public static final b SjP;
  private static final int Skg;
  private static final IListener<gh> Skh;
  private static boolean Ski;
  private static boolean Skj;
  private static long Skk;
  private static final String TAG;
  private static final Point nGU;
  private boolean Arp;
  private boolean Qvb;
  private HashMap<Integer, h.b> SjQ;
  private com.tencent.mm.plugin.story.h.k SjR;
  private com.tencent.mm.plugin.story.h.g SjS;
  private m SjT;
  private com.tencent.mm.plugin.story.h.b SjU;
  private o SjV;
  private i SjW;
  private com.tencent.mm.plugin.story.model.f.c SjX;
  private e SjY;
  private com.tencent.mm.plugin.story.model.c.e SjZ;
  private n.a Ska;
  private PluginStory.StorySynclistener Skb;
  private PluginStory.StoryCleanListener Skc;
  private StoryCore.ConfigChangedListener Skd;
  private StoryCore.a Ske;
  private MMHandler Skf;
  private final MMHandler handler;
  private final byte[] lock;
  private com.tencent.mm.storagebase.h mCN;
  
  static
  {
    AppMethodBeat.i(118713);
    SjP = new b((byte)0);
    TAG = "MicroMsg.StoryCore";
    Qvd = "";
    nGU = new Point();
    Qvn = 103;
    Skg = 150;
    Skh = (IListener)new IListener(com.tencent.mm.app.f.hfK) {};
    Skk = -1L;
    AppMethodBeat.o(118713);
  }
  
  public StoryCore()
  {
    AppMethodBeat.i(118712);
    this.lock = new byte[0];
    this.SjQ = new HashMap();
    this.Skb = new PluginStory.StorySynclistener();
    this.Skc = new PluginStory.StoryCleanListener();
    this.Skd = new StoryCore.ConfigChangedListener(this);
    this.Ske = new StoryCore.a(this);
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Skf = new MMHandler("SnsCore_task_handler");
    ((Map)this.SjQ).put(Integer.valueOf("MMStoryInfo".hashCode()), StoryCore..ExternalSyntheticLambda6.INSTANCE);
    ((Map)this.SjQ).put(Integer.valueOf("StoryExtItem".hashCode()), StoryCore..ExternalSyntheticLambda0.INSTANCE);
    ((Map)this.SjQ).put(Integer.valueOf("StoryCommentSync".hashCode()), StoryCore..ExternalSyntheticLambda5.INSTANCE);
    ((Map)this.SjQ).put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), StoryCore..ExternalSyntheticLambda4.INSTANCE);
    ((Map)this.SjQ).put(Integer.valueOf("StoryEditorInfo".hashCode()), StoryCore..ExternalSyntheticLambda3.INSTANCE);
    ((Map)this.SjQ).put(Integer.valueOf("StoryRoomInfo".hashCode()), StoryCore..ExternalSyntheticLambda2.INSTANCE);
    ((Map)this.SjQ).put(Integer.valueOf("MMStoryHistoryItem".hashCode()), StoryCore..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(118712);
  }
  
  private static final String[] hvE()
  {
    AppMethodBeat.i(367111);
    Object localObject = com.tencent.mm.plugin.story.h.k.Sth;
    localObject = com.tencent.mm.plugin.story.h.k.dZh();
    AppMethodBeat.o(367111);
    return localObject;
  }
  
  private static final String[] hvF()
  {
    AppMethodBeat.i(367113);
    Object localObject = com.tencent.mm.plugin.story.h.g.SsV;
    localObject = com.tencent.mm.plugin.story.h.g.dZh();
    AppMethodBeat.o(367113);
    return localObject;
  }
  
  private static final String[] hvG()
  {
    AppMethodBeat.i(367116);
    Object localObject = com.tencent.mm.plugin.story.h.b.SsK;
    localObject = com.tencent.mm.plugin.story.h.b.dZh();
    AppMethodBeat.o(367116);
    return localObject;
  }
  
  private static final String[] hvH()
  {
    AppMethodBeat.i(367117);
    Object localObject = o.Stv;
    localObject = o.hzj();
    AppMethodBeat.o(367117);
    return localObject;
  }
  
  private static final String[] hvI()
  {
    AppMethodBeat.i(367120);
    Object localObject = com.tencent.mm.plugin.story.h.e.SsQ;
    localObject = com.tencent.mm.plugin.story.h.e.hzj();
    AppMethodBeat.o(367120);
    return localObject;
  }
  
  private static final String[] hvJ()
  {
    AppMethodBeat.i(367122);
    Object localObject = m.Stt;
    localObject = m.dZh();
    AppMethodBeat.o(367122);
    return localObject;
  }
  
  private static final String[] hvK()
  {
    AppMethodBeat.i(367123);
    Object localObject = i.Std;
    localObject = i.dZh();
    AppMethodBeat.o(367123);
    return localObject;
  }
  
  public static boolean isValid()
  {
    AppMethodBeat.i(118711);
    boolean bool = com.tencent.mm.kernel.h.baC().aZN();
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
    if (this.Qvb)
    {
      AppMethodBeat.o(118709);
      return;
    }
    this.Qvb = true;
    this.Arp = true;
    com.tencent.mm.vfs.y.bDX(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getAccStoryPath());
    com.tencent.mm.vfs.y.bDX(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getAccStoryTmpPath());
    this.Skb.alive();
    this.Skc.alive();
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new h(), new String[] { "//story" });
    Object localObject = b.hvX();
    ((com.tencent.mm.plugin.story.model.f.c)localObject).nry.a((com.tencent.mm.loader.f.e)((com.tencent.mm.plugin.story.model.f.c)localObject).SnW);
    ((com.tencent.mm.plugin.story.model.f.c)localObject).GbK.a((com.tencent.mm.loader.f.e)((com.tencent.mm.plugin.story.model.f.c)localObject).SnX);
    com.tencent.mm.kernel.h.baD().mCm.a(351, (com.tencent.mm.am.h)localObject);
    localObject = b.hvS();
    ((com.tencent.mm.plugin.story.h.g)localObject).add((MStorage.IOnStorageChange)localObject);
    localObject = com.tencent.mm.plugin.story.model.b.b.SlF;
    if ((com.tencent.mm.vfs.y.ZC(com.tencent.mm.plugin.story.model.b.b.SlG)) && (!com.tencent.mm.vfs.y.ZC(com.tencent.mm.plugin.story.model.b.b.Qxx))) {
      com.tencent.mm.vfs.y.qn(com.tencent.mm.plugin.story.model.b.b.SlG, com.tencent.mm.plugin.story.model.b.b.Qxx);
    }
    byte[] arrayOfByte = com.tencent.mm.vfs.y.bi(com.tencent.mm.plugin.story.model.b.b.Qxx, 0, -1);
    if (arrayOfByte != null)
    {
      if (arrayOfByte.length != 0) {
        break label367;
      }
      i = 1;
      if (i != 0) {
        break label372;
      }
    }
    label367:
    label372:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.plugin.story.model.b.b.SlJ.parseFrom(arrayOfByte);
      }
      com.tencent.mm.kernel.h.baD().mCm.a(354, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.kernel.h.baD().mCm.a(764, (com.tencent.mm.am.h)localObject);
      com.tencent.mm.plugin.story.model.b.b.hhA();
      b.hwc();
      com.tencent.mm.plugin.story.model.sync.a.SmO.init();
      Skh.alive();
      localObject = k.Skq;
      k.reset();
      localObject = k.Skq;
      com.tencent.mm.vfs.y.bDX(kotlin.g.b.s.X(k.hwf(), "coming/"));
      com.tencent.mm.vfs.y.bDX(kotlin.g.b.s.X(k.hwf(), "pic/"));
      com.tencent.mm.vfs.y.bDX(kotlin.g.b.s.X(k.hwf(), "video/"));
      com.tencent.mm.plugin.story.api.p.Siw = (p.b)com.tencent.mm.plugin.story.model.d.e.Smg;
      this.Skd.alive();
      this.Ske.alive();
      AppMethodBeat.o(118709);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(118710);
    this.Ske.dead();
    this.Skb.dead();
    this.Skc.dead();
    this.Skd.dead();
    com.tencent.mm.pluginsdk.cmd.b.X(new String[] { "//story" });
    Object localObject = b.hvX();
    ((com.tencent.mm.plugin.story.model.f.c)localObject).nry.b((com.tencent.mm.loader.f.e)((com.tencent.mm.plugin.story.model.f.c)localObject).SnW);
    ((com.tencent.mm.plugin.story.model.f.c)localObject).GbK.b((com.tencent.mm.loader.f.e)((com.tencent.mm.plugin.story.model.f.c)localObject).SnX);
    com.tencent.mm.kernel.h.baD().mCm.b(351, (com.tencent.mm.am.h)localObject);
    localObject = b.hvS();
    ((com.tencent.mm.plugin.story.h.g)localObject).remove((MStorage.IOnStorageChange)localObject);
    localObject = com.tencent.mm.plugin.story.model.b.b.SlF;
    com.tencent.mm.plugin.story.model.b.b.hwF();
    com.tencent.mm.kernel.h.baD().mCm.b(354, (com.tencent.mm.am.h)localObject);
    com.tencent.mm.kernel.h.baD().mCm.b(764, (com.tencent.mm.am.h)localObject);
    localObject = com.tencent.mm.plugin.story.model.sync.a.SmO;
    Log.i(com.tencent.mm.plugin.story.model.sync.a.TAG, "destroy: ");
    b.hvS().remove((MStorage.IOnStorageChange)localObject);
    b.hvR().remove((MStorage.IOnStorageChange)localObject);
    com.tencent.mm.plugin.story.model.sync.a.tjb.clear();
    com.tencent.mm.plugin.story.model.sync.a.SmV.dead();
    localObject = com.tencent.mm.plugin.story.model.b.b.SlF;
    com.tencent.mm.plugin.story.model.b.b.h(com.tencent.mm.plugin.story.model.sync.a.SmW);
    Skh.dead();
    AppMethodBeat.o(118710);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static com.tencent.mm.loader.b.e a(com.tencent.mm.plugin.story.model.c.a parama)
    {
      AppMethodBeat.i(118697);
      kotlin.g.b.s.u(parama, "scene");
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.m(hvQ()) == null) {
        StoryCore.a(hvQ(), new com.tencent.mm.plugin.story.model.c.e());
      }
      com.tencent.mm.plugin.story.model.c.e locale = StoryCore.m(hvQ());
      kotlin.g.b.s.checkNotNull(locale);
      kotlin.g.b.s.u(parama, "scene");
      switch (com.tencent.mm.plugin.story.model.c.e.a.$EnumSwitchMapping$0[parama.ordinal()])
      {
      default: 
        parama = new p();
        AppMethodBeat.o(118697);
        throw parama;
      case 1: 
      case 2: 
        parama = locale.Smc;
        AppMethodBeat.o(118697);
        return parama;
      }
      parama = locale.Smb;
      AppMethodBeat.o(118697);
      return parama;
    }
    
    public static MMHandler gHI()
    {
      AppMethodBeat.i(118693);
      MMHandler localMMHandler = com.tencent.mm.kernel.h.baH().getWorkerHandler();
      kotlin.g.b.s.s(localMMHandler, "getPizzaWorkerThread().workerHandler");
      AppMethodBeat.o(118693);
      return localMMHandler;
    }
    
    public static String getAccStoryCachePath()
    {
      AppMethodBeat.i(118702);
      String str = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getAccStoryCachePath();
      kotlin.g.b.s.s(str, "plugin<IPluginStory>(IPl…s.java).accStoryCachePath");
      AppMethodBeat.o(118702);
      return str;
    }
    
    public static String getAccStoryPath()
    {
      AppMethodBeat.i(118701);
      String str = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getAccStoryPath();
      kotlin.g.b.s.s(str, "plugin<IPluginStory>(IPl…:class.java).accStoryPath");
      AppMethodBeat.o(118701);
      return str;
    }
    
    private static com.tencent.mm.storagebase.h getDataDB()
    {
      AppMethodBeat.i(118686);
      com.tencent.mm.storagebase.h localh = StoryCore.d(hvQ());
      kotlin.g.b.s.checkNotNull(localh);
      AppMethodBeat.o(118686);
      return localh;
    }
    
    public static String hgg()
    {
      AppMethodBeat.i(118700);
      String str = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
      if (str == null) {
        Log.i(StoryCore.access$getTAG$cp(), kotlin.g.b.s.X("error getSelfName ", Util.getStack()));
      }
      if (str == null)
      {
        AppMethodBeat.o(118700);
        return "";
      }
      AppMethodBeat.o(118700);
      return str;
    }
    
    private static StoryCore hvQ()
    {
      AppMethodBeat.i(118685);
      be localbe = com.tencent.mm.model.y.aL(StoryCore.class);
      if (localbe != null)
      {
        StoryCore.a((StoryCore)localbe);
        if (!StoryCore.b((StoryCore)localbe)) {}
      }
      synchronized (StoryCore.c((StoryCore)localbe))
      {
        Log.i(StoryCore.access$getTAG$cp(), "getCore need reset DB now " + Thread.currentThread().getName() + ' ' + Thread.currentThread().getId() + ' ' + ((StoryCore)localbe).hashCode());
        if (StoryCore.b((StoryCore)localbe))
        {
          StoryCore.o((StoryCore)localbe);
          StoryCore.p((StoryCore)localbe);
          Log.i(StoryCore.access$getTAG$cp(), "resetdb done");
        }
        ah localah = ah.aiuX;
        kotlin.g.b.s.s(localbe, "theCore");
        ??? = (StoryCore)localbe;
        AppMethodBeat.o(118685);
        return ???;
      }
    }
    
    public static com.tencent.mm.plugin.story.h.k hvR()
    {
      AppMethodBeat.i(118687);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.e(hvQ()) == null) {
        StoryCore.a(hvQ(), new com.tencent.mm.plugin.story.h.k((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.h.k localk = StoryCore.e(hvQ());
      kotlin.g.b.s.checkNotNull(localk);
      AppMethodBeat.o(118687);
      return localk;
    }
    
    public static com.tencent.mm.plugin.story.h.g hvS()
    {
      AppMethodBeat.i(118688);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.f(hvQ()) == null) {
        StoryCore.a(hvQ(), new com.tencent.mm.plugin.story.h.g((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.h.g localg = StoryCore.f(hvQ());
      kotlin.g.b.s.checkNotNull(localg);
      AppMethodBeat.o(118688);
      return localg;
    }
    
    public static m hvT()
    {
      AppMethodBeat.i(118689);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.g(hvQ()) == null) {
        StoryCore.a(hvQ(), new m((ISQLiteDatabase)getDataDB()));
      }
      m localm = StoryCore.g(hvQ());
      kotlin.g.b.s.checkNotNull(localm);
      AppMethodBeat.o(118689);
      return localm;
    }
    
    public static com.tencent.mm.plugin.story.h.b hvU()
    {
      AppMethodBeat.i(118690);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.h(hvQ()) == null) {
        StoryCore.a(hvQ(), new com.tencent.mm.plugin.story.h.b((ISQLiteDatabase)getDataDB()));
      }
      com.tencent.mm.plugin.story.h.b localb = StoryCore.h(hvQ());
      kotlin.g.b.s.checkNotNull(localb);
      AppMethodBeat.o(118690);
      return localb;
    }
    
    public static o hvV()
    {
      AppMethodBeat.i(118691);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.i(hvQ()) == null) {
        StoryCore.a(hvQ(), new o((ISQLiteDatabase)getDataDB()));
      }
      o localo = StoryCore.i(hvQ());
      kotlin.g.b.s.checkNotNull(localo);
      AppMethodBeat.o(118691);
      return localo;
    }
    
    public static i hvW()
    {
      AppMethodBeat.i(118692);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.j(hvQ()) == null) {
        StoryCore.a(hvQ(), new i((ISQLiteDatabase)getDataDB()));
      }
      i locali = StoryCore.j(hvQ());
      kotlin.g.b.s.checkNotNull(locali);
      AppMethodBeat.o(118692);
      return locali;
    }
    
    public static com.tencent.mm.plugin.story.model.f.c hvX()
    {
      AppMethodBeat.i(118694);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.k(hvQ()) == null) {
        StoryCore.a(hvQ(), new com.tencent.mm.plugin.story.model.f.c());
      }
      com.tencent.mm.plugin.story.model.f.c localc = StoryCore.k(hvQ());
      kotlin.g.b.s.checkNotNull(localc);
      AppMethodBeat.o(118694);
      return localc;
    }
    
    public static e hvY()
    {
      AppMethodBeat.i(118695);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.l(hvQ()) == null)
      {
        localObject = hvQ();
        String str = com.tencent.mm.kernel.h.baE().cachePath;
        e.a locala = e.SjB;
        StoryCore.a((StoryCore)localObject, new e(kotlin.g.b.s.X(str, e.hvs())));
      }
      Object localObject = StoryCore.l(hvQ());
      kotlin.g.b.s.checkNotNull(localObject);
      AppMethodBeat.o(118695);
      return localObject;
    }
    
    public static com.tencent.mm.loader.d<com.tencent.mm.plugin.story.model.c.d> hvZ()
    {
      AppMethodBeat.i(118696);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.m(hvQ()) == null) {
        StoryCore.a(hvQ(), new com.tencent.mm.plugin.story.model.c.e());
      }
      Object localObject = StoryCore.m(hvQ());
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((com.tencent.mm.plugin.story.model.c.e)localObject).SlZ;
      AppMethodBeat.o(118696);
      return localObject;
    }
    
    public static n.a hwa()
    {
      AppMethodBeat.i(118698);
      com.tencent.mm.kernel.h.baC().aZJ();
      if (StoryCore.n(hvQ()) == null) {
        StoryCore.a(hvQ(), new n.a());
      }
      n.a locala = StoryCore.n(hvQ());
      kotlin.g.b.s.checkNotNull(locala);
      AppMethodBeat.o(118698);
      return locala;
    }
    
    public static g.a hwb()
    {
      AppMethodBeat.i(118703);
      g.a locala = (g.a)com.tencent.mm.plugin.story.c.a.g.Sjf.boF();
      AppMethodBeat.o(118703);
      return locala;
    }
    
    static void hwc()
    {
      AppMethodBeat.i(118704);
      StoryCore.hvL();
      int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yIz, 1);
      Log.d(StoryCore.access$getTAG$cp(), "loadStoryCheck %s local_debug %s", new Object[] { Integer.valueOf(j), Boolean.FALSE });
      com.tencent.mm.storage.c localc = com.tencent.mm.model.newabtest.d.bEt().Fd("100481");
      int i = j;
      if (localc.isValid())
      {
        i = j;
        if (kotlin.g.b.s.p("1", localc.iWZ().get("open"))) {
          i = 1;
        }
      }
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        StoryCore.EH(bool);
        AppMethodBeat.o(118704);
        return;
      }
    }
    
    public static boolean hwd()
    {
      AppMethodBeat.i(118705);
      if (ac.hFS())
      {
        AppMethodBeat.o(118705);
        return false;
      }
      if (!StoryCore.hvM()) {
        hwc();
      }
      boolean bool = StoryCore.hvN();
      AppMethodBeat.o(118705);
      return bool;
    }
    
    public static long hwe()
    {
      AppMethodBeat.i(118706);
      if (StoryCore.hvO() == -1L) {
        StoryCore.vM(com.tencent.mm.kernel.h.baE().ban().a(at.a.acYO, 0L));
      }
      long l = StoryCore.hvO();
      AppMethodBeat.o(118706);
      return l;
    }
    
    public static boolean isInValid()
    {
      AppMethodBeat.i(118699);
      hvQ();
      if (!StoryCore.isValid())
      {
        AppMethodBeat.o(118699);
        return true;
      }
      AppMethodBeat.o(118699);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.StoryCore
 * JD-Core Version:    0.7.0.1
 */
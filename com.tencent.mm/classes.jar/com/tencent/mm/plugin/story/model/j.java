package com.tencent.mm.plugin.story.model;

import android.graphics.Point;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.story.PluginStory.b;
import com.tencent.mm.plugin.story.PluginStory.c;
import com.tencent.mm.plugin.story.api.o.b;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.h.m;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.plugin.story.model.f.a.i;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryCore;", "Lcom/tencent/mm/model/ISubCore;", "()V", "appForegroundListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isAccInit", "", "lock", "", "needResetDb", "storyAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "storyCleanListener", "Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "storyCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "storyConfigChangeListener", "Lcom/tencent/mm/plugin/story/model/StoryCore$ConfigChangedListener;", "storyDBFactories", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getStoryDBFactories", "()Ljava/util/HashMap;", "setStoryDBFactories", "(Ljava/util/HashMap;)V", "storyEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "storyExtInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "storyHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "storyInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "storyLoader", "Lcom/tencent/mm/plugin/story/model/download/StoryLoader;", "storyRoomInfoStg", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "storyServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "storySyncListener", "Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "storyUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "storyVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "taskThread", "checkDir", "", "clearPluginData", "pluginFlag", "getBaseDBFactories", "isValid", "onAccountPostReset", "updated", "onAccountRelease", "onSdcardMount", "mounted", "parpareTaskThread", "resetDb", "updateConfigs", "AppForegroundListener", "Companion", "ConfigChangedListener", "plugin-story_release"})
public final class j
  implements at
{
  private static final String TAG = "MicroMsg.StoryCore";
  private static String rgQ;
  private static final int rha = 103;
  private static final Point rhc;
  private static final int svd = 150;
  private static final com.tencent.mm.sdk.b.c<fb> sve;
  private static boolean svf;
  private static boolean svg;
  private static long svh;
  public static final j.b svi;
  private com.tencent.mm.cg.h eHS;
  private final byte[] eKs;
  private final ak handler;
  private boolean rgK;
  private boolean rgN;
  private HashMap<Integer, h.d> suM;
  private k suN;
  private com.tencent.mm.plugin.story.h.g suO;
  private m suP;
  private com.tencent.mm.plugin.story.h.b suQ;
  private o suR;
  private com.tencent.mm.plugin.story.h.e suS;
  private i suT;
  private com.tencent.mm.plugin.story.model.g.c suU;
  private e suV;
  private com.tencent.mm.plugin.story.model.c.e suW;
  private o.a suX;
  private PluginStory.c suY;
  private PluginStory.b suZ;
  private j.d sva;
  private j.a svb;
  private ak svc;
  
  static
  {
    AppMethodBeat.i(109086);
    svi = new j.b((byte)0);
    TAG = "MicroMsg.StoryCore";
    rgQ = "";
    rhc = new Point();
    rha = 103;
    svd = 150;
    sve = (com.tencent.mm.sdk.b.c)new j.c();
    svh = -1L;
    AppMethodBeat.o(109086);
  }
  
  public j()
  {
    AppMethodBeat.i(109085);
    this.eKs = new byte[0];
    this.suM = new HashMap();
    this.suY = new PluginStory.c();
    this.suZ = new PluginStory.b();
    this.sva = new j.d(this);
    this.svb = new j.a(this);
    this.handler = new ak(Looper.getMainLooper());
    com.tencent.mm.sdk.g.d.a((Runnable)new j.e(this), "SnsCore_task_handler", 10).start();
    ((Map)this.suM).put(Integer.valueOf("MMStoryInfo".hashCode()), j.1.svj);
    ((Map)this.suM).put(Integer.valueOf("StoryExtItem".hashCode()), j.2.svk);
    ((Map)this.suM).put(Integer.valueOf("StoryCommentSync".hashCode()), j.3.svl);
    ((Map)this.suM).put(Integer.valueOf("StoryVideoCacheInfo".hashCode()), j.4.svm);
    ((Map)this.suM).put(Integer.valueOf("StoryEditorInfo".hashCode()), j.5.svn);
    ((Map)this.suM).put(Integer.valueOf("StoryRoomInfo".hashCode()), j.6.svo);
    ((Map)this.suM).put(Integer.valueOf("MMStoryHistoryItem".hashCode()), j.7.svp);
    AppMethodBeat.o(109085);
  }
  
  public static boolean isValid()
  {
    AppMethodBeat.i(109084);
    boolean bool = com.tencent.mm.kernel.g.RJ().QU();
    AppMethodBeat.o(109084);
    return bool;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(109082);
    if (this.rgN)
    {
      AppMethodBeat.o(109082);
      return;
    }
    this.rgN = true;
    this.rgK = true;
    Object localObject1 = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class);
    a.f.b.j.p(localObject1, "plugin(IPluginStory::class.java)");
    com.tencent.mm.vfs.e.um(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryPath());
    localObject1 = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class);
    a.f.b.j.p(localObject1, "plugin(IPluginStory::class.java)");
    com.tencent.mm.vfs.e.um(((com.tencent.mm.plugin.story.api.e)localObject1).getAccStoryTmpPath());
    com.tencent.mm.sdk.b.a.ymk.c((com.tencent.mm.sdk.b.c)this.suY);
    com.tencent.mm.sdk.b.a.ymk.c((com.tencent.mm.sdk.b.c)this.suZ);
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new h(), new String[] { "//story" });
    localObject1 = j.b.cAI();
    ((com.tencent.mm.plugin.story.model.g.c)localObject1).sAb.a((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.model.g.c)localObject1).sAd);
    ((com.tencent.mm.plugin.story.model.g.c)localObject1).szR.a((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.model.g.c)localObject1).sAe);
    Object localObject2 = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localObject2, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject2).Rc().a(351, (com.tencent.mm.ai.f)localObject1);
    localObject1 = j.b.cAC();
    ((com.tencent.mm.plugin.story.h.g)localObject1).add((k.a)localObject1);
    localObject1 = com.tencent.mm.plugin.story.model.b.b.sxN;
    localObject2 = com.tencent.mm.vfs.e.i(com.tencent.mm.plugin.story.model.b.b.sxF, 0, -1);
    if (localObject2 != null)
    {
      if (localObject2.length != 0) {
        break label454;
      }
      i = 1;
      if (i != 0) {
        break label459;
      }
    }
    label454:
    label459:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.plugin.story.model.b.b.sxH.parseFrom((byte[])localObject2);
      }
      localObject2 = com.tencent.mm.kernel.g.RK();
      a.f.b.j.p(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).Rc().a(354, (com.tencent.mm.ai.f)localObject1);
      localObject2 = com.tencent.mm.kernel.g.RK();
      a.f.b.j.p(localObject2, "network()");
      ((com.tencent.mm.kernel.b)localObject2).Rc().a(764, (com.tencent.mm.ai.f)localObject1);
      com.tencent.mm.plugin.story.model.b.b.cpL();
      j.b.cAN();
      com.tencent.mm.plugin.story.model.f.a.szc.init();
      sve.alive();
      localObject1 = l.svv;
      l.reset();
      localObject1 = l.svv;
      com.tencent.mm.vfs.e.um(l.cAS() + "coming/");
      com.tencent.mm.vfs.e.um(l.cAS() + "/pic/");
      com.tencent.mm.vfs.e.um(l.cAS() + "/video/");
      com.tencent.mm.plugin.story.api.o.sra = (o.b)com.tencent.mm.plugin.story.model.d.d.syp;
      com.tencent.mm.sdk.b.a.ymk.c((com.tencent.mm.sdk.b.c)this.sva);
      this.svb.alive();
      AppMethodBeat.o(109082);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(109083);
    this.svb.dead();
    com.tencent.mm.sdk.b.a.ymk.d((com.tencent.mm.sdk.b.c)this.suY);
    com.tencent.mm.sdk.b.a.ymk.d((com.tencent.mm.sdk.b.c)this.suZ);
    com.tencent.mm.sdk.b.a.ymk.d((com.tencent.mm.sdk.b.c)this.sva);
    com.tencent.mm.pluginsdk.cmd.b.N(new String[] { "//story" });
    Object localObject = j.b.cAI();
    ((com.tencent.mm.plugin.story.model.g.c)localObject).sAb.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.model.g.c)localObject).sAd);
    ((com.tencent.mm.plugin.story.model.g.c)localObject).szR.b((com.tencent.mm.loader.g.f)((com.tencent.mm.plugin.story.model.g.c)localObject).sAe);
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localb, "MMKernel.network()");
    localb.Rc().b(351, (com.tencent.mm.ai.f)localObject);
    localObject = j.b.cAC();
    ((com.tencent.mm.plugin.story.h.g)localObject).remove((k.a)localObject);
    localObject = com.tencent.mm.plugin.story.model.b.b.sxN;
    com.tencent.mm.plugin.story.model.b.b.cBH();
    localb = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localb, "network()");
    localb.Rc().b(354, (com.tencent.mm.ai.f)localObject);
    localb = com.tencent.mm.kernel.g.RK();
    a.f.b.j.p(localb, "network()");
    localb.Rc().b(764, (com.tencent.mm.ai.f)localObject);
    localObject = com.tencent.mm.plugin.story.model.f.a.szc;
    ab.i(com.tencent.mm.plugin.story.model.f.a.TAG, "destroy: ");
    j.b.cAC().remove((k.a)localObject);
    j.b.cAB().remove((k.a)localObject);
    com.tencent.mm.plugin.story.model.f.a.ipW.clear();
    com.tencent.mm.plugin.story.model.f.a.sza.dead();
    localObject = com.tencent.mm.plugin.story.model.b.b.sxN;
    com.tencent.mm.plugin.story.model.b.b.c(com.tencent.mm.plugin.story.model.f.a.szb);
    sve.dead();
    AppMethodBeat.o(109083);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.j
 * JD-Core Version:    0.7.0.1
 */
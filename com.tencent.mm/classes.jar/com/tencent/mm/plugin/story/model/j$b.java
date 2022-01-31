package com.tencent.mm.plugin.story.model;

import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.story.c.a.f;
import com.tencent.mm.plugin.story.c.a.f.a;
import com.tencent.mm.plugin.story.h.b;
import com.tencent.mm.plugin.story.h.i;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.h.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryCore$Companion;", "", "()V", "MULTI_THUMB_IMAGEVIEW_OFFSET", "", "TAG", "", "THUMBNAIL_SIZE_LIMIT", "allReadTime", "", "exptChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExptChangeEvent;", "fileSys", "initAbTest", "", "multiThumbDisplaySize", "screenSize", "Landroid/graphics/Point;", "singleThumbDisplaySize", "storyIsOpen", "getAccStoryCachePath", "getAccStoryPath", "getAllStoryReadTime", "getCore", "Lcom/tencent/mm/plugin/story/model/StoryCore;", "getCropTypeWithCPU", "getDataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getRemuxType", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "getSelfName", "getSelfUin", "getStoryAsyncQueueMgr", "Lcom/tencent/mm/plugin/story/model/StoryAsyncQueueMgr;", "getStoryCommentStorage", "Lcom/tencent/mm/plugin/story/storage/StoryCommentStorage;", "getStoryEditorDataStorage", "Lcom/tencent/mm/plugin/story/storage/StoryEditorDataStorage;", "getStoryExtInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfoStorage;", "getStoryHistoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfoStorage;", "getStoryInfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryInfoStorage;", "getStoryRoominfoStorage", "Lcom/tencent/mm/plugin/story/storage/StoryRoomInfoStorage;", "getStoryServer", "Lcom/tencent/mm/plugin/story/model/StoryLogic$StoryServer;", "getStoryUploadManager", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "getStoryVideoCacheStorage", "Lcom/tencent/mm/plugin/story/storage/StoryVideoCacheStorage;", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isInValid", "isShowStory", "loadStoryStatus", "", "loader", "Lcom/tencent/mm/loader/Loader;", "Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "loaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "scene", "Lcom/tencent/mm/plugin/story/model/download/LoaderScene;", "setAllStoryReadTime", "time", "plugin-story_release"})
public final class j$b
{
  private static h Rq()
  {
    AppMethodBeat.i(109058);
    h localh = j.f(cAA());
    if (localh == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109058);
    return localh;
  }
  
  public static com.tencent.mm.loader.c.e a(com.tencent.mm.plugin.story.model.c.a parama)
  {
    AppMethodBeat.i(109070);
    a.f.b.j.q(parama, "scene");
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.p(cAA()) == null) {
      j.a(cAA(), new com.tencent.mm.plugin.story.model.c.e());
    }
    com.tencent.mm.plugin.story.model.c.e locale = j.p(cAA());
    if (locale == null) {
      a.f.b.j.ebi();
    }
    a.f.b.j.q(parama, "scene");
    switch (com.tencent.mm.plugin.story.model.c.f.bLo[parama.ordinal()])
    {
    default: 
      parama = new a.m();
      AppMethodBeat.o(109070);
      throw parama;
    case 1: 
    case 2: 
      parama = locale.syl;
      AppMethodBeat.o(109070);
      return parama;
    }
    parama = locale.syk;
    AppMethodBeat.o(109070);
    return parama;
  }
  
  private static j cAA()
  {
    AppMethodBeat.i(109057);
    j localj = (j)q.S(j.class);
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
      a.f.b.j.p(localThread, "Thread.currentThread()");
      localStringBuilder = localStringBuilder.append(localThread.getName()).append(" ");
      localThread = Thread.currentThread();
      a.f.b.j.p(localThread, "Thread.currentThread()");
      ab.i((String)localObject2, localThread.getId() + " " + localj.hashCode());
      if (j.b(localj))
      {
        j.e(localj);
        j.c(localj);
        ab.i(j.access$getTAG$cp(), "resetdb done");
      }
      localObject2 = y.BMg;
      a.f.b.j.p(localj, "theCore");
      AppMethodBeat.o(109057);
      return localj;
    }
  }
  
  public static k cAB()
  {
    AppMethodBeat.i(109059);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.g(cAA()) == null) {
      j.a(cAA(), new k((com.tencent.mm.sdk.e.e)Rq()));
    }
    k localk = j.g(cAA());
    if (localk == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109059);
    return localk;
  }
  
  public static com.tencent.mm.plugin.story.h.g cAC()
  {
    AppMethodBeat.i(109060);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.h(cAA()) == null) {
      j.a(cAA(), new com.tencent.mm.plugin.story.h.g((com.tencent.mm.sdk.e.e)Rq()));
    }
    com.tencent.mm.plugin.story.h.g localg = j.h(cAA());
    if (localg == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109060);
    return localg;
  }
  
  public static com.tencent.mm.plugin.story.h.m cAD()
  {
    AppMethodBeat.i(109061);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.i(cAA()) == null) {
      j.a(cAA(), new com.tencent.mm.plugin.story.h.m((com.tencent.mm.sdk.e.e)Rq()));
    }
    com.tencent.mm.plugin.story.h.m localm = j.i(cAA());
    if (localm == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109061);
    return localm;
  }
  
  public static b cAE()
  {
    AppMethodBeat.i(109062);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.j(cAA()) == null) {
      j.a(cAA(), new b((com.tencent.mm.sdk.e.e)Rq()));
    }
    b localb = j.j(cAA());
    if (localb == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109062);
    return localb;
  }
  
  public static o cAF()
  {
    AppMethodBeat.i(109063);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.k(cAA()) == null) {
      j.a(cAA(), new o((com.tencent.mm.sdk.e.e)Rq()));
    }
    o localo = j.k(cAA());
    if (localo == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109063);
    return localo;
  }
  
  public static com.tencent.mm.plugin.story.h.e cAG()
  {
    AppMethodBeat.i(109064);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.l(cAA()) == null) {
      j.a(cAA(), new com.tencent.mm.plugin.story.h.e((com.tencent.mm.sdk.e.e)Rq()));
    }
    com.tencent.mm.plugin.story.h.e locale = j.l(cAA());
    if (locale == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109064);
    return locale;
  }
  
  public static i cAH()
  {
    AppMethodBeat.i(109065);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.m(cAA()) == null) {
      j.a(cAA(), new i((com.tencent.mm.sdk.e.e)Rq()));
    }
    i locali = j.m(cAA());
    if (locali == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109065);
    return locali;
  }
  
  public static com.tencent.mm.plugin.story.model.g.c cAI()
  {
    AppMethodBeat.i(109067);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.n(cAA()) == null) {
      j.a(cAA(), new com.tencent.mm.plugin.story.model.g.c());
    }
    com.tencent.mm.plugin.story.model.g.c localc = j.n(cAA());
    if (localc == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109067);
    return localc;
  }
  
  public static e cAJ()
  {
    AppMethodBeat.i(109068);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.o(cAA()) == null)
    {
      localObject1 = cAA();
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = com.tencent.mm.kernel.g.RL();
      a.f.b.j.p(localObject2, "MMKernel.storage()");
      localStringBuilder = localStringBuilder.append(((com.tencent.mm.kernel.e)localObject2).Rp());
      localObject2 = e.suB;
      j.a((j)localObject1, new e(e.cAi()));
    }
    Object localObject1 = j.o(cAA());
    if (localObject1 == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109068);
    return localObject1;
  }
  
  public static com.tencent.mm.loader.d<com.tencent.mm.plugin.story.model.c.d> cAK()
  {
    AppMethodBeat.i(109069);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.p(cAA()) == null) {
      j.a(cAA(), new com.tencent.mm.plugin.story.model.c.e());
    }
    Object localObject = j.p(cAA());
    if (localObject == null) {
      a.f.b.j.ebi();
    }
    localObject = ((com.tencent.mm.plugin.story.model.c.e)localObject).syi;
    AppMethodBeat.o(109069);
    return localObject;
  }
  
  public static o.a cAL()
  {
    AppMethodBeat.i(109071);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (j.q(cAA()) == null) {
      j.a(cAA(), new o.a());
    }
    o.a locala = j.q(cAA());
    if (locala == null) {
      a.f.b.j.ebi();
    }
    AppMethodBeat.o(109071);
    return locala;
  }
  
  public static f.a cAM()
  {
    AppMethodBeat.i(109076);
    f.a locala = (f.a)f.ssh.Uw();
    AppMethodBeat.o(109076);
    return locala;
  }
  
  static void cAN()
  {
    AppMethodBeat.i(109077);
    j.cAx();
    int i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRY, 1);
    ab.d(j.access$getTAG$cp(), "loadStoryCheck %s local_debug %s", new Object[] { Integer.valueOf(i), Boolean.FALSE });
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100481");
    a.f.b.j.p(localc, "abTestItem");
    if ((localc.isValid()) && (a.f.b.j.e("1", (String)localc.dvN().get("open")))) {
      i = 1;
    }
    for (;;)
    {
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        j.lU(bool);
        AppMethodBeat.o(109077);
        return;
      }
    }
  }
  
  public static boolean cAO()
  {
    AppMethodBeat.i(109078);
    if (!j.cAw()) {
      cAN();
    }
    boolean bool = j.cAy();
    AppMethodBeat.o(109078);
    return bool;
  }
  
  public static long cAP()
  {
    AppMethodBeat.i(109079);
    if (j.cAz() == -1L)
    {
      com.tencent.mm.kernel.e locale = com.tencent.mm.kernel.g.RL();
      a.f.b.j.p(locale, "MMKernel.storage()");
      j.mv(locale.Ru().a(ac.a.yLM, 0L));
    }
    long l = j.cAz();
    AppMethodBeat.o(109079);
    return l;
  }
  
  public static String coK()
  {
    AppMethodBeat.i(109073);
    Object localObject = com.tencent.mm.kernel.g.RL();
    a.f.b.j.p(localObject, "MMKernel.storage()");
    String str = (String)((com.tencent.mm.kernel.e)localObject).Ru().get(2);
    if (str == null) {
      ab.i(j.access$getTAG$cp(), "error getSelfName " + bo.dtY());
    }
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(109073);
    return localObject;
  }
  
  public static boolean coN()
  {
    AppMethodBeat.i(109072);
    cAA();
    if (!j.isValid())
    {
      AppMethodBeat.o(109072);
      return true;
    }
    AppMethodBeat.o(109072);
    return false;
  }
  
  public static ak coO()
  {
    AppMethodBeat.i(109066);
    Object localObject = com.tencent.mm.kernel.g.RO();
    a.f.b.j.p(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((al)localObject).caB();
    a.f.b.j.p(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
    AppMethodBeat.o(109066);
    return localObject;
  }
  
  public static String getAccStoryCachePath()
  {
    AppMethodBeat.i(109075);
    Object localObject = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class);
    a.f.b.j.p(localObject, "plugin<IPluginStory>(IPluginStory::class.java)");
    localObject = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryCachePath();
    a.f.b.j.p(localObject, "plugin<IPluginStory>(IPl…s.java).accStoryCachePath");
    AppMethodBeat.o(109075);
    return localObject;
  }
  
  public static String getAccStoryPath()
  {
    AppMethodBeat.i(109074);
    Object localObject = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.story.api.e.class);
    a.f.b.j.p(localObject, "plugin<IPluginStory>(IPluginStory::class.java)");
    localObject = ((com.tencent.mm.plugin.story.api.e)localObject).getAccStoryPath();
    a.f.b.j.p(localObject, "plugin<IPluginStory>(IPl…:class.java).accStoryPath");
    AppMethodBeat.o(109074);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.j.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.b.a.jv;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onFakeDataUpdateCallback", "Lkotlin/Function0;", "", "postCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1;", "uploadQueue", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "addFakeDataListener", "onFakeDataUpdate", "addPostEndListener", "listener", "checkMixStory", "checkPost", "notifyEndPost", "localId", "", "isOk", "", "notifyEventPost", "notifyStartPost", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFakeDataListener", "removePostEndListener", "start", "startPost", "stop", "Companion", "plugin-story_release"})
public final class c
  implements i
{
  public static final a FqD;
  public kotlin.g.a.a<x> FqA;
  public final f FqB;
  public final h FqC;
  public com.tencent.mm.loader.g.d<a> ibn;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  public com.tencent.mm.loader.g.d<e> vSA;
  
  static
  {
    AppMethodBeat.i(119119);
    FqD = new a((byte)0);
    AppMethodBeat.o(119119);
  }
  
  public c()
  {
    AppMethodBeat.i(119118);
    this.ibn = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "storyPost"));
    this.vSA = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "storyUpload"));
    this.FqB = new f(this);
    this.FqC = new h();
    this.listeners = new HashSet();
    AppMethodBeat.o(119118);
  }
  
  private final void aY(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(119116);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, paramInt, paramBoolean));
    AppMethodBeat.o(119116);
  }
  
  public final void a(final com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(119114);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this, paramk));
    AppMethodBeat.o(119114);
  }
  
  public final void ac(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(119112);
    p.h(parama, "onFakeDataUpdate");
    this.FqA = parama;
    AppMethodBeat.o(119112);
  }
  
  public final void b(final com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(119115);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new g(this, paramk));
    AppMethodBeat.o(119115);
  }
  
  public final void checkPost()
  {
    AppMethodBeat.i(119111);
    Object localObject1 = com.tencent.mm.plugin.story.f.e.a.Fpl;
    com.tencent.mm.plugin.story.f.e.a.fpa();
    localObject1 = com.tencent.mm.plugin.story.f.j.Fmy;
    localObject1 = j.b.foc().frP();
    if (localObject1 == null)
    {
      Log.d("MicroMsg.StoryUploadTask", "All has post");
      AppMethodBeat.o(119111);
      return;
    }
    Log.d("MicroMsg.StoryUploadTask", "checking story from db, will post: " + ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID + ' ' + (int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid + ' ' + ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName + ' ' + ((com.tencent.mm.plugin.story.i.j)localObject1).frI().ibG);
    Object localObject2 = new a((com.tencent.mm.plugin.story.i.j)localObject1, this.vSA);
    this.ibn.c((com.tencent.mm.loader.g.c)localObject2);
    localObject2 = h.FuH;
    h.aaU((int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid).sW(Util.nowMilliSecond());
    localObject2 = h.FuH;
    h.aaU((int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid).sY(NetStatusUtil.getIOSNetType(MMApplicationContext.getContext()));
    AppMethodBeat.o(119111);
  }
  
  public final void fpv()
  {
    AppMethodBeat.i(119113);
    kotlin.g.a.a locala = this.FqA;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(119113);
      return;
    }
    AppMethodBeat.o(119113);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(119117);
    if (!(paramq instanceof com.tencent.mm.plugin.story.f.a.g)) {}
    for (paramString = null;; paramString = paramq)
    {
      paramString = (com.tencent.mm.plugin.story.f.a.g)paramString;
      if (paramString != null)
      {
        if ((paramInt1 == 4) || (paramInt2 == 0))
        {
          aY(paramString.ecf, true);
          try
          {
            paramq = com.tencent.mm.plugin.story.f.j.Fmy;
            paramq = j.b.foc().aba(paramString.ecf);
            if (paramq != null)
            {
              h localh = h.FuH;
              h.aaU(paramString.ecf).xh(String.valueOf(paramq.field_storyID));
              localh = h.FuH;
              h.aaU(paramString.ecf).xg(((edt)paramq.frG().NeB.LoV.get(0)).Url);
              paramq = h.FuH;
              h.aaU(paramString.ecf).sX(Util.nowMilliSecond());
              paramq = h.FuH;
              h.aaV(paramString.ecf);
              paramString = x.SXb;
              AppMethodBeat.o(119117);
              return;
            }
            AppMethodBeat.o(119117);
            return;
          }
          catch (Exception paramString)
          {
            Log.printErrStackTrace("MicroMsg.StoryUploadTask", (Throwable)paramString, "upload error", new Object[0]);
            paramString = x.SXb;
            AppMethodBeat.o(119117);
            return;
          }
        }
        aY(paramString.ecf, false);
      }
      AppMethodBeat.o(119117);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/upload/UploadManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(c paramc, com.tencent.mm.plugin.story.api.k paramk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(c paramc, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class f
    implements com.tencent.mm.loader.g.f<a>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    g(c paramc, com.tencent.mm.plugin.story.api.k paramk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class h
    implements com.tencent.mm.loader.g.f<e>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.c
 * JD-Core Version:    0.7.0.1
 */
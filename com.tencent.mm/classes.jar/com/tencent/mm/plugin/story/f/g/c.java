package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.gh;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashSet;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onFakeDataUpdateCallback", "Lkotlin/Function0;", "", "postCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1;", "uploadQueue", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "addFakeDataListener", "onFakeDataUpdate", "addPostEndListener", "listener", "checkMixStory", "checkPost", "notifyEndPost", "localId", "", "isOk", "", "notifyEventPost", "notifyStartPost", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFakeDataListener", "removePostEndListener", "start", "startPost", "stop", "Companion", "plugin-story_release"})
public final class c
  implements com.tencent.mm.ak.f
{
  public static final c.a BfM;
  public d.g.a.a<z> BfJ;
  public final f BfK;
  public final h BfL;
  public com.tencent.mm.loader.g.d<a> hip;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  public com.tencent.mm.loader.g.d<e> sUq;
  
  static
  {
    AppMethodBeat.i(119119);
    BfM = new c.a((byte)0);
    AppMethodBeat.o(119119);
  }
  
  public c()
  {
    AppMethodBeat.i(119118);
    this.hip = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "storyPost"));
    this.sUq = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "storyUpload"));
    this.BfK = new f(this);
    this.BfL = new h();
    this.listeners = new HashSet();
    AppMethodBeat.o(119118);
  }
  
  private final void aI(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(119116);
    com.tencent.mm.ac.c.h((d.g.a.a)new c(this, paramInt, paramBoolean));
    AppMethodBeat.o(119116);
  }
  
  public final void J(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(119112);
    p.h(parama, "onFakeDataUpdate");
    this.BfJ = parama;
    AppMethodBeat.o(119112);
  }
  
  public final void a(final com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(119114);
    com.tencent.mm.ac.c.h((d.g.a.a)new b(this, paramk));
    AppMethodBeat.o(119114);
  }
  
  public final void b(final com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(119115);
    com.tencent.mm.ac.c.h((d.g.a.a)new g(this, paramk));
    AppMethodBeat.o(119115);
  }
  
  public final void checkPost()
  {
    AppMethodBeat.i(119111);
    Object localObject1 = com.tencent.mm.plugin.story.f.e.a.Beu;
    com.tencent.mm.plugin.story.f.e.a.emz();
    localObject1 = com.tencent.mm.plugin.story.f.j.BbE;
    localObject1 = j.b.elB().epp();
    if (localObject1 == null)
    {
      ae.d("MicroMsg.StoryUploadTask", "All has post");
      AppMethodBeat.o(119111);
      return;
    }
    ae.d("MicroMsg.StoryUploadTask", "checking story from db, will post: " + ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID + ' ' + (int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid + ' ' + ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName + ' ' + ((com.tencent.mm.plugin.story.i.j)localObject1).epi().hiJ);
    Object localObject2 = new a((com.tencent.mm.plugin.story.i.j)localObject1, this.sUq);
    this.hip.b((com.tencent.mm.loader.g.c)localObject2);
    localObject2 = h.BjR;
    h.SY((int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid).lU(bu.fpO());
    localObject2 = h.BjR;
    h.SY((int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid).lW(az.iX(ak.getContext()));
    AppMethodBeat.o(119111);
  }
  
  public final void emU()
  {
    AppMethodBeat.i(119113);
    d.g.a.a locala = this.BfJ;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(119113);
      return;
    }
    AppMethodBeat.o(119113);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(119117);
    if (!(paramn instanceof com.tencent.mm.plugin.story.f.a.g)) {}
    for (paramString = null;; paramString = paramn)
    {
      paramString = (com.tencent.mm.plugin.story.f.a.g)paramString;
      if (paramString != null)
      {
        if ((paramInt1 == 4) || (paramInt2 == 0))
        {
          aI(paramString.dKr, true);
          try
          {
            paramn = com.tencent.mm.plugin.story.f.j.BbE;
            paramn = j.b.elB().Te(paramString.dKr);
            if (paramn != null)
            {
              h localh = h.BjR;
              h.SY(paramString.dKr).pz(String.valueOf(paramn.field_storyID));
              localh = h.BjR;
              h.SY(paramString.dKr).py(((dkg)paramn.epg().HSy.Gtx.get(0)).Url);
              paramn = h.BjR;
              h.SY(paramString.dKr).lV(bu.fpO());
              paramn = h.BjR;
              h.SZ(paramString.dKr);
              paramString = z.Nhr;
              AppMethodBeat.o(119117);
              return;
            }
            AppMethodBeat.o(119117);
            return;
          }
          catch (Exception paramString)
          {
            ae.printErrStackTrace("MicroMsg.StoryUploadTask", (Throwable)paramString, "upload error", new Object[0]);
            paramString = z.Nhr;
            AppMethodBeat.o(119117);
            return;
          }
        }
        aI(paramString.dKr, false);
      }
      AppMethodBeat.o(119117);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(c paramc, com.tencent.mm.plugin.story.api.k paramk)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(c paramc, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class f
    implements com.tencent.mm.loader.g.f<a>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(c paramc, com.tencent.mm.plugin.story.api.k paramk)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class h
    implements com.tencent.mm.loader.g.f<e>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.c
 * JD-Core Version:    0.7.0.1
 */
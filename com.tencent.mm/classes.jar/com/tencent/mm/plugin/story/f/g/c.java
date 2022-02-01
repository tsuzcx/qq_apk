package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.fg;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import d.y;
import java.util.HashSet;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onFakeDataUpdateCallback", "Lkotlin/Function0;", "", "postCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1;", "uploadQueue", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "addFakeDataListener", "onFakeDataUpdate", "addPostEndListener", "listener", "checkMixStory", "checkPost", "notifyEndPost", "localId", "", "isOk", "", "notifyEventPost", "notifyStartPost", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFakeDataListener", "removePostEndListener", "start", "startPost", "stop", "Companion", "plugin-story_release"})
public final class c
  implements com.tencent.mm.ak.g
{
  public static final c.a zwp;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  public com.tencent.mm.loader.g.d<a> rMY;
  public com.tencent.mm.loader.g.d<e> rMZ;
  public d.g.a.a<y> zwm;
  public final f zwn;
  public final h zwo;
  
  static
  {
    AppMethodBeat.i(119119);
    zwp = new c.a((byte)0);
    AppMethodBeat.o(119119);
  }
  
  public c()
  {
    AppMethodBeat.i(119118);
    this.rMY = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "storyPost"));
    this.rMZ = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "storyUpload"));
    this.zwn = new f(this);
    this.zwo = new h();
    this.listeners = new HashSet();
    AppMethodBeat.o(119118);
  }
  
  private final void aA(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(119116);
    com.tencent.mm.ac.c.g((d.g.a.a)new c(this, paramInt, paramBoolean));
    AppMethodBeat.o(119116);
  }
  
  public final void F(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(119112);
    d.g.b.k.h(parama, "onFakeDataUpdate");
    this.zwm = parama;
    AppMethodBeat.o(119112);
  }
  
  public final void a(final com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(119114);
    com.tencent.mm.ac.c.g((d.g.a.a)new b(this, paramk));
    AppMethodBeat.o(119114);
  }
  
  public final void b(final com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(119115);
    com.tencent.mm.ac.c.g((d.g.a.a)new g(this, paramk));
    AppMethodBeat.o(119115);
  }
  
  public final void checkPost()
  {
    AppMethodBeat.i(119111);
    Object localObject1 = com.tencent.mm.plugin.story.f.e.a.zuX;
    com.tencent.mm.plugin.story.f.e.a.dWC();
    localObject1 = com.tencent.mm.plugin.story.f.j.zsh;
    localObject1 = j.b.dVE().dZr();
    if (localObject1 == null)
    {
      ac.d("MicroMsg.StoryUploadTask", "All has post");
      AppMethodBeat.o(119111);
      return;
    }
    ac.d("MicroMsg.StoryUploadTask", "checking story from db, will post: " + ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID + ' ' + (int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid + ' ' + ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName + ' ' + ((com.tencent.mm.plugin.story.i.j)localObject1).dZk().gLY);
    Object localObject2 = new a((com.tencent.mm.plugin.story.i.j)localObject1, this.rMZ);
    this.rMY.b((com.tencent.mm.loader.g.c)localObject2);
    localObject2 = h.zAU;
    h.QI((int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid).jX(bs.eWj());
    localObject2 = h.zAU;
    h.QI((int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid).jZ(ax.iI(ai.getContext()));
    AppMethodBeat.o(119111);
  }
  
  public final void dWX()
  {
    AppMethodBeat.i(119113);
    d.g.a.a locala = this.zwm;
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
          aA(paramString.dwR, true);
          try
          {
            paramn = com.tencent.mm.plugin.story.f.j.zsh;
            paramn = j.b.dVE().QO(paramString.dwR);
            if (paramn != null)
            {
              h localh = h.zAU;
              h.QI(paramString.dwR).mQ(String.valueOf(paramn.field_storyID));
              localh = h.zAU;
              h.QI(paramString.dwR).mP(((ddy)paramn.dZi().FOc.Etz.get(0)).Url);
              paramn = h.zAU;
              h.QI(paramString.dwR).jY(bs.eWj());
              paramn = h.zAU;
              h.QJ(paramString.dwR);
              paramString = y.KTp;
              AppMethodBeat.o(119117);
              return;
            }
            AppMethodBeat.o(119117);
            return;
          }
          catch (Exception paramString)
          {
            ac.printErrStackTrace("MicroMsg.StoryUploadTask", (Throwable)paramString, "upload error", new Object[0]);
            paramString = y.KTp;
            AppMethodBeat.o(119117);
            return;
          }
        }
        aA(paramString.dwR, false);
      }
      AppMethodBeat.o(119117);
      return;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(c paramc, com.tencent.mm.plugin.story.api.k paramk)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(c paramc, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class f
    implements com.tencent.mm.loader.g.f<a>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(c paramc, com.tencent.mm.plugin.story.api.k paramk)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class h
    implements com.tencent.mm.loader.g.f<e>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.c
 * JD-Core Version:    0.7.0.1
 */
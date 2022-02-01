package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.ds;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import d.y;
import java.util.HashSet;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onFakeDataUpdateCallback", "Lkotlin/Function0;", "", "postCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1;", "uploadQueue", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "addFakeDataListener", "onFakeDataUpdate", "addPostEndListener", "listener", "checkMixStory", "checkPost", "notifyEndPost", "localId", "", "isOk", "", "notifyEventPost", "notifyStartPost", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFakeDataListener", "removePostEndListener", "start", "startPost", "stop", "Companion", "plugin-story_release"})
public final class c
  implements com.tencent.mm.al.g
{
  public static final a yjq;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  public com.tencent.mm.loader.g.d<a> qQX;
  public com.tencent.mm.loader.g.d<e> qQY;
  public d.g.a.a<y> yjn;
  public final f yjo;
  public final h yjp;
  
  static
  {
    AppMethodBeat.i(119119);
    yjq = new a((byte)0);
    AppMethodBeat.o(119119);
  }
  
  public c()
  {
    AppMethodBeat.i(119118);
    this.qQX = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "storyPost"));
    this.qQY = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.g(1, (byte)0), 1, "storyUpload"));
    this.yjo = new f(this);
    this.yjp = new h();
    this.listeners = new HashSet();
    AppMethodBeat.o(119118);
  }
  
  private final void ax(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(119116);
    com.tencent.mm.ad.c.g((d.g.a.a)new c(this, paramInt, paramBoolean));
    AppMethodBeat.o(119116);
  }
  
  public final void a(final com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(119114);
    com.tencent.mm.ad.c.g((d.g.a.a)new b(this, paramk));
    AppMethodBeat.o(119114);
  }
  
  public final void b(final com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(119115);
    com.tencent.mm.ad.c.g((d.g.a.a)new g(this, paramk));
    AppMethodBeat.o(119115);
  }
  
  public final void checkPost()
  {
    AppMethodBeat.i(119111);
    Object localObject1 = com.tencent.mm.plugin.story.f.e.a.yhX;
    com.tencent.mm.plugin.story.f.e.a.dIb();
    localObject1 = com.tencent.mm.plugin.story.f.j.yfh;
    localObject1 = j.b.dHd().dKQ();
    if (localObject1 == null)
    {
      ad.d("MicroMsg.StoryUploadTask", "All has post");
      AppMethodBeat.o(119111);
      return;
    }
    ad.d("MicroMsg.StoryUploadTask", "checking story from db, will post: " + ((com.tencent.mm.plugin.story.i.j)localObject1).field_storyID + ' ' + (int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid + ' ' + ((com.tencent.mm.plugin.story.i.j)localObject1).field_userName + ' ' + ((com.tencent.mm.plugin.story.i.j)localObject1).dKJ().gll);
    Object localObject2 = new a((com.tencent.mm.plugin.story.i.j)localObject1, this.qQY);
    this.qQX.b((com.tencent.mm.loader.g.c)localObject2);
    localObject2 = h.ynv;
    h.OC((int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid).gK(bt.eGO());
    localObject2 = h.ynv;
    h.OC((int)((com.tencent.mm.plugin.story.i.j)localObject1).systemRowid).gM(ay.ix(aj.getContext()));
    AppMethodBeat.o(119111);
  }
  
  public final void dIw()
  {
    AppMethodBeat.i(119113);
    d.g.a.a locala = this.yjn;
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
          ax(paramString.dzf, true);
          try
          {
            paramn = com.tencent.mm.plugin.story.f.j.yfh;
            paramn = j.b.dHd().OI(paramString.dzf);
            if (paramn != null)
            {
              h localh = h.ynv;
              h.OC(paramString.dzf).ka(String.valueOf(paramn.field_storyID));
              localh = h.ynv;
              h.OC(paramString.dzf).jZ(((cym)paramn.dKH().Era.DaC.get(0)).Url);
              paramn = h.ynv;
              h.OC(paramString.dzf).gL(bt.eGO());
              paramn = h.ynv;
              h.OD(paramString.dzf);
              paramString = y.JfV;
              AppMethodBeat.o(119117);
              return;
            }
            AppMethodBeat.o(119117);
            return;
          }
          catch (Exception paramString)
          {
            ad.printErrStackTrace("MicroMsg.StoryUploadTask", (Throwable)paramString, "upload error", new Object[0]);
            paramString = y.JfV;
            AppMethodBeat.o(119117);
            return;
          }
        }
        ax(paramString.dzf, false);
      }
      AppMethodBeat.o(119117);
      return;
    }
  }
  
  public final void z(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(119112);
    d.g.b.k.h(parama, "onFakeDataUpdate");
    this.yjn = parama;
    AppMethodBeat.o(119112);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/upload/UploadManager$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(c paramc, com.tencent.mm.plugin.story.api.k paramk)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(c paramc, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class f
    implements com.tencent.mm.loader.g.f<a>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(c paramc, com.tencent.mm.plugin.story.api.k paramk)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class h
    implements com.tencent.mm.loader.g.f<e>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.c
 * JD-Core Version:    0.7.0.1
 */
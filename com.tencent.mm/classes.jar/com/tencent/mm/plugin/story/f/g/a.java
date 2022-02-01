package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.p;
import com.tencent.mm.plugin.story.f.p.a;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import d.v;
import d.y;
import java.util.HashSet;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", "localId", "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", "clientId", "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"})
public final class a
  extends com.tencent.mm.loader.g.c
  implements com.tencent.mm.al.g
{
  public static final a yjf;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  private final d<e> qQY;
  private final g yjd;
  com.tencent.mm.plugin.story.i.j yje;
  
  static
  {
    AppMethodBeat.i(119094);
    yjf = new a((byte)0);
    AppMethodBeat.o(119094);
  }
  
  public a(com.tencent.mm.plugin.story.i.j paramj, d<e> paramd)
  {
    AppMethodBeat.i(119093);
    this.yje = paramj;
    this.qQY = paramd;
    this.yjd = new g();
    this.listeners = new HashSet();
    AppMethodBeat.o(119093);
  }
  
  private final void bW(int paramInt, String paramString)
  {
    AppMethodBeat.i(119091);
    ad.i("MicroMsg.StoryPostTask", "processError localId " + (int)this.yje.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    f localf = f.yjB;
    f.a(this.yje, paramInt, paramString, (d.g.a.a)new c(this));
    AppMethodBeat.o(119091);
  }
  
  private final cyn dIt()
  {
    AppMethodBeat.i(119087);
    Object localObject1 = new cyn().parseFrom(this.yje.field_postBuf);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
      AppMethodBeat.o(119087);
      throw ((Throwable)localObject1);
    }
    localObject1 = (cyn)localObject1;
    Object localObject2 = this.yje;
    byte[] arrayOfByte = ((cyn)localObject1).toByteArray();
    d.g.b.k.g(arrayOfByte, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject2).bE(arrayOfByte);
    localObject2 = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHd().a((int)this.yje.systemRowid, this.yje);
    AppMethodBeat.o(119087);
    return localObject1;
  }
  
  public final String abi()
  {
    AppMethodBeat.i(119090);
    int i = (int)this.yje.systemRowid;
    AppMethodBeat.o(119090);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119088);
    Object localObject1 = (cyn)com.tencent.mm.ad.c.a((com.tencent.mm.bx.a)new cyn(), this.yje.field_postBuf, (d.g.a.b)new b(this));
    Object localObject2;
    if (localObject1 != null)
    {
      if (com.tencent.mm.plugin.story.i.j.ay(((cyn)localObject1).gll, ((cyn)localObject1).DNs))
      {
        localObject2 = com.tencent.mm.plugin.story.i.a.yor;
        bW(com.tencent.mm.plugin.story.i.a.dKe(), "this item isTimeLimit");
        ad.i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + (int)this.yje.systemRowid + " is die count " + ((cyn)localObject1).gll + " time: " + ((cyn)localObject1).DNs);
        AppMethodBeat.o(119088);
        return;
      }
      int i = ((cyn)localObject1).DJF;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.yoI;
      if (i == com.tencent.mm.plugin.story.i.a.g.dKt())
      {
        localObject2 = dIt();
        if (com.tencent.mm.plugin.story.i.j.ay(((cyn)localObject2).gll, ((cyn)localObject2).DNs))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.yor;
          bW(com.tencent.mm.plugin.story.i.a.dKe(), "this item isTimeLimit");
          ad.i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + (int)this.yje.systemRowid + " is die ");
          AppMethodBeat.o(119088);
          return;
        }
        localObject1 = this.yje.dKH();
        p.a locala = p.yfx;
        localObject1 = p.a.a((czd)localObject1, ((cyn)localObject2).EqF);
        ad.i("MicroMsg.StoryPostTask", "startPost content " + (String)localObject1 + "  testValue " + ab.hWI);
        if (d.g.b.k.g(localObject1, ""))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.yor;
          bW(com.tencent.mm.plugin.story.i.a.dKd(), "content is error");
          AppMethodBeat.o(119088);
          return;
        }
        if (!ab.hWI) {
          break label395;
        }
        localObject1 = "<Test>Android Test Fail</Test>";
      }
    }
    label395:
    for (;;)
    {
      localObject2 = ((cyn)localObject2).gKn;
      d.g.b.k.g(localObject2, "postInfo.ClientId");
      com.tencent.mm.ad.c.g((d.g.a.a)new e(this, (String)localObject1, (String)localObject2));
      AppMethodBeat.o(119088);
      return;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.yoI;
      this.qQY.a((com.tencent.mm.loader.g.c)new e(this.yje), (com.tencent.mm.loader.g.f)new f(this));
      AppMethodBeat.o(119088);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(119089);
    paramString = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.aeS().b(351, (com.tencent.mm.al.g)this);
    a(h.gla);
    AppMethodBeat.o(119089);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/upload/PostTask$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Ljava/lang/Exception;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Exception, y>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(a parama, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(a parama, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/model/upload/PostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class f
    implements com.tencent.mm.loader.g.f<e>
  {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c>
  {
    public final void a(com.tencent.mm.loader.g.c paramc, h paramh)
    {
      AppMethodBeat.i(119086);
      d.g.b.k.h(paramc, "task");
      d.g.b.k.h(paramh, "status");
      AppMethodBeat.o(119086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.a
 * JD-Core Version:    0.7.0.1
 */
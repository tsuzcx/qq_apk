package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.p.a;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.v;
import d.z;
import java.util.HashSet;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", "localId", "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", "clientId", "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"})
public final class a
  extends com.tencent.mm.loader.g.c
  implements com.tencent.mm.al.f
{
  public static final a.a AOa;
  private final g ANY;
  com.tencent.mm.plugin.story.i.j ANZ;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  private final d<e> sJd;
  
  static
  {
    AppMethodBeat.i(119094);
    AOa = new a.a((byte)0);
    AppMethodBeat.o(119094);
  }
  
  public a(com.tencent.mm.plugin.story.i.j paramj, d<e> paramd)
  {
    AppMethodBeat.i(119093);
    this.ANZ = paramj;
    this.sJd = paramd;
    this.ANY = new g();
    this.listeners = new HashSet();
    AppMethodBeat.o(119093);
  }
  
  private final void ch(int paramInt, String paramString)
  {
    AppMethodBeat.i(119091);
    ad.i("MicroMsg.StoryPostTask", "processError localId " + (int)this.ANZ.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    f localf = f.AOw;
    f.a(this.ANZ, paramInt, paramString, (d.g.a.a)new c(this));
    AppMethodBeat.o(119091);
  }
  
  private final djm ejj()
  {
    AppMethodBeat.i(119087);
    Object localObject1 = new djm().parseFrom(this.ANZ.field_postBuf);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
      AppMethodBeat.o(119087);
      throw ((Throwable)localObject1);
    }
    localObject1 = (djm)localObject1;
    Object localObject2 = this.ANZ;
    byte[] arrayOfByte = ((djm)localObject1).toByteArray();
    d.g.b.p.g(arrayOfByte, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject2).bK(arrayOfByte);
    localObject2 = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehT().a((int)this.ANZ.systemRowid, this.ANZ);
    AppMethodBeat.o(119087);
    return localObject1;
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(119090);
    int i = (int)this.ANZ.systemRowid;
    AppMethodBeat.o(119090);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119088);
    Object localObject1 = (djm)com.tencent.mm.ad.c.a((com.tencent.mm.bx.a)new djm(), this.ANZ.field_postBuf, (d.g.a.b)new b(this));
    Object localObject2;
    if (localObject1 != null)
    {
      if (com.tencent.mm.plugin.story.i.j.aE(((djm)localObject1).hfV, ((djm)localObject1).GTk))
      {
        localObject2 = com.tencent.mm.plugin.story.i.a.ATp;
        ch(com.tencent.mm.plugin.story.i.a.ekU(), "this item isTimeLimit");
        ad.i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + (int)this.ANZ.systemRowid + " is die count " + ((djm)localObject1).hfV + " time: " + ((djm)localObject1).GTk);
        AppMethodBeat.o(119088);
        return;
      }
      int i = ((djm)localObject1).GPx;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.ATG;
      if (i == com.tencent.mm.plugin.story.i.a.g.elj())
      {
        localObject2 = ejj();
        if (com.tencent.mm.plugin.story.i.j.aE(((djm)localObject2).hfV, ((djm)localObject2).GTk))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.ATp;
          ch(com.tencent.mm.plugin.story.i.a.ekU(), "this item isTimeLimit");
          ad.i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + (int)this.ANZ.systemRowid + " is die ");
          AppMethodBeat.o(119088);
          return;
        }
        localObject1 = this.ANZ.elx();
        p.a locala = com.tencent.mm.plugin.story.f.p.AKr;
        localObject1 = p.a.a((dkc)localObject1, ((djm)localObject2).Hys);
        ad.i("MicroMsg.StoryPostTask", "startPost content " + (String)localObject1 + "  testValue " + ac.iPU);
        if (d.g.b.p.i(localObject1, ""))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.ATp;
          ch(com.tencent.mm.plugin.story.i.a.ekT(), "content is error");
          AppMethodBeat.o(119088);
          return;
        }
        if (!ac.iPU) {
          break label395;
        }
        localObject1 = "<Test>Android Test Fail</Test>";
      }
    }
    label395:
    for (;;)
    {
      localObject2 = ((djm)localObject2).hCW;
      d.g.b.p.g(localObject2, "postInfo.ClientId");
      com.tencent.mm.ad.c.g((d.g.a.a)new e(this, (String)localObject1, (String)localObject2));
      AppMethodBeat.o(119088);
      return;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.ATG;
      this.sJd.a((com.tencent.mm.loader.g.c)new e(this.ANZ), (com.tencent.mm.loader.g.f)new f(this));
      AppMethodBeat.o(119088);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(119089);
    paramString = g.ajB();
    d.g.b.p.g(paramString, "MMKernel.network()");
    paramString.aiU().b(351, (com.tencent.mm.al.f)this);
    a(com.tencent.mm.loader.g.j.hfK);
    AppMethodBeat.o(119089);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Ljava/lang/Exception;", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.b<Exception, z>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(a parama, int paramInt)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(a parama, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/model/upload/PostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class f
    implements com.tencent.mm.loader.g.f<e>
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c>
  {
    public final void a(com.tencent.mm.loader.g.c paramc, com.tencent.mm.loader.g.j paramj)
    {
      AppMethodBeat.i(119086);
      d.g.b.p.h(paramc, "task");
      d.g.b.p.h(paramj, "status");
      AppMethodBeat.o(119086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.a
 * JD-Core Version:    0.7.0.1
 */
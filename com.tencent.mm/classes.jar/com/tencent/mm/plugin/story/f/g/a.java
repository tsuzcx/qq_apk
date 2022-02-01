package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.p.a;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import d.v;
import d.z;
import java.util.HashSet;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", "localId", "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", "clientId", "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"})
public final class a
  extends com.tencent.mm.loader.g.c
  implements com.tencent.mm.ak.f
{
  public static final a.a BfB;
  com.tencent.mm.plugin.story.i.j BfA;
  private final g Bfz;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  private final d<e> sUq;
  
  static
  {
    AppMethodBeat.i(119094);
    BfB = new a.a((byte)0);
    AppMethodBeat.o(119094);
  }
  
  public a(com.tencent.mm.plugin.story.i.j paramj, d<e> paramd)
  {
    AppMethodBeat.i(119093);
    this.BfA = paramj;
    this.sUq = paramd;
    this.Bfz = new g();
    this.listeners = new HashSet();
    AppMethodBeat.o(119093);
  }
  
  private final void ch(int paramInt, String paramString)
  {
    AppMethodBeat.i(119091);
    ae.i("MicroMsg.StoryPostTask", "processError localId " + (int)this.BfA.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    f localf = f.BfX;
    f.a(this.BfA, paramInt, paramString, (d.g.a.a)new c(this));
    AppMethodBeat.o(119091);
  }
  
  private final dkh emR()
  {
    AppMethodBeat.i(119087);
    Object localObject1 = new dkh().parseFrom(this.BfA.field_postBuf);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
      AppMethodBeat.o(119087);
      throw ((Throwable)localObject1);
    }
    localObject1 = (dkh)localObject1;
    Object localObject2 = this.BfA;
    byte[] arrayOfByte = ((dkh)localObject1).toByteArray();
    d.g.b.p.g(arrayOfByte, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject2).bN(arrayOfByte);
    localObject2 = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elB().a((int)this.BfA.systemRowid, this.BfA);
    AppMethodBeat.o(119087);
    return localObject1;
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(119090);
    int i = (int)this.BfA.systemRowid;
    AppMethodBeat.o(119090);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119088);
    Object localObject1 = (dkh)com.tencent.mm.ac.c.a((com.tencent.mm.bw.a)new dkh(), this.BfA.field_postBuf, (d.g.a.b)new b(this));
    Object localObject2;
    if (localObject1 != null)
    {
      if (com.tencent.mm.plugin.story.i.j.aE(((dkh)localObject1).hiJ, ((dkh)localObject1).HmL))
      {
        localObject2 = com.tencent.mm.plugin.story.i.a.BkN;
        ch(com.tencent.mm.plugin.story.i.a.eoD(), "this item isTimeLimit");
        ae.i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + (int)this.BfA.systemRowid + " is die count " + ((dkh)localObject1).hiJ + " time: " + ((dkh)localObject1).HmL);
        AppMethodBeat.o(119088);
        return;
      }
      int i = ((dkh)localObject1).HiZ;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.Ble;
      if (i == com.tencent.mm.plugin.story.i.a.g.eoS())
      {
        localObject2 = emR();
        if (com.tencent.mm.plugin.story.i.j.aE(((dkh)localObject2).hiJ, ((dkh)localObject2).HmL))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.BkN;
          ch(com.tencent.mm.plugin.story.i.a.eoD(), "this item isTimeLimit");
          ae.i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + (int)this.BfA.systemRowid + " is die ");
          AppMethodBeat.o(119088);
          return;
        }
        localObject1 = this.BfA.epg();
        p.a locala = com.tencent.mm.plugin.story.f.p.BbU;
        localObject1 = p.a.a((dkx)localObject1, ((dkh)localObject2).HSd);
        ae.i("MicroMsg.StoryPostTask", "startPost content " + (String)localObject1 + "  testValue " + ac.iSN);
        if (d.g.b.p.i(localObject1, ""))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.BkN;
          ch(com.tencent.mm.plugin.story.i.a.eoC(), "content is error");
          AppMethodBeat.o(119088);
          return;
        }
        if (!ac.iSN) {
          break label395;
        }
        localObject1 = "<Test>Android Test Fail</Test>";
      }
    }
    label395:
    for (;;)
    {
      localObject2 = ((dkh)localObject2).hFO;
      d.g.b.p.g(localObject2, "postInfo.ClientId");
      com.tencent.mm.ac.c.h((d.g.a.a)new e(this, (String)localObject1, (String)localObject2));
      AppMethodBeat.o(119088);
      return;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.Ble;
      this.sUq.a((com.tencent.mm.loader.g.c)new e(this.BfA), (com.tencent.mm.loader.g.f)new f(this));
      AppMethodBeat.o(119088);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(119089);
    paramString = g.ajQ();
    d.g.b.p.g(paramString, "MMKernel.network()");
    paramString.ajj().b(351, (com.tencent.mm.ak.f)this);
    a(com.tencent.mm.loader.g.j.hiy);
    AppMethodBeat.o(119089);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Ljava/lang/Exception;", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.b<Exception, z>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(a parama, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    e(a parama, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/model/upload/PostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class f
    implements com.tencent.mm.loader.g.f<e>
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.p;
import com.tencent.mm.plugin.story.f.p.a;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import d.v;
import d.y;
import java.util.HashSet;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", "localId", "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", "clientId", "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"})
public final class a
  extends com.tencent.mm.loader.g.c
  implements com.tencent.mm.ak.g
{
  public static final a.a zwe;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  private final d<e> rMZ;
  private final g zwc;
  com.tencent.mm.plugin.story.i.j zwd;
  
  static
  {
    AppMethodBeat.i(119094);
    zwe = new a.a((byte)0);
    AppMethodBeat.o(119094);
  }
  
  public a(com.tencent.mm.plugin.story.i.j paramj, d<e> paramd)
  {
    AppMethodBeat.i(119093);
    this.zwd = paramj;
    this.rMZ = paramd;
    this.zwc = new g();
    this.listeners = new HashSet();
    AppMethodBeat.o(119093);
  }
  
  private final void ca(int paramInt, String paramString)
  {
    AppMethodBeat.i(119091);
    ac.i("MicroMsg.StoryPostTask", "processError localId " + (int)this.zwd.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    f localf = f.zwA;
    f.a(this.zwd, paramInt, paramString, (d.g.a.a)new c(this));
    AppMethodBeat.o(119091);
  }
  
  private final ddz dWU()
  {
    AppMethodBeat.i(119087);
    Object localObject1 = new ddz().parseFrom(this.zwd.field_postBuf);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
      AppMethodBeat.o(119087);
      throw ((Throwable)localObject1);
    }
    localObject1 = (ddz)localObject1;
    Object localObject2 = this.zwd;
    byte[] arrayOfByte = ((ddz)localObject1).toByteArray();
    d.g.b.k.g(arrayOfByte, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject2).bD(arrayOfByte);
    localObject2 = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVE().a((int)this.zwd.systemRowid, this.zwd);
    AppMethodBeat.o(119087);
    return localObject1;
  }
  
  public final String acg()
  {
    AppMethodBeat.i(119090);
    int i = (int)this.zwd.systemRowid;
    AppMethodBeat.o(119090);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119088);
    Object localObject1 = (ddz)com.tencent.mm.ac.c.a((com.tencent.mm.bw.a)new ddz(), this.zwd.field_postBuf, (d.g.a.b)new b(this));
    Object localObject2;
    if (localObject1 != null)
    {
      if (com.tencent.mm.plugin.story.i.j.ax(((ddz)localObject1).gLY, ((ddz)localObject1).FjJ))
      {
        localObject2 = com.tencent.mm.plugin.story.i.a.zBQ;
        ca(com.tencent.mm.plugin.story.i.a.dYF(), "this item isTimeLimit");
        ac.i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + (int)this.zwd.systemRowid + " is die count " + ((ddz)localObject1).gLY + " time: " + ((ddz)localObject1).FjJ);
        AppMethodBeat.o(119088);
        return;
      }
      int i = ((ddz)localObject1).FfT;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.zCh;
      if (i == com.tencent.mm.plugin.story.i.a.g.dYU())
      {
        localObject2 = dWU();
        if (com.tencent.mm.plugin.story.i.j.ax(((ddz)localObject2).gLY, ((ddz)localObject2).FjJ))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.zBQ;
          ca(com.tencent.mm.plugin.story.i.a.dYF(), "this item isTimeLimit");
          ac.i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + (int)this.zwd.systemRowid + " is die ");
          AppMethodBeat.o(119088);
          return;
        }
        localObject1 = this.zwd.dZi();
        p.a locala = p.zsx;
        localObject1 = p.a.a((dep)localObject1, ((ddz)localObject2).FNH);
        ac.i("MicroMsg.StoryPostTask", "startPost content " + (String)localObject1 + "  testValue " + ab.iwM);
        if (d.g.b.k.g(localObject1, ""))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.zBQ;
          ca(com.tencent.mm.plugin.story.i.a.dYE(), "content is error");
          AppMethodBeat.o(119088);
          return;
        }
        if (!ab.iwM) {
          break label395;
        }
        localObject1 = "<Test>Android Test Fail</Test>";
      }
    }
    label395:
    for (;;)
    {
      localObject2 = ((ddz)localObject2).hkN;
      d.g.b.k.g(localObject2, "postInfo.ClientId");
      com.tencent.mm.ac.c.g((d.g.a.a)new e(this, (String)localObject1, (String)localObject2));
      AppMethodBeat.o(119088);
      return;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.zCh;
      this.rMZ.a((com.tencent.mm.loader.g.c)new e(this.zwd), (com.tencent.mm.loader.g.f)new f(this));
      AppMethodBeat.o(119088);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(119089);
    paramString = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(paramString, "MMKernel.network()");
    paramString.agi().b(351, (com.tencent.mm.ak.g)this);
    a(h.gLN);
    AppMethodBeat.o(119089);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Ljava/lang/Exception;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Exception, y>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(a parama, int paramInt)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(a parama, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/model/upload/PostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class f
    implements com.tencent.mm.loader.g.f<e>
  {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.a
 * JD-Core Version:    0.7.0.1
 */
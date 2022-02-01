package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.p.a;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", "localId", "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", "clientId", "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"})
public final class a
  extends com.tencent.mm.loader.g.c
  implements i
{
  public static final a LKv;
  private final com.tencent.mm.loader.g.d<e> AAa;
  private final g LKt;
  com.tencent.mm.plugin.story.i.j LKu;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  
  static
  {
    AppMethodBeat.i(119094);
    LKv = new a((byte)0);
    AppMethodBeat.o(119094);
  }
  
  public a(com.tencent.mm.plugin.story.i.j paramj, com.tencent.mm.loader.g.d<e> paramd)
  {
    AppMethodBeat.i(119093);
    this.LKu = paramj;
    this.AAa = paramd;
    this.LKt = new g();
    this.listeners = new HashSet();
    AppMethodBeat.o(119093);
  }
  
  private final void cz(int paramInt, String paramString)
  {
    AppMethodBeat.i(119091);
    Log.i("MicroMsg.StoryPostTask", "processError localId " + (int)this.LKu.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    f localf = f.LKR;
    f.a(this.LKu, paramInt, paramString, (kotlin.g.a.a)new c(this));
    AppMethodBeat.o(119091);
  }
  
  private final env gdM()
  {
    AppMethodBeat.i(119087);
    Object localObject1 = new env().parseFrom(this.LKu.field_postBuf);
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
      AppMethodBeat.o(119087);
      throw ((Throwable)localObject1);
    }
    localObject1 = (env)localObject1;
    Object localObject2 = this.LKu;
    byte[] arrayOfByte = ((env)localObject1).toByteArray();
    kotlin.g.b.p.j(arrayOfByte, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject2).setPostBuf(arrayOfByte);
    localObject2 = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcw().a((int)this.LKu.systemRowid, this.LKu);
    AppMethodBeat.o(119087);
    return localObject1;
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(119090);
    int i = (int)this.LKu.systemRowid;
    AppMethodBeat.o(119090);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119088);
    Object localObject1 = (env)com.tencent.mm.ae.d.a((com.tencent.mm.cd.a)new env(), this.LKu.field_postBuf, (b)new b(this));
    Object localObject2;
    if (localObject1 != null)
    {
      if (com.tencent.mm.plugin.story.i.j.isTimeLimit(((env)localObject1).kQn, ((env)localObject1).TEf))
      {
        localObject2 = com.tencent.mm.plugin.story.i.a.LPG;
        cz(com.tencent.mm.plugin.story.i.a.gfz(), "this item isTimeLimit");
        Log.i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + (int)this.LKu.systemRowid + " is die count " + ((env)localObject1).kQn + " time: " + ((env)localObject1).TEf);
        AppMethodBeat.o(119088);
        return;
      }
      int i = ((env)localObject1).TAg;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.LPX;
      if (i == com.tencent.mm.plugin.story.i.a.g.gfO())
      {
        localObject2 = gdM();
        if (com.tencent.mm.plugin.story.i.j.isTimeLimit(((env)localObject2).kQn, ((env)localObject2).TEf))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.LPG;
          cz(com.tencent.mm.plugin.story.i.a.gfz(), "this item isTimeLimit");
          Log.i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + (int)this.LKu.systemRowid + " is die ");
          AppMethodBeat.o(119088);
          return;
        }
        localObject1 = this.LKu.ggc();
        p.a locala = com.tencent.mm.plugin.story.f.p.LGP;
        localObject1 = p.a.a((eol)localObject1, (env)localObject2);
        Log.i("MicroMsg.StoryPostTask", "startPost content " + (String)localObject1 + "  testValue " + ac.mGS);
        if (kotlin.g.b.p.h(localObject1, ""))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.LPG;
          cz(com.tencent.mm.plugin.story.i.a.gfy(), "content is error");
          AppMethodBeat.o(119088);
          return;
        }
        if (!ac.mGS) {
          break label398;
        }
        localObject1 = "<Test>Android Test Fail</Test>";
      }
    }
    label398:
    for (;;)
    {
      localObject2 = ((env)localObject2).lps;
      kotlin.g.b.p.j(localObject2, "postInfo.ClientId");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, (String)localObject1, (String)localObject2));
      AppMethodBeat.o(119088);
      return;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.LPX;
      this.AAa.a((com.tencent.mm.loader.g.c)new e(this.LKu), (com.tencent.mm.loader.g.f)new f(this));
      AppMethodBeat.o(119088);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(119089);
    paramString = h.aHF();
    kotlin.g.b.p.j(paramString, "MMKernel.network()");
    paramString.aGY().b(351, (i)this);
    a(com.tencent.mm.loader.g.j.kQd);
    AppMethodBeat.o(119089);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/upload/PostTask$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements b<Exception, x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(a parama, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(a parama, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/model/upload/PostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class f
    implements com.tencent.mm.loader.g.f<e>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c>
  {
    public final void a(com.tencent.mm.loader.g.c paramc, com.tencent.mm.loader.g.j paramj)
    {
      AppMethodBeat.i(119086);
      kotlin.g.b.p.k(paramc, "task");
      kotlin.g.b.p.k(paramj, "status");
      AppMethodBeat.o(119086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.a
 * JD-Core Version:    0.7.0.1
 */
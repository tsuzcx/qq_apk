package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.p.a;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", "localId", "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", "clientId", "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"})
public final class a
  extends c
  implements i
{
  public static final a Fqs;
  private final g Fqq;
  com.tencent.mm.plugin.story.i.j Fqr;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  private final com.tencent.mm.loader.g.d<e> vSA;
  
  static
  {
    AppMethodBeat.i(119094);
    Fqs = new a((byte)0);
    AppMethodBeat.o(119094);
  }
  
  public a(com.tencent.mm.plugin.story.i.j paramj, com.tencent.mm.loader.g.d<e> paramd)
  {
    AppMethodBeat.i(119093);
    this.Fqr = paramj;
    this.vSA = paramd;
    this.Fqq = new g();
    this.listeners = new HashSet();
    AppMethodBeat.o(119093);
  }
  
  private final void cy(int paramInt, String paramString)
  {
    AppMethodBeat.i(119091);
    Log.i("MicroMsg.StoryPostTask", "processError localId " + (int)this.Fqr.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    f localf = f.FqO;
    f.a(this.Fqr, paramInt, paramString, (kotlin.g.a.a)new c(this));
    AppMethodBeat.o(119091);
  }
  
  private final edu fps()
  {
    AppMethodBeat.i(119087);
    Object localObject1 = new edu().parseFrom(this.Fqr.field_postBuf);
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
      AppMethodBeat.o(119087);
      throw ((Throwable)localObject1);
    }
    localObject1 = (edu)localObject1;
    Object localObject2 = this.Fqr;
    byte[] arrayOfByte = ((edu)localObject1).toByteArray();
    kotlin.g.b.p.g(arrayOfByte, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject2).setPostBuf(arrayOfByte);
    localObject2 = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.foc().a((int)this.Fqr.systemRowid, this.Fqr);
    AppMethodBeat.o(119087);
    return localObject1;
  }
  
  public final String auK()
  {
    AppMethodBeat.i(119090);
    int i = (int)this.Fqr.systemRowid;
    AppMethodBeat.o(119090);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119088);
    Object localObject1 = (edu)com.tencent.mm.ac.d.a((com.tencent.mm.bw.a)new edu(), this.Fqr.field_postBuf, (kotlin.g.a.b)new b(this));
    Object localObject2;
    if (localObject1 != null)
    {
      if (com.tencent.mm.plugin.story.i.j.isTimeLimit(((edu)localObject1).ibG, ((edu)localObject1).MsZ))
      {
        localObject2 = com.tencent.mm.plugin.story.i.a.FvD;
        cy(com.tencent.mm.plugin.story.i.a.frd(), "this item isTimeLimit");
        Log.i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + (int)this.Fqr.systemRowid + " is die count " + ((edu)localObject1).ibG + " time: " + ((edu)localObject1).MsZ);
        AppMethodBeat.o(119088);
        return;
      }
      int i = ((edu)localObject1).Mpa;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.FvU;
      if (i == com.tencent.mm.plugin.story.i.a.g.frs())
      {
        localObject2 = fps();
        if (com.tencent.mm.plugin.story.i.j.isTimeLimit(((edu)localObject2).ibG, ((edu)localObject2).MsZ))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.FvD;
          cy(com.tencent.mm.plugin.story.i.a.frd(), "this item isTimeLimit");
          Log.i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + (int)this.Fqr.systemRowid + " is die ");
          AppMethodBeat.o(119088);
          return;
        }
        localObject1 = this.Fqr.frG();
        p.a locala = com.tencent.mm.plugin.story.f.p.FmN;
        localObject1 = p.a.a((eek)localObject1, (edu)localObject2);
        Log.i("MicroMsg.StoryPostTask", "startPost content " + (String)localObject1 + "  testValue " + ac.jPI);
        if (kotlin.g.b.p.j(localObject1, ""))
        {
          localObject1 = com.tencent.mm.plugin.story.i.a.FvD;
          cy(com.tencent.mm.plugin.story.i.a.frc(), "content is error");
          AppMethodBeat.o(119088);
          return;
        }
        if (!ac.jPI) {
          break label392;
        }
        localObject1 = "<Test>Android Test Fail</Test>";
      }
    }
    label392:
    for (;;)
    {
      localObject2 = ((edu)localObject2).izX;
      kotlin.g.b.p.g(localObject2, "postInfo.ClientId");
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new e(this, (String)localObject1, (String)localObject2));
      AppMethodBeat.o(119088);
      return;
      localObject1 = com.tencent.mm.plugin.story.i.a.g.FvU;
      this.vSA.a((c)new e(this.Fqr), (com.tencent.mm.loader.g.f)new f(this));
      AppMethodBeat.o(119088);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(119089);
    paramString = g.aAg();
    kotlin.g.b.p.g(paramString, "MMKernel.network()");
    paramString.azz().b(351, (i)this);
    a(com.tencent.mm.loader.g.j.ibw);
    AppMethodBeat.o(119089);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/upload/PostTask$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Exception, x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(a parama, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(a parama, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/upload/PostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class f
    implements com.tencent.mm.loader.g.f<e>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"})
  public static final class g
    implements com.tencent.mm.loader.g.f<c>
  {
    public final void a(c paramc, com.tencent.mm.loader.g.j paramj)
    {
      AppMethodBeat.i(119086);
      kotlin.g.b.p.h(paramc, "task");
      kotlin.g.b.p.h(paramj, "status");
      AppMethodBeat.o(119086);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.story.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.o;
import com.tencent.mm.plugin.story.model.o.a;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", "localId", "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", "clientId", "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.loader.f.c
  implements com.tencent.mm.am.h
{
  public static final a.a SnK;
  private final com.tencent.mm.loader.f.d<e> GbK;
  j SnL;
  private final a.g SnM;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  
  static
  {
    AppMethodBeat.i(119094);
    SnK = new a.a((byte)0);
    AppMethodBeat.o(119094);
  }
  
  public a(j paramj, com.tencent.mm.loader.f.d<e> paramd)
  {
    AppMethodBeat.i(119093);
    this.SnL = paramj;
    this.GbK = paramd;
    this.SnM = new a.g();
    this.listeners = new HashSet();
    AppMethodBeat.o(119093);
  }
  
  private final void dm(int paramInt, String paramString)
  {
    AppMethodBeat.i(119091);
    Log.i("MicroMsg.StoryPostTask", "processError localId " + (int)this.SnL.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    f localf = f.Soi;
    f.a(this.SnL, paramInt, paramString, (kotlin.g.a.a)new c(this));
    AppMethodBeat.o(119091);
  }
  
  private final fit hxg()
  {
    AppMethodBeat.i(119087);
    Object localObject1 = new fit().parseFrom(this.SnL.field_postBuf);
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
      AppMethodBeat.o(119087);
      throw ((Throwable)localObject1);
    }
    localObject1 = (fit)localObject1;
    Object localObject2 = this.SnL;
    byte[] arrayOfByte = ((fit)localObject1).toByteArray();
    kotlin.g.b.s.s(arrayOfByte, "postInfo.toByteArray()");
    ((j)localObject2).setPostBuf(arrayOfByte);
    localObject2 = StoryCore.SjP;
    StoryCore.b.hvR().a((int)this.SnL.systemRowid, this.SnL);
    AppMethodBeat.o(119087);
    return localObject1;
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(119090);
    int i = (int)this.SnL.systemRowid;
    AppMethodBeat.o(119090);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119088);
    Object localObject1 = com.tencent.mm.ae.d.a((com.tencent.mm.bx.a)new fit(), this.SnL.field_postBuf, (b)new b(this));
    Object localObject2;
    if ((fit)localObject1 != null)
    {
      if (j.isTimeLimit(((fit)localObject1).nrQ, ((fit)localObject1).aaTL))
      {
        localObject2 = com.tencent.mm.plugin.story.h.a.Sry;
        dm(com.tencent.mm.plugin.story.h.a.hyR(), "this item isTimeLimit");
        Log.i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + (int)this.SnL.systemRowid + " is die count " + ((fit)localObject1).nrQ + " time: " + ((fit)localObject1).aaTL);
        AppMethodBeat.o(119088);
        return;
      }
      int i = ((fit)localObject1).aaPu;
      localObject1 = com.tencent.mm.plugin.story.h.a.g.SsG;
      if (i == com.tencent.mm.plugin.story.h.a.g.hzg())
      {
        localObject2 = hxg();
        if (j.isTimeLimit(((fit)localObject2).nrQ, ((fit)localObject2).aaTL))
        {
          localObject1 = com.tencent.mm.plugin.story.h.a.Sry;
          dm(com.tencent.mm.plugin.story.h.a.hyR(), "this item isTimeLimit");
          Log.i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + (int)this.SnL.systemRowid + " is die ");
          AppMethodBeat.o(119088);
          return;
        }
        localObject1 = this.SnL.hzt();
        o.a locala = o.Skt;
        localObject1 = o.a.a((fjj)localObject1, (fit)localObject2);
        Log.i("MicroMsg.StoryPostTask", "startPost content " + (String)localObject1 + "  testValue " + z.pDs);
        if (kotlin.g.b.s.p(localObject1, ""))
        {
          localObject1 = com.tencent.mm.plugin.story.h.a.Sry;
          dm(com.tencent.mm.plugin.story.h.a.hyQ(), "content is error");
          AppMethodBeat.o(119088);
          return;
        }
        if (!z.pDs) {
          break label413;
        }
        localObject1 = "<Test>Android Test Fail</Test>";
      }
    }
    label413:
    for (;;)
    {
      localObject2 = ((fit)localObject2).nUv;
      kotlin.g.b.s.s(localObject2, "postInfo.ClientId");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, (String)localObject1, (String)localObject2));
      AppMethodBeat.o(119088);
      return;
      localObject1 = com.tencent.mm.plugin.story.h.a.g.SsG;
      this.GbK.a((com.tencent.mm.loader.f.c)new e(this.SnL), (com.tencent.mm.loader.f.e)new f(this));
      AppMethodBeat.o(119088);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(119089);
    com.tencent.mm.kernel.h.baD().mCm.b(351, (com.tencent.mm.am.h)this);
    a(i.nrG);
    AppMethodBeat.o(119089);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Exception, ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(a parama, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(a parama, String paramString1, String paramString2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/model/upload/PostTask$tryPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.loader.f.e<e>
  {
    f(a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.a
 * JD-Core Version:    0.7.0.1
 */
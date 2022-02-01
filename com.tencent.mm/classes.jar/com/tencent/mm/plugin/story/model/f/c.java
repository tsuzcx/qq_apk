package com.tencent.mm.plugin.story.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.mmdata.rpt.pe;
import com.tencent.mm.loader.f.a.f;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onFakeDataUpdateCallback", "Lkotlin/Function0;", "", "postCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1;", "uploadQueue", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "addFakeDataListener", "onFakeDataUpdate", "addPostEndListener", "listener", "checkMixStory", "checkPost", "notifyEndPost", "localId", "", "isOk", "", "notifyEventPost", "notifyStartPost", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFakeDataListener", "removePostEndListener", "start", "startPost", "stop", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.am.h
{
  public static final c.a SnU;
  public com.tencent.mm.loader.f.d<e> GbK;
  public kotlin.g.a.a<ah> SnV;
  public final f SnW;
  public final h SnX;
  private final HashSet<com.tencent.mm.plugin.story.api.k> listeners;
  public com.tencent.mm.loader.f.d<a> nry;
  
  static
  {
    AppMethodBeat.i(119119);
    SnU = new c.a((byte)0);
    AppMethodBeat.o(119119);
  }
  
  public c()
  {
    AppMethodBeat.i(119118);
    this.nry = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "storyPost"));
    this.GbK = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new f((com.tencent.mm.loader.f.a.c)new com.tencent.mm.loader.f.a.a(100), new com.tencent.mm.loader.f.a.g(1, (byte)0), 1, "storyUpload"));
    this.SnW = new f(this);
    this.SnX = new h();
    this.listeners = new HashSet();
    AppMethodBeat.o(119118);
  }
  
  private final void bR(final int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(119116);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this, paramInt, paramBoolean));
    AppMethodBeat.o(119116);
  }
  
  public final void a(com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(119114);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramk, this));
    AppMethodBeat.o(119114);
  }
  
  public final void b(com.tencent.mm.plugin.story.api.k paramk)
  {
    AppMethodBeat.i(119115);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(paramk, this));
    AppMethodBeat.o(119115);
  }
  
  public final void bN(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(119112);
    s.u(parama, "onFakeDataUpdate");
    this.SnV = parama;
    AppMethodBeat.o(119112);
  }
  
  public final void checkPost()
  {
    AppMethodBeat.i(119111);
    Object localObject1 = com.tencent.mm.plugin.story.model.e.a.SmE;
    com.tencent.mm.plugin.story.model.e.a.hwP();
    localObject1 = StoryCore.SjP;
    localObject1 = StoryCore.b.hvR().hzC();
    if (localObject1 == null)
    {
      Log.d("MicroMsg.StoryUploadTask", "All has post");
      AppMethodBeat.o(119111);
      return;
    }
    Log.d("MicroMsg.StoryUploadTask", "checking story from db, will post: " + ((j)localObject1).field_storyID + ' ' + (int)((j)localObject1).systemRowid + ' ' + ((j)localObject1).field_userName + ' ' + ((j)localObject1).hzv().nrQ);
    Object localObject2 = new a((j)localObject1, this.GbK);
    this.nry.c((com.tencent.mm.loader.f.c)localObject2);
    localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.anp((int)((j)localObject1).systemRowid).jlo = Util.nowMilliSecond();
    localObject2 = com.tencent.mm.plugin.story.g.h.SqZ;
    com.tencent.mm.plugin.story.g.h.anp((int)((j)localObject1).systemRowid).jlD = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
    AppMethodBeat.o(119111);
  }
  
  public final void hxj()
  {
    AppMethodBeat.i(119113);
    kotlin.g.a.a locala = this.SnV;
    if (locala != null) {
      locala.invoke();
    }
    AppMethodBeat.o(119113);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(119117);
    if ((paramp instanceof com.tencent.mm.plugin.story.model.a.g)) {
      paramString = (com.tencent.mm.plugin.story.model.a.g)paramp;
    }
    while (paramString != null)
    {
      if ((paramInt1 == 4) || (paramInt2 == 0))
      {
        bR(paramString.icg, true);
        try
        {
          paramp = StoryCore.SjP;
          paramp = StoryCore.b.hvR().anv(paramString.icg);
          if (paramp != null)
          {
            Object localObject = com.tencent.mm.plugin.story.g.h.SqZ;
            localObject = com.tencent.mm.plugin.story.g.h.anp(paramString.icg);
            ((pe)localObject).jjT = ((pe)localObject).F("Tid", String.valueOf(paramp.field_storyID), true);
            localObject = com.tencent.mm.plugin.story.g.h.SqZ;
            localObject = com.tencent.mm.plugin.story.g.h.anp(paramString.icg);
            ((pe)localObject).jlm = ((pe)localObject).F("FileUrl", ((fis)paramp.hzt().abJZ.Zpr.get(0)).Url, true);
            paramp = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.anp(paramString.icg).jlp = Util.nowMilliSecond();
            paramp = com.tencent.mm.plugin.story.g.h.SqZ;
            com.tencent.mm.plugin.story.g.h.anq(paramString.icg);
            paramString = ah.aiuX;
          }
          AppMethodBeat.o(119117);
          return;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.StoryUploadTask", (Throwable)paramString, "upload error", new Object[0]);
          paramString = ah.aiuX;
          AppMethodBeat.o(119117);
          return;
        }
        paramString = null;
        continue;
      }
      bR(paramString.icg, false);
    }
    AppMethodBeat.o(119117);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(com.tencent.mm.plugin.story.api.k paramk, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(c paramc, int paramInt, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(c paramc, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.loader.f.e<a>
  {
    f(c paramc) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(com.tencent.mm.plugin.story.api.k paramk, c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.loader.f.e<e>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.c
 * JD-Core Version:    0.7.0.1
 */
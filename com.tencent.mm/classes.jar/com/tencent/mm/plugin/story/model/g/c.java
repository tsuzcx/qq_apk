package com.tencent.mm.plugin.story.model.g;

import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.b.a.bh;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/upload/UploadManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onFakeDataUpdateCallback", "Lkotlin/Function0;", "", "postCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$postCallback$1;", "postQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/UploadManager$uploadCallback$1;", "uploadQueue", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "addFakeDataListener", "onFakeDataUpdate", "addPostEndListener", "listener", "checkMixStory", "checkPost", "notifyEndPost", "localId", "", "isOk", "", "notifyEventPost", "notifyStartPost", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFakeDataListener", "removePostEndListener", "start", "startPost", "stop", "Companion", "plugin-story_release"})
public final class c
  implements f
{
  public static final c.a sAf;
  private final HashSet<com.tencent.mm.plugin.story.api.j> listeners;
  public com.tencent.mm.loader.g.d<a> sAb;
  public a.f.a.a<y> sAc;
  public final c.f sAd;
  public final c.h sAe;
  public com.tencent.mm.loader.g.d<e> szR;
  
  static
  {
    AppMethodBeat.i(109466);
    sAf = new c.a((byte)0);
    AppMethodBeat.o(109466);
  }
  
  public c()
  {
    AppMethodBeat.i(109465);
    this.sAb = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new g((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.h(1, (byte)0), 1, "storyPost"));
    this.szR = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new g((com.tencent.mm.loader.g.a.c)new com.tencent.mm.loader.g.a.a(100), new com.tencent.mm.loader.g.a.h(1, (byte)0), 1, "storyUpload"));
    this.sAd = new c.f(this);
    this.sAe = new c.h();
    this.listeners = new HashSet();
    AppMethodBeat.o(109465);
  }
  
  private final void aj(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(109463);
    b.b((a.f.a.a)new c.c(this, paramInt, paramBoolean));
    AppMethodBeat.o(109463);
  }
  
  private static void cCh()
  {
    AppMethodBeat.i(109458);
    com.tencent.mm.plugin.story.proxy.c.a locala = com.tencent.mm.plugin.story.proxy.c.sDq;
    com.tencent.mm.plugin.story.proxy.c.a.cCy().cCx();
    AppMethodBeat.o(109458);
  }
  
  public final void a(final com.tencent.mm.plugin.story.api.j paramj)
  {
    AppMethodBeat.i(109461);
    b.b((a.f.a.a)new b(this, paramj));
    AppMethodBeat.o(109461);
  }
  
  public final void b(com.tencent.mm.plugin.story.api.j paramj)
  {
    AppMethodBeat.i(109462);
    b.b((a.f.a.a)new c.g(this, paramj));
    AppMethodBeat.o(109462);
  }
  
  public final void cCi()
  {
    AppMethodBeat.i(109460);
    a.f.a.a locala = this.sAc;
    if (locala != null)
    {
      locala.invoke();
      AppMethodBeat.o(109460);
      return;
    }
    AppMethodBeat.o(109460);
  }
  
  public final void checkPost()
  {
    AppMethodBeat.i(109457);
    cCh();
    Object localObject1 = com.tencent.mm.plugin.story.model.j.svi;
    localObject1 = j.b.cAB().cFj();
    if (localObject1 == null)
    {
      ab.d("MicroMsg.StoryUploadTask", "All has post");
      AppMethodBeat.o(109457);
      return;
    }
    ab.d("MicroMsg.StoryUploadTask", "checking story from db, will post: " + ((com.tencent.mm.plugin.story.h.j)localObject1).field_storyID + ' ' + (int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid + ' ' + ((com.tencent.mm.plugin.story.h.j)localObject1).field_userName + ' ' + ((com.tencent.mm.plugin.story.h.j)localObject1).cFb().ePG);
    Object localObject2 = new a((com.tencent.mm.plugin.story.h.j)localObject1, this.szR);
    this.sAb.b((com.tencent.mm.loader.g.c)localObject2);
    localObject2 = i.sFa;
    i.FV((int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid).dp(bo.aoy());
    localObject2 = i.sFa;
    i.FV((int)((com.tencent.mm.plugin.story.h.j)localObject1).systemRowid).dH(at.gV(ah.getContext()));
    AppMethodBeat.o(109457);
  }
  
  public final void h(a.f.a.a<y> parama)
  {
    AppMethodBeat.i(109459);
    a.f.b.j.q(parama, "onFakeDataUpdate");
    this.sAc = parama;
    AppMethodBeat.o(109459);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(109464);
    if (!(paramm instanceof com.tencent.mm.plugin.story.model.a.h)) {}
    for (paramString = null;; paramString = paramm)
    {
      paramString = (com.tencent.mm.plugin.story.model.a.h)paramString;
      if (paramString != null)
      {
        if ((paramInt1 == 4) || (paramInt2 == 0))
        {
          aj(paramString.cIp, true);
          try
          {
            paramm = com.tencent.mm.plugin.story.model.j.svi;
            paramm = j.b.cAB().Gb(paramString.cIp);
            if (paramm != null)
            {
              i locali = i.sFa;
              i.FV(paramString.cIp).gD(String.valueOf(paramm.field_storyID));
              locali = i.sFa;
              i.FV(paramString.cIp).gB(((chl)paramm.cEY().xSK.wOa.get(0)).Url);
              paramm = i.sFa;
              i.FV(paramString.cIp).dq(bo.aoy());
              paramm = i.sFa;
              i.FW(paramString.cIp);
              paramString = y.BMg;
              AppMethodBeat.o(109464);
              return;
            }
            AppMethodBeat.o(109464);
            return;
          }
          catch (Exception paramString)
          {
            ab.printErrStackTrace("MicroMsg.StoryUploadTask", (Throwable)paramString, "upload error", new Object[0]);
            paramString = y.BMg;
            AppMethodBeat.o(109464);
            return;
          }
        }
        aj(paramString.cIp, false);
      }
      AppMethodBeat.o(109464);
      return;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class b
    extends a.f.b.k
    implements a.f.a.a<y>
  {
    b(c paramc, com.tencent.mm.plugin.story.api.j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.g.c
 * JD-Core Version:    0.7.0.1
 */
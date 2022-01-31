package com.tencent.mm.plugin.story.model.g;

import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.p.a;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/upload/PostTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "uploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;Lcom/tencent/mm/loader/loader/LoaderCore;)V", "listeners", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "uploadCallback", "com/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1", "Lcom/tencent/mm/plugin/story/model/upload/PostTask$uploadCallback$1;", "call", "", "notifyError", "errType", "", "errMsg", "", "mediaLocalId", "notifyEventUI", "localId", "isOk", "", "onSceneEnd", "errCode", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reLoadPostInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "startPost", "storyPost", "content", "clientId", "tryPost", "postInfo", "uniqueId", "Companion", "plugin-story_release"})
public final class a
  extends c
  implements com.tencent.mm.ai.f
{
  public static final a.a szS;
  private final HashSet<com.tencent.mm.plugin.story.api.j> listeners;
  private final a.g szP;
  com.tencent.mm.plugin.story.h.j szQ;
  private final d<e> szR;
  
  static
  {
    AppMethodBeat.i(109440);
    szS = new a.a((byte)0);
    AppMethodBeat.o(109440);
  }
  
  public a(com.tencent.mm.plugin.story.h.j paramj, d<e> paramd)
  {
    AppMethodBeat.i(109439);
    this.szQ = paramj;
    this.szR = paramd;
    this.szP = new a.g();
    this.listeners = new HashSet();
    AppMethodBeat.o(109439);
  }
  
  private final void bk(int paramInt, String paramString)
  {
    AppMethodBeat.i(109437);
    ab.i("MicroMsg.StoryPostTask", "processError localId " + (int)this.szQ.systemRowid + " processError " + paramInt + " errMsg: " + paramString);
    f localf = f.sAp;
    f.a(this.szQ, paramInt, paramString, (a.f.a.a)new a.c(this));
    AppMethodBeat.o(109437);
  }
  
  private final chm cCe()
  {
    AppMethodBeat.i(109433);
    Object localObject1 = new chm().parseFrom(this.szQ.field_postBuf);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryMediaPostInfo");
      AppMethodBeat.o(109433);
      throw ((Throwable)localObject1);
    }
    localObject1 = (chm)localObject1;
    Object localObject2 = this.szQ;
    byte[] arrayOfByte = ((chm)localObject1).toByteArray();
    a.f.b.j.p(arrayOfByte, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.h.j)localObject2).bl(arrayOfByte);
    localObject2 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAB().a((int)this.szQ.systemRowid, this.szQ);
    AppMethodBeat.o(109433);
    return localObject1;
  }
  
  public final String Oy()
  {
    AppMethodBeat.i(109436);
    int i = (int)this.szQ.systemRowid;
    AppMethodBeat.o(109436);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(109434);
    Object localObject1 = (chm)com.tencent.mm.ab.b.a((com.tencent.mm.bv.a)new chm(), this.szQ.field_postBuf, (a.f.a.b)new a.b(this));
    Object localObject2;
    if (localObject1 != null)
    {
      if (com.tencent.mm.plugin.story.h.j.ag(((chm)localObject1).ePG, ((chm)localObject1).xst))
      {
        localObject2 = com.tencent.mm.plugin.story.h.a.sFV;
        bk(com.tencent.mm.plugin.story.h.a.cEl(), "this item isTimeLimit");
        ab.i("MicroMsg.StoryPostTask", "StoryInfo localId it time limit " + (int)this.szQ.systemRowid + " is die count " + ((chm)localObject1).ePG + " time: " + ((chm)localObject1).xst);
        AppMethodBeat.o(109434);
        return;
      }
      int i = ((chm)localObject1).nkT;
      localObject1 = com.tencent.mm.plugin.story.h.a.g.sGo;
      if (i == com.tencent.mm.plugin.story.h.a.g.cEG())
      {
        localObject2 = cCe();
        if (com.tencent.mm.plugin.story.h.j.ag(((chm)localObject2).ePG, ((chm)localObject2).xst))
        {
          localObject1 = com.tencent.mm.plugin.story.h.a.sFV;
          bk(com.tencent.mm.plugin.story.h.a.cEl(), "this item isTimeLimit");
          ab.i("MicroMsg.StoryPostTask", "storyInfo localId it time limit " + (int)this.szQ.systemRowid + " is die ");
          AppMethodBeat.o(109434);
          return;
        }
        localObject1 = this.szQ.cEY();
        p.a locala = com.tencent.mm.plugin.story.model.p.svy;
        localObject1 = p.a.a((cic)localObject1, ((chm)localObject2).xSr);
        ab.i("MicroMsg.StoryPostTask", "startPost content " + (String)localObject1 + "  testValue " + ae.glL);
        if (a.f.b.j.e(localObject1, ""))
        {
          localObject1 = com.tencent.mm.plugin.story.h.a.sFV;
          bk(com.tencent.mm.plugin.story.h.a.cEk(), "content is error");
          AppMethodBeat.o(109434);
          return;
        }
        if (!ae.glL) {
          break label395;
        }
        localObject1 = "<Test>Android Test Fail</Test>";
      }
    }
    label395:
    for (;;)
    {
      localObject2 = ((chm)localObject2).pIw;
      a.f.b.j.p(localObject2, "postInfo.ClientId");
      com.tencent.mm.ab.b.b((a.f.a.a)new a.e(this, (String)localObject1, (String)localObject2));
      AppMethodBeat.o(109434);
      return;
      localObject1 = com.tencent.mm.plugin.story.h.a.g.sGo;
      this.szR.a((c)new e(this.szQ), (com.tencent.mm.loader.g.f)new a.f(this));
      AppMethodBeat.o(109434);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(109435);
    paramString = g.RK();
    a.f.b.j.p(paramString, "MMKernel.network()");
    paramString.Rc().b(351, (com.tencent.mm.ai.f)this);
    a(h.ePv);
    AppMethodBeat.o(109435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.g.a
 * JD-Core Version:    0.7.0.1
 */
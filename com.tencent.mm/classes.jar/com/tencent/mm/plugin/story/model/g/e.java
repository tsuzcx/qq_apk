package com.tencent.mm.plugin.story.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.g.b.a.ay;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.plugin.story.h.a.g;
import com.tencent.mm.plugin.story.h.k;
import com.tencent.mm.plugin.story.image2video.d;
import com.tencent.mm.plugin.story.model.g.a;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.plugin.story.model.s;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "MicroMsg.StoryUploadTask";
  public static final e.a sAl;
  private com.tencent.mm.plugin.story.h.j szQ;
  
  static
  {
    AppMethodBeat.i(109482);
    sAl = new e.a((byte)0);
    TAG = "MicroMsg.StoryUploadTask";
    AppMethodBeat.o(109482);
  }
  
  public e(com.tencent.mm.plugin.story.h.j paramj)
  {
    AppMethodBeat.i(109481);
    this.szQ = paramj;
    AppMethodBeat.o(109481);
  }
  
  public final String Oy()
  {
    AppMethodBeat.i(109480);
    int i = (int)this.szQ.systemRowid;
    AppMethodBeat.o(109480);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(109479);
    Object localObject3 = this.szQ.cFb();
    Object localObject4 = (chl)this.szQ.cEY().xSK.wOa.get(0);
    Object localObject1 = com.tencent.mm.plugin.story.model.l.svv;
    localObject1 = com.tencent.mm.plugin.story.model.l.acY(((chl)localObject4).Id);
    Object localObject2 = com.tencent.mm.plugin.story.model.l.svv;
    localObject2 = com.tencent.mm.plugin.story.model.l.acX(((chl)localObject4).Id);
    int i = ((chm)localObject3).nkT;
    Object localObject5 = a.g.sGo;
    if (i == a.g.cEG())
    {
      a(com.tencent.mm.loader.g.h.ePv);
      AppMethodBeat.o(109479);
      return;
    }
    if (((chm)localObject3).ePG > 5)
    {
      localObject1 = f.sAp;
      f.a(this.szQ, -1, "", (a.f.a.a)e.b.sAm);
      a(com.tencent.mm.loader.g.h.ePw);
      AppMethodBeat.o(109479);
      return;
    }
    if (com.tencent.mm.vfs.e.avI((String)localObject1) < 0L)
    {
      localObject1 = f.sAp;
      f.a(this.szQ, -1, "", (a.f.a.a)e.c.sAn);
      a(com.tencent.mm.loader.g.h.ePw);
      AppMethodBeat.o(109479);
      return;
    }
    localObject5 = a.g.sGo;
    ((chm)localObject3).nkT = a.g.cEI();
    localObject5 = this.szQ;
    Object localObject6 = ((chm)localObject3).toByteArray();
    a.f.b.j.p(localObject6, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.h.j)localObject5).bl((byte[])localObject6);
    localObject5 = com.tencent.mm.plugin.story.model.j.svi;
    j.b.cAB().a((int)this.szQ.systemRowid, this.szQ);
    localObject5 = s.swk;
    localObject4 = s.a((chl)localObject4);
    boolean bool1;
    long l;
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSp, 0) == 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (ab.getLogLevel() >= 0)
      {
        bool2 = bool1;
        if (d.ssY) {
          bool2 = true;
        }
      }
      ab.i(TAG, "checkRemuxVideo isImageVideo:%s, enable:%s", new Object[] { Boolean.valueOf(((chm)localObject3).xSt), Boolean.valueOf(bool2) });
      if (((chm)localObject3).xSt)
      {
        localObject5 = i.sFa;
        i.cDC().cz(System.currentTimeMillis());
        localObject5 = i.sFa;
        localObject5 = i.cDC();
        if (!bool2) {
          break label832;
        }
        l = 1L;
        label372:
        ((ay)localObject5).cA(l);
      }
      if ((!((chm)localObject3).xSt) || (!bool2))
      {
        localObject5 = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class);
        a.f.b.j.p(localObject5, "MMKernel.service<IConfig…onfigService::class.java)");
        if (bo.getInt(((com.tencent.mm.plugin.zero.b.a)localObject5).Nq().getValue("StoryCheckSendVideoBitrateExceed"), 0) != 1) {
          break label965;
        }
      }
      if (bo.isNullOrNil((String)localObject4)) {
        break label965;
      }
      ab.i(TAG, "checkRemuxVideo, filePath:".concat(String.valueOf(localObject4)));
      if (((chm)localObject3).xSt)
      {
        localObject5 = com.tencent.mm.plugin.story.g.e.sEw;
        com.tencent.mm.plugin.story.g.e.cCP();
      }
      localObject6 = (c.a)com.tencent.mm.plugin.story.c.a.c.srQ.Uw();
      if (localObject4 == null) {
        a.f.b.j.ebi();
      }
      if (!((c.a)localObject6).acF((String)localObject4)) {
        break label956;
      }
      ab.i(TAG, "checkRemuxVideo, exceed bitrate:".concat(String.valueOf(localObject4)));
      if (((chm)localObject3).xSt)
      {
        localObject5 = com.tencent.mm.plugin.story.g.e.sEw;
        com.tencent.mm.plugin.story.g.e.cCN();
        localObject5 = i.sFa;
        i.cDC().FD();
      }
      localObject5 = com.tencent.mm.plugin.story.g.h.sEz;
      com.tencent.mm.plugin.story.g.h.cDg();
      ((c.a)localObject6).acE((String)localObject4);
      localObject5 = (String)localObject4 + ".remux";
      ab.i(TAG, "remux outputFilepath:".concat(String.valueOf(localObject5)));
      l = bo.yB();
      i = SightVideoJNI.remuxing((String)localObject4, (String)localObject5, ((c.a)localObject6).eRu, ((c.a)localObject6).eRv, ((c.a)localObject6).videoBitrate, com.tencent.mm.plugin.sight.base.b.qSp, 8, 2, 25.0F, ((c.a)localObject6).eRw, null, 0, com.tencent.mm.plugin.sight.base.b.qSo, 0, 51);
      ab.i(TAG, "checkRemuxVideo remux cost:" + bo.av(l) + "ms, ret:" + i);
      if (i < 0) {
        break label838;
      }
      if (((chm)localObject3).xSt)
      {
        l = bo.av(l);
        localObject3 = com.tencent.mm.plugin.story.g.e.sEw;
        com.tencent.mm.plugin.story.g.e.cCO();
        localObject3 = com.tencent.mm.plugin.story.g.e.sEw;
        com.tencent.mm.plugin.story.g.e.mK(l);
        localObject3 = i.sFa;
        i.cDC().gK(i);
        localObject3 = i.sFa;
        i.cDC().cB(l);
        localObject3 = i.sFa;
        i.cDD();
      }
      com.tencent.mm.vfs.e.aT((String)localObject5, (String)localObject4);
    }
    for (;;)
    {
      for (i = 0;; i = 1)
      {
        if (i == 0)
        {
          localObject3 = i.sFa;
          i.cDy().bE(System.currentTimeMillis());
          new b(this.szQ, (String)localObject1, (String)localObject2, (g.a)new d(this)).cCg();
        }
        AppMethodBeat.o(109479);
        return;
        bool1 = false;
        break;
        label832:
        l = 0L;
        break label372;
        label838:
        if (((chm)localObject3).xSt)
        {
          localObject4 = com.tencent.mm.plugin.story.g.e.sEw;
          com.tencent.mm.plugin.story.g.e.cCM();
          localObject4 = i.sFa;
          i.cDC().gK(i);
          localObject4 = i.sFa;
          i.cDD();
        }
        ((chm)localObject3).ePG += 1;
        localObject4 = this.szQ;
        localObject3 = ((chm)localObject3).toByteArray();
        a.f.b.j.p(localObject3, "postInfo.toByteArray()");
        ((com.tencent.mm.plugin.story.h.j)localObject4).bl((byte[])localObject3);
        localObject3 = com.tencent.mm.plugin.story.model.j.svi;
        j.b.cAB().a((int)this.szQ.systemRowid, this.szQ);
        com.tencent.mm.vfs.e.deleteFile((String)localObject5);
        a(com.tencent.mm.loader.g.h.ePw);
      }
      label956:
      ab.i(TAG, "checkRemuxVideo, no need remux");
      label965:
      if (((chm)localObject3).xSt)
      {
        localObject3 = i.sFa;
        i.cDD();
      }
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", "errorCode", "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"})
  public static final class d
    implements g.a
  {
    public final void a(int paramInt, boolean paramBoolean, com.tencent.mm.plugin.story.model.g paramg)
    {
      AppMethodBeat.i(109478);
      a.f.b.j.q(paramg, "upload");
      paramg = i.sFa;
      i.cDy().bF(paramInt);
      paramg = i.sFa;
      paramg = i.cDy();
      long l = System.currentTimeMillis();
      i locali = i.sFa;
      paramg.bE(l - i.cDy().Fq());
      paramg = i.sFa;
      i.cDz();
      if (paramBoolean)
      {
        this.sAo.a(com.tencent.mm.loader.g.h.ePv);
        AppMethodBeat.o(109478);
        return;
      }
      this.sAo.a(com.tencent.mm.loader.g.h.ePw);
      AppMethodBeat.o(109478);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.g.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.db;
import com.tencent.mm.g.b.a.dj;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.czd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "MicroMsg.StoryUploadTask";
  public static final a yjx;
  private com.tencent.mm.plugin.story.i.j yje;
  
  static
  {
    AppMethodBeat.i(119137);
    yjx = new a((byte)0);
    TAG = "MicroMsg.StoryUploadTask";
    AppMethodBeat.o(119137);
  }
  
  public e(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119136);
    this.yje = paramj;
    AppMethodBeat.o(119136);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(119135);
    int i = (int)this.yje.systemRowid;
    AppMethodBeat.o(119135);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119134);
    Object localObject3 = this.yje.dKJ();
    Object localObject4 = (cym)this.yje.dKH().Era.DaC.get(0);
    Object localObject1 = com.tencent.mm.plugin.story.f.l.yfu;
    localObject1 = com.tencent.mm.plugin.story.f.l.art(((cym)localObject4).Id);
    Object localObject2 = com.tencent.mm.plugin.story.f.l.yfu;
    localObject2 = com.tencent.mm.plugin.story.f.l.ars(((cym)localObject4).Id);
    int i = ((cyn)localObject3).DJF;
    Object localObject5 = a.g.yoI;
    if (i == a.g.dKt())
    {
      a(com.tencent.mm.loader.g.h.gla);
      AppMethodBeat.o(119134);
      return;
    }
    if (((cyn)localObject3).gll > 5)
    {
      localObject1 = f.yjB;
      f.a(this.yje, -1, "", (d.g.a.a)e.b.yjy);
      a(com.tencent.mm.loader.g.h.glb);
      AppMethodBeat.o(119134);
      return;
    }
    if (i.aMN((String)localObject1) < 0L)
    {
      localObject1 = f.yjB;
      f.a(this.yje, -1, "", (d.g.a.a)e.c.yjz);
      a(com.tencent.mm.loader.g.h.glb);
      AppMethodBeat.o(119134);
      return;
    }
    localObject5 = a.g.yoI;
    ((cyn)localObject3).DJF = a.g.dKv();
    localObject5 = this.yje;
    Object localObject6 = ((cyn)localObject3).toByteArray();
    d.g.b.k.g(localObject6, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject5).bE((byte[])localObject6);
    localObject5 = com.tencent.mm.plugin.story.f.j.yfh;
    j.b.dHd().a((int)this.yje.systemRowid, this.yje);
    localObject5 = s.ygj;
    localObject4 = s.a((cym)localObject4);
    boolean bool1;
    long l;
    label385:
    int m;
    int i2;
    int j;
    int k;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pjJ, 0) == 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (ad.getLogLevel() >= 0)
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.vgG;
        bool2 = bool1;
        if (com.tencent.mm.plugin.recordvideo.b.e.dhp()) {
          bool2 = true;
        }
      }
      ad.i(TAG, "checkRemuxVideo isImageVideo:%s, enable:%s", new Object[] { Boolean.valueOf(((cyn)localObject3).EqH), Boolean.valueOf(bool2) });
      if (((cyn)localObject3).EqH)
      {
        localObject5 = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.dJv().fU(System.currentTimeMillis());
        localObject5 = com.tencent.mm.plugin.story.h.h.ynv;
        localObject5 = com.tencent.mm.plugin.story.h.h.dJv();
        if (!bool2) {
          break label1341;
        }
        l = 1L;
        ((dj)localObject5).fV(l);
      }
      if ((!((cyn)localObject3).EqH) || (!bool2) || (com.tencent.mm.plugin.story.c.c.isEnable()))
      {
        localObject5 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
        d.g.b.k.g(localObject5, "MMKernel.service<IConfig…onfigService::class.java)");
        if (bt.getInt(((com.tencent.mm.plugin.zero.b.a)localObject5).Zd().getValue("StoryCheckSendVideoBitrateExceed"), 0) != 1) {
          break label1752;
        }
      }
      if (bt.isNullOrNil((String)localObject4)) {
        break label1752;
      }
      ad.i(TAG, "checkRemuxVideo, filePath:".concat(String.valueOf(localObject4)));
      if (((cyn)localObject3).EqH)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.ymU;
        com.tencent.mm.plugin.story.h.d.dIX();
      }
      localObject6 = (c.a)com.tencent.mm.plugin.story.c.a.c.ydE.ajp();
      if (localObject4 == null) {
        d.g.b.k.fvU();
      }
      if (!((c.a)localObject6).arg((String)localObject4)) {
        break label1743;
      }
      ad.i(TAG, "checkRemuxVideo, exceed bitrate:".concat(String.valueOf(localObject4)));
      if (((cyn)localObject3).EqH)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.ymU;
        com.tencent.mm.plugin.story.h.d.dIV();
        localObject5 = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.dJv().QQ();
      }
      localObject5 = com.tencent.mm.plugin.story.h.g.ymX;
      com.tencent.mm.plugin.story.h.g.dJh();
      d.g.b.k.h(localObject4, "path");
      ad.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile: ".concat(String.valueOf(localObject4)));
      localObject5 = com.tencent.mm.plugin.sight.base.e.ano((String)localObject4);
      if (localObject5 == null) {
        break label1347;
      }
      i1 = ((com.tencent.mm.plugin.sight.base.a)localObject5).width;
      n = ((com.tencent.mm.plugin.sight.base.a)localObject5).height;
      m = ((com.tencent.mm.plugin.sight.base.a)localObject5).videoBitrate;
      i2 = ((com.tencent.mm.plugin.sight.base.a)localObject5).frameRate;
      if (n > 0)
      {
        i = n;
        j = i1;
        k = m;
        if (i1 > 0) {}
      }
      else
      {
        i = n;
        j = i1;
        k = m;
      }
    }
    try
    {
      localObject5 = new com.tencent.mm.compatible.h.d();
      i = n;
      j = i1;
      k = m;
      ((com.tencent.mm.compatible.h.d)localObject5).setDataSource((String)localObject4);
      i = n;
      j = i1;
      k = m;
      i1 = bt.getInt(((com.tencent.mm.compatible.h.d)localObject5).extractMetadata(18), 0);
      i = n;
      j = i1;
      k = m;
      n = bt.getInt(((com.tencent.mm.compatible.h.d)localObject5).extractMetadata(19), 0);
      i = n;
      j = i1;
      k = m;
      m = bt.getInt(((com.tencent.mm.compatible.h.d)localObject5).extractMetadata(20), 0);
      i = n;
      j = i1;
      k = m;
      ((com.tencent.mm.compatible.h.d)localObject5).release();
      k = m;
      j = i1;
      i = n;
    }
    catch (Exception localException)
    {
      label798:
      break label798;
    }
    int n = i2;
    if (i2 <= 0)
    {
      localObject5 = com.tencent.mm.plugin.story.c.a.c.ydE;
      n = com.tencent.mm.plugin.story.c.a.c.arf((String)localObject4);
    }
    int i1 = SightVideoJNI.getMp4RotateVFS((String)localObject4);
    ad.i("MicroMsg.IEncodeConfig", "videoWidth: " + j + " , videoHeight :" + i + "  , videoBitrate:" + k + " ,videoBitrate " + ((c.a)localObject6).videoBitrate + ", videoFrameRate:" + n + " , videoRotate : " + i1);
    if (k < ((c.a)localObject6).videoBitrate) {
      ((c.a)localObject6).videoBitrate = k;
    }
    if ((i1 == 90) || (i1 == 270))
    {
      m = i;
      k = j;
      if (i > ((c.a)localObject6).gnh)
      {
        m = i;
        k = j;
        if (i - ((c.a)localObject6).gnh > 16)
        {
          k = (int)(((c.a)localObject6).gnh / i * j);
          m = ((c.a)localObject6).gnh;
        }
      }
      label997:
      i = m;
      if (m % 16 != 0) {
        i = com.tencent.mm.plugin.mmsight.d.GN(m);
      }
      j = k;
      if (k % 16 != 0) {
        j = com.tencent.mm.plugin.mmsight.d.GN(k);
      }
      if (((c.a)localObject6).frameRate > n) {
        ((c.a)localObject6).frameRate = n;
      }
      ((c.a)localObject6).gni = i;
      ((c.a)localObject6).gnh = j;
      ((c.a)localObject6).gta = i1;
      label1070:
      localObject5 = (String)localObject4 + ".remux";
      ad.i(TAG, "remux outputFilepath:".concat(String.valueOf(localObject5)));
      l = bt.GC();
      i = SightVideoJNI.remuxingVFS((String)localObject4, (String)localObject5, ((c.a)localObject6).gnh, ((c.a)localObject6).gni, ((c.a)localObject6).videoBitrate, com.tencent.mm.plugin.sight.base.c.wra, 8, 2, 25.0F, ((c.a)localObject6).frameRate, null, 0, com.tencent.mm.plugin.sight.base.c.wqZ, 0, 51);
      ad.i(TAG, "checkRemuxVideo remux cost:" + bt.aS(l) + "ms, ret:" + i);
      if (i < 0) {
        break label1625;
      }
      if (((cyn)localObject3).EqH)
      {
        l = bt.aS(l);
        localObject3 = com.tencent.mm.plugin.story.h.d.ymU;
        com.tencent.mm.plugin.story.h.d.dIW();
        localObject3 = com.tencent.mm.plugin.story.h.d.ymU;
        com.tencent.mm.plugin.story.h.d.tN(l);
        localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.dJv().iD(i);
        localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.dJv().fW(l);
        localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.dJw();
      }
      i.lD((String)localObject5, (String)localObject4);
    }
    for (;;)
    {
      for (i = 0;; i = 1)
      {
        if (i == 0)
        {
          localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJt().fg(System.currentTimeMillis());
          new b(this.yje, (String)localObject1, (String)localObject2, (g.a)new d(this)).dIv();
        }
        AppMethodBeat.o(119134);
        return;
        bool1 = false;
        break;
        label1341:
        l = 0L;
        break label385;
        label1347:
        com.tencent.mm.plugin.recordvideo.b.e.vgG.dhq();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.vgG;
        ((c.a)localObject6).gnh = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.vgG;
        ((c.a)localObject6).gni = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.vgG;
        ((c.a)localObject6).frameRate = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
        float f1 = 1.0F;
        bool1 = com.tencent.mm.plugin.story.c.c.isEnable();
        if (!bool1)
        {
          float f2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pnY, 2.0F);
          f1 = f2;
          if (f2 <= 1.0F) {
            f1 = 1.0F;
          }
        }
        ((c.a)localObject6).videoBitrate = ((int)(((c.a)localObject6).videoBitrate * f1));
        ((c.a)localObject6).gta = 0;
        ad.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile imageVideo, config:" + ((c.a)localObject6).gnh + ", " + ((c.a)localObject6).gni + ", " + ((c.a)localObject6).frameRate + ", " + ((c.a)localObject6).gta + ", " + ((c.a)localObject6).videoBitrate + ", " + f1 + ", " + bool1);
        break label1070;
        m = i;
        k = j;
        if (j <= ((c.a)localObject6).gnh) {
          break label997;
        }
        m = i;
        k = j;
        if (j - ((c.a)localObject6).gnh <= 16) {
          break label997;
        }
        f1 = ((c.a)localObject6).gnh / j;
        m = (int)(i * f1);
        k = ((c.a)localObject6).gnh;
        break label997;
        label1625:
        if (((cyn)localObject3).EqH)
        {
          localObject4 = com.tencent.mm.plugin.story.h.d.ymU;
          com.tencent.mm.plugin.story.h.d.dIU();
          localObject4 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJv().iD(i);
          localObject4 = com.tencent.mm.plugin.story.h.h.ynv;
          com.tencent.mm.plugin.story.h.h.dJw();
        }
        ((cyn)localObject3).gll += 1;
        localObject4 = this.yje;
        localObject3 = ((cyn)localObject3).toByteArray();
        d.g.b.k.g(localObject3, "postInfo.toByteArray()");
        ((com.tencent.mm.plugin.story.i.j)localObject4).bE((byte[])localObject3);
        localObject3 = com.tencent.mm.plugin.story.f.j.yfh;
        j.b.dHd().a((int)this.yje.systemRowid, this.yje);
        i.deleteFile((String)localObject5);
        a(com.tencent.mm.loader.g.h.glb);
      }
      label1743:
      ad.i(TAG, "checkRemuxVideo, no need remux");
      label1752:
      if (((cyn)localObject3).EqH)
      {
        localObject3 = com.tencent.mm.plugin.story.h.h.ynv;
        com.tencent.mm.plugin.story.h.h.dJw();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", "errorCode", "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"})
  public static final class d
    implements g.a
  {
    public final void a(int paramInt, boolean paramBoolean, com.tencent.mm.plugin.story.f.g paramg)
    {
      AppMethodBeat.i(119133);
      d.g.b.k.h(paramg, "upload");
      paramg = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJt().fh(paramInt);
      paramg = com.tencent.mm.plugin.story.h.h.ynv;
      paramg = com.tencent.mm.plugin.story.h.h.dJt();
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ynv;
      paramg.fg(l - com.tencent.mm.plugin.story.h.h.dJt().Qq());
      paramg = com.tencent.mm.plugin.story.h.h.ynv;
      com.tencent.mm.plugin.story.h.h.dJu();
      if (paramBoolean)
      {
        this.yjA.a(com.tencent.mm.loader.g.h.gla);
        AppMethodBeat.o(119133);
        return;
      }
      this.yjA.a(com.tencent.mm.loader.g.h.glb);
      AppMethodBeat.o(119133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.e
 * JD-Core Version:    0.7.0.1
 */
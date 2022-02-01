package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fo;
import com.tencent.mm.g.b.a.fw;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import java.util.LinkedList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.loader.g.c
{
  public static final e.a AOs;
  private static final String TAG = "MicroMsg.StoryUploadTask";
  private com.tencent.mm.plugin.story.i.j ANZ;
  
  static
  {
    AppMethodBeat.i(119137);
    AOs = new e.a((byte)0);
    TAG = "MicroMsg.StoryUploadTask";
    AppMethodBeat.o(119137);
  }
  
  public e(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119136);
    this.ANZ = paramj;
    AppMethodBeat.o(119136);
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(119135);
    int i = (int)this.ANZ.systemRowid;
    AppMethodBeat.o(119135);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119134);
    Object localObject3 = this.ANZ.elz();
    Object localObject4 = (djl)this.ANZ.elx().HyN.GaQ.get(0);
    Object localObject1 = com.tencent.mm.plugin.story.f.l.AKo;
    localObject1 = com.tencent.mm.plugin.story.f.l.aBH(((djl)localObject4).Id);
    Object localObject2 = com.tencent.mm.plugin.story.f.l.AKo;
    localObject2 = com.tencent.mm.plugin.story.f.l.aBG(((djl)localObject4).Id);
    int i = ((djm)localObject3).GPx;
    Object localObject5 = a.g.ATG;
    if (i == a.g.elj())
    {
      a(com.tencent.mm.loader.g.j.hfK);
      AppMethodBeat.o(119134);
      return;
    }
    if (((djm)localObject3).hfV > 5)
    {
      localObject1 = f.AOw;
      f.a(this.ANZ, -1, "", (d.g.a.a)e.b.AOt);
      a(com.tencent.mm.loader.g.j.hfL);
      AppMethodBeat.o(119134);
      return;
    }
    if (i.aYo((String)localObject1) < 0L)
    {
      localObject1 = f.AOw;
      f.a(this.ANZ, -1, "", (d.g.a.a)e.c.AOu);
      a(com.tencent.mm.loader.g.j.hfL);
      AppMethodBeat.o(119134);
      return;
    }
    localObject5 = a.g.ATG;
    ((djm)localObject3).GPx = a.g.ell();
    localObject5 = this.ANZ;
    Object localObject6 = ((djm)localObject3).toByteArray();
    p.g(localObject6, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject5).bK((byte[])localObject6);
    localObject5 = com.tencent.mm.plugin.story.f.j.AKb;
    j.b.ehT().a((int)this.ANZ.systemRowid, this.ANZ);
    localObject5 = s.ALd;
    localObject4 = s.a((djl)localObject4);
    boolean bool1;
    long l;
    label385:
    int m;
    int i2;
    int j;
    int k;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qqX, 0) == 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (ad.getLogLevel() >= 0)
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.xxi;
        bool2 = bool1;
        if (com.tencent.mm.plugin.recordvideo.b.e.dFq()) {
          bool2 = true;
        }
      }
      ad.i(TAG, "checkRemuxVideo isImageVideo:%s, enable:%s", new Object[] { Boolean.valueOf(((djm)localObject3).Hyu), Boolean.valueOf(bool2) });
      if (((djm)localObject3).Hyu)
      {
        localObject5 = h.ASt;
        h.ekl().kT(System.currentTimeMillis());
        localObject5 = h.ASt;
        localObject5 = h.ekl();
        if (!bool2) {
          break label1341;
        }
        l = 1L;
        ((fw)localObject5).kU(l);
      }
      if ((!((djm)localObject3).Hyu) || (!bool2) || (com.tencent.mm.plugin.story.c.c.isEnable()))
      {
        localObject5 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
        p.g(localObject5, "MMKernel.service<IConfig…onfigService::class.java)");
        if (bt.getInt(((com.tencent.mm.plugin.zero.b.a)localObject5).acA().getValue("StoryCheckSendVideoBitrateExceed"), 0) != 1) {
          break label1752;
        }
      }
      if (bt.isNullOrNil((String)localObject4)) {
        break label1752;
      }
      ad.i(TAG, "checkRemuxVideo, filePath:".concat(String.valueOf(localObject4)));
      if (((djm)localObject3).Hyu)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.ARS;
        com.tencent.mm.plugin.story.h.d.ejN();
      }
      localObject6 = (c.a)com.tencent.mm.plugin.story.c.a.c.AIy.ate();
      if (localObject4 == null) {
        p.gfZ();
      }
      if (!((c.a)localObject6).aBu((String)localObject4)) {
        break label1743;
      }
      ad.i(TAG, "checkRemuxVideo, exceed bitrate:".concat(String.valueOf(localObject4)));
      if (((djm)localObject3).Hyu)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.ARS;
        com.tencent.mm.plugin.story.h.d.ejL();
        localObject5 = h.ASt;
        h.ekl().Tz();
      }
      localObject5 = com.tencent.mm.plugin.story.h.g.ARV;
      com.tencent.mm.plugin.story.h.g.ejX();
      p.h(localObject4, "path");
      ad.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile: ".concat(String.valueOf(localObject4)));
      localObject5 = com.tencent.mm.plugin.sight.base.e.axx((String)localObject4);
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
      localObject5 = com.tencent.mm.plugin.story.c.a.c.AIy;
      n = com.tencent.mm.plugin.story.c.a.c.aBt((String)localObject4);
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
      if (i > ((c.a)localObject6).targetWidth)
      {
        m = i;
        k = j;
        if (i - ((c.a)localObject6).targetWidth > 16)
        {
          k = (int)(((c.a)localObject6).targetWidth / i * j);
          m = ((c.a)localObject6).targetWidth;
        }
      }
      label997:
      i = m;
      if (m % 16 != 0) {
        i = com.tencent.mm.plugin.mmsight.d.Kg(m);
      }
      j = k;
      if (k % 16 != 0) {
        j = com.tencent.mm.plugin.mmsight.d.Kg(k);
      }
      if (((c.a)localObject6).frameRate > n) {
        ((c.a)localObject6).frameRate = n;
      }
      ((c.a)localObject6).targetHeight = i;
      ((c.a)localObject6).targetWidth = j;
      ((c.a)localObject6).hlJ = i1;
      label1070:
      localObject5 = (String)localObject4 + ".remux";
      ad.i(TAG, "remux outputFilepath:".concat(String.valueOf(localObject5)));
      l = bt.HI();
      i = SightVideoJNI.remuxingVFS((String)localObject4, (String)localObject5, ((c.a)localObject6).targetWidth, ((c.a)localObject6).targetHeight, ((c.a)localObject6).videoBitrate, com.tencent.mm.plugin.sight.base.c.yRb, 8, 2, 25.0F, ((c.a)localObject6).frameRate, null, 0, com.tencent.mm.plugin.sight.base.c.yRa, 0, 51);
      ad.i(TAG, "checkRemuxVideo remux cost:" + bt.aO(l) + "ms, ret:" + i);
      if (i < 0) {
        break label1625;
      }
      if (((djm)localObject3).Hyu)
      {
        l = bt.aO(l);
        localObject3 = com.tencent.mm.plugin.story.h.d.ARS;
        com.tencent.mm.plugin.story.h.d.ejM();
        localObject3 = com.tencent.mm.plugin.story.h.d.ARS;
        com.tencent.mm.plugin.story.h.d.AO(l);
        localObject3 = h.ASt;
        h.ekl().iK(i);
        localObject3 = h.ASt;
        h.ekl().kV(l);
        localObject3 = h.ASt;
        h.ekm();
      }
      i.mA((String)localObject5, (String)localObject4);
    }
    for (;;)
    {
      for (i = 0;; i = 1)
      {
        if (i == 0)
        {
          localObject3 = h.ASt;
          h.ekj().kf(System.currentTimeMillis());
          new b(this.ANZ, (String)localObject1, (String)localObject2, (g.a)new d(this)).ejl();
        }
        AppMethodBeat.o(119134);
        return;
        bool1 = false;
        break;
        label1341:
        l = 0L;
        break label385;
        label1347:
        com.tencent.mm.plugin.recordvideo.b.e.xxi.dFr();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.xxi;
        ((c.a)localObject6).targetWidth = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.xxi;
        ((c.a)localObject6).targetHeight = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.xxi;
        ((c.a)localObject6).frameRate = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
        float f1 = 1.0F;
        bool1 = com.tencent.mm.plugin.story.c.c.isEnable();
        if (!bool1)
        {
          float f2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qvV, 2.0F);
          f1 = f2;
          if (f2 <= 1.0F) {
            f1 = 1.0F;
          }
        }
        ((c.a)localObject6).videoBitrate = ((int)(((c.a)localObject6).videoBitrate * f1));
        ((c.a)localObject6).hlJ = 0;
        ad.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile imageVideo, config:" + ((c.a)localObject6).targetWidth + ", " + ((c.a)localObject6).targetHeight + ", " + ((c.a)localObject6).frameRate + ", " + ((c.a)localObject6).hlJ + ", " + ((c.a)localObject6).videoBitrate + ", " + f1 + ", " + bool1);
        break label1070;
        m = i;
        k = j;
        if (j <= ((c.a)localObject6).targetWidth) {
          break label997;
        }
        m = i;
        k = j;
        if (j - ((c.a)localObject6).targetWidth <= 16) {
          break label997;
        }
        f1 = ((c.a)localObject6).targetWidth / j;
        m = (int)(i * f1);
        k = ((c.a)localObject6).targetWidth;
        break label997;
        label1625:
        if (((djm)localObject3).Hyu)
        {
          localObject4 = com.tencent.mm.plugin.story.h.d.ARS;
          com.tencent.mm.plugin.story.h.d.ejK();
          localObject4 = h.ASt;
          h.ekl().iK(i);
          localObject4 = h.ASt;
          h.ekm();
        }
        ((djm)localObject3).hfV += 1;
        localObject4 = this.ANZ;
        localObject3 = ((djm)localObject3).toByteArray();
        p.g(localObject3, "postInfo.toByteArray()");
        ((com.tencent.mm.plugin.story.i.j)localObject4).bK((byte[])localObject3);
        localObject3 = com.tencent.mm.plugin.story.f.j.AKb;
        j.b.ehT().a((int)this.ANZ.systemRowid, this.ANZ);
        i.deleteFile((String)localObject5);
        a(com.tencent.mm.loader.g.j.hfL);
      }
      label1743:
      ad.i(TAG, "checkRemuxVideo, no need remux");
      label1752:
      if (((djm)localObject3).Hyu)
      {
        localObject3 = h.ASt;
        h.ekm();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", "errorCode", "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"})
  public static final class d
    implements g.a
  {
    public final void a(int paramInt, boolean paramBoolean, com.tencent.mm.plugin.story.f.g paramg)
    {
      AppMethodBeat.i(119133);
      p.h(paramg, "upload");
      paramg = h.ASt;
      h.ekj().kg(paramInt);
      paramg = h.ASt;
      paramg = h.ekj();
      long l = System.currentTimeMillis();
      h localh = h.ASt;
      paramg.kf(l - h.ekj().SZ());
      paramg = h.ASt;
      h.ekk();
      if (paramBoolean)
      {
        this.AOv.a(com.tencent.mm.loader.g.j.hfK);
        AppMethodBeat.o(119133);
        return;
      }
      this.AOv.a(com.tencent.mm.loader.g.j.hfL);
      AppMethodBeat.o(119133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.e
 * JD-Core Version:    0.7.0.1
 */
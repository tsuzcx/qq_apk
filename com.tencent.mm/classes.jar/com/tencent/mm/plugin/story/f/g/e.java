package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.g.b.a.ex;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "MicroMsg.StoryUploadTask";
  public static final e.a zww;
  private com.tencent.mm.plugin.story.i.j zwd;
  
  static
  {
    AppMethodBeat.i(119137);
    zww = new e.a((byte)0);
    TAG = "MicroMsg.StoryUploadTask";
    AppMethodBeat.o(119137);
  }
  
  public e(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119136);
    this.zwd = paramj;
    AppMethodBeat.o(119136);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(119135);
    int i = (int)this.zwd.systemRowid;
    AppMethodBeat.o(119135);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119134);
    Object localObject3 = this.zwd.dZk();
    Object localObject4 = (ddy)this.zwd.dZi().FOc.Etz.get(0);
    Object localObject1 = com.tencent.mm.plugin.story.f.l.zsu;
    localObject1 = com.tencent.mm.plugin.story.f.l.awC(((ddy)localObject4).Id);
    Object localObject2 = com.tencent.mm.plugin.story.f.l.zsu;
    localObject2 = com.tencent.mm.plugin.story.f.l.awB(((ddy)localObject4).Id);
    int i = ((ddz)localObject3).FfT;
    Object localObject5 = a.g.zCh;
    if (i == a.g.dYU())
    {
      a(com.tencent.mm.loader.g.h.gLN);
      AppMethodBeat.o(119134);
      return;
    }
    if (((ddz)localObject3).gLY > 5)
    {
      localObject1 = f.zwA;
      f.a(this.zwd, -1, "", (d.g.a.a)e.b.zwx);
      a(com.tencent.mm.loader.g.h.gLO);
      AppMethodBeat.o(119134);
      return;
    }
    if (i.aSp((String)localObject1) < 0L)
    {
      localObject1 = f.zwA;
      f.a(this.zwd, -1, "", (d.g.a.a)e.c.zwy);
      a(com.tencent.mm.loader.g.h.gLO);
      AppMethodBeat.o(119134);
      return;
    }
    localObject5 = a.g.zCh;
    ((ddz)localObject3).FfT = a.g.dYW();
    localObject5 = this.zwd;
    Object localObject6 = ((ddz)localObject3).toByteArray();
    d.g.b.k.g(localObject6, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject5).bD((byte[])localObject6);
    localObject5 = com.tencent.mm.plugin.story.f.j.zsh;
    j.b.dVE().a((int)this.zwd.systemRowid, this.zwd);
    localObject5 = s.ztj;
    localObject4 = s.a((ddy)localObject4);
    boolean bool1;
    long l;
    label385:
    int m;
    int i2;
    int j;
    int k;
    if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pNa, 0) == 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (ac.getLogLevel() >= 0)
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.wps;
        bool2 = bool1;
        if (com.tencent.mm.plugin.recordvideo.b.e.duV()) {
          bool2 = true;
        }
      }
      ac.i(TAG, "checkRemuxVideo isImageVideo:%s, enable:%s", new Object[] { Boolean.valueOf(((ddz)localObject3).FNJ), Boolean.valueOf(bool2) });
      if (((ddz)localObject3).FNJ)
      {
        localObject5 = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXW().jh(System.currentTimeMillis());
        localObject5 = com.tencent.mm.plugin.story.h.h.zAU;
        localObject5 = com.tencent.mm.plugin.story.h.h.dXW();
        if (!bool2) {
          break label1341;
        }
        l = 1L;
        ((ex)localObject5).ji(l);
      }
      if ((!((ddz)localObject3).FNJ) || (!bool2) || (com.tencent.mm.plugin.story.c.c.isEnable()))
      {
        localObject5 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
        d.g.b.k.g(localObject5, "MMKernel.service<IConfig…onfigService::class.java)");
        if (bs.getInt(((com.tencent.mm.plugin.zero.b.a)localObject5).ZY().getValue("StoryCheckSendVideoBitrateExceed"), 0) != 1) {
          break label1752;
        }
      }
      if (bs.isNullOrNil((String)localObject4)) {
        break label1752;
      }
      ac.i(TAG, "checkRemuxVideo, filePath:".concat(String.valueOf(localObject4)));
      if (((ddz)localObject3).FNJ)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.zAt;
        com.tencent.mm.plugin.story.h.d.dXy();
      }
      localObject6 = (c.a)com.tencent.mm.plugin.story.c.a.c.zqE.aqp();
      if (localObject4 == null) {
        d.g.b.k.fOy();
      }
      if (!((c.a)localObject6).awp((String)localObject4)) {
        break label1743;
      }
      ac.i(TAG, "checkRemuxVideo, exceed bitrate:".concat(String.valueOf(localObject4)));
      if (((ddz)localObject3).FNJ)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.zAt;
        com.tencent.mm.plugin.story.h.d.dXw();
        localObject5 = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXW().Rs();
      }
      localObject5 = com.tencent.mm.plugin.story.h.g.zAw;
      com.tencent.mm.plugin.story.h.g.dXI();
      d.g.b.k.h(localObject4, "path");
      ac.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile: ".concat(String.valueOf(localObject4)));
      localObject5 = com.tencent.mm.plugin.sight.base.e.asx((String)localObject4);
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
      i1 = bs.getInt(((com.tencent.mm.compatible.h.d)localObject5).extractMetadata(18), 0);
      i = n;
      j = i1;
      k = m;
      n = bs.getInt(((com.tencent.mm.compatible.h.d)localObject5).extractMetadata(19), 0);
      i = n;
      j = i1;
      k = m;
      m = bs.getInt(((com.tencent.mm.compatible.h.d)localObject5).extractMetadata(20), 0);
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
      localObject5 = com.tencent.mm.plugin.story.c.a.c.zqE;
      n = com.tencent.mm.plugin.story.c.a.c.awo((String)localObject4);
    }
    int i1 = SightVideoJNI.getMp4RotateVFS((String)localObject4);
    ac.i("MicroMsg.IEncodeConfig", "videoWidth: " + j + " , videoHeight :" + i + "  , videoBitrate:" + k + " ,videoBitrate " + ((c.a)localObject6).videoBitrate + ", videoFrameRate:" + n + " , videoRotate : " + i1);
    if (k < ((c.a)localObject6).videoBitrate) {
      ((c.a)localObject6).videoBitrate = k;
    }
    if ((i1 == 90) || (i1 == 270))
    {
      m = i;
      k = j;
      if (i > ((c.a)localObject6).gNU)
      {
        m = i;
        k = j;
        if (i - ((c.a)localObject6).gNU > 16)
        {
          k = (int)(((c.a)localObject6).gNU / i * j);
          m = ((c.a)localObject6).gNU;
        }
      }
      label997:
      i = m;
      if (m % 16 != 0) {
        i = com.tencent.mm.plugin.mmsight.d.IJ(m);
      }
      j = k;
      if (k % 16 != 0) {
        j = com.tencent.mm.plugin.mmsight.d.IJ(k);
      }
      if (((c.a)localObject6).frameRate > n) {
        ((c.a)localObject6).frameRate = n;
      }
      ((c.a)localObject6).gNV = i;
      ((c.a)localObject6).gNU = j;
      ((c.a)localObject6).gTI = i1;
      label1070:
      localObject5 = (String)localObject4 + ".remux";
      ac.i(TAG, "remux outputFilepath:".concat(String.valueOf(localObject5)));
      l = bs.Gn();
      i = SightVideoJNI.remuxingVFS((String)localObject4, (String)localObject5, ((c.a)localObject6).gNU, ((c.a)localObject6).gNV, ((c.a)localObject6).videoBitrate, com.tencent.mm.plugin.sight.base.c.xCr, 8, 2, 25.0F, ((c.a)localObject6).frameRate, null, 0, com.tencent.mm.plugin.sight.base.c.xCq, 0, 51);
      ac.i(TAG, "checkRemuxVideo remux cost:" + bs.aO(l) + "ms, ret:" + i);
      if (i < 0) {
        break label1625;
      }
      if (((ddz)localObject3).FNJ)
      {
        l = bs.aO(l);
        localObject3 = com.tencent.mm.plugin.story.h.d.zAt;
        com.tencent.mm.plugin.story.h.d.dXx();
        localObject3 = com.tencent.mm.plugin.story.h.d.zAt;
        com.tencent.mm.plugin.story.h.d.yq(l);
        localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXW().it(i);
        localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXW().jj(l);
        localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXX();
      }
      i.ma((String)localObject5, (String)localObject4);
    }
    for (;;)
    {
      for (i = 0;; i = 1)
      {
        if (i == 0)
        {
          localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXU().it(System.currentTimeMillis());
          new b(this.zwd, (String)localObject1, (String)localObject2, (g.a)new d(this)).dWW();
        }
        AppMethodBeat.o(119134);
        return;
        bool1 = false;
        break;
        label1341:
        l = 0L;
        break label385;
        label1347:
        com.tencent.mm.plugin.recordvideo.b.e.wps.duW();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.wps;
        ((c.a)localObject6).gNU = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.wps;
        ((c.a)localObject6).gNV = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.wps;
        ((c.a)localObject6).frameRate = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
        float f1 = 1.0F;
        bool1 = com.tencent.mm.plugin.story.c.c.isEnable();
        if (!bool1)
        {
          float f2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pRy, 2.0F);
          f1 = f2;
          if (f2 <= 1.0F) {
            f1 = 1.0F;
          }
        }
        ((c.a)localObject6).videoBitrate = ((int)(((c.a)localObject6).videoBitrate * f1));
        ((c.a)localObject6).gTI = 0;
        ac.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile imageVideo, config:" + ((c.a)localObject6).gNU + ", " + ((c.a)localObject6).gNV + ", " + ((c.a)localObject6).frameRate + ", " + ((c.a)localObject6).gTI + ", " + ((c.a)localObject6).videoBitrate + ", " + f1 + ", " + bool1);
        break label1070;
        m = i;
        k = j;
        if (j <= ((c.a)localObject6).gNU) {
          break label997;
        }
        m = i;
        k = j;
        if (j - ((c.a)localObject6).gNU <= 16) {
          break label997;
        }
        f1 = ((c.a)localObject6).gNU / j;
        m = (int)(i * f1);
        k = ((c.a)localObject6).gNU;
        break label997;
        label1625:
        if (((ddz)localObject3).FNJ)
        {
          localObject4 = com.tencent.mm.plugin.story.h.d.zAt;
          com.tencent.mm.plugin.story.h.d.dXv();
          localObject4 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXW().it(i);
          localObject4 = com.tencent.mm.plugin.story.h.h.zAU;
          com.tencent.mm.plugin.story.h.h.dXX();
        }
        ((ddz)localObject3).gLY += 1;
        localObject4 = this.zwd;
        localObject3 = ((ddz)localObject3).toByteArray();
        d.g.b.k.g(localObject3, "postInfo.toByteArray()");
        ((com.tencent.mm.plugin.story.i.j)localObject4).bD((byte[])localObject3);
        localObject3 = com.tencent.mm.plugin.story.f.j.zsh;
        j.b.dVE().a((int)this.zwd.systemRowid, this.zwd);
        i.deleteFile((String)localObject5);
        a(com.tencent.mm.loader.g.h.gLO);
      }
      label1743:
      ac.i(TAG, "checkRemuxVideo, no need remux");
      label1752:
      if (((ddz)localObject3).FNJ)
      {
        localObject3 = com.tencent.mm.plugin.story.h.h.zAU;
        com.tencent.mm.plugin.story.h.h.dXX();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", "errorCode", "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"})
  public static final class d
    implements g.a
  {
    public final void a(int paramInt, boolean paramBoolean, com.tencent.mm.plugin.story.f.g paramg)
    {
      AppMethodBeat.i(119133);
      d.g.b.k.h(paramg, "upload");
      paramg = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dXU().iu(paramInt);
      paramg = com.tencent.mm.plugin.story.h.h.zAU;
      paramg = com.tencent.mm.plugin.story.h.h.dXU();
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
      paramg.it(l - com.tencent.mm.plugin.story.h.h.dXU().QS());
      paramg = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.dXV();
      if (paramBoolean)
      {
        this.zwz.a(com.tencent.mm.loader.g.h.gLN);
        AppMethodBeat.o(119133);
        return;
      }
      this.zwz.a(com.tencent.mm.loader.g.h.gLO);
      AppMethodBeat.o(119133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.e
 * JD-Core Version:    0.7.0.1
 */
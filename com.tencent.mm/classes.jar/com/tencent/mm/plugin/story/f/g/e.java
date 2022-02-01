package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.je;
import com.tencent.mm.g.b.a.jm;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.edu;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.loader.g.c
{
  public static final a FqK;
  private static final String TAG = "MicroMsg.StoryUploadTask";
  private com.tencent.mm.plugin.story.i.j Fqr;
  
  static
  {
    AppMethodBeat.i(119137);
    FqK = new a((byte)0);
    TAG = "MicroMsg.StoryUploadTask";
    AppMethodBeat.o(119137);
  }
  
  public e(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119136);
    this.Fqr = paramj;
    AppMethodBeat.o(119136);
  }
  
  public final String auK()
  {
    AppMethodBeat.i(119135);
    int i = (int)this.Fqr.systemRowid;
    AppMethodBeat.o(119135);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119134);
    Object localObject3 = this.Fqr.frI();
    Object localObject4 = (edt)this.Fqr.frG().NeB.LoV.get(0);
    Object localObject1 = com.tencent.mm.plugin.story.f.l.FmK;
    localObject1 = com.tencent.mm.plugin.story.f.l.aRW(((edt)localObject4).Id);
    Object localObject2 = com.tencent.mm.plugin.story.f.l.FmK;
    localObject2 = com.tencent.mm.plugin.story.f.l.aRV(((edt)localObject4).Id);
    int i = ((edu)localObject3).Mpa;
    Object localObject5 = a.g.FvU;
    if (i == a.g.frs())
    {
      a(com.tencent.mm.loader.g.j.ibw);
      AppMethodBeat.o(119134);
      return;
    }
    if (((edu)localObject3).ibG > 5)
    {
      localObject1 = f.FqO;
      f.a(this.Fqr, -1, "", (kotlin.g.a.a)e.b.FqL);
      a(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(119134);
      return;
    }
    if (com.tencent.mm.vfs.s.boW((String)localObject1) < 0L)
    {
      localObject1 = f.FqO;
      f.a(this.Fqr, -1, "", (kotlin.g.a.a)e.c.FqM);
      a(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(119134);
      return;
    }
    localObject5 = a.g.FvU;
    ((edu)localObject3).Mpa = a.g.fru();
    localObject5 = this.Fqr;
    Object localObject6 = ((edu)localObject3).toByteArray();
    p.g(localObject6, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject5).setPostBuf((byte[])localObject6);
    localObject5 = com.tencent.mm.plugin.story.f.j.Fmy;
    j.b.foc().a((int)this.Fqr.systemRowid, this.Fqr);
    localObject5 = com.tencent.mm.plugin.story.f.s.Fny;
    localObject4 = com.tencent.mm.plugin.story.f.s.a((edt)localObject4);
    boolean bool1;
    long l;
    label385:
    int m;
    int i2;
    int j;
    int k;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rPC, 0) == 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (Log.getLogLevel() >= 0)
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        bool2 = bool1;
        if (com.tencent.mm.plugin.recordvideo.b.e.eJu()) {
          bool2 = true;
        }
      }
      Log.i(TAG, "checkRemuxVideo isImageVideo:%s, enable:%s", new Object[] { Boolean.valueOf(((edu)localObject3).Neh), Boolean.valueOf(bool2) });
      if (((edu)localObject3).Neh)
      {
        localObject5 = h.FuH;
        h.fqu().sg(System.currentTimeMillis());
        localObject5 = h.FuH;
        localObject5 = h.fqu();
        if (!bool2) {
          break label1341;
        }
        l = 1L;
        ((jm)localObject5).sh(l);
      }
      if ((!((edu)localObject3).Neh) || (!bool2) || (com.tencent.mm.plugin.story.c.c.isEnable()))
      {
        localObject5 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(localObject5, "MMKernel.service<IConfig…onfigService::class.java)");
        if (Util.getInt(((com.tencent.mm.plugin.zero.b.a)localObject5).aqJ().getValue("StoryCheckSendVideoBitrateExceed"), 0) != 1) {
          break label1752;
        }
      }
      if (Util.isNullOrNil((String)localObject4)) {
        break label1752;
      }
      Log.i(TAG, "checkRemuxVideo, filePath:".concat(String.valueOf(localObject4)));
      if (((edu)localObject3).Neh)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.Fug;
        com.tencent.mm.plugin.story.h.d.fpW();
      }
      localObject6 = (c.a)com.tencent.mm.plugin.story.c.a.c.FkZ.aLT();
      if (localObject4 == null) {
        p.hyc();
      }
      if (!((c.a)localObject6).aRJ((String)localObject4)) {
        break label1743;
      }
      Log.i(TAG, "checkRemuxVideo, exceed bitrate:".concat(String.valueOf(localObject4)));
      if (((edu)localObject3).Neh)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.Fug;
        com.tencent.mm.plugin.story.h.d.fpU();
        localObject5 = h.FuH;
        h.fqu().ahu();
      }
      localObject5 = com.tencent.mm.plugin.story.h.g.Fuj;
      com.tencent.mm.plugin.story.h.g.fqg();
      p.h(localObject4, "path");
      Log.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile: ".concat(String.valueOf(localObject4)));
      localObject5 = com.tencent.mm.plugin.sight.base.e.aNx((String)localObject4);
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
      localObject5 = new com.tencent.mm.compatible.i.d();
      i = n;
      j = i1;
      k = m;
      ((com.tencent.mm.compatible.i.d)localObject5).setDataSource((String)localObject4);
      i = n;
      j = i1;
      k = m;
      i1 = Util.getInt(((com.tencent.mm.compatible.i.d)localObject5).extractMetadata(18), 0);
      i = n;
      j = i1;
      k = m;
      n = Util.getInt(((com.tencent.mm.compatible.i.d)localObject5).extractMetadata(19), 0);
      i = n;
      j = i1;
      k = m;
      m = Util.getInt(((com.tencent.mm.compatible.i.d)localObject5).extractMetadata(20), 0);
      i = n;
      j = i1;
      k = m;
      ((com.tencent.mm.compatible.i.d)localObject5).release();
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
      localObject5 = com.tencent.mm.plugin.story.c.a.c.FkZ;
      n = com.tencent.mm.plugin.story.c.a.c.aRI((String)localObject4);
    }
    int i1 = SightVideoJNI.getMp4RotateVFS((String)localObject4);
    Log.i("MicroMsg.IEncodeConfig", "videoWidth: " + j + " , videoHeight :" + i + "  , videoBitrate:" + k + " ,videoBitrate " + ((c.a)localObject6).videoBitrate + ", videoFrameRate:" + n + " , videoRotate : " + i1);
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
        i = com.tencent.mm.plugin.mmsight.d.QH(m);
      }
      j = k;
      if (k % 16 != 0) {
        j = com.tencent.mm.plugin.mmsight.d.QH(k);
      }
      if (((c.a)localObject6).frameRate > n) {
        ((c.a)localObject6).frameRate = n;
      }
      ((c.a)localObject6).targetHeight = i;
      ((c.a)localObject6).targetWidth = j;
      ((c.a)localObject6).ihS = i1;
      label1070:
      localObject5 = (String)localObject4 + ".remux";
      Log.i(TAG, "remux outputFilepath:".concat(String.valueOf(localObject5)));
      l = Util.currentTicks();
      i = SightVideoJNI.remuxingVFS((String)localObject4, (String)localObject5, ((c.a)localObject6).targetWidth, ((c.a)localObject6).targetHeight, ((c.a)localObject6).videoBitrate, com.tencent.mm.plugin.sight.base.c.Dmc, 8, 2, 25.0F, ((c.a)localObject6).frameRate, null, 0, com.tencent.mm.plugin.sight.base.c.Dmb, 0, 51);
      Log.i(TAG, "checkRemuxVideo remux cost:" + Util.ticksToNow(l) + "ms, ret:" + i);
      if (i < 0) {
        break label1625;
      }
      if (((edu)localObject3).Neh)
      {
        l = Util.ticksToNow(l);
        localObject3 = com.tencent.mm.plugin.story.h.d.Fug;
        com.tencent.mm.plugin.story.h.d.fpV();
        localObject3 = com.tencent.mm.plugin.story.h.d.Fug;
        com.tencent.mm.plugin.story.h.d.Kr(l);
        localObject3 = h.FuH;
        h.fqu().lM(i);
        localObject3 = h.FuH;
        h.fqu().si(l);
        localObject3 = h.FuH;
        h.fqv();
      }
      com.tencent.mm.vfs.s.nx((String)localObject5, (String)localObject4);
    }
    for (;;)
    {
      for (i = 0;; i = 1)
      {
        if (i == 0)
        {
          localObject3 = h.FuH;
          h.fqs().rs(System.currentTimeMillis());
          new b(this.Fqr, (String)localObject1, (String)localObject2, (g.a)new d(this)).fpu();
        }
        AppMethodBeat.o(119134);
        return;
        bool1 = false;
        break;
        label1341:
        l = 0L;
        break label385;
        label1347:
        com.tencent.mm.plugin.recordvideo.b.e.BNm.eJv();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        ((c.a)localObject6).targetWidth = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        ((c.a)localObject6).targetHeight = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
        ((c.a)localObject6).frameRate = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
        float f1 = 1.0F;
        bool1 = com.tencent.mm.plugin.story.c.c.isEnable();
        if (!bool1)
        {
          float f2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rVN, 2.0F);
          f1 = f2;
          if (f2 <= 1.0F) {
            f1 = 1.0F;
          }
        }
        ((c.a)localObject6).videoBitrate = ((int)(((c.a)localObject6).videoBitrate * f1));
        ((c.a)localObject6).ihS = 0;
        Log.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile imageVideo, config:" + ((c.a)localObject6).targetWidth + ", " + ((c.a)localObject6).targetHeight + ", " + ((c.a)localObject6).frameRate + ", " + ((c.a)localObject6).ihS + ", " + ((c.a)localObject6).videoBitrate + ", " + f1 + ", " + bool1);
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
        if (((edu)localObject3).Neh)
        {
          localObject4 = com.tencent.mm.plugin.story.h.d.Fug;
          com.tencent.mm.plugin.story.h.d.fpT();
          localObject4 = h.FuH;
          h.fqu().lM(i);
          localObject4 = h.FuH;
          h.fqv();
        }
        ((edu)localObject3).ibG += 1;
        localObject4 = this.Fqr;
        localObject3 = ((edu)localObject3).toByteArray();
        p.g(localObject3, "postInfo.toByteArray()");
        ((com.tencent.mm.plugin.story.i.j)localObject4).setPostBuf((byte[])localObject3);
        localObject3 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foc().a((int)this.Fqr.systemRowid, this.Fqr);
        com.tencent.mm.vfs.s.deleteFile((String)localObject5);
        a(com.tencent.mm.loader.g.j.ibx);
      }
      label1743:
      Log.i(TAG, "checkRemuxVideo, no need remux");
      label1752:
      if (((edu)localObject3).Neh)
      {
        localObject3 = h.FuH;
        h.fqv();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", "errorCode", "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"})
  public static final class d
    implements g.a
  {
    public final void a(int paramInt, boolean paramBoolean, com.tencent.mm.plugin.story.f.g paramg)
    {
      AppMethodBeat.i(119133);
      p.h(paramg, "upload");
      paramg = h.FuH;
      h.fqs().rt(paramInt);
      paramg = h.FuH;
      paramg = h.fqs();
      long l = System.currentTimeMillis();
      h localh = h.FuH;
      paramg.rs(l - h.fqs().agP());
      paramg = h.FuH;
      h.fqt();
      if (paramBoolean)
      {
        this.FqN.a(com.tencent.mm.loader.g.j.ibw);
        AppMethodBeat.o(119133);
        return;
      }
      this.FqN.a(com.tencent.mm.loader.g.j.ibx);
      AppMethodBeat.o(119133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.e
 * JD-Core Version:    0.7.0.1
 */
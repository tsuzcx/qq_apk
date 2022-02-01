package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ln;
import com.tencent.mm.f.b.a.lv;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.enu;
import com.tencent.mm.protocal.protobuf.env;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.loader.g.c
{
  public static final a LKN;
  private static final String TAG = "MicroMsg.StoryUploadTask";
  private com.tencent.mm.plugin.story.i.j LKu;
  
  static
  {
    AppMethodBeat.i(119137);
    LKN = new a((byte)0);
    TAG = "MicroMsg.StoryUploadTask";
    AppMethodBeat.o(119137);
  }
  
  public e(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119136);
    this.LKu = paramj;
    AppMethodBeat.o(119136);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(119135);
    int i = (int)this.LKu.systemRowid;
    AppMethodBeat.o(119135);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119134);
    Object localObject3 = this.LKu.gge();
    Object localObject4 = (enu)this.LKu.ggc().Ura.Sqr.get(0);
    Object localObject1 = com.tencent.mm.plugin.story.f.l.LGM;
    localObject1 = com.tencent.mm.plugin.story.f.l.bda(((enu)localObject4).Id);
    Object localObject2 = com.tencent.mm.plugin.story.f.l.LGM;
    localObject2 = com.tencent.mm.plugin.story.f.l.bcZ(((enu)localObject4).Id);
    int i = ((env)localObject3).TAg;
    Object localObject5 = a.g.LPX;
    if (i == a.g.gfO())
    {
      a(com.tencent.mm.loader.g.j.kQd);
      AppMethodBeat.o(119134);
      return;
    }
    if (((env)localObject3).kQn > 5)
    {
      localObject1 = f.LKR;
      f.a(this.LKu, -1, "", (kotlin.g.a.a)e.b.LKO);
      a(com.tencent.mm.loader.g.j.kQe);
      AppMethodBeat.o(119134);
      return;
    }
    if (u.bBQ((String)localObject1) < 0L)
    {
      localObject1 = f.LKR;
      f.a(this.LKu, -1, "", (kotlin.g.a.a)e.c.LKP);
      a(com.tencent.mm.loader.g.j.kQe);
      AppMethodBeat.o(119134);
      return;
    }
    localObject5 = a.g.LPX;
    ((env)localObject3).TAg = a.g.gfQ();
    localObject5 = this.LKu;
    Object localObject6 = ((env)localObject3).toByteArray();
    p.j(localObject6, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject5).setPostBuf((byte[])localObject6);
    localObject5 = com.tencent.mm.plugin.story.f.j.LGA;
    j.b.gcw().a((int)this.LKu.systemRowid, this.LKu);
    localObject5 = s.LHA;
    localObject4 = s.a((enu)localObject4);
    boolean bool1;
    long l;
    label385:
    int m;
    int i2;
    int j;
    int k;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvN, 0) == 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (Log.getLogLevel() >= 0)
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.b.f.HJU;
        bool2 = bool1;
        if (com.tencent.mm.plugin.recordvideo.b.f.fvD()) {
          bool2 = true;
        }
      }
      Log.i(TAG, "checkRemuxVideo isImageVideo:%s, enable:%s", new Object[] { Boolean.valueOf(((env)localObject3).UqG), Boolean.valueOf(bool2) });
      if (((env)localObject3).UqG)
      {
        localObject5 = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.geQ().wi(System.currentTimeMillis());
        localObject5 = com.tencent.mm.plugin.story.h.h.LOJ;
        localObject5 = com.tencent.mm.plugin.story.h.h.geQ();
        if (!bool2) {
          break label1341;
        }
        l = 1L;
        ((lv)localObject5).wj(l);
      }
      if ((!((env)localObject3).UqG) || (!bool2) || (com.tencent.mm.plugin.story.c.c.isEnable()))
      {
        localObject5 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class);
        p.j(localObject5, "MMKernel.service<IConfig…onfigService::class.java)");
        if (Util.getInt(((com.tencent.mm.plugin.zero.b.a)localObject5).axc().getValue("StoryCheckSendVideoBitrateExceed"), 0) != 1) {
          break label1752;
        }
      }
      if (Util.isNullOrNil((String)localObject4)) {
        break label1752;
      }
      Log.i(TAG, "checkRemuxVideo, filePath:".concat(String.valueOf(localObject4)));
      if (((env)localObject3).UqG)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.LOh;
        com.tencent.mm.plugin.story.h.d.ger();
      }
      localObject6 = (c.a)com.tencent.mm.plugin.story.c.a.c.LFb.aUb();
      if (localObject4 == null) {
        p.iCn();
      }
      if (!((c.a)localObject6).bcN((String)localObject4)) {
        break label1743;
      }
      Log.i(TAG, "checkRemuxVideo, exceed bitrate:".concat(String.valueOf(localObject4)));
      if (((env)localObject3).UqG)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.LOh;
        com.tencent.mm.plugin.story.h.d.gep();
        localObject5 = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.geQ().amQ();
      }
      localObject5 = com.tencent.mm.plugin.story.h.g.LOk;
      com.tencent.mm.plugin.story.h.g.geC();
      p.k(localObject4, "path");
      Log.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile: ".concat(String.valueOf(localObject4)));
      localObject5 = com.tencent.mm.plugin.sight.base.f.aYg((String)localObject4);
      if (localObject5 == null) {
        break label1347;
      }
      i1 = ((com.tencent.mm.plugin.sight.base.b)localObject5).width;
      n = ((com.tencent.mm.plugin.sight.base.b)localObject5).height;
      m = ((com.tencent.mm.plugin.sight.base.b)localObject5).videoBitrate;
      i2 = ((com.tencent.mm.plugin.sight.base.b)localObject5).frameRate;
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
      localObject5 = com.tencent.mm.plugin.story.c.a.c.LFb;
      n = com.tencent.mm.plugin.story.c.a.c.bcM((String)localObject4);
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
        i = com.tencent.mm.plugin.mmsight.d.WV(m);
      }
      j = k;
      if (k % 16 != 0) {
        j = com.tencent.mm.plugin.mmsight.d.WV(k);
      }
      if (((c.a)localObject6).frameRate > n) {
        ((c.a)localObject6).frameRate = n;
      }
      ((c.a)localObject6).targetHeight = i;
      ((c.a)localObject6).targetWidth = j;
      ((c.a)localObject6).kWG = i1;
      label1070:
      localObject5 = (String)localObject4 + ".remux";
      Log.i(TAG, "remux outputFilepath:".concat(String.valueOf(localObject5)));
      l = Util.currentTicks();
      i = SightVideoJNI.remuxingVFS((String)localObject4, (String)localObject5, ((c.a)localObject6).targetWidth, ((c.a)localObject6).targetHeight, ((c.a)localObject6).videoBitrate, com.tencent.mm.plugin.sight.base.d.JrH, 8, 2, 25.0F, ((c.a)localObject6).frameRate, null, 0, com.tencent.mm.plugin.sight.base.d.JrG, 0, 51);
      Log.i(TAG, "checkRemuxVideo remux cost:" + Util.ticksToNow(l) + "ms, ret:" + i);
      if (i < 0) {
        break label1625;
      }
      if (((env)localObject3).UqG)
      {
        l = Util.ticksToNow(l);
        localObject3 = com.tencent.mm.plugin.story.h.d.LOh;
        com.tencent.mm.plugin.story.h.d.geq();
        localObject3 = com.tencent.mm.plugin.story.h.d.LOh;
        com.tencent.mm.plugin.story.h.d.RL(l);
        localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.geQ().nM(i);
        localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.geQ().wk(l);
        localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.geR();
      }
      u.oo((String)localObject5, (String)localObject4);
    }
    for (;;)
    {
      for (i = 0;; i = 1)
      {
        if (i == 0)
        {
          localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geO().vu(System.currentTimeMillis());
          new b(this.LKu, (String)localObject1, (String)localObject2, (g.a)new d(this)).gdO();
        }
        AppMethodBeat.o(119134);
        return;
        bool1 = false;
        break;
        label1341:
        l = 0L;
        break label385;
        label1347:
        com.tencent.mm.plugin.recordvideo.b.f.HJU.fvF();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.f.HJU;
        ((c.a)localObject6).targetWidth = com.tencent.mm.plugin.recordvideo.b.f.getWidth();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.f.HJU;
        ((c.a)localObject6).targetHeight = com.tencent.mm.plugin.recordvideo.b.f.getHeight();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.f.HJU;
        ((c.a)localObject6).frameRate = com.tencent.mm.plugin.recordvideo.b.f.getFrameRate();
        float f1 = 1.0F;
        bool1 = com.tencent.mm.plugin.story.c.c.isEnable();
        if (!bool1)
        {
          float f2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCn, 2.0F);
          f1 = f2;
          if (f2 <= 1.0F) {
            f1 = 1.0F;
          }
        }
        ((c.a)localObject6).videoBitrate = ((int)(((c.a)localObject6).videoBitrate * f1));
        ((c.a)localObject6).kWG = 0;
        Log.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile imageVideo, config:" + ((c.a)localObject6).targetWidth + ", " + ((c.a)localObject6).targetHeight + ", " + ((c.a)localObject6).frameRate + ", " + ((c.a)localObject6).kWG + ", " + ((c.a)localObject6).videoBitrate + ", " + f1 + ", " + bool1);
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
        if (((env)localObject3).UqG)
        {
          localObject4 = com.tencent.mm.plugin.story.h.d.LOh;
          com.tencent.mm.plugin.story.h.d.geo();
          localObject4 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geQ().nM(i);
          localObject4 = com.tencent.mm.plugin.story.h.h.LOJ;
          com.tencent.mm.plugin.story.h.h.geR();
        }
        ((env)localObject3).kQn += 1;
        localObject4 = this.LKu;
        localObject3 = ((env)localObject3).toByteArray();
        p.j(localObject3, "postInfo.toByteArray()");
        ((com.tencent.mm.plugin.story.i.j)localObject4).setPostBuf((byte[])localObject3);
        localObject3 = com.tencent.mm.plugin.story.f.j.LGA;
        j.b.gcw().a((int)this.LKu.systemRowid, this.LKu);
        u.deleteFile((String)localObject5);
        a(com.tencent.mm.loader.g.j.kQe);
      }
      label1743:
      Log.i(TAG, "checkRemuxVideo, no need remux");
      label1752:
      if (((env)localObject3).UqG)
      {
        localObject3 = com.tencent.mm.plugin.story.h.h.LOJ;
        com.tencent.mm.plugin.story.h.h.geR();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", "errorCode", "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"})
  public static final class d
    implements g.a
  {
    public final void a(int paramInt, boolean paramBoolean, com.tencent.mm.plugin.story.f.g paramg)
    {
      AppMethodBeat.i(119133);
      p.k(paramg, "upload");
      paramg = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geO().vv(paramInt);
      paramg = com.tencent.mm.plugin.story.h.h.LOJ;
      paramg = com.tencent.mm.plugin.story.h.h.geO();
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.LOJ;
      paramg.vu(l - com.tencent.mm.plugin.story.h.h.geO().alW());
      paramg = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.geP();
      if (paramBoolean)
      {
        this.LKQ.a(com.tencent.mm.loader.g.j.kQd);
        AppMethodBeat.o(119133);
        return;
      }
      this.LKQ.a(com.tencent.mm.loader.g.j.kQe);
      AppMethodBeat.o(119133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.e
 * JD-Core Version:    0.7.0.1
 */
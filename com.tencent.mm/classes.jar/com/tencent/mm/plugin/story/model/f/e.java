package com.tencent.mm.plugin.story.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.on;
import com.tencent.mm.autogen.mmdata.rpt.ov;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.h.a.g;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.g.a;
import com.tencent.mm.plugin.story.model.r;
import com.tencent.mm.protocal.protobuf.fij;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.protocal.protobuf.fit;
import com.tencent.mm.protocal.protobuf.fjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.loader.f.c
{
  public static final e.a Soe;
  private static final String TAG;
  private j SnL;
  
  static
  {
    AppMethodBeat.i(119137);
    Soe = new e.a((byte)0);
    TAG = "MicroMsg.StoryUploadTask";
    AppMethodBeat.o(119137);
  }
  
  public e(j paramj)
  {
    AppMethodBeat.i(119136);
    this.SnL = paramj;
    AppMethodBeat.o(119136);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(119135);
    int i = (int)this.SnL.systemRowid;
    AppMethodBeat.o(119135);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119134);
    Object localObject3 = this.SnL.hzv();
    Object localObject4 = (fis)this.SnL.hzt().abJZ.Zpr.get(0);
    Object localObject1 = com.tencent.mm.plugin.story.model.k.Skq;
    localObject1 = com.tencent.mm.plugin.story.model.k.bbN(((fis)localObject4).Id);
    Object localObject2 = com.tencent.mm.plugin.story.model.k.Skq;
    localObject2 = com.tencent.mm.plugin.story.model.k.bbM(((fis)localObject4).Id);
    int i = ((fit)localObject3).aaPu;
    Object localObject5 = a.g.SsG;
    if (i == a.g.hzg())
    {
      a(i.nrG);
      AppMethodBeat.o(119134);
      return;
    }
    if (((fit)localObject3).nrQ > 5)
    {
      localObject1 = f.Soi;
      f.a(this.SnL, -1, "", (kotlin.g.a.a)e.b.Sof);
      a(i.nrH);
      AppMethodBeat.o(119134);
      return;
    }
    if (y.bEl((String)localObject1) < 0L)
    {
      localObject1 = f.Soi;
      f.a(this.SnL, -1, "", (kotlin.g.a.a)e.c.Sog);
      a(i.nrH);
      AppMethodBeat.o(119134);
      return;
    }
    localObject5 = a.g.SsG;
    ((fit)localObject3).aaPu = a.g.hzi();
    localObject5 = this.SnL;
    Object localObject6 = ((fit)localObject3).toByteArray();
    s.s(localObject6, "postInfo.toByteArray()");
    ((j)localObject5).setPostBuf((byte[])localObject6);
    localObject5 = StoryCore.SjP;
    StoryCore.b.hvR().a((int)this.SnL.systemRowid, this.SnL);
    localObject5 = r.Slb;
    localObject4 = r.a((fis)localObject4);
    boolean bool1;
    long l;
    label384:
    int m;
    int i2;
    int j;
    int k;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yIO, 0) == 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (Log.getLogLevel() >= 0)
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
        bool2 = bool1;
        if (com.tencent.mm.plugin.recordvideo.c.f.gHr()) {
          bool2 = true;
        }
      }
      Log.i(TAG, "checkRemuxVideo isImageVideo:%s, enable:%s", new Object[] { Boolean.valueOf(((fit)localObject3).abJF), Boolean.valueOf(bool2) });
      if (((fit)localObject3).abJF)
      {
        localObject5 = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hyi().jkw = System.currentTimeMillis();
        localObject5 = com.tencent.mm.plugin.story.g.h.SqZ;
        localObject5 = com.tencent.mm.plugin.story.g.h.hyi();
        if (!bool2) {
          break label1296;
        }
        l = 1L;
        ((ov)localObject5).jkx = l;
      }
      if (((!((fit)localObject3).abJF) || (!bool2) || (com.tencent.mm.plugin.story.c.c.isEnable())) && ((Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("StoryCheckSendVideoBitrateExceed"), 0) != 1) || (Util.isNullOrNil((String)localObject4)))) {
        break label1706;
      }
      Log.i(TAG, s.X("checkRemuxVideo, filePath:", localObject4));
      if (((fit)localObject3).abJF)
      {
        localObject5 = com.tencent.mm.plugin.story.g.d.SqV;
        com.tencent.mm.plugin.story.g.d.hxK();
      }
      localObject6 = (com.tencent.mm.plugin.story.c.a.c.a)com.tencent.mm.plugin.story.c.a.c.SiN.boF();
      s.checkNotNull(localObject4);
      if (!((com.tencent.mm.plugin.story.c.a.c.a)localObject6).bbB((String)localObject4)) {
        break label1697;
      }
      Log.i(TAG, s.X("checkRemuxVideo, exceed bitrate:", localObject4));
      if (((fit)localObject3).abJF)
      {
        localObject5 = com.tencent.mm.plugin.story.g.d.SqV;
        com.tencent.mm.plugin.story.g.d.hxI();
        localObject5 = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hyi().jky = 1L;
      }
      localObject5 = com.tencent.mm.plugin.story.g.g.SqY;
      com.tencent.mm.plugin.story.g.g.hxU();
      s.u(localObject4, "path");
      Log.i("MicroMsg.IEncodeConfig", s.X("videoConfigForLocalFile: ", localObject4));
      localObject5 = com.tencent.mm.plugin.sight.base.f.aVX((String)localObject4);
      if (localObject5 == null) {
        break label1302;
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
      label772:
      break label772;
    }
    int n = i2;
    if (i2 <= 0)
    {
      localObject5 = com.tencent.mm.plugin.story.c.a.c.SiN;
      n = com.tencent.mm.plugin.story.c.a.c.bbA((String)localObject4);
    }
    int i1 = SightVideoJNI.getMp4RotateVFS((String)localObject4);
    Log.i("MicroMsg.IEncodeConfig", "videoWidth: " + j + " , videoHeight :" + i + "  , videoBitrate:" + k + " ,videoBitrate " + ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).videoBitrate + ", videoFrameRate:" + n + " , videoRotate : " + i1);
    if (k < ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).videoBitrate) {
      ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).videoBitrate = k;
    }
    if ((i1 == 90) || (i1 == 270))
    {
      m = i;
      k = j;
      if (i > ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO)
      {
        m = i;
        k = j;
        if (i - ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO > 16)
        {
          k = (int)(((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO / i * j);
          m = ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO;
        }
      }
      label971:
      i = m;
      if (m % 16 != 0) {
        i = com.tencent.mm.plugin.mmsight.d.aaX(m);
      }
      j = k;
      if (k % 16 != 0) {
        j = com.tencent.mm.plugin.mmsight.d.aaX(k);
      }
      if (((com.tencent.mm.plugin.story.c.a.c.a)localObject6).frameRate > n) {
        ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).frameRate = n;
      }
      ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxP = i;
      ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO = j;
      ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nCg = i1;
      label1044:
      localObject5 = s.X((String)localObject4, ".remux");
      Log.i(TAG, s.X("remux outputFilepath:", localObject5));
      l = Util.currentTicks();
      i = SightVideoJNI.remuxingVFS((String)localObject4, (String)localObject5, ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO, ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxP, ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).videoBitrate, com.tencent.mm.plugin.sight.base.d.PFj, 8, 2, 25.0F, ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).frameRate, null, 0, com.tencent.mm.plugin.sight.base.d.PFi, 0, 51);
      Log.i(TAG, "checkRemuxVideo remux cost:" + Util.ticksToNow(l) + "ms, ret:" + i);
      if (i < 0) {
        break label1580;
      }
      if (((fit)localObject3).abJF)
      {
        l = Util.ticksToNow(l);
        localObject3 = com.tencent.mm.plugin.story.g.d.SqV;
        com.tencent.mm.plugin.story.g.d.hxJ();
        localObject3 = com.tencent.mm.plugin.story.g.d.SqV;
        com.tencent.mm.plugin.story.g.d.vU(l);
        localObject3 = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hyi().jkA = i;
        localObject3 = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hyi().jkz = l;
        localObject3 = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hyj();
      }
      y.qn((String)localObject5, (String)localObject4);
    }
    for (;;)
    {
      for (i = 0;; i = 1)
      {
        if (i == 0)
        {
          localObject3 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyg().iYN = System.currentTimeMillis();
          new b(this.SnL, (String)localObject1, (String)localObject2, (g.a)new d(this)).hxi();
        }
        AppMethodBeat.o(119134);
        return;
        bool1 = false;
        break;
        label1296:
        l = 0L;
        break label384;
        label1302:
        com.tencent.mm.plugin.recordvideo.c.f.NGM.gHt();
        localObject5 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
        ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO = com.tencent.mm.plugin.recordvideo.c.f.getWidth();
        localObject5 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
        ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxP = com.tencent.mm.plugin.recordvideo.c.f.getHeight();
        localObject5 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
        ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).frameRate = com.tencent.mm.plugin.recordvideo.c.f.getFrameRate();
        float f1 = 1.0F;
        bool1 = com.tencent.mm.plugin.story.c.c.isEnable();
        if (!bool1)
        {
          float f2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yQH, 2.0F);
          f1 = f2;
          if (f2 <= 1.0F) {
            f1 = 1.0F;
          }
        }
        ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).videoBitrate = ((int)(((com.tencent.mm.plugin.story.c.a.c.a)localObject6).videoBitrate * f1));
        ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nCg = 0;
        Log.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile imageVideo, config:" + ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO + ", " + ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxP + ", " + ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).frameRate + ", " + ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nCg + ", " + ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).videoBitrate + ", " + f1 + ", " + bool1);
        break label1044;
        m = i;
        k = j;
        if (j <= ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO) {
          break label971;
        }
        m = i;
        k = j;
        if (j - ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO <= 16) {
          break label971;
        }
        f1 = ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO / j;
        m = (int)(i * f1);
        k = ((com.tencent.mm.plugin.story.c.a.c.a)localObject6).nxO;
        break label971;
        label1580:
        if (((fit)localObject3).abJF)
        {
          localObject4 = com.tencent.mm.plugin.story.g.d.SqV;
          com.tencent.mm.plugin.story.g.d.hxH();
          localObject4 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyi().jkA = i;
          localObject4 = com.tencent.mm.plugin.story.g.h.SqZ;
          com.tencent.mm.plugin.story.g.h.hyj();
        }
        ((fit)localObject3).nrQ += 1;
        localObject4 = this.SnL;
        localObject3 = ((fit)localObject3).toByteArray();
        s.s(localObject3, "postInfo.toByteArray()");
        ((j)localObject4).setPostBuf((byte[])localObject3);
        localObject3 = StoryCore.SjP;
        StoryCore.b.hvR().a((int)this.SnL.systemRowid, this.SnL);
        y.deleteFile((String)localObject5);
        a(i.nrH);
      }
      label1697:
      Log.i(TAG, "checkRemuxVideo, no need remux");
      label1706:
      if (((fit)localObject3).abJF)
      {
        localObject3 = com.tencent.mm.plugin.story.g.h.SqZ;
        com.tencent.mm.plugin.story.g.h.hyj();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", "errorCode", "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements g.a
  {
    d(e parame) {}
    
    public final void a(int paramInt, boolean paramBoolean, com.tencent.mm.plugin.story.model.g paramg)
    {
      AppMethodBeat.i(119133);
      s.u(paramg, "upload");
      paramg = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hyg().jjr = paramInt;
      paramg = com.tencent.mm.plugin.story.g.h.SqZ;
      paramg = com.tencent.mm.plugin.story.g.h.hyg();
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.story.g.h localh = com.tencent.mm.plugin.story.g.h.SqZ;
      paramg.iYN = (l - com.tencent.mm.plugin.story.g.h.hyg().iYN);
      paramg = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.hyh();
      if (paramBoolean)
      {
        this.Soh.a(i.nrG);
        AppMethodBeat.o(119133);
        return;
      }
      this.Soh.a(i.nrH);
      AppMethodBeat.o(119133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.f.e
 * JD-Core Version:    0.7.0.1
 */
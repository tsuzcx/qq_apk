package com.tencent.mm.plugin.story.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fq;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.c.a.c.a;
import com.tencent.mm.plugin.story.f.g.a;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.s;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.i.a.g;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dkx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import java.util.LinkedList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/upload/UploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "(Lcom/tencent/mm/plugin/story/storage/StoryInfo;)V", "getStoryInfo", "()Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setStoryInfo", "call", "", "checkRemuxVideo", "", "filePath", "", "postInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaPostInfo;", "doUploadStory", "uniqueId", "Companion", "plugin-story_release"})
public final class e
  extends com.tencent.mm.loader.g.c
{
  public static final e.a BfT;
  private static final String TAG = "MicroMsg.StoryUploadTask";
  private com.tencent.mm.plugin.story.i.j BfA;
  
  static
  {
    AppMethodBeat.i(119137);
    BfT = new e.a((byte)0);
    TAG = "MicroMsg.StoryUploadTask";
    AppMethodBeat.o(119137);
  }
  
  public e(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119136);
    this.BfA = paramj;
    AppMethodBeat.o(119136);
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(119135);
    int i = (int)this.BfA.systemRowid;
    AppMethodBeat.o(119135);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(119134);
    Object localObject3 = this.BfA.epi();
    Object localObject4 = (dkg)this.BfA.epg().HSy.Gtx.get(0);
    Object localObject1 = com.tencent.mm.plugin.story.f.l.BbR;
    localObject1 = com.tencent.mm.plugin.story.f.l.aDa(((dkg)localObject4).Id);
    Object localObject2 = com.tencent.mm.plugin.story.f.l.BbR;
    localObject2 = com.tencent.mm.plugin.story.f.l.aCZ(((dkg)localObject4).Id);
    int i = ((dkh)localObject3).HiZ;
    Object localObject5 = a.g.Ble;
    if (i == a.g.eoS())
    {
      a(com.tencent.mm.loader.g.j.hiy);
      AppMethodBeat.o(119134);
      return;
    }
    if (((dkh)localObject3).hiJ > 5)
    {
      localObject1 = f.BfX;
      f.a(this.BfA, -1, "", (d.g.a.a)e.b.BfU);
      a(com.tencent.mm.loader.g.j.hiz);
      AppMethodBeat.o(119134);
      return;
    }
    if (o.aZR((String)localObject1) < 0L)
    {
      localObject1 = f.BfX;
      f.a(this.BfA, -1, "", (d.g.a.a)e.c.BfV);
      a(com.tencent.mm.loader.g.j.hiz);
      AppMethodBeat.o(119134);
      return;
    }
    localObject5 = a.g.Ble;
    ((dkh)localObject3).HiZ = a.g.eoU();
    localObject5 = this.BfA;
    Object localObject6 = ((dkh)localObject3).toByteArray();
    p.g(localObject6, "postInfo.toByteArray()");
    ((com.tencent.mm.plugin.story.i.j)localObject5).bN((byte[])localObject6);
    localObject5 = com.tencent.mm.plugin.story.f.j.BbE;
    j.b.elB().a((int)this.BfA.systemRowid, this.BfA);
    localObject5 = s.BcG;
    localObject4 = s.a((dkg)localObject4);
    boolean bool1;
    long l;
    label385:
    int m;
    int i2;
    int j;
    int k;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxK, 0) == 1)
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (ae.getLogLevel() >= 0)
      {
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.xNf;
        bool2 = bool1;
        if (com.tencent.mm.plugin.recordvideo.b.e.dIH()) {
          bool2 = true;
        }
      }
      ae.i(TAG, "checkRemuxVideo isImageVideo:%s, enable:%s", new Object[] { Boolean.valueOf(((dkh)localObject3).HSf), Boolean.valueOf(bool2) });
      if (((dkh)localObject3).HSf)
      {
        localObject5 = h.BjR;
        h.enU().le(System.currentTimeMillis());
        localObject5 = h.BjR;
        localObject5 = h.enU();
        if (!bool2) {
          break label1341;
        }
        l = 1L;
        ((fy)localObject5).lf(l);
      }
      if ((!((dkh)localObject3).HSf) || (!bool2) || (com.tencent.mm.plugin.story.c.c.isEnable()))
      {
        localObject5 = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class);
        p.g(localObject5, "MMKernel.service<IConfig…onfigService::class.java)");
        if (bu.getInt(((com.tencent.mm.plugin.zero.b.a)localObject5).acL().getValue("StoryCheckSendVideoBitrateExceed"), 0) != 1) {
          break label1752;
        }
      }
      if (bu.isNullOrNil((String)localObject4)) {
        break label1752;
      }
      ae.i(TAG, "checkRemuxVideo, filePath:".concat(String.valueOf(localObject4)));
      if (((dkh)localObject3).HSf)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.Bjq;
        com.tencent.mm.plugin.story.h.d.enw();
      }
      localObject6 = (c.a)com.tencent.mm.plugin.story.c.a.c.Bab.att();
      if (localObject4 == null) {
        p.gkB();
      }
      if (!((c.a)localObject6).aCN((String)localObject4)) {
        break label1743;
      }
      ae.i(TAG, "checkRemuxVideo, exceed bitrate:".concat(String.valueOf(localObject4)));
      if (((dkh)localObject3).HSf)
      {
        localObject5 = com.tencent.mm.plugin.story.h.d.Bjq;
        com.tencent.mm.plugin.story.h.d.enu();
        localObject5 = h.BjR;
        h.enU().TF();
      }
      localObject5 = com.tencent.mm.plugin.story.h.g.Bjt;
      com.tencent.mm.plugin.story.h.g.enG();
      p.h(localObject4, "path");
      ae.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile: ".concat(String.valueOf(localObject4)));
      localObject5 = com.tencent.mm.plugin.sight.base.e.ayN((String)localObject4);
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
      i1 = bu.getInt(((com.tencent.mm.compatible.h.d)localObject5).extractMetadata(18), 0);
      i = n;
      j = i1;
      k = m;
      n = bu.getInt(((com.tencent.mm.compatible.h.d)localObject5).extractMetadata(19), 0);
      i = n;
      j = i1;
      k = m;
      m = bu.getInt(((com.tencent.mm.compatible.h.d)localObject5).extractMetadata(20), 0);
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
      localObject5 = com.tencent.mm.plugin.story.c.a.c.Bab;
      n = com.tencent.mm.plugin.story.c.a.c.aCM((String)localObject4);
    }
    int i1 = SightVideoJNI.getMp4RotateVFS((String)localObject4);
    ae.i("MicroMsg.IEncodeConfig", "videoWidth: " + j + " , videoHeight :" + i + "  , videoBitrate:" + k + " ,videoBitrate " + ((c.a)localObject6).videoBitrate + ", videoFrameRate:" + n + " , videoRotate : " + i1);
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
        i = com.tencent.mm.plugin.mmsight.d.KG(m);
      }
      j = k;
      if (k % 16 != 0) {
        j = com.tencent.mm.plugin.mmsight.d.KG(k);
      }
      if (((c.a)localObject6).frameRate > n) {
        ((c.a)localObject6).frameRate = n;
      }
      ((c.a)localObject6).targetHeight = i;
      ((c.a)localObject6).targetWidth = j;
      ((c.a)localObject6).hoy = i1;
      label1070:
      localObject5 = (String)localObject4 + ".remux";
      ae.i(TAG, "remux outputFilepath:".concat(String.valueOf(localObject5)));
      l = bu.HQ();
      i = SightVideoJNI.remuxingVFS((String)localObject4, (String)localObject5, ((c.a)localObject6).targetWidth, ((c.a)localObject6).targetHeight, ((c.a)localObject6).videoBitrate, com.tencent.mm.plugin.sight.base.c.zhl, 8, 2, 25.0F, ((c.a)localObject6).frameRate, null, 0, com.tencent.mm.plugin.sight.base.c.zhk, 0, 51);
      ae.i(TAG, "checkRemuxVideo remux cost:" + bu.aO(l) + "ms, ret:" + i);
      if (i < 0) {
        break label1625;
      }
      if (((dkh)localObject3).HSf)
      {
        l = bu.aO(l);
        localObject3 = com.tencent.mm.plugin.story.h.d.Bjq;
        com.tencent.mm.plugin.story.h.d.env();
        localObject3 = com.tencent.mm.plugin.story.h.d.Bjq;
        com.tencent.mm.plugin.story.h.d.Bm(l);
        localObject3 = h.BjR;
        h.enU().iM(i);
        localObject3 = h.BjR;
        h.enU().lg(l);
        localObject3 = h.BjR;
        h.enV();
      }
      o.mG((String)localObject5, (String)localObject4);
    }
    for (;;)
    {
      for (i = 0;; i = 1)
      {
        if (i == 0)
        {
          localObject3 = h.BjR;
          h.enS().kq(System.currentTimeMillis());
          new b(this.BfA, (String)localObject1, (String)localObject2, (g.a)new d(this)).emT();
        }
        AppMethodBeat.o(119134);
        return;
        bool1 = false;
        break;
        label1341:
        l = 0L;
        break label385;
        label1347:
        com.tencent.mm.plugin.recordvideo.b.e.xNf.dII();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.xNf;
        ((c.a)localObject6).targetWidth = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.xNf;
        ((c.a)localObject6).targetHeight = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
        localObject5 = com.tencent.mm.plugin.recordvideo.b.e.xNf;
        ((c.a)localObject6).frameRate = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
        float f1 = 1.0F;
        bool1 = com.tencent.mm.plugin.story.c.c.isEnable();
        if (!bool1)
        {
          float f2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCU, 2.0F);
          f1 = f2;
          if (f2 <= 1.0F) {
            f1 = 1.0F;
          }
        }
        ((c.a)localObject6).videoBitrate = ((int)(((c.a)localObject6).videoBitrate * f1));
        ((c.a)localObject6).hoy = 0;
        ae.i("MicroMsg.IEncodeConfig", "videoConfigForLocalFile imageVideo, config:" + ((c.a)localObject6).targetWidth + ", " + ((c.a)localObject6).targetHeight + ", " + ((c.a)localObject6).frameRate + ", " + ((c.a)localObject6).hoy + ", " + ((c.a)localObject6).videoBitrate + ", " + f1 + ", " + bool1);
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
        if (((dkh)localObject3).HSf)
        {
          localObject4 = com.tencent.mm.plugin.story.h.d.Bjq;
          com.tencent.mm.plugin.story.h.d.ent();
          localObject4 = h.BjR;
          h.enU().iM(i);
          localObject4 = h.BjR;
          h.enV();
        }
        ((dkh)localObject3).hiJ += 1;
        localObject4 = this.BfA;
        localObject3 = ((dkh)localObject3).toByteArray();
        p.g(localObject3, "postInfo.toByteArray()");
        ((com.tencent.mm.plugin.story.i.j)localObject4).bN((byte[])localObject3);
        localObject3 = com.tencent.mm.plugin.story.f.j.BbE;
        j.b.elB().a((int)this.BfA.systemRowid, this.BfA);
        o.deleteFile((String)localObject5);
        a(com.tencent.mm.loader.g.j.hiz);
      }
      label1743:
      ae.i(TAG, "checkRemuxVideo, no need remux");
      label1752:
      if (((dkh)localObject3).HSf)
      {
        localObject3 = h.BjR;
        h.enV();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/story/model/upload/UploadTask$doUploadStory$sightUpload$1", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload$ISightCdnUploadCallback;", "onSightUpLoadEnd", "", "errorCode", "", "isOk", "", "upload", "Lcom/tencent/mm/plugin/story/model/StoryCdnUpload;", "plugin-story_release"})
  public static final class d
    implements g.a
  {
    public final void a(int paramInt, boolean paramBoolean, com.tencent.mm.plugin.story.f.g paramg)
    {
      AppMethodBeat.i(119133);
      p.h(paramg, "upload");
      paramg = h.BjR;
      h.enS().kr(paramInt);
      paramg = h.BjR;
      paramg = h.enS();
      long l = System.currentTimeMillis();
      h localh = h.BjR;
      paramg.kq(l - h.enS().Tf());
      paramg = h.BjR;
      h.enT();
      if (paramBoolean)
      {
        this.BfW.a(com.tencent.mm.loader.g.j.hiy);
        AppMethodBeat.o(119133);
        return;
      }
      this.BfW.a(com.tencent.mm.loader.g.j.hiz);
      AppMethodBeat.o(119133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.g.e
 * JD-Core Version:    0.7.0.1
 */
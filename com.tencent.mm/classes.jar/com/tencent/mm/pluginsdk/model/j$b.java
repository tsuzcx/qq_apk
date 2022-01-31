package com.tencent.mm.pluginsdk.model;

import android.os.Process;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.d;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bh;
import java.util.HashMap;

final class j$b
  implements av.a
{
  String eFj;
  VideoTransPara eHv;
  String fileName;
  private int mkJ;
  private int mkK;
  boolean mng = false;
  String rHT;
  int rHU;
  private boolean rHV;
  private int rHW = 0;
  int rTo;
  com.tencent.mm.bi.g rTr;
  String toUser;
  
  public final boolean JS()
  {
    int i;
    for (;;)
    {
      synchronized ()
      {
        if (!j.ckz().containsKey(this.fileName))
        {
          i = 1;
          j = i;
          if (i == 0)
          {
            if (u.oe(this.fileName) == null) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            y.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
            return true;
          }
        }
        else
        {
          i = 0;
        }
      }
      j = 0;
    }
    boolean bool = WXHardCoderJNI.hcEncodeVideoEnable;
    int j = WXHardCoderJNI.hcEncodeVideoDelay;
    int k = WXHardCoderJNI.hcEncodeVideoCPU;
    int m = WXHardCoderJNI.hcEncodeVideoIO;
    if (WXHardCoderJNI.hcEncodeVideoThr)
    {
      i = Process.myTid();
      j.DD(WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo"));
      y.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(j.Tc()) });
      if ((this.eHv == null) || (this.eHv.isDefault)) {
        break label288;
      }
      this.mkJ = this.eHv.width;
    }
    Object localObject3;
    for (this.mkK = this.eHv.height;; this.mkK = ???[1])
    {
      ??? = new PString();
      localObject3 = new PInt();
      if ((!((a)com.tencent.mm.kernel.g.r(a.class)).FD().a(this.eFj, (PString)???, (PInt)localObject3)) || (com.tencent.mm.vfs.e.r(((PString)???).value, this.rHT) < 0L)) {
        break label321;
      }
      y.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
      this.rHU = ((PInt)localObject3).value;
      this.rHV = true;
      return true;
      i = 0;
      break;
      label288:
      ??? = new int[2];
      j.c(this.eFj, (int[])???);
      this.mkJ = ???[0];
    }
    label321:
    long l = bk.UZ();
    if (this.eHv != null)
    {
      y.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[] { this.eHv });
      if (com.tencent.mm.plugin.sight.base.b.odZ) {
        this.eHv.videoBitrate = ((int)(this.eHv.videoBitrate * 0.915D));
      }
      if (this.mng)
      {
        h.nFQ.a(354L, 245L, 1L, false);
        if (com.tencent.mm.bi.e.a(this.eFj, this.rHT, this.eHv) < 0) {
          h.nFQ.a(354L, 246L, 1L, false);
        }
        this.rHW = ((int)bk.cp(l));
        y.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.eFj, this.rHT, Integer.valueOf(this.rHU), Integer.valueOf(this.mkJ), Integer.valueOf(this.mkK) });
        if (this.rHU < 0) {
          break label889;
        }
        bool = true;
        label505:
        this.rHV = bool;
        ??? = new PInt();
        localObject3 = new PInt();
        if (u.a(this.rHT, (PInt)???, (PInt)localObject3)) {
          this.rHU = ((PInt)???).value;
        }
        if (this.rHV) {
          break label895;
        }
        y.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
        com.tencent.mm.vfs.e.deleteFile(this.rHT);
        com.tencent.mm.vfs.e.r(this.eFj, this.rHT);
      }
    }
    label889:
    label895:
    PInt localPInt;
    for (;;)
    {
      if (j.Tc() != 0)
      {
        WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcEncodeVideoEnable, j.Tc());
        y.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformace %s", new Object[] { Integer.valueOf(j.Tc()) });
        j.DD(0);
      }
      return true;
      this.rHU = SightVideoJNI.remuxing(this.eFj, this.rHT, this.mkJ, this.mkK, this.eHv.videoBitrate, this.eHv.ejP, 8, this.eHv.ejO, 25.0F, this.eHv.fps, null, 0, com.tencent.mm.plugin.sight.base.b.odZ);
      break;
      y.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[] { this.fileName });
      if (com.tencent.mm.plugin.sight.base.b.odZ) {
        com.tencent.mm.plugin.sight.base.b.oeb = (int)(com.tencent.mm.plugin.sight.base.b.oeb * 0.915D);
      }
      if (this.mng)
      {
        this.eHv = new VideoTransPara();
        this.eHv.width = this.mkJ;
        this.eHv.height = this.mkK;
        this.eHv.videoBitrate = com.tencent.mm.plugin.sight.base.b.oeb;
        this.eHv.ejP = com.tencent.mm.plugin.sight.base.b.oea;
        this.eHv.ejO = 2;
        this.eHv.fps = ((int)com.tencent.mm.plugin.sight.base.b.oec);
        this.eHv.duration = com.tencent.mm.bi.e.op(this.eFj);
        com.tencent.mm.bi.e.a(this.eFj, this.rHT, this.eHv);
        break;
      }
      this.rHU = SightVideoJNI.remuxing(this.eFj, this.rHT, this.mkJ, this.mkK, com.tencent.mm.plugin.sight.base.b.oeb, com.tencent.mm.plugin.sight.base.b.oea, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.b.oec, null, 0, com.tencent.mm.plugin.sight.base.b.odZ);
      break;
      bool = false;
      break label505;
      y.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
      try
      {
        ??? = new com.tencent.mm.vfs.b(this.rHT).getName();
        localObject3 = this.rHT + ".tmp";
        localPInt = new PInt(0);
        if (!d.b(this.rHT, (String)localObject3, localPInt)) {
          break label1137;
        }
        bool = com.tencent.mm.vfs.e.deleteFile(this.rHT);
        localObject3 = new com.tencent.mm.vfs.b((String)localObject3);
        y.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(com.tencent.mm.vfs.e.f(((com.tencent.mm.vfs.b)localObject3).getParent() + "/", ((com.tencent.mm.vfs.b)localObject3).getName(), (String)???)), com.tencent.mm.vfs.j.n(((com.tencent.mm.vfs.b)localObject3).cLr()), this.rHT });
        h.nFQ.a(354L, 30L, 1L, false);
        ((a)com.tencent.mm.kernel.g.r(a.class)).FD().L(this.eFj, this.rHT, this.rHU);
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[] { localException.toString() });
      }
    }
    label1137:
    if (localPInt.value != 1) {
      h.nFQ.a(354L, 31L, 1L, false);
    }
    for (;;)
    {
      y.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.eFj, this.rHT });
      break;
      h.nFQ.a(354L, 32L, 1L, false);
      h.nFQ.f(13836, new Object[] { Integer.valueOf(600), Long.valueOf(bk.UX()), this.rHT });
    }
  }
  
  public final boolean JT()
  {
    for (;;)
    {
      synchronized ()
      {
        j.ckz().remove(this.fileName);
        if (this.rHV)
        {
          j.de(this.rHT, this.rTo);
          j.e(this.rHV, this.eFj, this.rHT);
          if (!com.tencent.mm.plugin.sight.base.b.odZ) {
            break label170;
          }
          i = 1;
          j.a(i, this.rHW, this.eFj, this.rHT, this.rHU);
          if (this.rTo != 1) {
            break label175;
          }
          i = 8;
          if (!this.rHV) {
            break label180;
          }
          j = 1;
          n.Sp().a(this.eFj, this.rHT, this.toUser, "", "", i, j);
          u.l(this.fileName, this.rHU, 43);
          u.nZ(this.fileName);
          return false;
        }
      }
      j.df(this.rHT, this.rTo);
      continue;
      label170:
      int i = 0;
      continue;
      label175:
      i = 1;
      continue;
      label180:
      int j = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.j.b
 * JD-Core Version:    0.7.0.1
 */
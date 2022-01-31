package com.tencent.mm.pluginsdk.model;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.a.d;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bh;
import java.util.HashMap;

final class j$b
  implements az.a
{
  private int eXo;
  private int eXp;
  String fVa;
  VideoTransPara fXm;
  String fileName;
  String hAo;
  boolean oMo = false;
  String toUser;
  int vKm;
  com.tencent.mm.bj.g vKp;
  int vyA;
  private boolean vyB;
  private int vyC = 0;
  
  public final boolean acS()
  {
    AppMethodBeat.i(50972);
    int i;
    for (;;)
    {
      synchronized (j.access$700())
      {
        if (!j.bUQ().containsKey(this.fileName))
        {
          i = 1;
          j = i;
          if (i == 0)
          {
            if (u.vr(this.fileName) == null) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            ab.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
            AppMethodBeat.o(50972);
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
      j.zT(WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEncodeVideoTimeout, 603, WXHardCoderJNI.hcEncodeVideoAction, "MicroMsg.ImportMultiVideo"));
      ab.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance startPerformance: %s", new Object[] { Integer.valueOf(j.amn()) });
      if ((this.fXm == null) || (this.fXm.isDefault)) {
        break label308;
      }
      this.eXo = this.fXm.width;
    }
    Object localObject3;
    for (this.eXp = this.fXm.height;; this.eXp = ???[1])
    {
      ??? = new PString();
      localObject3 = new PInt();
      if ((!((a)com.tencent.mm.kernel.g.E(a.class)).YH().a(this.fVa, (PString)???, (PInt)localObject3)) || (com.tencent.mm.vfs.e.C(((PString)???).value, this.hAo) < 0L)) {
        break label341;
      }
      ab.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
      this.vyA = ((PInt)localObject3).value;
      this.vyB = true;
      AppMethodBeat.o(50972);
      return true;
      i = 0;
      break;
      label308:
      ??? = new int[2];
      j.c(this.fVa, (int[])???);
      this.eXo = ???[0];
    }
    label341:
    long l = bo.yB();
    if (this.fXm != null)
    {
      ab.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", new Object[] { this.fXm });
      if (com.tencent.mm.plugin.sight.base.b.qSo) {
        this.fXm.videoBitrate = ((int)(this.fXm.videoBitrate * 0.915D));
      }
      if (this.oMo)
      {
        h.qsU.idkeyStat(354L, 245L, 1L, false);
        if (com.tencent.mm.bj.e.a(this.fVa, this.hAo, this.fXm) < 0) {
          h.qsU.idkeyStat(354L, 246L, 1L, false);
        }
        this.vyC = ((int)bo.av(l));
        ab.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.fVa, this.hAo, Integer.valueOf(this.vyA), Integer.valueOf(this.eXo), Integer.valueOf(this.eXp) });
        if (this.vyA < 0) {
          break label921;
        }
        bool = true;
        label525:
        this.vyB = bool;
        ??? = new PInt();
        localObject3 = new PInt();
        if (u.a(this.hAo, (PInt)???, (PInt)localObject3)) {
          this.vyA = ((PInt)???).value;
        }
        if (this.vyB) {
          break label927;
        }
        ab.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
        com.tencent.mm.vfs.e.deleteFile(this.hAo);
        com.tencent.mm.vfs.e.C(this.fVa, this.hAo);
      }
    }
    label921:
    label927:
    PInt localPInt;
    for (;;)
    {
      if (j.amn() != 0)
      {
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEncodeVideoEnable, j.amn());
        ab.i("MicroMsg.ImportMultiVideo", "hardcoder summerPerformance stopPerformance %s", new Object[] { Integer.valueOf(j.amn()) });
        j.zT(0);
      }
      AppMethodBeat.o(50972);
      return true;
      this.vyA = SightVideoJNI.remuxing(this.fVa, this.hAo, this.eXo, this.eXp, this.fXm.videoBitrate, this.fXm.fzW, 8, this.fXm.fzV, 25.0F, this.fXm.fps, null, 0, com.tencent.mm.plugin.sight.base.b.qSo, 0, 51);
      break;
      ab.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", new Object[] { this.fileName });
      if (com.tencent.mm.plugin.sight.base.b.qSo) {
        com.tencent.mm.plugin.sight.base.b.qSq = (int)(com.tencent.mm.plugin.sight.base.b.qSq * 0.915D);
      }
      if (this.oMo)
      {
        this.fXm = new VideoTransPara();
        this.fXm.width = this.eXo;
        this.fXm.height = this.eXp;
        this.fXm.videoBitrate = com.tencent.mm.plugin.sight.base.b.qSq;
        this.fXm.fzW = com.tencent.mm.plugin.sight.base.b.qSp;
        this.fXm.fzV = 2;
        this.fXm.fps = ((int)com.tencent.mm.plugin.sight.base.b.qSr);
        this.fXm.duration = com.tencent.mm.bj.e.ew(this.fVa);
        com.tencent.mm.bj.e.a(this.fVa, this.hAo, this.fXm);
        break;
      }
      this.vyA = SightVideoJNI.remuxing(this.fVa, this.hAo, this.eXo, this.eXp, com.tencent.mm.plugin.sight.base.b.qSq, com.tencent.mm.plugin.sight.base.b.qSp, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.b.qSr, null, 0, com.tencent.mm.plugin.sight.base.b.qSo, 0, 51);
      break;
      bool = false;
      break label525;
      ab.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
      try
      {
        ??? = new com.tencent.mm.vfs.b(this.hAo).getName();
        localObject3 = this.hAo + ".tmp";
        localPInt = new PInt(0);
        if (!d.b(this.hAo, (String)localObject3, localPInt)) {
          break label1169;
        }
        bool = com.tencent.mm.vfs.e.deleteFile(this.hAo);
        localObject3 = new com.tencent.mm.vfs.b((String)localObject3);
        ab.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(com.tencent.mm.vfs.e.h(((com.tencent.mm.vfs.b)localObject3).getParent() + "/", ((com.tencent.mm.vfs.b)localObject3).getName(), (String)???)), com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject3).dQJ()), this.hAo });
        h.qsU.idkeyStat(354L, 30L, 1L, false);
        ((a)com.tencent.mm.kernel.g.E(a.class)).YH().U(this.fVa, this.hAo, this.vyA);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", new Object[] { localException.toString() });
      }
    }
    label1169:
    if (localPInt.value != 1) {
      h.qsU.idkeyStat(354L, 31L, 1L, false);
    }
    for (;;)
    {
      ab.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.fVa, this.hAo });
      break;
      h.qsU.idkeyStat(354L, 32L, 1L, false);
      h.qsU.e(13836, new Object[] { Integer.valueOf(600), Long.valueOf(bo.aox()), this.hAo });
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(50973);
    ab.i("MicroMsg.ImportMultiVideo", "onPostExecute");
    for (;;)
    {
      synchronized (j.access$700())
      {
        j.bUQ().remove(this.fileName);
        if (this.vyB)
        {
          j.ej(this.hAo, this.vKm);
          j.f(this.vyB, this.fVa, this.hAo);
          if (!com.tencent.mm.plugin.sight.base.b.qSo) {
            break label204;
          }
          i = 1;
          j.a(i, this.vyC, this.fVa, this.hAo, this.vyA);
          if (this.vKm != 1) {
            break label209;
          }
          i = 8;
          if (!this.vyB) {
            break label214;
          }
          j = 1;
          n.alC().a(this.fVa, this.hAo, this.toUser, "", "", i, j);
          ab.i("MicroMsg.ImportMultiVideo", "updateVideo");
          u.v(this.fileName, this.vyA, 43);
          u.vm(this.fileName);
          AppMethodBeat.o(50973);
          return false;
        }
      }
      j.ek(this.hAo, this.vKm);
      continue;
      label204:
      int i = 0;
      continue;
      label209:
      i = 1;
      continue;
      label214:
      int j = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.j.b
 * JD-Core Version:    0.7.0.1
 */
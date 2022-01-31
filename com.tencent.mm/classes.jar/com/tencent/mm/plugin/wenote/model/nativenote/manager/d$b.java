package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bh;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.util.HashMap;

final class d$b
  implements av.a
{
  String eFj;
  VideoTransPara eHv;
  String fileName;
  private int mkJ;
  private int mkK;
  d.a rHJ;
  k rHK;
  String rHT;
  int rHU;
  private boolean rHV;
  private int rHW = 0;
  
  public final boolean JS()
  {
    for (;;)
    {
      synchronized ()
      {
        int i;
        if (!d.cil().containsKey(this.fileName))
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
            y.w("MicroMsg.NoteVideoCompress", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
            return true;
          }
        }
        else
        {
          i = 0;
        }
      }
      int j = 0;
    }
    if ((this.eHv != null) && (!this.eHv.isDefault)) {
      this.mkJ = this.eHv.width;
    }
    Object localObject3;
    for (this.mkK = this.eHv.height;; this.mkK = ???[1])
    {
      ??? = new PString();
      localObject3 = new PInt();
      au.Hx();
      if ((!c.FD().a(this.eFj, (PString)???, (PInt)localObject3)) || (e.r(((PString)???).value, this.rHT) < 0L)) {
        break;
      }
      y.i("MicroMsg.NoteVideoCompress", "copy remuxing file success, do not remuxing again.");
      this.rHU = ((PInt)localObject3).value;
      this.rHV = true;
      return true;
      ??? = new int[2];
      d.c(this.eFj, (int[])???);
      this.mkJ = ???[0];
    }
    long l = bk.UZ();
    if (this.eHv != null)
    {
      y.i("MicroMsg.NoteVideoCompress", "remuxing new para %s", new Object[] { this.eHv });
      this.rHU = SightVideoJNI.remuxing(this.eFj, this.rHT, this.mkJ, this.mkK, this.eHv.videoBitrate, this.eHv.ejP, 8, this.eHv.ejO, 25.0F, this.eHv.fps, null, 0, false);
      this.rHW = ((int)bk.cp(l));
      y.i("MicroMsg.NoteVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.eFj, this.rHT, Integer.valueOf(this.rHU), Integer.valueOf(this.mkJ), Integer.valueOf(this.mkK) });
      if (this.rHU < 0) {
        break label543;
      }
    }
    label543:
    for (boolean bool = true;; bool = false)
    {
      this.rHV = bool;
      ??? = new PInt();
      localObject3 = new PInt();
      if (u.a(this.rHT, (PInt)???, (PInt)localObject3)) {
        this.rHU = ((PInt)???).value;
      }
      if (this.rHV) {
        break label549;
      }
      y.w("MicroMsg.NoteVideoCompress", "remuxing video error, copy source video to send.");
      e.deleteFile(this.rHT);
      e.r(this.eFj, this.rHT);
      return true;
      y.w("MicroMsg.NoteVideoCompress", "remuxing but new para is null. %s", new Object[] { this.fileName });
      this.rHU = SightVideoJNI.remuxing(this.eFj, this.rHT, this.mkJ, this.mkK, com.tencent.mm.plugin.sight.base.b.oeb, com.tencent.mm.plugin.sight.base.b.oea, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.b.oec, null, 0, false);
      break;
    }
    label549:
    y.i("MicroMsg.NoteVideoCompress", "remuxing video sucess,insert to media duplication storage");
    for (;;)
    {
      PInt localPInt;
      try
      {
        localObject3 = new com.tencent.mm.vfs.b(this.rHT);
        ??? = ((com.tencent.mm.vfs.b)localObject3).getName();
        String str = this.rHT + ".tmp";
        localPInt = new PInt(0);
        if (!com.tencent.mm.plugin.a.d.b(this.rHT, str, localPInt)) {
          break label769;
        }
        bool = ((com.tencent.mm.vfs.b)localObject3).delete();
        localObject3 = new com.tencent.mm.vfs.b(str);
        y.i("MicroMsg.NoteVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(e.f(((com.tencent.mm.vfs.b)localObject3).getParent() + "/", ((com.tencent.mm.vfs.b)localObject3).getName(), (String)???)), j.n(((com.tencent.mm.vfs.b)localObject3).cLr()), this.rHT });
        au.Hx();
        c.FD().L(this.eFj, this.rHT, this.rHU);
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.NoteVideoCompress", "fast start exception e[%s]", new Object[] { localException.toString() });
      }
      break;
      label769:
      y.i("MicroMsg.NoteVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.eFj, this.rHT });
    }
  }
  
  public final boolean JT()
  {
    synchronized ()
    {
      d.cil().remove(this.fileName);
      if (this.rHJ != null) {
        this.rHJ.b(this.rHT, this.rHK);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.d.b
 * JD-Core Version:    0.7.0.1
 */
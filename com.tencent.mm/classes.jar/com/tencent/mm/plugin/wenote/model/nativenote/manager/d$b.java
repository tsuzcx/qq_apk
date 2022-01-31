package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bh;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.util.HashMap;

final class d$b
  implements az.a
{
  private int eXo;
  private int eXp;
  String fVa;
  VideoTransPara fXm;
  String fileName;
  String hAo;
  int vyA;
  private boolean vyB;
  private int vyC = 0;
  d.a vyq;
  k vyr;
  
  public final boolean acS()
  {
    AppMethodBeat.i(26756);
    for (;;)
    {
      synchronized (d.access$600())
      {
        int i;
        if (!d.bUP().containsKey(this.fileName))
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
            ab.w("MicroMsg.NoteVideoCompress", "remuxing job has been removed, filename %s", new Object[] { this.fileName });
            AppMethodBeat.o(26756);
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
    if ((this.fXm != null) && (!this.fXm.isDefault)) {
      this.eXo = this.fXm.width;
    }
    Object localObject3;
    for (this.eXp = this.fXm.height;; this.eXp = ???[1])
    {
      ??? = new PString();
      localObject3 = new PInt();
      aw.aaz();
      if ((!c.YH().a(this.fVa, (PString)???, (PInt)localObject3)) || (e.C(((PString)???).value, this.hAo) < 0L)) {
        break;
      }
      ab.i("MicroMsg.NoteVideoCompress", "copy remuxing file success, do not remuxing again.");
      this.vyA = ((PInt)localObject3).value;
      this.vyB = true;
      AppMethodBeat.o(26756);
      return true;
      ??? = new int[2];
      d.c(this.fVa, (int[])???);
      this.eXo = ???[0];
    }
    long l = bo.yB();
    if (this.fXm != null)
    {
      ab.i("MicroMsg.NoteVideoCompress", "remuxing new para %s", new Object[] { this.fXm });
      this.vyA = SightVideoJNI.remuxing(this.fVa, this.hAo, this.eXo, this.eXp, this.fXm.videoBitrate, this.fXm.fzW, 8, this.fXm.fzV, 25.0F, this.fXm.fps, null, 0, false, 0, 51);
      this.vyC = ((int)bo.av(l));
      ab.i("MicroMsg.NoteVideoCompress", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[] { this.fVa, this.hAo, Integer.valueOf(this.vyA), Integer.valueOf(this.eXo), Integer.valueOf(this.eXp) });
      if (this.vyA < 0) {
        break label579;
      }
    }
    label579:
    for (boolean bool = true;; bool = false)
    {
      this.vyB = bool;
      ??? = new PInt();
      localObject3 = new PInt();
      if (u.a(this.hAo, (PInt)???, (PInt)localObject3)) {
        this.vyA = ((PInt)???).value;
      }
      if (this.vyB) {
        break label585;
      }
      ab.w("MicroMsg.NoteVideoCompress", "remuxing video error, copy source video to send.");
      e.deleteFile(this.hAo);
      e.C(this.fVa, this.hAo);
      AppMethodBeat.o(26756);
      return true;
      ab.w("MicroMsg.NoteVideoCompress", "remuxing but new para is null. %s", new Object[] { this.fileName });
      this.vyA = SightVideoJNI.remuxing(this.fVa, this.hAo, this.eXo, this.eXp, com.tencent.mm.plugin.sight.base.b.qSq, com.tencent.mm.plugin.sight.base.b.qSp, 8, 2, 25.0F, com.tencent.mm.plugin.sight.base.b.qSr, null, 0, false, 0, 51);
      break;
    }
    label585:
    ab.i("MicroMsg.NoteVideoCompress", "remuxing video sucess,insert to media duplication storage");
    for (;;)
    {
      PInt localPInt;
      try
      {
        localObject3 = new com.tencent.mm.vfs.b(this.hAo);
        ??? = ((com.tencent.mm.vfs.b)localObject3).getName();
        String str = this.hAo + ".tmp";
        localPInt = new PInt(0);
        if (!com.tencent.mm.plugin.a.d.b(this.hAo, str, localPInt)) {
          break label806;
        }
        bool = ((com.tencent.mm.vfs.b)localObject3).delete();
        localObject3 = new com.tencent.mm.vfs.b(str);
        ab.i("MicroMsg.NoteVideoCompress", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(e.h(((com.tencent.mm.vfs.b)localObject3).getParent() + "/", ((com.tencent.mm.vfs.b)localObject3).getName(), (String)???)), j.p(((com.tencent.mm.vfs.b)localObject3).dQJ()), this.hAo });
        aw.aaz();
        c.YH().U(this.fVa, this.hAo, this.vyA);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.NoteVideoCompress", "fast start exception e[%s]", new Object[] { localException.toString() });
      }
      break;
      label806:
      ab.i("MicroMsg.NoteVideoCompress", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", new Object[] { Integer.valueOf(localPInt.value), this.fVa, this.hAo });
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(26757);
    synchronized (d.access$600())
    {
      d.bUP().remove(this.fileName);
      if (this.vyq != null) {
        this.vyq.b(this.hAo, this.vyr);
      }
      AppMethodBeat.o(26757);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.d.b
 * JD-Core Version:    0.7.0.1
 */
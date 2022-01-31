package com.tencent.mm.plugin.record.b;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.b;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;

final class k$c
  implements Runnable
{
  private g nsL;
  
  public k$c(k paramk, g paramg)
  {
    this.nsL = paramg;
  }
  
  public final void run()
  {
    Object localObject = this.nsL.field_dataProto.sXc.iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
    {
      label16:
      xv localxv = (xv)((Iterator)localObject).next();
      gf localgf = new gf();
      localgf.bNF.type = 2;
      localgf.bNF.bNH = localxv;
      com.tencent.mm.sdk.b.a.udP.m(localgf);
      y.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[] { localxv.kgC, Integer.valueOf(localxv.aYU) });
      String str;
      if (!bk.bl(localgf.bNG.path))
      {
        str = h.c(localxv, this.nsL.field_msgId);
        y.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[] { localgf.bNG.path, str });
        if (!localgf.bNG.path.equals(str)) {
          e.r(localgf.bNG.path, str);
        }
      }
      if (!bk.bl(localgf.bNG.thumbPath))
      {
        str = h.f(localxv, this.nsL.field_msgId);
        y.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[] { localgf.bNG.thumbPath, str });
        if (!localgf.bNG.thumbPath.equals(str)) {
          e.r(localgf.bNG.thumbPath, str);
        }
      }
      if (localxv.aYU == 3)
      {
        y.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
        localxv.Xz("");
        localxv.Xy("");
        localxv.Xx("");
        localxv.Xw("");
      }
      if ((bk.bl(localxv.sUG)) && (bk.bl(localxv.dQL))) {
        break label16;
      }
    }
    if (i != 0)
    {
      au.Dk().a(new a(this.nsL), 0);
      return;
    }
    localObject = g.a.a(h.a(this.nsL.field_title, this.nsL.field_desc, this.nsL.field_dataProto), null, null);
    this.ntj.d(this.nsL.field_msgId, this.nsL.field_localId, (String)localObject);
    this.ntj.nsO = false;
    this.ntj.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.k.c
 * JD-Core Version:    0.7.0.1
 */
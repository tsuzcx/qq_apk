package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gi.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;

final class q$c
  implements Runnable
{
  private j pYr;
  
  public q$c(q paramq, j paramj)
  {
    this.pYr = paramj;
  }
  
  public final void run()
  {
    AppMethodBeat.i(135735);
    ab.i("MicroMsg.RecordMsgSendService", "dojob FavDataCopyRunnable, info id:%s", new Object[] { Long.valueOf(this.pYr.field_msgId) });
    Object localObject = this.pYr.field_dataProto.wVc.iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = 1)
    {
      label45:
      aca localaca = (aca)((Iterator)localObject).next();
      gi localgi = new gi();
      localgi.cuX.type = 2;
      localgi.cuX.cuZ = localaca;
      a.ymk.l(localgi);
      ab.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[] { localaca.mBq, Integer.valueOf(localaca.dataType) });
      String str;
      if (!bo.isNullOrNil(localgi.cuY.path))
      {
        str = n.c(localaca, this.pYr.field_msgId);
        ab.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[] { localgi.cuY.path, str });
        if (!localgi.cuY.path.equals(str)) {
          e.C(localgi.cuY.path, str);
        }
      }
      if (!bo.isNullOrNil(localgi.cuY.thumbPath))
      {
        str = n.f(localaca, this.pYr.field_msgId);
        ab.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[] { localgi.cuY.thumbPath, str });
        if (!localgi.cuY.thumbPath.equals(str)) {
          e.C(localgi.cuY.thumbPath, str);
        }
      }
      if (localaca.dataType == 3)
      {
        ab.w("MicroMsg.RecordMsgSendService", "match voice type, clear cdn info");
        localaca.anv("");
        localaca.anu("");
        localaca.ant("");
        localaca.ans("");
      }
      if ((bo.isNullOrNil(localaca.wSC)) && (bo.isNullOrNil(localaca.fgM))) {
        break label45;
      }
    }
    if (i != 0)
    {
      g.RK().eHt.a(new f(this.pYr), 0);
      AppMethodBeat.o(135735);
      return;
    }
    localObject = j.b.a(n.a(this.pYr.field_title, this.pYr.field_desc, this.pYr.field_dataProto), null, null);
    this.pYR.d(this.pYr.field_msgId, this.pYr.field_localId, (String)localObject);
    this.pYR.pYu = false;
    this.pYR.a(null, false);
    AppMethodBeat.o(135735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.q.c
 * JD-Core Version:    0.7.0.1
 */
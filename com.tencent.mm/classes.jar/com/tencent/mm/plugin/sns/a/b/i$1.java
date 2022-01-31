package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.protocal.protobuf.cec;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class i$1
  implements Runnable
{
  i$1(i parami, int paramInt, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(35750);
    ayx localayx = new ayx();
    localayx.xoo = this.qZY;
    localayx.xov = ((int)(System.currentTimeMillis() / 1000L));
    localayx.jJu = 1;
    String str = i.t(this.qZZ);
    localayx.xop = new b(str.getBytes());
    i.a(this.raa).wok.add(localayx);
    ab.i("MicroMsg.SnsLogMgr", "snsadlog " + this.qZY + " " + str);
    if (i.b(this.raa) == 0L) {
      i.a(this.raa, System.currentTimeMillis());
    }
    AppMethodBeat.o(35750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.i.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.qqmail.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.qqmail.d.ar;
import com.tencent.mm.plugin.qqmail.e.b;
import com.tencent.mm.sdk.platformtools.Log;

public class g
  implements i, com.tencent.mm.ipcinvoker.d<IPCVoid, IPCInteger>
{
  private f<IPCInteger> jZn;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(249814);
    Log.i("MicroMsg.GetUnreadMailCountTask", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    h.aGY().b(12213, this);
    if (this.jZn != null)
    {
      paramInt1 = ((ar)d.c.b(((b)paramq).lKU.lBS)).HnA;
      this.jZn.aH(new IPCInteger(paramInt1));
    }
    AppMethodBeat.o(249814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.g
 * JD-Core Version:    0.7.0.1
 */
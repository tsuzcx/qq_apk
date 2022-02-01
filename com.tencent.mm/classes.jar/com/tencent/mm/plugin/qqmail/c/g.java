package com.tencent.mm.plugin.qqmail.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.qqmail.d.ar;
import com.tencent.mm.sdk.platformtools.Log;

public class g
  implements i, com.tencent.mm.ipcinvoker.b<IPCVoid, IPCInteger>
{
  private com.tencent.mm.ipcinvoker.d<IPCInteger> hny;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(198584);
    Log.i("MicroMsg.GetUnreadMailCountTask", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.kernel.g.azz().b(12213, this);
    if (this.hny != null)
    {
      paramInt1 = ((ar)((com.tencent.mm.plugin.qqmail.e.b)paramq).iUB.iLL.iLR).Btg;
      this.hny.bn(new IPCInteger(paramInt1));
    }
    AppMethodBeat.o(198584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.g
 * JD-Core Version:    0.7.0.1
 */
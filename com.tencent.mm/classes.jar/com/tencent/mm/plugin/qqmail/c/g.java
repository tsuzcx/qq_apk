package com.tencent.mm.plugin.qqmail.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.qqmail.d.ar;
import com.tencent.mm.sdk.platformtools.ad;

public class g
  implements f, com.tencent.mm.ipcinvoker.b<IPCVoid, IPCInteger>
{
  private d<IPCInteger> gyc;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(215184);
    ad.i("MicroMsg.GetUnreadMailCountTask", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.kernel.g.aiU().b(12213, this);
    if (this.gyc != null)
    {
      paramInt1 = ((ar)((com.tencent.mm.plugin.qqmail.e.b)paramn).hWL.hNL.hNQ).xdm;
      this.gyc.be(new IPCInteger(paramInt1));
    }
    AppMethodBeat.o(215184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.qqmail.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.qqmail.d.b;
import com.tencent.mm.plugin.qqmail.model.aq;
import com.tencent.mm.sdk.platformtools.Log;

public class g
  implements com.tencent.mm.am.h, d<IPCVoid, IPCInteger>
{
  private f<IPCInteger> mzo;
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(266871);
    Log.i("MicroMsg.GetUnreadMailCountTask", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.kernel.h.aZW().b(12213, this);
    if (this.mzo != null)
    {
      paramInt1 = ((aq)c.c.b(((b)paramp).oDw.otC)).Nlo;
      this.mzo.onCallback(new IPCInteger(paramInt1));
    }
    AppMethodBeat.o(266871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.g
 * JD-Core Version:    0.7.0.1
 */
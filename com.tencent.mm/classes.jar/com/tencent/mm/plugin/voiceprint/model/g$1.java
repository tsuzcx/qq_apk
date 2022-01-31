package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.sdk.platformtools.ab;

final class g$1
  implements Runnable
{
  g$1(g paramg, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(26091);
    new k().doScene(this.trk.dispatcher(), new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(26090);
        ab.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymousm.getType()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          g.1.this.trk.callback.onSceneEnd(paramAnonymousInt1, paramAnonymousInt2, "", g.1.this.trk);
          AppMethodBeat.o(26090);
          return;
        }
        g.1.this.trk.doScene(g.1.this.trk.dispatcher(), g.1.this.trk.callback);
        AppMethodBeat.o(26090);
      }
    });
    AppMethodBeat.o(26091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.g.1
 * JD-Core Version:    0.7.0.1
 */
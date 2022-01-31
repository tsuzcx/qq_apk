package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  implements Runnable
{
  e$1(e parame, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(26082);
    new k().doScene(this.trc.dispatcher(), new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(26081);
        ab.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymousm.getType()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          e.1.this.trc.callback.onSceneEnd(paramAnonymousInt1, paramAnonymousInt2, "", e.1.this.trc);
          AppMethodBeat.o(26081);
          return;
        }
        e.1.this.trc.doScene(e.1.this.trc.dispatcher(), e.1.this.trc.callback);
        AppMethodBeat.o(26081);
      }
    });
    AppMethodBeat.o(26082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.e.1
 * JD-Core Version:    0.7.0.1
 */
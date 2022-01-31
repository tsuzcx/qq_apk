package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;

final class g$1
  implements Runnable
{
  g$1(g.a parama, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(79255);
    Object localObject = as.eu("key_open_sdk_pkg", 1);
    if (localObject == null)
    {
      this.vLb.a(null);
      AppMethodBeat.o(79255);
      return;
    }
    ((as)localObject).encode(this.val$appId, this.Cl);
    localObject = g.bZ(this.val$appId, true);
    this.vLb.a((f)localObject);
    AppMethodBeat.o(79255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g.1
 * JD-Core Version:    0.7.0.1
 */
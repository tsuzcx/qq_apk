package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;

final class g$2
  implements Runnable
{
  g$2(ShowMessageFromWX.Req paramReq, String paramString, Context paramContext, ai paramai) {}
  
  public final void run()
  {
    AppMethodBeat.i(151612);
    Bundle localBundle = new Bundle();
    this.vLc.toBundle(localBundle);
    p.aC(localBundle);
    p.aD(localBundle);
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.targetPkgName = this.Cl;
    localArgs.bundle = localBundle;
    boolean bool = MMessageActV2.send(this.val$context, localArgs);
    if (this.kZN != null) {
      this.kZN.dZ(bool);
    }
    AppMethodBeat.o(151612);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g.2
 * JD-Core Version:    0.7.0.1
 */
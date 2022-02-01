package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;

final class h$3
  implements Runnable
{
  h$3(ShowMessageFromWX.Req paramReq, String paramString, Context paramContext, ap paramap) {}
  
  public final void run()
  {
    AppMethodBeat.i(184258);
    Bundle localBundle = new Bundle();
    this.XSg.toBundle(localBundle);
    u.bS(localBundle);
    u.bT(localBundle);
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.targetPkgName = this.bJT;
    localArgs.bundle = localBundle;
    boolean bool = MMessageActV2.send(this.val$context, localArgs);
    if (this.xpd != null) {
      this.xpd.onLaunchApp(bool, false);
    }
    AppMethodBeat.o(184258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.h.3
 * JD-Core Version:    0.7.0.1
 */
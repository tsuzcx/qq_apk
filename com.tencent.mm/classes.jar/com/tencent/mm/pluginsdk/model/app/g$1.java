package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;

final class g$1
  implements Runnable
{
  g$1(ShowMessageFromWX.Req paramReq, String paramString, Context paramContext, am paramam) {}
  
  public final void run()
  {
    Bundle localBundle = new Bundle();
    this.rUe.toBundle(localBundle);
    p.ak(localBundle);
    p.al(localBundle);
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.targetPkgName = this.Bz;
    localArgs.bundle = localBundle;
    boolean bool = MMessageActV2.send(this.val$context, localArgs);
    if (this.iRo != null) {
      this.iRo.cW(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.g.1
 * JD-Core Version:    0.7.0.1
 */
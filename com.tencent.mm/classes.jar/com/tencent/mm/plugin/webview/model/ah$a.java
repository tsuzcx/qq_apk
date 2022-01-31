package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.c;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ab;

public final class ah$a
{
  public static Bundle dbT()
  {
    AppMethodBeat.i(6659);
    String str = g.Nr().R("WebViewConfig", "oauthHostPath");
    ab.d("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths : %s", new Object[] { str });
    Bundle localBundle = new Bundle();
    localBundle.putString("oauth_host_paths", str);
    AppMethodBeat.o(6659);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ah.a
 * JD-Core Version:    0.7.0.1
 */
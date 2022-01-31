package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.m.c;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.y;

public final class ac$a
{
  public static Bundle cbQ()
  {
    String str = g.AB().H("WebViewConfig", "oauthHostPath");
    y.d("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths : %s", new Object[] { str });
    Bundle localBundle = new Bundle();
    localBundle.putString("oauth_host_paths", str);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac.a
 * JD-Core Version:    0.7.0.1
 */
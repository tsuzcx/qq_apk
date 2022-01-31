package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.c;
import com.tencent.mm.m.g;

public final class a$b
{
  public static Bundle dbH()
  {
    AppMethodBeat.i(6564);
    String str = g.Nr().R("WebViewConfig", "mediaEnableAutoPlayHostPaths");
    Bundle localBundle = new Bundle();
    localBundle.putString("enable_auto_play_host_paths", str);
    AppMethodBeat.o(6564);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.a.b
 * JD-Core Version:    0.7.0.1
 */
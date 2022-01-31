package com.tencent.mm.plugin.webview.luggage;

import android.webkit.WebResourceResponse;
import com.tencent.luggage.webview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public final class LuggageMMLocalResourceProvider
  implements c
{
  public final WebResourceResponse bG(String paramString)
  {
    AppMethodBeat.i(5987);
    PipedOutputStream localPipedOutputStream = new PipedOutputStream();
    try
    {
      PipedInputStream localPipedInputStream = new PipedInputStream(localPipedOutputStream);
      LuggageMMLocalResourceProvider.GetLocalResourceInfoTask localGetLocalResourceInfoTask = new LuggageMMLocalResourceProvider.GetLocalResourceInfoTask((byte)0);
      localGetLocalResourceInfoTask.ctV = paramString;
      localGetLocalResourceInfoTask.infoType = 1;
      localGetLocalResourceInfoTask.hzK = new LuggageMMLocalResourceProvider.1(this, localGetLocalResourceInfoTask, localPipedOutputStream);
      AppBrandMainProcessService.a(localGetLocalResourceInfoTask);
      paramString = new WebResourceResponse("image/*", "utf-8", localPipedInputStream);
      AppMethodBeat.o(5987);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(5987);
    }
    return null;
  }
  
  public final String xd()
  {
    return "weixin://resourceid/.*";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider
 * JD-Core Version:    0.7.0.1
 */
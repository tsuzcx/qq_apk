package com.tencent.mm.plugin.webview.luggage;

import android.webkit.WebResourceResponse;
import com.tencent.luggage.webview.a.c;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public final class LuggageMMLocalResourceProvider
  implements c
{
  public final WebResourceResponse bf(String paramString)
  {
    PipedOutputStream localPipedOutputStream = new PipedOutputStream();
    try
    {
      PipedInputStream localPipedInputStream = new PipedInputStream(localPipedOutputStream);
      LuggageMMLocalResourceProvider.GetLocalResourceInfoTask localGetLocalResourceInfoTask = new LuggageMMLocalResourceProvider.GetLocalResourceInfoTask((byte)0);
      localGetLocalResourceInfoTask.bMB = paramString;
      localGetLocalResourceInfoTask.infoType = 1;
      localGetLocalResourceInfoTask.ghz = new LuggageMMLocalResourceProvider.1(this, localGetLocalResourceInfoTask, localPipedOutputStream);
      LuggageMainProcessService.a(localGetLocalResourceInfoTask);
      return new WebResourceResponse("image/*", "utf-8", localPipedInputStream);
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public final String qx()
  {
    return "weixin://resourceid/.*";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider
 * JD-Core Version:    0.7.0.1
 */
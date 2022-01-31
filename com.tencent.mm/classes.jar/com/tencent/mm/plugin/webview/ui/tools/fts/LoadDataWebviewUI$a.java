package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.xweb.WebView;
import java.util.concurrent.CountDownLatch;

public class LoadDataWebviewUI$a
  extends WebViewUI.h
{
  protected LoadDataWebviewUI$a(LoadDataWebviewUI paramLoadDataWebviewUI)
  {
    super(paramLoadDataWebviewUI);
  }
  
  public void b(final WebView paramWebView, final String paramString)
  {
    AppMethodBeat.i(8553);
    d.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8551);
        try
        {
          LoadDataWebviewUI.a(LoadDataWebviewUI.a.this.vll).await();
          al.d(new LoadDataWebviewUI.a.2.1(this));
          AppMethodBeat.o(8551);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.WebSearch.LoadDataWebviewUI", localInterruptedException, null, new Object[0]);
          }
        }
      }
    }, "LoadDataWebviewClient_onPageStarted");
    AppMethodBeat.o(8553);
  }
  
  public void b(final WebView paramWebView, final String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(8552);
    d.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8549);
        try
        {
          LoadDataWebviewUI.a(LoadDataWebviewUI.a.this.vll).await();
          al.d(new LoadDataWebviewUI.a.1.1(this));
          AppMethodBeat.o(8549);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.WebSearch.LoadDataWebviewUI", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }, "LoadDataWebviewClient_onPageStarted");
    AppMethodBeat.o(8552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI.a
 * JD-Core Version:    0.7.0.1
 */
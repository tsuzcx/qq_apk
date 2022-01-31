package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import java.util.concurrent.CountDownLatch;

public class LoadDataWebviewUI$a
  extends WebViewUI.i
{
  protected LoadDataWebviewUI$a(LoadDataWebviewUI paramLoadDataWebviewUI)
  {
    super(paramLoadDataWebviewUI);
  }
  
  public void a(final WebView paramWebView, final String paramString)
  {
    e.post(new Runnable()
    {
      public final void run()
      {
        try
        {
          LoadDataWebviewUI.a(LoadDataWebviewUI.a.this.ruW).await();
          ai.d(new LoadDataWebviewUI.a.2.1(this));
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            y.printErrStackTrace("LoadDataWebviewUI", localInterruptedException, null, new Object[0]);
          }
        }
      }
    }, "LoadDataWebviewClient_onPageStarted");
  }
  
  public void b(final WebView paramWebView, final String paramString, final Bitmap paramBitmap)
  {
    e.post(new Runnable()
    {
      public final void run()
      {
        try
        {
          LoadDataWebviewUI.a(LoadDataWebviewUI.a.this.ruW).await();
          ai.d(new LoadDataWebviewUI.a.1.1(this));
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            y.printErrStackTrace("LoadDataWebviewUI", localInterruptedException, "", new Object[0]);
          }
        }
      }
    }, "LoadDataWebviewClient_onPageStarted");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webview.modeltools;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.charset.Charset;

public final class WebViewClipBoardHelper
  implements ClipboardManager.OnPrimaryClipChangedListener
{
  private long lastReportTime = 0L;
  private WebViewUI riN;
  public ClipboardManager riO;
  
  public WebViewClipBoardHelper(WebViewUI paramWebViewUI)
  {
    this.riN = paramWebViewUI;
    this.riO = ((ClipboardManager)paramWebViewUI.getApplicationContext().getSystemService("clipboard"));
    try
    {
      this.riO.addPrimaryClipChangedListener(this);
      return;
    }
    catch (Exception paramWebViewUI) {}
  }
  
  public final void onPrimaryClipChanged()
  {
    long l = System.currentTimeMillis();
    if (l - this.lastReportTime < 200L) {}
    Object localObject;
    do
    {
      do
      {
        return;
        this.lastReportTime = l;
        localObject = this.riO.getPrimaryClip();
      } while (localObject == null);
      localObject = ((ClipData)localObject).getItemAt(0);
    } while (localObject == null);
    WebViewClipBoardHelper.ClipBoardDataWrapper localClipBoardDataWrapper = new WebViewClipBoardHelper.ClipBoardDataWrapper();
    localClipBoardDataWrapper.url = this.riN.cdR();
    if (bk.L(((ClipData.Item)localObject).getText()))
    {
      y.w("MicroMsg.WebViewClipBoardHelper", "onPrimaryClipChanged text is null");
      return;
    }
    localClipBoardDataWrapper.length = ((ClipData.Item)localObject).getText().toString().getBytes(Charset.forName("UTF-8")).length;
    localClipBoardDataWrapper.fromScene = this.riN.getIntent().getIntExtra("from_scence", 0);
    localClipBoardDataWrapper.username = this.riN.getIntent().getStringExtra("geta8key_username");
    XIPCInvoker.a("com.tencent.mm", localClipBoardDataWrapper, WebViewClipBoardHelper.a.class, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper
 * JD-Core Version:    0.7.0.1
 */
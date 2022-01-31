package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.model.d.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

final class WebViewStubService$4
  implements d.a
{
  WebViewStubService$4(WebViewStubService paramWebViewStubService) {}
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    y.i("MicroMsg.WebViewStubService", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    if (paramBoolean) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("webview_jssdk_file_item_local_id", paramString1);
        localBundle.putInt("webview_jssdk_file_item_progreess", paramInt2);
        Iterator localIterator = WebViewStubService.h(this.rkg).iterator();
        while (localIterator.hasNext()) {
          ((WebViewStubCallbackWrapper)localIterator.next()).rno.b(2011, localBundle);
        }
        switch (paramInt1)
        {
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", new Object[] { localException.getMessage() });
      }
    }
    y.e("MicroMsg.WebViewStubService", "unsupport media type : %d", new Object[] { Integer.valueOf(paramInt1) });
    for (;;)
    {
      return;
      if (paramBoolean) {
        try
        {
          paramString2 = new Bundle();
          paramString2.putString("webview_jssdk_file_item_local_id", paramString1);
          paramString2.putInt("webview_jssdk_file_item_progreess", paramInt2);
          paramString1 = WebViewStubService.h(this.rkg).iterator();
          while (paramString1.hasNext()) {
            ((WebViewStubCallbackWrapper)paramString1.next()).rno.b(2003, paramString2);
          }
          try
          {
            paramString1 = new Bundle();
            paramString1.putString("webview_jssdk_file_item_server_id", paramString2);
            paramString1.putInt("webview_jssdk_file_item_progreess", paramInt2);
            paramString2 = WebViewStubService.h(this.rkg).iterator();
            while (paramString2.hasNext()) {
              ((WebViewStubCallbackWrapper)paramString2.next()).rno.b(2004, paramString1);
            }
            if (!paramBoolean) {
              break label500;
            }
          }
          catch (Exception paramString1)
          {
            y.e("MicroMsg.WebViewStubService", "notify download image failed :%s", new Object[] { paramString1.getMessage() });
            return;
          }
        }
        catch (Exception paramString1)
        {
          y.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", new Object[] { paramString1.getMessage() });
          return;
        }
      }
      try
      {
        paramString2 = new Bundle();
        paramString2.putString("webview_jssdk_file_item_local_id", paramString1);
        paramString2.putInt("webview_jssdk_file_item_progreess", paramInt2);
        paramString1 = WebViewStubService.h(this.rkg).iterator();
        while (paramString1.hasNext()) {
          ((WebViewStubCallbackWrapper)paramString1.next()).rno.b(2005, paramString2);
        }
        try
        {
          paramString1 = new Bundle();
          paramString1.putString("webview_jssdk_file_item_server_id", paramString2);
          paramString1.putInt("webview_jssdk_file_item_progreess", paramInt2);
          paramString2 = WebViewStubService.h(this.rkg).iterator();
          while (paramString2.hasNext()) {
            ((WebViewStubCallbackWrapper)paramString2.next()).rno.b(2006, paramString1);
          }
          if (!paramBoolean) {
            continue;
          }
        }
        catch (Exception paramString1)
        {
          y.e("MicroMsg.WebViewStubService", "notify download voice failed :%s", new Object[] { paramString1.getMessage() });
          return;
        }
      }
      catch (Exception paramString1)
      {
        y.e("MicroMsg.WebViewStubService", "notify upload voice failed :%s", new Object[] { paramString1.getMessage() });
        return;
      }
      try
      {
        label500:
        paramString2 = new Bundle();
        paramString2.putString("webview_jssdk_file_item_local_id", paramString1);
        paramString2.putInt("webview_jssdk_file_item_progreess", paramInt2);
        paramString1 = WebViewStubService.h(this.rkg).iterator();
        while (paramString1.hasNext()) {
          ((WebViewStubCallbackWrapper)paramString1.next()).rno.b(2010, paramString2);
        }
        return;
      }
      catch (Exception paramString1)
      {
        y.e("MicroMsg.WebViewStubService", "notify upload video failed :%s", new Object[] { paramString1.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.4
 * JD-Core Version:    0.7.0.1
 */
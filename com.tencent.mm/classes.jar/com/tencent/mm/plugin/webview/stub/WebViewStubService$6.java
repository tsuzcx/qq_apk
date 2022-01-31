package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.d.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

final class WebViewStubService$6
  implements d.a
{
  WebViewStubService$6(WebViewStubService paramWebViewStubService)
  {
    AppMethodBeat.i(7202);
    AppMethodBeat.o(7202);
  }
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(155692);
    ab.i("MicroMsg.WebViewStubService", "onWebView cdn callback progress, upload : %b, mediaType : %d, percent : %d, localid : %s, mediaId : %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2 });
    if (paramBoolean) {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("webview_jssdk_file_item_local_id", paramString1);
        localBundle.putInt("webview_jssdk_file_item_progreess", paramInt2);
        Iterator localIterator = WebViewStubService.f(this.uZy).iterator();
        while (localIterator.hasNext()) {
          ((WebViewStubCallbackWrapper)localIterator.next()).vdZ.e(2011, localBundle);
        }
        switch (paramInt1)
        {
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", new Object[] { localException.getMessage() });
      }
    }
    ab.e("MicroMsg.WebViewStubService", "unsupport media type : %d", new Object[] { Integer.valueOf(paramInt1) });
    do
    {
      AppMethodBeat.o(155692);
      return;
      if (paramBoolean)
      {
        try
        {
          paramString2 = new Bundle();
          paramString2.putString("webview_jssdk_file_item_local_id", paramString1);
          paramString2.putInt("webview_jssdk_file_item_progreess", paramInt2);
          paramString1 = WebViewStubService.f(this.uZy).iterator();
          while (paramString1.hasNext()) {
            ((WebViewStubCallbackWrapper)paramString1.next()).vdZ.e(2003, paramString2);
          }
          AppMethodBeat.o(155692);
        }
        catch (Exception paramString1)
        {
          ab.e("MicroMsg.WebViewStubService", "notify upload image failed :%s", new Object[] { paramString1.getMessage() });
          AppMethodBeat.o(155692);
          return;
        }
        return;
      }
      try
      {
        paramString1 = new Bundle();
        paramString1.putString("webview_jssdk_file_item_server_id", paramString2);
        paramString1.putInt("webview_jssdk_file_item_progreess", paramInt2);
        paramString2 = WebViewStubService.f(this.uZy).iterator();
        while (paramString2.hasNext()) {
          ((WebViewStubCallbackWrapper)paramString2.next()).vdZ.e(2004, paramString1);
        }
        AppMethodBeat.o(155692);
      }
      catch (Exception paramString1)
      {
        ab.e("MicroMsg.WebViewStubService", "notify download image failed :%s", new Object[] { paramString1.getMessage() });
        AppMethodBeat.o(155692);
        return;
      }
      return;
      if (paramBoolean)
      {
        try
        {
          paramString2 = new Bundle();
          paramString2.putString("webview_jssdk_file_item_local_id", paramString1);
          paramString2.putInt("webview_jssdk_file_item_progreess", paramInt2);
          paramString1 = WebViewStubService.f(this.uZy).iterator();
          while (paramString1.hasNext()) {
            ((WebViewStubCallbackWrapper)paramString1.next()).vdZ.e(2005, paramString2);
          }
          AppMethodBeat.o(155692);
        }
        catch (Exception paramString1)
        {
          ab.e("MicroMsg.WebViewStubService", "notify upload voice failed :%s", new Object[] { paramString1.getMessage() });
          AppMethodBeat.o(155692);
          return;
        }
        return;
      }
      try
      {
        paramString1 = new Bundle();
        paramString1.putString("webview_jssdk_file_item_server_id", paramString2);
        paramString1.putInt("webview_jssdk_file_item_progreess", paramInt2);
        paramString2 = WebViewStubService.f(this.uZy).iterator();
        while (paramString2.hasNext()) {
          ((WebViewStubCallbackWrapper)paramString2.next()).vdZ.e(2006, paramString1);
        }
        AppMethodBeat.o(155692);
      }
      catch (Exception paramString1)
      {
        ab.e("MicroMsg.WebViewStubService", "notify download voice failed :%s", new Object[] { paramString1.getMessage() });
        AppMethodBeat.o(155692);
        return;
      }
      return;
    } while (!paramBoolean);
    try
    {
      paramString2 = new Bundle();
      paramString2.putString("webview_jssdk_file_item_local_id", paramString1);
      paramString2.putInt("webview_jssdk_file_item_progreess", paramInt2);
      paramString1 = WebViewStubService.f(this.uZy).iterator();
      while (paramString1.hasNext()) {
        ((WebViewStubCallbackWrapper)paramString1.next()).vdZ.e(2010, paramString2);
      }
      AppMethodBeat.o(155692);
    }
    catch (Exception paramString1)
    {
      ab.e("MicroMsg.WebViewStubService", "notify upload video failed :%s", new Object[] { paramString1.getMessage() });
      AppMethodBeat.o(155692);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.xweb.x5;

import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import com.tencent.xweb.af;
import java.util.Map;
import org.xwalk.core.Log;

public final class a
{
  public static com.tencent.smtt.export.external.interfaces.WebResourceResponse b(com.tencent.xweb.WebResourceResponse paramWebResourceResponse)
  {
    AppMethodBeat.i(153830);
    if (paramWebResourceResponse == null)
    {
      AppMethodBeat.o(153830);
      return null;
    }
    if ((paramWebResourceResponse.aifn) && (Build.VERSION.SDK_INT >= 21)) {
      try
      {
        com.tencent.smtt.export.external.interfaces.WebResourceResponse localWebResourceResponse1 = new com.tencent.smtt.export.external.interfaces.WebResourceResponse(paramWebResourceResponse.mMimeType, paramWebResourceResponse.mEncoding, paramWebResourceResponse.mStatusCode, paramWebResourceResponse.mReasonPhrase, paramWebResourceResponse.mResponseHeaders, paramWebResourceResponse.mInputStream);
        AppMethodBeat.o(153830);
        return localWebResourceResponse1;
      }
      finally
      {
        Log.e("WCWebToX5DataTrans", "create webkit WebResourceResponse error:".concat(String.valueOf(localObject)));
      }
    }
    com.tencent.smtt.export.external.interfaces.WebResourceResponse localWebResourceResponse2 = new com.tencent.smtt.export.external.interfaces.WebResourceResponse(paramWebResourceResponse.mMimeType, paramWebResourceResponse.mEncoding, paramWebResourceResponse.mInputStream);
    if ((paramWebResourceResponse.mStatusCode > 100) && (paramWebResourceResponse.mReasonPhrase != null) && (!paramWebResourceResponse.mReasonPhrase.isEmpty())) {
      localWebResourceResponse2.setStatusCodeAndReasonPhrase(paramWebResourceResponse.mStatusCode, paramWebResourceResponse.mReasonPhrase);
    }
    localWebResourceResponse2.setResponseHeaders(paramWebResourceResponse.mResponseHeaders);
    AppMethodBeat.o(153830);
    return localWebResourceResponse2;
  }
  
  public static final class c
    implements com.tencent.smtt.export.external.interfaces.JsResult
  {
    public com.tencent.xweb.JsResult aimS;
    
    public c(com.tencent.xweb.JsResult paramJsResult)
    {
      this.aimS = paramJsResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(153815);
      this.aimS.cancel();
      AppMethodBeat.o(153815);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(153814);
      this.aimS.confirm();
      AppMethodBeat.o(153814);
    }
  }
  
  public static final class e
    implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
  {
    public com.tencent.xweb.WebResourceRequest aimU;
    
    private e(com.tencent.xweb.WebResourceRequest paramWebResourceRequest)
    {
      this.aimU = paramWebResourceRequest;
    }
    
    public static com.tencent.smtt.export.external.interfaces.WebResourceRequest a(com.tencent.xweb.WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(153817);
      if (paramWebResourceRequest == null)
      {
        AppMethodBeat.o(153817);
        return null;
      }
      paramWebResourceRequest = new e(paramWebResourceRequest);
      AppMethodBeat.o(153817);
      return paramWebResourceRequest;
    }
    
    public final String getMethod()
    {
      AppMethodBeat.i(153821);
      String str = this.aimU.getMethod();
      AppMethodBeat.o(153821);
      return str;
    }
    
    public final Map<String, String> getRequestHeaders()
    {
      AppMethodBeat.i(153822);
      Map localMap = this.aimU.getRequestHeaders();
      AppMethodBeat.o(153822);
      return localMap;
    }
    
    public final Uri getUrl()
    {
      AppMethodBeat.i(153818);
      Uri localUri = this.aimU.getUrl();
      AppMethodBeat.o(153818);
      return localUri;
    }
    
    public final boolean hasGesture()
    {
      AppMethodBeat.i(153820);
      boolean bool = this.aimU.hasGesture();
      AppMethodBeat.o(153820);
      return bool;
    }
    
    public final boolean isForMainFrame()
    {
      AppMethodBeat.i(153819);
      boolean bool = this.aimU.isForMainFrame();
      AppMethodBeat.o(153819);
      return bool;
    }
    
    public final boolean isRedirect()
    {
      return false;
    }
  }
  
  public static final class f
    implements WebViewCallbackClient
  {
    private WebView aimV;
    private int oG = -1;
    private af sLl;
    
    public f(WebView paramWebView, af paramaf)
    {
      this.aimV = paramWebView;
      this.sLl = paramaf;
    }
    
    public final void computeScroll(View paramView)
    {
      AppMethodBeat.i(153826);
      if (this.sLl != null) {
        this.sLl.computeScroll(paramView);
      }
      AppMethodBeat.o(153826);
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(153825);
      if (this.sLl != null)
      {
        boolean bool = this.sLl.dispatchTouchEvent(paramMotionEvent, paramView);
        AppMethodBeat.o(153825);
        return bool;
      }
      AppMethodBeat.o(153825);
      return false;
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(213144);
      if (this.aimV != null)
      {
        int i = this.aimV.getContentHeight();
        if (i != this.oG)
        {
          this.oG = i;
          if (this.sLl != null)
          {
            Log.i("WCWebToX5DataTrans", "x5-syskernel, onContentHeightChanged, height:".concat(String.valueOf(i)));
            this.sLl.Bv(i);
          }
        }
      }
      AppMethodBeat.o(213144);
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(153828);
      if (this.sLl != null)
      {
        boolean bool = this.sLl.onInterceptTouchEvent(paramMotionEvent, paramView);
        AppMethodBeat.o(153828);
        return bool;
      }
      AppMethodBeat.o(153828);
      return false;
    }
    
    public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
    {
      AppMethodBeat.i(153827);
      if (this.sLl != null) {
        this.sLl.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramView);
      }
      AppMethodBeat.o(153827);
    }
    
    public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
    {
      AppMethodBeat.i(153829);
      if (this.sLl != null) {
        this.sLl.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
      }
      AppMethodBeat.o(153829);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(153823);
      if (this.sLl != null)
      {
        boolean bool = this.sLl.onTouchEvent(paramMotionEvent, paramView);
        AppMethodBeat.o(153823);
        return bool;
      }
      AppMethodBeat.o(153823);
      return false;
    }
    
    public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
    {
      AppMethodBeat.i(153824);
      if (this.sLl != null)
      {
        paramBoolean = this.sLl.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, paramView);
        AppMethodBeat.o(153824);
        return paramBoolean;
      }
      AppMethodBeat.o(153824);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.xweb.x5;

import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebViewCallbackClient;
import com.tencent.xweb.aa;
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
    if ((paramWebResourceResponse.INl) && (Build.VERSION.SDK_INT >= 21)) {
      try
      {
        com.tencent.smtt.export.external.interfaces.WebResourceResponse localWebResourceResponse1 = new com.tencent.smtt.export.external.interfaces.WebResourceResponse(paramWebResourceResponse.mMimeType, paramWebResourceResponse.mEncoding, paramWebResourceResponse.mStatusCode, paramWebResourceResponse.mReasonPhrase, paramWebResourceResponse.mResponseHeaders, paramWebResourceResponse.mInputStream);
        AppMethodBeat.o(153830);
        return localWebResourceResponse1;
      }
      catch (Exception localException)
      {
        Log.e("SysWebDataTrans", "create webkit WebResourceResponse error :" + localException.getMessage());
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
  
  public static final class e
    implements com.tencent.smtt.export.external.interfaces.WebResourceRequest
  {
    public com.tencent.xweb.WebResourceRequest IRQ;
    
    private e(com.tencent.xweb.WebResourceRequest paramWebResourceRequest)
    {
      this.IRQ = paramWebResourceRequest;
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
      String str = this.IRQ.getMethod();
      AppMethodBeat.o(153821);
      return str;
    }
    
    public final Map<String, String> getRequestHeaders()
    {
      AppMethodBeat.i(153822);
      Map localMap = this.IRQ.getRequestHeaders();
      AppMethodBeat.o(153822);
      return localMap;
    }
    
    public final Uri getUrl()
    {
      AppMethodBeat.i(153818);
      Uri localUri = this.IRQ.getUrl();
      AppMethodBeat.o(153818);
      return localUri;
    }
    
    public final boolean hasGesture()
    {
      AppMethodBeat.i(153820);
      boolean bool = this.IRQ.hasGesture();
      AppMethodBeat.o(153820);
      return bool;
    }
    
    public final boolean isForMainFrame()
    {
      AppMethodBeat.i(153819);
      boolean bool = this.IRQ.isForMainFrame();
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
    aa IRR;
    
    public f(aa paramaa)
    {
      this.IRR = paramaa;
    }
    
    public final void computeScroll(View paramView)
    {
      AppMethodBeat.i(153826);
      if (this.IRR != null) {
        this.IRR.beA();
      }
      AppMethodBeat.o(153826);
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(153825);
      if (this.IRR != null)
      {
        boolean bool = this.IRR.C(paramMotionEvent);
        AppMethodBeat.o(153825);
        return bool;
      }
      AppMethodBeat.o(153825);
      return false;
    }
    
    public final void invalidate() {}
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(153828);
      if (this.IRR != null)
      {
        boolean bool = this.IRR.D(paramMotionEvent);
        AppMethodBeat.o(153828);
        return bool;
      }
      AppMethodBeat.o(153828);
      return false;
    }
    
    public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
    {
      AppMethodBeat.i(153827);
      if (this.IRR != null) {
        this.IRR.d(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(153827);
    }
    
    public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
    {
      AppMethodBeat.i(153829);
      if (this.IRR != null) {
        this.IRR.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
      }
      AppMethodBeat.o(153829);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(153823);
      if (this.IRR != null)
      {
        boolean bool = this.IRR.B(paramMotionEvent);
        AppMethodBeat.o(153823);
        return bool;
      }
      AppMethodBeat.o(153823);
      return false;
    }
    
    public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
    {
      AppMethodBeat.i(153824);
      if (this.IRR != null)
      {
        paramBoolean = this.IRR.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
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
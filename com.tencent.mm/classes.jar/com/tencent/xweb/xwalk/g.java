package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.a.a;
import com.tencent.xweb.j;
import com.tencent.xweb.o;
import com.tencent.xweb.q;
import com.tencent.xweb.z;
import java.io.File;
import java.util.Map;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDownloadListener;
import org.xwalk.core.XWalkFindListener;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkLongScreenshotCallback;
import org.xwalk.core.XWalkWebResourceError;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;

public final class g
{
  public static WebResourceResponse a(XWalkWebResourceResponse paramXWalkWebResourceResponse)
  {
    AppMethodBeat.i(154284);
    if (paramXWalkWebResourceResponse == null)
    {
      AppMethodBeat.o(154284);
      return null;
    }
    paramXWalkWebResourceResponse = new WebResourceResponse(paramXWalkWebResourceResponse.getMimeType(), paramXWalkWebResourceResponse.getEncoding(), paramXWalkWebResourceResponse.getStatusCode(), paramXWalkWebResourceResponse.getReasonPhrase(), paramXWalkWebResourceResponse.getResponseHeaders(), paramXWalkWebResourceResponse.getData());
    AppMethodBeat.o(154284);
    return paramXWalkWebResourceResponse;
  }
  
  public static final class a
    implements WebChromeClient.CustomViewCallback
  {
    CustomViewCallback aaih;
    
    a(CustomViewCallback paramCustomViewCallback)
    {
      this.aaih = paramCustomViewCallback;
    }
    
    public final void onCustomViewHidden()
    {
      AppMethodBeat.i(154265);
      this.aaih.onCustomViewHidden();
      AppMethodBeat.o(154265);
    }
  }
  
  public static final class b
    implements GeolocationPermissions.Callback
  {
    XWalkGeolocationPermissionsCallback aaii;
    
    public b(XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
    {
      this.aaii = paramXWalkGeolocationPermissionsCallback;
    }
    
    public final void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(154266);
      if (this.aaii != null) {
        this.aaii.invoke(paramString, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(154266);
    }
  }
  
  public static final class c
    extends JsResult
  {
    public XWalkJavascriptResult aaij;
    
    public c(XWalkJavascriptResult paramXWalkJavascriptResult)
    {
      this.aaij = paramXWalkJavascriptResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(154269);
      this.aaij.cancel();
      AppMethodBeat.o(154269);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(154268);
      this.aaij.confirm();
      AppMethodBeat.o(154268);
    }
    
    public final void confirmWithResult(String paramString)
    {
      AppMethodBeat.i(154267);
      this.aaij.confirmWithResult(paramString);
      AppMethodBeat.o(154267);
    }
  }
  
  public static final class d
    extends XWalkLongScreenshotCallback
  {
    private q aaik;
    
    public d(q paramq)
    {
      this.aaik = paramq;
    }
    
    public final File getCacheFileDir()
    {
      AppMethodBeat.i(154271);
      File localFile = this.aaik.getCacheFileDir();
      AppMethodBeat.o(154271);
      return localFile;
    }
    
    public final int getMaxHeightSupported()
    {
      AppMethodBeat.i(154274);
      int i = this.aaik.getMaxHeightSupported();
      AppMethodBeat.o(154274);
      return i;
    }
    
    public final File getResultFileDir()
    {
      AppMethodBeat.i(154272);
      File localFile = this.aaik.getResultFileDir();
      AppMethodBeat.o(154272);
      return localFile;
    }
    
    public final void onLongScreenshotFinished(int paramInt, String paramString)
    {
      AppMethodBeat.i(154270);
      this.aaik.onLongScreenshotFinished(paramInt, paramString);
      AppMethodBeat.o(154270);
    }
    
    public final Bitmap overrideScreenshot(Bitmap paramBitmap)
    {
      AppMethodBeat.i(154273);
      paramBitmap = this.aaik.overrideScreenshot(paramBitmap);
      AppMethodBeat.o(154273);
      return paramBitmap;
    }
  }
  
  public static final class e
    extends o
  {
    public XWalkJavascriptResult aaij;
    
    public e(XWalkJavascriptResult paramXWalkJavascriptResult)
    {
      this.aaij = paramXWalkJavascriptResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(154277);
      this.aaij.cancel();
      AppMethodBeat.o(154277);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(154276);
      this.aaij.confirm();
      AppMethodBeat.o(154276);
    }
    
    public final void confirmWithResult(String paramString)
    {
      AppMethodBeat.i(154275);
      this.aaij.confirmWithResult(paramString);
      AppMethodBeat.o(154275);
    }
  }
  
  public static final class f
    extends XWalkDownloadListener
  {
    DownloadListener aagc;
    
    public f(Context paramContext, DownloadListener paramDownloadListener)
    {
      super();
      this.aagc = paramDownloadListener;
    }
    
    public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      AppMethodBeat.i(154278);
      if (this.aagc != null) {
        this.aagc.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
      }
      AppMethodBeat.o(154278);
    }
  }
  
  public static final class g
    extends XWalkFindListener
  {
    WebView.FindListener aagd;
    
    public g(WebView.FindListener paramFindListener)
    {
      this.aagd = paramFindListener;
    }
    
    public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(154279);
      if (this.aagd != null) {
        this.aagd.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
      }
      AppMethodBeat.o(154279);
    }
  }
  
  public static final class i
    implements WebResourceRequest
  {
    private boolean Plg;
    private Map<String, String> RaC;
    private boolean aafm;
    private boolean aafn;
    a aafo;
    private String method;
    private Uri url;
    
    public i(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(154283);
      try
      {
        this.url = Uri.parse(paramString1);
        this.aafm = paramBoolean1;
        this.aafn = paramBoolean2;
        this.method = paramString2;
        this.Plg = paramBoolean3;
        AppMethodBeat.o(154283);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("WebResourceRequestImpl", "parse url failed , url = ".concat(String.valueOf(paramString1)));
        }
      }
    }
    
    public i(XWalkWebResourceRequest paramXWalkWebResourceRequest)
    {
      AppMethodBeat.i(154282);
      if (paramXWalkWebResourceRequest != null)
      {
        this.url = paramXWalkWebResourceRequest.getUrl();
        this.aafm = paramXWalkWebResourceRequest.isForMainFrame();
        this.aafn = paramXWalkWebResourceRequest.hasGesture();
        this.method = paramXWalkWebResourceRequest.getMethod();
        this.RaC = paramXWalkWebResourceRequest.getRequestHeaders();
        this.aafo = new a(this);
      }
      AppMethodBeat.o(154282);
    }
    
    public final String getMethod()
    {
      return this.method;
    }
    
    public final Map<String, String> getRequestHeaders()
    {
      return this.RaC;
    }
    
    public final Uri getUrl()
    {
      return this.url;
    }
    
    public final boolean hasGesture()
    {
      return this.aafn;
    }
    
    public final boolean isForMainFrame()
    {
      return this.aafm;
    }
  }
  
  public static final class j
    implements j
  {
    XWalkHttpAuthHandler aaim;
    
    public j(XWalkHttpAuthHandler paramXWalkHttpAuthHandler)
    {
      this.aaim = paramXWalkHttpAuthHandler;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(205047);
      this.aaim.cancel();
      AppMethodBeat.o(205047);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g
 * JD-Core Version:    0.7.0.1
 */
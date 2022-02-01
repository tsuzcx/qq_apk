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
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.l;
import com.tencent.xweb.q;
import com.tencent.xweb.s;
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
    CustomViewCallback aioO;
    
    a(CustomViewCallback paramCustomViewCallback)
    {
      this.aioO = paramCustomViewCallback;
    }
    
    public final void onCustomViewHidden()
    {
      AppMethodBeat.i(154265);
      this.aioO.onCustomViewHidden();
      AppMethodBeat.o(154265);
    }
  }
  
  public static final class b
    implements GeolocationPermissions.Callback
  {
    private XWalkGeolocationPermissionsCallback aioP;
    
    public b(XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
    {
      this.aioP = paramXWalkGeolocationPermissionsCallback;
    }
    
    public final void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(154266);
      if (this.aioP != null) {
        this.aioP.invoke(paramString, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(154266);
    }
  }
  
  public static final class c
    extends JsResult
  {
    public XWalkJavascriptResult aioQ;
    
    public c(XWalkJavascriptResult paramXWalkJavascriptResult)
    {
      this.aioQ = paramXWalkJavascriptResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(154269);
      this.aioQ.cancel();
      AppMethodBeat.o(154269);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(154268);
      this.aioQ.confirm();
      AppMethodBeat.o(154268);
    }
    
    public final void confirmWithResult(String paramString)
    {
      AppMethodBeat.i(154267);
      this.aioQ.confirmWithResult(paramString);
      AppMethodBeat.o(154267);
    }
  }
  
  public static final class d
    extends XWalkLongScreenshotCallback
  {
    private s aioR;
    
    public d(s params)
    {
      this.aioR = params;
    }
    
    public final File getCacheFileDir()
    {
      AppMethodBeat.i(154271);
      File localFile = this.aioR.getCacheFileDir();
      AppMethodBeat.o(154271);
      return localFile;
    }
    
    public final int getMaxHeightSupported()
    {
      AppMethodBeat.i(154274);
      int i = this.aioR.getMaxHeightSupported();
      AppMethodBeat.o(154274);
      return i;
    }
    
    public final File getResultFileDir()
    {
      AppMethodBeat.i(154272);
      File localFile = this.aioR.getResultFileDir();
      AppMethodBeat.o(154272);
      return localFile;
    }
    
    public final void onLongScreenshotFinished(int paramInt, String paramString)
    {
      AppMethodBeat.i(154270);
      this.aioR.onLongScreenshotFinished(paramInt, paramString);
      AppMethodBeat.o(154270);
    }
    
    public final Bitmap overrideScreenshot(Bitmap paramBitmap)
    {
      AppMethodBeat.i(154273);
      paramBitmap = this.aioR.overrideScreenshot(paramBitmap);
      AppMethodBeat.o(154273);
      return paramBitmap;
    }
  }
  
  public static final class e
    extends q
  {
    public XWalkJavascriptResult aioQ;
    
    public e(XWalkJavascriptResult paramXWalkJavascriptResult)
    {
      this.aioQ = paramXWalkJavascriptResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(154277);
      this.aioQ.cancel();
      AppMethodBeat.o(154277);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(154276);
      this.aioQ.confirm();
      AppMethodBeat.o(154276);
    }
    
    public final void confirmWithResult(String paramString)
    {
      AppMethodBeat.i(154275);
      this.aioQ.confirmWithResult(paramString);
      AppMethodBeat.o(154275);
    }
  }
  
  public static final class f
    extends XWalkDownloadListener
  {
    DownloadListener aimQ;
    
    public f(Context paramContext, DownloadListener paramDownloadListener)
    {
      super();
      this.aimQ = paramDownloadListener;
    }
    
    public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      AppMethodBeat.i(154278);
      if (this.aimQ != null) {
        this.aimQ.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
      }
      AppMethodBeat.o(154278);
    }
  }
  
  public static final class g
    extends XWalkFindListener
  {
    private WebView.FindListener aimR;
    
    public g(WebView.FindListener paramFindListener)
    {
      this.aimR = paramFindListener;
    }
    
    public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(154279);
      if (this.aimR != null) {
        this.aimR.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
      }
      AppMethodBeat.o(154279);
    }
  }
  
  public static final class i
    implements WebResourceRequest
  {
    private Map<String, String> XWH;
    private boolean aikA;
    private boolean aikB;
    ab aikC;
    private Uri aikz;
    private boolean aioT;
    private String method;
    
    public i(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(154283);
      try
      {
        this.aikz = Uri.parse(paramString1);
        this.aikA = paramBoolean1;
        this.aikB = paramBoolean2;
        this.method = paramString2;
        this.aioT = paramBoolean3;
        AppMethodBeat.o(154283);
        return;
      }
      finally
      {
        for (;;)
        {
          Log.e("WebResourceRequestImpl", "parse url failed, url = ".concat(String.valueOf(paramString1)));
        }
      }
    }
    
    public i(XWalkWebResourceRequest paramXWalkWebResourceRequest)
    {
      AppMethodBeat.i(154282);
      if (paramXWalkWebResourceRequest != null)
      {
        this.aikz = paramXWalkWebResourceRequest.getUrl();
        this.aikA = paramXWalkWebResourceRequest.isForMainFrame();
        this.aikB = paramXWalkWebResourceRequest.hasGesture();
        this.method = paramXWalkWebResourceRequest.getMethod();
        this.XWH = paramXWalkWebResourceRequest.getRequestHeaders();
        this.aikC = new ab(this);
      }
      AppMethodBeat.o(154282);
    }
    
    public final String getMethod()
    {
      return this.method;
    }
    
    public final Map<String, String> getRequestHeaders()
    {
      return this.XWH;
    }
    
    public final Uri getUrl()
    {
      return this.aikz;
    }
    
    public final boolean hasGesture()
    {
      return this.aikB;
    }
    
    public final boolean isForMainFrame()
    {
      return this.aikA;
    }
  }
  
  public static final class j
    implements l
  {
    private XWalkHttpAuthHandler aioU;
    
    public j(XWalkHttpAuthHandler paramXWalkHttpAuthHandler)
    {
      this.aioU = paramXWalkHttpAuthHandler;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(212959);
      this.aioU.cancel();
      AppMethodBeat.o(212959);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g
 * JD-Core Version:    0.7.0.1
 */
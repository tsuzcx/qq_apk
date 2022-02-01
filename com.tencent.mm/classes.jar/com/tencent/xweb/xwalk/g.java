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
    CustomViewCallback MTK;
    
    a(CustomViewCallback paramCustomViewCallback)
    {
      this.MTK = paramCustomViewCallback;
    }
    
    public final void onCustomViewHidden()
    {
      AppMethodBeat.i(154265);
      this.MTK.onCustomViewHidden();
      AppMethodBeat.o(154265);
    }
  }
  
  public static final class b
    implements GeolocationPermissions.Callback
  {
    XWalkGeolocationPermissionsCallback MTL;
    
    public b(XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
    {
      this.MTL = paramXWalkGeolocationPermissionsCallback;
    }
    
    public final void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(154266);
      if (this.MTL != null) {
        this.MTL.invoke(paramString, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(154266);
    }
  }
  
  public static final class c
    extends JsResult
  {
    public XWalkJavascriptResult MTM;
    
    public c(XWalkJavascriptResult paramXWalkJavascriptResult)
    {
      this.MTM = paramXWalkJavascriptResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(154269);
      this.MTM.cancel();
      AppMethodBeat.o(154269);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(154268);
      this.MTM.confirm();
      AppMethodBeat.o(154268);
    }
    
    public final void confirmWithResult(String paramString)
    {
      AppMethodBeat.i(154267);
      this.MTM.confirmWithResult(paramString);
      AppMethodBeat.o(154267);
    }
  }
  
  public static final class d
    extends XWalkLongScreenshotCallback
  {
    private q MTN;
    
    public d(q paramq)
    {
      this.MTN = paramq;
    }
    
    public final File getCacheFileDir()
    {
      AppMethodBeat.i(154271);
      File localFile = this.MTN.getCacheFileDir();
      AppMethodBeat.o(154271);
      return localFile;
    }
    
    public final int getMaxHeightSupported()
    {
      AppMethodBeat.i(154274);
      int i = this.MTN.getMaxHeightSupported();
      AppMethodBeat.o(154274);
      return i;
    }
    
    public final File getResultFileDir()
    {
      AppMethodBeat.i(154272);
      File localFile = this.MTN.getResultFileDir();
      AppMethodBeat.o(154272);
      return localFile;
    }
    
    public final void onLongScreenshotFinished(int paramInt, String paramString)
    {
      AppMethodBeat.i(154270);
      this.MTN.onLongScreenshotFinished(paramInt, paramString);
      AppMethodBeat.o(154270);
    }
    
    public final Bitmap overrideScreenshot(Bitmap paramBitmap)
    {
      AppMethodBeat.i(154273);
      paramBitmap = this.MTN.overrideScreenshot(paramBitmap);
      AppMethodBeat.o(154273);
      return paramBitmap;
    }
  }
  
  public static final class e
    extends o
  {
    public XWalkJavascriptResult MTM;
    
    public e(XWalkJavascriptResult paramXWalkJavascriptResult)
    {
      this.MTM = paramXWalkJavascriptResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(154277);
      this.MTM.cancel();
      AppMethodBeat.o(154277);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(154276);
      this.MTM.confirm();
      AppMethodBeat.o(154276);
    }
    
    public final void confirmWithResult(String paramString)
    {
      AppMethodBeat.i(154275);
      this.MTM.confirmWithResult(paramString);
      AppMethodBeat.o(154275);
    }
  }
  
  public static final class f
    extends XWalkDownloadListener
  {
    DownloadListener MRM;
    
    public f(Context paramContext, DownloadListener paramDownloadListener)
    {
      super();
      this.MRM = paramDownloadListener;
    }
    
    public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      AppMethodBeat.i(154278);
      if (this.MRM != null) {
        this.MRM.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
      }
      AppMethodBeat.o(154278);
    }
  }
  
  public static final class g
    extends XWalkFindListener
  {
    WebView.FindListener MRN;
    
    public g(WebView.FindListener paramFindListener)
    {
      this.MRN = paramFindListener;
    }
    
    public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(154279);
      if (this.MRN != null) {
        this.MRN.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
      }
      AppMethodBeat.o(154279);
    }
  }
  
  public static final class i
    implements WebResourceRequest
  {
    private boolean DJg;
    private Map<String, String> Fjf;
    private boolean MQX;
    private boolean MQY;
    a MQZ;
    private String method;
    private Uri url;
    
    public i(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(154283);
      try
      {
        this.url = Uri.parse(paramString1);
        this.MQX = paramBoolean1;
        this.MQY = paramBoolean2;
        this.method = paramString2;
        this.DJg = paramBoolean3;
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
      this.url = paramXWalkWebResourceRequest.getUrl();
      this.MQX = paramXWalkWebResourceRequest.isForMainFrame();
      this.MQY = paramXWalkWebResourceRequest.hasGesture();
      this.method = paramXWalkWebResourceRequest.getMethod();
      this.Fjf = paramXWalkWebResourceRequest.getRequestHeaders();
      this.MQZ = new a(this);
      AppMethodBeat.o(154282);
    }
    
    public final String getMethod()
    {
      return this.method;
    }
    
    public final Map<String, String> getRequestHeaders()
    {
      return this.Fjf;
    }
    
    public final Uri getUrl()
    {
      return this.url;
    }
    
    public final boolean hasGesture()
    {
      return this.MQY;
    }
    
    public final boolean isForMainFrame()
    {
      return this.MQX;
    }
  }
  
  public static final class j
    implements j
  {
    XWalkHttpAuthHandler MTP;
    
    public j(XWalkHttpAuthHandler paramXWalkHttpAuthHandler)
    {
      this.MTP = paramXWalkHttpAuthHandler;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(207573);
      this.MTP.cancel();
      AppMethodBeat.o(207573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g
 * JD-Core Version:    0.7.0.1
 */
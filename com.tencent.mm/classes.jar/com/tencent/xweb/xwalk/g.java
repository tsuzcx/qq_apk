package com.tencent.xweb.xwalk;

import android.content.Context;
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
import java.util.Map;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDownloadListener;
import org.xwalk.core.XWalkFindListener;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkJavascriptResult;
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
    CustomViewCallback SGR;
    
    a(CustomViewCallback paramCustomViewCallback)
    {
      this.SGR = paramCustomViewCallback;
    }
    
    public final void onCustomViewHidden()
    {
      AppMethodBeat.i(154265);
      this.SGR.onCustomViewHidden();
      AppMethodBeat.o(154265);
    }
  }
  
  public static final class b
    implements GeolocationPermissions.Callback
  {
    XWalkGeolocationPermissionsCallback SGS;
    
    public b(XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
    {
      this.SGS = paramXWalkGeolocationPermissionsCallback;
    }
    
    public final void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(154266);
      if (this.SGS != null) {
        this.SGS.invoke(paramString, paramBoolean1, paramBoolean2);
      }
      AppMethodBeat.o(154266);
    }
  }
  
  public static final class c
    extends JsResult
  {
    public XWalkJavascriptResult SGT;
    
    public c(XWalkJavascriptResult paramXWalkJavascriptResult)
    {
      this.SGT = paramXWalkJavascriptResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(154269);
      this.SGT.cancel();
      AppMethodBeat.o(154269);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(154268);
      this.SGT.confirm();
      AppMethodBeat.o(154268);
    }
    
    public final void confirmWithResult(String paramString)
    {
      AppMethodBeat.i(154267);
      this.SGT.confirmWithResult(paramString);
      AppMethodBeat.o(154267);
    }
  }
  
  public static final class e
    extends o
  {
    public XWalkJavascriptResult SGT;
    
    public e(XWalkJavascriptResult paramXWalkJavascriptResult)
    {
      this.SGT = paramXWalkJavascriptResult;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(154277);
      this.SGT.cancel();
      AppMethodBeat.o(154277);
    }
    
    public final void confirm()
    {
      AppMethodBeat.i(154276);
      this.SGT.confirm();
      AppMethodBeat.o(154276);
    }
    
    public final void confirmWithResult(String paramString)
    {
      AppMethodBeat.i(154275);
      this.SGT.confirmWithResult(paramString);
      AppMethodBeat.o(154275);
    }
  }
  
  public static final class f
    extends XWalkDownloadListener
  {
    DownloadListener SES;
    
    public f(Context paramContext, DownloadListener paramDownloadListener)
    {
      super();
      this.SES = paramDownloadListener;
    }
    
    public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      AppMethodBeat.i(154278);
      if (this.SES != null) {
        this.SES.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
      }
      AppMethodBeat.o(154278);
    }
  }
  
  public static final class g
    extends XWalkFindListener
  {
    WebView.FindListener SET;
    
    public g(WebView.FindListener paramFindListener)
    {
      this.SET = paramFindListener;
    }
    
    public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(154279);
      if (this.SET != null) {
        this.SET.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
      }
      AppMethodBeat.o(154279);
    }
  }
  
  public static final class i
    implements WebResourceRequest
  {
    private boolean Isw;
    private Map<String, String> JZZ;
    private boolean SEb;
    private boolean SEc;
    a SEd;
    private String method;
    private Uri url;
    
    public i(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(154283);
      try
      {
        this.url = Uri.parse(paramString1);
        this.SEb = paramBoolean1;
        this.SEc = paramBoolean2;
        this.method = paramString2;
        this.Isw = paramBoolean3;
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
      this.SEb = paramXWalkWebResourceRequest.isForMainFrame();
      this.SEc = paramXWalkWebResourceRequest.hasGesture();
      this.method = paramXWalkWebResourceRequest.getMethod();
      this.JZZ = paramXWalkWebResourceRequest.getRequestHeaders();
      this.SEd = new a(this);
      AppMethodBeat.o(154282);
    }
    
    public final String getMethod()
    {
      return this.method;
    }
    
    public final Map<String, String> getRequestHeaders()
    {
      return this.JZZ;
    }
    
    public final Uri getUrl()
    {
      return this.url;
    }
    
    public final boolean hasGesture()
    {
      return this.SEc;
    }
    
    public final boolean isForMainFrame()
    {
      return this.SEb;
    }
  }
  
  public static final class j
    implements j
  {
    XWalkHttpAuthHandler SGW;
    
    public j(XWalkHttpAuthHandler paramXWalkHttpAuthHandler)
    {
      this.SGW = paramXWalkHttpAuthHandler;
    }
    
    public final void cancel()
    {
      AppMethodBeat.i(207289);
      this.SGW.cancel();
      AppMethodBeat.o(207289);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g
 * JD-Core Version:    0.7.0.1
 */
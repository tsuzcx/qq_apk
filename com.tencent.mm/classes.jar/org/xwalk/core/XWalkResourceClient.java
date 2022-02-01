package org.xwalk.core;

import android.net.http.SslError;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class XWalkResourceClient
{
  public static final int ERROR_AUTHENTICATION = -4;
  public static final int ERROR_BAD_URL = -12;
  public static final int ERROR_CONNECT = -6;
  public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
  public static final int ERROR_FILE = -13;
  public static final int ERROR_FILE_NOT_FOUND = -14;
  public static final int ERROR_HOST_LOOKUP = -2;
  public static final int ERROR_IO = -7;
  public static final int ERROR_OK = 0;
  public static final int ERROR_PROXY_AUTHENTICATION = -5;
  public static final int ERROR_REDIRECT_LOOP = -9;
  public static final int ERROR_TIMEOUT = -8;
  public static final int ERROR_TOO_MANY_REQUESTS = -15;
  public static final int ERROR_UNKNOWN = -1;
  public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
  public static final int ERROR_UNSUPPORTED_SCHEME = -10;
  private Object bridge;
  private ArrayList<Object> constructorParams;
  private ArrayList<Object> constructorTypes;
  private XWalkCoreWrapper coreWrapper;
  private ReflectMethod createXWalkWebResourceResponseStringStringInputStreamMethod;
  private ReflectMethod createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod;
  private ReflectMethod doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod;
  private ReflectMethod onDocumentLoadedInFrameXWalkViewInternallongMethod;
  private ReflectMethod onLoadFinishedXWalkViewInternalStringMethod;
  private ReflectMethod onLoadStartedXWalkViewInternalStringMethod;
  private ReflectMethod onProgressChangedXWalkViewInternalintMethod;
  private ReflectMethod onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod;
  private ReflectMethod onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod;
  private ReflectMethod onReceivedLoadErrorXWalkViewInternalintStringStringMethod;
  private ReflectMethod onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod;
  private ReflectMethod onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod;
  private ReflectMethod postWrapperMethod;
  private ReflectMethod shouldInterceptLoadRequestXWalkViewInternalStringMethod;
  private ReflectMethod shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod;
  private ReflectMethod shouldOverrideUrlLoadingXWalkViewInternalStringMethod;
  
  static
  {
    AppMethodBeat.i(154858);
    if (!XWalkResourceClient.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(154858);
      return;
    }
  }
  
  public XWalkResourceClient(XWalkView paramXWalkView)
  {
    AppMethodBeat.i(154841);
    this.onDocumentLoadedInFrameXWalkViewInternallongMethod = new ReflectMethod(null, "onDocumentLoadedInFrame", new Class[0]);
    this.onLoadStartedXWalkViewInternalStringMethod = new ReflectMethod(null, "onLoadStarted", new Class[0]);
    this.onLoadFinishedXWalkViewInternalStringMethod = new ReflectMethod(null, "onLoadFinished", new Class[0]);
    this.onProgressChangedXWalkViewInternalintMethod = new ReflectMethod(null, "onProgressChanged", new Class[0]);
    this.shouldInterceptLoadRequestXWalkViewInternalStringMethod = new ReflectMethod(null, "shouldInterceptLoadRequest", new Class[0]);
    this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod = new ReflectMethod(null, "shouldInterceptLoadRequest", new Class[0]);
    this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod = new ReflectMethod(null, "onReceivedLoadError", new Class[0]);
    this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod = new ReflectMethod(null, "shouldOverrideUrlLoading", new Class[0]);
    this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod = new ReflectMethod(null, "onReceivedSslError", new Class[0]);
    this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod = new ReflectMethod(null, "onReceivedClientCertRequest", new Class[0]);
    this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod = new ReflectMethod(null, "onReceivedResponseHeaders", new Class[0]);
    this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod = new ReflectMethod(null, "doUpdateVisitedHistory", new Class[0]);
    this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod = new ReflectMethod(null, "onReceivedHttpAuthRequest", new Class[0]);
    this.createXWalkWebResourceResponseStringStringInputStreamMethod = new ReflectMethod(null, "createXWalkWebResourceResponse", new Class[0]);
    this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod = new ReflectMethod(null, "createXWalkWebResourceResponse", new Class[0]);
    this.constructorTypes = new ArrayList();
    this.constructorTypes.add("XWalkViewBridge");
    this.constructorParams = new ArrayList();
    this.constructorParams.add(paramXWalkView);
    reflectionInit();
    AppMethodBeat.o(154841);
  }
  
  public XWalkWebResourceResponse createXWalkWebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream)
  {
    AppMethodBeat.i(154855);
    try
    {
      paramString1 = (XWalkWebResourceResponse)this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamMethod.invoke(new Object[] { paramString1, paramString2, paramInputStream }));
      AppMethodBeat.o(154855);
      return paramString1;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154855);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(154855);
    }
    return null;
  }
  
  public XWalkWebResourceResponse createXWalkWebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream, int paramInt, String paramString3, Map<String, String> paramMap)
  {
    AppMethodBeat.i(154856);
    try
    {
      paramString1 = (XWalkWebResourceResponse)this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.invoke(new Object[] { paramString1, paramString2, paramInputStream, Integer.valueOf(paramInt), paramString3, paramMap }));
      AppMethodBeat.o(154856);
      return paramString1;
    }
    catch (UnsupportedOperationException paramString1)
    {
      if (this.coreWrapper == null)
      {
        paramString1 = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154856);
        throw paramString1;
      }
      XWalkCoreWrapper.handleRuntimeError(paramString1);
      AppMethodBeat.o(154856);
    }
    return null;
  }
  
  public void doUpdateVisitedHistory(XWalkView paramXWalkView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(154853);
    try
    {
      this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString, Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(154853);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154853);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154853);
    }
  }
  
  protected Object getBridge()
  {
    return this.bridge;
  }
  
  public void onDocumentLoadedInFrame(XWalkView paramXWalkView, long paramLong)
  {
    AppMethodBeat.i(154842);
    try
    {
      this.onDocumentLoadedInFrameXWalkViewInternallongMethod.invoke(new Object[] { paramXWalkView.getBridge(), Long.valueOf(paramLong) });
      AppMethodBeat.o(154842);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154842);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154842);
    }
  }
  
  public void onLoadFinished(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(154844);
    try
    {
      this.onLoadFinishedXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      AppMethodBeat.o(154844);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154844);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154844);
    }
  }
  
  public void onLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(154843);
    try
    {
      this.onLoadStartedXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      AppMethodBeat.o(154843);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154843);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154843);
    }
  }
  
  public void onProgressChanged(XWalkView paramXWalkView, int paramInt)
  {
    AppMethodBeat.i(154845);
    try
    {
      this.onProgressChangedXWalkViewInternalintMethod.invoke(new Object[] { paramXWalkView.getBridge(), Integer.valueOf(paramInt) });
      AppMethodBeat.o(154845);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154845);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154845);
    }
  }
  
  public void onReceivedClientCertRequest(XWalkView paramXWalkView, ClientCertRequest paramClientCertRequest)
  {
    AppMethodBeat.i(154851);
    try
    {
      this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), ((ClientCertRequestHandler)paramClientCertRequest).getBridge() });
      AppMethodBeat.o(154851);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154851);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154851);
    }
  }
  
  public void onReceivedHttpAuthRequest(XWalkView paramXWalkView, XWalkHttpAuthHandler paramXWalkHttpAuthHandler, String paramString1, String paramString2)
  {
    AppMethodBeat.i(154854);
    try
    {
      this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramXWalkHttpAuthHandler.getBridge(), paramString1, paramString2 });
      AppMethodBeat.o(154854);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154854);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154854);
    }
  }
  
  public void onReceivedHttpError(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest, XWalkWebResourceResponse paramXWalkWebResourceResponse) {}
  
  public void onReceivedLoadError(XWalkView paramXWalkView, int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(154848);
    try
    {
      this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), Integer.valueOf(paramInt), paramString1, paramString2 });
      AppMethodBeat.o(154848);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154848);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154848);
    }
  }
  
  public void onReceivedResponseHeaders(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest, XWalkWebResourceResponse paramXWalkWebResourceResponse)
  {
    AppMethodBeat.i(154852);
    try
    {
      this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), ((XWalkWebResourceRequestHandler)paramXWalkWebResourceRequest).getBridge(), paramXWalkWebResourceResponse.getBridge() });
      AppMethodBeat.o(154852);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154852);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154852);
    }
  }
  
  public void onReceivedSslError(XWalkView paramXWalkView, ValueCallback<Boolean> paramValueCallback, SslError paramSslError)
  {
    AppMethodBeat.i(154850);
    try
    {
      this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramValueCallback, paramSslError });
      AppMethodBeat.o(154850);
      return;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154850);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154850);
    }
  }
  
  void reflectionInit()
  {
    AppMethodBeat.i(154857);
    XWalkCoreWrapper.initEmbeddedMode();
    this.coreWrapper = XWalkCoreWrapper.getInstance();
    if (this.coreWrapper == null)
    {
      XWalkCoreWrapper.reserveReflectObject(this);
      AppMethodBeat.o(154857);
      return;
    }
    int j = this.constructorTypes.size();
    Object localObject1 = new Class[j + 1];
    int i = 0;
    if (i < j)
    {
      Object localObject2 = this.constructorTypes.get(i);
      if ((localObject2 instanceof String))
      {
        localObject1[i] = this.coreWrapper.getBridgeClass((String)localObject2);
        this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
      }
      label139:
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (!(localObject2 instanceof Class)) {
            break label139;
          }
          localObject1[i] = ((Class)localObject2);
        }
      } while ($assertionsDisabled);
      localObject1 = new AssertionError();
      AppMethodBeat.o(154857);
      throw ((Throwable)localObject1);
    }
    localObject1[j] = Object.class;
    this.constructorParams.add(this);
    localObject1 = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkResourceClientBridge"), (Class[])localObject1);
    try
    {
      this.bridge = ((ReflectConstructor)localObject1).newInstance(this.constructorParams.toArray());
      if (this.postWrapperMethod != null) {
        this.postWrapperMethod.invoke(new Object[0]);
      }
      this.onDocumentLoadedInFrameXWalkViewInternallongMethod.init(this.bridge, null, "onDocumentLoadedInFrameSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Long.TYPE });
      this.onLoadStartedXWalkViewInternalStringMethod.init(this.bridge, null, "onLoadStartedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onLoadFinishedXWalkViewInternalStringMethod.init(this.bridge, null, "onLoadFinishedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onProgressChangedXWalkViewInternalintMethod.init(this.bridge, null, "onProgressChangedSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE });
      this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.init(this.bridge, null, "shouldInterceptLoadRequestSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.init(this.bridge, null, "shouldInterceptLoadRequestSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge") });
      this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.init(this.bridge, null, "onReceivedLoadErrorSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE, String.class, String.class });
      this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.init(this.bridge, null, "shouldOverrideUrlLoadingSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class });
      this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.init(this.bridge, null, "onReceivedSslErrorSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, SslError.class });
      this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.init(this.bridge, null, "onReceivedClientCertRequestSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("ClientCertRequestHandlerBridge") });
      this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.init(this.bridge, null, "onReceivedResponseHeadersSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceResponseBridge") });
      this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.init(this.bridge, null, "doUpdateVisitedHistorySuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Boolean.TYPE });
      this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.init(this.bridge, null, "onReceivedHttpAuthRequestSuper", new Class[] { this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkHttpAuthHandlerBridge"), String.class, String.class });
      this.createXWalkWebResourceResponseStringStringInputStreamMethod.init(this.bridge, null, "createXWalkWebResourceResponseSuper", new Class[] { String.class, String.class, InputStream.class });
      this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.init(this.bridge, null, "createXWalkWebResourceResponseSuper", new Class[] { String.class, String.class, InputStream.class, Integer.TYPE, String.class, Map.class });
      AppMethodBeat.o(154857);
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      AppMethodBeat.o(154857);
    }
  }
  
  public WebResourceResponse shouldInterceptLoadRequest(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(154846);
    try
    {
      paramXWalkView = (WebResourceResponse)this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString });
      AppMethodBeat.o(154846);
      return paramXWalkView;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154846);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154846);
    }
    return null;
  }
  
  public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest)
  {
    AppMethodBeat.i(154847);
    try
    {
      paramXWalkView = (XWalkWebResourceResponse)this.coreWrapper.getWrapperObject(this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.invoke(new Object[] { paramXWalkView.getBridge(), ((XWalkWebResourceRequestHandler)paramXWalkWebResourceRequest).getBridge() }));
      AppMethodBeat.o(154847);
      return paramXWalkView;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154847);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154847);
    }
    return null;
  }
  
  public boolean shouldOverrideUrlLoading(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(154849);
    try
    {
      boolean bool = ((Boolean)this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.invoke(new Object[] { paramXWalkView.getBridge(), paramString })).booleanValue();
      AppMethodBeat.o(154849);
      return bool;
    }
    catch (UnsupportedOperationException paramXWalkView)
    {
      if (this.coreWrapper == null)
      {
        paramXWalkView = new RuntimeException("Crosswalk's APIs are not ready yet");
        AppMethodBeat.o(154849);
        throw paramXWalkView;
      }
      XWalkCoreWrapper.handleRuntimeError(paramXWalkView);
      AppMethodBeat.o(154849);
    }
    return false;
  }
  
  public boolean shouldOverrideUrlLoading(XWalkView paramXWalkView, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.XWalkResourceClient
 * JD-Core Version:    0.7.0.1
 */
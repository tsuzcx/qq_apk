package com.tencent.xweb.pinus.sdk;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class WebViewExtension
{
  public static final String EXTENSION_ADD_FILTER_RESOURCES = "AddFilterResources";
  private static final String TAG = "WebViewExtension";
  private static WebViewExtensionListener mWebViewExtensionListener;
  
  public static boolean addFilterResources(Resources paramResources, Map<Long, Integer> paramMap)
  {
    AppMethodBeat.i(213510);
    boolean bool = onMiscCallBack("AddFilterResources", new Object[] { paramResources, paramMap });
    AppMethodBeat.o(213510);
    return bool;
  }
  
  public static int getHostByName(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(213535);
    if (mWebViewExtensionListener != null)
    {
      int i = mWebViewExtensionListener.getHostByName(paramString, paramList);
      AppMethodBeat.o(213535);
      return i;
    }
    AppMethodBeat.o(213535);
    return 0;
  }
  
  public static boolean onMiscCallBack(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(213523);
    if (mWebViewExtensionListener != null)
    {
      mWebViewExtensionListener.onMiscCallBack(paramString, paramVarArgs);
      AppMethodBeat.o(213523);
      return true;
    }
    Log.e("WebViewExtension", "onMiscCallBack, interface is null, method:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(213523);
    return false;
  }
  
  public static void setExtension(WebViewExtensionListener paramWebViewExtensionListener)
  {
    AppMethodBeat.i(213498);
    Log.i("WebViewExtension", "setExtension WebViewExtensionListener:".concat(String.valueOf(paramWebViewExtensionListener)));
    mWebViewExtensionListener = paramWebViewExtensionListener;
    AppMethodBeat.o(213498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.pinus.sdk.WebViewExtension
 * JD-Core Version:    0.7.0.1
 */
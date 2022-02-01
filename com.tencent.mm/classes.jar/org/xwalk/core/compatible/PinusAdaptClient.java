package org.xwalk.core.compatible;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebExtendInterface;
import com.tencent.xweb.pinus.sdk.WebView;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkView;

public class PinusAdaptClient
{
  private static final String TAG = "PinusAdaptClient";
  public static final int XWEB_PINUS = 1;
  public static final int XWEB_XWALK = 0;
  protected WebView psWebview;
  protected XWalkView xwalkView;
  public int xwebType = -1;
  
  public void init(XWebExtendInterface paramXWebExtendInterface)
  {
    AppMethodBeat.i(187602);
    if ((paramXWebExtendInterface instanceof XWalkView)) {
      initXWalkView((XWalkView)paramXWebExtendInterface);
    }
    while (this.xwebType == -1)
    {
      Log.e("PinusAdaptClient", "xwebType = -1, super init not call view:".concat(String.valueOf(paramXWebExtendInterface)));
      paramXWebExtendInterface = new RuntimeException("PinusAdaptClient init error royle");
      AppMethodBeat.o(187602);
      throw paramXWebExtendInterface;
      if ((paramXWebExtendInterface instanceof WebView)) {
        initPSWebView((WebView)paramXWebExtendInterface);
      } else {
        Log.e("PinusAdaptClient", "PinusAdaptClient constructor error");
      }
    }
    AppMethodBeat.o(187602);
  }
  
  public void initPSWebView(WebView paramWebView)
  {
    this.xwebType = 1;
    this.psWebview = paramWebView;
  }
  
  public void initXWalkView(XWalkView paramXWalkView)
  {
    this.xwebType = 0;
    this.xwalkView = paramXWalkView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.compatible.PinusAdaptClient
 * JD-Core Version:    0.7.0.1
 */
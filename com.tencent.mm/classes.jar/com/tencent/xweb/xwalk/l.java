package com.tencent.xweb.xwalk;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

public class l
  extends XWalkUIClient
{
  public l(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public final void a(View paramView, CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(85371);
    super.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(85371);
  }
  
  public final void a(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(85369);
    super.onPageLoadStarted(paramXWalkView, paramString);
    AppMethodBeat.o(85369);
  }
  
  public final boolean a(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85372);
    boolean bool = super.onJsPrompt(paramXWalkView, paramString1, paramString2, paramString3, paramXWalkJavascriptResult);
    AppMethodBeat.o(85372);
    return bool;
  }
  
  public final boolean a(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85373);
    boolean bool = super.onJsConfirm(paramXWalkView, paramString1, paramString2, paramXWalkJavascriptResult);
    AppMethodBeat.o(85373);
    return bool;
  }
  
  public final boolean b(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(85374);
    boolean bool = super.onJsAlert(paramXWalkView, paramString1, paramString2, paramXWalkJavascriptResult);
    AppMethodBeat.o(85374);
    return bool;
  }
  
  public final void dZW()
  {
    AppMethodBeat.i(85370);
    super.onHideCustomView();
    AppMethodBeat.o(85370);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.l
 * JD-Core Version:    0.7.0.1
 */
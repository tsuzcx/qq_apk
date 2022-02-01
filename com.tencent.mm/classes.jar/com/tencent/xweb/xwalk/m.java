package com.tencent.xweb.xwalk;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;

public class m
  extends XWalkUIClient
{
  public m(XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  public final void a(View paramView, CustomViewCallback paramCustomViewCallback)
  {
    AppMethodBeat.i(154453);
    super.onShowCustomView(paramView, paramCustomViewCallback);
    AppMethodBeat.o(154453);
  }
  
  public final void a(XWalkView paramXWalkView, String paramString)
  {
    AppMethodBeat.i(154451);
    super.onPageLoadStarted(paramXWalkView, paramString);
    AppMethodBeat.o(154451);
  }
  
  public final boolean a(XWalkView paramXWalkView, String paramString1, String paramString2, String paramString3, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(154454);
    boolean bool = super.onJsPrompt(paramXWalkView, paramString1, paramString2, paramString3, paramXWalkJavascriptResult);
    AppMethodBeat.o(154454);
    return bool;
  }
  
  public final boolean a(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(154455);
    boolean bool = super.onJsConfirm(paramXWalkView, paramString1, paramString2, paramXWalkJavascriptResult);
    AppMethodBeat.o(154455);
    return bool;
  }
  
  public final boolean b(XWalkView paramXWalkView, String paramString1, String paramString2, XWalkJavascriptResult paramXWalkJavascriptResult)
  {
    AppMethodBeat.i(154456);
    boolean bool = super.onJsAlert(paramXWalkView, paramString1, paramString2, paramXWalkJavascriptResult);
    AppMethodBeat.o(154456);
    return bool;
  }
  
  public final void huJ()
  {
    AppMethodBeat.i(154452);
    super.onHideCustomView();
    AppMethodBeat.o(154452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.m
 * JD-Core Version:    0.7.0.1
 */
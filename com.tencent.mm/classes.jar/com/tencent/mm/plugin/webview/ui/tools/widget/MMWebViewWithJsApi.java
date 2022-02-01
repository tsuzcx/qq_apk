package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ag;

public class MMWebViewWithJsApi
  extends MMWebView
{
  private n Xqf;
  private boolean Xqg;
  
  public MMWebViewWithJsApi(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MMWebViewWithJsApi(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMWebViewWithJsApi(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(82238);
    this.Xqg = true;
    jET();
    getSettings().setJavaScriptEnabled(true);
    getSettings().kfU();
    setWebChromeClient(new l(this));
    setWebViewClient(new n(this));
    paramContext = getSettings().getUserAgentString();
    if (!aa.brR(paramContext))
    {
      paramContext = aa.cN(getContext(), paramContext);
      getSettings().setUserAgentString(paramContext);
    }
    AppMethodBeat.o(82238);
  }
  
  public j getJsapi()
  {
    if (this.Xqf != null) {
      return this.Xqf.sNc;
    }
    return null;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(82241);
    if (this.Xqf != null)
    {
      this.Xqf.Jb(true);
      this.Xqf.bmi("");
    }
    super.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(82241);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(82242);
    if (this.Xqf != null)
    {
      this.Xqf.Jb(true);
      this.Xqf.bmi("");
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(82242);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(82243);
    if (this.Xqf != null)
    {
      this.Xqf.Jb(false);
      if (this.Xqf.bmi(paramString)) {}
    }
    else
    {
      super.loadUrl(paramString);
    }
    AppMethodBeat.o(82243);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(82240);
    super.onDetachedFromWindow();
    if ((this.Xqf != null) && (this.Xqg)) {
      this.Xqf.cleanup();
    }
    AppMethodBeat.o(82240);
  }
  
  public void setCleanOnDetached(boolean paramBoolean)
  {
    this.Xqg = paramBoolean;
  }
  
  public void setWebViewClient(ag paramag)
  {
    AppMethodBeat.i(82239);
    super.setWebViewClient(paramag);
    if ((paramag instanceof n))
    {
      this.Xqf = ((n)paramag);
      AppMethodBeat.o(82239);
      return;
    }
    this.Xqf = null;
    AppMethodBeat.o(82239);
  }
  
  public static final class a
  {
    public static MMWebViewWithJsApi ld(Context paramContext)
    {
      AppMethodBeat.i(82237);
      MMWebViewWithJsApi.cD(paramContext);
      paramContext = new MMWebViewWithJsApi(paramContext);
      MMWebViewWithJsApi.a(paramContext);
      AppMethodBeat.o(82237);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi
 * JD-Core Version:    0.7.0.1
 */
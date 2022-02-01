package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.ad;

public class MMWebViewWithJsApi
  extends MMWebView
{
  private k Qxl;
  private boolean Qxm;
  
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
    this.Qxm = true;
    hZM();
    getSettings().setJavaScriptEnabled(true);
    getSettings().iwE();
    setWebChromeClient(new i(this));
    setWebViewClient(new k(this));
    paramContext = getSettings().getUserAgentString();
    if (!ab.bsa(paramContext))
    {
      paramContext = ab.cC(getContext(), paramContext);
      getSettings().setUserAgentString(paramContext);
    }
    AppMethodBeat.o(82238);
  }
  
  public h getJsapi()
  {
    if (this.Qxl != null) {
      return this.Qxl.pIl;
    }
    return null;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(82241);
    if (this.Qxl != null)
    {
      this.Qxl.Dt(true);
      this.Qxl.bmE("");
    }
    super.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(82241);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(82242);
    if (this.Qxl != null)
    {
      this.Qxl.Dt(true);
      this.Qxl.bmE("");
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(82242);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(82243);
    if (this.Qxl != null)
    {
      this.Qxl.Dt(false);
      if (this.Qxl.bmE(paramString)) {}
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
    if ((this.Qxl != null) && (this.Qxm)) {
      this.Qxl.cleanup();
    }
    AppMethodBeat.o(82240);
  }
  
  public void setCleanOnDetached(boolean paramBoolean)
  {
    this.Qxm = paramBoolean;
  }
  
  public void setWebViewClient(ad paramad)
  {
    AppMethodBeat.i(82239);
    super.setWebViewClient(paramad);
    if ((paramad instanceof k))
    {
      this.Qxl = ((k)paramad);
      AppMethodBeat.o(82239);
      return;
    }
    this.Qxl = null;
    AppMethodBeat.o(82239);
  }
  
  public static final class a
  {
    public static MMWebViewWithJsApi jd(Context paramContext)
    {
      AppMethodBeat.i(82237);
      MMWebViewWithJsApi.bQ(paramContext);
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
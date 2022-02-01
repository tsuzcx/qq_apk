package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.y;

public class MMWebViewWithJsApi
  extends MMWebView
{
  private k BuK;
  private boolean BuL;
  
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
    this.BuL = true;
    feQ();
    getSettings().setJavaScriptEnabled(true);
    getSettings().fri();
    setWebChromeClient(new i(this));
    setWebViewClient(new k(this));
    paramContext = getSettings().getUserAgentString();
    if (!x.aCK(paramContext))
    {
      paramContext = x.bR(getContext(), paramContext);
      getSettings().setUserAgentString(paramContext);
    }
    AppMethodBeat.o(82238);
  }
  
  public f getJsapi()
  {
    if (this.BuK != null) {
      return this.BuK.BmE;
    }
    return null;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(82241);
    if (this.BuK != null)
    {
      this.BuK.tD(true);
      this.BuK.ayh("");
    }
    super.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(82241);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(82242);
    if (this.BuK != null)
    {
      this.BuK.tD(true);
      this.BuK.ayh("");
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(82242);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(82243);
    if (this.BuK != null)
    {
      this.BuK.tD(false);
      if (this.BuK.ayh(paramString)) {}
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
    if ((this.BuK != null) && (this.BuL)) {
      this.BuK.cleanup();
    }
    AppMethodBeat.o(82240);
  }
  
  public void setCleanOnDetached(boolean paramBoolean)
  {
    this.BuL = paramBoolean;
  }
  
  public void setWebViewClient(ab paramab)
  {
    AppMethodBeat.i(82239);
    super.setWebViewClient(paramab);
    if ((paramab instanceof k))
    {
      this.BuK = ((k)paramab);
      AppMethodBeat.o(82239);
      return;
    }
    this.BuK = null;
    AppMethodBeat.o(82239);
  }
  
  public static final class a
  {
    public static MMWebViewWithJsApi gI(Context paramContext)
    {
      AppMethodBeat.i(197214);
      paramContext = gJ(paramContext);
      AppMethodBeat.o(197214);
      return paramContext;
    }
    
    public static MMWebViewWithJsApi gJ(Context paramContext)
    {
      AppMethodBeat.i(82237);
      MMWebViewWithJsApi.gH(paramContext);
      paramContext = new MMWebViewWithJsApi(paramContext);
      MMWebViewWithJsApi.b(paramContext);
      AppMethodBeat.o(82237);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.t;
import com.tencent.xweb.w;

public class MMWebViewWithJsApi
  extends MMWebView
{
  private k vsN;
  private boolean vsO;
  
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
    AppMethodBeat.i(10030);
    this.vsO = true;
    dOK();
    getSettings().setJavaScriptEnabled(true);
    getSettings().dYz();
    setWebChromeClient(new i(this));
    setWebViewClient(new k(this));
    paramContext = getSettings().getUserAgentString();
    if (!u.amS(paramContext))
    {
      paramContext = u.bD(getContext(), paramContext);
      getSettings().setUserAgentString(paramContext);
    }
    AppMethodBeat.o(10030);
  }
  
  public d getJsapi()
  {
    if (this.vsN != null) {
      return this.vsN.vmp;
    }
    return null;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10033);
    if (this.vsN != null)
    {
      this.vsN.oI(true);
      this.vsN.aiJ("");
    }
    super.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(10033);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(10034);
    if (this.vsN != null)
    {
      this.vsN.oI(true);
      this.vsN.aiJ("");
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(10034);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(10035);
    if (this.vsN != null)
    {
      this.vsN.oI(false);
      if (this.vsN.aiJ(paramString)) {}
    }
    else
    {
      super.loadUrl(paramString);
    }
    AppMethodBeat.o(10035);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(10032);
    super.onDetachedFromWindow();
    if ((this.vsN != null) && (this.vsO)) {
      this.vsN.cleanup();
    }
    AppMethodBeat.o(10032);
  }
  
  public void setCleanOnDetached(boolean paramBoolean)
  {
    this.vsO = paramBoolean;
  }
  
  public void setWebViewClient(w paramw)
  {
    AppMethodBeat.i(10031);
    super.setWebViewClient(paramw);
    if ((paramw instanceof k))
    {
      this.vsN = ((k)paramw);
      AppMethodBeat.o(10031);
      return;
    }
    this.vsN = null;
    AppMethodBeat.o(10031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi
 * JD-Core Version:    0.7.0.1
 */
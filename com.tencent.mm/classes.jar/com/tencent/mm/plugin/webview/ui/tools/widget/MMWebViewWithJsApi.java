package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.z;

public class MMWebViewWithJsApi
  extends MMWebView
{
  private k CMT;
  private boolean CMU;
  
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
    this.CMU = true;
    fuL();
    getSettings().setJavaScriptEnabled(true);
    getSettings().fJJ();
    setWebChromeClient(new i(this));
    setWebViewClient(new k(this));
    paramContext = getSettings().getUserAgentString();
    if (!x.aIc(paramContext))
    {
      paramContext = x.bS(getContext(), paramContext);
      getSettings().setUserAgentString(paramContext);
    }
    AppMethodBeat.o(82238);
  }
  
  public f getJsapi()
  {
    if (this.CMT != null) {
      return this.CMT.CEL;
    }
    return null;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(82241);
    if (this.CMT != null)
    {
      this.CMT.uF(true);
      this.CMT.aDy("");
    }
    super.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(82241);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(82242);
    if (this.CMT != null)
    {
      this.CMT.uF(true);
      this.CMT.aDy("");
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(82242);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(82243);
    if (this.CMT != null)
    {
      this.CMT.uF(false);
      if (this.CMT.aDy(paramString)) {}
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
    if ((this.CMT != null) && (this.CMU)) {
      this.CMT.cleanup();
    }
    AppMethodBeat.o(82240);
  }
  
  public void setCleanOnDetached(boolean paramBoolean)
  {
    this.CMU = paramBoolean;
  }
  
  public void setWebViewClient(ac paramac)
  {
    AppMethodBeat.i(82239);
    super.setWebViewClient(paramac);
    if ((paramac instanceof k))
    {
      this.CMT = ((k)paramac);
      AppMethodBeat.o(82239);
      return;
    }
    this.CMT = null;
    AppMethodBeat.o(82239);
  }
  
  public static final class a
  {
    public static MMWebViewWithJsApi gT(Context paramContext)
    {
      AppMethodBeat.i(210106);
      paramContext = gU(paramContext);
      AppMethodBeat.o(210106);
      return paramContext;
    }
    
    public static MMWebViewWithJsApi gU(Context paramContext)
    {
      AppMethodBeat.i(82237);
      MMWebViewWithJsApi.gS(paramContext);
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
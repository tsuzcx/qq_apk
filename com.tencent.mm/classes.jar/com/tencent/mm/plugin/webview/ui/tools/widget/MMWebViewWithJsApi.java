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
  private k EqT;
  private boolean EqU;
  
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
    this.EqU = true;
    fLy();
    getSettings().setJavaScriptEnabled(true);
    getSettings().gbd();
    setWebChromeClient(new i(this));
    setWebViewClient(new k(this));
    paramContext = getSettings().getUserAgentString();
    if (!x.aNE(paramContext))
    {
      paramContext = x.bW(getContext(), paramContext);
      getSettings().setUserAgentString(paramContext);
    }
    AppMethodBeat.o(82238);
  }
  
  public f getJsapi()
  {
    if (this.EqT != null) {
      return this.EqT.Eiv;
    }
    return null;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(82241);
    if (this.EqT != null)
    {
      this.EqT.vq(true);
      this.EqT.aIZ("");
    }
    super.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(82241);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(82242);
    if (this.EqT != null)
    {
      this.EqT.vq(true);
      this.EqT.aIZ("");
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(82242);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(82243);
    if (this.EqT != null)
    {
      this.EqT.vq(false);
      if (this.EqT.aIZ(paramString)) {}
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
    if ((this.EqT != null) && (this.EqU)) {
      this.EqT.cleanup();
    }
    AppMethodBeat.o(82240);
  }
  
  public void setCleanOnDetached(boolean paramBoolean)
  {
    this.EqU = paramBoolean;
  }
  
  public void setWebViewClient(ac paramac)
  {
    AppMethodBeat.i(82239);
    super.setWebViewClient(paramac);
    if ((paramac instanceof k))
    {
      this.EqT = ((k)paramac);
      AppMethodBeat.o(82239);
      return;
    }
    this.EqT = null;
    AppMethodBeat.o(82239);
  }
  
  public static final class a
  {
    public static MMWebViewWithJsApi gY(Context paramContext)
    {
      AppMethodBeat.i(221664);
      paramContext = gZ(paramContext);
      AppMethodBeat.o(221664);
      return paramContext;
    }
    
    public static MMWebViewWithJsApi gZ(Context paramContext)
    {
      AppMethodBeat.i(82237);
      MMWebViewWithJsApi.gX(paramContext);
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
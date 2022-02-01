package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.ac;

public class MMWebViewWithJsApi
  extends MMWebView
{
  private k Jza;
  private boolean Jzb;
  
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
    this.Jzb = true;
    gYV();
    getSettings().setJavaScriptEnabled(true);
    getSettings().hsW();
    setWebChromeClient(new i(this));
    setWebViewClient(new k(this));
    paramContext = getSettings().getUserAgentString();
    if (!com.tencent.mm.pluginsdk.ui.tools.z.bfF(paramContext))
    {
      paramContext = com.tencent.mm.pluginsdk.ui.tools.z.cr(getContext(), paramContext);
      getSettings().setUserAgentString(paramContext);
    }
    AppMethodBeat.o(82238);
  }
  
  public h getJsapi()
  {
    if (this.Jza != null) {
      return this.Jza.JpW;
    }
    return null;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(82241);
    if (this.Jza != null)
    {
      this.Jza.zv(true);
      this.Jza.baG("");
    }
    super.loadData(paramString1, paramString2, paramString3);
    AppMethodBeat.o(82241);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(82242);
    if (this.Jza != null)
    {
      this.Jza.zv(true);
      this.Jza.baG("");
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(82242);
  }
  
  public void loadUrl(String paramString)
  {
    AppMethodBeat.i(82243);
    if (this.Jza != null)
    {
      this.Jza.zv(false);
      if (this.Jza.baG(paramString)) {}
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
    if ((this.Jza != null) && (this.Jzb)) {
      this.Jza.cleanup();
    }
    AppMethodBeat.o(82240);
  }
  
  public void setCleanOnDetached(boolean paramBoolean)
  {
    this.Jzb = paramBoolean;
  }
  
  public void setWebViewClient(ac paramac)
  {
    AppMethodBeat.i(82239);
    super.setWebViewClient(paramac);
    if ((paramac instanceof k))
    {
      this.Jza = ((k)paramac);
      AppMethodBeat.o(82239);
      return;
    }
    this.Jza = null;
    AppMethodBeat.o(82239);
  }
  
  public static final class a
  {
    public static MMWebViewWithJsApi hY(Context paramContext)
    {
      AppMethodBeat.i(258630);
      paramContext = hZ(paramContext);
      AppMethodBeat.o(258630);
      return paramContext;
    }
    
    public static MMWebViewWithJsApi hZ(Context paramContext)
    {
      AppMethodBeat.i(82237);
      MMWebViewWithJsApi.bQ(paramContext);
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
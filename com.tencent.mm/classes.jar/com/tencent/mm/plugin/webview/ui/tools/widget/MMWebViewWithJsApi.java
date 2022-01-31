package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.n;
import com.tencent.xweb.p;

public class MMWebViewWithJsApi
  extends MMWebView
{
  private k rCB;
  private boolean rCC = true;
  
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
    cJR();
    getSettings().setJavaScriptEnabled(true);
    getSettings().cSu();
    setWebChromeClient(new i(this));
    setWebViewClient(new k(this));
    paramContext = getSettings().getUserAgentString();
    if (!s.WZ(paramContext))
    {
      paramContext = s.aX(getContext(), paramContext);
      getSettings().setUserAgentString(paramContext);
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (this.rCB != null)
    {
      this.rCB.rCp = true;
      this.rCB.TI("");
    }
    super.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (this.rCB != null)
    {
      this.rCB.rCp = true;
      this.rCB.TI("");
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if (this.rCB != null)
    {
      this.rCB.rCp = false;
      if (this.rCB.TI(paramString)) {}
    }
    else
    {
      super.loadUrl(paramString);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.rCB != null) && (this.rCC)) {
      this.rCB.cleanup();
    }
  }
  
  public void setCleanOnDetached(boolean paramBoolean)
  {
    this.rCC = paramBoolean;
  }
  
  public void setWebViewClient(p paramp)
  {
    super.setWebViewClient(paramp);
    if ((paramp instanceof k))
    {
      this.rCB = ((k)paramp);
      return;
    }
    this.rCB = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi
 * JD-Core Version:    0.7.0.1
 */
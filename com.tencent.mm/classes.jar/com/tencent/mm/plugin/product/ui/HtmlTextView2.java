package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings.LayoutAlgorithm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.n;
import com.tencent.xweb.p;

public class HtmlTextView2
  extends MMWebView
{
  private p mTi = new HtmlTextView2.2(this);
  
  public HtmlTextView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(ae.getContext(), paramAttributeSet);
    initView();
  }
  
  public HtmlTextView2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(ae.getContext(), paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    setOnTouchListener(new HtmlTextView2.1(this));
    setVerticalScrollBarEnabled(false);
    getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    getSettings().setDefaultTextEncodingName("utf-8");
  }
  
  public void setText(String paramString)
  {
    setWebViewClient(null);
    loadData(paramString, "text/html", "utf-8");
    setWebViewClient(this.mTi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.HtmlTextView2
 * JD-Core Version:    0.7.0.1
 */
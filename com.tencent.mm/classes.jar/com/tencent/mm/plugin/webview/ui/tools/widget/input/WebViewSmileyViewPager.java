package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.base.CustomViewPager;

public class WebViewSmileyViewPager
  extends CustomViewPager
{
  private int hxX = 0;
  private int hxY = 0;
  private c rDq;
  private WebViewSmileyViewPager.a rDz;
  
  public WebViewSmileyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (d.gF(9)) {
      setOverScrollMode(2);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.rDq != null) && (((paramInt1 > 0) && (paramInt3 != paramInt1)) || ((paramInt2 > 0) && (paramInt4 != paramInt2) && (((paramInt2 > 0) && (paramInt2 != this.hxX)) || ((paramInt1 > 0) && (paramInt1 != this.hxY))))))
    {
      this.rDq.hxU = paramInt2;
      this.rDq.hxV = paramInt1;
      if (this.rDz != null) {
        this.rDz.asF();
      }
    }
    if (paramInt2 > 0) {
      this.hxX = paramInt2;
    }
    if (paramInt1 > 0) {
      this.hxY = paramInt1;
    }
  }
  
  public void setOnSizeChangedListener(WebViewSmileyViewPager.a parama)
  {
    this.rDz = parama;
  }
  
  public void setPanelManager(c paramc)
  {
    this.rDq = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.base.CustomViewPager;

public class WebViewSmileyViewPager
  extends CustomViewPager
{
  private int jqh;
  private int jqi;
  private c vtC;
  private WebViewSmileyViewPager.a vtL;
  
  public WebViewSmileyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(10126);
    this.jqh = 0;
    this.jqi = 0;
    if (d.fv(9)) {
      setOverScrollMode(2);
    }
    AppMethodBeat.o(10126);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(10127);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.vtC != null) && (((paramInt1 > 0) && (paramInt3 != paramInt1)) || ((paramInt2 > 0) && (paramInt4 != paramInt2) && (((paramInt2 > 0) && (paramInt2 != this.jqh)) || ((paramInt1 > 0) && (paramInt1 != this.jqi))))))
    {
      this.vtC.jqe = paramInt2;
      this.vtC.jqf = paramInt1;
      if (this.vtL != null) {
        this.vtL.aRJ();
      }
    }
    if (paramInt2 > 0) {
      this.jqh = paramInt2;
    }
    if (paramInt1 > 0) {
      this.jqi = paramInt1;
    }
    AppMethodBeat.o(10127);
  }
  
  public void setOnSizeChangedListener(WebViewSmileyViewPager.a parama)
  {
    this.vtL = parama;
  }
  
  public void setPanelManager(c paramc)
  {
    this.vtC = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager
 * JD-Core Version:    0.7.0.1
 */
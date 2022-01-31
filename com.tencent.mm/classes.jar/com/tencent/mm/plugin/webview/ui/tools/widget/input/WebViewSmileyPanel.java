package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel
  extends LinearLayout
  implements ViewPager.e, WebViewSmileyViewPager.a
{
  View QR = null;
  private boolean hvi = false;
  MMActivity hxN;
  private MMDotView hxP;
  private boolean hxQ = true;
  c rDq;
  private WebViewSmileyPanel.a rDt;
  private WebViewSmileyViewPager rDu = null;
  
  public WebViewSmileyPanel(Context paramContext)
  {
    super(paramContext, null);
    init();
  }
  
  public WebViewSmileyPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void asI()
  {
    if (this.hxP == null) {}
    boolean bool;
    do
    {
      return;
      bool = j.fA(getContext());
    } while (bool == this.hxQ);
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool)
    {
      this.hxP.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding));
      localLayoutParams = (RelativeLayout.LayoutParams)this.hxP.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.f.emoji_panel_tab_height);
      this.hxP.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.hxQ = bool;
      return;
      this.hxP.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.f.LittlePadding));
      localLayoutParams = (RelativeLayout.LayoutParams)this.hxP.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.hxP.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    this.hxN = ((MMActivity)getContext());
    this.rDq = new c();
    this.rDq.hxz = getContext();
    this.rDq.rDx = this.rDt;
  }
  
  public final void Q(int paramInt) {}
  
  public final void R(int paramInt)
  {
    a locala = this.rDq.cgW();
    int i = locala.getPageCount();
    int j = locala.hxB;
    if (i <= 1)
    {
      this.hxP.setVisibility(4);
      return;
    }
    this.hxP.setVisibility(0);
    this.hxP.setDotCount(i);
    this.hxP.setSelectedDot(paramInt - j);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void asF()
  {
    if (this.rDu == null) {
      return;
    }
    this.rDq.hxQ = j.fA(getContext());
    WebViewSmileyViewPager.b localb = (WebViewSmileyViewPager.b)this.rDu.getAdapter();
    if (localb != null)
    {
      localb.hya.clear();
      localb.rDq = this.rDq;
      localb.notifyDataSetChanged();
    }
    for (;;)
    {
      this.rDu.post(new WebViewSmileyPanel.1(this));
      return;
      localb = new WebViewSmileyViewPager.b();
      localb.rDq = this.rDq;
      this.rDu.setAdapter(localb);
    }
  }
  
  protected final c getManager()
  {
    return this.rDq;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.hvi)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      return;
    }
    j.fA(getContext());
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    asI();
  }
  
  public void setOnTextOperationListener(WebViewSmileyPanel.a parama)
  {
    this.rDt = parama;
    this.rDq.rDx = this.rDt;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (this.hvi = false;; this.hvi = true)
    {
      super.setVisibility(paramInt);
      if (!this.hvi)
      {
        this.hxN.XM();
        if ((this.QR == null) || (getChildCount() <= 0)) {
          break;
        }
        this.QR.setVisibility(0);
      }
      return;
    }
    if (this.QR == null) {
      this.QR = View.inflate(ae.getContext(), R.i.webview_smiley_panel, null);
    }
    for (;;)
    {
      this.rDu = ((WebViewSmileyViewPager)this.QR.findViewById(R.h.smiley_panel_view_pager));
      this.rDu.setOnPageChangeListener(this);
      this.rDu.setPanelManager(this.rDq);
      this.rDu.setOnSizeChangedListener(this);
      this.hxP = ((MMDotView)this.QR.findViewById(R.h.smiley_panel_dot));
      this.hxP.setDotCount(1);
      asI();
      addView(this.QR, new LinearLayout.LayoutParams(-1, -1));
      return;
      if (this.QR.getParent() != null) {
        ((ViewGroup)this.QR.getParent()).removeView(this.QR);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel
 * JD-Core Version:    0.7.0.1
 */
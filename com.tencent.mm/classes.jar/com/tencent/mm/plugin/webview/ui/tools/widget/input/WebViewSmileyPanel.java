package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.webview.c.d;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, WebViewSmileyViewPager.a
{
  private c Xsf;
  private a Xsp;
  private WebViewSmileyViewPager Xsq;
  private boolean Xsr;
  private View mContentView;
  public boolean uIa;
  private MMActivity wry;
  private MMDotView xUq;
  
  public WebViewSmileyPanel(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(82349);
    this.uIa = false;
    this.mContentView = null;
    this.Xsq = null;
    this.Xsr = true;
    init();
    AppMethodBeat.o(82349);
  }
  
  public WebViewSmileyPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82350);
    this.uIa = false;
    this.mContentView = null;
    this.Xsq = null;
    this.Xsr = true;
    init();
    AppMethodBeat.o(82350);
  }
  
  private void iCO()
  {
    AppMethodBeat.i(82353);
    if (this.xUq == null)
    {
      AppMethodBeat.o(82353);
      return;
    }
    boolean bool = j.isPortOrientation(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.Xsr)
    {
      if (!bool) {
        break label108;
      }
      this.xUq.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(c.d.MiddlePadding));
      localLayoutParams = (RelativeLayout.LayoutParams)this.xUq.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(c.d.emoji_panel_tab_height);
      this.xUq.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.Xsr = bool;
      AppMethodBeat.o(82353);
      return;
      label108:
      this.xUq.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(c.d.LittlePadding));
      localLayoutParams = (RelativeLayout.LayoutParams)this.xUq.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.xUq.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(82351);
    this.wry = ((MMActivity)getContext());
    this.Xsf = new c();
    this.Xsf.xNl = getContext();
    this.Xsf.Xsu = this.Xsp;
    AppMethodBeat.o(82351);
  }
  
  public final void cSc()
  {
    AppMethodBeat.i(298104);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(0);
    }
    AppMethodBeat.o(298104);
  }
  
  protected final c getManager()
  {
    return this.Xsf;
  }
  
  public final void iCN()
  {
    AppMethodBeat.i(82346);
    if (this.Xsq == null)
    {
      AppMethodBeat.o(82346);
      return;
    }
    this.Xsf.Xsr = j.isPortOrientation(getContext());
    WebViewSmileyViewPager.b localb = (WebViewSmileyViewPager.b)this.Xsq.getAdapter();
    if (localb != null)
    {
      localb.XsB.clear();
      localb.Xsf = this.Xsf;
      localb.notifyDataSetChanged();
    }
    for (;;)
    {
      this.Xsq.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(82344);
          WebViewSmileyPanel.this.onPageSelected(WebViewSmileyPanel.a(WebViewSmileyPanel.this).getCurrentItem());
          AppMethodBeat.o(82344);
        }
      });
      AppMethodBeat.o(82346);
      return;
      localb = new WebViewSmileyViewPager.b();
      localb.Xsf = this.Xsf;
      this.Xsq.setAdapter(localb);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(298101);
    this.Xsf.onDestroy();
    if (this.mContentView != null)
    {
      ((ViewGroup)this.mContentView.getParent()).removeView(this.mContentView);
      ((ViewGroup)this.mContentView).removeAllViews();
      this.mContentView = null;
    }
    this.wry = null;
    AppMethodBeat.o(298101);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82348);
    if (this.uIa)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(82348);
      return;
    }
    j.isPortOrientation(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(82348);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(82345);
    a locala = this.Xsf.iCP();
    int i = locala.getPageCount();
    int j = locala.uQR;
    if (i <= 1)
    {
      this.xUq.setVisibility(4);
      AppMethodBeat.o(82345);
      return;
    }
    this.xUq.setVisibility(0);
    this.xUq.setDotCount(i);
    this.xUq.setSelectedDot(paramInt - j);
    AppMethodBeat.o(82345);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82347);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    iCO();
    AppMethodBeat.o(82347);
  }
  
  public void setOnTextOperationListener(a parama)
  {
    this.Xsp = parama;
    this.Xsf.Xsu = this.Xsp;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(82352);
    if (paramInt == 0) {}
    for (this.uIa = false;; this.uIa = true)
    {
      super.setVisibility(paramInt);
      if (this.uIa) {
        break label180;
      }
      this.wry.hideVKB();
      if ((this.mContentView == null) || (getChildCount() <= 0)) {
        break;
      }
      this.mContentView.setVisibility(0);
      AppMethodBeat.o(82352);
      return;
    }
    if (this.mContentView == null) {
      this.mContentView = View.inflate(MMApplicationContext.getContext(), c.g.webview_smiley_panel, null);
    }
    for (;;)
    {
      this.Xsq = ((WebViewSmileyViewPager)this.mContentView.findViewById(c.f.smiley_panel_view_pager));
      this.Xsq.setOnPageChangeListener(this);
      this.Xsq.setPanelManager(this.Xsf);
      this.Xsq.setOnSizeChangedListener(this);
      this.xUq = ((MMDotView)this.mContentView.findViewById(c.f.smiley_panel_dot));
      this.xUq.setDotCount(1);
      iCO();
      addView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
      label180:
      AppMethodBeat.o(82352);
      return;
      if (this.mContentView.getParent() != null) {
        ((ViewGroup)this.mContentView.getParent()).removeView(this.mContentView);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aWM();
    
    public abstract void append(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel
 * JD-Core Version:    0.7.0.1
 */
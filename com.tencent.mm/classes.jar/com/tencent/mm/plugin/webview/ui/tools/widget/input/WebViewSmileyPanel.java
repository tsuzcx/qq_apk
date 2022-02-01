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
import com.tencent.mm.compatible.util.i;
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
  private c Qzm;
  private a Qzv;
  private WebViewSmileyViewPager Qzw;
  private boolean Qzx;
  private View mContentView;
  public boolean rwW;
  private MMActivity tmY;
  private MMDotView uLP;
  
  public WebViewSmileyPanel(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(82349);
    this.rwW = false;
    this.mContentView = null;
    this.Qzw = null;
    this.Qzx = true;
    init();
    AppMethodBeat.o(82349);
  }
  
  public WebViewSmileyPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82350);
    this.rwW = false;
    this.mContentView = null;
    this.Qzw = null;
    this.Qzx = true;
    init();
    AppMethodBeat.o(82350);
  }
  
  private void hcn()
  {
    AppMethodBeat.i(82353);
    if (this.uLP == null)
    {
      AppMethodBeat.o(82353);
      return;
    }
    boolean bool = i.isPortOrientation(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.Qzx)
    {
      if (!bool) {
        break label108;
      }
      this.uLP.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(c.d.MiddlePadding));
      localLayoutParams = (RelativeLayout.LayoutParams)this.uLP.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(c.d.emoji_panel_tab_height);
      this.uLP.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.Qzx = bool;
      AppMethodBeat.o(82353);
      return;
      label108:
      this.uLP.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(c.d.LittlePadding));
      localLayoutParams = (RelativeLayout.LayoutParams)this.uLP.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.uLP.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(82351);
    this.tmY = ((MMActivity)getContext());
    this.Qzm = new c();
    this.Qzm.uEJ = getContext();
    this.Qzm.QzA = this.Qzv;
    AppMethodBeat.o(82351);
  }
  
  public final void cpz()
  {
    AppMethodBeat.i(233011);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(0);
    }
    AppMethodBeat.o(233011);
  }
  
  protected final c getManager()
  {
    return this.Qzm;
  }
  
  public final void hcm()
  {
    AppMethodBeat.i(82346);
    if (this.Qzw == null)
    {
      AppMethodBeat.o(82346);
      return;
    }
    this.Qzm.Qzx = i.isPortOrientation(getContext());
    WebViewSmileyViewPager.b localb = (WebViewSmileyViewPager.b)this.Qzw.getAdapter();
    if (localb != null)
    {
      localb.QzH.clear();
      localb.Qzm = this.Qzm;
      localb.notifyDataSetChanged();
    }
    for (;;)
    {
      this.Qzw.post(new Runnable()
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
      localb.Qzm = this.Qzm;
      this.Qzw.setAdapter(localb);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(233009);
    this.Qzm.onDestroy();
    if (this.mContentView != null)
    {
      ((ViewGroup)this.mContentView.getParent()).removeView(this.mContentView);
      ((ViewGroup)this.mContentView).removeAllViews();
      this.mContentView = null;
    }
    this.tmY = null;
    AppMethodBeat.o(233009);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82348);
    if (this.rwW)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(82348);
      return;
    }
    i.isPortOrientation(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(82348);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(82345);
    a locala = this.Qzm.hco();
    int i = locala.getPageCount();
    int j = locala.rFF;
    if (i <= 1)
    {
      this.uLP.setVisibility(4);
      AppMethodBeat.o(82345);
      return;
    }
    this.uLP.setVisibility(0);
    this.uLP.setDotCount(i);
    this.uLP.setSelectedDot(paramInt - j);
    AppMethodBeat.o(82345);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82347);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    hcn();
    AppMethodBeat.o(82347);
  }
  
  public void setOnTextOperationListener(a parama)
  {
    this.Qzv = parama;
    this.Qzm.QzA = this.Qzv;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(82352);
    if (paramInt == 0) {}
    for (this.rwW = false;; this.rwW = true)
    {
      super.setVisibility(paramInt);
      if (this.rwW) {
        break label180;
      }
      this.tmY.hideVKB();
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
      this.Qzw = ((WebViewSmileyViewPager)this.mContentView.findViewById(c.f.smiley_panel_view_pager));
      this.Qzw.setOnPageChangeListener(this);
      this.Qzw.setPanelManager(this.Qzm);
      this.Qzw.setOnSizeChangedListener(this);
      this.uLP = ((MMDotView)this.mContentView.findViewById(c.f.smiley_panel_dot));
      this.uLP.setDotCount(1);
      hcn();
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
    public abstract void aDO();
    
    public abstract void append(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel
 * JD-Core Version:    0.7.0.1
 */
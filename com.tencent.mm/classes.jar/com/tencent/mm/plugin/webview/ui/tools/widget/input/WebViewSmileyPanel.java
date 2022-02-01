package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, WebViewSmileyViewPager.a
{
  c BwH;
  private a BwK;
  private WebViewSmileyViewPager BwL;
  View mContentView;
  private boolean mdi;
  private MMDotView mfR;
  private boolean mfS;
  MMActivity nqt;
  
  public WebViewSmileyPanel(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(82349);
    this.mdi = false;
    this.mContentView = null;
    this.BwL = null;
    this.mfS = true;
    init();
    AppMethodBeat.o(82349);
  }
  
  public WebViewSmileyPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82350);
    this.mdi = false;
    this.mContentView = null;
    this.BwL = null;
    this.mfS = true;
    init();
    AppMethodBeat.o(82350);
  }
  
  private void bue()
  {
    AppMethodBeat.i(82353);
    if (this.mfR == null)
    {
      AppMethodBeat.o(82353);
      return;
    }
    boolean bool = i.ip(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.mfS)
    {
      if (!bool) {
        break label106;
      }
      this.mfR.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165500));
      localLayoutParams = (RelativeLayout.LayoutParams)this.mfR.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131166250);
      this.mfR.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.mfS = bool;
      AppMethodBeat.o(82353);
      return;
      label106:
      this.mfR.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165490));
      localLayoutParams = (RelativeLayout.LayoutParams)this.mfR.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.mfR.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(82351);
    this.nqt = ((MMActivity)getContext());
    this.BwH = new c();
    this.BwH.mfC = getContext();
    this.BwH.BwO = this.BwK;
    AppMethodBeat.o(82351);
  }
  
  public final void bua()
  {
    AppMethodBeat.i(82346);
    if (this.BwL == null)
    {
      AppMethodBeat.o(82346);
      return;
    }
    this.BwH.mfS = i.ip(getContext());
    WebViewSmileyViewPager.b localb = (WebViewSmileyViewPager.b)this.BwL.getAdapter();
    if (localb != null)
    {
      localb.mgc.clear();
      localb.BwH = this.BwH;
      localb.notifyDataSetChanged();
    }
    for (;;)
    {
      this.BwL.post(new Runnable()
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
      localb.BwH = this.BwH;
      this.BwL.setAdapter(localb);
    }
  }
  
  protected final c getManager()
  {
    return this.BwH;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82348);
    if (this.mdi)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(82348);
      return;
    }
    i.ip(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(82348);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(82345);
    a locala = this.BwH.eru();
    int i = locala.getPageCount();
    int j = locala.mfE;
    if (i <= 1)
    {
      this.mfR.setVisibility(4);
      AppMethodBeat.o(82345);
      return;
    }
    this.mfR.setVisibility(0);
    this.mfR.setDotCount(i);
    this.mfR.setSelectedDot(paramInt - j);
    AppMethodBeat.o(82345);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82347);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    bue();
    AppMethodBeat.o(82347);
  }
  
  public void setOnTextOperationListener(a parama)
  {
    this.BwK = parama;
    this.BwH.BwO = this.BwK;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(82352);
    if (paramInt == 0) {}
    for (this.mdi = false;; this.mdi = true)
    {
      super.setVisibility(paramInt);
      if (this.mdi) {
        break label177;
      }
      this.nqt.hideVKB();
      if ((this.mContentView == null) || (getChildCount() <= 0)) {
        break;
      }
      this.mContentView.setVisibility(0);
      AppMethodBeat.o(82352);
      return;
    }
    if (this.mContentView == null) {
      this.mContentView = View.inflate(aj.getContext(), 2131496090, null);
    }
    for (;;)
    {
      this.BwL = ((WebViewSmileyViewPager)this.mContentView.findViewById(2131304873));
      this.BwL.setOnPageChangeListener(this);
      this.BwL.setPanelManager(this.BwH);
      this.BwL.setOnSizeChangedListener(this);
      this.mfR = ((MMDotView)this.mContentView.findViewById(2131304870));
      this.mfR.setDotCount(1);
      bue();
      addView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
      label177:
      AppMethodBeat.o(82352);
      return;
      if (this.mContentView.getParent() != null) {
        ((ViewGroup)this.mContentView.getParent()).removeView(this.mContentView);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void append(String paramString);
    
    public abstract void btF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel
 * JD-Core Version:    0.7.0.1
 */
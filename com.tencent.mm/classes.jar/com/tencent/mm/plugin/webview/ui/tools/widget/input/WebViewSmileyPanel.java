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
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, WebViewSmileyViewPager.a
{
  c COP;
  private a COS;
  private WebViewSmileyViewPager COT;
  View mContentView;
  private boolean mFh;
  private MMDotView mHQ;
  private boolean mHR;
  MMActivity nTt;
  
  public WebViewSmileyPanel(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(82349);
    this.mFh = false;
    this.mContentView = null;
    this.COT = null;
    this.mHR = true;
    init();
    AppMethodBeat.o(82349);
  }
  
  public WebViewSmileyPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82350);
    this.mFh = false;
    this.mContentView = null;
    this.COT = null;
    this.mHR = true;
    init();
    AppMethodBeat.o(82350);
  }
  
  private void bBd()
  {
    AppMethodBeat.i(82353);
    if (this.mHQ == null)
    {
      AppMethodBeat.o(82353);
      return;
    }
    boolean bool = i.iA(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.mHR)
    {
      if (!bool) {
        break label106;
      }
      this.mHQ.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165500));
      localLayoutParams = (RelativeLayout.LayoutParams)this.mHQ.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131166250);
      this.mHQ.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.mHR = bool;
      AppMethodBeat.o(82353);
      return;
      label106:
      this.mHQ.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165490));
      localLayoutParams = (RelativeLayout.LayoutParams)this.mHQ.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.mHQ.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(82351);
    this.nTt = ((MMActivity)getContext());
    this.COP = new c();
    this.COP.mHB = getContext();
    this.COP.COW = this.COS;
    AppMethodBeat.o(82351);
  }
  
  public final void bAZ()
  {
    AppMethodBeat.i(82346);
    if (this.COT == null)
    {
      AppMethodBeat.o(82346);
      return;
    }
    this.COP.mHR = i.iA(getContext());
    WebViewSmileyViewPager.b localb = (WebViewSmileyViewPager.b)this.COT.getAdapter();
    if (localb != null)
    {
      localb.mIb.clear();
      localb.COP = this.COP;
      localb.notifyDataSetChanged();
    }
    for (;;)
    {
      this.COT.post(new Runnable()
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
      localb.COP = this.COP;
      this.COT.setAdapter(localb);
    }
  }
  
  protected final c getManager()
  {
    return this.COP;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82348);
    if (this.mFh)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(82348);
      return;
    }
    i.iA(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(82348);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(82345);
    a locala = this.COP.eGO();
    int i = locala.getPageCount();
    int j = locala.mHD;
    if (i <= 1)
    {
      this.mHQ.setVisibility(4);
      AppMethodBeat.o(82345);
      return;
    }
    this.mHQ.setVisibility(0);
    this.mHQ.setDotCount(i);
    this.mHQ.setSelectedDot(paramInt - j);
    AppMethodBeat.o(82345);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82347);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    bBd();
    AppMethodBeat.o(82347);
  }
  
  public void setOnTextOperationListener(a parama)
  {
    this.COS = parama;
    this.COP.COW = this.COS;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(82352);
    if (paramInt == 0) {}
    for (this.mFh = false;; this.mFh = true)
    {
      super.setVisibility(paramInt);
      if (this.mFh) {
        break label177;
      }
      this.nTt.hideVKB();
      if ((this.mContentView == null) || (getChildCount() <= 0)) {
        break;
      }
      this.mContentView.setVisibility(0);
      AppMethodBeat.o(82352);
      return;
    }
    if (this.mContentView == null) {
      this.mContentView = View.inflate(ai.getContext(), 2131496090, null);
    }
    for (;;)
    {
      this.COT = ((WebViewSmileyViewPager)this.mContentView.findViewById(2131304873));
      this.COT.setOnPageChangeListener(this);
      this.COT.setPanelManager(this.COP);
      this.COT.setOnSizeChangedListener(this);
      this.mHQ = ((MMDotView)this.mContentView.findViewById(2131304870));
      this.mHQ.setDotCount(1);
      bBd();
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
    public abstract void amb();
    
    public abstract void append(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, WebViewSmileyViewPager.a
{
  private c ELj;
  private a ELm;
  private WebViewSmileyViewPager ELn;
  private View mContentView;
  private boolean nkN;
  private MMDotView nnw;
  private boolean nnx;
  private MMActivity oDq;
  
  public WebViewSmileyPanel(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(82349);
    this.nkN = false;
    this.mContentView = null;
    this.ELn = null;
    this.nnx = true;
    init();
    AppMethodBeat.o(82349);
  }
  
  public WebViewSmileyPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82350);
    this.nkN = false;
    this.mContentView = null;
    this.ELn = null;
    this.nnx = true;
    init();
    AppMethodBeat.o(82350);
  }
  
  private void bFX()
  {
    AppMethodBeat.i(82353);
    if (this.nnw == null)
    {
      AppMethodBeat.o(82353);
      return;
    }
    boolean bool = i.iP(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.nnx)
    {
      if (!bool) {
        break label106;
      }
      this.nnw.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165500));
      localLayoutParams = (RelativeLayout.LayoutParams)this.nnw.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131166250);
      this.nnw.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.nnx = bool;
      AppMethodBeat.o(82353);
      return;
      label106:
      this.nnw.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165490));
      localLayoutParams = (RelativeLayout.LayoutParams)this.nnw.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.nnw.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(82351);
    this.oDq = ((MMActivity)getContext());
    this.ELj = new c();
    this.ELj.nnh = getContext();
    this.ELj.ELq = this.ELm;
    AppMethodBeat.o(82351);
  }
  
  public final void bFT()
  {
    AppMethodBeat.i(82346);
    if (this.ELn == null)
    {
      AppMethodBeat.o(82346);
      return;
    }
    this.ELj.nnx = i.iP(getContext());
    WebViewSmileyViewPager.b localb = (WebViewSmileyViewPager.b)this.ELn.getAdapter();
    if (localb != null)
    {
      localb.nnH.clear();
      localb.ELj = this.ELj;
      localb.notifyDataSetChanged();
    }
    for (;;)
    {
      this.ELn.post(new Runnable()
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
      localb.ELj = this.ELj;
      this.ELn.setAdapter(localb);
    }
  }
  
  public final void bFU()
  {
    AppMethodBeat.i(199201);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(0);
    }
    AppMethodBeat.o(199201);
  }
  
  protected final c getManager()
  {
    return this.ELj;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199200);
    this.ELj.onDestroy();
    if (this.mContentView != null)
    {
      ((ViewGroup)this.mContentView.getParent()).removeView(this.mContentView);
      ((ViewGroup)this.mContentView).removeAllViews();
      this.mContentView = null;
    }
    this.oDq = null;
    AppMethodBeat.o(199200);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82348);
    if (this.nkN)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(82348);
      return;
    }
    i.iP(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(82348);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(82345);
    a locala = this.ELj.eZA();
    int i = locala.getPageCount();
    int j = locala.nnj;
    if (i <= 1)
    {
      this.nnw.setVisibility(4);
      AppMethodBeat.o(82345);
      return;
    }
    this.nnw.setVisibility(0);
    this.nnw.setDotCount(i);
    this.nnw.setSelectedDot(paramInt - j);
    AppMethodBeat.o(82345);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82347);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    bFX();
    AppMethodBeat.o(82347);
  }
  
  public void setOnTextOperationListener(a parama)
  {
    this.ELm = parama;
    this.ELj.ELq = this.ELm;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(82352);
    if (paramInt == 0) {}
    for (this.nkN = false;; this.nkN = true)
    {
      super.setVisibility(paramInt);
      if (this.nkN) {
        break label178;
      }
      this.oDq.hideVKB();
      if ((this.mContentView == null) || (getChildCount() <= 0)) {
        break;
      }
      this.mContentView.setVisibility(0);
      AppMethodBeat.o(82352);
      return;
    }
    if (this.mContentView == null) {
      this.mContentView = View.inflate(ak.getContext(), 2131496090, null);
    }
    for (;;)
    {
      this.ELn = ((WebViewSmileyViewPager)this.mContentView.findViewById(2131304873));
      this.ELn.setOnPageChangeListener(this);
      this.ELn.setPanelManager(this.ELj);
      this.ELn.setOnSizeChangedListener(this);
      this.nnw = ((MMDotView)this.mContentView.findViewById(2131304870));
      this.nnw.setDotCount(1);
      bFX();
      addView(this.mContentView, new LinearLayout.LayoutParams(-1, -1));
      label178:
      AppMethodBeat.o(82352);
      return;
      if (this.mContentView.getParent() != null) {
        ((ViewGroup)this.mContentView.getParent()).removeView(this.mContentView);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void apc();
    
    public abstract void append(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel
 * JD-Core Version:    0.7.0.1
 */
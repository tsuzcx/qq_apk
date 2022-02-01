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
  c EsP;
  private a EsS;
  private WebViewSmileyViewPager EsT;
  View mContentView;
  private boolean nfF;
  private MMDotView nio;
  private boolean nip;
  MMActivity owO;
  
  public WebViewSmileyPanel(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(82349);
    this.nfF = false;
    this.mContentView = null;
    this.EsT = null;
    this.nip = true;
    init();
    AppMethodBeat.o(82349);
  }
  
  public WebViewSmileyPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82350);
    this.nfF = false;
    this.mContentView = null;
    this.EsT = null;
    this.nip = true;
    init();
    AppMethodBeat.o(82350);
  }
  
  private void bFf()
  {
    AppMethodBeat.i(82353);
    if (this.nio == null)
    {
      AppMethodBeat.o(82353);
      return;
    }
    boolean bool = i.iK(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.nip)
    {
      if (!bool) {
        break label106;
      }
      this.nio.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165500));
      localLayoutParams = (RelativeLayout.LayoutParams)this.nio.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131166250);
      this.nio.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.nip = bool;
      AppMethodBeat.o(82353);
      return;
      label106:
      this.nio.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165490));
      localLayoutParams = (RelativeLayout.LayoutParams)this.nio.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.nio.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(82351);
    this.owO = ((MMActivity)getContext());
    this.EsP = new c();
    this.EsP.nhZ = getContext();
    this.EsP.EsW = this.EsS;
    AppMethodBeat.o(82351);
  }
  
  public final void bFb()
  {
    AppMethodBeat.i(82346);
    if (this.EsT == null)
    {
      AppMethodBeat.o(82346);
      return;
    }
    this.EsP.nip = i.iK(getContext());
    WebViewSmileyViewPager.b localb = (WebViewSmileyViewPager.b)this.EsT.getAdapter();
    if (localb != null)
    {
      localb.niz.clear();
      localb.EsP = this.EsP;
      localb.notifyDataSetChanged();
    }
    for (;;)
    {
      this.EsT.post(new Runnable()
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
      localb.EsP = this.EsP;
      this.EsT.setAdapter(localb);
    }
  }
  
  protected final c getManager()
  {
    return this.EsP;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82348);
    if (this.nfF)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(82348);
      return;
    }
    i.iK(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(82348);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(82345);
    a locala = this.EsP.eVO();
    int i = locala.getPageCount();
    int j = locala.nib;
    if (i <= 1)
    {
      this.nio.setVisibility(4);
      AppMethodBeat.o(82345);
      return;
    }
    this.nio.setVisibility(0);
    this.nio.setDotCount(i);
    this.nio.setSelectedDot(paramInt - j);
    AppMethodBeat.o(82345);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82347);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    bFf();
    AppMethodBeat.o(82347);
  }
  
  public void setOnTextOperationListener(a parama)
  {
    this.EsS = parama;
    this.EsP.EsW = this.EsS;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(82352);
    if (paramInt == 0) {}
    for (this.nfF = false;; this.nfF = true)
    {
      super.setVisibility(paramInt);
      if (this.nfF) {
        break label177;
      }
      this.owO.hideVKB();
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
      this.EsT = ((WebViewSmileyViewPager)this.mContentView.findViewById(2131304873));
      this.EsT.setOnPageChangeListener(this);
      this.EsT.setPanelManager(this.EsP);
      this.EsT.setOnSizeChangedListener(this);
      this.nio = ((MMDotView)this.mContentView.findViewById(2131304870));
      this.nio.setDotCount(1);
      bFf();
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
    public abstract void aoO();
    
    public abstract void append(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel
 * JD-Core Version:    0.7.0.1
 */
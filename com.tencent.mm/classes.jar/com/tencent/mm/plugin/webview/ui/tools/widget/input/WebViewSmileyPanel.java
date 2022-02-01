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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, WebViewSmileyViewPager.a
{
  private c JBa;
  private a JBd;
  private WebViewSmileyViewPager JBe;
  private View mContentView;
  private boolean ouu;
  private MMDotView oxc;
  private boolean oxd;
  private MMActivity pQZ;
  
  public WebViewSmileyPanel(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(82349);
    this.ouu = false;
    this.mContentView = null;
    this.JBe = null;
    this.oxd = true;
    init();
    AppMethodBeat.o(82349);
  }
  
  public WebViewSmileyPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(82350);
    this.ouu = false;
    this.mContentView = null;
    this.JBe = null;
    this.oxd = true;
    init();
    AppMethodBeat.o(82350);
  }
  
  private void ccn()
  {
    AppMethodBeat.i(82353);
    if (this.oxc == null)
    {
      AppMethodBeat.o(82353);
      return;
    }
    boolean bool = i.isPortOrientation(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.oxd)
    {
      if (!bool) {
        break label106;
      }
      this.oxc.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165518));
      localLayoutParams = (RelativeLayout.LayoutParams)this.oxc.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131166293);
      this.oxc.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.oxd = bool;
      AppMethodBeat.o(82353);
      return;
      label106:
      this.oxc.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131165508));
      localLayoutParams = (RelativeLayout.LayoutParams)this.oxc.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.oxc.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(82351);
    this.pQZ = ((MMActivity)getContext());
    this.JBa = new c();
    this.JBa.owO = getContext();
    this.JBa.JBh = this.JBd;
    AppMethodBeat.o(82351);
  }
  
  public final void ccj()
  {
    AppMethodBeat.i(82346);
    if (this.JBe == null)
    {
      AppMethodBeat.o(82346);
      return;
    }
    this.JBa.oxd = i.isPortOrientation(getContext());
    WebViewSmileyViewPager.b localb = (WebViewSmileyViewPager.b)this.JBe.getAdapter();
    if (localb != null)
    {
      localb.oxn.clear();
      localb.JBa = this.JBa;
      localb.notifyDataSetChanged();
    }
    for (;;)
    {
      this.JBe.post(new Runnable()
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
      localb.JBa = this.JBa;
      this.JBe.setAdapter(localb);
    }
  }
  
  public final void cck()
  {
    AppMethodBeat.i(212144);
    if (this.mContentView != null) {
      this.mContentView.setVisibility(0);
    }
    AppMethodBeat.o(212144);
  }
  
  protected final c getManager()
  {
    return this.JBa;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212143);
    this.JBa.onDestroy();
    if (this.mContentView != null)
    {
      ((ViewGroup)this.mContentView.getParent()).removeView(this.mContentView);
      ((ViewGroup)this.mContentView).removeAllViews();
      this.mContentView = null;
    }
    this.pQZ = null;
    AppMethodBeat.o(212143);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82348);
    if (this.ouu)
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
    a locala = this.JBa.giG();
    int i = locala.getPageCount();
    int j = locala.owQ;
    if (i <= 1)
    {
      this.oxc.setVisibility(4);
      AppMethodBeat.o(82345);
      return;
    }
    this.oxc.setVisibility(0);
    this.oxc.setDotCount(i);
    this.oxc.setSelectedDot(paramInt - j);
    AppMethodBeat.o(82345);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(82347);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ccn();
    AppMethodBeat.o(82347);
  }
  
  public void setOnTextOperationListener(a parama)
  {
    this.JBd = parama;
    this.JBa.JBh = this.JBd;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(82352);
    if (paramInt == 0) {}
    for (this.ouu = false;; this.ouu = true)
    {
      super.setVisibility(paramInt);
      if (this.ouu) {
        break label178;
      }
      this.pQZ.hideVKB();
      if ((this.mContentView == null) || (getChildCount() <= 0)) {
        break;
      }
      this.mContentView.setVisibility(0);
      AppMethodBeat.o(82352);
      return;
    }
    if (this.mContentView == null) {
      this.mContentView = View.inflate(MMApplicationContext.getContext(), 2131497078, null);
    }
    for (;;)
    {
      this.JBe = ((WebViewSmileyViewPager)this.mContentView.findViewById(2131307959));
      this.JBe.setOnPageChangeListener(this);
      this.JBe.setPanelManager(this.JBa);
      this.JBe.setOnSizeChangedListener(this);
      this.oxc = ((MMDotView)this.mContentView.findViewById(2131307956));
      this.oxc.setDotCount(1);
      ccn();
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
    public abstract void aHC();
    
    public abstract void append(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel
 * JD-Core Version:    0.7.0.1
 */
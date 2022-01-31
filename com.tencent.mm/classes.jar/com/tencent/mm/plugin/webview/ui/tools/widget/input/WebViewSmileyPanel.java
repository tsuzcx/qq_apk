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
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel
  extends LinearLayout
  implements ViewPager.OnPageChangeListener, WebViewSmileyViewPager.a
{
  View Qz;
  private boolean jnt;
  MMActivity jpX;
  private MMDotView jpZ;
  private boolean jqa;
  c vtC;
  private WebViewSmileyPanel.a vtF;
  private WebViewSmileyViewPager vtG;
  
  public WebViewSmileyPanel(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(10114);
    this.jnt = false;
    this.Qz = null;
    this.vtG = null;
    this.jqa = true;
    init();
    AppMethodBeat.o(10114);
  }
  
  public WebViewSmileyPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(10115);
    this.jnt = false;
    this.Qz = null;
    this.vtG = null;
    this.jqa = true;
    init();
    AppMethodBeat.o(10115);
  }
  
  private void aRN()
  {
    AppMethodBeat.i(10118);
    if (this.jpZ == null)
    {
      AppMethodBeat.o(10118);
      return;
    }
    boolean bool = j.gN(getContext());
    RelativeLayout.LayoutParams localLayoutParams;
    if (bool != this.jqa)
    {
      if (!bool) {
        break label109;
      }
      this.jpZ.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131427792));
      localLayoutParams = (RelativeLayout.LayoutParams)this.jpZ.getLayoutParams();
      localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131428385);
      this.jpZ.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.jqa = bool;
      AppMethodBeat.o(10118);
      return;
      label109:
      this.jpZ.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(2131427782));
      localLayoutParams = (RelativeLayout.LayoutParams)this.jpZ.getLayoutParams();
      localLayoutParams.bottomMargin = 0;
      this.jpZ.setLayoutParams(localLayoutParams);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(10116);
    this.jpX = ((MMActivity)getContext());
    this.vtC = new c();
    this.vtC.jpJ = getContext();
    this.vtC.vtJ = this.vtF;
    AppMethodBeat.o(10116);
  }
  
  public final void aRJ()
  {
    AppMethodBeat.i(10111);
    if (this.vtG == null)
    {
      AppMethodBeat.o(10111);
      return;
    }
    this.vtC.jqa = j.gN(getContext());
    WebViewSmileyViewPager.b localb = (WebViewSmileyViewPager.b)this.vtG.getAdapter();
    if (localb != null)
    {
      localb.jqk.clear();
      localb.vtC = this.vtC;
      localb.notifyDataSetChanged();
    }
    for (;;)
    {
      this.vtG.post(new WebViewSmileyPanel.1(this));
      AppMethodBeat.o(10111);
      return;
      localb = new WebViewSmileyViewPager.b();
      localb.vtC = this.vtC;
      this.vtG.setAdapter(localb);
    }
  }
  
  protected final c getManager()
  {
    return this.vtC;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10113);
    if (this.jnt)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
      AppMethodBeat.o(10113);
      return;
    }
    j.gN(getContext());
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(10113);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(10110);
    a locala = this.vtC.dhd();
    int i = locala.getPageCount();
    int j = locala.jpL;
    if (i <= 1)
    {
      this.jpZ.setVisibility(4);
      AppMethodBeat.o(10110);
      return;
    }
    this.jpZ.setVisibility(0);
    this.jpZ.setDotCount(i);
    this.jpZ.setSelectedDot(paramInt - j);
    AppMethodBeat.o(10110);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(10112);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    aRN();
    AppMethodBeat.o(10112);
  }
  
  public void setOnTextOperationListener(WebViewSmileyPanel.a parama)
  {
    this.vtF = parama;
    this.vtC.vtJ = this.vtF;
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(10117);
    if (paramInt == 0) {}
    for (this.jnt = false;; this.jnt = true)
    {
      super.setVisibility(paramInt);
      if (this.jnt) {
        break label179;
      }
      this.jpX.hideVKB();
      if ((this.Qz == null) || (getChildCount() <= 0)) {
        break;
      }
      this.Qz.setVisibility(0);
      AppMethodBeat.o(10117);
      return;
    }
    if (this.Qz == null) {
      this.Qz = View.inflate(ah.getContext(), 2130971308, null);
    }
    for (;;)
    {
      this.vtG = ((WebViewSmileyViewPager)this.Qz.findViewById(2131821544));
      this.vtG.setOnPageChangeListener(this);
      this.vtG.setPanelManager(this.vtC);
      this.vtG.setOnSizeChangedListener(this);
      this.jpZ = ((MMDotView)this.Qz.findViewById(2131821543));
      this.jpZ.setDotCount(1);
      aRN();
      addView(this.Qz, new LinearLayout.LayoutParams(-1, -1));
      label179:
      AppMethodBeat.o(10117);
      return;
      if (this.Qz.getParent() != null) {
        ((ViewGroup)this.Qz.getParent()).removeView(this.Qz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel
 * JD-Core Version:    0.7.0.1
 */
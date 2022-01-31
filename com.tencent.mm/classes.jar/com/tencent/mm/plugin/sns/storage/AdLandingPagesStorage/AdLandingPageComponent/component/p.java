package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.t;

public final class p
  extends h
{
  MMWebView foJ;
  FrameLayout rwD;
  
  public p(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaa, paramViewGroup);
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37193);
    this.rwD = ((FrameLayout)this.contentView);
    this.foJ = MMWebView.a.iI(this.context);
    this.rwD.addView(this.foJ);
    AppMethodBeat.o(37193);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37192);
    this.foJ.setVerticalScrollBarEnabled(false);
    this.foJ.setHorizontalScrollBarEnabled(false);
    this.foJ.getSettings().setJavaScriptEnabled(true);
    this.foJ.loadUrl(((aa)this.rve).nDe);
    this.foJ.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.foJ.setVisibility(0);
    this.rwD.setPadding(this.rwD.getPaddingLeft(), (int)((aa)this.rve).paddingTop, this.rwD.getPaddingRight(), (int)((aa)this.rve).paddingBottom);
    this.rwD.setLayoutParams(new LinearLayout.LayoutParams(this.iiW, this.iiX));
    AppMethodBeat.o(37192);
  }
  
  protected final View cqR()
  {
    AppMethodBeat.i(37194);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(37194);
    return localFrameLayout;
  }
  
  protected final int getLayout()
  {
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.aa;

public final class w
  extends m
{
  FrameLayout Kss;
  MMWebView lxa;
  
  public w(Context paramContext, am paramam, ViewGroup paramViewGroup)
  {
    super(paramContext, paramam, paramViewGroup);
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96613);
    this.lxa.setVerticalScrollBarEnabled(false);
    this.lxa.setHorizontalScrollBarEnabled(false);
    this.lxa.getSettings().setJavaScriptEnabled(true);
    this.lxa.loadUrl(((am)this.KqB).h5Url);
    this.lxa.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.lxa.setVisibility(0);
    this.Kss.setPadding(this.Kss.getPaddingLeft(), (int)((am)this.KqB).paddingTop, this.Kss.getPaddingRight(), (int)((am)this.KqB).paddingBottom);
    this.Kss.setLayoutParams(new LinearLayout.LayoutParams(this.pEj, this.pEk));
    AppMethodBeat.o(96613);
  }
  
  protected final View fKj()
  {
    AppMethodBeat.i(96615);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(96615);
    return localFrameLayout;
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96614);
    this.Kss = ((FrameLayout)this.contentView);
    this.lxa = MMWebView.a.lH(this.context);
    this.Kss.addView(this.lxa);
    AppMethodBeat.o(96614);
  }
  
  protected final int getLayout()
  {
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w
 * JD-Core Version:    0.7.0.1
 */
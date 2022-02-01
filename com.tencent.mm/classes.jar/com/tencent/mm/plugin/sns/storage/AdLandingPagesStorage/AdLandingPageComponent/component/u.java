package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.z;

public final class u
  extends k
{
  MMWebView hqK;
  FrameLayout yoC;
  
  public u(Context paramContext, ah paramah, ViewGroup paramViewGroup)
  {
    super(paramContext, paramah, paramViewGroup);
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96614);
    this.yoC = ((FrameLayout)this.contentView);
    this.hqK = MMWebView.a.kv(this.context);
    this.yoC.addView(this.hqK);
    AppMethodBeat.o(96614);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96613);
    this.hqK.setVerticalScrollBarEnabled(false);
    this.hqK.setHorizontalScrollBarEnabled(false);
    this.hqK.getSettings().setJavaScriptEnabled(true);
    this.hqK.loadUrl(((ah)this.ymQ).tuw);
    this.hqK.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.hqK.setVisibility(0);
    this.yoC.setPadding(this.yoC.getPaddingLeft(), (int)((ah)this.ymQ).paddingTop, this.yoC.getPaddingRight(), (int)((ah)this.ymQ).paddingBottom);
    this.yoC.setLayoutParams(new LinearLayout.LayoutParams(this.kWB, this.kWC));
    AppMethodBeat.o(96613);
  }
  
  protected final View dKp()
  {
    AppMethodBeat.i(96615);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(96615);
    return localFrameLayout;
  }
  
  protected final int getLayout()
  {
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u
 * JD-Core Version:    0.7.0.1
 */
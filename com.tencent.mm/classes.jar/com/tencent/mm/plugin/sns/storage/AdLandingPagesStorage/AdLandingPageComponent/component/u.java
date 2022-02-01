package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.y;

public final class u
  extends k
{
  MMWebView gQk;
  FrameLayout xbN;
  
  public u(Context paramContext, ag paramag, ViewGroup paramViewGroup)
  {
    super(paramContext, paramag, paramViewGroup);
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96613);
    this.gQk.setVerticalScrollBarEnabled(false);
    this.gQk.setHorizontalScrollBarEnabled(false);
    this.gQk.getSettings().setJavaScriptEnabled(true);
    this.gQk.loadUrl(((ag)this.xab).smD);
    this.gQk.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.gQk.setVisibility(0);
    this.xbN.setPadding(this.xbN.getPaddingLeft(), (int)((ag)this.xab).paddingTop, this.xbN.getPaddingRight(), (int)((ag)this.xab).paddingBottom);
    this.xbN.setLayoutParams(new LinearLayout.LayoutParams(this.kvn, this.kvo));
    AppMethodBeat.o(96613);
  }
  
  protected final View dvQ()
  {
    AppMethodBeat.i(96615);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(96615);
    return localFrameLayout;
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96614);
    this.xbN = ((FrameLayout)this.contentView);
    this.gQk = MMWebView.a.kk(this.context);
    this.xbN.addView(this.gQk);
    AppMethodBeat.o(96614);
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
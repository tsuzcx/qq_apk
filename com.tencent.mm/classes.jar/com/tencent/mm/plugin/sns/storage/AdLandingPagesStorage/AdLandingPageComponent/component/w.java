package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.z;

public final class w
  extends m
{
  MMWebView hLV;
  FrameLayout zWD;
  
  public w(Context paramContext, aj paramaj, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaj, paramViewGroup);
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96614);
    this.zWD = ((FrameLayout)this.contentView);
    this.hLV = MMWebView.a.kO(this.context);
    this.zWD.addView(this.hLV);
    AppMethodBeat.o(96614);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96613);
    this.hLV.setVerticalScrollBarEnabled(false);
    this.hLV.setHorizontalScrollBarEnabled(false);
    this.hLV.getSettings().setJavaScriptEnabled(true);
    this.hLV.loadUrl(((aj)this.zUP).uEo);
    this.hLV.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.hLV.setVisibility(0);
    this.zWD.setPadding(this.zWD.getPaddingLeft(), (int)((aj)this.zUP).paddingTop, this.zWD.getPaddingRight(), (int)((aj)this.zUP).paddingBottom);
    this.zWD.setLayoutParams(new LinearLayout.LayoutParams(this.lxZ, this.lya));
    AppMethodBeat.o(96613);
  }
  
  protected final View eae()
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w
 * JD-Core Version:    0.7.0.1
 */
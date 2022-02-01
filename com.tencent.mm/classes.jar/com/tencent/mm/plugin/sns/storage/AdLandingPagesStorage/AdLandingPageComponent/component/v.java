package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.z;

public final class v
  extends l
{
  MMWebView hJc;
  FrameLayout zFx;
  
  public v(Context paramContext, ai paramai, ViewGroup paramViewGroup)
  {
    super(paramContext, paramai, paramViewGroup);
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(96614);
    this.zFx = ((FrameLayout)this.contentView);
    this.hJc = MMWebView.a.kH(this.context);
    this.zFx.addView(this.hJc);
    AppMethodBeat.o(96614);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96613);
    this.hJc.setVerticalScrollBarEnabled(false);
    this.hJc.setHorizontalScrollBarEnabled(false);
    this.hJc.getSettings().setJavaScriptEnabled(true);
    this.hJc.loadUrl(((ai)this.zDK).usV);
    this.hJc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.hJc.setVisibility(0);
    this.zFx.setPadding(this.zFx.getPaddingLeft(), (int)((ai)this.zDK).paddingTop, this.zFx.getPaddingRight(), (int)((ai)this.zDK).paddingBottom);
    this.zFx.setLayoutParams(new LinearLayout.LayoutParams(this.ltA, this.ltB));
    AppMethodBeat.o(96613);
  }
  
  protected final View dWC()
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v
 * JD-Core Version:    0.7.0.1
 */
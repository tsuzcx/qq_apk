package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.ad;

public final class y
  extends n
{
  FrameLayout QQO;
  MMWebView ooz;
  
  public y(Context paramContext, an paraman, ViewGroup paramViewGroup)
  {
    super(paramContext, paraman, paramViewGroup);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96614);
    this.QQO = ((FrameLayout)this.contentView);
    this.ooz = MMWebView.a.nL(this.context);
    this.QQO.addView(this.ooz);
    AppMethodBeat.o(96614);
  }
  
  protected final int getLayout()
  {
    return 2147483647;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96613);
    this.ooz.setVerticalScrollBarEnabled(false);
    this.ooz.setHorizontalScrollBarEnabled(false);
    this.ooz.getSettings().setJavaScriptEnabled(true);
    this.ooz.loadUrl(((an)this.QOV).h5Url);
    this.ooz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.ooz.setVisibility(0);
    this.QQO.setPadding(this.QQO.getPaddingLeft(), (int)((an)this.QOV).paddingTop, this.QQO.getPaddingRight(), (int)((an)this.QOV).paddingBottom);
    this.QQO.setLayoutParams(new LinearLayout.LayoutParams(this.sJv, this.pvg));
    AppMethodBeat.o(96613);
  }
  
  protected final View ham()
  {
    AppMethodBeat.i(96615);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(96615);
    return localFrameLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y
 * JD-Core Version:    0.7.0.1
 */
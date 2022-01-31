package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.n;

public final class p
  extends i
{
  MMWebView dYF;
  FrameLayout oGO;
  
  public p(Context paramContext, v paramv, ViewGroup paramViewGroup)
  {
    super(paramContext, paramv, paramViewGroup);
  }
  
  public final View bFf()
  {
    this.oGO = ((FrameLayout)this.contentView);
    this.dYF = MMWebView.a.cO(this.context);
    this.oGO.addView(this.dYF);
    return this.oGO;
  }
  
  protected final void bFj()
  {
    WindowManager localWindowManager = (WindowManager)this.context.getSystemService("window");
    int i = localWindowManager.getDefaultDisplay().getWidth();
    int j = localWindowManager.getDefaultDisplay().getHeight();
    this.dYF.setVerticalScrollBarEnabled(false);
    this.dYF.setHorizontalScrollBarEnabled(false);
    this.dYF.getSettings().setJavaScriptEnabled(true);
    this.dYF.loadUrl(((v)this.oFE).lfj);
    this.dYF.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.dYF.setVisibility(0);
    this.oGO.setPadding(this.oGO.getPaddingLeft(), (int)((v)this.oFE).oDi, this.oGO.getPaddingRight(), (int)((v)this.oFE).oDj);
    this.oGO.setLayoutParams(new LinearLayout.LayoutParams(i, j));
  }
  
  protected final View bFk()
  {
    return new FrameLayout(this.context);
  }
  
  protected final int getLayout()
  {
    return 2147483647;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mm.R.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class q
  implements g
{
  private final MMWebView dYF;
  private final MMActivity hxN;
  
  public q(MMActivity paramMMActivity, MMWebView paramMMWebView)
  {
    this.hxN = paramMMActivity;
    this.dYF = paramMMWebView;
  }
  
  public final void a(g.a parama)
  {
    if (this.hxN.getSwipeBackLayout() == null) {
      return;
    }
    this.hxN.getSwipeBackLayout().setSwipeBackListener(new q.1(this, parama));
  }
  
  public final void a(g.b paramb)
  {
    b.a(this.hxN, new q.2(this, paramb));
  }
  
  public final ViewGroup cbn()
  {
    return (ViewGroup)this.hxN.getWindow().getDecorView();
  }
  
  public final boolean cbo()
  {
    return this.hxN.getSwipeBackLayout() != null;
  }
  
  public final Activity getActivity()
  {
    return this.hxN;
  }
  
  public final View getContentView()
  {
    if (this.hxN.getSwipeBackLayout() == null) {
      return null;
    }
    return this.hxN.getSwipeBackLayout().getTargetContentView();
  }
  
  public final Intent getIntent()
  {
    return this.hxN.getIntent();
  }
  
  public final String getUrl()
  {
    return this.dYF.getUrl();
  }
  
  public final void jW(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.hxN.getIntent().putExtra("MMActivity.OverrideExitAnimation", R.a.pop_out);
      this.hxN.getIntent().putExtra("MMActivity.OverrideEnterAnimation", R.a.anim_not_change);
    }
    for (;;)
    {
      this.hxN.finish();
      return;
      this.hxN.getIntent().putExtra("MMActivity.OverrideExitAnimation", 0);
      this.hxN.getIntent().putExtra("MMActivity.OverrideEnterAnimation", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.q
 * JD-Core Version:    0.7.0.1
 */
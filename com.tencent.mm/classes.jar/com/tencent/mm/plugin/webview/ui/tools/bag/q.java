package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class q
  implements g
{
  private final MMWebView foJ;
  private final MMActivity jpX;
  
  public q(MMActivity paramMMActivity, MMWebView paramMMWebView)
  {
    this.jpX = paramMMActivity;
    this.foJ = paramMMWebView;
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(8285);
    if (this.jpX.getSwipeBackLayout() == null)
    {
      AppMethodBeat.o(8285);
      return;
    }
    this.jpX.getSwipeBackLayout().setSwipeBackListener(new q.1(this, parama));
    AppMethodBeat.o(8285);
  }
  
  public final void a(g.b paramb)
  {
    AppMethodBeat.i(8287);
    b.a(this.jpX, new q.2(this, paramb));
    AppMethodBeat.o(8287);
  }
  
  public final ViewGroup bTL()
  {
    AppMethodBeat.i(8282);
    ViewGroup localViewGroup = (ViewGroup)this.jpX.getWindow().getDecorView();
    AppMethodBeat.o(8282);
    return localViewGroup;
  }
  
  public final boolean dbs()
  {
    AppMethodBeat.i(8284);
    if (this.jpX.getSwipeBackLayout() != null)
    {
      AppMethodBeat.o(8284);
      return true;
    }
    AppMethodBeat.o(8284);
    return false;
  }
  
  public final Activity getActivity()
  {
    return this.jpX;
  }
  
  public final View getContentView()
  {
    AppMethodBeat.i(8283);
    if (this.jpX.getSwipeBackLayout() == null)
    {
      AppMethodBeat.o(8283);
      return null;
    }
    View localView = this.jpX.getSwipeBackLayout().getTargetContentView();
    AppMethodBeat.o(8283);
    return localView;
  }
  
  public final Intent getIntent()
  {
    AppMethodBeat.i(8280);
    Intent localIntent = this.jpX.getIntent();
    AppMethodBeat.o(8280);
    return localIntent;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(8281);
    String str = this.foJ.getUrl();
    AppMethodBeat.o(8281);
    return str;
  }
  
  public final void mU(boolean paramBoolean)
  {
    AppMethodBeat.i(8286);
    if (paramBoolean)
    {
      this.jpX.getIntent().putExtra("MMActivity.OverrideExitAnimation", 2131034222);
      this.jpX.getIntent().putExtra("MMActivity.OverrideEnterAnimation", 2131034130);
    }
    for (;;)
    {
      this.jpX.finish();
      AppMethodBeat.o(8286);
      return;
      this.jpX.getIntent().putExtra("MMActivity.OverrideExitAnimation", 0);
      this.jpX.getIntent().putExtra("MMActivity.OverrideEnterAnimation", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.q
 * JD-Core Version:    0.7.0.1
 */
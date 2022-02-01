package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lastRowBottomMaxPadding", "", "lastRowBottomPadding", "topPadding", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-webview_release"})
final class BrowserChooseDialogView$b
  extends RecyclerView.h
{
  private final int Jmd;
  private final int Jme;
  private final int Jmf;
  
  public BrowserChooseDialogView$b(Context paramContext)
  {
    AppMethodBeat.i(210455);
    this.Jmd = paramContext.getResources().getDimensionPixelSize(2131165299);
    this.Jme = paramContext.getResources().getDimensionPixelSize(2131165299);
    this.Jmf = paramContext.getResources().getDimensionPixelSize(2131165312);
    AppMethodBeat.o(210455);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(210454);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    paramRect.top = this.Jmd;
    int j = RecyclerView.bw(paramView);
    paramView = paramRecyclerView.getAdapter();
    int i;
    if (paramView != null) {
      i = paramView.getItemCount();
    }
    while (j / 4 == (i - 1) / 4) {
      if (i <= 4)
      {
        paramRect.bottom = this.Jmf;
        AppMethodBeat.o(210454);
        return;
        i = 0;
      }
      else
      {
        paramRect.bottom = this.Jme;
      }
    }
    AppMethodBeat.o(210454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserChooseDialogView.b
 * JD-Core Version:    0.7.0.1
 */
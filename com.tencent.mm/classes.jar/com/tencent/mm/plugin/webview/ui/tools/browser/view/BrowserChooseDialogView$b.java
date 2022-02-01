package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lastRowBottomMaxPadding", "", "lastRowBottomPadding", "topPadding", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
final class BrowserChooseDialogView$b
  extends RecyclerView.h
{
  private final int Ipu;
  private final int Xbq;
  private final int Xbr;
  
  public BrowserChooseDialogView$b(Context paramContext)
  {
    AppMethodBeat.i(296565);
    this.Ipu = paramContext.getResources().getDimensionPixelSize(c.d.Edge_3A);
    this.Xbq = paramContext.getResources().getDimensionPixelSize(c.d.Edge_3A);
    this.Xbr = paramContext.getResources().getDimensionPixelSize(c.d.Edge_8A);
    AppMethodBeat.o(296565);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(296574);
    s.u(paramRect, "outRect");
    s.u(paramView, "view");
    s.u(paramRecyclerView, "parent");
    s.u(params, "state");
    paramRect.top = this.Ipu;
    int j = RecyclerView.bA(paramView);
    paramView = paramRecyclerView.getAdapter();
    int i;
    if (paramView == null) {
      i = 0;
    }
    while (j / 4 == (i - 1) / 4) {
      if (i <= 4)
      {
        paramRect.bottom = this.Xbr;
        AppMethodBeat.o(296574);
        return;
        i = paramView.getItemCount();
      }
      else
      {
        paramRect.bottom = this.Xbq;
      }
    }
    AppMethodBeat.o(296574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserChooseDialogView.b
 * JD-Core Version:    0.7.0.1
 */
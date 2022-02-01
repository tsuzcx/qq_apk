package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView$BrowserItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "browserIcon", "Landroid/widget/ImageView;", "getBrowserIcon", "()Landroid/widget/ImageView;", "browserTitle", "Landroid/widget/TextView;", "getBrowserTitle", "()Landroid/widget/TextView;", "plugin-webview_release"})
final class BrowserChooseDialogView$c
  extends RecyclerView.v
{
  final ImageView Jmg;
  final TextView Jmh;
  
  public BrowserChooseDialogView$c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(210456);
    View localView = paramView.findViewById(2131297793);
    p.g(localView, "itemView.findViewById(R.id.browser_icon)");
    this.Jmg = ((ImageView)localView);
    paramView = paramView.findViewById(2131297798);
    p.g(paramView, "itemView.findViewById(R.id.browser_title)");
    this.Jmh = ((TextView)paramView);
    AppMethodBeat.o(210456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserChooseDialogView.c
 * JD-Core Version:    0.7.0.1
 */
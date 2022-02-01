package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView$BrowserItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "browserIcon", "Landroid/widget/ImageView;", "getBrowserIcon", "()Landroid/widget/ImageView;", "browserNotSetting", "Landroid/widget/TextView;", "getBrowserNotSetting", "()Landroid/widget/TextView;", "browserSelectedIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getBrowserSelectedIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "browserTitle", "getBrowserTitle", "container", "Landroid/widget/RelativeLayout;", "getContainer", "()Landroid/widget/RelativeLayout;", "plugin-webview_release"})
final class BrowserSettingDialogView$c
  extends RecyclerView.v
{
  final RelativeLayout GJH;
  final ImageView Jmg;
  final TextView Jmh;
  final WeImageView Jmw;
  final TextView Jmx;
  
  public BrowserSettingDialogView$c(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(210478);
    View localView = paramView.findViewById(2131297794);
    p.g(localView, "itemView.findViewById(R.id.browser_item_container)");
    this.GJH = ((RelativeLayout)localView);
    localView = paramView.findViewById(2131297793);
    p.g(localView, "itemView.findViewById(R.id.browser_icon)");
    this.Jmg = ((ImageView)localView);
    localView = paramView.findViewById(2131297798);
    p.g(localView, "itemView.findViewById(R.id.browser_title)");
    this.Jmh = ((TextView)localView);
    localView = paramView.findViewById(2131297797);
    p.g(localView, "itemView.findViewById(R.id.browser_selected_icon)");
    this.Jmw = ((WeImageView)localView);
    paramView = paramView.findViewById(2131297796);
    p.g(paramView, "itemView.findViewById(R.id.browser_not_setting)");
    this.Jmx = ((TextView)paramView);
    AppMethodBeat.o(210478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.BrowserSettingDialogView.c
 * JD-Core Version:    0.7.0.1
 */
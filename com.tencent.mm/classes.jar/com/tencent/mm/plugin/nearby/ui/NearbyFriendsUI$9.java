package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class NearbyFriendsUI$9
  implements View.OnClickListener
{
  NearbyFriendsUI$9(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(89847);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    NearbyFriendsUI.i(this.Gtl).removeHeaderView(NearbyFriendsUI.m(this.Gtl));
    NearbyFriendsUI.n(this.Gtl);
    paramView = new Intent(this.Gtl, NearbySayHiListUI.class);
    paramView.putExtra("k_say_hi_type", 2);
    paramView.putExtra("show_clear_header", true);
    this.Gtl.startActivityForResult(paramView, 2009);
    a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(89847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.9
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

final class NearbyFriendsUI$9
  implements View.OnClickListener
{
  NearbyFriendsUI$9(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onClick(View paramView)
  {
    NearbyFriendsUI.k(this.mDs).removeHeaderView(NearbyFriendsUI.m(this.mDs));
    NearbyFriendsUI.n(this.mDs);
    paramView = new Intent(this.mDs, NearbySayHiListUI.class);
    paramView.putExtra("k_say_hi_type", 2);
    paramView.putExtra("show_clear_header", true);
    this.mDs.startActivityForResult(paramView, 2009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.9
 * JD-Core Version:    0.7.0.1
 */
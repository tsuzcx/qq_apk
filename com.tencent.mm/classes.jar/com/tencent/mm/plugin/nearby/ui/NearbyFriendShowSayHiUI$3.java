package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class NearbyFriendShowSayHiUI$3
  implements View.OnClickListener
{
  NearbyFriendShowSayHiUI$3(NearbyFriendShowSayHiUI paramNearbyFriendShowSayHiUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.mCY, NearbySayHiListUI.class);
    paramView.putExtra("k_say_hi_type", 2);
    paramView.putExtra("show_clear_header", true);
    this.mCY.startActivityForResult(paramView, 2009);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI.3
 * JD-Core Version:    0.7.0.1
 */
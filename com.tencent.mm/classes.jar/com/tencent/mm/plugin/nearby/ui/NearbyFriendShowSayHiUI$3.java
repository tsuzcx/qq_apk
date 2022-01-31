package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NearbyFriendShowSayHiUI$3
  implements View.OnClickListener
{
  NearbyFriendShowSayHiUI$3(NearbyFriendShowSayHiUI paramNearbyFriendShowSayHiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55428);
    paramView = new Intent(this.pcS, NearbySayHiListUI.class);
    paramView.putExtra("k_say_hi_type", 2);
    paramView.putExtra("show_clear_header", true);
    this.pcS.startActivityForResult(paramView, 2009);
    AppMethodBeat.o(55428);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI.3
 * JD-Core Version:    0.7.0.1
 */
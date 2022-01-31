package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NearbyFriendsUI$9
  implements View.OnClickListener
{
  NearbyFriendsUI$9(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55450);
    NearbyFriendsUI.j(this.pdm).removeHeaderView(NearbyFriendsUI.n(this.pdm));
    NearbyFriendsUI.o(this.pdm);
    paramView = new Intent(this.pdm, NearbySayHiListUI.class);
    paramView.putExtra("k_say_hi_type", 2);
    paramView.putExtra("show_clear_header", true);
    this.pdm.startActivityForResult(paramView, 2009);
    AppMethodBeat.o(55450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.9
 * JD-Core Version:    0.7.0.1
 */
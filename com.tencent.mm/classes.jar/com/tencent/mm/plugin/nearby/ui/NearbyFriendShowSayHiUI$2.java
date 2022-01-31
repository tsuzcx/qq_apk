package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class NearbyFriendShowSayHiUI$2
  implements View.OnClickListener
{
  NearbyFriendShowSayHiUI$2(NearbyFriendShowSayHiUI paramNearbyFriendShowSayHiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55427);
    this.pcS.startActivity(new Intent(this.pcS, NearbyFriendsUI.class));
    AppMethodBeat.o(55427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendShowSayHiUI.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azr;
import java.util.Map;

final class NearbyFriendsUI$c$3
  implements View.OnClickListener
{
  NearbyFriendsUI$c$3(NearbyFriendsUI.c paramc, azr paramazr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(145833);
    paramView = (NearbyFriendsUI.a)NearbyFriendsUI.t(this.pdx.pdm).get(this.pdy.jJA);
    if (paramView != null)
    {
      paramView.pdv += 1;
      paramView.iqO = true;
      paramView.pdw |= 0x2;
    }
    NearbyFriendsUI.A(this.pdx.pdm);
    this.pdx.notifyDataSetChanged();
    AppMethodBeat.o(145833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.c.3
 * JD-Core Version:    0.7.0.1
 */
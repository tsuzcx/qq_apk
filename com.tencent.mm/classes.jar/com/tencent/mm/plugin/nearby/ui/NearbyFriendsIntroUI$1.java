package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

final class NearbyFriendsIntroUI$1
  implements View.OnClickListener
{
  NearbyFriendsIntroUI$1(NearbyFriendsIntroUI paramNearbyFriendsIntroUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55435);
    if (NearbyFriendsIntroUI.a(this.pcT) == null)
    {
      NearbyFriendsIntroUI.a(this.pcT, h.a(this.pcT.getContext(), this.pcT.getString(2131297087), NearbyFriendsIntroUI.b(this.pcT), new NearbyFriendsIntroUI.1.1(this), null));
      AppMethodBeat.o(55435);
      return;
    }
    NearbyFriendsIntroUI.a(this.pcT).show();
    AppMethodBeat.o(55435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI.1
 * JD-Core Version:    0.7.0.1
 */
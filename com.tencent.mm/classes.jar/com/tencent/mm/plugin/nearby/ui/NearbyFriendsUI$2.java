package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class NearbyFriendsUI$2
  implements View.OnClickListener
{
  NearbyFriendsUI$2(NearbyFriendsUI paramNearbyFriendsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(89840);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    NearbyFriendsUI.x(this.Mpl);
    a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbyFriendsUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(89840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class NormalUserFooterPreference$b$1
  implements View.OnClickListener
{
  NormalUserFooterPreference$b$1(NormalUserFooterPreference.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27314);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.Hby.fqF();
    a.a(this, "com/tencent/mm/plugin/profile/ui/NormalUserFooterPreference$NearByFriendHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(27314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.b.1
 * JD-Core Version:    0.7.0.1
 */
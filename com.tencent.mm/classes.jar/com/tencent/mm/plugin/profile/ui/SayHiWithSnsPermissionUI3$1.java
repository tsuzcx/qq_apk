package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SayHiWithSnsPermissionUI3$1
  implements View.OnClickListener
{
  SayHiWithSnsPermissionUI3$1(SayHiWithSnsPermissionUI3 paramSayHiWithSnsPermissionUI3) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(305566);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.Nbs.hideVKB();
    a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3.1
 * JD-Core Version:    0.7.0.1
 */
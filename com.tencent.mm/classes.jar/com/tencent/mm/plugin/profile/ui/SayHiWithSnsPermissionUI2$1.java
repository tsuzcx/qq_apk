package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SayHiWithSnsPermissionUI2$1
  implements View.OnClickListener
{
  SayHiWithSnsPermissionUI2$1(SayHiWithSnsPermissionUI2 paramSayHiWithSnsPermissionUI2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179673);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.BiF.hideVKB();
    a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(179673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2.1
 * JD-Core Version:    0.7.0.1
 */
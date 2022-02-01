package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;

final class SayHiWithSnsPermissionUI2$10
  implements View.OnClickListener
{
  SayHiWithSnsPermissionUI2$10(SayHiWithSnsPermissionUI2 paramSayHiWithSnsPermissionUI2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179686);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (SayHiWithSnsPermissionUI2.o(this.BiF).getVisibility() != 0)
    {
      SayHiWithSnsPermissionUI2.g(this.BiF).setVisibility(4);
      SayHiWithSnsPermissionUI2.o(this.BiF).setVisibility(0);
      this.BiF.findViewById(2131305488).setVisibility(8);
    }
    a.a(this, "com/tencent/mm/plugin/profile/ui/SayHiWithSnsPermissionUI2$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(179686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2.10
 * JD-Core Version:    0.7.0.1
 */
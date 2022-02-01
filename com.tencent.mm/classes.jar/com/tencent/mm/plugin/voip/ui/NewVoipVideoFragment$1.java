package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$1
  implements View.OnClickListener
{
  NewVoipVideoFragment$1(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(292405);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    h.OAn.b(11619, new Object[] { Integer.valueOf(2) });
    if ((this.UIV.UJb != null) && (this.UIV.UJb.get() != null)) {
      ((c)this.UIV.UJb.get()).hWi();
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292405);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.1
 * JD-Core Version:    0.7.0.1
 */
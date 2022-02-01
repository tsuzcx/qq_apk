package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class NewVoipVideoFragment$19
  implements View.OnClickListener
{
  NewVoipVideoFragment$19(NewVoipVideoFragment paramNewVoipVideoFragment) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(236879);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (System.currentTimeMillis() - NewVoipVideoFragment.h(this.NUZ) <= 1000L)
    {
      a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(236879);
      return;
    }
    NewVoipVideoFragment.a(this.NUZ, System.currentTimeMillis());
    h.IzE.a(11618, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
    if (this.NUZ.NVx != null) {
      this.NUZ.NVx.aU(false, true);
    }
    if ((this.NUZ.NVe != null) && (this.NUZ.NVe.get() != null)) {
      ((c)this.NUZ.NVe.get()).AP(true);
    }
    a.a(this, "com/tencent/mm/plugin/voip/ui/NewVoipVideoFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.NewVoipVideoFragment.19
 * JD-Core Version:    0.7.0.1
 */
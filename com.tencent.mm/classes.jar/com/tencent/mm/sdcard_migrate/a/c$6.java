package com.tencent.mm.sdcard_migrate.a;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class c$6
  implements View.OnClickListener
{
  c$6(c paramc, a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(257225);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.acrR.acqW != null) {
      this.acrR.acqW.onClick(this.acrK, -1);
    }
    this.acrK.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(257225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c.6
 * JD-Core Version:    0.7.0.1
 */
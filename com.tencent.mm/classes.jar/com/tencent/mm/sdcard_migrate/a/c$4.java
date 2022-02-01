package com.tencent.mm.sdcard_migrate.a;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class c$4
  implements View.OnClickListener
{
  c$4(c paramc, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(257206);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.acrN != null) {
      this.acrN.onClick(this.acrK, -1);
    }
    if (this.acrO) {
      this.acrK.dismiss();
    }
    a.a(this, "com/tencent/mm/sdcard_migrate/ui/NoSVGMMAlertDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(257206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.a.c.4
 * JD-Core Version:    0.7.0.1
 */
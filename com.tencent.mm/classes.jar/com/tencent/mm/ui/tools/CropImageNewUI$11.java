package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class CropImageNewUI$11
  implements View.OnClickListener
{
  CropImageNewUI$11(CropImageNewUI paramCropImageNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39016);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/tools/CropImageNewUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    CropImageNewUI.r(this.LaH);
    a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(39016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.11
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class CropImageNewUI$18
  implements View.OnClickListener
{
  CropImageNewUI$18(CropImageNewUI paramCropImageNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39022);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/tools/CropImageNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    CropImageNewUI.a(this.XNW, true);
    a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(39022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.18
 * JD-Core Version:    0.7.0.1
 */
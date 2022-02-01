package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class d$2
  implements View.OnClickListener
{
  d$2(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(159553);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/widget/picker/MMTimePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    d.a(this.Lxy, false, null);
    a.a(this, "com/tencent/mm/ui/widget/picker/MMTimePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(159553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webwx.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ExtDeviceWXLoginUI$2
  implements View.OnClickListener
{
  ExtDeviceWXLoginUI$2(ExtDeviceWXLoginUI paramExtDeviceWXLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30196);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = ExtDeviceWXLoginUI.a(this.Xxl);
    if (!ExtDeviceWXLoginUI.a(this.Xxl).isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(30196);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.2
 * JD-Core Version:    0.7.0.1
 */
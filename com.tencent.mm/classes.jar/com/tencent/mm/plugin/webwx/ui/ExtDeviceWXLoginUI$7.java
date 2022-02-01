package com.tencent.mm.plugin.webwx.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class ExtDeviceWXLoginUI$7
  implements View.OnClickListener
{
  ExtDeviceWXLoginUI$7(ExtDeviceWXLoginUI paramExtDeviceWXLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(265338);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.ExtDeviceWXLoginUI", "spam url %s", new Object[] { ExtDeviceWXLoginUI.h(this.Xxl) });
    if ((ExtDeviceWXLoginUI.i(this.Xxl) == 0) && (!Util.isNullOrNil(ExtDeviceWXLoginUI.h(this.Xxl)))) {
      ExtDeviceWXLoginUI.ct(this.Xxl, ExtDeviceWXLoginUI.h(this.Xxl));
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/webwx/ui/ExtDeviceWXLoginUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265338);
      return;
      ExtDeviceWXLoginUI.j(this.Xxl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.c;

final class VcardContactUI$1
  implements h.c
{
  VcardContactUI$1(VcardContactUI paramVcardContactUI, String paramString) {}
  
  public final void lh(int paramInt)
  {
    AppMethodBeat.i(52002);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(52002);
      return;
      Object localObject = new Intent("android.intent.action.DIAL");
      ((Intent)localObject).setFlags(268435456);
      ((Intent)localObject).setData(Uri.parse("tel:" + this.oQI));
      VcardContactUI localVcardContactUI = this.yLh;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localVcardContactUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localVcardContactUI, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI.1
 * JD-Core Version:    0.7.0.1
 */
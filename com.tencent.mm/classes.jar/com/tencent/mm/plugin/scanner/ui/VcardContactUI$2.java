package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.ui.base.h.d;

final class VcardContactUI$2
  implements h.d
{
  VcardContactUI$2(VcardContactUI paramVcardContactUI, String paramString) {}
  
  public final void qy(int paramInt)
  {
    AppMethodBeat.i(52003);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(52003);
      return;
      Object localObject1 = new Intent();
      Object localObject2 = this.IUx + " " + this.IUx;
      ((Intent)localObject1).putExtra("composeType", 4);
      ((Intent)localObject1).putExtra("toList", new String[] { localObject2 });
      c.b(this.IUw, "qqmail", ".ui.ComposeUI", (Intent)localObject1);
      AppMethodBeat.o(52003);
      return;
      localObject2 = new Intent("android.intent.action.SEND");
      ((Intent)localObject2).setType("text/plain");
      ((Intent)localObject2).putExtra("android.intent.extra.EMAIL", new String[] { this.IUx });
      localObject1 = this.IUw;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/scanner/ui/VcardContactUI$2", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((VcardContactUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/scanner/ui/VcardContactUI$2", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI.2
 * JD-Core Version:    0.7.0.1
 */
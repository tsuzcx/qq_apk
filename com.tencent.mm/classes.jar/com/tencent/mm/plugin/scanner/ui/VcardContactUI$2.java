package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.base.h.c;

final class VcardContactUI$2
  implements h.c
{
  VcardContactUI$2(VcardContactUI paramVcardContactUI, String paramString) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localIntent = new Intent();
      String str = this.nOc + " " + this.nOc;
      localIntent.putExtra("composeType", 4);
      localIntent.putExtra("toList", new String[] { str });
      d.b(this.nOb, "qqmail", ".ui.ComposeUI", localIntent);
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { this.nOc });
    this.nOb.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI.2
 * JD-Core Version:    0.7.0.1
 */
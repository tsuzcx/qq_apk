package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.ui.base.h.c;

final class VcardContactUI$1
  implements h.c
{
  VcardContactUI$1(VcardContactUI paramVcardContactUI, String paramString) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setFlags(268435456);
    localIntent.setData(Uri.parse("tel:" + this.ixq));
    this.nOb.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI.1
 * JD-Core Version:    0.7.0.1
 */
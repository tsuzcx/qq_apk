package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.plugin.account.bind.ui.BindMobileUI;

final class h$6$2
  implements DialogInterface.OnClickListener
{
  h$6$2(h.6 param6, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29314);
    Intent localIntent = new Intent();
    localIntent.setClass(this.yXs.yXo.yXg, BindMobileUI.class);
    localIntent.putExtra("kstyle_bind_wording", new BindWordingContent(this.hEF, ""));
    MMWizardActivity.J(this.yXs.yXo.yXg, localIntent);
    paramDialogInterface.dismiss();
    AppMethodBeat.o(29314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.h.6.2
 * JD-Core Version:    0.7.0.1
 */
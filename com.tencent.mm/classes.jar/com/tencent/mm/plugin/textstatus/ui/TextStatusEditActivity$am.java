package com.tencent.mm.plugin.textstatus.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$12", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-textstatus_release"})
public final class TextStatusEditActivity$am
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(233381);
    this.MMz.gmN().setEnabled(TextStatusEditActivity.gns());
    if (this.MMz.gmN().isEnabled()) {
      TextStatusEditActivity.c(this.MMz).setVisibility(8);
    }
    for (;;)
    {
      String str1 = String.valueOf(paramEditable);
      String str2;
      if (g.a(str1, g.a.XSu) > 64)
      {
        str2 = g.hV(str1, 64);
        if (paramEditable == null) {}
      }
      try
      {
        paramEditable.replace(str2.length(), str1.length(), (CharSequence)"");
        this.MMz.dN(null);
        AppMethodBeat.o(233381);
        return;
        TextStatusEditActivity.c(this.MMz).setVisibility(0);
      }
      catch (Exception paramEditable)
      {
        for (;;)
        {
          Log.e("MicroMsg.TextStatus.TextStatusEditActivity", "etDesc replace: " + paramEditable.getMessage());
        }
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.am
 * JD-Core Version:    0.7.0.1
 */
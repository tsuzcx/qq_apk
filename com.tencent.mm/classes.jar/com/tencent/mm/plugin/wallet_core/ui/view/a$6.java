package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.b.e.c;

final class a$6
  implements e.c
{
  a$6(Context paramContext, a.a parama, TextView paramTextView1, EditText paramEditText, String paramString1, String paramString2, TextView paramTextView2) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(47859);
    if ((this.val$context instanceof MMActivity)) {
      if (this.uwe != null) {
        if (!bo.isNullOrNil(this.uwk.getText().toString().trim())) {
          break label119;
        }
      }
    }
    label119:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.uwe.a(paramBoolean, this.uwc.getText().toString().trim(), this.val$name, this.uwg, this.uwh.getText().toString().trim());
      if ((this.val$context instanceof MMActivity)) {
        al.d(new a.6.1(this));
      }
      AppMethodBeat.o(47859);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a.6
 * JD-Core Version:    0.7.0.1
 */
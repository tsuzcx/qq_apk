package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.e.a;

final class a$4
  implements View.OnClickListener
{
  a$4(a.a parama, EditText paramEditText, String paramString1, String paramString2, TextView paramTextView, Context paramContext, e.a parama1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47856);
    if (this.uwe != null) {
      this.uwe.a(false, this.uwc.getText().toString().trim(), this.val$name, this.uwg, this.uwh.getText().toString().trim());
    }
    a.a(this.val$context, this.uwf.gwf);
    AppMethodBeat.o(47856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a.4
 * JD-Core Version:    0.7.0.1
 */
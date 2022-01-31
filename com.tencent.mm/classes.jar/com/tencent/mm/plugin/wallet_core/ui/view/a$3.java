package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.e.a;

final class a$3
  implements View.OnClickListener
{
  a$3(a.a parama, EditText paramEditText, Context paramContext, e.a parama1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47855);
    if (this.uwe != null) {
      this.uwe.a(true, this.uwc.getText().toString().trim(), null, null, null);
    }
    a.a(this.val$context, this.uwf.gwf);
    AppMethodBeat.o(47855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.a.3
 * JD-Core Version:    0.7.0.1
 */
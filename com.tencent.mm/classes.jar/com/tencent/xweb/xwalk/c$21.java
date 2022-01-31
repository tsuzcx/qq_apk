package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.d.a;

final class c$21
  implements View.OnClickListener
{
  c$21(c paramc, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85142);
    c.a(this.BIO, this.BIU.getText().toString(), d.a.BDb);
    AppMethodBeat.o(85142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.21
 * JD-Core Version:    0.7.0.1
 */
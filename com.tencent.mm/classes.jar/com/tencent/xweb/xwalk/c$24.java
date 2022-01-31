package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.d.a;

final class c$24
  implements View.OnClickListener
{
  c$24(c paramc, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85145);
    c.a(this.BIO, this.BIU.getText().toString(), d.a.BDa);
    AppMethodBeat.o(85145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.24
 * JD-Core Version:    0.7.0.1
 */
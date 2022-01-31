package com.tencent.mm.ui.applet;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.d.b;

final class d$a$1
  implements d.b
{
  d$a$1(d.a parama) {}
  
  public final void dAv()
  {
    AppMethodBeat.i(29980);
    this.zhd.id(this.zhd.context);
    Toast.makeText(this.zhd.context, "trace file has saved ", 0).show();
    AppMethodBeat.o(29980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.applet.d.a.1
 * JD-Core Version:    0.7.0.1
 */
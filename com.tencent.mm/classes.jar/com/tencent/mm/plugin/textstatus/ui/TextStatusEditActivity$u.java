package com.tencent.mm.plugin.textstatus.ui;

import android.graphics.Paint;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class TextStatusEditActivity$u
  implements Runnable
{
  TextStatusEditActivity$u(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(258455);
    ao.a((Paint)this.GeQ.fwr().getPaint(), 0.8F);
    this.GeQ.fwr().setHint(2131766716);
    AppMethodBeat.o(258455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.u
 * JD-Core Version:    0.7.0.1
 */
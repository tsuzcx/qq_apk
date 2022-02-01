package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
public final class k$a$b
  implements Runnable
{
  public k$a$b(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(198571);
    Toast.makeText(this.$context, (CharSequence)this.$context.getString(a.h.save_image_err), 1).show();
    AppMethodBeat.o(198571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.k.a.b
 * JD-Core Version:    0.7.0.1
 */
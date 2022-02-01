package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
public final class k$a$d
  implements Runnable
{
  public k$a$d(Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(239809);
    Toast.makeText(this.$context, (CharSequence)this.$context.getString(2131764864), 1).show();
    AppMethodBeat.o(239809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.k.a.d
 * JD-Core Version:    0.7.0.1
 */
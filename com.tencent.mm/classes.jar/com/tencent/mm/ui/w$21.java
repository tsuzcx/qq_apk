package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.ac;

final class w$21
  implements Runnable
{
  w$21(w paramw, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(195997);
    if ((!w.cgj()) && (this.mvh))
    {
      ac.d(this.mvh, new Intent().putExtra("classname", this.Wad.bpE()).putExtra("main_process", false));
      AppMethodBeat.o(195997);
      return;
    }
    ac.d(this.mvh, new Intent().putExtra("classname", this.Wad.bpE() + this.Wad.getIdentString()));
    AppMethodBeat.o(195997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.w.21
 * JD-Core Version:    0.7.0.1
 */
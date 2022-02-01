package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.ag;

final class y$20
  implements Runnable
{
  y$20(y paramy, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(250062);
    if ((!y.jjX()) && (this.poG))
    {
      ag.d(this.poG, new Intent().putExtra("classname", this.adEy.Dy()).putExtra("main_process", false));
      AppMethodBeat.o(250062);
      return;
    }
    ag.d(this.poG, new Intent().putExtra("classname", this.adEy.Dy() + this.adEy.getIdentString()));
    AppMethodBeat.o(250062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.y.20
 * JD-Core Version:    0.7.0.1
 */
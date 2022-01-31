package com.tencent.mm.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMTabView$1
  implements Runnable
{
  MMTabView$1(MMTabView paramMMTabView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(106109);
    MMTabView.a(this.zcv).setText(this.zcu);
    this.zcv.dCA();
    AppMethodBeat.o(106109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MMTabView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.a;
import com.tencent.mm.plugin.topstory.ui.video.b;

final class e$8
  implements View.OnClickListener
{
  e$8(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1893);
    this.tkq.getFSVideoUIComponent().ah(paramView, e.a(this.tkq).cJb());
    AppMethodBeat.o(1893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.8
 * JD-Core Version:    0.7.0.1
 */
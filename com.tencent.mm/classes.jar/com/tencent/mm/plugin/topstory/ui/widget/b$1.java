package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, b.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(2227);
    if (b.a(this.tmx).isEmpty()) {
      b.a(this.tmx).add(b.b(this.tmx));
    }
    this.tmw.i(b.a(this.tmx));
    this.tmx.dismiss();
    AppMethodBeat.o(2227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.b.1
 * JD-Core Version:    0.7.0.1
 */
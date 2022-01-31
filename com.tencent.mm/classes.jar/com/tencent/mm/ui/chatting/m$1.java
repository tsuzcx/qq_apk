package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.n.a;

final class m$1
  implements n.a
{
  public final void a(ImageView paramImageView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(30597);
    a.b.u(paramImageView, paramMenuItem.getTitle());
    AppMethodBeat.o(30597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.1
 * JD-Core Version:    0.7.0.1
 */
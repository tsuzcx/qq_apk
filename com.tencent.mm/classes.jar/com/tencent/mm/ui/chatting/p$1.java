package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.u.b;

final class p$1
  implements u.b
{
  public final void onAttach(ImageView paramImageView1, ImageView paramImageView2, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(253627);
    a.b.C(paramImageView1, paramMenuItem.getTitle());
    AppMethodBeat.o(253627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.1
 * JD-Core Version:    0.7.0.1
 */
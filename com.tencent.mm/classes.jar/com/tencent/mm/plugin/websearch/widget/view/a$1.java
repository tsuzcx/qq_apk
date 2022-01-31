package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.ui.base.n.a;
import java.util.List;

public final class a$1
  implements n.a
{
  public a$1(a parama, List paramList) {}
  
  public final void a(ImageView paramImageView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(91473);
    paramMenuItem = (y)this.mwc.get(paramMenuItem.getItemId());
    com.tencent.mm.at.a.a.ahM().a(paramMenuItem.iconUrl, paramImageView, a.a(this.uML));
    AppMethodBeat.o(91473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a.1
 * JD-Core Version:    0.7.0.1
 */
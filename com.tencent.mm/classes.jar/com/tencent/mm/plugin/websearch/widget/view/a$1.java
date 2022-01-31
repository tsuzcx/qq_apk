package com.tencent.mm.plugin.websearch.widget.view;

import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.ui.base.n.a;
import java.util.List;

public final class a$1
  implements n.a
{
  public a$1(a parama, List paramList) {}
  
  public final void a(ImageView paramImageView, MenuItem paramMenuItem)
  {
    paramMenuItem = (y)this.kbG.get(paramMenuItem.getItemId());
    com.tencent.mm.as.a.a.OT().a(paramMenuItem.iconUrl, paramImageView, a.a(this.qXw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.a.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.ui.chatting.d.a;

final class d$e$9
  implements g
{
  d$e$9(d.e parame, d.c paramc, a parama) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(153933);
    if (paramb.bitmap != null)
    {
      paramString = paramb.bitmap;
      this.zSV.zSh.getViewTreeObserver().addOnPreDrawListener(new d.e.9.1(this, paramString));
    }
    AppMethodBeat.o(153933);
  }
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.e.9
 * JD-Core Version:    0.7.0.1
 */
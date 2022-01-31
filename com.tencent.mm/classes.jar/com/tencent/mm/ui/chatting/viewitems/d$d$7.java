package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.ui.chatting.d.a;

final class d$d$7
  implements g
{
  d$d$7(d.d paramd, d.c paramc, a parama) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(153922);
    if (paramb.bitmap != null)
    {
      paramString = paramb.bitmap;
      this.zSV.zSh.getViewTreeObserver().addOnPreDrawListener(new d.d.7.1(this, paramString));
    }
    AppMethodBeat.o(153922);
  }
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d.7
 * JD-Core Version:    0.7.0.1
 */
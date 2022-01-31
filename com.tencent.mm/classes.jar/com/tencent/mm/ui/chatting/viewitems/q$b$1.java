package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.u.o;

final class q$b$1
  implements b.h
{
  q$b$1(q.b paramb, q.d paramd) {}
  
  public final void JG() {}
  
  public final void JH() {}
  
  public final void p(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.vDr.vBW.setImageBitmap(paramBitmap);
      this.vDr.vBW.setVisibility(0);
      this.vDr.vBX.setVisibility(4);
      return;
    }
    this.vDr.vBW.setVisibility(4);
    this.vDr.vBX.setVisibility(0);
  }
  
  public final String pU()
  {
    return "CHAT#" + o.aX(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.b.1
 * JD-Core Version:    0.7.0.1
 */
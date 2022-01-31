package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.u.o;

final class d$d$2
  implements b.h
{
  d$d$2(d.d paramd, d.c paramc) {}
  
  public final void JG() {}
  
  public final void JH() {}
  
  public final void p(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.vCh.vBW.setImageBitmap(paramBitmap);
      this.vCh.vBW.setVisibility(0);
      this.vCh.vBX.setVisibility(4);
      return;
    }
    this.vCh.vBW.setVisibility(4);
    this.vCh.vBX.setVisibility(0);
  }
  
  public final String pU()
  {
    return "CHAT#" + o.aX(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d.2
 * JD-Core Version:    0.7.0.1
 */
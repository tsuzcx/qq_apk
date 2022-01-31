package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class d$d$1
  implements ViewTreeObserver.OnPreDrawListener
{
  private boolean zSU = false;
  
  d$d$1(d.d paramd, d.c paramc, com.tencent.mm.ui.chatting.d.a parama, Bitmap paramBitmap) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(32822);
    if (this.zSU)
    {
      this.zSV.zSh.getViewTreeObserver().removeOnPreDrawListener(this);
      AppMethodBeat.o(32822);
      return true;
    }
    this.zSV.zSh.getViewTreeObserver().removeOnPreDrawListener(this);
    this.zSU = true;
    int i = com.tencent.mm.cb.a.fromDPToPix(this.zRK.zJz.getContext(), 24);
    Bitmap localBitmap = this.val$bitmap;
    Object localObject;
    if (localBitmap != null)
    {
      localObject = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localObject = d.au(this.zRK.zJz.getContext().getResources().getColor(2131689870), i, i);
    }
    int j = ((Bitmap)localObject).getHeight();
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      localObject = d.g(d.al(Bitmap.createScaledBitmap((Bitmap)localObject, i, i, true)), 20);
      j = this.zSV.zSh.getHeight();
      int k = this.zSV.zSh.getWidth();
      i = j;
      if (j == 0) {
        i = com.tencent.mm.cb.a.ao(this.zRK.zJz.getContext(), 2131428225);
      }
      j = k;
      if (k == 0) {
        j = com.tencent.mm.cb.a.ao(this.zRK.zJz.getContext(), 2131428226);
      }
      localObject = new BitmapDrawable(d.a((Bitmap)localObject, 2130838217, j, i));
      this.zSV.zSh.setBackgroundDrawable((Drawable)localObject);
      AppMethodBeat.o(32822);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d.1
 * JD-Core Version:    0.7.0.1
 */
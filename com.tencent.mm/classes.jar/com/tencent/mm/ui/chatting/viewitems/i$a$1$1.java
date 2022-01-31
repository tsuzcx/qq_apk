package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.d;

final class i$a$1$1
  implements ViewTreeObserver.OnPreDrawListener
{
  i$a$1$1(i.a.1 param1, Bitmap paramBitmap) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(32913);
    this.zTJ.zTI.iDQ.getViewTreeObserver().removeOnPreDrawListener(this);
    int j = this.zTJ.zTI.iDQ.getHeight();
    int k = this.zTJ.zTI.iDQ.getWidth();
    int i = j;
    if (j == 0) {
      i = a.ao(this.zTJ.val$context, 2131428225);
    }
    j = k;
    if (k == 0) {
      j = a.ao(this.zTJ.val$context, 2131428226);
    }
    if (this.zTJ.zTI.zTG) {}
    for (Object localObject = d.a(this.kCo, 2130838217, j, i);; localObject = d.a(this.kCo, 2130838250, j, i))
    {
      localObject = new BitmapDrawable((Bitmap)localObject);
      this.zTJ.zTI.iDQ.setBackgroundDrawable((Drawable)localObject);
      AppMethodBeat.o(32913);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.a.1.1
 * JD-Core Version:    0.7.0.1
 */
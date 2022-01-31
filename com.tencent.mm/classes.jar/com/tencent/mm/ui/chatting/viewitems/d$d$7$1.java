package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class d$d$7$1
  implements ViewTreeObserver.OnPreDrawListener
{
  d$d$7$1(d.d.7 param7, Bitmap paramBitmap) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(153921);
    this.zSZ.zSV.zSh.getViewTreeObserver().removeOnPreDrawListener(this);
    int j = this.zSZ.zSV.zSh.getHeight();
    int k = this.zSZ.zSV.zSh.getWidth();
    int i = j;
    if (j == 0) {
      i = com.tencent.mm.cb.a.ao(this.zSZ.zRK.zJz.getContext(), 2131428225);
    }
    j = k;
    if (k == 0) {
      j = com.tencent.mm.cb.a.ao(this.zSZ.zRK.zJz.getContext(), 2131428226);
    }
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(d.a(this.kCo, 2130838217, j, i));
    this.zSZ.zSV.zSh.setBackgroundDrawable(localBitmapDrawable);
    AppMethodBeat.o(153921);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.d.7.1
 * JD-Core Version:    0.7.0.1
 */
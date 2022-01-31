package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;

final class d$e$9$1
  implements ViewTreeObserver.OnPreDrawListener
{
  d$e$9$1(d.e.9 param9, Bitmap paramBitmap) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(153932);
    this.zTd.zSV.zSh.getViewTreeObserver().removeOnPreDrawListener(this);
    int j = this.zTd.zSV.zSh.getHeight();
    int k = this.zTd.zSV.zSh.getWidth();
    int i = j;
    if (j == 0) {
      i = com.tencent.mm.cb.a.ao(this.zTd.zRK.zJz.getContext(), 2131428225);
    }
    j = k;
    if (k == 0) {
      j = com.tencent.mm.cb.a.ao(this.zTd.zRK.zJz.getContext(), 2131428226);
    }
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(d.a(this.kCo, 2130838250, j, i));
    this.zTd.zSV.zSh.setBackgroundDrawable(localBitmapDrawable);
    AppMethodBeat.o(153932);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.e.9.1
 * JD-Core Version:    0.7.0.1
 */
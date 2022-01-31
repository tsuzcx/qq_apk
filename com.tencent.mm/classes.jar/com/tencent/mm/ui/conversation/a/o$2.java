package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.sg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class o$2
  implements View.OnClickListener
{
  o$2(o paramo) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.TryNewInitBanner", "summerinit onClick trynewinit layout start try");
    this.vVy.setVisibility(8);
    a.udP.m(new sg());
    y.i("MicroMsg.TryNewInitBanner", "summerinit onClick tryNeeInitAgain done callBack (now by event to notice initbanner)");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o.2
 * JD-Core Version:    0.7.0.1
 */
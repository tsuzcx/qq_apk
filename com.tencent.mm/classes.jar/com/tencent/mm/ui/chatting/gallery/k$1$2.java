package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.bo;

final class k$1$2
  implements Runnable
{
  k$1$2(k.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(32379);
    if ((this.zNM.zNL.zNp == null) || (this.zNM.zNL.zNp.getVisibility() == 0))
    {
      AppMethodBeat.o(32379);
      return;
    }
    if ((this.zNM.zNL.zNp.getTag() != null) && ((this.zNM.zNL.zNp.getTag() instanceof s)))
    {
      s locals = (s)this.zNM.zNL.zNp.getTag();
      if ((locals.fXG != null) && (!bo.isNullOrNil(locals.fXG.fiO)))
      {
        this.zNM.zNL.zNp.setVisibility(8);
        AppMethodBeat.o(32379);
        return;
      }
      if ((locals.fXG != null) && (!bo.isNullOrNil(locals.fXG.fiR)) && (!bo.isNullOrNil(locals.fXG.fiS)))
      {
        this.zNM.zNL.zNp.setVisibility(8);
        AppMethodBeat.o(32379);
        return;
      }
    }
    this.zNM.zNL.zNp.setVisibility(0);
    this.zNM.zNL.zNp.startAnimation(AnimationUtils.loadAnimation(this.zNM.zNL.zNp.getContext(), 2131034181));
    AppMethodBeat.o(32379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.1.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.sdk.platformtools.bk;

final class k$1$2
  implements Runnable
{
  k$1$2(k.1 param1) {}
  
  public final void run()
  {
    if ((this.vxA.vxz.vxf == null) || (this.vxA.vxz.vxf.getVisibility() == 0)) {
      return;
    }
    if ((this.vxA.vxz.vxf.getTag() != null) && ((this.vxA.vxz.vxf.getTag() instanceof s)))
    {
      s locals = (s)this.vxA.vxz.vxf.getTag();
      if ((locals.eHQ != null) && (!bk.bl(locals.eHQ.dSP)))
      {
        this.vxA.vxz.vxf.setVisibility(8);
        return;
      }
      if ((locals.eHQ != null) && (!bk.bl(locals.eHQ.dSS)) && (!bk.bl(locals.eHQ.dST)))
      {
        this.vxA.vxz.vxf.setVisibility(8);
        return;
      }
    }
    this.vxA.vxz.vxf.setVisibility(0);
    this.vxA.vxz.vxf.startAnimation(AnimationUtils.loadAnimation(this.vxA.vxz.vxf.getContext(), R.a.fast_faded_in));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.1.2
 * JD-Core Version:    0.7.0.1
 */
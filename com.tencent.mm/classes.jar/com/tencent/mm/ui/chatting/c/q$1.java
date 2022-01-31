package com.tencent.mm.ui.chatting.c;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.d.a;

final class q$1
  implements ChatFooter.e
{
  private Animation zFY;
  private Animation zFZ;
  
  q$1(q paramq) {}
  
  public final boolean pu(boolean paramBoolean)
  {
    AppMethodBeat.i(31407);
    if (this.zFY == null)
    {
      this.zFY = AnimationUtils.loadAnimation(this.zGa.caz.zJz.getContext(), 2131034230);
      this.zFZ = AnimationUtils.loadAnimation(this.zGa.caz.zJz.getContext(), 2131034228);
    }
    if (paramBoolean)
    {
      ab.i("MicroMsg.ChattingUI.FootComponent", "switchFooterToInput customFooter is %s", new Object[] { this.zGa.zFL });
      if (this.zGa.zFL != null) {
        this.zGa.zFL.startAnimation(this.zFZ);
      }
      this.zGa.dIm();
      this.zGa.oBw.startAnimation(this.zFY);
      this.zGa.oBw.postInvalidateDelayed(this.zFY.getDuration());
    }
    for (;;)
    {
      AppMethodBeat.o(31407);
      return false;
      this.zGa.oBw.startAnimation(this.zFZ);
      this.zGa.dIl();
      if (this.zGa.zFL != null)
      {
        this.zGa.zFL.startAnimation(this.zFY);
        this.zGa.zFL.postInvalidateDelayed(this.zFY.getDuration());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.q.1
 * JD-Core Version:    0.7.0.1
 */
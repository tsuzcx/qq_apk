package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.a.c;
import com.tencent.mm.plugin.story.api.i.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bj;

public final class s$c
  implements i.a
{
  private a HNS;
  private Animation HNT;
  private Vibrator njY;
  
  public s$c(a parama)
  {
    AppMethodBeat.i(196429);
    this.njY = ((Vibrator)ai.getContext().getSystemService("vibrator"));
    this.HNS = parama;
    this.HNT = AnimationUtils.loadAnimation(parama.HZF.getContext(), 2130772172);
    AppMethodBeat.o(196429);
  }
  
  public final boolean fl(View paramView)
  {
    AppMethodBeat.i(34591);
    Object localObject = (bj)paramView.getTag();
    if (localObject == null)
    {
      ac.w("MicroMsg.AvatarDoubleClickListener", "onDoubleClick tag null");
      AppMethodBeat.o(34591);
      return false;
    }
    localObject = ((bj)localObject).userName;
    ac.i("MicroMsg.AvatarDoubleClickListener", "onDoubleClick: %s", new Object[] { localObject });
    if ((!bs.isNullOrNil((String)localObject)) && ((w.wp((String)localObject)) || (w.wn((String)localObject))) && (!w.xn((String)localObject)))
    {
      if (this.HNT != null)
      {
        this.HNT.cancel();
        paramView.startAnimation(this.HNT);
      }
      this.njY.vibrate(10L);
      if (((c)g.ab(c.class)).dci())
      {
        this.HNS.flA();
        ((c)g.ab(c.class)).hD(this.HNS.getTalkerUserName(), (String)localObject);
      }
    }
    AppMethodBeat.o(34591);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.c
 * JD-Core Version:    0.7.0.1
 */
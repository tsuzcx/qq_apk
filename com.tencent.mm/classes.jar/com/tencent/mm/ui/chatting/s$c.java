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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.viewitems.bi;

public final class s$c
  implements i.a
{
  private a Gob;
  private Animation Goc;
  private Vibrator mHT;
  
  public s$c(a parama)
  {
    AppMethodBeat.i(191483);
    this.mHT = ((Vibrator)aj.getContext().getSystemService("vibrator"));
    this.Gob = parama;
    this.Goc = AnimationUtils.loadAnimation(parama.GzJ.getContext(), 2130772172);
    AppMethodBeat.o(191483);
  }
  
  public final boolean eY(View paramView)
  {
    AppMethodBeat.i(34591);
    Object localObject = (bi)paramView.getTag();
    if (localObject == null)
    {
      ad.w("MicroMsg.AvatarDoubleClickListener", "onDoubleClick tag null");
      AppMethodBeat.o(34591);
      return false;
    }
    localObject = ((bi)localObject).userName;
    ad.i("MicroMsg.AvatarDoubleClickListener", "onDoubleClick: %s", new Object[] { localObject });
    if ((!bt.isNullOrNil((String)localObject)) && ((w.sm((String)localObject)) || (w.sk((String)localObject))) && (!w.tk((String)localObject)))
    {
      if (this.Goc != null)
      {
        this.Goc.cancel();
        paramView.startAnimation(this.Goc);
      }
      this.mHT.vibrate(10L);
      if (((c)g.ab(c.class)).cOz())
      {
        this.Gob.eVO();
        ((c)g.ab(c.class)).hk(this.Gob.getTalkerUserName(), (String)localObject);
      }
    }
    AppMethodBeat.o(34591);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.c
 * JD-Core Version:    0.7.0.1
 */
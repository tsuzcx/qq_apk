package com.tencent.mm.ui.chatting.viewitems;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.lang.ref.WeakReference;

final class d$c$3
  implements ao.b.a
{
  d$c$3(WeakReference paramWeakReference) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(32812);
    ImageView localImageView = (ImageView)this.vJy.get();
    if (localImageView == null)
    {
      AppMethodBeat.o(32812);
      return;
    }
    ad localad = ((j)g.E(j.class)).YA().arw(paramString);
    if ((localad != null) && ((int)localad.euF > 0) && ((localImageView.getTag() instanceof String)) && (bo.isEqual((String)localImageView.getTag(), paramString)))
    {
      h localh = o.adg().rj(paramString);
      if ((localh != null) && (!bo.isNullOrNil(localh.acY())))
      {
        com.tencent.mm.plugin.brandservice.b.a.a(localImageView, localad, localh.acY(), true);
        AppMethodBeat.o(32812);
        return;
      }
      a.b.s(localImageView, paramString);
    }
    AppMethodBeat.o(32812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.c.3
 * JD-Core Version:    0.7.0.1
 */
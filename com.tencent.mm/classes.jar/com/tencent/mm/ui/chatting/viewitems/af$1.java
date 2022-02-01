package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.lang.ref.WeakReference;

final class af$1
  implements as.b.a
{
  af$1(WeakReference paramWeakReference, TextView paramTextView, Context paramContext) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(37172);
    if (this.EJy == null)
    {
      AppMethodBeat.o(37172);
      return;
    }
    ImageView localImageView = (ImageView)this.EJy.get();
    if (localImageView == null)
    {
      AppMethodBeat.o(37172);
      return;
    }
    am localam = ((l)g.ab(l.class)).azp().Bf(paramString);
    Object localObject = (String)localImageView.getTag();
    if ((localam != null) && ((int)localam.gfj > 0) && ((localImageView.getTag() instanceof String)) && (w.zE(paramString)) && (bt.lQ((String)localObject, paramString)))
    {
      localObject = p.aEx().Dj(paramString);
      if ((localObject != null) && (!bt.isNullOrNil(((i)localObject).aEr()))) {
        d.a(localImageView, localam, ((i)localObject).aEr(), true);
      }
      for (;;)
      {
        paramString = v.zf(paramString);
        this.KdC.setText(k.b(this.val$context, paramString, this.KdC.getTextSize()));
        AppMethodBeat.o(37172);
        return;
        a.b.d(localImageView, paramString);
      }
    }
    this.KdC.setText(k.b(this.val$context, this.val$context.getResources().getString(2131756568), this.KdC.getTextSize()));
    AppMethodBeat.o(37172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.1
 * JD-Core Version:    0.7.0.1
 */
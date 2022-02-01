package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.lang.ref.WeakReference;

final class af$1
  implements au.b.a
{
  af$1(WeakReference paramWeakReference, TextView paramTextView, Context paramContext) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(37172);
    if (this.FbW == null)
    {
      AppMethodBeat.o(37172);
      return;
    }
    ImageView localImageView = (ImageView)this.FbW.get();
    if (localImageView == null)
    {
      AppMethodBeat.o(37172);
      return;
    }
    an localan = ((l)g.ab(l.class)).azF().BH(paramString);
    Object localObject = (String)localImageView.getTag();
    if ((localan != null) && ((int)localan.ght > 0) && ((localImageView.getTag() instanceof String)) && (x.Ao(paramString)) && (bu.lX((String)localObject, paramString)))
    {
      localObject = p.aEN().DL(paramString);
      if ((localObject != null) && (!bu.isNullOrNil(((i)localObject).aEH()))) {
        d.a(localImageView, localan, ((i)localObject).aEH(), true);
      }
      for (;;)
      {
        paramString = w.zP(paramString);
        this.KzV.setText(k.b(this.val$context, paramString, this.KzV.getTextSize()));
        AppMethodBeat.o(37172);
        return;
        a.b.d(localImageView, paramString);
      }
    }
    this.KzV.setText(k.b(this.val$context, this.val$context.getResources().getString(2131756568), this.KzV.getTextSize()));
    AppMethodBeat.o(37172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.1
 * JD-Core Version:    0.7.0.1
 */
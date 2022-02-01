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
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.lang.ref.WeakReference;

final class al$1
  implements ay.b.a
{
  al$1(WeakReference paramWeakReference, TextView paramTextView, Context paramContext) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(37172);
    if (this.JSU == null)
    {
      AppMethodBeat.o(37172);
      return;
    }
    ImageView localImageView = (ImageView)this.JSU.get();
    if (localImageView == null)
    {
      AppMethodBeat.o(37172);
      return;
    }
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    Object localObject = (String)localImageView.getTag();
    if ((localas != null) && ((int)localas.gMZ > 0) && ((localImageView.getTag() instanceof String)) && (ab.IT(paramString)) && (Util.isEqual((String)localObject, paramString)))
    {
      localObject = p.aYB().Mx(paramString);
      if ((localObject != null) && (!Util.isNullOrNil(((i)localObject).aYu()))) {
        d.a(localImageView, localas, ((i)localObject).aYu(), true);
      }
      for (;;)
      {
        paramString = aa.getDisplayName(paramString);
        this.PMz.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.val$context, paramString, this.PMz.getTextSize()));
        AppMethodBeat.o(37172);
        return;
        a.b.d(localImageView, paramString);
      }
    }
    this.PMz.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.val$context, this.val$context.getResources().getString(2131756704), this.PMz.getTextSize()));
    AppMethodBeat.o(37172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.1
 * JD-Core Version:    0.7.0.1
 */
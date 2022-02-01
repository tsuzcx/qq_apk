package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.lang.ref.WeakReference;

public final class al
{
  public static void a(Context paramContext, k.b paramb, ImageView paramImageView, TextView paramTextView)
  {
    AppMethodBeat.i(37175);
    if ((paramContext == null) || (paramb == null) || (paramImageView == null) || (paramTextView == null))
    {
      Log.i("MicroMsg.ChattingItemBizUtils", "param null");
      AppMethodBeat.o(37175);
      return;
    }
    if (Util.isNullOrNil(paramb.eag)) {
      Log.i("MicroMsg.ChattingItemBizUtils", "srcUsername null");
    }
    String str;
    if (ab.IT(paramb.eag))
    {
      a.b.d(paramImageView, paramb.eag);
      paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, "", paramTextView.getTextSize()));
      paramImageView.setVisibility(0);
      paramTextView.setVisibility(0);
      str = aa.getDisplayName(paramb.eag);
      if (Util.isNullOrNil(str)) {
        break label228;
      }
    }
    as localas;
    for (;;)
    {
      paramImageView.setTag(paramb.eag);
      localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramb.eag);
      if ((Util.isNullOrNil(paramb.eag)) || ((localas != null) && ((int)localas.gMZ > 0))) {
        break label237;
      }
      paramImageView.setTag(paramb.eag);
      paramImageView = new WeakReference(paramImageView);
      ay.a.iDq.a(paramb.eag, "", new al.1(paramImageView, paramTextView, paramContext));
      AppMethodBeat.o(37175);
      return;
      a.b.d(paramImageView, " ");
      paramImageView.setImageResource(2131231405);
      break;
      label228:
      str = paramb.eag;
    }
    label237:
    if (ab.IT(paramb.eag))
    {
      if ((!com.tencent.mm.contact.c.oR(localas.field_type)) && (com.tencent.mm.aj.c.a(paramb.eag, false, -1, null) == null))
      {
        paramb = p.aYB().Mx(paramb.eag);
        if ((paramb != null) && (!Util.isNullOrNil(paramb.aYu()))) {
          d.a(paramImageView, localas, paramb.aYu(), true);
        }
      }
      paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, str, paramTextView.getTextSize()));
      AppMethodBeat.o(37175);
      return;
    }
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, paramContext.getResources().getString(2131756704), paramTextView.getTextSize()));
    AppMethodBeat.o(37175);
  }
  
  public static boolean a(k.b paramb, e parame)
  {
    AppMethodBeat.i(233821);
    if ((parame == null) || (paramb == null))
    {
      AppMethodBeat.o(233821);
      return false;
    }
    if (Util.isNullOrNil(paramb.eag))
    {
      AppMethodBeat.o(233821);
      return false;
    }
    if (!((b)g.af(b.class)).isMpUrl(paramb.url))
    {
      AppMethodBeat.o(233821);
      return false;
    }
    if (parame.iwc >= 0)
    {
      AppMethodBeat.o(233821);
      return true;
    }
    if (parame.iwj == 1)
    {
      AppMethodBeat.o(233821);
      return true;
    }
    AppMethodBeat.o(233821);
    return false;
  }
  
  public static void b(TextView paramTextView, k.b paramb)
  {
    AppMethodBeat.i(169879);
    if (paramTextView == null)
    {
      AppMethodBeat.o(169879);
      return;
    }
    if (paramb == null)
    {
      Log.e("MicroMsg.ChattingItemBizUtils", "setFriendInfo, param error");
      paramTextView.setText("");
      AppMethodBeat.o(169879);
      return;
    }
    paramb = (e)paramb.as(e.class);
    if ((paramb != null) && (paramb.iwf == 1))
    {
      paramTextView.setText(Util.nullAsNil(paramTextView.getContext().getString(2131763172)));
      AppMethodBeat.o(169879);
      return;
    }
    paramTextView.setText("");
    AppMethodBeat.o(169879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al
 * JD-Core Version:    0.7.0.1
 */
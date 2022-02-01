package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.lang.ref.WeakReference;

public final class af
{
  public static void a(Context paramContext, k.b paramb, ImageView paramImageView, TextView paramTextView)
  {
    AppMethodBeat.i(37175);
    if ((paramContext == null) || (paramb == null) || (paramImageView == null) || (paramTextView == null))
    {
      ae.i("MicroMsg.ChattingItemBizUtils", "param null");
      AppMethodBeat.o(37175);
      return;
    }
    if (bu.isNullOrNil(paramb.dIt)) {
      ae.i("MicroMsg.ChattingItemBizUtils", "srcUsername null");
    }
    String str;
    if (x.Ao(paramb.dIt))
    {
      a.b.d(paramImageView, paramb.dIt);
      paramTextView.setText(k.b(paramContext, "", paramTextView.getTextSize()));
      paramImageView.setVisibility(0);
      paramTextView.setVisibility(0);
      str = w.zP(paramb.dIt);
      if (bu.isNullOrNil(str)) {
        break label228;
      }
    }
    an localan;
    for (;;)
    {
      paramImageView.setTag(paramb.dIt);
      localan = ((l)g.ab(l.class)).azF().BH(paramb.dIt);
      if ((bu.isNullOrNil(paramb.dIt)) || ((localan != null) && ((int)localan.ght > 0))) {
        break label237;
      }
      paramImageView.setTag(paramb.dIt);
      paramImageView = new WeakReference(paramImageView);
      au.a.hIG.a(paramb.dIt, "", new af.1(paramImageView, paramTextView, paramContext));
      AppMethodBeat.o(37175);
      return;
      a.b.d(paramImageView, " ");
      paramImageView.setImageResource(2131231342);
      break;
      label228:
      str = paramb.dIt;
    }
    label237:
    if (x.Ao(paramb.dIt))
    {
      if ((!com.tencent.mm.contact.c.lO(localan.field_type)) && (com.tencent.mm.aj.c.a(paramb.dIt, false, -1, null) == null))
      {
        paramb = p.aEN().DL(paramb.dIt);
        if ((paramb != null) && (!bu.isNullOrNil(paramb.aEH()))) {
          d.a(paramImageView, localan, paramb.aEH(), true);
        }
      }
      paramTextView.setText(k.b(paramContext, str, paramTextView.getTextSize()));
      AppMethodBeat.o(37175);
      return;
    }
    paramTextView.setText(k.b(paramContext, paramContext.getResources().getString(2131756568), paramTextView.getTextSize()));
    AppMethodBeat.o(37175);
  }
  
  public static boolean a(k.b paramb, e parame)
  {
    AppMethodBeat.i(187820);
    if ((parame == null) || (paramb == null))
    {
      AppMethodBeat.o(187820);
      return false;
    }
    if (bu.isNullOrNil(paramb.dIt))
    {
      AppMethodBeat.o(187820);
      return false;
    }
    if (!((b)g.ab(b.class)).isMpUrl(paramb.url))
    {
      AppMethodBeat.o(187820);
      return false;
    }
    if (parame.hBV >= 0)
    {
      AppMethodBeat.o(187820);
      return true;
    }
    if (parame.hCd == 1)
    {
      AppMethodBeat.o(187820);
      return true;
    }
    AppMethodBeat.o(187820);
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
      ae.e("MicroMsg.ChattingItemBizUtils", "setFriendInfo, param error");
      paramTextView.setText("");
      AppMethodBeat.o(169879);
      return;
    }
    paramb = (e)paramb.ao(e.class);
    if ((paramb != null) && (paramb.hBY == 1))
    {
      paramTextView.setText(bu.nullAsNil(paramTextView.getContext().getString(2131761345)));
      AppMethodBeat.o(169879);
      return;
    }
    paramTextView.setText("");
    AppMethodBeat.o(169879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af
 * JD-Core Version:    0.7.0.1
 */
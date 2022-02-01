package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.lang.ref.WeakReference;

public final class af
{
  public static void a(Context paramContext, k.b paramb, ImageView paramImageView, TextView paramTextView)
  {
    AppMethodBeat.i(37175);
    if ((paramContext == null) || (paramb == null) || (paramImageView == null) || (paramTextView == null))
    {
      ad.i("MicroMsg.ChattingItemBizUtils", "param null");
      AppMethodBeat.o(37175);
      return;
    }
    if (bt.isNullOrNil(paramb.dHo)) {
      ad.i("MicroMsg.ChattingItemBizUtils", "srcUsername null");
    }
    String str;
    if (w.zE(paramb.dHo))
    {
      a.b.d(paramImageView, paramb.dHo);
      paramTextView.setText(k.b(paramContext, "", paramTextView.getTextSize()));
      paramImageView.setVisibility(0);
      paramTextView.setVisibility(0);
      str = v.zf(paramb.dHo);
      if (bt.isNullOrNil(str)) {
        break label228;
      }
    }
    am localam;
    for (;;)
    {
      paramImageView.setTag(paramb.dHo);
      localam = ((l)g.ab(l.class)).azp().Bf(paramb.dHo);
      if ((bt.isNullOrNil(paramb.dHo)) || ((localam != null) && ((int)localam.gfj > 0))) {
        break label237;
      }
      paramImageView.setTag(paramb.dHo);
      paramImageView = new WeakReference(paramImageView);
      as.a.hFO.a(paramb.dHo, "", new af.1(paramImageView, paramTextView, paramContext));
      AppMethodBeat.o(37175);
      return;
      a.b.d(paramImageView, " ");
      paramImageView.setImageResource(2131231342);
      break;
      label228:
      str = paramb.dHo;
    }
    label237:
    if (w.zE(paramb.dHo))
    {
      if ((!com.tencent.mm.o.b.lM(localam.field_type)) && (c.a(paramb.dHo, false, -1, null) == null))
      {
        paramb = p.aEx().Dj(paramb.dHo);
        if ((paramb != null) && (!bt.isNullOrNil(paramb.aEr()))) {
          d.a(paramImageView, localam, paramb.aEr(), true);
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
    AppMethodBeat.i(194425);
    if ((parame == null) || (paramb == null))
    {
      AppMethodBeat.o(194425);
      return false;
    }
    if (bt.isNullOrNil(paramb.dHo))
    {
      AppMethodBeat.o(194425);
      return false;
    }
    if (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(paramb.url))
    {
      AppMethodBeat.o(194425);
      return false;
    }
    if (parame.hzh >= 0)
    {
      AppMethodBeat.o(194425);
      return true;
    }
    if (parame.hzp == 1)
    {
      AppMethodBeat.o(194425);
      return true;
    }
    AppMethodBeat.o(194425);
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
      ad.e("MicroMsg.ChattingItemBizUtils", "setFriendInfo, param error");
      paramTextView.setText("");
      AppMethodBeat.o(169879);
      return;
    }
    paramb = (e)paramb.ao(e.class);
    if ((paramb != null) && (paramb.hzk == 1))
    {
      paramTextView.setText(bt.nullAsNil(paramTextView.getContext().getString(2131761345)));
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
package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.lang.ref.WeakReference;

public final class ao
{
  public static void a(final Context paramContext, k.b paramb, ImageView paramImageView, final TextView paramTextView)
  {
    AppMethodBeat.i(37175);
    if ((paramContext == null) || (paramb == null) || (paramImageView == null) || (paramTextView == null))
    {
      Log.i("MicroMsg.ChattingItemBizUtils", "param null");
      AppMethodBeat.o(37175);
      return;
    }
    if (Util.isNullOrNil(paramb.fUd)) {
      Log.i("MicroMsg.ChattingItemBizUtils", "srcUsername null");
    }
    String str;
    if (ab.Qm(paramb.fUd))
    {
      a.b.d(paramImageView, paramb.fUd);
      paramTextView.setText(l.b(paramContext, "", paramTextView.getTextSize()));
      paramImageView.setVisibility(0);
      paramTextView.setVisibility(0);
      str = aa.PJ(paramb.fUd);
      if (Util.isNullOrNil(str)) {
        break label229;
      }
    }
    as localas;
    for (;;)
    {
      paramImageView.setTag(paramb.fUd);
      localas = ((n)h.ae(n.class)).bbL().RG(paramb.fUd);
      if ((Util.isNullOrNil(paramb.fUd)) || ((localas != null) && ((int)localas.jxt > 0))) {
        break label238;
      }
      paramImageView.setTag(paramb.fUd);
      paramImageView = new WeakReference(paramImageView);
      az.a.ltq.a(paramb.fUd, "", new az.b.a()
      {
        public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37172);
          if (this.QRZ == null)
          {
            AppMethodBeat.o(37172);
            return;
          }
          ImageView localImageView = (ImageView)this.QRZ.get();
          if (localImageView == null)
          {
            AppMethodBeat.o(37172);
            return;
          }
          as localas = ((n)h.ae(n.class)).bbL().RG(paramAnonymousString);
          Object localObject = (String)localImageView.getTag();
          if ((localas != null) && ((int)localas.jxt > 0) && ((localImageView.getTag() instanceof String)) && (ab.Qm(paramAnonymousString)) && (Util.isEqual((String)localObject, paramAnonymousString)))
          {
            localObject = q.bhP().TS(paramAnonymousString);
            if ((localObject != null) && (!Util.isNullOrNil(((j)localObject).bhI()))) {
              com.tencent.mm.plugin.brandservice.b.e.a(localImageView, localas, ((j)localObject).bhI(), true);
            }
            for (;;)
            {
              paramAnonymousString = aa.PJ(paramAnonymousString);
              paramTextView.setText(l.b(paramContext, paramAnonymousString, paramTextView.getTextSize()));
              AppMethodBeat.o(37172);
              return;
              a.b.d(localImageView, paramAnonymousString);
            }
          }
          paramTextView.setText(l.b(paramContext, paramContext.getResources().getString(R.l.biz_card_username_unknow), paramTextView.getTextSize()));
          AppMethodBeat.o(37172);
        }
      });
      AppMethodBeat.o(37175);
      return;
      a.b.d(paramImageView, " ");
      paramImageView.setImageResource(R.g.brand_default_head);
      break;
      label229:
      str = paramb.fUd;
    }
    label238:
    if (ab.Qm(paramb.fUd))
    {
      if ((!com.tencent.mm.contact.d.rk(localas.field_type)) && (com.tencent.mm.am.d.a(paramb.fUd, false, -1, null) == null))
      {
        paramb = q.bhP().TS(paramb.fUd);
        if ((paramb != null) && (!Util.isNullOrNil(paramb.bhI()))) {
          com.tencent.mm.plugin.brandservice.b.e.a(paramImageView, localas, paramb.bhI(), true);
        }
      }
      paramTextView.setText(l.b(paramContext, str, paramTextView.getTextSize()));
      AppMethodBeat.o(37175);
      return;
    }
    paramTextView.setText(l.b(paramContext, paramContext.getResources().getString(R.l.biz_card_username_unknow), paramTextView.getTextSize()));
    AppMethodBeat.o(37175);
  }
  
  public static boolean a(k.b paramb, com.tencent.mm.aj.e parame)
  {
    AppMethodBeat.i(273105);
    if ((parame == null) || (paramb == null))
    {
      AppMethodBeat.o(273105);
      return false;
    }
    if (Util.isNullOrNil(paramb.fUd))
    {
      AppMethodBeat.o(273105);
      return false;
    }
    if (!((c)h.ae(c.class)).isMpUrl(paramb.url))
    {
      AppMethodBeat.o(273105);
      return false;
    }
    if (parame.llp >= 0)
    {
      AppMethodBeat.o(273105);
      return true;
    }
    if (parame.llw == 1)
    {
      AppMethodBeat.o(273105);
      return true;
    }
    AppMethodBeat.o(273105);
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
    paramb = (com.tencent.mm.aj.e)paramb.ar(com.tencent.mm.aj.e.class);
    if ((paramb != null) && (paramb.lls == 1))
    {
      paramTextView.setText(Util.nullAsNil(paramTextView.getContext().getString(R.l.mp_pay_content)));
      AppMethodBeat.o(169879);
      return;
    }
    paramTextView.setText("");
    AppMethodBeat.o(169879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao
 * JD-Core Version:    0.7.0.1
 */
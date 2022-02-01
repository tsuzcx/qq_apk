package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.e;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.lang.ref.WeakReference;

public final class ae
{
  public static void a(final Context paramContext, k.b paramb, ImageView paramImageView, final TextView paramTextView)
  {
    AppMethodBeat.i(37175);
    if ((paramContext == null) || (paramb == null) || (paramImageView == null) || (paramTextView == null))
    {
      ac.i("MicroMsg.ChattingItemBizUtils", "param null");
      AppMethodBeat.o(37175);
      return;
    }
    if (bs.isNullOrNil(paramb.dvl)) {
      ac.i("MicroMsg.ChattingItemBizUtils", "srcUsername null");
    }
    String str;
    if (w.wH(paramb.dvl))
    {
      a.b.d(paramImageView, paramb.dvl);
      paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, "", paramTextView.getTextSize()));
      paramImageView.setVisibility(0);
      paramTextView.setVisibility(0);
      str = v.wk(paramb.dvl);
      if (bs.isNullOrNil(str)) {
        break label228;
      }
    }
    ai localai;
    for (;;)
    {
      paramImageView.setTag(paramb.dvl);
      localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramb.dvl);
      if ((bs.isNullOrNil(paramb.dvl)) || ((localai != null) && ((int)localai.fLJ > 0))) {
        break label237;
      }
      paramImageView.setTag(paramb.dvl);
      paramImageView = new WeakReference(paramImageView);
      ar.a.hnw.a(paramb.dvl, "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37172);
          if (this.DfC == null)
          {
            AppMethodBeat.o(37172);
            return;
          }
          ImageView localImageView = (ImageView)this.DfC.get();
          if (localImageView == null)
          {
            AppMethodBeat.o(37172);
            return;
          }
          ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramAnonymousString);
          Object localObject = (String)localImageView.getTag();
          if ((localai != null) && ((int)localai.fLJ > 0) && ((localImageView.getTag() instanceof String)) && (w.wH(paramAnonymousString)) && (bs.lr((String)localObject, paramAnonymousString)))
          {
            localObject = p.aBw().Ak(paramAnonymousString);
            if ((localObject != null) && (!bs.isNullOrNil(((i)localObject).aBp()))) {
              d.a(localImageView, localai, ((i)localObject).aBp(), true);
            }
            for (;;)
            {
              paramAnonymousString = v.wk(paramAnonymousString);
              paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, paramAnonymousString, paramTextView.getTextSize()));
              AppMethodBeat.o(37172);
              return;
              a.b.d(localImageView, paramAnonymousString);
            }
          }
          paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, paramContext.getResources().getString(2131756568), paramTextView.getTextSize()));
          AppMethodBeat.o(37172);
        }
      });
      AppMethodBeat.o(37175);
      return;
      a.b.d(paramImageView, " ");
      paramImageView.setImageResource(2131231342);
      break;
      label228:
      str = paramb.dvl;
    }
    label237:
    if (w.wH(paramb.dvl))
    {
      if ((!com.tencent.mm.n.b.ln(localai.field_type)) && (c.a(paramb.dvl, false, -1, null) == null))
      {
        paramb = p.aBw().Ak(paramb.dvl);
        if ((paramb != null) && (!bs.isNullOrNil(paramb.aBp()))) {
          d.a(paramImageView, localai, paramb.aBp(), true);
        }
      }
      paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str, paramTextView.getTextSize()));
      AppMethodBeat.o(37175);
      return;
    }
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, paramContext.getResources().getString(2131756568), paramTextView.getTextSize()));
    AppMethodBeat.o(37175);
  }
  
  public static boolean a(k.b paramb, e parame)
  {
    AppMethodBeat.i(196724);
    if ((parame == null) || (paramb == null))
    {
      AppMethodBeat.o(196724);
      return false;
    }
    if (bs.isNullOrNil(paramb.dvl))
    {
      AppMethodBeat.o(196724);
      return false;
    }
    if (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(paramb.url))
    {
      AppMethodBeat.o(196724);
      return false;
    }
    if (parame.hgY >= 0)
    {
      AppMethodBeat.o(196724);
      return true;
    }
    if (parame.hhg == 1)
    {
      AppMethodBeat.o(196724);
      return true;
    }
    AppMethodBeat.o(196724);
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
      ac.e("MicroMsg.ChattingItemBizUtils", "setFriendInfo, param error");
      paramTextView.setText("");
      AppMethodBeat.o(169879);
      return;
    }
    paramb = (e)paramb.ao(e.class);
    if ((paramb != null) && (paramb.hhb == 1))
    {
      paramTextView.setText(bs.nullAsNil(paramTextView.getContext().getString(2131761345)));
      AppMethodBeat.o(169879);
      return;
    }
    paramTextView.setText("");
    AppMethodBeat.o(169879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae
 * JD-Core Version:    0.7.0.1
 */
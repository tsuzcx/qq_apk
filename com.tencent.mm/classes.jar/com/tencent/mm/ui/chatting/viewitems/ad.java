package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.lang.ref.WeakReference;

public final class ad
{
  public static void a(final Context paramContext, k.b paramb, ImageView paramImageView, final TextView paramTextView)
  {
    AppMethodBeat.i(37175);
    if ((paramContext == null) || (paramb == null) || (paramImageView == null) || (paramTextView == null))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemBizUtils", "param null");
      AppMethodBeat.o(37175);
      return;
    }
    if (bt.isNullOrNil(paramb.dxz)) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingItemBizUtils", "srcUsername null");
    }
    String str;
    if (w.sE(paramb.dxz))
    {
      a.b.d(paramImageView, paramb.dxz);
      paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, "", paramTextView.getTextSize()));
      paramImageView.setVisibility(0);
      paramTextView.setVisibility(0);
      str = v.sh(paramb.dxz);
      if (bt.isNullOrNil(str)) {
        break label228;
      }
    }
    af localaf;
    for (;;)
    {
      paramImageView.setTag(paramb.dxz);
      localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramb.dxz);
      if ((bt.isNullOrNil(paramb.dxz)) || ((localaf != null) && ((int)localaf.fId > 0))) {
        break label237;
      }
      paramImageView.setTag(paramb.dxz);
      paramImageView = new WeakReference(paramImageView);
      ar.a.gMW.a(paramb.dxz, "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37172);
          if (this.BNs == null)
          {
            AppMethodBeat.o(37172);
            return;
          }
          ImageView localImageView = (ImageView)this.BNs.get();
          if (localImageView == null)
          {
            AppMethodBeat.o(37172);
            return;
          }
          af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramAnonymousString);
          Object localObject = (String)localImageView.getTag();
          if ((localaf != null) && ((int)localaf.fId > 0) && ((localImageView.getTag() instanceof String)) && (w.sE(paramAnonymousString)) && (bt.kU((String)localObject, paramAnonymousString)))
          {
            localObject = p.auF().we(paramAnonymousString);
            if ((localObject != null) && (!bt.isNullOrNil(((i)localObject).auy()))) {
              com.tencent.mm.plugin.brandservice.b.e.a(localImageView, localaf, ((i)localObject).auy(), true);
            }
            for (;;)
            {
              paramAnonymousString = v.sh(paramAnonymousString);
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
      str = paramb.dxz;
    }
    label237:
    if (w.sE(paramb.dxz))
    {
      if ((!com.tencent.mm.n.b.ls(localaf.field_type)) && (c.a(paramb.dxz, false, -1, null) == null))
      {
        paramb = p.auF().we(paramb.dxz);
        if ((paramb != null) && (!bt.isNullOrNil(paramb.auy()))) {
          com.tencent.mm.plugin.brandservice.b.e.a(paramImageView, localaf, paramb.auy(), true);
        }
      }
      paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, str, paramTextView.getTextSize()));
      AppMethodBeat.o(37175);
      return;
    }
    paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, paramContext.getResources().getString(2131756568), paramTextView.getTextSize()));
    AppMethodBeat.o(37175);
  }
  
  public static boolean a(k.b paramb, com.tencent.mm.ai.e parame)
  {
    AppMethodBeat.i(191646);
    if ((parame == null) || (paramb == null))
    {
      AppMethodBeat.o(191646);
      return false;
    }
    if (bt.isNullOrNil(paramb.dxz))
    {
      AppMethodBeat.o(191646);
      return false;
    }
    if (!((com.tencent.mm.plugin.brandservice.a.b)g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).isMpUrl(paramb.url))
    {
      AppMethodBeat.o(191646);
      return false;
    }
    if (parame.gGx >= 0)
    {
      AppMethodBeat.o(191646);
      return true;
    }
    if (parame.gGF == 1)
    {
      AppMethodBeat.o(191646);
      return true;
    }
    AppMethodBeat.o(191646);
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
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ChattingItemBizUtils", "setFriendInfo, param error");
      paramTextView.setText("");
      AppMethodBeat.o(169879);
      return;
    }
    paramb = (com.tencent.mm.ai.e)paramb.ao(com.tencent.mm.ai.e.class);
    if ((paramb != null) && (paramb.gGA == 1))
    {
      paramTextView.setText(bt.nullAsNil(paramTextView.getContext().getString(2131761345)));
      AppMethodBeat.o(169879);
      return;
    }
    paramTextView.setText("");
    AppMethodBeat.o(169879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad
 * JD-Core Version:    0.7.0.1
 */
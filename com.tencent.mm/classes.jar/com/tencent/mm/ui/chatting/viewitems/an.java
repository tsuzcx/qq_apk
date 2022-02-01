package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.lang.ref.WeakReference;

public final class an
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
    if (Util.isNullOrNil(paramb.iaa)) {
      Log.i("MicroMsg.ChattingItemBizUtils", "srcUsername null");
    }
    String str;
    if (ab.IS(paramb.iaa))
    {
      a.b.h(paramImageView, paramb.iaa);
      paramTextView.setText(p.b(paramContext, "", paramTextView.getTextSize()));
      paramImageView.setVisibility(0);
      paramTextView.setVisibility(0);
      str = aa.getDisplayName(paramb.iaa);
      if (Util.isNullOrNil(str)) {
        break label229;
      }
    }
    au localau;
    for (;;)
    {
      paramImageView.setTag(paramb.iaa);
      localau = ((n)h.ax(n.class)).bzA().JE(paramb.iaa);
      if ((Util.isNullOrNil(paramb.iaa)) || ((localau != null) && ((int)localau.maN > 0))) {
        break label238;
      }
      paramImageView.setTag(paramb.iaa);
      paramImageView = new WeakReference(paramImageView);
      az.a.okP.a(paramb.iaa, "", new az.b.a()
      {
        public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37172);
          if (an.this == null)
          {
            AppMethodBeat.o(37172);
            return;
          }
          ImageView localImageView = (ImageView)an.this.get();
          if (localImageView == null)
          {
            AppMethodBeat.o(37172);
            return;
          }
          au localau = ((n)h.ax(n.class)).bzA().JE(paramAnonymousString);
          Object localObject = (String)localImageView.getTag();
          if ((localau != null) && ((int)localau.maN > 0) && ((localImageView.getTag() instanceof String)) && (ab.IS(paramAnonymousString)) && (Util.isEqual((String)localObject, paramAnonymousString)))
          {
            localObject = q.bFE().LS(paramAnonymousString);
            if ((localObject != null) && (!Util.isNullOrNil(((j)localObject).bFx()))) {
              com.tencent.mm.plugin.brandservice.model.e.a(localImageView, localau, ((j)localObject).bFx(), true);
            }
            for (;;)
            {
              paramAnonymousString = aa.getDisplayName(paramAnonymousString);
              paramTextView.setText(p.b(paramContext, paramAnonymousString, paramTextView.getTextSize()));
              AppMethodBeat.o(37172);
              return;
              a.b.h(localImageView, paramAnonymousString);
            }
          }
          paramTextView.setText(p.b(paramContext, paramContext.getResources().getString(R.l.biz_card_username_unknow), paramTextView.getTextSize()));
          AppMethodBeat.o(37172);
        }
      });
      AppMethodBeat.o(37175);
      return;
      a.b.h(paramImageView, " ");
      paramImageView.setImageResource(R.g.brand_default_head);
      break;
      label229:
      str = paramb.iaa;
    }
    label238:
    if (ab.IS(paramb.iaa))
    {
      if ((!com.tencent.mm.contact.d.rs(localau.field_type)) && (com.tencent.mm.modelavatar.d.a(paramb.iaa, false, -1, null) == null))
      {
        paramb = q.bFE().LS(paramb.iaa);
        if ((paramb != null) && (!Util.isNullOrNil(paramb.bFx()))) {
          com.tencent.mm.plugin.brandservice.model.e.a(paramImageView, localau, paramb.bFx(), true);
        }
      }
      paramTextView.setText(p.b(paramContext, str, paramTextView.getTextSize()));
      AppMethodBeat.o(37175);
      return;
    }
    paramTextView.setText(p.b(paramContext, paramContext.getResources().getString(R.l.biz_card_username_unknow), paramTextView.getTextSize()));
    AppMethodBeat.o(37175);
  }
  
  public static boolean a(k.b paramb, com.tencent.mm.message.e parame)
  {
    AppMethodBeat.i(255184);
    if ((parame == null) || (paramb == null))
    {
      AppMethodBeat.o(255184);
      return false;
    }
    if (Util.isNullOrNil(paramb.iaa))
    {
      AppMethodBeat.o(255184);
      return false;
    }
    if (!((c)h.ax(c.class)).isMpUrl(paramb.url))
    {
      AppMethodBeat.o(255184);
      return false;
    }
    if (parame.nQm >= 0)
    {
      AppMethodBeat.o(255184);
      return true;
    }
    if (parame.nQt == 1)
    {
      AppMethodBeat.o(255184);
      return true;
    }
    AppMethodBeat.o(255184);
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
    paramb = (com.tencent.mm.message.e)paramb.aK(com.tencent.mm.message.e.class);
    if ((paramb != null) && (paramb.nQp == 1))
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an
 * JD-Core Version:    0.7.0.1
 */
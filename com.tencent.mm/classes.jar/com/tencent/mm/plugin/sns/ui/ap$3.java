package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.plugin.sns.e.a;
import com.tencent.mm.plugin.sns.e.a.2;
import com.tencent.mm.plugin.sns.e.a.3;
import com.tencent.mm.plugin.sns.e.a.4;
import com.tencent.mm.plugin.sns.j.b;
import com.tencent.mm.plugin.sns.j.b.1;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;

final class ap$3
  implements g.b
{
  ap$3(ap paramap, Context paramContext, b.b paramb, String paramString1, String paramString2, p paramp, int paramInt) {}
  
  public final void c(final SubscribeMsgRequestResult paramSubscribeMsgRequestResult)
  {
    AppMethodBeat.i(179163);
    if (paramSubscribeMsgRequestResult == null)
    {
      com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(179161);
          try
          {
            if (((ap.3.this.val$context instanceof Activity)) && (!((Activity)ap.3.this.val$context).isFinishing())) {
              t.ci(ap.3.this.val$context, ap.3.this.xMr.ygO);
            }
            AppMethodBeat.o(179161);
            return;
          }
          catch (Throwable localThrowable)
          {
            ac.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable.toString());
            AppMethodBeat.o(179161);
          }
        }
      });
      ac.e("MicroMsg.SnsAdCardActionBtnCtrl", "NetSceneSubscribeInfo result is null");
      paramSubscribeMsgRequestResult = new y(this.xMm, this.hyc, 0, -2);
      b.a(this.yyo, this.iqF, paramSubscribeMsgRequestResult);
      AppMethodBeat.o(179163);
      return;
    }
    com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179162);
        try
        {
          if (ap.3.this.val$context != null)
          {
            e locale = new e(ap.3.this.val$context, true, 0);
            a locala = new a();
            Context localContext = ap.3.this.val$context;
            SubscribeMsgRequestResult localSubscribeMsgRequestResult = paramSubscribeMsgRequestResult;
            b.b localb = ap.3.this.xMr;
            p localp = ap.3.this.yyo;
            int i = ap.3.this.iqF;
            ap.a locala1 = ap.c(ap.3.this.yFz);
            String str1 = localb.pis;
            String str2 = localb.ygJ;
            View localView = LayoutInflater.from(localContext).inflate(2131495530, null);
            Object localObject1 = (TextView)localView.findViewById(2131306893);
            Object localObject2 = (ImageView)localView.findViewById(2131306892);
            Object localObject3 = (TextView)localView.findViewById(2131305527);
            TextView localTextView = (TextView)localView.findViewById(2131305520);
            Button localButton = (Button)localView.findViewById(2131305516);
            String str3 = localSubscribeMsgRequestResult.appName;
            String str4 = localSubscribeMsgRequestResult.igG;
            ((TextView)localObject1).setText(str3);
            if (!TextUtils.equals((String)((ImageView)localObject2).getTag(2131304927), str4))
            {
              ((ImageView)localObject2).setImageDrawable(null);
              if (!TextUtils.isEmpty(str4))
              {
                ac.d("HalfScreenSubscribeUtils", "loadImage, hash=" + localObject2.hashCode() + ", url=" + str4);
                h.a(str4, false, new b.1((ImageView)localObject2, str4));
              }
            }
            ((TextView)localObject3).setText(localb.ygL);
            localTextView.setText(localb.ygM);
            localButton.setText(localb.ygN);
            localObject2 = (WeImageView)localView.findViewById(2131298360);
            localObject1 = (Button)localView.findViewById(2131305516);
            locala.xMj = false;
            locale.Ihj = new a.2(locala, str2, str1, localp, i);
            ((WeImageView)localObject2).setOnClickListener(new a.3(locala, locale));
            localObject2 = localSubscribeMsgRequestResult.igI;
            localObject3 = localSubscribeMsgRequestResult.buffer;
            ((Button)localObject1).setOnClickListener(new a.4(locala, str1, (List)localObject2, locale, localContext, localb, str2, localp, i, locala1, localSubscribeMsgRequestResult.igL, (byte[])localObject3, b.fA((List)localObject2)));
            locale.J(localView, true);
            locale.fvq();
            locale.cED();
          }
          AppMethodBeat.o(179162);
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.e("MicroMsg.SnsAdCardActionBtnCtrl", localThrowable.toString());
          AppMethodBeat.o(179162);
        }
      }
    });
    AppMethodBeat.o(179163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap.3
 * JD-Core Version:    0.7.0.1
 */
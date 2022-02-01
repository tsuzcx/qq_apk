package com.tencent.mm.plugin.sns.e;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.as.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.a.e.b;
import java.lang.ref.WeakReference;

public final class b
{
  public Context mContext;
  com.tencent.mm.ui.base.p mHk;
  public com.tencent.mm.ui.widget.a.e nMW;
  public volatile boolean zsP;
  
  public b()
  {
    AppMethodBeat.i(179077);
    this.zsP = false;
    this.mHk = null;
    AppMethodBeat.o(179077);
  }
  
  public static View a(Context paramContext, b.c paramc, com.tencent.mm.plugin.sns.storage.p paramp, bq parambq)
  {
    AppMethodBeat.i(219231);
    View localView = LayoutInflater.from(paramContext).inflate(2131495530, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131306893);
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)localView.findViewById(2131306892);
    TextView localTextView2 = (TextView)localView.findViewById(2131305527);
    if ((paramc == null) || (paramp == null)) {}
    try
    {
      ae.e("HalfScreenSubscribeUtils", "adCardActionBtnInfo == null || snsInfo == null");
      for (;;)
      {
        paramContext = (TextView)localView.findViewById(2131305520);
        paramp = (Button)localView.findViewById(2131305516);
        localTextView1.setText(paramc.zOv);
        localTextView2.setText(paramc.zOo);
        paramContext.setText(paramc.zOp);
        paramp.setText(paramc.zOq);
        AppMethodBeat.o(219231);
        return localView;
        if (bu.isNullOrNil(paramc.zOv))
        {
          paramContext = paramp.field_userName;
          if (!bu.isNullOrNil(paramContext))
          {
            parambq = parambq.aUL(paramContext);
            if (parambq != null) {
              break;
            }
            if (paramp.Rt(32))
            {
              localb = paramp.dVj();
              if (!localb.zNN) {
                break label243;
              }
              parambq = localb.zNO;
              paramc.zOv = parambq;
            }
          }
        }
        if (!bu.isNullOrNil(paramc.zOu)) {
          break label274;
        }
        a.b.c(localRoundCornerImageView, paramp.field_userName);
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.mm.plugin.sns.storage.b localb;
        ae.e("HalfScreenSubscribeUtils", paramContext.toString());
        continue;
        paramContext = parambq.adG();
        continue;
        label243:
        parambq = paramContext;
        if (bu.isNullOrNil(paramContext))
        {
          parambq = paramContext;
          if (!bu.isNullOrNil(localb.nickname))
          {
            parambq = localb.nickname;
            continue;
            label274:
            paramContext = paramc.zOu;
            if (!TextUtils.equals((String)localRoundCornerImageView.getTag(2131304927), paramContext))
            {
              localRoundCornerImageView.setImageDrawable(null);
              com.tencent.mm.plugin.sns.a.c.j(paramContext, localRoundCornerImageView);
            }
          }
        }
      }
    }
  }
  
  public static final class a
    implements f
  {
    private com.tencent.mm.plugin.sns.storage.p znm;
    private int zsG;
    private WeakReference<b> zsY;
    b.c zsZ;
    as.a zta;
    
    public a(b paramb, b.c paramc, com.tencent.mm.plugin.sns.storage.p paramp, int paramInt, as.a parama)
    {
      AppMethodBeat.i(219229);
      this.zsY = new WeakReference(paramb);
      this.zsZ = paramc;
      this.znm = paramp;
      this.zsG = paramInt;
      this.zta = parama;
      AppMethodBeat.o(219229);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
    {
      AppMethodBeat.i(219230);
      ae.i("HalfSubscribeController", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
      for (;;)
      {
        StringBuilder localStringBuilder;
        try
        {
          if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e))
          {
            if ((this.zsY == null) || (this.zsY.get() == null))
            {
              g.ajj().b(paramn.getType(), this);
              AppMethodBeat.o(219230);
              return;
            }
            paramString = (b)this.zsY.get();
            paramString.zsP = true;
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219226);
                if (paramString.mHk != null)
                {
                  paramString.mHk.dismiss();
                  paramString.mHk = null;
                }
                if ((paramString.nMW != null) && (paramString.nMW.isShowing()))
                {
                  ae.i("HalfSubscribeController", "mmBottomSheet tryHide due to send subscribe");
                  paramString.nMW.bqD();
                }
                AppMethodBeat.o(219226);
              }
            });
            paramString = paramString.mContext;
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
              break label417;
            }
            ae.i("HalfSubscribeController", "subscribe is success");
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219227);
                try
                {
                  b.a.this.zta.a(b.a.this.zsZ);
                  if (((paramString instanceof Activity)) && (!((Activity)paramString).isFinishing())) {
                    t.cn(paramString, b.a.this.zsZ.zOs);
                  }
                  AppMethodBeat.o(219227);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  ae.e("HalfSubscribeController", localThrowable.toString());
                  AppMethodBeat.o(219227);
                }
              }
            });
            paramString = r.zV(this.znm.field_snsId);
          }
          try
          {
            g.ajP();
            localObject = com.tencent.mm.kernel.a.aiF();
            if (bu.V(new String[] { paramString, localObject }))
            {
              ae.e("StorageHelper", "HalfScreenSubscribe, snsId or uin is empty");
              paramString = new y(this.zsZ.zOm, this.zsZ.pSx, 1, 0);
              com.tencent.mm.plugin.sns.a.c.a(this.znm, this.zsG, paramString);
              g.ajj().b(paramn.getType(), this);
              AppMethodBeat.o(219230);
              return;
            }
            localStringBuilder = new StringBuilder();
            if (!bu.isNullOrNil(paramString))
            {
              localStringBuilder.append(paramString);
              if (bu.isNullOrNil((String)localObject)) {
                break label476;
              }
              paramString = (String)localObject;
              localStringBuilder.append(paramString);
              if (localStringBuilder.length() > 0) {
                break label342;
              }
              ae.e("StorageHelper", "HalfScreenSubscribe, key is empty");
              continue;
            }
          }
          catch (Throwable paramString)
          {
            ae.e("StorageHelper", paramString.toString());
            continue;
          }
          paramString = "";
        }
        catch (Throwable paramString)
        {
          ae.e("HalfSubscribeController", paramString.toString());
          AppMethodBeat.o(219230);
          return;
        }
        continue;
        label342:
        paramString = localStringBuilder.toString();
        Object localObject = ak.getContext().getSharedPreferences("SnsAdVoteSubscribe", 0).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, "1");
        ((SharedPreferences.Editor)localObject).commit();
        ae.i("StorageHelper", "HalfScreenSubscribe, key = " + paramString + ", isSubscribe=" + "1");
        continue;
        label417:
        ae.e("HalfSubscribeController", "subscribe is failed");
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219228);
            try
            {
              if (((paramString instanceof Activity)) && (!((Activity)paramString).isFinishing())) {
                t.co(paramString, b.a.this.zsZ.zOr);
              }
              AppMethodBeat.o(219228);
              return;
            }
            catch (Throwable localThrowable)
            {
              ae.e("HalfSubscribeController", localThrowable.toString());
              AppMethodBeat.o(219228);
            }
          }
        });
        paramString = new y(this.zsZ.zOm, this.zsZ.pSx, 1, -3);
        com.tencent.mm.plugin.sns.a.c.a(this.znm, this.zsG, paramString);
        continue;
        label476:
        paramString = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.b
 * JD-Core Version:    0.7.0.1
 */
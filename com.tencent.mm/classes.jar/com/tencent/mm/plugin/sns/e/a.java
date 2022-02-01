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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.c;
import com.tencent.mm.plugin.sns.a.c.1;
import com.tencent.mm.plugin.sns.storage.b.b;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.as.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.a.e.b;
import java.lang.ref.WeakReference;

public final class a
{
  com.tencent.mm.ui.base.p mCf;
  public Context mContext;
  public com.tencent.mm.ui.widget.a.e nHu;
  public volatile boolean zcb;
  
  public a()
  {
    AppMethodBeat.i(179077);
    this.zcb = false;
    this.mCf = null;
    AppMethodBeat.o(179077);
  }
  
  public static View a(Context paramContext, b.b paramb, com.tencent.mm.plugin.sns.storage.p paramp, bp parambp)
  {
    AppMethodBeat.i(197748);
    View localView = LayoutInflater.from(paramContext).inflate(2131495530, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131306893);
    RoundCornerImageView localRoundCornerImageView = (RoundCornerImageView)localView.findViewById(2131306892);
    TextView localTextView2 = (TextView)localView.findViewById(2131305527);
    if ((paramb == null) || (paramp == null)) {}
    try
    {
      ad.e("HalfScreenSubscribeUtils", "adCardActionBtnInfo == null || snsInfo == null");
      for (;;)
      {
        paramContext = (TextView)localView.findViewById(2131305520);
        paramp = (Button)localView.findViewById(2131305516);
        localTextView1.setText(paramb.zwW);
        localTextView2.setText(paramb.zwP);
        paramContext.setText(paramb.zwQ);
        paramp.setText(paramb.zwR);
        AppMethodBeat.o(197748);
        return localView;
        if (bt.isNullOrNil(paramb.zwW))
        {
          paramContext = paramp.field_userName;
          if (!bt.isNullOrNil(paramContext))
          {
            parambp = parambp.aTk(paramContext);
            if (parambp != null) {
              break;
            }
            if (paramp.QM(32))
            {
              localb = paramp.dRL();
              if (!localb.zws) {
                break label243;
              }
              parambp = localb.zwt;
              paramb.zwW = parambp;
            }
          }
        }
        if (!bt.isNullOrNil(paramb.zwV)) {
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
        ad.e("HalfScreenSubscribeUtils", paramContext.toString());
        continue;
        paramContext = parambp.adv();
        continue;
        label243:
        parambp = paramContext;
        if (bt.isNullOrNil(paramContext))
        {
          parambp = paramContext;
          if (!bt.isNullOrNil(localb.nickname))
          {
            parambp = localb.nickname;
            continue;
            label274:
            paramContext = paramb.zwV;
            if (!TextUtils.equals((String)localRoundCornerImageView.getTag(2131304927), paramContext))
            {
              localRoundCornerImageView.setImageDrawable(null);
              if (!TextUtils.isEmpty(paramContext))
              {
                ad.d("HalfScreenSubscribeUtils", "loadImage, hash=" + localRoundCornerImageView.hashCode() + ", url=" + paramContext);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(paramContext, false, new c.1(localRoundCornerImageView, paramContext));
              }
            }
          }
        }
      }
    }
  }
  
  public static final class a
    implements f
  {
    private com.tencent.mm.plugin.sns.storage.p yXF;
    private WeakReference<a> zck;
    b.b zcl;
    private int zcm;
    as.a zcn;
    
    public a(a parama, b.b paramb, com.tencent.mm.plugin.sns.storage.p paramp, int paramInt, as.a parama1)
    {
      AppMethodBeat.i(197746);
      this.zck = new WeakReference(parama);
      this.zcl = paramb;
      this.yXF = paramp;
      this.zcm = paramInt;
      this.zcn = parama1;
      AppMethodBeat.o(197746);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
    {
      AppMethodBeat.i(197747);
      ad.i("HalfSubscribeController", "onSceneEnd errType %d,errCode %d,errMsg %s,scene %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
      for (;;)
      {
        StringBuilder localStringBuilder;
        try
        {
          if ((paramn instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.e))
          {
            if ((this.zck == null) || (this.zck.get() == null))
            {
              g.aiU().b(paramn.getType(), this);
              AppMethodBeat.o(197747);
              return;
            }
            paramString = (a)this.zck.get();
            paramString.zcb = true;
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(197743);
                if (paramString.mCf != null)
                {
                  paramString.mCf.dismiss();
                  paramString.mCf = null;
                }
                if ((paramString.nHu != null) && (paramString.nHu.isShowing()))
                {
                  ad.i("HalfSubscribeController", "mmBottomSheet tryHide due to send subscribe");
                  paramString.nHu.bpT();
                }
                AppMethodBeat.o(197743);
              }
            });
            paramString = paramString.mContext;
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
              break label417;
            }
            ad.i("HalfSubscribeController", "subscribe is success");
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(197744);
                try
                {
                  a.a.this.zcn.a(a.a.this.zcl);
                  if (((paramString instanceof Activity)) && (!((Activity)paramString).isFinishing())) {
                    t.cm(paramString, a.a.this.zcl.zwT);
                  }
                  AppMethodBeat.o(197744);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  ad.e("HalfSubscribeController", localThrowable.toString());
                  AppMethodBeat.o(197744);
                }
              }
            });
            paramString = com.tencent.mm.plugin.sns.data.q.zw(this.yXF.field_snsId);
          }
          try
          {
            g.ajA();
            localObject = com.tencent.mm.kernel.a.aiq();
            if (bt.V(new String[] { paramString, localObject }))
            {
              ad.e("StorageHelper", "HalfScreenSubscribe, snsId or uin is empty");
              paramString = new y(this.zcl.zwN, this.zcl.pLS, 1, 0);
              c.a(this.yXF, this.zcm, paramString);
              g.aiU().b(paramn.getType(), this);
              AppMethodBeat.o(197747);
              return;
            }
            localStringBuilder = new StringBuilder();
            if (!bt.isNullOrNil(paramString))
            {
              localStringBuilder.append(paramString);
              if (bt.isNullOrNil((String)localObject)) {
                break label476;
              }
              paramString = (String)localObject;
              localStringBuilder.append(paramString);
              if (localStringBuilder.length() > 0) {
                break label342;
              }
              ad.e("StorageHelper", "HalfScreenSubscribe, key is empty");
              continue;
            }
          }
          catch (Throwable paramString)
          {
            ad.e("StorageHelper", paramString.toString());
            continue;
          }
          paramString = "";
        }
        catch (Throwable paramString)
        {
          ad.e("HalfSubscribeController", paramString.toString());
          AppMethodBeat.o(197747);
          return;
        }
        continue;
        label342:
        paramString = localStringBuilder.toString();
        Object localObject = aj.getContext().getSharedPreferences("SnsAdVoteSubscribe", 0).edit();
        ((SharedPreferences.Editor)localObject).putString(paramString, "1");
        ((SharedPreferences.Editor)localObject).commit();
        ad.i("StorageHelper", "HalfScreenSubscribe, key = " + paramString + ", isSubscribe=" + "1");
        continue;
        label417:
        ad.e("HalfSubscribeController", "subscribe is failed");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197745);
            try
            {
              if (((paramString instanceof Activity)) && (!((Activity)paramString).isFinishing())) {
                t.cn(paramString, a.a.this.zcl.zwS);
              }
              AppMethodBeat.o(197745);
              return;
            }
            catch (Throwable localThrowable)
            {
              ad.e("HalfSubscribeController", localThrowable.toString());
              AppMethodBeat.o(197745);
            }
          }
        });
        paramString = new y(this.zcl.zwN, this.zcl.pLS, 1, -3);
        c.a(this.yXF, this.zcm, paramString);
        continue;
        label476:
        paramString = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.a
 * JD-Core Version:    0.7.0.1
 */
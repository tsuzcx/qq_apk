package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.threadpool.i;

public final class a
  extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a
{
  public a(AdClickActionInfo paramAdClickActionInfo)
  {
    this.PYe = paramAdClickActionInfo;
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, AdClickActionInfo paramAdClickActionInfo, d paramd)
  {
    AppMethodBeat.i(311414);
    if ((paramAdClickActionInfo == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(311414);
      return false;
    }
    com.tencent.mm.plugin.sns.ad.j.k.a((SnsAdClick)paramd.K("snsAdClick", null), 42);
    paramView = new b(paramView.getContext(), paramSnsInfo);
    paramView.PYw = paramAdClickActionInfo;
    if (paramView.vlk == null)
    {
      paramView.mContentView = LayoutInflater.from(paramView.mContext).inflate(b.g.sns_bottom_subscribe_layout, null);
      paramSnsInfo = paramView.mContentView.findViewById(b.f.close);
      paramd = (TextView)paramView.mContentView.findViewById(b.f.subscribe);
      paramView.PYr = ((ImageView)paramView.mContentView.findViewById(b.f.we_app_icon));
      paramView.PYs = ((TextView)paramView.mContentView.findViewById(b.f.we_app_title));
      paramView.PYt = ((TextView)paramView.mContentView.findViewById(b.f.subscribe_title));
      paramView.PYu = ((TextView)paramView.mContentView.findViewById(b.f.subscribe_content));
      if (paramSnsInfo != null) {
        paramSnsInfo.setOnClickListener(new a.b.1(paramView));
      }
      if (paramd != null)
      {
        paramd.setText(b.j.sns_ad_coupon_accept);
        paramd.setOnClickListener(new a.b.2(paramView));
      }
      paramView.vlk = new f(paramView.mContext, true, 0);
      paramView.vlk.af(paramView.mContentView, true);
      paramView.vlk.uR(true);
    }
    if (paramAdClickActionInfo != null)
    {
      if (paramView.PYs != null) {
        paramView.PYs.setText(paramAdClickActionInfo.PLK);
      }
      if (paramView.PYt != null) {
        paramView.PYt.setText(paramAdClickActionInfo.PLL);
      }
      if (paramView.PYu != null) {
        paramView.PYu.setText(paramAdClickActionInfo.PLM);
      }
      com.tencent.mm.plugin.sns.b.c.a(b.f.sns_ad_subscribe_url, paramAdClickActionInfo.PLJ, paramView.PYr);
    }
    if (!paramView.vlk.isShowing()) {
      paramView.vlk.dDn();
    }
    AppMethodBeat.o(311414);
    return true;
  }
  
  public static final class a
    extends com.tencent.mm.plugin.sns.ad.landingpage.component.comp.a.a
  {
    public a(SnsInfo paramSnsInfo, int paramInt, String paramString, AdClickActionInfo paramAdClickActionInfo)
    {
      super(paramString);
      AppMethodBeat.i(311398);
      this.source = 1;
      if (paramSnsInfo != null)
      {
        this.uxInfo = Util.nullAsNil(paramSnsInfo.getUxinfo());
        this.hQX = t.x(paramSnsInfo);
        if (paramSnsInfo.getAdXml() != null)
        {
          this.adExtInfo = Util.nullAsNil(paramSnsInfo.getAdXml().adExtInfo);
          if (paramAdClickActionInfo != null)
          {
            this.appId = Util.nullAsNil(paramAdClickActionInfo.PLH);
            this.mdN = Util.nullAsNil(paramAdClickActionInfo.PLI);
          }
        }
      }
      AppMethodBeat.o(311398);
    }
  }
  
  public static final class b
    implements com.tencent.mm.am.h
  {
    private SnsInfo PJQ;
    ImageView PYr;
    TextView PYs;
    TextView PYt;
    TextView PYu;
    private w PYv = null;
    AdClickActionInfo PYw;
    View mContentView;
    Context mContext;
    f vlk;
    
    b(Context paramContext, SnsInfo paramSnsInfo)
    {
      this.mContext = paramContext;
      this.PJQ = paramSnsInfo;
    }
    
    final void b(AdClickActionInfo paramAdClickActionInfo)
    {
      AppMethodBeat.i(311419);
      SnsInfo localSnsInfo = this.PJQ;
      if (paramAdClickActionInfo != null)
      {
        paramAdClickActionInfo = new com.tencent.mm.plugin.sns.ad.h.c(paramAdClickActionInfo.PLH, paramAdClickActionInfo.PLI, localSnsInfo.getUxinfo(), "");
        com.tencent.mm.kernel.h.aZW().a(4743, this);
        com.tencent.mm.kernel.h.aZW().a(paramAdClickActionInfo, 0);
        if (this.PYv == null)
        {
          this.PYv = com.tencent.mm.ui.base.k.a(this.mContext, this.mContext.getString(b.j.loading), true, null);
          AppMethodBeat.o(311419);
          return;
        }
        if (!this.PYv.isShowing()) {
          this.PYv.show();
        }
      }
      AppMethodBeat.o(311419);
    }
    
    public final void onSceneEnd(final int paramInt1, int paramInt2, final String paramString, p paramp)
    {
      AppMethodBeat.i(311425);
      try
      {
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(311392);
            try
            {
              Object localObject1 = a.b.c(a.b.this);
              if ((localObject1 != null) && (((w)localObject1).isShowing())) {
                ((w)localObject1).dismiss();
              }
              localObject1 = a.b.a(a.b.this);
              if ((localObject1 != null) && (((f)localObject1).isShowing())) {
                ((f)localObject1).cyW();
              }
              return;
            }
            finally
            {
              AppMethodBeat.o(311392);
            }
          }
        });
        com.tencent.mm.kernel.h.aZW().b(4743, this);
        int i = -1;
        if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof com.tencent.mm.plugin.sns.ad.h.c)))
        {
          paramString = (cso)((com.tencent.mm.plugin.sns.ad.h.c)paramp).hbp();
          if (paramString == null) {
            break label169;
          }
          paramInt1 = paramString.ret;
          paramString = Util.nullAsNil(paramString.msg);
        }
        for (;;)
        {
          Log.d("SnsAd.AdCoupon", "the coupon result is ".concat(String.valueOf(paramInt1)));
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(311391);
              try
              {
                if (paramInt1 == 0)
                {
                  localContext = a.b.d(a.b.this);
                  if (TextUtils.isEmpty(paramString)) {}
                  for (str = a.b.d(a.b.this).getString(b.j.sns_ad_coupon_success);; str = paramString)
                  {
                    aa.db(localContext, str);
                    return;
                  }
                }
                Context localContext = a.b.d(a.b.this);
                if (TextUtils.isEmpty(paramString)) {}
                for (String str = a.b.d(a.b.this).getString(b.j.sns_ad_coupon_error);; str = paramString)
                {
                  aa.dc(localContext, str);
                  return;
                }
                return;
              }
              finally
              {
                AppMethodBeat.o(311391);
              }
            }
          });
          j.a(new a.a(this.PJQ, paramInt1, paramString, this.PYw));
          return;
          Log.w("SnsAd.AdCoupon", "the coupon errType is " + paramInt1 + ", errCode is " + paramInt2);
          label169:
          paramString = "";
          paramInt1 = i;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(311425);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */
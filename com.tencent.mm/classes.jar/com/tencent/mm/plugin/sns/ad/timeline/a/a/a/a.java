package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.c;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.i.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;

public final class a
  extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, AdClickActionInfo paramAdClickActionInfo, d paramd)
  {
    AppMethodBeat.i(223932);
    if ((paramAdClickActionInfo == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(223932);
      return false;
    }
    k.a((SnsAdClick)paramd.y("snsAdClick", null), 42);
    paramView = new b(paramView.getContext(), paramSnsInfo);
    paramView.JHw = paramAdClickActionInfo;
    if (paramView.rZT == null)
    {
      paramView.mContentView = LayoutInflater.from(paramView.mContext).inflate(i.g.sns_bottom_subscribe_layout, null);
      paramSnsInfo = paramView.mContentView.findViewById(i.f.close);
      paramd = (TextView)paramView.mContentView.findViewById(i.f.subscribe);
      paramView.JHr = ((ImageView)paramView.mContentView.findViewById(i.f.we_app_icon));
      paramView.JHs = ((TextView)paramView.mContentView.findViewById(i.f.we_app_title));
      paramView.JHt = ((TextView)paramView.mContentView.findViewById(i.f.subscribe_title));
      paramView.JHu = ((TextView)paramView.mContentView.findViewById(i.f.subscribe_content));
      if (paramSnsInfo != null) {
        paramSnsInfo.setOnClickListener(new a.b.1(paramView));
      }
      if (paramd != null)
      {
        paramd.setText(i.j.sns_ad_coupon_accept);
        paramd.setOnClickListener(new a.b.2(paramView));
      }
      paramView.rZT = new e(paramView.mContext, true, 0);
      paramView.rZT.Z(paramView.mContentView, true);
      paramView.rZT.rn(true);
    }
    if (paramAdClickActionInfo != null)
    {
      if (paramView.JHs != null) {
        paramView.JHs.setText(paramAdClickActionInfo.JxV);
      }
      if (paramView.JHt != null) {
        paramView.JHt.setText(paramAdClickActionInfo.JxW);
      }
      if (paramView.JHu != null) {
        paramView.JHu.setText(paramAdClickActionInfo.JxX);
      }
      c.a(i.f.sns_ad_subscribe_url, paramAdClickActionInfo.JxU, paramView.JHr);
    }
    if (!paramView.rZT.isShowing()) {
      paramView.rZT.eik();
    }
    AppMethodBeat.o(223932);
    return true;
  }
  
  public static final class a
    extends com.tencent.mm.plugin.sns.ad.landingpage.component.a.a.a
  {
    public a(SnsInfo paramSnsInfo, int paramInt, String paramString, AdClickActionInfo paramAdClickActionInfo)
    {
      super(paramString);
      AppMethodBeat.i(270693);
      this.source = 1;
      if (paramSnsInfo != null)
      {
        this.uxInfo = Util.nullAsNil(paramSnsInfo.getUxinfo());
        this.fLp = com.tencent.mm.plugin.sns.data.t.w(paramSnsInfo);
        if (paramSnsInfo.getAdXml() != null)
        {
          this.adExtInfo = Util.nullAsNil(paramSnsInfo.getAdXml().adExtInfo);
          if (paramAdClickActionInfo != null)
          {
            this.appId = Util.nullAsNil(paramAdClickActionInfo.JxS);
            this.jDR = Util.nullAsNil(paramAdClickActionInfo.JxT);
          }
        }
      }
      AppMethodBeat.o(270693);
    }
  }
  
  public static final class b
    implements com.tencent.mm.an.i
  {
    ImageView JHr;
    TextView JHs;
    TextView JHt;
    TextView JHu;
    private s JHv = null;
    AdClickActionInfo JHw;
    private SnsInfo Jws;
    View mContentView;
    Context mContext;
    e rZT;
    
    b(Context paramContext, SnsInfo paramSnsInfo)
    {
      this.mContext = paramContext;
      this.Jws = paramSnsInfo;
    }
    
    final void b(AdClickActionInfo paramAdClickActionInfo)
    {
      AppMethodBeat.i(224342);
      SnsInfo localSnsInfo = this.Jws;
      if (paramAdClickActionInfo != null)
      {
        paramAdClickActionInfo = new com.tencent.mm.plugin.sns.ad.g.b(paramAdClickActionInfo.JxS, paramAdClickActionInfo.JxT, localSnsInfo.getUxinfo(), "");
        com.tencent.mm.kernel.h.aGY().a(4743, this);
        com.tencent.mm.kernel.h.aGY().a(paramAdClickActionInfo, 0);
        if (this.JHv == null)
        {
          this.JHv = com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(i.j.loading), true, null);
          AppMethodBeat.o(224342);
          return;
        }
        if (!this.JHv.isShowing()) {
          this.JHv.show();
        }
      }
      AppMethodBeat.o(224342);
    }
    
    public final void onSceneEnd(final int paramInt1, int paramInt2, final String paramString, q paramq)
    {
      AppMethodBeat.i(224350);
      try
      {
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193584);
            try
            {
              Object localObject = a.b.c(a.b.this);
              if ((localObject != null) && (((s)localObject).isShowing())) {
                ((s)localObject).dismiss();
              }
              localObject = a.b.a(a.b.this);
              if ((localObject != null) && (((e)localObject).isShowing())) {
                ((e)localObject).bYF();
              }
              AppMethodBeat.o(193584);
              return;
            }
            catch (Throwable localThrowable)
            {
              AppMethodBeat.o(193584);
            }
          }
        });
        com.tencent.mm.kernel.h.aGY().b(4743, this);
        int i = -1;
        if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof com.tencent.mm.plugin.sns.ad.g.b)))
        {
          paramString = (cdc)((com.tencent.mm.plugin.sns.ad.g.b)paramq).fKY();
          if (paramString == null) {
            break label169;
          }
          paramInt1 = paramString.ret;
          paramString = Util.nullAsNil(paramString.msg);
        }
        for (;;)
        {
          Log.d("SnsAd.AdCoupon", "the coupon result is ".concat(String.valueOf(paramInt1)));
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(212506);
              try
              {
                if (paramInt1 == 0)
                {
                  localContext = a.b.d(a.b.this);
                  if (TextUtils.isEmpty(paramString)) {}
                  for (str = a.b.d(a.b.this).getString(i.j.sns_ad_coupon_success);; str = paramString)
                  {
                    w.cR(localContext, str);
                    AppMethodBeat.o(212506);
                    return;
                  }
                }
                Context localContext = a.b.d(a.b.this);
                if (TextUtils.isEmpty(paramString)) {}
                for (String str = a.b.d(a.b.this).getString(i.j.sns_ad_coupon_error);; str = paramString)
                {
                  w.cS(localContext, str);
                  AppMethodBeat.o(212506);
                  return;
                }
                return;
              }
              catch (Throwable localThrowable)
              {
                AppMethodBeat.o(212506);
              }
            }
          });
          j.a(new a.a(this.Jws, paramInt1, paramString, this.JHw));
          AppMethodBeat.o(224350);
          return;
          Log.w("SnsAd.AdCoupon", "the coupon errType is " + paramInt1 + ", errCode is " + paramInt2);
          label169:
          paramString = "";
          paramInt1 = i;
        }
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(224350);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */
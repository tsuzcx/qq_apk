package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.d.n;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.ad.j.j.a;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.ad.widget.b.c.1;
import com.tencent.mm.plugin.sns.ad.widget.b.c.2;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f;

public final class b
  extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a
{
  public b(AdClickActionInfo paramAdClickActionInfo)
  {
    this.PYe = paramAdClickActionInfo;
  }
  
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, AdClickActionInfo paramAdClickActionInfo, d paramd)
  {
    AppMethodBeat.i(311413);
    Log.d("SnsAd.AdFinderLiveNotice", "the AdFinderLiveSubscriptionClick button is clicked");
    if ((paramView == null) || (paramView.getContext() == null) || (paramAdClickActionInfo == null))
    {
      AppMethodBeat.o(311413);
      return false;
    }
    com.tencent.mm.plugin.sns.ad.j.k.a((SnsAdClick)paramd.K("snsAdClick", null), 43);
    paramView = new com.tencent.mm.plugin.sns.ad.widget.b.c(paramView.getContext(), paramSnsInfo, new a(paramView.getContext(), paramAdClickActionInfo));
    if (paramView.QhR == null) {
      Log.w("SnsAd.SemiDialogManager", "the adapter is null , can't show dialog!!!");
    }
    for (;;)
    {
      paramInt = n.ajs(paramAdClickActionInfo.scene);
      com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.hm(n.aw(paramSnsInfo.getUxinfo(), t.x(paramSnsInfo), paramInt), paramAdClickActionInfo.finderUsername);
      AppMethodBeat.o(311413);
      return true;
      try
      {
        if (paramView.vlk == null)
        {
          paramView.mContentView = LayoutInflater.from(paramView.mContext).inflate(b.g.sns_bottom_subscribe_layout, null);
          if ((paramView.QhR != null) && (!TextUtils.isEmpty(paramView.QhR.hbv())))
          {
            paramd = (ImageView)paramView.mContentView.findViewById(b.f.we_app_icon);
            com.tencent.mm.plugin.sns.b.c.a(b.f.sns_ad_subscribe_url, paramView.QhR.hbv(), paramd);
          }
          if ((paramView.QhR != null) && (!TextUtils.isEmpty(paramView.QhR.hbw())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(b.f.we_app_title);
            if (paramd != null) {
              paramd.setText(paramView.QhR.hbw());
            }
          }
          if ((paramView.QhR != null) && (!TextUtils.isEmpty(paramView.QhR.hbx())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(b.f.subscribe_title);
            if (paramd != null) {
              paramd.setText(paramView.QhR.hbx());
            }
          }
          if ((paramView.QhR != null) && (!TextUtils.isEmpty(paramView.QhR.hby())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(b.f.subscribe_content);
            if (paramd != null) {
              paramd.setText(paramView.QhR.hby());
            }
          }
          if ((paramView.QhR != null) && (!TextUtils.isEmpty(paramView.QhR.hbz())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(b.f.subscribe);
            if (paramd != null)
            {
              paramd.setText(paramView.QhR.hbz());
              paramd.setOnClickListener(new c.2(paramView, paramView.QhR.hbA()));
            }
          }
          paramd = paramView.mContentView.findViewById(b.f.close);
          if (paramd != null) {
            paramd.setOnClickListener(new c.1(paramView));
          }
          paramView.vlk = new f(paramView.mContext, true, 0);
          paramView.vlk.af(paramView.mContentView, true);
          paramView.vlk.uR(true);
        }
        if ((paramView.vlk != null) && (!paramView.vlk.isShowing())) {
          paramView.vlk.dDn();
        }
      }
      finally {}
    }
  }
  
  static final class a
    implements com.tencent.mm.plugin.sns.ad.widget.b.a, com.tencent.mm.plugin.sns.ad.widget.b.b
  {
    AdClickActionInfo PYz;
    Context context;
    
    a(Context paramContext, AdClickActionInfo paramAdClickActionInfo)
    {
      this.context = paramContext;
      this.PYz = paramAdClickActionInfo;
    }
    
    public final boolean a(final com.tencent.mm.plugin.sns.ad.widget.b.c paramc, final View paramView, final SnsInfo paramSnsInfo)
    {
      final String str1 = null;
      AppMethodBeat.i(311417);
      if ((paramc == null) || (paramView == null) || (paramSnsInfo == null) || (this.PYz == null))
      {
        AppMethodBeat.o(311417);
        return false;
      }
      final Context localContext = paramView.getContext();
      if (localContext == null)
      {
        AppMethodBeat.o(311417);
        return false;
      }
      paramView = str1;
      if ((localContext instanceof Activity)) {
        paramView = com.tencent.mm.ui.base.k.a(localContext, localContext.getString(b.j.loading), true, null);
      }
      str1 = t.x(paramSnsInfo);
      final String str2 = this.PYz.finderUsername;
      final String str3 = this.PYz.PLN;
      com.tencent.mm.plugin.sns.ad.b.b.b(str1, str2, str3, new com.tencent.mm.plugin.sns.ad.b.b.a()
      {
        public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(311409);
          Log.i("SnsAd.AdFinderLiveNotice", "AdFinderLiveNoticeClick:: the out snsid is " + str1 + ", inner snsid = " + paramAnonymousString);
          if ((paramView != null) && (paramView.isShowing())) {
            paramView.dismiss();
          }
          if (paramAnonymousInt2 == 0) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.gR(paramAnonymousString, 513);
          }
          paramAnonymousObject = paramc;
          switch (paramAnonymousInt2)
          {
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.ad.b.b.aT(localContext, paramAnonymousInt2);
            SnsInfo localSnsInfo = paramSnsInfo;
            String str3 = str2;
            String str4 = str3;
            Object localObject = "";
            String str2 = "";
            String str1 = str2;
            paramAnonymousObject = localObject;
            if (localSnsInfo != null)
            {
              str1 = str2;
              paramAnonymousObject = localObject;
              if (localSnsInfo.getAdXml() != null)
              {
                paramAnonymousObject = localSnsInfo.getAdXml().adExtInfo;
                str1 = localSnsInfo.getUxinfo();
              }
            }
            localObject = new com.tencent.mm.plugin.sns.ad.b.a();
            ((com.tencent.mm.plugin.sns.ad.b.a)localObject).c(paramAnonymousString, str1, paramAnonymousObject, str3, str4, paramAnonymousInt2, 1);
            j.a((j.a)localObject);
            AppMethodBeat.o(311409);
            return;
            if (paramAnonymousObject != null) {
              paramAnonymousObject.dismiss();
            }
          }
        }
      });
      AppMethodBeat.o(311417);
      return true;
    }
    
    public final com.tencent.mm.plugin.sns.ad.widget.b.a hbA()
    {
      return this;
    }
    
    public final String hbv()
    {
      if (this.PYz != null) {
        return this.PYz.PLO;
      }
      return "";
    }
    
    public final String hbw()
    {
      if (this.PYz != null) {
        return this.PYz.finderNickName;
      }
      return "";
    }
    
    public final String hbx()
    {
      if (this.PYz != null) {
        return this.PYz.PLP;
      }
      return null;
    }
    
    public final String hby()
    {
      return "预约成功后，在活动开始前以服务通知的形式，提醒您准时参与";
    }
    
    public final String hbz()
    {
      return "预约直播";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */
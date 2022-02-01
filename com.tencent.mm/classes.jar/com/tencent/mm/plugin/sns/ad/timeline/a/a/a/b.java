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
import com.tencent.mm.plugin.sns.ad.d.l;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.i.j.a;
import com.tencent.mm.plugin.sns.ad.i.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.ad.widget.b.c.1;
import com.tencent.mm.plugin.sns.ad.widget.b.c.2;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.e;

public final class b
  extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, AdClickActionInfo paramAdClickActionInfo, d paramd)
  {
    AppMethodBeat.i(267358);
    Log.d("SnsAd.AdFinderLiveNotice", "the AdFinderLiveSubscriptionClick button is clicked");
    if ((paramView == null) || (paramView.getContext() == null) || (paramAdClickActionInfo == null))
    {
      AppMethodBeat.o(267358);
      return false;
    }
    k.a((SnsAdClick)paramd.y("snsAdClick", null), 43);
    paramView = new com.tencent.mm.plugin.sns.ad.widget.b.c(paramView.getContext(), paramSnsInfo, new a(paramView.getContext(), paramAdClickActionInfo));
    if (paramView.JNr == null) {
      Log.w("SnsAd.SemiDialogManager", "the adapter is null , can't show dialog!!!");
    }
    for (;;)
    {
      paramInt = l.aeJ(paramAdClickActionInfo.scene);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.gF(l.an(paramSnsInfo.getUxinfo(), t.w(paramSnsInfo), paramInt), paramAdClickActionInfo.finderUsername);
      AppMethodBeat.o(267358);
      return true;
      try
      {
        if (paramView.rZT == null)
        {
          paramView.mContentView = LayoutInflater.from(paramView.mContext).inflate(i.g.sns_bottom_subscribe_layout, null);
          if ((paramView.JNr != null) && (!TextUtils.isEmpty(paramView.JNr.fLe())))
          {
            paramd = (ImageView)paramView.mContentView.findViewById(i.f.we_app_icon);
            com.tencent.mm.plugin.sns.a.c.a(i.f.sns_ad_subscribe_url, paramView.JNr.fLe(), paramd);
          }
          if ((paramView.JNr != null) && (!TextUtils.isEmpty(paramView.JNr.fLf())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(i.f.we_app_title);
            if (paramd != null) {
              paramd.setText(paramView.JNr.fLf());
            }
          }
          if ((paramView.JNr != null) && (!TextUtils.isEmpty(paramView.JNr.fLg())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(i.f.subscribe_title);
            if (paramd != null) {
              paramd.setText(paramView.JNr.fLg());
            }
          }
          if ((paramView.JNr != null) && (!TextUtils.isEmpty(paramView.JNr.fLh())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(i.f.subscribe_content);
            if (paramd != null) {
              paramd.setText(paramView.JNr.fLh());
            }
          }
          if ((paramView.JNr != null) && (!TextUtils.isEmpty(paramView.JNr.fLi())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(i.f.subscribe);
            if (paramd != null)
            {
              paramd.setText(paramView.JNr.fLi());
              paramd.setOnClickListener(new c.2(paramView, paramView.JNr.fLj()));
            }
          }
          paramd = paramView.mContentView.findViewById(i.f.close);
          if (paramd != null) {
            paramd.setOnClickListener(new c.1(paramView));
          }
          paramView.rZT = new e(paramView.mContext, true, 0);
          paramView.rZT.Z(paramView.mContentView, true);
          paramView.rZT.rn(true);
        }
        if ((paramView.rZT != null) && (!paramView.rZT.isShowing())) {
          paramView.rZT.eik();
        }
      }
      catch (Throwable paramView) {}
    }
  }
  
  static final class a
    implements com.tencent.mm.plugin.sns.ad.widget.b.a, com.tencent.mm.plugin.sns.ad.widget.b.b
  {
    AdClickActionInfo JHz;
    Context context;
    
    a(Context paramContext, AdClickActionInfo paramAdClickActionInfo)
    {
      this.context = paramContext;
      this.JHz = paramAdClickActionInfo;
    }
    
    public final boolean a(final com.tencent.mm.plugin.sns.ad.widget.b.c paramc, final View paramView, final SnsInfo paramSnsInfo)
    {
      final String str1 = null;
      AppMethodBeat.i(217101);
      if ((paramc == null) || (paramView == null) || (paramSnsInfo == null) || (this.JHz == null))
      {
        AppMethodBeat.o(217101);
        return false;
      }
      final Context localContext = paramView.getContext();
      if (localContext == null)
      {
        AppMethodBeat.o(217101);
        return false;
      }
      paramView = str1;
      if ((localContext instanceof Activity)) {
        paramView = h.a(localContext, localContext.getString(i.j.loading), true, null);
      }
      str1 = t.w(paramSnsInfo);
      final String str2 = this.JHz.finderUsername;
      final String str3 = this.JHz.JxY;
      com.tencent.mm.plugin.sns.ad.b.b.b(str1, str2, str3, new com.tencent.mm.plugin.sns.ad.b.b.a()
      {
        public final void b(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
        {
          AppMethodBeat.i(225289);
          Log.i("SnsAd.AdFinderLiveNotice", "AdFinderLiveNoticeClick:: the out snsid is " + str1 + ", inner snsid = " + paramAnonymousString);
          if ((paramView != null) && (paramView.isShowing())) {
            paramView.dismiss();
          }
          if (paramAnonymousInt2 == 0) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.fY(paramAnonymousString, 513);
          }
          paramAnonymousObject = paramc;
          switch (paramAnonymousInt2)
          {
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.ad.b.b.aG(localContext, paramAnonymousInt2);
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
            AppMethodBeat.o(225289);
            return;
            if (paramAnonymousObject != null) {
              paramAnonymousObject.dismiss();
            }
          }
        }
      });
      AppMethodBeat.o(217101);
      return true;
    }
    
    public final String fLe()
    {
      if (this.JHz != null) {
        return this.JHz.JxZ;
      }
      return "";
    }
    
    public final String fLf()
    {
      if (this.JHz != null) {
        return this.JHz.Jya;
      }
      return "";
    }
    
    public final String fLg()
    {
      if (this.JHz != null) {
        return this.JHz.Jyb;
      }
      return null;
    }
    
    public final String fLh()
    {
      return "预约成功后，在活动开始前以服务通知的形式，提醒您准时参与";
    }
    
    public final String fLi()
    {
      return "预约直播";
    }
    
    public final com.tencent.mm.plugin.sns.ad.widget.b.a fLj()
    {
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */
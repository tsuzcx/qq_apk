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
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.ad.i.i.a;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.ad.widget.b.c.1;
import com.tencent.mm.plugin.sns.ad.widget.b.c.2;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.e;

public final class b
  extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml.AdCardActionBtnInfo paramAdCardActionBtnInfo, d paramd)
  {
    AppMethodBeat.i(202097);
    Log.d("SnsAd.AdFinderLiveNotice", "the AdFinderLiveSubscriptionClick button is clicked");
    if ((paramView == null) || (paramView.getContext() == null) || (paramAdCardActionBtnInfo == null))
    {
      AppMethodBeat.o(202097);
      return false;
    }
    j.a((SnsAdClick)paramd.z("snsAdClick", null), 43);
    paramView = new com.tencent.mm.plugin.sns.ad.widget.b.c(paramView.getContext(), paramSnsInfo, new a(paramView.getContext(), paramAdCardActionBtnInfo));
    if (paramView.DBG == null) {
      Log.w("SnsAd.SemiDialogManager", "the adapter is null , can't show dialog!!!");
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.gr(com.tencent.mm.plugin.sns.ad.e.h.jU(paramSnsInfo.getUxinfo(), r.v(paramSnsInfo)), paramAdCardActionBtnInfo.finderUsername);
      AppMethodBeat.o(202097);
      return true;
      try
      {
        if (paramView.oXS == null)
        {
          paramView.mContentView = LayoutInflater.from(paramView.mContext).inflate(2131496418, null);
          if ((paramView.DBG != null) && (!TextUtils.isEmpty(paramView.DBG.eXB())))
          {
            paramd = (ImageView)paramView.mContentView.findViewById(2131310360);
            com.tencent.mm.plugin.sns.a.c.k(paramView.DBG.eXB(), paramd);
          }
          if ((paramView.DBG != null) && (!TextUtils.isEmpty(paramView.DBG.eXC())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(2131310361);
            if (paramd != null) {
              paramd.setText(paramView.DBG.eXC());
            }
          }
          if ((paramView.DBG != null) && (!TextUtils.isEmpty(paramView.DBG.eXD())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(2131308744);
            if (paramd != null) {
              paramd.setText(paramView.DBG.eXD());
            }
          }
          if ((paramView.DBG != null) && (!TextUtils.isEmpty(paramView.DBG.eXE())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(2131308737);
            if (paramd != null) {
              paramd.setText(paramView.DBG.eXE());
            }
          }
          if ((paramView.DBG != null) && (!TextUtils.isEmpty(paramView.DBG.eXF())))
          {
            paramd = (TextView)paramView.mContentView.findViewById(2131308733);
            if (paramd != null)
            {
              paramd.setText(paramView.DBG.eXF());
              paramd.setOnClickListener(new c.2(paramView, paramView.DBG.eXG()));
            }
          }
          paramd = paramView.mContentView.findViewById(2131298763);
          if (paramd != null) {
            paramd.setOnClickListener(new c.1(paramView));
          }
          paramView.oXS = new e(paramView.mContext, true, 0);
          paramView.oXS.V(paramView.mContentView, true);
          paramView.oXS.Dm(true);
        }
        if ((paramView.oXS != null) && (!paramView.oXS.isShowing())) {
          paramView.oXS.dGm();
        }
      }
      catch (Throwable paramView) {}
    }
  }
  
  static final class a
    implements com.tencent.mm.plugin.sns.ad.widget.b.a, com.tencent.mm.plugin.sns.ad.widget.b.b
  {
    ADXml.AdCardActionBtnInfo DxE;
    Context context;
    
    a(Context paramContext, ADXml.AdCardActionBtnInfo paramAdCardActionBtnInfo)
    {
      this.context = paramContext;
      this.DxE = paramAdCardActionBtnInfo;
    }
    
    public final boolean a(final com.tencent.mm.plugin.sns.ad.widget.b.c paramc, final View paramView, final SnsInfo paramSnsInfo)
    {
      final String str1 = null;
      AppMethodBeat.i(202096);
      if ((paramc == null) || (paramView == null) || (paramSnsInfo == null) || (this.DxE == null))
      {
        AppMethodBeat.o(202096);
        return false;
      }
      final Context localContext = paramView.getContext();
      if (localContext == null)
      {
        AppMethodBeat.o(202096);
        return false;
      }
      paramView = str1;
      if ((localContext instanceof Activity)) {
        paramView = com.tencent.mm.ui.base.h.a(localContext, localContext.getString(2131762443), true, null);
      }
      str1 = r.v(paramSnsInfo);
      final String str2 = this.DxE.finderUsername;
      final String str3 = this.DxE.finderLiveNoticeId;
      com.tencent.mm.plugin.sns.ad.c.b.b(str1, str2, str3, new com.tencent.mm.plugin.sns.ad.c.b.a()
      {
        public final void b(String paramAnonymousString, int paramAnonymousInt, Object paramAnonymousObject)
        {
          AppMethodBeat.i(202095);
          Log.i("SnsAd.AdFinderLiveNotice", "AdFinderLiveNoticeClick:: the out snsid is " + str1 + ", inner snsid = " + paramAnonymousString);
          if ((paramView != null) && (paramView.isShowing())) {
            paramView.dismiss();
          }
          if (paramAnonymousInt == 0) {
            com.tencent.mm.plugin.sns.ad.widget.living.b.fv(paramAnonymousString, 513);
          }
          paramAnonymousObject = paramc;
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.ad.c.b.ao(localContext, paramAnonymousInt);
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
            localObject = new com.tencent.mm.plugin.sns.ad.c.a();
            ((com.tencent.mm.plugin.sns.ad.c.a)localObject).c(paramAnonymousString, str1, paramAnonymousObject, str3, str4, paramAnonymousInt, 1);
            i.a((i.a)localObject);
            AppMethodBeat.o(202095);
            return;
            if (paramAnonymousObject != null) {
              paramAnonymousObject.dismiss();
            }
          }
        }
      });
      AppMethodBeat.o(202096);
      return true;
    }
    
    public final String eXB()
    {
      if (this.DxE != null) {
        return this.DxE.finderAvatar;
      }
      return "";
    }
    
    public final String eXC()
    {
      if (this.DxE != null) {
        return this.DxE.finderNickName;
      }
      return "";
    }
    
    public final String eXD()
    {
      if (this.DxE != null) {
        return this.DxE.finderLiveTitle;
      }
      return null;
    }
    
    public final String eXE()
    {
      return "预约成功后，在活动开始前以服务通知的形式，提醒您准时参与";
    }
    
    public final String eXF()
    {
      return "预约直播";
    }
    
    public final com.tencent.mm.plugin.sns.ad.widget.b.a eXG()
    {
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */
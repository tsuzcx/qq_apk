package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.c;
import com.tencent.mm.plugin.sns.ad.h.b;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;

public final class a
  extends com.tencent.mm.plugin.sns.ad.timeline.a.a.a
{
  public final boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, ADXml.AdCardActionBtnInfo paramAdCardActionBtnInfo, d paramd)
  {
    AppMethodBeat.i(202094);
    if ((paramAdCardActionBtnInfo == null) || (paramSnsInfo == null))
    {
      AppMethodBeat.o(202094);
      return false;
    }
    j.a((SnsAdClick)paramd.z("snsAdClick", null), 42);
    paramView = new b(paramView.getContext(), paramSnsInfo);
    if (paramView.oXS == null)
    {
      paramView.mContentView = LayoutInflater.from(paramView.mContext).inflate(2131496418, null);
      paramSnsInfo = paramView.mContentView.findViewById(2131298763);
      paramd = (TextView)paramView.mContentView.findViewById(2131308733);
      paramView.Dxx = ((ImageView)paramView.mContentView.findViewById(2131310360));
      paramView.Dxy = ((TextView)paramView.mContentView.findViewById(2131310361));
      paramView.Dxz = ((TextView)paramView.mContentView.findViewById(2131308744));
      paramView.DxA = ((TextView)paramView.mContentView.findViewById(2131308737));
      if (paramSnsInfo != null) {
        paramSnsInfo.setOnClickListener(new a.b.1(paramView));
      }
      if (paramd != null)
      {
        paramd.setText(2131765943);
        paramd.setOnClickListener(new a.b.2(paramView));
      }
      paramView.oXS = new e(paramView.mContext, true, 0);
      paramView.oXS.V(paramView.mContentView, true);
      paramView.oXS.Dm(true);
    }
    if (paramAdCardActionBtnInfo != null)
    {
      if (paramView.Dxy != null) {
        paramView.Dxy.setText(paramAdCardActionBtnInfo.couponSenderName);
      }
      if (paramView.Dxz != null) {
        paramView.Dxz.setText(paramAdCardActionBtnInfo.couponName);
      }
      if (paramView.DxA != null) {
        paramView.DxA.setText(paramAdCardActionBtnInfo.couponDesc);
      }
      c.k(paramAdCardActionBtnInfo.couponSenderPhoto, paramView.Dxx);
    }
    if (!paramView.oXS.isShowing()) {
      paramView.oXS.dGm();
    }
    AppMethodBeat.o(202094);
    return true;
  }
  
  public static final class a
    extends com.tencent.mm.plugin.sns.ad.landingpage.component.a.a.a
  {
    public a(SnsInfo paramSnsInfo, int paramInt, String paramString)
    {
      super(paramString);
      AppMethodBeat.i(202087);
      this.source = 1;
      if (paramSnsInfo != null)
      {
        this.uxInfo = Util.nullAsNil(paramSnsInfo.getUxinfo());
        this.dRS = r.v(paramSnsInfo);
        if (paramSnsInfo.getAdXml() != null)
        {
          this.adExtInfo = Util.nullAsNil(paramSnsInfo.getAdXml().adExtInfo);
          paramSnsInfo = paramSnsInfo.getAdXml().adCardActionBtnInfo;
          if (paramSnsInfo != null)
          {
            this.appId = Util.nullAsNil(paramSnsInfo.couponAppId);
            this.gTp = Util.nullAsNil(paramSnsInfo.couponStockId);
          }
        }
      }
      AppMethodBeat.o(202087);
    }
  }
  
  public static final class b
    implements com.tencent.mm.ak.i
  {
    private SnsInfo DqO;
    TextView DxA;
    com.tencent.mm.ui.base.q DxB = null;
    ImageView Dxx;
    TextView Dxy;
    TextView Dxz;
    View mContentView;
    Context mContext;
    e oXS;
    
    b(Context paramContext, SnsInfo paramSnsInfo)
    {
      this.mContext = paramContext;
      this.DqO = paramSnsInfo;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(202093);
      try
      {
        com.tencent.f.h.RTc.aV(new a.b.3(this));
        g.azz().b(4743, this);
        int i = -1;
        if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof b)))
        {
          paramString = (bvk)((b)paramq).eXx();
          if (paramString == null) {
            break label165;
          }
          paramInt1 = paramString.ret;
          paramString = Util.nullAsNil(paramString.msg);
        }
        for (;;)
        {
          Log.d("SnsAd.AdCoupon", "the coupon result is ".concat(String.valueOf(paramInt1)));
          com.tencent.f.h.RTc.aV(new a.b.4(this, paramInt1, paramString));
          com.tencent.mm.plugin.sns.ad.i.i.a(new a.a(this.DqO, paramInt1, paramString));
          AppMethodBeat.o(202093);
          return;
          Log.w("SnsAd.AdCoupon", "the coupon errType is " + paramInt1 + ", errCode is " + paramInt2);
          label165:
          paramString = "";
          paramInt1 = i;
        }
        return;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(202093);
      }
    }
    
    final void sendRequest()
    {
      AppMethodBeat.i(202092);
      SnsInfo localSnsInfo = this.DqO;
      Object localObject;
      if ((localSnsInfo == null) || (localSnsInfo.getAdXml() == null)) {
        localObject = null;
      }
      while (localObject != null)
      {
        localObject = new b(((ADXml.AdCardActionBtnInfo)localObject).couponAppId, ((ADXml.AdCardActionBtnInfo)localObject).couponStockId, localSnsInfo.getUxinfo(), "");
        g.azz().a(4743, this);
        g.azz().a((com.tencent.mm.ak.q)localObject, 0);
        if (this.DxB == null)
        {
          this.DxB = com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131762443), true, null);
          AppMethodBeat.o(202092);
          return;
          localObject = localSnsInfo.getAdXml().adCardActionBtnInfo;
        }
        else if (!this.DxB.isShowing())
        {
          this.DxB.show();
        }
      }
      AppMethodBeat.o(202092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */
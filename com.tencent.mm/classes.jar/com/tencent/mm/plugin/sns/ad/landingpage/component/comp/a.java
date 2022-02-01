package com.tencent.mm.plugin.sns.ad.landingpage.component.comp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.ad.j.j.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r
{
  com.tencent.mm.plugin.sns.ad.landingpage.component.info.a PPC;
  private w PPD;
  
  public a(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.info.a parama, ViewGroup paramViewGroup)
  {
    super(paramContext, parama, paramViewGroup);
    AppMethodBeat.i(310698);
    this.PPC = parama;
    try
    {
      if ((this.QPl != null) && (this.PPC != null))
      {
        this.QPl.mx("appId", this.PPC.PLH);
        this.QPl.mx("stockId", this.PPC.PLI);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(310698);
    }
  }
  
  private void cZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(310714);
    String str;
    int i;
    if (paramInt == 0)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.context.getString(b.j.sns_ad_coupon_success);
      }
      aa.db(this.context, str);
      if (this.PPC == null)
      {
        paramString = null;
        if (paramString == null) {
          break label405;
        }
        i = paramString.PLm;
        paramInt = paramString.PLm;
        if (paramInt != 15) {
          break label146;
        }
        paramString = new Intent();
        paramString.putExtra("title", this.context.getString(b.j.sns_ad_coupon_title_of_card_package));
        com.tencent.mm.br.c.b(this.context, "card", ".ui.v4.CouponAndGiftCardListV4UI", paramString);
        paramInt = 1;
        label108:
        if (paramInt != 0) {
          break label461;
        }
        paramInt = -1;
      }
    }
    for (;;)
    {
      j.a(new a(this, 0, str, paramInt));
      AppMethodBeat.o(310714);
      return;
      paramString = this.PPC.PRP;
      break;
      label146:
      Object localObject;
      if (paramInt == 4)
      {
        localObject = AdLandingPagesProxy.getInstance().getSelfUserName();
        localObject = hjn().getSnsId() + ":" + hjn().uxInfo + ":" + (String)localObject + ":" + System.currentTimeMillis();
        boolean bool = AdLandingPagesProxy.getInstance().isWeAppAppendClickTime(hjn().getSnsId(), hjn().source);
        paramString.nUS = m.cW(paramString.nUS, bool);
        t.a(paramString.xVm, paramString.nUS, paramString.nUT, hjn().aid, hjn().qTb, (String)localObject, hjn().uxInfo, 1084);
        paramInt = 1;
        break label108;
      }
      if ((paramInt == 0) && (!com.tencent.matrix.trace.f.c.hm(paramString.PLn)))
      {
        localObject = ((SnsAdNativeLandingPagesUI)this.context).getIntent();
        if (localObject != null)
        {
          long l = com.tencent.mm.plugin.sns.storage.ai.aXe(((Intent)localObject).getStringExtra("sns_landing_pages_share_sns_id"));
          paramInt = ((Intent)localObject).getIntExtra("sns_landig_pages_from_source", 0);
          paramString = paramString.PLn;
          m.a(this.context, paramString, hjn(), paramInt, l, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV).QKG);
          paramInt = 1;
          break label108;
        }
      }
      paramInt = 0;
      break label108;
      label405:
      paramInt = -1;
      continue;
      j.a(new a(this, paramInt, paramString, -1));
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.context.getString(b.j.sns_ad_coupon_error);
      }
      aa.dc(this.context, str);
      AppMethodBeat.o(310714);
      return;
      label461:
      paramInt = i;
    }
  }
  
  public final void hac()
  {
    AppMethodBeat.i(310737);
    try
    {
      Object localObject1 = new com.tencent.mm.plugin.sns.ad.remote.a();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).PXU = new c();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).PXT = new b(this);
      com.tencent.mm.plugin.sns.ad.remote.ipc.a locala = ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).hbq();
      if (locala != null)
      {
        if ((this.context instanceof Activity))
        {
          localObject1 = (Activity)this.context;
          if ((!((Activity)localObject1).isFinishing()) && (!((Activity)localObject1).isDestroyed()))
          {
            if (this.PPD == null) {
              this.PPD = com.tencent.mm.plugin.sns.ad.landingpage.a.a.aU(this.context, b.j.sns_ad_landing_coupon_loading);
            }
            if ((this.PPD != null) && (!this.PPD.isShowing())) {
              this.PPD.show();
            }
          }
        }
        localObject1 = this.PPC;
        Object localObject3;
        if (localObject1 == null) {
          localObject3 = null;
        }
        for (;;)
        {
          locala.aX((Bundle)localObject3);
          AppMethodBeat.o(310737);
          return;
          Bundle localBundle = new Bundle();
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.landingpage.component.info.a)localObject1).PLH)) {
            localBundle.putString("COUPON_APP_ID", ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.a)localObject1).PLH);
          }
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.landingpage.component.info.a)localObject1).PLI)) {
            localBundle.putString("COUPON_STOCK_ID", ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.a)localObject1).PLI);
          }
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.landingpage.component.info.a)localObject1).QKG)) {
            localBundle.putString("COMP_ID", ((com.tencent.mm.plugin.sns.ad.landingpage.component.info.a)localObject1).QKG);
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai localai = hjn();
          localObject3 = localBundle;
          if (localai != null)
          {
            localObject3 = localai.hiC();
            localObject1 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject1 = localai.uxInfo;
            }
            localObject3 = localBundle;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localBundle.putString("UX_INFO", (String)localObject1);
              localObject3 = localBundle;
            }
          }
        }
      }
      Log.e("SnsAd.CouponCardBtnComp", "the ipc request object is null, please check the log to find the reason!");
    }
    finally
    {
      AppMethodBeat.o(310737);
      return;
    }
    AppMethodBeat.o(310737);
  }
  
  public static class a
    implements j.a
  {
    protected int actionType;
    protected String adExtInfo;
    protected String appId;
    protected String hQX;
    protected String mdN;
    protected String msg;
    protected int result;
    protected int source;
    protected String uxInfo;
    
    protected a(int paramInt, String paramString)
    {
      AppMethodBeat.i(310768);
      this.actionType = -1;
      this.result = paramInt;
      this.msg = Util.nullAs(paramString, "");
      AppMethodBeat.o(310768);
    }
    
    protected a(a parama, int paramInt1, String paramString, int paramInt2)
    {
      AppMethodBeat.i(310785);
      this.actionType = -1;
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai localai = parama.hjn();
      if (localai != null)
      {
        this.hQX = aWu(localai.getSnsId());
        this.adExtInfo = Util.nullAs(localai.adExtInfo, "");
        this.uxInfo = Util.nullAs(localai.hiC(), "");
        if (TextUtils.isEmpty(this.uxInfo)) {
          this.uxInfo = Util.nullAs(localai.uxInfo, "");
        }
      }
      parama = parama.PPC;
      if (parama != null)
      {
        this.appId = parama.PLH;
        this.mdN = parama.PLI;
      }
      this.source = 0;
      this.result = paramInt1;
      this.msg = Util.nullAs(paramString, "");
      this.actionType = paramInt2;
      AppMethodBeat.o(310785);
    }
    
    private static String aWu(String paramString)
    {
      AppMethodBeat.i(310775);
      try
      {
        paramString = t.uA(m.aXe(paramString));
        return paramString;
      }
      finally
      {
        AppMethodBeat.o(310775);
      }
      return "";
    }
    
    public final String gZE()
    {
      return "sns_ad_native_landing_page_coupon";
    }
    
    /* Error */
    public final String getContent()
    {
      // Byte code:
      //   0: ldc 119
      //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 121	org/json/JSONObject
      //   8: dup
      //   9: invokespecial 122	org/json/JSONObject:<init>	()V
      //   12: astore_1
      //   13: aload_1
      //   14: ldc 124
      //   16: aload_0
      //   17: getfield 68	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/a$a:hQX	Ljava/lang/String;
      //   20: invokevirtual 128	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   23: pop
      //   24: aload_1
      //   25: ldc 130
      //   27: aload_0
      //   28: getfield 76	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/a$a:uxInfo	Ljava/lang/String;
      //   31: invokevirtual 128	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   34: pop
      //   35: aload_1
      //   36: ldc 131
      //   38: aload_0
      //   39: getfield 71	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/a$a:adExtInfo	Ljava/lang/String;
      //   42: invokevirtual 128	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   45: pop
      //   46: new 121	org/json/JSONObject
      //   49: dup
      //   50: invokespecial 122	org/json/JSONObject:<init>	()V
      //   53: astore_2
      //   54: aload_1
      //   55: ldc 133
      //   57: aload_2
      //   58: invokevirtual 128	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   61: pop
      //   62: aload_2
      //   63: ldc 134
      //   65: aload_0
      //   66: getfield 94	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/a$a:appId	Ljava/lang/String;
      //   69: invokevirtual 128	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   72: pop
      //   73: aload_2
      //   74: ldc 136
      //   76: aload_0
      //   77: getfield 99	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/a$a:mdN	Ljava/lang/String;
      //   80: invokevirtual 128	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   83: pop
      //   84: aload_2
      //   85: ldc 137
      //   87: aload_0
      //   88: getfield 36	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/a$a:result	I
      //   91: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   94: invokevirtual 128	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   97: pop
      //   98: aload_2
      //   99: ldc 144
      //   101: aload_0
      //   102: getfield 46	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/a$a:msg	Ljava/lang/String;
      //   105: invokevirtual 128	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   108: pop
      //   109: aload_2
      //   110: ldc 145
      //   112: aload_0
      //   113: getfield 101	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/a$a:source	I
      //   116: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   119: invokevirtual 128	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   122: pop
      //   123: aload_2
      //   124: ldc 146
      //   126: aload_0
      //   127: getfield 34	com/tencent/mm/plugin/sns/ad/landingpage/component/comp/a$a:actionType	I
      //   130: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   133: invokevirtual 128	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   136: pop
      //   137: aload_1
      //   138: invokevirtual 149	org/json/JSONObject:toString	()Ljava/lang/String;
      //   141: astore_1
      //   142: ldc 119
      //   144: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   147: aload_1
      //   148: areturn
      //   149: astore_2
      //   150: goto -13 -> 137
      //   153: astore_2
      //   154: goto -17 -> 137
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	157	0	this	a
      //   12	136	1	localObject1	Object
      //   53	71	2	localJSONObject	org.json.JSONObject
      //   149	1	2	localObject2	Object
      //   153	1	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   13	62	149	finally
      //   62	137	153	finally
    }
  }
  
  static final class b
    implements com.tencent.mm.plugin.sns.ad.remote.a.a
  {
    WeakReference<a> PPE;
    
    b(a parama)
    {
      AppMethodBeat.i(310763);
      this.PPE = new WeakReference(parama);
      AppMethodBeat.o(310763);
    }
    
    @com.tencent.mm.plugin.sns.ad.remote.b
    public final void aW(Bundle paramBundle)
    {
      AppMethodBeat.i(310780);
      Log.d("SnsAd.CouponCardBtnComp", "the onCallbackFromServer running!");
      try
      {
        Object localObject = this.PPE;
        if (localObject != null)
        {
          localObject = (a)((Reference)localObject).get();
          if (localObject != null) {
            a.a((a)localObject, paramBundle);
          }
        }
        AppMethodBeat.o(310780);
        return;
      }
      finally
      {
        Log.d("SnsAd.CouponCardBtnComp", "there is something wrong in client!");
        AppMethodBeat.o(310780);
      }
    }
  }
  
  public static final class c
    implements com.tencent.mm.am.h, com.tencent.mm.plugin.sns.ad.remote.a.b
  {
    com.tencent.mm.plugin.sns.ad.remote.ipc.b PPF;
    
    public final Bundle a(com.tencent.mm.plugin.sns.ad.remote.ipc.b paramb, Bundle paramBundle)
    {
      AppMethodBeat.i(310765);
      try
      {
        String str1 = com.tencent.mm.plugin.sns.ad.j.h.getString(paramBundle, "COUPON_APP_ID");
        String str2 = com.tencent.mm.plugin.sns.ad.j.h.getString(paramBundle, "COUPON_STOCK_ID");
        String str3 = com.tencent.mm.plugin.sns.ad.j.h.getString(paramBundle, "COMP_ID");
        paramBundle = com.tencent.mm.plugin.sns.ad.j.h.getString(paramBundle, "UX_INFO");
        this.PPF = paramb;
        long l = System.currentTimeMillis();
        com.tencent.mm.kernel.h.aZW().a(4743, this);
        com.tencent.mm.kernel.h.aZW().a(new com.tencent.mm.plugin.sns.ad.h.c(str1, str2, paramBundle, str3), 0);
        Log.d("SnsAd.CouponCardBtnComp", "CouponRemoteCall::the onServerCall is end, take time: " + (System.currentTimeMillis() - l) + " ms");
        AppMethodBeat.o(310765);
        return null;
      }
      finally
      {
        for (;;)
        {
          Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onServerCall has something invalid!");
        }
      }
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(310778);
      for (;;)
      {
        try
        {
          paramString = new Bundle();
          com.tencent.mm.kernel.h.aZW().b(4743, this);
          if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof com.tencent.mm.plugin.sns.ad.h.c)))
          {
            paramp = (cso)((com.tencent.mm.plugin.sns.ad.h.c)paramp).hbp();
            if (paramp != null)
            {
              paramString.putInt("ret", paramp.ret);
              if (!TextUtils.isEmpty(paramp.msg)) {
                paramString.putString("msg", paramp.msg);
              }
              if (this.PPF != null) {
                this.PPF.aY(paramString);
              }
              AppMethodBeat.o(310778);
              return;
            }
            Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onSceneEnd, the response is null!!!!");
            paramString.putInt("call_ipc_result_key", -1);
            continue;
          }
          Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onSceneEnd is return error errType is " + paramInt1 + ", the error code is " + paramInt2);
        }
        finally
        {
          Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onSceneEnd has something invalid!");
          AppMethodBeat.o(310778);
          return;
        }
        paramString.putInt("call_ipc_result_key", -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.comp.a
 * JD-Core Version:    0.7.0.1
 */
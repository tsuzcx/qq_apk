package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.plugin.sns.ad.i.j.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
{
  com.tencent.mm.plugin.sns.ad.landingpage.component.b.a JAb;
  private s JAc;
  
  public a(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.a parama, ViewGroup paramViewGroup)
  {
    super(paramContext, parama, paramViewGroup);
    AppMethodBeat.i(225010);
    this.JAb = parama;
    try
    {
      if ((this.KqQ != null) && (this.JAb != null))
      {
        this.KqQ.kQ("appId", this.JAb.JxS);
        this.KqQ.kQ("stockId", this.JAb.JxT);
      }
      AppMethodBeat.o(225010);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(225010);
    }
  }
  
  private void co(int paramInt, String paramString)
  {
    AppMethodBeat.i(225019);
    if (paramInt == 0)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.context.getString(i.j.sns_ad_coupon_success);
      }
      w.cR(this.context, str);
      AppMethodBeat.o(225019);
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.context.getString(i.j.sns_ad_coupon_error);
    }
    w.cS(this.context, str);
    AppMethodBeat.o(225019);
  }
  
  public final void fKd()
  {
    AppMethodBeat.i(225016);
    try
    {
      Object localObject1 = new com.tencent.mm.plugin.sns.ad.remote.a();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).JGU = new c();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).JGT = new b(this);
      com.tencent.mm.plugin.sns.ad.remote.ipc.a locala = ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).fKZ();
      if (locala != null)
      {
        if ((this.context instanceof Activity))
        {
          localObject1 = (Activity)this.context;
          if ((!((Activity)localObject1).isFinishing()) && (!((Activity)localObject1).isDestroyed()))
          {
            if (this.JAc == null) {
              this.JAc = com.tencent.mm.plugin.sns.ad.landingpage.a.a.aH(this.context, i.j.sns_ad_landing_coupon_loading);
            }
            if ((this.JAc != null) && (!this.JAc.isShowing())) {
              this.JAc.show();
            }
          }
        }
        localObject1 = this.JAb;
        Object localObject2;
        if (localObject1 == null) {
          localObject2 = null;
        }
        for (;;)
        {
          locala.aw((Bundle)localObject2);
          AppMethodBeat.o(225016);
          return;
          Bundle localBundle = new Bundle();
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).JxS)) {
            localBundle.putString("COUPON_APP_ID", ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).JxS);
          }
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).JxT)) {
            localBundle.putString("COUPON_STOCK_ID", ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).JxT);
          }
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).KmB)) {
            localBundle.putString("COMP_ID", ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).KmB);
          }
          ai localai = fRp();
          localObject2 = localBundle;
          if (localai != null)
          {
            localObject2 = localai.fQE();
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = localai.uxInfo;
            }
            localObject2 = localBundle;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localBundle.putString("UX_INFO", (String)localObject1);
              localObject2 = localBundle;
            }
          }
        }
      }
      Log.e("SnsAd.CouponCardBtnComp", "the ipc request object is null, please check the log to find the reason!");
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(225016);
      return;
    }
    AppMethodBeat.o(225016);
  }
  
  public static class a
    implements j.a
  {
    protected String adExtInfo;
    protected String appId;
    protected String fLp;
    protected String jDR;
    protected String msg;
    protected int result;
    protected int source;
    protected String uxInfo;
    
    protected a(int paramInt, String paramString)
    {
      AppMethodBeat.i(199332);
      this.result = paramInt;
      this.msg = Util.nullAs(paramString, "");
      AppMethodBeat.o(199332);
    }
    
    protected a(a parama, int paramInt, String paramString)
    {
      AppMethodBeat.i(199334);
      ai localai = parama.fRp();
      if (localai != null)
      {
        this.fLp = aYt(localai.getSnsId());
        this.adExtInfo = Util.nullAs(localai.adExtInfo, "");
        this.uxInfo = Util.nullAs(localai.fQE(), "");
        if (TextUtils.isEmpty(this.uxInfo)) {
          this.uxInfo = Util.nullAs(localai.uxInfo, "");
        }
      }
      parama = parama.JAb;
      if (parama != null)
      {
        this.appId = parama.JxS;
        this.jDR = parama.JxT;
      }
      this.source = 0;
      this.result = paramInt;
      this.msg = Util.nullAs(paramString, "");
      AppMethodBeat.o(199334);
    }
    
    private static String aYt(String paramString)
    {
      AppMethodBeat.i(199333);
      try
      {
        paramString = com.tencent.mm.plugin.sns.data.t.Qu(m.aYS(paramString));
        AppMethodBeat.o(199333);
        return paramString;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(199333);
      }
      return "";
    }
    
    public final String fJK()
    {
      return "sns_ad_native_landing_page_coupon";
    }
    
    /* Error */
    public final String getContent()
    {
      // Byte code:
      //   0: ldc 118
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 120	org/json/JSONObject
      //   8: dup
      //   9: invokespecial 121	org/json/JSONObject:<init>	()V
      //   12: astore_1
      //   13: aload_1
      //   14: ldc 123
      //   16: aload_0
      //   17: getfield 65	com/tencent/mm/plugin/sns/ad/landingpage/component/a/a$a:fLp	Ljava/lang/String;
      //   20: invokevirtual 127	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   23: pop
      //   24: aload_1
      //   25: ldc 129
      //   27: aload_0
      //   28: getfield 73	com/tencent/mm/plugin/sns/ad/landingpage/component/a/a$a:uxInfo	Ljava/lang/String;
      //   31: invokevirtual 127	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   34: pop
      //   35: aload_1
      //   36: ldc 130
      //   38: aload_0
      //   39: getfield 68	com/tencent/mm/plugin/sns/ad/landingpage/component/a/a$a:adExtInfo	Ljava/lang/String;
      //   42: invokevirtual 127	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   45: pop
      //   46: new 120	org/json/JSONObject
      //   49: dup
      //   50: invokespecial 121	org/json/JSONObject:<init>	()V
      //   53: astore_2
      //   54: aload_1
      //   55: ldc 132
      //   57: aload_2
      //   58: invokevirtual 127	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   61: pop
      //   62: aload_2
      //   63: ldc 133
      //   65: aload_0
      //   66: getfield 91	com/tencent/mm/plugin/sns/ad/landingpage/component/a/a$a:appId	Ljava/lang/String;
      //   69: invokevirtual 127	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   72: pop
      //   73: aload_2
      //   74: ldc 135
      //   76: aload_0
      //   77: getfield 96	com/tencent/mm/plugin/sns/ad/landingpage/component/a/a$a:jDR	Ljava/lang/String;
      //   80: invokevirtual 127	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   83: pop
      //   84: aload_2
      //   85: ldc 136
      //   87: aload_0
      //   88: getfield 33	com/tencent/mm/plugin/sns/ad/landingpage/component/a/a$a:result	I
      //   91: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   94: invokevirtual 127	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   97: pop
      //   98: aload_2
      //   99: ldc 143
      //   101: aload_0
      //   102: getfield 43	com/tencent/mm/plugin/sns/ad/landingpage/component/a/a$a:msg	Ljava/lang/String;
      //   105: invokevirtual 127	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   108: pop
      //   109: aload_2
      //   110: ldc 144
      //   112: aload_0
      //   113: getfield 98	com/tencent/mm/plugin/sns/ad/landingpage/component/a/a$a:source	I
      //   116: invokestatic 142	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   119: invokevirtual 127	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   122: pop
      //   123: aload_1
      //   124: invokevirtual 147	org/json/JSONObject:toString	()Ljava/lang/String;
      //   127: astore_1
      //   128: ldc 118
      //   130: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   133: aload_1
      //   134: areturn
      //   135: astore_2
      //   136: goto -13 -> 123
      //   139: astore_2
      //   140: goto -17 -> 123
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	143	0	this	a
      //   12	122	1	localObject	Object
      //   53	57	2	localJSONObject	org.json.JSONObject
      //   135	1	2	localThrowable1	Throwable
      //   139	1	2	localThrowable2	Throwable
      // Exception table:
      //   from	to	target	type
      //   13	62	135	java/lang/Throwable
      //   62	123	139	java/lang/Throwable
    }
  }
  
  static final class b
    implements com.tencent.mm.plugin.sns.ad.remote.a.a
  {
    WeakReference<a> JAd;
    
    b(a parama)
    {
      AppMethodBeat.i(238054);
      this.JAd = new WeakReference(parama);
      AppMethodBeat.o(238054);
    }
    
    @com.tencent.mm.plugin.sns.ad.remote.b
    public final void av(Bundle paramBundle)
    {
      AppMethodBeat.i(238057);
      Log.d("SnsAd.CouponCardBtnComp", "the onCallbackFromServer running!");
      try
      {
        Object localObject = this.JAd;
        if (localObject != null)
        {
          localObject = (a)((Reference)localObject).get();
          if (localObject != null) {
            a.a((a)localObject, paramBundle);
          }
        }
        AppMethodBeat.o(238057);
        return;
      }
      catch (Throwable paramBundle)
      {
        Log.d("SnsAd.CouponCardBtnComp", "there is something wrong in client!");
        AppMethodBeat.o(238057);
      }
    }
  }
  
  public static final class c
    implements i, com.tencent.mm.plugin.sns.ad.remote.a.b
  {
    com.tencent.mm.plugin.sns.ad.remote.ipc.b JAe;
    
    public final Bundle a(com.tencent.mm.plugin.sns.ad.remote.ipc.b paramb, Bundle paramBundle)
    {
      AppMethodBeat.i(211676);
      try
      {
        String str1 = com.tencent.mm.plugin.sns.ad.i.h.getString(paramBundle, "COUPON_APP_ID");
        String str2 = com.tencent.mm.plugin.sns.ad.i.h.getString(paramBundle, "COUPON_STOCK_ID");
        String str3 = com.tencent.mm.plugin.sns.ad.i.h.getString(paramBundle, "COMP_ID");
        paramBundle = com.tencent.mm.plugin.sns.ad.i.h.getString(paramBundle, "UX_INFO");
        this.JAe = paramb;
        long l = System.currentTimeMillis();
        com.tencent.mm.kernel.h.aGY().a(4743, this);
        com.tencent.mm.kernel.h.aGY().a(new com.tencent.mm.plugin.sns.ad.g.b(str1, str2, paramBundle, str3), 0);
        Log.d("SnsAd.CouponCardBtnComp", "CouponRemoteCall::the onServerCall is end, take time: " + (System.currentTimeMillis() - l) + " ms");
        AppMethodBeat.o(211676);
        return null;
      }
      catch (Throwable paramb)
      {
        for (;;)
        {
          Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onServerCall has something invalid!");
        }
      }
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(211677);
      for (;;)
      {
        try
        {
          paramString = new Bundle();
          com.tencent.mm.kernel.h.aGY().b(4743, this);
          if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof com.tencent.mm.plugin.sns.ad.g.b)))
          {
            paramq = (cdc)((com.tencent.mm.plugin.sns.ad.g.b)paramq).fKY();
            if (paramq != null)
            {
              paramString.putInt("ret", paramq.ret);
              if (!TextUtils.isEmpty(paramq.msg)) {
                paramString.putString("msg", paramq.msg);
              }
              if (this.JAe != null) {
                this.JAe.ax(paramString);
              }
              AppMethodBeat.o(211677);
              return;
            }
            Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onSceneEnd, the response is null!!!!");
            paramString.putInt("call_ipc_result_key", -1);
            continue;
          }
          Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onSceneEnd is return error errType is " + paramInt1 + ", the error code is " + paramInt2);
        }
        catch (Throwable paramString)
        {
          Log.e("SnsAd.CouponCardBtnComp", "CouponRemoteCall::onSceneEnd has something invalid!");
          AppMethodBeat.o(211677);
          return;
        }
        paramString.putInt("call_ipc_result_key", -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.a
 * JD-Core Version:    0.7.0.1
 */
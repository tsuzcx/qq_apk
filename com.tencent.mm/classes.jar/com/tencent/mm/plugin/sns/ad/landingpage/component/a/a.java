package com.tencent.mm.plugin.sns.ad.landingpage.component.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.sns.ad.i.i.a;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
{
  com.tencent.mm.plugin.sns.ad.landingpage.component.b.a Dtk;
  private com.tencent.mm.ui.base.q Dtl;
  
  public a(Context paramContext, com.tencent.mm.plugin.sns.ad.landingpage.component.b.a parama, ViewGroup paramViewGroup)
  {
    super(paramContext, parama, paramViewGroup);
    AppMethodBeat.i(201955);
    this.Dtk = parama;
    try
    {
      if ((this.Edn != null) && (this.Dtk != null))
      {
        this.Edn.kv("appId", this.Dtk.couponAppId);
        this.Edn.kv("stockId", this.Dtk.couponStockId);
      }
      AppMethodBeat.o(201955);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(201955);
    }
  }
  
  private void cp(int paramInt, String paramString)
  {
    AppMethodBeat.i(201957);
    if (paramInt == 0)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.context.getString(2131765945);
      }
      u.cG(this.context, str);
      AppMethodBeat.o(201957);
      return;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.context.getString(2131765944);
    }
    u.cH(this.context, str);
    AppMethodBeat.o(201957);
  }
  
  public final void eWS()
  {
    AppMethodBeat.i(201956);
    try
    {
      Object localObject1 = new com.tencent.mm.plugin.sns.ad.remote.a();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).Dxn = new c();
      ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).Dxm = new b(this);
      com.tencent.mm.plugin.sns.ad.remote.ipc.a locala = ((com.tencent.mm.plugin.sns.ad.remote.a)localObject1).eXy();
      if (locala != null)
      {
        if ((this.context instanceof Activity))
        {
          localObject1 = (Activity)this.context;
          if ((!((Activity)localObject1).isFinishing()) && (!((Activity)localObject1).isDestroyed()))
          {
            if (this.Dtl == null) {
              this.Dtl = com.tencent.mm.plugin.sns.ad.landingpage.a.a.ap(this.context, 2131765961);
            }
            if ((this.Dtl != null) && (!this.Dtl.isShowing())) {
              this.Dtl.show();
            }
          }
        }
        localObject1 = this.Dtk;
        Object localObject2;
        if (localObject1 == null) {
          localObject2 = null;
        }
        for (;;)
        {
          locala.aA((Bundle)localObject2);
          AppMethodBeat.o(201956);
          return;
          Bundle localBundle = new Bundle();
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).couponAppId)) {
            localBundle.putString("COUPON_APP_ID", ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).couponAppId);
          }
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).couponStockId)) {
            localBundle.putString("COUPON_STOCK_ID", ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).couponStockId);
          }
          if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).DZi)) {
            localBundle.putString("COMP_ID", ((com.tencent.mm.plugin.sns.ad.landingpage.component.b.a)localObject1).DZi);
          }
          ah localah = fds();
          localObject2 = localBundle;
          if (localah != null)
          {
            localObject2 = localah.DZW;
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = localah.uxInfo;
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
      AppMethodBeat.o(201956);
      return;
    }
    AppMethodBeat.o(201956);
  }
  
  public static class a
    implements i.a
  {
    protected String adExtInfo;
    protected String appId;
    protected String dRS;
    protected String gTp;
    protected String msg;
    protected int result;
    protected int source;
    protected String uxInfo;
    
    protected a(int paramInt, String paramString)
    {
      AppMethodBeat.i(201947);
      this.result = paramInt;
      this.msg = Util.nullAs(paramString, "");
      AppMethodBeat.o(201947);
    }
    
    protected a(a parama, int paramInt, String paramString)
    {
      AppMethodBeat.i(201949);
      ah localah = parama.fds();
      if (localah != null)
      {
        this.dRS = aNI(localah.getSnsId());
        this.adExtInfo = Util.nullAs(localah.adExtInfo, "");
        this.uxInfo = Util.nullAs(localah.DZW, "");
        if (TextUtils.isEmpty(this.uxInfo)) {
          this.uxInfo = Util.nullAs(localah.uxInfo, "");
        }
      }
      parama = parama.Dtk;
      if (parama != null)
      {
        this.appId = parama.couponAppId;
        this.gTp = parama.couponStockId;
      }
      this.source = 0;
      this.result = paramInt;
      this.msg = Util.nullAs(paramString, "");
      AppMethodBeat.o(201949);
    }
    
    private static String aNI(String paramString)
    {
      AppMethodBeat.i(201948);
      try
      {
        paramString = r.Jb(k.aOa(paramString));
        AppMethodBeat.o(201948);
        return paramString;
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(201948);
      }
      return "";
    }
    
    public final String eWH()
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
      //   17: getfield 65	com/tencent/mm/plugin/sns/ad/landingpage/component/a/a$a:dRS	Ljava/lang/String;
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
      //   77: getfield 96	com/tencent/mm/plugin/sns/ad/landingpage/component/a/a$a:gTp	Ljava/lang/String;
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
    WeakReference<a> Dtm;
    
    b(a parama)
    {
      AppMethodBeat.i(201951);
      this.Dtm = new WeakReference(parama);
      AppMethodBeat.o(201951);
    }
    
    @com.tencent.mm.plugin.sns.ad.remote.b
    public final void az(Bundle paramBundle)
    {
      AppMethodBeat.i(201952);
      Log.d("SnsAd.CouponCardBtnComp", "the onCallbackFromServer running!");
      try
      {
        Object localObject = this.Dtm;
        if (localObject != null)
        {
          localObject = (a)((Reference)localObject).get();
          if (localObject != null) {
            a.a((a)localObject, paramBundle);
          }
        }
        AppMethodBeat.o(201952);
        return;
      }
      catch (Throwable paramBundle)
      {
        Log.d("SnsAd.CouponCardBtnComp", "there is something wrong in client!");
        AppMethodBeat.o(201952);
      }
    }
  }
  
  public static final class c
    implements i, com.tencent.mm.plugin.sns.ad.remote.a.b
  {
    com.tencent.mm.plugin.sns.ad.remote.ipc.b Dtn;
    
    public final Bundle a(com.tencent.mm.plugin.sns.ad.remote.ipc.b paramb, Bundle paramBundle)
    {
      AppMethodBeat.i(201953);
      try
      {
        String str1 = com.tencent.mm.plugin.sns.ad.i.g.getString(paramBundle, "COUPON_APP_ID");
        String str2 = com.tencent.mm.plugin.sns.ad.i.g.getString(paramBundle, "COUPON_STOCK_ID");
        String str3 = com.tencent.mm.plugin.sns.ad.i.g.getString(paramBundle, "COMP_ID");
        paramBundle = com.tencent.mm.plugin.sns.ad.i.g.getString(paramBundle, "UX_INFO");
        this.Dtn = paramb;
        long l = System.currentTimeMillis();
        com.tencent.mm.kernel.g.azz().a(4743, this);
        com.tencent.mm.kernel.g.azz().a(new com.tencent.mm.plugin.sns.ad.h.b(str1, str2, paramBundle, str3), 0);
        Log.d("SnsAd.CouponCardBtnComp", "CouponRemoteCall::the onServerCall is end, take time: " + (System.currentTimeMillis() - l) + " ms");
        AppMethodBeat.o(201953);
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
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(201954);
      for (;;)
      {
        try
        {
          paramString = new Bundle();
          com.tencent.mm.kernel.g.azz().b(4743, this);
          if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof com.tencent.mm.plugin.sns.ad.h.b)))
          {
            paramq = (bvk)((com.tencent.mm.plugin.sns.ad.h.b)paramq).eXx();
            if (paramq != null)
            {
              paramString.putInt("ret", paramq.ret);
              if (!TextUtils.isEmpty(paramq.msg)) {
                paramString.putString("msg", paramq.msg);
              }
              if (this.Dtn != null) {
                this.Dtn.aB(paramString);
              }
              AppMethodBeat.o(201954);
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
          AppMethodBeat.o(201954);
          return;
        }
        paramString.putInt("call_ipc_result_key", -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.component.a.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.ad.b.a;
import com.tencent.mm.plugin.sns.ad.i.f;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class g
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private d rr;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97146);
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new bt();
    ((d.a)localObject1).iLO = new bu();
    ((d.a)localObject1).uri = "/cgi-bin/mmoc-bin/ad/adchannelmsg";
    ((d.a)localObject1).funcId = 2538;
    this.rr = ((d.a)localObject1).aXF();
    localObject1 = (bt)this.rr.iLK.iLR;
    bs localbs = new bs();
    localbs.KFB = 2;
    Object localObject2 = MMApplicationContext.getContext();
    if (NetStatusUtil.isWifi((Context)localObject2)) {
      i = 1;
    }
    label521:
    for (;;)
    {
      localbs.KFy = i;
      localbs.Dsg = a.aoK();
      localbs.imei = a.eWE();
      localbs.KFG = a.eWC();
      localbs.KFF = f.eYk();
      localObject2 = new PString();
      localbs.KFH = b(paramString1, paramString2, (PString)localObject2);
      localbs.KFI = Util.nullAsNil(((PString)localObject2).value);
      ((bt)localObject1).KFJ = localbs;
      ((bt)localObject1).dfC = paramString1;
      ((bt)localObject1).content = paramString2;
      try
      {
        label220:
        int j;
        if (TextUtils.isEmpty(localbs.Dsg))
        {
          i = 0;
          j = k;
          if (!TextUtils.isEmpty(localbs.imei))
          {
            j = k;
            if (!"1234567890ABCDEF".equals(localbs.imei)) {
              j = 1;
            }
          }
          localObject2 = k.aoz();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label484;
          }
        }
        label484:
        for (paramString1 = "0";; paramString1 = "1")
        {
          localObject1 = "0";
          paramString2 = (String)localObject1;
          if (localbs.imei != null)
          {
            paramString2 = (String)localObject1;
            if (localbs.imei.equals(localObject2)) {
              paramString2 = "1";
            }
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("##oaid:").append(localbs.Dsg).append(", imei:").append(localbs.imei).append(", rawImei:").append((String)localObject2).append(", waid:").append(localbs.KFH).append(", waidPkg:").append(localbs.KFI).append(", common_device_id:").append(localbs.KFG).append(", ua:").append(localbs.KFF);
          Log.i("NetSceneAdLadingPageClick", ((StringBuilder)localObject1).toString());
          j.b(j.DEc, paramString1, i, j, paramString2);
          AppMethodBeat.o(97146);
          return;
          if (NetStatusUtil.is2G((Context)localObject2)) {
            break;
          }
          if (NetStatusUtil.is3G((Context)localObject2))
          {
            i = 3;
            break;
          }
          if (NetStatusUtil.is4G((Context)localObject2))
          {
            i = 4;
            break;
          }
          if (!NetStatusUtil.is5G((Context)localObject2)) {
            break label521;
          }
          i = 5;
          break;
          i = 1;
          break label220;
        }
        i = 0;
      }
      catch (Throwable paramString1)
      {
        Log.e("NetSceneAdLadingPageClick", "adTecReport exp=" + paramString1.toString());
        AppMethodBeat.o(97146);
        return;
      }
    }
  }
  
  private static String b(String paramString1, String paramString2, PString paramPString)
  {
    AppMethodBeat.i(203142);
    if (paramString2.contains("uxinfo")) {
      try
      {
        paramString2 = new JSONObject(paramString2).optString("uxinfo");
        if (TextUtils.isEmpty(paramString2))
        {
          Log.e("NetSceneAdLadingPageClick", "getWaid, has no uxinfo, channel=".concat(String.valueOf(paramString1)));
          AppMethodBeat.o(203142);
          return "";
        }
        paramString1 = ADInfo.getWaidPkgByUxInfo(paramString2);
        Log.i("NetSceneAdLadingPageClick", "getWaid, waidPkg=" + paramString1 + ", uxinfo=" + paramString2);
        if (!TextUtils.isEmpty(paramString1))
        {
          paramPString.value = paramString1;
          paramString1 = b.aRy(paramString1);
          AppMethodBeat.o(203142);
          return paramString1;
        }
      }
      catch (Throwable paramString1)
      {
        Log.e("NetSceneAdLadingPageClick", "getWaid exop=" + paramString1.toString());
      }
    }
    AppMethodBeat.o(203142);
    return "";
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(97149);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(97149);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(97148);
    int i = this.rr.getType();
    AppMethodBeat.o(97148);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97147);
    Log.i("NetSceneAdLadingPageClick", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97147);
  }
  
  public static final class a
  {
    public com.tencent.mm.ab.i Ecy;
    com.tencent.mm.ab.i EiR;
    
    public a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2, String paramString3)
    {
      AppMethodBeat.i(179131);
      this.Ecy = new com.tencent.mm.ab.i();
      this.EiR = new com.tencent.mm.ab.i();
      try
      {
        this.Ecy.h("uxinfo", paramString1);
        this.Ecy.U("scene", paramInt1);
        this.Ecy.U("originScene", paramInt2);
        this.Ecy.v("canvasId", paramLong);
        this.Ecy.U("type", 21);
        this.Ecy.U("subType", paramInt3);
        this.Ecy.U("action", 1);
        if (!Util.isNullOrNil(new String[] { paramString2, paramString3 }))
        {
          this.Ecy.h("viewid", paramString2);
          this.Ecy.h("commInfo", paramString3);
        }
        AppMethodBeat.o(179131);
        return;
      }
      catch (Exception paramString1)
      {
        Log.e("NetSceneAdLadingPageClick", "ContentBuilder exp=" + paramString1.toString());
        AppMethodBeat.o(179131);
      }
    }
    
    private String build()
    {
      AppMethodBeat.i(97144);
      try
      {
        this.Ecy.h("extInfo", this.EiR);
        String str = this.Ecy.toString();
        AppMethodBeat.o(97144);
        return str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("NetSceneAdLadingPageClick", "build exp=" + localException.toString());
        }
      }
    }
    
    public final com.tencent.mm.ab.i bo(String paramString, long paramLong)
    {
      AppMethodBeat.i(97143);
      try
      {
        this.EiR.v(paramString, paramLong);
        paramString = this.EiR;
        AppMethodBeat.o(97143);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString.toString());
        }
      }
    }
    
    public final com.tencent.mm.ab.i kv(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97142);
      try
      {
        this.EiR.h(paramString1, Util.nullAsNil(paramString2));
        paramString1 = this.EiR;
        AppMethodBeat.o(97142);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          Log.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString1.toString());
        }
      }
    }
    
    public final void report(String paramString)
    {
      AppMethodBeat.i(203141);
      try
      {
        String str = build();
        AdLandingPagesProxy.getInstance().onAdLandingPageClick(paramString, str);
        Log.i("NetSceneAdLadingPageClick", "report, channel=" + paramString + ", content=" + str);
        AppMethodBeat.o(203141);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("NetSceneAdLadingPageClick", "report exp=" + paramString.toString());
        AppMethodBeat.o(203141);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g
 * JD-Core Version:    0.7.0.1
 */
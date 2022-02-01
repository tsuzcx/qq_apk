package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.ad.a.a;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.waid.b;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class g
  extends q
  implements m
{
  private i callback;
  private d rr;
  
  public g(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97146);
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new br();
    ((d.a)localObject1).lBV = new bs();
    ((d.a)localObject1).uri = "/cgi-bin/mmoc-bin/ad/adchannelmsg";
    ((d.a)localObject1).funcId = 2538;
    this.rr = ((d.a)localObject1).bgN();
    br localbr = (br)d.b.b(this.rr.lBR);
    localObject1 = new bq();
    ((bq)localObject1).RGS = 2;
    Object localObject2 = MMApplicationContext.getContext();
    if (NetStatusUtil.isWifi((Context)localObject2)) {
      i = 1;
    }
    for (;;)
    {
      ((bq)localObject1).RGP = i;
      ((bq)localObject1).JyL = a.auQ();
      ((bq)localObject1).imei = a.fJH();
      ((bq)localObject1).RGX = a.fJF();
      ((bq)localObject1).RGW = com.tencent.mm.plugin.sns.ad.i.g.fLT();
      localObject2 = new PString();
      ((bq)localObject1).RGY = b(paramString1, paramString2, (PString)localObject2);
      ((bq)localObject1).RGZ = Util.nullAsNil(((PString)localObject2).value);
      localbr.RHb = ((bq)localObject1);
      localbr.RHa = paramString1;
      localbr.content = paramString2;
      try
      {
        paramString1 = com.tencent.mm.plugin.sns.ad.i.g.getDeviceId();
        paramString2 = new StringBuilder();
        paramString2.append("##oaid:").append(((bq)localObject1).JyL).append(", imei:").append(((bq)localObject1).imei).append(", rawImei:").append(paramString1).append(", waid:").append(((bq)localObject1).RGY).append(", waidPkg:").append(((bq)localObject1).RGZ).append(", common_device_id:").append(((bq)localObject1).RGX).append(", ua:").append(((bq)localObject1).RGW);
        Log.d("NetSceneAdLadingPageClick", paramString2.toString());
        AppMethodBeat.o(97146);
        return;
      }
      catch (Throwable paramString1)
      {
        Log.e("NetSceneAdLadingPageClick", "adTecReport exp=" + paramString1.toString());
        AppMethodBeat.o(97146);
        return;
      }
      if (!NetStatusUtil.is2G((Context)localObject2)) {
        if (NetStatusUtil.is3G((Context)localObject2)) {
          i = 3;
        } else if (NetStatusUtil.is4G((Context)localObject2)) {
          i = 4;
        } else if (NetStatusUtil.is5G((Context)localObject2)) {
          i = 5;
        } else {
          i = 0;
        }
      }
    }
  }
  
  private static String b(String paramString1, String paramString2, PString paramPString)
  {
    AppMethodBeat.i(197301);
    if (paramString2.contains("uxinfo")) {
      try
      {
        paramString2 = new JSONObject(paramString2).optString("uxinfo");
        if (TextUtils.isEmpty(paramString2))
        {
          Log.e("NetSceneAdLadingPageClick", "getWaid, has no uxinfo, channel=".concat(String.valueOf(paramString1)));
          AppMethodBeat.o(197301);
          return "";
        }
        paramString1 = ADInfo.getWaidPkgByUxInfo(paramString2);
        Log.i("NetSceneAdLadingPageClick", "getWaid, waidPkg=" + paramString1 + ", uxinfo=" + paramString2);
        if (!TextUtils.isEmpty(paramString1))
        {
          paramPString.value = paramString1;
          paramString1 = b.bcD(paramString1);
          AppMethodBeat.o(197301);
          return paramString1;
        }
      }
      catch (Throwable paramString1)
      {
        Log.e("NetSceneAdLadingPageClick", "getWaid exop=" + paramString1.toString());
      }
    }
    AppMethodBeat.o(197301);
    return "";
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g
 * JD-Core Version:    0.7.0.1
 */
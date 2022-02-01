package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public final class d
  extends n
  implements com.tencent.mm.network.k
{
  private f callback;
  private com.tencent.mm.ak.b rr;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97146);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new bn();
    ((b.a)localObject1).hQG = new bo();
    ((b.a)localObject1).uri = "/cgi-bin/mmoc-bin/ad/adchannelmsg";
    ((b.a)localObject1).funcId = 2538;
    this.rr = ((b.a)localObject1).aDS();
    localObject1 = (bn)this.rr.hQD.hQJ;
    bm localbm = new bm();
    localbm.FLZ = 2;
    Object localObject2 = ak.getContext();
    if (az.isWifi((Context)localObject2)) {
      i = 1;
    }
    label521:
    for (;;)
    {
      localbm.FLW = i;
      localbm.zmV = com.tencent.mm.plugin.sns.ad.a.a.aaL();
      localbm.imei = com.tencent.mm.plugin.sns.ad.a.a.dUD();
      localbm.FMe = com.tencent.mm.plugin.sns.ad.a.a.dUB();
      localbm.FMd = com.tencent.mm.plugin.sns.ad.f.d.dVE();
      localObject2 = new PString();
      localbm.FMf = b(paramString1, paramString2, (PString)localObject2);
      localbm.FMg = bu.nullAsNil(((PString)localObject2).value);
      ((bn)localObject1).FMh = localbm;
      ((bn)localObject1).cPd = paramString1;
      ((bn)localObject1).content = paramString2;
      try
      {
        label220:
        int j;
        if (TextUtils.isEmpty(localbm.zmV))
        {
          i = 0;
          j = k;
          if (!TextUtils.isEmpty(localbm.imei))
          {
            j = k;
            if (!"1234567890ABCDEF".equals(localbm.imei)) {
              j = 1;
            }
          }
          localObject2 = com.tencent.mm.plugin.sns.data.k.aaA();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label484;
          }
        }
        label484:
        for (paramString1 = "0";; paramString1 = "1")
        {
          localObject1 = "0";
          paramString2 = (String)localObject1;
          if (localbm.imei != null)
          {
            paramString2 = (String)localObject1;
            if (localbm.imei.equals(localObject2)) {
              paramString2 = "1";
            }
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("##oaid:").append(localbm.zmV).append(", imei:").append(localbm.imei).append(", rawImei:").append((String)localObject2).append(", waid:").append(localbm.FMf).append(", waidPkg:").append(localbm.FMg).append(", common_device_id:").append(localbm.FMe).append(", ua:").append(localbm.FMd);
          ae.i("NetSceneAdLadingPageClick", ((StringBuilder)localObject1).toString());
          j.b(j.ztS, paramString1, i, j, paramString2);
          AppMethodBeat.o(97146);
          return;
          if (az.is2G((Context)localObject2)) {
            break;
          }
          if (az.is3G((Context)localObject2))
          {
            i = 3;
            break;
          }
          if (az.is4G((Context)localObject2))
          {
            i = 4;
            break;
          }
          if (!az.is5G((Context)localObject2)) {
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
        ae.e("NetSceneAdLadingPageClick", "adTecReport exp=" + paramString1.toString());
        AppMethodBeat.o(97146);
        return;
      }
    }
  }
  
  private static String b(String paramString1, String paramString2, PString paramPString)
  {
    AppMethodBeat.i(219611);
    if (paramString2.contains("uxinfo")) {
      try
      {
        paramString2 = new JSONObject(paramString2).optString("uxinfo");
        if (TextUtils.isEmpty(paramString2))
        {
          ae.e("NetSceneAdLadingPageClick", "getWaid, has no uxinfo, channel=".concat(String.valueOf(paramString1)));
          AppMethodBeat.o(219611);
          return "";
        }
        paramString1 = com.tencent.mm.plugin.sns.storage.a.aAZ(paramString2);
        ae.i("NetSceneAdLadingPageClick", "getWaid, waidPkg=" + paramString1 + ", uxinfo=" + paramString2);
        if (!TextUtils.isEmpty(paramString1))
        {
          paramPString.value = paramString1;
          paramString1 = com.tencent.mm.plugin.sns.waid.b.aCC(paramString1);
          AppMethodBeat.o(219611);
          return paramString1;
        }
      }
      catch (Throwable paramString1)
      {
        ae.e("NetSceneAdLadingPageClick", "getWaid exop=" + paramString1.toString());
      }
    }
    AppMethodBeat.o(219611);
    return "";
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(97149);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97147);
    ae.i("NetSceneAdLadingPageClick", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.ad.e.c;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class d
  extends n
  implements k
{
  private f callback;
  private com.tencent.mm.al.b rr;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97146);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new bn();
    ((b.a)localObject1).hNN = new bo();
    ((b.a)localObject1).uri = "/cgi-bin/mmoc-bin/ad/adchannelmsg";
    ((b.a)localObject1).funcId = 2538;
    this.rr = ((b.a)localObject1).aDC();
    localObject1 = (bn)this.rr.hNK.hNQ;
    bm localbm = new bm();
    localbm.FtB = 2;
    Object localObject2 = aj.getContext();
    if (ay.isWifi((Context)localObject2)) {
      i = 1;
    }
    label196:
    label484:
    for (;;)
    {
      localbm.Fty = i;
      localbm.yWM = com.tencent.mm.plugin.sns.ad.a.a.aaC();
      localbm.imei = com.tencent.mm.plugin.sns.ad.a.a.ftk();
      localbm.FtG = com.tencent.mm.plugin.sns.ad.a.a.dRf();
      localbm.FtF = c.dSd();
      localbm.FtH = jA(paramString1, paramString2);
      ((bn)localObject1).FtJ = localbm;
      ((bn)localObject1).cOt = paramString1;
      ((bn)localObject1).content = paramString2;
      try
      {
        int j;
        if (TextUtils.isEmpty(localbm.yWM))
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
          localObject2 = j.aar();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label447;
          }
        }
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
          ((StringBuilder)localObject1).append("##oaid:").append(localbm.yWM).append(", imei:").append(localbm.imei).append(", rawImei:").append((String)localObject2).append(", waid:").append(localbm.FtH).append(", common_device_id:").append(localbm.FtG).append(", ua:").append(localbm.FtF);
          ad.i("NetSceneAdLadingPageClick", ((StringBuilder)localObject1).toString());
          com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.zdc, paramString1, i, j, paramString2);
          AppMethodBeat.o(97146);
          return;
          if (ay.is2G((Context)localObject2)) {
            break;
          }
          if (ay.is3G((Context)localObject2))
          {
            i = 3;
            break;
          }
          if (ay.is4G((Context)localObject2))
          {
            i = 4;
            break;
          }
          if (!ay.is5G((Context)localObject2)) {
            break label484;
          }
          i = 5;
          break;
          i = 1;
          break label196;
        }
        i = 0;
      }
      catch (Throwable paramString1)
      {
        ad.e("NetSceneAdLadingPageClick", "adTecReport exp=" + paramString1.toString());
        AppMethodBeat.o(97146);
        return;
      }
    }
  }
  
  private static String jA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198097);
    if (paramString2.contains("uxinfo")) {
      try
      {
        paramString2 = new JSONObject(paramString2).optString("uxinfo");
        if (TextUtils.isEmpty(paramString2))
        {
          ad.e("NetSceneAdLadingPageClick", "getWaid, has no uxinfo, channel=".concat(String.valueOf(paramString1)));
          AppMethodBeat.o(198097);
          return "";
        }
        paramString1 = com.tencent.mm.plugin.sns.storage.a.azI(paramString2);
        ad.i("NetSceneAdLadingPageClick", "getWaid, waidPkg=" + paramString1 + ", uxinfo=" + paramString2);
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = com.tencent.mm.plugin.sns.waid.b.aBl(paramString1);
          AppMethodBeat.o(198097);
          return paramString1;
        }
      }
      catch (Throwable paramString1)
      {
        ad.e("NetSceneAdLadingPageClick", "getWaid exop=" + paramString1.toString());
      }
    }
    AppMethodBeat.o(198097);
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
    ad.i("NetSceneAdLadingPageClick", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97147);
  }
  
  public static final class a
  {
    public com.tencent.mm.ac.i zDp;
    com.tencent.mm.ac.i zJt;
    
    public a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2, String paramString3)
    {
      AppMethodBeat.i(179131);
      this.zDp = new com.tencent.mm.ac.i();
      this.zJt = new com.tencent.mm.ac.i();
      try
      {
        this.zDp.h("uxinfo", paramString1);
        this.zDp.R("scene", paramInt1);
        this.zDp.R("originScene", paramInt2);
        this.zDp.u("canvasId", paramLong);
        this.zDp.R("type", 21);
        this.zDp.R("subType", paramInt3);
        this.zDp.R("action", 1);
        if (!bt.V(new String[] { paramString2, paramString3 }))
        {
          this.zDp.h("viewid", paramString2);
          this.zDp.h("commInfo", paramString3);
        }
        AppMethodBeat.o(179131);
        return;
      }
      catch (Exception paramString1)
      {
        ad.e("NetSceneAdLadingPageClick", "ContentBuilder exp=" + paramString1.toString());
        AppMethodBeat.o(179131);
      }
    }
    
    public final com.tencent.mm.ac.i bl(String paramString, long paramLong)
    {
      AppMethodBeat.i(97143);
      try
      {
        this.zJt.u(paramString, paramLong);
        paramString = this.zJt;
        AppMethodBeat.o(97143);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ad.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString.toString());
        }
      }
    }
    
    public final String dbO()
    {
      AppMethodBeat.i(97144);
      try
      {
        this.zDp.h("extInfo", this.zJt);
        String str = this.zDp.toString();
        AppMethodBeat.o(97144);
        return str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("NetSceneAdLadingPageClick", "build exp=" + localException.toString());
        }
      }
    }
    
    public final com.tencent.mm.ac.i jB(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97142);
      try
      {
        this.zJt.h(paramString1, bt.nullAsNil(paramString2));
        paramString1 = this.zJt;
        AppMethodBeat.o(97142);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ad.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString1.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d
 * JD-Core Version:    0.7.0.1
 */
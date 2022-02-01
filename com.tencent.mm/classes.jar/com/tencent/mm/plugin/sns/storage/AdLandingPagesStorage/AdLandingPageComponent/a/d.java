package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  extends n
  implements k
{
  private g callback;
  private b rr;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97146);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bn();
    ((b.a)localObject).hvu = new bo();
    ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/adchannelmsg";
    ((b.a)localObject).funcId = 2538;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bn)this.rr.hvr.hvw;
    bm localbm = new bm();
    localbm.DOu = 2;
    Context localContext = ai.getContext();
    if (ax.isWifi(localContext)) {
      i = 1;
    }
    for (;;)
    {
      localbm.DOr = i;
      localbm.imei = com.tencent.mm.compatible.deviceinfo.q.cF(false);
      localbm.DOw = com.tencent.mm.compatible.deviceinfo.q.getOAID();
      ac.i("NetSceneAdLadingPageClick", "adChannelCgiReport, oaid=" + localbm.DOw + "imei=" + localbm.imei);
      ((bn)localObject).DOy = localbm;
      ((bn)localObject).cDo = paramString1;
      ((bn)localObject).content = paramString2;
      boolean bool = TextUtils.isEmpty(localbm.DOw);
      label232:
      int j;
      if ((TextUtils.isEmpty(localbm.imei)) || ("1234567890ABCDEF".equals(localbm.imei)))
      {
        i = 1;
        if ((bool) || (i != 0))
        {
          paramString1 = com.tencent.mm.plugin.sns.data.i.xNj;
          if (!bool) {
            break label329;
          }
          j = 0;
          label253:
          if (i == 0) {
            break label335;
          }
        }
      }
      label329:
      label335:
      for (i = k;; i = 1)
      {
        com.tencent.mm.plugin.sns.data.i.b(paramString1, "", j, i, "");
        AppMethodBeat.o(97146);
        return;
        if (ax.is2G(localContext)) {
          break;
        }
        if (ax.is3G(localContext))
        {
          i = 3;
          break;
        }
        if (ax.is4G(localContext))
        {
          i = 4;
          break;
        }
        if (!ax.is5G(localContext)) {
          break label340;
        }
        i = 5;
        break;
        i = 0;
        break label232;
        j = 1;
        break label253;
      }
      label340:
      i = 0;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(97149);
    this.callback = paramg;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(97147);
    ac.i("NetSceneAdLadingPageClick", "errType=" + paramInt2 + ", errCode=" + paramInt3 + ", errMsg=" + paramString);
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(97147);
  }
  
  public static final class a
  {
    com.tencent.mm.ab.i ysj;
    com.tencent.mm.ab.i ysk;
    
    public a(String paramString1, int paramInt1, int paramInt2, long paramLong, int paramInt3, String paramString2, String paramString3)
    {
      AppMethodBeat.i(179131);
      this.ysj = new com.tencent.mm.ab.i();
      this.ysk = new com.tencent.mm.ab.i();
      try
      {
        this.ysj.i("uxinfo", paramString1);
        this.ysj.O("scene", paramInt1);
        this.ysj.O("originScene", paramInt2);
        this.ysj.s("canvasId", paramLong);
        this.ysj.O("type", 21);
        this.ysj.O("subType", paramInt3);
        this.ysj.O("action", 1);
        if (!bs.T(new String[] { paramString2, paramString3 }))
        {
          this.ysj.i("viewid", paramString2);
          this.ysj.i("commInfo", paramString3);
        }
        AppMethodBeat.o(179131);
        return;
      }
      catch (Exception paramString1)
      {
        ac.e("NetSceneAdLadingPageClick", "ContentBuilder exp=" + paramString1.toString());
        AppMethodBeat.o(179131);
      }
    }
    
    public final com.tencent.mm.ab.i bi(String paramString, long paramLong)
    {
      AppMethodBeat.i(97143);
      try
      {
        this.ysk.s(paramString, paramLong);
        paramString = this.ysk;
        AppMethodBeat.o(97143);
        return paramString;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ac.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString.toString());
        }
      }
    }
    
    public final String cSH()
    {
      AppMethodBeat.i(97144);
      try
      {
        this.ysj.i("extInfo", this.ysk);
        String str = this.ysj.toString();
        AppMethodBeat.o(97144);
        return str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("NetSceneAdLadingPageClick", "build exp=" + localException.toString());
        }
      }
    }
    
    public final com.tencent.mm.ab.i jo(String paramString1, String paramString2)
    {
      AppMethodBeat.i(97142);
      try
      {
        this.ysk.i(paramString1, bs.nullAsNil(paramString2));
        paramString1 = this.ysk;
        AppMethodBeat.o(97142);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ac.e("NetSceneAdLadingPageClick", "appendExtInfo exp=" + paramString1.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d
 * JD-Core Version:    0.7.0.1
 */
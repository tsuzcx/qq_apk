package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acs;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class l
  extends m
  implements k
{
  public b dmK;
  private f dmL;
  
  public l(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new acs();
    ((b.a)localObject).ecI = new act();
    ((b.a)localObject).uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
    ((b.a)localObject).ecG = 1393;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (acs)this.dmK.ecE.ecN;
    ((acs)localObject).sPM = paramString1;
    ((acs)localObject).sEy = paramString2;
    ((acs)localObject).tbv = ((String)paramMap.get("groupId"));
    ((acs)localObject).quW = ((String)paramMap.get("timestamp"));
    ((acs)localObject).ivF = ((String)paramMap.get("nonceStr"));
    ((acs)localObject).signature = ((String)paramMap.get("signature"));
    ((acs)localObject).tbw = paramMap.get("params").toString();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final act cbH()
  {
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null)) {
      return (act)this.dmK.ecF.ecN;
    }
    return null;
  }
  
  public final int getType()
  {
    return 1393;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.l
 * JD-Core Version:    0.7.0.1
 */
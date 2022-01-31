package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ckr;
import com.tencent.mm.protocal.c.cks;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class t
  extends a
  implements k
{
  private s dZR;
  private b dmK;
  private f dmL;
  
  public t(s params)
  {
    this.dZR = params;
    this.qTu = params.bGm;
    this.El = params.offset;
    this.fzn = params.scene;
    this.qTt = params.bVm;
    this.dZR = params;
    this.qTv = params.qTN;
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecG = 1943;
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).ecH = new ckr();
    ((b.a)localObject1).ecI = new cks();
    this.dmK = ((b.a)localObject1).Kt();
    localObject1 = (ckr)this.dmK.ecE.ecN;
    ((ckr)localObject1).sDT = params.offset;
    ((ckr)localObject1).tqS = aa.Bs(1);
    ((ckr)localObject1).tEN = params.qTw;
    ((ckr)localObject1).sYZ = params.bGm;
    ((ckr)localObject1).tqT = aa.Jx();
    ((ckr)localObject1).pyo = params.scene;
    ((ckr)localObject1).sFF = params.jfE;
    ((ckr)localObject1).tXU = params.bVt;
    ((ckr)localObject1).tpJ = params.qTC;
    ((ckr)localObject1).tNf = params.bvj;
    ((ckr)localObject1).tXW = params.qTP;
    Object localObject2 = new rb();
    ((rb)localObject2).key = "client_system_version";
    ((rb)localObject2).sOI = Build.VERSION.SDK_INT;
    params.qTG.add(localObject2);
    ((ckr)localObject1).tXV = params.qTG;
    ((ckr)localObject1).tpM = params.bIB;
    this.bVq = params.lJQ;
    int i;
    String str;
    int j;
    if (params.qTQ)
    {
      i = params.scene;
      localObject1 = params.bIB;
      localObject2 = params.bVp;
      str = params.jfE;
      j = params.offset;
      if (params.qTw != 1) {
        break label361;
      }
    }
    for (;;)
    {
      z.a(i, (String)localObject1, (String)localObject2, str, j, bool, params.lJQ, params.bGm, params.businessType, params.qTM);
      return;
      label361:
      bool = false;
    }
  }
  
  private cks bZo()
  {
    return (cks)this.dmK.ecF.ecN;
  }
  
  public final String Jv()
  {
    if (bZo() != null) {
      return bZo().sEb;
    }
    return "";
  }
  
  public final int Jw()
  {
    if (bZo() != null) {
      return bZo().tpP;
    }
    return 0;
  }
  
  public final int a(e parame, f paramf)
  {
    ao.reportIdKey649ForLook(this.fzn, 2);
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    boolean bool2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if (this.dZR.qTQ)
      {
        paramInt1 = this.dZR.scene;
        paramq = this.dZR.bIB;
        paramArrayOfByte = this.dZR.bVp;
        String str = this.dZR.jfE;
        int i = this.dZR.offset;
        if (this.dZR.qTw != 1) {
          break label196;
        }
        bool2 = true;
        label118:
        z.a(paramInt1, paramq, paramArrayOfByte, str, i, bool2, this.dZR.lJQ, bool1, this.dZR.bGm, this.dZR.businessType, this.dZR.qTM);
      }
      if (paramInt3 != -1) {
        break label202;
      }
      ao.reportIdKey649ForLook(this.fzn, 4);
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      bool1 = false;
      break;
      label196:
      bool2 = false;
      break label118;
      label202:
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        ao.reportIdKey649ForLook(this.fzn, 8);
      } else {
        ao.reportIdKey649ForLook(this.fzn, 3);
      }
    }
  }
  
  public final int getType()
  {
    return 1943;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.t
 * JD-Core Version:    0.7.0.1
 */
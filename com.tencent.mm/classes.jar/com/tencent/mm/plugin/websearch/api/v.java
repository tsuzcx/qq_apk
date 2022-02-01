package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aag;
import com.tencent.mm.protocal.protobuf.eej;
import com.tencent.mm.protocal.protobuf.eek;
import java.util.LinkedList;

public final class v
  extends a
  implements k
{
  private s DBv;
  private f callback;
  private b rr;
  
  public v(s params)
  {
    AppMethodBeat.i(117630);
    this.DBv = params;
    this.tQe = params.dld;
    this.fq = params.offset;
    this.mScene = params.scene;
    this.DAT = params.dCT;
    this.DBv = params;
    this.DAU = params.yjJ;
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).hNM = new eej();
    ((b.a)localObject1).hNN = new eek();
    this.rr = ((b.a)localObject1).aDC();
    localObject1 = (eej)this.rr.hNK.hNQ;
    ((eej)localObject1).FMu = params.offset;
    ((eej)localObject1).GDa = ad.We(1);
    ((eej)localObject1).Hmr = params.DAZ;
    ((eej)localObject1).Gsr = params.dld;
    ((eej)localObject1).GRt = ad.bNG();
    ((eej)localObject1).Scene = params.scene;
    ((eej)localObject1).FMt = params.pLL;
    ((eej)localObject1).Hmv = params.dDa;
    ((eej)localObject1).HPA = params.DBf;
    ((eej)localObject1).HAv = params.cSc;
    ((eej)localObject1).HPC = params.DBr;
    Object localObject2 = new aag();
    ((aag)localObject2).key = "client_system_version";
    ((aag)localObject2).FZe = Build.VERSION.SDK_INT;
    params.DBj.add(localObject2);
    ((eej)localObject1).HOp = params.DBj;
    ((eej)localObject1).HPB = params.sessionId;
    this.dCX = params.dwW;
    int i;
    String str;
    int j;
    if (params.DBt)
    {
      i = params.scene;
      localObject1 = params.sessionId;
      localObject2 = params.dCW;
      str = params.pLL;
      j = params.offset;
      if (params.DAZ != 1) {
        break label372;
      }
    }
    for (;;)
    {
      ac.a(i, (String)localObject1, (String)localObject2, str, j, bool, params.dwW, params.dld, params.businessType, params.DBp);
      AppMethodBeat.o(117630);
      return;
      label372:
      bool = false;
    }
  }
  
  private eek eLW()
  {
    return (eek)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(117631);
    am.iR(this.mScene, 2);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(117631);
    return i;
  }
  
  public final String eLN()
  {
    AppMethodBeat.i(117633);
    if (eLW() != null)
    {
      String str = eLW().GDb;
      AppMethodBeat.o(117633);
      return str;
    }
    AppMethodBeat.o(117633);
    return "";
  }
  
  public final int eLO()
  {
    AppMethodBeat.i(117634);
    if (eLW() != null)
    {
      int i = eLW().HPG;
      AppMethodBeat.o(117634);
      return i;
    }
    AppMethodBeat.o(117634);
    return 0;
  }
  
  public final int getType()
  {
    return 1943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117632);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    boolean bool2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if (this.DBv.DBt)
      {
        paramInt1 = this.DBv.scene;
        paramq = this.DBv.sessionId;
        paramArrayOfByte = this.DBv.dCW;
        String str = this.DBv.pLL;
        int i = this.DBv.offset;
        if (this.DBv.DAZ != 1) {
          break label208;
        }
        bool2 = true;
        label124:
        ac.a(paramInt1, paramq, paramArrayOfByte, str, i, bool2, this.DBv.dwW, bool1, this.DBv.dld, this.DBv.businessType, this.DBv.DBp);
      }
      if (paramInt3 != -1) {
        break label214;
      }
      am.iR(this.mScene, 4);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117632);
      return;
      bool1 = false;
      break;
      label208:
      bool2 = false;
      break label124;
      label214:
      if ((paramInt2 != 0) || (paramInt3 != 0)) {
        am.iR(this.mScene, 8);
      } else {
        am.iR(this.mScene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.v
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.protocal.protobuf.dst;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class t
  extends a
  implements k
{
  private q AGj;
  private g callback;
  private b rr;
  
  public t(q paramq)
  {
    AppMethodBeat.i(117630);
    this.AGj = paramq;
    this.rLL = paramq.dcm;
    this.LZ = paramq.offset;
    this.mScene = paramq.scene;
    this.AFI = paramq.dtt;
    this.AGj = paramq;
    this.AFJ = paramq.AGe;
    Object localObject1 = new b.a();
    ((b.a)localObject1).funcId = getType();
    ((b.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((b.a)localObject1).gUU = new dss();
    ((b.a)localObject1).gUV = new dst();
    this.rr = ((b.a)localObject1).atI();
    localObject1 = (dss)this.rr.gUS.gUX;
    ((dss)localObject1).CNt = paramq.offset;
    ((dss)localObject1).DLD = aa.Sb(1);
    ((dss)localObject1).Efc = paramq.AFN;
    ((dss)localObject1).Dop = paramq.dcm;
    ((dss)localObject1).DLE = aa.bCk();
    ((dss)localObject1).Scene = paramq.scene;
    ((dss)localObject1).CNs = paramq.oEK;
    ((dss)localObject1).Efg = paramq.dtA;
    ((dss)localObject1).EHi = paramq.AFT;
    ((dss)localObject1).EsO = paramq.cJR;
    ((dss)localObject1).EHk = paramq.AGg;
    Object localObject2 = new xp();
    ((xp)localObject2).key = "client_system_version";
    ((xp)localObject2).CZi = Build.VERSION.SDK_INT;
    paramq.AFX.add(localObject2);
    ((dss)localObject1).EFX = paramq.AFX;
    ((dss)localObject1).EHj = paramq.sessionId;
    this.dtx = paramq.dnB;
    int i;
    String str;
    int j;
    if (paramq.AGh)
    {
      i = paramq.scene;
      localObject1 = paramq.sessionId;
      localObject2 = paramq.dtw;
      str = paramq.oEK;
      j = paramq.offset;
      if (paramq.AFN != 1) {
        break label372;
      }
    }
    for (;;)
    {
      z.a(i, (String)localObject1, (String)localObject2, str, j, bool, paramq.dnB, paramq.dcm, paramq.businessType, paramq.AGd);
      AppMethodBeat.o(117630);
      return;
      label372:
      bool = false;
    }
  }
  
  private dst ehN()
  {
    return (dst)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117631);
    ak.ip(this.mScene, 2);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(117631);
    return i;
  }
  
  public final String ehF()
  {
    AppMethodBeat.i(117633);
    if (ehN() != null)
    {
      String str = ehN().DLy;
      AppMethodBeat.o(117633);
      return str;
    }
    AppMethodBeat.o(117633);
    return "";
  }
  
  public final int ehG()
  {
    AppMethodBeat.i(117634);
    if (ehN() != null)
    {
      int i = ehN().EHo;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117632);
    ad.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    boolean bool2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if (this.AGj.AGh)
      {
        paramInt1 = this.AGj.scene;
        paramq = this.AGj.sessionId;
        paramArrayOfByte = this.AGj.dtw;
        String str = this.AGj.oEK;
        int i = this.AGj.offset;
        if (this.AGj.AFN != 1) {
          break label208;
        }
        bool2 = true;
        label124:
        z.a(paramInt1, paramq, paramArrayOfByte, str, i, bool2, this.AGj.dnB, bool1, this.AGj.dcm, this.AGj.businessType, this.AGj.AGd);
      }
      if (paramInt3 != -1) {
        break label214;
      }
      ak.ip(this.mScene, 4);
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
        ak.ip(this.mScene, 8);
      } else {
        ak.ip(this.mScene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.t
 * JD-Core Version:    0.7.0.1
 */
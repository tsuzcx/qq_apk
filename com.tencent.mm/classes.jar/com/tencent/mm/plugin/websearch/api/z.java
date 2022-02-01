package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.fal;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class z
  extends a
  implements m
{
  private v IDt;
  private i callback;
  private d rr;
  
  public z(v paramv)
  {
    AppMethodBeat.i(117630);
    this.IDt = paramv;
    this.xsj = paramv.dDv;
    this.fs = paramv.offset;
    this.mScene = paramv.scene;
    this.IDq = paramv.dVL;
    this.IDt = paramv;
    this.IDr = paramv.CAJ;
    Object localObject1 = new d.a();
    ((d.a)localObject1).funcId = getType();
    ((d.a)localObject1).uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
    ((d.a)localObject1).iLN = new fal();
    ((d.a)localObject1).iLO = new fam();
    this.rr = ((d.a)localObject1).aXF();
    localObject1 = (fal)this.rr.iLK.iLR;
    ((fal)localObject1).KZk = paramv.offset;
    ((fal)localObject1).MaY = ai.aft(1);
    ((fal)localObject1).MRb = paramv.IDE;
    ((fal)localObject1).LPT = paramv.dDv;
    ((fal)localObject1).MlQ = ai.clJ();
    ((fal)localObject1).Scene = paramv.scene;
    ((fal)localObject1).KZj = paramv.rjq;
    ((fal)localObject1).MRf = paramv.dVS;
    ((fal)localObject1).NwG = paramv.IDK;
    ((fal)localObject1).NgA = paramv.channelId;
    ((fal)localObject1).NwI = paramv.IDW;
    Object localObject2 = new aca();
    ((aca)localObject2).key = "client_system_version";
    ((aca)localObject2).LmC = Build.VERSION.SDK_INT;
    paramv.IDO.add(localObject2);
    ((fal)localObject1).Nva = paramv.IDO;
    ((fal)localObject1).NwH = paramv.sessionId;
    this.dVP = paramv.dPI;
    int i;
    String str;
    int j;
    if (paramv.IEa)
    {
      i = paramv.scene;
      localObject1 = paramv.sessionId;
      localObject2 = paramv.dVO;
      str = paramv.rjq;
      j = paramv.offset;
      if (paramv.IDE != 1) {
        break label372;
      }
    }
    for (;;)
    {
      ah.a(i, (String)localObject1, (String)localObject2, str, j, bool, paramv.dPI, paramv.dDv, paramv.businessType, paramv.IDU);
      AppMethodBeat.o(117630);
      return;
      label372:
      bool = false;
    }
  }
  
  private fam fXR()
  {
    return (fam)this.rr.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117631);
    ar.kb(this.mScene, 2);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(117631);
    return i;
  }
  
  public final String fXC()
  {
    AppMethodBeat.i(117633);
    if (fXR() != null)
    {
      String str = fXR().MaZ;
      AppMethodBeat.o(117633);
      return str;
    }
    AppMethodBeat.o(117633);
    return "";
  }
  
  public final int fXD()
  {
    AppMethodBeat.i(117634);
    if (fXR() != null)
    {
      int i = fXR().NwM;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117632);
    Log.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool1;
    boolean bool2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      bool1 = true;
      if (this.IDt.IEa)
      {
        paramInt1 = this.IDt.scene;
        params = this.IDt.sessionId;
        paramArrayOfByte = this.IDt.dVO;
        String str = this.IDt.rjq;
        int i = this.IDt.offset;
        if (this.IDt.IDE != 1) {
          break label208;
        }
        bool2 = true;
        label124:
        ah.a(paramInt1, params, paramArrayOfByte, str, i, bool2, this.IDt.dPI, bool1, this.IDt.dDv, this.IDt.businessType, this.IDt.IDU);
      }
      if (paramInt3 != -1) {
        break label214;
      }
      ar.kb(this.mScene, 4);
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
        ar.kb(this.mScene, 8);
      } else {
        ar.kb(this.mScene, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.z
 * JD-Core Version:    0.7.0.1
 */
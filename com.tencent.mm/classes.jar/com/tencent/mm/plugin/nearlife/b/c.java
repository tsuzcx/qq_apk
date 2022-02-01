package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends q
  implements m
{
  private i AAQ;
  public String AAR;
  private d iLF;
  
  public c(String paramString1, String paramString2, String paramString3, chk paramchk, int paramInt, LinkedList<dqi> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(26548);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ael();
    ((d.a)localObject).iLO = new aem();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/createpoi";
    ((d.a)localObject).funcId = 650;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.iLF = ((d.a)localObject).aXF();
    paramString4 = Util.nullAs(paramString4, "");
    localObject = Util.nullAs(null, "");
    ael localael = (ael)this.iLF.iLK.iLR;
    localael.Name = paramString1;
    localael.LpJ = paramString2;
    localael.LpL = paramchk;
    localael.oTz = paramInt;
    if (paramLinkedList != null) {
      localael.LpM = paramLinkedList;
    }
    localael.LpN = paramString4;
    localael.LpO = ((String)localObject);
    localael.LpK = paramString3;
    Log.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[] { paramString1, paramString2, paramString3, Float.valueOf(paramchk.LbD), Float.valueOf(paramchk.LbC), Integer.valueOf(paramInt), paramString4, localObject });
    AppMethodBeat.o(26548);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(26549);
    this.AAQ = parami;
    int i = dispatch(paramg, this.iLF, this);
    AppMethodBeat.o(26549);
    return i;
  }
  
  public final int getType()
  {
    return 650;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26550);
    Log.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (aem)this.iLF.iLL.iLR;
    if (this.iLF.iLL.getRetCode() != 0)
    {
      this.AAQ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26550);
      return;
    }
    this.AAR = params.LpP;
    Log.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.AAR);
    this.AAQ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.c
 * JD-Core Version:    0.7.0.1
 */
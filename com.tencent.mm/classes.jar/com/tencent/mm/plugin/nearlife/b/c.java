package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.ahf;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends p
  implements m
{
  private h MpS;
  public String MpT;
  private com.tencent.mm.am.c otw;
  
  public c(String paramString1, String paramString2, String paramString3, dha paramdha, int paramInt, LinkedList<etl> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(26548);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ahe();
    ((c.a)localObject).otF = new ahf();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/createpoi";
    ((c.a)localObject).funcId = 650;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.otw = ((c.a)localObject).bEF();
    paramString4 = Util.nullAs(paramString4, "");
    localObject = Util.nullAs(null, "");
    ahe localahe = (ahe)c.b.b(this.otw.otB);
    localahe.IGU = paramString1;
    localahe.Zqh = paramString2;
    localahe.Zqj = paramdha;
    localahe.vgN = paramInt;
    if (paramLinkedList != null) {
      localahe.Zqk = paramLinkedList;
    }
    localahe.Zql = paramString4;
    localahe.Zqm = ((String)localObject);
    localahe.Zqi = paramString3;
    Log.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[] { paramString1, paramString2, paramString3, Float.valueOf(paramdha.ZaH), Float.valueOf(paramdha.ZaG), Integer.valueOf(paramInt), paramString4, localObject });
    AppMethodBeat.o(26548);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(26549);
    this.MpS = paramh;
    int i = dispatch(paramg, this.otw, this);
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
    params = (ahf)c.c.b(this.otw.otC);
    if (this.otw.otC.getRetCode() != 0)
    {
      this.MpS.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26550);
      return;
    }
    this.MpT = params.Zqn;
    Log.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.MpT);
    this.MpS.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.c
 * JD-Core Version:    0.7.0.1
 */
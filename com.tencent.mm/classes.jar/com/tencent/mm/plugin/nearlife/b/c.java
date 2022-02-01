package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.protocal.protobuf.aab;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class c
  extends n
  implements k
{
  private b hvm;
  private g vkE;
  public String vkF;
  
  public c(String paramString1, String paramString2, String paramString3, boz paramboz, int paramInt, LinkedList<crm> paramLinkedList, String paramString4)
  {
    AppMethodBeat.i(26548);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new aaa();
    ((b.a)localObject).hvu = new aab();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/createpoi";
    ((b.a)localObject).funcId = 650;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.hvm = ((b.a)localObject).aAz();
    paramString4 = bs.bG(paramString4, "");
    localObject = bs.bG(null, "");
    aaa localaaa = (aaa)this.hvm.hvr.hvw;
    localaaa.Name = paramString1;
    localaaa.Euh = paramString2;
    localaaa.Euj = paramboz;
    localaaa.ncL = paramInt;
    if (paramLinkedList != null) {
      localaaa.Euk = paramLinkedList;
    }
    localaaa.Eul = paramString4;
    localaaa.Eum = ((String)localObject);
    localaaa.Eui = paramString3;
    ac.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[] { paramString1, paramString2, paramString3, Float.valueOf(paramboz.Ehu), Float.valueOf(paramboz.Eht), Integer.valueOf(paramInt), paramString4, localObject });
    AppMethodBeat.o(26548);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(26549);
    this.vkE = paramg;
    int i = dispatch(parame, this.hvm, this);
    AppMethodBeat.o(26549);
    return i;
  }
  
  public final int getType()
  {
    return 650;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26550);
    ac.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (aab)this.hvm.hvs.hvw;
    if (this.hvm.hvs.getRetCode() != 0)
    {
      this.vkE.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26550);
      return;
    }
    this.vkF = paramq.Eun;
    ac.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.vkF);
    this.vkE.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(26550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.b.c
 * JD-Core Version:    0.7.0.1
 */
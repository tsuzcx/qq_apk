package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.protocal.protobuf.aay;
import com.tencent.mm.protocal.protobuf.dxc;
import com.tencent.mm.protocal.protobuf.dxl;
import com.tencent.mm.protocal.protobuf.dxm;
import com.tencent.mm.protocal.protobuf.dxo;
import com.tencent.mm.protocal.protobuf.dxp;
import com.tencent.mm.protocal.protobuf.dxq;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
{
  public static com.tencent.mm.ak.b a(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, LinkedList<dxw> paramLinkedList, LinkedList<aay> paramLinkedList1)
  {
    AppMethodBeat.i(190462);
    Object localObject2 = new b.a();
    ((b.a)localObject2).hQF = new dxo();
    ((b.a)localObject2).hQG = new dxp();
    ((b.a)localObject2).funcId = 448;
    ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/voipmtinvite";
    ((b.a)localObject2).hQH = 0;
    ((b.a)localObject2).respCmdId = 0;
    Object localObject1 = new dxw();
    ((dxw)localObject1).username = paramString3;
    ((dxw)localObject1).IcF = paramString4;
    paramString3 = ((b.a)localObject2).aDS();
    paramString4 = (dxo)paramString3.hQD.hQJ;
    paramString4.IcO = ((dxw)localObject1);
    paramString4.Icy = paramString1;
    paramString4.Icz = paramString2;
    paramString4.Gsg = paramLong;
    paramString1 = new LinkedList();
    paramString2 = paramLinkedList1.iterator();
    while (paramString2.hasNext())
    {
      paramLinkedList1 = (aay)paramString2.next();
      localObject1 = new dxq();
      ((dxq)localObject1).GsQ = paramLinkedList1.GsQ;
      localObject2 = paramLinkedList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        dxw localdxw = (dxw)((Iterator)localObject2).next();
        if (paramLinkedList1.FQc.equals(localdxw.IcF)) {
          ((dxq)localObject1).IcQ = localdxw;
        }
      }
      paramString1.add(localObject1);
    }
    ae.i("MicroMsg.Multitalk.ILinkCGIImp", "invite member cnt:%d", new Object[] { Integer.valueOf(paramString1.size()) });
    paramString4.IcP = paramString1;
    paramString4.IcN = paramLinkedList;
    AppMethodBeat.o(190462);
    return paramString3;
  }
  
  public static com.tencent.mm.ak.b a(String paramString1, String paramString2, dxc paramdxc)
  {
    AppMethodBeat.i(190463);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dxu();
    ((b.a)localObject).hQG = new dxv();
    ((b.a)localObject).funcId = 3878;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtsendbannermsg";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    dxw localdxw = new dxw();
    localdxw.username = paramString2;
    localdxw.IcF = null;
    paramString2 = ((b.a)localObject).aDS();
    localObject = (dxu)paramString2.hQD.hQJ;
    ((dxu)localObject).IcO = localdxw;
    ((dxu)localObject).Icy = paramString1;
    try
    {
      ((dxu)localObject).IcT = com.tencent.mm.bw.b.cm(paramdxc.toByteArray());
      AppMethodBeat.o(190463);
      return paramString2;
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Multitalk.ILinkCGIImp", paramString1, "hy: error when convert to byte array", new Object[0]);
      }
    }
  }
  
  public static com.tencent.mm.ak.b aI(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(190461);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dxl();
    ((b.a)localObject).hQG = new dxm();
    ((b.a)localObject).funcId = 3994;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtgetuserinfo";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
    ((dxl)((com.tencent.mm.ak.b)localObject).hQD.hQJ).ikO = paramLinkedList;
    AppMethodBeat.o(190461);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.i
 * JD-Core Version:    0.7.0.1
 */
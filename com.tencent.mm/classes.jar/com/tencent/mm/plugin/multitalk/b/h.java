package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.fbt;
import com.tencent.mm.protocal.protobuf.fcc;
import com.tencent.mm.protocal.protobuf.fcd;
import com.tencent.mm.protocal.protobuf.fcf;
import com.tencent.mm.protocal.protobuf.fcg;
import com.tencent.mm.protocal.protobuf.fch;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.fcm;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  public static d a(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, LinkedList<fcn> paramLinkedList, LinkedList<ade> paramLinkedList1)
  {
    AppMethodBeat.i(199089);
    Object localObject2 = new d.a();
    ((d.a)localObject2).lBU = new fcf();
    ((d.a)localObject2).lBV = new fcg();
    ((d.a)localObject2).funcId = 448;
    ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/voipmtinvite";
    ((d.a)localObject2).lBW = 0;
    ((d.a)localObject2).respCmdId = 0;
    Object localObject1 = new fcn();
    ((fcn)localObject1).username = paramString3;
    ((fcn)localObject1).UBZ = paramString4;
    paramString3 = ((d.a)localObject2).bgN();
    paramString4 = (fcf)d.b.b(paramString3.lBR);
    paramString4.UCi = ((fcn)localObject1);
    paramString4.UBS = paramString1;
    paramString4.UBT = paramString2;
    paramString4.SoR = paramLong;
    paramString1 = new LinkedList();
    paramString2 = paramLinkedList1.iterator();
    while (paramString2.hasNext())
    {
      paramLinkedList1 = (ade)paramString2.next();
      localObject1 = new fch();
      ((fch)localObject1).SpH = paramLinkedList1.SpH;
      localObject2 = paramLinkedList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        fcn localfcn = (fcn)((Iterator)localObject2).next();
        if (paramLinkedList1.openid.equals(localfcn.UBZ)) {
          ((fch)localObject1).UCk = localfcn;
        }
      }
      paramString1.add(localObject1);
    }
    Log.i("MicroMsg.Multitalk.ILinkCGIImp", "invite member cnt:%d", new Object[] { Integer.valueOf(paramString1.size()) });
    paramString4.UCj = paramString1;
    paramString4.UCh = paramLinkedList;
    AppMethodBeat.o(199089);
    return paramString3;
  }
  
  public static d a(String paramString1, String paramString2, fbt paramfbt)
  {
    AppMethodBeat.i(199092);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fcl();
    ((d.a)localObject).lBV = new fcm();
    ((d.a)localObject).funcId = 3878;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtsendbannermsg";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    fcn localfcn = new fcn();
    localfcn.username = paramString2;
    localfcn.UBZ = null;
    paramString2 = ((d.a)localObject).bgN();
    localObject = (fcl)d.b.b(paramString2.lBR);
    ((fcl)localObject).UCi = localfcn;
    ((fcl)localObject).UBS = paramString1;
    try
    {
      ((fcl)localObject).UCn = b.cU(paramfbt.toByteArray());
      AppMethodBeat.o(199092);
      return paramString2;
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Multitalk.ILinkCGIImp", paramString1, "hy: error when convert to byte array", new Object[0]);
      }
    }
  }
  
  public static d bw(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(199086);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new fcc();
    ((d.a)localObject).lBV = new fcd();
    ((d.a)localObject).funcId = 3994;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtgetuserinfo";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    ((fcc)d.b.b(((d)localObject).lBR)).lWo = paramLinkedList;
    AppMethodBeat.o(199086);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.h
 * JD-Core Version:    0.7.0.1
 */
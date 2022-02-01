package com.tencent.mm.plugin.multitalk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.afm;
import com.tencent.mm.protocal.protobuf.fye;
import com.tencent.mm.protocal.protobuf.fyn;
import com.tencent.mm.protocal.protobuf.fyo;
import com.tencent.mm.protocal.protobuf.fyq;
import com.tencent.mm.protocal.protobuf.fyr;
import com.tencent.mm.protocal.protobuf.fys;
import com.tencent.mm.protocal.protobuf.fyw;
import com.tencent.mm.protocal.protobuf.fyx;
import com.tencent.mm.protocal.protobuf.fyy;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
{
  public static c a(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, LinkedList<fyy> paramLinkedList, LinkedList<afm> paramLinkedList1)
  {
    AppMethodBeat.i(285135);
    Object localObject2 = new c.a();
    ((c.a)localObject2).otE = new fyq();
    ((c.a)localObject2).otF = new fyr();
    ((c.a)localObject2).funcId = 448;
    ((c.a)localObject2).uri = "/cgi-bin/micromsg-bin/voipmtinvite";
    ((c.a)localObject2).otG = 0;
    ((c.a)localObject2).respCmdId = 0;
    Object localObject1 = new fyy();
    ((fyy)localObject1).username = paramString3;
    ((fyy)localObject1).abWi = paramString4;
    paramString3 = ((c.a)localObject2).bEF();
    paramString4 = (fyq)c.b.b(paramString3.otB);
    paramString4.abWs = ((fyy)localObject1);
    paramString4.abWb = paramString1;
    paramString4.abWc = paramString2;
    paramString4.ZnE = paramLong;
    paramString1 = new LinkedList();
    paramString2 = paramLinkedList1.iterator();
    while (paramString2.hasNext())
    {
      paramLinkedList1 = (afm)paramString2.next();
      localObject1 = new fys();
      ((fys)localObject1).ZoB = paramLinkedList1.ZoB;
      localObject2 = paramLinkedList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        fyy localfyy = (fyy)((Iterator)localObject2).next();
        if (paramLinkedList1.openid.equals(localfyy.abWi)) {
          ((fys)localObject1).abWu = localfyy;
        }
      }
      paramString1.add(localObject1);
    }
    Log.i("MicroMsg.Multitalk.ILinkCGIImp", "invite member cnt:%d", new Object[] { Integer.valueOf(paramString1.size()) });
    paramString4.abWt = paramString1;
    paramString4.abWr = paramLinkedList;
    AppMethodBeat.o(285135);
    return paramString3;
  }
  
  public static c a(String paramString1, String paramString2, fye paramfye)
  {
    AppMethodBeat.i(285146);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fyw();
    ((c.a)localObject).otF = new fyx();
    ((c.a)localObject).funcId = 3878;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtsendbannermsg";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    fyy localfyy = new fyy();
    localfyy.username = paramString2;
    localfyy.abWi = null;
    paramString2 = ((c.a)localObject).bEF();
    localObject = (fyw)c.b.b(paramString2.otB);
    ((fyw)localObject).abWs = localfyy;
    ((fyw)localObject).abWb = paramString1;
    try
    {
      ((fyw)localObject).abWx = b.cX(paramfye.toByteArray());
      AppMethodBeat.o(285146);
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
  
  public static c bE(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(285124);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fyn();
    ((c.a)localObject).otF = new fyo();
    ((c.a)localObject).funcId = 3994;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtgetuserinfo";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    ((fyn)c.b.b(((c)localObject).otB)).oPq = paramLinkedList;
    AppMethodBeat.o(285124);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.h
 * JD-Core Version:    0.7.0.1
 */
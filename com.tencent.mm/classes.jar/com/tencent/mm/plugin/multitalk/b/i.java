package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.eri;
import com.tencent.mm.protocal.protobuf.err;
import com.tencent.mm.protocal.protobuf.ers;
import com.tencent.mm.protocal.protobuf.eru;
import com.tencent.mm.protocal.protobuf.erv;
import com.tencent.mm.protocal.protobuf.erw;
import com.tencent.mm.protocal.protobuf.esa;
import com.tencent.mm.protocal.protobuf.esb;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class i
{
  public static d a(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, LinkedList<esc> paramLinkedList, LinkedList<acw> paramLinkedList1)
  {
    AppMethodBeat.i(239035);
    Object localObject2 = new d.a();
    ((d.a)localObject2).iLN = new eru();
    ((d.a)localObject2).iLO = new erv();
    ((d.a)localObject2).funcId = 448;
    ((d.a)localObject2).uri = "/cgi-bin/micromsg-bin/voipmtinvite";
    ((d.a)localObject2).iLP = 0;
    ((d.a)localObject2).respCmdId = 0;
    Object localObject1 = new esc();
    ((esc)localObject1).username = paramString3;
    ((esc)localObject1).Npd = paramString4;
    paramString3 = ((d.a)localObject2).aXF();
    paramString4 = (eru)paramString3.iLK.iLR;
    paramString4.Npm = ((esc)localObject1);
    paramString4.NoW = paramString1;
    paramString4.NoX = paramString2;
    paramString4.Lnw = paramLong;
    paramString1 = new LinkedList();
    paramString2 = paramLinkedList1.iterator();
    while (paramString2.hasNext())
    {
      paramLinkedList1 = (acw)paramString2.next();
      localObject1 = new erw();
      ((erw)localObject1).Loi = paramLinkedList1.Loi;
      localObject2 = paramLinkedList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        esc localesc = (esc)((Iterator)localObject2).next();
        if (paramLinkedList1.openid.equals(localesc.Npd)) {
          ((erw)localObject1).Npo = localesc;
        }
      }
      paramString1.add(localObject1);
    }
    Log.i("MicroMsg.Multitalk.ILinkCGIImp", "invite member cnt:%d", new Object[] { Integer.valueOf(paramString1.size()) });
    paramString4.Npn = paramString1;
    paramString4.Npl = paramLinkedList;
    AppMethodBeat.o(239035);
    return paramString3;
  }
  
  public static d a(String paramString1, String paramString2, eri parameri)
  {
    AppMethodBeat.i(239036);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new esa();
    ((d.a)localObject).iLO = new esb();
    ((d.a)localObject).funcId = 3878;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtsendbannermsg";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    esc localesc = new esc();
    localesc.username = paramString2;
    localesc.Npd = null;
    paramString2 = ((d.a)localObject).aXF();
    localObject = (esa)paramString2.iLK.iLR;
    ((esa)localObject).Npm = localesc;
    ((esa)localObject).NoW = paramString1;
    try
    {
      ((esa)localObject).Npr = b.cD(parameri.toByteArray());
      AppMethodBeat.o(239036);
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
  
  public static d bd(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(239034);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new err();
    ((d.a)localObject).iLO = new ers();
    ((d.a)localObject).funcId = 3994;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/voipmtgetuserinfo";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    ((err)((d)localObject).iLK.iLR).jfN = paramLinkedList;
    AppMethodBeat.o(239034);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.i
 * JD-Core Version:    0.7.0.1
 */
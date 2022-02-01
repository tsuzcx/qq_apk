package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.protocal.protobuf.bfq;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
  extends aa
{
  public String kac;
  
  public n(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(30993);
    ac.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", new Object[] { paramString });
    this.kac = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bfq();
    ((b.a)localObject).hvu = new bfr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
    ((b.a)localObject).funcId = 452;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (bfq)this.fYA.hvr.hvw;
    ((bfq)localObject).fZx = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bs.isNullOrNil(str)) {
        paramString.add(z.FI(str));
      }
    }
    ((bfq)localObject).DPy = paramString;
    ((bfq)localObject).ENJ = paramLinkedList.size();
    AppMethodBeat.o(30993);
  }
  
  public final void ca(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30996);
    if (paramArrayOfByte == null)
    {
      ac.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
      AppMethodBeat.o(30996);
      return;
    }
    b.c localc = this.fYA.hvs;
    try
    {
      localc.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(30996);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte.getMessage());
      ac.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(30996);
    }
  }
  
  public final byte[] eKJ()
  {
    AppMethodBeat.i(30995);
    try
    {
      byte[] arrayOfByte = ((b.b)this.fYA.getReqObj()).toProtoBuf();
      AppMethodBeat.o(30995);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.NetSceneGetUserInfoInApp", localException.getMessage());
      ac.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", localException, "", new Object[0]);
      AppMethodBeat.o(30995);
    }
    return null;
  }
  
  public final bfr eKK()
  {
    if (this.fYA == null) {
      return null;
    }
    return (bfr)this.fYA.hvs.hvw;
  }
  
  public final int getType()
  {
    return 14;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30994);
    ac.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(30994);
      return;
    }
    AppMethodBeat.o(30994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.n
 * JD-Core Version:    0.7.0.1
 */
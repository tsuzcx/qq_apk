package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
  extends aa
{
  public String kxO;
  
  public n(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(30993);
    ae.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", new Object[] { paramString });
    this.kxO = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bkq();
    ((b.a)localObject).hQG = new bkr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
    ((b.a)localObject).funcId = 452;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (bkq)this.gux.hQD.hQJ;
    ((bkq)localObject).gvv = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bu.isNullOrNil(str)) {
        paramString.add(z.Jw(str));
      }
    }
    ((bkq)localObject).FNk = paramString;
    ((bkq)localObject).GQn = paramLinkedList.size();
    AppMethodBeat.o(30993);
  }
  
  public final void ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30996);
    if (paramArrayOfByte == null)
    {
      ae.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
      AppMethodBeat.o(30996);
      return;
    }
    b.c localc = this.gux.hQE;
    try
    {
      localc.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(30996);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte.getMessage());
      ae.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(30996);
    }
  }
  
  public final byte[] fdr()
  {
    AppMethodBeat.i(30995);
    try
    {
      byte[] arrayOfByte = ((b.b)this.gux.getReqObj()).toProtoBuf();
      AppMethodBeat.o(30995);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.NetSceneGetUserInfoInApp", localException.getMessage());
      ae.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", localException, "", new Object[0]);
      AppMethodBeat.o(30995);
    }
    return null;
  }
  
  public final bkr fds()
  {
    if (this.gux == null) {
      return null;
    }
    return (bkr)this.gux.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 14;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30994);
    ae.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(30994);
      return;
    }
    AppMethodBeat.o(30994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.n
 * JD-Core Version:    0.7.0.1
 */
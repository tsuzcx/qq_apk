package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.protocal.protobuf.bjz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class n
  extends aa
{
  public String kuy;
  
  public n(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(30993);
    ad.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", new Object[] { paramString });
    this.kuy = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bjy();
    ((b.a)localObject).hNN = new bjz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
    ((b.a)localObject).funcId = 452;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (bjy)this.grW.hNK.hNQ;
    ((bjy)localObject).gsT = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bt.isNullOrNil(str)) {
        paramString.add(z.IX(str));
      }
    }
    ((bjy)localObject).FuM = paramString;
    ((bjy)localObject).GwN = paramLinkedList.size();
    AppMethodBeat.o(30993);
  }
  
  public final void ch(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30996);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
      AppMethodBeat.o(30996);
      return;
    }
    b.c localc = this.grW.hNL;
    try
    {
      localc.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(30996);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte.getMessage());
      ad.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(30996);
    }
  }
  
  public final byte[] eZD()
  {
    AppMethodBeat.i(30995);
    try
    {
      byte[] arrayOfByte = ((b.b)this.grW.getReqObj()).toProtoBuf();
      AppMethodBeat.o(30995);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.NetSceneGetUserInfoInApp", localException.getMessage());
      ad.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", localException, "", new Object[0]);
      AppMethodBeat.o(30995);
    }
    return null;
  }
  
  public final bjz eZE()
  {
    if (this.grW == null) {
      return null;
    }
    return (bjz)this.grW.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 14;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30994);
    ad.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
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
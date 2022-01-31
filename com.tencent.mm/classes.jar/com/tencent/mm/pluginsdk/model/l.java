package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class l
  extends x
{
  public String hAf;
  
  public l(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(27300);
    ab.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", new Object[] { paramString });
    this.hAf = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new arf();
    ((b.a)localObject).fsY = new arg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
    ((b.a)localObject).funcId = 452;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (arf)this.lFp.fsV.fta;
    ((arf)localObject).npZ = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bo.isNullOrNil(str)) {
        paramString.add(aa.wA(str));
      }
    }
    ((arf)localObject).wou = paramString;
    ((arf)localObject).xaL = paramLinkedList.size();
    AppMethodBeat.o(27300);
  }
  
  public final void bJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27303);
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
      AppMethodBeat.o(27303);
      return;
    }
    b.c localc = this.lFp.fsW;
    try
    {
      localc.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(27303);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte.getMessage());
      ab.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(27303);
    }
  }
  
  public final byte[] dli()
  {
    AppMethodBeat.i(27302);
    try
    {
      byte[] arrayOfByte = ((b.b)this.lFp.getReqObj()).toProtoBuf();
      AppMethodBeat.o(27302);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.NetSceneGetUserInfoInApp", localException.getMessage());
      ab.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", localException, "", new Object[0]);
      AppMethodBeat.o(27302);
    }
    return null;
  }
  
  public final arg dlj()
  {
    if (this.lFp == null) {
      return null;
    }
    return (arg)this.lFp.fsW.fta;
  }
  
  public final int getType()
  {
    return 14;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27301);
    ab.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(27301);
      return;
    }
    AppMethodBeat.o(27301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.l
 * JD-Core Version:    0.7.0.1
 */
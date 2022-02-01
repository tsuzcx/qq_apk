package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends aa
{
  public String appID;
  
  public s(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(30993);
    Log.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", new Object[] { paramString });
    this.appID = paramString;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cer();
    ((d.a)localObject).lBV = new ces();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
    ((d.a)localObject).funcId = 452;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (cer)d.b.b(this.jTk.lBR);
    ((cer)localObject).jUi = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!Util.isNullOrNil(str)) {
        paramString.add(z.ZW(str));
      }
    }
    ((cer)localObject).RIj = paramString;
    ((cer)localObject).Tdc = paramLinkedList.size();
    AppMethodBeat.o(30993);
  }
  
  public final void cS(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30996);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
      AppMethodBeat.o(30996);
      return;
    }
    d.c localc = this.jTk.lBS;
    try
    {
      localc.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(30996);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(30996);
    }
  }
  
  public final int getType()
  {
    return 14;
  }
  
  public final byte[] hha()
  {
    AppMethodBeat.i(30995);
    try
    {
      byte[] arrayOfByte = ((d.b)this.jTk.getReqObj()).toProtoBuf();
      AppMethodBeat.o(30995);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetSceneGetUserInfoInApp", localException.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", localException, "", new Object[0]);
      AppMethodBeat.o(30995);
    }
    return null;
  }
  
  public final ces hhb()
  {
    AppMethodBeat.i(291788);
    if (this.jTk == null)
    {
      AppMethodBeat.o(291788);
      return null;
    }
    ces localces = (ces)d.c.b(this.jTk.lBS);
    AppMethodBeat.o(291788);
    return localces;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30994);
    Log.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(30994);
      return;
    }
    AppMethodBeat.o(30994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.s
 * JD-Core Version:    0.7.0.1
 */
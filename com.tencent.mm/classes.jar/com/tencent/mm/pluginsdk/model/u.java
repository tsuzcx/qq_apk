package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.pluginsdk.model.app.ae;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class u
  extends ae
{
  public String appID;
  
  public u(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(30993);
    Log.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", new Object[] { paramString });
    this.appID = paramString;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cuu();
    ((c.a)localObject).otF = new cuv();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
    ((c.a)localObject).funcId = 452;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (cuu)c.b.b(this.mtC.otB);
    ((cuu)localObject).muA = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!Util.isNullOrNil(str)) {
        paramString.add(w.Sk(str));
      }
    }
    ((cuu)localObject).YFl = paramString;
    ((cuu)localObject).aaqr = paramLinkedList.size();
    AppMethodBeat.o(30993);
  }
  
  public final void cV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30996);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
      AppMethodBeat.o(30996);
      return;
    }
    c.c localc = this.mtC.otC;
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
  
  public final byte[] iIa()
  {
    AppMethodBeat.i(30995);
    try
    {
      byte[] arrayOfByte = ((c.b)this.mtC.getReqObj()).toProtoBuf();
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
  
  public final cuv iIb()
  {
    AppMethodBeat.i(244759);
    if (this.mtC == null)
    {
      AppMethodBeat.o(244759);
      return null;
    }
    cuv localcuv = (cuv)c.c.b(this.mtC.otC);
    AppMethodBeat.o(244759);
    return localcuv;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
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
 * Qualified Name:     com.tencent.mm.pluginsdk.model.u
 * JD-Core Version:    0.7.0.1
 */
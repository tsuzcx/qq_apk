package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.openapi.a;
import com.tencent.mm.protocal.protobuf.ceh;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.protocal.protobuf.gr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ah
  extends ae
{
  List<String> XSQ;
  
  public ah(List<String> paramList)
  {
    AppMethodBeat.i(151814);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ceh();
    ((c.a)localObject).otF = new cei();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getappsetting";
    ((c.a)localObject).funcId = 395;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    this.XSQ = paramList;
    Log.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + paramList.size());
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (str.length() > 0))
      {
        gr localgr = new gr();
        localgr.muA = str;
        ((LinkedList)localObject).add(localgr);
      }
    }
    if (((LinkedList)localObject).size() == 0) {
      Log.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
    }
    paramList = (ceh)c.b.b(this.mtC.otB);
    paramList.aaow = ((LinkedList)localObject);
    paramList.aaov = ((LinkedList)localObject).size();
    AppMethodBeat.o(151814);
  }
  
  public final void cV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151817);
    if (paramArrayOfByte == null)
    {
      Log.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
      AppMethodBeat.o(151817);
      return;
    }
    try
    {
      this.mtC.otC.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151817);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + paramArrayOfByte.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151817);
    }
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final byte[] iIa()
  {
    AppMethodBeat.i(151816);
    try
    {
      byte[] arrayOfByte = ((c.b)this.mtC.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151816);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + localException.getMessage());
      Log.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", localException, "", new Object[0]);
      AppMethodBeat.o(151816);
    }
    return null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151815);
    Log.d("MicroMsg.NetSceneGetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151815);
      return;
    }
    paramString = (cei)c.c.b(this.mtC.otC);
    Log.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + paramString.aaov);
    params = paramString.aaox;
    if ((params == null) || (params.size() == 0))
    {
      Log.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
      AppMethodBeat.o(151815);
      return;
    }
    paramString = a.gxn();
    params = params.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (gq)params.next();
      g localg = h.s(paramArrayOfByte.muA, false, false);
      if (localg != null)
      {
        localg.field_authFlag = paramArrayOfByte.YIo;
        localg.field_openId = paramArrayOfByte.muE;
        boolean bool = paramString.a(localg, new String[0]);
        Log.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramArrayOfByte.muA);
      }
    }
    AppMethodBeat.o(151815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah
 * JD-Core Version:    0.7.0.1
 */
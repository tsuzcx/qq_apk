package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.big;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad
  extends aa
{
  List<String> JWz;
  
  public ad(List<String> paramList)
  {
    AppMethodBeat.i(151814);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bif();
    ((d.a)localObject).iLO = new big();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getappsetting";
    ((d.a)localObject).funcId = 395;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    this.JWz = paramList;
    Log.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + paramList.size());
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (str.length() > 0))
      {
        gk localgk = new gk();
        localgk.hik = str;
        ((LinkedList)localObject).add(localgk);
      }
    }
    if (((LinkedList)localObject).size() == 0) {
      Log.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
    }
    paramList = (bif)this.hhm.iLK.iLR;
    paramList.LSy = ((LinkedList)localObject);
    paramList.LSx = ((LinkedList)localObject).size();
    AppMethodBeat.o(151814);
  }
  
  public final void cB(byte[] paramArrayOfByte)
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
      this.hhm.iLL.fromProtoBuf(paramArrayOfByte);
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
  
  public final byte[] gmB()
  {
    AppMethodBeat.i(151816);
    try
    {
      byte[] arrayOfByte = ((d.b)this.hhm.getReqObj()).toProtoBuf();
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
    paramString = (big)this.hhm.iLL.iLR;
    Log.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + paramString.LSx);
    params = paramString.LSz;
    if ((params == null) || (params.size() == 0))
    {
      Log.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
      AppMethodBeat.o(151815);
      return;
    }
    paramString = a.eAS();
    params = params.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (gj)params.next();
      g localg = h.o(paramArrayOfByte.hik, false, false);
      if (localg != null)
      {
        localg.field_authFlag = paramArrayOfByte.KKl;
        localg.field_openId = paramArrayOfByte.hio;
        boolean bool = paramString.a(localg, new String[0]);
        Log.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramArrayOfByte.hik);
      }
    }
    AppMethodBeat.o(151815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ad
 * JD-Core Version:    0.7.0.1
 */
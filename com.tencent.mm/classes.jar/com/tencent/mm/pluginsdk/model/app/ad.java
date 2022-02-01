package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.protocal.protobuf.bpr;
import com.tencent.mm.protocal.protobuf.fx;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad
  extends aa
{
  List<String> QWS;
  
  public ad(List<String> paramList)
  {
    AppMethodBeat.i(151814);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bpq();
    ((d.a)localObject).lBV = new bpr();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getappsetting";
    ((d.a)localObject).funcId = 395;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    this.QWS = paramList;
    Log.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + paramList.size());
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (str.length() > 0))
      {
        fy localfy = new fy();
        localfy.jUi = str;
        ((LinkedList)localObject).add(localfy);
      }
    }
    if (((LinkedList)localObject).size() == 0) {
      Log.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
    }
    paramList = (bpq)d.b.b(this.jTk.lBR);
    paramList.Tbk = ((LinkedList)localObject);
    paramList.Tbj = ((LinkedList)localObject).size();
    AppMethodBeat.o(151814);
  }
  
  public final void cS(byte[] paramArrayOfByte)
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
      this.jTk.lBS.fromProtoBuf(paramArrayOfByte);
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
  
  public final byte[] hha()
  {
    AppMethodBeat.i(151816);
    try
    {
      byte[] arrayOfByte = ((d.b)this.jTk.getReqObj()).toProtoBuf();
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
    paramString = (bpr)d.c.b(this.jTk.lBS);
    Log.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + paramString.Tbj);
    params = paramString.Tbl;
    if ((params == null) || (params.size() == 0))
    {
      Log.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
      AppMethodBeat.o(151815);
      return;
    }
    paramString = a.fmz();
    params = params.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (fx)params.next();
      g localg = h.o(paramArrayOfByte.jUi, false, false);
      if (localg != null)
      {
        localg.field_authFlag = paramArrayOfByte.RLc;
        localg.field_openId = paramArrayOfByte.jUm;
        boolean bool = paramString.a(localg, new String[0]);
        Log.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramArrayOfByte.jUi);
      }
    }
    AppMethodBeat.o(151815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ad
 * JD-Core Version:    0.7.0.1
 */
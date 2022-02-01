package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.fw;
import com.tencent.mm.protocal.protobuf.fx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad
  extends aa
{
  List<String> ENl;
  
  public ad(List<String> paramList)
  {
    AppMethodBeat.i(151814);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new awf();
    ((b.a)localObject).hNN = new awg();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappsetting";
    ((b.a)localObject).funcId = 395;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    this.ENl = paramList;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + paramList.size());
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (str.length() > 0))
      {
        fx localfx = new fx();
        localfx.gsT = str;
        ((LinkedList)localObject).add(localfx);
      }
    }
    if (((LinkedList)localObject).size() == 0) {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
    }
    paramList = (awf)this.grW.hNK.hNQ;
    paramList.GuV = ((LinkedList)localObject);
    paramList.GuU = ((LinkedList)localObject).size();
    AppMethodBeat.o(151814);
  }
  
  public final void ch(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151817);
    if (paramArrayOfByte == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
      AppMethodBeat.o(151817);
      return;
    }
    try
    {
      this.grW.hNL.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151817);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + paramArrayOfByte.getMessage());
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151817);
    }
  }
  
  public final byte[] eZD()
  {
    AppMethodBeat.i(151816);
    try
    {
      byte[] arrayOfByte = ((b.b)this.grW.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151816);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + localException.getMessage());
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", localException, "", new Object[0]);
      AppMethodBeat.o(151816);
    }
    return null;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151815);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151815);
      return;
    }
    paramString = (awg)this.grW.hNL.hNQ;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + paramString.GuU);
    paramq = paramString.GuW;
    if ((paramq == null) || (paramq.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
      AppMethodBeat.o(151815);
      return;
    }
    paramString = a.dxQ();
    paramq = paramq.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (fw)paramq.next();
      g localg = h.m(paramArrayOfByte.gsT, false, false);
      if (localg != null)
      {
        localg.field_authFlag = paramArrayOfByte.Fyg;
        localg.field_openId = paramArrayOfByte.gsX;
        boolean bool = paramString.a(localg, new String[0]);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramArrayOfByte.gsT);
      }
    }
    AppMethodBeat.o(151815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ad
 * JD-Core Version:    0.7.0.1
 */
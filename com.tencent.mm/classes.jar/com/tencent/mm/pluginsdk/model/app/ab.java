package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.ey;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ab
  extends x
{
  List<String> vLA;
  
  public ab(List<String> paramList)
  {
    AppMethodBeat.i(79377);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new afy();
    ((b.a)localObject).fsY = new afz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappsetting";
    ((b.a)localObject).funcId = 395;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    this.vLA = paramList;
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + paramList.size());
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (str.length() > 0))
      {
        ey localey = new ey();
        localey.npZ = str;
        ((LinkedList)localObject).add(localey);
      }
    }
    if (((LinkedList)localObject).size() == 0) {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
    }
    paramList = (afy)this.lFp.fsV.fta;
    paramList.wZc = ((LinkedList)localObject);
    paramList.wZb = ((LinkedList)localObject).size();
    AppMethodBeat.o(79377);
  }
  
  public final void bJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(79380);
    if (paramArrayOfByte == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
      AppMethodBeat.o(79380);
      return;
    }
    try
    {
      this.lFp.fsW.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(79380);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + paramArrayOfByte.getMessage());
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(79380);
    }
  }
  
  public final byte[] dli()
  {
    AppMethodBeat.i(79379);
    try
    {
      byte[] arrayOfByte = ((b.b)this.lFp.getReqObj()).toProtoBuf();
      AppMethodBeat.o(79379);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + localException.getMessage());
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", localException, "", new Object[0]);
      AppMethodBeat.o(79379);
    }
    return null;
  }
  
  public final int getType()
  {
    return 1;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(79378);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(79378);
      return;
    }
    paramString = (afz)this.lFp.fsW.fta;
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + paramString.wZb);
    paramq = paramString.wZd;
    if ((paramq == null) || (paramq.size() == 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
      AppMethodBeat.o(79378);
      return;
    }
    paramString = a.cac();
    paramq = paramq.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (ex)paramq.next();
      f localf = g.ca(paramArrayOfByte.npZ, false);
      if (localf != null)
      {
        localf.field_authFlag = paramArrayOfByte.wrd;
        localf.field_openId = paramArrayOfByte.nrU;
        boolean bool = paramString.a(localf, new String[0]);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramArrayOfByte.npZ);
      }
    }
    AppMethodBeat.o(79378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ab
 * JD-Core Version:    0.7.0.1
 */
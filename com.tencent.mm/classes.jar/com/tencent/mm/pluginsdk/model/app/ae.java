package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae
  extends aa
{
  List<String> Diy;
  
  public ae(List<String> paramList)
  {
    AppMethodBeat.i(151814);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ash();
    ((b.a)localObject).hvu = new asi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappsetting";
    ((b.a)localObject).funcId = 395;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    this.Diy = paramList;
    ac.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + paramList.size());
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (str.length() > 0))
      {
        fs localfs = new fs();
        localfs.fZx = str;
        ((LinkedList)localObject).add(localfs);
      }
    }
    if (((LinkedList)localObject).size() == 0) {
      ac.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
    }
    paramList = (ash)this.fYA.hvr.hvw;
    paramList.ELR = ((LinkedList)localObject);
    paramList.ELQ = ((LinkedList)localObject).size();
    AppMethodBeat.o(151814);
  }
  
  public final void ca(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151817);
    if (paramArrayOfByte == null)
    {
      ac.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
      AppMethodBeat.o(151817);
      return;
    }
    try
    {
      this.fYA.hvs.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151817);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + paramArrayOfByte.getMessage());
      ac.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151817);
    }
  }
  
  public final byte[] eKJ()
  {
    AppMethodBeat.i(151816);
    try
    {
      byte[] arrayOfByte = ((b.b)this.fYA.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151816);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + localException.getMessage());
      ac.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", localException, "", new Object[0]);
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
    ac.d("MicroMsg.NetSceneGetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151815);
      return;
    }
    paramString = (asi)this.fYA.hvs.hvw;
    ac.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + paramString.ELQ);
    paramq = paramString.ELS;
    if ((paramq == null) || (paramq.size() == 0))
    {
      ac.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
      AppMethodBeat.o(151815);
      return;
    }
    paramString = a.dny();
    paramq = paramq.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (fr)paramq.next();
      g localg = h.k(paramArrayOfByte.fZx, false, false);
      if (localg != null)
      {
        localg.field_authFlag = paramArrayOfByte.DSN;
        localg.field_openId = paramArrayOfByte.fZB;
        boolean bool = paramString.a(localg, new String[0]);
        ac.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramArrayOfByte.fZx);
      }
    }
    AppMethodBeat.o(151815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ae
 * JD-Core Version:    0.7.0.1
 */
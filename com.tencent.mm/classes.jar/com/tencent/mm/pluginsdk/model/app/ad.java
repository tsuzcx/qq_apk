package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.fw;
import com.tencent.mm.protocal.protobuf.fx;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad
  extends aa
{
  List<String> FfI;
  
  public ad(List<String> paramList)
  {
    AppMethodBeat.i(151814);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new awv();
    ((b.a)localObject).hQG = new aww();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappsetting";
    ((b.a)localObject).funcId = 395;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    this.FfI = paramList;
    ae.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + paramList.size());
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (str.length() > 0))
      {
        fx localfx = new fx();
        localfx.gvv = str;
        ((LinkedList)localObject).add(localfx);
      }
    }
    if (((LinkedList)localObject).size() == 0) {
      ae.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
    }
    paramList = (awv)this.gux.hQD.hQJ;
    paramList.GOu = ((LinkedList)localObject);
    paramList.GOt = ((LinkedList)localObject).size();
    AppMethodBeat.o(151814);
  }
  
  public final void ck(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151817);
    if (paramArrayOfByte == null)
    {
      ae.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
      AppMethodBeat.o(151817);
      return;
    }
    try
    {
      this.gux.hQE.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151817);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + paramArrayOfByte.getMessage());
      ae.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151817);
    }
  }
  
  public final byte[] fdr()
  {
    AppMethodBeat.i(151816);
    try
    {
      byte[] arrayOfByte = ((b.b)this.gux.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151816);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + localException.getMessage());
      ae.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", localException, "", new Object[0]);
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
    ae.d("MicroMsg.NetSceneGetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151815);
      return;
    }
    paramString = (aww)this.gux.hQE.hQJ;
    ae.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + paramString.GOt);
    paramq = paramString.GOv;
    if ((paramq == null) || (paramq.size() == 0))
    {
      ae.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
      AppMethodBeat.o(151815);
      return;
    }
    paramString = a.dBg();
    paramq = paramq.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (fw)paramq.next();
      g localg = h.m(paramArrayOfByte.gvv, false, false);
      if (localg != null)
      {
        localg.field_authFlag = paramArrayOfByte.FQE;
        localg.field_openId = paramArrayOfByte.gvz;
        boolean bool = paramString.a(localg, new String[0]);
        ae.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramArrayOfByte.gvv);
      }
    }
    AppMethodBeat.o(151815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ad
 * JD-Core Version:    0.7.0.1
 */
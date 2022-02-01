package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.fp;
import com.tencent.mm.protocal.protobuf.fq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae
  extends aa
{
  List<String> BQk;
  
  public ae(List<String> paramList)
  {
    AppMethodBeat.i(151814);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new apd();
    ((b.a)localObject).gUV = new ape();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappsetting";
    ((b.a)localObject).funcId = 395;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fUF = ((b.a)localObject).atI();
    this.BQk = paramList;
    ad.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + paramList.size());
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (str.length() > 0))
      {
        fq localfq = new fq();
        localfq.fVC = str;
        ((LinkedList)localObject).add(localfq);
      }
    }
    if (((LinkedList)localObject).size() == 0) {
      ad.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
    }
    paramList = (apd)this.fUF.gUS.gUX;
    paramList.DqP = ((LinkedList)localObject);
    paramList.DqO = ((LinkedList)localObject).size();
    AppMethodBeat.o(151814);
  }
  
  public final void cb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151817);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
      AppMethodBeat.o(151817);
      return;
    }
    try
    {
      this.fUF.gUT.fromProtoBuf(paramArrayOfByte);
      AppMethodBeat.o(151817);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + paramArrayOfByte.getMessage());
      ad.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(151817);
    }
  }
  
  public final byte[] evp()
  {
    AppMethodBeat.i(151816);
    try
    {
      byte[] arrayOfByte = ((b.b)this.fUF.getReqObj()).toProtoBuf();
      AppMethodBeat.o(151816);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + localException.getMessage());
      ad.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", localException, "", new Object[0]);
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
    ad.d("MicroMsg.NetSceneGetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
      AppMethodBeat.o(151815);
      return;
    }
    paramString = (ape)this.fUF.gUT.gUX;
    ad.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + paramString.DqO);
    paramq = paramString.DqQ;
    if ((paramq == null) || (paramq.size() == 0))
    {
      ad.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
      AppMethodBeat.o(151815);
      return;
    }
    paramString = a.cZQ();
    paramq = paramq.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (fp)paramq.next();
      g localg = h.j(paramArrayOfByte.fVC, false, false);
      if (localg != null)
      {
        localg.field_authFlag = paramArrayOfByte.CAr;
        localg.field_openId = paramArrayOfByte.fVG;
        boolean bool = paramString.a(localg, new String[0]);
        ad.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramArrayOfByte.fVC);
      }
    }
    AppMethodBeat.o(151815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ae
 * JD-Core Version:    0.7.0.1
 */
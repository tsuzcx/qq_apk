package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.protocal.c.abi;
import com.tencent.mm.protocal.c.abj;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class af
  extends x
{
  List<String> rUM;
  
  public af(List<String> paramList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new abi();
    ((b.a)localObject).ecI = new abj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getappsetting";
    ((b.a)localObject).ecG = 395;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    this.rUM = paramList;
    y.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + paramList.size());
    localObject = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if ((str != null) && (str.length() > 0))
      {
        dx localdx = new dx();
        localdx.kRX = str;
        ((LinkedList)localObject).add(localdx);
      }
    }
    if (((LinkedList)localObject).size() == 0) {
      y.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
    }
    paramList = (abi)this.jvQ.ecE.ecN;
    paramList.taM = ((LinkedList)localObject);
    paramList.taL = ((LinkedList)localObject).size();
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetAppSetting", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + paramInt2 + ", errCode = " + paramInt3);
    }
    for (;;)
    {
      return;
      paramString = (abj)this.jvQ.ecF.ecN;
      y.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + paramString.taL);
      paramq = paramString.taN;
      if ((paramq == null) || (paramq.size() == 0))
      {
        y.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
        return;
      }
      paramString = a.brn();
      paramq = paramq.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (dw)paramq.next();
        f localf = g.by(paramArrayOfByte.kRX, false);
        if (localf != null)
        {
          localf.field_authFlag = paramArrayOfByte.sxz;
          localf.field_openId = paramArrayOfByte.kTU;
          boolean bool = paramString.a(localf, new String[0]);
          y.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bool + ", appId = " + paramArrayOfByte.kRX);
        }
      }
    }
  }
  
  public final void bi(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
      return;
    }
    try
    {
      this.jvQ.ecF.A(paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + paramArrayOfByte.getMessage());
      y.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", paramArrayOfByte, "", new Object[0]);
    }
  }
  
  public final byte[] ckB()
  {
    try
    {
      byte[] arrayOfByte = ((b.b)this.jvQ.Kv()).HG();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + localException.getMessage());
      y.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", localException, "", new Object[0]);
    }
    return null;
  }
  
  public final int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.af
 * JD-Core Version:    0.7.0.1
 */
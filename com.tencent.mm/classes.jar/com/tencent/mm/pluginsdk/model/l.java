package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.protocal.c.als;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class l
  extends x
{
  public String rTu;
  
  public l(String paramString, LinkedList<String> paramLinkedList)
  {
    y.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", new Object[] { paramString });
    this.rTu = paramString;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new als();
    ((b.a)localObject).ecI = new alt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
    ((b.a)localObject).ecG = 452;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (als)this.jvQ.ecE.ecN;
    ((als)localObject).kRX = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!bk.bl(str)) {
        paramString.add(aa.pj(str));
      }
    }
    ((als)localObject).svn = paramString;
    ((als)localObject).tct = paramLinkedList.size();
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      y.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    }
  }
  
  public final void bi(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
      return;
    }
    b.c localc = this.jvQ.ecF;
    try
    {
      localc.A(paramArrayOfByte);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte.getMessage());
      y.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", paramArrayOfByte, "", new Object[0]);
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
      y.e("MicroMsg.NetSceneGetUserInfoInApp", localException.getMessage());
      y.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", localException, "", new Object[0]);
    }
    return null;
  }
  
  public final int getType()
  {
    return 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.l
 * JD-Core Version:    0.7.0.1
 */
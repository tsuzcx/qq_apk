package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aii;
import com.tencent.mm.protocal.c.aij;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a
  extends m
  implements k
{
  private RandomAccessFile aRL;
  private f dmL;
  private int ebK;
  private String filePath;
  private int hYm;
  String url;
  
  public a(String paramString)
  {
    this.url = paramString;
    this.hYm = 0;
    this.ebK = 0;
    this.filePath = null;
    this.aRL = null;
  }
  
  private boolean d(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((this.aRL != null) || (this.filePath != null))
      {
        y.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
        return false;
      }
      this.filePath = com.tencent.mm.pluginsdk.h.a.a.Wq(paramString);
      if (this.filePath == null)
      {
        y.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + paramString + "]");
        return false;
      }
    }
    try
    {
      this.aRL = new RandomAccessFile(this.filePath, "rw");
      return false;
    }
    catch (Exception paramString)
    {
      try
      {
        this.aRL.seek(paramInt);
        this.aRL.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        return true;
      }
      catch (IOException paramString)
      {
        y.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + paramString.getMessage());
      }
      paramString = paramString;
      y.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + paramString.getMessage());
      return false;
    }
  }
  
  protected final int Ka()
  {
    return 10;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = new b.a();
    paramf.ecH = new aii();
    paramf.ecI = new aij();
    paramf.uri = "/cgi-bin/micromsg-bin/getpsmimg";
    paramf.ecG = 141;
    paramf.ecJ = 29;
    paramf.ecK = 1000000029;
    paramf = paramf.Kt();
    aii localaii = (aii)paramf.ecE.ecN;
    localaii.URL = this.url;
    localaii.sDT = this.hYm;
    y.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.hYm + " totallen:" + this.ebK);
    return a(parame, paramf, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    do
    {
      return;
      paramq = (aij)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      y.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.hYm + " Resp[ totallen:" + paramq.sDS + " bufSize:" + paramq.ndi.tFK + " ]");
      if (paramq.sDS > 0) {
        this.ebK = paramq.sDS;
      }
      if (!d(this.url, paramq.ndi.tFM.oY, this.hYm))
      {
        this.dmL.onSceneEnd(3, -1, paramString, this);
        return;
      }
      paramInt1 = this.hYm;
      this.hYm = (paramq.ndi.tFK + paramInt1);
      if (this.ebK <= this.hYm)
      {
        y.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.ebK);
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
    } while (a(this.edc, this.dmL) >= 0);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    paramq = ((aii)((com.tencent.mm.ah.b)paramq).ecE.ecN).URL;
    int i;
    if (paramq == null) {
      i = 0;
    }
    while (i == 0)
    {
      y.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
      return m.b.eds;
      if (paramq.indexOf("weixin://") != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((this.hYm < 0) || (this.ebK < 0))
    {
      y.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.hYm + " total:" + this.ebK);
      return m.b.eds;
    }
    if (this.hYm == 0)
    {
      if (this.ebK != 0)
      {
        y.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.hYm + " total:" + this.ebK);
        return m.b.eds;
      }
    }
    else if (this.hYm >= this.ebK)
    {
      y.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.hYm + " total:" + this.ebK);
      return m.b.eds;
    }
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 141;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.a
 * JD-Core Version:    0.7.0.1
 */
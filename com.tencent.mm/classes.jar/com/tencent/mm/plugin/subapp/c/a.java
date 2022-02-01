package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a
  extends n
  implements k
{
  private g callback;
  private RandomAccessFile file;
  private String filePath;
  private int gTY;
  String url;
  private int yCK;
  
  public a(String paramString)
  {
    this.url = paramString;
    this.yCK = 0;
    this.gTY = 0;
    this.filePath = null;
    this.file = null;
  }
  
  private boolean c(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(28918);
    if (paramInt == 0)
    {
      if ((this.file != null) || (this.filePath != null))
      {
        ad.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
        AppMethodBeat.o(28918);
        return false;
      }
      this.filePath = com.tencent.mm.pluginsdk.i.a.a.aBu(paramString);
      if (this.filePath == null)
      {
        ad.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + paramString + "]");
        AppMethodBeat.o(28918);
        return false;
      }
    }
    try
    {
      this.file = i.cS(this.filePath, true);
      return false;
    }
    catch (Exception paramString)
    {
      try
      {
        this.file.seek(paramInt);
        this.file.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        AppMethodBeat.o(28918);
        return true;
      }
      catch (IOException paramString)
      {
        ad.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + paramString.getMessage());
        AppMethodBeat.o(28918);
      }
      paramString = paramString;
      ad.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + paramString.getMessage());
      AppMethodBeat.o(28918);
      return false;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(28915);
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new axq();
    paramg.gUV = new axr();
    paramg.uri = "/cgi-bin/micromsg-bin/getpsmimg";
    paramg.funcId = 141;
    paramg.reqCmdId = 29;
    paramg.respCmdId = 1000000029;
    paramg = paramg.atI();
    axq localaxq = (axq)paramg.gUS.gUX;
    localaxq.URL = this.url;
    localaxq.CNt = this.yCK;
    ad.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.yCK + " totallen:" + this.gTY);
    int i = dispatch(parame, paramg, this);
    AppMethodBeat.o(28915);
    return i;
  }
  
  public final int getType()
  {
    return 141;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28917);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramq = (axr)((com.tencent.mm.al.b)paramq).gUT.gUX;
    ad.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.yCK + " Resp[ totallen:" + paramq.Dwy + " bufSize:" + paramq.uKT.getILen() + " ]");
    if (paramq.Dwy > 0) {
      this.gTY = paramq.Dwy;
    }
    if (!c(this.url, paramq.uKT.getBuffer().wA, this.yCK))
    {
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramInt1 = this.yCK;
    this.yCK = (paramq.uKT.getILen() + paramInt1);
    if (this.gTY <= this.yCK)
    {
      ad.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.gTY);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(28917);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(28916);
    paramq = ((axq)((com.tencent.mm.al.b)paramq).gUS.gUX).URL;
    int i;
    if (paramq == null) {
      i = 0;
    }
    while (i == 0)
    {
      ad.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
      paramq = n.b.gVC;
      AppMethodBeat.o(28916);
      return paramq;
      if (paramq.indexOf("weixin://") != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((this.yCK < 0) || (this.gTY < 0))
    {
      ad.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.yCK + " total:" + this.gTY);
      paramq = n.b.gVC;
      AppMethodBeat.o(28916);
      return paramq;
    }
    if (this.yCK == 0)
    {
      if (this.gTY != 0)
      {
        ad.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.yCK + " total:" + this.gTY);
        paramq = n.b.gVC;
        AppMethodBeat.o(28916);
        return paramq;
      }
    }
    else if (this.yCK >= this.gTY)
    {
      ad.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.yCK + " total:" + this.gTY);
      paramq = n.b.gVC;
      AppMethodBeat.o(28916);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(28916);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.a
 * JD-Core Version:    0.7.0.1
 */
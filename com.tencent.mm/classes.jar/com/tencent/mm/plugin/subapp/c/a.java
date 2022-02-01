package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a
  extends n
  implements k
{
  private int ByX;
  private f callback;
  private RandomAccessFile file;
  private String filePath;
  private int hPI;
  String url;
  
  public a(String paramString)
  {
    this.url = paramString;
    this.ByX = 0;
    this.hPI = 0;
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
        ae.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
        AppMethodBeat.o(28918);
        return false;
      }
      this.filePath = com.tencent.mm.pluginsdk.k.a.a.aNI(paramString);
      if (this.filePath == null)
      {
        ae.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + paramString + "]");
        AppMethodBeat.o(28918);
        return false;
      }
    }
    try
    {
      this.file = o.dg(this.filePath, true);
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
        ae.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + paramString.getMessage());
        AppMethodBeat.o(28918);
      }
      paramString = paramString;
      ae.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + paramString.getMessage());
      AppMethodBeat.o(28918);
      return false;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28915);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new bgc();
    paramf.hQG = new bgd();
    paramf.uri = "/cgi-bin/micromsg-bin/getpsmimg";
    paramf.funcId = 141;
    paramf.hQH = 29;
    paramf.respCmdId = 1000000029;
    paramf = paramf.aDS();
    bgc localbgc = (bgc)paramf.hQD.hQJ;
    localbgc.URL = this.url;
    localbgc.GeT = this.ByX;
    ae.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.ByX + " totallen:" + this.hPI);
    int i = dispatch(parame, paramf, this);
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
      ae.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramq = (bgd)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    ae.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.ByX + " Resp[ totallen:" + paramq.GUL + " bufSize:" + paramq.xsE.getILen() + " ]");
    if (paramq.GUL > 0) {
      this.hPI = paramq.GUL;
    }
    if (!c(this.url, paramq.xsE.getBuffer().zr, this.ByX))
    {
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramInt1 = this.ByX;
    this.ByX = (paramq.xsE.getILen() + paramInt1);
    if (this.hPI <= this.ByX)
    {
      ae.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.hPI);
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
    paramq = ((bgc)((com.tencent.mm.ak.b)paramq).hQD.hQJ).URL;
    int i;
    if (paramq == null) {
      i = 0;
    }
    while (i == 0)
    {
      ae.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
      paramq = n.b.hRj;
      AppMethodBeat.o(28916);
      return paramq;
      if (paramq.indexOf("weixin://") != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((this.ByX < 0) || (this.hPI < 0))
    {
      ae.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.ByX + " total:" + this.hPI);
      paramq = n.b.hRj;
      AppMethodBeat.o(28916);
      return paramq;
    }
    if (this.ByX == 0)
    {
      if (this.hPI != 0)
      {
        ae.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.ByX + " total:" + this.hPI);
        paramq = n.b.hRj;
        AppMethodBeat.o(28916);
        return paramq;
      }
    }
    else if (this.ByX >= this.hPI)
    {
      ae.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.ByX + " total:" + this.hPI);
      paramq = n.b.hRj;
      AppMethodBeat.o(28916);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(28916);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.sdk.platformtools.ac;
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
  private int hux;
  String url;
  private int zPY;
  
  public a(String paramString)
  {
    this.url = paramString;
    this.zPY = 0;
    this.hux = 0;
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
        ac.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
        AppMethodBeat.o(28918);
        return false;
      }
      this.filePath = com.tencent.mm.pluginsdk.i.a.a.aGM(paramString);
      if (this.filePath == null)
      {
        ac.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + paramString + "]");
        AppMethodBeat.o(28918);
        return false;
      }
    }
    try
    {
      this.file = i.cY(this.filePath, true);
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
        ac.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + paramString.getMessage());
        AppMethodBeat.o(28918);
      }
      paramString = paramString;
      ac.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + paramString.getMessage());
      AppMethodBeat.o(28918);
      return false;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(28915);
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new bbi();
    paramg.hvu = new bbj();
    paramg.uri = "/cgi-bin/micromsg-bin/getpsmimg";
    paramg.funcId = 141;
    paramg.reqCmdId = 29;
    paramg.respCmdId = 1000000029;
    paramg = paramg.aAz();
    bbi localbbi = (bbi)paramg.hvr.hvw;
    localbbi.URL = this.url;
    localbbi.EfV = this.zPY;
    ac.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.zPY + " totallen:" + this.hux);
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
      ac.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramq = (bbj)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    ac.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.zPY + " Resp[ totallen:" + paramq.ERT + " bufSize:" + paramq.vTK.getILen() + " ]");
    if (paramq.ERT > 0) {
      this.hux = paramq.ERT;
    }
    if (!c(this.url, paramq.vTK.getBuffer().xy, this.zPY))
    {
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramInt1 = this.zPY;
    this.zPY = (paramq.vTK.getILen() + paramInt1);
    if (this.hux <= this.zPY)
    {
      ac.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.hux);
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
    paramq = ((bbi)((com.tencent.mm.ak.b)paramq).hvr.hvw).URL;
    int i;
    if (paramq == null) {
      i = 0;
    }
    while (i == 0)
    {
      ac.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
      paramq = n.b.hwb;
      AppMethodBeat.o(28916);
      return paramq;
      if (paramq.indexOf("weixin://") != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((this.zPY < 0) || (this.hux < 0))
    {
      ac.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.zPY + " total:" + this.hux);
      paramq = n.b.hwb;
      AppMethodBeat.o(28916);
      return paramq;
    }
    if (this.zPY == 0)
    {
      if (this.hux != 0)
      {
        ac.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.zPY + " total:" + this.hux);
        paramq = n.b.hwb;
        AppMethodBeat.o(28916);
        return paramq;
      }
    }
    else if (this.zPY >= this.hux)
    {
      ac.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.zPY + " total:" + this.hux);
      paramq = n.b.hwb;
      AppMethodBeat.o(28916);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(28916);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.a
 * JD-Core Version:    0.7.0.1
 */
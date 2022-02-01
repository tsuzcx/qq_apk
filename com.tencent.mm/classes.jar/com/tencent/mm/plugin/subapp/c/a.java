package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a
  extends n
  implements k
{
  private int Bhz;
  private f callback;
  private RandomAccessFile file;
  private String filePath;
  private int hMP;
  String url;
  
  public a(String paramString)
  {
    this.url = paramString;
    this.Bhz = 0;
    this.hMP = 0;
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
      this.filePath = com.tencent.mm.pluginsdk.k.a.a.aMm(paramString);
      if (this.filePath == null)
      {
        ad.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + paramString + "]");
        AppMethodBeat.o(28918);
        return false;
      }
    }
    try
    {
      this.file = i.dd(this.filePath, true);
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
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(28915);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new bfm();
    paramf.hNN = new bfn();
    paramf.uri = "/cgi-bin/micromsg-bin/getpsmimg";
    paramf.funcId = 141;
    paramf.hNO = 29;
    paramf.respCmdId = 1000000029;
    paramf = paramf.aDC();
    bfm localbfm = (bfm)paramf.hNK.hNQ;
    localbfm.URL = this.url;
    localbfm.FMu = this.Bhz;
    ad.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.Bhz + " totallen:" + this.hMP);
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
      ad.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramq = (bfn)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    ad.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.Bhz + " Resp[ totallen:" + paramq.GBl + " bufSize:" + paramq.xcN.getILen() + " ]");
    if (paramq.GBl > 0) {
      this.hMP = paramq.GBl;
    }
    if (!c(this.url, paramq.xcN.getBuffer().zr, this.Bhz))
    {
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramInt1 = this.Bhz;
    this.Bhz = (paramq.xcN.getILen() + paramInt1);
    if (this.hMP <= this.Bhz)
    {
      ad.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.hMP);
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
    paramq = ((bfm)((com.tencent.mm.al.b)paramq).hNK.hNQ).URL;
    int i;
    if (paramq == null) {
      i = 0;
    }
    while (i == 0)
    {
      ad.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
      paramq = n.b.hOq;
      AppMethodBeat.o(28916);
      return paramq;
      if (paramq.indexOf("weixin://") != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((this.Bhz < 0) || (this.hMP < 0))
    {
      ad.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.Bhz + " total:" + this.hMP);
      paramq = n.b.hOq;
      AppMethodBeat.o(28916);
      return paramq;
    }
    if (this.Bhz == 0)
    {
      if (this.hMP != 0)
      {
        ad.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.Bhz + " total:" + this.hMP);
        paramq = n.b.hOq;
        AppMethodBeat.o(28916);
        return paramq;
      }
    }
    else if (this.Bhz >= this.hMP)
    {
      ad.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.Bhz + " total:" + this.hMP);
      paramq = n.b.hOq;
      AppMethodBeat.o(28916);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(28916);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.a
 * JD-Core Version:    0.7.0.1
 */
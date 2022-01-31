package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.anl;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a
  extends m
  implements k
{
  private RandomAccessFile aZl;
  private f callback;
  private String filePath;
  private int fsd;
  private int sWX;
  String url;
  
  public a(String paramString)
  {
    this.url = paramString;
    this.sWX = 0;
    this.fsd = 0;
    this.filePath = null;
    this.aZl = null;
  }
  
  private boolean d(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(25239);
    if (paramInt == 0)
    {
      if ((this.aZl != null) || (this.filePath != null))
      {
        ab.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
        AppMethodBeat.o(25239);
        return false;
      }
      this.filePath = com.tencent.mm.pluginsdk.h.a.a.alU(paramString);
      if (this.filePath == null)
      {
        ab.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + paramString + "]");
        AppMethodBeat.o(25239);
        return false;
      }
    }
    try
    {
      this.aZl = new RandomAccessFile(this.filePath, "rw");
      return false;
    }
    catch (Exception paramString)
    {
      try
      {
        this.aZl.seek(paramInt);
        this.aZl.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        AppMethodBeat.o(25239);
        return true;
      }
      catch (IOException paramString)
      {
        ab.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + paramString.getMessage());
        AppMethodBeat.o(25239);
      }
      paramString = paramString;
      ab.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + paramString.getMessage());
      AppMethodBeat.o(25239);
      return false;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25236);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new anl();
    paramf.fsY = new anm();
    paramf.uri = "/cgi-bin/micromsg-bin/getpsmimg";
    paramf.funcId = 141;
    paramf.reqCmdId = 29;
    paramf.respCmdId = 1000000029;
    paramf = paramf.ado();
    anl localanl = (anl)paramf.fsV.fta;
    localanl.URL = this.url;
    localanl.wzS = this.sWX;
    ab.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.sWX + " totallen:" + this.fsd);
    int i = dispatch(parame, paramf, this);
    AppMethodBeat.o(25236);
    return i;
  }
  
  public final int getType()
  {
    return 141;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25238);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25238);
      return;
    }
    paramq = (anm)((com.tencent.mm.ai.b)paramq).fsW.fta;
    ab.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.sWX + " Resp[ totallen:" + paramq.wzR + " bufSize:" + paramq.pIA.getILen() + " ]");
    if (paramq.wzR > 0) {
      this.fsd = paramq.wzR;
    }
    if (!d(this.url, paramq.pIA.getBuffer().pW, this.sWX))
    {
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(25238);
      return;
    }
    paramInt1 = this.sWX;
    this.sWX = (paramq.pIA.getILen() + paramInt1);
    if (this.fsd <= this.sWX)
    {
      ab.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.fsd);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25238);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(25238);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(25237);
    paramq = ((anl)((com.tencent.mm.ai.b)paramq).fsV.fta).URL;
    int i;
    if (paramq == null) {
      i = 0;
    }
    while (i == 0)
    {
      ab.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
      paramq = m.b.ftv;
      AppMethodBeat.o(25237);
      return paramq;
      if (paramq.indexOf("weixin://") != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((this.sWX < 0) || (this.fsd < 0))
    {
      ab.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.sWX + " total:" + this.fsd);
      paramq = m.b.ftv;
      AppMethodBeat.o(25237);
      return paramq;
    }
    if (this.sWX == 0)
    {
      if (this.fsd != 0)
      {
        ab.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.sWX + " total:" + this.fsd);
        paramq = m.b.ftv;
        AppMethodBeat.o(25237);
        return paramq;
      }
    }
    else if (this.sWX >= this.fsd)
    {
      ab.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.sWX + " total:" + this.fsd);
      paramq = m.b.ftv;
      AppMethodBeat.o(25237);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(25237);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.b.a
 * JD-Core Version:    0.7.0.1
 */
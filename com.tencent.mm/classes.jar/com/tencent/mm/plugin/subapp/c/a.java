package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a
  extends q
  implements m
{
  private int FJI;
  private i callback;
  private RandomAccessFile file;
  private String filePath;
  private int iKP;
  String url;
  
  public a(String paramString)
  {
    this.url = paramString;
    this.FJI = 0;
    this.iKP = 0;
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
        Log.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
        AppMethodBeat.o(28918);
        return false;
      }
      this.filePath = com.tencent.mm.pluginsdk.k.a.a.bek(paramString);
      if (this.filePath == null)
      {
        Log.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + paramString + "]");
        AppMethodBeat.o(28918);
        return false;
      }
    }
    try
    {
      this.file = com.tencent.mm.vfs.s.dB(this.filePath, true);
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
        Log.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + paramString.getMessage());
        AppMethodBeat.o(28918);
      }
      paramString = paramString;
      Log.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + paramString.getMessage());
      AppMethodBeat.o(28918);
      return false;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(28915);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new bry();
    parami.iLO = new brz();
    parami.uri = "/cgi-bin/micromsg-bin/getpsmimg";
    parami.funcId = 141;
    parami.iLP = 29;
    parami.respCmdId = 1000000029;
    parami = parami.aXF();
    bry localbry = (bry)parami.iLK.iLR;
    localbry.URL = this.url;
    localbry.KZk = this.FJI;
    Log.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.FJI + " totallen:" + this.iKP);
    int i = dispatch(paramg, parami, this);
    AppMethodBeat.o(28915);
    return i;
  }
  
  public final int getType()
  {
    return 141;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28917);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    params = (brz)((d)params).iLL.iLR;
    Log.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.FJI + " Resp[ totallen:" + params.LZd + " bufSize:" + params.BsI.getILen() + " ]");
    if (params.LZd > 0) {
      this.iKP = params.LZd;
    }
    if (!c(this.url, params.BsI.getBuffer().zy, this.FJI))
    {
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramInt1 = this.FJI;
    this.FJI = (params.BsI.getILen() + paramInt1);
    if (this.iKP <= this.FJI)
    {
      Log.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.iKP);
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
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(28916);
    params = ((bry)((d)params).iLK.iLR).URL;
    int i;
    if (params == null) {
      i = 0;
    }
    while (i == 0)
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
      params = q.b.iMr;
      AppMethodBeat.o(28916);
      return params;
      if (params.indexOf("weixin://") != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((this.FJI < 0) || (this.iKP < 0))
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.FJI + " total:" + this.iKP);
      params = q.b.iMr;
      AppMethodBeat.o(28916);
      return params;
    }
    if (this.FJI == 0)
    {
      if (this.iKP != 0)
      {
        Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.FJI + " total:" + this.iKP);
        params = q.b.iMr;
        AppMethodBeat.o(28916);
        return params;
      }
    }
    else if (this.FJI >= this.iKP)
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.FJI + " total:" + this.iKP);
      params = q.b.iMr;
      AppMethodBeat.o(28916);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(28916);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.a
 * JD-Core Version:    0.7.0.1
 */
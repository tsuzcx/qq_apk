package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bzu;
import com.tencent.mm.protocal.protobuf.bzv;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a
  extends q
  implements m
{
  private int MdF;
  private i callback;
  private RandomAccessFile file;
  private String filePath;
  private int lAW;
  String url;
  
  public a(String paramString)
  {
    this.url = paramString;
    this.MdF = 0;
    this.lAW = 0;
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
      this.filePath = com.tencent.mm.pluginsdk.l.a.a.bqG(paramString);
      if (this.filePath == null)
      {
        Log.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + paramString + "]");
        AppMethodBeat.o(28918);
        return false;
      }
    }
    try
    {
      this.file = u.dO(this.filePath, true);
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
    parami.lBU = new bzu();
    parami.lBV = new bzv();
    parami.uri = "/cgi-bin/micromsg-bin/getpsmimg";
    parami.funcId = 141;
    parami.lBW = 29;
    parami.respCmdId = 1000000029;
    parami = parami.bgN();
    bzu localbzu = (bzu)d.b.b(parami.lBR);
    localbzu.URL = this.url;
    localbzu.Sat = this.MdF;
    Log.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.MdF + " totallen:" + this.lAW);
    int i = dispatch(paramg, parami, this);
    AppMethodBeat.o(28915);
    return i;
  }
  
  public final int getType()
  {
    return 141;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28917);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    params = (bzv)d.c.b(((d)params).lBS);
    Log.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.MdF + " Resp[ totallen:" + params.Tix + " bufSize:" + params.Hnc.Ufv + " ]");
    if (params.Tix > 0) {
      this.lAW = params.Tix;
    }
    if (!c(this.url, params.Hnc.Tkb.UH, this.MdF))
    {
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramInt1 = this.MdF;
    this.MdF = (params.Hnc.Ufv + paramInt1);
    if (this.lAW <= this.MdF)
    {
      Log.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.lAW);
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
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(28916);
    params = ((bzu)d.b.b(((d)params).lBR)).URL;
    int i;
    if (params == null) {
      i = 0;
    }
    while (i == 0)
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
      params = q.b.lCy;
      AppMethodBeat.o(28916);
      return params;
      if (params.indexOf("weixin://") != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((this.MdF < 0) || (this.lAW < 0))
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.MdF + " total:" + this.lAW);
      params = q.b.lCy;
      AppMethodBeat.o(28916);
      return params;
    }
    if (this.MdF == 0)
    {
      if (this.lAW != 0)
      {
        Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.MdF + " total:" + this.lAW);
        params = q.b.lCy;
        AppMethodBeat.o(28916);
        return params;
      }
    }
    else if (this.MdF >= this.lAW)
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.MdF + " total:" + this.lAW);
      params = q.b.lCy;
      AppMethodBeat.o(28916);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(28916);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.a
 * JD-Core Version:    0.7.0.1
 */
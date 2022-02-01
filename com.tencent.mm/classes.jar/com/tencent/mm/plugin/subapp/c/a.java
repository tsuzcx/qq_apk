package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a
  extends p
  implements m
{
  private int SEV;
  private h callback;
  private RandomAccessFile file;
  private String filePath;
  private int osy;
  String url;
  
  public a(String paramString)
  {
    this.url = paramString;
    this.SEV = 0;
    this.osy = 0;
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
      this.filePath = com.tencent.mm.pluginsdk.k.a.a.bqv(paramString);
      if (this.filePath == null)
      {
        Log.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + paramString + "]");
        AppMethodBeat.o(28918);
        return false;
      }
    }
    try
    {
      this.file = y.eA(this.filePath, true);
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
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(28915);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new cpd();
    paramh.otF = new cpe();
    paramh.uri = "/cgi-bin/micromsg-bin/getpsmimg";
    paramh.funcId = 141;
    paramh.otG = 29;
    paramh.respCmdId = 1000000029;
    paramh = paramh.bEF();
    cpd localcpd = (cpd)c.b.b(paramh.otB);
    localcpd.URL = this.url;
    localcpd.YYs = this.SEV;
    Log.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.SEV + " totallen:" + this.osy);
    int i = dispatch(paramg, paramh, this);
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
    params = (cpe)c.c.b(((c)params).otC);
    Log.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.SEV + " Resp[ totallen:" + params.aavV + " bufSize:" + params.NkQ.abwJ + " ]");
    if (params.aavV > 0) {
      this.osy = params.aavV;
    }
    if (!c(this.url, params.NkQ.aaxD.Op, this.SEV))
    {
      this.callback.onSceneEnd(3, -1, paramString, this);
      AppMethodBeat.o(28917);
      return;
    }
    paramInt1 = this.SEV;
    this.SEV = (params.NkQ.abwJ + paramInt1);
    if (this.osy <= this.SEV)
    {
      Log.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.osy);
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
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(28916);
    params = ((cpd)c.b.b(((c)params).otB)).URL;
    int i;
    if (params == null) {
      i = 0;
    }
    while (i == 0)
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
      params = p.b.oui;
      AppMethodBeat.o(28916);
      return params;
      if (params.indexOf("weixin://") != 0) {
        i = 0;
      } else {
        i = 1;
      }
    }
    if ((this.SEV < 0) || (this.osy < 0))
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.SEV + " total:" + this.osy);
      params = p.b.oui;
      AppMethodBeat.o(28916);
      return params;
    }
    if (this.SEV == 0)
    {
      if (this.osy != 0)
      {
        Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.SEV + " total:" + this.osy);
        params = p.b.oui;
        AppMethodBeat.o(28916);
        return params;
      }
    }
    else if (this.SEV >= this.osy)
    {
      Log.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.SEV + " total:" + this.osy);
      params = p.b.oui;
      AppMethodBeat.o(28916);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(28916);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.a
 * JD-Core Version:    0.7.0.1
 */
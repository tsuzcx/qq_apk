package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.protocal.protobuf.cvm;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.protocal.protobuf.fzj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class b
  extends p
  implements m
{
  private h MpS;
  private String SIY;
  public fzj SJf;
  private final String TAG;
  public int cqG;
  private c otw;
  
  public b(String paramString)
  {
    AppMethodBeat.i(29270);
    this.TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    this.cqG = -1;
    if (!Util.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.SIY = paramString;
      paramString = new c.a();
      paramString.otE = new cvl();
      paramString.otF = new cvm();
      paramString.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
      paramString.funcId = 548;
      paramString.otG = 0;
      paramString.respCmdId = 0;
      this.otw = paramString.bEF();
      AppMethodBeat.o(29270);
      return;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(29271);
    this.MpS = paramh;
    ((cvl)c.b.b(this.otw.otB)).YWC = this.SIY;
    int i = dispatch(paramg, this.otw, this);
    AppMethodBeat.o(29271);
    return i;
  }
  
  public final int getType()
  {
    return 548;
  }
  
  public final boolean hBv()
  {
    AppMethodBeat.i(29273);
    if ((this.SJf != null) && (!Util.isNullOrNil(this.SJf.abWK)))
    {
      AppMethodBeat.o(29273);
      return true;
    }
    AppMethodBeat.o(29273);
    return false;
  }
  
  public final boolean isComplete()
  {
    return (this.SJf != null) && (this.SJf.oOu == 1);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29272);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cvm)c.c.b(this.otw.otC);
      if (params.ZkH != null) {
        this.cqG = params.ZkH.abpC;
      }
      this.SJf = params.ZkF;
    }
    for (;;)
    {
      this.MpS.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29272);
      return;
      Log.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.b
 * JD-Core Version:    0.7.0.1
 */
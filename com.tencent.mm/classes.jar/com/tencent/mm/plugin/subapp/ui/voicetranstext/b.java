package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class b
  extends q
  implements m
{
  private i AAQ;
  private String FNA;
  public esm FNH;
  public int FNL;
  private final String TAG;
  private d iLF;
  
  public b(String paramString)
  {
    AppMethodBeat.i(29270);
    this.TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    this.FNL = -1;
    if (!Util.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.FNA = paramString;
      paramString = new d.a();
      paramString.iLN = new bxo();
      paramString.iLO = new bxp();
      paramString.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
      paramString.funcId = 548;
      paramString.iLP = 0;
      paramString.respCmdId = 0;
      this.iLF = paramString.aXF();
      AppMethodBeat.o(29270);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29271);
    this.AAQ = parami;
    ((bxo)this.iLF.iLK.iLR).KXr = this.FNA;
    int i = dispatch(paramg, this.iLF, this);
    AppMethodBeat.o(29271);
    return i;
  }
  
  public final boolean ftu()
  {
    AppMethodBeat.i(29273);
    if ((this.FNH != null) && (!Util.isNullOrNil(this.FNH.NpE)))
    {
      AppMethodBeat.o(29273);
      return true;
    }
    AppMethodBeat.o(29273);
    return false;
  }
  
  public final int getType()
  {
    return 548;
  }
  
  public final boolean isComplete()
  {
    return (this.FNH != null) && (this.FNH.jeU == 1);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29272);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (bxp)this.iLF.iLL.iLR;
      if (params.Llm != null) {
        this.FNL = params.Llm.MML;
      }
      this.FNH = params.Llk;
    }
    for (;;)
    {
      this.AAQ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29272);
      return;
      Log.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.b
 * JD-Core Version:    0.7.0.1
 */
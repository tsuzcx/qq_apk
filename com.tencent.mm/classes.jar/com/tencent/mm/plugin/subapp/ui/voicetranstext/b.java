package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.fcx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class b
  extends q
  implements m
{
  private i GtS;
  private String MhB;
  public fcx MhI;
  public int MhM;
  private final String TAG;
  private d lBM;
  
  public b(String paramString)
  {
    AppMethodBeat.i(29270);
    this.TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    this.MhM = -1;
    if (!Util.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.MhB = paramString;
      paramString = new d.a();
      paramString.lBU = new cfi();
      paramString.lBV = new cfj();
      paramString.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
      paramString.funcId = 548;
      paramString.lBW = 0;
      paramString.respCmdId = 0;
      this.lBM = paramString.bgN();
      AppMethodBeat.o(29270);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29271);
    this.GtS = parami;
    ((cfi)d.b.b(this.lBM.lBR)).RYD = this.MhB;
    int i = dispatch(paramg, this.lBM, this);
    AppMethodBeat.o(29271);
    return i;
  }
  
  public final int getType()
  {
    return 548;
  }
  
  public final boolean ghU()
  {
    AppMethodBeat.i(29273);
    if ((this.MhI != null) && (!Util.isNullOrNil(this.MhI.UCA)))
    {
      AppMethodBeat.o(29273);
      return true;
    }
    AppMethodBeat.o(29273);
    return false;
  }
  
  public final boolean isComplete()
  {
    return (this.MhI != null) && (this.MhI.lVs == 1);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29272);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (cfj)d.c.b(this.lBM.lBS);
      if (params.Smv != null) {
        this.MhM = params.Smv.TYF;
      }
      this.MhI = params.Smt;
    }
    for (;;)
    {
      this.GtS.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29272);
      return;
      Log.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.b
 * JD-Core Version:    0.7.0.1
 */
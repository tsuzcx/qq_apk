package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcn;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;

public final class b
  extends n
  implements k
{
  private final String TAG;
  private com.tencent.mm.al.b gUN;
  private g ubG;
  public dld yGE;
  public int yGI;
  private String yGw;
  
  public b(String paramString)
  {
    AppMethodBeat.i(29270);
    this.TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    this.yGI = -1;
    if (!bt.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.yGw = paramString;
      paramString = new b.a();
      paramString.gUU = new bcn();
      paramString.gUV = new bco();
      paramString.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
      paramString.funcId = 548;
      paramString.reqCmdId = 0;
      paramString.respCmdId = 0;
      this.gUN = paramString.atI();
      AppMethodBeat.o(29270);
      return;
    }
  }
  
  public final boolean dMx()
  {
    AppMethodBeat.i(29273);
    if ((this.yGE != null) && (!bt.isNullOrNil(this.yGE.EAP)))
    {
      AppMethodBeat.o(29273);
      return true;
    }
    AppMethodBeat.o(29273);
    return false;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29271);
    this.ubG = paramg;
    ((bcn)this.gUN.gUS.gUX).CLB = this.yGw;
    int i = dispatch(parame, this.gUN, this);
    AppMethodBeat.o(29271);
    return i;
  }
  
  public final int getType()
  {
    return 548;
  }
  
  public final boolean isComplete()
  {
    return (this.yGE != null) && (this.yGE.hno == 1);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29272);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bco)this.gUN.gUT.gUX;
      if (paramq.CYc != null) {
        this.yGI = paramq.CYc.Ebx;
      }
      this.yGE = paramq.CYa;
    }
    for (;;)
    {
      this.ubG.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29272);
      return;
      ad.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.b
 * JD-Core Version:    0.7.0.1
 */
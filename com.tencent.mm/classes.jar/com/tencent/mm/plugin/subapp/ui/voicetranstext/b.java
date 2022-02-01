package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.protocal.protobuf.ckk;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;

public final class b
  extends n
  implements k
{
  private final String TAG;
  private com.tencent.mm.ak.b hvm;
  private g vkE;
  private String zTK;
  public dqu zTS;
  public int zTW;
  
  public b(String paramString)
  {
    AppMethodBeat.i(29270);
    this.TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    this.zTW = -1;
    if (!bs.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.zTK = paramString;
      paramString = new b.a();
      paramString.hvt = new bgf();
      paramString.hvu = new bgg();
      paramString.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
      paramString.funcId = 548;
      paramString.reqCmdId = 0;
      paramString.respCmdId = 0;
      this.hvm = paramString.aAz();
      AppMethodBeat.o(29270);
      return;
    }
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29271);
    this.vkE = paramg;
    ((bgf)this.hvm.hvr.hvw).Eee = this.zTK;
    int i = dispatch(parame, this.hvm, this);
    AppMethodBeat.o(29271);
    return i;
  }
  
  public final boolean eaX()
  {
    AppMethodBeat.i(29273);
    if ((this.zTS != null) && (!bs.isNullOrNil(this.zTS.FYc)))
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
    return (this.zTS != null) && (this.zTS.hNR == 1);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29272);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bgg)this.hvm.hvs.hvw;
      if (paramq.EqL != null) {
        this.zTW = paramq.EqL.Fys;
      }
      this.zTS = paramq.EqJ;
    }
    for (;;)
    {
      this.vkE.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29272);
      return;
      ac.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;

public final class b
  extends n
  implements k
{
  public int BlA;
  private String Blp;
  public dwo Blw;
  private final String TAG;
  private com.tencent.mm.al.b hNF;
  private f wpW;
  
  public b(String paramString)
  {
    AppMethodBeat.i(29270);
    this.TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    this.BlA = -1;
    if (!bt.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.Blp = paramString;
      paramString = new b.a();
      paramString.hNM = new bkn();
      paramString.hNN = new bko();
      paramString.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
      paramString.funcId = 548;
      paramString.hNO = 0;
      paramString.respCmdId = 0;
      this.hNF = paramString.aDC();
      AppMethodBeat.o(29270);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29271);
    this.wpW = paramf;
    ((bkn)this.hNF.hNK.hNQ).FKD = this.Blp;
    int i = dispatch(parame, this.hNF, this);
    AppMethodBeat.o(29271);
    return i;
  }
  
  public final boolean eno()
  {
    AppMethodBeat.i(29273);
    if ((this.Blw != null) && (!bt.isNullOrNil(this.Blw.HIY)))
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
    return (this.Blw != null) && (this.Blw.ihf == 1);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29272);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bko)this.hNF.hNL.hNQ;
      if (paramq.FXV != null) {
        this.BlA = paramq.FXV.Hix;
      }
      this.Blw = paramq.FXT;
    }
    for (;;)
    {
      this.wpW.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29272);
      return;
      ad.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.b
 * JD-Core Version:    0.7.0.1
 */
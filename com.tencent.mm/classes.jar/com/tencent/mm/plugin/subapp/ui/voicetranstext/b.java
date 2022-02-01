package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blf;
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import junit.framework.Assert;

public final class b
  extends n
  implements k
{
  private String BCO;
  public dyf BCV;
  public int BCZ;
  private final String TAG;
  private com.tencent.mm.ak.b hQy;
  private f wFF;
  
  public b(String paramString)
  {
    AppMethodBeat.i(29270);
    this.TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    this.BCZ = -1;
    if (!bu.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.BCO = paramString;
      paramString = new b.a();
      paramString.hQF = new blf();
      paramString.hQG = new blg();
      paramString.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
      paramString.funcId = 548;
      paramString.hQH = 0;
      paramString.respCmdId = 0;
      this.hQy = paramString.aDS();
      AppMethodBeat.o(29270);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29271);
    this.wFF = paramf;
    ((blf)this.hQy.hQD.hQJ).Gdc = this.BCO;
    int i = dispatch(parame, this.hQy, this);
    AppMethodBeat.o(29271);
    return i;
  }
  
  public final boolean eqW()
  {
    AppMethodBeat.i(29273);
    if ((this.BCV != null) && (!bu.isNullOrNil(this.BCV.Idg)))
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
    return (this.BCV != null) && (this.BCV.ijY == 1);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29272);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (blg)this.hQy.hQE.hQJ;
      if (paramq.Gqu != null) {
        this.BCZ = paramq.Gqu.HBX;
      }
      this.BCV = paramq.Gqs;
    }
    for (;;)
    {
      this.wFF.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29272);
      return;
      ae.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.b
 * JD-Core Version:    0.7.0.1
 */
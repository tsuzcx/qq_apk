package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class b
  extends m
  implements k
{
  private final String TAG;
  private com.tencent.mm.ai.b fsQ;
  private f peg;
  private String sZY;
  public cri tah;
  public int tal;
  
  public b(String paramString)
  {
    AppMethodBeat.i(25580);
    this.TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    this.tal = -1;
    if (!bo.isNullOrNil(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.sZY = paramString;
      paramString = new b.a();
      paramString.fsX = new aru();
      paramString.fsY = new arv();
      paramString.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
      paramString.funcId = 548;
      paramString.reqCmdId = 0;
      paramString.respCmdId = 0;
      this.fsQ = paramString.ado();
      AppMethodBeat.o(25580);
      return;
    }
  }
  
  public final boolean cHd()
  {
    AppMethodBeat.i(25583);
    if ((this.tah != null) && (!bo.isNullOrNil(this.tah.xZS)))
    {
      AppMethodBeat.o(25583);
      return true;
    }
    AppMethodBeat.o(25583);
    return false;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25581);
    this.peg = paramf;
    ((aru)this.fsQ.fsV.fta).wAs = this.sZY;
    int i = dispatch(parame, this.fsQ, this);
    AppMethodBeat.o(25581);
    return i;
  }
  
  public final int getType()
  {
    return 548;
  }
  
  public final boolean isComplete()
  {
    return (this.tah != null) && (this.tah.fKi == 1);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25582);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (arv)this.fsQ.fsW.fta;
      if (paramq.wLK != null) {
        this.tal = paramq.wLK.xEz;
      }
      this.tah = paramq.wLI;
    }
    for (;;)
    {
      this.peg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25582);
      return;
      ab.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.b
 * JD-Core Version:    0.7.0.1
 */
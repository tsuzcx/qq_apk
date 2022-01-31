package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends m
  implements k
{
  public static int tad = 1;
  public static int tae = 2;
  public static int taf = 3;
  private int Scene;
  private String cGY;
  private b fsQ;
  private String mFileName;
  public int mState;
  private f peg;
  private String sZY;
  private int sZZ;
  private crd taa;
  private long tab;
  private String tac;
  public cri tah;
  public cox tai;
  public bqi taj;
  int tak;
  
  public a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    AppMethodBeat.i(25573);
    this.mState = -1;
    a(paramString1, paramInt1, paramInt2, paramLong, paramString2, 0, "", "");
    AppMethodBeat.o(25573);
  }
  
  public a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(25575);
    this.mState = -1;
    a(paramString1, paramInt1, paramInt2, paramLong, paramString2, paramInt3, paramString3, paramString4);
    AppMethodBeat.o(25575);
  }
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(25572);
    this.mState = -1;
    a(paramString1, paramInt, -1, -1L, paramString2, 0, "", "");
    AppMethodBeat.o(25572);
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(25574);
    this.mState = -1;
    a(paramString1, paramInt1, -1, -1L, paramString2, paramInt2, paramString3, paramString4);
    AppMethodBeat.o(25574);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(25576);
    b.a locala = new b.a();
    locala.fsX = new th();
    locala.fsY = new ti();
    locala.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
    locala.funcId = 546;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.mFileName = paramString2;
    this.fsQ = locala.ado();
    ab.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (paramInt2 >= 0) {
      this.taa = d.bm(paramInt2, paramString2);
    }
    if (paramLong > 0L) {
      this.tab = paramLong;
    }
    this.sZY = paramString1;
    this.sZZ = paramInt1;
    this.Scene = paramInt3;
    this.tac = paramString3;
    this.cGY = paramString4;
    AppMethodBeat.o(25576);
  }
  
  public final boolean cHd()
  {
    AppMethodBeat.i(25579);
    if ((this.tah != null) && (!bo.isNullOrNil(this.tah.xZS)))
    {
      AppMethodBeat.o(25579);
      return true;
    }
    AppMethodBeat.o(25579);
    return false;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(25577);
    this.peg = paramf;
    paramf = (th)this.fsQ.fsV.fta;
    paramf.wAs = this.sZY;
    paramf.pIx = this.sZZ;
    paramf.wLH = this.taa;
    paramf.pIG = this.tab;
    paramf.Scene = this.Scene;
    paramf.num = this.tac;
    paramf.nul = this.cGY;
    int i = dispatch(parame, this.fsQ, this);
    AppMethodBeat.o(25577);
    return i;
  }
  
  public final int getType()
  {
    return 546;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25578);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ti)this.fsQ.fsW.fta;
      if (paramq == null)
      {
        AppMethodBeat.o(25578);
        return;
      }
      this.tah = paramq.wLI;
      this.mState = paramq.jJS;
      this.tai = paramq.wLJ;
      this.taj = paramq.wLK;
      this.tak = paramq.wLL;
    }
    for (;;)
    {
      this.peg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25578);
      return;
      ab.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.sZY });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.a
 * JD-Core Version:    0.7.0.1
 */
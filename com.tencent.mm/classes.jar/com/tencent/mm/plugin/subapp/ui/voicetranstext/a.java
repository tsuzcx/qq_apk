package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.protocal.protobuf.aab;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.eoe;
import com.tencent.mm.protocal.protobuf.esg;
import com.tencent.mm.protocal.protobuf.esm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends q
  implements m
{
  public static int FNE = 1;
  public static int FNF = 2;
  public static int FNG = 3;
  private i AAQ;
  private String FNA;
  private int FNB;
  private esg FNC;
  private long FND;
  public esm FNH;
  public eoe FNI;
  public did FNJ;
  int FNK;
  private int Scene;
  private String dkU;
  private String dkV;
  private com.tencent.mm.ak.d iLF;
  private String mFileName;
  public int mState;
  
  public a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    AppMethodBeat.i(29263);
    this.mState = -1;
    a(paramString1, paramInt1, paramInt2, paramLong, paramString2, 0, "", "");
    AppMethodBeat.o(29263);
  }
  
  public a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29265);
    this.mState = -1;
    a(paramString1, paramInt1, paramInt2, paramLong, paramString2, paramInt3, paramString3, paramString4);
    AppMethodBeat.o(29265);
  }
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29262);
    this.mState = -1;
    a(paramString1, paramInt, -1, -1L, paramString2, 0, "", "");
    AppMethodBeat.o(29262);
  }
  
  public a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29264);
    this.mState = -1;
    a(paramString1, paramInt1, -1, -1L, paramString2, paramInt2, paramString3, paramString4);
    AppMethodBeat.o(29264);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29266);
    d.a locala = new d.a();
    locala.iLN = new aaa();
    locala.iLO = new aab();
    locala.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
    locala.funcId = 546;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.mFileName = paramString2;
    this.iLF = locala.aXF();
    Log.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (paramInt2 >= 0) {
      this.FNC = d.cz(paramInt2, paramString2);
    }
    if (paramLong > 0L) {
      this.FND = paramLong;
    }
    this.FNA = paramString1;
    this.FNB = paramInt1;
    this.Scene = paramInt3;
    this.dkU = paramString3;
    this.dkV = paramString4;
    AppMethodBeat.o(29266);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29267);
    this.AAQ = parami;
    parami = (aaa)this.iLF.iLK.iLR;
    parami.KXr = this.FNA;
    parami.BsF = this.FNB;
    parami.Llj = this.FNC;
    parami.Brn = this.FND;
    parami.Scene = this.Scene;
    parami.xNH = this.dkU;
    parami.xNG = this.dkV;
    int i = dispatch(paramg, this.iLF, this);
    AppMethodBeat.o(29267);
    return i;
  }
  
  public final boolean ftu()
  {
    AppMethodBeat.i(29269);
    if ((this.FNH != null) && (!Util.isNullOrNil(this.FNH.NpE)))
    {
      AppMethodBeat.o(29269);
      return true;
    }
    AppMethodBeat.o(29269);
    return false;
  }
  
  public final int getType()
  {
    return 546;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29268);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (aab)this.iLF.iLL.iLR;
      if (params == null)
      {
        AppMethodBeat.o(29268);
        return;
      }
      this.FNH = params.Llk;
      this.mState = params.oTW;
      this.FNI = params.Lll;
      this.FNJ = params.Llm;
      this.FNK = params.Lln;
    }
    for (;;)
    {
      this.AAQ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29268);
      return;
      Log.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.FNA });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.a
 * JD-Core Version:    0.7.0.1
 */
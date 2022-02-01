package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aae;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.eym;
import com.tencent.mm.protocal.protobuf.fcr;
import com.tencent.mm.protocal.protobuf.fcx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends q
  implements m
{
  public static int MhF = 1;
  public static int MhG = 2;
  public static int MhH = 3;
  private int CPw;
  private i GtS;
  private String MhB;
  private int MhC;
  private fcr MhD;
  private long MhE;
  public fcx MhI;
  public eym MhJ;
  public drv MhK;
  int MhL;
  private String fcC;
  private String fcD;
  private com.tencent.mm.an.d lBM;
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
    locala.lBU = new aae();
    locala.lBV = new aaf();
    locala.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
    locala.funcId = 546;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.mFileName = paramString2;
    this.lBM = locala.bgN();
    Log.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (paramInt2 >= 0) {
      this.MhD = d.cA(paramInt2, paramString2);
    }
    if (paramLong > 0L) {
      this.MhE = paramLong;
    }
    this.MhB = paramString1;
    this.MhC = paramInt1;
    this.CPw = paramInt3;
    this.fcC = paramString3;
    this.fcD = paramString4;
    AppMethodBeat.o(29266);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(29267);
    this.GtS = parami;
    parami = (aae)d.b.b(this.lBM.lBR);
    parami.RYD = this.MhB;
    parami.HmZ = this.MhC;
    parami.Sms = this.MhD;
    parami.HlH = this.MhE;
    parami.CPw = this.CPw;
    parami.CRR = this.fcC;
    parami.CRQ = this.fcD;
    int i = dispatch(paramg, this.lBM, this);
    AppMethodBeat.o(29267);
    return i;
  }
  
  public final int getType()
  {
    return 546;
  }
  
  public final boolean ghU()
  {
    AppMethodBeat.i(29269);
    if ((this.MhI != null) && (!Util.isNullOrNil(this.MhI.UCA)))
    {
      AppMethodBeat.o(29269);
      return true;
    }
    AppMethodBeat.o(29269);
    return false;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29268);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (aaf)d.c.b(this.lBM.lBS);
      if (params == null)
      {
        AppMethodBeat.o(29268);
        return;
      }
      this.MhI = params.Smt;
      this.mState = params.rVU;
      this.MhJ = params.Smu;
      this.MhK = params.Smv;
      this.MhL = params.Smw;
    }
    for (;;)
    {
      this.GtS.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29268);
      return;
      Log.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.MhB });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.a
 * JD-Core Version:    0.7.0.1
 */
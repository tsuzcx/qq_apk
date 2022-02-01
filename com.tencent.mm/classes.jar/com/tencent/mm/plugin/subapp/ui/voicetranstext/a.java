package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckk;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dqp;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.wk;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class a
  extends n
  implements k
{
  public static int zTP = 1;
  public static int zTQ = 2;
  public static int zTR = 3;
  private int Scene;
  private String dvw;
  private b hvm;
  private String mFileName;
  public int mState;
  private g vkE;
  private String zTK;
  private int zTL;
  private dqp zTM;
  private long zTN;
  private String zTO;
  public dqu zTS;
  public dns zTT;
  public ckk zTU;
  int zTV;
  
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
    b.a locala = new b.a();
    locala.hvt = new wk();
    locala.hvu = new wl();
    locala.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
    locala.funcId = 546;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.mFileName = paramString2;
    this.hvm = locala.aAz();
    ac.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (paramInt2 >= 0) {
      this.zTM = d.cb(paramInt2, paramString2);
    }
    if (paramLong > 0L) {
      this.zTN = paramLong;
    }
    this.zTK = paramString1;
    this.zTL = paramInt1;
    this.Scene = paramInt3;
    this.zTO = paramString3;
    this.dvw = paramString4;
    AppMethodBeat.o(29266);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(29267);
    this.vkE = paramg;
    paramg = (wk)this.hvm.hvr.hvw;
    paramg.Eee = this.zTK;
    paramg.vTH = this.zTL;
    paramg.EqI = this.zTM;
    paramg.vTQ = this.zTN;
    paramg.Scene = this.Scene;
    paramg.tlK = this.zTO;
    paramg.tlJ = this.dvw;
    int i = dispatch(parame, this.hvm, this);
    AppMethodBeat.o(29267);
    return i;
  }
  
  public final boolean eaX()
  {
    AppMethodBeat.i(29269);
    if ((this.zTS != null) && (!bs.isNullOrNil(this.zTS.FYc)))
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29268);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (wl)this.hvm.hvs.hvw;
      if (paramq == null)
      {
        AppMethodBeat.o(29268);
        return;
      }
      this.zTS = paramq.EqJ;
      this.mState = paramq.ndj;
      this.zTT = paramq.EqK;
      this.zTU = paramq.EqL;
      this.zTV = paramq.EqM;
    }
    for (;;)
    {
      this.vkE.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29268);
      return;
      ac.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.zTK });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.a
 * JD-Core Version:    0.7.0.1
 */
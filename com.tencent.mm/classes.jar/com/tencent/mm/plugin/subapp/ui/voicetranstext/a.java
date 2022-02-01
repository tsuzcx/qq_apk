package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ace;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.protocal.protobuf.fuf;
import com.tencent.mm.protocal.protobuf.fzc;
import com.tencent.mm.protocal.protobuf.fzj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  extends p
  implements m
{
  public static int SJc = 1;
  public static int SJd = 2;
  public static int SJe = 3;
  private int IJG;
  private h MpS;
  private String SIY;
  private int SIZ;
  private fzc SJa;
  private long SJb;
  public fzj SJf;
  public fuf SJg;
  public ekq SJh;
  int SJi;
  private String hgk;
  private String hgl;
  private String mFileName;
  public int mState;
  private c otw;
  
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
    c.a locala = new c.a();
    locala.otE = new ace();
    locala.otF = new acf();
    locala.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
    locala.funcId = 546;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.mFileName = paramString2;
    this.otw = locala.bEF();
    Log.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (paramInt2 >= 0) {
      this.SJa = d.dn(paramInt2, paramString2);
    }
    if (paramLong > 0L) {
      this.SJb = paramLong;
    }
    this.SIY = paramString1;
    this.SIZ = paramInt1;
    this.IJG = paramInt3;
    this.hgk = paramString3;
    this.hgl = paramString4;
    AppMethodBeat.o(29266);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(29267);
    this.MpS = paramh;
    paramh = (ace)c.b.b(this.otw.otB);
    paramh.YWC = this.SIY;
    paramh.NkN = this.SIZ;
    paramh.ZkE = this.SJa;
    paramh.Njv = this.SJb;
    paramh.IJG = this.IJG;
    paramh.IMh = this.hgk;
    paramh.IMg = this.hgl;
    int i = dispatch(paramg, this.otw, this);
    AppMethodBeat.o(29267);
    return i;
  }
  
  public final int getType()
  {
    return 546;
  }
  
  public final boolean hBv()
  {
    AppMethodBeat.i(29269);
    if ((this.SJf != null) && (!Util.isNullOrNil(this.SJf.abWK)))
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
      params = (acf)c.c.b(this.otw.otC);
      if (params == null)
      {
        AppMethodBeat.o(29268);
        return;
      }
      this.SJf = params.ZkF;
      this.mState = params.vhk;
      this.SJg = params.ZkG;
      this.SJh = params.ZkH;
      this.SJi = params.ZkI;
    }
    for (;;)
    {
      this.MpS.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29268);
      return;
      Log.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.SIY });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.a
 * JD-Core Version:    0.7.0.1
 */
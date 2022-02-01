package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.modelvoice.b;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.fuf;
import com.tencent.mm.protocal.protobuf.fug;
import com.tencent.mm.protocal.protobuf.fuh;
import com.tencent.mm.protocal.protobuf.fzc;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class c
  extends p
  implements m
{
  private int IJG;
  private h MpS;
  private String SIY;
  private fzc SJa;
  public fuf SJg;
  private final String TAG;
  private String hgk;
  private String hgl;
  private String mFileName;
  private com.tencent.mm.am.c otw;
  
  public c(c paramc)
  {
    AppMethodBeat.i(29274);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    this.SIY = paramc.SIY;
    this.SJa = paramc.SJa;
    this.SJg = paramc.SJg;
    this.mFileName = paramc.mFileName;
    this.IJG = paramc.IJG;
    this.hgk = paramc.hgk;
    this.hgl = paramc.hgl;
    Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramc.IJG), paramc.hgk, paramc.hgl });
    hBw();
    AppMethodBeat.o(29274);
  }
  
  public c(String paramString1, fuf paramfuf, int paramInt, String paramString2)
  {
    AppMethodBeat.i(29275);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.SIY = paramString1;
      this.SJg = paramfuf;
      this.SJa = d.dn(paramInt, paramString2);
      this.mFileName = paramString2;
      hBw();
      AppMethodBeat.o(29275);
      return;
    }
  }
  
  public c(String paramString1, fuf paramfuf, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(29276);
    this.TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    if (paramString2 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", new Object[] { Integer.valueOf(paramInt2), paramString3, paramString4 });
      this.SIY = paramString1;
      this.SJg = paramfuf;
      this.SJa = d.dn(paramInt1, paramString2);
      this.mFileName = paramString2;
      this.IJG = paramInt2;
      this.hgk = paramString3;
      this.hgl = paramString4;
      hBw();
      AppMethodBeat.o(29276);
      return;
    }
  }
  
  private void hBw()
  {
    AppMethodBeat.i(29279);
    c.a locala = new c.a();
    locala.otE = new fug();
    locala.otF = new fuh();
    locala.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
    locala.funcId = 547;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.otw = locala.bEF();
    AppMethodBeat.o(29279);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(29277);
    this.MpS = paramh;
    if ((!Util.isNullOrNil(this.mFileName)) && (!Util.isNullOrNil(this.SIY)) && (this.SJg != null) && (this.SJa != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
      AppMethodBeat.o(29277);
      return -1;
    }
    fug localfug = (fug)c.b.b(this.otw.otB);
    localfug.YWC = this.SIY;
    localfug.ZkE = this.SJa;
    localfug.ZkG = this.SJg;
    paramh = this.mFileName;
    i = this.SJg.NkO;
    int j = this.SJg.NkP;
    gol localgol = new gol();
    Object localObject = com.tencent.mm.modelvoice.s.QH(paramh);
    paramh = localgol;
    if (localObject != null)
    {
      localObject = ((b)localObject).eQ(i, j);
      paramh = localgol;
      if (localObject != null) {
        paramh = w.aN(((com.tencent.mm.modelvoice.g)localObject).buf);
      }
    }
    localfug.NkQ = paramh;
    localfug.IJG = this.IJG;
    localfug.IMh = this.hgk;
    localfug.IMg = this.hgl;
    i = dispatch(paramg, this.otw, this);
    AppMethodBeat.o(29277);
    return i;
  }
  
  public final int getType()
  {
    return 547;
  }
  
  public final boolean hBx()
  {
    return (this.SJg == null) || (this.SJg.NkP <= 0);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29278);
    hBx();
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.SJg = ((fuh)c.c.b(this.otw.otC)).ZkG;
      this.MpS.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (!hBx()) {
        break label130;
      }
      if (this.SJg == null) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneUploadVoiceForTrans", "succeeed finish: %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(29278);
      return;
      Log.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      break;
    }
    label130:
    AppMethodBeat.o(29278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.voicetranstext.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ftn;
import com.tencent.mm.protocal.protobuf.fto;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.y;
import java.util.UUID;

public final class c
  extends p
  implements m
{
  private int Wjc;
  public String Wjd;
  public boolean Wje;
  private h callback;
  private String clientId;
  private int encodeType;
  private String filename;
  public int hBm;
  MTimerHandler orP;
  public boolean pdm;
  private boolean pfn;
  private com.tencent.mm.am.c rr;
  public String talker;
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(30061);
    this.filename = null;
    this.encodeType = 0;
    this.pdm = false;
    this.Wjc = 0;
    this.pfn = false;
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30060);
        long l1 = y.bEl(c.a(c.this));
        long l2 = l1 - c.b(c.this);
        Log.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[] { c.a(c.this), Long.valueOf(l1), Integer.valueOf(c.b(c.this)), Boolean.valueOf(c.c(c.this)), Long.valueOf(l2) });
        if ((l2 < 3300L) && (!c.c(c.this)))
        {
          AppMethodBeat.o(30060);
          return true;
        }
        if ((c.c(c.this)) && (l2 <= 0L))
        {
          AppMethodBeat.o(30060);
          return false;
        }
        if (c.this.doScene(c.d(c.this), c.e(c.this)) == -1) {
          c.e(c.this).onSceneEnd(3, -1, "doScene failed", c.this);
        }
        AppMethodBeat.o(30060);
        return false;
      }
    }, true);
    this.hBm = paramInt;
    this.talker = paramString2;
    this.filename = paramString1;
    this.encodeType = 0;
    this.clientId = UUID.randomUUID().toString();
    AppMethodBeat.o(30061);
  }
  
  private static String d(gol paramgol)
  {
    AppMethodBeat.i(30065);
    if ((paramgol != null) && (paramgol.aaxD != null))
    {
      paramgol = paramgol.aaxD.ZV();
      AppMethodBeat.o(30065);
      return paramgol;
    }
    AppMethodBeat.o(30065);
    return null;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(30062);
    this.callback = paramh;
    int k = (int)y.bEl(this.filename);
    if (k <= 0)
    {
      Log.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[] { this.filename });
      AppMethodBeat.o(30062);
      return -1;
    }
    int j = k - this.Wjc;
    int i;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      Log.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.Wjc), Boolean.valueOf(this.pdm), Boolean.valueOf(this.pfn), this.filename });
      paramh = y.bi(this.filename, this.Wjc, i);
      if (paramh != null) {
        break label280;
      }
      if (!this.pfn) {
        break;
      }
      AppMethodBeat.o(30062);
      return 0;
      if ((j < 3300) && (!this.pdm))
      {
        Log.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.pdm) });
        AppMethodBeat.o(30062);
        return -1;
      }
      i = j;
      if (this.pdm)
      {
        this.pfn = true;
        i = j;
      }
    }
    Log.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.pdm), Boolean.valueOf(this.pfn) });
    AppMethodBeat.o(30062);
    return -1;
    label280:
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ftn();
    ((c.a)localObject).otF = new fto();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((c.a)localObject).funcId = 349;
    ((c.a)localObject).otG = 158;
    ((c.a)localObject).respCmdId = 1000000158;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ftn)c.b.b(this.rr.otB);
    bh.bCz();
    ((ftn)localObject).UserName = ((String)com.tencent.mm.model.c.ban().d(2, ""));
    ((ftn)localObject).NkQ = new gol().df(paramh);
    ((ftn)localObject).YYs = this.Wjc;
    ((ftn)localObject).abRF = this.clientId;
    if (this.pfn)
    {
      i = 1;
      ((ftn)localObject).oOu = i;
      ((ftn)localObject).abRG = 0;
      ((ftn)localObject).YIH = 0;
      ((ftn)localObject).abRH = this.encodeType;
      ((ftn)localObject).YIE = 0;
      i = dispatch(paramg, this.rr, this);
      j = ((ftn)localObject).YYs;
      this.Wjc = (((ftn)localObject).NkQ.abwJ + j);
      if (!this.pdm) {
        break label563;
      }
    }
    label563:
    for (long l = 0L;; l = 500L)
    {
      Log.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[] { this.filename, Long.valueOf(l), Integer.valueOf(i) });
      this.orP.startTimer(l);
      AppMethodBeat.o(30062);
      return i;
      i = 0;
      break;
    }
  }
  
  public final int getType()
  {
    return 349;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30064);
    Log.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.filename });
    params = (fto)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(30064);
      return;
    }
    Log.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[] { Integer.valueOf(params.oOu), d(params.abRI) });
    if (params.oOu == 1)
    {
      this.Wje = true;
      params = d(params.abRI);
      if (params != null) {
        this.Wjd = params;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(30064);
      return;
    }
    AppMethodBeat.o(30064);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(30063);
    this.callback.onSceneEnd(3, 0, "securityCheckError", this);
    AppMethodBeat.o(30063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.subapp.d;

import android.content.ContentValues;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.k.a;
import com.tencent.mm.al.k.b;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import d.g.a.b;
import d.y;

public final class i
  implements com.tencent.mm.al.k
{
  private static int cZR = 100;
  private m cOw;
  private String fileName;
  private int mRf;
  private long omg;
  protected k.b yDg;
  protected k.a yDh;
  private a yDi;
  private long yDj;
  private int yDk;
  private com.tencent.mm.plugin.subapp.a.a yDl;
  private av yDm;
  
  public i()
  {
    AppMethodBeat.i(28977);
    this.cOw = null;
    this.yDh = null;
    this.mRf = 0;
    this.fileName = "";
    this.omg = 0L;
    this.yDj = 0L;
    this.yDk = 0;
    this.yDm = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(191256);
        String str = i.b(i.this);
        g localg;
        if (str != null)
        {
          localg = d.dMj().aso(str);
          if (localg != null) {
            break label83;
          }
          ad.d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(str)));
        }
        for (;;)
        {
          d.dMk().run();
          ad.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.b(i.this));
          AppMethodBeat.o(191256);
          return false;
          label83:
          if (localg.field_status == 1)
          {
            localg.field_status = 2;
            localg.dtM = 64;
            h.a(localg);
          }
        }
      }
    }, true);
    this.yDl = new com.tencent.mm.plugin.subapp.a.a(new b() {});
    AppMethodBeat.o(28977);
  }
  
  public final boolean Ft()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(28982);
    com.tencent.mm.plugin.audio.c.a.Od("record").Oc("record");
    ad.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
    try
    {
      ad.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.cOw != null) {
        this.cOw.Ob();
      }
      if (this.yDk != 2)
      {
        h.AC(this.fileName);
        this.fileName = null;
        ad.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + bt.aS(this.yDj));
        bool1 = bool2;
        this.yDk = -1;
        AppMethodBeat.o(28982);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(28982);
    }
    this.mRf = ((int)Ou());
    if ((this.mRf < 800L) || (this.mRf < 1000L))
    {
      ad.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.mRf);
      h.AC(this.fileName);
      this.fileName = "";
      bool1 = false;
    }
    String str;
    int i;
    g localg;
    for (;;)
    {
      this.fileName = "";
      break;
      str = this.fileName;
      i = this.mRf;
      if (str != null)
      {
        ad.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
        localg = d.dMj().aso(str);
        if (localg != null)
        {
          if ((localg.field_status != 97) && (localg.field_status != 98)) {
            localg.field_status = 3;
          }
          localg.field_totallen = c.zS(h.bP(str, false));
          if (localg.field_totallen > 0) {
            break label414;
          }
          h.zV(str);
        }
      }
      d.dMk().run();
      ad.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
    }
    label414:
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.field_voicelenght = i;
    localg.dtM = 3424;
    bl localbl = new bl();
    localbl.nY(localg.field_user);
    localbl.setType(34);
    localbl.jV(1);
    localbl.nZ(str);
    if (localg.field_status == 97)
    {
      localbl.setStatus(2);
      localbl.setContent(f.b(localg.field_human, localg.field_voicelenght, false));
    }
    for (;;)
    {
      localbl.kY(bi.uj(localg.field_user));
      localg.field_msglocalid = ((int)bi.u(localbl));
      h.a(localg);
      break;
      if (localg.field_status == 98)
      {
        localbl.setStatus(5);
        localbl.setContent(f.b(localg.field_human, -1L, true));
      }
      else
      {
        localbl.setStatus(1);
      }
    }
  }
  
  public final int Os()
  {
    return this.mRf;
  }
  
  public final void Ot() {}
  
  public final long Ou()
  {
    AppMethodBeat.i(28983);
    if (this.omg <= 0L)
    {
      AppMethodBeat.o(28983);
      return 0L;
    }
    long l = bt.aS(this.omg);
    AppMethodBeat.o(28983);
    return l;
  }
  
  public final int Ov()
  {
    return 0;
  }
  
  public final void a(k.a parama)
  {
    this.yDh = parama;
  }
  
  public final void a(k.b paramb)
  {
    this.yDg = paramb;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(28981);
    ad.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
    try
    {
      ad.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.cOw != null) {
        this.cOw.Ob();
      }
      String str = this.fileName;
      if (str != null)
      {
        ad.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
        g localg = d.dMj().aso(str);
        if (localg != null)
        {
          localg.field_status = 8;
          localg.field_totallen = c.zS(h.bP(str, false));
          localg.dtM = 64;
          h.a(localg);
        }
      }
      d.dMk().run();
      this.fileName = "";
      AppMethodBeat.o(28981);
      return true;
    }
    finally
    {
      AppMethodBeat.o(28981);
    }
  }
  
  public final boolean fP(String paramString)
  {
    AppMethodBeat.i(28980);
    String str = k.zP(u.aqG());
    Object localObject = new g();
    ((g)localObject).field_filename = str;
    ((g)localObject).field_user = paramString;
    ((g)localObject).field_createtime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_clientid = str;
    ((g)localObject).field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_status = 1;
    ((g)localObject).field_human = u.aqG();
    ((g)localObject).dtM = -1;
    paramString = d.dMj();
    ad.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
    localObject = ((g)localObject).convertTo();
    int i = (int)paramString.db.insert("VoiceRemindInfo", "", (ContentValues)localObject);
    ad.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(i)));
    paramString = str;
    if (i == -1) {
      paramString = null;
    }
    this.fileName = paramString;
    this.yDl.Oc("record");
    this.yDl.Mx();
    AppMethodBeat.o(28980);
    return false;
  }
  
  public final String getFileName()
  {
    return this.fileName;
  }
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(28979);
    if (this.cOw != null)
    {
      int i = this.cOw.getMaxAmplitude();
      if (i > cZR) {
        cZR = i;
      }
      ad.d("getMaxAmplitude", " map: " + i + " max:" + cZR + " per:" + i * 100 / cZR);
      i = i * 100 / cZR;
      AppMethodBeat.o(28979);
      return i;
    }
    AppMethodBeat.o(28979);
    return 0;
  }
  
  public final boolean isRecording()
  {
    if (this.cOw == null) {}
    while (this.cOw.mStatus != 1) {
      return false;
    }
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28984);
    if (this.cOw != null)
    {
      this.cOw.Ob();
      ad.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
    }
    this.fileName = "";
    this.yDj = 0L;
    this.yDi = null;
    this.yDk = 0;
    this.omg = 0L;
    AppMethodBeat.o(28984);
  }
  
  final class a
    implements Runnable
  {
    ap handler;
    
    public a()
    {
      AppMethodBeat.i(28975);
      this.handler = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(28974);
          if (i.c(i.this) <= 0)
          {
            AppMethodBeat.o(28974);
            return;
          }
          paramAnonymousMessage = new StringBuilder("On Part :");
          if (i.this.yDg == null) {}
          for (boolean bool = true;; bool = false)
          {
            ad.d("MicroMsg.VoiceRemindRecorder", bool);
            i.d(i.this);
            if (i.this.yDg != null) {
              i.this.yDg.auN();
            }
            AppMethodBeat.o(28974);
            return;
          }
        }
      };
      AppMethodBeat.o(28975);
    }
    
    public final void run()
    {
      AppMethodBeat.i(28976);
      if (i.e(i.this) == null)
      {
        ad.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
        AppMethodBeat.o(28976);
        return;
      }
      synchronized (i.this)
      {
        if (!i.e(i.this).fO(h.bP(i.b(i.this), true)))
        {
          i.asm(i.b(i.this));
          i.f(i.this);
          ad.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.b(i.this) + "]");
          i.g(i.this);
        }
        i.a(i.this, bt.GC());
        ad.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.b(i.this) + "] time:" + bt.aS(i.h(i.this)));
        this.handler.sendEmptyMessageDelayed(0, 1L);
        AppMethodBeat.o(28976);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.i
 * JD-Core Version:    0.7.0.1
 */
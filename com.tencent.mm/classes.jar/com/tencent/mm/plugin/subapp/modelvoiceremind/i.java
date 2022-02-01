package com.tencent.mm.plugin.subapp.modelvoiceremind;

import android.content.ContentValues;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.l;
import com.tencent.mm.am.l.a;
import com.tencent.mm.am.l.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.cc;
import kotlin.ah;
import kotlin.g.a.b;

public final class i
  implements l
{
  private static int hxV = 100;
  protected l.b SFr;
  protected l.a SFs;
  private a SFt;
  private long SFu;
  private int SFv;
  private com.tencent.mm.plugin.subapp.a.a SFw;
  private MTimerHandler SFx;
  private String fileName;
  private m hlu;
  private int vza;
  private long xxM;
  
  public i()
  {
    AppMethodBeat.i(28977);
    this.hlu = null;
    this.SFs = null;
    this.vza = 0;
    this.fileName = "";
    this.xxM = 0L;
    this.SFu = 0L;
    this.SFv = 0;
    this.SFx = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(292023);
        String str = i.b(i.this);
        g localg;
        if (str != null)
        {
          localg = d.hAZ().bcF(str);
          if (localg != null) {
            break label83;
          }
          Log.d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(str)));
        }
        for (;;)
        {
          d.hBa().run();
          Log.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.b(i.this));
          AppMethodBeat.o(292023);
          return false;
          label83:
          if (localg.field_status == 1)
          {
            localg.field_status = 2;
            localg.eQp = 64;
            h.a(localg);
          }
        }
      }
    }, true);
    this.SFw = new com.tencent.mm.plugin.subapp.a.a(new b() {});
    AppMethodBeat.o(28977);
  }
  
  public final void a(l.a parama)
  {
    this.SFs = parama;
  }
  
  public final void a(l.b paramb)
  {
    this.SFr = paramb;
  }
  
  public final int aGI()
  {
    AppMethodBeat.i(28979);
    if (this.hlu != null)
    {
      int i = this.hlu.aGI();
      if (i > hxV) {
        hxV = i;
      }
      Log.d("getMaxAmplitude", " map: " + i + " max:" + hxV + " per:" + i * 100 / hxV);
      i = i * 100 / hxV;
      AppMethodBeat.o(28979);
      return i;
    }
    AppMethodBeat.o(28979);
    return 0;
  }
  
  public final int aHa()
  {
    return this.vza;
  }
  
  public final void aHc() {}
  
  public final long aHd()
  {
    AppMethodBeat.i(28983);
    if (this.xxM <= 0L)
    {
      AppMethodBeat.o(28983);
      return 0L;
    }
    long l = Util.ticksToNow(this.xxM);
    AppMethodBeat.o(28983);
    return l;
  }
  
  public final int aHe()
  {
    return 0;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(28981);
    Log.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
    try
    {
      Log.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.hlu != null) {
        this.hlu.aGH();
      }
      String str = this.fileName;
      if (str != null)
      {
        Log.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
        g localg = d.hAZ().bcF(str);
        if (localg != null)
        {
          localg.field_status = 8;
          localg.field_totallen = c.PZ(h.dt(str, false));
          localg.eQp = 64;
          h.a(localg);
        }
      }
      d.hBa().run();
      this.fileName = "";
      AppMethodBeat.o(28981);
      return true;
    }
    finally
    {
      AppMethodBeat.o(28981);
    }
  }
  
  public final String getFileName()
  {
    return this.fileName;
  }
  
  public final boolean isRecording()
  {
    if (this.hlu == null) {}
    while (this.hlu.mStatus != 1) {
      return false;
    }
    return true;
  }
  
  public final boolean jM(String paramString)
  {
    AppMethodBeat.i(28980);
    String str = k.PW(z.bAM());
    Object localObject = new g();
    ((g)localObject).field_filename = str;
    ((g)localObject).field_user = paramString;
    ((g)localObject).field_createtime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_clientid = str;
    ((g)localObject).field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_status = 1;
    ((g)localObject).field_human = z.bAM();
    ((g)localObject).eQp = -1;
    paramString = d.hAZ();
    Log.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
    localObject = ((g)localObject).convertTo();
    int i = (int)paramString.db.insert("VoiceRemindInfo", "", (ContentValues)localObject);
    Log.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(i)));
    paramString = str;
    if (i == -1) {
      paramString = null;
    }
    this.fileName = paramString;
    this.SFw.ahq("record");
    this.SFw.aEU();
    AppMethodBeat.o(28980);
    return false;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28984);
    if (this.hlu != null)
    {
      this.hlu.aGH();
      Log.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
    }
    this.fileName = "";
    this.SFu = 0L;
    this.SFt = null;
    this.SFv = 0;
    this.xxM = 0L;
    AppMethodBeat.o(28984);
  }
  
  public final boolean stop()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(28982);
    com.tencent.mm.plugin.audio.c.a.ahs("record").ahq("record");
    Log.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
    try
    {
      Log.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.hlu != null) {
        this.hlu.aGH();
      }
      if (this.SFv != 2)
      {
        h.QM(this.fileName);
        this.fileName = null;
        Log.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + Util.ticksToNow(this.SFu));
        bool1 = bool2;
        this.SFv = -1;
        AppMethodBeat.o(28982);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(28982);
    }
    this.vza = ((int)aHd());
    if ((this.vza < 800L) || (this.vza < 1000L))
    {
      Log.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.vza);
      h.QM(this.fileName);
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
      i = this.vza;
      if (str != null)
      {
        Log.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
        localg = d.hAZ().bcF(str);
        if (localg != null)
        {
          if ((localg.field_status != 97) && (localg.field_status != 98)) {
            localg.field_status = 3;
          }
          localg.field_totallen = c.PZ(h.dt(str, false));
          if (localg.field_totallen > 0) {
            break label421;
          }
          h.Qf(str);
        }
      }
      d.hBa().run();
      Log.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
    }
    label421:
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.field_voicelenght = i;
    localg.eQp = 3424;
    cc localcc = new cc();
    localcc.BS(localg.field_user);
    localcc.setType(34);
    localcc.pI(1);
    localcc.BT(str);
    if (localg.field_status == 97)
    {
      localcc.setStatus(2);
      localcc.setContent(f.a(localg.field_human, localg.field_voicelenght, false));
    }
    for (;;)
    {
      localcc.setCreateTime(br.JN(localg.field_user));
      localg.field_msglocalid = ((int)br.B(localcc));
      h.a(localg);
      break;
      if (localg.field_status == 98)
      {
        localcc.setStatus(5);
        localcc.setContent(f.a(localg.field_human, -1L, true));
      }
      else
      {
        localcc.setStatus(1);
      }
    }
  }
  
  final class a
    implements Runnable
  {
    MMHandler handler;
    
    public a()
    {
      AppMethodBeat.i(28975);
      this.handler = new MMHandler()
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
          if (i.this.SFr == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.VoiceRemindRecorder", bool);
            i.d(i.this);
            if (i.this.SFr != null) {
              i.this.SFr.bFK();
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
        Log.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
        AppMethodBeat.o(28976);
        return;
      }
      synchronized (i.this)
      {
        if (!i.e(i.this).jL(h.dt(i.b(i.this), true)))
        {
          i.bcD(i.b(i.this));
          i.f(i.this);
          Log.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.b(i.this) + "]");
          i.g(i.this);
        }
        i.a(i.this, Util.currentTicks());
        Log.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.b(i.this) + "] time:" + Util.ticksToNow(i.h(i.this)));
        this.handler.sendEmptyMessageDelayed(0, 1L);
        AppMethodBeat.o(28976);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.modelvoiceremind.i
 * JD-Core Version:    0.7.0.1
 */
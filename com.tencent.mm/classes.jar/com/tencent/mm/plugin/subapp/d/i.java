package com.tencent.mm.plugin.subapp.d;

import android.content.ContentValues;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m.a;
import com.tencent.mm.ak.m.b;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ca;
import kotlin.g.a.b;
import kotlin.x;

public final class i
  implements com.tencent.mm.ak.m
{
  private static int dAR = 100;
  protected m.b FKe;
  protected m.a FKf;
  private a FKg;
  private long FKh;
  private int FKi;
  private com.tencent.mm.plugin.subapp.a.a FKj;
  private MTimerHandler FKk;
  private com.tencent.mm.modelvoice.m doF;
  private String fileName;
  private int pkT;
  private long qPl;
  
  public i()
  {
    AppMethodBeat.i(28977);
    this.doF = null;
    this.FKf = null;
    this.pkT = 0;
    this.fileName = "";
    this.qPl = 0L;
    this.FKh = 0L;
    this.FKi = 0;
    this.FKk = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(232068);
        String str = i.b(i.this);
        g localg;
        if (str != null)
        {
          localg = d.fth().aSP(str);
          if (localg != null) {
            break label83;
          }
          Log.d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(str)));
        }
        for (;;)
        {
          d.fti().run();
          Log.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.b(i.this));
          AppMethodBeat.o(232068);
          return false;
          label83:
          if (localg.field_status == 1)
          {
            localg.field_status = 2;
            localg.cSx = 64;
            h.a(localg);
          }
        }
      }
    }, true);
    this.FKj = new com.tencent.mm.plugin.subapp.a.a(new b() {});
    AppMethodBeat.o(28977);
  }
  
  public final boolean Qt()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(28982);
    com.tencent.mm.plugin.audio.c.a.agr("record").agq("record");
    Log.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
    try
    {
      Log.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.doF != null) {
        this.doF.ZZ();
      }
      if (this.FKi != 2)
      {
        h.Rk(this.fileName);
        this.fileName = null;
        Log.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + Util.ticksToNow(this.FKh));
        bool1 = bool2;
        this.FKi = -1;
        AppMethodBeat.o(28982);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(28982);
    }
    this.pkT = ((int)aas());
    if ((this.pkT < 800L) || (this.pkT < 1000L))
    {
      Log.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.pkT);
      h.Rk(this.fileName);
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
      i = this.pkT;
      if (str != null)
      {
        Log.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
        localg = d.fth().aSP(str);
        if (localg != null)
        {
          if ((localg.field_status != 97) && (localg.field_status != 98)) {
            localg.field_status = 3;
          }
          localg.field_totallen = c.Qy(h.cz(str, false));
          if (localg.field_totallen > 0) {
            break label414;
          }
          h.QE(str);
        }
      }
      d.fti().run();
      Log.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
    }
    label414:
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.field_voicelenght = i;
    localg.cSx = 3424;
    ca localca = new ca();
    localca.Cy(localg.field_user);
    localca.setType(34);
    localca.nv(1);
    localca.Cz(str);
    if (localg.field_status == 97)
    {
      localca.setStatus(2);
      localca.setContent(f.b(localg.field_human, localg.field_voicelenght, false));
    }
    for (;;)
    {
      localca.setCreateTime(bp.Kw(localg.field_user));
      localg.field_msglocalid = ((int)bp.x(localca));
      h.a(localg);
      break;
      if (localg.field_status == 98)
      {
        localca.setStatus(5);
        localca.setContent(f.b(localg.field_human, -1L, true));
      }
      else
      {
        localca.setStatus(1);
      }
    }
  }
  
  public final void a(m.a parama)
  {
    this.FKf = parama;
  }
  
  public final void a(m.b paramb)
  {
    this.FKe = paramb;
  }
  
  public final int aaq()
  {
    return this.pkT;
  }
  
  public final void aar() {}
  
  public final long aas()
  {
    AppMethodBeat.i(28983);
    if (this.qPl <= 0L)
    {
      AppMethodBeat.o(28983);
      return 0L;
    }
    long l = Util.ticksToNow(this.qPl);
    AppMethodBeat.o(28983);
    return l;
  }
  
  public final int aat()
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
      if (this.doF != null) {
        this.doF.ZZ();
      }
      String str = this.fileName;
      if (str != null)
      {
        Log.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
        g localg = d.fth().aSP(str);
        if (localg != null)
        {
          localg.field_status = 8;
          localg.field_totallen = c.Qy(h.cz(str, false));
          localg.cSx = 64;
          h.a(localg);
        }
      }
      d.fti().run();
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
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(28979);
    if (this.doF != null)
    {
      int i = this.doF.getMaxAmplitude();
      if (i > dAR) {
        dAR = i;
      }
      Log.d("getMaxAmplitude", " map: " + i + " max:" + dAR + " per:" + i * 100 / dAR);
      i = i * 100 / dAR;
      AppMethodBeat.o(28979);
      return i;
    }
    AppMethodBeat.o(28979);
    return 0;
  }
  
  public final boolean hx(String paramString)
  {
    AppMethodBeat.i(28980);
    String str = k.Qv(z.aTY());
    Object localObject = new g();
    ((g)localObject).field_filename = str;
    ((g)localObject).field_user = paramString;
    ((g)localObject).field_createtime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_clientid = str;
    ((g)localObject).field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_status = 1;
    ((g)localObject).field_human = z.aTY();
    ((g)localObject).cSx = -1;
    paramString = d.fth();
    Log.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
    localObject = ((g)localObject).convertTo();
    int i = (int)paramString.db.insert("VoiceRemindInfo", "", (ContentValues)localObject);
    Log.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(i)));
    paramString = str;
    if (i == -1) {
      paramString = null;
    }
    this.fileName = paramString;
    this.FKj.agq("record");
    this.FKj.Yo();
    AppMethodBeat.o(28980);
    return false;
  }
  
  public final boolean isRecording()
  {
    if (this.doF == null) {}
    while (this.doF.mStatus != 1) {
      return false;
    }
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28984);
    if (this.doF != null)
    {
      this.doF.ZZ();
      Log.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
    }
    this.fileName = "";
    this.FKh = 0L;
    this.FKg = null;
    this.FKi = 0;
    this.qPl = 0L;
    AppMethodBeat.o(28984);
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
          if (i.this.FKe == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.VoiceRemindRecorder", bool);
            i.d(i.this);
            if (i.this.FKe != null) {
              i.this.FKe.aYN();
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
        if (!i.e(i.this).hw(h.cz(i.b(i.this), true)))
        {
          i.aSN(i.b(i.this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.i
 * JD-Core Version:    0.7.0.1
 */
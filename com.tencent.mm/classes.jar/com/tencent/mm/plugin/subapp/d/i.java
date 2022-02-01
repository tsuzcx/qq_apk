package com.tencent.mm.plugin.subapp.d;

import android.content.ContentValues;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.m.a;
import com.tencent.mm.an.m.b;
import com.tencent.mm.model.bq;
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
  implements com.tencent.mm.an.m
{
  private static int ftG = 100;
  protected m.b Meb;
  protected m.a Mec;
  private a Med;
  private long Mee;
  private int Mef;
  private com.tencent.mm.plugin.subapp.a.a Meg;
  private MTimerHandler Meh;
  private com.tencent.mm.modelvoice.m fhj;
  private String fileName;
  private int snc;
  private long urr;
  
  public i()
  {
    AppMethodBeat.i(28977);
    this.fhj = null;
    this.Mec = null;
    this.snc = 0;
    this.fileName = "";
    this.urr = 0L;
    this.Mee = 0L;
    this.Mef = 0;
    this.Meh = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(272122);
        String str = i.b(i.this);
        g localg;
        if (str != null)
        {
          localg = d.ghG().bdT(str);
          if (localg != null) {
            break label83;
          }
          Log.d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(str)));
        }
        for (;;)
        {
          d.ghH().run();
          Log.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.b(i.this));
          AppMethodBeat.o(272122);
          return false;
          label83:
          if (localg.field_status == 1)
          {
            localg.field_status = 2;
            localg.cUP = 64;
            h.a(localg);
          }
        }
      }
    }, true);
    this.Meg = new com.tencent.mm.plugin.subapp.a.a(new b() {});
    AppMethodBeat.o(28977);
  }
  
  public final boolean TV()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(28982);
    com.tencent.mm.plugin.audio.c.a.anV("record").anT("record");
    Log.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
    try
    {
      Log.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.fhj != null) {
        this.fhj.aeJ();
      }
      if (this.Mef != 2)
      {
        h.YH(this.fileName);
        this.fileName = null;
        Log.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + Util.ticksToNow(this.Mee));
        bool1 = bool2;
        this.Mef = -1;
        AppMethodBeat.o(28982);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(28982);
    }
    this.snc = ((int)aff());
    if ((this.snc < 800L) || (this.snc < 1000L))
    {
      Log.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.snc);
      h.YH(this.fileName);
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
      i = this.snc;
      if (str != null)
      {
        Log.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
        localg = d.ghG().bdT(str);
        if (localg != null)
        {
          if ((localg.field_status != 97) && (localg.field_status != 98)) {
            localg.field_status = 3;
          }
          localg.field_totallen = c.XV(h.cN(str, false));
          if (localg.field_totallen > 0) {
            break label414;
          }
          h.Yb(str);
        }
      }
      d.ghH().run();
      Log.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
    }
    label414:
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.field_voicelenght = i;
    localg.cUP = 3424;
    ca localca = new ca();
    localca.Jm(localg.field_user);
    localca.setType(34);
    localca.pJ(1);
    localca.Jn(str);
    if (localg.field_status == 97)
    {
      localca.setStatus(2);
      localca.setContent(f.a(localg.field_human, localg.field_voicelenght, false));
    }
    for (;;)
    {
      localca.setCreateTime(bq.RP(localg.field_user));
      localg.field_msglocalid = ((int)bq.z(localca));
      h.a(localg);
      break;
      if (localg.field_status == 98)
      {
        localca.setStatus(5);
        localca.setContent(f.a(localg.field_human, -1L, true));
      }
      else
      {
        localca.setStatus(1);
      }
    }
  }
  
  public final void a(m.a parama)
  {
    this.Mec = parama;
  }
  
  public final void a(m.b paramb)
  {
    this.Meb = paramb;
  }
  
  public final int aeK()
  {
    AppMethodBeat.i(28979);
    if (this.fhj != null)
    {
      int i = this.fhj.aeK();
      if (i > ftG) {
        ftG = i;
      }
      Log.d("getMaxAmplitude", " map: " + i + " max:" + ftG + " per:" + i * 100 / ftG);
      i = i * 100 / ftG;
      AppMethodBeat.o(28979);
      return i;
    }
    AppMethodBeat.o(28979);
    return 0;
  }
  
  public final int afc()
  {
    return this.snc;
  }
  
  public final void afe() {}
  
  public final long aff()
  {
    AppMethodBeat.i(28983);
    if (this.urr <= 0L)
    {
      AppMethodBeat.o(28983);
      return 0L;
    }
    long l = Util.ticksToNow(this.urr);
    AppMethodBeat.o(28983);
    return l;
  }
  
  public final int afg()
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
      if (this.fhj != null) {
        this.fhj.aeJ();
      }
      String str = this.fileName;
      if (str != null)
      {
        Log.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
        g localg = d.ghG().bdT(str);
        if (localg != null)
        {
          localg.field_status = 8;
          localg.field_totallen = c.XV(h.cN(str, false));
          localg.cUP = 64;
          h.a(localg);
        }
      }
      d.ghH().run();
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
  
  public final boolean il(String paramString)
  {
    AppMethodBeat.i(28980);
    String str = k.XS(z.bcZ());
    Object localObject = new g();
    ((g)localObject).field_filename = str;
    ((g)localObject).field_user = paramString;
    ((g)localObject).field_createtime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_clientid = str;
    ((g)localObject).field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_status = 1;
    ((g)localObject).field_human = z.bcZ();
    ((g)localObject).cUP = -1;
    paramString = d.ghG();
    Log.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
    localObject = ((g)localObject).convertTo();
    int i = (int)paramString.db.insert("VoiceRemindInfo", "", (ContentValues)localObject);
    Log.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(i)));
    paramString = str;
    if (i == -1) {
      paramString = null;
    }
    this.fileName = paramString;
    this.Meg.anT("record");
    this.Meg.acU();
    AppMethodBeat.o(28980);
    return false;
  }
  
  public final boolean isRecording()
  {
    if (this.fhj == null) {}
    while (this.fhj.mStatus != 1) {
      return false;
    }
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28984);
    if (this.fhj != null)
    {
      this.fhj.aeJ();
      Log.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
    }
    this.fileName = "";
    this.Mee = 0L;
    this.Med = null;
    this.Mef = 0;
    this.urr = 0L;
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
          if (i.this.Meb == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.d("MicroMsg.VoiceRemindRecorder", bool);
            i.d(i.this);
            if (i.this.Meb != null) {
              i.this.Meb.bic();
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
        if (!i.e(i.this).ik(h.cN(i.b(i.this), true)))
        {
          i.bdR(i.b(i.this));
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
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.i
 * JD-Core Version:    0.7.0.1
 */
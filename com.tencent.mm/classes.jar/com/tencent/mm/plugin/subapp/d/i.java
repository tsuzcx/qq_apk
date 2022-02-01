package com.tencent.mm.plugin.subapp.d;

import android.content.ContentValues;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j.a;
import com.tencent.mm.ak.j.b;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import d.g.a.b;
import d.z;

public final class i
  implements com.tencent.mm.ak.j
{
  private static int djH = 100;
  protected j.b Bzt;
  protected j.a Bzu;
  private a Bzv;
  private long Bzw;
  private int Bzx;
  private com.tencent.mm.plugin.subapp.a.a Bzy;
  private aw Bzz;
  private m cYc;
  private String fileName;
  private int nZX;
  private long pzU;
  
  public i()
  {
    AppMethodBeat.i(28977);
    this.cYc = null;
    this.Bzu = null;
    this.nZX = 0;
    this.fileName = "";
    this.pzU = 0L;
    this.Bzw = 0L;
    this.Bzx = 0;
    this.Bzz = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(186633);
        String str = i.b(i.this);
        g localg;
        if (str != null)
        {
          localg = d.eqI().aDU(str);
          if (localg != null) {
            break label83;
          }
          ae.d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(str)));
        }
        for (;;)
        {
          d.eqJ().run();
          ae.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.b(i.this));
          AppMethodBeat.o(186633);
          return false;
          label83:
          if (localg.field_status == 1)
          {
            localg.field_status = 2;
            localg.dEu = 64;
            h.a(localg);
          }
        }
      }
    }, true);
    this.Bzy = new com.tencent.mm.plugin.subapp.a.a(new b() {});
    AppMethodBeat.o(28977);
  }
  
  public final boolean GB()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(28982);
    com.tencent.mm.plugin.audio.c.a.Ww("record").Wv("record");
    ae.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
    try
    {
      ae.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.cYc != null) {
        this.cYc.PF();
      }
      if (this.Bzx != 2)
      {
        h.Iy(this.fileName);
        this.fileName = null;
        ae.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + bu.aO(this.Bzw));
        bool1 = bool2;
        this.Bzx = -1;
        AppMethodBeat.o(28982);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(28982);
    }
    this.nZX = ((int)PY());
    if ((this.nZX < 800L) || (this.nZX < 1000L))
    {
      ae.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.nZX);
      h.Iy(this.fileName);
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
      i = this.nZX;
      if (str != null)
      {
        ae.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
        localg = d.eqI().aDU(str);
        if (localg != null)
        {
          if ((localg.field_status != 97) && (localg.field_status != 98)) {
            localg.field_status = 3;
          }
          localg.field_totallen = c.HL(h.ch(str, false));
          if (localg.field_totallen > 0) {
            break label414;
          }
          h.HR(str);
        }
      }
      d.eqJ().run();
      ae.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
    }
    label414:
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.field_voicelenght = i;
    localg.dEu = 3424;
    bv localbv = new bv();
    localbv.ui(localg.field_user);
    localbv.setType(34);
    localbv.kt(1);
    localbv.uj(str);
    if (localg.field_status == 97)
    {
      localbv.setStatus(2);
      localbv.setContent(f.b(localg.field_human, localg.field_voicelenght, false));
    }
    for (;;)
    {
      localbv.qN(bl.BQ(localg.field_user));
      localg.field_msglocalid = ((int)bl.v(localbv));
      h.a(localg);
      break;
      if (localg.field_status == 98)
      {
        localbv.setStatus(5);
        localbv.setContent(f.b(localg.field_human, -1L, true));
      }
      else
      {
        localbv.setStatus(1);
      }
    }
  }
  
  public final int PW()
  {
    return this.nZX;
  }
  
  public final void PX() {}
  
  public final long PY()
  {
    AppMethodBeat.i(28983);
    if (this.pzU <= 0L)
    {
      AppMethodBeat.o(28983);
      return 0L;
    }
    long l = bu.aO(this.pzU);
    AppMethodBeat.o(28983);
    return l;
  }
  
  public final int PZ()
  {
    return 0;
  }
  
  public final void a(j.a parama)
  {
    this.Bzu = parama;
  }
  
  public final void a(j.b paramb)
  {
    this.Bzt = paramb;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(28981);
    ae.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
    try
    {
      ae.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.cYc != null) {
        this.cYc.PF();
      }
      String str = this.fileName;
      if (str != null)
      {
        ae.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
        g localg = d.eqI().aDU(str);
        if (localg != null)
        {
          localg.field_status = 8;
          localg.field_totallen = c.HL(h.ch(str, false));
          localg.dEu = 64;
          h.a(localg);
        }
      }
      d.eqJ().run();
      this.fileName = "";
      AppMethodBeat.o(28981);
      return true;
    }
    finally
    {
      AppMethodBeat.o(28981);
    }
  }
  
  public final boolean gG(String paramString)
  {
    AppMethodBeat.i(28980);
    String str = k.HI(v.aAC());
    Object localObject = new g();
    ((g)localObject).field_filename = str;
    ((g)localObject).field_user = paramString;
    ((g)localObject).field_createtime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_clientid = str;
    ((g)localObject).field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_status = 1;
    ((g)localObject).field_human = v.aAC();
    ((g)localObject).dEu = -1;
    paramString = d.eqI();
    ae.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
    localObject = ((g)localObject).convertTo();
    int i = (int)paramString.db.insert("VoiceRemindInfo", "", (ContentValues)localObject);
    ae.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(i)));
    paramString = str;
    if (i == -1) {
      paramString = null;
    }
    this.fileName = paramString;
    this.Bzy.Wv("record");
    this.Bzy.Oc();
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
    if (this.cYc != null)
    {
      int i = this.cYc.getMaxAmplitude();
      if (i > djH) {
        djH = i;
      }
      ae.d("getMaxAmplitude", " map: " + i + " max:" + djH + " per:" + i * 100 / djH);
      i = i * 100 / djH;
      AppMethodBeat.o(28979);
      return i;
    }
    AppMethodBeat.o(28979);
    return 0;
  }
  
  public final boolean isRecording()
  {
    if (this.cYc == null) {}
    while (this.cYc.mStatus != 1) {
      return false;
    }
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28984);
    if (this.cYc != null)
    {
      this.cYc.PF();
      ae.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
    }
    this.fileName = "";
    this.Bzw = 0L;
    this.Bzv = null;
    this.Bzx = 0;
    this.pzU = 0L;
    AppMethodBeat.o(28984);
  }
  
  final class a
    implements Runnable
  {
    aq handler;
    
    public a()
    {
      AppMethodBeat.i(28975);
      this.handler = new aq()
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
          if (i.this.Bzt == null) {}
          for (boolean bool = true;; bool = false)
          {
            ae.d("MicroMsg.VoiceRemindRecorder", bool);
            i.d(i.this);
            if (i.this.Bzt != null) {
              i.this.Bzt.aEY();
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
        ae.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
        AppMethodBeat.o(28976);
        return;
      }
      synchronized (i.this)
      {
        if (!i.e(i.this).gF(h.ch(i.b(i.this), true)))
        {
          i.aDS(i.b(i.this));
          i.f(i.this);
          ae.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.b(i.this) + "]");
          i.g(i.this);
        }
        i.a(i.this, bu.HQ());
        ae.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.b(i.this) + "] time:" + bu.aO(i.h(i.this)));
        this.handler.sendEmptyMessageDelayed(0, 1L);
        AppMethodBeat.o(28976);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.i
 * JD-Core Version:    0.7.0.1
 */
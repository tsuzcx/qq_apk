package com.tencent.mm.plugin.subapp.d;

import android.content.ContentValues;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.j.a;
import com.tencent.mm.al.j.b;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import d.g.a.b;
import d.z;

public final class i
  implements com.tencent.mm.al.j
{
  private static int diF = 100;
  protected j.b BhV;
  protected j.a BhW;
  private a BhX;
  private long BhY;
  private int BhZ;
  private com.tencent.mm.plugin.subapp.a.a Bia;
  private av Bib;
  private m cXf;
  private String fileName;
  private int nUr;
  private long pto;
  
  public i()
  {
    AppMethodBeat.i(28977);
    this.cXf = null;
    this.BhW = null;
    this.nUr = 0;
    this.fileName = "";
    this.pto = 0L;
    this.BhY = 0L;
    this.BhZ = 0;
    this.Bib = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(193358);
        String str = i.b(i.this);
        g localg;
        if (str != null)
        {
          localg = d.emZ().aCB(str);
          if (localg != null) {
            break label83;
          }
          ad.d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(str)));
        }
        for (;;)
        {
          d.ena().run();
          ad.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.b(i.this));
          AppMethodBeat.o(193358);
          return false;
          label83:
          if (localg.field_status == 1)
          {
            localg.field_status = 2;
            localg.dDp = 64;
            h.a(localg);
          }
        }
      }
    }, true);
    this.Bia = new com.tencent.mm.plugin.subapp.a.a(new b() {});
    AppMethodBeat.o(28977);
  }
  
  public final boolean Gv()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(28982);
    com.tencent.mm.plugin.audio.c.a.VK("record").VJ("record");
    ad.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
    try
    {
      ad.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.cXf != null) {
        this.cXf.PG();
      }
      if (this.BhZ != 2)
      {
        h.HW(this.fileName);
        this.fileName = null;
        ad.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + bt.aO(this.BhY));
        bool1 = bool2;
        this.BhZ = -1;
        AppMethodBeat.o(28982);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(28982);
    }
    this.nUr = ((int)PZ());
    if ((this.nUr < 800L) || (this.nUr < 1000L))
    {
      ad.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.nUr);
      h.HW(this.fileName);
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
      i = this.nUr;
      if (str != null)
      {
        ad.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
        localg = d.emZ().aCB(str);
        if (localg != null)
        {
          if ((localg.field_status != 97) && (localg.field_status != 98)) {
            localg.field_status = 3;
          }
          localg.field_totallen = c.Hj(h.cd(str, false));
          if (localg.field_totallen > 0) {
            break label414;
          }
          h.Hp(str);
        }
      }
      d.ena().run();
      ad.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
    }
    label414:
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.field_voicelenght = i;
    localg.dDp = 3424;
    bu localbu = new bu();
    localbu.tN(localg.field_user);
    localbu.setType(34);
    localbu.kr(1);
    localbu.tO(str);
    if (localg.field_status == 97)
    {
      localbu.setStatus(2);
      localbu.setContent(f.b(localg.field_human, localg.field_voicelenght, false));
    }
    for (;;)
    {
      localbu.qA(bj.Bo(localg.field_user));
      localg.field_msglocalid = ((int)bj.v(localbu));
      h.a(localg);
      break;
      if (localg.field_status == 98)
      {
        localbu.setStatus(5);
        localbu.setContent(f.b(localg.field_human, -1L, true));
      }
      else
      {
        localbu.setStatus(1);
      }
    }
  }
  
  public final int PX()
  {
    return this.nUr;
  }
  
  public final void PY() {}
  
  public final long PZ()
  {
    AppMethodBeat.i(28983);
    if (this.pto <= 0L)
    {
      AppMethodBeat.o(28983);
      return 0L;
    }
    long l = bt.aO(this.pto);
    AppMethodBeat.o(28983);
    return l;
  }
  
  public final int Qa()
  {
    return 0;
  }
  
  public final void a(j.a parama)
  {
    this.BhW = parama;
  }
  
  public final void a(j.b paramb)
  {
    this.BhV = paramb;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(28981);
    ad.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
    try
    {
      ad.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.cXf != null) {
        this.cXf.PG();
      }
      String str = this.fileName;
      if (str != null)
      {
        ad.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
        g localg = d.emZ().aCB(str);
        if (localg != null)
        {
          localg.field_status = 8;
          localg.field_totallen = c.Hj(h.cd(str, false));
          localg.dDp = 64;
          h.a(localg);
        }
      }
      d.ena().run();
      this.fileName = "";
      AppMethodBeat.o(28981);
      return true;
    }
    finally
    {
      AppMethodBeat.o(28981);
    }
  }
  
  public final boolean gA(String paramString)
  {
    AppMethodBeat.i(28980);
    String str = k.Hg(u.aAm());
    Object localObject = new g();
    ((g)localObject).field_filename = str;
    ((g)localObject).field_user = paramString;
    ((g)localObject).field_createtime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_clientid = str;
    ((g)localObject).field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_status = 1;
    ((g)localObject).field_human = u.aAm();
    ((g)localObject).dDp = -1;
    paramString = d.emZ();
    ad.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
    localObject = ((g)localObject).convertTo();
    int i = (int)paramString.db.insert("VoiceRemindInfo", "", (ContentValues)localObject);
    ad.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(i)));
    paramString = str;
    if (i == -1) {
      paramString = null;
    }
    this.fileName = paramString;
    this.Bia.VJ("record");
    this.Bia.Oe();
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
    if (this.cXf != null)
    {
      int i = this.cXf.getMaxAmplitude();
      if (i > diF) {
        diF = i;
      }
      ad.d("getMaxAmplitude", " map: " + i + " max:" + diF + " per:" + i * 100 / diF);
      i = i * 100 / diF;
      AppMethodBeat.o(28979);
      return i;
    }
    AppMethodBeat.o(28979);
    return 0;
  }
  
  public final boolean isRecording()
  {
    if (this.cXf == null) {}
    while (this.cXf.mStatus != 1) {
      return false;
    }
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28984);
    if (this.cXf != null)
    {
      this.cXf.PG();
      ad.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
    }
    this.fileName = "";
    this.BhY = 0L;
    this.BhX = null;
    this.BhZ = 0;
    this.pto = 0L;
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
          if (i.this.BhV == null) {}
          for (boolean bool = true;; bool = false)
          {
            ad.d("MicroMsg.VoiceRemindRecorder", bool);
            i.d(i.this);
            if (i.this.BhV != null) {
              i.this.BhV.aEI();
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
        if (!i.e(i.this).gz(h.cd(i.b(i.this), true)))
        {
          i.aCz(i.b(i.this));
          i.f(i.this);
          ad.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.b(i.this) + "]");
          i.g(i.this);
        }
        i.a(i.this, bt.HI());
        ad.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.b(i.this) + "] time:" + bt.aO(i.h(i.this)));
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
package com.tencent.mm.plugin.subapp.d;

import android.content.ContentValues;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.k.a;
import com.tencent.mm.ak.k.b;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import d.g.a.b;
import d.y;

public final class i
  implements com.tencent.mm.ak.k
{
  private static int cXn = 100;
  private m cLR;
  private String fileName;
  private int ntv;
  private long oPG;
  private au zQA;
  protected k.b zQu;
  protected k.a zQv;
  private a zQw;
  private long zQx;
  private int zQy;
  private com.tencent.mm.plugin.subapp.a.a zQz;
  
  public i()
  {
    AppMethodBeat.i(28977);
    this.cLR = null;
    this.zQv = null;
    this.ntv = 0;
    this.fileName = "";
    this.oPG = 0L;
    this.zQx = 0L;
    this.zQy = 0;
    this.zQA = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(196085);
        String str = i.b(i.this);
        g localg;
        if (str != null)
        {
          localg = d.eaJ().axx(str);
          if (localg != null) {
            break label83;
          }
          ac.d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(str)));
        }
        for (;;)
        {
          d.eaK().run();
          ac.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.b(i.this));
          AppMethodBeat.o(196085);
          return false;
          label83:
          if (localg.field_status == 1)
          {
            localg.field_status = 2;
            localg.drx = 64;
            h.a(localg);
          }
        }
      }
    }, true);
    this.zQz = new com.tencent.mm.plugin.subapp.a.a(new b() {});
    AppMethodBeat.o(28977);
  }
  
  public final boolean Fb()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(28982);
    com.tencent.mm.plugin.audio.c.a.Sm("record").Sl("record");
    ac.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
    try
    {
      ac.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.cLR != null) {
        this.cLR.NX();
      }
      if (this.zQy != 2)
      {
        h.EH(this.fileName);
        this.fileName = null;
        ac.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + bs.aO(this.zQx));
        bool1 = bool2;
        this.zQy = -1;
        AppMethodBeat.o(28982);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(28982);
    }
    this.ntv = ((int)Oq());
    if ((this.ntv < 800L) || (this.ntv < 1000L))
    {
      ac.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.ntv);
      h.EH(this.fileName);
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
      i = this.ntv;
      if (str != null)
      {
        ac.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
        localg = d.eaJ().axx(str);
        if (localg != null)
        {
          if ((localg.field_status != 97) && (localg.field_status != 98)) {
            localg.field_status = 3;
          }
          localg.field_totallen = c.DX(h.bW(str, false));
          if (localg.field_totallen > 0) {
            break label414;
          }
          h.Ea(str);
        }
      }
      d.eaK().run();
      ac.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
    }
    label414:
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.field_voicelenght = i;
    localg.drx = 3424;
    bo localbo = new bo();
    localbo.re(localg.field_user);
    localbo.setType(34);
    localbo.jT(1);
    localbo.rf(str);
    if (localg.field_status == 97)
    {
      localbo.setStatus(2);
      localbo.setContent(f.b(localg.field_human, localg.field_voicelenght, false));
    }
    for (;;)
    {
      localbo.oA(bi.yp(localg.field_user));
      localg.field_msglocalid = ((int)bi.u(localbo));
      h.a(localg);
      break;
      if (localg.field_status == 98)
      {
        localbo.setStatus(5);
        localbo.setContent(f.b(localg.field_human, -1L, true));
      }
      else
      {
        localbo.setStatus(1);
      }
    }
  }
  
  public final int Oo()
  {
    return this.ntv;
  }
  
  public final void Op() {}
  
  public final long Oq()
  {
    AppMethodBeat.i(28983);
    if (this.oPG <= 0L)
    {
      AppMethodBeat.o(28983);
      return 0L;
    }
    long l = bs.aO(this.oPG);
    AppMethodBeat.o(28983);
    return l;
  }
  
  public final int Or()
  {
    return 0;
  }
  
  public final void a(k.a parama)
  {
    this.zQv = parama;
  }
  
  public final void a(k.b paramb)
  {
    this.zQu = paramb;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(28981);
    ac.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
    try
    {
      ac.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.cLR != null) {
        this.cLR.NX();
      }
      String str = this.fileName;
      if (str != null)
      {
        ac.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
        g localg = d.eaJ().axx(str);
        if (localg != null)
        {
          localg.field_status = 8;
          localg.field_totallen = c.DX(h.bW(str, false));
          localg.drx = 64;
          h.a(localg);
        }
      }
      d.eaK().run();
      this.fileName = "";
      AppMethodBeat.o(28981);
      return true;
    }
    finally
    {
      AppMethodBeat.o(28981);
    }
  }
  
  public final boolean fF(String paramString)
  {
    AppMethodBeat.i(28980);
    String str = k.DU(u.axw());
    Object localObject = new g();
    ((g)localObject).field_filename = str;
    ((g)localObject).field_user = paramString;
    ((g)localObject).field_createtime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_clientid = str;
    ((g)localObject).field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_status = 1;
    ((g)localObject).field_human = u.axw();
    ((g)localObject).drx = -1;
    paramString = d.eaJ();
    ac.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
    localObject = ((g)localObject).convertTo();
    int i = (int)paramString.db.insert("VoiceRemindInfo", "", (ContentValues)localObject);
    ac.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(i)));
    paramString = str;
    if (i == -1) {
      paramString = null;
    }
    this.fileName = paramString;
    this.zQz.Sl("record");
    this.zQz.Mv();
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
    if (this.cLR != null)
    {
      int i = this.cLR.getMaxAmplitude();
      if (i > cXn) {
        cXn = i;
      }
      ac.d("getMaxAmplitude", " map: " + i + " max:" + cXn + " per:" + i * 100 / cXn);
      i = i * 100 / cXn;
      AppMethodBeat.o(28979);
      return i;
    }
    AppMethodBeat.o(28979);
    return 0;
  }
  
  public final boolean isRecording()
  {
    if (this.cLR == null) {}
    while (this.cLR.mStatus != 1) {
      return false;
    }
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28984);
    if (this.cLR != null)
    {
      this.cLR.NX();
      ac.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
    }
    this.fileName = "";
    this.zQx = 0L;
    this.zQw = null;
    this.zQy = 0;
    this.oPG = 0L;
    AppMethodBeat.o(28984);
  }
  
  final class a
    implements Runnable
  {
    ao handler;
    
    public a()
    {
      AppMethodBeat.i(28975);
      this.handler = new ao()
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
          if (i.this.zQu == null) {}
          for (boolean bool = true;; bool = false)
          {
            ac.d("MicroMsg.VoiceRemindRecorder", bool);
            i.d(i.this);
            if (i.this.zQu != null) {
              i.this.zQu.aBG();
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
        ac.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
        AppMethodBeat.o(28976);
        return;
      }
      synchronized (i.this)
      {
        if (!i.e(i.this).fE(h.bW(i.b(i.this), true)))
        {
          i.axv(i.b(i.this));
          i.f(i.this);
          ac.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.b(i.this) + "]");
          i.g(i.this);
        }
        i.a(i.this, bs.Gn());
        ac.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.b(i.this) + "] time:" + bs.aO(i.h(i.this)));
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
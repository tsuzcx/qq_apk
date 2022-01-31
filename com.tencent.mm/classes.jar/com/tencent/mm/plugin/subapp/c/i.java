package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import com.tencent.mm.ah.j.a;
import com.tencent.mm.ah.j.b;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class i
  implements com.tencent.mm.ah.j, f.a
{
  private static int bEl = 100;
  private com.tencent.mm.modelvoice.k byP = null;
  private String fileName = "";
  private int hYh = 0;
  private long jlU = 0L;
  protected j.b pvN;
  protected j.a pvO = null;
  private boolean pvP = false;
  private i.a pvQ;
  private long pvR = 0L;
  private int pvS = 0;
  private am pvT = new am(new i.1(this), true);
  
  public final void a(j.a parama)
  {
    this.pvO = parama;
  }
  
  public final void a(j.b paramb)
  {
    this.pvN = paramb;
  }
  
  public final boolean cE(String paramString)
  {
    String str = k.nR(q.Gj());
    Object localObject = new g();
    ((g)localObject).field_filename = str;
    ((g)localObject).field_user = paramString;
    ((g)localObject).field_createtime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_clientid = str;
    ((g)localObject).field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_status = 1;
    ((g)localObject).field_human = q.Gj();
    ((g)localObject).bcw = -1;
    paramString = d.bLX();
    y.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
    localObject = ((g)localObject).vf();
    int i = (int)paramString.dXw.insert("VoiceRemindInfo", "", (ContentValues)localObject);
    y.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result" + i);
    paramString = str;
    if (i == -1) {
      paramString = null;
    }
    this.fileName = paramString;
    au.Hy().a(this);
    i = au.Hy().yk();
    this.pvP = false;
    if (i != 0)
    {
      ew(100);
      return false;
    }
    new i.3(this).sendEmptyMessageDelayed(0, 50L);
    return false;
  }
  
  public final boolean cancel()
  {
    y.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
    try
    {
      y.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.byP != null) {
        this.byP.uh();
      }
      String str = this.fileName;
      if (str != null)
      {
        y.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
        g localg = h.PB(str);
        if (localg != null)
        {
          localg.field_status = 8;
          localg.field_totallen = c.nU(h.bh(str, false));
          localg.bcw = 64;
          h.a(localg);
        }
      }
      d.bLY().run();
      this.fileName = "";
      return true;
    }
    finally {}
  }
  
  public final void ew(int paramInt)
  {
    y.d("MicroMsg.VoiceRemindRecorder", " Recorder onBluetoothHeadsetStateChange :" + paramInt);
    if (this.pvP) {
      return;
    }
    this.pvP = true;
    au.Hy().b(this);
    this.byP = new com.tencent.mm.modelvoice.k();
    new i.2(this);
    this.pvQ = new i.a(this);
    com.tencent.mm.sdk.f.e.post(this.pvQ, "VoiceRemindRecorder_record");
    this.pvS = 1;
    this.pvT.S(3000L, 3000L);
    y.d("MicroMsg.VoiceRemindRecorder", "start end time:" + bk.cp(this.pvR));
  }
  
  public final String getFileName()
  {
    return this.fileName;
  }
  
  public final int getMaxAmplitude()
  {
    if (this.byP != null)
    {
      int i = this.byP.getMaxAmplitude();
      if (i > bEl) {
        bEl = i;
      }
      y.d("getMaxAmplitude", " map: " + i + " max:" + bEl + " per:" + i * 100 / bEl);
      return i * 100 / bEl;
    }
    return 0;
  }
  
  public final boolean isRecording()
  {
    if (this.byP == null) {}
    while (this.byP.mStatus != 1) {
      return false;
    }
    return true;
  }
  
  public final void reset()
  {
    if (this.byP != null)
    {
      this.byP.uh();
      y.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
    }
    this.fileName = "";
    this.pvR = 0L;
    this.pvQ = null;
    this.pvS = 0;
    this.jlU = 0L;
  }
  
  public final int uA()
  {
    return 0;
  }
  
  public final boolean un()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    au.Hy().yl();
    y.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
    try
    {
      y.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.byP != null) {
        this.byP.uh();
      }
      if (this.pvS != 2)
      {
        h.oC(this.fileName);
        this.fileName = null;
        y.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + bk.cp(this.pvR));
        bool1 = bool2;
        this.pvS = -1;
        return bool1;
      }
    }
    finally {}
    this.hYh = ((int)uy());
    if ((this.hYh < 800L) || (this.hYh < 1000L))
    {
      y.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.hYh);
      h.oC(this.fileName);
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
      i = this.hYh;
      if (str != null)
      {
        y.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
        localg = h.PB(str);
        if (localg != null)
        {
          if ((localg.field_status != 97) && (localg.field_status != 98)) {
            localg.field_status = 3;
          }
          localg.field_totallen = c.nU(h.bh(str, false));
          if (localg.field_totallen > 0) {
            break label396;
          }
          h.nX(str);
        }
      }
      d.bLY().run();
      y.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
    }
    label396:
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.field_voicelenght = i;
    localg.bcw = 3424;
    bi localbi = new bi();
    localbi.ec(localg.field_user);
    localbi.setType(34);
    localbi.fA(1);
    localbi.ed(str);
    if (localg.field_status == 97)
    {
      localbi.setStatus(2);
      localbi.setContent(f.d(localg.field_human, localg.field_voicelenght, false));
    }
    for (;;)
    {
      localbi.bg(bd.iK(localg.field_user));
      localg.field_msglocalid = ((int)bd.h(localbi));
      h.a(localg);
      break;
      if (localg.field_status == 98)
      {
        localbi.setStatus(5);
        localbi.setContent(f.d(localg.field_human, -1L, true));
      }
      else
      {
        localbi.setStatus(1);
      }
    }
  }
  
  public final int ux()
  {
    return this.hYh;
  }
  
  public final long uy()
  {
    if (this.jlU <= 0L) {
      return 0L;
    }
    return bk.cp(this.jlU);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.i
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j.a;
import com.tencent.mm.ai.j.b;
import com.tencent.mm.compatible.b.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class i
  implements com.tencent.mm.ai.j, g.a
{
  private static int ckX = 100;
  private m caR;
  private String fileName;
  private int jRV;
  private long lvI;
  protected j.b sXt;
  protected j.a sXu;
  private boolean sXv;
  private i.a sXw;
  private long sXx;
  private int sXy;
  private ap sXz;
  
  public i()
  {
    AppMethodBeat.i(25298);
    this.caR = null;
    this.sXu = null;
    this.jRV = 0;
    this.fileName = "";
    this.sXv = false;
    this.lvI = 0L;
    this.sXx = 0L;
    this.sXy = 0;
    this.sXz = new ap(new i.1(this), true);
    AppMethodBeat.o(25298);
  }
  
  public final int EK()
  {
    return this.jRV;
  }
  
  public final void EL() {}
  
  public final long EN()
  {
    AppMethodBeat.i(25304);
    if (this.lvI <= 0L)
    {
      AppMethodBeat.o(25304);
      return 0L;
    }
    long l = bo.av(this.lvI);
    AppMethodBeat.o(25304);
    return l;
  }
  
  public final int EQ()
  {
    return 0;
  }
  
  public final boolean Ez()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(25303);
    aw.aaA().KF();
    ab.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
    try
    {
      ab.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.caR != null) {
        this.caR.Et();
      }
      if (this.sXy != 2)
      {
        h.vP(this.fileName);
        this.fileName = null;
        ab.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + bo.av(this.sXx));
        bool1 = bool2;
        this.sXy = -1;
        AppMethodBeat.o(25303);
        return bool1;
      }
    }
    finally
    {
      AppMethodBeat.o(25303);
    }
    this.jRV = ((int)EN());
    if ((this.jRV < 800L) || (this.jRV < 1000L))
    {
      ab.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.jRV);
      h.vP(this.fileName);
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
      i = this.jRV;
      if (str != null)
      {
        ab.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
        localg = d.cGT().adV(str);
        if (localg != null)
        {
          if ((localg.field_status != 97) && (localg.field_status != 98)) {
            localg.field_status = 3;
          }
          localg.field_totallen = c.vh(h.bE(str, false));
          if (localg.field_totallen > 0) {
            break label410;
          }
          h.vk(str);
        }
      }
      d.cGU().run();
      ab.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
    }
    label410:
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.field_voicelenght = i;
    localg.bsY = 3424;
    bi localbi = new bi();
    localbi.kj(localg.field_user);
    localbi.setType(34);
    localbi.hL(1);
    localbi.kk(str);
    if (localg.field_status == 97)
    {
      localbi.setStatus(2);
      localbi.setContent(f.d(localg.field_human, localg.field_voicelenght, false));
    }
    for (;;)
    {
      localbi.fQ(bf.py(localg.field_user));
      localg.field_msglocalid = ((int)bf.l(localbi));
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
  
  public final void a(j.a parama)
  {
    this.sXu = parama;
  }
  
  public final void a(j.b paramb)
  {
    this.sXt = paramb;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(25302);
    ab.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
    try
    {
      ab.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
      if (this.caR != null) {
        this.caR.Et();
      }
      String str = this.fileName;
      if (str != null)
      {
        ab.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
        g localg = d.cGT().adV(str);
        if (localg != null)
        {
          localg.field_status = 8;
          localg.field_totallen = c.vh(h.bE(str, false));
          localg.bsY = 64;
          h.a(localg);
        }
      }
      d.cGU().run();
      this.fileName = "";
      AppMethodBeat.o(25302);
      return true;
    }
    finally
    {
      AppMethodBeat.o(25302);
    }
  }
  
  public final boolean eI(String paramString)
  {
    AppMethodBeat.i(25301);
    String str = k.ve(r.Zn());
    Object localObject = new g();
    ((g)localObject).field_filename = str;
    ((g)localObject).field_user = paramString;
    ((g)localObject).field_createtime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_clientid = str;
    ((g)localObject).field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_status = 1;
    ((g)localObject).field_human = r.Zn();
    ((g)localObject).bsY = -1;
    paramString = d.cGT();
    ab.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
    localObject = ((g)localObject).convertTo();
    int i = (int)paramString.db.insert("VoiceRemindInfo", "", (ContentValues)localObject);
    ab.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(i)));
    paramString = str;
    if (i == -1) {
      paramString = null;
    }
    this.fileName = paramString;
    aw.aaA().a(this);
    i = aw.aaA().KE();
    this.sXv = false;
    if (i != 0) {
      gy(100);
    }
    for (;;)
    {
      AppMethodBeat.o(25301);
      return false;
      new i.3(this).sendEmptyMessageDelayed(0, 50L);
    }
  }
  
  public final String getFileName()
  {
    return this.fileName;
  }
  
  public final int getMaxAmplitude()
  {
    AppMethodBeat.i(25300);
    if (this.caR != null)
    {
      int i = this.caR.getMaxAmplitude();
      if (i > ckX) {
        ckX = i;
      }
      ab.d("getMaxAmplitude", " map: " + i + " max:" + ckX + " per:" + i * 100 / ckX);
      i = i * 100 / ckX;
      AppMethodBeat.o(25300);
      return i;
    }
    AppMethodBeat.o(25300);
    return 0;
  }
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(25299);
    ab.d("MicroMsg.VoiceRemindRecorder", " Recorder onBluetoothHeadsetStateChange :".concat(String.valueOf(paramInt)));
    if (this.sXv)
    {
      AppMethodBeat.o(25299);
      return;
    }
    this.sXv = true;
    aw.aaA().b(this);
    this.caR = new m();
    new i.2(this);
    this.sXw = new i.a(this);
    com.tencent.mm.sdk.g.d.post(this.sXw, "VoiceRemindRecorder_record");
    this.sXy = 1;
    this.sXz.ag(3000L, 3000L);
    ab.d("MicroMsg.VoiceRemindRecorder", "start end time:" + bo.av(this.sXx));
    AppMethodBeat.o(25299);
  }
  
  public final boolean isRecording()
  {
    if (this.caR == null) {}
    while (this.caR.mStatus != 1) {
      return false;
    }
    return true;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(25305);
    if (this.caR != null)
    {
      this.caR.Et();
      ab.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
    }
    this.fileName = "";
    this.sXx = 0L;
    this.sXw = null;
    this.sXy = 0;
    this.lvI = 0L;
    AppMethodBeat.o(25305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.i
 * JD-Core Version:    0.7.0.1
 */
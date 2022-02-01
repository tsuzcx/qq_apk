package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
  extends v2protocal
{
  public byte[] Oio;
  byte[] Oip;
  public int field_voipcsChannelInfoLength;
  int field_voipcsEngineInfoLength;
  
  public a(MMHandler paramMMHandler)
  {
    super(paramMMHandler);
    AppMethodBeat.i(125338);
    this.Oio = new byte[2048];
    this.Oip = new byte[2048];
    this.field_voipcsChannelInfoLength = 0;
    this.field_voipcsEngineInfoLength = 0;
    AppMethodBeat.o(125338);
  }
  
  public final String gES()
  {
    AppMethodBeat.i(125339);
    getVoipcsEngineInfo(this.Oip, this.Oip.length);
    Log.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(this.field_voipcsEngineInfoLength) });
    String str = this.DPQ + "," + this.DPJ + "," + this.NQI + "," + c.gEX().OiV + "," + this.Ftu + "," + this.NQX + gBd() + new String(this.Oip, 0, this.field_voipcsEngineInfoLength);
    e.Logi("MicroMsg.CSV2protocal", "voipreport:NewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(125339);
    return str;
  }
  
  public final int gET()
  {
    AppMethodBeat.i(125340);
    this.netType = e.getNetType(MMApplicationContext.getContext());
    this.NQG = this.netType;
    c.gEX().NQG = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool1;
    boolean bool2;
    if ((this.NQG >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 30))
    {
      bool1 = true;
      if ((af.juH.jqm != 1) || (af.juH.jpO.width < 480) || (af.juH.jpO.height < 360) || (af.juH.jpQ.width < 480) || (af.juH.jpQ.height < 360)) {
        break label495;
      }
      bool2 = true;
      label152:
      if (af.juH.jqm != 0) {
        break label501;
      }
    }
    label495:
    label501:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (((bool1) || (bool2)) && (!bool3))
      {
        this.defaultWidth = 480;
        this.defaultHeight = 360;
        NQA = true;
        e.Logi("MicroMsg.CSV2protocal", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
      }
      e.Logi("MicroMsg.CSV2protocal", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool1 + ", bEnable480FromSvr:" + bool2 + ", bDisable480FromSvr:" + bool3);
      this.NRR = new int[this.defaultWidth * this.defaultHeight];
      h.aHE();
      this.ucB = com.tencent.mm.kernel.b.getUin();
      int i = Build.VERSION.SDK_INT;
      int j = OpenGlRender.getGLVersion();
      Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
      int k = localDisplay.getWidth();
      int m = localDisplay.getHeight();
      i = init(this.netType, 2, this.defaultWidth << 16 | this.defaultHeight, k << 16 | m, this.ucB, j << 24 | i << 16 | cpuFlag0, com.tencent.mm.loader.j.b.aSC() + "lib/", 8, 0L, 0, 0);
      e.Logd("MicroMsg.CSV2protocal", "protocalInitForCS protocal init ret :" + i + ",uin= " + this.ucB + ", groupRsCap = 0");
      this.lsn = true;
      if (i < 0) {
        reset();
      }
      AppMethodBeat.o(125340);
      return i;
      bool1 = false;
      break;
      bool2 = false;
      break label152;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a
 * JD-Core Version:    0.7.0.1
 */
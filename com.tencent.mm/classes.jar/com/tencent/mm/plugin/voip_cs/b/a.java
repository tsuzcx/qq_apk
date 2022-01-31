package com.tencent.mm.plugin.voip_cs.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  extends v2protocal
{
  public int field_voipcsChannelInfoLength;
  int field_voipcsEngineInfoLength;
  public byte[] tJF;
  byte[] tJG;
  
  public a(ak paramak)
  {
    super(paramak);
    AppMethodBeat.i(135285);
    this.tJF = new byte[2048];
    this.tJG = new byte[2048];
    this.field_voipcsChannelInfoLength = 0;
    this.field_voipcsEngineInfoLength = 0;
    AppMethodBeat.o(135285);
  }
  
  public final String cQj()
  {
    AppMethodBeat.i(135286);
    getVoipcsEngineInfo(this.tJG, this.tJG.length);
    ab.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(this.field_voipcsEngineInfoLength) });
    String str = this.nNh + "," + this.nNa + "," + this.tAb + "," + c.cQo().tKn + "," + this.tAp + "," + this.tAq + cOy() + new String(this.tJG, 0, this.field_voipcsEngineInfoLength);
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.CSV2protocal", "voipreport:NewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(135286);
    return str;
  }
  
  public final int cQk()
  {
    boolean bool3 = false;
    AppMethodBeat.i(135287);
    this.netType = com.tencent.mm.plugin.voip.a.a.getNetType(ah.getContext());
    this.tzZ = this.netType;
    c.cQo().tzZ = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool1;
    if ((this.tzZ >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 30))
    {
      bool1 = true;
      if ((ac.eru.eou != 1) || (ac.eru.enV.width < 480) || (ac.eru.enV.height < 360) || (ac.eru.enX.width < 480) || (ac.eru.enX.height < 360)) {
        break label489;
      }
    }
    label489:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (ac.eru.eou == 0) {
        bool3 = true;
      }
      if (((bool1) || (bool2)) && (!bool3))
      {
        this.defaultWidth = 480;
        this.defaultHeight = 360;
        tzX = true;
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.CSV2protocal", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
      }
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.CSV2protocal", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool1 + ", bEnable480FromSvr:" + bool2 + ", bDisable480FromSvr:" + bool3);
      this.tBa = new int[this.defaultWidth * this.defaultHeight];
      g.RJ();
      this.kTL = com.tencent.mm.kernel.a.getUin();
      int i = Build.VERSION.SDK_INT;
      int j = OpenGlRender.getGLVersion();
      Display localDisplay = ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay();
      int k = localDisplay.getWidth();
      int m = localDisplay.getHeight();
      i = init(this.netType, 2, this.defaultWidth << 16 | this.defaultHeight, k << 16 | m, this.kTL, cpuFlag0 | j << 24 | i << 16, e.eQu + "lib/", 8);
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.CSV2protocal", "protocal init ret :" + i + ",uin= " + this.kTL);
      this.isInited = true;
      if (i < 0) {
        reset();
      }
      AppMethodBeat.o(135287);
      return i;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a
 * JD-Core Version:    0.7.0.1
 */
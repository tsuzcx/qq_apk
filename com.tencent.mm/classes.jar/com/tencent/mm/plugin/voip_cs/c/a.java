package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;

public final class a
  extends v2protocal
{
  public byte[] AUa;
  byte[] AUb;
  public int field_voipcsChannelInfoLength;
  int field_voipcsEngineInfoLength;
  
  public a(ao paramao)
  {
    super(paramao);
    AppMethodBeat.i(125338);
    this.AUa = new byte[2048];
    this.AUb = new byte[2048];
    this.field_voipcsChannelInfoLength = 0;
    this.field_voipcsEngineInfoLength = 0;
    AppMethodBeat.o(125338);
  }
  
  public final int enA()
  {
    boolean bool3 = false;
    AppMethodBeat.i(125340);
    this.netType = com.tencent.mm.plugin.voip.b.d.getNetType(ai.getContext());
    this.AGe = this.netType;
    c.enE().AGe = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool1;
    if ((this.AGe >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 30))
    {
      bool1 = true;
      if ((ae.fJd.fFg != 1) || (ae.fJd.fEI.width < 480) || (ae.fJd.fEI.height < 360) || (ae.fJd.fEK.width < 480) || (ae.fJd.fEK.height < 360)) {
        break label487;
      }
    }
    label487:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (ae.fJd.fFg == 0) {
        bool3 = true;
      }
      if (((bool1) || (bool2)) && (!bool3))
      {
        this.defaultWidth = 480;
        this.defaultHeight = 360;
        AGa = true;
        com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.CSV2protocal", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
      }
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.CSV2protocal", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool1 + ", bEnable480FromSvr:" + bool2 + ", bDisable480FromSvr:" + bool3);
      this.AHp = new int[this.defaultWidth * this.defaultHeight];
      g.agP();
      this.oDO = com.tencent.mm.kernel.a.getUin();
      int i = Build.VERSION.SDK_INT;
      int j = OpenGlRender.getGLVersion();
      Display localDisplay = ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay();
      int k = localDisplay.getWidth();
      int m = localDisplay.getHeight();
      i = init(this.netType, 2, this.defaultWidth << 16 | this.defaultHeight, k << 16 | m, this.oDO, j << 24 | i << 16 | cpuFlag0, b.aoY() + "lib/", 8, 0L);
      com.tencent.mm.plugin.voip.b.d.Logd("MicroMsg.CSV2protocal", "protocal init ret :" + i + ",uin= " + this.oDO);
      this.icd = true;
      if (i < 0) {
        reset();
      }
      AppMethodBeat.o(125340);
      return i;
      bool1 = false;
      break;
    }
  }
  
  public final String enz()
  {
    AppMethodBeat.i(125339);
    getVoipcsEngineInfo(this.AUb, this.AUb.length);
    ac.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(this.field_voipcsEngineInfoLength) });
    String str = this.tIN + "," + this.tIG + "," + this.AGg + "," + c.enE().AUH + "," + this.AGv + "," + this.AGw + ekB() + new String(this.AUb, 0, this.field_voipcsEngineInfoLength);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.CSV2protocal", "voipreport:NewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(125339);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a
 * JD-Core Version:    0.7.0.1
 */
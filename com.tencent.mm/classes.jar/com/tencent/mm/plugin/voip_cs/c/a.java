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
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
  extends v2protocal
{
  public byte[] HqD;
  byte[] HqE;
  public int field_voipcsChannelInfoLength;
  int field_voipcsEngineInfoLength;
  
  public a(MMHandler paramMMHandler)
  {
    super(paramMMHandler);
    AppMethodBeat.i(125338);
    this.HqD = new byte[2048];
    this.HqE = new byte[2048];
    this.field_voipcsChannelInfoLength = 0;
    this.field_voipcsEngineInfoLength = 0;
    AppMethodBeat.o(125338);
  }
  
  public final String fMo()
  {
    AppMethodBeat.i(125339);
    getVoipcsEngineInfo(this.HqE, this.HqE.length);
    Log.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(this.field_voipcsEngineInfoLength) });
    String str = this.ypO + "," + this.ypH + "," + this.Haw + "," + c.fMt().Hrk + "," + this.zNX + "," + this.HaL + fIO() + new String(this.HqE, 0, this.field_voipcsEngineInfoLength);
    e.Logi("MicroMsg.CSV2protocal", "voipreport:NewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(125339);
    return str;
  }
  
  public final int fMp()
  {
    AppMethodBeat.i(125340);
    this.netType = e.getNetType(MMApplicationContext.getContext());
    this.Hau = this.netType;
    c.fMt().Hau = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool1;
    boolean bool2;
    if ((this.Hau >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 30))
    {
      bool1 = true;
      if ((ae.gKt.gGc != 1) || (ae.gKt.gFE.width < 480) || (ae.gKt.gFE.height < 360) || (ae.gKt.gFG.width < 480) || (ae.gKt.gFG.height < 360)) {
        break label494;
      }
      bool2 = true;
      label152:
      if (ae.gKt.gGc != 0) {
        break label500;
      }
    }
    label494:
    label500:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (((bool1) || (bool2)) && (!bool3))
      {
        this.defaultWidth = 480;
        this.defaultHeight = 360;
        Hap = true;
        e.Logi("MicroMsg.CSV2protocal", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
      }
      e.Logi("MicroMsg.CSV2protocal", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool1 + ", bEnable480FromSvr:" + bool2 + ", bDisable480FromSvr:" + bool3);
      this.HbF = new int[this.defaultWidth * this.defaultHeight];
      g.aAf();
      this.qDA = com.tencent.mm.kernel.a.getUin();
      int i = Build.VERSION.SDK_INT;
      int j = OpenGlRender.getGLVersion();
      Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
      int k = localDisplay.getWidth();
      int m = localDisplay.getHeight();
      i = init(this.netType, 2, this.defaultWidth << 16 | this.defaultHeight, k << 16 | m, this.qDA, j << 24 | i << 16 | cpuFlag0, b.aKA() + "lib/", 8, 0L, 0);
      e.Logd("MicroMsg.CSV2protocal", "protocalInitForCS protocal init ret :" + i + ",uin= " + this.qDA + ", groupRsCap = 0");
      this.iCs = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a
 * JD-Core Version:    0.7.0.1
 */
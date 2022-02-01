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
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

public final class a
  extends v2protocal
{
  public byte[] Cui;
  byte[] Cuj;
  public int field_voipcsChannelInfoLength;
  int field_voipcsEngineInfoLength;
  
  public a(ap paramap)
  {
    super(paramap);
    AppMethodBeat.i(125338);
    this.Cui = new byte[2048];
    this.Cuj = new byte[2048];
    this.field_voipcsChannelInfoLength = 0;
    this.field_voipcsEngineInfoLength = 0;
    AppMethodBeat.o(125338);
  }
  
  public final String eBy()
  {
    AppMethodBeat.i(125339);
    getVoipcsEngineInfo(this.Cuj, this.Cuj.length);
    ad.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(this.field_voipcsEngineInfoLength) });
    String str = this.uLA + "," + this.uLt + "," + this.Cfg + "," + c.eBD().CuP + "," + this.Cfv + "," + this.Cfw + eym() + new String(this.Cuj, 0, this.field_voipcsEngineInfoLength);
    f.Logi("MicroMsg.CSV2protocal", "voipreport:NewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(125339);
    return str;
  }
  
  public final int eBz()
  {
    boolean bool3 = false;
    AppMethodBeat.i(125340);
    this.netType = f.getNetType(aj.getContext());
    this.Cfe = this.netType;
    c.eBD().Cfe = this.netType;
    if (this.netType == 5) {
      this.netType = 4;
    }
    boolean bool1;
    if ((this.Cfe >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 30))
    {
      bool1 = true;
      if ((ae.gcE.fYF != 1) || (ae.gcE.fYh.width < 480) || (ae.gcE.fYh.height < 360) || (ae.gcE.fYj.width < 480) || (ae.gcE.fYj.height < 360)) {
        break label490;
      }
    }
    label490:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (ae.gcE.fYF == 0) {
        bool3 = true;
      }
      if (((bool1) || (bool2)) && (!bool3))
      {
        this.defaultWidth = 480;
        this.defaultHeight = 360;
        Cfa = true;
        f.Logi("MicroMsg.CSV2protocal", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
      }
      f.Logi("MicroMsg.CSV2protocal", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool1 + ", bEnable480FromSvr:" + bool2 + ", bDisable480FromSvr:" + bool3);
      this.Cgq = new int[this.defaultWidth * this.defaultHeight];
      g.ajA();
      this.pho = com.tencent.mm.kernel.a.getUin();
      int i = Build.VERSION.SDK_INT;
      int j = OpenGlRender.getGLVersion();
      Display localDisplay = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay();
      int k = localDisplay.getWidth();
      int m = localDisplay.getHeight();
      i = init(this.netType, 2, this.defaultWidth << 16 | this.defaultHeight, k << 16 | m, this.pho, j << 24 | i << 16 | cpuFlag0, b.arL() + "lib/", 8, 0L);
      f.Logd("MicroMsg.CSV2protocal", "protocal init ret :" + i + ",uin= " + this.pho);
      this.ivz = true;
      if (i < 0) {
        reset();
      }
      AppMethodBeat.o(125340);
      return i;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a
 * JD-Core Version:    0.7.0.1
 */
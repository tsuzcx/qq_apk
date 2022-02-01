package com.tencent.mm.plugin.voip_cs.model;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
  extends v2protocal
{
  public byte[] UWJ;
  byte[] UWK;
  public int field_voipcsChannelInfoLength;
  int field_voipcsEngineInfoLength;
  
  public a(MMHandler paramMMHandler)
  {
    super(paramMMHandler);
    AppMethodBeat.i(125338);
    this.UWJ = new byte[2048];
    this.UWK = new byte[2048];
    this.field_voipcsChannelInfoLength = 0;
    this.field_voipcsEngineInfoLength = 0;
    AppMethodBeat.o(125338);
  }
  
  public final String idT()
  {
    AppMethodBeat.i(125339);
    getVoipcsEngineInfo(this.UWK, this.UWK.length);
    Log.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", new Object[] { Integer.valueOf(this.field_voipcsEngineInfoLength) });
    String str = this.JHb + "," + this.Hnt + "," + this.UDu + "," + c.idY().UXq + "," + this.LpO + "," + this.UDJ + hZc() + new String(this.UWK, 0, this.field_voipcsEngineInfoLength);
    g.Logi("MicroMsg.CSV2protocal", "voipreport:NewEngineString:".concat(String.valueOf(str)));
    AppMethodBeat.o(125339);
    return str;
  }
  
  public final int idU()
  {
    AppMethodBeat.i(125340);
    MMApplicationContext.getContext();
    this.netType = g.ibq();
    this.UDs = this.netType;
    c.idY().UDs = this.netType;
    boolean bool1;
    boolean bool2;
    if ((this.UDs >= 4) && ((cpuFlag0 & 0x400) != 0) && ((cpuFlag0 & 0xFF) >= 30))
    {
      bool1 = true;
      if ((af.lXY.lTt != 1) || (af.lXY.lSV.width < 480) || (af.lXY.lSV.height < 360) || (af.lXY.lSX.width < 480) || (af.lXY.lSX.height < 360)) {
        break label484;
      }
      bool2 = true;
      label140:
      if (af.lXY.lTt != 0) {
        break label490;
      }
    }
    label484:
    label490:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (((bool1) || (bool2)) && (!bool3))
      {
        this.defaultWidth = 480;
        this.defaultHeight = 360;
        UDm = true;
        g.Logi("MicroMsg.CSV2protocal", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
      }
      g.Logi("MicroMsg.CSV2protocal", "steve: Android CPUFlag:" + (cpuFlag0 & 0xFF) + ", 480x360 Enc flags: bEnable480FromLocal:" + bool1 + ", bEnable480FromSvr:" + bool2 + ", bDisable480FromSvr:" + bool3);
      this.UEW = new int[this.defaultWidth * this.defaultHeight];
      h.baC();
      this.xiF = com.tencent.mm.kernel.b.getUin();
      int i = Build.VERSION.SDK_INT;
      int j = OpenGlRender.getGLVersion();
      Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
      int k = localDisplay.getWidth();
      int m = localDisplay.getHeight();
      i = init(this.netType, 2, this.defaultWidth << 16 | this.defaultHeight, k << 16 | m, this.xiF, j << 24 | i << 16 | cpuFlag0, com.tencent.mm.loader.i.b.bmq() + "lib/", 8, 0L, 0, 0, 0);
      g.Logd("MicroMsg.CSV2protocal", "protocalInitForCS protocal init ret :" + i + ",uin= " + this.xiF + ", groupRsCap = 0");
      this.ojM = true;
      if (i < 0) {
        reset();
      }
      AppMethodBeat.o(125340);
      return i;
      bool1 = false;
      break;
      bool2 = false;
      break label140;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.a
 * JD-Core Version:    0.7.0.1
 */
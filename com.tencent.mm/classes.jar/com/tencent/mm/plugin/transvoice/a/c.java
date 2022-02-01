package com.tencent.mm.plugin.transvoice.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "", "()V", "clickChangeLanguageTime", "", "getClickChangeLanguageTime", "()J", "setClickChangeLanguageTime", "(J)V", "defaultLanguageType", "", "getDefaultLanguageType", "()I", "setDefaultLanguageType", "(I)V", "enableReport", "", "getEnableReport", "()Z", "setEnableReport", "(Z)V", "value", "exitType", "getExitType", "setExitType", "isTrans2TxtAvailable", "setTrans2TxtAvailable", "isTransEdited", "setTransEdited", "isTransFinished", "setTransFinished", "isTransGotoEditPanel", "setTransGotoEditPanel", "isTransTimeout", "setTransTimeout", "networkType", "getNetworkType", "setNetworkType", "sendLanguageType", "getSendLanguageType", "setSendLanguageType", "startRecordPressLocX", "getStartRecordPressLocX", "setStartRecordPressLocX", "startRecordPressLocY", "getStartRecordPressLocY", "setStartRecordPressLocY", "startRecordTime", "getStartRecordTime", "setStartRecordTime", "stopRecordPressLocX", "getStopRecordPressLocX", "setStopRecordPressLocX", "stopRecordPressLocY", "getStopRecordPressLocY", "setStopRecordPressLocY", "stopRecordTime", "getStopRecordTime", "setStopRecordTime", "transEndTime", "getTransEndTime", "setTransEndTime", "txtCountFinallySend", "getTxtCountFinallySend", "setTxtCountFinallySend", "txtCountFromServer", "getTxtCountFromServer", "setTxtCountFromServer", "voiceDuration", "getVoiceDuration", "setVoiceDuration", "report", "", "reset", "Companion", "SingletonHolder", "plugin-transvoice_release"})
public final class c
{
  private static final c Gub;
  public static final a Guc;
  public boolean GtJ;
  public int GtK;
  public int GtL;
  public long GtM;
  public int GtN;
  public int GtO;
  public long GtP;
  public long GtQ;
  public int GtR = g.jwp;
  public int GtS = g.jwp;
  public int GtT;
  public long GtU;
  public int GtV;
  public int GtW;
  public int GtX;
  public int GtY;
  public int GtZ;
  public int Gua;
  private int gmJ;
  private int networkType;
  public long ofl;
  
  static
  {
    AppMethodBeat.i(102548);
    Guc = new a((byte)0);
    b localb = b.Gue;
    Gub = b.fAv();
    AppMethodBeat.o(102548);
  }
  
  private void report()
  {
    AppMethodBeat.i(102547);
    h localh = h.CyF;
    long l1 = this.ofl;
    int i = this.GtK;
    int j = this.GtL;
    long l2 = this.GtM;
    int k = this.GtN;
    int m = this.GtO;
    int n = this.gmJ;
    int i1 = this.networkType;
    long l3 = this.GtP;
    long l4 = this.GtQ;
    int i2 = this.GtR;
    int i3 = this.GtS;
    int i4 = this.GtT;
    long l5 = this.GtU;
    int i5 = this.GtV;
    int i6 = this.GtW;
    int i7 = this.GtX;
    int i8 = this.GtY;
    int i9 = this.GtZ;
    int i10 = this.Gua;
    Object localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "MMApplicationContext.getContext().resources");
    int i11 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "MMApplicationContext.getContext().resources");
    localh.a(17164, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l5), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(((Resources)localObject).getDisplayMetrics().heightPixels) });
    reset();
    AppMethodBeat.o(102547);
  }
  
  private void reset()
  {
    this.ofl = 0L;
    this.GtK = 0;
    this.GtL = 0;
    this.GtM = 0L;
    this.GtN = 0;
    this.GtO = 0;
    this.networkType = 0;
    this.GtP = 0L;
    this.GtQ = 0L;
    this.GtR = g.jwp;
    this.GtS = g.jwp;
    this.GtT = 0;
    this.GtU = 0L;
    this.GtV = 0;
    this.GtW = 0;
    this.GtX = 0;
    this.GtY = 0;
    this.GtZ = 0;
    this.Gua = 0;
  }
  
  public final void setExitType(int paramInt)
  {
    AppMethodBeat.i(102546);
    if (this.GtJ)
    {
      this.GtJ = false;
      this.gmJ = paramInt;
      this.networkType = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
      report();
      AppMethodBeat.o(102546);
      return;
    }
    reset();
    AppMethodBeat.o(102546);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$Companion;", "", "()V", "MMNewVoiceInputExitCancel", "", "MMNewVoiceInputExitNormal", "MMNewVoiceInputExitTooShort", "MMNewVoiceInputExitTransNoData", "MMNewVoiceInputExitTransNoNetwork", "MMNewVoiceInputExitTransSend", "MMNewVoiceInputExitTransSendCancel", "MMNewVoiceInputExitTransSendEdited", "MMNewVoiceInputExitTransSendOriVoice", "instance", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getInstance", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getHolder", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"})
  static final class b
  {
    private static final c Gud;
    public static final b Gue;
    
    static
    {
      AppMethodBeat.i(102545);
      Gue = new b();
      Gud = new c((byte)0);
      AppMethodBeat.o(102545);
    }
    
    public static c fAv()
    {
      return Gud;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.c
 * JD-Core Version:    0.7.0.1
 */
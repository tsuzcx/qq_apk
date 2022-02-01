package com.tencent.mm.plugin.transvoice.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "", "()V", "clickChangeLanguageTime", "", "getClickChangeLanguageTime", "()J", "setClickChangeLanguageTime", "(J)V", "defaultLanguageType", "", "getDefaultLanguageType", "()I", "setDefaultLanguageType", "(I)V", "enableReport", "", "getEnableReport", "()Z", "setEnableReport", "(Z)V", "value", "exitType", "getExitType", "setExitType", "isTrans2TxtAvailable", "setTrans2TxtAvailable", "isTransEdited", "setTransEdited", "isTransFinished", "setTransFinished", "isTransGotoEditPanel", "setTransGotoEditPanel", "isTransTimeout", "setTransTimeout", "networkType", "getNetworkType", "setNetworkType", "sendLanguageType", "getSendLanguageType", "setSendLanguageType", "startRecordPressLocX", "getStartRecordPressLocX", "setStartRecordPressLocX", "startRecordPressLocY", "getStartRecordPressLocY", "setStartRecordPressLocY", "startRecordTime", "getStartRecordTime", "setStartRecordTime", "stopRecordPressLocX", "getStopRecordPressLocX", "setStopRecordPressLocX", "stopRecordPressLocY", "getStopRecordPressLocY", "setStopRecordPressLocY", "stopRecordTime", "getStopRecordTime", "setStopRecordTime", "transEndTime", "getTransEndTime", "setTransEndTime", "txtCountFinallySend", "getTxtCountFinallySend", "setTxtCountFinallySend", "txtCountFromServer", "getTxtCountFromServer", "setTxtCountFromServer", "voiceDuration", "getVoiceDuration", "setVoiceDuration", "report", "", "reset", "Companion", "SingletonHolder", "plugin-transvoice_release"})
public final class c
{
  private static final c yWw;
  public static final a yWx;
  private int fjS;
  public long lKF;
  private int networkType;
  public boolean yWe;
  public int yWf;
  public int yWg;
  public long yWh;
  public int yWi;
  public int yWj;
  public long yWk;
  public long yWl;
  public int yWm = g.hEl;
  public int yWn = g.hEl;
  public int yWo;
  public long yWp;
  public int yWq;
  public int yWr;
  public int yWs;
  public int yWt;
  public int yWu;
  public int yWv;
  
  static
  {
    AppMethodBeat.i(102548);
    yWx = new a((byte)0);
    b localb = b.yWz;
    yWw = b.dQF();
    AppMethodBeat.o(102548);
  }
  
  private void report()
  {
    AppMethodBeat.i(102547);
    h localh = h.vKh;
    long l1 = this.lKF;
    int i = this.yWf;
    int j = this.yWg;
    long l2 = this.yWh;
    int k = this.yWi;
    int m = this.yWj;
    int n = this.fjS;
    int i1 = this.networkType;
    long l3 = this.yWk;
    long l4 = this.yWl;
    int i2 = this.yWm;
    int i3 = this.yWn;
    int i4 = this.yWo;
    long l5 = this.yWp;
    int i5 = this.yWq;
    int i6 = this.yWr;
    int i7 = this.yWs;
    int i8 = this.yWt;
    int i9 = this.yWu;
    int i10 = this.yWv;
    Object localObject = aj.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    k.g(localObject, "MMApplicationContext.getContext().resources");
    int i11 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = aj.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    k.g(localObject, "MMApplicationContext.getContext().resources");
    localh.f(17164, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l5), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(((Resources)localObject).getDisplayMetrics().heightPixels) });
    reset();
    AppMethodBeat.o(102547);
  }
  
  private void reset()
  {
    this.lKF = 0L;
    this.yWf = 0;
    this.yWg = 0;
    this.yWh = 0L;
    this.yWi = 0;
    this.yWj = 0;
    this.networkType = 0;
    this.yWk = 0L;
    this.yWl = 0L;
    this.yWm = g.hEl;
    this.yWn = g.hEl;
    this.yWo = 0;
    this.yWp = 0L;
    this.yWq = 0;
    this.yWr = 0;
    this.yWs = 0;
    this.yWt = 0;
    this.yWu = 0;
    this.yWv = 0;
  }
  
  public final void setExitType(int paramInt)
  {
    AppMethodBeat.i(102546);
    if (this.yWe)
    {
      this.yWe = false;
      this.fjS = paramInt;
      this.networkType = ay.ix(aj.getContext());
      report();
      AppMethodBeat.o(102546);
      return;
    }
    reset();
    AppMethodBeat.o(102546);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$Companion;", "", "()V", "MMNewVoiceInputExitCancel", "", "MMNewVoiceInputExitNormal", "MMNewVoiceInputExitTooShort", "MMNewVoiceInputExitTransNoData", "MMNewVoiceInputExitTransNoNetwork", "MMNewVoiceInputExitTransSend", "MMNewVoiceInputExitTransSendCancel", "MMNewVoiceInputExitTransSendEdited", "MMNewVoiceInputExitTransSendOriVoice", "instance", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getInstance", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getHolder", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"})
  static final class b
  {
    private static final c yWy;
    public static final b yWz;
    
    static
    {
      AppMethodBeat.i(102545);
      yWz = new b();
      yWy = new c((byte)0);
      AppMethodBeat.o(102545);
    }
    
    public static c dQF()
    {
      return yWy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.c
 * JD-Core Version:    0.7.0.1
 */
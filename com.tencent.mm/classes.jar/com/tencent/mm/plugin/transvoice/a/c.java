package com.tencent.mm.plugin.transvoice.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "", "()V", "clickChangeLanguageTime", "", "getClickChangeLanguageTime", "()J", "setClickChangeLanguageTime", "(J)V", "defaultLanguageType", "", "getDefaultLanguageType", "()I", "setDefaultLanguageType", "(I)V", "enableReport", "", "getEnableReport", "()Z", "setEnableReport", "(Z)V", "value", "exitType", "getExitType", "setExitType", "isTrans2TxtAvailable", "setTrans2TxtAvailable", "isTransEdited", "setTransEdited", "isTransFinished", "setTransFinished", "isTransGotoEditPanel", "setTransGotoEditPanel", "isTransTimeout", "setTransTimeout", "networkType", "getNetworkType", "setNetworkType", "sendLanguageType", "getSendLanguageType", "setSendLanguageType", "startRecordPressLocX", "getStartRecordPressLocX", "setStartRecordPressLocX", "startRecordPressLocY", "getStartRecordPressLocY", "setStartRecordPressLocY", "startRecordTime", "getStartRecordTime", "setStartRecordTime", "stopRecordPressLocX", "getStopRecordPressLocX", "setStopRecordPressLocX", "stopRecordPressLocY", "getStopRecordPressLocY", "setStopRecordPressLocY", "stopRecordTime", "getStopRecordTime", "setStopRecordTime", "transEndTime", "getTransEndTime", "setTransEndTime", "txtCountFinallySend", "getTxtCountFinallySend", "setTxtCountFinallySend", "txtCountFromServer", "getTxtCountFromServer", "setTxtCountFromServer", "voiceDuration", "getVoiceDuration", "setVoiceDuration", "report", "", "reset", "Companion", "SingletonHolder", "plugin-transvoice_release"})
public final class c
{
  private static final c BBX;
  public static final c.a BBY;
  public boolean BBF;
  public int BBG;
  public int BBH;
  public long BBI;
  public int BBJ;
  public int BBK;
  public long BBL;
  public long BBM;
  public int BBN = com.tencent.mm.modelvoiceaddr.g.iyh;
  public int BBO = com.tencent.mm.modelvoiceaddr.g.iyh;
  public int BBP;
  public long BBQ;
  public int BBR;
  public int BBS;
  public int BBT;
  public int BBU;
  public int BBV;
  public int BBW;
  private int fFu;
  public long mNe;
  private int networkType;
  
  static
  {
    AppMethodBeat.i(102548);
    BBY = new c.a((byte)0);
    b localb = b.BCa;
    BBX = b.erv();
    AppMethodBeat.o(102548);
  }
  
  private void report()
  {
    AppMethodBeat.i(102547);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
    long l1 = this.mNe;
    int i = this.BBG;
    int j = this.BBH;
    long l2 = this.BBI;
    int k = this.BBJ;
    int m = this.BBK;
    int n = this.fFu;
    int i1 = this.networkType;
    long l3 = this.BBL;
    long l4 = this.BBM;
    int i2 = this.BBN;
    int i3 = this.BBO;
    int i4 = this.BBP;
    long l5 = this.BBQ;
    int i5 = this.BBR;
    int i6 = this.BBS;
    int i7 = this.BBT;
    int i8 = this.BBU;
    int i9 = this.BBV;
    int i10 = this.BBW;
    Object localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "MMApplicationContext.getContext().resources");
    int i11 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "MMApplicationContext.getContext().resources");
    localg.f(17164, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l5), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(((Resources)localObject).getDisplayMetrics().heightPixels) });
    reset();
    AppMethodBeat.o(102547);
  }
  
  private void reset()
  {
    this.mNe = 0L;
    this.BBG = 0;
    this.BBH = 0;
    this.BBI = 0L;
    this.BBJ = 0;
    this.BBK = 0;
    this.networkType = 0;
    this.BBL = 0L;
    this.BBM = 0L;
    this.BBN = com.tencent.mm.modelvoiceaddr.g.iyh;
    this.BBO = com.tencent.mm.modelvoiceaddr.g.iyh;
    this.BBP = 0;
    this.BBQ = 0L;
    this.BBR = 0;
    this.BBS = 0;
    this.BBT = 0;
    this.BBU = 0;
    this.BBV = 0;
    this.BBW = 0;
  }
  
  public final void setExitType(int paramInt)
  {
    AppMethodBeat.i(102546);
    if (this.BBF)
    {
      this.BBF = false;
      this.fFu = paramInt;
      this.networkType = ay.iS(aj.getContext());
      report();
      AppMethodBeat.o(102546);
      return;
    }
    reset();
    AppMethodBeat.o(102546);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getHolder", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"})
  static final class b
  {
    private static final c BBZ;
    public static final b BCa;
    
    static
    {
      AppMethodBeat.i(102545);
      BCa = new b();
      BBZ = new c((byte)0);
      AppMethodBeat.o(102545);
    }
    
    public static c erv()
    {
      return BBZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.c
 * JD-Core Version:    0.7.0.1
 */
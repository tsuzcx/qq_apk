package com.tencent.mm.plugin.transvoice.a;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "", "()V", "clickChangeLanguageTime", "", "getClickChangeLanguageTime", "()J", "setClickChangeLanguageTime", "(J)V", "defaultLanguageType", "", "getDefaultLanguageType", "()I", "setDefaultLanguageType", "(I)V", "enableReport", "", "getEnableReport", "()Z", "setEnableReport", "(Z)V", "value", "exitType", "getExitType", "setExitType", "isTrans2TxtAvailable", "setTrans2TxtAvailable", "isTransEdited", "setTransEdited", "isTransFinished", "setTransFinished", "isTransGotoEditPanel", "setTransGotoEditPanel", "isTransTimeout", "setTransTimeout", "networkType", "getNetworkType", "setNetworkType", "sendLanguageType", "getSendLanguageType", "setSendLanguageType", "startRecordPressLocX", "getStartRecordPressLocX", "setStartRecordPressLocX", "startRecordPressLocY", "getStartRecordPressLocY", "setStartRecordPressLocY", "startRecordTime", "getStartRecordTime", "setStartRecordTime", "stopRecordPressLocX", "getStopRecordPressLocX", "setStopRecordPressLocX", "stopRecordPressLocY", "getStopRecordPressLocY", "setStopRecordPressLocY", "stopRecordTime", "getStopRecordTime", "setStopRecordTime", "transEndTime", "getTransEndTime", "setTransEndTime", "txtCountFinallySend", "getTxtCountFinallySend", "setTxtCountFinallySend", "txtCountFromServer", "getTxtCountFromServer", "setTxtCountFromServer", "voiceDuration", "getVoiceDuration", "setVoiceDuration", "report", "", "reset", "Companion", "SingletonHolder", "plugin-transvoice_release"})
public final class c
{
  private static final c tpC;
  public static final c.a tpD;
  private int dZJ;
  public long iWt;
  private int networkType;
  public int tpA;
  public int tpB;
  public boolean tpk;
  public int tpl;
  public int tpm;
  public long tpn;
  public int tpo;
  public int tpp;
  public long tpq;
  public long tpr;
  public int tps;
  public int tpt;
  public int tpu;
  public long tpv;
  public int tpw;
  public int tpx;
  public int tpy;
  public int tpz;
  
  static
  {
    AppMethodBeat.i(155211);
    tpD = new c.a((byte)0);
    b localb = b.tpF;
    tpC = b.cKZ();
    AppMethodBeat.o(155211);
  }
  
  private void IE()
  {
    AppMethodBeat.i(155210);
    h localh = h.qsU;
    long l1 = this.iWt;
    int i = this.tpl;
    int j = this.tpm;
    long l2 = this.tpn;
    int k = this.tpo;
    int m = this.tpp;
    int n = this.dZJ;
    int i1 = this.networkType;
    long l3 = this.tpq;
    long l4 = this.tpr;
    int i2 = this.tps;
    int i3 = this.tpt;
    int i4 = this.tpu;
    long l5 = this.tpv;
    int i5 = this.tpw;
    int i6 = this.tpx;
    int i7 = this.tpy;
    int i8 = this.tpz;
    int i9 = this.tpA;
    int i10 = this.tpB;
    Object localObject = ah.getContext();
    j.p(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    j.p(localObject, "MMApplicationContext.getContext().resources");
    int i11 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = ah.getContext();
    j.p(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    j.p(localObject, "MMApplicationContext.getContext().resources");
    localh.e(17164, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l5), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(((Resources)localObject).getDisplayMetrics().heightPixels) });
    reset();
    AppMethodBeat.o(155210);
  }
  
  private void reset()
  {
    this.iWt = 0L;
    this.tpl = 0;
    this.tpm = 0;
    this.tpn = 0L;
    this.tpo = 0;
    this.tpp = 0;
    this.networkType = 0;
    this.tpq = 0L;
    this.tpr = 0L;
    this.tps = 0;
    this.tpt = 0;
    this.tpu = 0;
    this.tpv = 0L;
    this.tpw = 0;
    this.tpx = 0;
    this.tpy = 0;
    this.tpz = 0;
    this.tpA = 0;
    this.tpB = 0;
  }
  
  public final void GV(int paramInt)
  {
    AppMethodBeat.i(155209);
    if (this.tpk)
    {
      this.tpk = false;
      this.dZJ = paramInt;
      this.networkType = at.gV(ah.getContext());
      IE();
      AppMethodBeat.o(155209);
      return;
    }
    reset();
    AppMethodBeat.o(155209);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getHolder", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"})
  static final class b
  {
    private static final c tpE;
    public static final b tpF;
    
    static
    {
      AppMethodBeat.i(155208);
      tpF = new b();
      tpE = new c((byte)0);
      AppMethodBeat.o(155208);
    }
    
    public static c cKZ()
    {
      return tpE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.c
 * JD-Core Version:    0.7.0.1
 */
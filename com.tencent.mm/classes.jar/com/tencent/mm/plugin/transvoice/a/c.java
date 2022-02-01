package com.tencent.mm.plugin.transvoice.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "", "()V", "clickChangeLanguageTime", "", "getClickChangeLanguageTime", "()J", "setClickChangeLanguageTime", "(J)V", "defaultLanguageType", "", "getDefaultLanguageType", "()I", "setDefaultLanguageType", "(I)V", "enableReport", "", "getEnableReport", "()Z", "setEnableReport", "(Z)V", "value", "exitType", "getExitType", "setExitType", "isTrans2TxtAvailable", "setTrans2TxtAvailable", "isTransEdited", "setTransEdited", "isTransFinished", "setTransFinished", "isTransGotoEditPanel", "setTransGotoEditPanel", "isTransTimeout", "setTransTimeout", "networkType", "getNetworkType", "setNetworkType", "sendLanguageType", "getSendLanguageType", "setSendLanguageType", "startRecordPressLocX", "getStartRecordPressLocX", "setStartRecordPressLocX", "startRecordPressLocY", "getStartRecordPressLocY", "setStartRecordPressLocY", "startRecordTime", "getStartRecordTime", "setStartRecordTime", "stopRecordPressLocX", "getStopRecordPressLocX", "setStopRecordPressLocX", "stopRecordPressLocY", "getStopRecordPressLocY", "setStopRecordPressLocY", "stopRecordTime", "getStopRecordTime", "setStopRecordTime", "transEndTime", "getTransEndTime", "setTransEndTime", "txtCountFinallySend", "getTxtCountFinallySend", "setTxtCountFinallySend", "txtCountFromServer", "getTxtCountFromServer", "setTxtCountFromServer", "voiceDuration", "getVoiceDuration", "setVoiceDuration", "report", "", "reset", "Companion", "SingletonHolder", "plugin-transvoice_release"})
public final class c
{
  private static final c BTv;
  public static final c.a BTw;
  public boolean BTd;
  public int BTe;
  public int BTf;
  public long BTg;
  public int BTh;
  public int BTi;
  public long BTj;
  public long BTk;
  public int BTl = com.tencent.mm.modelvoiceaddr.g.iBa;
  public int BTm = com.tencent.mm.modelvoiceaddr.g.iBa;
  public int BTn;
  public long BTo;
  public int BTp;
  public int BTq;
  public int BTr;
  public int BTs;
  public int BTt;
  public int BTu;
  private int fHy;
  public long mSh;
  private int networkType;
  
  static
  {
    AppMethodBeat.i(102548);
    BTw = new c.a((byte)0);
    b localb = b.BTy;
    BTv = b.evc();
    AppMethodBeat.o(102548);
  }
  
  private void report()
  {
    AppMethodBeat.i(102547);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
    long l1 = this.mSh;
    int i = this.BTe;
    int j = this.BTf;
    long l2 = this.BTg;
    int k = this.BTh;
    int m = this.BTi;
    int n = this.fHy;
    int i1 = this.networkType;
    long l3 = this.BTj;
    long l4 = this.BTk;
    int i2 = this.BTl;
    int i3 = this.BTm;
    int i4 = this.BTn;
    long l5 = this.BTo;
    int i5 = this.BTp;
    int i6 = this.BTq;
    int i7 = this.BTr;
    int i8 = this.BTs;
    int i9 = this.BTt;
    int i10 = this.BTu;
    Object localObject = ak.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "MMApplicationContext.getContext().resources");
    int i11 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = ak.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "MMApplicationContext.getContext().resources");
    localg.f(17164, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l5), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(((Resources)localObject).getDisplayMetrics().heightPixels) });
    reset();
    AppMethodBeat.o(102547);
  }
  
  private void reset()
  {
    this.mSh = 0L;
    this.BTe = 0;
    this.BTf = 0;
    this.BTg = 0L;
    this.BTh = 0;
    this.BTi = 0;
    this.networkType = 0;
    this.BTj = 0L;
    this.BTk = 0L;
    this.BTl = com.tencent.mm.modelvoiceaddr.g.iBa;
    this.BTm = com.tencent.mm.modelvoiceaddr.g.iBa;
    this.BTn = 0;
    this.BTo = 0L;
    this.BTp = 0;
    this.BTq = 0;
    this.BTr = 0;
    this.BTs = 0;
    this.BTt = 0;
    this.BTu = 0;
  }
  
  public final void setExitType(int paramInt)
  {
    AppMethodBeat.i(102546);
    if (this.BTd)
    {
      this.BTd = false;
      this.fHy = paramInt;
      this.networkType = az.iX(ak.getContext());
      report();
      AppMethodBeat.o(102546);
      return;
    }
    reset();
    AppMethodBeat.o(102546);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getHolder", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"})
  static final class b
  {
    private static final c BTx;
    public static final b BTy;
    
    static
    {
      AppMethodBeat.i(102545);
      BTy = new b();
      BTx = new c((byte)0);
      AppMethodBeat.o(102545);
    }
    
    public static c evc()
    {
      return BTx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.c
 * JD-Core Version:    0.7.0.1
 */
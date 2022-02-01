package com.tencent.mm.plugin.transvoice.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "", "()V", "clickChangeLanguageTime", "", "getClickChangeLanguageTime", "()J", "setClickChangeLanguageTime", "(J)V", "defaultLanguageType", "", "getDefaultLanguageType", "()I", "setDefaultLanguageType", "(I)V", "enableReport", "", "getEnableReport", "()Z", "setEnableReport", "(Z)V", "value", "exitType", "getExitType", "setExitType", "isTrans2TxtAvailable", "setTrans2TxtAvailable", "isTransEdited", "setTransEdited", "isTransFinished", "setTransFinished", "isTransGotoEditPanel", "setTransGotoEditPanel", "isTransTimeout", "setTransTimeout", "networkType", "getNetworkType", "setNetworkType", "sendLanguageType", "getSendLanguageType", "setSendLanguageType", "startRecordPressLocX", "getStartRecordPressLocX", "setStartRecordPressLocX", "startRecordPressLocY", "getStartRecordPressLocY", "setStartRecordPressLocY", "startRecordTime", "getStartRecordTime", "setStartRecordTime", "stopRecordPressLocX", "getStopRecordPressLocX", "setStopRecordPressLocX", "stopRecordPressLocY", "getStopRecordPressLocY", "setStopRecordPressLocY", "stopRecordTime", "getStopRecordTime", "setStopRecordTime", "transEndTime", "getTransEndTime", "setTransEndTime", "txtCountFinallySend", "getTxtCountFinallySend", "setTxtCountFinallySend", "txtCountFromServer", "getTxtCountFromServer", "setTxtCountFromServer", "voiceDuration", "getVoiceDuration", "setVoiceDuration", "report", "", "reset", "Companion", "SingletonHolder", "plugin-transvoice_release"})
public final class c
{
  private static final c Akl;
  public static final c.a Akm;
  public boolean AjT;
  public int AjU;
  public int AjV;
  public long AjW;
  public int AjX;
  public int AjY;
  public long AjZ;
  public long Aka;
  public int Akb = g.ieN;
  public int Akc = g.ieN;
  public int Akd;
  public long Ake;
  public int Akf;
  public int Akg;
  public int Akh;
  public int Aki;
  public int Akj;
  public int Akk;
  private int fnm;
  public long mmC;
  private int networkType;
  
  static
  {
    AppMethodBeat.i(102548);
    Akm = new c.a((byte)0);
    b localb = b.Ako;
    Akl = b.efe();
    AppMethodBeat.o(102548);
  }
  
  private void report()
  {
    AppMethodBeat.i(102547);
    h localh = h.wUl;
    long l1 = this.mmC;
    int i = this.AjU;
    int j = this.AjV;
    long l2 = this.AjW;
    int k = this.AjX;
    int m = this.AjY;
    int n = this.fnm;
    int i1 = this.networkType;
    long l3 = this.AjZ;
    long l4 = this.Aka;
    int i2 = this.Akb;
    int i3 = this.Akc;
    int i4 = this.Akd;
    long l5 = this.Ake;
    int i5 = this.Akf;
    int i6 = this.Akg;
    int i7 = this.Akh;
    int i8 = this.Aki;
    int i9 = this.Akj;
    int i10 = this.Akk;
    Object localObject = ai.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    k.g(localObject, "MMApplicationContext.getContext().resources");
    int i11 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = ai.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    k.g(localObject, "MMApplicationContext.getContext().resources");
    localh.f(17164, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l5), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(((Resources)localObject).getDisplayMetrics().heightPixels) });
    reset();
    AppMethodBeat.o(102547);
  }
  
  private void reset()
  {
    this.mmC = 0L;
    this.AjU = 0;
    this.AjV = 0;
    this.AjW = 0L;
    this.AjX = 0;
    this.AjY = 0;
    this.networkType = 0;
    this.AjZ = 0L;
    this.Aka = 0L;
    this.Akb = g.ieN;
    this.Akc = g.ieN;
    this.Akd = 0;
    this.Ake = 0L;
    this.Akf = 0;
    this.Akg = 0;
    this.Akh = 0;
    this.Aki = 0;
    this.Akj = 0;
    this.Akk = 0;
  }
  
  public final void setExitType(int paramInt)
  {
    AppMethodBeat.i(102546);
    if (this.AjT)
    {
      this.AjT = false;
      this.fnm = paramInt;
      this.networkType = ax.iI(ai.getContext());
      report();
      AppMethodBeat.o(102546);
      return;
    }
    reset();
    AppMethodBeat.o(102546);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getHolder", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"})
  static final class b
  {
    private static final c Akn;
    public static final b Ako;
    
    static
    {
      AppMethodBeat.i(102545);
      Ako = new b();
      Akn = new c((byte)0);
      AppMethodBeat.o(102545);
    }
    
    public static c efe()
    {
      return Akn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.c
 * JD-Core Version:    0.7.0.1
 */
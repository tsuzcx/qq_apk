package com.tencent.mm.plugin.transvoice.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.systemservicecache.NetworkCache;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "", "()V", "clickChangeLanguageTime", "", "getClickChangeLanguageTime", "()J", "setClickChangeLanguageTime", "(J)V", "defaultLanguageType", "", "getDefaultLanguageType", "()I", "setDefaultLanguageType", "(I)V", "enableReport", "", "getEnableReport", "()Z", "setEnableReport", "(Z)V", "value", "exitType", "getExitType", "setExitType", "isTrans2TxtAvailable", "setTrans2TxtAvailable", "isTransEdited", "setTransEdited", "isTransFinished", "setTransFinished", "isTransGotoEditPanel", "setTransGotoEditPanel", "isTransTimeout", "setTransTimeout", "networkType", "getNetworkType", "setNetworkType", "sendLanguageType", "getSendLanguageType", "setSendLanguageType", "startRecordPressLocX", "getStartRecordPressLocX", "setStartRecordPressLocX", "startRecordPressLocY", "getStartRecordPressLocY", "setStartRecordPressLocY", "startRecordTime", "getStartRecordTime", "setStartRecordTime", "stopRecordPressLocX", "getStopRecordPressLocX", "setStopRecordPressLocX", "stopRecordPressLocY", "getStopRecordPressLocY", "setStopRecordPressLocY", "stopRecordTime", "getStopRecordTime", "setStopRecordTime", "transEndTime", "getTransEndTime", "setTransEndTime", "txtCountFinallySend", "getTxtCountFinallySend", "setTxtCountFinallySend", "txtCountFromServer", "getTxtCountFromServer", "setTxtCountFromServer", "voiceDuration", "getVoiceDuration", "setVoiceDuration", "report", "", "reset", "Companion", "SingletonHolder", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a TUa;
  private static final c TUt;
  public boolean TUb;
  public int TUc;
  public int TUd;
  public long TUe;
  public int TUf;
  public int TUg;
  public long TUh;
  public long TUi;
  public int TUj = g.pfE;
  public int TUk = g.pfE;
  public int TUl;
  public long TUm;
  public int TUn;
  public int TUo;
  public int TUp;
  public int TUq;
  public int TUr;
  public int TUs;
  private int lsO;
  private int networkType;
  public long uoS;
  
  static
  {
    AppMethodBeat.i(102548);
    TUa = new c.a((byte)0);
    b localb = b.TUu;
    TUt = b.hPE();
    AppMethodBeat.o(102548);
  }
  
  private void report()
  {
    AppMethodBeat.i(102547);
    h.OAn.b(17164, new Object[] { Long.valueOf(this.uoS), Integer.valueOf(this.TUc), Integer.valueOf(this.TUd), Long.valueOf(this.TUe), Integer.valueOf(this.TUf), Integer.valueOf(this.TUg), Integer.valueOf(this.lsO), Integer.valueOf(this.networkType), Long.valueOf(this.TUh), Long.valueOf(this.TUi), Integer.valueOf(this.TUj), Integer.valueOf(this.TUk), Integer.valueOf(this.TUl), Long.valueOf(this.TUm), Integer.valueOf(this.TUn), Integer.valueOf(this.TUo), Integer.valueOf(this.TUp), Integer.valueOf(this.TUq), Integer.valueOf(this.TUr), Integer.valueOf(this.TUs), Integer.valueOf(MMApplicationContext.getContext().getResources().getDisplayMetrics().widthPixels), Integer.valueOf(MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels) });
    reset();
    AppMethodBeat.o(102547);
  }
  
  private void reset()
  {
    this.uoS = 0L;
    this.TUc = 0;
    this.TUd = 0;
    this.TUe = 0L;
    this.TUf = 0;
    this.TUg = 0;
    this.networkType = 0;
    this.TUh = 0L;
    this.TUi = 0L;
    this.TUj = g.pfE;
    this.TUk = g.pfE;
    this.TUl = 0;
    this.TUm = 0L;
    this.TUn = 0;
    this.TUo = 0;
    this.TUp = 0;
    this.TUq = 0;
    this.TUr = 0;
    this.TUs = 0;
  }
  
  public final void setExitType(int paramInt)
  {
    AppMethodBeat.i(102546);
    if (this.TUb)
    {
      this.TUb = false;
      this.lsO = paramInt;
      this.networkType = NetworkCache.INSTANCE.getIOSNetTypeFromCache(MMApplicationContext.getContext());
      report();
      AppMethodBeat.o(102546);
      return;
    }
    reset();
    AppMethodBeat.o(102546);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getHolder", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    public static final b TUu;
    private static final c TUv;
    
    static
    {
      AppMethodBeat.i(102545);
      TUu = new b();
      TUv = new c((byte)0);
      AppMethodBeat.o(102545);
    }
    
    public static c hPE()
    {
      return TUv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.model.c
 * JD-Core Version:    0.7.0.1
 */
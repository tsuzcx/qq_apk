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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "", "()V", "clickChangeLanguageTime", "", "getClickChangeLanguageTime", "()J", "setClickChangeLanguageTime", "(J)V", "defaultLanguageType", "", "getDefaultLanguageType", "()I", "setDefaultLanguageType", "(I)V", "enableReport", "", "getEnableReport", "()Z", "setEnableReport", "(Z)V", "value", "exitType", "getExitType", "setExitType", "isTrans2TxtAvailable", "setTrans2TxtAvailable", "isTransEdited", "setTransEdited", "isTransFinished", "setTransFinished", "isTransGotoEditPanel", "setTransGotoEditPanel", "isTransTimeout", "setTransTimeout", "networkType", "getNetworkType", "setNetworkType", "sendLanguageType", "getSendLanguageType", "setSendLanguageType", "startRecordPressLocX", "getStartRecordPressLocX", "setStartRecordPressLocX", "startRecordPressLocY", "getStartRecordPressLocY", "setStartRecordPressLocY", "startRecordTime", "getStartRecordTime", "setStartRecordTime", "stopRecordPressLocX", "getStopRecordPressLocX", "setStopRecordPressLocX", "stopRecordPressLocY", "getStopRecordPressLocY", "setStopRecordPressLocY", "stopRecordTime", "getStopRecordTime", "setStopRecordTime", "transEndTime", "getTransEndTime", "setTransEndTime", "txtCountFinallySend", "getTxtCountFinallySend", "setTxtCountFinallySend", "txtCountFromServer", "getTxtCountFromServer", "setTxtCountFromServer", "voiceDuration", "getVoiceDuration", "setVoiceDuration", "report", "", "reset", "Companion", "SingletonHolder", "plugin-transvoice_release"})
public final class c
{
  private static final c Nhu;
  public static final a Nhv;
  public boolean Nhc;
  public int Nhd;
  public int Nhe;
  public long Nhf;
  public int Nhg;
  public int Nhh;
  public long Nhi;
  public long Nhj;
  public int Nhk = g.mlS;
  public int Nhl = g.mlS;
  public int Nhm;
  public long Nhn;
  public int Nho;
  public int Nhp;
  public int Nhq;
  public int Nhr;
  public int Nhs;
  public int Nht;
  private int iQS;
  private int networkType;
  public long rgW;
  
  static
  {
    AppMethodBeat.i(102548);
    Nhv = new a((byte)0);
    b localb = b.Nhx;
    Nhu = b.gsw();
    AppMethodBeat.o(102548);
  }
  
  private void report()
  {
    AppMethodBeat.i(102547);
    h localh = h.IzE;
    long l1 = this.rgW;
    int i = this.Nhd;
    int j = this.Nhe;
    long l2 = this.Nhf;
    int k = this.Nhg;
    int m = this.Nhh;
    int n = this.iQS;
    int i1 = this.networkType;
    long l3 = this.Nhi;
    long l4 = this.Nhj;
    int i2 = this.Nhk;
    int i3 = this.Nhl;
    int i4 = this.Nhm;
    long l5 = this.Nhn;
    int i5 = this.Nho;
    int i6 = this.Nhp;
    int i7 = this.Nhq;
    int i8 = this.Nhr;
    int i9 = this.Nhs;
    int i10 = this.Nht;
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "MMApplicationContext.getContext().resources");
    int i11 = ((Resources)localObject).getDisplayMetrics().widthPixels;
    localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources();
    p.j(localObject, "MMApplicationContext.getContext().resources");
    localh.a(17164, new Object[] { Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(l5), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(((Resources)localObject).getDisplayMetrics().heightPixels) });
    reset();
    AppMethodBeat.o(102547);
  }
  
  private void reset()
  {
    this.rgW = 0L;
    this.Nhd = 0;
    this.Nhe = 0;
    this.Nhf = 0L;
    this.Nhg = 0;
    this.Nhh = 0;
    this.networkType = 0;
    this.Nhi = 0L;
    this.Nhj = 0L;
    this.Nhk = g.mlS;
    this.Nhl = g.mlS;
    this.Nhm = 0;
    this.Nhn = 0L;
    this.Nho = 0;
    this.Nhp = 0;
    this.Nhq = 0;
    this.Nhr = 0;
    this.Nhs = 0;
    this.Nht = 0;
  }
  
  public final void setExitType(int paramInt)
  {
    AppMethodBeat.i(102546);
    if (this.Nhc)
    {
      this.Nhc = false;
      this.iQS = paramInt;
      this.networkType = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
      report();
      AppMethodBeat.o(102546);
      return;
    }
    reset();
    AppMethodBeat.o(102546);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$Companion;", "", "()V", "MMNewVoiceInputExitCancel", "", "MMNewVoiceInputExitNormal", "MMNewVoiceInputExitTooShort", "MMNewVoiceInputExitTransNoData", "MMNewVoiceInputExitTransNoNetwork", "MMNewVoiceInputExitTransSend", "MMNewVoiceInputExitTransSendCancel", "MMNewVoiceInputExitTransSendEdited", "MMNewVoiceInputExitTransSendOriVoice", "instance", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getInstance", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "getHolder", "()Lcom/tencent/mm/plugin/transvoice/model/TransVoiceReporter;", "plugin-transvoice_release"})
  static final class b
  {
    private static final c Nhw;
    public static final b Nhx;
    
    static
    {
      AppMethodBeat.i(102545);
      Nhx = new b();
      Nhw = new c((byte)0);
      AppMethodBeat.o(102545);
    }
    
    public static c gsw()
    {
      return Nhw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.a.c
 * JD-Core Version:    0.7.0.1
 */
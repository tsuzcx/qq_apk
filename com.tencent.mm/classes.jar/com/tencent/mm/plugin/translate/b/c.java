package com.tencent.mm.plugin.translate.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qc;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/translate/model/TransInWritingReporter;", "", "()V", "ActionType_Click", "", "ActionType_Exposure", "ButtonType_ResultText", "", "ButtonType_Send", "ButtonType_Switch", "ButtonType_Switch_close", "ButtonType_Switch_en", "ButtonType_Switch_ja", "ButtonType_Switch_ko", "ButtonType_Switch_zhCN", "ButtonType_Switch_zhTW", "ButtonType_Tip", "ButtonType_TransClose", "ButtonType_TransEnable", "ButtonType_UseTrans", "TAG", "TargetLan_en", "TargetLan_ja", "TargetLan_ko", "TargetLan_zhCN", "TargetLan_zhTW", "curSession", "getSession", "refreshSession", "", "reportSendClick", "chatId", "sendLen", "transLen", "targetLan", "reportSwitchClick", "reportSwitchCloseClick", "reportSwitchLanClick", "lan", "reportSwitchLanExpose", "reportTipsExposure", "reportTransCloseClick", "reportTransCloseExposure", "reportTransEnableClick", "reportTransEnableExposure", "reportTransResult", "reportUseTransClick", "typeLen", "reportUseTransExposure", "resetSession", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c TSK;
  private static String TSL;
  
  static
  {
    AppMethodBeat.i(260490);
    TSK = new c();
    TSL = "";
    AppMethodBeat.o(260490);
  }
  
  public static void beH(String paramString)
  {
    AppMethodBeat.i(260432);
    s.u(paramString, "chatId");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 2;
    localqc.xh("1");
    localqc.xi(paramString);
    localqc.bMH();
    AppMethodBeat.o(260432);
  }
  
  public static void beI(String paramString)
  {
    AppMethodBeat.i(260439);
    s.u(paramString, "chatId");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 1;
    localqc.xh("1");
    localqc.xi(paramString);
    localqc.bMH();
    AppMethodBeat.o(260439);
  }
  
  public static void beJ(String paramString)
  {
    AppMethodBeat.i(260445);
    s.u(paramString, "chatId");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 2;
    localqc.xh("2");
    localqc.xi(paramString);
    localqc.bMH();
    AppMethodBeat.o(260445);
  }
  
  public static void beK(String paramString)
  {
    AppMethodBeat.i(260450);
    s.u(paramString, "chatId");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 1;
    localqc.xh("2");
    localqc.xi(paramString);
    localqc.bMH();
    AppMethodBeat.o(260450);
  }
  
  public static void beL(String paramString)
  {
    AppMethodBeat.i(260459);
    s.u(paramString, "chatId");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 1;
    localqc.xh("3");
    localqc.xi(paramString);
    localqc.bMH();
    AppMethodBeat.o(260459);
  }
  
  public static void beM(String paramString)
  {
    AppMethodBeat.i(260466);
    s.u(paramString, "chatId");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 2;
    localqc.xh("4");
    localqc.xi(paramString);
    localqc.bMH();
    AppMethodBeat.o(260466);
  }
  
  public static void beN(String paramString)
  {
    AppMethodBeat.i(260474);
    s.u(paramString, "chatId");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 2;
    localqc.xh("100");
    localqc.xi(paramString);
    localqc.bMH();
    AppMethodBeat.o(260474);
  }
  
  public static void beO(String paramString)
  {
    AppMethodBeat.i(260476);
    s.u(paramString, "chatId");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 2;
    localqc.xh("5");
    localqc.xi(paramString);
    localqc.bMH();
    AppMethodBeat.o(260476);
  }
  
  public static void beP(String paramString)
  {
    AppMethodBeat.i(260483);
    s.u(paramString, "chatId");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 1;
    localqc.xh("6");
    localqc.xi(paramString);
    localqc.bMH();
    AppMethodBeat.o(260483);
  }
  
  public static void hPs()
  {
    AppMethodBeat.i(260421);
    String str = UUID.randomUUID().toString();
    s.s(str, "randomUUID().toString()");
    TSL = str;
    AppMethodBeat.o(260421);
  }
  
  private static String hPt()
  {
    AppMethodBeat.i(260424);
    if (((CharSequence)TSL).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        hPs();
      }
      String str = TSL;
      AppMethodBeat.o(260424);
      return str;
    }
  }
  
  public static void np(String paramString1, String paramString2)
  {
    AppMethodBeat.i(260471);
    s.u(paramString1, "chatId");
    s.u(paramString2, "lan");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 2;
    localqc.xh(paramString2);
    localqc.xi(paramString1);
    localqc.bMH();
    AppMethodBeat.o(260471);
  }
  
  public static void o(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(260479);
    s.u(paramString1, "chatId");
    s.u(paramString2, "targetLan");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 2;
    localqc.xh("6");
    localqc.jqf = paramInt1;
    localqc.jqg = paramInt2;
    localqc.xj(paramString2);
    localqc.xi(paramString1);
    localqc.bMH();
    AppMethodBeat.o(260479);
  }
  
  public static void p(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(260488);
    s.u(paramString1, "chatId");
    s.u(paramString2, "targetLan");
    qc localqc = new qc();
    localqc.xg(hPt());
    localqc.ipH = 2;
    localqc.xh("7");
    localqc.jqg = paramInt2;
    localqc.jqh = paramInt1;
    localqc.xj(paramString2);
    localqc.xi(paramString1);
    localqc.bMH();
    AppMethodBeat.o(260488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.b.c
 * JD-Core Version:    0.7.0.1
 */
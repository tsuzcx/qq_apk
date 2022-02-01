package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.protocal.protobuf.flq;
import com.tencent.mm.protocal.protobuf.fvd;
import com.tencent.mm.protocal.protobuf.ghx;
import com.tencent.mm.protocal.protobuf.gic;
import com.tencent.mm.protocal.protobuf.gmm;
import com.tencent.mm.ui.aw;
import java.util.LinkedList;

public final class w
{
  public Bundle OMx;
  public int Wob;
  public LinkedList<fvd> Woc;
  public String Wod;
  public String Woe;
  public int Wof;
  public LinkedList<String> Wog;
  public int Woh;
  public int Woi;
  public String Woj;
  public flq Wok;
  public LinkedList<aem> Wol;
  public LinkedList<duw> Wom;
  public int Won;
  public gmm Woo;
  public ghx Wop;
  public String Woq;
  public String Wor;
  public boolean Wos;
  public String Wot;
  public int Wou;
  public boolean Wov;
  public String Wow;
  public boolean Wox;
  public String Woy;
  public int Woz;
  public int businessType;
  public int channelId;
  public String content;
  public String hAB;
  public String hAT;
  public String hOG;
  public int hVk;
  public String hVn;
  public int hVr;
  public String language;
  public int offset;
  public int scene;
  public String sessionId;
  public int subtype;
  public String xVe;
  
  public w()
  {
    AppMethodBeat.i(117623);
    this.Woc = new LinkedList();
    this.Wog = new LinkedList();
    this.Wol = new LinkedList();
    this.Wom = new LinkedList();
    this.hAT = "";
    this.content = "";
    this.Wov = false;
    this.Wow = "";
    this.Wox = true;
    AppMethodBeat.o(117623);
  }
  
  public final void a(gic paramgic, int paramInt)
  {
    AppMethodBeat.i(369997);
    paramgic.aakp = this.hAB;
    paramgic.abuB = this.Wob;
    paramgic.YYo = this.businessType;
    paramgic.aaLr = aj.dch();
    paramgic.YYs = this.offset;
    paramgic.acet = aj.asY(paramInt);
    paramgic.abyc = this.Woc;
    paramgic.IJG = this.scene;
    paramgic.YYr = this.xVe;
    paramgic.abuF = this.hVr;
    paramgic.aceu = this.Wod;
    paramgic.acew = this.Wof;
    paramgic.acev = this.Woe;
    paramgic.acex = this.Wog;
    paramgic.accs = this.Wol;
    paramgic.Wok = this.Wok;
    paramgic.acey = this.Wom;
    paramgic.yts = this.language;
    paramgic.acee = this.sessionId;
    if (aw.isDarkMode()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramgic.abgz = paramInt;
      paramgic.aaLs = aj.iqa();
      AppMethodBeat.o(369997);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.w
 * JD-Core Version:    0.7.0.1
 */
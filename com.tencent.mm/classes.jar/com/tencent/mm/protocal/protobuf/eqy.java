package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class eqy
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public String IJC;
  public int IJG;
  public String SessionId;
  public String YNd;
  public String YWK;
  public long YYo;
  public int Zlk;
  public int aaGE;
  public int aaMX;
  public int aayc;
  public String aaye;
  public String aayf;
  public String abgw;
  public long abmO;
  public int abuA;
  public int abuB;
  public String abuC;
  public String abuD;
  public String abuE;
  public int abuF;
  public int abuG;
  public int abuH;
  public int abuI;
  public String abuJ;
  public String abuK;
  public int abuL;
  public String abuM;
  public int abuN;
  public int abuO;
  public String abuP;
  public int abuQ;
  public String abuR;
  public String abuS;
  public String abuT;
  public String abuy;
  public int abuz;
  public String hAP;
  public String vYk;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258806);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchId", this.aayf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RecommendId", this.abuy, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessType", Long.valueOf(this.YYo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DocId", this.abgw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DocPos", Integer.valueOf(this.abuz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TypePos", Integer.valueOf(this.abuA), false);
      com.tencent.mm.bk.a.a(localJSONObject, "IsHomePage", Integer.valueOf(this.abuB), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Timestamp", Long.valueOf(this.abmO), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Expand1", Integer.valueOf(this.aaGE), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SuggestionId", this.abuC, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ClickType", Integer.valueOf(this.Zlk), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Expand2", this.abuD, false);
      com.tencent.mm.bk.a.a(localJSONObject, "LogString", this.abuE, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ClickSource", Integer.valueOf(this.aaMX), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SceneActionType", Integer.valueOf(this.abuF), false);
      com.tencent.mm.bk.a.a(localJSONObject, "H5Version", Integer.valueOf(this.aayc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Query", this.YWK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ResultType", Integer.valueOf(this.abuG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeAppH5Version", Integer.valueOf(this.abuH), false);
      com.tencent.mm.bk.a.a(localJSONObject, "JumpUrl", this.IGI, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SessionId", this.SessionId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ItemType", Integer.valueOf(this.abuI), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Expand", this.abuJ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BizName", this.YNd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ClickZone", this.abuK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NetType", this.vYk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestId", this.aaye, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Channelid", Integer.valueOf(this.abuL), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ClickContent", this.abuM, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ReqSubType", Integer.valueOf(this.abuN), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ResultSubType", Integer.valueOf(this.abuO), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ParentSearchId", this.abuP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ReqBusinessType", Integer.valueOf(this.abuQ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "BoxId", this.abuR, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CdnHttpHead", this.abuS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "VideoUrl", this.IJC, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ByPass", this.abuT, false);
      label496:
      AppMethodBeat.o(258806);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label496;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117900);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IJG);
      if (this.aayf != null) {
        paramVarArgs.g(2, this.aayf);
      }
      if (this.abuy != null) {
        paramVarArgs.g(3, this.abuy);
      }
      paramVarArgs.bv(4, this.YYo);
      if (this.abgw != null) {
        paramVarArgs.g(5, this.abgw);
      }
      paramVarArgs.bS(6, this.abuz);
      paramVarArgs.bS(7, this.abuA);
      paramVarArgs.bS(8, this.abuB);
      paramVarArgs.bv(9, this.abmO);
      paramVarArgs.bS(10, this.aaGE);
      if (this.abuC != null) {
        paramVarArgs.g(11, this.abuC);
      }
      paramVarArgs.bS(12, this.Zlk);
      if (this.abuD != null) {
        paramVarArgs.g(13, this.abuD);
      }
      if (this.abuE != null) {
        paramVarArgs.g(14, this.abuE);
      }
      paramVarArgs.bS(15, this.aaMX);
      paramVarArgs.bS(16, this.abuF);
      paramVarArgs.bS(17, this.aayc);
      if (this.YWK != null) {
        paramVarArgs.g(18, this.YWK);
      }
      paramVarArgs.bS(19, this.abuG);
      paramVarArgs.bS(20, this.abuH);
      if (this.IGI != null) {
        paramVarArgs.g(21, this.IGI);
      }
      if (this.SessionId != null) {
        paramVarArgs.g(22, this.SessionId);
      }
      paramVarArgs.bS(23, this.abuI);
      if (this.abuJ != null) {
        paramVarArgs.g(24, this.abuJ);
      }
      if (this.hAP != null) {
        paramVarArgs.g(25, this.hAP);
      }
      if (this.YNd != null) {
        paramVarArgs.g(26, this.YNd);
      }
      if (this.abuK != null) {
        paramVarArgs.g(27, this.abuK);
      }
      if (this.vYk != null) {
        paramVarArgs.g(28, this.vYk);
      }
      if (this.aaye != null) {
        paramVarArgs.g(29, this.aaye);
      }
      paramVarArgs.bS(30, this.abuL);
      if (this.abuM != null) {
        paramVarArgs.g(31, this.abuM);
      }
      paramVarArgs.bS(32, this.abuN);
      paramVarArgs.bS(33, this.abuO);
      if (this.abuP != null) {
        paramVarArgs.g(34, this.abuP);
      }
      paramVarArgs.bS(35, this.abuQ);
      if (this.abuR != null) {
        paramVarArgs.g(36, this.abuR);
      }
      if (this.abuS != null) {
        paramVarArgs.g(37, this.abuS);
      }
      if (this.IJC != null) {
        paramVarArgs.g(38, this.IJC);
      }
      if (this.abuT != null) {
        paramVarArgs.g(39, this.abuT);
      }
      AppMethodBeat.o(117900);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IJG) + 0;
      paramInt = i;
      if (this.aayf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aayf);
      }
      i = paramInt;
      if (this.abuy != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abuy);
      }
      i += i.a.a.b.b.a.q(4, this.YYo);
      paramInt = i;
      if (this.abgw != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abgw);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.abuz) + i.a.a.b.b.a.cJ(7, this.abuA) + i.a.a.b.b.a.cJ(8, this.abuB) + i.a.a.b.b.a.q(9, this.abmO) + i.a.a.b.b.a.cJ(10, this.aaGE);
      paramInt = i;
      if (this.abuC != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.abuC);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.Zlk);
      paramInt = i;
      if (this.abuD != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.abuD);
      }
      i = paramInt;
      if (this.abuE != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.abuE);
      }
      i = i + i.a.a.b.b.a.cJ(15, this.aaMX) + i.a.a.b.b.a.cJ(16, this.abuF) + i.a.a.b.b.a.cJ(17, this.aayc);
      paramInt = i;
      if (this.YWK != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.YWK);
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.abuG) + i.a.a.b.b.a.cJ(20, this.abuH);
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.IGI);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.SessionId);
      }
      i += i.a.a.b.b.a.cJ(23, this.abuI);
      paramInt = i;
      if (this.abuJ != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.abuJ);
      }
      i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(25, this.hAP);
      }
      paramInt = i;
      if (this.YNd != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.YNd);
      }
      i = paramInt;
      if (this.abuK != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.abuK);
      }
      paramInt = i;
      if (this.vYk != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.vYk);
      }
      i = paramInt;
      if (this.aaye != null) {
        i = paramInt + i.a.a.b.b.a.h(29, this.aaye);
      }
      i += i.a.a.b.b.a.cJ(30, this.abuL);
      paramInt = i;
      if (this.abuM != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.abuM);
      }
      i = paramInt + i.a.a.b.b.a.cJ(32, this.abuN) + i.a.a.b.b.a.cJ(33, this.abuO);
      paramInt = i;
      if (this.abuP != null) {
        paramInt = i + i.a.a.b.b.a.h(34, this.abuP);
      }
      i = paramInt + i.a.a.b.b.a.cJ(35, this.abuQ);
      paramInt = i;
      if (this.abuR != null) {
        paramInt = i + i.a.a.b.b.a.h(36, this.abuR);
      }
      i = paramInt;
      if (this.abuS != null) {
        i = paramInt + i.a.a.b.b.a.h(37, this.abuS);
      }
      paramInt = i;
      if (this.IJC != null) {
        paramInt = i + i.a.a.b.b.a.h(38, this.IJC);
      }
      i = paramInt;
      if (this.abuT != null) {
        i = paramInt + i.a.a.b.b.a.h(39, this.abuT);
      }
      AppMethodBeat.o(117900);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117900);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eqy localeqy = (eqy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117900);
        return -1;
      case 1: 
        localeqy.IJG = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 2: 
        localeqy.aayf = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 3: 
        localeqy.abuy = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 4: 
        localeqy.YYo = locala.ajGk.aaw();
        AppMethodBeat.o(117900);
        return 0;
      case 5: 
        localeqy.abgw = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 6: 
        localeqy.abuz = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 7: 
        localeqy.abuA = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 8: 
        localeqy.abuB = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 9: 
        localeqy.abmO = locala.ajGk.aaw();
        AppMethodBeat.o(117900);
        return 0;
      case 10: 
        localeqy.aaGE = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 11: 
        localeqy.abuC = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 12: 
        localeqy.Zlk = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 13: 
        localeqy.abuD = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 14: 
        localeqy.abuE = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 15: 
        localeqy.aaMX = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 16: 
        localeqy.abuF = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 17: 
        localeqy.aayc = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 18: 
        localeqy.YWK = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 19: 
        localeqy.abuG = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 20: 
        localeqy.abuH = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 21: 
        localeqy.IGI = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 22: 
        localeqy.SessionId = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 23: 
        localeqy.abuI = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 24: 
        localeqy.abuJ = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 25: 
        localeqy.hAP = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 26: 
        localeqy.YNd = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 27: 
        localeqy.abuK = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 28: 
        localeqy.vYk = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 29: 
        localeqy.aaye = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 30: 
        localeqy.abuL = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 31: 
        localeqy.abuM = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 32: 
        localeqy.abuN = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 33: 
        localeqy.abuO = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 34: 
        localeqy.abuP = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 35: 
        localeqy.abuQ = locala.ajGk.aar();
        AppMethodBeat.o(117900);
        return 0;
      case 36: 
        localeqy.abuR = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 37: 
        localeqy.abuS = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      case 38: 
        localeqy.IJC = locala.ajGk.readString();
        AppMethodBeat.o(117900);
        return 0;
      }
      localeqy.abuT = locala.ajGk.readString();
      AppMethodBeat.o(117900);
      return 0;
    }
    AppMethodBeat.o(117900);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqy
 * JD-Core Version:    0.7.0.1
 */
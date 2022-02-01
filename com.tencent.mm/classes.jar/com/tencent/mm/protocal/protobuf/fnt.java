package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fnt
  extends com.tencent.mm.bx.a
{
  public int GRg;
  public String GtP;
  public int TJd;
  public LinkedList<aem> Wol;
  public String Wot;
  public LinkedList<fod> abNF;
  public String abNG;
  public LinkedList<String> abNH;
  public bzk abNI;
  public String abNJ;
  public String abNK;
  public boolean abNL;
  public int channelId;
  public String hAB;
  public String hOG;
  public String hVn;
  public String mpa;
  public int offset;
  public int scene;
  public String sessionId;
  public int tBy;
  public String tgw;
  public String url;
  public String zIO;
  
  public fnt()
  {
    AppMethodBeat.i(152996);
    this.Wol = new LinkedList();
    this.abNF = new LinkedList();
    this.abNH = new LinkedList();
    AppMethodBeat.o(152996);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258430);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "searchId", this.mpa, false);
      com.tencent.mm.bk.a.a(localJSONObject, "sessionId", this.sessionId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "subSessionId", this.hVn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "offset", Integer.valueOf(this.offset), false);
      com.tencent.mm.bk.a.a(localJSONObject, "keyword", this.hAB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "scene", Integer.valueOf(this.scene), false);
      com.tencent.mm.bk.a.a(localJSONObject, "url", this.url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "requestId", this.hOG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "extReqParams", this.Wol, false);
      com.tencent.mm.bk.a.a(localJSONObject, "contextId", this.zIO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "stageList", this.abNF, false);
      com.tencent.mm.bk.a.a(localJSONObject, "firstLoadWebView", Integer.valueOf(this.TJd), false);
      com.tencent.mm.bk.a.a(localJSONObject, "channelId", Integer.valueOf(this.channelId), false);
      com.tencent.mm.bk.a.a(localJSONObject, "navigationId", this.Wot, false);
      com.tencent.mm.bk.a.a(localJSONObject, "pageId", Integer.valueOf(this.tBy), false);
      com.tencent.mm.bk.a.a(localJSONObject, "pageTitle", this.tgw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "netType", this.GtP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "webviewType", this.abNG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "checkDocidList", this.abNH, false);
      com.tencent.mm.bk.a.a(localJSONObject, "actionBarColor", Integer.valueOf(this.GRg), false);
      com.tencent.mm.bk.a.a(localJSONObject, "floatingWindow", this.abNI, false);
      com.tencent.mm.bk.a.a(localJSONObject, "homeMsgId", this.abNJ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "redPointMsgId", this.abNK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "directRequest", Boolean.valueOf(this.abNL), false);
      label298:
      AppMethodBeat.o(258430);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label298;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152997);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.mpa != null) {
        paramVarArgs.g(1, this.mpa);
      }
      if (this.sessionId != null) {
        paramVarArgs.g(2, this.sessionId);
      }
      if (this.hVn != null) {
        paramVarArgs.g(3, this.hVn);
      }
      paramVarArgs.bS(4, this.offset);
      if (this.hAB != null) {
        paramVarArgs.g(5, this.hAB);
      }
      paramVarArgs.bS(6, this.scene);
      if (this.url != null) {
        paramVarArgs.g(7, this.url);
      }
      if (this.hOG != null) {
        paramVarArgs.g(8, this.hOG);
      }
      paramVarArgs.e(9, 8, this.Wol);
      if (this.zIO != null) {
        paramVarArgs.g(10, this.zIO);
      }
      paramVarArgs.e(11, 8, this.abNF);
      paramVarArgs.bS(12, this.TJd);
      paramVarArgs.bS(13, this.channelId);
      if (this.Wot != null) {
        paramVarArgs.g(14, this.Wot);
      }
      paramVarArgs.bS(15, this.tBy);
      if (this.tgw != null) {
        paramVarArgs.g(16, this.tgw);
      }
      if (this.GtP != null) {
        paramVarArgs.g(17, this.GtP);
      }
      if (this.abNG != null) {
        paramVarArgs.g(18, this.abNG);
      }
      paramVarArgs.e(19, 1, this.abNH);
      paramVarArgs.bS(20, this.GRg);
      if (this.abNI != null)
      {
        paramVarArgs.qD(21, this.abNI.computeSize());
        this.abNI.writeFields(paramVarArgs);
      }
      if (this.abNJ != null) {
        paramVarArgs.g(22, this.abNJ);
      }
      if (this.abNK != null) {
        paramVarArgs.g(23, this.abNK);
      }
      paramVarArgs.di(24, this.abNL);
      AppMethodBeat.o(152997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mpa == null) {
        break label1696;
      }
    }
    label1696:
    for (int i = i.a.a.b.b.a.h(1, this.mpa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.sessionId);
      }
      i = paramInt;
      if (this.hVn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hVn);
      }
      i += i.a.a.b.b.a.cJ(4, this.offset);
      paramInt = i;
      if (this.hAB != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hAB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.url);
      }
      i = paramInt;
      if (this.hOG != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.hOG);
      }
      i += i.a.a.a.c(9, 8, this.Wol);
      paramInt = i;
      if (this.zIO != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.zIO);
      }
      i = paramInt + i.a.a.a.c(11, 8, this.abNF) + i.a.a.b.b.a.cJ(12, this.TJd) + i.a.a.b.b.a.cJ(13, this.channelId);
      paramInt = i;
      if (this.Wot != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.Wot);
      }
      i = paramInt + i.a.a.b.b.a.cJ(15, this.tBy);
      paramInt = i;
      if (this.tgw != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.tgw);
      }
      i = paramInt;
      if (this.GtP != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.GtP);
      }
      paramInt = i;
      if (this.abNG != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.abNG);
      }
      i = paramInt + i.a.a.a.c(19, 1, this.abNH) + i.a.a.b.b.a.cJ(20, this.GRg);
      paramInt = i;
      if (this.abNI != null) {
        paramInt = i + i.a.a.a.qC(21, this.abNI.computeSize());
      }
      i = paramInt;
      if (this.abNJ != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.abNJ);
      }
      paramInt = i;
      if (this.abNK != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.abNK);
      }
      i = i.a.a.b.b.a.ko(24);
      AppMethodBeat.o(152997);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Wol.clear();
        this.abNF.clear();
        this.abNH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fnt localfnt = (fnt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152997);
          return -1;
        case 1: 
          localfnt.mpa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 2: 
          localfnt.sessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 3: 
          localfnt.hVn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 4: 
          localfnt.offset = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152997);
          return 0;
        case 5: 
          localfnt.hAB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 6: 
          localfnt.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152997);
          return 0;
        case 7: 
          localfnt.url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 8: 
          localfnt.hOG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aem();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aem)localObject2).parseFrom((byte[])localObject1);
            }
            localfnt.Wol.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 10: 
          localfnt.zIO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fod();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fod)localObject2).parseFrom((byte[])localObject1);
            }
            localfnt.abNF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 12: 
          localfnt.TJd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152997);
          return 0;
        case 13: 
          localfnt.channelId = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152997);
          return 0;
        case 14: 
          localfnt.Wot = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 15: 
          localfnt.tBy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152997);
          return 0;
        case 16: 
          localfnt.tgw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 17: 
          localfnt.GtP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 18: 
          localfnt.abNG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 19: 
          localfnt.abNH.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(152997);
          return 0;
        case 20: 
          localfnt.GRg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152997);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzk)localObject2).parseFrom((byte[])localObject1);
            }
            localfnt.abNI = ((bzk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 22: 
          localfnt.abNJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 23: 
          localfnt.abNK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152997);
          return 0;
        }
        localfnt.abNL = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(152997);
        return 0;
      }
      AppMethodBeat.o(152997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnt
 * JD-Core Version:    0.7.0.1
 */
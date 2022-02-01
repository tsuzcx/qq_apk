package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class gic
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public flq Wok;
  public long YYo;
  public String YYr;
  public int YYs;
  public dhb aaLr;
  public acm aaLs;
  public String aakp;
  public int abgz;
  public int abuB;
  public int abuF;
  public LinkedList<fvd> abyc;
  public LinkedList<aem> accs;
  public com.tencent.mm.bx.b aceA;
  public fdy aceB;
  public ahq aceC;
  public eej aceD;
  public fln aceE;
  public int aced;
  public String acee;
  public int acet;
  public String aceu;
  public String acev;
  public int acew;
  public LinkedList<String> acex;
  public LinkedList<duw> acey;
  public com.tencent.mm.bx.b acez;
  public String yts;
  
  public gic()
  {
    AppMethodBeat.i(117954);
    this.abyc = new LinkedList();
    this.acex = new LinkedList();
    this.aced = 2;
    this.accs = new LinkedList();
    this.acey = new LinkedList();
    AppMethodBeat.o(117954);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258631);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "IsHomePage", Integer.valueOf(this.abuB), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Keyword", this.aakp, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Offset", Integer.valueOf(this.YYs), false);
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessType", Long.valueOf(this.YYo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "CliVersion", Integer.valueOf(this.acet), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Location", this.aaLr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MatchUserList", this.abyc, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchID", this.YYr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SceneActionType", Integer.valueOf(this.abuF), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SugID", this.aceu, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PrefixSug", this.acev, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SugType", Integer.valueOf(this.acew), false);
      com.tencent.mm.bk.a.a(localJSONObject, "PrefixQuery", this.acex, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DisplayPattern", Integer.valueOf(this.aced), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TagInfo", this.Wok, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtReqParams", this.accs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NumConditions", this.acey, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Language", this.yts, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeAppCtrlInfo", this.acez, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SessionID", this.acee, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BoxCtrlInfo", this.aceA, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SnsInfo", this.aceB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DebugCtrlInfo", this.aceC, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PoiInfo", this.aceD, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DarkMode", Integer.valueOf(this.abgz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ChildMode", this.aaLs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TagExtInfo", this.aceE, false);
      label348:
      AppMethodBeat.o(258631);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label348;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117955);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aakp == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.abuB);
      if (this.aakp != null) {
        paramVarArgs.g(2, this.aakp);
      }
      paramVarArgs.bS(3, this.YYs);
      paramVarArgs.bv(4, this.YYo);
      paramVarArgs.bS(5, this.acet);
      if (this.aaLr != null)
      {
        paramVarArgs.qD(6, this.aaLr.computeSize());
        this.aaLr.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.abyc);
      paramVarArgs.bS(8, this.IJG);
      if (this.YYr != null) {
        paramVarArgs.g(9, this.YYr);
      }
      paramVarArgs.bS(10, this.abuF);
      if (this.aceu != null) {
        paramVarArgs.g(11, this.aceu);
      }
      if (this.acev != null) {
        paramVarArgs.g(12, this.acev);
      }
      paramVarArgs.bS(13, this.acew);
      paramVarArgs.e(14, 1, this.acex);
      paramVarArgs.bS(15, this.aced);
      if (this.Wok != null)
      {
        paramVarArgs.qD(16, this.Wok.computeSize());
        this.Wok.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.accs);
      paramVarArgs.e(18, 8, this.acey);
      if (this.yts != null) {
        paramVarArgs.g(19, this.yts);
      }
      if (this.acez != null) {
        paramVarArgs.d(20, this.acez);
      }
      if (this.acee != null) {
        paramVarArgs.g(21, this.acee);
      }
      if (this.aceA != null) {
        paramVarArgs.d(22, this.aceA);
      }
      if (this.aceB != null)
      {
        paramVarArgs.qD(23, this.aceB.computeSize());
        this.aceB.writeFields(paramVarArgs);
      }
      if (this.aceC != null)
      {
        paramVarArgs.qD(24, this.aceC.computeSize());
        this.aceC.writeFields(paramVarArgs);
      }
      if (this.aceD != null)
      {
        paramVarArgs.qD(25, this.aceD.computeSize());
        this.aceD.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(26, this.abgz);
      if (this.aaLs != null)
      {
        paramVarArgs.qD(27, this.aaLs.computeSize());
        this.aaLs.writeFields(paramVarArgs);
      }
      if (this.aceE != null)
      {
        paramVarArgs.qD(28, this.aceE.computeSize());
        this.aceE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abuB) + 0;
      paramInt = i;
      if (this.aakp != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aakp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.YYs) + i.a.a.b.b.a.q(4, this.YYo) + i.a.a.b.b.a.cJ(5, this.acet);
      paramInt = i;
      if (this.aaLr != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaLr.computeSize());
      }
      i = paramInt + i.a.a.a.c(7, 8, this.abyc) + i.a.a.b.b.a.cJ(8, this.IJG);
      paramInt = i;
      if (this.YYr != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YYr);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.abuF);
      paramInt = i;
      if (this.aceu != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aceu);
      }
      i = paramInt;
      if (this.acev != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.acev);
      }
      i = i + i.a.a.b.b.a.cJ(13, this.acew) + i.a.a.a.c(14, 1, this.acex) + i.a.a.b.b.a.cJ(15, this.aced);
      paramInt = i;
      if (this.Wok != null) {
        paramInt = i + i.a.a.a.qC(16, this.Wok.computeSize());
      }
      i = paramInt + i.a.a.a.c(17, 8, this.accs) + i.a.a.a.c(18, 8, this.acey);
      paramInt = i;
      if (this.yts != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.yts);
      }
      i = paramInt;
      if (this.acez != null) {
        i = paramInt + i.a.a.b.b.a.c(20, this.acez);
      }
      paramInt = i;
      if (this.acee != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.acee);
      }
      i = paramInt;
      if (this.aceA != null) {
        i = paramInt + i.a.a.b.b.a.c(22, this.aceA);
      }
      paramInt = i;
      if (this.aceB != null) {
        paramInt = i + i.a.a.a.qC(23, this.aceB.computeSize());
      }
      i = paramInt;
      if (this.aceC != null) {
        i = paramInt + i.a.a.a.qC(24, this.aceC.computeSize());
      }
      paramInt = i;
      if (this.aceD != null) {
        paramInt = i + i.a.a.a.qC(25, this.aceD.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(26, this.abgz);
      paramInt = i;
      if (this.aaLs != null) {
        paramInt = i + i.a.a.a.qC(27, this.aaLs.computeSize());
      }
      i = paramInt;
      if (this.aceE != null) {
        i = paramInt + i.a.a.a.qC(28, this.aceE.computeSize());
      }
      AppMethodBeat.o(117955);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abyc.clear();
      this.acex.clear();
      this.accs.clear();
      this.acey.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.aakp == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      gic localgic = (gic)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117955);
        return -1;
      case 1: 
        localgic.abuB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117955);
        return 0;
      case 2: 
        localgic.aakp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 3: 
        localgic.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117955);
        return 0;
      case 4: 
        localgic.YYo = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(117955);
        return 0;
      case 5: 
        localgic.acet = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117955);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhb)localObject2).parseFrom((byte[])localObject1);
          }
          localgic.aaLr = ((dhb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fvd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fvd)localObject2).parseFrom((byte[])localObject1);
          }
          localgic.abyc.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 8: 
        localgic.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117955);
        return 0;
      case 9: 
        localgic.YYr = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 10: 
        localgic.abuF = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117955);
        return 0;
      case 11: 
        localgic.aceu = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 12: 
        localgic.acev = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 13: 
        localgic.acew = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117955);
        return 0;
      case 14: 
        localgic.acex.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(117955);
        return 0;
      case 15: 
        localgic.aced = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117955);
        return 0;
      case 16: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new flq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((flq)localObject2).parseFrom((byte[])localObject1);
          }
          localgic.Wok = ((flq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 17: 
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
          localgic.accs.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 18: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new duw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((duw)localObject2).parseFrom((byte[])localObject1);
          }
          localgic.acey.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 19: 
        localgic.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 20: 
        localgic.acez = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(117955);
        return 0;
      case 21: 
        localgic.acee = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 22: 
        localgic.aceA = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(117955);
        return 0;
      case 23: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fdy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fdy)localObject2).parseFrom((byte[])localObject1);
          }
          localgic.aceB = ((fdy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 24: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ahq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ahq)localObject2).parseFrom((byte[])localObject1);
          }
          localgic.aceC = ((ahq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 25: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eej();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eej)localObject2).parseFrom((byte[])localObject1);
          }
          localgic.aceD = ((eej)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 26: 
        localgic.abgz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117955);
        return 0;
      case 27: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acm)localObject2).parseFrom((byte[])localObject1);
          }
          localgic.aaLs = ((acm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fln();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fln)localObject2).parseFrom((byte[])localObject1);
        }
        localgic.aceE = ((fln)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    AppMethodBeat.o(117955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gic
 * JD-Core Version:    0.7.0.1
 */
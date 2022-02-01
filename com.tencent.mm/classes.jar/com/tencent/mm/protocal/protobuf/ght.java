package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ght
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String YYr;
  public int YYs;
  public dhb aaLr;
  public String aakp;
  public int aayc;
  public int abMl;
  public String abgx;
  public String abqY;
  public int abuB;
  public int abuF;
  public LinkedList<aem> accs;
  public int aced;
  public String acee;
  public String acef;
  public LinkedList<String> aceg;
  public int aceh;
  public int acei;
  public bzk acej;
  public int vhJ;
  
  public ght()
  {
    AppMethodBeat.i(117947);
    this.aced = 2;
    this.accs = new LinkedList();
    this.aceg = new LinkedList();
    AppMethodBeat.o(117947);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258831);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Offset", Integer.valueOf(this.YYs), false);
      com.tencent.mm.bk.a.a(localJSONObject, "H5Version", Integer.valueOf(this.aayc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "IsHomePage", Integer.valueOf(this.abuB), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Keyword", this.aakp, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Location", this.aaLr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchID", this.YYr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SceneActionType", Integer.valueOf(this.abuF), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DisplayPattern", Integer.valueOf(this.aced), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtReqParams", this.accs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SessionID", this.acee, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Source", this.abgx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ChannelId", Integer.valueOf(this.abMl), false);
      com.tencent.mm.bk.a.a(localJSONObject, "NavigationId", this.acef, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RedPointMsgId", this.abqY, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CheckDocidList", this.aceg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Pos", Integer.valueOf(this.aceh), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Type", Integer.valueOf(this.vhJ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "FromPreTabChannelId", Integer.valueOf(this.acei), false);
      com.tencent.mm.bk.a.a(localJSONObject, "FloatingWindow", this.acej, false);
      label263:
      AppMethodBeat.o(258831);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label263;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117948);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YYs);
      paramVarArgs.bS(2, this.aayc);
      paramVarArgs.bS(3, this.abuB);
      if (this.aakp != null) {
        paramVarArgs.g(4, this.aakp);
      }
      if (this.aaLr != null)
      {
        paramVarArgs.qD(5, this.aaLr.computeSize());
        this.aaLr.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.IJG);
      if (this.YYr != null) {
        paramVarArgs.g(7, this.YYr);
      }
      paramVarArgs.bS(8, this.abuF);
      paramVarArgs.bS(9, this.aced);
      paramVarArgs.e(10, 8, this.accs);
      if (this.acee != null) {
        paramVarArgs.g(11, this.acee);
      }
      if (this.abgx != null) {
        paramVarArgs.g(12, this.abgx);
      }
      paramVarArgs.bS(13, this.abMl);
      if (this.acef != null) {
        paramVarArgs.g(14, this.acef);
      }
      if (this.abqY != null) {
        paramVarArgs.g(15, this.abqY);
      }
      paramVarArgs.e(16, 1, this.aceg);
      paramVarArgs.bS(17, this.aceh);
      paramVarArgs.bS(18, this.vhJ);
      paramVarArgs.bS(19, this.acei);
      if (this.acej != null)
      {
        paramVarArgs.qD(20, this.acej.computeSize());
        this.acej.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YYs) + 0 + i.a.a.b.b.a.cJ(2, this.aayc) + i.a.a.b.b.a.cJ(3, this.abuB);
      paramInt = i;
      if (this.aakp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aakp);
      }
      i = paramInt;
      if (this.aaLr != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaLr.computeSize());
      }
      i += i.a.a.b.b.a.cJ(6, this.IJG);
      paramInt = i;
      if (this.YYr != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YYr);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.abuF) + i.a.a.b.b.a.cJ(9, this.aced) + i.a.a.a.c(10, 8, this.accs);
      paramInt = i;
      if (this.acee != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.acee);
      }
      i = paramInt;
      if (this.abgx != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.abgx);
      }
      i += i.a.a.b.b.a.cJ(13, this.abMl);
      paramInt = i;
      if (this.acef != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.acef);
      }
      i = paramInt;
      if (this.abqY != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.abqY);
      }
      i = i + i.a.a.a.c(16, 1, this.aceg) + i.a.a.b.b.a.cJ(17, this.aceh) + i.a.a.b.b.a.cJ(18, this.vhJ) + i.a.a.b.b.a.cJ(19, this.acei);
      paramInt = i;
      if (this.acej != null) {
        paramInt = i + i.a.a.a.qC(20, this.acej.computeSize());
      }
      AppMethodBeat.o(117948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.accs.clear();
      this.aceg.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ght localght = (ght)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117948);
        return -1;
      case 1: 
        localght.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117948);
        return 0;
      case 2: 
        localght.aayc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117948);
        return 0;
      case 3: 
        localght.abuB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117948);
        return 0;
      case 4: 
        localght.aakp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 5: 
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
          localght.aaLr = ((dhb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 6: 
        localght.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117948);
        return 0;
      case 7: 
        localght.YYr = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 8: 
        localght.abuF = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117948);
        return 0;
      case 9: 
        localght.aced = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117948);
        return 0;
      case 10: 
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
          localght.accs.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 11: 
        localght.acee = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 12: 
        localght.abgx = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 13: 
        localght.abMl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117948);
        return 0;
      case 14: 
        localght.acef = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 15: 
        localght.abqY = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 16: 
        localght.aceg.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(117948);
        return 0;
      case 17: 
        localght.aceh = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117948);
        return 0;
      case 18: 
        localght.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117948);
        return 0;
      case 19: 
        localght.acei = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117948);
        return 0;
      }
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
        localght.acej = ((bzk)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    AppMethodBeat.o(117948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ght
 * JD-Core Version:    0.7.0.1
 */
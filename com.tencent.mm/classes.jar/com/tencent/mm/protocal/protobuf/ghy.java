package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ghy
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public long YYo;
  public dhb aaLr;
  public acm aaLs;
  public int aayc;
  public LinkedList<String> acer;
  public LinkedList<aem> aces;
  public String vYk;
  public String yts;
  
  public ghy()
  {
    AppMethodBeat.i(117951);
    this.acer = new LinkedList();
    this.aces = new LinkedList();
    AppMethodBeat.o(117951);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258719);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "ConfigKeys", this.acer, false);
      com.tencent.mm.bk.a.a(localJSONObject, "H5Version", Integer.valueOf(this.aayc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Language", this.yts, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessType", Long.valueOf(this.YYo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "NetType", this.vYk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Location", this.aaLr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtParams", this.aces, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ChildMode", this.aaLs, false);
      label121:
      AppMethodBeat.o(258719);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label121;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117952);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.acer);
      paramVarArgs.bS(2, this.aayc);
      if (this.yts != null) {
        paramVarArgs.g(3, this.yts);
      }
      paramVarArgs.bS(4, this.IJG);
      paramVarArgs.bv(5, this.YYo);
      if (this.vYk != null) {
        paramVarArgs.g(6, this.vYk);
      }
      if (this.aaLr != null)
      {
        paramVarArgs.qD(7, this.aaLr.computeSize());
        this.aaLr.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.aces);
      if (this.aaLs != null)
      {
        paramVarArgs.qD(9, this.aaLs.computeSize());
        this.aaLs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 1, this.acer) + 0 + i.a.a.b.b.a.cJ(2, this.aayc);
      paramInt = i;
      if (this.yts != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.yts);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.IJG) + i.a.a.b.b.a.q(5, this.YYo);
      paramInt = i;
      if (this.vYk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.vYk);
      }
      i = paramInt;
      if (this.aaLr != null) {
        i = paramInt + i.a.a.a.qC(7, this.aaLr.computeSize());
      }
      i += i.a.a.a.c(8, 8, this.aces);
      paramInt = i;
      if (this.aaLs != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaLs.computeSize());
      }
      AppMethodBeat.o(117952);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.acer.clear();
      this.aces.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ghy localghy = (ghy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117952);
        return -1;
      case 1: 
        localghy.acer.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(117952);
        return 0;
      case 2: 
        localghy.aayc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117952);
        return 0;
      case 3: 
        localghy.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 4: 
        localghy.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117952);
        return 0;
      case 5: 
        localghy.YYo = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(117952);
        return 0;
      case 6: 
        localghy.vYk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117952);
        return 0;
      case 7: 
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
          localghy.aaLr = ((dhb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117952);
        return 0;
      case 8: 
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
          localghy.aces.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117952);
        return 0;
      }
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
        localghy.aaLs = ((acm)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117952);
      return 0;
    }
    AppMethodBeat.o(117952);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghy
 * JD-Core Version:    0.7.0.1
 */
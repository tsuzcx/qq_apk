package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class jd
  extends com.tencent.mm.bx.a
{
  public int Njs;
  public long Njv;
  public etl YFE;
  public etl YFF;
  public etl YFG;
  public String YFJ;
  public String YHk;
  public int YKV;
  public int YKW;
  public int YKX;
  public LinkedList<etl> YKY;
  public LinkedList<etm> YKZ;
  public gol YLa;
  public int YLb;
  public int YLc;
  public int YLd;
  public long YLe;
  public int YLf;
  public int vhJ;
  
  public jd()
  {
    AppMethodBeat.i(32137);
    this.YKY = new LinkedList();
    this.YKZ = new LinkedList();
    AppMethodBeat.o(32137);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32138);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.YFG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.vhJ);
      if (this.YHk != null) {
        paramVarArgs.g(2, this.YHk);
      }
      if (this.YFE != null)
      {
        paramVarArgs.qD(3, this.YFE.computeSize());
        this.YFE.writeFields(paramVarArgs);
      }
      if (this.YFF != null)
      {
        paramVarArgs.qD(4, this.YFF.computeSize());
        this.YFF.writeFields(paramVarArgs);
      }
      if (this.YFG != null)
      {
        paramVarArgs.qD(5, this.YFG.computeSize());
        this.YFG.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.YKV);
      paramVarArgs.bS(7, this.YKW);
      if (this.YFJ != null) {
        paramVarArgs.g(8, this.YFJ);
      }
      paramVarArgs.bS(9, this.Njs);
      paramVarArgs.bS(10, this.YKX);
      paramVarArgs.e(11, 8, this.YKY);
      paramVarArgs.e(12, 8, this.YKZ);
      if (this.YLa != null)
      {
        paramVarArgs.qD(13, this.YLa.computeSize());
        this.YLa.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.YLb);
      paramVarArgs.bS(15, this.YLc);
      paramVarArgs.bv(16, this.Njv);
      paramVarArgs.bS(17, this.YLd);
      paramVarArgs.bv(18, this.YLe);
      paramVarArgs.bS(19, this.YLf);
      AppMethodBeat.o(32138);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0;
      paramInt = i;
      if (this.YHk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YHk);
      }
      i = paramInt;
      if (this.YFE != null) {
        i = paramInt + i.a.a.a.qC(3, this.YFE.computeSize());
      }
      paramInt = i;
      if (this.YFF != null) {
        paramInt = i + i.a.a.a.qC(4, this.YFF.computeSize());
      }
      i = paramInt;
      if (this.YFG != null) {
        i = paramInt + i.a.a.a.qC(5, this.YFG.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(6, this.YKV) + i.a.a.b.b.a.cJ(7, this.YKW);
      paramInt = i;
      if (this.YFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YFJ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.Njs) + i.a.a.b.b.a.cJ(10, this.YKX) + i.a.a.a.c(11, 8, this.YKY) + i.a.a.a.c(12, 8, this.YKZ);
      paramInt = i;
      if (this.YLa != null) {
        paramInt = i + i.a.a.a.qC(13, this.YLa.computeSize());
      }
      i = i.a.a.b.b.a.cJ(14, this.YLb);
      int j = i.a.a.b.b.a.cJ(15, this.YLc);
      int k = i.a.a.b.b.a.q(16, this.Njv);
      int m = i.a.a.b.b.a.cJ(17, this.YLd);
      int n = i.a.a.b.b.a.q(18, this.YLe);
      int i1 = i.a.a.b.b.a.cJ(19, this.YLf);
      AppMethodBeat.o(32138);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YKY.clear();
      this.YKZ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.YFE == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.YFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.YFG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32138);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      jd localjd = (jd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32138);
        return -1;
      case 1: 
        localjd.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32138);
        return 0;
      case 2: 
        localjd.YHk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localjd.YFE = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localjd.YFF = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localjd.YFG = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 6: 
        localjd.YKV = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32138);
        return 0;
      case 7: 
        localjd.YKW = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32138);
        return 0;
      case 8: 
        localjd.YFJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 9: 
        localjd.Njs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32138);
        return 0;
      case 10: 
        localjd.YKX = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32138);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localjd.YKY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etm)localObject2).di((byte[])localObject1);
          }
          localjd.YKZ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 13: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localjd.YLa = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 14: 
        localjd.YLb = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32138);
        return 0;
      case 15: 
        localjd.YLc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32138);
        return 0;
      case 16: 
        localjd.Njv = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(32138);
        return 0;
      case 17: 
        localjd.YLd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32138);
        return 0;
      case 18: 
        localjd.YLe = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(32138);
        return 0;
      }
      localjd.YLf = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(32138);
      return 0;
    }
    AppMethodBeat.o(32138);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jd
 * JD-Core Version:    0.7.0.1
 */
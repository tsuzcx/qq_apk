package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gks
  extends com.tencent.mm.bx.a
{
  public int YQB;
  public LinkedList<ww> Zqk;
  public LinkedList<giy> aaBN;
  public int acgB;
  public String acgC;
  public String acgD;
  public int acgE;
  public gp acgF;
  
  public gks()
  {
    AppMethodBeat.i(123694);
    this.Zqk = new LinkedList();
    this.aaBN = new LinkedList();
    AppMethodBeat.o(123694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123695);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YQB);
      paramVarArgs.bS(2, this.acgB);
      if (this.acgC != null) {
        paramVarArgs.g(3, this.acgC);
      }
      if (this.acgD != null) {
        paramVarArgs.g(4, this.acgD);
      }
      paramVarArgs.bS(5, this.acgE);
      paramVarArgs.e(6, 8, this.Zqk);
      if (this.acgF != null)
      {
        paramVarArgs.qD(7, this.acgF.computeSize());
        this.acgF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(36, 8, this.aaBN);
      AppMethodBeat.o(123695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YQB) + 0 + i.a.a.b.b.a.cJ(2, this.acgB);
      paramInt = i;
      if (this.acgC != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.acgC);
      }
      i = paramInt;
      if (this.acgD != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.acgD);
      }
      i = i + i.a.a.b.b.a.cJ(5, this.acgE) + i.a.a.a.c(6, 8, this.Zqk);
      paramInt = i;
      if (this.acgF != null) {
        paramInt = i + i.a.a.a.qC(7, this.acgF.computeSize());
      }
      i = i.a.a.a.c(36, 8, this.aaBN);
      AppMethodBeat.o(123695);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zqk.clear();
      this.aaBN.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      gks localgks = (gks)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123695);
        return -1;
      case 1: 
        localgks.YQB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(123695);
        return 0;
      case 2: 
        localgks.acgB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(123695);
        return 0;
      case 3: 
        localgks.acgC = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 4: 
        localgks.acgD = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 5: 
        localgks.acgE = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(123695);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ww();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ww)localObject2).parseFrom((byte[])localObject1);
          }
          localgks.Zqk.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gp)localObject2).parseFrom((byte[])localObject1);
          }
          localgks.acgF = ((gp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new giy();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((giy)localObject2).parseFrom((byte[])localObject1);
        }
        localgks.aaBN.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    AppMethodBeat.o(123695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gks
 * JD-Core Version:    0.7.0.1
 */
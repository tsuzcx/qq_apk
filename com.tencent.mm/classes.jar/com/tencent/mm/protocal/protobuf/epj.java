package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epj
  extends com.tencent.mm.bx.a
{
  public gol abtA;
  public gol abtB;
  public gol abtC;
  public long abtD;
  public int abty;
  public gol abtz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125760);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abty);
      if (this.abtz != null)
      {
        paramVarArgs.qD(2, this.abtz.computeSize());
        this.abtz.writeFields(paramVarArgs);
      }
      if (this.abtA != null)
      {
        paramVarArgs.qD(3, this.abtA.computeSize());
        this.abtA.writeFields(paramVarArgs);
      }
      if (this.abtB != null)
      {
        paramVarArgs.qD(4, this.abtB.computeSize());
        this.abtB.writeFields(paramVarArgs);
      }
      if (this.abtC != null)
      {
        paramVarArgs.qD(5, this.abtC.computeSize());
        this.abtC.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.abtD);
      AppMethodBeat.o(125760);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abty) + 0;
      paramInt = i;
      if (this.abtz != null) {
        paramInt = i + i.a.a.a.qC(2, this.abtz.computeSize());
      }
      i = paramInt;
      if (this.abtA != null) {
        i = paramInt + i.a.a.a.qC(3, this.abtA.computeSize());
      }
      paramInt = i;
      if (this.abtB != null) {
        paramInt = i + i.a.a.a.qC(4, this.abtB.computeSize());
      }
      i = paramInt;
      if (this.abtC != null) {
        i = paramInt + i.a.a.a.qC(5, this.abtC.computeSize());
      }
      paramInt = i.a.a.b.b.a.q(6, this.abtD);
      AppMethodBeat.o(125760);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125760);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      epj localepj = (epj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      gol localgol;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125760);
        return -1;
      case 1: 
        localepj.abty = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125760);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localepj.abtz = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localepj.abtA = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localepj.abtB = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localepj.abtC = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      }
      localepj.abtD = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(125760);
      return 0;
    }
    AppMethodBeat.o(125760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epj
 * JD-Core Version:    0.7.0.1
 */
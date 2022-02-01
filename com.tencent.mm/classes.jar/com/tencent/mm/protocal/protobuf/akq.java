package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class akq
  extends com.tencent.mm.bx.a
{
  public int ZrQ;
  public akr ZrR;
  public int ZrS;
  public akr ZrT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43094);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZrR == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.ZrT == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.ZrQ);
      if (this.ZrR != null)
      {
        paramVarArgs.qD(2, this.ZrR.computeSize());
        this.ZrR.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.ZrS);
      if (this.ZrT != null)
      {
        paramVarArgs.qD(4, this.ZrT.computeSize());
        this.ZrT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZrQ) + 0;
      paramInt = i;
      if (this.ZrR != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZrR.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.ZrS);
      paramInt = i;
      if (this.ZrT != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZrT.computeSize());
      }
      AppMethodBeat.o(43094);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.ZrR == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.ZrT == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      akq localakq = (akq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      akr localakr;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43094);
        return -1;
      case 1: 
        localakq.ZrQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43094);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localakr = new akr();
          if ((localObject != null) && (localObject.length > 0)) {
            localakr.parseFrom((byte[])localObject);
          }
          localakq.ZrR = localakr;
          paramInt += 1;
        }
        AppMethodBeat.o(43094);
        return 0;
      case 3: 
        localakq.ZrS = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(43094);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localakr = new akr();
        if ((localObject != null) && (localObject.length > 0)) {
          localakr.parseFrom((byte[])localObject);
        }
        localakq.ZrT = localakr;
        paramInt += 1;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    AppMethodBeat.o(43094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akq
 * JD-Core Version:    0.7.0.1
 */
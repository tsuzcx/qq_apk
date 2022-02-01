package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aep
  extends com.tencent.mm.bw.a
{
  public csv LpV;
  public LinkedList<ahg> LpW;
  public LinkedList<erb> LpX;
  public String LpY;
  
  public aep()
  {
    AppMethodBeat.i(91431);
    this.LpW = new LinkedList();
    this.LpX = new LinkedList();
    AppMethodBeat.o(91431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91432);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LpV != null)
      {
        paramVarArgs.ni(1, this.LpV.computeSize());
        this.LpV.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.LpW);
      paramVarArgs.e(3, 8, this.LpX);
      if (this.LpY != null) {
        paramVarArgs.e(4, this.LpY);
      }
      AppMethodBeat.o(91432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LpV == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = g.a.a.a.nh(1, this.LpV.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LpW) + g.a.a.a.c(3, 8, this.LpX);
      paramInt = i;
      if (this.LpY != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LpY);
      }
      AppMethodBeat.o(91432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LpW.clear();
        this.LpX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aep localaep = (aep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91432);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaep.LpV = ((csv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaep.LpW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((erb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaep.LpX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        }
        localaep.LpY = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91432);
        return 0;
      }
      AppMethodBeat.o(91432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aep
 * JD-Core Version:    0.7.0.1
 */
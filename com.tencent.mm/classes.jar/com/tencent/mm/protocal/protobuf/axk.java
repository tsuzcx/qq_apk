package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axk
  extends com.tencent.mm.bw.a
{
  public int LHS;
  public LinkedList<axk> LHT;
  public axk LHU;
  public int LHV;
  public String qHk;
  
  public axk()
  {
    AppMethodBeat.i(209563);
    this.LHT = new LinkedList();
    AppMethodBeat.o(209563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209564);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LHS);
      if (this.qHk != null) {
        paramVarArgs.e(2, this.qHk);
      }
      paramVarArgs.e(3, 8, this.LHT);
      if (this.LHU != null)
      {
        paramVarArgs.ni(4, this.LHU.computeSize());
        this.LHU.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.LHV);
      AppMethodBeat.o(209564);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LHS) + 0;
      paramInt = i;
      if (this.qHk != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.qHk);
      }
      i = paramInt + g.a.a.a.c(3, 8, this.LHT);
      paramInt = i;
      if (this.LHU != null) {
        paramInt = i + g.a.a.a.nh(4, this.LHU.computeSize());
      }
      i = g.a.a.b.b.a.bu(5, this.LHV);
      AppMethodBeat.o(209564);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LHT.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209564);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      axk localaxk = (axk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209564);
        return -1;
      case 1: 
        localaxk.LHS = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209564);
        return 0;
      case 2: 
        localaxk.qHk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209564);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new axk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((axk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaxk.LHT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209564);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new axk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((axk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaxk.LHU = ((axk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209564);
        return 0;
      }
      localaxk.LHV = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(209564);
      return 0;
    }
    AppMethodBeat.o(209564);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axk
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class yn
  extends com.tencent.mm.bv.a
{
  public int wPD;
  public yo wPE;
  public int wPF;
  public yo wPG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60034);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wPE == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(60034);
        throw paramVarArgs;
      }
      if (this.wPG == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(60034);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.wPD);
      if (this.wPE != null)
      {
        paramVarArgs.iQ(2, this.wPE.computeSize());
        this.wPE.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wPF);
      if (this.wPG != null)
      {
        paramVarArgs.iQ(4, this.wPG.computeSize());
        this.wPG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(60034);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wPD) + 0;
      paramInt = i;
      if (this.wPE != null) {
        paramInt = i + e.a.a.a.iP(2, this.wPE.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(3, this.wPF);
      paramInt = i;
      if (this.wPG != null) {
        paramInt = i + e.a.a.a.iP(4, this.wPG.computeSize());
      }
      AppMethodBeat.o(60034);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wPE == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(60034);
        throw paramVarArgs;
      }
      if (this.wPG == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(60034);
        throw paramVarArgs;
      }
      AppMethodBeat.o(60034);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      yn localyn = (yn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(60034);
        return -1;
      case 1: 
        localyn.wPD = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60034);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yo();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localyn.wPE = ((yo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60034);
        return 0;
      case 3: 
        localyn.wPF = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60034);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new yo();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((yo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localyn.wPG = ((yo)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(60034);
      return 0;
    }
    AppMethodBeat.o(60034);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yn
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class aix
  extends com.tencent.mm.bv.a
{
  public int wLP;
  public int wLQ;
  public int wLR;
  public b wLT;
  public auv wLU;
  public int xaD;
  public int xaE;
  public int xaF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72849);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wLP);
      paramVarArgs.aO(2, this.wLQ);
      paramVarArgs.aO(3, this.wLR);
      if (this.wLT != null) {
        paramVarArgs.c(4, this.wLT);
      }
      paramVarArgs.aO(5, this.xaD);
      paramVarArgs.aO(6, this.xaE);
      paramVarArgs.aO(7, this.xaF);
      if (this.wLU != null)
      {
        paramVarArgs.iQ(8, this.wLU.computeSize());
        this.wLU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72849);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.wLP) + 0 + e.a.a.b.b.a.bl(2, this.wLQ) + e.a.a.b.b.a.bl(3, this.wLR);
      paramInt = i;
      if (this.wLT != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.wLT);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xaD) + e.a.a.b.b.a.bl(6, this.xaE) + e.a.a.b.b.a.bl(7, this.xaF);
      paramInt = i;
      if (this.wLU != null) {
        paramInt = i + e.a.a.a.iP(8, this.wLU.computeSize());
      }
      AppMethodBeat.o(72849);
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
      AppMethodBeat.o(72849);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      aix localaix = (aix)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72849);
        return -1;
      case 1: 
        localaix.wLP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72849);
        return 0;
      case 2: 
        localaix.wLQ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72849);
        return 0;
      case 3: 
        localaix.wLR = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72849);
        return 0;
      case 4: 
        localaix.wLT = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(72849);
        return 0;
      case 5: 
        localaix.xaD = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72849);
        return 0;
      case 6: 
        localaix.xaE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72849);
        return 0;
      case 7: 
        localaix.xaF = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72849);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new auv();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((auv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localaix.wLU = ((auv)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72849);
      return 0;
    }
    AppMethodBeat.o(72849);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aix
 * JD-Core Version:    0.7.0.1
 */
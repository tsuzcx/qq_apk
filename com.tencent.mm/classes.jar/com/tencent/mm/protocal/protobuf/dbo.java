package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbo
  extends com.tencent.mm.bv.a
{
  public dbg yhA;
  public int yhS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115025);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yhA != null)
      {
        paramVarArgs.iQ(1, this.yhA.computeSize());
        this.yhA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.yhS);
      AppMethodBeat.o(115025);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhA == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = e.a.a.a.iP(1, this.yhA.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.yhS);
      AppMethodBeat.o(115025);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(115025);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        dbo localdbo = (dbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115025);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dbg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdbo.yhA = ((dbg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115025);
          return 0;
        }
        localdbo.yhS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(115025);
        return 0;
      }
      AppMethodBeat.o(115025);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbo
 * JD-Core Version:    0.7.0.1
 */
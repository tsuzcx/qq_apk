package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajj
  extends com.tencent.mm.bx.a
{
  public ccg GgB;
  public int GgC;
  public int GgD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209401);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GgB != null)
      {
        paramVarArgs.lC(1, this.GgB.computeSize());
        this.GgB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GgC);
      paramVarArgs.aS(3, this.GgD);
      AppMethodBeat.o(209401);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GgB == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.a.lB(1, this.GgB.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GgC);
      int j = f.a.a.b.b.a.bz(3, this.GgD);
      AppMethodBeat.o(209401);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209401);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajj localajj = (ajj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209401);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ccg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajj.GgB = ((ccg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209401);
          return 0;
        case 2: 
          localajj.GgC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209401);
          return 0;
        }
        localajj.GgD = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209401);
        return 0;
      }
      AppMethodBeat.o(209401);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajj
 * JD-Core Version:    0.7.0.1
 */
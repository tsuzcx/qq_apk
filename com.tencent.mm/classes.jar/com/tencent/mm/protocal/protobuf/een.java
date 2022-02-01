package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class een
  extends com.tencent.mm.bx.a
{
  public long HPK;
  public pr HPL;
  public int HPM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.HPK);
      if (this.HPL != null)
      {
        paramVarArgs.lC(2, this.HPL.computeSize());
        this.HPL.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HPM);
      AppMethodBeat.o(117950);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.HPK) + 0;
      paramInt = i;
      if (this.HPL != null) {
        paramInt = i + f.a.a.a.lB(2, this.HPL.computeSize());
      }
      i = f.a.a.b.b.a.bz(3, this.HPM);
      AppMethodBeat.o(117950);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117950);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      een localeen = (een)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117950);
        return -1;
      case 1: 
        localeen.HPK = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117950);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((pr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeen.HPL = ((pr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117950);
        return 0;
      }
      localeen.HPM = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(117950);
      return 0;
    }
    AppMethodBeat.o(117950);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.een
 * JD-Core Version:    0.7.0.1
 */
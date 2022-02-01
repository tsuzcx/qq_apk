package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmf
  extends com.tencent.mm.bx.a
{
  public int GNa;
  public cwt HAz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32467);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HAz == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(32467);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GNa);
      if (this.HAz != null)
      {
        paramVarArgs.lC(2, this.HAz.computeSize());
        this.HAz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GNa) + 0;
      paramInt = i;
      if (this.HAz != null) {
        paramInt = i + f.a.a.a.lB(2, this.HAz.computeSize());
      }
      AppMethodBeat.o(32467);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.HAz == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(32467);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dmf localdmf = (dmf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32467);
        return -1;
      case 1: 
        localdmf.GNa = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32467);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cwt();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdmf.HAz = ((cwt)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32467);
      return 0;
    }
    AppMethodBeat.o(32467);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmf
 * JD-Core Version:    0.7.0.1
 */
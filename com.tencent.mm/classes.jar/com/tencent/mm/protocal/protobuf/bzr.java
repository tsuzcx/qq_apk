package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzr
  extends com.tencent.mm.bx.a
{
  public bzq GUI;
  public int GUJ;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      if (this.GUI != null)
      {
        paramVarArgs.lC(2, this.GUI.computeSize());
        this.GUI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GUJ);
      AppMethodBeat.o(192559);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.GUI != null) {
        paramInt = i + f.a.a.a.lB(2, this.GUI.computeSize());
      }
      i = f.a.a.b.b.a.bz(3, this.GUJ);
      AppMethodBeat.o(192559);
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
      AppMethodBeat.o(192559);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bzr localbzr = (bzr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(192559);
        return -1;
      case 1: 
        localbzr.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(192559);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bzq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzr.GUI = ((bzq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(192559);
        return 0;
      }
      localbzr.GUJ = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(192559);
      return 0;
    }
    AppMethodBeat.o(192559);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzr
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btv
  extends com.tencent.mm.bx.a
{
  public int GOn = 0;
  public ccg GOo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209409);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GOn);
      if (this.GOo != null)
      {
        paramVarArgs.lC(2, this.GOo.computeSize());
        this.GOo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209409);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GOn) + 0;
      paramInt = i;
      if (this.GOo != null) {
        paramInt = i + f.a.a.a.lB(2, this.GOo.computeSize());
      }
      AppMethodBeat.o(209409);
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
      AppMethodBeat.o(209409);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      btv localbtv = (btv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209409);
        return -1;
      case 1: 
        localbtv.GOn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209409);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ccg();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ccg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbtv.GOo = ((ccg)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209409);
      return 0;
    }
    AppMethodBeat.o(209409);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btv
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eba
  extends com.tencent.mm.bx.a
{
  public int HNH;
  public ebh HNI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HNH);
      if (this.HNI != null)
      {
        paramVarArgs.lC(2, this.HNI.computeSize());
        this.HNI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209419);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HNH) + 0;
      paramInt = i;
      if (this.HNI != null) {
        paramInt = i + f.a.a.a.lB(2, this.HNI.computeSize());
      }
      AppMethodBeat.o(209419);
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
      AppMethodBeat.o(209419);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      eba localeba = (eba)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209419);
        return -1;
      case 1: 
        localeba.HNH = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209419);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ebh();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ebh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localeba.HNI = ((ebh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209419);
      return 0;
    }
    AppMethodBeat.o(209419);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eba
 * JD-Core Version:    0.7.0.1
 */
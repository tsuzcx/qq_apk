package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvf
  extends com.tencent.mm.bx.a
{
  public int EmI;
  public cmf EmJ;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125797);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EmI);
      if (this.EmJ != null)
      {
        paramVarArgs.kX(2, this.EmJ.computeSize());
        this.EmJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Scene);
      AppMethodBeat.o(125797);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.EmI) + 0;
      paramInt = i;
      if (this.EmJ != null) {
        paramInt = i + f.a.a.a.kW(2, this.EmJ.computeSize());
      }
      i = f.a.a.b.b.a.bA(3, this.Scene);
      AppMethodBeat.o(125797);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125797);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cvf localcvf = (cvf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125797);
        return -1;
      case 1: 
        localcvf.EmI = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125797);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvf.EmJ = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125797);
        return 0;
      }
      localcvf.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(125797);
      return 0;
    }
    AppMethodBeat.o(125797);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvf
 * JD-Core Version:    0.7.0.1
 */
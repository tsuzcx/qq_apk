package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bup
  extends com.tencent.mm.bw.a
{
  public int HhN = 0;
  public cda HhO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197197);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HhN);
      if (this.HhO != null)
      {
        paramVarArgs.lJ(2, this.HhO.computeSize());
        this.HhO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(197197);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HhN) + 0;
      paramInt = i;
      if (this.HhO != null) {
        paramInt = i + f.a.a.a.lI(2, this.HhO.computeSize());
      }
      AppMethodBeat.o(197197);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(197197);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bup localbup = (bup)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197197);
        return -1;
      case 1: 
        localbup.HhN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(197197);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cda();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cda)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbup.HhO = ((cda)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(197197);
      return 0;
    }
    AppMethodBeat.o(197197);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bup
 * JD-Core Version:    0.7.0.1
 */
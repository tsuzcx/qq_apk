package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjd
  extends com.tencent.mm.bw.a
{
  public int HvK;
  public SKBuiltinBuffer_t HvL;
  public int HvM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134248);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HvK);
      if (this.HvL != null)
      {
        paramVarArgs.lJ(2, this.HvL.computeSize());
        this.HvL.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HvM);
      AppMethodBeat.o(134248);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HvK) + 0;
      paramInt = i;
      if (this.HvL != null) {
        paramInt = i + f.a.a.a.lI(2, this.HvL.computeSize());
      }
      i = f.a.a.b.b.a.bz(3, this.HvM);
      AppMethodBeat.o(134248);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(134248);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cjd localcjd = (cjd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(134248);
        return -1;
      case 1: 
        localcjd.HvK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(134248);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjd.HvL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(134248);
        return 0;
      }
      localcjd.HvM = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(134248);
      return 0;
    }
    AppMethodBeat.o(134248);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjd
 * JD-Core Version:    0.7.0.1
 */
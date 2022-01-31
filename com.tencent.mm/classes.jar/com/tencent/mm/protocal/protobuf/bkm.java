package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkm
  extends com.tencent.mm.bv.a
{
  public LinkedList<bkj> xzf;
  
  public bkm()
  {
    AppMethodBeat.i(89119);
    this.xzf = new LinkedList();
    AppMethodBeat.o(89119);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89120);
    if (paramInt == 0)
    {
      ((e.a.a.c.a)paramVarArgs[0]).e(1, 8, this.xzf);
      AppMethodBeat.o(89120);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.a.c(1, 8, this.xzf);
      AppMethodBeat.o(89120);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xzf.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(89120);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bkm localbkm = (bkm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(89120);
        return -1;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bkj();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bkj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbkm.xzf.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(89120);
      return 0;
    }
    AppMethodBeat.o(89120);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkm
 * JD-Core Version:    0.7.0.1
 */
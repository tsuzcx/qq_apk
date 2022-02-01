package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arg
  extends com.tencent.mm.bw.a
{
  public int GEk;
  public LinkedList<FinderContact> GHZ;
  public int GIa;
  
  public arg()
  {
    AppMethodBeat.i(169041);
    this.GHZ = new LinkedList();
    AppMethodBeat.o(169041);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169042);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GHZ);
      paramVarArgs.aS(2, this.GEk);
      paramVarArgs.aS(3, this.GIa);
      AppMethodBeat.o(169042);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.GHZ);
      i = f.a.a.b.b.a.bz(2, this.GEk);
      int j = f.a.a.b.b.a.bz(3, this.GIa);
      AppMethodBeat.o(169042);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GHZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(169042);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      arg localarg = (arg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169042);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarg.GHZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169042);
        return 0;
      case 2: 
        localarg.GEk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169042);
        return 0;
      }
      localarg.GIa = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(169042);
      return 0;
    }
    AppMethodBeat.o(169042);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arg
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlb
  extends com.tencent.mm.bw.a
{
  public int HSI;
  public int HSJ;
  public LinkedList<cdk> HSK;
  
  public dlb()
  {
    AppMethodBeat.i(143986);
    this.HSK = new LinkedList();
    AppMethodBeat.o(143986);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143987);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HSI);
      paramVarArgs.aS(2, this.HSJ);
      paramVarArgs.e(3, 8, this.HSK);
      AppMethodBeat.o(143987);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HSI);
      i = f.a.a.b.b.a.bz(2, this.HSJ);
      int j = f.a.a.a.c(3, 8, this.HSK);
      AppMethodBeat.o(143987);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HSK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143987);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dlb localdlb = (dlb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143987);
        return -1;
      case 1: 
        localdlb.HSI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143987);
        return 0;
      case 2: 
        localdlb.HSJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143987);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cdk();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cdk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdlb.HSK.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143987);
      return 0;
    }
    AppMethodBeat.o(143987);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlb
 * JD-Core Version:    0.7.0.1
 */
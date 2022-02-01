package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnt
  extends com.tencent.mm.bw.a
{
  public int Gxq;
  public long Gxr;
  public LinkedList<coc> HzO;
  public int uXA;
  
  public cnt()
  {
    AppMethodBeat.i(32381);
    this.HzO = new LinkedList();
    AppMethodBeat.o(32381);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32382);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gxq);
      paramVarArgs.aZ(2, this.Gxr);
      paramVarArgs.e(3, 8, this.HzO);
      paramVarArgs.aS(4, this.uXA);
      AppMethodBeat.o(32382);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gxq);
      i = f.a.a.b.b.a.p(2, this.Gxr);
      int j = f.a.a.a.c(3, 8, this.HzO);
      int k = f.a.a.b.b.a.bz(4, this.uXA);
      AppMethodBeat.o(32382);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HzO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32382);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cnt localcnt = (cnt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32382);
        return -1;
      case 1: 
        localcnt.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32382);
        return 0;
      case 2: 
        localcnt.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(32382);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new coc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((coc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnt.HzO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32382);
        return 0;
      }
      localcnt.uXA = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(32382);
      return 0;
    }
    AppMethodBeat.o(32382);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnt
 * JD-Core Version:    0.7.0.1
 */
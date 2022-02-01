package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdn
  extends com.tencent.mm.bw.a
{
  public LinkedList<ss> GtQ;
  public int GtR;
  public int GtS;
  public long lastUpdateTime;
  public int version;
  
  public cdn()
  {
    AppMethodBeat.i(32357);
    this.GtQ = new LinkedList();
    AppMethodBeat.o(32357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32358);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GtQ);
      paramVarArgs.aS(2, this.version);
      paramVarArgs.aS(3, this.GtR);
      paramVarArgs.aS(4, this.GtS);
      paramVarArgs.aZ(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.GtQ);
      i = f.a.a.b.b.a.bz(2, this.version);
      int j = f.a.a.b.b.a.bz(3, this.GtR);
      int k = f.a.a.b.b.a.bz(4, this.GtS);
      int m = f.a.a.b.b.a.p(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GtQ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32358);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cdn localcdn = (cdn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32358);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ss();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdn.GtQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32358);
        return 0;
      case 2: 
        localcdn.version = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32358);
        return 0;
      case 3: 
        localcdn.GtR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32358);
        return 0;
      case 4: 
        localcdn.GtS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32358);
        return 0;
      }
      localcdn.lastUpdateTime = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(32358);
      return 0;
    }
    AppMethodBeat.o(32358);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdn
 * JD-Core Version:    0.7.0.1
 */
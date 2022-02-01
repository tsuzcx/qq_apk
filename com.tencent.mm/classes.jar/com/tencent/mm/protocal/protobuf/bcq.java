package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcq
  extends com.tencent.mm.bw.a
{
  public int LLK;
  public LinkedList<FinderContact> LLL;
  public int msj;
  public int type;
  
  public bcq()
  {
    AppMethodBeat.i(209680);
    this.LLL = new LinkedList();
    AppMethodBeat.o(209680);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209681);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      paramVarArgs.aM(2, this.msj);
      paramVarArgs.aM(3, this.LLK);
      paramVarArgs.e(4, 8, this.LLL);
      AppMethodBeat.o(209681);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.type);
      i = g.a.a.b.b.a.bu(2, this.msj);
      int j = g.a.a.b.b.a.bu(3, this.LLK);
      int k = g.a.a.a.c(4, 8, this.LLL);
      AppMethodBeat.o(209681);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LLL.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209681);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bcq localbcq = (bcq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209681);
        return -1;
      case 1: 
        localbcq.type = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209681);
        return 0;
      case 2: 
        localbcq.msj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209681);
        return 0;
      case 3: 
        localbcq.LLK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209681);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new FinderContact();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localbcq.LLL.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209681);
      return 0;
    }
    AppMethodBeat.o(209681);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcq
 * JD-Core Version:    0.7.0.1
 */
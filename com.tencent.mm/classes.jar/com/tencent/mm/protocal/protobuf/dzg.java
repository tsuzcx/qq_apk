package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzg
  extends com.tencent.mm.bw.a
{
  public int nID;
  public LinkedList<dzf> nIE;
  
  public dzg()
  {
    AppMethodBeat.i(115871);
    this.nIE = new LinkedList();
    AppMethodBeat.o(115871);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115872);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nID);
      paramVarArgs.e(2, 8, this.nIE);
      AppMethodBeat.o(115872);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.nID);
      i = f.a.a.a.c(2, 8, this.nIE);
      AppMethodBeat.o(115872);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nIE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115872);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dzg localdzg = (dzg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115872);
        return -1;
      case 1: 
        localdzg.nID = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115872);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dzf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dzf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdzg.nIE.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(115872);
      return 0;
    }
    AppMethodBeat.o(115872);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzg
 * JD-Core Version:    0.7.0.1
 */
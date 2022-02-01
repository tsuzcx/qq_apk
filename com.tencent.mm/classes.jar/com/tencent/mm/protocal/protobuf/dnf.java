package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnf
  extends com.tencent.mm.bw.a
{
  public boolean HUp;
  public LinkedList<bj> HUq;
  
  public dnf()
  {
    AppMethodBeat.i(122551);
    this.HUp = false;
    this.HUq = new LinkedList();
    AppMethodBeat.o(122551);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.HUp);
      paramVarArgs.e(2, 8, this.HUq);
      AppMethodBeat.o(122552);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amF(1);
      i = f.a.a.a.c(2, 8, this.HUq);
      AppMethodBeat.o(122552);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HUq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(122552);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dnf localdnf = (dnf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122552);
        return -1;
      case 1: 
        localdnf.HUp = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(122552);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdnf.HUq.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(122552);
      return 0;
    }
    AppMethodBeat.o(122552);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnf
 * JD-Core Version:    0.7.0.1
 */
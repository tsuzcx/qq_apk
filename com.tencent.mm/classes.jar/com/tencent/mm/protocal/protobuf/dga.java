package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dga
  extends com.tencent.mm.bw.a
{
  public cxn HMU;
  public long HNg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125769);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.HNg);
      if (this.HMU != null)
      {
        paramVarArgs.lJ(2, this.HMU.computeSize());
        this.HMU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125769);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.HNg) + 0;
      paramInt = i;
      if (this.HMU != null) {
        paramInt = i + f.a.a.a.lI(2, this.HMU.computeSize());
      }
      AppMethodBeat.o(125769);
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
      AppMethodBeat.o(125769);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dga localdga = (dga)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125769);
        return -1;
      case 1: 
        localdga.HNg = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(125769);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cxn();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdga.HMU = ((cxn)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125769);
      return 0;
    }
    AppMethodBeat.o(125769);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dga
 * JD-Core Version:    0.7.0.1
 */
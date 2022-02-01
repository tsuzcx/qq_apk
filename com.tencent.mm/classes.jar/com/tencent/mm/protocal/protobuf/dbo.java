package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbo
  extends com.tencent.mm.bw.a
{
  public bqe HKn;
  public long HKo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110910);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HKn != null)
      {
        paramVarArgs.lJ(1, this.HKn.computeSize());
        this.HKn.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.HKo);
      AppMethodBeat.o(110910);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HKn == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.lI(1, this.HKn.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HKo);
      AppMethodBeat.o(110910);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(110910);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbo localdbo = (dbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110910);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bqe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbo.HKn = ((bqe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110910);
          return 0;
        }
        localdbo.HKo = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110910);
        return 0;
      }
      AppMethodBeat.o(110910);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbo
 * JD-Core Version:    0.7.0.1
 */
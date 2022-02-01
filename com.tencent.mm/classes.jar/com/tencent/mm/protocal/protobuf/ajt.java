package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajt
  extends com.tencent.mm.bw.a
{
  public cda Gzk;
  public int Gzl;
  public int Gzm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197188);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gzk != null)
      {
        paramVarArgs.lJ(1, this.Gzk.computeSize());
        this.Gzk.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gzl);
      paramVarArgs.aS(3, this.Gzm);
      AppMethodBeat.o(197188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gzk == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.a.lI(1, this.Gzk.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gzl);
      int j = f.a.a.b.b.a.bz(3, this.Gzm);
      AppMethodBeat.o(197188);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197188);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajt localajt = (ajt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197188);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cda();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cda)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajt.Gzk = ((cda)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197188);
          return 0;
        case 2: 
          localajt.Gzl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(197188);
          return 0;
        }
        localajt.Gzm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(197188);
        return 0;
      }
      AppMethodBeat.o(197188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajt
 * JD-Core Version:    0.7.0.1
 */
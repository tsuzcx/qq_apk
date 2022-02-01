package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajh
  extends com.tencent.mm.bw.a
{
  public int FUF;
  public dlx GyJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117867);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GyJ != null)
      {
        paramVarArgs.lJ(1, this.GyJ.computeSize());
        this.GyJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FUF);
      AppMethodBeat.o(117867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GyJ == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.lI(1, this.GyJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FUF);
      AppMethodBeat.o(117867);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117867);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajh localajh = (ajh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117867);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dlx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajh.GyJ = ((dlx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117867);
          return 0;
        }
        localajh.FUF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117867);
        return 0;
      }
      AppMethodBeat.o(117867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajh
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afu
  extends com.tencent.mm.bx.a
{
  public bsy DfJ;
  public int DfK;
  public int DfL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DfJ != null)
      {
        paramVarArgs.kX(1, this.DfJ.computeSize());
        this.DfJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DfK);
      paramVarArgs.aR(3, this.DfL);
      AppMethodBeat.o(195469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DfJ == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.a.kW(1, this.DfJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DfK);
      int j = f.a.a.b.b.a.bA(3, this.DfL);
      AppMethodBeat.o(195469);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(195469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afu localafu = (afu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195469);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bsy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafu.DfJ = ((bsy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195469);
          return 0;
        case 2: 
          localafu.DfK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(195469);
          return 0;
        }
        localafu.DfL = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(195469);
        return 0;
      }
      AppMethodBeat.o(195469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afu
 * JD-Core Version:    0.7.0.1
 */
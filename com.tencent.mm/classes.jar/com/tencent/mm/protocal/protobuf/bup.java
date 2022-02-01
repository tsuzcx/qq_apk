package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bup
  extends com.tencent.mm.bx.a
{
  public dcm DnE;
  public int flags;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122519);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DnE != null)
      {
        paramVarArgs.kX(1, this.DnE.computeSize());
        this.DnE.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.flags);
      AppMethodBeat.o(122519);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DnE == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.kW(1, this.DnE.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.flags);
      AppMethodBeat.o(122519);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122519);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bup localbup = (bup)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122519);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dcm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbup.DnE = ((dcm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122519);
          return 0;
        }
        localbup.flags = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(122519);
        return 0;
      }
      AppMethodBeat.o(122519);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bup
 * JD-Core Version:    0.7.0.1
 */
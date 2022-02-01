package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzg
  extends com.tencent.mm.bw.a
{
  public dhz EIE;
  public int flags;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122519);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EIE != null)
      {
        paramVarArgs.ln(1, this.EIE.computeSize());
        this.EIE.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.flags);
      AppMethodBeat.o(122519);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EIE == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.lm(1, this.EIE.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.flags);
      AppMethodBeat.o(122519);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122519);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzg localbzg = (bzg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122519);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dhz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzg.EIE = ((dhz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122519);
          return 0;
        }
        localbzg.flags = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(122519);
        return 0;
      }
      AppMethodBeat.o(122519);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzg
 * JD-Core Version:    0.7.0.1
 */
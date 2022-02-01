package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coc
  extends com.tencent.mm.bw.a
{
  public bnn BNE;
  public String dlQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72577);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlQ != null) {
        paramVarArgs.d(1, this.dlQ);
      }
      if (this.BNE != null)
      {
        paramVarArgs.ln(2, this.BNE.computeSize());
        this.BNE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlQ == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.BNE != null) {
        i = paramInt + f.a.a.a.lm(2, this.BNE.computeSize());
      }
      AppMethodBeat.o(72577);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72577);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coc localcoc = (coc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72577);
          return -1;
        case 1: 
          localcoc.dlQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72577);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bnn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bnn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcoc.BNE = ((bnn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72577);
        return 0;
      }
      AppMethodBeat.o(72577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coc
 * JD-Core Version:    0.7.0.1
 */
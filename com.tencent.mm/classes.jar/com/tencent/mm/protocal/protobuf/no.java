package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class no
  extends com.tencent.mm.bw.a
{
  public cqm EdD;
  public String EdE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117836);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EdD != null)
      {
        paramVarArgs.ln(1, this.EdD.computeSize());
        this.EdD.writeFields(paramVarArgs);
      }
      if (this.EdE != null) {
        paramVarArgs.d(2, this.EdE);
      }
      AppMethodBeat.o(117836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EdD == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.a.lm(1, this.EdD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EdE != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EdE);
      }
      AppMethodBeat.o(117836);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117836);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        no localno = (no)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117836);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cqm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localno.EdD = ((cqm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117836);
          return 0;
        }
        localno.EdE = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117836);
        return 0;
      }
      AppMethodBeat.o(117836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.no
 * JD-Core Version:    0.7.0.1
 */
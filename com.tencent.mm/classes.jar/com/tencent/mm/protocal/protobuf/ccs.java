package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccs
  extends com.tencent.mm.bw.a
{
  public bqg GfD;
  public dnl Gtc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91552);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GfD != null)
      {
        paramVarArgs.lJ(1, this.GfD.computeSize());
        this.GfD.writeFields(paramVarArgs);
      }
      if (this.Gtc != null)
      {
        paramVarArgs.lJ(2, this.Gtc.computeSize());
        this.Gtc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GfD == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lI(1, this.GfD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gtc != null) {
        i = paramInt + f.a.a.a.lI(2, this.Gtc.computeSize());
      }
      AppMethodBeat.o(91552);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccs localccs = (ccs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91552);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccs.GfD = ((bqg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91552);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccs.Gtc = ((dnl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91552);
        return 0;
      }
      AppMethodBeat.o(91552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccs
 * JD-Core Version:    0.7.0.1
 */
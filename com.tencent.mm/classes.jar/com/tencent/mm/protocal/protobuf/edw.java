package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edw
  extends com.tencent.mm.bw.a
{
  public cwl GcB;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117944);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GcB != null)
      {
        paramVarArgs.lJ(1, this.GcB.computeSize());
        this.GcB.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      AppMethodBeat.o(117944);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GcB == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.a.lI(1, this.GcB.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nIJ);
      }
      AppMethodBeat.o(117944);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117944);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        edw localedw = (edw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117944);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cwl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localedw.GcB = ((cwl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117944);
          return 0;
        }
        localedw.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117944);
        return 0;
      }
      AppMethodBeat.o(117944);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edw
 * JD-Core Version:    0.7.0.1
 */
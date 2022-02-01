package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pb
  extends com.tencent.mm.bw.a
{
  public String FXj;
  public int FZk;
  public pc GcJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124454);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GcJ != null)
      {
        paramVarArgs.lJ(1, this.GcJ.computeSize());
        this.GcJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FZk);
      if (this.FXj != null) {
        paramVarArgs.d(3, this.FXj);
      }
      AppMethodBeat.o(124454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GcJ == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.a.lI(1, this.GcJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FZk);
      paramInt = i;
      if (this.FXj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FXj);
      }
      AppMethodBeat.o(124454);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pb localpb = (pb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124454);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((pc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpb.GcJ = ((pc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124454);
          return 0;
        case 2: 
          localpb.FZk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124454);
          return 0;
        }
        localpb.FXj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124454);
        return 0;
      }
      AppMethodBeat.o(124454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pb
 * JD-Core Version:    0.7.0.1
 */
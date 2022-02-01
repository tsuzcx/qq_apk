package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nf
  extends com.tencent.mm.bw.a
{
  public ni FZA;
  public String FZB;
  public String FZC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZA != null)
      {
        paramVarArgs.lJ(1, this.FZA.computeSize());
        this.FZA.writeFields(paramVarArgs);
      }
      if (this.FZB != null) {
        paramVarArgs.d(2, this.FZB);
      }
      if (this.FZC != null) {
        paramVarArgs.d(3, this.FZC);
      }
      AppMethodBeat.o(124421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FZA == null) {
        break label430;
      }
    }
    label430:
    for (int i = f.a.a.a.lI(1, this.FZA.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FZB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FZB);
      }
      i = paramInt;
      if (this.FZC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FZC);
      }
      AppMethodBeat.o(124421);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        nf localnf = (nf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124421);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ni();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ni)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localnf.FZA = ((ni)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124421);
          return 0;
        case 2: 
          localnf.FZB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124421);
          return 0;
        }
        localnf.FZC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124421);
        return 0;
      }
      AppMethodBeat.o(124421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nf
 * JD-Core Version:    0.7.0.1
 */
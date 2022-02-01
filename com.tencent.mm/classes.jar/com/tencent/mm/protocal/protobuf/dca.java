package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dca
  extends com.tencent.mm.bw.a
{
  public LinkedList<aus> GLy;
  public String dAa;
  
  public dca()
  {
    AppMethodBeat.i(122534);
    this.GLy = new LinkedList();
    AppMethodBeat.o(122534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122535);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dAa != null) {
        paramVarArgs.d(1, this.dAa);
      }
      paramVarArgs.e(2, 8, this.GLy);
      AppMethodBeat.o(122535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dAa == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.dAa) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.GLy);
      AppMethodBeat.o(122535);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122535);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dca localdca = (dca)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122535);
          return -1;
        case 1: 
          localdca.dAa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122535);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aus();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aus)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdca.GLy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122535);
        return 0;
      }
      AppMethodBeat.o(122535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dca
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejx
  extends com.tencent.mm.bw.a
{
  public ejt ImM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153342);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ImM != null)
      {
        paramVarArgs.lJ(1, this.ImM.computeSize());
        this.ImM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153342);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ImM == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = f.a.a.a.lI(1, this.ImM.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(153342);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153342);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ejx localejx = (ejx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153342);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ejt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localejx.ImM = ((ejt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153342);
        return 0;
      }
      AppMethodBeat.o(153342);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejx
 * JD-Core Version:    0.7.0.1
 */
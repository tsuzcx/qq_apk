package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwk
  extends com.tencent.mm.bw.a
{
  public dwo IbH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188958);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IbH != null)
      {
        paramVarArgs.lJ(1, this.IbH.computeSize());
        this.IbH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(188958);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IbH == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = f.a.a.a.lI(1, this.IbH.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(188958);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188958);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwk localdwk = (dwk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(188958);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dwo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwk.IbH = ((dwo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(188958);
        return 0;
      }
      AppMethodBeat.o(188958);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwk
 * JD-Core Version:    0.7.0.1
 */
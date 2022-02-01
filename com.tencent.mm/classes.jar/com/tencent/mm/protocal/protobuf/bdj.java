package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdj
  extends com.tencent.mm.bw.a
{
  public bbi LNi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209697);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LNi != null)
      {
        paramVarArgs.ni(1, this.LNi.computeSize());
        this.LNi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209697);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LNi == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = g.a.a.a.nh(1, this.LNi.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(209697);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209697);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bdj localbdj = (bdj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209697);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bbi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bbi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbdj.LNi = ((bbi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209697);
        return 0;
      }
      AppMethodBeat.o(209697);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdj
 * JD-Core Version:    0.7.0.1
 */
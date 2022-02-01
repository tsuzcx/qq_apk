package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class hf
  extends com.tencent.mm.bw.a
{
  public cnb KKP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KKP == null)
      {
        paramVarArgs = new b("Not all required fields were included: MediaObj");
        AppMethodBeat.o(125713);
        throw paramVarArgs;
      }
      if (this.KKP != null)
      {
        paramVarArgs.ni(1, this.KKP.computeSize());
        this.KKP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KKP == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = g.a.a.a.nh(1, this.KKP.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125713);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KKP == null)
        {
          paramVarArgs = new b("Not all required fields were included: MediaObj");
          AppMethodBeat.o(125713);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125713);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        hf localhf = (hf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125713);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cnb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localhf.KKP = ((cnb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125713);
        return 0;
      }
      AppMethodBeat.o(125713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hf
 * JD-Core Version:    0.7.0.1
 */
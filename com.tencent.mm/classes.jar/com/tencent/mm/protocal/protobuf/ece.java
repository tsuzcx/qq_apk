package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ece
  extends com.tencent.mm.bw.a
{
  public ebw Ghr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153347);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ghr != null)
      {
        paramVarArgs.ln(1, this.Ghr.computeSize());
        this.Ghr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153347);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ghr == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = f.a.a.a.lm(1, this.Ghr.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(153347);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153347);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ece localece = (ece)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153347);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ebw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localece.Ghr = ((ebw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153347);
        return 0;
      }
      AppMethodBeat.o(153347);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ece
 * JD-Core Version:    0.7.0.1
 */
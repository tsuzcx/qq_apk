package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class de
  extends com.tencent.mm.bx.a
{
  public blv CxP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43082);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CxP != null)
      {
        paramVarArgs.kX(1, this.CxP.computeSize());
        this.CxP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43082);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CxP == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = f.a.a.a.kW(1, this.CxP.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(43082);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(43082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        de localde = (de)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43082);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new blv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((blv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localde.CxP = ((blv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43082);
        return 0;
      }
      AppMethodBeat.o(43082);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.de
 * JD-Core Version:    0.7.0.1
 */
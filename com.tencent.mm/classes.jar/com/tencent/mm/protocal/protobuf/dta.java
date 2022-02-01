package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dta
  extends com.tencent.mm.bw.a
{
  public crm FPU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115920);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FPU == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatReport");
        AppMethodBeat.o(115920);
        throw paramVarArgs;
      }
      if (this.FPU != null)
      {
        paramVarArgs.ln(1, this.FPU.computeSize());
        this.FPU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115920);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FPU == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.a.lm(1, this.FPU.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(115920);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FPU == null)
        {
          paramVarArgs = new b("Not all required fields were included: StatReport");
          AppMethodBeat.o(115920);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115920);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dta localdta = (dta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115920);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdta.FPU = ((crm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115920);
        return 0;
      }
      AppMethodBeat.o(115920);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dta
 * JD-Core Version:    0.7.0.1
 */
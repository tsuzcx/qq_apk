package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bve
  extends com.tencent.mm.bw.a
{
  public acw Fld;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43108);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fld == null)
      {
        paramVarArgs = new b("Not all required fields were included: DisturbSetting");
        AppMethodBeat.o(43108);
        throw paramVarArgs;
      }
      if (this.Fld != null)
      {
        paramVarArgs.ln(1, this.Fld.computeSize());
        this.Fld.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43108);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fld == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.a.lm(1, this.Fld.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(43108);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Fld == null)
        {
          paramVarArgs = new b("Not all required fields were included: DisturbSetting");
          AppMethodBeat.o(43108);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43108);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bve localbve = (bve)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43108);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((acw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbve.Fld = ((acw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43108);
        return 0;
      }
      AppMethodBeat.o(43108);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bve
 * JD-Core Version:    0.7.0.1
 */
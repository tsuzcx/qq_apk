package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bpm
  extends com.tencent.mm.bx.a
{
  public cmf DbD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101822);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DbD == null)
      {
        paramVarArgs = new b("Not all required fields were included: MemberName");
        AppMethodBeat.o(101822);
        throw paramVarArgs;
      }
      if (this.DbD != null)
      {
        paramVarArgs.kX(1, this.DbD.computeSize());
        this.DbD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DbD == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.a.kW(1, this.DbD.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(101822);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DbD == null)
        {
          paramVarArgs = new b("Not all required fields were included: MemberName");
          AppMethodBeat.o(101822);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpm localbpm = (bpm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101822);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpm.DbD = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101822);
        return 0;
      }
      AppMethodBeat.o(101822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpm
 * JD-Core Version:    0.7.0.1
 */
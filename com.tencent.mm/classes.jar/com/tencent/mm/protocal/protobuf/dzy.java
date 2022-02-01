package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzy
  extends com.tencent.mm.bx.a
{
  public dza HMT;
  public int HMU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147810);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMT == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147810);
        throw paramVarArgs;
      }
      if (this.HMT != null)
      {
        paramVarArgs.lC(1, this.HMT.computeSize());
        this.HMT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HMU);
      AppMethodBeat.o(147810);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMT == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.a.lB(1, this.HMT.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HMU);
      AppMethodBeat.o(147810);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HMT == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147810);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147810);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzy localdzy = (dzy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147810);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dza();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dza)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzy.HMT = ((dza)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147810);
          return 0;
        }
        localdzy.HMU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(147810);
        return 0;
      }
      AppMethodBeat.o(147810);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzy
 * JD-Core Version:    0.7.0.1
 */
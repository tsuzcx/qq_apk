package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzw
  extends com.tencent.mm.bx.a
{
  public dzb HMV;
  public int HMW;
  public int HMX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147808);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMV == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147808);
        throw paramVarArgs;
      }
      if (this.HMV != null)
      {
        paramVarArgs.lC(1, this.HMV.computeSize());
        this.HMV.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HMW);
      paramVarArgs.aS(3, this.HMX);
      AppMethodBeat.o(147808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMV == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = f.a.a.a.lB(1, this.HMV.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HMW);
      int j = f.a.a.b.b.a.bz(3, this.HMX);
      AppMethodBeat.o(147808);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HMV == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_response");
          AppMethodBeat.o(147808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzw localdzw = (dzw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147808);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dzb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzw.HMV = ((dzb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147808);
          return 0;
        case 2: 
          localdzw.HMW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(147808);
          return 0;
        }
        localdzw.HMX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(147808);
        return 0;
      }
      AppMethodBeat.o(147808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzw
 * JD-Core Version:    0.7.0.1
 */
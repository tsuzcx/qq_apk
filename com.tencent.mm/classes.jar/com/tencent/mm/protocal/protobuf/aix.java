package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aix
  extends com.tencent.mm.bx.a
{
  public int FCk;
  public dla Gga;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117867);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gga != null)
      {
        paramVarArgs.lC(1, this.Gga.computeSize());
        this.Gga.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FCk);
      AppMethodBeat.o(117867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gga == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.lB(1, this.Gga.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FCk);
      AppMethodBeat.o(117867);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117867);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aix localaix = (aix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117867);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dla();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dla)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaix.Gga = ((dla)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117867);
          return 0;
        }
        localaix.FCk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117867);
        return 0;
      }
      AppMethodBeat.o(117867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aix
 * JD-Core Version:    0.7.0.1
 */
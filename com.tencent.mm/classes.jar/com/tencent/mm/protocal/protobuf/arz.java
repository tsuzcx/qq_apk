package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arz
  extends com.tencent.mm.bx.a
{
  public aqu Gqk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gqk != null)
      {
        paramVarArgs.lC(1, this.Gqk.computeSize());
        this.Gqk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209367);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gqk == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = f.a.a.a.lB(1, this.Gqk.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(209367);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209367);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arz localarz = (arz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209367);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aqu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarz.Gqk = ((aqu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209367);
        return 0;
      }
      AppMethodBeat.o(209367);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arz
 * JD-Core Version:    0.7.0.1
 */
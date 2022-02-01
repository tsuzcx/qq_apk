package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pp
  extends com.tencent.mm.bx.a
{
  public String FKI;
  public LinkedList<cnw> FKJ;
  
  public pp()
  {
    AppMethodBeat.i(209394);
    this.FKJ = new LinkedList();
    AppMethodBeat.o(209394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKI != null) {
        paramVarArgs.d(1, this.FKI);
      }
      paramVarArgs.e(2, 8, this.FKJ);
      AppMethodBeat.o(209395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FKI == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.FKI) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.FKJ);
      AppMethodBeat.o(209395);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FKJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pp localpp = (pp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209395);
          return -1;
        case 1: 
          localpp.FKI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209395);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cnw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpp.FKJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209395);
        return 0;
      }
      AppMethodBeat.o(209395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pp
 * JD-Core Version:    0.7.0.1
 */
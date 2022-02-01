package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbr
  extends com.tencent.mm.bx.a
{
  public LinkedList<chj> FJw;
  public String dtL;
  
  public dbr()
  {
    AppMethodBeat.i(122544);
    this.FJw = new LinkedList();
    AppMethodBeat.o(122544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dtL != null) {
        paramVarArgs.d(1, this.dtL);
      }
      paramVarArgs.e(2, 8, this.FJw);
      AppMethodBeat.o(122545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dtL == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.dtL) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.FJw);
      AppMethodBeat.o(122545);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FJw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbr localdbr = (dbr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122545);
          return -1;
        case 1: 
          localdbr.dtL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122545);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((chj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbr.FJw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122545);
        return 0;
      }
      AppMethodBeat.o(122545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbr
 * JD-Core Version:    0.7.0.1
 */
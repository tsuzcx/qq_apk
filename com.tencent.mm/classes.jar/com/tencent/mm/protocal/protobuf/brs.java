package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class brs
  extends com.tencent.mm.bx.a
{
  public bsk Fux;
  public LinkedList<bsl> Fuy;
  
  public brs()
  {
    AppMethodBeat.i(116332);
    this.Fuy = new LinkedList();
    AppMethodBeat.o(116332);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fux == null)
      {
        paramVarArgs = new b("Not all required fields were included: LogHead");
        AppMethodBeat.o(116333);
        throw paramVarArgs;
      }
      if (this.Fux != null)
      {
        paramVarArgs.lC(1, this.Fux.computeSize());
        this.Fux.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Fuy);
      AppMethodBeat.o(116333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fux == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = f.a.a.a.lB(1, this.Fux.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Fuy);
      AppMethodBeat.o(116333);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fuy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Fux == null)
        {
          paramVarArgs = new b("Not all required fields were included: LogHead");
          AppMethodBeat.o(116333);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116333);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brs localbrs = (brs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116333);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrs.Fux = ((bsk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116333);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrs.Fuy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116333);
        return 0;
      }
      AppMethodBeat.o(116333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brs
 * JD-Core Version:    0.7.0.1
 */
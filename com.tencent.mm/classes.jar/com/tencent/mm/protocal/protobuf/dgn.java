package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgn
  extends com.tencent.mm.bx.a
{
  public SnsObject Htv;
  public cwt HuP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Htv == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(125809);
        throw paramVarArgs;
      }
      if (this.Htv != null)
      {
        paramVarArgs.lC(1, this.Htv.computeSize());
        this.Htv.writeFields(paramVarArgs);
      }
      if (this.HuP != null)
      {
        paramVarArgs.lC(2, this.HuP.computeSize());
        this.HuP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Htv == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lB(1, this.Htv.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HuP != null) {
        i = paramInt + f.a.a.a.lB(2, this.HuP.computeSize());
      }
      AppMethodBeat.o(125809);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Htv == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(125809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgn localdgn = (dgn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125809);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgn.Htv = ((SnsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125809);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgn.HuP = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125809);
        return 0;
      }
      AppMethodBeat.o(125809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgn
 * JD-Core Version:    0.7.0.1
 */
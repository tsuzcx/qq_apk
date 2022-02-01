package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bux
  extends com.tencent.mm.bx.a
{
  public buy GPe;
  public buu GPf;
  public buv GPg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211971);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GPe != null)
      {
        paramVarArgs.lC(1, this.GPe.computeSize());
        this.GPe.writeFields(paramVarArgs);
      }
      if (this.GPf != null)
      {
        paramVarArgs.lC(2, this.GPf.computeSize());
        this.GPf.writeFields(paramVarArgs);
      }
      if (this.GPg != null)
      {
        paramVarArgs.lC(3, this.GPg.computeSize());
        this.GPg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(211971);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GPe == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lB(1, this.GPe.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GPf != null) {
        paramInt = i + f.a.a.a.lB(2, this.GPf.computeSize());
      }
      i = paramInt;
      if (this.GPg != null) {
        i = paramInt + f.a.a.a.lB(3, this.GPg.computeSize());
      }
      AppMethodBeat.o(211971);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(211971);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bux localbux = (bux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211971);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbux.GPe = ((buy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211971);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbux.GPf = ((buu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211971);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new buv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((buv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbux.GPg = ((buv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(211971);
        return 0;
      }
      AppMethodBeat.o(211971);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bux
 * JD-Core Version:    0.7.0.1
 */
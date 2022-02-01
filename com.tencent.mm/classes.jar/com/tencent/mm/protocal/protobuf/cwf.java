package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cwf
  extends com.tencent.mm.bx.a
{
  public cwt GKC;
  public cwt GbY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbY == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43126);
        throw paramVarArgs;
      }
      if (this.GKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(43126);
        throw paramVarArgs;
      }
      if (this.GbY != null)
      {
        paramVarArgs.lC(1, this.GbY.computeSize());
        this.GbY.writeFields(paramVarArgs);
      }
      if (this.GKC != null)
      {
        paramVarArgs.lC(2, this.GKC.computeSize());
        this.GKC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbY == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lB(1, this.GbY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GKC != null) {
        i = paramInt + f.a.a.a.lB(2, this.GKC.computeSize());
      }
      AppMethodBeat.o(43126);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GbY == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43126);
          throw paramVarArgs;
        }
        if (this.GKC == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(43126);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43126);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwf localcwf = (cwf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43126);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwf.GbY = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43126);
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
          localcwf.GKC = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43126);
        return 0;
      }
      AppMethodBeat.o(43126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwf
 * JD-Core Version:    0.7.0.1
 */
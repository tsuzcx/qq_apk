package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ead
  extends com.tencent.mm.bx.a
{
  public dzb HMV;
  public dzu HNf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147815);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMV == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147815);
        throw paramVarArgs;
      }
      if (this.HMV != null)
      {
        paramVarArgs.lC(1, this.HMV.computeSize());
        this.HMV.writeFields(paramVarArgs);
      }
      if (this.HNf != null)
      {
        paramVarArgs.lC(2, this.HNf.computeSize());
        this.HNf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMV == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lB(1, this.HMV.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HNf != null) {
        i = paramInt + f.a.a.a.lB(2, this.HNf.computeSize());
      }
      AppMethodBeat.o(147815);
      return i;
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
          AppMethodBeat.o(147815);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ead localead = (ead)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147815);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localead.HMV = ((dzb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147815);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localead.HNf = ((dzu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(147815);
        return 0;
      }
      AppMethodBeat.o(147815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ead
 * JD-Core Version:    0.7.0.1
 */
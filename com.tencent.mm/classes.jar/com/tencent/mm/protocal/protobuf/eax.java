package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eax
  extends com.tencent.mm.bx.a
{
  public eay LzA;
  public eau LzB;
  public eav LzC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202521);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.LzA != null)
      {
        paramVarArgs.kX(1, this.LzA.computeSize());
        this.LzA.writeFields(paramVarArgs);
      }
      if (this.LzB != null)
      {
        paramVarArgs.kX(2, this.LzB.computeSize());
        this.LzB.writeFields(paramVarArgs);
      }
      if (this.LzC != null)
      {
        paramVarArgs.kX(3, this.LzC.computeSize());
        this.LzC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(202521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LzA == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.kW(1, this.LzA.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LzB != null) {
        paramInt = i + f.a.a.a.kW(2, this.LzB.computeSize());
      }
      i = paramInt;
      if (this.LzC != null) {
        i = paramInt + f.a.a.a.kW(3, this.LzC.computeSize());
      }
      AppMethodBeat.o(202521);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(202521);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eax localeax = (eax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202521);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eay();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eay)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeax.LzA = ((eay)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(202521);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eau();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eau)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeax.LzB = ((eau)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(202521);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eav();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eav)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeax.LzC = ((eav)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(202521);
        return 0;
      }
      AppMethodBeat.o(202521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eax
 * JD-Core Version:    0.7.0.1
 */
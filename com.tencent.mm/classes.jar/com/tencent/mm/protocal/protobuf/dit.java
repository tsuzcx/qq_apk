package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dit
  extends com.tencent.mm.bw.a
{
  public int HPN;
  public dyj HPO;
  public int HQt;
  public int HQu;
  public int HQv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115855);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HPO == null)
      {
        paramVarArgs = new b("Not all required fields were included: Addr");
        AppMethodBeat.o(115855);
        throw paramVarArgs;
      }
      if (this.HPO != null)
      {
        paramVarArgs.lJ(1, this.HPO.computeSize());
        this.HPO.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HPN);
      paramVarArgs.aS(3, this.HQt);
      paramVarArgs.aS(4, this.HQu);
      paramVarArgs.aS(5, this.HQv);
      AppMethodBeat.o(115855);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HPO == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = f.a.a.a.lI(1, this.HPO.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HPN);
      int j = f.a.a.b.b.a.bz(3, this.HQt);
      int k = f.a.a.b.b.a.bz(4, this.HQu);
      int m = f.a.a.b.b.a.bz(5, this.HQv);
      AppMethodBeat.o(115855);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HPO == null)
        {
          paramVarArgs = new b("Not all required fields were included: Addr");
          AppMethodBeat.o(115855);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115855);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dit localdit = (dit)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115855);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdit.HPO = ((dyj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115855);
          return 0;
        case 2: 
          localdit.HPN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115855);
          return 0;
        case 3: 
          localdit.HQt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115855);
          return 0;
        case 4: 
          localdit.HQu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115855);
          return 0;
        }
        localdit.HQv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115855);
        return 0;
      }
      AppMethodBeat.o(115855);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dit
 * JD-Core Version:    0.7.0.1
 */
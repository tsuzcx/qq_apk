package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class boa
  extends com.tencent.mm.bw.a
{
  public dod HaU;
  public coq HaV;
  public coq HaW;
  public String dyI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197195);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HaU != null)
      {
        paramVarArgs.lJ(1, this.HaU.computeSize());
        this.HaU.writeFields(paramVarArgs);
      }
      if (this.dyI != null) {
        paramVarArgs.d(2, this.dyI);
      }
      if (this.HaV != null)
      {
        paramVarArgs.lJ(3, this.HaV.computeSize());
        this.HaV.writeFields(paramVarArgs);
      }
      if (this.HaW != null)
      {
        paramVarArgs.lJ(4, this.HaW.computeSize());
        this.HaW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(197195);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HaU == null) {
        break label678;
      }
    }
    label678:
    for (int i = f.a.a.a.lI(1, this.HaU.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dyI);
      }
      i = paramInt;
      if (this.HaV != null) {
        i = paramInt + f.a.a.a.lI(3, this.HaV.computeSize());
      }
      paramInt = i;
      if (this.HaW != null) {
        paramInt = i + f.a.a.a.lI(4, this.HaW.computeSize());
      }
      AppMethodBeat.o(197195);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197195);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        boa localboa = (boa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(197195);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboa.HaU = ((dod)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197195);
          return 0;
        case 2: 
          localboa.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(197195);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new coq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((coq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localboa.HaV = ((coq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(197195);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new coq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((coq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localboa.HaW = ((coq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(197195);
        return 0;
      }
      AppMethodBeat.o(197195);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boa
 * JD-Core Version:    0.7.0.1
 */
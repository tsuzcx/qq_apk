package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ciu
  extends com.tencent.mm.bw.a
{
  public ciw Hvn;
  public civ Hvo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117886);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hvn != null)
      {
        paramVarArgs.lJ(1, this.Hvn.computeSize());
        this.Hvn.writeFields(paramVarArgs);
      }
      if (this.Hvo != null)
      {
        paramVarArgs.lJ(2, this.Hvo.computeSize());
        this.Hvo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hvn == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lI(1, this.Hvn.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hvo != null) {
        i = paramInt + f.a.a.a.lI(2, this.Hvo.computeSize());
      }
      AppMethodBeat.o(117886);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117886);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ciu localciu = (ciu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117886);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ciw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ciw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localciu.Hvn = ((ciw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117886);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new civ();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((civ)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localciu.Hvo = ((civ)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117886);
        return 0;
      }
      AppMethodBeat.o(117886);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciu
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cia
  extends com.tencent.mm.bx.a
{
  public cic HbN;
  public cib HbO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117886);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HbN != null)
      {
        paramVarArgs.lC(1, this.HbN.computeSize());
        this.HbN.writeFields(paramVarArgs);
      }
      if (this.HbO != null)
      {
        paramVarArgs.lC(2, this.HbO.computeSize());
        this.HbO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HbN == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lB(1, this.HbN.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HbO != null) {
        i = paramInt + f.a.a.a.lB(2, this.HbO.computeSize());
      }
      AppMethodBeat.o(117886);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117886);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cia localcia = (cia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117886);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cic();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cic)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcia.HbN = ((cic)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117886);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cib();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cib)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcia.HbO = ((cib)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cia
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ye
  extends com.tencent.mm.bx.a
{
  public dak Dag;
  public dbp Dah;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dag != null)
      {
        paramVarArgs.kX(1, this.Dag.computeSize());
        this.Dag.writeFields(paramVarArgs);
      }
      if (this.Dah != null)
      {
        paramVarArgs.kX(2, this.Dah.computeSize());
        this.Dah.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dag == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.kW(1, this.Dag.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dah != null) {
        i = paramInt + f.a.a.a.kW(2, this.Dah.computeSize());
      }
      AppMethodBeat.o(91425);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ye localye = (ye)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91425);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dak();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localye.Dag = ((dak)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91425);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localye.Dah = ((dbp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91425);
        return 0;
      }
      AppMethodBeat.o(91425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ye
 * JD-Core Version:    0.7.0.1
 */
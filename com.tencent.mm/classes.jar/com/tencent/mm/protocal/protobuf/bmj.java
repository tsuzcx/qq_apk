package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmj
  extends com.tencent.mm.bv.a
{
  public int Timestamp;
  public azt wOE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28571);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOE != null)
      {
        paramVarArgs.iQ(1, this.wOE.computeSize());
        this.wOE.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.Timestamp);
      AppMethodBeat.o(28571);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOE == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = e.a.a.a.iP(1, this.wOE.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.Timestamp);
      AppMethodBeat.o(28571);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28571);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bmj localbmj = (bmj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28571);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azt();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((azt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbmj.wOE = ((azt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28571);
          return 0;
        }
        localbmj.Timestamp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28571);
        return 0;
      }
      AppMethodBeat.o(28571);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmj
 * JD-Core Version:    0.7.0.1
 */
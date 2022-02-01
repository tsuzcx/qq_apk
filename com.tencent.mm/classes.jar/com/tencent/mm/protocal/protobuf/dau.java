package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dau
  extends com.tencent.mm.bx.a
{
  public bpm HqL;
  public long HqM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110910);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HqL != null)
      {
        paramVarArgs.lC(1, this.HqL.computeSize());
        this.HqL.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HqM);
      AppMethodBeat.o(110910);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HqL == null) {
        break label354;
      }
    }
    label354:
    for (paramInt = f.a.a.a.lB(1, this.HqL.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HqM);
      AppMethodBeat.o(110910);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(110910);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dau localdau = (dau)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110910);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bpm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdau.HqL = ((bpm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110910);
          return 0;
        }
        localdau.HqM = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110910);
        return 0;
      }
      AppMethodBeat.o(110910);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dau
 * JD-Core Version:    0.7.0.1
 */
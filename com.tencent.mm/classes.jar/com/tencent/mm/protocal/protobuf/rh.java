package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rh
  extends com.tencent.mm.bw.a
{
  public abi GfF;
  public rg GfG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91385);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GfF != null)
      {
        paramVarArgs.lJ(1, this.GfF.computeSize());
        this.GfF.writeFields(paramVarArgs);
      }
      if (this.GfG != null)
      {
        paramVarArgs.lJ(2, this.GfG.computeSize());
        this.GfG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GfF == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lI(1, this.GfF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GfG != null) {
        i = paramInt + f.a.a.a.lI(2, this.GfG.computeSize());
      }
      AppMethodBeat.o(91385);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rh localrh = (rh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91385);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrh.GfF = ((abi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91385);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrh.GfG = ((rg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91385);
        return 0;
      }
      AppMethodBeat.o(91385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rh
 * JD-Core Version:    0.7.0.1
 */
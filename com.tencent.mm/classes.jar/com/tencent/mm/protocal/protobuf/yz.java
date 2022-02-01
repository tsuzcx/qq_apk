package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yz
  extends com.tencent.mm.bx.a
{
  public bpm FYD;
  public dvw FYE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110892);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FYD != null)
      {
        paramVarArgs.lC(1, this.FYD.computeSize());
        this.FYD.writeFields(paramVarArgs);
      }
      if (this.FYE != null)
      {
        paramVarArgs.lC(2, this.FYE.computeSize());
        this.FYE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FYD == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lB(1, this.FYD.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FYE != null) {
        i = paramInt + f.a.a.a.lB(2, this.FYE.computeSize());
      }
      AppMethodBeat.o(110892);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(110892);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yz localyz = (yz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110892);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyz.FYD = ((bpm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110892);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dvw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyz.FYE = ((dvw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110892);
        return 0;
      }
      AppMethodBeat.o(110892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yz
 * JD-Core Version:    0.7.0.1
 */
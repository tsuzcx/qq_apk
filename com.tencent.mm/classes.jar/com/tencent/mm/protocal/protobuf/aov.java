package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aov
  extends com.tencent.mm.bw.a
{
  public String GGd;
  public dje GGe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189359);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GGd != null) {
        paramVarArgs.d(1, this.GGd);
      }
      if (this.GGe != null)
      {
        paramVarArgs.lJ(2, this.GGe.computeSize());
        this.GGe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(189359);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GGd == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.GGd) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GGe != null) {
        i = paramInt + f.a.a.a.lI(2, this.GGe.computeSize());
      }
      AppMethodBeat.o(189359);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189359);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aov localaov = (aov)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189359);
          return -1;
        case 1: 
          localaov.GGd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189359);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dje();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dje)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaov.GGe = ((dje)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189359);
        return 0;
      }
      AppMethodBeat.o(189359);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aov
 * JD-Core Version:    0.7.0.1
 */
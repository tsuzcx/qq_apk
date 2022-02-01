package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cze
  extends com.tencent.mm.bw.a
{
  public String FAA;
  public LinkedList<acz> FIl;
  
  public cze()
  {
    AppMethodBeat.i(194022);
    this.FIl = new LinkedList();
    AppMethodBeat.o(194022);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194023);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FAA != null) {
        paramVarArgs.d(1, this.FAA);
      }
      paramVarArgs.e(2, 8, this.FIl);
      AppMethodBeat.o(194023);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FAA == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.FAA) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.FIl);
      AppMethodBeat.o(194023);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FIl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194023);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cze localcze = (cze)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194023);
          return -1;
        case 1: 
          localcze.FAA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194023);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((acz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcze.FIl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194023);
        return 0;
      }
      AppMethodBeat.o(194023);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cze
 * JD-Core Version:    0.7.0.1
 */
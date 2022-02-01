package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdh
  extends com.tencent.mm.bw.a
{
  public String fnJ;
  public LinkedList<cdi> ulR;
  
  public cdh()
  {
    AppMethodBeat.i(194050);
    this.ulR = new LinkedList();
    AppMethodBeat.o(194050);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194051);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fnJ != null) {
        paramVarArgs.d(1, this.fnJ);
      }
      paramVarArgs.e(2, 8, this.ulR);
      AppMethodBeat.o(194051);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fnJ == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.fnJ) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.ulR);
      AppMethodBeat.o(194051);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ulR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(194051);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdh localcdh = (cdh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194051);
          return -1;
        case 1: 
          localcdh.fnJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(194051);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cdi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdh.ulR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194051);
        return 0;
      }
      AppMethodBeat.o(194051);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdh
 * JD-Core Version:    0.7.0.1
 */
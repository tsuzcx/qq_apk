package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbr
  extends com.tencent.mm.bw.a
{
  public String LKO;
  public LinkedList<bdj> LKY;
  
  public bbr()
  {
    AppMethodBeat.i(209661);
    this.LKY = new LinkedList();
    AppMethodBeat.o(209661);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209662);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LKO != null) {
        paramVarArgs.e(1, this.LKO);
      }
      paramVarArgs.e(2, 8, this.LKY);
      AppMethodBeat.o(209662);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LKO == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = g.a.a.b.b.a.f(1, this.LKO) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.LKY);
      AppMethodBeat.o(209662);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LKY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209662);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bbr localbbr = (bbr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209662);
          return -1;
        case 1: 
          localbbr.LKO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209662);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bdj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbbr.LKY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209662);
        return 0;
      }
      AppMethodBeat.o(209662);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbr
 * JD-Core Version:    0.7.0.1
 */
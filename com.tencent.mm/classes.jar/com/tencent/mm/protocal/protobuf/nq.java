package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nq
  extends com.tencent.mm.bw.a
{
  public LinkedList<ns> KKx;
  public boolean KTd;
  public String Title;
  
  public nq()
  {
    AppMethodBeat.i(124411);
    this.KKx = new LinkedList();
    AppMethodBeat.o(124411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.KKx);
      paramVarArgs.cc(3, this.KTd);
      AppMethodBeat.o(124412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = g.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.KKx);
      int j = g.a.a.b.b.a.fS(3);
      AppMethodBeat.o(124412);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KKx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        nq localnq = (nq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124412);
          return -1;
        case 1: 
          localnq.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124412);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ns();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ns)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localnq.KKx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124412);
          return 0;
        }
        localnq.KTd = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(124412);
        return 0;
      }
      AppMethodBeat.o(124412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class evr
  extends com.tencent.mm.bw.a
{
  public String Nta;
  public LinkedList<evn> Nts;
  
  public evr()
  {
    AppMethodBeat.i(147803);
    this.Nts = new LinkedList();
    AppMethodBeat.o(147803);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147804);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nta != null) {
        paramVarArgs.e(1, this.Nta);
      }
      paramVarArgs.e(2, 8, this.Nts);
      AppMethodBeat.o(147804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nta == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = g.a.a.b.b.a.f(1, this.Nta) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.Nts);
      AppMethodBeat.o(147804);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nts.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        evr localevr = (evr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147804);
          return -1;
        case 1: 
          localevr.Nta = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147804);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new evn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((evn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localevr.Nts.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(147804);
        return 0;
      }
      AppMethodBeat.o(147804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evr
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dfa
  extends com.tencent.mm.bw.a
{
  public LinkedList<cft> MKb;
  public String id;
  
  public dfa()
  {
    AppMethodBeat.i(220720);
    this.MKb = new LinkedList();
    AppMethodBeat.o(220720);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220721);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new b("Not all required fields were included: id");
        AppMethodBeat.o(220721);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.e(1, this.id);
      }
      paramVarArgs.e(2, 8, this.MKb);
      AppMethodBeat.o(220721);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = g.a.a.b.b.a.f(1, this.id) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.MKb);
      AppMethodBeat.o(220721);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MKb.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new b("Not all required fields were included: id");
          AppMethodBeat.o(220721);
          throw paramVarArgs;
        }
        AppMethodBeat.o(220721);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dfa localdfa = (dfa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220721);
          return -1;
        case 1: 
          localdfa.id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(220721);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cft();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cft)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdfa.MKb.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(220721);
        return 0;
      }
      AppMethodBeat.o(220721);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfa
 * JD-Core Version:    0.7.0.1
 */
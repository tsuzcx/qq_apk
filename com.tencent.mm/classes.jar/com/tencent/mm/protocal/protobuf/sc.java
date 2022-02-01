package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sc
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b KZM;
  public com.tencent.mm.bw.b KZN;
  public LinkedList<duv> KZO;
  
  public sc()
  {
    AppMethodBeat.i(117851);
    this.KZO = new LinkedList();
    AppMethodBeat.o(117851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117852);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KZM == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(117852);
        throw paramVarArgs;
      }
      if (this.KZN == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ServiceUrl");
        AppMethodBeat.o(117852);
        throw paramVarArgs;
      }
      if (this.KZM != null) {
        paramVarArgs.c(1, this.KZM);
      }
      if (this.KZN != null) {
        paramVarArgs.c(2, this.KZN);
      }
      paramVarArgs.e(3, 8, this.KZO);
      AppMethodBeat.o(117852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KZM == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = g.a.a.b.b.a.b(1, this.KZM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KZN != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.KZN);
      }
      paramInt = g.a.a.a.c(3, 8, this.KZO);
      AppMethodBeat.o(117852);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KZO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KZM == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
          AppMethodBeat.o(117852);
          throw paramVarArgs;
        }
        if (this.KZN == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: ServiceUrl");
          AppMethodBeat.o(117852);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117852);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        sc localsc = (sc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117852);
          return -1;
        case 1: 
          localsc.KZM = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(117852);
          return 0;
        case 2: 
          localsc.KZN = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(117852);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new duv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((duv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsc.KZO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117852);
        return 0;
      }
      AppMethodBeat.o(117852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sc
 * JD-Core Version:    0.7.0.1
 */
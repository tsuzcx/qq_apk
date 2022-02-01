package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dvw
  extends dop
{
  public int LTj;
  public og LTl;
  public int mask;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124551);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LTl == null)
      {
        paramVarArgs = new b("Not all required fields were included: attr");
        AppMethodBeat.o(124551);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LTj);
      paramVarArgs.aM(3, this.mask);
      if (this.LTl != null)
      {
        paramVarArgs.ni(4, this.LTl.computeSize());
        this.LTl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LTj) + g.a.a.b.b.a.bu(3, this.mask);
      paramInt = i;
      if (this.LTl != null) {
        paramInt = i + g.a.a.a.nh(4, this.LTl.computeSize());
      }
      AppMethodBeat.o(124551);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LTl == null)
        {
          paramVarArgs = new b("Not all required fields were included: attr");
          AppMethodBeat.o(124551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvw localdvw = (dvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124551);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdvw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124551);
          return 0;
        case 2: 
          localdvw.LTj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124551);
          return 0;
        case 3: 
          localdvw.mask = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124551);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new og();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((og)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdvw.LTl = ((og)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124551);
        return 0;
      }
      AppMethodBeat.o(124551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvw
 * JD-Core Version:    0.7.0.1
 */
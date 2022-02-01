package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cf
  extends com.tencent.mm.cd.a
{
  public cot RHS;
  public LinkedList<cou> RHT;
  
  public cf()
  {
    AppMethodBeat.i(116325);
    this.RHT = new LinkedList();
    AppMethodBeat.o(116325);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116326);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RHS == null)
      {
        paramVarArgs = new b("Not all required fields were included: LogHead");
        AppMethodBeat.o(116326);
        throw paramVarArgs;
      }
      if (this.RHS != null)
      {
        paramVarArgs.oE(1, this.RHS.computeSize());
        this.RHS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.RHT);
      AppMethodBeat.o(116326);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RHS == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = g.a.a.a.oD(1, this.RHS.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.RHT);
      AppMethodBeat.o(116326);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RHT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RHS == null)
        {
          paramVarArgs = new b("Not all required fields were included: LogHead");
          AppMethodBeat.o(116326);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116326);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cf localcf = (cf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116326);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cot();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cot)localObject2).parseFrom((byte[])localObject1);
            }
            localcf.RHS = ((cot)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(116326);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cou();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cou)localObject2).parseFrom((byte[])localObject1);
          }
          localcf.RHT.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(116326);
        return 0;
      }
      AppMethodBeat.o(116326);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cf
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bw
  extends com.tencent.mm.bx.a
{
  public bke CwR;
  public LinkedList<bkf> CwS;
  
  public bw()
  {
    AppMethodBeat.i(116325);
    this.CwS = new LinkedList();
    AppMethodBeat.o(116325);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116326);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CwR == null)
      {
        paramVarArgs = new b("Not all required fields were included: LogHead");
        AppMethodBeat.o(116326);
        throw paramVarArgs;
      }
      if (this.CwR != null)
      {
        paramVarArgs.kX(1, this.CwR.computeSize());
        this.CwR.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.CwS);
      AppMethodBeat.o(116326);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CwR == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = f.a.a.a.kW(1, this.CwR.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.CwS);
      AppMethodBeat.o(116326);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CwS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CwR == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bw localbw = (bw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116326);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bke();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bke)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbw.CwR = ((bke)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116326);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbw.CwS.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bw
 * JD-Core Version:    0.7.0.1
 */
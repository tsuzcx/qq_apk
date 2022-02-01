package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class afg
  extends dpc
{
  public LinkedList<afq> KGQ;
  public int gsq;
  
  public afg()
  {
    AppMethodBeat.i(101803);
    this.KGQ = new LinkedList();
    AppMethodBeat.o(101803);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101804);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101804);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.gsq);
      paramVarArgs.e(3, 8, this.KGQ);
      AppMethodBeat.o(101804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.gsq);
      int j = g.a.a.a.c(3, 8, this.KGQ);
      AppMethodBeat.o(101804);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KGQ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101804);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101804);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        afg localafg = (afg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101804);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localafg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101804);
          return 0;
        case 2: 
          localafg.gsq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101804);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localafg.KGQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101804);
        return 0;
      }
      AppMethodBeat.o(101804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afg
 * JD-Core Version:    0.7.0.1
 */
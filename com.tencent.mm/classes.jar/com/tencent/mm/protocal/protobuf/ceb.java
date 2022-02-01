package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ceb
  extends dpc
{
  public int MjI;
  public cdz Mjz;
  public int dIZ;
  public int xGz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123603);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123603);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Mjz != null)
      {
        paramVarArgs.ni(2, this.Mjz.computeSize());
        this.Mjz.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.dIZ);
      paramVarArgs.aM(4, this.xGz);
      paramVarArgs.aM(5, this.MjI);
      AppMethodBeat.o(123603);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Mjz != null) {
        i = paramInt + g.a.a.a.nh(2, this.Mjz.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(3, this.dIZ);
      int j = g.a.a.b.b.a.bu(4, this.xGz);
      int k = g.a.a.b.b.a.bu(5, this.MjI);
      AppMethodBeat.o(123603);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123603);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123603);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ceb localceb = (ceb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123603);
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
            localceb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123603);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localceb.Mjz = ((cdz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123603);
          return 0;
        case 3: 
          localceb.dIZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123603);
          return 0;
        case 4: 
          localceb.xGz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123603);
          return 0;
        }
        localceb.MjI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123603);
        return 0;
      }
      AppMethodBeat.o(123603);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceb
 * JD-Core Version:    0.7.0.1
 */
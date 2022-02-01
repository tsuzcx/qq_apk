package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bkq
  extends dpc
{
  public LinkedList<String> pQI;
  public int pQK;
  public int pQL;
  public int pQM;
  
  public bkq()
  {
    AppMethodBeat.i(114018);
    this.pQI = new LinkedList();
    AppMethodBeat.o(114018);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114019);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114019);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.pQI);
      paramVarArgs.aM(3, this.pQK);
      paramVarArgs.aM(4, this.pQL);
      paramVarArgs.aM(5, this.pQM);
      AppMethodBeat.o(114019);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.pQI);
      int j = g.a.a.b.b.a.bu(3, this.pQK);
      int k = g.a.a.b.b.a.bu(4, this.pQL);
      int m = g.a.a.b.b.a.bu(5, this.pQM);
      AppMethodBeat.o(114019);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.pQI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114019);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114019);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkq localbkq = (bkq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114019);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbkq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114019);
          return 0;
        case 2: 
          localbkq.pQI.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(114019);
          return 0;
        case 3: 
          localbkq.pQK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114019);
          return 0;
        case 4: 
          localbkq.pQL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114019);
          return 0;
        }
        localbkq.pQM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(114019);
        return 0;
      }
      AppMethodBeat.o(114019);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkq
 * JD-Core Version:    0.7.0.1
 */
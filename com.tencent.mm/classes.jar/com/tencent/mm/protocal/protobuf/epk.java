package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class epk
  extends dpc
{
  public LinkedList<String> Nnj;
  public int rBL;
  public String rBM;
  
  public epk()
  {
    AppMethodBeat.i(82484);
    this.Nnj = new LinkedList();
    AppMethodBeat.o(82484);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.rBL);
      if (this.rBM != null) {
        paramVarArgs.e(3, this.rBM);
      }
      paramVarArgs.e(4, 1, this.Nnj);
      AppMethodBeat.o(82485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.rBL);
      paramInt = i;
      if (this.rBM != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.rBM);
      }
      i = g.a.a.a.c(4, 1, this.Nnj);
      AppMethodBeat.o(82485);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nnj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        epk localepk = (epk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82485);
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
            localepk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82485);
          return 0;
        case 2: 
          localepk.rBL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82485);
          return 0;
        case 3: 
          localepk.rBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82485);
          return 0;
        }
        localepk.Nnj.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(82485);
        return 0;
      }
      AppMethodBeat.o(82485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epk
 * JD-Core Version:    0.7.0.1
 */
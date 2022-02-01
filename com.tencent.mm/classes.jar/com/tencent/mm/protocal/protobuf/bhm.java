package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bhm
  extends dpc
{
  public LinkedList<com.tencent.mm.bw.b> LRZ;
  public int LSa;
  public LinkedList<Integer> LSb;
  public int Timestamp;
  
  public bhm()
  {
    AppMethodBeat.i(153147);
    this.LRZ = new LinkedList();
    this.LSb = new LinkedList();
    AppMethodBeat.o(153147);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153148);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153148);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 6, this.LRZ);
      paramVarArgs.aM(3, this.LSa);
      paramVarArgs.aM(4, this.Timestamp);
      paramVarArgs.e(5, 2, this.LSb);
      AppMethodBeat.o(153148);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label573;
      }
    }
    label573:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 6, this.LRZ);
      int j = g.a.a.b.b.a.bu(3, this.LSa);
      int k = g.a.a.b.b.a.bu(4, this.Timestamp);
      int m = g.a.a.a.c(5, 2, this.LSb);
      AppMethodBeat.o(153148);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LRZ.clear();
        this.LSb.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153148);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153148);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bhm localbhm = (bhm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153148);
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
            localbhm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153148);
          return 0;
        case 2: 
          localbhm.LRZ.add(((g.a.a.a.a)localObject1).UbS.hPo());
          AppMethodBeat.o(153148);
          return 0;
        case 3: 
          localbhm.LSa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153148);
          return 0;
        case 4: 
          localbhm.Timestamp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153148);
          return 0;
        }
        localbhm.LSb.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
        AppMethodBeat.o(153148);
        return 0;
      }
      AppMethodBeat.o(153148);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhm
 * JD-Core Version:    0.7.0.1
 */
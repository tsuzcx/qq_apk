package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dnj
  extends dpc
{
  public int LVH;
  public LinkedList<Integer> LVI;
  public LinkedList<akh> LVJ;
  public int MQC;
  
  public dnj()
  {
    AppMethodBeat.i(220724);
    this.LVJ = new LinkedList();
    this.LVI = new LinkedList();
    AppMethodBeat.o(220724);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220725);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(220725);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LVH);
      paramVarArgs.aM(3, this.MQC);
      paramVarArgs.e(4, 8, this.LVJ);
      paramVarArgs.e(5, 2, this.LVI);
      AppMethodBeat.o(220725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label653;
      }
    }
    label653:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LVH);
      int j = g.a.a.b.b.a.bu(3, this.MQC);
      int k = g.a.a.a.c(4, 8, this.LVJ);
      int m = g.a.a.a.c(5, 2, this.LVI);
      AppMethodBeat.o(220725);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LVJ.clear();
        this.LVI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(220725);
          throw paramVarArgs;
        }
        AppMethodBeat.o(220725);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dnj localdnj = (dnj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(220725);
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
            localdnj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220725);
          return 0;
        case 2: 
          localdnj.LVH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220725);
          return 0;
        case 3: 
          localdnj.MQC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(220725);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdnj.LVJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(220725);
          return 0;
        }
        localdnj.LVI.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
        AppMethodBeat.o(220725);
        return 0;
      }
      AppMethodBeat.o(220725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnj
 * JD-Core Version:    0.7.0.1
 */
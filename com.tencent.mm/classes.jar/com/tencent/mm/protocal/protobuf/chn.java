package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class chn
  extends dpc
{
  public int DJa;
  public int LUB;
  public LinkedList<chi> LUC;
  public int MmY;
  public int MmZ;
  public int Mna;
  
  public chn()
  {
    AppMethodBeat.i(89927);
    this.LUC = new LinkedList();
    AppMethodBeat.o(89927);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89928);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89928);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LUB);
      paramVarArgs.e(3, 8, this.LUC);
      paramVarArgs.aM(4, this.DJa);
      paramVarArgs.aM(5, this.MmY);
      paramVarArgs.aM(6, this.MmZ);
      paramVarArgs.aM(7, this.Mna);
      AppMethodBeat.o(89928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LUB);
      int j = g.a.a.a.c(3, 8, this.LUC);
      int k = g.a.a.b.b.a.bu(4, this.DJa);
      int m = g.a.a.b.b.a.bu(5, this.MmY);
      int n = g.a.a.b.b.a.bu(6, this.MmZ);
      int i1 = g.a.a.b.b.a.bu(7, this.Mna);
      AppMethodBeat.o(89928);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LUC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(89928);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        chn localchn = (chn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89928);
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
            localchn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 2: 
          localchn.LUB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89928);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchn.LUC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89928);
          return 0;
        case 4: 
          localchn.DJa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89928);
          return 0;
        case 5: 
          localchn.MmY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89928);
          return 0;
        case 6: 
          localchn.MmZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(89928);
          return 0;
        }
        localchn.Mna = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(89928);
        return 0;
      }
      AppMethodBeat.o(89928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chn
 * JD-Core Version:    0.7.0.1
 */
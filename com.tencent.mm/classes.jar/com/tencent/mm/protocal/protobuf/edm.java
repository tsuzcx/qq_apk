package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class edm
  extends dpc
{
  public int KCC;
  public int KZh;
  public LinkedList<eea> NdM;
  public long NdN;
  public int Ndu;
  
  public edm()
  {
    AppMethodBeat.i(118445);
    this.NdM = new LinkedList();
    AppMethodBeat.o(118445);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118446);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118446);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Ndu);
      paramVarArgs.e(3, 8, this.NdM);
      paramVarArgs.bb(4, this.NdN);
      paramVarArgs.aM(5, this.KZh);
      paramVarArgs.aM(6, this.KCC);
      AppMethodBeat.o(118446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.Ndu);
      int j = g.a.a.a.c(3, 8, this.NdM);
      int k = g.a.a.b.b.a.r(4, this.NdN);
      int m = g.a.a.b.b.a.bu(5, this.KZh);
      int n = g.a.a.b.b.a.bu(6, this.KCC);
      AppMethodBeat.o(118446);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NdM.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        edm localedm = (edm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118446);
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
            localedm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118446);
          return 0;
        case 2: 
          localedm.Ndu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118446);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eea();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eea)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localedm.NdM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118446);
          return 0;
        case 4: 
          localedm.NdN = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(118446);
          return 0;
        case 5: 
          localedm.KZh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(118446);
          return 0;
        }
        localedm.KCC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(118446);
        return 0;
      }
      AppMethodBeat.o(118446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edm
 * JD-Core Version:    0.7.0.1
 */
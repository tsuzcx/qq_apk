package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cuq
  extends cwj
{
  public int GRC;
  public LinkedList<Integer> GRD;
  public LinkedList<ahv> GRE;
  public int HFs;
  
  public cuq()
  {
    AppMethodBeat.i(196283);
    this.GRE = new LinkedList();
    this.GRD = new LinkedList();
    AppMethodBeat.o(196283);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196284);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(196284);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GRC);
      paramVarArgs.aS(3, this.HFs);
      paramVarArgs.e(4, 8, this.GRE);
      paramVarArgs.e(5, 2, this.GRD);
      AppMethodBeat.o(196284);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label653;
      }
    }
    label653:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GRC);
      int j = f.a.a.b.b.a.bz(3, this.HFs);
      int k = f.a.a.a.c(4, 8, this.GRE);
      int m = f.a.a.a.c(5, 2, this.GRD);
      AppMethodBeat.o(196284);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GRE.clear();
        this.GRD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(196284);
          throw paramVarArgs;
        }
        AppMethodBeat.o(196284);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cuq localcuq = (cuq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196284);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196284);
          return 0;
        case 2: 
          localcuq.GRC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196284);
          return 0;
        case 3: 
          localcuq.HFs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196284);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ahv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ahv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcuq.GRE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196284);
          return 0;
        }
        localcuq.GRD.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
        AppMethodBeat.o(196284);
        return 0;
      }
      AppMethodBeat.o(196284);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuq
 * JD-Core Version:    0.7.0.1
 */
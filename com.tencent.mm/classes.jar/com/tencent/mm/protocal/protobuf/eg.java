package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class eg
  extends bvk
{
  public int enabled;
  public int kWh;
  public LinkedList<kx> wqe;
  public boolean wqf;
  public int wqg;
  
  public eg()
  {
    AppMethodBeat.i(14687);
    this.wqe = new LinkedList();
    AppMethodBeat.o(14687);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14688);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(14688);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wqe);
      paramVarArgs.aS(3, this.wqf);
      paramVarArgs.aO(4, this.wqg);
      paramVarArgs.aO(5, this.enabled);
      paramVarArgs.aO(6, this.kWh);
      AppMethodBeat.o(14688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.wqe);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.bl(4, this.wqg);
      int m = e.a.a.b.b.a.bl(5, this.enabled);
      int n = e.a.a.b.b.a.bl(6, this.kWh);
      AppMethodBeat.o(14688);
      return paramInt + i + (j + 1) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wqe.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(14688);
          throw paramVarArgs;
        }
        AppMethodBeat.o(14688);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        eg localeg = (eg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(14688);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localeg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14688);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new kx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((kx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localeg.wqe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14688);
          return 0;
        case 3: 
          localeg.wqf = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(14688);
          return 0;
        case 4: 
          localeg.wqg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14688);
          return 0;
        case 5: 
          localeg.enabled = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14688);
          return 0;
        }
        localeg.kWh = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14688);
        return 0;
      }
      AppMethodBeat.o(14688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eg
 * JD-Core Version:    0.7.0.1
 */
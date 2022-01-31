package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class azw
  extends bvk
{
  public int rfp;
  public int xaS;
  public LinkedList<azr> xaT;
  public int xpr;
  public int xps;
  public int xpt;
  
  public azw()
  {
    AppMethodBeat.i(55528);
    this.xaT = new LinkedList();
    AppMethodBeat.o(55528);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55529);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(55529);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xaS);
      paramVarArgs.e(3, 8, this.xaT);
      paramVarArgs.aO(4, this.rfp);
      paramVarArgs.aO(5, this.xpr);
      paramVarArgs.aO(6, this.xps);
      paramVarArgs.aO(7, this.xpt);
      AppMethodBeat.o(55529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xaS);
      int j = e.a.a.a.c(3, 8, this.xaT);
      int k = e.a.a.b.b.a.bl(4, this.rfp);
      int m = e.a.a.b.b.a.bl(5, this.xpr);
      int n = e.a.a.b.b.a.bl(6, this.xps);
      int i1 = e.a.a.b.b.a.bl(7, this.xpt);
      AppMethodBeat.o(55529);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xaT.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(55529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(55529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        azw localazw = (azw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(55529);
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
            localazw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55529);
          return 0;
        case 2: 
          localazw.xaS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55529);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazw.xaT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55529);
          return 0;
        case 4: 
          localazw.rfp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55529);
          return 0;
        case 5: 
          localazw.xpr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55529);
          return 0;
        case 6: 
          localazw.xps = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55529);
          return 0;
        }
        localazw.xpt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(55529);
        return 0;
      }
      AppMethodBeat.o(55529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azw
 * JD-Core Version:    0.7.0.1
 */
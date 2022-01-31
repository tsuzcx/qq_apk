package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cgl
  extends bvk
{
  public int pIE;
  public long pIG;
  public int xRl;
  public LinkedList<rb> xRm;
  
  public cgl()
  {
    AppMethodBeat.i(80193);
    this.xRm = new LinkedList();
    AppMethodBeat.o(80193);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80194);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80194);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIE);
      paramVarArgs.am(3, this.pIG);
      paramVarArgs.aO(4, this.xRl);
      paramVarArgs.e(5, 8, this.xRm);
      AppMethodBeat.o(80194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.pIE);
      int j = e.a.a.b.b.a.p(3, this.pIG);
      int k = e.a.a.b.b.a.bl(4, this.xRl);
      int m = e.a.a.a.c(5, 8, this.xRm);
      AppMethodBeat.o(80194);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xRm.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(80194);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cgl localcgl = (cgl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80194);
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
            localcgl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80194);
          return 0;
        case 2: 
          localcgl.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80194);
          return 0;
        case 3: 
          localcgl.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(80194);
          return 0;
        case 4: 
          localcgl.xRl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80194);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rb();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcgl.xRm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80194);
        return 0;
      }
      AppMethodBeat.o(80194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgl
 * JD-Core Version:    0.7.0.1
 */
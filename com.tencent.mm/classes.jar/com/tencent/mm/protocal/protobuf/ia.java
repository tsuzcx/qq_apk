package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ia
  extends bvk
{
  public int fKi;
  public LinkedList<String> wsV;
  public int wux;
  public LinkedList<zg> wuz;
  
  public ia()
  {
    AppMethodBeat.i(62521);
    this.wsV = new LinkedList();
    this.wuz = new LinkedList();
    AppMethodBeat.o(62521);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62522);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(62522);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wux);
      paramVarArgs.e(3, 1, this.wsV);
      paramVarArgs.aO(4, this.fKi);
      paramVarArgs.e(5, 8, this.wuz);
      AppMethodBeat.o(62522);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wux);
      int j = e.a.a.a.c(3, 1, this.wsV);
      int k = e.a.a.b.b.a.bl(4, this.fKi);
      int m = e.a.a.a.c(5, 8, this.wuz);
      AppMethodBeat.o(62522);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wsV.clear();
        this.wuz.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(62522);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62522);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ia localia = (ia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62522);
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
            localia.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62522);
          return 0;
        case 2: 
          localia.wux = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62522);
          return 0;
        case 3: 
          localia.wsV.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(62522);
          return 0;
        case 4: 
          localia.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62522);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localia.wuz.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(62522);
        return 0;
      }
      AppMethodBeat.o(62522);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ia
 * JD-Core Version:    0.7.0.1
 */
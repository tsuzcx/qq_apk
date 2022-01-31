package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class amu
  extends bvk
{
  public int woE;
  public int xdt;
  public LinkedList<bhi> xdu;
  public String xdv;
  public int xdw;
  
  public amu()
  {
    AppMethodBeat.i(28450);
    this.xdu = new LinkedList();
    AppMethodBeat.o(28450);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28451);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28451);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xdt);
      paramVarArgs.e(3, 8, this.xdu);
      if (this.xdv != null) {
        paramVarArgs.e(4, this.xdv);
      }
      paramVarArgs.aO(5, this.woE);
      paramVarArgs.aO(6, this.xdw);
      AppMethodBeat.o(28451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xdt) + e.a.a.a.c(3, 8, this.xdu);
      paramInt = i;
      if (this.xdv != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xdv);
      }
      i = e.a.a.b.b.a.bl(5, this.woE);
      int j = e.a.a.b.b.a.bl(6, this.xdw);
      AppMethodBeat.o(28451);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xdu.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28451);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        amu localamu = (amu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28451);
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
            localamu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28451);
          return 0;
        case 2: 
          localamu.xdt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28451);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamu.xdu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28451);
          return 0;
        case 4: 
          localamu.xdv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28451);
          return 0;
        case 5: 
          localamu.woE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28451);
          return 0;
        }
        localamu.xdw = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28451);
        return 0;
      }
      AppMethodBeat.o(28451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amu
 * JD-Core Version:    0.7.0.1
 */
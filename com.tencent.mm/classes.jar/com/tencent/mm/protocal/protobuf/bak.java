package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bak
  extends bvk
{
  public String wQf;
  public int xpA;
  public LinkedList<bai> xpC;
  public LinkedList<bai> xpD;
  public int xpy;
  
  public bak()
  {
    AppMethodBeat.i(73735);
    this.xpC = new LinkedList();
    this.xpD = new LinkedList();
    AppMethodBeat.o(73735);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73736);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(73736);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wQf != null) {
        paramVarArgs.e(2, this.wQf);
      }
      paramVarArgs.aO(3, this.xpy);
      paramVarArgs.e(4, 8, this.xpC);
      paramVarArgs.aO(5, this.xpA);
      paramVarArgs.e(6, 8, this.xpD);
      AppMethodBeat.o(73736);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wQf != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wQf);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.xpy);
      int j = e.a.a.a.c(4, 8, this.xpC);
      int k = e.a.a.b.b.a.bl(5, this.xpA);
      int m = e.a.a.a.c(6, 8, this.xpD);
      AppMethodBeat.o(73736);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xpC.clear();
        this.xpD.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(73736);
          throw paramVarArgs;
        }
        AppMethodBeat.o(73736);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bak localbak = (bak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73736);
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
            localbak.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73736);
          return 0;
        case 2: 
          localbak.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73736);
          return 0;
        case 3: 
          localbak.xpy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73736);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bai();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bai)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbak.xpC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73736);
          return 0;
        case 5: 
          localbak.xpA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73736);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bai();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bai)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbak.xpD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73736);
        return 0;
      }
      AppMethodBeat.o(73736);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bak
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.a.c;
import java.util.LinkedList;

public final class amd
  extends bvk
{
  public int koj;
  public String kok;
  public c ukr;
  public String wZi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56817);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      if (this.ukr != null)
      {
        paramVarArgs.iQ(4, this.ukr.computeSize());
        this.ukr.writeFields(paramVarArgs);
      }
      if (this.wZi != null) {
        paramVarArgs.e(5, this.wZi);
      }
      AppMethodBeat.o(56817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.ukr != null) {
        i = paramInt + e.a.a.a.iP(4, this.ukr.computeSize());
      }
      paramInt = i;
      if (this.wZi != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wZi);
      }
      AppMethodBeat.o(56817);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        amd localamd = (amd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56817);
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
            localamd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56817);
          return 0;
        case 2: 
          localamd.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56817);
          return 0;
        case 3: 
          localamd.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56817);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamd.ukr = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56817);
          return 0;
        }
        localamd.wZi = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56817);
        return 0;
      }
      AppMethodBeat.o(56817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amd
 * JD-Core Version:    0.7.0.1
 */
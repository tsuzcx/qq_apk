package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cnu
  extends bvk
{
  public int CreateTime;
  public String fKw;
  public String fKz;
  public String jJA;
  public int pIx;
  public int pIy;
  public int pIz;
  public String xWD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28688);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28688);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      if (this.fKz != null) {
        paramVarArgs.e(3, this.fKz);
      }
      if (this.xWD != null) {
        paramVarArgs.e(4, this.xWD);
      }
      if (this.jJA != null) {
        paramVarArgs.e(5, this.jJA);
      }
      paramVarArgs.aO(6, this.pIx);
      paramVarArgs.aO(7, this.pIy);
      paramVarArgs.aO(8, this.pIz);
      paramVarArgs.aO(9, this.CreateTime);
      AppMethodBeat.o(28688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label805;
      }
    }
    label805:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt;
      if (this.fKz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.fKz);
      }
      paramInt = i;
      if (this.xWD != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xWD);
      }
      i = paramInt;
      if (this.jJA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jJA);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.pIx);
      int j = e.a.a.b.b.a.bl(7, this.pIy);
      int k = e.a.a.b.b.a.bl(8, this.pIz);
      int m = e.a.a.b.b.a.bl(9, this.CreateTime);
      AppMethodBeat.o(28688);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28688);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28688);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cnu localcnu = (cnu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28688);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcnu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28688);
          return 0;
        case 2: 
          localcnu.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28688);
          return 0;
        case 3: 
          localcnu.fKz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28688);
          return 0;
        case 4: 
          localcnu.xWD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28688);
          return 0;
        case 5: 
          localcnu.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28688);
          return 0;
        case 6: 
          localcnu.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28688);
          return 0;
        case 7: 
          localcnu.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28688);
          return 0;
        case 8: 
          localcnu.pIz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28688);
          return 0;
        }
        localcnu.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28688);
        return 0;
      }
      AppMethodBeat.o(28688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnu
 * JD-Core Version:    0.7.0.1
 */
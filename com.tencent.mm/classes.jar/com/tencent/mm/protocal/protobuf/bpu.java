package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bpu
  extends bvk
{
  public int koj;
  public String kok;
  public String tNy;
  public int xDH;
  public String xDI;
  public String xDJ;
  public atv xDK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56939);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56939);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      paramVarArgs.aO(4, this.xDH);
      if (this.xDI != null) {
        paramVarArgs.e(5, this.xDI);
      }
      if (this.xDJ != null) {
        paramVarArgs.e(6, this.xDJ);
      }
      if (this.xDK != null)
      {
        paramVarArgs.iQ(7, this.xDK.computeSize());
        this.xDK.writeFields(paramVarArgs);
      }
      if (this.tNy != null) {
        paramVarArgs.e(100, this.tNy);
      }
      AppMethodBeat.o(56939);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xDH);
      paramInt = i;
      if (this.xDI != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xDI);
      }
      i = paramInt;
      if (this.xDJ != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xDJ);
      }
      paramInt = i;
      if (this.xDK != null) {
        paramInt = i + e.a.a.a.iP(7, this.xDK.computeSize());
      }
      i = paramInt;
      if (this.tNy != null) {
        i = paramInt + e.a.a.b.b.a.f(100, this.tNy);
      }
      AppMethodBeat.o(56939);
      return i;
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
          AppMethodBeat.o(56939);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56939);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bpu localbpu = (bpu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56939);
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
            localbpu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56939);
          return 0;
        case 2: 
          localbpu.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56939);
          return 0;
        case 3: 
          localbpu.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56939);
          return 0;
        case 4: 
          localbpu.xDH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56939);
          return 0;
        case 5: 
          localbpu.xDI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56939);
          return 0;
        case 6: 
          localbpu.xDJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56939);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpu.xDK = ((atv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56939);
          return 0;
        }
        localbpu.tNy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56939);
        return 0;
      }
      AppMethodBeat.o(56939);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpu
 * JD-Core Version:    0.7.0.1
 */
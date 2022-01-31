package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aif
  extends bvk
{
  public int koj;
  public String kok;
  public on wZZ;
  public int xaa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89083);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89083);
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
      if (this.wZZ != null)
      {
        paramVarArgs.iQ(4, this.wZZ.computeSize());
        this.wZZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.xaa);
      AppMethodBeat.o(89083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.wZZ != null) {
        i = paramInt + e.a.a.a.iP(4, this.wZZ.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(5, this.xaa);
      AppMethodBeat.o(89083);
      return i + paramInt;
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
          AppMethodBeat.o(89083);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89083);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aif localaif = (aif)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89083);
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
            localaif.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89083);
          return 0;
        case 2: 
          localaif.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89083);
          return 0;
        case 3: 
          localaif.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89083);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new on();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((on)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaif.wZZ = ((on)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89083);
          return 0;
        }
        localaif.xaa = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(89083);
        return 0;
      }
      AppMethodBeat.o(89083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aif
 * JD-Core Version:    0.7.0.1
 */
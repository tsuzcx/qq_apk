package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cow
  extends bvk
{
  public int pIE;
  public long pIG;
  public String wDo;
  public String wpS;
  public int xXz;
  public int xrE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51009);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(51009);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wpS != null) {
        paramVarArgs.e(2, this.wpS);
      }
      paramVarArgs.aO(3, this.pIE);
      paramVarArgs.aO(4, this.xrE);
      paramVarArgs.aO(5, this.xXz);
      paramVarArgs.am(6, this.pIG);
      if (this.wDo != null) {
        paramVarArgs.e(7, this.wDo);
      }
      AppMethodBeat.o(51009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wpS != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wpS);
      }
      i = i + e.a.a.b.b.a.bl(3, this.pIE) + e.a.a.b.b.a.bl(4, this.xrE) + e.a.a.b.b.a.bl(5, this.xXz) + e.a.a.b.b.a.p(6, this.pIG);
      paramInt = i;
      if (this.wDo != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wDo);
      }
      AppMethodBeat.o(51009);
      return paramInt;
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
          AppMethodBeat.o(51009);
          throw paramVarArgs;
        }
        AppMethodBeat.o(51009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cow localcow = (cow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(51009);
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
            localcow.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(51009);
          return 0;
        case 2: 
          localcow.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51009);
          return 0;
        case 3: 
          localcow.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51009);
          return 0;
        case 4: 
          localcow.xrE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51009);
          return 0;
        case 5: 
          localcow.xXz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51009);
          return 0;
        case 6: 
          localcow.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(51009);
          return 0;
        }
        localcow.wDo = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(51009);
        return 0;
      }
      AppMethodBeat.o(51009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cow
 * JD-Core Version:    0.7.0.1
 */
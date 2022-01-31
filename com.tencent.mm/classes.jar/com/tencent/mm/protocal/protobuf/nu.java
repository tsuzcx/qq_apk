package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class nu
  extends bvk
{
  public int CreateTime;
  public String nul;
  public String num;
  public long pIG;
  public String wDd;
  public String wDo;
  public String wDs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80032);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80032);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wDd != null) {
        paramVarArgs.e(3, this.wDd);
      }
      if (this.num != null) {
        paramVarArgs.e(4, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(5, this.nul);
      }
      paramVarArgs.aO(9, this.CreateTime);
      paramVarArgs.am(10, this.pIG);
      if (this.wDo != null) {
        paramVarArgs.e(11, this.wDo);
      }
      if (this.wDs != null) {
        paramVarArgs.e(12, this.wDs);
      }
      AppMethodBeat.o(80032);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wDd != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wDd);
      }
      i = paramInt;
      if (this.num != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.num);
      }
      paramInt = i;
      if (this.nul != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.nul);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.CreateTime) + e.a.a.b.b.a.p(10, this.pIG);
      paramInt = i;
      if (this.wDo != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wDo);
      }
      i = paramInt;
      if (this.wDs != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.wDs);
      }
      AppMethodBeat.o(80032);
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
          AppMethodBeat.o(80032);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80032);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        nu localnu = (nu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(80032);
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
            localnu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80032);
          return 0;
        case 3: 
          localnu.wDd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80032);
          return 0;
        case 4: 
          localnu.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80032);
          return 0;
        case 5: 
          localnu.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80032);
          return 0;
        case 9: 
          localnu.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80032);
          return 0;
        case 10: 
          localnu.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(80032);
          return 0;
        case 11: 
          localnu.wDo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80032);
          return 0;
        }
        localnu.wDs = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80032);
        return 0;
      }
      AppMethodBeat.o(80032);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nu
 * JD-Core Version:    0.7.0.1
 */
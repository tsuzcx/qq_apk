package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class sd
  extends bvk
{
  public String wKq;
  public String wKr;
  public int wKy;
  public long wKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28358);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28358);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wKy);
      if (this.wKq != null) {
        paramVarArgs.e(3, this.wKq);
      }
      if (this.wKr != null) {
        paramVarArgs.e(4, this.wKr);
      }
      paramVarArgs.am(5, this.wKz);
      AppMethodBeat.o(28358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label581;
      }
    }
    label581:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wKy);
      paramInt = i;
      if (this.wKq != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wKq);
      }
      i = paramInt;
      if (this.wKr != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wKr);
      }
      paramInt = e.a.a.b.b.a.p(5, this.wKz);
      AppMethodBeat.o(28358);
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
          AppMethodBeat.o(28358);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28358);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        sd localsd = (sd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28358);
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
            localsd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28358);
          return 0;
        case 2: 
          localsd.wKy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28358);
          return 0;
        case 3: 
          localsd.wKq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28358);
          return 0;
        case 4: 
          localsd.wKr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28358);
          return 0;
        }
        localsd.wKz = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(28358);
        return 0;
      }
      AppMethodBeat.o(28358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sd
 * JD-Core Version:    0.7.0.1
 */
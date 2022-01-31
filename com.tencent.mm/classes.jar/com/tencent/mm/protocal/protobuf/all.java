package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class all
  extends bvk
{
  public String wxa;
  public String xcj;
  public String xck;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28438);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28438);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xcj != null) {
        paramVarArgs.e(2, this.xcj);
      }
      if (this.xck != null) {
        paramVarArgs.e(3, this.xck);
      }
      if (this.wxa != null) {
        paramVarArgs.e(4, this.wxa);
      }
      AppMethodBeat.o(28438);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label552;
      }
    }
    label552:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xcj != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xcj);
      }
      i = paramInt;
      if (this.xck != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xck);
      }
      paramInt = i;
      if (this.wxa != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wxa);
      }
      AppMethodBeat.o(28438);
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
          AppMethodBeat.o(28438);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28438);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        all localall = (all)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28438);
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
            localall.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28438);
          return 0;
        case 2: 
          localall.xcj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28438);
          return 0;
        case 3: 
          localall.xck = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28438);
          return 0;
        }
        localall.wxa = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28438);
        return 0;
      }
      AppMethodBeat.o(28438);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.all
 * JD-Core Version:    0.7.0.1
 */
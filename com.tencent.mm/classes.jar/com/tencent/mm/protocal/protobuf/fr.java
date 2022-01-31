package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class fr
  extends bvk
{
  public String npZ;
  public String wrH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62510);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(62510);
        throw paramVarArgs;
      }
      if (this.wrH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqKey");
        AppMethodBeat.o(62510);
        throw paramVarArgs;
      }
      if (this.npZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(62510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wrH != null) {
        paramVarArgs.e(2, this.wrH);
      }
      if (this.npZ != null) {
        paramVarArgs.e(3, this.npZ);
      }
      AppMethodBeat.o(62510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label574;
      }
    }
    label574:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wrH != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wrH);
      }
      i = paramInt;
      if (this.npZ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npZ);
      }
      AppMethodBeat.o(62510);
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
          AppMethodBeat.o(62510);
          throw paramVarArgs;
        }
        if (this.wrH == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqKey");
          AppMethodBeat.o(62510);
          throw paramVarArgs;
        }
        if (this.npZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(62510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        fr localfr = (fr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62510);
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
            localfr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62510);
          return 0;
        case 2: 
          localfr.wrH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62510);
          return 0;
        }
        localfr.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(62510);
        return 0;
      }
      AppMethodBeat.o(62510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fr
 * JD-Core Version:    0.7.0.1
 */
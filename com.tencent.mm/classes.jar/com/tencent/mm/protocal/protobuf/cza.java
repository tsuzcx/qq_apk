package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cza
  extends cwj
{
  public SKBuiltinBuffer_t GQI;
  public long GQL;
  public String HIZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104835);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104835);
        throw paramVarArgs;
      }
      if (this.HIZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchResult");
        AppMethodBeat.o(104835);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HIZ != null) {
        paramVarArgs.d(2, this.HIZ);
      }
      if (this.GQI != null)
      {
        paramVarArgs.lJ(3, this.GQI.computeSize());
        this.GQI.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(4, this.GQL);
      AppMethodBeat.o(104835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label666;
      }
    }
    label666:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HIZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HIZ);
      }
      i = paramInt;
      if (this.GQI != null) {
        i = paramInt + f.a.a.a.lI(3, this.GQI.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(4, this.GQL);
      AppMethodBeat.o(104835);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104835);
          throw paramVarArgs;
        }
        if (this.HIZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: SearchResult");
          AppMethodBeat.o(104835);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cza localcza = (cza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104835);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcza.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104835);
          return 0;
        case 2: 
          localcza.HIZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104835);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcza.GQI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104835);
          return 0;
        }
        localcza.GQL = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(104835);
        return 0;
      }
      AppMethodBeat.o(104835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cza
 * JD-Core Version:    0.7.0.1
 */
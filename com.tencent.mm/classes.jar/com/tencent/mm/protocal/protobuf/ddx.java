package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ddx
  extends cwj
{
  public SKBuiltinBuffer_t FTj;
  public int HLx;
  public int HLz;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32447);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32447);
        throw paramVarArgs;
      }
      if (this.FTj == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32447);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FTj != null)
      {
        paramVarArgs.lJ(2, this.FTj.computeSize());
        this.FTj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Ret);
      paramVarArgs.aS(4, this.HLx);
      paramVarArgs.aS(5, this.HLz);
      AppMethodBeat.o(32447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label713;
      }
    }
    label713:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FTj != null) {
        i = paramInt + f.a.a.a.lI(2, this.FTj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Ret);
      int j = f.a.a.b.b.a.bz(4, this.HLx);
      int k = f.a.a.b.b.a.bz(5, this.HLz);
      AppMethodBeat.o(32447);
      return i + paramInt + j + k;
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
          AppMethodBeat.o(32447);
          throw paramVarArgs;
        }
        if (this.FTj == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(32447);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32447);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddx localddx = (ddx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32447);
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
            localddx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32447);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddx.FTj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32447);
          return 0;
        case 3: 
          localddx.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32447);
          return 0;
        case 4: 
          localddx.HLx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32447);
          return 0;
        }
        localddx.HLz = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32447);
        return 0;
      }
      AppMethodBeat.o(32447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddx
 * JD-Core Version:    0.7.0.1
 */
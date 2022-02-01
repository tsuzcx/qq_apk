package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbn
  extends cwj
{
  public String GRl;
  public int GRv;
  public int gxu;
  public String msg;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(108146);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ret);
      if (this.msg != null) {
        paramVarArgs.d(3, this.msg);
      }
      if (this.GRl != null) {
        paramVarArgs.d(4, this.GRl);
      }
      paramVarArgs.aS(5, this.GRv);
      paramVarArgs.aS(6, this.gxu);
      AppMethodBeat.o(108146);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ret);
      paramInt = i;
      if (this.msg != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.msg);
      }
      i = paramInt;
      if (this.GRl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GRl);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.GRv);
      int j = f.a.a.b.b.a.bz(6, this.gxu);
      AppMethodBeat.o(108146);
      return i + paramInt + j;
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
          AppMethodBeat.o(108146);
          throw paramVarArgs;
        }
        AppMethodBeat.o(108146);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbn localbbn = (bbn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(108146);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108146);
          return 0;
        case 2: 
          localbbn.ret = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(108146);
          return 0;
        case 3: 
          localbbn.msg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108146);
          return 0;
        case 4: 
          localbbn.GRl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(108146);
          return 0;
        case 5: 
          localbbn.GRv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(108146);
          return 0;
        }
        localbbn.gxu = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(108146);
        return 0;
      }
      AppMethodBeat.o(108146);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbn
 * JD-Core Version:    0.7.0.1
 */
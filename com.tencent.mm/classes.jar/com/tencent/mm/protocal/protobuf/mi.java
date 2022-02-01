package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class mi
  extends cwj
{
  public int FTU;
  public String FXS;
  public long FXv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(188918);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FXS != null) {
        paramVarArgs.d(2, this.FXS);
      }
      paramVarArgs.aZ(11, this.FXv);
      paramVarArgs.aS(15, this.FTU);
      AppMethodBeat.o(188918);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FXS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FXS);
      }
      paramInt = f.a.a.b.b.a.p(11, this.FXv);
      int j = f.a.a.b.b.a.bz(15, this.FTU);
      AppMethodBeat.o(188918);
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
          AppMethodBeat.o(188918);
          throw paramVarArgs;
        }
        AppMethodBeat.o(188918);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mi localmi = (mi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(188918);
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
            localmi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188918);
          return 0;
        case 2: 
          localmi.FXS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188918);
          return 0;
        case 11: 
          localmi.FXv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(188918);
          return 0;
        }
        localmi.FTU = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(188918);
        return 0;
      }
      AppMethodBeat.o(188918);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mi
 * JD-Core Version:    0.7.0.1
 */
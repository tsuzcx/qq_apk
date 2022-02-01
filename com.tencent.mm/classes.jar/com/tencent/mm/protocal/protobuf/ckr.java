package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ckr
  extends cwj
{
  public String FNt;
  public String GMp;
  public String GMq;
  public String qkR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91607);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91607);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GMp != null) {
        paramVarArgs.d(2, this.GMp);
      }
      if (this.GMq != null) {
        paramVarArgs.d(3, this.GMq);
      }
      if (this.FNt != null) {
        paramVarArgs.d(4, this.FNt);
      }
      if (this.qkR != null) {
        paramVarArgs.d(5, this.qkR);
      }
      AppMethodBeat.o(91607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GMp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GMp);
      }
      i = paramInt;
      if (this.GMq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GMq);
      }
      paramInt = i;
      if (this.FNt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FNt);
      }
      i = paramInt;
      if (this.qkR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.qkR);
      }
      AppMethodBeat.o(91607);
      return i;
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
          AppMethodBeat.o(91607);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ckr localckr = (ckr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91607);
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
            localckr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91607);
          return 0;
        case 2: 
          localckr.GMp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91607);
          return 0;
        case 3: 
          localckr.GMq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91607);
          return 0;
        case 4: 
          localckr.FNt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91607);
          return 0;
        }
        localckr.qkR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91607);
        return 0;
      }
      AppMethodBeat.o(91607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckr
 * JD-Core Version:    0.7.0.1
 */
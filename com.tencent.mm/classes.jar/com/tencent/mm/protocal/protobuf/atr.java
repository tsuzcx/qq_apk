package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class atr
  extends cwj
{
  public int GKB;
  public String GKC;
  public String GKD;
  public int GKE;
  public String GKF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91467);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91467);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GKB);
      if (this.GKC != null) {
        paramVarArgs.d(3, this.GKC);
      }
      if (this.GKD != null) {
        paramVarArgs.d(4, this.GKD);
      }
      paramVarArgs.aS(5, this.GKE);
      if (this.GKF != null) {
        paramVarArgs.d(6, this.GKF);
      }
      AppMethodBeat.o(91467);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GKB);
      paramInt = i;
      if (this.GKC != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GKC);
      }
      i = paramInt;
      if (this.GKD != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GKD);
      }
      i += f.a.a.b.b.a.bz(5, this.GKE);
      paramInt = i;
      if (this.GKF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKF);
      }
      AppMethodBeat.o(91467);
      return paramInt;
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
          AppMethodBeat.o(91467);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91467);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        atr localatr = (atr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91467);
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
            localatr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91467);
          return 0;
        case 2: 
          localatr.GKB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91467);
          return 0;
        case 3: 
          localatr.GKC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91467);
          return 0;
        case 4: 
          localatr.GKD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91467);
          return 0;
        case 5: 
          localatr.GKE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91467);
          return 0;
        }
        localatr.GKF = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91467);
        return 0;
      }
      AppMethodBeat.o(91467);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atr
 * JD-Core Version:    0.7.0.1
 */
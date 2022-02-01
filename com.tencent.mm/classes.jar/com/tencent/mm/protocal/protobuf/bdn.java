package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bdn
  extends cwj
{
  public int GKB;
  public String GKC;
  public String GKD;
  public int GKE;
  public String GKF;
  public String GSR;
  public String GSS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91490);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91490);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GSR != null) {
        paramVarArgs.d(2, this.GSR);
      }
      paramVarArgs.aS(3, this.GKB);
      if (this.GKC != null) {
        paramVarArgs.d(4, this.GKC);
      }
      if (this.GKD != null) {
        paramVarArgs.d(5, this.GKD);
      }
      paramVarArgs.aS(6, this.GKE);
      if (this.GKF != null) {
        paramVarArgs.d(7, this.GKF);
      }
      if (this.GSS != null) {
        paramVarArgs.d(8, this.GSS);
      }
      AppMethodBeat.o(91490);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GSR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GSR);
      }
      i += f.a.a.b.b.a.bz(3, this.GKB);
      paramInt = i;
      if (this.GKC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GKC);
      }
      i = paramInt;
      if (this.GKD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GKD);
      }
      i += f.a.a.b.b.a.bz(6, this.GKE);
      paramInt = i;
      if (this.GKF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GKF);
      }
      i = paramInt;
      if (this.GSS != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GSS);
      }
      AppMethodBeat.o(91490);
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
          AppMethodBeat.o(91490);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91490);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdn localbdn = (bdn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91490);
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
            localbdn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91490);
          return 0;
        case 2: 
          localbdn.GSR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 3: 
          localbdn.GKB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91490);
          return 0;
        case 4: 
          localbdn.GKC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 5: 
          localbdn.GKD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91490);
          return 0;
        case 6: 
          localbdn.GKE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91490);
          return 0;
        case 7: 
          localbdn.GKF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91490);
          return 0;
        }
        localbdn.GSS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91490);
        return 0;
      }
      AppMethodBeat.o(91490);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdn
 * JD-Core Version:    0.7.0.1
 */
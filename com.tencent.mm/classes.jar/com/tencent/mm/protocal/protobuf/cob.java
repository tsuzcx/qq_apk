package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cob
  extends cwj
{
  public int Gxq;
  public long Gxr;
  public int HzU;
  public int HzW;
  public int HzX;
  public int qkQ;
  public String qkR;
  public int uXA;
  public int uXl;
  public String uXm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32391);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32391);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Gxq);
      paramVarArgs.aZ(4, this.Gxr);
      paramVarArgs.aS(5, this.HzW);
      paramVarArgs.aS(6, this.HzU);
      paramVarArgs.aS(7, this.uXA);
      paramVarArgs.aS(8, this.HzX);
      paramVarArgs.aS(9, this.qkQ);
      if (this.qkR != null) {
        paramVarArgs.d(10, this.qkR);
      }
      paramVarArgs.aS(11, this.uXl);
      if (this.uXm != null) {
        paramVarArgs.d(12, this.uXm);
      }
      AppMethodBeat.o(32391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label855;
      }
    }
    label855:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(3, this.Gxq) + f.a.a.b.b.a.p(4, this.Gxr) + f.a.a.b.b.a.bz(5, this.HzW) + f.a.a.b.b.a.bz(6, this.HzU) + f.a.a.b.b.a.bz(7, this.uXA) + f.a.a.b.b.a.bz(8, this.HzX) + f.a.a.b.b.a.bz(9, this.qkQ);
      paramInt = i;
      if (this.qkR != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qkR);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.uXl);
      paramInt = i;
      if (this.uXm != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uXm);
      }
      AppMethodBeat.o(32391);
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
          AppMethodBeat.o(32391);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32391);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cob localcob = (cob)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(32391);
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
            localcob.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32391);
          return 0;
        case 3: 
          localcob.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 4: 
          localcob.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(32391);
          return 0;
        case 5: 
          localcob.HzW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 6: 
          localcob.HzU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 7: 
          localcob.uXA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 8: 
          localcob.HzX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 9: 
          localcob.qkQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32391);
          return 0;
        case 10: 
          localcob.qkR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32391);
          return 0;
        case 11: 
          localcob.uXl = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32391);
          return 0;
        }
        localcob.uXm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32391);
        return 0;
      }
      AppMethodBeat.o(32391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cob
 * JD-Core Version:    0.7.0.1
 */
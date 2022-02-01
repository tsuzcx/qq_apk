package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dke
  extends cwj
{
  public int FJk;
  public String HNx;
  public int HOS;
  public long HRJ;
  public int HRV;
  public LinkedList<dkc> HRW;
  
  public dke()
  {
    AppMethodBeat.i(118450);
    this.HRW = new LinkedList();
    AppMethodBeat.o(118450);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118451);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HNx != null) {
        paramVarArgs.d(2, this.HNx);
      }
      paramVarArgs.aS(3, this.HRV);
      paramVarArgs.e(4, 8, this.HRW);
      paramVarArgs.aS(5, this.HOS);
      paramVarArgs.aZ(6, this.HRJ);
      paramVarArgs.aS(7, this.FJk);
      AppMethodBeat.o(118451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HNx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HNx);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HRV);
      int j = f.a.a.a.c(4, 8, this.HRW);
      int k = f.a.a.b.b.a.bz(5, this.HOS);
      int m = f.a.a.b.b.a.p(6, this.HRJ);
      int n = f.a.a.b.b.a.bz(7, this.FJk);
      AppMethodBeat.o(118451);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HRW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118451);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dke localdke = (dke)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118451);
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
            localdke.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 2: 
          localdke.HNx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118451);
          return 0;
        case 3: 
          localdke.HRV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118451);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdke.HRW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 5: 
          localdke.HOS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118451);
          return 0;
        case 6: 
          localdke.HRJ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(118451);
          return 0;
        }
        localdke.FJk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118451);
        return 0;
      }
      AppMethodBeat.o(118451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dke
 * JD-Core Version:    0.7.0.1
 */
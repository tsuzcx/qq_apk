package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dla
  extends cwj
{
  public int FJk;
  public String HNx;
  public int HOS;
  public long HRJ;
  public int HSE;
  public LinkedList<dkn> HSF;
  public int HSG;
  public int HSH;
  
  public dla()
  {
    AppMethodBeat.i(118477);
    this.HSF = new LinkedList();
    AppMethodBeat.o(118477);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118478);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118478);
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
      paramVarArgs.aS(3, this.HSE);
      paramVarArgs.e(4, 8, this.HSF);
      paramVarArgs.aS(5, this.HSG);
      paramVarArgs.aS(6, this.HSH);
      paramVarArgs.aS(7, this.HOS);
      paramVarArgs.aZ(8, this.HRJ);
      paramVarArgs.aS(9, this.FJk);
      AppMethodBeat.o(118478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HNx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HNx);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HSE);
      int j = f.a.a.a.c(4, 8, this.HSF);
      int k = f.a.a.b.b.a.bz(5, this.HSG);
      int m = f.a.a.b.b.a.bz(6, this.HSH);
      int n = f.a.a.b.b.a.bz(7, this.HOS);
      int i1 = f.a.a.b.b.a.p(8, this.HRJ);
      int i2 = f.a.a.b.b.a.bz(9, this.FJk);
      AppMethodBeat.o(118478);
      return i + paramInt + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HSF.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118478);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dla localdla = (dla)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118478);
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
            localdla.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 2: 
          localdla.HNx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118478);
          return 0;
        case 3: 
          localdla.HSE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118478);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdla.HSF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118478);
          return 0;
        case 5: 
          localdla.HSG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118478);
          return 0;
        case 6: 
          localdla.HSH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118478);
          return 0;
        case 7: 
          localdla.HOS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118478);
          return 0;
        case 8: 
          localdla.HRJ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(118478);
          return 0;
        }
        localdla.FJk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118478);
        return 0;
      }
      AppMethodBeat.o(118478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dla
 * JD-Core Version:    0.7.0.1
 */
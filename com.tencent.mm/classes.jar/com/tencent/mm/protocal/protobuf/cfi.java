package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cfi
  extends cwj
{
  public String FVL;
  public cls FVM;
  public cgv FVN;
  public String HrS;
  public String HrZ;
  public bqn Hsa;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72531);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      if (this.HrS != null) {
        paramVarArgs.d(4, this.HrS);
      }
      if (this.FVL != null) {
        paramVarArgs.d(5, this.FVL);
      }
      if (this.HrZ != null) {
        paramVarArgs.d(6, this.HrZ);
      }
      if (this.FVM != null)
      {
        paramVarArgs.lJ(7, this.FVM.computeSize());
        this.FVM.writeFields(paramVarArgs);
      }
      if (this.FVN != null)
      {
        paramVarArgs.lJ(8, this.FVN.computeSize());
        this.FVN.writeFields(paramVarArgs);
      }
      if (this.Hsa != null)
      {
        paramVarArgs.lJ(9, this.Hsa.computeSize());
        this.Hsa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.HrS != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HrS);
      }
      paramInt = i;
      if (this.FVL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FVL);
      }
      i = paramInt;
      if (this.HrZ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HrZ);
      }
      paramInt = i;
      if (this.FVM != null) {
        paramInt = i + f.a.a.a.lI(7, this.FVM.computeSize());
      }
      i = paramInt;
      if (this.FVN != null) {
        i = paramInt + f.a.a.a.lI(8, this.FVN.computeSize());
      }
      paramInt = i;
      if (this.Hsa != null) {
        paramInt = i + f.a.a.a.lI(9, this.Hsa.computeSize());
      }
      AppMethodBeat.o(72531);
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
          AppMethodBeat.o(72531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfi localcfi = (cfi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72531);
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
            localcfi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 2: 
          localcfi.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72531);
          return 0;
        case 3: 
          localcfi.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 4: 
          localcfi.HrS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 5: 
          localcfi.FVL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 6: 
          localcfi.HrZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cls();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cls)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfi.FVM = ((cls)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfi.FVN = ((cgv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcfi.Hsa = ((bqn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      AppMethodBeat.o(72531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfi
 * JD-Core Version:    0.7.0.1
 */
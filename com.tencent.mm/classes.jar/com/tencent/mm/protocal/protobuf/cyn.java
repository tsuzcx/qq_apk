package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyn
  extends cwj
{
  public String FPO;
  public String HIH;
  public String HII;
  public String HIJ;
  public com.tencent.mm.bw.b HIK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82472);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FPO != null) {
        paramVarArgs.d(3, this.FPO);
      }
      if (this.HIH != null) {
        paramVarArgs.d(4, this.HIH);
      }
      if (this.HII != null) {
        paramVarArgs.d(5, this.HII);
      }
      if (this.HIJ != null) {
        paramVarArgs.d(6, this.HIJ);
      }
      if (this.HIK != null) {
        paramVarArgs.c(7, this.HIK);
      }
      AppMethodBeat.o(82472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label666;
      }
    }
    label666:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FPO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FPO);
      }
      i = paramInt;
      if (this.HIH != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HIH);
      }
      paramInt = i;
      if (this.HII != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HII);
      }
      i = paramInt;
      if (this.HIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HIJ);
      }
      paramInt = i;
      if (this.HIK != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.HIK);
      }
      AppMethodBeat.o(82472);
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82472);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyn localcyn = (cyn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(82472);
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
            localcyn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82472);
          return 0;
        case 3: 
          localcyn.FPO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 4: 
          localcyn.HIH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 5: 
          localcyn.HII = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 6: 
          localcyn.HIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82472);
          return 0;
        }
        localcyn.HIK = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(82472);
        return 0;
      }
      AppMethodBeat.o(82472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyn
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czt
  extends cwj
{
  public bob FVS;
  public boc FVT;
  public String FVm;
  public caj FVn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32424);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32424);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FVn != null)
      {
        paramVarArgs.lJ(2, this.FVn.computeSize());
        this.FVn.writeFields(paramVarArgs);
      }
      if (this.FVS != null)
      {
        paramVarArgs.lJ(3, this.FVS.computeSize());
        this.FVS.writeFields(paramVarArgs);
      }
      if (this.FVT != null)
      {
        paramVarArgs.lJ(4, this.FVT.computeSize());
        this.FVT.writeFields(paramVarArgs);
      }
      if (this.FVm != null) {
        paramVarArgs.d(5, this.FVm);
      }
      AppMethodBeat.o(32424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label893;
      }
    }
    label893:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FVn != null) {
        paramInt = i + f.a.a.a.lI(2, this.FVn.computeSize());
      }
      i = paramInt;
      if (this.FVS != null) {
        i = paramInt + f.a.a.a.lI(3, this.FVS.computeSize());
      }
      paramInt = i;
      if (this.FVT != null) {
        paramInt = i + f.a.a.a.lI(4, this.FVT.computeSize());
      }
      i = paramInt;
      if (this.FVm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FVm);
      }
      AppMethodBeat.o(32424);
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
          AppMethodBeat.o(32424);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32424);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czt localczt = (czt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32424);
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
            localczt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczt.FVn = ((caj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bob();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczt.FVS = ((bob)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((boc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczt.FVT = ((boc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
          return 0;
        }
        localczt.FVm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32424);
        return 0;
      }
      AppMethodBeat.o(32424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czt
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class crn
  extends cwj
{
  public crk HCE;
  public int HCS;
  public int HCT;
  public String HCU;
  public String qsG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HCE == null)
      {
        paramVarArgs = new b("Not all required fields were included: rcptinfolist");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32404);
        throw paramVarArgs;
      }
      if (this.HCE != null)
      {
        paramVarArgs.lJ(1, this.HCE.computeSize());
        this.HCE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HCS);
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(3, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.qsG != null) {
        paramVarArgs.d(4, this.qsG);
      }
      paramVarArgs.aS(5, this.HCT);
      if (this.HCU != null) {
        paramVarArgs.d(6, this.HCU);
      }
      AppMethodBeat.o(32404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HCE == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lI(1, this.HCE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HCS);
      paramInt = i;
      if (this.BaseResponse != null) {
        paramInt = i + f.a.a.a.lI(3, this.BaseResponse.computeSize());
      }
      i = paramInt;
      if (this.qsG != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.qsG);
      }
      i += f.a.a.b.b.a.bz(5, this.HCT);
      paramInt = i;
      if (this.HCU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HCU);
      }
      AppMethodBeat.o(32404);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HCE == null)
        {
          paramVarArgs = new b("Not all required fields were included: rcptinfolist");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32404);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crn localcrn = (crn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32404);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrn.HCE = ((crk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 2: 
          localcrn.HCS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32404);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32404);
          return 0;
        case 4: 
          localcrn.qsG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32404);
          return 0;
        case 5: 
          localcrn.HCT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32404);
          return 0;
        }
        localcrn.HCU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32404);
        return 0;
      }
      AppMethodBeat.o(32404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crn
 * JD-Core Version:    0.7.0.1
 */
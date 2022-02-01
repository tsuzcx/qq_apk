package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azm
  extends cwj
{
  public int GOF;
  public cqw GPD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133171);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133171);
        throw paramVarArgs;
      }
      if (this.GPD == null)
      {
        paramVarArgs = new b("Not all required fields were included: CertValue");
        AppMethodBeat.o(133171);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GPD != null)
      {
        paramVarArgs.lJ(2, this.GPD.computeSize());
        this.GPD.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GOF);
      AppMethodBeat.o(133171);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GPD != null) {
        i = paramInt + f.a.a.a.lI(2, this.GPD.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.GOF);
      AppMethodBeat.o(133171);
      return i + paramInt;
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
          AppMethodBeat.o(133171);
          throw paramVarArgs;
        }
        if (this.GPD == null)
        {
          paramVarArgs = new b("Not all required fields were included: CertValue");
          AppMethodBeat.o(133171);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133171);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azm localazm = (azm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133171);
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
            localazm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133171);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazm.GPD = ((cqw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133171);
          return 0;
        }
        localazm.GOF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133171);
        return 0;
      }
      AppMethodBeat.o(133171);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqm
  extends cwj
{
  public cxk FLp;
  public dms HCj;
  public edr HCk;
  public long HCl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91654);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91654);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HCj != null)
      {
        paramVarArgs.lJ(2, this.HCj.computeSize());
        this.HCj.writeFields(paramVarArgs);
      }
      if (this.FLp != null)
      {
        paramVarArgs.lJ(3, this.FLp.computeSize());
        this.FLp.writeFields(paramVarArgs);
      }
      if (this.HCk != null)
      {
        paramVarArgs.lJ(4, this.HCk.computeSize());
        this.HCk.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(5, this.HCl);
      AppMethodBeat.o(91654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label866;
      }
    }
    label866:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HCj != null) {
        paramInt = i + f.a.a.a.lI(2, this.HCj.computeSize());
      }
      i = paramInt;
      if (this.FLp != null) {
        i = paramInt + f.a.a.a.lI(3, this.FLp.computeSize());
      }
      paramInt = i;
      if (this.HCk != null) {
        paramInt = i + f.a.a.a.lI(4, this.HCk.computeSize());
      }
      i = f.a.a.b.b.a.p(5, this.HCl);
      AppMethodBeat.o(91654);
      return paramInt + i;
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
          AppMethodBeat.o(91654);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqm localcqm = (cqm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91654);
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
            localcqm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dms();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dms)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqm.HCj = ((dms)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqm.FLp = ((cxk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new edr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((edr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqm.HCk = ((edr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        }
        localcqm.HCl = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91654);
        return 0;
      }
      AppMethodBeat.o(91654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqm
 * JD-Core Version:    0.7.0.1
 */
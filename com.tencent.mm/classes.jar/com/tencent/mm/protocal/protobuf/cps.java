package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cps
  extends cvp
{
  public cwq FsR;
  public dlv HiJ;
  public eca HiK;
  public long HiL;
  
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HiJ != null)
      {
        paramVarArgs.lC(2, this.HiJ.computeSize());
        this.HiJ.writeFields(paramVarArgs);
      }
      if (this.FsR != null)
      {
        paramVarArgs.lC(3, this.FsR.computeSize());
        this.FsR.writeFields(paramVarArgs);
      }
      if (this.HiK != null)
      {
        paramVarArgs.lC(4, this.HiK.computeSize());
        this.HiK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.HiL);
      AppMethodBeat.o(91654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label866;
      }
    }
    label866:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HiJ != null) {
        paramInt = i + f.a.a.a.lB(2, this.HiJ.computeSize());
      }
      i = paramInt;
      if (this.FsR != null) {
        i = paramInt + f.a.a.a.lB(3, this.FsR.computeSize());
      }
      paramInt = i;
      if (this.HiK != null) {
        paramInt = i + f.a.a.a.lB(4, this.HiK.computeSize());
      }
      i = f.a.a.b.b.a.p(5, this.HiL);
      AppMethodBeat.o(91654);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        cps localcps = (cps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91654);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcps.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dlv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dlv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcps.HiJ = ((dlv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcps.FsR = ((cwq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcps.HiK = ((eca)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        }
        localcps.HiL = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91654);
        return 0;
      }
      AppMethodBeat.o(91654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cps
 * JD-Core Version:    0.7.0.1
 */
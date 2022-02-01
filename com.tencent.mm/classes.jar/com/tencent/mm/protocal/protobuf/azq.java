package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azq
  extends com.tencent.mm.bw.a
{
  public int FNN;
  public cxn GPN;
  public int GPO;
  public int GPP;
  public int GPQ = 1;
  public int GPR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GPN == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatroomId");
        AppMethodBeat.o(101809);
        throw paramVarArgs;
      }
      if (this.GPN != null)
      {
        paramVarArgs.lJ(1, this.GPN.computeSize());
        this.GPN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FNN);
      paramVarArgs.aS(3, this.GPO);
      paramVarArgs.aS(4, this.GPP);
      paramVarArgs.aS(5, this.GPQ);
      paramVarArgs.aS(6, this.GPR);
      AppMethodBeat.o(101809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GPN == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lI(1, this.GPN.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.FNN);
      int j = f.a.a.b.b.a.bz(3, this.GPO);
      int k = f.a.a.b.b.a.bz(4, this.GPP);
      int m = f.a.a.b.b.a.bz(5, this.GPQ);
      int n = f.a.a.b.b.a.bz(6, this.GPR);
      AppMethodBeat.o(101809);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GPN == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatroomId");
          AppMethodBeat.o(101809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azq localazq = (azq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101809);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazq.GPN = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101809);
          return 0;
        case 2: 
          localazq.FNN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101809);
          return 0;
        case 3: 
          localazq.GPO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101809);
          return 0;
        case 4: 
          localazq.GPP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101809);
          return 0;
        case 5: 
          localazq.GPQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101809);
          return 0;
        }
        localazq.GPR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(101809);
        return 0;
      }
      AppMethodBeat.o(101809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azq
 * JD-Core Version:    0.7.0.1
 */
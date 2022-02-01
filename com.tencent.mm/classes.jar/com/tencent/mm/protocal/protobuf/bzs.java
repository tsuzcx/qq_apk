package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzs
  extends cpx
{
  public int FoC;
  public LinkedList<dqr> FoD;
  public int OpCode;
  
  public bzs()
  {
    AppMethodBeat.i(32364);
    this.FoD = new LinkedList();
    AppMethodBeat.o(32364);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32365);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      paramVarArgs.aR(3, this.FoC);
      paramVarArgs.e(4, 8, this.FoD);
      AppMethodBeat.o(32365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label552;
      }
    }
    label552:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.OpCode);
      int j = f.a.a.b.b.a.bx(3, this.FoC);
      int k = f.a.a.a.c(4, 8, this.FoD);
      AppMethodBeat.o(32365);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FoD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzs localbzs = (bzs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32365);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzs.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32365);
          return 0;
        case 2: 
          localbzs.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32365);
          return 0;
        case 3: 
          localbzs.FoC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32365);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzs.FoD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32365);
        return 0;
      }
      AppMethodBeat.o(32365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzs
 * JD-Core Version:    0.7.0.1
 */
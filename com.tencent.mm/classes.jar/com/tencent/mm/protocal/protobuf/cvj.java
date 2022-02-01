package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvj
  extends cpx
{
  public long FGl;
  public long FGm;
  public String srz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.srz != null) {
        paramVarArgs.d(2, this.srz);
      }
      paramVarArgs.aO(3, this.FGl);
      paramVarArgs.aO(4, this.FGm);
      AppMethodBeat.o(82476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.srz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.srz);
      }
      paramInt = f.a.a.b.b.a.p(3, this.FGl);
      int j = f.a.a.b.b.a.p(4, this.FGm);
      AppMethodBeat.o(82476);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cvj localcvj = (cvj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82476);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82476);
          return 0;
        case 2: 
          localcvj.srz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82476);
          return 0;
        case 3: 
          localcvj.FGl = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(82476);
          return 0;
        }
        localcvj.FGm = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(82476);
        return 0;
      }
      AppMethodBeat.o(82476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvj
 * JD-Core Version:    0.7.0.1
 */
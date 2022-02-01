package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbq
  extends cpx
{
  public int DWS;
  public int DWT;
  public int ESd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DWS);
      paramVarArgs.aR(3, this.DWT);
      paramVarArgs.aR(4, this.ESd);
      AppMethodBeat.o(91499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.DWS);
      int j = f.a.a.b.b.a.bx(3, this.DWT);
      int k = f.a.a.b.b.a.bx(4, this.ESd);
      AppMethodBeat.o(91499);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbq localbbq = (bbq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91499);
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
            localbbq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91499);
          return 0;
        case 2: 
          localbbq.DWS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91499);
          return 0;
        case 3: 
          localbbq.DWT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91499);
          return 0;
        }
        localbbq.ESd = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91499);
        return 0;
      }
      AppMethodBeat.o(91499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbq
 * JD-Core Version:    0.7.0.1
 */
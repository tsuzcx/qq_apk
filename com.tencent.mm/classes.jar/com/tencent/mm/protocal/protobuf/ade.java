package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ade
  extends cpx
{
  public int EvT;
  public int EvU;
  public int vTH;
  public int vTI;
  public int vTO;
  public long vTQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127170);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.vTO);
      paramVarArgs.aR(3, this.vTH);
      paramVarArgs.aR(4, this.vTI);
      paramVarArgs.aR(5, this.EvT);
      paramVarArgs.aR(6, this.EvU);
      paramVarArgs.aO(7, this.vTQ);
      AppMethodBeat.o(127170);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.vTO);
      int j = f.a.a.b.b.a.bx(3, this.vTH);
      int k = f.a.a.b.b.a.bx(4, this.vTI);
      int m = f.a.a.b.b.a.bx(5, this.EvT);
      int n = f.a.a.b.b.a.bx(6, this.EvU);
      int i1 = f.a.a.b.b.a.p(7, this.vTQ);
      AppMethodBeat.o(127170);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127170);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ade localade = (ade)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127170);
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
            localade.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127170);
          return 0;
        case 2: 
          localade.vTO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127170);
          return 0;
        case 3: 
          localade.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127170);
          return 0;
        case 4: 
          localade.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127170);
          return 0;
        case 5: 
          localade.EvT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127170);
          return 0;
        case 6: 
          localade.EvU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127170);
          return 0;
        }
        localade.vTQ = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(127170);
        return 0;
      }
      AppMethodBeat.o(127170);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ade
 * JD-Core Version:    0.7.0.1
 */
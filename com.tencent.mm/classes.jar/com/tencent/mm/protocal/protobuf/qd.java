package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class qd
  extends cpx
{
  public b EgN;
  public b EgO;
  public int EgP;
  public int EgQ;
  public int EgR;
  public int hTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207951);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EgN != null) {
        paramVarArgs.c(2, this.EgN);
      }
      paramVarArgs.aR(3, this.hTM);
      if (this.EgO != null) {
        paramVarArgs.c(4, this.EgO);
      }
      paramVarArgs.aR(5, this.EgP);
      paramVarArgs.aR(6, this.EgQ);
      paramVarArgs.aR(7, this.EgR);
      AppMethodBeat.o(207951);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EgN != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.EgN);
      }
      i += f.a.a.b.b.a.bx(3, this.hTM);
      paramInt = i;
      if (this.EgO != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.EgO);
      }
      i = f.a.a.b.b.a.bx(5, this.EgP);
      int j = f.a.a.b.b.a.bx(6, this.EgQ);
      int k = f.a.a.b.b.a.bx(7, this.EgR);
      AppMethodBeat.o(207951);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(207951);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        qd localqd = (qd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207951);
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
            localqd.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207951);
          return 0;
        case 2: 
          localqd.EgN = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(207951);
          return 0;
        case 3: 
          localqd.hTM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(207951);
          return 0;
        case 4: 
          localqd.EgO = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(207951);
          return 0;
        case 5: 
          localqd.EgP = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(207951);
          return 0;
        case 6: 
          localqd.EgQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(207951);
          return 0;
        }
        localqd.EgR = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(207951);
        return 0;
      }
      AppMethodBeat.o(207951);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qd
 * JD-Core Version:    0.7.0.1
 */
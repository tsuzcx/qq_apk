package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bht
  extends cpx
{
  public int EXc;
  public int EXd;
  public int EXe;
  public int condition;
  public int reason;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123598);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.reason);
      paramVarArgs.aR(3, this.condition);
      paramVarArgs.aR(4, this.EXc);
      paramVarArgs.aR(5, this.EXd);
      paramVarArgs.aR(6, this.EXe);
      AppMethodBeat.o(123598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.reason);
      int j = f.a.a.b.b.a.bx(3, this.condition);
      int k = f.a.a.b.b.a.bx(4, this.EXc);
      int m = f.a.a.b.b.a.bx(5, this.EXd);
      int n = f.a.a.b.b.a.bx(6, this.EXe);
      AppMethodBeat.o(123598);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bht localbht = (bht)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123598);
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
            localbht.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123598);
          return 0;
        case 2: 
          localbht.reason = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123598);
          return 0;
        case 3: 
          localbht.condition = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123598);
          return 0;
        case 4: 
          localbht.EXc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123598);
          return 0;
        case 5: 
          localbht.EXd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123598);
          return 0;
        }
        localbht.EXe = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123598);
        return 0;
      }
      AppMethodBeat.o(123598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bht
 * JD-Core Version:    0.7.0.1
 */
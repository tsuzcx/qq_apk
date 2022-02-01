package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddv
  extends cpx
{
  public String FJm;
  public long FJn;
  public long FKy;
  public int FKz;
  public String ncR;
  public int pAT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118449);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FJm != null) {
        paramVarArgs.d(2, this.FJm);
      }
      if (this.ncR != null) {
        paramVarArgs.d(3, this.ncR);
      }
      paramVarArgs.aR(4, this.pAT);
      paramVarArgs.aO(5, this.FJn);
      paramVarArgs.aO(6, this.FKy);
      paramVarArgs.aR(7, this.FKz);
      AppMethodBeat.o(118449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FJm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FJm);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ncR);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.pAT);
      int j = f.a.a.b.b.a.p(5, this.FJn);
      int k = f.a.a.b.b.a.p(6, this.FKy);
      int m = f.a.a.b.b.a.bx(7, this.FKz);
      AppMethodBeat.o(118449);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(118449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddv localddv = (ddv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118449);
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
            localddv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118449);
          return 0;
        case 2: 
          localddv.FJm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118449);
          return 0;
        case 3: 
          localddv.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118449);
          return 0;
        case 4: 
          localddv.pAT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118449);
          return 0;
        case 5: 
          localddv.FJn = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(118449);
          return 0;
        case 6: 
          localddv.FKy = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(118449);
          return 0;
        }
        localddv.FKz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(118449);
        return 0;
      }
      AppMethodBeat.o(118449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddv
 * JD-Core Version:    0.7.0.1
 */
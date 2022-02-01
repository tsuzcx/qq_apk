package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgm
  extends cpx
{
  public int DPJ;
  public int Edq;
  public int Exf;
  public long Exg;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32462);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Exf);
      paramVarArgs.aO(3, this.Exg);
      paramVarArgs.aR(4, this.Edq);
      paramVarArgs.aR(5, this.DPJ);
      paramVarArgs.aR(6, this.Scene);
      AppMethodBeat.o(32462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.Exf);
      int j = f.a.a.b.b.a.p(3, this.Exg);
      int k = f.a.a.b.b.a.bx(4, this.Edq);
      int m = f.a.a.b.b.a.bx(5, this.DPJ);
      int n = f.a.a.b.b.a.bx(6, this.Scene);
      AppMethodBeat.o(32462);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32462);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgm localdgm = (dgm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32462);
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
            localdgm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32462);
          return 0;
        case 2: 
          localdgm.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32462);
          return 0;
        case 3: 
          localdgm.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32462);
          return 0;
        case 4: 
          localdgm.Edq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32462);
          return 0;
        case 5: 
          localdgm.DPJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32462);
          return 0;
        }
        localdgm.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32462);
        return 0;
      }
      AppMethodBeat.o(32462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chv
  extends cpx
{
  public int Exf;
  public long Exg;
  public long FvQ;
  public long FvT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32376);
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
      paramVarArgs.aO(4, this.FvQ);
      paramVarArgs.aO(5, this.FvT);
      AppMethodBeat.o(32376);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label505;
      }
    }
    label505:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.Exf);
      int j = f.a.a.b.b.a.p(3, this.Exg);
      int k = f.a.a.b.b.a.p(4, this.FvQ);
      int m = f.a.a.b.b.a.p(5, this.FvT);
      AppMethodBeat.o(32376);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32376);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chv localchv = (chv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32376);
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
            localchv.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32376);
          return 0;
        case 2: 
          localchv.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32376);
          return 0;
        case 3: 
          localchv.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32376);
          return 0;
        case 4: 
          localchv.FvQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32376);
          return 0;
        }
        localchv.FvT = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(32376);
        return 0;
      }
      AppMethodBeat.o(32376);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chv
 * JD-Core Version:    0.7.0.1
 */
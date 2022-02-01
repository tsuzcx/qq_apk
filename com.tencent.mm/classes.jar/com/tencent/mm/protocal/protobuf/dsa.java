package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsa
  extends cpx
{
  public int Exf;
  public long Exg;
  public long FYl;
  public String FZq;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115878);
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
      if (this.FZq != null) {
        paramVarArgs.d(4, this.FZq);
      }
      paramVarArgs.aR(5, this.ndI);
      paramVarArgs.aO(6, this.FYl);
      AppMethodBeat.o(115878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Exf) + f.a.a.b.b.a.p(3, this.Exg);
      paramInt = i;
      if (this.FZq != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FZq);
      }
      i = f.a.a.b.b.a.bx(5, this.ndI);
      int j = f.a.a.b.b.a.p(6, this.FYl);
      AppMethodBeat.o(115878);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(115878);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsa localdsa = (dsa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115878);
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
            localdsa.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115878);
          return 0;
        case 2: 
          localdsa.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115878);
          return 0;
        case 3: 
          localdsa.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(115878);
          return 0;
        case 4: 
          localdsa.FZq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115878);
          return 0;
        case 5: 
          localdsa.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(115878);
          return 0;
        }
        localdsa.FYl = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(115878);
        return 0;
      }
      AppMethodBeat.o(115878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsa
 * JD-Core Version:    0.7.0.1
 */
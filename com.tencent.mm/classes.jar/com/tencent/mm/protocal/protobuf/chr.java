package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chr
  extends cpx
{
  public int Exf;
  public long Exg;
  public long FvQ;
  public int FvR;
  public String FvS;
  public long FvT;
  public String tlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32372);
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
      if (this.tlJ != null) {
        paramVarArgs.d(4, this.tlJ);
      }
      paramVarArgs.aO(5, this.FvQ);
      paramVarArgs.aR(6, this.FvR);
      if (this.FvS != null) {
        paramVarArgs.d(7, this.FvS);
      }
      paramVarArgs.aO(8, this.FvT);
      AppMethodBeat.o(32372);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Exf) + f.a.a.b.b.a.p(3, this.Exg);
      paramInt = i;
      if (this.tlJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tlJ);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.FvQ) + f.a.a.b.b.a.bx(6, this.FvR);
      paramInt = i;
      if (this.FvS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FvS);
      }
      i = f.a.a.b.b.a.p(8, this.FvT);
      AppMethodBeat.o(32372);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32372);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chr localchr = (chr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32372);
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
            localchr.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32372);
          return 0;
        case 2: 
          localchr.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32372);
          return 0;
        case 3: 
          localchr.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32372);
          return 0;
        case 4: 
          localchr.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32372);
          return 0;
        case 5: 
          localchr.FvQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32372);
          return 0;
        case 6: 
          localchr.FvR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32372);
          return 0;
        case 7: 
          localchr.FvS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32372);
          return 0;
        }
        localchr.FvT = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(32372);
        return 0;
      }
      AppMethodBeat.o(32372);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chr
 * JD-Core Version:    0.7.0.1
 */
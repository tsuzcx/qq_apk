package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dre
  extends cpx
{
  public int DUB;
  public long Exg;
  public long FOh;
  public String FYS;
  public long FvQ;
  public int FvR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.FvR);
      paramVarArgs.aO(3, this.FOh);
      paramVarArgs.aO(4, this.Exg);
      if (this.FYS != null) {
        paramVarArgs.d(5, this.FYS);
      }
      paramVarArgs.aO(6, this.FvQ);
      paramVarArgs.aR(7, this.DUB);
      AppMethodBeat.o(125494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FvR) + f.a.a.b.b.a.p(3, this.FOh) + f.a.a.b.b.a.p(4, this.Exg);
      paramInt = i;
      if (this.FYS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FYS);
      }
      i = f.a.a.b.b.a.p(6, this.FvQ);
      int j = f.a.a.b.b.a.bx(7, this.DUB);
      AppMethodBeat.o(125494);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125494);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dre localdre = (dre)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125494);
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
            localdre.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125494);
          return 0;
        case 2: 
          localdre.FvR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125494);
          return 0;
        case 3: 
          localdre.FOh = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125494);
          return 0;
        case 4: 
          localdre.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125494);
          return 0;
        case 5: 
          localdre.FYS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125494);
          return 0;
        case 6: 
          localdre.FvQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125494);
          return 0;
        }
        localdre.DUB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125494);
        return 0;
      }
      AppMethodBeat.o(125494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dre
 * JD-Core Version:    0.7.0.1
 */
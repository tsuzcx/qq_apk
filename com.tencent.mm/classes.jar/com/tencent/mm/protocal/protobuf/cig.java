package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cig
  extends cpx
{
  public int Exf;
  public long Exg;
  public long FvQ;
  public long FvT;
  public String Fwn;
  public int Fwo;
  public int Fwp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32390);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fwn == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUsername");
        AppMethodBeat.o(32390);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fwn != null) {
        paramVarArgs.d(2, this.Fwn);
      }
      paramVarArgs.aR(3, this.Exf);
      paramVarArgs.aO(4, this.Exg);
      paramVarArgs.aO(5, this.FvQ);
      paramVarArgs.aR(6, this.Fwo);
      paramVarArgs.aO(7, this.FvT);
      paramVarArgs.aR(8, this.Fwp);
      AppMethodBeat.o(32390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fwn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fwn);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.Exf);
      int j = f.a.a.b.b.a.p(4, this.Exg);
      int k = f.a.a.b.b.a.p(5, this.FvQ);
      int m = f.a.a.b.b.a.bx(6, this.Fwo);
      int n = f.a.a.b.b.a.p(7, this.FvT);
      int i1 = f.a.a.b.b.a.bx(8, this.Fwp);
      AppMethodBeat.o(32390);
      return i + paramInt + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Fwn == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUsername");
          AppMethodBeat.o(32390);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32390);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cig localcig = (cig)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32390);
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
            localcig.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32390);
          return 0;
        case 2: 
          localcig.Fwn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32390);
          return 0;
        case 3: 
          localcig.Exf = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32390);
          return 0;
        case 4: 
          localcig.Exg = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32390);
          return 0;
        case 5: 
          localcig.FvQ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32390);
          return 0;
        case 6: 
          localcig.Fwo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32390);
          return 0;
        case 7: 
          localcig.FvT = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(32390);
          return 0;
        }
        localcig.Fwp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32390);
        return 0;
      }
      AppMethodBeat.o(32390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cig
 * JD-Core Version:    0.7.0.1
 */
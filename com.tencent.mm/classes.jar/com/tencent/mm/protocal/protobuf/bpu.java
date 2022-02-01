package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpu
  extends cpx
{
  public int EfS;
  public int FeO;
  public int ncL;
  public LinkedList<bif> ncM;
  
  public bpu()
  {
    AppMethodBeat.i(155429);
    this.ncM = new LinkedList();
    AppMethodBeat.o(155429);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ncL);
      paramVarArgs.e(3, 8, this.ncM);
      paramVarArgs.aR(4, this.EfS);
      paramVarArgs.aR(5, this.FeO);
      AppMethodBeat.o(155430);
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
      int i = f.a.a.b.b.a.bx(2, this.ncL);
      int j = f.a.a.a.c(3, 8, this.ncM);
      int k = f.a.a.b.b.a.bx(4, this.EfS);
      int m = f.a.a.b.b.a.bx(5, this.FeO);
      AppMethodBeat.o(155430);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ncM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpu localbpu = (bpu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155430);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155430);
          return 0;
        case 2: 
          localbpu.ncL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155430);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bif();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bif)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpu.ncM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155430);
          return 0;
        case 4: 
          localbpu.EfS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155430);
          return 0;
        }
        localbpu.FeO = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(155430);
        return 0;
      }
      AppMethodBeat.o(155430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpu
 * JD-Core Version:    0.7.0.1
 */
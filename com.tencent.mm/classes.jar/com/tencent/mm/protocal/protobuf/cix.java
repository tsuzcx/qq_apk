package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cix
  extends cpx
{
  public int EuD;
  public int FnA;
  public LinkedList<String> FnB;
  public String Fnz;
  
  public cix()
  {
    AppMethodBeat.i(82464);
    this.FnB = new LinkedList();
    AppMethodBeat.o(82464);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82465);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fnz != null) {
        paramVarArgs.d(2, this.Fnz);
      }
      paramVarArgs.aR(3, this.FnA);
      paramVarArgs.e(4, 1, this.FnB);
      paramVarArgs.aR(5, this.EuD);
      AppMethodBeat.o(82465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Fnz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Fnz);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FnA);
      int j = f.a.a.a.c(4, 1, this.FnB);
      int k = f.a.a.b.b.a.bx(5, this.EuD);
      AppMethodBeat.o(82465);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FnB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82465);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cix localcix = (cix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82465);
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
            localcix.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82465);
          return 0;
        case 2: 
          localcix.Fnz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82465);
          return 0;
        case 3: 
          localcix.FnA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82465);
          return 0;
        case 4: 
          localcix.FnB.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(82465);
          return 0;
        }
        localcix.EuD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(82465);
        return 0;
      }
      AppMethodBeat.o(82465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cix
 * JD-Core Version:    0.7.0.1
 */
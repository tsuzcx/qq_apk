package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ada
  extends cpx
{
  public int EfV;
  public ccj EvM;
  public int EvN;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EvM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Package");
        AppMethodBeat.o(152536);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EvM != null)
      {
        paramVarArgs.ln(2, this.EvM.computeSize());
        this.EvM.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.EfV);
      paramVarArgs.aR(4, this.EvN);
      paramVarArgs.aR(5, this.ndI);
      AppMethodBeat.o(152536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EvM != null) {
        i = paramInt + f.a.a.a.lm(2, this.EvM.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(3, this.EfV);
      int j = f.a.a.b.b.a.bx(4, this.EvN);
      int k = f.a.a.b.b.a.bx(5, this.ndI);
      AppMethodBeat.o(152536);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EvM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Package");
          AppMethodBeat.o(152536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ada localada = (ada)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152536);
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
            localada.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152536);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localada.EvM = ((ccj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152536);
          return 0;
        case 3: 
          localada.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152536);
          return 0;
        case 4: 
          localada.EvN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152536);
          return 0;
        }
        localada.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152536);
        return 0;
      }
      AppMethodBeat.o(152536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ada
 * JD-Core Version:    0.7.0.1
 */
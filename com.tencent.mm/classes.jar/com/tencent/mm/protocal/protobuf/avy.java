package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avy
  extends cpx
{
  public cdt EOb;
  public String Epl;
  public long Eub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72483);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Epl != null) {
        paramVarArgs.d(2, this.Epl);
      }
      paramVarArgs.aO(3, this.Eub);
      if (this.EOb != null)
      {
        paramVarArgs.ln(4, this.EOb.computeSize());
        this.EOb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72483);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Epl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Epl);
      }
      i += f.a.a.b.b.a.p(3, this.Eub);
      paramInt = i;
      if (this.EOb != null) {
        paramInt = i + f.a.a.a.lm(4, this.EOb.computeSize());
      }
      AppMethodBeat.o(72483);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72483);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avy localavy = (avy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72483);
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
            localavy.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72483);
          return 0;
        case 2: 
          localavy.Epl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72483);
          return 0;
        case 3: 
          localavy.Eub = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72483);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavy.EOb = ((cdt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72483);
        return 0;
      }
      AppMethodBeat.o(72483);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avy
 * JD-Core Version:    0.7.0.1
 */
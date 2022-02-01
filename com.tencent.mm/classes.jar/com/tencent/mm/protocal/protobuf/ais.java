package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ais
  extends cpx
{
  public aiu EDu;
  public int dtJ;
  public String rfC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195046);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.rfC != null) {
        paramVarArgs.d(2, this.rfC);
      }
      paramVarArgs.aR(3, this.dtJ);
      if (this.EDu != null)
      {
        paramVarArgs.ln(4, this.EDu.computeSize());
        this.EDu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195046);
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
      if (this.rfC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.rfC);
      }
      i += f.a.a.b.b.a.bx(3, this.dtJ);
      paramInt = i;
      if (this.EDu != null) {
        paramInt = i + f.a.a.a.lm(4, this.EDu.computeSize());
      }
      AppMethodBeat.o(195046);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195046);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ais localais = (ais)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195046);
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
            localais.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195046);
          return 0;
        case 2: 
          localais.rfC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195046);
          return 0;
        case 3: 
          localais.dtJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195046);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aiu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localais.EDu = ((aiu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(195046);
        return 0;
      }
      AppMethodBeat.o(195046);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ais
 * JD-Core Version:    0.7.0.1
 */
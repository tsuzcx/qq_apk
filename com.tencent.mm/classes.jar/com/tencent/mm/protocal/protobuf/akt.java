package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class akt
  extends cpx
{
  public aiu EDL;
  public String EEI;
  public b EEJ;
  public int diw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168982);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EEI != null) {
        paramVarArgs.d(2, this.EEI);
      }
      if (this.EEJ != null) {
        paramVarArgs.c(3, this.EEJ);
      }
      if (this.EDL != null)
      {
        paramVarArgs.ln(4, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.diw);
      AppMethodBeat.o(168982);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EEI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EEI);
      }
      i = paramInt;
      if (this.EEJ != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.EEJ);
      }
      paramInt = i;
      if (this.EDL != null) {
        paramInt = i + f.a.a.a.lm(4, this.EDL.computeSize());
      }
      i = f.a.a.b.b.a.bx(5, this.diw);
      AppMethodBeat.o(168982);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168982);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akt localakt = (akt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168982);
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
            localakt.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168982);
          return 0;
        case 2: 
          localakt.EEI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168982);
          return 0;
        case 3: 
          localakt.EEJ = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(168982);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakt.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168982);
          return 0;
        }
        localakt.diw = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168982);
        return 0;
      }
      AppMethodBeat.o(168982);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akt
 * JD-Core Version:    0.7.0.1
 */
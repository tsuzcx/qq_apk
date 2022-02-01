package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccq
  extends com.tencent.mm.bw.a
{
  public dnl FLn;
  public ccs Hpm;
  public ccr Hpn;
  public ccr Hpo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FLn != null)
      {
        paramVarArgs.lJ(1, this.FLn.computeSize());
        this.FLn.writeFields(paramVarArgs);
      }
      if (this.Hpm != null)
      {
        paramVarArgs.lJ(2, this.Hpm.computeSize());
        this.Hpm.writeFields(paramVarArgs);
      }
      if (this.Hpn != null)
      {
        paramVarArgs.lJ(3, this.Hpn.computeSize());
        this.Hpn.writeFields(paramVarArgs);
      }
      if (this.Hpo != null)
      {
        paramVarArgs.lJ(4, this.Hpo.computeSize());
        this.Hpo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FLn == null) {
        break label774;
      }
    }
    label774:
    for (int i = f.a.a.a.lI(1, this.FLn.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hpm != null) {
        paramInt = i + f.a.a.a.lI(2, this.Hpm.computeSize());
      }
      i = paramInt;
      if (this.Hpn != null) {
        i = paramInt + f.a.a.a.lI(3, this.Hpn.computeSize());
      }
      paramInt = i;
      if (this.Hpo != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hpo.computeSize());
      }
      AppMethodBeat.o(91550);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccq localccq = (ccq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91550);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccq.FLn = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccq.Hpm = ((ccs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccq.Hpn = ((ccr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccq.Hpo = ((ccr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      AppMethodBeat.o(91550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccq
 * JD-Core Version:    0.7.0.1
 */
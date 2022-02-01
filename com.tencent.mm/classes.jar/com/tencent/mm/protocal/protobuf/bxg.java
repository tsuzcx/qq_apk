package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxg
  extends com.tencent.mm.bw.a
{
  public dhb DNJ;
  public bxi Fmd;
  public bxh Fme;
  public bxh Fmf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DNJ != null)
      {
        paramVarArgs.ln(1, this.DNJ.computeSize());
        this.DNJ.writeFields(paramVarArgs);
      }
      if (this.Fmd != null)
      {
        paramVarArgs.ln(2, this.Fmd.computeSize());
        this.Fmd.writeFields(paramVarArgs);
      }
      if (this.Fme != null)
      {
        paramVarArgs.ln(3, this.Fme.computeSize());
        this.Fme.writeFields(paramVarArgs);
      }
      if (this.Fmf != null)
      {
        paramVarArgs.ln(4, this.Fmf.computeSize());
        this.Fmf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DNJ == null) {
        break label774;
      }
    }
    label774:
    for (int i = f.a.a.a.lm(1, this.DNJ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fmd != null) {
        paramInt = i + f.a.a.a.lm(2, this.Fmd.computeSize());
      }
      i = paramInt;
      if (this.Fme != null) {
        i = paramInt + f.a.a.a.lm(3, this.Fme.computeSize());
      }
      paramInt = i;
      if (this.Fmf != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fmf.computeSize());
      }
      AppMethodBeat.o(91550);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxg localbxg = (bxg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91550);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxg.DNJ = ((dhb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxg.Fmd = ((bxi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxg.Fme = ((bxh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91550);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbxg.Fmf = ((bxh)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxg
 * JD-Core Version:    0.7.0.1
 */
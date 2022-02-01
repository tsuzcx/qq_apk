package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcu
  extends com.tencent.mm.bw.a
{
  public dcv FMs;
  public dct FMt;
  public dcs FMu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125844);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FMs != null)
      {
        paramVarArgs.ln(1, this.FMs.computeSize());
        this.FMs.writeFields(paramVarArgs);
      }
      if (this.FMt != null)
      {
        paramVarArgs.ln(2, this.FMt.computeSize());
        this.FMt.writeFields(paramVarArgs);
      }
      if (this.FMu != null)
      {
        paramVarArgs.ln(3, this.FMu.computeSize());
        this.FMu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FMs == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lm(1, this.FMs.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FMt != null) {
        paramInt = i + f.a.a.a.lm(2, this.FMt.computeSize());
      }
      i = paramInt;
      if (this.FMu != null) {
        i = paramInt + f.a.a.a.lm(3, this.FMu.computeSize());
      }
      AppMethodBeat.o(125844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcu localdcu = (dcu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125844);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcu.FMs = ((dcv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dct();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dct)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcu.FMt = ((dct)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125844);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcu.FMu = ((dcs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125844);
        return 0;
      }
      AppMethodBeat.o(125844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcu
 * JD-Core Version:    0.7.0.1
 */
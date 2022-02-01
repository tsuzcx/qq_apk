package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ta
  extends com.tencent.mm.bw.a
{
  public sz Enh;
  public sz Eni;
  public sz Enj;
  public sz Enk;
  public sz Enl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113984);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Enh != null)
      {
        paramVarArgs.ln(1, this.Enh.computeSize());
        this.Enh.writeFields(paramVarArgs);
      }
      if (this.Eni != null)
      {
        paramVarArgs.ln(2, this.Eni.computeSize());
        this.Eni.writeFields(paramVarArgs);
      }
      if (this.Enj != null)
      {
        paramVarArgs.ln(3, this.Enj.computeSize());
        this.Enj.writeFields(paramVarArgs);
      }
      if (this.Enk != null)
      {
        paramVarArgs.ln(4, this.Enk.computeSize());
        this.Enk.writeFields(paramVarArgs);
      }
      if (this.Enl != null)
      {
        paramVarArgs.ln(5, this.Enl.computeSize());
        this.Enl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Enh == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.lm(1, this.Enh.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eni != null) {
        paramInt = i + f.a.a.a.lm(2, this.Eni.computeSize());
      }
      i = paramInt;
      if (this.Enj != null) {
        i = paramInt + f.a.a.a.lm(3, this.Enj.computeSize());
      }
      paramInt = i;
      if (this.Enk != null) {
        paramInt = i + f.a.a.a.lm(4, this.Enk.computeSize());
      }
      i = paramInt;
      if (this.Enl != null) {
        i = paramInt + f.a.a.a.lm(5, this.Enl.computeSize());
      }
      AppMethodBeat.o(113984);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ta localta = (ta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113984);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localta.Enh = ((sz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localta.Eni = ((sz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localta.Enj = ((sz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localta.Enk = ((sz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localta.Enl = ((sz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      AppMethodBeat.o(113984);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ta
 * JD-Core Version:    0.7.0.1
 */
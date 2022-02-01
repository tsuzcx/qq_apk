package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aad
  extends com.tencent.mm.bw.a
{
  public btt Euo;
  public cnb Eup;
  public cnb Euq;
  public cnb Eur;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206860);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Euo != null)
      {
        paramVarArgs.ln(1, this.Euo.computeSize());
        this.Euo.writeFields(paramVarArgs);
      }
      if (this.Eup != null)
      {
        paramVarArgs.ln(2, this.Eup.computeSize());
        this.Eup.writeFields(paramVarArgs);
      }
      if (this.Euq != null)
      {
        paramVarArgs.ln(3, this.Euq.computeSize());
        this.Euq.writeFields(paramVarArgs);
      }
      if (this.Eur != null)
      {
        paramVarArgs.ln(4, this.Eur.computeSize());
        this.Eur.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(206860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Euo == null) {
        break label774;
      }
    }
    label774:
    for (int i = f.a.a.a.lm(1, this.Euo.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eup != null) {
        paramInt = i + f.a.a.a.lm(2, this.Eup.computeSize());
      }
      i = paramInt;
      if (this.Euq != null) {
        i = paramInt + f.a.a.a.lm(3, this.Euq.computeSize());
      }
      paramInt = i;
      if (this.Eur != null) {
        paramInt = i + f.a.a.a.lm(4, this.Eur.computeSize());
      }
      AppMethodBeat.o(206860);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(206860);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aad localaad = (aad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206860);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaad.Euo = ((btt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206860);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaad.Eup = ((cnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206860);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaad.Euq = ((cnb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206860);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cnb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cnb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaad.Eur = ((cnb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(206860);
        return 0;
      }
      AppMethodBeat.o(206860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aad
 * JD-Core Version:    0.7.0.1
 */
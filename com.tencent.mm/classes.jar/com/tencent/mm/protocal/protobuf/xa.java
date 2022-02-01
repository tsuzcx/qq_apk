package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xa
  extends com.tencent.mm.bw.a
{
  public blc Ert;
  public dqf Eru;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110892);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ert != null)
      {
        paramVarArgs.ln(1, this.Ert.computeSize());
        this.Ert.writeFields(paramVarArgs);
      }
      if (this.Eru != null)
      {
        paramVarArgs.ln(2, this.Eru.computeSize());
        this.Eru.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ert == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.a.lm(1, this.Ert.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eru != null) {
        i = paramInt + f.a.a.a.lm(2, this.Eru.computeSize());
      }
      AppMethodBeat.o(110892);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(110892);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xa localxa = (xa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110892);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxa.Ert = ((blc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110892);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localxa.Eru = ((dqf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110892);
        return 0;
      }
      AppMethodBeat.o(110892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xa
 * JD-Core Version:    0.7.0.1
 */
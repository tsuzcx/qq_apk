package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cy
  extends com.tencent.mm.bv.a
{
  public cdh wpl;
  public bwc wpm;
  public int wpn;
  public btk wpo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94503);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wpl == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsADObject");
        AppMethodBeat.o(94503);
        throw paramVarArgs;
      }
      if (this.wpl != null)
      {
        paramVarArgs.iQ(1, this.wpl.computeSize());
        this.wpl.writeFields(paramVarArgs);
      }
      if (this.wpm != null)
      {
        paramVarArgs.iQ(2, this.wpm.computeSize());
        this.wpm.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wpn);
      if (this.wpo != null)
      {
        paramVarArgs.iQ(4, this.wpo.computeSize());
        this.wpo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wpl == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = e.a.a.a.iP(1, this.wpl.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wpm != null) {
        i = paramInt + e.a.a.a.iP(2, this.wpm.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.wpn);
      paramInt = i;
      if (this.wpo != null) {
        paramInt = i + e.a.a.a.iP(4, this.wpo.computeSize());
      }
      AppMethodBeat.o(94503);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wpl == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsADObject");
          AppMethodBeat.o(94503);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cy localcy = (cy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94503);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcy.wpl = ((cdh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94503);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcy.wpm = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94503);
          return 0;
        case 3: 
          localcy.wpn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94503);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btk();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcy.wpo = ((btk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94503);
        return 0;
      }
      AppMethodBeat.o(94503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cy
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aap
  extends com.tencent.mm.bw.a
{
  public csy GrQ;
  public LinkedList<ja> GrR;
  public boolean GrS;
  public csy GrT;
  
  public aap()
  {
    AppMethodBeat.i(212468);
    this.GrR = new LinkedList();
    AppMethodBeat.o(212468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GrQ != null)
      {
        paramVarArgs.lJ(1, this.GrQ.computeSize());
        this.GrQ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GrR);
      paramVarArgs.bC(3, this.GrS);
      if (this.GrT != null)
      {
        paramVarArgs.lJ(4, this.GrT.computeSize());
        this.GrT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(212469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GrQ == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lI(1, this.GrQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GrR) + f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.GrT != null) {
        paramInt = i + f.a.a.a.lI(4, this.GrT.computeSize());
      }
      AppMethodBeat.o(212469);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GrR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(212469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aap localaap = (aap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212469);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaap.GrQ = ((csy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212469);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ja();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ja)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaap.GrR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212469);
          return 0;
        case 3: 
          localaap.GrS = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(212469);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaap.GrT = ((csy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212469);
        return 0;
      }
      AppMethodBeat.o(212469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aap
 * JD-Core Version:    0.7.0.1
 */
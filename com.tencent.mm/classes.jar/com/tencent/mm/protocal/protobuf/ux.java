package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ux
  extends com.tencent.mm.bw.a
{
  public uw GmP;
  public uw GmQ;
  public uw GmR;
  public uw GmS;
  public uw GmT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113984);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GmP != null)
      {
        paramVarArgs.lJ(1, this.GmP.computeSize());
        this.GmP.writeFields(paramVarArgs);
      }
      if (this.GmQ != null)
      {
        paramVarArgs.lJ(2, this.GmQ.computeSize());
        this.GmQ.writeFields(paramVarArgs);
      }
      if (this.GmR != null)
      {
        paramVarArgs.lJ(3, this.GmR.computeSize());
        this.GmR.writeFields(paramVarArgs);
      }
      if (this.GmS != null)
      {
        paramVarArgs.lJ(4, this.GmS.computeSize());
        this.GmS.writeFields(paramVarArgs);
      }
      if (this.GmT != null)
      {
        paramVarArgs.lJ(5, this.GmT.computeSize());
        this.GmT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113984);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GmP == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.lI(1, this.GmP.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GmQ != null) {
        paramInt = i + f.a.a.a.lI(2, this.GmQ.computeSize());
      }
      i = paramInt;
      if (this.GmR != null) {
        i = paramInt + f.a.a.a.lI(3, this.GmR.computeSize());
      }
      paramInt = i;
      if (this.GmS != null) {
        paramInt = i + f.a.a.a.lI(4, this.GmS.computeSize());
      }
      i = paramInt;
      if (this.GmT != null) {
        i = paramInt + f.a.a.a.lI(5, this.GmT.computeSize());
      }
      AppMethodBeat.o(113984);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113984);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ux localux = (ux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113984);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localux.GmP = ((uw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localux.GmQ = ((uw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localux.GmR = ((uw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localux.GmS = ((uw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113984);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localux.GmT = ((uw)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ux
 * JD-Core Version:    0.7.0.1
 */
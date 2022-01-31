package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qf
  extends com.tencent.mm.bv.a
{
  public qe wIE;
  public qe wIF;
  public qe wIG;
  public qe wIH;
  public qe wII;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89051);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wIE != null)
      {
        paramVarArgs.iQ(1, this.wIE.computeSize());
        this.wIE.writeFields(paramVarArgs);
      }
      if (this.wIF != null)
      {
        paramVarArgs.iQ(2, this.wIF.computeSize());
        this.wIF.writeFields(paramVarArgs);
      }
      if (this.wIG != null)
      {
        paramVarArgs.iQ(3, this.wIG.computeSize());
        this.wIG.writeFields(paramVarArgs);
      }
      if (this.wIH != null)
      {
        paramVarArgs.iQ(4, this.wIH.computeSize());
        this.wIH.writeFields(paramVarArgs);
      }
      if (this.wII != null)
      {
        paramVarArgs.iQ(5, this.wII.computeSize());
        this.wII.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(89051);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wIE == null) {
        break label926;
      }
    }
    label926:
    for (int i = e.a.a.a.iP(1, this.wIE.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wIF != null) {
        paramInt = i + e.a.a.a.iP(2, this.wIF.computeSize());
      }
      i = paramInt;
      if (this.wIG != null) {
        i = paramInt + e.a.a.a.iP(3, this.wIG.computeSize());
      }
      paramInt = i;
      if (this.wIH != null) {
        paramInt = i + e.a.a.a.iP(4, this.wIH.computeSize());
      }
      i = paramInt;
      if (this.wII != null) {
        i = paramInt + e.a.a.a.iP(5, this.wII.computeSize());
      }
      AppMethodBeat.o(89051);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89051);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qf localqf = (qf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89051);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qe();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localqf.wIE = ((qe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89051);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qe();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localqf.wIF = ((qe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89051);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qe();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localqf.wIG = ((qe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89051);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qe();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localqf.wIH = ((qe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89051);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qe();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localqf.wII = ((qe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89051);
        return 0;
      }
      AppMethodBeat.o(89051);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qf
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class be
  extends com.tencent.mm.bw.a
{
  public dnl FLn;
  public dnl FLo;
  public cxk FLp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91342);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FLn != null)
      {
        paramVarArgs.lJ(1, this.FLn.computeSize());
        this.FLn.writeFields(paramVarArgs);
      }
      if (this.FLo != null)
      {
        paramVarArgs.lJ(2, this.FLo.computeSize());
        this.FLo.writeFields(paramVarArgs);
      }
      if (this.FLp != null)
      {
        paramVarArgs.lJ(3, this.FLp.computeSize());
        this.FLp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91342);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FLn == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lI(1, this.FLn.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FLo != null) {
        paramInt = i + f.a.a.a.lI(2, this.FLo.computeSize());
      }
      i = paramInt;
      if (this.FLp != null) {
        i = paramInt + f.a.a.a.lI(3, this.FLp.computeSize());
      }
      AppMethodBeat.o(91342);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91342);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        be localbe = (be)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91342);
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
            localbe.FLn = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91342);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbe.FLo = ((dnl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91342);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbe.FLp = ((cxk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91342);
        return 0;
      }
      AppMethodBeat.o(91342);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.be
 * JD-Core Version:    0.7.0.1
 */
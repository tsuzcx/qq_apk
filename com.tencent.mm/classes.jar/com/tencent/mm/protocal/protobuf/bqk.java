package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqk
  extends com.tencent.mm.bw.a
{
  public bql FfA;
  public bqh FfB;
  public bqi FfC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190894);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FfA != null)
      {
        paramVarArgs.ln(1, this.FfA.computeSize());
        this.FfA.writeFields(paramVarArgs);
      }
      if (this.FfB != null)
      {
        paramVarArgs.ln(2, this.FfB.computeSize());
        this.FfB.writeFields(paramVarArgs);
      }
      if (this.FfC != null)
      {
        paramVarArgs.ln(3, this.FfC.computeSize());
        this.FfC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(190894);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FfA == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lm(1, this.FfA.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FfB != null) {
        paramInt = i + f.a.a.a.lm(2, this.FfB.computeSize());
      }
      i = paramInt;
      if (this.FfC != null) {
        i = paramInt + f.a.a.a.lm(3, this.FfC.computeSize());
      }
      AppMethodBeat.o(190894);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(190894);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqk localbqk = (bqk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190894);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bql();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqk.FfA = ((bql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190894);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqk.FfB = ((bqh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190894);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbqk.FfC = ((bqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(190894);
        return 0;
      }
      AppMethodBeat.o(190894);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqk
 * JD-Core Version:    0.7.0.1
 */
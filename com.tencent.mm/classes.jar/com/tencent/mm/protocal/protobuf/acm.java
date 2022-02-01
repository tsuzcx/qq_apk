package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acm
  extends com.tencent.mm.bw.a
{
  public bzb Guo;
  public csy Gup;
  public csy Guq;
  public csy Gur;
  public csy Gus;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212474);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Guo != null)
      {
        paramVarArgs.lJ(1, this.Guo.computeSize());
        this.Guo.writeFields(paramVarArgs);
      }
      if (this.Gup != null)
      {
        paramVarArgs.lJ(2, this.Gup.computeSize());
        this.Gup.writeFields(paramVarArgs);
      }
      if (this.Guq != null)
      {
        paramVarArgs.lJ(3, this.Guq.computeSize());
        this.Guq.writeFields(paramVarArgs);
      }
      if (this.Gur != null)
      {
        paramVarArgs.lJ(4, this.Gur.computeSize());
        this.Gur.writeFields(paramVarArgs);
      }
      if (this.Gus != null)
      {
        paramVarArgs.lJ(5, this.Gus.computeSize());
        this.Gus.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(212474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Guo == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.lI(1, this.Guo.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gup != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gup.computeSize());
      }
      i = paramInt;
      if (this.Guq != null) {
        i = paramInt + f.a.a.a.lI(3, this.Guq.computeSize());
      }
      paramInt = i;
      if (this.Gur != null) {
        paramInt = i + f.a.a.a.lI(4, this.Gur.computeSize());
      }
      i = paramInt;
      if (this.Gus != null) {
        i = paramInt + f.a.a.a.lI(5, this.Gus.computeSize());
      }
      AppMethodBeat.o(212474);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(212474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acm localacm = (acm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212474);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacm.Guo = ((bzb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212474);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacm.Gup = ((csy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212474);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacm.Guq = ((csy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212474);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacm.Gur = ((csy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212474);
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
          localacm.Gus = ((csy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212474);
        return 0;
      }
      AppMethodBeat.o(212474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acm
 * JD-Core Version:    0.7.0.1
 */
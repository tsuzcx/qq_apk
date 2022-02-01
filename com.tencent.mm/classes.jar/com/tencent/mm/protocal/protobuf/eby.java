package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eby
  extends com.tencent.mm.bw.a
{
  public ecf GhA;
  public ebx GhB;
  public ece GhC;
  public eca Ghv;
  public ebz Ghw;
  public ecb Ghx;
  public ecd Ghy;
  public ecc Ghz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ghv != null)
      {
        paramVarArgs.ln(1, this.Ghv.computeSize());
        this.Ghv.writeFields(paramVarArgs);
      }
      if (this.Ghw != null)
      {
        paramVarArgs.ln(2, this.Ghw.computeSize());
        this.Ghw.writeFields(paramVarArgs);
      }
      if (this.Ghx != null)
      {
        paramVarArgs.ln(3, this.Ghx.computeSize());
        this.Ghx.writeFields(paramVarArgs);
      }
      if (this.Ghy != null)
      {
        paramVarArgs.ln(4, this.Ghy.computeSize());
        this.Ghy.writeFields(paramVarArgs);
      }
      if (this.Ghz != null)
      {
        paramVarArgs.ln(5, this.Ghz.computeSize());
        this.Ghz.writeFields(paramVarArgs);
      }
      if (this.GhA != null)
      {
        paramVarArgs.ln(6, this.GhA.computeSize());
        this.GhA.writeFields(paramVarArgs);
      }
      if (this.GhB != null)
      {
        paramVarArgs.ln(7, this.GhB.computeSize());
        this.GhB.writeFields(paramVarArgs);
      }
      if (this.GhC != null)
      {
        paramVarArgs.ln(8, this.GhC.computeSize());
        this.GhC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ghv == null) {
        break label1394;
      }
    }
    label1394:
    for (int i = f.a.a.a.lm(1, this.Ghv.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ghw != null) {
        paramInt = i + f.a.a.a.lm(2, this.Ghw.computeSize());
      }
      i = paramInt;
      if (this.Ghx != null) {
        i = paramInt + f.a.a.a.lm(3, this.Ghx.computeSize());
      }
      paramInt = i;
      if (this.Ghy != null) {
        paramInt = i + f.a.a.a.lm(4, this.Ghy.computeSize());
      }
      i = paramInt;
      if (this.Ghz != null) {
        i = paramInt + f.a.a.a.lm(5, this.Ghz.computeSize());
      }
      paramInt = i;
      if (this.GhA != null) {
        paramInt = i + f.a.a.a.lm(6, this.GhA.computeSize());
      }
      i = paramInt;
      if (this.GhB != null) {
        i = paramInt + f.a.a.a.lm(7, this.GhB.computeSize());
      }
      paramInt = i;
      if (this.GhC != null) {
        paramInt = i + f.a.a.a.lm(8, this.GhC.computeSize());
      }
      AppMethodBeat.o(153340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eby localeby = (eby)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153340);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeby.Ghv = ((eca)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeby.Ghw = ((ebz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeby.Ghx = ((ecb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeby.Ghy = ((ecd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeby.Ghz = ((ecc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeby.GhA = ((ecf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeby.GhB = ((ebx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ece();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ece)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeby.GhC = ((ece)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      AppMethodBeat.o(153340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eby
 * JD-Core Version:    0.7.0.1
 */
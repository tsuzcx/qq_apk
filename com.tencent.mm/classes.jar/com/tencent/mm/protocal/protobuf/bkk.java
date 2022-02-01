package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkk
  extends com.tencent.mm.bw.a
{
  public int EZX;
  public bkn EZY;
  public bkm EZZ;
  public bkl Faa;
  public bkj Fab;
  public bko Fac;
  public bkp Fad;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32324);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EZX);
      if (this.EZY != null)
      {
        paramVarArgs.ln(2, this.EZY.computeSize());
        this.EZY.writeFields(paramVarArgs);
      }
      if (this.EZZ != null)
      {
        paramVarArgs.ln(3, this.EZZ.computeSize());
        this.EZZ.writeFields(paramVarArgs);
      }
      if (this.Faa != null)
      {
        paramVarArgs.ln(4, this.Faa.computeSize());
        this.Faa.writeFields(paramVarArgs);
      }
      if (this.Fab != null)
      {
        paramVarArgs.ln(5, this.Fab.computeSize());
        this.Fab.writeFields(paramVarArgs);
      }
      if (this.Fac != null)
      {
        paramVarArgs.ln(6, this.Fac.computeSize());
        this.Fac.writeFields(paramVarArgs);
      }
      if (this.Fad != null)
      {
        paramVarArgs.ln(7, this.Fad.computeSize());
        this.Fad.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EZX) + 0;
      paramInt = i;
      if (this.EZY != null) {
        paramInt = i + f.a.a.a.lm(2, this.EZY.computeSize());
      }
      i = paramInt;
      if (this.EZZ != null) {
        i = paramInt + f.a.a.a.lm(3, this.EZZ.computeSize());
      }
      paramInt = i;
      if (this.Faa != null) {
        paramInt = i + f.a.a.a.lm(4, this.Faa.computeSize());
      }
      i = paramInt;
      if (this.Fab != null) {
        i = paramInt + f.a.a.a.lm(5, this.Fab.computeSize());
      }
      paramInt = i;
      if (this.Fac != null) {
        paramInt = i + f.a.a.a.lm(6, this.Fac.computeSize());
      }
      i = paramInt;
      if (this.Fad != null) {
        i = paramInt + f.a.a.a.lm(7, this.Fad.computeSize());
      }
      AppMethodBeat.o(32324);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bkk localbkk = (bkk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32324);
        return -1;
      case 1: 
        localbkk.EZX = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32324);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbkk.EZY = ((bkn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbkk.EZZ = ((bkm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbkk.Faa = ((bkl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbkk.Fab = ((bkj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bko();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bko)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbkk.Fac = ((bko)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bkp();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bkp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbkk.Fad = ((bkp)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    AppMethodBeat.o(32324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkk
 * JD-Core Version:    0.7.0.1
 */
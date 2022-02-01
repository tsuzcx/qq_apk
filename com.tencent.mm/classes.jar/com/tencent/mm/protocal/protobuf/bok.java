package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bok
  extends com.tencent.mm.bw.a
{
  public iz Hbr;
  public sd Hbs;
  public bzo Hbt;
  public djm Hbu;
  public cyl Hbv;
  public zz Hbw;
  public alf Hbx;
  public aut Hby;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hbr != null)
      {
        paramVarArgs.lJ(1, this.Hbr.computeSize());
        this.Hbr.writeFields(paramVarArgs);
      }
      if (this.Hbs != null)
      {
        paramVarArgs.lJ(2, this.Hbs.computeSize());
        this.Hbs.writeFields(paramVarArgs);
      }
      if (this.Hbt != null)
      {
        paramVarArgs.lJ(3, this.Hbt.computeSize());
        this.Hbt.writeFields(paramVarArgs);
      }
      if (this.Hbu != null)
      {
        paramVarArgs.lJ(4, this.Hbu.computeSize());
        this.Hbu.writeFields(paramVarArgs);
      }
      if (this.Hbv != null)
      {
        paramVarArgs.lJ(6, this.Hbv.computeSize());
        this.Hbv.writeFields(paramVarArgs);
      }
      if (this.Hbw != null)
      {
        paramVarArgs.lJ(7, this.Hbw.computeSize());
        this.Hbw.writeFields(paramVarArgs);
      }
      if (this.Hbx != null)
      {
        paramVarArgs.lJ(8, this.Hbx.computeSize());
        this.Hbx.writeFields(paramVarArgs);
      }
      if (this.Hby != null)
      {
        paramVarArgs.lJ(9, this.Hby.computeSize());
        this.Hby.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hbr == null) {
        break label1402;
      }
    }
    label1402:
    for (int i = f.a.a.a.lI(1, this.Hbr.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hbs != null) {
        paramInt = i + f.a.a.a.lI(2, this.Hbs.computeSize());
      }
      i = paramInt;
      if (this.Hbt != null) {
        i = paramInt + f.a.a.a.lI(3, this.Hbt.computeSize());
      }
      paramInt = i;
      if (this.Hbu != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hbu.computeSize());
      }
      i = paramInt;
      if (this.Hbv != null) {
        i = paramInt + f.a.a.a.lI(6, this.Hbv.computeSize());
      }
      paramInt = i;
      if (this.Hbw != null) {
        paramInt = i + f.a.a.a.lI(7, this.Hbw.computeSize());
      }
      i = paramInt;
      if (this.Hbx != null) {
        i = paramInt + f.a.a.a.lI(8, this.Hbx.computeSize());
      }
      paramInt = i;
      if (this.Hby != null) {
        paramInt = i + f.a.a.a.lI(9, this.Hby.computeSize());
      }
      AppMethodBeat.o(116471);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bok localbok = (bok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(116471);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.Hbr = ((iz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.Hbs = ((sd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.Hbt = ((bzo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.Hbu = ((djm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.Hbv = ((cyl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.Hbw = ((zz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbok.Hbx = ((alf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aut();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aut)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbok.Hby = ((aut)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      AppMethodBeat.o(116471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bok
 * JD-Core Version:    0.7.0.1
 */
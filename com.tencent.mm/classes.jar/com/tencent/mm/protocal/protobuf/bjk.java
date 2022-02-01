package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjk
  extends com.tencent.mm.bw.a
{
  public aqh EYA;
  public is EYt;
  public qk EYu;
  public buf EYv;
  public dde EYw;
  public csh EYx;
  public xx EYy;
  public aif EYz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EYt != null)
      {
        paramVarArgs.ln(1, this.EYt.computeSize());
        this.EYt.writeFields(paramVarArgs);
      }
      if (this.EYu != null)
      {
        paramVarArgs.ln(2, this.EYu.computeSize());
        this.EYu.writeFields(paramVarArgs);
      }
      if (this.EYv != null)
      {
        paramVarArgs.ln(3, this.EYv.computeSize());
        this.EYv.writeFields(paramVarArgs);
      }
      if (this.EYw != null)
      {
        paramVarArgs.ln(4, this.EYw.computeSize());
        this.EYw.writeFields(paramVarArgs);
      }
      if (this.EYx != null)
      {
        paramVarArgs.ln(6, this.EYx.computeSize());
        this.EYx.writeFields(paramVarArgs);
      }
      if (this.EYy != null)
      {
        paramVarArgs.ln(7, this.EYy.computeSize());
        this.EYy.writeFields(paramVarArgs);
      }
      if (this.EYz != null)
      {
        paramVarArgs.ln(8, this.EYz.computeSize());
        this.EYz.writeFields(paramVarArgs);
      }
      if (this.EYA != null)
      {
        paramVarArgs.ln(9, this.EYA.computeSize());
        this.EYA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(116471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EYt == null) {
        break label1402;
      }
    }
    label1402:
    for (int i = f.a.a.a.lm(1, this.EYt.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EYu != null) {
        paramInt = i + f.a.a.a.lm(2, this.EYu.computeSize());
      }
      i = paramInt;
      if (this.EYv != null) {
        i = paramInt + f.a.a.a.lm(3, this.EYv.computeSize());
      }
      paramInt = i;
      if (this.EYw != null) {
        paramInt = i + f.a.a.a.lm(4, this.EYw.computeSize());
      }
      i = paramInt;
      if (this.EYx != null) {
        i = paramInt + f.a.a.a.lm(6, this.EYx.computeSize());
      }
      paramInt = i;
      if (this.EYy != null) {
        paramInt = i + f.a.a.a.lm(7, this.EYy.computeSize());
      }
      i = paramInt;
      if (this.EYz != null) {
        i = paramInt + f.a.a.a.lm(8, this.EYz.computeSize());
      }
      paramInt = i;
      if (this.EYA != null) {
        paramInt = i + f.a.a.a.lm(9, this.EYA.computeSize());
      }
      AppMethodBeat.o(116471);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjk localbjk = (bjk)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new is();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((is)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjk.EYt = ((is)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjk.EYu = ((qk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjk.EYv = ((buf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dde();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dde)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjk.EYw = ((dde)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjk.EYx = ((csh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjk.EYy = ((xx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aif();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aif)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjk.EYz = ((aif)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116471);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aqh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjk.EYA = ((aqh)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjk
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dch
  extends com.tencent.mm.bw.a
{
  public cie HKJ;
  public cia HKK;
  public cie HKL;
  public cia HKM;
  public boolean HKN = false;
  public boolean HKO = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196285);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HKJ != null)
      {
        paramVarArgs.lJ(1, this.HKJ.computeSize());
        this.HKJ.writeFields(paramVarArgs);
      }
      if (this.HKK != null)
      {
        paramVarArgs.lJ(2, this.HKK.computeSize());
        this.HKK.writeFields(paramVarArgs);
      }
      if (this.HKL != null)
      {
        paramVarArgs.lJ(3, this.HKL.computeSize());
        this.HKL.writeFields(paramVarArgs);
      }
      if (this.HKM != null)
      {
        paramVarArgs.lJ(4, this.HKM.computeSize());
        this.HKM.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(5, this.HKN);
      paramVarArgs.bC(6, this.HKO);
      AppMethodBeat.o(196285);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HKJ == null) {
        break label858;
      }
    }
    label858:
    for (int i = f.a.a.a.lI(1, this.HKJ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HKK != null) {
        paramInt = i + f.a.a.a.lI(2, this.HKK.computeSize());
      }
      i = paramInt;
      if (this.HKL != null) {
        i = paramInt + f.a.a.a.lI(3, this.HKL.computeSize());
      }
      paramInt = i;
      if (this.HKM != null) {
        paramInt = i + f.a.a.a.lI(4, this.HKM.computeSize());
      }
      i = f.a.a.b.b.a.amF(5);
      int j = f.a.a.b.b.a.amF(6);
      AppMethodBeat.o(196285);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(196285);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dch localdch = (dch)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196285);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cie();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cie)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdch.HKJ = ((cie)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196285);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdch.HKK = ((cia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196285);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cie();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cie)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdch.HKL = ((cie)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196285);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdch.HKM = ((cia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196285);
          return 0;
        case 5: 
          localdch.HKN = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(196285);
          return 0;
        }
        localdch.HKO = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(196285);
        return 0;
      }
      AppMethodBeat.o(196285);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dch
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class feo
  extends com.tencent.mm.bw.a
{
  public feq NzS;
  public fep NzT;
  public fer NzU;
  public fet NzV;
  public fes NzW;
  public fev NzX;
  public fen NzY;
  public feu NzZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153340);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NzS != null)
      {
        paramVarArgs.ni(1, this.NzS.computeSize());
        this.NzS.writeFields(paramVarArgs);
      }
      if (this.NzT != null)
      {
        paramVarArgs.ni(2, this.NzT.computeSize());
        this.NzT.writeFields(paramVarArgs);
      }
      if (this.NzU != null)
      {
        paramVarArgs.ni(3, this.NzU.computeSize());
        this.NzU.writeFields(paramVarArgs);
      }
      if (this.NzV != null)
      {
        paramVarArgs.ni(4, this.NzV.computeSize());
        this.NzV.writeFields(paramVarArgs);
      }
      if (this.NzW != null)
      {
        paramVarArgs.ni(5, this.NzW.computeSize());
        this.NzW.writeFields(paramVarArgs);
      }
      if (this.NzX != null)
      {
        paramVarArgs.ni(6, this.NzX.computeSize());
        this.NzX.writeFields(paramVarArgs);
      }
      if (this.NzY != null)
      {
        paramVarArgs.ni(7, this.NzY.computeSize());
        this.NzY.writeFields(paramVarArgs);
      }
      if (this.NzZ != null)
      {
        paramVarArgs.ni(8, this.NzZ.computeSize());
        this.NzZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NzS == null) {
        break label1394;
      }
    }
    label1394:
    for (int i = g.a.a.a.nh(1, this.NzS.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.NzT != null) {
        paramInt = i + g.a.a.a.nh(2, this.NzT.computeSize());
      }
      i = paramInt;
      if (this.NzU != null) {
        i = paramInt + g.a.a.a.nh(3, this.NzU.computeSize());
      }
      paramInt = i;
      if (this.NzV != null) {
        paramInt = i + g.a.a.a.nh(4, this.NzV.computeSize());
      }
      i = paramInt;
      if (this.NzW != null) {
        i = paramInt + g.a.a.a.nh(5, this.NzW.computeSize());
      }
      paramInt = i;
      if (this.NzX != null) {
        paramInt = i + g.a.a.a.nh(6, this.NzX.computeSize());
      }
      i = paramInt;
      if (this.NzY != null) {
        i = paramInt + g.a.a.a.nh(7, this.NzY.computeSize());
      }
      paramInt = i;
      if (this.NzZ != null) {
        paramInt = i + g.a.a.a.nh(8, this.NzZ.computeSize());
      }
      AppMethodBeat.o(153340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        feo localfeo = (feo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153340);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new feq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((feq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfeo.NzS = ((feq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fep();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fep)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfeo.NzT = ((fep)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fer();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fer)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfeo.NzU = ((fer)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fet();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fet)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfeo.NzV = ((fet)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fes();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fes)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfeo.NzW = ((fes)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fev();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fev)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfeo.NzX = ((fev)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fen();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fen)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfeo.NzY = ((fen)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new feu();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((feu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfeo.NzZ = ((feu)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.feo
 * JD-Core Version:    0.7.0.1
 */
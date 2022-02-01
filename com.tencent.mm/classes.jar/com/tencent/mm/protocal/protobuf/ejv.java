package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejv
  extends com.tencent.mm.bw.a
{
  public ejx ImQ;
  public ejw ImR;
  public ejy ImS;
  public eka ImT;
  public ejz ImU;
  public ekc ImV;
  public eju ImW;
  public ekb ImX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ImQ != null)
      {
        paramVarArgs.lJ(1, this.ImQ.computeSize());
        this.ImQ.writeFields(paramVarArgs);
      }
      if (this.ImR != null)
      {
        paramVarArgs.lJ(2, this.ImR.computeSize());
        this.ImR.writeFields(paramVarArgs);
      }
      if (this.ImS != null)
      {
        paramVarArgs.lJ(3, this.ImS.computeSize());
        this.ImS.writeFields(paramVarArgs);
      }
      if (this.ImT != null)
      {
        paramVarArgs.lJ(4, this.ImT.computeSize());
        this.ImT.writeFields(paramVarArgs);
      }
      if (this.ImU != null)
      {
        paramVarArgs.lJ(5, this.ImU.computeSize());
        this.ImU.writeFields(paramVarArgs);
      }
      if (this.ImV != null)
      {
        paramVarArgs.lJ(6, this.ImV.computeSize());
        this.ImV.writeFields(paramVarArgs);
      }
      if (this.ImW != null)
      {
        paramVarArgs.lJ(7, this.ImW.computeSize());
        this.ImW.writeFields(paramVarArgs);
      }
      if (this.ImX != null)
      {
        paramVarArgs.lJ(8, this.ImX.computeSize());
        this.ImX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ImQ == null) {
        break label1394;
      }
    }
    label1394:
    for (int i = f.a.a.a.lI(1, this.ImQ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ImR != null) {
        paramInt = i + f.a.a.a.lI(2, this.ImR.computeSize());
      }
      i = paramInt;
      if (this.ImS != null) {
        i = paramInt + f.a.a.a.lI(3, this.ImS.computeSize());
      }
      paramInt = i;
      if (this.ImT != null) {
        paramInt = i + f.a.a.a.lI(4, this.ImT.computeSize());
      }
      i = paramInt;
      if (this.ImU != null) {
        i = paramInt + f.a.a.a.lI(5, this.ImU.computeSize());
      }
      paramInt = i;
      if (this.ImV != null) {
        paramInt = i + f.a.a.a.lI(6, this.ImV.computeSize());
      }
      i = paramInt;
      if (this.ImW != null) {
        i = paramInt + f.a.a.a.lI(7, this.ImW.computeSize());
      }
      paramInt = i;
      if (this.ImX != null) {
        paramInt = i + f.a.a.a.lI(8, this.ImX.computeSize());
      }
      AppMethodBeat.o(153340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ejv localejv = (ejv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153340);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localejv.ImQ = ((ejx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localejv.ImR = ((ejw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localejv.ImS = ((ejy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eka();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eka)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localejv.ImT = ((eka)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ejz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localejv.ImU = ((ejz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localejv.ImV = ((ekc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eju();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eju)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localejv.ImW = ((eju)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ekb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ekb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localejv.ImX = ((ekb)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejv
 * JD-Core Version:    0.7.0.1
 */
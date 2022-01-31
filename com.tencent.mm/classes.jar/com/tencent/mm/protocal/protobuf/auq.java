package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class auq
  extends com.tencent.mm.bv.a
{
  public ho xjC;
  public nv xjD;
  public bcy xjE;
  public cgq xjF;
  public bww xjG;
  public uf xjH;
  public adi xjI;
  public ael xjJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2542);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xjC != null)
      {
        paramVarArgs.iQ(1, this.xjC.computeSize());
        this.xjC.writeFields(paramVarArgs);
      }
      if (this.xjD != null)
      {
        paramVarArgs.iQ(2, this.xjD.computeSize());
        this.xjD.writeFields(paramVarArgs);
      }
      if (this.xjE != null)
      {
        paramVarArgs.iQ(3, this.xjE.computeSize());
        this.xjE.writeFields(paramVarArgs);
      }
      if (this.xjF != null)
      {
        paramVarArgs.iQ(4, this.xjF.computeSize());
        this.xjF.writeFields(paramVarArgs);
      }
      if (this.xjG != null)
      {
        paramVarArgs.iQ(6, this.xjG.computeSize());
        this.xjG.writeFields(paramVarArgs);
      }
      if (this.xjH != null)
      {
        paramVarArgs.iQ(7, this.xjH.computeSize());
        this.xjH.writeFields(paramVarArgs);
      }
      if (this.xjI != null)
      {
        paramVarArgs.iQ(8, this.xjI.computeSize());
        this.xjI.writeFields(paramVarArgs);
      }
      if (this.xjJ != null)
      {
        paramVarArgs.iQ(9, this.xjJ.computeSize());
        this.xjJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(2542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xjC == null) {
        break label1416;
      }
    }
    label1416:
    for (int i = e.a.a.a.iP(1, this.xjC.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xjD != null) {
        paramInt = i + e.a.a.a.iP(2, this.xjD.computeSize());
      }
      i = paramInt;
      if (this.xjE != null) {
        i = paramInt + e.a.a.a.iP(3, this.xjE.computeSize());
      }
      paramInt = i;
      if (this.xjF != null) {
        paramInt = i + e.a.a.a.iP(4, this.xjF.computeSize());
      }
      i = paramInt;
      if (this.xjG != null) {
        i = paramInt + e.a.a.a.iP(6, this.xjG.computeSize());
      }
      paramInt = i;
      if (this.xjH != null) {
        paramInt = i + e.a.a.a.iP(7, this.xjH.computeSize());
      }
      i = paramInt;
      if (this.xjI != null) {
        i = paramInt + e.a.a.a.iP(8, this.xjI.computeSize());
      }
      paramInt = i;
      if (this.xjJ != null) {
        paramInt = i + e.a.a.a.iP(9, this.xjJ.computeSize());
      }
      AppMethodBeat.o(2542);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(2542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        auq localauq = (auq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(2542);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ho();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ho)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauq.xjC = ((ho)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(2542);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauq.xjD = ((nv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(2542);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcy();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauq.xjE = ((bcy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(2542);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauq.xjF = ((cgq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(2542);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bww();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bww)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauq.xjG = ((bww)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(2542);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauq.xjH = ((uf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(2542);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new adi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((adi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localauq.xjI = ((adi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(2542);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ael();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ael)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localauq.xjJ = ((ael)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(2542);
        return 0;
      }
      AppMethodBeat.o(2542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auq
 * JD-Core Version:    0.7.0.1
 */
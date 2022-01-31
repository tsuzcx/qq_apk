package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbi
  extends com.tencent.mm.bv.a
{
  public dbk yhE;
  public dbj yhF;
  public dbl yhG;
  public dbn yhH;
  public dbm yhI;
  public dbo yhJ;
  public dbh yhK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115018);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yhE != null)
      {
        paramVarArgs.iQ(1, this.yhE.computeSize());
        this.yhE.writeFields(paramVarArgs);
      }
      if (this.yhF != null)
      {
        paramVarArgs.iQ(2, this.yhF.computeSize());
        this.yhF.writeFields(paramVarArgs);
      }
      if (this.yhG != null)
      {
        paramVarArgs.iQ(3, this.yhG.computeSize());
        this.yhG.writeFields(paramVarArgs);
      }
      if (this.yhH != null)
      {
        paramVarArgs.iQ(4, this.yhH.computeSize());
        this.yhH.writeFields(paramVarArgs);
      }
      if (this.yhI != null)
      {
        paramVarArgs.iQ(5, this.yhI.computeSize());
        this.yhI.writeFields(paramVarArgs);
      }
      if (this.yhJ != null)
      {
        paramVarArgs.iQ(6, this.yhJ.computeSize());
        this.yhJ.writeFields(paramVarArgs);
      }
      if (this.yhK != null)
      {
        paramVarArgs.iQ(7, this.yhK.computeSize());
        this.yhK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115018);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhE == null) {
        break label1238;
      }
    }
    label1238:
    for (int i = e.a.a.a.iP(1, this.yhE.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yhF != null) {
        paramInt = i + e.a.a.a.iP(2, this.yhF.computeSize());
      }
      i = paramInt;
      if (this.yhG != null) {
        i = paramInt + e.a.a.a.iP(3, this.yhG.computeSize());
      }
      paramInt = i;
      if (this.yhH != null) {
        paramInt = i + e.a.a.a.iP(4, this.yhH.computeSize());
      }
      i = paramInt;
      if (this.yhI != null) {
        i = paramInt + e.a.a.a.iP(5, this.yhI.computeSize());
      }
      paramInt = i;
      if (this.yhJ != null) {
        paramInt = i + e.a.a.a.iP(6, this.yhJ.computeSize());
      }
      i = paramInt;
      if (this.yhK != null) {
        i = paramInt + e.a.a.a.iP(7, this.yhK.computeSize());
      }
      AppMethodBeat.o(115018);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(115018);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        dbi localdbi = (dbi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115018);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbk();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbk)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdbi.yhE = ((dbk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115018);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdbi.yhF = ((dbj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115018);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdbi.yhG = ((dbl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115018);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdbi.yhH = ((dbn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115018);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdbi.yhI = ((dbm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115018);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbo();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdbi.yhJ = ((dbo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115018);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbh();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localdbi.yhK = ((dbh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115018);
        return 0;
      }
      AppMethodBeat.o(115018);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbi
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bi
  extends com.tencent.mm.bw.a
{
  public bj FLB;
  public bj FLC;
  public bj FLD;
  public bj FLE;
  public bj FLF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FLB != null)
      {
        paramVarArgs.lJ(1, this.FLB.computeSize());
        this.FLB.writeFields(paramVarArgs);
      }
      if (this.FLC != null)
      {
        paramVarArgs.lJ(2, this.FLC.computeSize());
        this.FLC.writeFields(paramVarArgs);
      }
      if (this.FLD != null)
      {
        paramVarArgs.lJ(3, this.FLD.computeSize());
        this.FLD.writeFields(paramVarArgs);
      }
      if (this.FLE != null)
      {
        paramVarArgs.lJ(4, this.FLE.computeSize());
        this.FLE.writeFields(paramVarArgs);
      }
      if (this.FLF != null)
      {
        paramVarArgs.lJ(5, this.FLF.computeSize());
        this.FLF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FLB == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.lI(1, this.FLB.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FLC != null) {
        paramInt = i + f.a.a.a.lI(2, this.FLC.computeSize());
      }
      i = paramInt;
      if (this.FLD != null) {
        i = paramInt + f.a.a.a.lI(3, this.FLD.computeSize());
      }
      paramInt = i;
      if (this.FLE != null) {
        paramInt = i + f.a.a.a.lI(4, this.FLE.computeSize());
      }
      i = paramInt;
      if (this.FLF != null) {
        i = paramInt + f.a.a.a.lI(5, this.FLF.computeSize());
      }
      AppMethodBeat.o(122481);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bi localbi = (bi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122481);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.FLB = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.FLC = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.FLD = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.FLE = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbi.FLF = ((bj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122481);
        return 0;
      }
      AppMethodBeat.o(122481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bi
 * JD-Core Version:    0.7.0.1
 */
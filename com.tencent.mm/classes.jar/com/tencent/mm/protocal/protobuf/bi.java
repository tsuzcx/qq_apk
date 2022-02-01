package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bi
  extends com.tencent.mm.bw.a
{
  public bj DNX;
  public bj DNY;
  public bj DNZ;
  public bj DOa;
  public bj DOb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DNX != null)
      {
        paramVarArgs.ln(1, this.DNX.computeSize());
        this.DNX.writeFields(paramVarArgs);
      }
      if (this.DNY != null)
      {
        paramVarArgs.ln(2, this.DNY.computeSize());
        this.DNY.writeFields(paramVarArgs);
      }
      if (this.DNZ != null)
      {
        paramVarArgs.ln(3, this.DNZ.computeSize());
        this.DNZ.writeFields(paramVarArgs);
      }
      if (this.DOa != null)
      {
        paramVarArgs.ln(4, this.DOa.computeSize());
        this.DOa.writeFields(paramVarArgs);
      }
      if (this.DOb != null)
      {
        paramVarArgs.ln(5, this.DOb.computeSize());
        this.DOb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DNX == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.lm(1, this.DNX.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DNY != null) {
        paramInt = i + f.a.a.a.lm(2, this.DNY.computeSize());
      }
      i = paramInt;
      if (this.DNZ != null) {
        i = paramInt + f.a.a.a.lm(3, this.DNZ.computeSize());
      }
      paramInt = i;
      if (this.DOa != null) {
        paramInt = i + f.a.a.a.lm(4, this.DOa.computeSize());
      }
      i = paramInt;
      if (this.DOb != null) {
        i = paramInt + f.a.a.a.lm(5, this.DOb.computeSize());
      }
      AppMethodBeat.o(122481);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.DNX = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.DNY = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.DNZ = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.DOa = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbi.DOb = ((bj)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bi
 * JD-Core Version:    0.7.0.1
 */
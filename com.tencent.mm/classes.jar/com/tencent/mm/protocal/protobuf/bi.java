package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bi
  extends com.tencent.mm.bx.a
{
  public bj Ftd;
  public bj Fte;
  public bj Ftf;
  public bj Ftg;
  public bj Fth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ftd != null)
      {
        paramVarArgs.lC(1, this.Ftd.computeSize());
        this.Ftd.writeFields(paramVarArgs);
      }
      if (this.Fte != null)
      {
        paramVarArgs.lC(2, this.Fte.computeSize());
        this.Fte.writeFields(paramVarArgs);
      }
      if (this.Ftf != null)
      {
        paramVarArgs.lC(3, this.Ftf.computeSize());
        this.Ftf.writeFields(paramVarArgs);
      }
      if (this.Ftg != null)
      {
        paramVarArgs.lC(4, this.Ftg.computeSize());
        this.Ftg.writeFields(paramVarArgs);
      }
      if (this.Fth != null)
      {
        paramVarArgs.lC(5, this.Fth.computeSize());
        this.Fth.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ftd == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.lB(1, this.Ftd.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fte != null) {
        paramInt = i + f.a.a.a.lB(2, this.Fte.computeSize());
      }
      i = paramInt;
      if (this.Ftf != null) {
        i = paramInt + f.a.a.a.lB(3, this.Ftf.computeSize());
      }
      paramInt = i;
      if (this.Ftg != null) {
        paramInt = i + f.a.a.a.lB(4, this.Ftg.computeSize());
      }
      i = paramInt;
      if (this.Fth != null) {
        i = paramInt + f.a.a.a.lB(5, this.Fth.computeSize());
      }
      AppMethodBeat.o(122481);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.Ftd = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.Fte = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.Ftf = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbi.Ftg = ((bj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbi.Fth = ((bj)localObject1);
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
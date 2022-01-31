package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lf
  extends com.tencent.mm.bv.a
{
  public uq wzu;
  public lw wzv;
  public ld wzw;
  public ly wzx;
  public lx wzy;
  public kg wzz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151372);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wzu != null)
      {
        paramVarArgs.iQ(1, this.wzu.computeSize());
        this.wzu.writeFields(paramVarArgs);
      }
      if (this.wzv != null)
      {
        paramVarArgs.iQ(2, this.wzv.computeSize());
        this.wzv.writeFields(paramVarArgs);
      }
      if (this.wzw != null)
      {
        paramVarArgs.iQ(3, this.wzw.computeSize());
        this.wzw.writeFields(paramVarArgs);
      }
      if (this.wzx != null)
      {
        paramVarArgs.iQ(4, this.wzx.computeSize());
        this.wzx.writeFields(paramVarArgs);
      }
      if (this.wzy != null)
      {
        paramVarArgs.iQ(5, this.wzy.computeSize());
        this.wzy.writeFields(paramVarArgs);
      }
      if (this.wzz != null)
      {
        paramVarArgs.iQ(6, this.wzz.computeSize());
        this.wzz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(151372);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wzu == null) {
        break label1082;
      }
    }
    label1082:
    for (int i = e.a.a.a.iP(1, this.wzu.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wzv != null) {
        paramInt = i + e.a.a.a.iP(2, this.wzv.computeSize());
      }
      i = paramInt;
      if (this.wzw != null) {
        i = paramInt + e.a.a.a.iP(3, this.wzw.computeSize());
      }
      paramInt = i;
      if (this.wzx != null) {
        paramInt = i + e.a.a.a.iP(4, this.wzx.computeSize());
      }
      i = paramInt;
      if (this.wzy != null) {
        i = paramInt + e.a.a.a.iP(5, this.wzy.computeSize());
      }
      paramInt = i;
      if (this.wzz != null) {
        paramInt = i + e.a.a.a.iP(6, this.wzz.computeSize());
      }
      AppMethodBeat.o(151372);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151372);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        lf locallf = (lf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151372);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallf.wzu = ((uq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151372);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallf.wzv = ((lw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151372);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ld();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ld)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallf.wzw = ((ld)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151372);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ly();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ly)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallf.wzx = ((ly)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151372);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallf.wzy = ((lx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151372);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((kg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locallf.wzz = ((kg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151372);
        return 0;
      }
      AppMethodBeat.o(151372);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lf
 * JD-Core Version:    0.7.0.1
 */
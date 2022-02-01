package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mv
  extends com.tencent.mm.bx.a
{
  public xq CKn;
  public nt CKo;
  public mt CKp;
  public ny CKq;
  public nw CKr;
  public ls CKs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CKn != null)
      {
        paramVarArgs.kX(1, this.CKn.computeSize());
        this.CKn.writeFields(paramVarArgs);
      }
      if (this.CKo != null)
      {
        paramVarArgs.kX(2, this.CKo.computeSize());
        this.CKo.writeFields(paramVarArgs);
      }
      if (this.CKp != null)
      {
        paramVarArgs.kX(3, this.CKp.computeSize());
        this.CKp.writeFields(paramVarArgs);
      }
      if (this.CKq != null)
      {
        paramVarArgs.kX(4, this.CKq.computeSize());
        this.CKq.writeFields(paramVarArgs);
      }
      if (this.CKr != null)
      {
        paramVarArgs.kX(5, this.CKr.computeSize());
        this.CKr.writeFields(paramVarArgs);
      }
      if (this.CKs != null)
      {
        paramVarArgs.kX(6, this.CKs.computeSize());
        this.CKs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CKn == null) {
        break label1082;
      }
    }
    label1082:
    for (int i = f.a.a.a.kW(1, this.CKn.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CKo != null) {
        paramInt = i + f.a.a.a.kW(2, this.CKo.computeSize());
      }
      i = paramInt;
      if (this.CKp != null) {
        i = paramInt + f.a.a.a.kW(3, this.CKp.computeSize());
      }
      paramInt = i;
      if (this.CKq != null) {
        paramInt = i + f.a.a.a.kW(4, this.CKq.computeSize());
      }
      i = paramInt;
      if (this.CKr != null) {
        i = paramInt + f.a.a.a.kW(5, this.CKr.computeSize());
      }
      paramInt = i;
      if (this.CKs != null) {
        paramInt = i + f.a.a.a.kW(6, this.CKs.computeSize());
      }
      AppMethodBeat.o(124434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mv localmv = (mv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124434);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmv.CKn = ((xq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmv.CKo = ((nt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmv.CKp = ((mt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ny();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ny)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmv.CKq = ((ny)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmv.CKr = ((nw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ls();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ls)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localmv.CKs = ((ls)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      AppMethodBeat.o(124434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mv
 * JD-Core Version:    0.7.0.1
 */
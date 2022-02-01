package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ou
  extends com.tencent.mm.bw.a
{
  public acb KVq;
  public qe KVr;
  public op KVs;
  public qm KVt;
  public qk KVu;
  public ni KVv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124434);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KVq != null)
      {
        paramVarArgs.ni(1, this.KVq.computeSize());
        this.KVq.writeFields(paramVarArgs);
      }
      if (this.KVr != null)
      {
        paramVarArgs.ni(2, this.KVr.computeSize());
        this.KVr.writeFields(paramVarArgs);
      }
      if (this.KVs != null)
      {
        paramVarArgs.ni(3, this.KVs.computeSize());
        this.KVs.writeFields(paramVarArgs);
      }
      if (this.KVt != null)
      {
        paramVarArgs.ni(4, this.KVt.computeSize());
        this.KVt.writeFields(paramVarArgs);
      }
      if (this.KVu != null)
      {
        paramVarArgs.ni(5, this.KVu.computeSize());
        this.KVu.writeFields(paramVarArgs);
      }
      if (this.KVv != null)
      {
        paramVarArgs.ni(6, this.KVv.computeSize());
        this.KVv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KVq == null) {
        break label1082;
      }
    }
    label1082:
    for (int i = g.a.a.a.nh(1, this.KVq.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KVr != null) {
        paramInt = i + g.a.a.a.nh(2, this.KVr.computeSize());
      }
      i = paramInt;
      if (this.KVs != null) {
        i = paramInt + g.a.a.a.nh(3, this.KVs.computeSize());
      }
      paramInt = i;
      if (this.KVt != null) {
        paramInt = i + g.a.a.a.nh(4, this.KVt.computeSize());
      }
      i = paramInt;
      if (this.KVu != null) {
        i = paramInt + g.a.a.a.nh(5, this.KVu.computeSize());
      }
      paramInt = i;
      if (this.KVv != null) {
        paramInt = i + g.a.a.a.nh(6, this.KVv.computeSize());
      }
      AppMethodBeat.o(124434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ou localou = (ou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124434);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localou.KVq = ((acb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localou.KVr = ((qe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new op();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((op)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localou.KVs = ((op)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localou.KVt = ((qm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localou.KVu = ((qk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ni();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ni)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localou.KVv = ((ni)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ou
 * JD-Core Version:    0.7.0.1
 */
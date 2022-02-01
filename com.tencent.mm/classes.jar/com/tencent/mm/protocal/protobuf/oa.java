package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oa
  extends com.tencent.mm.bw.a
{
  public aak Gbs;
  public ph Gbt;
  public nw Gbu;
  public pm Gbv;
  public pk Gbw;
  public mq Gbx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gbs != null)
      {
        paramVarArgs.lJ(1, this.Gbs.computeSize());
        this.Gbs.writeFields(paramVarArgs);
      }
      if (this.Gbt != null)
      {
        paramVarArgs.lJ(2, this.Gbt.computeSize());
        this.Gbt.writeFields(paramVarArgs);
      }
      if (this.Gbu != null)
      {
        paramVarArgs.lJ(3, this.Gbu.computeSize());
        this.Gbu.writeFields(paramVarArgs);
      }
      if (this.Gbv != null)
      {
        paramVarArgs.lJ(4, this.Gbv.computeSize());
        this.Gbv.writeFields(paramVarArgs);
      }
      if (this.Gbw != null)
      {
        paramVarArgs.lJ(5, this.Gbw.computeSize());
        this.Gbw.writeFields(paramVarArgs);
      }
      if (this.Gbx != null)
      {
        paramVarArgs.lJ(6, this.Gbx.computeSize());
        this.Gbx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gbs == null) {
        break label1082;
      }
    }
    label1082:
    for (int i = f.a.a.a.lI(1, this.Gbs.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gbt != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gbt.computeSize());
      }
      i = paramInt;
      if (this.Gbu != null) {
        i = paramInt + f.a.a.a.lI(3, this.Gbu.computeSize());
      }
      paramInt = i;
      if (this.Gbv != null) {
        paramInt = i + f.a.a.a.lI(4, this.Gbv.computeSize());
      }
      i = paramInt;
      if (this.Gbw != null) {
        i = paramInt + f.a.a.a.lI(5, this.Gbw.computeSize());
      }
      paramInt = i;
      if (this.Gbx != null) {
        paramInt = i + f.a.a.a.lI(6, this.Gbx.computeSize());
      }
      AppMethodBeat.o(124434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oa localoa = (oa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124434);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aak();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoa.Gbs = ((aak)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ph();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ph)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoa.Gbt = ((ph)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoa.Gbu = ((nw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoa.Gbv = ((pm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoa.Gbw = ((pk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124434);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localoa.Gbx = ((mq)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oa
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqr
  extends com.tencent.mm.bx.a
{
  public LinkedList<dqp> Fru;
  public buf HEA;
  public int HEB;
  public dqq HEC;
  public dqq HED;
  public String HEy;
  public String HEz;
  public int HiB;
  public String desc;
  public String title;
  
  public dqr()
  {
    AppMethodBeat.i(72617);
    this.Fru = new LinkedList();
    AppMethodBeat.o(72617);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.HEy != null) {
        paramVarArgs.d(3, this.HEy);
      }
      if (this.HEz != null) {
        paramVarArgs.d(4, this.HEz);
      }
      if (this.HEA != null)
      {
        paramVarArgs.lC(5, this.HEA.computeSize());
        this.HEA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.Fru);
      paramVarArgs.aS(7, this.HiB);
      paramVarArgs.aS(8, this.HEB);
      if (this.HEC != null)
      {
        paramVarArgs.lC(9, this.HEC.computeSize());
        this.HEC.writeFields(paramVarArgs);
      }
      if (this.HED != null)
      {
        paramVarArgs.lC(10, this.HED.computeSize());
        this.HED.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.HEy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HEy);
      }
      paramInt = i;
      if (this.HEz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HEz);
      }
      i = paramInt;
      if (this.HEA != null) {
        i = paramInt + f.a.a.a.lB(5, this.HEA.computeSize());
      }
      i = i + f.a.a.a.c(6, 8, this.Fru) + f.a.a.b.b.a.bz(7, this.HiB) + f.a.a.b.b.a.bz(8, this.HEB);
      paramInt = i;
      if (this.HEC != null) {
        paramInt = i + f.a.a.a.lB(9, this.HEC.computeSize());
      }
      i = paramInt;
      if (this.HED != null) {
        i = paramInt + f.a.a.a.lB(10, this.HED.computeSize());
      }
      AppMethodBeat.o(72618);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fru.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqr localdqr = (dqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72618);
          return -1;
        case 1: 
          localdqr.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 2: 
          localdqr.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 3: 
          localdqr.HEy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 4: 
          localdqr.HEz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72618);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new buf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((buf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqr.HEA = ((buf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqr.Fru.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        case 7: 
          localdqr.HiB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72618);
          return 0;
        case 8: 
          localdqr.HEB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72618);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqr.HEC = ((dqq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72618);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqr.HED = ((dqq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72618);
        return 0;
      }
      AppMethodBeat.o(72618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqr
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cje
  extends com.tencent.mm.bv.a
{
  public bvz wna;
  public String wug;
  public bkd xJu;
  public awf xTp;
  public LinkedList<cjw> xTq;
  public LinkedList<cjw> xTr;
  public awf xTs;
  public bss xTt;
  public bvy xTu;
  
  public cje()
  {
    AppMethodBeat.i(48965);
    this.xTq = new LinkedList();
    this.xTr = new LinkedList();
    AppMethodBeat.o(48965);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48966);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xTp != null)
      {
        paramVarArgs.iQ(1, this.xTp.computeSize());
        this.xTp.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.xTq);
      paramVarArgs.e(3, 8, this.xTr);
      if (this.xTs != null)
      {
        paramVarArgs.iQ(4, this.xTs.computeSize());
        this.xTs.writeFields(paramVarArgs);
      }
      if (this.xTt != null)
      {
        paramVarArgs.iQ(5, this.xTt.computeSize());
        this.xTt.writeFields(paramVarArgs);
      }
      if (this.wug != null) {
        paramVarArgs.e(6, this.wug);
      }
      if (this.xJu != null)
      {
        paramVarArgs.iQ(7, this.xJu.computeSize());
        this.xJu.writeFields(paramVarArgs);
      }
      if (this.wna != null)
      {
        paramVarArgs.iQ(8, this.wna.computeSize());
        this.wna.writeFields(paramVarArgs);
      }
      if (this.xTu != null)
      {
        paramVarArgs.iQ(9, this.xTu.computeSize());
        this.xTu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48966);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xTp == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = e.a.a.a.iP(1, this.xTp.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.xTq) + e.a.a.a.c(3, 8, this.xTr);
      paramInt = i;
      if (this.xTs != null) {
        paramInt = i + e.a.a.a.iP(4, this.xTs.computeSize());
      }
      i = paramInt;
      if (this.xTt != null) {
        i = paramInt + e.a.a.a.iP(5, this.xTt.computeSize());
      }
      paramInt = i;
      if (this.wug != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wug);
      }
      i = paramInt;
      if (this.xJu != null) {
        i = paramInt + e.a.a.a.iP(7, this.xJu.computeSize());
      }
      paramInt = i;
      if (this.wna != null) {
        paramInt = i + e.a.a.a.iP(8, this.wna.computeSize());
      }
      i = paramInt;
      if (this.xTu != null) {
        i = paramInt + e.a.a.a.iP(9, this.xTu.computeSize());
      }
      AppMethodBeat.o(48966);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xTq.clear();
        this.xTr.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48966);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cje localcje = (cje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48966);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcje.xTp = ((awf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48966);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcje.xTq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48966);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcje.xTr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48966);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcje.xTs = ((awf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48966);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bss();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bss)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcje.xTt = ((bss)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48966);
          return 0;
        case 6: 
          localcje.wug = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48966);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcje.xJu = ((bkd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48966);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcje.wna = ((bvz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48966);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvy();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcje.xTu = ((bvy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48966);
        return 0;
      }
      AppMethodBeat.o(48966);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cje
 * JD-Core Version:    0.7.0.1
 */
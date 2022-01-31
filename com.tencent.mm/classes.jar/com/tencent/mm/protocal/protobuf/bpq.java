package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bpq
  extends bvk
{
  public int koj;
  public String kok;
  public long wKm;
  public long wKn;
  public avf wOz;
  public LinkedList<bkt> wkO;
  public bfg xDF;
  public ckm xaX;
  public np xcg;
  public bvv xkx;
  
  public bpq()
  {
    AppMethodBeat.i(48935);
    this.wkO = new LinkedList();
    AppMethodBeat.o(48935);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48936);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(48936);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      if (this.wOz != null)
      {
        paramVarArgs.iQ(4, this.wOz.computeSize());
        this.wOz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.wkO);
      paramVarArgs.am(6, this.wKm);
      paramVarArgs.am(7, this.wKn);
      if (this.xkx != null)
      {
        paramVarArgs.iQ(8, this.xkx.computeSize());
        this.xkx.writeFields(paramVarArgs);
      }
      if (this.xcg != null)
      {
        paramVarArgs.iQ(9, this.xcg.computeSize());
        this.xcg.writeFields(paramVarArgs);
      }
      if (this.xaX != null)
      {
        paramVarArgs.iQ(10, this.xaX.computeSize());
        this.xaX.writeFields(paramVarArgs);
      }
      if (this.xDF != null)
      {
        paramVarArgs.iQ(11, this.xDF.computeSize());
        this.xDF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(48936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1470;
      }
    }
    label1470:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.wOz != null) {
        i = paramInt + e.a.a.a.iP(4, this.wOz.computeSize());
      }
      i = i + e.a.a.a.c(5, 8, this.wkO) + e.a.a.b.b.a.p(6, this.wKm) + e.a.a.b.b.a.p(7, this.wKn);
      paramInt = i;
      if (this.xkx != null) {
        paramInt = i + e.a.a.a.iP(8, this.xkx.computeSize());
      }
      i = paramInt;
      if (this.xcg != null) {
        i = paramInt + e.a.a.a.iP(9, this.xcg.computeSize());
      }
      paramInt = i;
      if (this.xaX != null) {
        paramInt = i + e.a.a.a.iP(10, this.xaX.computeSize());
      }
      i = paramInt;
      if (this.xDF != null) {
        i = paramInt + e.a.a.a.iP(11, this.xDF.computeSize());
      }
      AppMethodBeat.o(48936);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wkO.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(48936);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48936);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bpq localbpq = (bpq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48936);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48936);
          return 0;
        case 2: 
          localbpq.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48936);
          return 0;
        case 3: 
          localbpq.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48936);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpq.wOz = ((avf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48936);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkt();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpq.wkO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48936);
          return 0;
        case 6: 
          localbpq.wKm = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(48936);
          return 0;
        case 7: 
          localbpq.wKn = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(48936);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpq.xkx = ((bvv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48936);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new np();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((np)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpq.xcg = ((np)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48936);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpq.xaX = ((ckm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48936);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfg();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bfg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbpq.xDF = ((bfg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(48936);
        return 0;
      }
      AppMethodBeat.o(48936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpq
 * JD-Core Version:    0.7.0.1
 */
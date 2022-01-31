package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class cqk
  extends buy
{
  public int wsW;
  public SKBuiltinBuffer_t wsr;
  public SKBuiltinBuffer_t wss;
  public int xYW;
  public LinkedList<cqi> xYX;
  public int xYY;
  public LinkedList<Integer> xYZ;
  public int xZa;
  public LinkedList<cqj> xZb;
  public int xZc;
  public String xfJ;
  
  public cqk()
  {
    AppMethodBeat.i(80209);
    this.xYX = new LinkedList();
    this.xYZ = new LinkedList();
    this.xZb = new LinkedList();
    AppMethodBeat.o(80209);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80210);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wsW);
      paramVarArgs.aO(3, this.xYW);
      paramVarArgs.e(4, 8, this.xYX);
      if (this.xfJ != null) {
        paramVarArgs.e(5, this.xfJ);
      }
      paramVarArgs.aO(6, this.xYY);
      paramVarArgs.f(7, 2, this.xYZ);
      paramVarArgs.aO(8, this.xZa);
      paramVarArgs.e(9, 8, this.xZb);
      if (this.wsr != null)
      {
        paramVarArgs.iQ(10, this.wsr.computeSize());
        this.wsr.writeFields(paramVarArgs);
      }
      if (this.wss != null)
      {
        paramVarArgs.iQ(11, this.wss.computeSize());
        this.wss.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(12, this.xZc);
      AppMethodBeat.o(80210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1253;
      }
    }
    label1253:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wsW) + e.a.a.b.b.a.bl(3, this.xYW) + e.a.a.a.c(4, 8, this.xYX);
      paramInt = i;
      if (this.xfJ != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xfJ);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xYY) + e.a.a.a.d(7, 2, this.xYZ) + e.a.a.b.b.a.bl(8, this.xZa) + e.a.a.a.c(9, 8, this.xZb);
      paramInt = i;
      if (this.wsr != null) {
        paramInt = i + e.a.a.a.iP(10, this.wsr.computeSize());
      }
      i = paramInt;
      if (this.wss != null) {
        i = paramInt + e.a.a.a.iP(11, this.wss.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(12, this.xZc);
      AppMethodBeat.o(80210);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xYX.clear();
        this.xYZ.clear();
        this.xZb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80210);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cqk localcqk = (cqk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80210);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqk.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80210);
          return 0;
        case 2: 
          localcqk.wsW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80210);
          return 0;
        case 3: 
          localcqk.xYW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80210);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqk.xYX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80210);
          return 0;
        case 5: 
          localcqk.xfJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80210);
          return 0;
        case 6: 
          localcqk.xYY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80210);
          return 0;
        case 7: 
          localcqk.xYZ = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
          AppMethodBeat.o(80210);
          return 0;
        case 8: 
          localcqk.xZa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80210);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqk.xZb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80210);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqk.wsr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80210);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqk.wss = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80210);
          return 0;
        }
        localcqk.xZc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80210);
        return 0;
      }
      AppMethodBeat.o(80210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqk
 * JD-Core Version:    0.7.0.1
 */
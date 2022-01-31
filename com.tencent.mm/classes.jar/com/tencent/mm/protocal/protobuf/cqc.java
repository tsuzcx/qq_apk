package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqc
  extends buy
{
  public int OpCode;
  public SKBuiltinBuffer_t wuh;
  public String wwj;
  public bwc wwn;
  public SKBuiltinBuffer_t wwo;
  public int xMf;
  public String xYG;
  public bwc xYH;
  public bwc xgV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60072);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.OpCode);
      if (this.xYG != null) {
        paramVarArgs.e(3, this.xYG);
      }
      if (this.wwj != null) {
        paramVarArgs.e(4, this.wwj);
      }
      if (this.xgV != null)
      {
        paramVarArgs.iQ(5, this.xgV.computeSize());
        this.xgV.writeFields(paramVarArgs);
      }
      if (this.xYH != null)
      {
        paramVarArgs.iQ(6, this.xYH.computeSize());
        this.xYH.writeFields(paramVarArgs);
      }
      if (this.wwn != null)
      {
        paramVarArgs.iQ(7, this.wwn.computeSize());
        this.wwn.writeFields(paramVarArgs);
      }
      if (this.wwo != null)
      {
        paramVarArgs.iQ(8, this.wwo.computeSize());
        this.wwo.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(9, this.xMf);
      if (this.wuh != null)
      {
        paramVarArgs.iQ(10, this.wuh.computeSize());
        this.wuh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(60072);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.OpCode);
      paramInt = i;
      if (this.xYG != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xYG);
      }
      i = paramInt;
      if (this.wwj != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wwj);
      }
      paramInt = i;
      if (this.xgV != null) {
        paramInt = i + e.a.a.a.iP(5, this.xgV.computeSize());
      }
      i = paramInt;
      if (this.xYH != null) {
        i = paramInt + e.a.a.a.iP(6, this.xYH.computeSize());
      }
      paramInt = i;
      if (this.wwn != null) {
        paramInt = i + e.a.a.a.iP(7, this.wwn.computeSize());
      }
      i = paramInt;
      if (this.wwo != null) {
        i = paramInt + e.a.a.a.iP(8, this.wwo.computeSize());
      }
      i += e.a.a.b.b.a.bl(9, this.xMf);
      paramInt = i;
      if (this.wuh != null) {
        paramInt = i + e.a.a.a.iP(10, this.wuh.computeSize());
      }
      AppMethodBeat.o(60072);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(60072);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cqc localcqc = (cqc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(60072);
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
            localcqc.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60072);
          return 0;
        case 2: 
          localcqc.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60072);
          return 0;
        case 3: 
          localcqc.xYG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60072);
          return 0;
        case 4: 
          localcqc.wwj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(60072);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqc.xgV = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60072);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqc.xYH = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60072);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqc.wwn = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60072);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcqc.wwo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(60072);
          return 0;
        case 9: 
          localcqc.xMf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(60072);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcqc.wuh = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60072);
        return 0;
      }
      AppMethodBeat.o(60072);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqc
 * JD-Core Version:    0.7.0.1
 */
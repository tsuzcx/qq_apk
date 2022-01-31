package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aff
  extends buy
{
  public int OpCode;
  public int Scene;
  public String jJA;
  public int wJM;
  public int wJN;
  public bwc wXZ;
  public bwc wYa;
  public bwc wYb;
  public bwc wYc;
  public String wYd;
  public int wYe;
  public String wYf;
  public SKBuiltinBuffer_t wYg;
  public int wYh;
  public int wYi;
  public String wYj;
  public int wYk;
  public SKBuiltinBuffer_t wYl;
  public String wYm;
  public int woE;
  public int wqO;
  public SKBuiltinBuffer_t wrT;
  public int wsD;
  public String wuH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80054);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.OpCode);
      if (this.wrT != null)
      {
        paramVarArgs.iQ(3, this.wrT.computeSize());
        this.wrT.writeFields(paramVarArgs);
      }
      if (this.wXZ != null)
      {
        paramVarArgs.iQ(4, this.wXZ.computeSize());
        this.wXZ.writeFields(paramVarArgs);
      }
      if (this.wYa != null)
      {
        paramVarArgs.iQ(5, this.wYa.computeSize());
        this.wYa.writeFields(paramVarArgs);
      }
      if (this.wYb != null)
      {
        paramVarArgs.iQ(6, this.wYb.computeSize());
        this.wYb.writeFields(paramVarArgs);
      }
      if (this.wYc != null)
      {
        paramVarArgs.iQ(7, this.wYc.computeSize());
        this.wYc.writeFields(paramVarArgs);
      }
      if (this.wYd != null) {
        paramVarArgs.e(8, this.wYd);
      }
      paramVarArgs.aO(9, this.wYe);
      paramVarArgs.aO(10, this.Scene);
      if (this.jJA != null) {
        paramVarArgs.e(11, this.jJA);
      }
      if (this.wYf != null) {
        paramVarArgs.e(12, this.wYf);
      }
      if (this.wYg != null)
      {
        paramVarArgs.iQ(13, this.wYg.computeSize());
        this.wYg.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(14, this.wsD);
      paramVarArgs.aO(15, this.wYh);
      paramVarArgs.aO(16, this.woE);
      if (this.wuH != null) {
        paramVarArgs.e(17, this.wuH);
      }
      paramVarArgs.aO(18, this.wJM);
      paramVarArgs.aO(19, this.wJN);
      paramVarArgs.aO(20, this.wYi);
      if (this.wYj != null) {
        paramVarArgs.e(21, this.wYj);
      }
      paramVarArgs.aO(22, this.wYk);
      if (this.wYl != null)
      {
        paramVarArgs.iQ(23, this.wYl.computeSize());
        this.wYl.writeFields(paramVarArgs);
      }
      if (this.wYm != null) {
        paramVarArgs.e(24, this.wYm);
      }
      paramVarArgs.aO(25, this.wqO);
      AppMethodBeat.o(80054);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2262;
      }
    }
    label2262:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.OpCode);
      paramInt = i;
      if (this.wrT != null) {
        paramInt = i + e.a.a.a.iP(3, this.wrT.computeSize());
      }
      i = paramInt;
      if (this.wXZ != null) {
        i = paramInt + e.a.a.a.iP(4, this.wXZ.computeSize());
      }
      paramInt = i;
      if (this.wYa != null) {
        paramInt = i + e.a.a.a.iP(5, this.wYa.computeSize());
      }
      i = paramInt;
      if (this.wYb != null) {
        i = paramInt + e.a.a.a.iP(6, this.wYb.computeSize());
      }
      paramInt = i;
      if (this.wYc != null) {
        paramInt = i + e.a.a.a.iP(7, this.wYc.computeSize());
      }
      i = paramInt;
      if (this.wYd != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wYd);
      }
      i = i + e.a.a.b.b.a.bl(9, this.wYe) + e.a.a.b.b.a.bl(10, this.Scene);
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.jJA);
      }
      i = paramInt;
      if (this.wYf != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.wYf);
      }
      paramInt = i;
      if (this.wYg != null) {
        paramInt = i + e.a.a.a.iP(13, this.wYg.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(14, this.wsD) + e.a.a.b.b.a.bl(15, this.wYh) + e.a.a.b.b.a.bl(16, this.woE);
      paramInt = i;
      if (this.wuH != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.wuH);
      }
      i = paramInt + e.a.a.b.b.a.bl(18, this.wJM) + e.a.a.b.b.a.bl(19, this.wJN) + e.a.a.b.b.a.bl(20, this.wYi);
      paramInt = i;
      if (this.wYj != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.wYj);
      }
      i = paramInt + e.a.a.b.b.a.bl(22, this.wYk);
      paramInt = i;
      if (this.wYl != null) {
        paramInt = i + e.a.a.a.iP(23, this.wYl.computeSize());
      }
      i = paramInt;
      if (this.wYm != null) {
        i = paramInt + e.a.a.b.b.a.f(24, this.wYm);
      }
      paramInt = e.a.a.b.b.a.bl(25, this.wqO);
      AppMethodBeat.o(80054);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80054);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aff localaff = (aff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80054);
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
            localaff.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80054);
          return 0;
        case 2: 
          localaff.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80054);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaff.wrT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80054);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaff.wXZ = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80054);
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
            localaff.wYa = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80054);
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
            localaff.wYb = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80054);
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
            localaff.wYc = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80054);
          return 0;
        case 8: 
          localaff.wYd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80054);
          return 0;
        case 9: 
          localaff.wYe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80054);
          return 0;
        case 10: 
          localaff.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80054);
          return 0;
        case 11: 
          localaff.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80054);
          return 0;
        case 12: 
          localaff.wYf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80054);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaff.wYg = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80054);
          return 0;
        case 14: 
          localaff.wsD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80054);
          return 0;
        case 15: 
          localaff.wYh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80054);
          return 0;
        case 16: 
          localaff.woE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80054);
          return 0;
        case 17: 
          localaff.wuH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80054);
          return 0;
        case 18: 
          localaff.wJM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80054);
          return 0;
        case 19: 
          localaff.wJN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80054);
          return 0;
        case 20: 
          localaff.wYi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80054);
          return 0;
        case 21: 
          localaff.wYj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80054);
          return 0;
        case 22: 
          localaff.wYk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80054);
          return 0;
        case 23: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaff.wYl = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80054);
          return 0;
        case 24: 
          localaff.wYm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80054);
          return 0;
        }
        localaff.wqO = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80054);
        return 0;
      }
      AppMethodBeat.o(80054);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aff
 * JD-Core Version:    0.7.0.1
 */
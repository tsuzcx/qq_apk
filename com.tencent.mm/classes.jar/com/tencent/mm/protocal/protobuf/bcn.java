package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bcn
  extends buy
{
  public String ThumbUrl;
  public int nqW;
  public String nrZ;
  public int wDe;
  public int wDf;
  public int xdn;
  public SKBuiltinBuffer_t xrA;
  public int xrB;
  public int xrC;
  public int xrD;
  public int xrE;
  public SKBuiltinBuffer_t xrF;
  public int xrG;
  public int xrH;
  public int xrI;
  public int xrJ;
  public int xrK;
  public String xrL;
  public String xrM;
  public String xrw;
  public String xrx;
  public String xry;
  public int xrz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28548);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xrA == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataBuffer");
        AppMethodBeat.o(28548);
        throw paramVarArgs;
      }
      if (this.xrF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(28548);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xrw != null) {
        paramVarArgs.e(2, this.xrw);
      }
      if (this.xrx != null) {
        paramVarArgs.e(3, this.xrx);
      }
      if (this.xry != null) {
        paramVarArgs.e(4, this.xry);
      }
      paramVarArgs.aO(5, this.nqW);
      paramVarArgs.aO(6, this.xrz);
      if (this.xrA != null)
      {
        paramVarArgs.iQ(7, this.xrA.computeSize());
        this.xrA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.xrB);
      paramVarArgs.aO(9, this.xrC);
      paramVarArgs.aO(10, this.xrD);
      paramVarArgs.aO(11, this.xrE);
      if (this.xrF != null)
      {
        paramVarArgs.iQ(12, this.xrF.computeSize());
        this.xrF.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(13, this.xrG);
      paramVarArgs.aO(14, this.xrH);
      paramVarArgs.aO(15, this.xrI);
      paramVarArgs.aO(16, this.xrJ);
      paramVarArgs.aO(17, this.xdn);
      paramVarArgs.aO(18, this.xrK);
      if (this.nrZ != null) {
        paramVarArgs.e(19, this.nrZ);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(20, this.ThumbUrl);
      }
      paramVarArgs.aO(21, this.wDf);
      paramVarArgs.aO(22, this.wDe);
      if (this.xrL != null) {
        paramVarArgs.e(23, this.xrL);
      }
      if (this.xrM != null) {
        paramVarArgs.e(24, this.xrM);
      }
      AppMethodBeat.o(28548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1804;
      }
    }
    label1804:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xrw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xrw);
      }
      i = paramInt;
      if (this.xrx != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xrx);
      }
      paramInt = i;
      if (this.xry != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xry);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.nqW) + e.a.a.b.b.a.bl(6, this.xrz);
      paramInt = i;
      if (this.xrA != null) {
        paramInt = i + e.a.a.a.iP(7, this.xrA.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xrB) + e.a.a.b.b.a.bl(9, this.xrC) + e.a.a.b.b.a.bl(10, this.xrD) + e.a.a.b.b.a.bl(11, this.xrE);
      paramInt = i;
      if (this.xrF != null) {
        paramInt = i + e.a.a.a.iP(12, this.xrF.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(13, this.xrG) + e.a.a.b.b.a.bl(14, this.xrH) + e.a.a.b.b.a.bl(15, this.xrI) + e.a.a.b.b.a.bl(16, this.xrJ) + e.a.a.b.b.a.bl(17, this.xdn) + e.a.a.b.b.a.bl(18, this.xrK);
      paramInt = i;
      if (this.nrZ != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.nrZ);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.ThumbUrl);
      }
      i = i + e.a.a.b.b.a.bl(21, this.wDf) + e.a.a.b.b.a.bl(22, this.wDe);
      paramInt = i;
      if (this.xrL != null) {
        paramInt = i + e.a.a.b.b.a.f(23, this.xrL);
      }
      i = paramInt;
      if (this.xrM != null) {
        i = paramInt + e.a.a.b.b.a.f(24, this.xrM);
      }
      AppMethodBeat.o(28548);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xrA == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataBuffer");
          AppMethodBeat.o(28548);
          throw paramVarArgs;
        }
        if (this.xrF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(28548);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28548);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bcn localbcn = (bcn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28548);
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
            localbcn.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28548);
          return 0;
        case 2: 
          localbcn.xrw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28548);
          return 0;
        case 3: 
          localbcn.xrx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28548);
          return 0;
        case 4: 
          localbcn.xry = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28548);
          return 0;
        case 5: 
          localbcn.nqW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 6: 
          localbcn.xrz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcn.xrA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28548);
          return 0;
        case 8: 
          localbcn.xrB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 9: 
          localbcn.xrC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 10: 
          localbcn.xrD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 11: 
          localbcn.xrE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcn.xrF = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28548);
          return 0;
        case 13: 
          localbcn.xrG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 14: 
          localbcn.xrH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 15: 
          localbcn.xrI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 16: 
          localbcn.xrJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 17: 
          localbcn.xdn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 18: 
          localbcn.xrK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 19: 
          localbcn.nrZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28548);
          return 0;
        case 20: 
          localbcn.ThumbUrl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28548);
          return 0;
        case 21: 
          localbcn.wDf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 22: 
          localbcn.wDe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28548);
          return 0;
        case 23: 
          localbcn.xrL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28548);
          return 0;
        }
        localbcn.xrM = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28548);
        return 0;
      }
      AppMethodBeat.o(28548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcn
 * JD-Core Version:    0.7.0.1
 */
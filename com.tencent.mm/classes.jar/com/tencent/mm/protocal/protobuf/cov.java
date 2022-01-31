package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cov
  extends buy
{
  public int niK;
  public String nul;
  public String num;
  public String wDo;
  public int wDp;
  public int wDq;
  public int wDr;
  public int wPR;
  public int wQz;
  public String woU;
  public String wpS;
  public int wxV;
  public int xKZ;
  public int xMz;
  public SKBuiltinBuffer_t xXA;
  public String xXB;
  public int xXC;
  public String xXD;
  public String xXE;
  public int xXF;
  public String xXG;
  public String xXH;
  public String xXI;
  public String xXJ;
  public String xXK;
  public String xXL;
  public String xXM;
  public String xXN;
  public int xXq;
  public int xXr;
  public int xXs;
  public int xXy;
  public int xXz;
  public String xlf;
  public String xlh;
  public int xrD;
  public int xrE;
  public SKBuiltinBuffer_t xrF;
  public int xrG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51008);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xrF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(51008);
        throw paramVarArgs;
      }
      if (this.xXA == null)
      {
        paramVarArgs = new b("Not all required fields were included: VideoData");
        AppMethodBeat.o(51008);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wpS != null) {
        paramVarArgs.e(2, this.wpS);
      }
      if (this.num != null) {
        paramVarArgs.e(3, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(4, this.nul);
      }
      paramVarArgs.aO(5, this.xrD);
      paramVarArgs.aO(6, this.xrE);
      if (this.xrF != null)
      {
        paramVarArgs.iQ(7, this.xrF.computeSize());
        this.xrF.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.xXy);
      paramVarArgs.aO(9, this.xXz);
      if (this.xXA != null)
      {
        paramVarArgs.iQ(10, this.xXA.computeSize());
        this.xXA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.xMz);
      paramVarArgs.aO(12, this.wPR);
      paramVarArgs.aO(13, this.xrG);
      paramVarArgs.aO(14, this.wxV);
      if (this.woU != null) {
        paramVarArgs.e(15, this.woU);
      }
      if (this.xXB != null) {
        paramVarArgs.e(16, this.xXB);
      }
      if (this.wDo != null) {
        paramVarArgs.e(17, this.wDo);
      }
      paramVarArgs.aO(18, this.wDp);
      if (this.xlf != null) {
        paramVarArgs.e(19, this.xlf);
      }
      paramVarArgs.aO(20, this.xXq);
      paramVarArgs.aO(21, this.xXr);
      paramVarArgs.aO(22, this.xXs);
      if (this.xlh != null) {
        paramVarArgs.e(23, this.xlh);
      }
      paramVarArgs.aO(24, this.xXC);
      paramVarArgs.aO(25, this.wQz);
      if (this.xXD != null) {
        paramVarArgs.e(26, this.xXD);
      }
      if (this.xXE != null) {
        paramVarArgs.e(27, this.xXE);
      }
      paramVarArgs.aO(28, this.xXF);
      if (this.xXG != null) {
        paramVarArgs.e(29, this.xXG);
      }
      if (this.xXH != null) {
        paramVarArgs.e(30, this.xXH);
      }
      if (this.xXI != null) {
        paramVarArgs.e(31, this.xXI);
      }
      if (this.xXJ != null) {
        paramVarArgs.e(32, this.xXJ);
      }
      if (this.xXK != null) {
        paramVarArgs.e(33, this.xXK);
      }
      if (this.xXL != null) {
        paramVarArgs.e(34, this.xXL);
      }
      if (this.xXM != null) {
        paramVarArgs.e(35, this.xXM);
      }
      paramVarArgs.aO(36, this.xKZ);
      if (this.xXN != null) {
        paramVarArgs.e(37, this.xXN);
      }
      paramVarArgs.aO(38, this.wDq);
      paramVarArgs.aO(39, this.wDr);
      paramVarArgs.aO(40, this.niK);
      AppMethodBeat.o(51008);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2690;
      }
    }
    label2690:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wpS != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wpS);
      }
      i = paramInt;
      if (this.num != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.num);
      }
      paramInt = i;
      if (this.nul != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nul);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xrD) + e.a.a.b.b.a.bl(6, this.xrE);
      paramInt = i;
      if (this.xrF != null) {
        paramInt = i + e.a.a.a.iP(7, this.xrF.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xXy) + e.a.a.b.b.a.bl(9, this.xXz);
      paramInt = i;
      if (this.xXA != null) {
        paramInt = i + e.a.a.a.iP(10, this.xXA.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.xMz) + e.a.a.b.b.a.bl(12, this.wPR) + e.a.a.b.b.a.bl(13, this.xrG) + e.a.a.b.b.a.bl(14, this.wxV);
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.woU);
      }
      i = paramInt;
      if (this.xXB != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.xXB);
      }
      paramInt = i;
      if (this.wDo != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.wDo);
      }
      i = paramInt + e.a.a.b.b.a.bl(18, this.wDp);
      paramInt = i;
      if (this.xlf != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.xlf);
      }
      i = paramInt + e.a.a.b.b.a.bl(20, this.xXq) + e.a.a.b.b.a.bl(21, this.xXr) + e.a.a.b.b.a.bl(22, this.xXs);
      paramInt = i;
      if (this.xlh != null) {
        paramInt = i + e.a.a.b.b.a.f(23, this.xlh);
      }
      i = paramInt + e.a.a.b.b.a.bl(24, this.xXC) + e.a.a.b.b.a.bl(25, this.wQz);
      paramInt = i;
      if (this.xXD != null) {
        paramInt = i + e.a.a.b.b.a.f(26, this.xXD);
      }
      i = paramInt;
      if (this.xXE != null) {
        i = paramInt + e.a.a.b.b.a.f(27, this.xXE);
      }
      i += e.a.a.b.b.a.bl(28, this.xXF);
      paramInt = i;
      if (this.xXG != null) {
        paramInt = i + e.a.a.b.b.a.f(29, this.xXG);
      }
      i = paramInt;
      if (this.xXH != null) {
        i = paramInt + e.a.a.b.b.a.f(30, this.xXH);
      }
      paramInt = i;
      if (this.xXI != null) {
        paramInt = i + e.a.a.b.b.a.f(31, this.xXI);
      }
      i = paramInt;
      if (this.xXJ != null) {
        i = paramInt + e.a.a.b.b.a.f(32, this.xXJ);
      }
      paramInt = i;
      if (this.xXK != null) {
        paramInt = i + e.a.a.b.b.a.f(33, this.xXK);
      }
      i = paramInt;
      if (this.xXL != null) {
        i = paramInt + e.a.a.b.b.a.f(34, this.xXL);
      }
      paramInt = i;
      if (this.xXM != null) {
        paramInt = i + e.a.a.b.b.a.f(35, this.xXM);
      }
      i = paramInt + e.a.a.b.b.a.bl(36, this.xKZ);
      paramInt = i;
      if (this.xXN != null) {
        paramInt = i + e.a.a.b.b.a.f(37, this.xXN);
      }
      i = e.a.a.b.b.a.bl(38, this.wDq);
      int j = e.a.a.b.b.a.bl(39, this.wDr);
      int k = e.a.a.b.b.a.bl(40, this.niK);
      AppMethodBeat.o(51008);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xrF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(51008);
          throw paramVarArgs;
        }
        if (this.xXA == null)
        {
          paramVarArgs = new b("Not all required fields were included: VideoData");
          AppMethodBeat.o(51008);
          throw paramVarArgs;
        }
        AppMethodBeat.o(51008);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cov localcov = (cov)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(51008);
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
            localcov.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(51008);
          return 0;
        case 2: 
          localcov.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 3: 
          localcov.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 4: 
          localcov.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 5: 
          localcov.xrD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 6: 
          localcov.xrE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
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
            localcov.xrF = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(51008);
          return 0;
        case 8: 
          localcov.xXy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 9: 
          localcov.xXz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
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
            localcov.xXA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(51008);
          return 0;
        case 11: 
          localcov.xMz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 12: 
          localcov.wPR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 13: 
          localcov.xrG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 14: 
          localcov.wxV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 15: 
          localcov.woU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 16: 
          localcov.xXB = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 17: 
          localcov.wDo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 18: 
          localcov.wDp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 19: 
          localcov.xlf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 20: 
          localcov.xXq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 21: 
          localcov.xXr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 22: 
          localcov.xXs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 23: 
          localcov.xlh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 24: 
          localcov.xXC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 25: 
          localcov.wQz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 26: 
          localcov.xXD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 27: 
          localcov.xXE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 28: 
          localcov.xXF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 29: 
          localcov.xXG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 30: 
          localcov.xXH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 31: 
          localcov.xXI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 32: 
          localcov.xXJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 33: 
          localcov.xXK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 34: 
          localcov.xXL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 35: 
          localcov.xXM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 36: 
          localcov.xKZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 37: 
          localcov.xXN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(51008);
          return 0;
        case 38: 
          localcov.wDq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        case 39: 
          localcov.wDr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(51008);
          return 0;
        }
        localcov.niK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51008);
        return 0;
      }
      AppMethodBeat.o(51008);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cov
 * JD-Core Version:    0.7.0.1
 */
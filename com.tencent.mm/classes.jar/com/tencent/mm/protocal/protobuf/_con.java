package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class con
  extends buy
{
  public String Md5;
  public String fKw;
  public String fKz;
  public int nqW;
  public SKBuiltinBuffer_t pIA;
  public int pIx;
  public int pIy;
  public int pIz;
  public String wDo;
  public int wDp;
  public int wDq;
  public int wDr;
  public int wLO;
  public int wQz;
  public String wmD;
  public String wmE;
  public String wmF;
  public bwc woP;
  public bwc woQ;
  public String woU;
  public int xKZ;
  public int xPK;
  public bwc xXk;
  public String xXl;
  public String xXm;
  public int xXn;
  public int xXo;
  public String xXp;
  public int xXq;
  public int xXr;
  public int xXs;
  public int xdn;
  public String xlh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80203);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xXk == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(80203);
        throw paramVarArgs;
      }
      if (this.woP == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(80203);
        throw paramVarArgs;
      }
      if (this.woQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(80203);
        throw paramVarArgs;
      }
      if (this.pIA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(80203);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.xXk != null)
      {
        paramVarArgs.iQ(2, this.xXk.computeSize());
        this.xXk.writeFields(paramVarArgs);
      }
      if (this.woP != null)
      {
        paramVarArgs.iQ(3, this.woP.computeSize());
        this.woP.writeFields(paramVarArgs);
      }
      if (this.woQ != null)
      {
        paramVarArgs.iQ(4, this.woQ.computeSize());
        this.woQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.pIx);
      paramVarArgs.aO(6, this.pIy);
      paramVarArgs.aO(7, this.pIz);
      if (this.pIA != null)
      {
        paramVarArgs.iQ(8, this.pIA.computeSize());
        this.pIA.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(9, this.nqW);
      if (this.woU != null) {
        paramVarArgs.e(10, this.woU);
      }
      paramVarArgs.aO(11, this.xdn);
      paramVarArgs.aO(12, this.wLO);
      paramVarArgs.aO(13, this.xPK);
      if (this.fKz != null) {
        paramVarArgs.e(14, this.fKz);
      }
      if (this.xXl != null) {
        paramVarArgs.e(15, this.xXl);
      }
      if (this.xXm != null) {
        paramVarArgs.e(16, this.xXm);
      }
      if (this.wDo != null) {
        paramVarArgs.e(17, this.wDo);
      }
      paramVarArgs.aO(18, this.wDp);
      paramVarArgs.aO(19, this.xXn);
      paramVarArgs.aO(20, this.xXo);
      if (this.xXp != null) {
        paramVarArgs.e(21, this.xXp);
      }
      paramVarArgs.aO(22, this.xXq);
      paramVarArgs.aO(23, this.xXr);
      paramVarArgs.aO(24, this.xXs);
      if (this.xlh != null) {
        paramVarArgs.e(25, this.xlh);
      }
      paramVarArgs.aO(26, this.wQz);
      if (this.Md5 != null) {
        paramVarArgs.e(27, this.Md5);
      }
      paramVarArgs.aO(28, this.wDq);
      paramVarArgs.aO(29, this.wDr);
      paramVarArgs.aO(30, this.xKZ);
      if (this.fKw != null) {
        paramVarArgs.e(31, this.fKw);
      }
      if (this.wmF != null) {
        paramVarArgs.e(32, this.wmF);
      }
      if (this.wmE != null) {
        paramVarArgs.e(33, this.wmE);
      }
      if (this.wmD != null) {
        paramVarArgs.e(34, this.wmD);
      }
      AppMethodBeat.o(80203);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2626;
      }
    }
    label2626:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xXk != null) {
        paramInt = i + e.a.a.a.iP(2, this.xXk.computeSize());
      }
      i = paramInt;
      if (this.woP != null) {
        i = paramInt + e.a.a.a.iP(3, this.woP.computeSize());
      }
      paramInt = i;
      if (this.woQ != null) {
        paramInt = i + e.a.a.a.iP(4, this.woQ.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.pIx) + e.a.a.b.b.a.bl(6, this.pIy) + e.a.a.b.b.a.bl(7, this.pIz);
      paramInt = i;
      if (this.pIA != null) {
        paramInt = i + e.a.a.a.iP(8, this.pIA.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.nqW);
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.woU);
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.xdn) + e.a.a.b.b.a.bl(12, this.wLO) + e.a.a.b.b.a.bl(13, this.xPK);
      paramInt = i;
      if (this.fKz != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.fKz);
      }
      i = paramInt;
      if (this.xXl != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.xXl);
      }
      paramInt = i;
      if (this.xXm != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.xXm);
      }
      i = paramInt;
      if (this.wDo != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.wDo);
      }
      i = i + e.a.a.b.b.a.bl(18, this.wDp) + e.a.a.b.b.a.bl(19, this.xXn) + e.a.a.b.b.a.bl(20, this.xXo);
      paramInt = i;
      if (this.xXp != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.xXp);
      }
      i = paramInt + e.a.a.b.b.a.bl(22, this.xXq) + e.a.a.b.b.a.bl(23, this.xXr) + e.a.a.b.b.a.bl(24, this.xXs);
      paramInt = i;
      if (this.xlh != null) {
        paramInt = i + e.a.a.b.b.a.f(25, this.xlh);
      }
      i = paramInt + e.a.a.b.b.a.bl(26, this.wQz);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + e.a.a.b.b.a.f(27, this.Md5);
      }
      i = paramInt + e.a.a.b.b.a.bl(28, this.wDq) + e.a.a.b.b.a.bl(29, this.wDr) + e.a.a.b.b.a.bl(30, this.xKZ);
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(31, this.fKw);
      }
      i = paramInt;
      if (this.wmF != null) {
        i = paramInt + e.a.a.b.b.a.f(32, this.wmF);
      }
      paramInt = i;
      if (this.wmE != null) {
        paramInt = i + e.a.a.b.b.a.f(33, this.wmE);
      }
      i = paramInt;
      if (this.wmD != null) {
        i = paramInt + e.a.a.b.b.a.f(34, this.wmD);
      }
      AppMethodBeat.o(80203);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xXk == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(80203);
          throw paramVarArgs;
        }
        if (this.woP == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(80203);
          throw paramVarArgs;
        }
        if (this.woQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(80203);
          throw paramVarArgs;
        }
        if (this.pIA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(80203);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80203);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        con localcon = (con)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80203);
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
            localcon.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80203);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcon.xXk = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80203);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcon.woP = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80203);
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
            localcon.woQ = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80203);
          return 0;
        case 5: 
          localcon.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 6: 
          localcon.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 7: 
          localcon.pIz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
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
            localcon.pIA = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80203);
          return 0;
        case 9: 
          localcon.nqW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 10: 
          localcon.woU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        case 11: 
          localcon.xdn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 12: 
          localcon.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 13: 
          localcon.xPK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 14: 
          localcon.fKz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        case 15: 
          localcon.xXl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        case 16: 
          localcon.xXm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        case 17: 
          localcon.wDo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        case 18: 
          localcon.wDp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 19: 
          localcon.xXn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 20: 
          localcon.xXo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 21: 
          localcon.xXp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        case 22: 
          localcon.xXq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 23: 
          localcon.xXr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 24: 
          localcon.xXs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 25: 
          localcon.xlh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        case 26: 
          localcon.wQz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 27: 
          localcon.Md5 = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        case 28: 
          localcon.wDq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 29: 
          localcon.wDr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 30: 
          localcon.xKZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80203);
          return 0;
        case 31: 
          localcon.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        case 32: 
          localcon.wmF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        case 33: 
          localcon.wmE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80203);
          return 0;
        }
        localcon.wmD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80203);
        return 0;
      }
      AppMethodBeat.o(80203);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.con
 * JD-Core Version:    0.7.0.1
 */
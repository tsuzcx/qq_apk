package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgf
  extends buy
{
  public String gwU;
  public String jJA;
  public String jKG;
  public String lGG;
  public String lGH;
  public String wQd;
  public String wQf;
  public String wSl;
  public String wYf;
  public int wmq;
  public String wmr;
  public String wms;
  public int wso;
  public String wsp;
  public SKBuiltinBuffer_t wsr;
  public zd wsy;
  public int wvK;
  public SKBuiltinBuffer_t wvN;
  public int wvQ;
  public String wvR;
  public String wvW;
  public String xfI;
  public String xfJ;
  public int xfK;
  public String xrj;
  public int xve;
  public int xvf;
  public int xvg;
  public String xvh;
  public String xvi;
  public String xvj;
  public String xvk;
  public String xvl;
  public String xvm;
  public int xvn;
  public String xvo;
  public String xvp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58920);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jJA != null) {
        paramVarArgs.e(2, this.jJA);
      }
      if (this.wvW != null) {
        paramVarArgs.e(3, this.wvW);
      }
      if (this.jKG != null) {
        paramVarArgs.e(4, this.jKG);
      }
      paramVarArgs.aO(5, this.wmq);
      if (this.wmr != null) {
        paramVarArgs.e(6, this.wmr);
      }
      if (this.wms != null) {
        paramVarArgs.e(7, this.wms);
      }
      if (this.wQf != null) {
        paramVarArgs.e(8, this.wQf);
      }
      paramVarArgs.aO(12, this.wso);
      paramVarArgs.aO(13, this.xve);
      paramVarArgs.aO(14, this.xfK);
      if (this.lGG != null) {
        paramVarArgs.e(15, this.lGG);
      }
      if (this.lGH != null) {
        paramVarArgs.e(16, this.lGH);
      }
      paramVarArgs.aO(17, this.wvK);
      if (this.wQd != null) {
        paramVarArgs.e(18, this.wQd);
      }
      if (this.wvN != null)
      {
        paramVarArgs.iQ(19, this.wvN.computeSize());
        this.wvN.writeFields(paramVarArgs);
      }
      if (this.gwU != null) {
        paramVarArgs.e(20, this.gwU);
      }
      if (this.xfI != null) {
        paramVarArgs.e(21, this.xfI);
      }
      if (this.xfJ != null) {
        paramVarArgs.e(22, this.xfJ);
      }
      paramVarArgs.aO(23, this.xvf);
      paramVarArgs.aO(24, this.xvg);
      if (this.wsp != null) {
        paramVarArgs.e(31, this.wsp);
      }
      if (this.xrj != null) {
        paramVarArgs.e(32, this.xrj);
      }
      if (this.xvh != null) {
        paramVarArgs.e(33, this.xvh);
      }
      if (this.wSl != null) {
        paramVarArgs.e(34, this.wSl);
      }
      if (this.xvi != null) {
        paramVarArgs.e(35, this.xvi);
      }
      if (this.xvj != null) {
        paramVarArgs.e(36, this.xvj);
      }
      if (this.wsy != null)
      {
        paramVarArgs.iQ(37, this.wsy.computeSize());
        this.wsy.writeFields(paramVarArgs);
      }
      if (this.xvk != null) {
        paramVarArgs.e(38, this.xvk);
      }
      if (this.wYf != null) {
        paramVarArgs.e(39, this.wYf);
      }
      if (this.xvl != null) {
        paramVarArgs.e(40, this.xvl);
      }
      if (this.xvm != null) {
        paramVarArgs.e(41, this.xvm);
      }
      paramVarArgs.aO(42, this.xvn);
      if (this.wsr != null)
      {
        paramVarArgs.iQ(43, this.wsr.computeSize());
        this.wsr.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(44, this.wvQ);
      if (this.wvR != null) {
        paramVarArgs.e(45, this.wvR);
      }
      if (this.xvo != null) {
        paramVarArgs.e(46, this.xvo);
      }
      if (this.xvp != null) {
        paramVarArgs.e(47, this.xvp);
      }
      AppMethodBeat.o(58920);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2766;
      }
    }
    label2766:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jJA);
      }
      i = paramInt;
      if (this.wvW != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wvW);
      }
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.jKG);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wmq);
      paramInt = i;
      if (this.wmr != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wmr);
      }
      i = paramInt;
      if (this.wms != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wms);
      }
      paramInt = i;
      if (this.wQf != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wQf);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.wso) + e.a.a.b.b.a.bl(13, this.xve) + e.a.a.b.b.a.bl(14, this.xfK);
      paramInt = i;
      if (this.lGG != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.lGG);
      }
      i = paramInt;
      if (this.lGH != null) {
        i = paramInt + e.a.a.b.b.a.f(16, this.lGH);
      }
      i += e.a.a.b.b.a.bl(17, this.wvK);
      paramInt = i;
      if (this.wQd != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.wQd);
      }
      i = paramInt;
      if (this.wvN != null) {
        i = paramInt + e.a.a.a.iP(19, this.wvN.computeSize());
      }
      paramInt = i;
      if (this.gwU != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.gwU);
      }
      i = paramInt;
      if (this.xfI != null) {
        i = paramInt + e.a.a.b.b.a.f(21, this.xfI);
      }
      paramInt = i;
      if (this.xfJ != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.xfJ);
      }
      i = paramInt + e.a.a.b.b.a.bl(23, this.xvf) + e.a.a.b.b.a.bl(24, this.xvg);
      paramInt = i;
      if (this.wsp != null) {
        paramInt = i + e.a.a.b.b.a.f(31, this.wsp);
      }
      i = paramInt;
      if (this.xrj != null) {
        i = paramInt + e.a.a.b.b.a.f(32, this.xrj);
      }
      paramInt = i;
      if (this.xvh != null) {
        paramInt = i + e.a.a.b.b.a.f(33, this.xvh);
      }
      i = paramInt;
      if (this.wSl != null) {
        i = paramInt + e.a.a.b.b.a.f(34, this.wSl);
      }
      paramInt = i;
      if (this.xvi != null) {
        paramInt = i + e.a.a.b.b.a.f(35, this.xvi);
      }
      i = paramInt;
      if (this.xvj != null) {
        i = paramInt + e.a.a.b.b.a.f(36, this.xvj);
      }
      paramInt = i;
      if (this.wsy != null) {
        paramInt = i + e.a.a.a.iP(37, this.wsy.computeSize());
      }
      i = paramInt;
      if (this.xvk != null) {
        i = paramInt + e.a.a.b.b.a.f(38, this.xvk);
      }
      paramInt = i;
      if (this.wYf != null) {
        paramInt = i + e.a.a.b.b.a.f(39, this.wYf);
      }
      i = paramInt;
      if (this.xvl != null) {
        i = paramInt + e.a.a.b.b.a.f(40, this.xvl);
      }
      paramInt = i;
      if (this.xvm != null) {
        paramInt = i + e.a.a.b.b.a.f(41, this.xvm);
      }
      i = paramInt + e.a.a.b.b.a.bl(42, this.xvn);
      paramInt = i;
      if (this.wsr != null) {
        paramInt = i + e.a.a.a.iP(43, this.wsr.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(44, this.wvQ);
      paramInt = i;
      if (this.wvR != null) {
        paramInt = i + e.a.a.b.b.a.f(45, this.wvR);
      }
      i = paramInt;
      if (this.xvo != null) {
        i = paramInt + e.a.a.b.b.a.f(46, this.xvo);
      }
      paramInt = i;
      if (this.xvp != null) {
        paramInt = i + e.a.a.b.b.a.f(47, this.xvp);
      }
      AppMethodBeat.o(58920);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(58920);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bgf localbgf = (bgf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        case 11: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 30: 
        default: 
          AppMethodBeat.o(58920);
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
            localbgf.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58920);
          return 0;
        case 2: 
          localbgf.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 3: 
          localbgf.wvW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 4: 
          localbgf.jKG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 5: 
          localbgf.wmq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58920);
          return 0;
        case 6: 
          localbgf.wmr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 7: 
          localbgf.wms = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 8: 
          localbgf.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 12: 
          localbgf.wso = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58920);
          return 0;
        case 13: 
          localbgf.xve = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58920);
          return 0;
        case 14: 
          localbgf.xfK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58920);
          return 0;
        case 15: 
          localbgf.lGG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 16: 
          localbgf.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 17: 
          localbgf.wvK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58920);
          return 0;
        case 18: 
          localbgf.wQd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 19: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgf.wvN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58920);
          return 0;
        case 20: 
          localbgf.gwU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 21: 
          localbgf.xfI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 22: 
          localbgf.xfJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 23: 
          localbgf.xvf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58920);
          return 0;
        case 24: 
          localbgf.xvg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58920);
          return 0;
        case 31: 
          localbgf.wsp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 32: 
          localbgf.xrj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 33: 
          localbgf.xvh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 34: 
          localbgf.wSl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 35: 
          localbgf.xvi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 36: 
          localbgf.xvj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 37: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgf.wsy = ((zd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58920);
          return 0;
        case 38: 
          localbgf.xvk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 39: 
          localbgf.wYf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 40: 
          localbgf.xvl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 41: 
          localbgf.xvm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 42: 
          localbgf.xvn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58920);
          return 0;
        case 43: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbgf.wsr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58920);
          return 0;
        case 44: 
          localbgf.wvQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(58920);
          return 0;
        case 45: 
          localbgf.wvR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        case 46: 
          localbgf.xvo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58920);
          return 0;
        }
        localbgf.xvp = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58920);
        return 0;
      }
      AppMethodBeat.o(58920);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgf
 * JD-Core Version:    0.7.0.1
 */
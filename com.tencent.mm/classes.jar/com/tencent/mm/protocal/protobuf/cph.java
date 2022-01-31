package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cph
  extends com.tencent.mm.bv.a
{
  public String dqY;
  public String gwZ;
  public String wJq;
  public String wJr;
  public int wYk;
  public int wmw;
  public baf wpi;
  public String wvt;
  public bwf wwc;
  public int xCL;
  public String xXZ;
  public String xYa;
  public int xYb;
  public int xYc;
  public int xYd;
  public String xYe;
  public int xYf;
  public bwc xYg;
  public int xYh;
  public String xYi;
  public String xYj;
  public String xYk;
  public String xYl;
  public String xYm;
  public bko xYn;
  public String xYo;
  public int xYp;
  public long xYq;
  public String xYr;
  public cid xYs;
  public long xYt;
  public cfj xpk;
  public String xtv;
  public String xtw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123521);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xpk == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
        AppMethodBeat.o(123521);
        throw paramVarArgs;
      }
      if (this.xpk != null)
      {
        paramVarArgs.iQ(1, this.xpk.computeSize());
        this.xpk.writeFields(paramVarArgs);
      }
      if (this.gwZ != null) {
        paramVarArgs.e(2, this.gwZ);
      }
      if (this.xXZ != null) {
        paramVarArgs.e(3, this.xXZ);
      }
      if (this.xYa != null) {
        paramVarArgs.e(4, this.xYa);
      }
      paramVarArgs.aO(5, this.xYb);
      paramVarArgs.aO(6, this.xYc);
      paramVarArgs.aO(7, this.xYd);
      if (this.xYe != null) {
        paramVarArgs.e(8, this.xYe);
      }
      if (this.wJq != null) {
        paramVarArgs.e(9, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(10, this.wJr);
      }
      paramVarArgs.aO(11, this.xYf);
      if (this.xYg != null)
      {
        paramVarArgs.iQ(12, this.xYg.computeSize());
        this.xYg.writeFields(paramVarArgs);
      }
      if (this.wwc != null)
      {
        paramVarArgs.iQ(13, this.wwc.computeSize());
        this.wwc.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(14, this.wmw);
      paramVarArgs.aO(15, this.xYh);
      if (this.wvt != null) {
        paramVarArgs.e(16, this.wvt);
      }
      if (this.xtv != null) {
        paramVarArgs.e(17, this.xtv);
      }
      if (this.xtw != null) {
        paramVarArgs.e(18, this.xtw);
      }
      if (this.xYi != null) {
        paramVarArgs.e(19, this.xYi);
      }
      if (this.xYj != null) {
        paramVarArgs.e(20, this.xYj);
      }
      if (this.xYk != null) {
        paramVarArgs.e(21, this.xYk);
      }
      if (this.xYl != null) {
        paramVarArgs.e(22, this.xYl);
      }
      if (this.wpi != null)
      {
        paramVarArgs.iQ(23, this.wpi.computeSize());
        this.wpi.writeFields(paramVarArgs);
      }
      if (this.xYm != null) {
        paramVarArgs.e(24, this.xYm);
      }
      if (this.xYn != null)
      {
        paramVarArgs.iQ(25, this.xYn.computeSize());
        this.xYn.writeFields(paramVarArgs);
      }
      if (this.xYo != null) {
        paramVarArgs.e(26, this.xYo);
      }
      paramVarArgs.aO(27, this.xYp);
      if (this.dqY != null) {
        paramVarArgs.e(28, this.dqY);
      }
      paramVarArgs.aO(29, this.wYk);
      paramVarArgs.am(30, this.xYq);
      if (this.xYr != null) {
        paramVarArgs.e(31, this.xYr);
      }
      paramVarArgs.aO(32, this.xCL);
      if (this.xYs != null)
      {
        paramVarArgs.iQ(33, this.xYs.computeSize());
        this.xYs.writeFields(paramVarArgs);
      }
      paramVarArgs.am(34, this.xYt);
      AppMethodBeat.o(123521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xpk == null) {
        break label2682;
      }
    }
    label2682:
    for (int i = e.a.a.a.iP(1, this.xpk.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gwZ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.gwZ);
      }
      i = paramInt;
      if (this.xXZ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xXZ);
      }
      paramInt = i;
      if (this.xYa != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xYa);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xYb) + e.a.a.b.b.a.bl(6, this.xYc) + e.a.a.b.b.a.bl(7, this.xYd);
      paramInt = i;
      if (this.xYe != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xYe);
      }
      i = paramInt;
      if (this.wJq != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wJq);
      }
      paramInt = i;
      if (this.wJr != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wJr);
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.xYf);
      paramInt = i;
      if (this.xYg != null) {
        paramInt = i + e.a.a.a.iP(12, this.xYg.computeSize());
      }
      i = paramInt;
      if (this.wwc != null) {
        i = paramInt + e.a.a.a.iP(13, this.wwc.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(14, this.wmw) + e.a.a.b.b.a.bl(15, this.xYh);
      paramInt = i;
      if (this.wvt != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wvt);
      }
      i = paramInt;
      if (this.xtv != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.xtv);
      }
      paramInt = i;
      if (this.xtw != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.xtw);
      }
      i = paramInt;
      if (this.xYi != null) {
        i = paramInt + e.a.a.b.b.a.f(19, this.xYi);
      }
      paramInt = i;
      if (this.xYj != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.xYj);
      }
      i = paramInt;
      if (this.xYk != null) {
        i = paramInt + e.a.a.b.b.a.f(21, this.xYk);
      }
      paramInt = i;
      if (this.xYl != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.xYl);
      }
      i = paramInt;
      if (this.wpi != null) {
        i = paramInt + e.a.a.a.iP(23, this.wpi.computeSize());
      }
      paramInt = i;
      if (this.xYm != null) {
        paramInt = i + e.a.a.b.b.a.f(24, this.xYm);
      }
      i = paramInt;
      if (this.xYn != null) {
        i = paramInt + e.a.a.a.iP(25, this.xYn.computeSize());
      }
      paramInt = i;
      if (this.xYo != null) {
        paramInt = i + e.a.a.b.b.a.f(26, this.xYo);
      }
      i = paramInt + e.a.a.b.b.a.bl(27, this.xYp);
      paramInt = i;
      if (this.dqY != null) {
        paramInt = i + e.a.a.b.b.a.f(28, this.dqY);
      }
      i = paramInt + e.a.a.b.b.a.bl(29, this.wYk) + e.a.a.b.b.a.p(30, this.xYq);
      paramInt = i;
      if (this.xYr != null) {
        paramInt = i + e.a.a.b.b.a.f(31, this.xYr);
      }
      i = paramInt + e.a.a.b.b.a.bl(32, this.xCL);
      paramInt = i;
      if (this.xYs != null) {
        paramInt = i + e.a.a.a.iP(33, this.xYs.computeSize());
      }
      i = e.a.a.b.b.a.p(34, this.xYt);
      AppMethodBeat.o(123521);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xpk == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
          AppMethodBeat.o(123521);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123521);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cph localcph = (cph)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123521);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcph.xpk = ((cfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123521);
          return 0;
        case 2: 
          localcph.gwZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 3: 
          localcph.xXZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 4: 
          localcph.xYa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 5: 
          localcph.xYb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123521);
          return 0;
        case 6: 
          localcph.xYc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123521);
          return 0;
        case 7: 
          localcph.xYd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123521);
          return 0;
        case 8: 
          localcph.xYe = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 9: 
          localcph.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 10: 
          localcph.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 11: 
          localcph.xYf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123521);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcph.xYg = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123521);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcph.wwc = ((bwf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123521);
          return 0;
        case 14: 
          localcph.wmw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123521);
          return 0;
        case 15: 
          localcph.xYh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123521);
          return 0;
        case 16: 
          localcph.wvt = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 17: 
          localcph.xtv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 18: 
          localcph.xtw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 19: 
          localcph.xYi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 20: 
          localcph.xYj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 21: 
          localcph.xYk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 22: 
          localcph.xYl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 23: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new baf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((baf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcph.wpi = ((baf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123521);
          return 0;
        case 24: 
          localcph.xYm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 25: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bko();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bko)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcph.xYn = ((bko)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123521);
          return 0;
        case 26: 
          localcph.xYo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 27: 
          localcph.xYp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123521);
          return 0;
        case 28: 
          localcph.dqY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 29: 
          localcph.wYk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123521);
          return 0;
        case 30: 
          localcph.xYq = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(123521);
          return 0;
        case 31: 
          localcph.xYr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(123521);
          return 0;
        case 32: 
          localcph.xCL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(123521);
          return 0;
        case 33: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cid();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cid)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcph.xYs = ((cid)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123521);
          return 0;
        }
        localcph.xYt = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(123521);
        return 0;
      }
      AppMethodBeat.o(123521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cph
 * JD-Core Version:    0.7.0.1
 */
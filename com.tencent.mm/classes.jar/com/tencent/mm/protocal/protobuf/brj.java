package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brj
  extends com.tencent.mm.bv.a
{
  public String npZ;
  public String nqL;
  public int nqf;
  public String ntp;
  public String wnA;
  public String wnB;
  public String wnC;
  public dbw wnD;
  public String wnx;
  public String wny;
  public String wnz;
  public String wwV;
  public String xES;
  public String xET;
  public int xEU;
  public LinkedList<bwc> xEV;
  public String xEW;
  public String xEX;
  public String xEY;
  public String xEZ;
  public String xFa;
  public String xFb;
  public String xFc;
  public int xFd;
  public int xuP;
  
  public brj()
  {
    AppMethodBeat.i(80158);
    this.xEV = new LinkedList();
    AppMethodBeat.o(80158);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80159);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npZ != null) {
        paramVarArgs.e(1, this.npZ);
      }
      if (this.ntp != null) {
        paramVarArgs.e(2, this.ntp);
      }
      if (this.wnz != null) {
        paramVarArgs.e(3, this.wnz);
      }
      if (this.xES != null) {
        paramVarArgs.e(4, this.xES);
      }
      if (this.wny != null) {
        paramVarArgs.e(5, this.wny);
      }
      if (this.wnx != null) {
        paramVarArgs.e(6, this.wnx);
      }
      if (this.xET != null) {
        paramVarArgs.e(7, this.xET);
      }
      paramVarArgs.aO(8, this.xEU);
      paramVarArgs.e(9, 8, this.xEV);
      if (this.wnA != null) {
        paramVarArgs.e(10, this.wnA);
      }
      if (this.xEW != null) {
        paramVarArgs.e(11, this.xEW);
      }
      if (this.xEX != null) {
        paramVarArgs.e(12, this.xEX);
      }
      paramVarArgs.aO(13, this.xuP);
      if (this.wwV != null) {
        paramVarArgs.e(14, this.wwV);
      }
      if (this.nqL != null) {
        paramVarArgs.e(15, this.nqL);
      }
      if (this.wnB != null) {
        paramVarArgs.e(16, this.wnB);
      }
      if (this.xEY != null) {
        paramVarArgs.e(17, this.xEY);
      }
      if (this.xEZ != null) {
        paramVarArgs.e(18, this.xEZ);
      }
      if (this.wnC != null) {
        paramVarArgs.e(19, this.wnC);
      }
      if (this.xFa != null) {
        paramVarArgs.e(20, this.xFa);
      }
      if (this.xFb != null) {
        paramVarArgs.e(21, this.xFb);
      }
      if (this.wnD != null)
      {
        paramVarArgs.iQ(22, this.wnD.computeSize());
        this.wnD.writeFields(paramVarArgs);
      }
      if (this.xFc != null) {
        paramVarArgs.e(23, this.xFc);
      }
      paramVarArgs.aO(24, this.xFd);
      paramVarArgs.aO(25, this.nqf);
      AppMethodBeat.o(80159);
      return 0;
    }
    if (paramInt == 1) {
      if (this.npZ == null) {
        break label1806;
      }
    }
    label1806:
    for (int i = e.a.a.b.b.a.f(1, this.npZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ntp != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ntp);
      }
      i = paramInt;
      if (this.wnz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wnz);
      }
      paramInt = i;
      if (this.xES != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xES);
      }
      i = paramInt;
      if (this.wny != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wny);
      }
      paramInt = i;
      if (this.wnx != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wnx);
      }
      i = paramInt;
      if (this.xET != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xET);
      }
      i = i + e.a.a.b.b.a.bl(8, this.xEU) + e.a.a.a.c(9, 8, this.xEV);
      paramInt = i;
      if (this.wnA != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.wnA);
      }
      i = paramInt;
      if (this.xEW != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.xEW);
      }
      paramInt = i;
      if (this.xEX != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xEX);
      }
      i = paramInt + e.a.a.b.b.a.bl(13, this.xuP);
      paramInt = i;
      if (this.wwV != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.wwV);
      }
      i = paramInt;
      if (this.nqL != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.nqL);
      }
      paramInt = i;
      if (this.wnB != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wnB);
      }
      i = paramInt;
      if (this.xEY != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.xEY);
      }
      paramInt = i;
      if (this.xEZ != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.xEZ);
      }
      i = paramInt;
      if (this.wnC != null) {
        i = paramInt + e.a.a.b.b.a.f(19, this.wnC);
      }
      paramInt = i;
      if (this.xFa != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.xFa);
      }
      i = paramInt;
      if (this.xFb != null) {
        i = paramInt + e.a.a.b.b.a.f(21, this.xFb);
      }
      paramInt = i;
      if (this.wnD != null) {
        paramInt = i + e.a.a.a.iP(22, this.wnD.computeSize());
      }
      i = paramInt;
      if (this.xFc != null) {
        i = paramInt + e.a.a.b.b.a.f(23, this.xFc);
      }
      paramInt = e.a.a.b.b.a.bl(24, this.xFd);
      int j = e.a.a.b.b.a.bl(25, this.nqf);
      AppMethodBeat.o(80159);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xEV.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80159);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        brj localbrj = (brj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80159);
          return -1;
        case 1: 
          localbrj.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 2: 
          localbrj.ntp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 3: 
          localbrj.wnz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 4: 
          localbrj.xES = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 5: 
          localbrj.wny = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 6: 
          localbrj.wnx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 7: 
          localbrj.xET = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 8: 
          localbrj.xEU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80159);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbrj.xEV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80159);
          return 0;
        case 10: 
          localbrj.wnA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 11: 
          localbrj.xEW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 12: 
          localbrj.xEX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 13: 
          localbrj.xuP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80159);
          return 0;
        case 14: 
          localbrj.wwV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 15: 
          localbrj.nqL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 16: 
          localbrj.wnB = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 17: 
          localbrj.xEY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 18: 
          localbrj.xEZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 19: 
          localbrj.wnC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 20: 
          localbrj.xFa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 21: 
          localbrj.xFb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 22: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbrj.wnD = ((dbw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80159);
          return 0;
        case 23: 
          localbrj.xFc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80159);
          return 0;
        case 24: 
          localbrj.xFd = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80159);
          return 0;
        }
        localbrj.nqf = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(80159);
        return 0;
      }
      AppMethodBeat.o(80159);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brj
 * JD-Core Version:    0.7.0.1
 */
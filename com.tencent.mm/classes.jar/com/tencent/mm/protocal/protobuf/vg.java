package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class vg
  extends com.tencent.mm.bv.a
{
  public int gwP;
  public String gwU;
  public String jJA;
  public String jKG;
  public String nuz;
  public String wNI;
  public String wNJ;
  public int wNK;
  public int wNL;
  public String wNM;
  public int wNN;
  public String wNO;
  public String wNP;
  public int wNQ;
  public int wNR;
  public LinkedList<bvx> wNS;
  public String wNT;
  public int wNU;
  public int wNV;
  public int wNW;
  public int wNX;
  public SKBuiltinBuffer_t woT;
  
  public vg()
  {
    AppMethodBeat.i(28370);
    this.wNS = new LinkedList();
    AppMethodBeat.o(28370);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28371);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(28371);
        throw paramVarArgs;
      }
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      if (this.wNI != null) {
        paramVarArgs.e(3, this.wNI);
      }
      if (this.wNJ != null) {
        paramVarArgs.e(4, this.wNJ);
      }
      paramVarArgs.aO(5, this.gwP);
      if (this.woT != null)
      {
        paramVarArgs.iQ(6, this.woT.computeSize());
        this.woT.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.wNK);
      paramVarArgs.aO(8, this.wNL);
      if (this.wNM != null) {
        paramVarArgs.e(9, this.wNM);
      }
      paramVarArgs.aO(10, this.wNN);
      if (this.wNO != null) {
        paramVarArgs.e(11, this.wNO);
      }
      if (this.wNP != null) {
        paramVarArgs.e(12, this.wNP);
      }
      paramVarArgs.aO(13, this.wNQ);
      paramVarArgs.aO(14, this.wNR);
      paramVarArgs.e(15, 8, this.wNS);
      if (this.wNT != null) {
        paramVarArgs.e(16, this.wNT);
      }
      paramVarArgs.aO(17, this.wNU);
      paramVarArgs.aO(18, this.wNV);
      if (this.nuz != null) {
        paramVarArgs.e(19, this.nuz);
      }
      paramVarArgs.aO(20, this.wNW);
      paramVarArgs.aO(21, this.wNX);
      if (this.gwU != null) {
        paramVarArgs.e(22, this.gwU);
      }
      AppMethodBeat.o(28371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label1594;
      }
    }
    label1594:
    for (int i = e.a.a.b.b.a.f(1, this.jJA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKG);
      }
      i = paramInt;
      if (this.wNI != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wNI);
      }
      paramInt = i;
      if (this.wNJ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wNJ);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.gwP);
      paramInt = i;
      if (this.woT != null) {
        paramInt = i + e.a.a.a.iP(6, this.woT.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.wNK) + e.a.a.b.b.a.bl(8, this.wNL);
      paramInt = i;
      if (this.wNM != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wNM);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.wNN);
      paramInt = i;
      if (this.wNO != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wNO);
      }
      i = paramInt;
      if (this.wNP != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.wNP);
      }
      i = i + e.a.a.b.b.a.bl(13, this.wNQ) + e.a.a.b.b.a.bl(14, this.wNR) + e.a.a.a.c(15, 8, this.wNS);
      paramInt = i;
      if (this.wNT != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wNT);
      }
      i = paramInt + e.a.a.b.b.a.bl(17, this.wNU) + e.a.a.b.b.a.bl(18, this.wNV);
      paramInt = i;
      if (this.nuz != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.nuz);
      }
      i = paramInt + e.a.a.b.b.a.bl(20, this.wNW) + e.a.a.b.b.a.bl(21, this.wNX);
      paramInt = i;
      if (this.gwU != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.gwU);
      }
      AppMethodBeat.o(28371);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wNS.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.woT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(28371);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28371);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vg localvg = (vg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28371);
          return -1;
        case 1: 
          localvg.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28371);
          return 0;
        case 2: 
          localvg.jKG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28371);
          return 0;
        case 3: 
          localvg.wNI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28371);
          return 0;
        case 4: 
          localvg.wNJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28371);
          return 0;
        case 5: 
          localvg.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28371);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvg.woT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28371);
          return 0;
        case 7: 
          localvg.wNK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28371);
          return 0;
        case 8: 
          localvg.wNL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28371);
          return 0;
        case 9: 
          localvg.wNM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28371);
          return 0;
        case 10: 
          localvg.wNN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28371);
          return 0;
        case 11: 
          localvg.wNO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28371);
          return 0;
        case 12: 
          localvg.wNP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28371);
          return 0;
        case 13: 
          localvg.wNQ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28371);
          return 0;
        case 14: 
          localvg.wNR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28371);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvg.wNS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28371);
          return 0;
        case 16: 
          localvg.wNT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28371);
          return 0;
        case 17: 
          localvg.wNU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28371);
          return 0;
        case 18: 
          localvg.wNV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28371);
          return 0;
        case 19: 
          localvg.nuz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28371);
          return 0;
        case 20: 
          localvg.wNW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28371);
          return 0;
        case 21: 
          localvg.wNX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28371);
          return 0;
        }
        localvg.gwU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28371);
        return 0;
      }
      AppMethodBeat.o(28371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vg
 * JD-Core Version:    0.7.0.1
 */
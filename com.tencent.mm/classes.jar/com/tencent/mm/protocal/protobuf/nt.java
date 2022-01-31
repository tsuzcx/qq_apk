package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nt
  extends buy
{
  public int Scene;
  public String fKw;
  public int niK;
  public String nul;
  public String num;
  public String wDd;
  public int wDe;
  public int wDf;
  public SKBuiltinBuffer_t wDg;
  public float wDh;
  public float wDi;
  public String wDj;
  public int wDk;
  public int wDl;
  public int wDm;
  public int wDn;
  public String wDo;
  public int wDp;
  public int wDq;
  public int wDr;
  public String wmD;
  public String wmE;
  public String wmF;
  public String woU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80031);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wDd != null) {
        paramVarArgs.e(1, this.wDd);
      }
      if (this.num != null) {
        paramVarArgs.e(2, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(3, this.nul);
      }
      paramVarArgs.aO(4, this.wDe);
      paramVarArgs.aO(5, this.wDf);
      if (this.woU != null) {
        paramVarArgs.e(6, this.woU);
      }
      if (this.wDg != null)
      {
        paramVarArgs.iQ(7, this.wDg.computeSize());
        this.wDg.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.Scene);
      paramVarArgs.q(9, this.wDh);
      paramVarArgs.q(10, this.wDi);
      if (this.wDj != null) {
        paramVarArgs.e(11, this.wDj);
      }
      paramVarArgs.aO(12, this.wDk);
      paramVarArgs.aO(13, this.wDl);
      paramVarArgs.aO(14, this.wDm);
      paramVarArgs.aO(15, this.wDn);
      if (this.wDo != null) {
        paramVarArgs.e(16, this.wDo);
      }
      paramVarArgs.aO(17, this.wDp);
      paramVarArgs.aO(18, this.wDq);
      paramVarArgs.aO(19, this.wDr);
      paramVarArgs.aO(20, this.niK);
      if (this.fKw != null) {
        paramVarArgs.e(21, this.fKw);
      }
      if (this.wmF != null) {
        paramVarArgs.e(22, this.wmF);
      }
      if (this.wmE != null) {
        paramVarArgs.e(23, this.wmE);
      }
      if (this.wmD != null) {
        paramVarArgs.e(24, this.wmD);
      }
      AppMethodBeat.o(80031);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wDd == null) {
        break label1504;
      }
    }
    label1504:
    for (int i = e.a.a.b.b.a.f(1, this.wDd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.num != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.num);
      }
      i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nul);
      }
      i = i + e.a.a.b.b.a.bl(4, this.wDe) + e.a.a.b.b.a.bl(5, this.wDf);
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.woU);
      }
      i = paramInt;
      if (this.wDg != null) {
        i = paramInt + e.a.a.a.iP(7, this.wDg.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(8, this.Scene) + (e.a.a.b.b.a.eW(9) + 4) + (e.a.a.b.b.a.eW(10) + 4);
      paramInt = i;
      if (this.wDj != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wDj);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.wDk) + e.a.a.b.b.a.bl(13, this.wDl) + e.a.a.b.b.a.bl(14, this.wDm) + e.a.a.b.b.a.bl(15, this.wDn);
      paramInt = i;
      if (this.wDo != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wDo);
      }
      i = paramInt + e.a.a.b.b.a.bl(17, this.wDp) + e.a.a.b.b.a.bl(18, this.wDq) + e.a.a.b.b.a.bl(19, this.wDr) + e.a.a.b.b.a.bl(20, this.niK);
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.fKw);
      }
      i = paramInt;
      if (this.wmF != null) {
        i = paramInt + e.a.a.b.b.a.f(22, this.wmF);
      }
      paramInt = i;
      if (this.wmE != null) {
        paramInt = i + e.a.a.b.b.a.f(23, this.wmE);
      }
      i = paramInt;
      if (this.wmD != null) {
        i = paramInt + e.a.a.b.b.a.f(24, this.wmD);
      }
      AppMethodBeat.o(80031);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80031);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        nt localnt = (nt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80031);
          return -1;
        case 1: 
          localnt.wDd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80031);
          return 0;
        case 2: 
          localnt.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80031);
          return 0;
        case 3: 
          localnt.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80031);
          return 0;
        case 4: 
          localnt.wDe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 5: 
          localnt.wDf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 6: 
          localnt.woU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80031);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localnt.wDg = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80031);
          return 0;
        case 8: 
          localnt.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 9: 
          localnt.wDh = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(80031);
          return 0;
        case 10: 
          localnt.wDi = Float.intBitsToFloat(((e.a.a.a.a)localObject1).CLY.emx());
          AppMethodBeat.o(80031);
          return 0;
        case 11: 
          localnt.wDj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80031);
          return 0;
        case 12: 
          localnt.wDk = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 13: 
          localnt.wDl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 14: 
          localnt.wDm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 15: 
          localnt.wDn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 16: 
          localnt.wDo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80031);
          return 0;
        case 17: 
          localnt.wDp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 18: 
          localnt.wDq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 19: 
          localnt.wDr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 20: 
          localnt.niK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80031);
          return 0;
        case 21: 
          localnt.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80031);
          return 0;
        case 22: 
          localnt.wmF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80031);
          return 0;
        case 23: 
          localnt.wmE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80031);
          return 0;
        }
        localnt.wmD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80031);
        return 0;
      }
      AppMethodBeat.o(80031);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nt
 * JD-Core Version:    0.7.0.1
 */
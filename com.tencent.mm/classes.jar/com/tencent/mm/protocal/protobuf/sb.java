package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sb
  extends cvw
{
  public String FKQ;
  public String FKR;
  public String FKS;
  public String FNL;
  public String GgV;
  public int GgW;
  public int GgX;
  public SKBuiltinBuffer_t GgY;
  public float GgZ;
  public float Gha;
  public String Ghb;
  public int Ghc;
  public int Ghd;
  public int Ghe;
  public int Ghf;
  public String Ghg;
  public int Ghh;
  public int Ghi;
  public int Ghj;
  public String Ghk;
  public int Scene;
  public String ikm;
  public int ucK;
  public String uvF;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152511);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GgV != null) {
        paramVarArgs.d(1, this.GgV);
      }
      if (this.uvG != null) {
        paramVarArgs.d(2, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(3, this.uvF);
      }
      paramVarArgs.aS(4, this.GgW);
      paramVarArgs.aS(5, this.GgX);
      if (this.FNL != null) {
        paramVarArgs.d(6, this.FNL);
      }
      if (this.GgY != null)
      {
        paramVarArgs.lJ(7, this.GgY.computeSize());
        this.GgY.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.Scene);
      paramVarArgs.y(9, this.GgZ);
      paramVarArgs.y(10, this.Gha);
      if (this.Ghb != null) {
        paramVarArgs.d(11, this.Ghb);
      }
      paramVarArgs.aS(12, this.Ghc);
      paramVarArgs.aS(13, this.Ghd);
      paramVarArgs.aS(14, this.Ghe);
      paramVarArgs.aS(15, this.Ghf);
      if (this.Ghg != null) {
        paramVarArgs.d(16, this.Ghg);
      }
      paramVarArgs.aS(17, this.Ghh);
      paramVarArgs.aS(18, this.Ghi);
      paramVarArgs.aS(19, this.Ghj);
      paramVarArgs.aS(20, this.ucK);
      if (this.ikm != null) {
        paramVarArgs.d(21, this.ikm);
      }
      if (this.FKS != null) {
        paramVarArgs.d(22, this.FKS);
      }
      if (this.FKR != null) {
        paramVarArgs.d(23, this.FKR);
      }
      if (this.FKQ != null) {
        paramVarArgs.d(24, this.FKQ);
      }
      if (this.Ghk != null) {
        paramVarArgs.d(25, this.Ghk);
      }
      AppMethodBeat.o(152511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GgV == null) {
        break label1564;
      }
    }
    label1564:
    for (int i = f.a.a.b.b.a.e(1, this.GgV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uvG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uvG);
      }
      i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvF);
      }
      i = i + f.a.a.b.b.a.bz(4, this.GgW) + f.a.a.b.b.a.bz(5, this.GgX);
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNL);
      }
      i = paramInt;
      if (this.GgY != null) {
        i = paramInt + f.a.a.a.lI(7, this.GgY.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(8, this.Scene) + f.a.a.b.b.a.amE(9) + f.a.a.b.b.a.amE(10);
      paramInt = i;
      if (this.Ghb != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Ghb);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.Ghc) + f.a.a.b.b.a.bz(13, this.Ghd) + f.a.a.b.b.a.bz(14, this.Ghe) + f.a.a.b.b.a.bz(15, this.Ghf);
      paramInt = i;
      if (this.Ghg != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Ghg);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.Ghh) + f.a.a.b.b.a.bz(18, this.Ghi) + f.a.a.b.b.a.bz(19, this.Ghj) + f.a.a.b.b.a.bz(20, this.ucK);
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.ikm);
      }
      i = paramInt;
      if (this.FKS != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.FKS);
      }
      paramInt = i;
      if (this.FKR != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.FKR);
      }
      i = paramInt;
      if (this.FKQ != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.FKQ);
      }
      paramInt = i;
      if (this.Ghk != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.Ghk);
      }
      AppMethodBeat.o(152511);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        sb localsb = (sb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152511);
          return -1;
        case 1: 
          localsb.GgV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 2: 
          localsb.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 3: 
          localsb.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 4: 
          localsb.GgW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 5: 
          localsb.GgX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 6: 
          localsb.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localsb.GgY = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152511);
          return 0;
        case 8: 
          localsb.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 9: 
          localsb.GgZ = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(152511);
          return 0;
        case 10: 
          localsb.Gha = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(152511);
          return 0;
        case 11: 
          localsb.Ghb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 12: 
          localsb.Ghc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 13: 
          localsb.Ghd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 14: 
          localsb.Ghe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 15: 
          localsb.Ghf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 16: 
          localsb.Ghg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 17: 
          localsb.Ghh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 18: 
          localsb.Ghi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 19: 
          localsb.Ghj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 20: 
          localsb.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 21: 
          localsb.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 22: 
          localsb.FKS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 23: 
          localsb.FKR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 24: 
          localsb.FKQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152511);
          return 0;
        }
        localsb.Ghk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152511);
        return 0;
      }
      AppMethodBeat.o(152511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sb
 * JD-Core Version:    0.7.0.1
 */
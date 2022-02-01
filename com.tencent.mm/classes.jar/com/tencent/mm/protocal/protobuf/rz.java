package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rz
  extends cvc
{
  public float FOA;
  public float FOB;
  public String FOC;
  public int FOD;
  public int FOE;
  public int FOF;
  public int FOG;
  public String FOH;
  public int FOI;
  public int FOJ;
  public int FOK;
  public String FOL;
  public String FOw;
  public int FOx;
  public int FOy;
  public SKBuiltinBuffer_t FOz;
  public String Fss;
  public String Fst;
  public String Fsu;
  public String Fvn;
  public int Scene;
  public String iht;
  public int tRT;
  public String uki;
  public String ukj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152511);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FOw != null) {
        paramVarArgs.d(1, this.FOw);
      }
      if (this.ukj != null) {
        paramVarArgs.d(2, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(3, this.uki);
      }
      paramVarArgs.aS(4, this.FOx);
      paramVarArgs.aS(5, this.FOy);
      if (this.Fvn != null) {
        paramVarArgs.d(6, this.Fvn);
      }
      if (this.FOz != null)
      {
        paramVarArgs.lC(7, this.FOz.computeSize());
        this.FOz.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.Scene);
      paramVarArgs.z(9, this.FOA);
      paramVarArgs.z(10, this.FOB);
      if (this.FOC != null) {
        paramVarArgs.d(11, this.FOC);
      }
      paramVarArgs.aS(12, this.FOD);
      paramVarArgs.aS(13, this.FOE);
      paramVarArgs.aS(14, this.FOF);
      paramVarArgs.aS(15, this.FOG);
      if (this.FOH != null) {
        paramVarArgs.d(16, this.FOH);
      }
      paramVarArgs.aS(17, this.FOI);
      paramVarArgs.aS(18, this.FOJ);
      paramVarArgs.aS(19, this.FOK);
      paramVarArgs.aS(20, this.tRT);
      if (this.iht != null) {
        paramVarArgs.d(21, this.iht);
      }
      if (this.Fsu != null) {
        paramVarArgs.d(22, this.Fsu);
      }
      if (this.Fst != null) {
        paramVarArgs.d(23, this.Fst);
      }
      if (this.Fss != null) {
        paramVarArgs.d(24, this.Fss);
      }
      if (this.FOL != null) {
        paramVarArgs.d(25, this.FOL);
      }
      AppMethodBeat.o(152511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FOw == null) {
        break label1564;
      }
    }
    label1564:
    for (int i = f.a.a.b.b.a.e(1, this.FOw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ukj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ukj);
      }
      i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uki);
      }
      i = i + f.a.a.b.b.a.bz(4, this.FOx) + f.a.a.b.b.a.bz(5, this.FOy);
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fvn);
      }
      i = paramInt;
      if (this.FOz != null) {
        i = paramInt + f.a.a.a.lB(7, this.FOz.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(8, this.Scene) + f.a.a.b.b.a.alU(9) + f.a.a.b.b.a.alU(10);
      paramInt = i;
      if (this.FOC != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FOC);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.FOD) + f.a.a.b.b.a.bz(13, this.FOE) + f.a.a.b.b.a.bz(14, this.FOF) + f.a.a.b.b.a.bz(15, this.FOG);
      paramInt = i;
      if (this.FOH != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.FOH);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.FOI) + f.a.a.b.b.a.bz(18, this.FOJ) + f.a.a.b.b.a.bz(19, this.FOK) + f.a.a.b.b.a.bz(20, this.tRT);
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.iht);
      }
      i = paramInt;
      if (this.Fsu != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.Fsu);
      }
      paramInt = i;
      if (this.Fst != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.Fst);
      }
      i = paramInt;
      if (this.Fss != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.Fss);
      }
      paramInt = i;
      if (this.FOL != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.FOL);
      }
      AppMethodBeat.o(152511);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        rz localrz = (rz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152511);
          return -1;
        case 1: 
          localrz.FOw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 2: 
          localrz.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 3: 
          localrz.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 4: 
          localrz.FOx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 5: 
          localrz.FOy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 6: 
          localrz.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localrz.FOz = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152511);
          return 0;
        case 8: 
          localrz.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 9: 
          localrz.FOA = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(152511);
          return 0;
        case 10: 
          localrz.FOB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(152511);
          return 0;
        case 11: 
          localrz.FOC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 12: 
          localrz.FOD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 13: 
          localrz.FOE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 14: 
          localrz.FOF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 15: 
          localrz.FOG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 16: 
          localrz.FOH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 17: 
          localrz.FOI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 18: 
          localrz.FOJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 19: 
          localrz.FOK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 20: 
          localrz.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152511);
          return 0;
        case 21: 
          localrz.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 22: 
          localrz.Fsu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 23: 
          localrz.Fst = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152511);
          return 0;
        case 24: 
          localrz.Fss = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152511);
          return 0;
        }
        localrz.FOL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152511);
        return 0;
      }
      AppMethodBeat.o(152511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rz
 * JD-Core Version:    0.7.0.1
 */
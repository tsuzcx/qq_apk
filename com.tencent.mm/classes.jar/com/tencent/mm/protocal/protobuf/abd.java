package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abd
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t Fvm;
  public String GaA;
  public int GaB;
  public int GaC;
  public String GaD;
  public int GaE;
  public String GaF;
  public String GaG;
  public int GaH;
  public int GaI;
  public LinkedList<cwf> GaJ;
  public String GaK;
  public int GaL;
  public int GaM;
  public int GaN;
  public int GaO;
  public String Gaz;
  public int jdc;
  public String jdh;
  public String nDo;
  public String nEt;
  public String ukw;
  
  public abd()
  {
    AppMethodBeat.i(32174);
    this.GaJ = new LinkedList();
    AppMethodBeat.o(32174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32175);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(32175);
        throw paramVarArgs;
      }
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      if (this.Gaz != null) {
        paramVarArgs.d(3, this.Gaz);
      }
      if (this.GaA != null) {
        paramVarArgs.d(4, this.GaA);
      }
      paramVarArgs.aS(5, this.jdc);
      if (this.Fvm != null)
      {
        paramVarArgs.lC(6, this.Fvm.computeSize());
        this.Fvm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.GaB);
      paramVarArgs.aS(8, this.GaC);
      if (this.GaD != null) {
        paramVarArgs.d(9, this.GaD);
      }
      paramVarArgs.aS(10, this.GaE);
      if (this.GaF != null) {
        paramVarArgs.d(11, this.GaF);
      }
      if (this.GaG != null) {
        paramVarArgs.d(12, this.GaG);
      }
      paramVarArgs.aS(13, this.GaH);
      paramVarArgs.aS(14, this.GaI);
      paramVarArgs.e(15, 8, this.GaJ);
      if (this.GaK != null) {
        paramVarArgs.d(16, this.GaK);
      }
      paramVarArgs.aS(17, this.GaL);
      paramVarArgs.aS(18, this.GaM);
      if (this.ukw != null) {
        paramVarArgs.d(19, this.ukw);
      }
      paramVarArgs.aS(20, this.GaN);
      paramVarArgs.aS(21, this.GaO);
      if (this.jdh != null) {
        paramVarArgs.d(22, this.jdh);
      }
      AppMethodBeat.o(32175);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label1594;
      }
    }
    label1594:
    for (int i = f.a.a.b.b.a.e(1, this.nDo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nEt);
      }
      i = paramInt;
      if (this.Gaz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gaz);
      }
      paramInt = i;
      if (this.GaA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GaA);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jdc);
      paramInt = i;
      if (this.Fvm != null) {
        paramInt = i + f.a.a.a.lB(6, this.Fvm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.GaB) + f.a.a.b.b.a.bz(8, this.GaC);
      paramInt = i;
      if (this.GaD != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GaD);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.GaE);
      paramInt = i;
      if (this.GaF != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GaF);
      }
      i = paramInt;
      if (this.GaG != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GaG);
      }
      i = i + f.a.a.b.b.a.bz(13, this.GaH) + f.a.a.b.b.a.bz(14, this.GaI) + f.a.a.a.c(15, 8, this.GaJ);
      paramInt = i;
      if (this.GaK != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GaK);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.GaL) + f.a.a.b.b.a.bz(18, this.GaM);
      paramInt = i;
      if (this.ukw != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.ukw);
      }
      i = paramInt + f.a.a.b.b.a.bz(20, this.GaN) + f.a.a.b.b.a.bz(21, this.GaO);
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.jdh);
      }
      AppMethodBeat.o(32175);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GaJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Fvm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(32175);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32175);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abd localabd = (abd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32175);
          return -1;
        case 1: 
          localabd.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 2: 
          localabd.nEt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 3: 
          localabd.Gaz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 4: 
          localabd.GaA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 5: 
          localabd.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabd.Fvm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 7: 
          localabd.GaB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 8: 
          localabd.GaC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 9: 
          localabd.GaD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 10: 
          localabd.GaE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 11: 
          localabd.GaF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 12: 
          localabd.GaG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 13: 
          localabd.GaH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 14: 
          localabd.GaI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localabd.GaJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32175);
          return 0;
        case 16: 
          localabd.GaK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 17: 
          localabd.GaL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 18: 
          localabd.GaM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 19: 
          localabd.ukw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32175);
          return 0;
        case 20: 
          localabd.GaN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32175);
          return 0;
        case 21: 
          localabd.GaO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32175);
          return 0;
        }
        localabd.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32175);
        return 0;
      }
      AppMethodBeat.o(32175);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abd
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dth
  extends cvc
{
  public int FGO;
  public String FOH;
  public int FOI;
  public int FOJ;
  public int FOK;
  public String FOL;
  public String Fvn;
  public String Fwt;
  public String GJL;
  public String GJN;
  public int GSf;
  public int GSg;
  public SKBuiltinBuffer_t GSh;
  public int GSi;
  public int Gdp;
  public int Ges;
  public int HFN;
  public int HFO;
  public int HFP;
  public int HFV;
  public int HFW;
  public SKBuiltinBuffer_t HFX;
  public String HFY;
  public int HFZ;
  public String HGa;
  public String HGb;
  public int HGc;
  public String HGd;
  public String HGe;
  public String HGf;
  public String HGg;
  public String HGh;
  public String HGi;
  public String HGj;
  public String HGk;
  public int Hqi;
  public int Hsd;
  public int tRT;
  public String uki;
  public String ukj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127180);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GSh == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.HFX == null)
      {
        paramVarArgs = new b("Not all required fields were included: VideoData");
        AppMethodBeat.o(127180);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Fwt != null) {
        paramVarArgs.d(2, this.Fwt);
      }
      if (this.ukj != null) {
        paramVarArgs.d(3, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(4, this.uki);
      }
      paramVarArgs.aS(5, this.GSf);
      paramVarArgs.aS(6, this.GSg);
      if (this.GSh != null)
      {
        paramVarArgs.lC(7, this.GSh.computeSize());
        this.GSh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.HFV);
      paramVarArgs.aS(9, this.HFW);
      if (this.HFX != null)
      {
        paramVarArgs.lC(10, this.HFX.computeSize());
        this.HFX.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.Hsd);
      paramVarArgs.aS(12, this.Gdp);
      paramVarArgs.aS(13, this.GSi);
      paramVarArgs.aS(14, this.FGO);
      if (this.Fvn != null) {
        paramVarArgs.d(15, this.Fvn);
      }
      if (this.HFY != null) {
        paramVarArgs.d(16, this.HFY);
      }
      if (this.FOH != null) {
        paramVarArgs.d(17, this.FOH);
      }
      paramVarArgs.aS(18, this.FOI);
      if (this.GJL != null) {
        paramVarArgs.d(19, this.GJL);
      }
      paramVarArgs.aS(20, this.HFN);
      paramVarArgs.aS(21, this.HFO);
      paramVarArgs.aS(22, this.HFP);
      if (this.GJN != null) {
        paramVarArgs.d(23, this.GJN);
      }
      paramVarArgs.aS(24, this.HFZ);
      paramVarArgs.aS(25, this.Ges);
      if (this.HGa != null) {
        paramVarArgs.d(26, this.HGa);
      }
      if (this.HGb != null) {
        paramVarArgs.d(27, this.HGb);
      }
      paramVarArgs.aS(28, this.HGc);
      if (this.HGd != null) {
        paramVarArgs.d(29, this.HGd);
      }
      if (this.HGe != null) {
        paramVarArgs.d(30, this.HGe);
      }
      if (this.HGf != null) {
        paramVarArgs.d(31, this.HGf);
      }
      if (this.HGg != null) {
        paramVarArgs.d(32, this.HGg);
      }
      if (this.HGh != null) {
        paramVarArgs.d(33, this.HGh);
      }
      if (this.HGi != null) {
        paramVarArgs.d(34, this.HGi);
      }
      if (this.HGj != null) {
        paramVarArgs.d(35, this.HGj);
      }
      paramVarArgs.aS(36, this.Hqi);
      if (this.HGk != null) {
        paramVarArgs.d(37, this.HGk);
      }
      paramVarArgs.aS(38, this.FOJ);
      paramVarArgs.aS(39, this.FOK);
      paramVarArgs.aS(40, this.tRT);
      if (this.FOL != null) {
        paramVarArgs.d(41, this.FOL);
      }
      AppMethodBeat.o(127180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2742;
      }
    }
    label2742:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fwt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fwt);
      }
      i = paramInt;
      if (this.ukj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ukj);
      }
      paramInt = i;
      if (this.uki != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uki);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GSf) + f.a.a.b.b.a.bz(6, this.GSg);
      paramInt = i;
      if (this.GSh != null) {
        paramInt = i + f.a.a.a.lB(7, this.GSh.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HFV) + f.a.a.b.b.a.bz(9, this.HFW);
      paramInt = i;
      if (this.HFX != null) {
        paramInt = i + f.a.a.a.lB(10, this.HFX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.Hsd) + f.a.a.b.b.a.bz(12, this.Gdp) + f.a.a.b.b.a.bz(13, this.GSi) + f.a.a.b.b.a.bz(14, this.FGO);
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Fvn);
      }
      i = paramInt;
      if (this.HFY != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.HFY);
      }
      paramInt = i;
      if (this.FOH != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.FOH);
      }
      i = paramInt + f.a.a.b.b.a.bz(18, this.FOI);
      paramInt = i;
      if (this.GJL != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.GJL);
      }
      i = paramInt + f.a.a.b.b.a.bz(20, this.HFN) + f.a.a.b.b.a.bz(21, this.HFO) + f.a.a.b.b.a.bz(22, this.HFP);
      paramInt = i;
      if (this.GJN != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.GJN);
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.HFZ) + f.a.a.b.b.a.bz(25, this.Ges);
      paramInt = i;
      if (this.HGa != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.HGa);
      }
      i = paramInt;
      if (this.HGb != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.HGb);
      }
      i += f.a.a.b.b.a.bz(28, this.HGc);
      paramInt = i;
      if (this.HGd != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.HGd);
      }
      i = paramInt;
      if (this.HGe != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.HGe);
      }
      paramInt = i;
      if (this.HGf != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.HGf);
      }
      i = paramInt;
      if (this.HGg != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.HGg);
      }
      paramInt = i;
      if (this.HGh != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.HGh);
      }
      i = paramInt;
      if (this.HGi != null) {
        i = paramInt + f.a.a.b.b.a.e(34, this.HGi);
      }
      paramInt = i;
      if (this.HGj != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.HGj);
      }
      i = paramInt + f.a.a.b.b.a.bz(36, this.Hqi);
      paramInt = i;
      if (this.HGk != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.HGk);
      }
      i = paramInt + f.a.a.b.b.a.bz(38, this.FOJ) + f.a.a.b.b.a.bz(39, this.FOK) + f.a.a.b.b.a.bz(40, this.tRT);
      paramInt = i;
      if (this.FOL != null) {
        paramInt = i + f.a.a.b.b.a.e(41, this.FOL);
      }
      AppMethodBeat.o(127180);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GSh == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        if (this.HFX == null)
        {
          paramVarArgs = new b("Not all required fields were included: VideoData");
          AppMethodBeat.o(127180);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dth localdth = (dth)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127180);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdth.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 2: 
          localdth.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 3: 
          localdth.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 4: 
          localdth.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 5: 
          localdth.GSf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 6: 
          localdth.GSg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdth.GSh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 8: 
          localdth.HFV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 9: 
          localdth.HFW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdth.HFX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127180);
          return 0;
        case 11: 
          localdth.Hsd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 12: 
          localdth.Gdp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 13: 
          localdth.GSi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 14: 
          localdth.FGO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 15: 
          localdth.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 16: 
          localdth.HFY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 17: 
          localdth.FOH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 18: 
          localdth.FOI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 19: 
          localdth.GJL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 20: 
          localdth.HFN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 21: 
          localdth.HFO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 22: 
          localdth.HFP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 23: 
          localdth.GJN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 24: 
          localdth.HFZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 25: 
          localdth.Ges = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 26: 
          localdth.HGa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 27: 
          localdth.HGb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 28: 
          localdth.HGc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 29: 
          localdth.HGd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 30: 
          localdth.HGe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 31: 
          localdth.HGf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 32: 
          localdth.HGg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 33: 
          localdth.HGh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 34: 
          localdth.HGi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 35: 
          localdth.HGj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 36: 
          localdth.Hqi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 37: 
          localdth.HGk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127180);
          return 0;
        case 38: 
          localdth.FOJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 39: 
          localdth.FOK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        case 40: 
          localdth.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127180);
          return 0;
        }
        localdth.FOL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(127180);
        return 0;
      }
      AppMethodBeat.o(127180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dth
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cou
  extends cvp
{
  public String Cxm;
  public String Cyu;
  public boolean GNn;
  public int GXO;
  public ckz GXU;
  public String HgB;
  public String HgD;
  public String HhD;
  public String HhE;
  public String HhF;
  public int HhG;
  public LinkedList<afa> HhH;
  public int HhI;
  public LinkedList<afa> HhJ;
  public afa HhK;
  public LinkedList<afa> HhL;
  public afa HhM;
  public bzb HhN;
  public String HhO;
  public int HhP;
  public String HhQ;
  public int HhR;
  public boolean HhS;
  public String HhT;
  public String HhU;
  public LinkedList<ccg> HhV;
  public String HhW;
  public String HhX;
  public String HhY;
  public ccg HhZ;
  public String Hhx;
  public bsx Hia;
  public bsx Hib;
  public String Hic;
  public String Hid;
  public alf Hie;
  public LinkedList<ccg> Hif;
  public String Hig;
  public String Hih;
  public btv Hii;
  public int dMY;
  public int ozR;
  public String ozS;
  public int uxm;
  
  public cou()
  {
    AppMethodBeat.i(91644);
    this.HhH = new LinkedList();
    this.HhJ = new LinkedList();
    this.HhL = new LinkedList();
    this.HhV = new LinkedList();
    this.Hif = new LinkedList();
    AppMethodBeat.o(91644);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91645);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91645);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.aS(4, this.GXO);
      if (this.HhD != null) {
        paramVarArgs.d(5, this.HhD);
      }
      if (this.HhE != null) {
        paramVarArgs.d(6, this.HhE);
      }
      if (this.HhF != null) {
        paramVarArgs.d(7, this.HhF);
      }
      paramVarArgs.aS(8, this.HhG);
      paramVarArgs.e(9, 8, this.HhH);
      paramVarArgs.aS(10, this.dMY);
      paramVarArgs.aS(11, this.HhI);
      paramVarArgs.e(12, 8, this.HhJ);
      if (this.HgB != null) {
        paramVarArgs.d(13, this.HgB);
      }
      if (this.HhK != null)
      {
        paramVarArgs.lC(14, this.HhK.computeSize());
        this.HhK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.HhL);
      if (this.HhM != null)
      {
        paramVarArgs.lC(16, this.HhM.computeSize());
        this.HhM.writeFields(paramVarArgs);
      }
      if (this.HhN != null)
      {
        paramVarArgs.lC(17, this.HhN.computeSize());
        this.HhN.writeFields(paramVarArgs);
      }
      if (this.HhO != null) {
        paramVarArgs.d(18, this.HhO);
      }
      paramVarArgs.aS(19, this.HhP);
      if (this.HhQ != null) {
        paramVarArgs.d(20, this.HhQ);
      }
      if (this.Hhx != null) {
        paramVarArgs.d(21, this.Hhx);
      }
      paramVarArgs.aS(22, this.HhR);
      paramVarArgs.bt(23, this.HhS);
      paramVarArgs.aS(24, this.uxm);
      if (this.HgD != null) {
        paramVarArgs.d(25, this.HgD);
      }
      if (this.HhT != null) {
        paramVarArgs.d(26, this.HhT);
      }
      if (this.HhU != null) {
        paramVarArgs.d(27, this.HhU);
      }
      paramVarArgs.e(28, 8, this.HhV);
      if (this.HhW != null) {
        paramVarArgs.d(29, this.HhW);
      }
      if (this.HhX != null) {
        paramVarArgs.d(30, this.HhX);
      }
      if (this.HhY != null) {
        paramVarArgs.d(31, this.HhY);
      }
      if (this.Cxm != null) {
        paramVarArgs.d(32, this.Cxm);
      }
      if (this.HhZ != null)
      {
        paramVarArgs.lC(33, this.HhZ.computeSize());
        this.HhZ.writeFields(paramVarArgs);
      }
      if (this.Hia != null)
      {
        paramVarArgs.lC(34, this.Hia.computeSize());
        this.Hia.writeFields(paramVarArgs);
      }
      if (this.Hib != null)
      {
        paramVarArgs.lC(35, this.Hib.computeSize());
        this.Hib.writeFields(paramVarArgs);
      }
      if (this.Hic != null) {
        paramVarArgs.d(36, this.Hic);
      }
      if (this.Hid != null) {
        paramVarArgs.d(37, this.Hid);
      }
      if (this.Hie != null)
      {
        paramVarArgs.lC(38, this.Hie.computeSize());
        this.Hie.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(39, this.GNn);
      if (this.GXU != null)
      {
        paramVarArgs.lC(40, this.GXU.computeSize());
        this.GXU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(41, 8, this.Hif);
      if (this.Hig != null) {
        paramVarArgs.d(42, this.Hig);
      }
      if (this.Hih != null) {
        paramVarArgs.d(43, this.Hih);
      }
      if (this.Hii != null)
      {
        paramVarArgs.lC(45, this.Hii.computeSize());
        this.Hii.writeFields(paramVarArgs);
      }
      if (this.Cyu != null) {
        paramVarArgs.d(100, this.Cyu);
      }
      AppMethodBeat.o(91645);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label4362;
      }
    }
    label4362:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GXO);
      paramInt = i;
      if (this.HhD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HhD);
      }
      i = paramInt;
      if (this.HhE != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HhE);
      }
      paramInt = i;
      if (this.HhF != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HhF);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HhG) + f.a.a.a.c(9, 8, this.HhH) + f.a.a.b.b.a.bz(10, this.dMY) + f.a.a.b.b.a.bz(11, this.HhI) + f.a.a.a.c(12, 8, this.HhJ);
      paramInt = i;
      if (this.HgB != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.HgB);
      }
      i = paramInt;
      if (this.HhK != null) {
        i = paramInt + f.a.a.a.lB(14, this.HhK.computeSize());
      }
      i += f.a.a.a.c(15, 8, this.HhL);
      paramInt = i;
      if (this.HhM != null) {
        paramInt = i + f.a.a.a.lB(16, this.HhM.computeSize());
      }
      i = paramInt;
      if (this.HhN != null) {
        i = paramInt + f.a.a.a.lB(17, this.HhN.computeSize());
      }
      paramInt = i;
      if (this.HhO != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HhO);
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.HhP);
      paramInt = i;
      if (this.HhQ != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.HhQ);
      }
      i = paramInt;
      if (this.Hhx != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.Hhx);
      }
      i = i + f.a.a.b.b.a.bz(22, this.HhR) + f.a.a.b.b.a.alV(23) + f.a.a.b.b.a.bz(24, this.uxm);
      paramInt = i;
      if (this.HgD != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.HgD);
      }
      i = paramInt;
      if (this.HhT != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.HhT);
      }
      paramInt = i;
      if (this.HhU != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.HhU);
      }
      i = paramInt + f.a.a.a.c(28, 8, this.HhV);
      paramInt = i;
      if (this.HhW != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.HhW);
      }
      i = paramInt;
      if (this.HhX != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.HhX);
      }
      paramInt = i;
      if (this.HhY != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.HhY);
      }
      i = paramInt;
      if (this.Cxm != null) {
        i = paramInt + f.a.a.b.b.a.e(32, this.Cxm);
      }
      paramInt = i;
      if (this.HhZ != null) {
        paramInt = i + f.a.a.a.lB(33, this.HhZ.computeSize());
      }
      i = paramInt;
      if (this.Hia != null) {
        i = paramInt + f.a.a.a.lB(34, this.Hia.computeSize());
      }
      paramInt = i;
      if (this.Hib != null) {
        paramInt = i + f.a.a.a.lB(35, this.Hib.computeSize());
      }
      i = paramInt;
      if (this.Hic != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.Hic);
      }
      paramInt = i;
      if (this.Hid != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.Hid);
      }
      i = paramInt;
      if (this.Hie != null) {
        i = paramInt + f.a.a.a.lB(38, this.Hie.computeSize());
      }
      i += f.a.a.b.b.a.alV(39);
      paramInt = i;
      if (this.GXU != null) {
        paramInt = i + f.a.a.a.lB(40, this.GXU.computeSize());
      }
      i = paramInt + f.a.a.a.c(41, 8, this.Hif);
      paramInt = i;
      if (this.Hig != null) {
        paramInt = i + f.a.a.b.b.a.e(42, this.Hig);
      }
      i = paramInt;
      if (this.Hih != null) {
        i = paramInt + f.a.a.b.b.a.e(43, this.Hih);
      }
      paramInt = i;
      if (this.Hii != null) {
        paramInt = i + f.a.a.a.lB(45, this.Hii.computeSize());
      }
      i = paramInt;
      if (this.Cyu != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.Cyu);
      }
      AppMethodBeat.o(91645);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HhH.clear();
        this.HhJ.clear();
        this.HhL.clear();
        this.HhV.clear();
        this.Hif.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91645);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91645);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cou localcou = (cou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 44: 
        case 46: 
        case 47: 
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 57: 
        case 58: 
        case 59: 
        case 60: 
        case 61: 
        case 62: 
        case 63: 
        case 64: 
        case 65: 
        case 66: 
        case 67: 
        case 68: 
        case 69: 
        case 70: 
        case 71: 
        case 72: 
        case 73: 
        case 74: 
        case 75: 
        case 76: 
        case 77: 
        case 78: 
        case 79: 
        case 80: 
        case 81: 
        case 82: 
        case 83: 
        case 84: 
        case 85: 
        case 86: 
        case 87: 
        case 88: 
        case 89: 
        case 90: 
        case 91: 
        case 92: 
        case 93: 
        case 94: 
        case 95: 
        case 96: 
        case 97: 
        case 98: 
        case 99: 
        default: 
          AppMethodBeat.o(91645);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 2: 
          localcou.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 3: 
          localcou.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 4: 
          localcou.GXO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 5: 
          localcou.HhD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 6: 
          localcou.HhE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 7: 
          localcou.HhF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 8: 
          localcou.HhG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.HhH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 10: 
          localcou.dMY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 11: 
          localcou.HhI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.HhJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 13: 
          localcou.HgB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.HhK = ((afa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.HhL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.HhM = ((afa)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.HhN = ((bzb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 18: 
          localcou.HhO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 19: 
          localcou.HhP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 20: 
          localcou.HhQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 21: 
          localcou.Hhx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 22: 
          localcou.HhR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 23: 
          localcou.HhS = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91645);
          return 0;
        case 24: 
          localcou.uxm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91645);
          return 0;
        case 25: 
          localcou.HgD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 26: 
          localcou.HhT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 27: 
          localcou.HhU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.HhV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 29: 
          localcou.HhW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 30: 
          localcou.HhX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 31: 
          localcou.HhY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 32: 
          localcou.Cxm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.HhZ = ((ccg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.Hia = ((bsx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 35: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.Hib = ((bsx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 36: 
          localcou.Hic = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 37: 
          localcou.Hid = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 38: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.Hie = ((alf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 39: 
          localcou.GNn = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91645);
          return 0;
        case 40: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.GXU = ((ckz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 41: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.Hif.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        case 42: 
          localcou.Hig = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 43: 
          localcou.Hih = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91645);
          return 0;
        case 45: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcou.Hii = ((btv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91645);
          return 0;
        }
        localcou.Cyu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91645);
        return 0;
      }
      AppMethodBeat.o(91645);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cou
 * JD-Core Version:    0.7.0.1
 */
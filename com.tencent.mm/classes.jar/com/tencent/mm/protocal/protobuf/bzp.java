package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzp
  extends com.tencent.mm.bx.a
{
  public int DeleteFlag;
  public int ExtFlag;
  public String FVo;
  public String FVp;
  public String Fvh;
  public SKBuiltinBuffer_t Fvm;
  public String GDx;
  public cwt GKC;
  public int GNU;
  public String GNV;
  public String GNW;
  public String GNX;
  public int GNY;
  public dhg GOa;
  public acf GOb;
  public cwt GTS;
  public cwt GTT;
  public cwt GTU;
  public int GUA;
  public String GUB;
  public ckj GUC;
  public int GUD;
  public int GUE;
  public String GUF;
  public int GUi;
  public cwt GUm;
  public int GUn;
  public int GUo;
  public String GUp;
  public String GUq;
  public String GUr;
  public String GUs;
  public String GUt;
  public String GUu;
  public String GUv;
  public String GUw;
  public dh GUx;
  public int GUy;
  public int GUz;
  public int GaB;
  public int GaC;
  public int GaH;
  public int GaI;
  public LinkedList<cwf> GaJ;
  public int GaL;
  public int GaM;
  public cwt GbY;
  public int GbZ;
  public cwt Gbr;
  public cwt Gbs;
  public String Gca;
  public String GtU;
  public vv GwB;
  public String ePI;
  public long ePP;
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  public int jdg;
  public String jdh;
  public int jdi;
  public int jdj;
  public String jdk;
  public String jdl;
  public String jdm;
  public int tRT;
  public String ukw;
  
  public bzp()
  {
    AppMethodBeat.i(43106);
    this.GaJ = new LinkedList();
    AppMethodBeat.o(43106);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43107);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbY == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.GKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.Gbr == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.Gbs == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.GbY != null)
      {
        paramVarArgs.lC(1, this.GbY.computeSize());
        this.GbY.writeFields(paramVarArgs);
      }
      if (this.GKC != null)
      {
        paramVarArgs.lC(2, this.GKC.computeSize());
        this.GKC.writeFields(paramVarArgs);
      }
      if (this.Gbr != null)
      {
        paramVarArgs.lC(3, this.Gbr.computeSize());
        this.Gbr.writeFields(paramVarArgs);
      }
      if (this.Gbs != null)
      {
        paramVarArgs.lC(4, this.Gbs.computeSize());
        this.Gbs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.jdc);
      if (this.Fvm != null)
      {
        paramVarArgs.lC(6, this.Fvm.computeSize());
        this.Fvm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.GaB);
      paramVarArgs.aS(8, this.GaC);
      paramVarArgs.aS(9, this.GUi);
      if (this.GTS != null)
      {
        paramVarArgs.lC(10, this.GTS.computeSize());
        this.GTS.writeFields(paramVarArgs);
      }
      if (this.GTT != null)
      {
        paramVarArgs.lC(11, this.GTT.computeSize());
        this.GTT.writeFields(paramVarArgs);
      }
      if (this.GTU != null)
      {
        paramVarArgs.lC(12, this.GTU.computeSize());
        this.GTU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.GaH);
      paramVarArgs.aS(14, this.GaI);
      paramVarArgs.e(15, 8, this.GaJ);
      if (this.GUm != null)
      {
        paramVarArgs.lC(16, this.GUm.computeSize());
        this.GUm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(17, this.GaL);
      paramVarArgs.aS(18, this.GaM);
      if (this.jdd != null) {
        paramVarArgs.d(19, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(20, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(21, this.jdf);
      }
      paramVarArgs.aS(22, this.jdg);
      paramVarArgs.aS(23, this.GUn);
      paramVarArgs.aS(24, this.GNU);
      if (this.GNV != null) {
        paramVarArgs.d(25, this.GNV);
      }
      paramVarArgs.aS(26, this.GUo);
      paramVarArgs.aS(27, this.tRT);
      if (this.GNW != null) {
        paramVarArgs.d(28, this.GNW);
      }
      if (this.GDx != null) {
        paramVarArgs.d(29, this.GDx);
      }
      if (this.jdh != null) {
        paramVarArgs.d(30, this.jdh);
      }
      if (this.GUp != null) {
        paramVarArgs.d(31, this.GUp);
      }
      if (this.GNX != null) {
        paramVarArgs.d(32, this.GNX);
      }
      paramVarArgs.aS(33, this.GNY);
      paramVarArgs.aS(34, this.jdj);
      paramVarArgs.aS(35, this.jdi);
      if (this.jdk != null) {
        paramVarArgs.d(36, this.jdk);
      }
      if (this.GOa != null)
      {
        paramVarArgs.lC(37, this.GOa.computeSize());
        this.GOa.writeFields(paramVarArgs);
      }
      if (this.jdl != null) {
        paramVarArgs.d(38, this.jdl);
      }
      if (this.FVo != null) {
        paramVarArgs.d(39, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(40, this.FVp);
      }
      if (this.jdm != null) {
        paramVarArgs.d(41, this.jdm);
      }
      if (this.GOb != null)
      {
        paramVarArgs.lC(42, this.GOb.computeSize());
        this.GOb.writeFields(paramVarArgs);
      }
      if (this.GUq != null) {
        paramVarArgs.d(43, this.GUq);
      }
      if (this.GUr != null) {
        paramVarArgs.d(44, this.GUr);
      }
      if (this.GUs != null) {
        paramVarArgs.d(45, this.GUs);
      }
      if (this.GUt != null) {
        paramVarArgs.d(46, this.GUt);
      }
      if (this.GUu != null) {
        paramVarArgs.d(47, this.GUu);
      }
      if (this.GUv != null) {
        paramVarArgs.d(48, this.GUv);
      }
      if (this.GUw != null) {
        paramVarArgs.d(49, this.GUw);
      }
      if (this.GUx != null)
      {
        paramVarArgs.lC(50, this.GUx.computeSize());
        this.GUx.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(53, this.GUy);
      if (this.ukw != null) {
        paramVarArgs.d(54, this.ukw);
      }
      paramVarArgs.aS(55, this.GUz);
      paramVarArgs.aS(56, this.GUA);
      if (this.GwB != null)
      {
        paramVarArgs.lC(57, this.GwB.computeSize());
        this.GwB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(58, this.DeleteFlag);
      if (this.Fvh != null) {
        paramVarArgs.d(59, this.Fvh);
      }
      if (this.GUB != null) {
        paramVarArgs.d(60, this.GUB);
      }
      if (this.Gca != null) {
        paramVarArgs.d(61, this.Gca);
      }
      if (this.GUC != null)
      {
        paramVarArgs.lC(62, this.GUC.computeSize());
        this.GUC.writeFields(paramVarArgs);
      }
      if (this.ePI != null) {
        paramVarArgs.d(63, this.ePI);
      }
      paramVarArgs.aS(64, this.GUD);
      paramVarArgs.aS(65, this.GbZ);
      paramVarArgs.aS(66, this.GUE);
      paramVarArgs.aS(67, this.ExtFlag);
      if (this.GUF != null) {
        paramVarArgs.d(68, this.GUF);
      }
      paramVarArgs.aY(70, this.ePP);
      if (this.GtU != null) {
        paramVarArgs.d(71, this.GtU);
      }
      AppMethodBeat.o(43107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbY == null) {
        break label5582;
      }
    }
    label5582:
    for (int i = f.a.a.a.lB(1, this.GbY.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GKC != null) {
        paramInt = i + f.a.a.a.lB(2, this.GKC.computeSize());
      }
      i = paramInt;
      if (this.Gbr != null) {
        i = paramInt + f.a.a.a.lB(3, this.Gbr.computeSize());
      }
      paramInt = i;
      if (this.Gbs != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gbs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jdc);
      paramInt = i;
      if (this.Fvm != null) {
        paramInt = i + f.a.a.a.lB(6, this.Fvm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.GaB) + f.a.a.b.b.a.bz(8, this.GaC) + f.a.a.b.b.a.bz(9, this.GUi);
      paramInt = i;
      if (this.GTS != null) {
        paramInt = i + f.a.a.a.lB(10, this.GTS.computeSize());
      }
      i = paramInt;
      if (this.GTT != null) {
        i = paramInt + f.a.a.a.lB(11, this.GTT.computeSize());
      }
      paramInt = i;
      if (this.GTU != null) {
        paramInt = i + f.a.a.a.lB(12, this.GTU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.GaH) + f.a.a.b.b.a.bz(14, this.GaI) + f.a.a.a.c(15, 8, this.GaJ);
      paramInt = i;
      if (this.GUm != null) {
        paramInt = i + f.a.a.a.lB(16, this.GUm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.GaL) + f.a.a.b.b.a.bz(18, this.GaM);
      paramInt = i;
      if (this.jdd != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.jdd);
      }
      i = paramInt;
      if (this.jde != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.jde);
      }
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.jdf);
      }
      i = paramInt + f.a.a.b.b.a.bz(22, this.jdg) + f.a.a.b.b.a.bz(23, this.GUn) + f.a.a.b.b.a.bz(24, this.GNU);
      paramInt = i;
      if (this.GNV != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.GNV);
      }
      i = paramInt + f.a.a.b.b.a.bz(26, this.GUo) + f.a.a.b.b.a.bz(27, this.tRT);
      paramInt = i;
      if (this.GNW != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.GNW);
      }
      i = paramInt;
      if (this.GDx != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.GDx);
      }
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.jdh);
      }
      i = paramInt;
      if (this.GUp != null) {
        i = paramInt + f.a.a.b.b.a.e(31, this.GUp);
      }
      paramInt = i;
      if (this.GNX != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.GNX);
      }
      i = paramInt + f.a.a.b.b.a.bz(33, this.GNY) + f.a.a.b.b.a.bz(34, this.jdj) + f.a.a.b.b.a.bz(35, this.jdi);
      paramInt = i;
      if (this.jdk != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.jdk);
      }
      i = paramInt;
      if (this.GOa != null) {
        i = paramInt + f.a.a.a.lB(37, this.GOa.computeSize());
      }
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.jdl);
      }
      i = paramInt;
      if (this.FVo != null) {
        i = paramInt + f.a.a.b.b.a.e(39, this.FVo);
      }
      paramInt = i;
      if (this.FVp != null) {
        paramInt = i + f.a.a.b.b.a.e(40, this.FVp);
      }
      i = paramInt;
      if (this.jdm != null) {
        i = paramInt + f.a.a.b.b.a.e(41, this.jdm);
      }
      paramInt = i;
      if (this.GOb != null) {
        paramInt = i + f.a.a.a.lB(42, this.GOb.computeSize());
      }
      i = paramInt;
      if (this.GUq != null) {
        i = paramInt + f.a.a.b.b.a.e(43, this.GUq);
      }
      paramInt = i;
      if (this.GUr != null) {
        paramInt = i + f.a.a.b.b.a.e(44, this.GUr);
      }
      i = paramInt;
      if (this.GUs != null) {
        i = paramInt + f.a.a.b.b.a.e(45, this.GUs);
      }
      paramInt = i;
      if (this.GUt != null) {
        paramInt = i + f.a.a.b.b.a.e(46, this.GUt);
      }
      i = paramInt;
      if (this.GUu != null) {
        i = paramInt + f.a.a.b.b.a.e(47, this.GUu);
      }
      paramInt = i;
      if (this.GUv != null) {
        paramInt = i + f.a.a.b.b.a.e(48, this.GUv);
      }
      i = paramInt;
      if (this.GUw != null) {
        i = paramInt + f.a.a.b.b.a.e(49, this.GUw);
      }
      paramInt = i;
      if (this.GUx != null) {
        paramInt = i + f.a.a.a.lB(50, this.GUx.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(53, this.GUy);
      paramInt = i;
      if (this.ukw != null) {
        paramInt = i + f.a.a.b.b.a.e(54, this.ukw);
      }
      i = paramInt + f.a.a.b.b.a.bz(55, this.GUz) + f.a.a.b.b.a.bz(56, this.GUA);
      paramInt = i;
      if (this.GwB != null) {
        paramInt = i + f.a.a.a.lB(57, this.GwB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(58, this.DeleteFlag);
      paramInt = i;
      if (this.Fvh != null) {
        paramInt = i + f.a.a.b.b.a.e(59, this.Fvh);
      }
      i = paramInt;
      if (this.GUB != null) {
        i = paramInt + f.a.a.b.b.a.e(60, this.GUB);
      }
      paramInt = i;
      if (this.Gca != null) {
        paramInt = i + f.a.a.b.b.a.e(61, this.Gca);
      }
      i = paramInt;
      if (this.GUC != null) {
        i = paramInt + f.a.a.a.lB(62, this.GUC.computeSize());
      }
      paramInt = i;
      if (this.ePI != null) {
        paramInt = i + f.a.a.b.b.a.e(63, this.ePI);
      }
      i = paramInt + f.a.a.b.b.a.bz(64, this.GUD) + f.a.a.b.b.a.bz(65, this.GbZ) + f.a.a.b.b.a.bz(66, this.GUE) + f.a.a.b.b.a.bz(67, this.ExtFlag);
      paramInt = i;
      if (this.GUF != null) {
        paramInt = i + f.a.a.b.b.a.e(68, this.GUF);
      }
      i = paramInt + f.a.a.b.b.a.p(70, this.ePP);
      paramInt = i;
      if (this.GtU != null) {
        paramInt = i + f.a.a.b.b.a.e(71, this.GtU);
      }
      AppMethodBeat.o(43107);
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
        if (this.GbY == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.GKC == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.Gbr == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.Gbs == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.Fvm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43107);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzp localbzp = (bzp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 51: 
        case 52: 
        case 69: 
        default: 
          AppMethodBeat.o(43107);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GbY = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GKC = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.Gbr = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.Gbs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 5: 
          localbzp.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
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
            localbzp.Fvm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 7: 
          localbzp.GaB = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 8: 
          localbzp.GaC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 9: 
          localbzp.GUi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GTS = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GTT = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GTU = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 13: 
          localbzp.GaH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 14: 
          localbzp.GaI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
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
            localbzp.GaJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GUm = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 17: 
          localbzp.GaL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 18: 
          localbzp.GaM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 19: 
          localbzp.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 20: 
          localbzp.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 21: 
          localbzp.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 22: 
          localbzp.jdg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 23: 
          localbzp.GUn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 24: 
          localbzp.GNU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 25: 
          localbzp.GNV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 26: 
          localbzp.GUo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 27: 
          localbzp.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 28: 
          localbzp.GNW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 29: 
          localbzp.GDx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 30: 
          localbzp.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 31: 
          localbzp.GUp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 32: 
          localbzp.GNX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 33: 
          localbzp.GNY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 34: 
          localbzp.jdj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 35: 
          localbzp.jdi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 36: 
          localbzp.jdk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 37: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GOa = ((dhg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 38: 
          localbzp.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 39: 
          localbzp.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 40: 
          localbzp.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 41: 
          localbzp.jdm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 42: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GOb = ((acf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 43: 
          localbzp.GUq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 44: 
          localbzp.GUr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 45: 
          localbzp.GUs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 46: 
          localbzp.GUt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 47: 
          localbzp.GUu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 48: 
          localbzp.GUv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 49: 
          localbzp.GUw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 50: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GUx = ((dh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 53: 
          localbzp.GUy = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 54: 
          localbzp.ukw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 55: 
          localbzp.GUz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 56: 
          localbzp.GUA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 57: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GwB = ((vv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 58: 
          localbzp.DeleteFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 59: 
          localbzp.Fvh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 60: 
          localbzp.GUB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 61: 
          localbzp.Gca = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 62: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzp.GUC = ((ckj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 63: 
          localbzp.ePI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 64: 
          localbzp.GUD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 65: 
          localbzp.GbZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 66: 
          localbzp.GUE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 67: 
          localbzp.ExtFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(43107);
          return 0;
        case 68: 
          localbzp.GUF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 70: 
          localbzp.ePP = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(43107);
          return 0;
        }
        localbzp.GtU = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43107);
        return 0;
      }
      AppMethodBeat.o(43107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzp
 * JD-Core Version:    0.7.0.1
 */
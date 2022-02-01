package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bqj
  extends com.tencent.mm.bx.a
{
  public String CVv;
  public String CVw;
  public SKBuiltinBuffer_t CxB;
  public String Cxw;
  public cmf DFJ;
  public int DIV;
  public String DIW;
  public String DIX;
  public String DIY;
  public int DIZ;
  public cwh DJb;
  public zh DJc;
  public cmf DNT;
  public cmf DNU;
  public cmf DNV;
  public int DOA;
  public int DOB;
  public String DOC;
  public cal DOD;
  public int DOE;
  public int DOF;
  public String DOG;
  public int DOj;
  public cmf DOn;
  public int DOo;
  public int DOp;
  public String DOq;
  public String DOr;
  public String DOs;
  public String DOt;
  public String DOu;
  public String DOv;
  public String DOw;
  public String DOx;
  public de DOy;
  public int DOz;
  public int Dan;
  public int Dao;
  public int Dat;
  public int Dau;
  public LinkedList<clr> Dav;
  public int Dax;
  public int Day;
  public String DbA;
  public cmf Dbb;
  public cmf Dbc;
  public cmf Dby;
  public int Dbz;
  public int DeleteFlag;
  public tq Dst;
  public String DyE;
  public int ExtFlag;
  public String evN;
  public long evU;
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  public int ijQ;
  public String ijR;
  public int ijS;
  public int ijT;
  public String ijU;
  public String ijV;
  public String ijW;
  public int rNz;
  public String sed;
  
  public bqj()
  {
    AppMethodBeat.i(43106);
    this.Dav = new LinkedList();
    AppMethodBeat.o(43106);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43107);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dby == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.DFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.Dbb == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.Dbc == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(43107);
        throw paramVarArgs;
      }
      if (this.Dby != null)
      {
        paramVarArgs.kX(1, this.Dby.computeSize());
        this.Dby.writeFields(paramVarArgs);
      }
      if (this.DFJ != null)
      {
        paramVarArgs.kX(2, this.DFJ.computeSize());
        this.DFJ.writeFields(paramVarArgs);
      }
      if (this.Dbb != null)
      {
        paramVarArgs.kX(3, this.Dbb.computeSize());
        this.Dbb.writeFields(paramVarArgs);
      }
      if (this.Dbc != null)
      {
        paramVarArgs.kX(4, this.Dbc.computeSize());
        this.Dbc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.ijM);
      if (this.CxB != null)
      {
        paramVarArgs.kX(6, this.CxB.computeSize());
        this.CxB.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.Dan);
      paramVarArgs.aR(8, this.Dao);
      paramVarArgs.aR(9, this.DOj);
      if (this.DNT != null)
      {
        paramVarArgs.kX(10, this.DNT.computeSize());
        this.DNT.writeFields(paramVarArgs);
      }
      if (this.DNU != null)
      {
        paramVarArgs.kX(11, this.DNU.computeSize());
        this.DNU.writeFields(paramVarArgs);
      }
      if (this.DNV != null)
      {
        paramVarArgs.kX(12, this.DNV.computeSize());
        this.DNV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(13, this.Dat);
      paramVarArgs.aR(14, this.Dau);
      paramVarArgs.e(15, 8, this.Dav);
      if (this.DOn != null)
      {
        paramVarArgs.kX(16, this.DOn.computeSize());
        this.DOn.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(17, this.Dax);
      paramVarArgs.aR(18, this.Day);
      if (this.ijN != null) {
        paramVarArgs.d(19, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(20, this.ijO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(21, this.ijP);
      }
      paramVarArgs.aR(22, this.ijQ);
      paramVarArgs.aR(23, this.DOo);
      paramVarArgs.aR(24, this.DIV);
      if (this.DIW != null) {
        paramVarArgs.d(25, this.DIW);
      }
      paramVarArgs.aR(26, this.DOp);
      paramVarArgs.aR(27, this.rNz);
      if (this.DIX != null) {
        paramVarArgs.d(28, this.DIX);
      }
      if (this.DyE != null) {
        paramVarArgs.d(29, this.DyE);
      }
      if (this.ijR != null) {
        paramVarArgs.d(30, this.ijR);
      }
      if (this.DOq != null) {
        paramVarArgs.d(31, this.DOq);
      }
      if (this.DIY != null) {
        paramVarArgs.d(32, this.DIY);
      }
      paramVarArgs.aR(33, this.DIZ);
      paramVarArgs.aR(34, this.ijT);
      paramVarArgs.aR(35, this.ijS);
      if (this.ijU != null) {
        paramVarArgs.d(36, this.ijU);
      }
      if (this.DJb != null)
      {
        paramVarArgs.kX(37, this.DJb.computeSize());
        this.DJb.writeFields(paramVarArgs);
      }
      if (this.ijV != null) {
        paramVarArgs.d(38, this.ijV);
      }
      if (this.CVv != null) {
        paramVarArgs.d(39, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(40, this.CVw);
      }
      if (this.ijW != null) {
        paramVarArgs.d(41, this.ijW);
      }
      if (this.DJc != null)
      {
        paramVarArgs.kX(42, this.DJc.computeSize());
        this.DJc.writeFields(paramVarArgs);
      }
      if (this.DOr != null) {
        paramVarArgs.d(43, this.DOr);
      }
      if (this.DOs != null) {
        paramVarArgs.d(44, this.DOs);
      }
      if (this.DOt != null) {
        paramVarArgs.d(45, this.DOt);
      }
      if (this.DOu != null) {
        paramVarArgs.d(46, this.DOu);
      }
      if (this.DOv != null) {
        paramVarArgs.d(47, this.DOv);
      }
      if (this.DOw != null) {
        paramVarArgs.d(48, this.DOw);
      }
      if (this.DOx != null) {
        paramVarArgs.d(49, this.DOx);
      }
      if (this.DOy != null)
      {
        paramVarArgs.kX(50, this.DOy.computeSize());
        this.DOy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(53, this.DOz);
      if (this.sed != null) {
        paramVarArgs.d(54, this.sed);
      }
      paramVarArgs.aR(55, this.DOA);
      paramVarArgs.aR(56, this.DOB);
      if (this.Dst != null)
      {
        paramVarArgs.kX(57, this.Dst.computeSize());
        this.Dst.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(58, this.DeleteFlag);
      if (this.Cxw != null) {
        paramVarArgs.d(59, this.Cxw);
      }
      if (this.DOC != null) {
        paramVarArgs.d(60, this.DOC);
      }
      if (this.DbA != null) {
        paramVarArgs.d(61, this.DbA);
      }
      if (this.DOD != null)
      {
        paramVarArgs.kX(62, this.DOD.computeSize());
        this.DOD.writeFields(paramVarArgs);
      }
      if (this.evN != null) {
        paramVarArgs.d(63, this.evN);
      }
      paramVarArgs.aR(64, this.DOE);
      paramVarArgs.aR(65, this.Dbz);
      paramVarArgs.aR(66, this.DOF);
      paramVarArgs.aR(67, this.ExtFlag);
      if (this.DOG != null) {
        paramVarArgs.d(68, this.DOG);
      }
      paramVarArgs.aG(70, this.evU);
      AppMethodBeat.o(43107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dby == null) {
        break label5522;
      }
    }
    label5522:
    for (int i = f.a.a.a.kW(1, this.Dby.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DFJ != null) {
        paramInt = i + f.a.a.a.kW(2, this.DFJ.computeSize());
      }
      i = paramInt;
      if (this.Dbb != null) {
        i = paramInt + f.a.a.a.kW(3, this.Dbb.computeSize());
      }
      paramInt = i;
      if (this.Dbc != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dbc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.ijM);
      paramInt = i;
      if (this.CxB != null) {
        paramInt = i + f.a.a.a.kW(6, this.CxB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.Dan) + f.a.a.b.b.a.bA(8, this.Dao) + f.a.a.b.b.a.bA(9, this.DOj);
      paramInt = i;
      if (this.DNT != null) {
        paramInt = i + f.a.a.a.kW(10, this.DNT.computeSize());
      }
      i = paramInt;
      if (this.DNU != null) {
        i = paramInt + f.a.a.a.kW(11, this.DNU.computeSize());
      }
      paramInt = i;
      if (this.DNV != null) {
        paramInt = i + f.a.a.a.kW(12, this.DNV.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.Dat) + f.a.a.b.b.a.bA(14, this.Dau) + f.a.a.a.c(15, 8, this.Dav);
      paramInt = i;
      if (this.DOn != null) {
        paramInt = i + f.a.a.a.kW(16, this.DOn.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(17, this.Dax) + f.a.a.b.b.a.bA(18, this.Day);
      paramInt = i;
      if (this.ijN != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.ijN);
      }
      i = paramInt;
      if (this.ijO != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.ijO);
      }
      paramInt = i;
      if (this.ijP != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.ijP);
      }
      i = paramInt + f.a.a.b.b.a.bA(22, this.ijQ) + f.a.a.b.b.a.bA(23, this.DOo) + f.a.a.b.b.a.bA(24, this.DIV);
      paramInt = i;
      if (this.DIW != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.DIW);
      }
      i = paramInt + f.a.a.b.b.a.bA(26, this.DOp) + f.a.a.b.b.a.bA(27, this.rNz);
      paramInt = i;
      if (this.DIX != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.DIX);
      }
      i = paramInt;
      if (this.DyE != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.DyE);
      }
      paramInt = i;
      if (this.ijR != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.ijR);
      }
      i = paramInt;
      if (this.DOq != null) {
        i = paramInt + f.a.a.b.b.a.e(31, this.DOq);
      }
      paramInt = i;
      if (this.DIY != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.DIY);
      }
      i = paramInt + f.a.a.b.b.a.bA(33, this.DIZ) + f.a.a.b.b.a.bA(34, this.ijT) + f.a.a.b.b.a.bA(35, this.ijS);
      paramInt = i;
      if (this.ijU != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.ijU);
      }
      i = paramInt;
      if (this.DJb != null) {
        i = paramInt + f.a.a.a.kW(37, this.DJb.computeSize());
      }
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.ijV);
      }
      i = paramInt;
      if (this.CVv != null) {
        i = paramInt + f.a.a.b.b.a.e(39, this.CVv);
      }
      paramInt = i;
      if (this.CVw != null) {
        paramInt = i + f.a.a.b.b.a.e(40, this.CVw);
      }
      i = paramInt;
      if (this.ijW != null) {
        i = paramInt + f.a.a.b.b.a.e(41, this.ijW);
      }
      paramInt = i;
      if (this.DJc != null) {
        paramInt = i + f.a.a.a.kW(42, this.DJc.computeSize());
      }
      i = paramInt;
      if (this.DOr != null) {
        i = paramInt + f.a.a.b.b.a.e(43, this.DOr);
      }
      paramInt = i;
      if (this.DOs != null) {
        paramInt = i + f.a.a.b.b.a.e(44, this.DOs);
      }
      i = paramInt;
      if (this.DOt != null) {
        i = paramInt + f.a.a.b.b.a.e(45, this.DOt);
      }
      paramInt = i;
      if (this.DOu != null) {
        paramInt = i + f.a.a.b.b.a.e(46, this.DOu);
      }
      i = paramInt;
      if (this.DOv != null) {
        i = paramInt + f.a.a.b.b.a.e(47, this.DOv);
      }
      paramInt = i;
      if (this.DOw != null) {
        paramInt = i + f.a.a.b.b.a.e(48, this.DOw);
      }
      i = paramInt;
      if (this.DOx != null) {
        i = paramInt + f.a.a.b.b.a.e(49, this.DOx);
      }
      paramInt = i;
      if (this.DOy != null) {
        paramInt = i + f.a.a.a.kW(50, this.DOy.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(53, this.DOz);
      paramInt = i;
      if (this.sed != null) {
        paramInt = i + f.a.a.b.b.a.e(54, this.sed);
      }
      i = paramInt + f.a.a.b.b.a.bA(55, this.DOA) + f.a.a.b.b.a.bA(56, this.DOB);
      paramInt = i;
      if (this.Dst != null) {
        paramInt = i + f.a.a.a.kW(57, this.Dst.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(58, this.DeleteFlag);
      paramInt = i;
      if (this.Cxw != null) {
        paramInt = i + f.a.a.b.b.a.e(59, this.Cxw);
      }
      i = paramInt;
      if (this.DOC != null) {
        i = paramInt + f.a.a.b.b.a.e(60, this.DOC);
      }
      paramInt = i;
      if (this.DbA != null) {
        paramInt = i + f.a.a.b.b.a.e(61, this.DbA);
      }
      i = paramInt;
      if (this.DOD != null) {
        i = paramInt + f.a.a.a.kW(62, this.DOD.computeSize());
      }
      paramInt = i;
      if (this.evN != null) {
        paramInt = i + f.a.a.b.b.a.e(63, this.evN);
      }
      i = paramInt + f.a.a.b.b.a.bA(64, this.DOE) + f.a.a.b.b.a.bA(65, this.Dbz) + f.a.a.b.b.a.bA(66, this.DOF) + f.a.a.b.b.a.bA(67, this.ExtFlag);
      paramInt = i;
      if (this.DOG != null) {
        paramInt = i + f.a.a.b.b.a.e(68, this.DOG);
      }
      i = f.a.a.b.b.a.q(70, this.evU);
      AppMethodBeat.o(43107);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dav.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dby == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.DFJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.Dbb == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.Dbc == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(43107);
          throw paramVarArgs;
        }
        if (this.CxB == null)
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
        bqj localbqj = (bqj)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.Dby = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.DFJ = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.Dbb = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.Dbc = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 5: 
          localbqj.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.CxB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 7: 
          localbqj.Dan = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 8: 
          localbqj.Dao = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 9: 
          localbqj.DOj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.DNT = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.DNU = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.DNV = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 13: 
          localbqj.Dat = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 14: 
          localbqj.Dau = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.Dav.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.DOn = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 17: 
          localbqj.Dax = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 18: 
          localbqj.Day = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 19: 
          localbqj.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 20: 
          localbqj.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 21: 
          localbqj.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 22: 
          localbqj.ijQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 23: 
          localbqj.DOo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 24: 
          localbqj.DIV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 25: 
          localbqj.DIW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 26: 
          localbqj.DOp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 27: 
          localbqj.rNz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 28: 
          localbqj.DIX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 29: 
          localbqj.DyE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 30: 
          localbqj.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 31: 
          localbqj.DOq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 32: 
          localbqj.DIY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 33: 
          localbqj.DIZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 34: 
          localbqj.ijT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 35: 
          localbqj.ijS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 36: 
          localbqj.ijU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 37: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.DJb = ((cwh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 38: 
          localbqj.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 39: 
          localbqj.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 40: 
          localbqj.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 41: 
          localbqj.ijW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 42: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.DJc = ((zh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 43: 
          localbqj.DOr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 44: 
          localbqj.DOs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 45: 
          localbqj.DOt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 46: 
          localbqj.DOu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 47: 
          localbqj.DOv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 48: 
          localbqj.DOw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 49: 
          localbqj.DOx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 50: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.DOy = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 53: 
          localbqj.DOz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 54: 
          localbqj.sed = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 55: 
          localbqj.DOA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 56: 
          localbqj.DOB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 57: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.Dst = ((tq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 58: 
          localbqj.DeleteFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 59: 
          localbqj.Cxw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 60: 
          localbqj.DOC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 61: 
          localbqj.DbA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 62: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cal();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cal)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqj.DOD = ((cal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43107);
          return 0;
        case 63: 
          localbqj.evN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        case 64: 
          localbqj.DOE = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 65: 
          localbqj.Dbz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 66: 
          localbqj.DOF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 67: 
          localbqj.ExtFlag = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43107);
          return 0;
        case 68: 
          localbqj.DOG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(43107);
          return 0;
        }
        localbqj.evU = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(43107);
        return 0;
      }
      AppMethodBeat.o(43107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqj
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyc
  extends cvp
{
  public String FVo;
  public String FVp;
  public SKBuiltinBuffer_t Fvm;
  public cwt GKC;
  public int GNU;
  public String GNV;
  public String GNW;
  public String GNX;
  public int GNY;
  public dhg GOa;
  public acf GOb;
  public cwt GbY;
  public cwt Gbr;
  public cwt Gbs;
  public String Guj;
  public int GwU;
  public LinkedList<cya> GwV;
  public int Hpn;
  public SKBuiltinBuffer_t Hpp;
  public String Hpq;
  public String Hpr;
  public int Hps;
  public LinkedList<cyp> Hpt;
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
  
  public cyc()
  {
    AppMethodBeat.i(152683);
    this.GwV = new LinkedList();
    this.Hpt = new LinkedList();
    AppMethodBeat.o(152683);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152684);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.GbY == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.GKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.Gbr == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.Gbs == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GbY != null)
      {
        paramVarArgs.lC(2, this.GbY.computeSize());
        this.GbY.writeFields(paramVarArgs);
      }
      if (this.GKC != null)
      {
        paramVarArgs.lC(3, this.GKC.computeSize());
        this.GKC.writeFields(paramVarArgs);
      }
      if (this.Gbr != null)
      {
        paramVarArgs.lC(4, this.Gbr.computeSize());
        this.Gbr.writeFields(paramVarArgs);
      }
      if (this.Gbs != null)
      {
        paramVarArgs.lC(5, this.Gbs.computeSize());
        this.Gbs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.jdc);
      if (this.Fvm != null)
      {
        paramVarArgs.lC(7, this.Fvm.computeSize());
        this.Fvm.writeFields(paramVarArgs);
      }
      if (this.jdd != null) {
        paramVarArgs.d(8, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(9, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(10, this.jdf);
      }
      paramVarArgs.aS(11, this.jdg);
      paramVarArgs.aS(12, this.GNU);
      if (this.GNV != null) {
        paramVarArgs.d(13, this.GNV);
      }
      if (this.GNW != null) {
        paramVarArgs.d(14, this.GNW);
      }
      if (this.jdh != null) {
        paramVarArgs.d(15, this.jdh);
      }
      if (this.GNX != null) {
        paramVarArgs.d(16, this.GNX);
      }
      paramVarArgs.aS(17, this.GNY);
      paramVarArgs.aS(18, this.jdj);
      paramVarArgs.aS(19, this.jdi);
      if (this.jdk != null) {
        paramVarArgs.d(20, this.jdk);
      }
      if (this.GOa != null)
      {
        paramVarArgs.lC(21, this.GOa.computeSize());
        this.GOa.writeFields(paramVarArgs);
      }
      if (this.jdl != null) {
        paramVarArgs.d(22, this.jdl);
      }
      if (this.jdm != null) {
        paramVarArgs.d(23, this.jdm);
      }
      if (this.GOb != null)
      {
        paramVarArgs.lC(24, this.GOb.computeSize());
        this.GOb.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(25, this.GwU);
      paramVarArgs.e(26, 8, this.GwV);
      if (this.FVo != null) {
        paramVarArgs.d(27, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(28, this.FVp);
      }
      if (this.Hpp != null)
      {
        paramVarArgs.lC(29, this.Hpp.computeSize());
        this.Hpp.writeFields(paramVarArgs);
      }
      if (this.Guj != null) {
        paramVarArgs.d(30, this.Guj);
      }
      if (this.Hpq != null) {
        paramVarArgs.d(31, this.Hpq);
      }
      paramVarArgs.aS(32, this.Hpn);
      if (this.Hpr != null) {
        paramVarArgs.d(33, this.Hpr);
      }
      paramVarArgs.aS(34, this.Hps);
      paramVarArgs.e(35, 8, this.Hpt);
      AppMethodBeat.o(152684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3462;
      }
    }
    label3462:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GbY != null) {
        paramInt = i + f.a.a.a.lB(2, this.GbY.computeSize());
      }
      i = paramInt;
      if (this.GKC != null) {
        i = paramInt + f.a.a.a.lB(3, this.GKC.computeSize());
      }
      paramInt = i;
      if (this.Gbr != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gbr.computeSize());
      }
      i = paramInt;
      if (this.Gbs != null) {
        i = paramInt + f.a.a.a.lB(5, this.Gbs.computeSize());
      }
      i += f.a.a.b.b.a.bz(6, this.jdc);
      paramInt = i;
      if (this.Fvm != null) {
        paramInt = i + f.a.a.a.lB(7, this.Fvm.computeSize());
      }
      i = paramInt;
      if (this.jdd != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.jdd);
      }
      paramInt = i;
      if (this.jde != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jde);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.jdf);
      }
      i = i + f.a.a.b.b.a.bz(11, this.jdg) + f.a.a.b.b.a.bz(12, this.GNU);
      paramInt = i;
      if (this.GNV != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GNV);
      }
      i = paramInt;
      if (this.GNW != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GNW);
      }
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.jdh);
      }
      i = paramInt;
      if (this.GNX != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.GNX);
      }
      i = i + f.a.a.b.b.a.bz(17, this.GNY) + f.a.a.b.b.a.bz(18, this.jdj) + f.a.a.b.b.a.bz(19, this.jdi);
      paramInt = i;
      if (this.jdk != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.jdk);
      }
      i = paramInt;
      if (this.GOa != null) {
        i = paramInt + f.a.a.a.lB(21, this.GOa.computeSize());
      }
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.jdl);
      }
      i = paramInt;
      if (this.jdm != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.jdm);
      }
      paramInt = i;
      if (this.GOb != null) {
        paramInt = i + f.a.a.a.lB(24, this.GOb.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(25, this.GwU) + f.a.a.a.c(26, 8, this.GwV);
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.FVp);
      }
      paramInt = i;
      if (this.Hpp != null) {
        paramInt = i + f.a.a.a.lB(29, this.Hpp.computeSize());
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.Guj);
      }
      paramInt = i;
      if (this.Hpq != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.Hpq);
      }
      i = paramInt + f.a.a.b.b.a.bz(32, this.Hpn);
      paramInt = i;
      if (this.Hpr != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.Hpr);
      }
      i = f.a.a.b.b.a.bz(34, this.Hps);
      int j = f.a.a.a.c(35, 8, this.Hpt);
      AppMethodBeat.o(152684);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GwV.clear();
        this.Hpt.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.GbY == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.GKC == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.Gbr == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.Gbs == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.Fvm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152684);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyc localcyc = (cyc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152684);
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
            localcyc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
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
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.GbY = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
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
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.GKC = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
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
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.Gbr = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.Gbs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 6: 
          localcyc.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152684);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.Fvm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 8: 
          localcyc.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 9: 
          localcyc.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 10: 
          localcyc.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 11: 
          localcyc.jdg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 12: 
          localcyc.GNU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 13: 
          localcyc.GNV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 14: 
          localcyc.GNW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 15: 
          localcyc.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 16: 
          localcyc.GNX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 17: 
          localcyc.GNY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 18: 
          localcyc.jdj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 19: 
          localcyc.jdi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 20: 
          localcyc.jdk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.GOa = ((dhg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 22: 
          localcyc.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 23: 
          localcyc.jdm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.GOb = ((acf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 25: 
          localcyc.GwU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cya();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cya)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.GwV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 27: 
          localcyc.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 28: 
          localcyc.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 29: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyc.Hpp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 30: 
          localcyc.Guj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 31: 
          localcyc.Hpq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 32: 
          localcyc.Hpn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 33: 
          localcyc.Hpr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 34: 
          localcyc.Hps = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152684);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cyp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cyp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyc.Hpt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152684);
        return 0;
      }
      AppMethodBeat.o(152684);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyc
 * JD-Core Version:    0.7.0.1
 */
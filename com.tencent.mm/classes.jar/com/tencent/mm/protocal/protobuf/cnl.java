package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnl
  extends cld
{
  public String CVv;
  public String CVw;
  public SKBuiltinBuffer_t CxB;
  public cmf DFJ;
  public int DIV;
  public String DIW;
  public String DIX;
  public String DIY;
  public int DIZ;
  public cwh DJb;
  public zh DJc;
  public cmf Dbb;
  public cmf Dbc;
  public cmf Dby;
  public String Dqd;
  public int DsM;
  public LinkedList<cnj> DsN;
  public int EhQ;
  public SKBuiltinBuffer_t EhS;
  public String EhT;
  public String EhU;
  public int EhV;
  public LinkedList<cny> EhW;
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
  
  public cnl()
  {
    AppMethodBeat.i(152683);
    this.DsN = new LinkedList();
    this.EhW = new LinkedList();
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
      if (this.Dby == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.DFJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.Dbb == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.Dbc == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Dby != null)
      {
        paramVarArgs.kX(2, this.Dby.computeSize());
        this.Dby.writeFields(paramVarArgs);
      }
      if (this.DFJ != null)
      {
        paramVarArgs.kX(3, this.DFJ.computeSize());
        this.DFJ.writeFields(paramVarArgs);
      }
      if (this.Dbb != null)
      {
        paramVarArgs.kX(4, this.Dbb.computeSize());
        this.Dbb.writeFields(paramVarArgs);
      }
      if (this.Dbc != null)
      {
        paramVarArgs.kX(5, this.Dbc.computeSize());
        this.Dbc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.ijM);
      if (this.CxB != null)
      {
        paramVarArgs.kX(7, this.CxB.computeSize());
        this.CxB.writeFields(paramVarArgs);
      }
      if (this.ijN != null) {
        paramVarArgs.d(8, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(9, this.ijO);
      }
      if (this.ijP != null) {
        paramVarArgs.d(10, this.ijP);
      }
      paramVarArgs.aR(11, this.ijQ);
      paramVarArgs.aR(12, this.DIV);
      if (this.DIW != null) {
        paramVarArgs.d(13, this.DIW);
      }
      if (this.DIX != null) {
        paramVarArgs.d(14, this.DIX);
      }
      if (this.ijR != null) {
        paramVarArgs.d(15, this.ijR);
      }
      if (this.DIY != null) {
        paramVarArgs.d(16, this.DIY);
      }
      paramVarArgs.aR(17, this.DIZ);
      paramVarArgs.aR(18, this.ijT);
      paramVarArgs.aR(19, this.ijS);
      if (this.ijU != null) {
        paramVarArgs.d(20, this.ijU);
      }
      if (this.DJb != null)
      {
        paramVarArgs.kX(21, this.DJb.computeSize());
        this.DJb.writeFields(paramVarArgs);
      }
      if (this.ijV != null) {
        paramVarArgs.d(22, this.ijV);
      }
      if (this.ijW != null) {
        paramVarArgs.d(23, this.ijW);
      }
      if (this.DJc != null)
      {
        paramVarArgs.kX(24, this.DJc.computeSize());
        this.DJc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(25, this.DsM);
      paramVarArgs.e(26, 8, this.DsN);
      if (this.CVv != null) {
        paramVarArgs.d(27, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(28, this.CVw);
      }
      if (this.EhS != null)
      {
        paramVarArgs.kX(29, this.EhS.computeSize());
        this.EhS.writeFields(paramVarArgs);
      }
      if (this.Dqd != null) {
        paramVarArgs.d(30, this.Dqd);
      }
      if (this.EhT != null) {
        paramVarArgs.d(31, this.EhT);
      }
      paramVarArgs.aR(32, this.EhQ);
      if (this.EhU != null) {
        paramVarArgs.d(33, this.EhU);
      }
      paramVarArgs.aR(34, this.EhV);
      paramVarArgs.e(35, 8, this.EhW);
      AppMethodBeat.o(152684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3462;
      }
    }
    label3462:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Dby != null) {
        paramInt = i + f.a.a.a.kW(2, this.Dby.computeSize());
      }
      i = paramInt;
      if (this.DFJ != null) {
        i = paramInt + f.a.a.a.kW(3, this.DFJ.computeSize());
      }
      paramInt = i;
      if (this.Dbb != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dbb.computeSize());
      }
      i = paramInt;
      if (this.Dbc != null) {
        i = paramInt + f.a.a.a.kW(5, this.Dbc.computeSize());
      }
      i += f.a.a.b.b.a.bA(6, this.ijM);
      paramInt = i;
      if (this.CxB != null) {
        paramInt = i + f.a.a.a.kW(7, this.CxB.computeSize());
      }
      i = paramInt;
      if (this.ijN != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.ijN);
      }
      paramInt = i;
      if (this.ijO != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ijO);
      }
      i = paramInt;
      if (this.ijP != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.ijP);
      }
      i = i + f.a.a.b.b.a.bA(11, this.ijQ) + f.a.a.b.b.a.bA(12, this.DIV);
      paramInt = i;
      if (this.DIW != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DIW);
      }
      i = paramInt;
      if (this.DIX != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DIX);
      }
      paramInt = i;
      if (this.ijR != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.ijR);
      }
      i = paramInt;
      if (this.DIY != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.DIY);
      }
      i = i + f.a.a.b.b.a.bA(17, this.DIZ) + f.a.a.b.b.a.bA(18, this.ijT) + f.a.a.b.b.a.bA(19, this.ijS);
      paramInt = i;
      if (this.ijU != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.ijU);
      }
      i = paramInt;
      if (this.DJb != null) {
        i = paramInt + f.a.a.a.kW(21, this.DJb.computeSize());
      }
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.ijV);
      }
      i = paramInt;
      if (this.ijW != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.ijW);
      }
      paramInt = i;
      if (this.DJc != null) {
        paramInt = i + f.a.a.a.kW(24, this.DJc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(25, this.DsM) + f.a.a.a.c(26, 8, this.DsN);
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.CVw);
      }
      paramInt = i;
      if (this.EhS != null) {
        paramInt = i + f.a.a.a.kW(29, this.EhS.computeSize());
      }
      i = paramInt;
      if (this.Dqd != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.Dqd);
      }
      paramInt = i;
      if (this.EhT != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.EhT);
      }
      i = paramInt + f.a.a.b.b.a.bA(32, this.EhQ);
      paramInt = i;
      if (this.EhU != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.EhU);
      }
      i = f.a.a.b.b.a.bA(34, this.EhV);
      int j = f.a.a.a.c(35, 8, this.EhW);
      AppMethodBeat.o(152684);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DsN.clear();
        this.EhW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.Dby == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.DFJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.Dbb == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.Dbc == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.CxB == null)
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
        cnl localcnl = (cnl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152684);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
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
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnl.Dby = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
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
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnl.DFJ = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
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
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnl.Dbb = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnl.Dbc = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 6: 
          localcnl.ijM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152684);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnl.CxB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 8: 
          localcnl.ijN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 9: 
          localcnl.ijO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 10: 
          localcnl.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 11: 
          localcnl.ijQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152684);
          return 0;
        case 12: 
          localcnl.DIV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152684);
          return 0;
        case 13: 
          localcnl.DIW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 14: 
          localcnl.DIX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 15: 
          localcnl.ijR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 16: 
          localcnl.DIY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 17: 
          localcnl.DIZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152684);
          return 0;
        case 18: 
          localcnl.ijT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152684);
          return 0;
        case 19: 
          localcnl.ijS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152684);
          return 0;
        case 20: 
          localcnl.ijU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnl.DJb = ((cwh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 22: 
          localcnl.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 23: 
          localcnl.ijW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnl.DJc = ((zh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 25: 
          localcnl.DsM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152684);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnl.DsN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 27: 
          localcnl.CVv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 28: 
          localcnl.CVw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 29: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnl.EhS = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 30: 
          localcnl.Dqd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 31: 
          localcnl.EhT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 32: 
          localcnl.EhQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152684);
          return 0;
        case 33: 
          localcnl.EhU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 34: 
          localcnl.EhV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152684);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cny();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cny)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcnl.EhW.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnl
 * JD-Core Version:    0.7.0.1
 */
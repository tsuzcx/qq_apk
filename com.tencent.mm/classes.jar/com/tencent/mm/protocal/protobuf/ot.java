package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ot
  extends cld
{
  public String CMC;
  public cth CMD;
  public String CME;
  public String CMF;
  public int CMG;
  public int CMH;
  public int CMI;
  public dcl CMJ;
  public String CMK;
  public int CML;
  public int CMM;
  public int CMN;
  public com.tencent.mm.bx.b CMO;
  public int CMP;
  public int CMQ;
  public int CMR;
  public om CMS;
  public dn CMT;
  public dm CMU;
  public vi CMV;
  public String CMo;
  public String CxW;
  public String CxX;
  public String CxY;
  public String dlJ;
  public int ntx;
  public String nty;
  public int vAW = 0;
  public String vAX;
  public String vAY;
  public String vAZ;
  public String vBa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91375);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91375);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      if (this.dlJ != null) {
        paramVarArgs.d(4, this.dlJ);
      }
      if (this.CMC != null) {
        paramVarArgs.d(5, this.CMC);
      }
      if (this.CMD != null)
      {
        paramVarArgs.kX(6, this.CMD.computeSize());
        this.CMD.writeFields(paramVarArgs);
      }
      if (this.CxW != null) {
        paramVarArgs.d(7, this.CxW);
      }
      if (this.CxY != null) {
        paramVarArgs.d(8, this.CxY);
      }
      if (this.CME != null) {
        paramVarArgs.d(9, this.CME);
      }
      if (this.CMF != null) {
        paramVarArgs.d(10, this.CMF);
      }
      paramVarArgs.aR(11, this.CMG);
      if (this.CxX != null) {
        paramVarArgs.d(12, this.CxX);
      }
      if (this.CMo != null) {
        paramVarArgs.d(13, this.CMo);
      }
      paramVarArgs.aR(14, this.CMH);
      paramVarArgs.aR(15, this.CMI);
      if (this.CMJ != null)
      {
        paramVarArgs.kX(16, this.CMJ.computeSize());
        this.CMJ.writeFields(paramVarArgs);
      }
      if (this.CMK != null) {
        paramVarArgs.d(17, this.CMK);
      }
      paramVarArgs.aR(18, this.CML);
      paramVarArgs.aR(19, this.CMM);
      paramVarArgs.aR(20, this.CMN);
      if (this.CMO != null) {
        paramVarArgs.c(21, this.CMO);
      }
      paramVarArgs.aR(22, this.CMP);
      paramVarArgs.aR(23, this.vAW);
      if (this.vAX != null) {
        paramVarArgs.d(24, this.vAX);
      }
      if (this.vAY != null) {
        paramVarArgs.d(25, this.vAY);
      }
      paramVarArgs.aR(26, this.CMQ);
      if (this.vAZ != null) {
        paramVarArgs.d(27, this.vAZ);
      }
      if (this.vBa != null) {
        paramVarArgs.d(28, this.vBa);
      }
      paramVarArgs.aR(29, this.CMR);
      if (this.CMS != null)
      {
        paramVarArgs.kX(30, this.CMS.computeSize());
        this.CMS.writeFields(paramVarArgs);
      }
      if (this.CMT != null)
      {
        paramVarArgs.kX(31, this.CMT.computeSize());
        this.CMT.writeFields(paramVarArgs);
      }
      if (this.CMU != null)
      {
        paramVarArgs.kX(32, this.CMU.computeSize());
        this.CMU.writeFields(paramVarArgs);
      }
      if (this.CMV != null)
      {
        paramVarArgs.kX(33, this.CMV.computeSize());
        this.CMV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91375);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2714;
      }
    }
    label2714:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.dlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.dlJ);
      }
      paramInt = i;
      if (this.CMC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CMC);
      }
      i = paramInt;
      if (this.CMD != null) {
        i = paramInt + f.a.a.a.kW(6, this.CMD.computeSize());
      }
      paramInt = i;
      if (this.CxW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CxW);
      }
      i = paramInt;
      if (this.CxY != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CxY);
      }
      paramInt = i;
      if (this.CME != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CME);
      }
      i = paramInt;
      if (this.CMF != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CMF);
      }
      i += f.a.a.b.b.a.bA(11, this.CMG);
      paramInt = i;
      if (this.CxX != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.CxX);
      }
      i = paramInt;
      if (this.CMo != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.CMo);
      }
      i = i + f.a.a.b.b.a.bA(14, this.CMH) + f.a.a.b.b.a.bA(15, this.CMI);
      paramInt = i;
      if (this.CMJ != null) {
        paramInt = i + f.a.a.a.kW(16, this.CMJ.computeSize());
      }
      i = paramInt;
      if (this.CMK != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.CMK);
      }
      i = i + f.a.a.b.b.a.bA(18, this.CML) + f.a.a.b.b.a.bA(19, this.CMM) + f.a.a.b.b.a.bA(20, this.CMN);
      paramInt = i;
      if (this.CMO != null) {
        paramInt = i + f.a.a.b.b.a.b(21, this.CMO);
      }
      i = paramInt + f.a.a.b.b.a.bA(22, this.CMP) + f.a.a.b.b.a.bA(23, this.vAW);
      paramInt = i;
      if (this.vAX != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.vAX);
      }
      i = paramInt;
      if (this.vAY != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.vAY);
      }
      i += f.a.a.b.b.a.bA(26, this.CMQ);
      paramInt = i;
      if (this.vAZ != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.vAZ);
      }
      i = paramInt;
      if (this.vBa != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.vBa);
      }
      i += f.a.a.b.b.a.bA(29, this.CMR);
      paramInt = i;
      if (this.CMS != null) {
        paramInt = i + f.a.a.a.kW(30, this.CMS.computeSize());
      }
      i = paramInt;
      if (this.CMT != null) {
        i = paramInt + f.a.a.a.kW(31, this.CMT.computeSize());
      }
      paramInt = i;
      if (this.CMU != null) {
        paramInt = i + f.a.a.a.kW(32, this.CMU.computeSize());
      }
      i = paramInt;
      if (this.CMV != null) {
        i = paramInt + f.a.a.a.kW(33, this.CMV.computeSize());
      }
      AppMethodBeat.o(91375);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91375);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ot localot = (ot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91375);
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
            localot.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 2: 
          localot.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 3: 
          localot.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 4: 
          localot.dlJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 5: 
          localot.CMC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cth();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cth)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localot.CMD = ((cth)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 7: 
          localot.CxW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 8: 
          localot.CxY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 9: 
          localot.CME = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 10: 
          localot.CMF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 11: 
          localot.CMG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 12: 
          localot.CxX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 13: 
          localot.CMo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 14: 
          localot.CMH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 15: 
          localot.CMI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localot.CMJ = ((dcl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 17: 
          localot.CMK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 18: 
          localot.CML = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 19: 
          localot.CMM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 20: 
          localot.CMN = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 21: 
          localot.CMO = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(91375);
          return 0;
        case 22: 
          localot.CMP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 23: 
          localot.vAW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 24: 
          localot.vAX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 25: 
          localot.vAY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 26: 
          localot.CMQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 27: 
          localot.vAZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 28: 
          localot.vBa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91375);
          return 0;
        case 29: 
          localot.CMR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91375);
          return 0;
        case 30: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new om();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((om)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localot.CMS = ((om)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localot.CMT = ((dn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        case 32: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localot.CMU = ((dm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91375);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new vi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((vi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localot.CMV = ((vi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91375);
        return 0;
      }
      AppMethodBeat.o(91375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ot
 * JD-Core Version:    0.7.0.1
 */
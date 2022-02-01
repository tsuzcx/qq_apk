package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ctp
  extends dpc
{
  public String KCy;
  public String KEa;
  public int KEd;
  public String KEg;
  public String KEh;
  public int KEi;
  public String KEj;
  public int KEl;
  public ffh KEm;
  public ffe KEn;
  public String KLg;
  public dyh KLj;
  public int KLo;
  public int KLp;
  public tc KQK;
  public tc KQL;
  public tc KQM;
  public ccb KQj;
  public qy KQk;
  public ctb KQl;
  public String MbJ;
  public SKBuiltinBuffer_t MbL;
  public String MyK;
  public int MyL;
  public String MyM;
  public int MyN;
  public dby MyO;
  public int MyP;
  public String MyQ;
  public String MyR;
  public dta MyS;
  public String UserName;
  public int oTW;
  public int rBx;
  public String rBz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133185);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133185);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.rBx);
      if (this.KCy != null) {
        paramVarArgs.e(3, this.KCy);
      }
      if (this.KEg != null) {
        paramVarArgs.e(4, this.KEg);
      }
      if (this.KEh != null) {
        paramVarArgs.e(5, this.KEh);
      }
      if (this.MyK != null) {
        paramVarArgs.e(6, this.MyK);
      }
      if (this.KEa != null) {
        paramVarArgs.e(7, this.KEa);
      }
      paramVarArgs.aM(8, this.KEi);
      paramVarArgs.aM(9, this.MyL);
      if (this.MyM != null) {
        paramVarArgs.e(10, this.MyM);
      }
      if (this.KQk != null)
      {
        paramVarArgs.ni(14, this.KQk.computeSize());
        this.KQk.writeFields(paramVarArgs);
      }
      if (this.KEj != null) {
        paramVarArgs.e(15, this.KEj);
      }
      if (this.UserName != null) {
        paramVarArgs.e(16, this.UserName);
      }
      paramVarArgs.aM(17, this.oTW);
      if (this.KQl != null)
      {
        paramVarArgs.ni(18, this.KQl.computeSize());
        this.KQl.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(19, this.MyN);
      paramVarArgs.aM(20, this.KEd);
      if (this.KLg != null) {
        paramVarArgs.e(21, this.KLg);
      }
      if (this.MyO != null)
      {
        paramVarArgs.ni(22, this.MyO.computeSize());
        this.MyO.writeFields(paramVarArgs);
      }
      if (this.rBz != null) {
        paramVarArgs.e(23, this.rBz);
      }
      paramVarArgs.aM(24, this.MyP);
      if (this.KQj != null)
      {
        paramVarArgs.ni(25, this.KQj.computeSize());
        this.KQj.writeFields(paramVarArgs);
      }
      if (this.MyQ != null) {
        paramVarArgs.e(26, this.MyQ);
      }
      if (this.KQK != null)
      {
        paramVarArgs.ni(27, this.KQK.computeSize());
        this.KQK.writeFields(paramVarArgs);
      }
      if (this.MyR != null) {
        paramVarArgs.e(28, this.MyR);
      }
      if (this.MbJ != null) {
        paramVarArgs.e(29, this.MbJ);
      }
      if (this.MbL != null)
      {
        paramVarArgs.ni(30, this.MbL.computeSize());
        this.MbL.writeFields(paramVarArgs);
      }
      if (this.KLj != null)
      {
        paramVarArgs.ni(31, this.KLj.computeSize());
        this.KLj.writeFields(paramVarArgs);
      }
      if (this.KQL != null)
      {
        paramVarArgs.ni(32, this.KQL.computeSize());
        this.KQL.writeFields(paramVarArgs);
      }
      if (this.KQM != null)
      {
        paramVarArgs.ni(33, this.KQM.computeSize());
        this.KQM.writeFields(paramVarArgs);
      }
      if (this.MyS != null)
      {
        paramVarArgs.ni(34, this.MyS.computeSize());
        this.MyS.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(35, this.KLo);
      paramVarArgs.aM(36, this.KLp);
      paramVarArgs.aM(37, this.KEl);
      if (this.KEm != null)
      {
        paramVarArgs.ni(38, this.KEm.computeSize());
        this.KEm.writeFields(paramVarArgs);
      }
      if (this.KEn != null)
      {
        paramVarArgs.ni(39, this.KEn.computeSize());
        this.KEn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3494;
      }
    }
    label3494:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.rBx);
      paramInt = i;
      if (this.KCy != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KCy);
      }
      i = paramInt;
      if (this.KEg != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.KEg);
      }
      paramInt = i;
      if (this.KEh != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KEh);
      }
      i = paramInt;
      if (this.MyK != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MyK);
      }
      paramInt = i;
      if (this.KEa != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KEa);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.KEi) + g.a.a.b.b.a.bu(9, this.MyL);
      paramInt = i;
      if (this.MyM != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MyM);
      }
      i = paramInt;
      if (this.KQk != null) {
        i = paramInt + g.a.a.a.nh(14, this.KQk.computeSize());
      }
      paramInt = i;
      if (this.KEj != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.KEj);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.UserName);
      }
      i += g.a.a.b.b.a.bu(17, this.oTW);
      paramInt = i;
      if (this.KQl != null) {
        paramInt = i + g.a.a.a.nh(18, this.KQl.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(19, this.MyN) + g.a.a.b.b.a.bu(20, this.KEd);
      paramInt = i;
      if (this.KLg != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.KLg);
      }
      i = paramInt;
      if (this.MyO != null) {
        i = paramInt + g.a.a.a.nh(22, this.MyO.computeSize());
      }
      paramInt = i;
      if (this.rBz != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.rBz);
      }
      i = paramInt + g.a.a.b.b.a.bu(24, this.MyP);
      paramInt = i;
      if (this.KQj != null) {
        paramInt = i + g.a.a.a.nh(25, this.KQj.computeSize());
      }
      i = paramInt;
      if (this.MyQ != null) {
        i = paramInt + g.a.a.b.b.a.f(26, this.MyQ);
      }
      paramInt = i;
      if (this.KQK != null) {
        paramInt = i + g.a.a.a.nh(27, this.KQK.computeSize());
      }
      i = paramInt;
      if (this.MyR != null) {
        i = paramInt + g.a.a.b.b.a.f(28, this.MyR);
      }
      paramInt = i;
      if (this.MbJ != null) {
        paramInt = i + g.a.a.b.b.a.f(29, this.MbJ);
      }
      i = paramInt;
      if (this.MbL != null) {
        i = paramInt + g.a.a.a.nh(30, this.MbL.computeSize());
      }
      paramInt = i;
      if (this.KLj != null) {
        paramInt = i + g.a.a.a.nh(31, this.KLj.computeSize());
      }
      i = paramInt;
      if (this.KQL != null) {
        i = paramInt + g.a.a.a.nh(32, this.KQL.computeSize());
      }
      paramInt = i;
      if (this.KQM != null) {
        paramInt = i + g.a.a.a.nh(33, this.KQM.computeSize());
      }
      i = paramInt;
      if (this.MyS != null) {
        i = paramInt + g.a.a.a.nh(34, this.MyS.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(35, this.KLo) + g.a.a.b.b.a.bu(36, this.KLp) + g.a.a.b.b.a.bu(37, this.KEl);
      paramInt = i;
      if (this.KEm != null) {
        paramInt = i + g.a.a.a.nh(38, this.KEm.computeSize());
      }
      i = paramInt;
      if (this.KEn != null) {
        i = paramInt + g.a.a.a.nh(39, this.KEn.computeSize());
      }
      AppMethodBeat.o(133185);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133185);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133185);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ctp localctp = (ctp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(133185);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 2: 
          localctp.rBx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133185);
          return 0;
        case 3: 
          localctp.KCy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 4: 
          localctp.KEg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 5: 
          localctp.KEh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 6: 
          localctp.MyK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 7: 
          localctp.KEa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 8: 
          localctp.KEi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133185);
          return 0;
        case 9: 
          localctp.MyL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133185);
          return 0;
        case 10: 
          localctp.MyM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.KQk = ((qy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 15: 
          localctp.KEj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 16: 
          localctp.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 17: 
          localctp.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133185);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.KQl = ((ctb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 19: 
          localctp.MyN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133185);
          return 0;
        case 20: 
          localctp.KEd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133185);
          return 0;
        case 21: 
          localctp.KLg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dby();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dby)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.MyO = ((dby)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 23: 
          localctp.rBz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 24: 
          localctp.MyP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133185);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.KQj = ((ccb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 26: 
          localctp.MyQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 27: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.KQK = ((tc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 28: 
          localctp.MyR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 29: 
          localctp.MbJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 30: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.MbL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 31: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.KLj = ((dyh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 32: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.KQL = ((tc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 33: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.KQM = ((tc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 34: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dta();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dta)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.MyS = ((dta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 35: 
          localctp.KLo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133185);
          return 0;
        case 36: 
          localctp.KLp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133185);
          return 0;
        case 37: 
          localctp.KEl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133185);
          return 0;
        case 38: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ffh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ffh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localctp.KEm = ((ffh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ffe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ffe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localctp.KEn = ((ffe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133185);
        return 0;
      }
      AppMethodBeat.o(133185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctp
 * JD-Core Version:    0.7.0.1
 */
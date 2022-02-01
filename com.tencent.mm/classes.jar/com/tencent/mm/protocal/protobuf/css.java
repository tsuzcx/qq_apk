package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class css
  extends cqk
{
  public SKBuiltinBuffer_t DPX;
  public String ELg;
  public int ENQ;
  public LinkedList<csq> ENR;
  public String Eof;
  public String Eog;
  public crm EtY;
  public crm EtZ;
  public crm EuE;
  public int FEO;
  public SKBuiltinBuffer_t FEQ;
  public String FER;
  public String FES;
  public int FET;
  public LinkedList<ctf> FEU;
  public crm Fbd;
  public int Feq;
  public String Fer;
  public String Fes;
  public String Fet;
  public int Feu;
  public dbt Few;
  public aaf Fex;
  public int iJT;
  public String iJU;
  public String iJV;
  public String iJW;
  public int iJX;
  public String iJY;
  public int iJZ;
  public int iKa;
  public String iKb;
  public String iKc;
  public String iKd;
  
  public css()
  {
    AppMethodBeat.i(152683);
    this.ENR = new LinkedList();
    this.FEU = new LinkedList();
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
      if (this.EuE == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.Fbd == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.EtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.EtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.DPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EuE != null)
      {
        paramVarArgs.ln(2, this.EuE.computeSize());
        this.EuE.writeFields(paramVarArgs);
      }
      if (this.Fbd != null)
      {
        paramVarArgs.ln(3, this.Fbd.computeSize());
        this.Fbd.writeFields(paramVarArgs);
      }
      if (this.EtY != null)
      {
        paramVarArgs.ln(4, this.EtY.computeSize());
        this.EtY.writeFields(paramVarArgs);
      }
      if (this.EtZ != null)
      {
        paramVarArgs.ln(5, this.EtZ.computeSize());
        this.EtZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.iJT);
      if (this.DPX != null)
      {
        paramVarArgs.ln(7, this.DPX.computeSize());
        this.DPX.writeFields(paramVarArgs);
      }
      if (this.iJU != null) {
        paramVarArgs.d(8, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(9, this.iJV);
      }
      if (this.iJW != null) {
        paramVarArgs.d(10, this.iJW);
      }
      paramVarArgs.aR(11, this.iJX);
      paramVarArgs.aR(12, this.Feq);
      if (this.Fer != null) {
        paramVarArgs.d(13, this.Fer);
      }
      if (this.Fes != null) {
        paramVarArgs.d(14, this.Fes);
      }
      if (this.iJY != null) {
        paramVarArgs.d(15, this.iJY);
      }
      if (this.Fet != null) {
        paramVarArgs.d(16, this.Fet);
      }
      paramVarArgs.aR(17, this.Feu);
      paramVarArgs.aR(18, this.iKa);
      paramVarArgs.aR(19, this.iJZ);
      if (this.iKb != null) {
        paramVarArgs.d(20, this.iKb);
      }
      if (this.Few != null)
      {
        paramVarArgs.ln(21, this.Few.computeSize());
        this.Few.writeFields(paramVarArgs);
      }
      if (this.iKc != null) {
        paramVarArgs.d(22, this.iKc);
      }
      if (this.iKd != null) {
        paramVarArgs.d(23, this.iKd);
      }
      if (this.Fex != null)
      {
        paramVarArgs.ln(24, this.Fex.computeSize());
        this.Fex.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(25, this.ENQ);
      paramVarArgs.e(26, 8, this.ENR);
      if (this.Eof != null) {
        paramVarArgs.d(27, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(28, this.Eog);
      }
      if (this.FEQ != null)
      {
        paramVarArgs.ln(29, this.FEQ.computeSize());
        this.FEQ.writeFields(paramVarArgs);
      }
      if (this.ELg != null) {
        paramVarArgs.d(30, this.ELg);
      }
      if (this.FER != null) {
        paramVarArgs.d(31, this.FER);
      }
      paramVarArgs.aR(32, this.FEO);
      if (this.FES != null) {
        paramVarArgs.d(33, this.FES);
      }
      paramVarArgs.aR(34, this.FET);
      paramVarArgs.e(35, 8, this.FEU);
      AppMethodBeat.o(152684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3462;
      }
    }
    label3462:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EuE != null) {
        paramInt = i + f.a.a.a.lm(2, this.EuE.computeSize());
      }
      i = paramInt;
      if (this.Fbd != null) {
        i = paramInt + f.a.a.a.lm(3, this.Fbd.computeSize());
      }
      paramInt = i;
      if (this.EtY != null) {
        paramInt = i + f.a.a.a.lm(4, this.EtY.computeSize());
      }
      i = paramInt;
      if (this.EtZ != null) {
        i = paramInt + f.a.a.a.lm(5, this.EtZ.computeSize());
      }
      i += f.a.a.b.b.a.bx(6, this.iJT);
      paramInt = i;
      if (this.DPX != null) {
        paramInt = i + f.a.a.a.lm(7, this.DPX.computeSize());
      }
      i = paramInt;
      if (this.iJU != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.iJU);
      }
      paramInt = i;
      if (this.iJV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iJV);
      }
      i = paramInt;
      if (this.iJW != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.iJW);
      }
      i = i + f.a.a.b.b.a.bx(11, this.iJX) + f.a.a.b.b.a.bx(12, this.Feq);
      paramInt = i;
      if (this.Fer != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Fer);
      }
      i = paramInt;
      if (this.Fes != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Fes);
      }
      paramInt = i;
      if (this.iJY != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.iJY);
      }
      i = paramInt;
      if (this.Fet != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.Fet);
      }
      i = i + f.a.a.b.b.a.bx(17, this.Feu) + f.a.a.b.b.a.bx(18, this.iKa) + f.a.a.b.b.a.bx(19, this.iJZ);
      paramInt = i;
      if (this.iKb != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.iKb);
      }
      i = paramInt;
      if (this.Few != null) {
        i = paramInt + f.a.a.a.lm(21, this.Few.computeSize());
      }
      paramInt = i;
      if (this.iKc != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.iKc);
      }
      i = paramInt;
      if (this.iKd != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.iKd);
      }
      paramInt = i;
      if (this.Fex != null) {
        paramInt = i + f.a.a.a.lm(24, this.Fex.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(25, this.ENQ) + f.a.a.a.c(26, 8, this.ENR);
      paramInt = i;
      if (this.Eof != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.Eof);
      }
      i = paramInt;
      if (this.Eog != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.Eog);
      }
      paramInt = i;
      if (this.FEQ != null) {
        paramInt = i + f.a.a.a.lm(29, this.FEQ.computeSize());
      }
      i = paramInt;
      if (this.ELg != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.ELg);
      }
      paramInt = i;
      if (this.FER != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.FER);
      }
      i = paramInt + f.a.a.b.b.a.bx(32, this.FEO);
      paramInt = i;
      if (this.FES != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.FES);
      }
      i = f.a.a.b.b.a.bx(34, this.FET);
      int j = f.a.a.a.c(35, 8, this.FEU);
      AppMethodBeat.o(152684);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ENR.clear();
        this.FEU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.EuE == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.Fbd == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.EtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.EtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.DPX == null)
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
        css localcss = (css)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152684);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcss.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcss.EuE = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcss.Fbd = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcss.EtY = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcss.EtZ = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 6: 
          localcss.iJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152684);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcss.DPX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 8: 
          localcss.iJU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 9: 
          localcss.iJV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 10: 
          localcss.iJW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 11: 
          localcss.iJX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152684);
          return 0;
        case 12: 
          localcss.Feq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152684);
          return 0;
        case 13: 
          localcss.Fer = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 14: 
          localcss.Fes = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 15: 
          localcss.iJY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 16: 
          localcss.Fet = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 17: 
          localcss.Feu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152684);
          return 0;
        case 18: 
          localcss.iKa = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152684);
          return 0;
        case 19: 
          localcss.iJZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152684);
          return 0;
        case 20: 
          localcss.iKb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcss.Few = ((dbt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 22: 
          localcss.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 23: 
          localcss.iKd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcss.Fex = ((aaf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 25: 
          localcss.ENQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152684);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcss.ENR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 27: 
          localcss.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 28: 
          localcss.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 29: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcss.FEQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 30: 
          localcss.ELg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 31: 
          localcss.FER = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 32: 
          localcss.FEO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152684);
          return 0;
        case 33: 
          localcss.FES = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 34: 
          localcss.FET = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152684);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ctf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ctf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcss.FEU.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.css
 * JD-Core Version:    0.7.0.1
 */
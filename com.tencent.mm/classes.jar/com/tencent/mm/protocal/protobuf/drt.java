package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class drt
  extends dpc
{
  public SKBuiltinBuffer_t KHp;
  public String LRO;
  public int LUB;
  public LinkedList<drr> LUC;
  public String Lir;
  public String Lis;
  public dqi LpA;
  public dqi LpB;
  public dqi Lqk;
  public int MUk;
  public SKBuiltinBuffer_t MUm;
  public String MUn;
  public String MUo;
  public int MUp;
  public LinkedList<dsk> MUq;
  public dqi Mjj;
  public int MmK;
  public String MmL;
  public String MmM;
  public String MmN;
  public int MmO;
  public ebj MmQ;
  public aeq MmR;
  public int kdY;
  public String kdZ;
  public String kea;
  public String keb;
  public int kec;
  public String ked;
  public int kee;
  public int kef;
  public String keg;
  public String keh;
  public String kei;
  
  public drt()
  {
    AppMethodBeat.i(152683);
    this.LUC = new LinkedList();
    this.MUq = new LinkedList();
    AppMethodBeat.o(152683);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152684);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.Lqk == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.Mjj == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.LpA == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.LpB == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.KHp == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Lqk != null)
      {
        paramVarArgs.ni(2, this.Lqk.computeSize());
        this.Lqk.writeFields(paramVarArgs);
      }
      if (this.Mjj != null)
      {
        paramVarArgs.ni(3, this.Mjj.computeSize());
        this.Mjj.writeFields(paramVarArgs);
      }
      if (this.LpA != null)
      {
        paramVarArgs.ni(4, this.LpA.computeSize());
        this.LpA.writeFields(paramVarArgs);
      }
      if (this.LpB != null)
      {
        paramVarArgs.ni(5, this.LpB.computeSize());
        this.LpB.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.kdY);
      if (this.KHp != null)
      {
        paramVarArgs.ni(7, this.KHp.computeSize());
        this.KHp.writeFields(paramVarArgs);
      }
      if (this.kdZ != null) {
        paramVarArgs.e(8, this.kdZ);
      }
      if (this.kea != null) {
        paramVarArgs.e(9, this.kea);
      }
      if (this.keb != null) {
        paramVarArgs.e(10, this.keb);
      }
      paramVarArgs.aM(11, this.kec);
      paramVarArgs.aM(12, this.MmK);
      if (this.MmL != null) {
        paramVarArgs.e(13, this.MmL);
      }
      if (this.MmM != null) {
        paramVarArgs.e(14, this.MmM);
      }
      if (this.ked != null) {
        paramVarArgs.e(15, this.ked);
      }
      if (this.MmN != null) {
        paramVarArgs.e(16, this.MmN);
      }
      paramVarArgs.aM(17, this.MmO);
      paramVarArgs.aM(18, this.kef);
      paramVarArgs.aM(19, this.kee);
      if (this.keg != null) {
        paramVarArgs.e(20, this.keg);
      }
      if (this.MmQ != null)
      {
        paramVarArgs.ni(21, this.MmQ.computeSize());
        this.MmQ.writeFields(paramVarArgs);
      }
      if (this.keh != null) {
        paramVarArgs.e(22, this.keh);
      }
      if (this.kei != null) {
        paramVarArgs.e(23, this.kei);
      }
      if (this.MmR != null)
      {
        paramVarArgs.ni(24, this.MmR.computeSize());
        this.MmR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(25, this.LUB);
      paramVarArgs.e(26, 8, this.LUC);
      if (this.Lir != null) {
        paramVarArgs.e(27, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(28, this.Lis);
      }
      if (this.MUm != null)
      {
        paramVarArgs.ni(29, this.MUm.computeSize());
        this.MUm.writeFields(paramVarArgs);
      }
      if (this.LRO != null) {
        paramVarArgs.e(30, this.LRO);
      }
      if (this.MUn != null) {
        paramVarArgs.e(31, this.MUn);
      }
      paramVarArgs.aM(32, this.MUk);
      if (this.MUo != null) {
        paramVarArgs.e(33, this.MUo);
      }
      paramVarArgs.aM(34, this.MUp);
      paramVarArgs.e(35, 8, this.MUq);
      AppMethodBeat.o(152684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3462;
      }
    }
    label3462:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lqk != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lqk.computeSize());
      }
      i = paramInt;
      if (this.Mjj != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mjj.computeSize());
      }
      paramInt = i;
      if (this.LpA != null) {
        paramInt = i + g.a.a.a.nh(4, this.LpA.computeSize());
      }
      i = paramInt;
      if (this.LpB != null) {
        i = paramInt + g.a.a.a.nh(5, this.LpB.computeSize());
      }
      i += g.a.a.b.b.a.bu(6, this.kdY);
      paramInt = i;
      if (this.KHp != null) {
        paramInt = i + g.a.a.a.nh(7, this.KHp.computeSize());
      }
      i = paramInt;
      if (this.kdZ != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.kdZ);
      }
      paramInt = i;
      if (this.kea != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.kea);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.keb);
      }
      i = i + g.a.a.b.b.a.bu(11, this.kec) + g.a.a.b.b.a.bu(12, this.MmK);
      paramInt = i;
      if (this.MmL != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.MmL);
      }
      i = paramInt;
      if (this.MmM != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.MmM);
      }
      paramInt = i;
      if (this.ked != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.ked);
      }
      i = paramInt;
      if (this.MmN != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.MmN);
      }
      i = i + g.a.a.b.b.a.bu(17, this.MmO) + g.a.a.b.b.a.bu(18, this.kef) + g.a.a.b.b.a.bu(19, this.kee);
      paramInt = i;
      if (this.keg != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.keg);
      }
      i = paramInt;
      if (this.MmQ != null) {
        i = paramInt + g.a.a.a.nh(21, this.MmQ.computeSize());
      }
      paramInt = i;
      if (this.keh != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.keh);
      }
      i = paramInt;
      if (this.kei != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.kei);
      }
      paramInt = i;
      if (this.MmR != null) {
        paramInt = i + g.a.a.a.nh(24, this.MmR.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(25, this.LUB) + g.a.a.a.c(26, 8, this.LUC);
      paramInt = i;
      if (this.Lir != null) {
        paramInt = i + g.a.a.b.b.a.f(27, this.Lir);
      }
      i = paramInt;
      if (this.Lis != null) {
        i = paramInt + g.a.a.b.b.a.f(28, this.Lis);
      }
      paramInt = i;
      if (this.MUm != null) {
        paramInt = i + g.a.a.a.nh(29, this.MUm.computeSize());
      }
      i = paramInt;
      if (this.LRO != null) {
        i = paramInt + g.a.a.b.b.a.f(30, this.LRO);
      }
      paramInt = i;
      if (this.MUn != null) {
        paramInt = i + g.a.a.b.b.a.f(31, this.MUn);
      }
      i = paramInt + g.a.a.b.b.a.bu(32, this.MUk);
      paramInt = i;
      if (this.MUo != null) {
        paramInt = i + g.a.a.b.b.a.f(33, this.MUo);
      }
      i = g.a.a.b.b.a.bu(34, this.MUp);
      int j = g.a.a.a.c(35, 8, this.MUq);
      AppMethodBeat.o(152684);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LUC.clear();
        this.MUq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.Lqk == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.Mjj == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.LpA == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.LpB == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.KHp == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        drt localdrt = (drt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152684);
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
            localdrt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrt.Lqk = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrt.Mjj = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrt.LpA = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrt.LpB = ((dqi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 6: 
          localdrt.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152684);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrt.KHp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 8: 
          localdrt.kdZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 9: 
          localdrt.kea = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 10: 
          localdrt.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 11: 
          localdrt.kec = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152684);
          return 0;
        case 12: 
          localdrt.MmK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152684);
          return 0;
        case 13: 
          localdrt.MmL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 14: 
          localdrt.MmM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 15: 
          localdrt.ked = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 16: 
          localdrt.MmN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 17: 
          localdrt.MmO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152684);
          return 0;
        case 18: 
          localdrt.kef = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152684);
          return 0;
        case 19: 
          localdrt.kee = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152684);
          return 0;
        case 20: 
          localdrt.keg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrt.MmQ = ((ebj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 22: 
          localdrt.keh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 23: 
          localdrt.kei = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeq();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrt.MmR = ((aeq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 25: 
          localdrt.LUB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152684);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new drr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((drr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrt.LUC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 27: 
          localdrt.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 28: 
          localdrt.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 29: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdrt.MUm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 30: 
          localdrt.LRO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 31: 
          localdrt.MUn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 32: 
          localdrt.MUk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152684);
          return 0;
        case 33: 
          localdrt.MUo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 34: 
          localdrt.MUp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152684);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dsk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dsk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdrt.MUq.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drt
 * JD-Core Version:    0.7.0.1
 */
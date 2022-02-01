package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyw
  extends cwj
{
  public SKBuiltinBuffer_t FNK;
  public String GNI;
  public int GQu;
  public LinkedList<cyu> GQv;
  public String GnN;
  public String GnO;
  public cxn GtY;
  public cxn GtZ;
  public cxn GuF;
  public int HIP;
  public SKBuiltinBuffer_t HIR;
  public String HIS;
  public String HIT;
  public int HIU;
  public LinkedList<czj> HIV;
  public cxn Hed;
  public dia HhA;
  public aco HhB;
  public int Hhu;
  public String Hhv;
  public String Hhw;
  public String Hhx;
  public int Hhy;
  public int jfV;
  public String jfW;
  public String jfX;
  public String jfY;
  public int jfZ;
  public String jga;
  public int jgb;
  public int jgc;
  public String jgd;
  public String jge;
  public String jgf;
  
  public cyw()
  {
    AppMethodBeat.i(152683);
    this.GQv = new LinkedList();
    this.HIV = new LinkedList();
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
      if (this.GuF == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.Hed == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.GtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.GtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.FNK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152684);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GuF != null)
      {
        paramVarArgs.lJ(2, this.GuF.computeSize());
        this.GuF.writeFields(paramVarArgs);
      }
      if (this.Hed != null)
      {
        paramVarArgs.lJ(3, this.Hed.computeSize());
        this.Hed.writeFields(paramVarArgs);
      }
      if (this.GtY != null)
      {
        paramVarArgs.lJ(4, this.GtY.computeSize());
        this.GtY.writeFields(paramVarArgs);
      }
      if (this.GtZ != null)
      {
        paramVarArgs.lJ(5, this.GtZ.computeSize());
        this.GtZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.jfV);
      if (this.FNK != null)
      {
        paramVarArgs.lJ(7, this.FNK.computeSize());
        this.FNK.writeFields(paramVarArgs);
      }
      if (this.jfW != null) {
        paramVarArgs.d(8, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(9, this.jfX);
      }
      if (this.jfY != null) {
        paramVarArgs.d(10, this.jfY);
      }
      paramVarArgs.aS(11, this.jfZ);
      paramVarArgs.aS(12, this.Hhu);
      if (this.Hhv != null) {
        paramVarArgs.d(13, this.Hhv);
      }
      if (this.Hhw != null) {
        paramVarArgs.d(14, this.Hhw);
      }
      if (this.jga != null) {
        paramVarArgs.d(15, this.jga);
      }
      if (this.Hhx != null) {
        paramVarArgs.d(16, this.Hhx);
      }
      paramVarArgs.aS(17, this.Hhy);
      paramVarArgs.aS(18, this.jgc);
      paramVarArgs.aS(19, this.jgb);
      if (this.jgd != null) {
        paramVarArgs.d(20, this.jgd);
      }
      if (this.HhA != null)
      {
        paramVarArgs.lJ(21, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      if (this.jge != null) {
        paramVarArgs.d(22, this.jge);
      }
      if (this.jgf != null) {
        paramVarArgs.d(23, this.jgf);
      }
      if (this.HhB != null)
      {
        paramVarArgs.lJ(24, this.HhB.computeSize());
        this.HhB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(25, this.GQu);
      paramVarArgs.e(26, 8, this.GQv);
      if (this.GnN != null) {
        paramVarArgs.d(27, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(28, this.GnO);
      }
      if (this.HIR != null)
      {
        paramVarArgs.lJ(29, this.HIR.computeSize());
        this.HIR.writeFields(paramVarArgs);
      }
      if (this.GNI != null) {
        paramVarArgs.d(30, this.GNI);
      }
      if (this.HIS != null) {
        paramVarArgs.d(31, this.HIS);
      }
      paramVarArgs.aS(32, this.HIP);
      if (this.HIT != null) {
        paramVarArgs.d(33, this.HIT);
      }
      paramVarArgs.aS(34, this.HIU);
      paramVarArgs.e(35, 8, this.HIV);
      AppMethodBeat.o(152684);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3462;
      }
    }
    label3462:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GuF != null) {
        paramInt = i + f.a.a.a.lI(2, this.GuF.computeSize());
      }
      i = paramInt;
      if (this.Hed != null) {
        i = paramInt + f.a.a.a.lI(3, this.Hed.computeSize());
      }
      paramInt = i;
      if (this.GtY != null) {
        paramInt = i + f.a.a.a.lI(4, this.GtY.computeSize());
      }
      i = paramInt;
      if (this.GtZ != null) {
        i = paramInt + f.a.a.a.lI(5, this.GtZ.computeSize());
      }
      i += f.a.a.b.b.a.bz(6, this.jfV);
      paramInt = i;
      if (this.FNK != null) {
        paramInt = i + f.a.a.a.lI(7, this.FNK.computeSize());
      }
      i = paramInt;
      if (this.jfW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.jfW);
      }
      paramInt = i;
      if (this.jfX != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jfX);
      }
      i = paramInt;
      if (this.jfY != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.jfY);
      }
      i = i + f.a.a.b.b.a.bz(11, this.jfZ) + f.a.a.b.b.a.bz(12, this.Hhu);
      paramInt = i;
      if (this.Hhv != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Hhv);
      }
      i = paramInt;
      if (this.Hhw != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.Hhw);
      }
      paramInt = i;
      if (this.jga != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.jga);
      }
      i = paramInt;
      if (this.Hhx != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.Hhx);
      }
      i = i + f.a.a.b.b.a.bz(17, this.Hhy) + f.a.a.b.b.a.bz(18, this.jgc) + f.a.a.b.b.a.bz(19, this.jgb);
      paramInt = i;
      if (this.jgd != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.jgd);
      }
      i = paramInt;
      if (this.HhA != null) {
        i = paramInt + f.a.a.a.lI(21, this.HhA.computeSize());
      }
      paramInt = i;
      if (this.jge != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.jge);
      }
      i = paramInt;
      if (this.jgf != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.jgf);
      }
      paramInt = i;
      if (this.HhB != null) {
        paramInt = i + f.a.a.a.lI(24, this.HhB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(25, this.GQu) + f.a.a.a.c(26, 8, this.GQv);
      paramInt = i;
      if (this.GnN != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.GnN);
      }
      i = paramInt;
      if (this.GnO != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.GnO);
      }
      paramInt = i;
      if (this.HIR != null) {
        paramInt = i + f.a.a.a.lI(29, this.HIR.computeSize());
      }
      i = paramInt;
      if (this.GNI != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.GNI);
      }
      paramInt = i;
      if (this.HIS != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.HIS);
      }
      i = paramInt + f.a.a.b.b.a.bz(32, this.HIP);
      paramInt = i;
      if (this.HIT != null) {
        paramInt = i + f.a.a.b.b.a.e(33, this.HIT);
      }
      i = f.a.a.b.b.a.bz(34, this.HIU);
      int j = f.a.a.a.c(35, 8, this.HIV);
      AppMethodBeat.o(152684);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GQv.clear();
        this.HIV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.GuF == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.Hed == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.GtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.GtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152684);
          throw paramVarArgs;
        }
        if (this.FNK == null)
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
        cyw localcyw = (cyw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152684);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyw.GuF = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyw.Hed = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyw.GtY = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyw.GtZ = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 6: 
          localcyw.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyw.FNK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 8: 
          localcyw.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 9: 
          localcyw.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 10: 
          localcyw.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 11: 
          localcyw.jfZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 12: 
          localcyw.Hhu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 13: 
          localcyw.Hhv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 14: 
          localcyw.Hhw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 15: 
          localcyw.jga = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 16: 
          localcyw.Hhx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 17: 
          localcyw.Hhy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 18: 
          localcyw.jgc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 19: 
          localcyw.jgb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 20: 
          localcyw.jgd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyw.HhA = ((dia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 22: 
          localcyw.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 23: 
          localcyw.jgf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aco();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyw.HhB = ((aco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 25: 
          localcyw.GQu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyw.GQv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 27: 
          localcyw.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 28: 
          localcyw.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 29: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyw.HIR = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152684);
          return 0;
        case 30: 
          localcyw.GNI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 31: 
          localcyw.HIS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 32: 
          localcyw.HIP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152684);
          return 0;
        case 33: 
          localcyw.HIT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152684);
          return 0;
        case 34: 
          localcyw.HIU = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152684);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new czj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((czj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcyw.HIV.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyw
 * JD-Core Version:    0.7.0.1
 */
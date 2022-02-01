package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyu
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t FNK;
  public String GNI;
  public String GnN;
  public String GnO;
  public cxn GtY;
  public cxn GtZ;
  public cxn GuF;
  public int HIP;
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152681);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuF == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.Hed == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.GtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.GtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.FNK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.GuF != null)
      {
        paramVarArgs.lJ(1, this.GuF.computeSize());
        this.GuF.writeFields(paramVarArgs);
      }
      if (this.Hed != null)
      {
        paramVarArgs.lJ(2, this.Hed.computeSize());
        this.Hed.writeFields(paramVarArgs);
      }
      if (this.GtY != null)
      {
        paramVarArgs.lJ(3, this.GtY.computeSize());
        this.GtY.writeFields(paramVarArgs);
      }
      if (this.GtZ != null)
      {
        paramVarArgs.lJ(4, this.GtZ.computeSize());
        this.GtZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.jfV);
      if (this.FNK != null)
      {
        paramVarArgs.lJ(6, this.FNK.computeSize());
        this.FNK.writeFields(paramVarArgs);
      }
      if (this.jfW != null) {
        paramVarArgs.d(7, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(8, this.jfX);
      }
      if (this.jfY != null) {
        paramVarArgs.d(9, this.jfY);
      }
      paramVarArgs.aS(10, this.jfZ);
      paramVarArgs.aS(11, this.Hhu);
      if (this.Hhv != null) {
        paramVarArgs.d(12, this.Hhv);
      }
      if (this.Hhw != null) {
        paramVarArgs.d(13, this.Hhw);
      }
      if (this.jga != null) {
        paramVarArgs.d(14, this.jga);
      }
      if (this.Hhx != null) {
        paramVarArgs.d(15, this.Hhx);
      }
      paramVarArgs.aS(16, this.Hhy);
      paramVarArgs.aS(17, this.jgc);
      paramVarArgs.aS(18, this.jgb);
      if (this.jgd != null) {
        paramVarArgs.d(19, this.jgd);
      }
      if (this.HhA != null)
      {
        paramVarArgs.lJ(20, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      if (this.jge != null) {
        paramVarArgs.d(21, this.jge);
      }
      if (this.jgf != null) {
        paramVarArgs.d(22, this.jgf);
      }
      if (this.HhB != null)
      {
        paramVarArgs.lJ(23, this.HhB.computeSize());
        this.HhB.writeFields(paramVarArgs);
      }
      if (this.GnN != null) {
        paramVarArgs.d(24, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(25, this.GnO);
      }
      if (this.GNI != null) {
        paramVarArgs.d(26, this.GNI);
      }
      paramVarArgs.aS(27, this.HIP);
      AppMethodBeat.o(152681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GuF == null) {
        break label2602;
      }
    }
    label2602:
    for (int i = f.a.a.a.lI(1, this.GuF.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hed != null) {
        paramInt = i + f.a.a.a.lI(2, this.Hed.computeSize());
      }
      i = paramInt;
      if (this.GtY != null) {
        i = paramInt + f.a.a.a.lI(3, this.GtY.computeSize());
      }
      paramInt = i;
      if (this.GtZ != null) {
        paramInt = i + f.a.a.a.lI(4, this.GtZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jfV);
      paramInt = i;
      if (this.FNK != null) {
        paramInt = i + f.a.a.a.lI(6, this.FNK.computeSize());
      }
      i = paramInt;
      if (this.jfW != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.jfW);
      }
      paramInt = i;
      if (this.jfX != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.jfX);
      }
      i = paramInt;
      if (this.jfY != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.jfY);
      }
      i = i + f.a.a.b.b.a.bz(10, this.jfZ) + f.a.a.b.b.a.bz(11, this.Hhu);
      paramInt = i;
      if (this.Hhv != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Hhv);
      }
      i = paramInt;
      if (this.Hhw != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Hhw);
      }
      paramInt = i;
      if (this.jga != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.jga);
      }
      i = paramInt;
      if (this.Hhx != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Hhx);
      }
      i = i + f.a.a.b.b.a.bz(16, this.Hhy) + f.a.a.b.b.a.bz(17, this.jgc) + f.a.a.b.b.a.bz(18, this.jgb);
      paramInt = i;
      if (this.jgd != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.jgd);
      }
      i = paramInt;
      if (this.HhA != null) {
        i = paramInt + f.a.a.a.lI(20, this.HhA.computeSize());
      }
      paramInt = i;
      if (this.jge != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.jge);
      }
      i = paramInt;
      if (this.jgf != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.jgf);
      }
      paramInt = i;
      if (this.HhB != null) {
        paramInt = i + f.a.a.a.lI(23, this.HhB.computeSize());
      }
      i = paramInt;
      if (this.GnN != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.GnN);
      }
      paramInt = i;
      if (this.GnO != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.GnO);
      }
      i = paramInt;
      if (this.GNI != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.GNI);
      }
      paramInt = f.a.a.b.b.a.bz(27, this.HIP);
      AppMethodBeat.o(152681);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GuF == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.Hed == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.GtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.GtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.FNK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152681);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyu localcyu = (cyu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152681);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyu.GuF = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyu.Hed = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyu.GtY = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyu.GtZ = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 5: 
          localcyu.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyu.FNK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 7: 
          localcyu.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 8: 
          localcyu.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 9: 
          localcyu.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 10: 
          localcyu.jfZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 11: 
          localcyu.Hhu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 12: 
          localcyu.Hhv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 13: 
          localcyu.Hhw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 14: 
          localcyu.jga = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 15: 
          localcyu.Hhx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 16: 
          localcyu.Hhy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 17: 
          localcyu.jgc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 18: 
          localcyu.jgb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 19: 
          localcyu.jgd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyu.HhA = ((dia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 21: 
          localcyu.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 22: 
          localcyu.jgf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aco();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyu.HhB = ((aco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 24: 
          localcyu.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 25: 
          localcyu.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 26: 
          localcyu.GNI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152681);
          return 0;
        }
        localcyu.HIP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(152681);
        return 0;
      }
      AppMethodBeat.o(152681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyu
 * JD-Core Version:    0.7.0.1
 */
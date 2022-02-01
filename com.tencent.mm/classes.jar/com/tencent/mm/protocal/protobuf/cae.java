package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cae
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t FNK;
  public String GXa;
  public String GnN;
  public String GnO;
  public cxn GtY;
  public cxn GtZ;
  public int Gto;
  public cxn GuF;
  public cxn Hed;
  public dia HhA;
  public aco HhB;
  public int Hhu;
  public String Hhv;
  public String Hhw;
  public String Hhx;
  public int Hhy;
  public int HnJ;
  public cxn Hnt;
  public cxn Hnu;
  public cxn Hnv;
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
    AppMethodBeat.i(101824);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuF == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Hed == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.GtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.GtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.FNK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Hnt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Hnu == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
        AppMethodBeat.o(101824);
        throw paramVarArgs;
      }
      if (this.Hnv == null)
      {
        paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
        AppMethodBeat.o(101824);
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
      paramVarArgs.aS(7, this.HnJ);
      if (this.Hnt != null)
      {
        paramVarArgs.lJ(8, this.Hnt.computeSize());
        this.Hnt.writeFields(paramVarArgs);
      }
      if (this.Hnu != null)
      {
        paramVarArgs.lJ(9, this.Hnu.computeSize());
        this.Hnu.writeFields(paramVarArgs);
      }
      if (this.Hnv != null)
      {
        paramVarArgs.lJ(10, this.Hnv.computeSize());
        this.Hnv.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.Gto);
      if (this.jfW != null) {
        paramVarArgs.d(12, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(13, this.jfX);
      }
      if (this.jfY != null) {
        paramVarArgs.d(14, this.jfY);
      }
      paramVarArgs.aS(15, this.jfZ);
      paramVarArgs.aS(16, this.Hhu);
      if (this.Hhv != null) {
        paramVarArgs.d(17, this.Hhv);
      }
      if (this.Hhw != null) {
        paramVarArgs.d(18, this.Hhw);
      }
      if (this.GXa != null) {
        paramVarArgs.d(19, this.GXa);
      }
      if (this.Hhx != null) {
        paramVarArgs.d(20, this.Hhx);
      }
      paramVarArgs.aS(21, this.Hhy);
      paramVarArgs.aS(22, this.jgc);
      paramVarArgs.aS(23, this.jgb);
      if (this.jgd != null) {
        paramVarArgs.d(24, this.jgd);
      }
      if (this.jga != null) {
        paramVarArgs.d(25, this.jga);
      }
      if (this.HhA != null)
      {
        paramVarArgs.lJ(26, this.HhA.computeSize());
        this.HhA.writeFields(paramVarArgs);
      }
      if (this.jge != null) {
        paramVarArgs.d(27, this.jge);
      }
      if (this.GnN != null) {
        paramVarArgs.d(28, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(29, this.GnO);
      }
      if (this.jgf != null) {
        paramVarArgs.d(30, this.jgf);
      }
      if (this.HhB != null)
      {
        paramVarArgs.lJ(31, this.HhB.computeSize());
        this.HhB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GuF == null) {
        break label3258;
      }
    }
    label3258:
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
      i = paramInt + f.a.a.b.b.a.bz(7, this.HnJ);
      paramInt = i;
      if (this.Hnt != null) {
        paramInt = i + f.a.a.a.lI(8, this.Hnt.computeSize());
      }
      i = paramInt;
      if (this.Hnu != null) {
        i = paramInt + f.a.a.a.lI(9, this.Hnu.computeSize());
      }
      paramInt = i;
      if (this.Hnv != null) {
        paramInt = i + f.a.a.a.lI(10, this.Hnv.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.Gto);
      paramInt = i;
      if (this.jfW != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.jfW);
      }
      i = paramInt;
      if (this.jfX != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.jfX);
      }
      paramInt = i;
      if (this.jfY != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.jfY);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.jfZ) + f.a.a.b.b.a.bz(16, this.Hhu);
      paramInt = i;
      if (this.Hhv != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.Hhv);
      }
      i = paramInt;
      if (this.Hhw != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.Hhw);
      }
      paramInt = i;
      if (this.GXa != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.GXa);
      }
      i = paramInt;
      if (this.Hhx != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.Hhx);
      }
      i = i + f.a.a.b.b.a.bz(21, this.Hhy) + f.a.a.b.b.a.bz(22, this.jgc) + f.a.a.b.b.a.bz(23, this.jgb);
      paramInt = i;
      if (this.jgd != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.jgd);
      }
      i = paramInt;
      if (this.jga != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.jga);
      }
      paramInt = i;
      if (this.HhA != null) {
        paramInt = i + f.a.a.a.lI(26, this.HhA.computeSize());
      }
      i = paramInt;
      if (this.jge != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.jge);
      }
      paramInt = i;
      if (this.GnN != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.GnN);
      }
      i = paramInt;
      if (this.GnO != null) {
        i = paramInt + f.a.a.b.b.a.e(29, this.GnO);
      }
      paramInt = i;
      if (this.jgf != null) {
        paramInt = i + f.a.a.b.b.a.e(30, this.jgf);
      }
      i = paramInt;
      if (this.HhB != null) {
        i = paramInt + f.a.a.a.lI(31, this.HhB.computeSize());
      }
      AppMethodBeat.o(101824);
      return i;
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
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Hed == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.GtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.GtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.FNK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Hnt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Hnu == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkPYInitial");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        if (this.Hnv == null)
        {
          paramVarArgs = new b("Not all required fields were included: RemarkQuanPin");
          AppMethodBeat.o(101824);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cae localcae = (cae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101824);
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
            localcae.GuF = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localcae.Hed = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localcae.GtY = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
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
            localcae.GtZ = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 5: 
          localcae.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101824);
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
            localcae.FNK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 7: 
          localcae.HnJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcae.Hnt = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcae.Hnu = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcae.Hnv = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 11: 
          localcae.Gto = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 12: 
          localcae.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 13: 
          localcae.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 14: 
          localcae.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 15: 
          localcae.jfZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 16: 
          localcae.Hhu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 17: 
          localcae.Hhv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 18: 
          localcae.Hhw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 19: 
          localcae.GXa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 20: 
          localcae.Hhx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 21: 
          localcae.Hhy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 22: 
          localcae.jgc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 23: 
          localcae.jgb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101824);
          return 0;
        case 24: 
          localcae.jgd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 25: 
          localcae.jga = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dia();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcae.HhA = ((dia)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101824);
          return 0;
        case 27: 
          localcae.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 28: 
          localcae.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 29: 
          localcae.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        case 30: 
          localcae.jgf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101824);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aco();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcae.HhB = ((aco)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101824);
        return 0;
      }
      AppMethodBeat.o(101824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cae
 * JD-Core Version:    0.7.0.1
 */
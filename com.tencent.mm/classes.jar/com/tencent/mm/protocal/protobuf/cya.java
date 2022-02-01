package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cya
  extends com.tencent.mm.bx.a
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
  public int Hpn;
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152681);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbY == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.GKC == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.Gbr == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.Gbs == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.Fvm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152681);
        throw paramVarArgs;
      }
      if (this.GbY != null)
      {
        paramVarArgs.lC(1, this.GbY.computeSize());
        this.GbY.writeFields(paramVarArgs);
      }
      if (this.GKC != null)
      {
        paramVarArgs.lC(2, this.GKC.computeSize());
        this.GKC.writeFields(paramVarArgs);
      }
      if (this.Gbr != null)
      {
        paramVarArgs.lC(3, this.Gbr.computeSize());
        this.Gbr.writeFields(paramVarArgs);
      }
      if (this.Gbs != null)
      {
        paramVarArgs.lC(4, this.Gbs.computeSize());
        this.Gbs.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.jdc);
      if (this.Fvm != null)
      {
        paramVarArgs.lC(6, this.Fvm.computeSize());
        this.Fvm.writeFields(paramVarArgs);
      }
      if (this.jdd != null) {
        paramVarArgs.d(7, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(8, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(9, this.jdf);
      }
      paramVarArgs.aS(10, this.jdg);
      paramVarArgs.aS(11, this.GNU);
      if (this.GNV != null) {
        paramVarArgs.d(12, this.GNV);
      }
      if (this.GNW != null) {
        paramVarArgs.d(13, this.GNW);
      }
      if (this.jdh != null) {
        paramVarArgs.d(14, this.jdh);
      }
      if (this.GNX != null) {
        paramVarArgs.d(15, this.GNX);
      }
      paramVarArgs.aS(16, this.GNY);
      paramVarArgs.aS(17, this.jdj);
      paramVarArgs.aS(18, this.jdi);
      if (this.jdk != null) {
        paramVarArgs.d(19, this.jdk);
      }
      if (this.GOa != null)
      {
        paramVarArgs.lC(20, this.GOa.computeSize());
        this.GOa.writeFields(paramVarArgs);
      }
      if (this.jdl != null) {
        paramVarArgs.d(21, this.jdl);
      }
      if (this.jdm != null) {
        paramVarArgs.d(22, this.jdm);
      }
      if (this.GOb != null)
      {
        paramVarArgs.lC(23, this.GOb.computeSize());
        this.GOb.writeFields(paramVarArgs);
      }
      if (this.FVo != null) {
        paramVarArgs.d(24, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(25, this.FVp);
      }
      if (this.Guj != null) {
        paramVarArgs.d(26, this.Guj);
      }
      paramVarArgs.aS(27, this.Hpn);
      AppMethodBeat.o(152681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbY == null) {
        break label2602;
      }
    }
    label2602:
    for (int i = f.a.a.a.lB(1, this.GbY.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GKC != null) {
        paramInt = i + f.a.a.a.lB(2, this.GKC.computeSize());
      }
      i = paramInt;
      if (this.Gbr != null) {
        i = paramInt + f.a.a.a.lB(3, this.Gbr.computeSize());
      }
      paramInt = i;
      if (this.Gbs != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gbs.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jdc);
      paramInt = i;
      if (this.Fvm != null) {
        paramInt = i + f.a.a.a.lB(6, this.Fvm.computeSize());
      }
      i = paramInt;
      if (this.jdd != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.jdd);
      }
      paramInt = i;
      if (this.jde != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.jde);
      }
      i = paramInt;
      if (this.jdf != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.jdf);
      }
      i = i + f.a.a.b.b.a.bz(10, this.jdg) + f.a.a.b.b.a.bz(11, this.GNU);
      paramInt = i;
      if (this.GNV != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GNV);
      }
      i = paramInt;
      if (this.GNW != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GNW);
      }
      paramInt = i;
      if (this.jdh != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.jdh);
      }
      i = paramInt;
      if (this.GNX != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GNX);
      }
      i = i + f.a.a.b.b.a.bz(16, this.GNY) + f.a.a.b.b.a.bz(17, this.jdj) + f.a.a.b.b.a.bz(18, this.jdi);
      paramInt = i;
      if (this.jdk != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.jdk);
      }
      i = paramInt;
      if (this.GOa != null) {
        i = paramInt + f.a.a.a.lB(20, this.GOa.computeSize());
      }
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.jdl);
      }
      i = paramInt;
      if (this.jdm != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.jdm);
      }
      paramInt = i;
      if (this.GOb != null) {
        paramInt = i + f.a.a.a.lB(23, this.GOb.computeSize());
      }
      i = paramInt;
      if (this.FVo != null) {
        i = paramInt + f.a.a.b.b.a.e(24, this.FVo);
      }
      paramInt = i;
      if (this.FVp != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.FVp);
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.b.b.a.e(26, this.Guj);
      }
      paramInt = f.a.a.b.b.a.bz(27, this.Hpn);
      AppMethodBeat.o(152681);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GbY == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.GKC == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.Gbr == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.Gbs == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(152681);
          throw paramVarArgs;
        }
        if (this.Fvm == null)
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
        cya localcya = (cya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152681);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcya.GbY = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcya.GKC = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcya.Gbr = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
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
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcya.Gbs = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 5: 
          localcya.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcya.Fvm = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 7: 
          localcya.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 8: 
          localcya.jde = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 9: 
          localcya.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 10: 
          localcya.jdg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 11: 
          localcya.GNU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 12: 
          localcya.GNV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 13: 
          localcya.GNW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 14: 
          localcya.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 15: 
          localcya.GNX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 16: 
          localcya.GNY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 17: 
          localcya.jdj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 18: 
          localcya.jdi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152681);
          return 0;
        case 19: 
          localcya.jdk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcya.GOa = ((dhg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 21: 
          localcya.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 22: 
          localcya.jdm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcya.GOb = ((acf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152681);
          return 0;
        case 24: 
          localcya.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 25: 
          localcya.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        case 26: 
          localcya.Guj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152681);
          return 0;
        }
        localcya.Hpn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152681);
        return 0;
      }
      AppMethodBeat.o(152681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cya
 * JD-Core Version:    0.7.0.1
 */
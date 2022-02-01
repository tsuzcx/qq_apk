package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class caq
  extends com.tencent.mm.bx.a
{
  public int Fsf;
  public int Fsi;
  public cwt GKC;
  public int GNU;
  public String GNV;
  public String GNW;
  public String GNX;
  public int GNY;
  public aex GUL;
  public int GUo;
  public int GVa;
  public int GVg;
  public com.tencent.mm.bx.b GVh;
  public int GVj;
  public cwt GVk;
  public cwt GVl;
  public int GVm;
  public int GVn;
  public int GVo;
  public int GVp;
  public int GVq;
  public bmj GVr;
  public int GVs;
  public String GVt;
  public cwt GbY;
  public long Ggd;
  public String Gge;
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
  public int nDG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43112);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbY == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.GKC == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.GVk == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.GVl == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GVj);
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
      paramVarArgs.aS(4, this.Fsf);
      if (this.GVk != null)
      {
        paramVarArgs.lC(5, this.GVk.computeSize());
        this.GVk.writeFields(paramVarArgs);
      }
      if (this.GVl != null)
      {
        paramVarArgs.lC(6, this.GVl.computeSize());
        this.GVl.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.nDG);
      paramVarArgs.aS(8, this.GVg);
      if (this.GVh != null) {
        paramVarArgs.c(9, this.GVh);
      }
      paramVarArgs.aS(10, this.jdc);
      if (this.jdd != null) {
        paramVarArgs.d(11, this.jdd);
      }
      if (this.jde != null) {
        paramVarArgs.d(12, this.jde);
      }
      if (this.jdf != null) {
        paramVarArgs.d(13, this.jdf);
      }
      paramVarArgs.aS(14, this.jdg);
      if (this.GUL != null)
      {
        paramVarArgs.lC(15, this.GUL.computeSize());
        this.GUL.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.Fsi);
      paramVarArgs.aS(17, this.GNU);
      if (this.GNV != null) {
        paramVarArgs.d(18, this.GNV);
      }
      paramVarArgs.aS(19, this.GVm);
      paramVarArgs.aS(20, this.GVn);
      paramVarArgs.aS(21, this.GUo);
      paramVarArgs.aS(22, this.GVo);
      paramVarArgs.aS(23, this.GVp);
      if (this.GNW != null) {
        paramVarArgs.d(24, this.GNW);
      }
      paramVarArgs.aS(25, this.GVq);
      if (this.GVr != null)
      {
        paramVarArgs.lC(26, this.GVr.computeSize());
        this.GVr.writeFields(paramVarArgs);
      }
      if (this.jdh != null) {
        paramVarArgs.d(27, this.jdh);
      }
      if (this.GNX != null) {
        paramVarArgs.d(28, this.GNX);
      }
      paramVarArgs.aS(29, this.GNY);
      paramVarArgs.aS(30, this.GVs);
      paramVarArgs.aY(31, this.Ggd);
      if (this.Gge != null) {
        paramVarArgs.d(32, this.Gge);
      }
      paramVarArgs.aS(33, this.jdj);
      paramVarArgs.aS(34, this.jdi);
      if (this.jdk != null) {
        paramVarArgs.d(35, this.jdk);
      }
      paramVarArgs.aS(36, this.GVa);
      if (this.GVt != null) {
        paramVarArgs.d(37, this.GVt);
      }
      if (this.jdl != null) {
        paramVarArgs.d(38, this.jdl);
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GVj) + 0;
      paramInt = i;
      if (this.GbY != null) {
        paramInt = i + f.a.a.a.lB(2, this.GbY.computeSize());
      }
      i = paramInt;
      if (this.GKC != null) {
        i = paramInt + f.a.a.a.lB(3, this.GKC.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.Fsf);
      paramInt = i;
      if (this.GVk != null) {
        paramInt = i + f.a.a.a.lB(5, this.GVk.computeSize());
      }
      i = paramInt;
      if (this.GVl != null) {
        i = paramInt + f.a.a.a.lB(6, this.GVl.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(7, this.nDG) + f.a.a.b.b.a.bz(8, this.GVg);
      paramInt = i;
      if (this.GVh != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.GVh);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.jdc);
      paramInt = i;
      if (this.jdd != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.jdd);
      }
      i = paramInt;
      if (this.jde != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.jde);
      }
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.jdf);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.jdg);
      paramInt = i;
      if (this.GUL != null) {
        paramInt = i + f.a.a.a.lB(15, this.GUL.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.Fsi) + f.a.a.b.b.a.bz(17, this.GNU);
      paramInt = i;
      if (this.GNV != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.GNV);
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.GVm) + f.a.a.b.b.a.bz(20, this.GVn) + f.a.a.b.b.a.bz(21, this.GUo) + f.a.a.b.b.a.bz(22, this.GVo) + f.a.a.b.b.a.bz(23, this.GVp);
      paramInt = i;
      if (this.GNW != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.GNW);
      }
      i = paramInt + f.a.a.b.b.a.bz(25, this.GVq);
      paramInt = i;
      if (this.GVr != null) {
        paramInt = i + f.a.a.a.lB(26, this.GVr.computeSize());
      }
      i = paramInt;
      if (this.jdh != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.jdh);
      }
      paramInt = i;
      if (this.GNX != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.GNX);
      }
      i = paramInt + f.a.a.b.b.a.bz(29, this.GNY) + f.a.a.b.b.a.bz(30, this.GVs) + f.a.a.b.b.a.p(31, this.Ggd);
      paramInt = i;
      if (this.Gge != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.Gge);
      }
      i = paramInt + f.a.a.b.b.a.bz(33, this.jdj) + f.a.a.b.b.a.bz(34, this.jdi);
      paramInt = i;
      if (this.jdk != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.jdk);
      }
      i = paramInt + f.a.a.b.b.a.bz(36, this.GVa);
      paramInt = i;
      if (this.GVt != null) {
        paramInt = i + f.a.a.b.b.a.e(37, this.GVt);
      }
      i = paramInt;
      if (this.jdl != null) {
        i = paramInt + f.a.a.b.b.a.e(38, this.jdl);
      }
      AppMethodBeat.o(43112);
      return i;
    }
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
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.GKC == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.GVk == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      if (this.GVl == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(43112);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43112);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      caq localcaq = (caq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43112);
        return -1;
      case 1: 
        localcaq.GVj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
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
          localcaq.GbY = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
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
          localcaq.GKC = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 4: 
        localcaq.Fsf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
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
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcaq.GVk = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcaq.GVl = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 7: 
        localcaq.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 8: 
        localcaq.GVg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 9: 
        localcaq.GVh = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(43112);
        return 0;
      case 10: 
        localcaq.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 11: 
        localcaq.jdd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 12: 
        localcaq.jde = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 13: 
        localcaq.jdf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 14: 
        localcaq.jdg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aex();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aex)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcaq.GUL = ((aex)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 16: 
        localcaq.Fsi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 17: 
        localcaq.GNU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 18: 
        localcaq.GNV = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 19: 
        localcaq.GVm = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 20: 
        localcaq.GVn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 21: 
        localcaq.GUo = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 22: 
        localcaq.GVo = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 23: 
        localcaq.GVp = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 24: 
        localcaq.GNW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 25: 
        localcaq.GVq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 26: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcaq.GVr = ((bmj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43112);
        return 0;
      case 27: 
        localcaq.jdh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 28: 
        localcaq.GNX = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 29: 
        localcaq.GNY = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 30: 
        localcaq.GVs = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 31: 
        localcaq.Ggd = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(43112);
        return 0;
      case 32: 
        localcaq.Gge = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 33: 
        localcaq.jdj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 34: 
        localcaq.jdi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 35: 
        localcaq.jdk = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43112);
        return 0;
      case 36: 
        localcaq.GVa = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(43112);
        return 0;
      case 37: 
        localcaq.GVt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(43112);
        return 0;
      }
      localcaq.jdl = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(43112);
      return 0;
    }
    AppMethodBeat.o(43112);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caq
 * JD-Core Version:    0.7.0.1
 */
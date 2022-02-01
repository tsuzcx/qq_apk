package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class hu
  extends com.tencent.mm.bx.a
{
  public int CCQ;
  public int CCR;
  public int CCS;
  public LinkedList<cmf> CCT;
  public LinkedList<cmg> CCU;
  public SKBuiltinBuffer_t CCV;
  public int CCW;
  public int CCX;
  public int CCY;
  public long CCZ;
  public int CDa;
  public String CxC;
  public cmf Cxx;
  public cmf Cxy;
  public cmf Cxz;
  public String CyF;
  public int mBH;
  public int uKX;
  public long uKZ;
  
  public hu()
  {
    AppMethodBeat.i(32137);
    this.CCT = new LinkedList();
    this.CCU = new LinkedList();
    AppMethodBeat.o(32137);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32138);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxx == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.Cxy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.Cxz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.mBH);
      if (this.CyF != null) {
        paramVarArgs.d(2, this.CyF);
      }
      if (this.Cxx != null)
      {
        paramVarArgs.kX(3, this.Cxx.computeSize());
        this.Cxx.writeFields(paramVarArgs);
      }
      if (this.Cxy != null)
      {
        paramVarArgs.kX(4, this.Cxy.computeSize());
        this.Cxy.writeFields(paramVarArgs);
      }
      if (this.Cxz != null)
      {
        paramVarArgs.kX(5, this.Cxz.computeSize());
        this.Cxz.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.CCQ);
      paramVarArgs.aR(7, this.CCR);
      if (this.CxC != null) {
        paramVarArgs.d(8, this.CxC);
      }
      paramVarArgs.aR(9, this.uKX);
      paramVarArgs.aR(10, this.CCS);
      paramVarArgs.e(11, 8, this.CCT);
      paramVarArgs.e(12, 8, this.CCU);
      if (this.CCV != null)
      {
        paramVarArgs.kX(13, this.CCV.computeSize());
        this.CCV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.CCW);
      paramVarArgs.aR(15, this.CCX);
      paramVarArgs.aG(16, this.uKZ);
      paramVarArgs.aR(17, this.CCY);
      paramVarArgs.aG(18, this.CCZ);
      paramVarArgs.aR(19, this.CDa);
      AppMethodBeat.o(32138);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.mBH) + 0;
      paramInt = i;
      if (this.CyF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CyF);
      }
      i = paramInt;
      if (this.Cxx != null) {
        i = paramInt + f.a.a.a.kW(3, this.Cxx.computeSize());
      }
      paramInt = i;
      if (this.Cxy != null) {
        paramInt = i + f.a.a.a.kW(4, this.Cxy.computeSize());
      }
      i = paramInt;
      if (this.Cxz != null) {
        i = paramInt + f.a.a.a.kW(5, this.Cxz.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(6, this.CCQ) + f.a.a.b.b.a.bA(7, this.CCR);
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CxC);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.uKX) + f.a.a.b.b.a.bA(10, this.CCS) + f.a.a.a.c(11, 8, this.CCT) + f.a.a.a.c(12, 8, this.CCU);
      paramInt = i;
      if (this.CCV != null) {
        paramInt = i + f.a.a.a.kW(13, this.CCV.computeSize());
      }
      i = f.a.a.b.b.a.bA(14, this.CCW);
      int j = f.a.a.b.b.a.bA(15, this.CCX);
      int k = f.a.a.b.b.a.q(16, this.uKZ);
      int m = f.a.a.b.b.a.bA(17, this.CCY);
      int n = f.a.a.b.b.a.q(18, this.CCZ);
      int i1 = f.a.a.b.b.a.bA(19, this.CDa);
      AppMethodBeat.o(32138);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CCT.clear();
      this.CCU.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Cxx == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.Cxy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.Cxz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32138);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      hu localhu = (hu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32138);
        return -1;
      case 1: 
        localhu.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32138);
        return 0;
      case 2: 
        localhu.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32138);
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
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhu.Cxx = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
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
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhu.Cxy = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
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
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhu.Cxz = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 6: 
        localhu.CCQ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32138);
        return 0;
      case 7: 
        localhu.CCR = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32138);
        return 0;
      case 8: 
        localhu.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 9: 
        localhu.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32138);
        return 0;
      case 10: 
        localhu.CCS = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32138);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhu.CCT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhu.CCU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localhu.CCV = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 14: 
        localhu.CCW = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32138);
        return 0;
      case 15: 
        localhu.CCX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32138);
        return 0;
      case 16: 
        localhu.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(32138);
        return 0;
      case 17: 
        localhu.CCY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32138);
        return 0;
      case 18: 
        localhu.CCZ = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(32138);
        return 0;
      }
      localhu.CDa = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(32138);
      return 0;
    }
    AppMethodBeat.o(32138);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hu
 * JD-Core Version:    0.7.0.1
 */
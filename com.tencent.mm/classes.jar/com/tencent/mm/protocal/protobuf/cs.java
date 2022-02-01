package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cs
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int CxA;
  public SKBuiltinBuffer_t CxB;
  public String CxC;
  public String CxD;
  public int CxE;
  public cmf Cxx;
  public cmf Cxy;
  public cmf Cxz;
  public int mBi;
  public int saz;
  public int uKX;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133143);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxx == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.Cxy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.Cxz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.uKX);
      if (this.Cxx != null)
      {
        paramVarArgs.kX(2, this.Cxx.computeSize());
        this.Cxx.writeFields(paramVarArgs);
      }
      if (this.Cxy != null)
      {
        paramVarArgs.kX(3, this.Cxy.computeSize());
        this.Cxy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.saz);
      if (this.Cxz != null)
      {
        paramVarArgs.kX(5, this.Cxz.computeSize());
        this.Cxz.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.mBi);
      paramVarArgs.aR(7, this.CxA);
      if (this.CxB != null)
      {
        paramVarArgs.kX(8, this.CxB.computeSize());
        this.CxB.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.CreateTime);
      if (this.CxC != null) {
        paramVarArgs.d(10, this.CxC);
      }
      if (this.CxD != null) {
        paramVarArgs.d(11, this.CxD);
      }
      paramVarArgs.aG(12, this.uKZ);
      paramVarArgs.aR(13, this.CxE);
      AppMethodBeat.o(133143);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.uKX) + 0;
      paramInt = i;
      if (this.Cxx != null) {
        paramInt = i + f.a.a.a.kW(2, this.Cxx.computeSize());
      }
      i = paramInt;
      if (this.Cxy != null) {
        i = paramInt + f.a.a.a.kW(3, this.Cxy.computeSize());
      }
      i += f.a.a.b.b.a.bA(4, this.saz);
      paramInt = i;
      if (this.Cxz != null) {
        paramInt = i + f.a.a.a.kW(5, this.Cxz.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.mBi) + f.a.a.b.b.a.bA(7, this.CxA);
      paramInt = i;
      if (this.CxB != null) {
        paramInt = i + f.a.a.a.kW(8, this.CxB.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.CreateTime);
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CxC);
      }
      i = paramInt;
      if (this.CxD != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.CxD);
      }
      paramInt = f.a.a.b.b.a.q(12, this.uKZ);
      int j = f.a.a.b.b.a.bA(13, this.CxE);
      AppMethodBeat.o(133143);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Cxx == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.Cxy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.Cxz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133143);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133143);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cs localcs = (cs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133143);
        return -1;
      case 1: 
        localcs.uKX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133143);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcs.Cxx = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
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
          localcs.Cxy = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 4: 
        localcs.saz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133143);
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
          localcs.Cxz = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 6: 
        localcs.mBi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133143);
        return 0;
      case 7: 
        localcs.CxA = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133143);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcs.CxB = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133143);
        return 0;
      case 9: 
        localcs.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(133143);
        return 0;
      case 10: 
        localcs.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 11: 
        localcs.CxD = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(133143);
        return 0;
      case 12: 
        localcs.uKZ = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(133143);
        return 0;
      }
      localcs.CxE = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(133143);
      return 0;
    }
    AppMethodBeat.o(133143);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cs
 * JD-Core Version:    0.7.0.1
 */
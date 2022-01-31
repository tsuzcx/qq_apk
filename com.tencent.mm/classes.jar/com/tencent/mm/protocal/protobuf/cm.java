package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cm
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public int jJS;
  public int nqW;
  public int pIE;
  public long pIG;
  public bwc woP;
  public bwc woQ;
  public bwc woR;
  public int woS;
  public SKBuiltinBuffer_t woT;
  public String woU;
  public String woV;
  public int woW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58884);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.woP == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(58884);
        throw paramVarArgs;
      }
      if (this.woQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(58884);
        throw paramVarArgs;
      }
      if (this.woR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(58884);
        throw paramVarArgs;
      }
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(58884);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.pIE);
      if (this.woP != null)
      {
        paramVarArgs.iQ(2, this.woP.computeSize());
        this.woP.writeFields(paramVarArgs);
      }
      if (this.woQ != null)
      {
        paramVarArgs.iQ(3, this.woQ.computeSize());
        this.woQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.nqW);
      if (this.woR != null)
      {
        paramVarArgs.iQ(5, this.woR.computeSize());
        this.woR.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.jJS);
      paramVarArgs.aO(7, this.woS);
      if (this.woT != null)
      {
        paramVarArgs.iQ(8, this.woT.computeSize());
        this.woT.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(9, this.CreateTime);
      if (this.woU != null) {
        paramVarArgs.e(10, this.woU);
      }
      if (this.woV != null) {
        paramVarArgs.e(11, this.woV);
      }
      paramVarArgs.am(12, this.pIG);
      paramVarArgs.aO(13, this.woW);
      AppMethodBeat.o(58884);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.pIE) + 0;
      paramInt = i;
      if (this.woP != null) {
        paramInt = i + e.a.a.a.iP(2, this.woP.computeSize());
      }
      i = paramInt;
      if (this.woQ != null) {
        i = paramInt + e.a.a.a.iP(3, this.woQ.computeSize());
      }
      i += e.a.a.b.b.a.bl(4, this.nqW);
      paramInt = i;
      if (this.woR != null) {
        paramInt = i + e.a.a.a.iP(5, this.woR.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.jJS) + e.a.a.b.b.a.bl(7, this.woS);
      paramInt = i;
      if (this.woT != null) {
        paramInt = i + e.a.a.a.iP(8, this.woT.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.CreateTime);
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.woU);
      }
      i = paramInt;
      if (this.woV != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.woV);
      }
      paramInt = e.a.a.b.b.a.p(12, this.pIG);
      int j = e.a.a.b.b.a.bl(13, this.woW);
      AppMethodBeat.o(58884);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.woP == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(58884);
        throw paramVarArgs;
      }
      if (this.woQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(58884);
        throw paramVarArgs;
      }
      if (this.woR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(58884);
        throw paramVarArgs;
      }
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(58884);
        throw paramVarArgs;
      }
      AppMethodBeat.o(58884);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      cm localcm = (cm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(58884);
        return -1;
      case 1: 
        localcm.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58884);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcm.woP = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58884);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcm.woQ = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58884);
        return 0;
      case 4: 
        localcm.nqW = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58884);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcm.woR = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58884);
        return 0;
      case 6: 
        localcm.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58884);
        return 0;
      case 7: 
        localcm.woS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58884);
        return 0;
      case 8: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcm.woT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58884);
        return 0;
      case 9: 
        localcm.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(58884);
        return 0;
      case 10: 
        localcm.woU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58884);
        return 0;
      case 11: 
        localcm.woV = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(58884);
        return 0;
      case 12: 
        localcm.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(58884);
        return 0;
      }
      localcm.woW = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(58884);
      return 0;
    }
    AppMethodBeat.o(58884);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cm
 * JD-Core Version:    0.7.0.1
 */
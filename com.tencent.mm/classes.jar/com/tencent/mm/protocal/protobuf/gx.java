package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class gx
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public int pIE;
  public long pIG;
  public bwc woP;
  public bwc woQ;
  public bwc woR;
  public String woU;
  public String wpS;
  public int wtl;
  public int wtm;
  public int wtn;
  public LinkedList<bwc> wto;
  public LinkedList<bwd> wtp;
  public SKBuiltinBuffer_t wtq;
  public int wtr;
  public int wts;
  public int wtt;
  public long wtu;
  public int wtv;
  
  public gx()
  {
    AppMethodBeat.i(28333);
    this.wto = new LinkedList();
    this.wtp = new LinkedList();
    AppMethodBeat.o(28333);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28334);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.woP == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(28334);
        throw paramVarArgs;
      }
      if (this.woQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(28334);
        throw paramVarArgs;
      }
      if (this.woR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(28334);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.jKs);
      if (this.wpS != null) {
        paramVarArgs.e(2, this.wpS);
      }
      if (this.woP != null)
      {
        paramVarArgs.iQ(3, this.woP.computeSize());
        this.woP.writeFields(paramVarArgs);
      }
      if (this.woQ != null)
      {
        paramVarArgs.iQ(4, this.woQ.computeSize());
        this.woQ.writeFields(paramVarArgs);
      }
      if (this.woR != null)
      {
        paramVarArgs.iQ(5, this.woR.computeSize());
        this.woR.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.wtl);
      paramVarArgs.aO(7, this.wtm);
      if (this.woU != null) {
        paramVarArgs.e(8, this.woU);
      }
      paramVarArgs.aO(9, this.pIE);
      paramVarArgs.aO(10, this.wtn);
      paramVarArgs.e(11, 8, this.wto);
      paramVarArgs.e(12, 8, this.wtp);
      if (this.wtq != null)
      {
        paramVarArgs.iQ(13, this.wtq.computeSize());
        this.wtq.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(14, this.wtr);
      paramVarArgs.aO(15, this.wts);
      paramVarArgs.am(16, this.pIG);
      paramVarArgs.aO(17, this.wtt);
      paramVarArgs.am(18, this.wtu);
      paramVarArgs.aO(19, this.wtv);
      AppMethodBeat.o(28334);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.jKs) + 0;
      paramInt = i;
      if (this.wpS != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wpS);
      }
      i = paramInt;
      if (this.woP != null) {
        i = paramInt + e.a.a.a.iP(3, this.woP.computeSize());
      }
      paramInt = i;
      if (this.woQ != null) {
        paramInt = i + e.a.a.a.iP(4, this.woQ.computeSize());
      }
      i = paramInt;
      if (this.woR != null) {
        i = paramInt + e.a.a.a.iP(5, this.woR.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(6, this.wtl) + e.a.a.b.b.a.bl(7, this.wtm);
      paramInt = i;
      if (this.woU != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.woU);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.pIE) + e.a.a.b.b.a.bl(10, this.wtn) + e.a.a.a.c(11, 8, this.wto) + e.a.a.a.c(12, 8, this.wtp);
      paramInt = i;
      if (this.wtq != null) {
        paramInt = i + e.a.a.a.iP(13, this.wtq.computeSize());
      }
      i = e.a.a.b.b.a.bl(14, this.wtr);
      int j = e.a.a.b.b.a.bl(15, this.wts);
      int k = e.a.a.b.b.a.p(16, this.pIG);
      int m = e.a.a.b.b.a.bl(17, this.wtt);
      int n = e.a.a.b.b.a.p(18, this.wtu);
      int i1 = e.a.a.b.b.a.bl(19, this.wtv);
      AppMethodBeat.o(28334);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wto.clear();
      this.wtp.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.woP == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(28334);
        throw paramVarArgs;
      }
      if (this.woQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(28334);
        throw paramVarArgs;
      }
      if (this.woR == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(28334);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28334);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      gx localgx = (gx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(28334);
        return -1;
      case 1: 
        localgx.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28334);
        return 0;
      case 2: 
        localgx.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28334);
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
          localgx.woP = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28334);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgx.woQ = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28334);
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
          localgx.woR = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28334);
        return 0;
      case 6: 
        localgx.wtl = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28334);
        return 0;
      case 7: 
        localgx.wtm = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28334);
        return 0;
      case 8: 
        localgx.woU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28334);
        return 0;
      case 9: 
        localgx.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28334);
        return 0;
      case 10: 
        localgx.wtn = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28334);
        return 0;
      case 11: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgx.wto.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28334);
        return 0;
      case 12: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwd();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgx.wtp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28334);
        return 0;
      case 13: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localgx.wtq = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28334);
        return 0;
      case 14: 
        localgx.wtr = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28334);
        return 0;
      case 15: 
        localgx.wts = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28334);
        return 0;
      case 16: 
        localgx.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(28334);
        return 0;
      case 17: 
        localgx.wtt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28334);
        return 0;
      case 18: 
        localgx.wtu = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(28334);
        return 0;
      }
      localgx.wtv = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(28334);
      return 0;
    }
    AppMethodBeat.o(28334);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gx
 * JD-Core Version:    0.7.0.1
 */
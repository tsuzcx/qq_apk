package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class if
  extends com.tencent.mm.bw.a
{
  public cxn FNG;
  public cxn FNH;
  public cxn FNI;
  public String FNL;
  public String FOR;
  public int FTe;
  public int FTf;
  public int FTg;
  public LinkedList<cxn> FTh;
  public LinkedList<cxo> FTi;
  public SKBuiltinBuffer_t FTj;
  public int FTk;
  public int FTl;
  public int FTm;
  public long FTn;
  public int FTo;
  public int nJA;
  public int xri;
  public long xrk;
  
  public if()
  {
    AppMethodBeat.i(32137);
    this.FTh = new LinkedList();
    this.FTi = new LinkedList();
    AppMethodBeat.o(32137);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32138);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.FNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.FNI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.nJA);
      if (this.FOR != null) {
        paramVarArgs.d(2, this.FOR);
      }
      if (this.FNG != null)
      {
        paramVarArgs.lJ(3, this.FNG.computeSize());
        this.FNG.writeFields(paramVarArgs);
      }
      if (this.FNH != null)
      {
        paramVarArgs.lJ(4, this.FNH.computeSize());
        this.FNH.writeFields(paramVarArgs);
      }
      if (this.FNI != null)
      {
        paramVarArgs.lJ(5, this.FNI.computeSize());
        this.FNI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FTe);
      paramVarArgs.aS(7, this.FTf);
      if (this.FNL != null) {
        paramVarArgs.d(8, this.FNL);
      }
      paramVarArgs.aS(9, this.xri);
      paramVarArgs.aS(10, this.FTg);
      paramVarArgs.e(11, 8, this.FTh);
      paramVarArgs.e(12, 8, this.FTi);
      if (this.FTj != null)
      {
        paramVarArgs.lJ(13, this.FTj.computeSize());
        this.FTj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.FTk);
      paramVarArgs.aS(15, this.FTl);
      paramVarArgs.aZ(16, this.xrk);
      paramVarArgs.aS(17, this.FTm);
      paramVarArgs.aZ(18, this.FTn);
      paramVarArgs.aS(19, this.FTo);
      AppMethodBeat.o(32138);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nJA) + 0;
      paramInt = i;
      if (this.FOR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FOR);
      }
      i = paramInt;
      if (this.FNG != null) {
        i = paramInt + f.a.a.a.lI(3, this.FNG.computeSize());
      }
      paramInt = i;
      if (this.FNH != null) {
        paramInt = i + f.a.a.a.lI(4, this.FNH.computeSize());
      }
      i = paramInt;
      if (this.FNI != null) {
        i = paramInt + f.a.a.a.lI(5, this.FNI.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(6, this.FTe) + f.a.a.b.b.a.bz(7, this.FTf);
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FNL);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.xri) + f.a.a.b.b.a.bz(10, this.FTg) + f.a.a.a.c(11, 8, this.FTh) + f.a.a.a.c(12, 8, this.FTi);
      paramInt = i;
      if (this.FTj != null) {
        paramInt = i + f.a.a.a.lI(13, this.FTj.computeSize());
      }
      i = f.a.a.b.b.a.bz(14, this.FTk);
      int j = f.a.a.b.b.a.bz(15, this.FTl);
      int k = f.a.a.b.b.a.p(16, this.xrk);
      int m = f.a.a.b.b.a.bz(17, this.FTm);
      int n = f.a.a.b.b.a.p(18, this.FTn);
      int i1 = f.a.a.b.b.a.bz(19, this.FTo);
      AppMethodBeat.o(32138);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FTh.clear();
      this.FTi.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.FNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.FNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.FNI == null)
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
      if localif = (if)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32138);
        return -1;
      case 1: 
        localif.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 2: 
        localif.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32138);
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
          localif.FNG = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
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
          localif.FNH = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
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
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localif.FNI = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 6: 
        localif.FTe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 7: 
        localif.FTf = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 8: 
        localif.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 9: 
        localif.xri = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 10: 
        localif.FTg = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localif.FTh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localif.FTi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localif.FTj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 14: 
        localif.FTk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 15: 
        localif.FTl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 16: 
        localif.xrk = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(32138);
        return 0;
      case 17: 
        localif.FTm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 18: 
        localif.FTn = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(32138);
        return 0;
      }
      localif.FTo = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(32138);
      return 0;
    }
    AppMethodBeat.o(32138);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.if
 * JD-Core Version:    0.7.0.1
 */
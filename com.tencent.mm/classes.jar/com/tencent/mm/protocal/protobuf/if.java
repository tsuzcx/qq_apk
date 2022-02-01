package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class if
  extends com.tencent.mm.bx.a
{
  public int FAI;
  public int FAJ;
  public int FAK;
  public LinkedList<cwt> FAL;
  public LinkedList<cwu> FAM;
  public SKBuiltinBuffer_t FAN;
  public int FAO;
  public int FAP;
  public int FAQ;
  public long FAS;
  public int FAT;
  public cwt Fvi;
  public cwt Fvj;
  public cwt Fvk;
  public String Fvn;
  public String Fwt;
  public int nEf;
  public int xbr;
  public long xbt;
  
  public if()
  {
    AppMethodBeat.i(32137);
    this.FAL = new LinkedList();
    this.FAM = new LinkedList();
    AppMethodBeat.o(32137);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32138);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.Fvj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.Fvk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.nEf);
      if (this.Fwt != null) {
        paramVarArgs.d(2, this.Fwt);
      }
      if (this.Fvi != null)
      {
        paramVarArgs.lC(3, this.Fvi.computeSize());
        this.Fvi.writeFields(paramVarArgs);
      }
      if (this.Fvj != null)
      {
        paramVarArgs.lC(4, this.Fvj.computeSize());
        this.Fvj.writeFields(paramVarArgs);
      }
      if (this.Fvk != null)
      {
        paramVarArgs.lC(5, this.Fvk.computeSize());
        this.Fvk.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FAI);
      paramVarArgs.aS(7, this.FAJ);
      if (this.Fvn != null) {
        paramVarArgs.d(8, this.Fvn);
      }
      paramVarArgs.aS(9, this.xbr);
      paramVarArgs.aS(10, this.FAK);
      paramVarArgs.e(11, 8, this.FAL);
      paramVarArgs.e(12, 8, this.FAM);
      if (this.FAN != null)
      {
        paramVarArgs.lC(13, this.FAN.computeSize());
        this.FAN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.FAO);
      paramVarArgs.aS(15, this.FAP);
      paramVarArgs.aY(16, this.xbt);
      paramVarArgs.aS(17, this.FAQ);
      paramVarArgs.aY(18, this.FAS);
      paramVarArgs.aS(19, this.FAT);
      AppMethodBeat.o(32138);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nEf) + 0;
      paramInt = i;
      if (this.Fwt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fwt);
      }
      i = paramInt;
      if (this.Fvi != null) {
        i = paramInt + f.a.a.a.lB(3, this.Fvi.computeSize());
      }
      paramInt = i;
      if (this.Fvj != null) {
        paramInt = i + f.a.a.a.lB(4, this.Fvj.computeSize());
      }
      i = paramInt;
      if (this.Fvk != null) {
        i = paramInt + f.a.a.a.lB(5, this.Fvk.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(6, this.FAI) + f.a.a.b.b.a.bz(7, this.FAJ);
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fvn);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.xbr) + f.a.a.b.b.a.bz(10, this.FAK) + f.a.a.a.c(11, 8, this.FAL) + f.a.a.a.c(12, 8, this.FAM);
      paramInt = i;
      if (this.FAN != null) {
        paramInt = i + f.a.a.a.lB(13, this.FAN.computeSize());
      }
      i = f.a.a.b.b.a.bz(14, this.FAO);
      int j = f.a.a.b.b.a.bz(15, this.FAP);
      int k = f.a.a.b.b.a.p(16, this.xbt);
      int m = f.a.a.b.b.a.bz(17, this.FAQ);
      int n = f.a.a.b.b.a.p(18, this.FAS);
      int i1 = f.a.a.b.b.a.bz(19, this.FAT);
      AppMethodBeat.o(32138);
      return paramInt + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FAL.clear();
      this.FAM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Fvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.Fvj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(32138);
        throw paramVarArgs;
      }
      if (this.Fvk == null)
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
        localif.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 2: 
        localif.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32138);
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
          localif.Fvi = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
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
          localif.Fvj = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
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
          localif.Fvk = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 6: 
        localif.FAI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 7: 
        localif.FAJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 8: 
        localif.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32138);
        return 0;
      case 9: 
        localif.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 10: 
        localif.FAK = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localif.FAL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localif.FAM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localif.FAN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32138);
        return 0;
      case 14: 
        localif.FAO = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 15: 
        localif.FAP = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 16: 
        localif.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(32138);
        return 0;
      case 17: 
        localif.FAQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32138);
        return 0;
      case 18: 
        localif.FAS = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(32138);
        return 0;
      }
      localif.FAT = ((f.a.a.a.a)localObject1).NPN.zc();
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
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dxy
  extends cvc
{
  public int FYc;
  public int GeI;
  public long GeJ;
  public dym HJd;
  public dym HJe;
  public long HJh;
  public int HJi;
  public int HJj;
  public LinkedList<cbv> HJk;
  public int HKd;
  public int HKp;
  public LinkedList<cwt> HKq;
  public int HKr;
  public int HfX;
  public String Hgt;
  public int Hwq;
  
  public dxy()
  {
    AppMethodBeat.i(115883);
    this.HKq = new LinkedList();
    this.HJk = new LinkedList();
    AppMethodBeat.o(115883);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115884);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HJd == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.HJe == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hgt != null) {
        paramVarArgs.d(2, this.Hgt);
      }
      paramVarArgs.aS(3, this.HKp);
      paramVarArgs.e(4, 8, this.HKq);
      if (this.HJd != null)
      {
        paramVarArgs.lC(6, this.HJd.computeSize());
        this.HJd.writeFields(paramVarArgs);
      }
      if (this.HJe != null)
      {
        paramVarArgs.lC(7, this.HJe.computeSize());
        this.HJe.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.FYc);
      paramVarArgs.aS(9, this.Hwq);
      paramVarArgs.aS(10, this.GeI);
      paramVarArgs.aY(11, this.GeJ);
      paramVarArgs.aS(12, this.HKd);
      paramVarArgs.aY(13, this.HJh);
      paramVarArgs.aS(14, this.HKr);
      paramVarArgs.aS(15, this.HfX);
      paramVarArgs.aS(16, this.HJi);
      paramVarArgs.aS(17, this.HJj);
      paramVarArgs.e(18, 8, this.HJk);
      AppMethodBeat.o(115884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1586;
      }
    }
    label1586:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hgt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hgt);
      }
      i = i + f.a.a.b.b.a.bz(3, this.HKp) + f.a.a.a.c(4, 8, this.HKq);
      paramInt = i;
      if (this.HJd != null) {
        paramInt = i + f.a.a.a.lB(6, this.HJd.computeSize());
      }
      i = paramInt;
      if (this.HJe != null) {
        i = paramInt + f.a.a.a.lB(7, this.HJe.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(8, this.FYc);
      int j = f.a.a.b.b.a.bz(9, this.Hwq);
      int k = f.a.a.b.b.a.bz(10, this.GeI);
      int m = f.a.a.b.b.a.p(11, this.GeJ);
      int n = f.a.a.b.b.a.bz(12, this.HKd);
      int i1 = f.a.a.b.b.a.p(13, this.HJh);
      int i2 = f.a.a.b.b.a.bz(14, this.HKr);
      int i3 = f.a.a.b.b.a.bz(15, this.HfX);
      int i4 = f.a.a.b.b.a.bz(16, this.HJi);
      int i5 = f.a.a.b.b.a.bz(17, this.HJj);
      int i6 = f.a.a.a.c(18, 8, this.HJk);
      AppMethodBeat.o(115884);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HKq.clear();
        this.HJk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HJd == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        if (this.HJe == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxy localdxy = (dxy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115884);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 2: 
          localdxy.Hgt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115884);
          return 0;
        case 3: 
          localdxy.HKp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115884);
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
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxy.HKq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dym();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dym)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxy.HJd = ((dym)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dym();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dym)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxy.HJe = ((dym)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 8: 
          localdxy.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 9: 
          localdxy.Hwq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 10: 
          localdxy.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 11: 
          localdxy.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115884);
          return 0;
        case 12: 
          localdxy.HKd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 13: 
          localdxy.HJh = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115884);
          return 0;
        case 14: 
          localdxy.HKr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 15: 
          localdxy.HfX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 16: 
          localdxy.HJi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115884);
          return 0;
        case 17: 
          localdxy.HJj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115884);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxy.HJk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      AppMethodBeat.o(115884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxy
 * JD-Core Version:    0.7.0.1
 */
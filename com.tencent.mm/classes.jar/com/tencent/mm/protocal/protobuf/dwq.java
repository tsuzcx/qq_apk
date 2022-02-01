package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwq
  extends cvc
{
  public int FYc;
  public int GeI;
  public long GeJ;
  public int HJc;
  public dym HJd;
  public dym HJe;
  public String HJf;
  public int HJg;
  public long HJh;
  public int HJi;
  public int HJj;
  public LinkedList<cbv> HJk;
  public String Hgt;
  
  public dwq()
  {
    AppMethodBeat.i(115857);
    this.HJk = new LinkedList();
    AppMethodBeat.o(115857);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115858);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      if (this.Hgt != null) {
        paramVarArgs.d(4, this.Hgt);
      }
      paramVarArgs.aS(5, this.HJc);
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
      if (this.HJf != null) {
        paramVarArgs.d(9, this.HJf);
      }
      paramVarArgs.aS(10, this.HJg);
      paramVarArgs.aY(11, this.HJh);
      paramVarArgs.aS(12, this.HJi);
      paramVarArgs.aS(13, this.HJj);
      paramVarArgs.e(14, 8, this.HJk);
      AppMethodBeat.o(115858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1254;
      }
    }
    label1254:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GeI) + f.a.a.b.b.a.p(3, this.GeJ);
      paramInt = i;
      if (this.Hgt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hgt);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HJc);
      paramInt = i;
      if (this.HJd != null) {
        paramInt = i + f.a.a.a.lB(6, this.HJd.computeSize());
      }
      i = paramInt;
      if (this.HJe != null) {
        i = paramInt + f.a.a.a.lB(7, this.HJe.computeSize());
      }
      i += f.a.a.b.b.a.bz(8, this.FYc);
      paramInt = i;
      if (this.HJf != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HJf);
      }
      i = f.a.a.b.b.a.bz(10, this.HJg);
      int j = f.a.a.b.b.a.p(11, this.HJh);
      int k = f.a.a.b.b.a.bz(12, this.HJi);
      int m = f.a.a.b.b.a.bz(13, this.HJj);
      int n = f.a.a.a.c(14, 8, this.HJk);
      AppMethodBeat.o(115858);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HJk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(115858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwq localdwq = (dwq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115858);
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
            localdwq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 2: 
          localdwq.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115858);
          return 0;
        case 3: 
          localdwq.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115858);
          return 0;
        case 4: 
          localdwq.Hgt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 5: 
          localdwq.HJc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115858);
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
            localdwq.HJd = ((dym)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
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
            localdwq.HJe = ((dym)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 8: 
          localdwq.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115858);
          return 0;
        case 9: 
          localdwq.HJf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 10: 
          localdwq.HJg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115858);
          return 0;
        case 11: 
          localdwq.HJh = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115858);
          return 0;
        case 12: 
          localdwq.HJi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115858);
          return 0;
        case 13: 
          localdwq.HJj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115858);
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
          localdwq.HJk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115858);
        return 0;
      }
      AppMethodBeat.o(115858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwq
 * JD-Core Version:    0.7.0.1
 */
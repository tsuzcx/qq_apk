package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwu
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
  public int HJu;
  public int HJv;
  public String Hgt;
  
  public dwu()
  {
    AppMethodBeat.i(115863);
    this.HJk = new LinkedList();
    AppMethodBeat.o(115863);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115864);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hgt != null) {
        paramVarArgs.d(2, this.Hgt);
      }
      paramVarArgs.aS(3, this.GeI);
      paramVarArgs.aS(4, this.HJu);
      if (this.HJd != null)
      {
        paramVarArgs.lC(5, this.HJd.computeSize());
        this.HJd.writeFields(paramVarArgs);
      }
      if (this.HJe != null)
      {
        paramVarArgs.lC(6, this.HJe.computeSize());
        this.HJe.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.GeJ);
      paramVarArgs.aS(8, this.FYc);
      paramVarArgs.aY(9, this.HJh);
      paramVarArgs.aS(10, this.HJv);
      paramVarArgs.aS(11, this.HJi);
      paramVarArgs.aS(12, this.HJj);
      paramVarArgs.e(13, 8, this.HJk);
      AppMethodBeat.o(115864);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hgt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hgt);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GeI) + f.a.a.b.b.a.bz(4, this.HJu);
      paramInt = i;
      if (this.HJd != null) {
        paramInt = i + f.a.a.a.lB(5, this.HJd.computeSize());
      }
      i = paramInt;
      if (this.HJe != null) {
        i = paramInt + f.a.a.a.lB(6, this.HJe.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(7, this.GeJ);
      int j = f.a.a.b.b.a.bz(8, this.FYc);
      int k = f.a.a.b.b.a.p(9, this.HJh);
      int m = f.a.a.b.b.a.bz(10, this.HJv);
      int n = f.a.a.b.b.a.bz(11, this.HJi);
      int i1 = f.a.a.b.b.a.bz(12, this.HJj);
      int i2 = f.a.a.a.c(13, 8, this.HJk);
      AppMethodBeat.o(115864);
      return i + paramInt + j + k + m + n + i1 + i2;
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
        AppMethodBeat.o(115864);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwu localdwu = (dwu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115864);
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
            localdwu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 2: 
          localdwu.Hgt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115864);
          return 0;
        case 3: 
          localdwu.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115864);
          return 0;
        case 4: 
          localdwu.HJu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115864);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dym();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dym)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwu.HJd = ((dym)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
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
            localdwu.HJe = ((dym)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115864);
          return 0;
        case 7: 
          localdwu.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115864);
          return 0;
        case 8: 
          localdwu.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115864);
          return 0;
        case 9: 
          localdwu.HJh = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115864);
          return 0;
        case 10: 
          localdwu.HJv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115864);
          return 0;
        case 11: 
          localdwu.HJi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115864);
          return 0;
        case 12: 
          localdwu.HJj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115864);
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
          localdwu.HJk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115864);
        return 0;
      }
      AppMethodBeat.o(115864);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwu
 * JD-Core Version:    0.7.0.1
 */
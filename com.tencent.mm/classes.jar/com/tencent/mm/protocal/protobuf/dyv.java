package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyv
  extends cvc
{
  public int GcV;
  public long HJh;
  public dyu HKc;
  public dyu HMi;
  public dyu HMj;
  public dyu HMk;
  public dyu HMl;
  public int HMm;
  public LinkedList<cwt> HMn;
  public LinkedList<cwt> HMo;
  public LinkedList<cwt> HMp;
  public int HMq;
  public LinkedList<cwt> HMr;
  public int Hlr;
  
  public dyv()
  {
    AppMethodBeat.i(115921);
    this.HMn = new LinkedList();
    this.HMo = new LinkedList();
    this.HMp = new LinkedList();
    this.HMr = new LinkedList();
    AppMethodBeat.o(115921);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115922);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HKc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HKc != null)
      {
        paramVarArgs.lC(2, this.HKc.computeSize());
        this.HKc.writeFields(paramVarArgs);
      }
      if (this.HMi != null)
      {
        paramVarArgs.lC(3, this.HMi.computeSize());
        this.HMi.writeFields(paramVarArgs);
      }
      if (this.HMj != null)
      {
        paramVarArgs.lC(4, this.HMj.computeSize());
        this.HMj.writeFields(paramVarArgs);
      }
      if (this.HMk != null)
      {
        paramVarArgs.lC(5, this.HMk.computeSize());
        this.HMk.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.HJh);
      if (this.HMl != null)
      {
        paramVarArgs.lC(7, this.HMl.computeSize());
        this.HMl.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.HMm);
      paramVarArgs.e(9, 8, this.HMn);
      paramVarArgs.aS(10, this.GcV);
      paramVarArgs.e(11, 8, this.HMo);
      paramVarArgs.aS(12, this.Hlr);
      paramVarArgs.e(13, 8, this.HMp);
      paramVarArgs.aS(14, this.HMq);
      paramVarArgs.e(15, 8, this.HMr);
      AppMethodBeat.o(115922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1942;
      }
    }
    label1942:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HKc != null) {
        paramInt = i + f.a.a.a.lB(2, this.HKc.computeSize());
      }
      i = paramInt;
      if (this.HMi != null) {
        i = paramInt + f.a.a.a.lB(3, this.HMi.computeSize());
      }
      paramInt = i;
      if (this.HMj != null) {
        paramInt = i + f.a.a.a.lB(4, this.HMj.computeSize());
      }
      i = paramInt;
      if (this.HMk != null) {
        i = paramInt + f.a.a.a.lB(5, this.HMk.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.HJh);
      paramInt = i;
      if (this.HMl != null) {
        paramInt = i + f.a.a.a.lB(7, this.HMl.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.HMm);
      int j = f.a.a.a.c(9, 8, this.HMn);
      int k = f.a.a.b.b.a.bz(10, this.GcV);
      int m = f.a.a.a.c(11, 8, this.HMo);
      int n = f.a.a.b.b.a.bz(12, this.Hlr);
      int i1 = f.a.a.a.c(13, 8, this.HMp);
      int i2 = f.a.a.b.b.a.bz(14, this.HMq);
      int i3 = f.a.a.a.c(15, 8, this.HMr);
      AppMethodBeat.o(115922);
      return paramInt + i + j + k + m + n + i1 + i2 + i3;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HMn.clear();
        this.HMo.clear();
        this.HMp.clear();
        this.HMr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HKc == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyv localdyv = (dyv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115922);
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
            localdyv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyv.HKc = ((dyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyv.HMi = ((dyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyv.HMj = ((dyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyv.HMk = ((dyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 6: 
          localdyv.HJh = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115922);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyv.HMl = ((dyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 8: 
          localdyv.HMm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115922);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyv.HMn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 10: 
          localdyv.GcV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115922);
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
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyv.HMo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 12: 
          localdyv.Hlr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115922);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyv.HMp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115922);
          return 0;
        case 14: 
          localdyv.HMq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115922);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyv.HMr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115922);
        return 0;
      }
      AppMethodBeat.o(115922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyv
 * JD-Core Version:    0.7.0.1
 */
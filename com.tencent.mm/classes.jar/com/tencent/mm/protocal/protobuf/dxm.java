package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dxm
  extends cvc
{
  public int GeI;
  public long GeJ;
  public long HJh;
  public dyu HKc;
  public int HKd;
  public int HKe;
  public int HfX;
  public String Hgt;
  public String uki;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115868);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HKc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReportData");
        AppMethodBeat.o(115868);
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
      paramVarArgs.aS(3, this.GeI);
      paramVarArgs.aY(4, this.GeJ);
      if (this.uki != null) {
        paramVarArgs.d(6, this.uki);
      }
      if (this.HKc != null)
      {
        paramVarArgs.lC(8, this.HKc.computeSize());
        this.HKc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.HKd);
      paramVarArgs.aY(10, this.HJh);
      paramVarArgs.aS(11, this.HfX);
      paramVarArgs.aS(12, this.HKe);
      AppMethodBeat.o(115868);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hgt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Hgt);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GeI) + f.a.a.b.b.a.p(4, this.GeJ);
      paramInt = i;
      if (this.uki != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uki);
      }
      i = paramInt;
      if (this.HKc != null) {
        i = paramInt + f.a.a.a.lB(8, this.HKc.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(9, this.HKd);
      int j = f.a.a.b.b.a.p(10, this.HJh);
      int k = f.a.a.b.b.a.bz(11, this.HfX);
      int m = f.a.a.b.b.a.bz(12, this.HKe);
      AppMethodBeat.o(115868);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HKc == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReportData");
          AppMethodBeat.o(115868);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115868);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxm localdxm = (dxm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(115868);
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
            localdxm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 2: 
          localdxm.Hgt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 3: 
          localdxm.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115868);
          return 0;
        case 4: 
          localdxm.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115868);
          return 0;
        case 6: 
          localdxm.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(115868);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxm.HKc = ((dyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115868);
          return 0;
        case 9: 
          localdxm.HKd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115868);
          return 0;
        case 10: 
          localdxm.HJh = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115868);
          return 0;
        case 11: 
          localdxm.HfX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115868);
          return 0;
        }
        localdxm.HKe = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115868);
        return 0;
      }
      AppMethodBeat.o(115868);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxm
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dys
  extends cvc
{
  public int FYc;
  public int GeI;
  public int HwA;
  public int Hwq;
  public int Hwr;
  public int Hws;
  public int Hwt;
  public int Hwu;
  public LinkedList<Integer> Hwv;
  public int Hww;
  public int Hwx;
  public LinkedList<Integer> Hwy;
  public int Hwz;
  
  public dys()
  {
    AppMethodBeat.i(115916);
    this.Hwv = new LinkedList();
    this.Hwy = new LinkedList();
    AppMethodBeat.o(115916);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115917);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aS(3, this.Hwq);
      paramVarArgs.aS(4, this.FYc);
      paramVarArgs.aS(5, this.Hwr);
      paramVarArgs.aS(6, this.Hws);
      paramVarArgs.aS(7, this.Hwt);
      paramVarArgs.aS(8, this.Hwu);
      paramVarArgs.f(9, 2, this.Hwv);
      paramVarArgs.aS(10, this.Hww);
      paramVarArgs.aS(11, this.Hwx);
      paramVarArgs.f(12, 2, this.Hwy);
      paramVarArgs.aS(13, this.Hwz);
      paramVarArgs.aS(14, this.HwA);
      AppMethodBeat.o(115917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label984;
      }
    }
    label984:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GeI);
      int j = f.a.a.b.b.a.bz(3, this.Hwq);
      int k = f.a.a.b.b.a.bz(4, this.FYc);
      int m = f.a.a.b.b.a.bz(5, this.Hwr);
      int n = f.a.a.b.b.a.bz(6, this.Hws);
      int i1 = f.a.a.b.b.a.bz(7, this.Hwt);
      int i2 = f.a.a.b.b.a.bz(8, this.Hwu);
      int i3 = f.a.a.a.d(9, 2, this.Hwv);
      int i4 = f.a.a.b.b.a.bz(10, this.Hww);
      int i5 = f.a.a.b.b.a.bz(11, this.Hwx);
      int i6 = f.a.a.a.d(12, 2, this.Hwy);
      int i7 = f.a.a.b.b.a.bz(13, this.Hwz);
      int i8 = f.a.a.b.b.a.bz(14, this.HwA);
      AppMethodBeat.o(115917);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hwv.clear();
        this.Hwy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(115917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dys localdys = (dys)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115917);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdys.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115917);
          return 0;
        case 2: 
          localdys.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 3: 
          localdys.Hwq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 4: 
          localdys.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 5: 
          localdys.Hwr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 6: 
          localdys.Hws = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 7: 
          localdys.Hwt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 8: 
          localdys.Hwu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 9: 
          localdys.Hwv = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
          AppMethodBeat.o(115917);
          return 0;
        case 10: 
          localdys.Hww = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 11: 
          localdys.Hwx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115917);
          return 0;
        case 12: 
          localdys.Hwy = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
          AppMethodBeat.o(115917);
          return 0;
        case 13: 
          localdys.Hwz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115917);
          return 0;
        }
        localdys.HwA = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115917);
        return 0;
      }
      AppMethodBeat.o(115917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dys
 * JD-Core Version:    0.7.0.1
 */